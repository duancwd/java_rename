package rename;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.StringTokenizer;
import java.nio.file.Files;
import java.nio.file.Path;
public class testrename {
	//1 read txt
	public static void readTxtFile(String filePath){
        try {
                String encoding="utf-8";//or GBK
                File file=new File(filePath);
                if(file.isFile() && file.exists()){ //判断文件是否存在
                    InputStreamReader read = new InputStreamReader(
                    new FileInputStream(file),encoding);//考虑到编码格式
                    BufferedReader bufferedReader = new BufferedReader(read);
                    String lineTxt = null;
                    while((lineTxt = bufferedReader.readLine()) != null){
                       // System.out.println(lineTxt);
                        getTokens(lineTxt);
                    }
                    read.close();
        }else{
            System.out.println("cannot get file!");
        }
        } catch (Exception e) {
            System.out.println("something wrong!");
            e.printStackTrace();
        }
     
    }
     
	
	
	//
	
	public static String[] getTokens(String input) throws IOException{

	    int i = 0;
	    StringTokenizer st = new StringTokenizer(input);
	    int numTokens = st.countTokens();
	    String[] tokenList = new String[numTokens];
	    while (st.hasMoreTokens()){
	        tokenList[i] = st.nextToken();
	        i++;
	    }
	    
	    String path ="home/chaoduan/text/backup/"+tokenList[0];
        String oldname = tokenList[1];
        String newname = tokenList[2];
	    if (isExist(path)) {
	    	renameFile(oldname, newname);
	    }
	    else{
	    	new File(path).mkdir();
	    	
	    }
	    System.out.println("token =" + tokenList[1]);
	    return(tokenList);
	  }


	
	 public static boolean isExist(String path) {
		  File file = new File(path);
		  //判断文件夹是否存在,如果不存在则创建文件夹
		  if (file.exists()) {
		   return true;
		  }
		  else return false;
		 }
	
	
	// rename
	 
	 public static void renameFile(String oldname,  String newname) throws IOException{
		 File file = new File("oldname");

		// File (or directory) with new name
		File file2 = new File("newname");

		if (file2.exists())
		   throw new java.io.IOException("file exists");

		// Rename file (or directory)
		boolean success = file.renameTo(file2);

		if (!success) {
		   // File was not successfully renamed
			throw new java.io.IOException("file unsuccess");
		}
	 }
	
	
	public static void main(String argv[]){
        String filePath = "/Users/chaoduan/Desktop/testjava.txt";
//      "res/";
        readTxtFile(filePath);
    }
	
	
	
	

}
