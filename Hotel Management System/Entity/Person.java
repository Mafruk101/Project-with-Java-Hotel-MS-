package Entity;
public abstract class Person{
		
	private String Name;
	private String Contact;
	private String NID;
	private int Age;
	private String Gender;

    public Person(String Name,String Contact,String NID, int Age, String Gender)
	{
		this.Name=Name;
		this.Contact=Contact;
		this.NID=NID;
		this.Age=Age;
		this.Gender=Gender;
		
	}
	public void setName (String Name)
	{
		this.Name=Name;
	}
	public void setContact(String Contact)
	{
		this.Contact=Contact;
	}
	public void setNID(String NID)
	{
		this.NID=NID;
	}
	public void setAge(int Age)
	{
		this.Age=Age;
	}
	public void setGender(String Gender)
	{
		this.Gender=Gender;
	}

	
	public String getName() {return Name;}
	public String getContact() {return Contact;}
	public String getNID() {return NID;} 
	public int getAge (){return Age;}
	public String getGender() {return Gender;}
	
	public void showInfo()
	{
		System.out.println("Name: " +Name);
		System.out.println("Contact: "+Contact);
		System.out.println("NID: "+NID);
		System.out.println("Age :"+Age);
		System.out.println("Gender :"+Gender);
		
	}
	
	
}