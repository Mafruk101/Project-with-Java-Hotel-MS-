package File;
import Entity.*;
import EntityList.*;
import java.util.*;
import java.io.*;

public class MemberFileIO{
	public static void loadFromFile(MemberList memberList){
		try{
			
			Scanner sc = new Scanner(new File("./File/MemberInfo.txt"));
			
			while(sc.hasNextLine()){
				String data[] = sc.nextLine().split(",");
				Member m = new Member(data[0],data[1],data[2],Integer.parseInt(data[3]),
									data[4],data[5]);
				memberList.insert(m);
			}
			sc.close();
		}
		catch(Exception e){
			//System.out.println("Cannot Read. Try again later");
			e.getMessage();
		}
	}
	
	public static void writeInFile(Member m){
		try{
			FileWriter writer = new FileWriter(new File("./File/MemberInfo.txt"),true);
			String data = m.getName()+","+ m.getContact()+"," + 
						m.getNID()+","+ m.getAge()+","+ m.getGender()+","+m.getMemberRent()+"\n";
			writer.write(data);
			writer.close();
		}
		catch(Exception c){
			//System.out.println("Cannot Write. Try again later");
			c.getMessage();
		}
	}
}