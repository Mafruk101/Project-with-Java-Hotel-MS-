package EntityList;
import Entity.*;
import Interfaces.*;

public class RoomList implements iRoomList {
    private Room room[];
    
    public RoomList() {
        room = new Room[50];
    }
    
    public RoomList(int size) {
        room = new Room[size];
    }
    
    public void insert(Room r) {
        boolean flag = false;
        for (int i = 0; i < room.length; i++) {
            if (room[i] == null) {
                room[i] = r;
                flag = true;
                break;
            }
        }
        if (flag) {
            System.out.println("Successfully Inserted");
        } else {
            System.out.println("Failed to Insert");
        }
    }
    
    public Room getByNumber(String number) {
        for (int i = 0; i < room.length; i++) {
            if (room[i] != null) {
                if (room[i].getRoomNumber().equals(number)) {
                    return room[i];
                }
            }
        }
        return null;
    }
    
    public void deleteByNumber(String number) {
        boolean flag = false;
        for (int i = 0; i < room.length; i++) {
            if (room[i] != null) {
                if (room[i].getRoomNumber().equals(number)) {
                    room[i] = null;
                    flag = true;
                    break;
                }
            }
        }
        if (flag) {
            System.out.println("Deletion Successful");
        } else {
            System.out.println("Deletion Failed");
        }
    }
    

 	public String getAll() {
		String allRoomInfo = "";
		for (int i = 0; i < room.length; i++) {
			if (room[i] != null) {
				
				allRoomInfo += "_______________________________________________________________________________________________________________________\n";
				allRoomInfo += room[i].getRoomInfoAsString();
			}
		}allRoomInfo += "\n_______________________________________________________________________________________________________________________\n";
		return allRoomInfo;
	}
}