import GUI.*;
import javax.swing.*;
import Entity.*;
import EntityList.*;
import File.*;
 
public class MemberFrameTest {
    public static void main(String[] args) {
       
        MemberList memberList = new MemberList();
		MemberFileIO.loadFromFile(memberList);
        
        MemberFrame memberFrame = new MemberFrame(memberList);
    }
}