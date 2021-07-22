/**
 * @author Quyet Quang Quy ID: 12118217
 * @version 1.0 
 * @see java.util.*
 * this class is to be link between TCP UPD and user interface.
 * It is good for changing user interface with minimal of recoding
 * This interface will be implemented in Jframe
 */
package PPFileSharing;

import java.util.*;


public interface IView {
  public String getGroupIP();
  public String getGroupPort();
  public String getPeerID();
  public String getRecievingPort();
  public void showErrorDialog(String msg);
  public String getFileName();
  public void setLogUDP(String msg);
  public void setLogTCP(String msg);
  public void setListFiles(Set<String> list);
  public void setPathSharedFolder(String path);
  public void setUploadePorcess(int current,int max);
  public void setDownloadProcess(int current,int max);
  public void setEnable(boolean state);
}
