package EntityList;
import Entity.*;
import Interfaces.*;

public class EmployeeList implements iEmployeeList {
	private Employee emp[];
	public EmployeeList() {
		emp = new Employee[50];
	}
	public EmployeeList(int size) {
		emp = new Employee[size];
	}
	public void insert(Employee e) {
		boolean flag = false;
		for (int i = 0; i < emp.length; i++) {
			if (emp[i] == null) {
				emp[i] = e;
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
	public Employee getByNID(String nid) {
		for (int i = 0; i < emp.length; i++) {
			if (emp[i] != null) {
				if (emp[i].getNID().equals(nid)) {
					return emp[i];
				}
			}
		}
		return null;
	}
	public void deleteByNID(String nid) {
		boolean flag = false;
		for (int i = 0; i < emp.length; i++) {
			if (emp[i] != null) {
				if (emp[i].getNID().equals(nid)) {
					emp[i] = null;
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
	public Employee searchByName(String name) {
		for (int i = 0; i < emp.length; i++) {
			if (emp[i] != null) {
				if (emp[i].getName().equals(name)) {
					System.out.println("+++ Found +++");
					return emp[i];
				}
			}
		}return null;
	}
	public String getAll() {
		String allEmployeeInfo = "";
		for (int i = 0; i < emp.length; i++) {
			if (emp[i] != null) {
				allEmployeeInfo += "_______________________________________________________________________________________________________________________\n";
				allEmployeeInfo += emp[i].getEmployeeInfoAsString();
			}
		}allEmployeeInfo += "\n_______________________________________________________________________________________________________________________\n";
		return allEmployeeInfo;
	}
	
	public void addBonusToAll(int bonusAmount) { 
        for (int i = 0; i < emp.length; i++) {
            if (emp[i] != null) {
                emp[i].addBonus(bonusAmount);
            }
        }
        System.out.println("Bonus added to all employees successfully!");
    }
	
	
}