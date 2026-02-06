package Interfaces;
import Entity.*;
public interface iEmployeeList{
	public void insert(Employee e);
	public Employee getByNID(String nid);
	public void deleteByNID(String nid);
	//public Employee searchByName(String name);
}