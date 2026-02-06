package Entity;
public class Room{
		
	private String RoomNumber;
	private String RoomType;
	private String RoomStatus;


    public Room(String RoomNumber,String RoomType,String RoomStatus)
	{
		this.RoomNumber=RoomNumber;
		this.RoomType=RoomType;
		this.RoomStatus=RoomStatus;
	}
	public void setRoomNumber (String RoomNumber)
	{
		this.RoomNumber=RoomNumber;
	}
	public void setRoomType(String RoomType)
	{
		this.RoomType=RoomType;
	}
	public void setRoomStatus(String RoomStatus)
	{
		this.RoomStatus=RoomStatus;
	}

	public String getRoomNumber() {return RoomNumber;}
	public String getRoomType() {return RoomType;}
	public String getRoomStatus() {return RoomStatus;} 
	
	public void showRoomInfo()
	{
		System.out.println("Room Number : " +RoomNumber);
		System.out.println("RoomType: "+RoomType);
		System.out.println("RoomStatus: "+RoomStatus);

		
	}
	public String getRoomInfoAsString(){
		
		
		return  "Room Number : " +RoomNumber+"\n"+
				"RoomType: "+RoomType+"\n"+
				"RoomStatus: "+RoomStatus+"\n";
	}
	
	
}