package File;
import Entity.*;
import EntityList.*;
import java.util.*;
import java.io.*;

public class EmployeeFileIO{
	public static void loadFromFile(EmployeeList employeeList){
		try{
			
			Scanner sc = new Scanner(new File("./File/EmployeeInfo.txt"));
			
			while(sc.hasNextLine()){
				String data[] = sc.nextLine().split(",");
				Employee e = new Employee(  data[0],data[1],data[2],Integer.parseInt(data[3]),
									data[4],data[5],Integer.parseInt(data[6]));
				employeeList.insert(e);
			}
			sc.close();
		}
		catch(Exception e){
			//System.out.println("Cannot Read. Try again later");
			e.getMessage();
		}
	}
	
	public static void writeInFile(Employee e){
		try{
			FileWriter writer = new FileWriter(new File("./File/EmployeeInfo.txt"),true);
			String data = e.getName()+","+ e.getContact()+"," + 
						e.getNID()+","+ e.getAge()+","+ e.getGender()+","+e.getEmployeeCatagory()+","+e.getEmployeeSalary()+"\n";
			writer.write(data);
			writer.close();
		}
		catch(Exception c){
			//System.out.println("Cannot Write. Try again later");
			c.getMessage();
		}
	}
}