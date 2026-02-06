package GUI;
import EntityList.*;
import File.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ManagementFrame extends JFrame implements ActionListener {
	 Font font = new Font("Cambria",Font.BOLD,15);
	 JButton EmployeeManageButton, MemberManageButton, RoomManageButton, BackButton;
	 
	 
	 public ManagementFrame () {
		 super("Management System");
		 super.setDefaultCloseOperation(EXIT_ON_CLOSE);
		 super.setSize(870,610);
		 super.setLocation(240,50);
		 super.getContentPane().setBackground(new Color(150,103,208));
		 super.setLayout(null);
		 
		 ImageIcon image = new ImageIcon("./GUI/Resources/management.jpg");
		 JLabel background = new JLabel();
		 background.setBounds(0,0,870,610);
		 background.setIcon(image);
		 
	    
		 
		 EmployeeManageButton=new JButton("Employee Section");
		 EmployeeManageButton.setBounds(230,210,180,50);
		 EmployeeManageButton.setBackground(new Color(134,2,222));
		 EmployeeManageButton.setForeground(Color.WHITE);
		 EmployeeManageButton.setFont(font);
		 EmployeeManageButton.addActionListener(this);
		
		 MemberManageButton = new JButton("Member Section");
		 MemberManageButton.setBounds(470,210,170,50);
		 MemberManageButton.setBackground(new Color(134,2,222));
		 MemberManageButton.setForeground(Color.WHITE);
		 MemberManageButton.setFont(font);
		 MemberManageButton.addActionListener(this);
		 
		 RoomManageButton = new JButton("Room Section");
		 RoomManageButton.setBounds(362,310,155,50);
		 RoomManageButton.setBackground(new Color(134,2,222));
		 RoomManageButton.setForeground(Color.WHITE);
		 RoomManageButton.setFont(font);
		 RoomManageButton.addActionListener(this);
		 
		 BackButton = new JButton();
		 image = new ImageIcon("./GUI/Resources/back21.jpg");
		 BackButton.setBounds(50,40,55,55);
		 BackButton.setIcon(image);
		 BackButton.addActionListener(this);
		 
		 
		 		 
		 super.add(EmployeeManageButton);
         super.add(MemberManageButton);
 		 super.add(RoomManageButton);
		 super.add(BackButton);
		 super.add(background);
		 super.setVisible(true);
		 
		 
	 }
	 public void actionPerformed (ActionEvent e){
		try {
		System.out.println("Button Clicked");
		
		 
		if(EmployeeManageButton == e.getSource()){
			 
			 EmployeeList employeeList = new EmployeeList();
			 EmployeeFileIO.loadFromFile(employeeList);
			 EmployeeFrame employeeframe = new EmployeeFrame(employeeList);
			 this.setVisible(false);	
	    }
		 
		else if (MemberManageButton == e.getSource()) { 
		
             MemberList memberList = new MemberList();
		     MemberFileIO.loadFromFile(memberList);
             MemberFrame memberFrame = new MemberFrame(memberList);
		     this.setVisible(false);
		}
		
		else if (RoomManageButton == e.getSource()) { 
		
             RoomList roomList = new RoomList();
		     RoomFileIO.loadFromFile(roomList);
             RoomFrame roomFrame = new RoomFrame(roomList);
		     this.setVisible(false);
		}
		
		else if(BackButton == e.getSource()) { 
		
		     LoginPage loginPage = new LoginPage();
			 //loginPage.setVisible(true);
	         this.setVisible(false);
		
		} }
		
	catch(Exception ex) {System.out.println(ex.getMessage()); }
		
	 }
		 

}

