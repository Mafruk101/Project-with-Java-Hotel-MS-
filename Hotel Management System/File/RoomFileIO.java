package File;
import Entity.*;
import EntityList.*;
import java.util.*;
import java.io.*;

public class RoomFileIO{
	public static void loadFromFile(RoomList roomList){
		try{
			
			Scanner sc = new Scanner(new File("./File/RoomInfo.txt"));
			
			while(sc.hasNextLine()){
				String data[] = sc.nextLine().split(",");
				Room r = new Room(data[0],data[1],data[2]);
				roomList.insert(r);
			}
			sc.close();
		}
		catch(Exception e){
			//System.out.println("Cannot Read. Try again later");
			e.getMessage();
		}
	}
	
	public static void writeInFile(Room r){
		try{
			FileWriter writer = new FileWriter(new File("./File/RoomInfo.txt"),true);
			String data = r.getRoomNumber()+","+ r.getRoomType()+","+r.getRoomStatus()+"\n";
			writer.write(data);
			writer.close();
		}
		catch(Exception c){
			//System.out.println("Cannot Write. Try again later");
			c.getMessage();
		}
	}
}