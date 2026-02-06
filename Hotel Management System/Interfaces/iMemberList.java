package Interfaces;
import Entity.*;
public interface iMemberList{
	public void insert(Member m);
	public Member getByNID(String nid);
	public void deleteByNID(String nid);
	
}