package Entity;

public class Employee extends Person {
    private String EmployeeCatagory;
    private int EmployeeSalary; 

    public Employee(String Name, String Contact, String NID, int Age, String Gender, String EmployeeCatagory, int EmployeeSalary) {
        super(Name, Contact, NID, Age, Gender);
        this.EmployeeCatagory = EmployeeCatagory;
        this.EmployeeSalary = EmployeeSalary;
    }

    public void setEmployeeCatagory(String EmployeeCatagory) {
        this.EmployeeCatagory = EmployeeCatagory;
    }

    public void setEmployeeSalary(int EmployeeSalary) { 
        this.EmployeeSalary = EmployeeSalary;
    }

    public int getEmployeeSalary() { 
        return EmployeeSalary;
    }
	
	public String getEmployeeCatagory() {
    return EmployeeCatagory; }

    public void addBonus(int bonusAmount) {
        int currentSalary = EmployeeSalary; 
        EmployeeSalary = currentSalary + bonusAmount;
       
    }

    @Override
    public void showInfo() {
        super.showInfo();
        System.out.println("Employee Catagory: " + EmployeeCatagory);
        System.out.println("Employee Salary: " + EmployeeSalary);
    }

    public String getEmployeeInfoAsString() {

        return "Name: " + getName() + "\n" +
                "Contact: " + getContact() + "\n" +
                "NID: " + getNID() + "\n" +
                "Age :" + getAge() + "\n" +
                "Gender :" + getGender() + "\n" +
                "Employee Catagory: " + EmployeeCatagory + "\n" +
                "Employee Salary: " + EmployeeSalary + " \n ";
    }
}