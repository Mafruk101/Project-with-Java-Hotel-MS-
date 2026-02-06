package File;
import Entity.*;
import EntityList.*;
import java.util.*;
import java.io.*;

public class UserFileIO {
	
	public static boolean checkUserFromFile(String userName,String userPass){
		try{
			Scanner sc = new Scanner(new File("./File/UserInfo.txt"));
			while(sc.hasNextLine()){
				String data[] = sc.nextLine().split(",");
				if(data[0].equals(userName) && data[1].equals(userPass)){
					return true;
				}
			}
			sc.close();
		}
		catch(Exception e){
			System.out.println("Cannot Read File");
		}
		
		return false;
	}
	
	

	
}