package Interfaces;
import Entity.*;
public interface iRoomList{
	public void insert(Room r);
	public Room getByNumber(String number);
	public void deleteByNumber(String number);
	
}