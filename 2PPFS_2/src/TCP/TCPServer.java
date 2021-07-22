/**
 * @author Quyet Quang Quy ID: 12118217 
 * @version 1.0 
 * 
 * @see PPFileSharing.IView
 * @see UDP.IPMulticast
 * @see java.io.*
 * @see java.net.*
 * 
 * this class is to receive file from the uploading peer
 */
package TCP;

import PPFileSharing.IView;
import UDP.IPMulticast;
import java.io.*;
import java.net.*;


public class TCPServer {
    
    
    private static Integer recivingPort;
    private static ServerSocket serverSocket;
    private static IPMulticast iPMulticast;
    
    private static IView view; 
    
    /**
     * Constructor
     * @param view is the user interface Jframe
     * @param port port of TCP server
     * @param iPMulticast 
     */
    public TCPServer(IView view,Integer port,IPMulticast iPMulticast) {
        TCPServer.view = view;
        serverSocket=null;
        recivingPort =  port;
        this.iPMulticast=iPMulticast;
    }
    
   
    
    /**
     * start TCP server to receive file. the file can be received in many packets
     * @throws IOException 
     */
    public void startTCPServer() throws IOException
    {
       serverSocket = new ServerSocket(recivingPort);
       view.setLogTCP("Server is listening port: " + serverSocket.getLocalPort());
       
       new Thread(() -> {
           while (true) {  
               Socket socketConnection;
               try {
                   socketConnection = serverSocket.accept();
               } catch (IOException ex) {                   
                   return;
               }
               
               new Thread(() -> {
                   try {
                     
                        DataInputStream dataInput = new DataInputStream(socketConnection.getInputStream());
                        String fileName = dataInput.readUTF();
                        FileOutputStream fileOutput = new FileOutputStream("SharedFolder\\Downloaded-"+fileName);
                        
                        iPMulticast.stopTimer();  
                        view.setLogUDP("File was found: "+fileName);
                        int fileSize = dataInput.readInt();
                        byte[] dataFile = new byte[fileSize];
                        int readByte=0;
                        int totalByte = 0;                      
                        
                        
                        BufferedOutputStream bufferedOut;
                        bufferedOut = new BufferedOutputStream(fileOutput);
                        while ((readByte = dataInput.read(dataFile, 0, dataFile.length))>0) {    
                            totalByte+=readByte;
                            bufferedOut.write(dataFile, 0, readByte);
                            view.setDownloadProcess(totalByte, fileSize);
                            
                        }
                        bufferedOut.close();  
                        fileOutput.close();
                        dataInput.close();
                        socketConnection.close();
                        IPMulticast.reloadListFiles();
                        view.setLogTCP(fileName+" is saved as Download-"+fileName);
                   } catch (IOException ex) {
                       //ex.printStackTrace();
                       view.showErrorDialog(ex.getMessage());
                   }
               }).start();
           }
       }).start();
       
    }
    /**
     * the method is to stop the TCP server
     * @throws IOException 
     */
    public void stopTCPServer() throws IOException
    {
        if(serverSocket!=null&&!serverSocket.isClosed())
            {
                serverSocket.close();   
                view.setLogTCP("Server is stopped");
            }
    }
}
