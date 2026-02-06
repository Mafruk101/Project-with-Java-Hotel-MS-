import GUI.*;
import javax.swing.*;
import EntityList.*;
import File.*;
 
public class RoomFrameTest {
    public static void main(String[] args) {
        
        RoomList roomList = new RoomList();
		RoomFileIO.loadFromFile(roomList);
      
        RoomFrame roomFrame = new RoomFrame(roomList);
    }
}