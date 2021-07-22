/**
 * @author Quyet Quang Quy ID: 12118217
 * @version 1.0 
 * @see PPFileSharing.IView
 * @see PPFileSharing.InputCondition
 * @see TCP.TCPClient
 * @see TCP.TCPServer
 * @see java.awt.Desktop
 * @see java.io.File
 * @see java.io.IOException
 * @see java.net.DatagramPacket
 * @see java.net.InetAddress
 * @see java.net.MulticastSocket
 * @see java.net.URISyntaxException
 * @see java.net.UnknownHostException
 * @see java.util.*
 * @see java.util.stream.Collectors
 * this class is a core of system, it handles the UDP protocol by IP multicast technology.
 * it will broadcast the request to the network. 
 * if the other peers find the file, that peer will upload the file to the requester.
 */
package UDP;

import PPFileSharing.IView;
import PPFileSharing.InputCondition;
import TCP.TCPClient;
import TCP.TCPServer;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.URISyntaxException;
import java.net.UnknownHostException;
import java.util.*;
import java.util.stream.Collectors;


public class IPMulticast extends InputCondition{
    
    private final String SEARCHING_MSG = "SM";
    private final String REGEX = ">";
    
    
    private static IView view;
    private static InetAddress group;
    private static MulticastSocket ms;
    private static String groupIP;
    private static Integer groupPort;
    private static String peerID;
    private static Integer recivingPort;
    private static TCP.TCPServer tCPServer;
    private static TCP.TCPClient tCPClient;
    private static Timer t;   
    private static Set<String> listFiles;
    
    
    private Thread listener;
    
    /**
     * Constructor
     * @param view the user interface
     */
    public IPMulticast(IView view) {
        IPMulticast.view = view;
        tCPClient=new TCPClient(view);        
        listFiles = new HashSet<>();
    }
    
    /**
     * stop the timer when the file is downloaded
     */
    public void stopTimer()
    {
        t.cancel();
    }
    /**
     * this method is to check the IP is in the rage of IP multicast or not and correct format
     * @param groupIP
     * @return the valid IP
     */
    private String checkGroupIP(String groupIP)
    {
        if(groupIP.matches("^(22[4-9]|23\\d)\\."+
                                "(25[0-5]|2[0-4]\\d|1\\d\\d|\\d\\d?)\\."+
                                "(25[0-5]|2[0-4]\\d|1\\d\\d|\\d\\d?)\\."+
                                "(25[0-5]|2[0-4]\\d|1\\d\\d|\\d\\d?)$"
                                ))
        {
            return groupIP;
        }
        else
            throw new NumberFormatException("Group IP address is not multicast address ["+groupIP+"]"
                    + "\n Example: any address between 224.0.0.0 to 239.255.255.255");
        
      
    }
    /**
     * make sure peerID is not null
     * @param peerID
     * @return 
     */
    private String checkPeerName(String peerID)
    {
        if(peerID.length()>0)
            return peerID;
        else
            throw  new IllegalArgumentException("Peer ID is emty");
    }
    
    /**
     * create the message format with a special character in the middle
     * @param inMSG list of elements
     * @return 
     */
    private String construcMSG(List<String> inMSG)    {
        
        return inMSG.stream().collect(Collectors.joining(REGEX));
    }
    /**
     * this method is to broadcast the request to the network
     * 
     */
    public void broadcastMSG()
    {
        try {
            String fileName = view.getFileName().trim();
            //a-b
            String msg = construcMSG(Arrays.asList(SEARCHING_MSG,peerID,InetAddress.getLocalHost()
                    .getHostName(),recivingPort.toString(),fileName));

            if (fileName.length()>0) {
                DatagramPacket messageOut = new DatagramPacket(msg.getBytes(), msg.getBytes().length, group, groupPort);
                try {
                    ms.send(messageOut);
                    view.setLogUDP("Waiting for the result in 6 second..."+"\nSent a broadcast to searh file"+ fileName);
                    
                    t = new Timer();
                    TimerTask tsk =
                    new TimerTask() {
                        @Override
                        public void run() {
                            view.setLogUDP(fileName+" were not found");
                        }
                    };
                    t.schedule(tsk, 6000);
                    
                } catch (IOException ex) {
                    //ex.printStackTrace();
                    view.showErrorDialog(ex.getMessage());
                }
            }
            else
                view.showErrorDialog("Please enter file name to search.");
            
        } catch (UnknownHostException e) {
            view.showErrorDialog(e.getMessage());
            //e.printStackTrace();
        }
        
        
    }
    /**
     * Leave the multicast group and stop the TCP server
     * 
     */
    public void leaveGroup()
    {
        if(ms!=null&&!ms.isClosed())
        {
            try {
                view.setEnable(true);
                ms.leaveGroup(group);
                ms.close();
                tCPServer.stopTCPServer();
                view.setLogUDP("Left the group");
            } catch (IOException ex) {
                view.showErrorDialog(ex.getMessage());
                //ex.printStackTrace();
            }
            
        }
    }
    /**
     * join the multicast group and start TCP server
     */
    public void joinGroup()
    {
        
       try {
            if(listener!=null&&listener.isAlive())
               return;
            
            groupIP = checkGroupIP(view.getGroupIP().trim());
            groupPort = InputCondition.checkPortNumber(Integer.parseInt(view.getGroupPort().trim()));
            peerID = checkPeerName(view.getPeerID().trim());
            recivingPort = InputCondition.checkPortNumber(Integer.parseInt(view.getRecievingPort().trim()));
            
            tCPServer = new TCPServer(view, recivingPort,this);
            tCPServer.startTCPServer();
            
            group =  InetAddress.getByName(groupIP);
            ms = new MulticastSocket(groupPort);            
            ms.joinGroup(group);         
            
            
            
            listener = new Thread(() -> {   
                view.setLogUDP("Joined group under ID "+peerID);
                while (true) {                    
                    byte[] inputMSG = new byte[1024];
                    DatagramPacket input = new DatagramPacket(inputMSG,inputMSG.length);
                    try {
                         ms.receive(input);
                         encapsulatesMSG(new String(input.getData()));
                    } catch (IOException ex) {
                        //view.showErrorDialog(ex.getMessage());
                        System.out.println("Exit Group");
                        return;
                    }
                }
            });            
            listener.start();
            view.setEnable(false);
            
        } catch (IOException | NumberFormatException e) {
            
            //e.printStackTrace();
            view.showErrorDialog(e.getMessage());
        }
       
    }
   /**
    * the method is to find the file in shared folder based on given file name
    * @param fileName the name of the file 
    * @return the find to upload
    * @throws URISyntaxException 
    */
    private File findFileInFolder(String fileName) throws URISyntaxException
    {
        reloadListFiles();
        if(listFiles.contains(fileName))
        {            
            return new File("SharedFolder\\"+fileName);
        }
        else
            return null;
    }
    /**
     * reload the list of file in the user interface and set of the file
     * 
     */
    public static void reloadListFiles()
    {
        try {
            File sharedFolder = new File("SharedFolder");
            listFiles.clear();
            listFiles.addAll(Arrays.asList(sharedFolder.list()));
            view.setListFiles(listFiles);
            view.setPathSharedFolder(sharedFolder.getAbsolutePath());
        } catch (Exception e) {
            view.showErrorDialog(e.getMessage());
            //e.printStackTrace();
        }
        
    }
    /**
     * open the selected file from the list on user interface based on given file name
     * @param fileName 
     */
    public void openFile(String fileName)
    {
        try {
            File sharedFolder = new File("SharedFolder\\"+fileName);
            if(!Desktop.isDesktopSupported()){
                view.showErrorDialog("Desktop is not supported");
            }
            else
            {
                Desktop.getDesktop().open(sharedFolder);
            }
        } catch (IOException e) {
            view.showErrorDialog("Can not open the file. "+e.getMessage());
        }
        
        
    }
    /**
     * the method is to process the message from the overlay network (multicast IP network)
     * and it will ignore the message that is sent by itself
     * @param msgIn message from the thread
     */
    private void encapsulatesMSG(String msgIn)
    {       
       
        try {
            String[] fragments = msgIn.split(REGEX);             

            //---------------------------------------------------------------------------------------------------------------------
            if(!peerID.equalsIgnoreCase(fragments[1].trim()))
            {           
                if(SEARCHING_MSG.equalsIgnoreCase(fragments[0].trim()))
                {
                    
                    view.setLogUDP("Searching file " + fragments[fragments.length-1]+"...");
                    File sendingFile =findFileInFolder(fragments[fragments.length-1].trim());

                    if(sendingFile!=null)                            
                    {

                        
                        view.setLogUDP("File: "+fragments[fragments.length-1]+" was found in local sheared folder");
                        
                        new Thread(() -> {
                            tCPClient.sendFile(sendingFile, fragments[2],Integer.parseInt(fragments[3]));
                        }).start();

                    }else                            
                    {
                        
                        view.setLogUDP("File: "+fragments[fragments.length-1]+" was not found");
                    }

                }                
                
                
            }
        } catch (Exception e) {

            view.showErrorDialog(e.getMessage());
            //e.printStackTrace();
        }          
       
    }
   
}
