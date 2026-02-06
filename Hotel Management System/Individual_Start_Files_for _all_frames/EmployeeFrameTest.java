import GUI.*;
import javax.swing.*;
import Entity.*;
import EntityList.*;
import File.*;
 
public class EmployeeFrameTest {
    public static void main(String[] args) {
        
        EmployeeList employeeList = new EmployeeList();
		EmployeeFileIO.loadFromFile(employeeList);
     
        EmployeeFrame employeeFrame = new EmployeeFrame(employeeList);
    }
}