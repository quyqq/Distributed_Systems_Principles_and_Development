/**
 * @author Quyet Quang Quy ID: 12118217
 * @version 1.0 
 * 
 * @see PPFileSharing.IView
 * @see java.io.File
 * @see java.io.*
 * @see java.net.Socket
 * this class is to send the requested file to the TCP server
 */
package TCP;

import PPFileSharing.IView;
import java.io.File;
import java.io.*;
import java.net.Socket;


public class TCPClient {
    private IView view;

    /**
     * constructor
     * @param view the view is the Jframe
     */
    public TCPClient(IView view) {
        this.view = view;
    }
    
    /**
     * this method is to send the requested file to the requester 
     * the file can be any size. therefore, the file have to break in many small packets.
     * the small packets will be sent over the network to the request peer.
     * @param f file to send
     * @param hostName TCP host name
     * @param hostPort TCP host port
     */
    public void sendFile(File f,String hostName,int hostPort)
    {            
        view.setLogTCP("Uploading file: "+f.getName()+" to "+hostName+":"+hostPort+"...");
        try {          
            

            byte[] fileData = new byte[(int)(f).length()]; 
            FileInputStream fileIS = new FileInputStream(f);
            BufferedInputStream buff = new BufferedInputStream(fileIS);
            DataInputStream dataInST = new DataInputStream(buff);


            Socket socketFileConnection = new Socket(hostName, hostPort);
            DataOutputStream dataOut = new DataOutputStream(socketFileConnection.getOutputStream());
            dataOut.writeUTF(f.getName());
            dataOut.writeInt(fileData.length);
            byte[] buffer =  new byte[1000];//size of a packet
            int byteRead=0;
            int totalByteRead=0;
            //sending over the network
            while ((byteRead=dataInST.read(buffer))>0) {                
                dataOut.write(buffer,0,byteRead);
                totalByteRead+=byteRead;
                view.setUploadePorcess(totalByteRead,fileData.length);

            }
            dataOut.flush();

            fileIS.close();
            buff.close();
            dataInST.close();
            dataOut.close();
            socketFileConnection.close();
            view.setLogTCP("File: "+f.getName()+" is uploaded to "+hostName+":"+hostPort);
            
        } catch (Exception ex) {
            //ex.printStackTrace();
           view.showErrorDialog("File can not be uploaded "+ex.getMessage());
        }
            
    }
}
