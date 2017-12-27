package tools;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ExecShell {

	public void copyfile() {
		
		String cmdA= "ls" ;
		Process process;
		try {
			process = Runtime.getRuntime().exec(cmdA);
		
			InputStream in = process.getInputStream();
			InputStream error = process.getErrorStream();
			
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in));
			BufferedReader errorReader = new BufferedReader(new InputStreamReader(error));
			
			StringBuilder builder = new StringBuilder();
			String line = "";
			while ((line=bufferedReader.readLine())!=null) {
				builder.append(line+"\n");
				System.out.println(line);		
			}
			System.out.println(line);
			StringBuilder errorbuilder = new StringBuilder();
			String errorLine = "";
			while ((errorLine=errorReader.readLine())!=null) {
				errorbuilder.append(errorLine+"\n");
			}
			System.out.println(errorLine);
			try {
				process.waitFor();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			in.close();
		
		}
		
		
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
public StringBuilder  execSelectFile(String path) {
		String cmd= "cd   "+path +"/file"+" &&  dir " ;
		Process process;
		String[] cmdA = { "/bin/sh", "-c", cmd };  
		StringBuilder  resultbuilder=null ;
		String result ;
		try {
			process = Runtime.getRuntime().exec(cmdA);
		
			InputStream in = process.getInputStream();
			InputStream error = process.getErrorStream();
			
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in));
			BufferedReader errorReader = new BufferedReader(new InputStreamReader(error));
			
			//结果未输出
			StringBuilder builder = new StringBuilder();
		
			while ((result=bufferedReader.readLine())!=null) {
				builder.append(result+"\n");
			}
			   
			StringBuilder errorbuilder = new StringBuilder();
			while ((result=errorReader.readLine())!=null) {
				errorbuilder.append(result+"\n");
			
			}
			resultbuilder=builder;			
			try {
				process.waitFor();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			in.close();
		
		}
		
		
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return resultbuilder ;
	}
	
	public void readfile() {

		try {
		    File file = new File("/file");
		    if (file.isFile() && file.exists()) { //判断文件是否存在
		        InputStreamReader read = new InputStreamReader(
		                new FileInputStream(file));//考虑到编码格式
		        BufferedReader bufferedReader = new BufferedReader(read);
		        String lineTxt = null;
		        while ((lineTxt = bufferedReader.readLine()) != null) {
		               System.out.println(lineTxt);         
		        }       
		        read.close();
		    } else {
		    	
		        System.out.println("找不到指定的文件");
		    
		    }
		} catch (Exception e) {
		    System.out.println("读取文件内容出错");
		    e.printStackTrace();
		}
		
	}
}


