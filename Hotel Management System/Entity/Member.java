package Entity;
public class Member extends Person {
	private String MemberRent; 

	public Member(String Name,String Contact,String NID, int Age, String Gender,String MemberRent )
	{
		super(Name, Contact, NID, Age, Gender);
		this.MemberRent=MemberRent;		
	}
	public void setMemberRent(String MemberRent){
		this.MemberRent=MemberRent;
	}
	
	public String getMemberRent(){
		return MemberRent;
	}
	
	@Override
	public void showInfo(){
		super.showInfo();
		System.out.println("Member Rent: "+MemberRent);
	}
	public String getMemberInfoAsString(){
		
		
		return  "Name: " +getName()+"\n"+
				"Contact: "+getContact()+"\n"+
				"NID: "+getNID()+"\n"+
				"Age :"+getAge()+"\n"+
				"Gender :"+getGender()+"\n"+
				"Member Rent: "+MemberRent+"\n";
	}
}