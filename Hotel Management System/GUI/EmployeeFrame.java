package GUI;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.event.*;
import Entity.*;
import EntityList.*;
import File.*;

public class EmployeeFrame extends JFrame implements ActionListener{
	Font titleFont = new Font("Impact",Font.BOLD,30);
	Font font = new Font("ChunkFive",Font.BOLD,16);
	
	JTextField NameTextField,ContactTextField,NIDTextField,AgeTextField,GenderTextField,CatagoryTextField,SalaryTextField;
	JTextField searchTextField,deleteTextField;
	JButton addButton,updateButton,searchButton,deleteButton, BackButton, bonusButton;
	JTextArea textArea;
	
	EmployeeList EmpList ;
	
	public EmployeeFrame(EmployeeList EmpList){
		super("Employee Manager");
		super.setDefaultCloseOperation(EXIT_ON_CLOSE);
		super.setSize(1000,700); 
		super.setLocation(170,0);
		super.getContentPane().setBackground(new Color(218,232,252));
		super.setLayout(null);
		
		this.EmpList= EmpList;
		
		JLabel title = new JLabel("MANAGE EMPLOYEE");
		title.setForeground(Color.WHITE);
		title.setBounds(340,20,330,50); 
		title.setFont(titleFont);
		
		//left part 
		addButton = new JButton("ADD");
		addButton.setBounds(33,450,110,40); 
		addButton.setBackground(Color.BLUE);
		addButton.setForeground(Color.WHITE);
		addButton.setFont(font);
		addButton.addActionListener(this);
		
		bonusButton = new JButton("BONUS");
		bonusButton.setBounds(33,550,110,40); 
		bonusButton.setBackground(Color.MAGENTA);
		bonusButton.setForeground(Color.WHITE);
		bonusButton.setFont(font);
		bonusButton.addActionListener(this);
				
		updateButton = new JButton("UPDATE");
		updateButton.setBounds(160,450,120,40); 
		updateButton.setBackground(Color.BLUE);
		updateButton.setForeground(Color.WHITE);
		updateButton.setFont(font);
		updateButton.addActionListener(this);
		
		deleteButton = new JButton("DELETE");
		deleteButton.setBounds(345,90,120,40); 
		deleteButton.setBackground(Color.RED);
		deleteButton.setForeground(Color.WHITE);
		deleteButton.setFont(font);
		deleteButton.addActionListener(this);
		
		deleteTextField = new JTextField();
		deleteTextField.setBounds(470,90,120,40);
		deleteTextField.setOpaque(false);
		deleteTextField.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
		deleteTextField.setFont(font);
		
		JLabel NameLabel = new JLabel("Name:");
		NameLabel.setForeground(Color.WHITE);
		NameLabel.setBounds(33,90,119,20); 
		NameLabel.setFont(font);
		
		NameTextField = new JTextField();
		NameTextField.setBounds(33,120,120,40);
		NameTextField.setOpaque(false);
		NameTextField.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));		
		NameTextField.setFont(font);

		JLabel ContactLabel = new JLabel("Contact:");
		ContactLabel.setBounds(33,180,119,20);
		ContactLabel.setForeground(Color.WHITE);
		ContactLabel.setFont(font);
		
		ContactTextField = new JTextField();
		ContactTextField.setBounds(33,210,120,40);
		ContactTextField.setOpaque(false);
		ContactTextField.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
		ContactTextField.setFont(font);
		//------------------------------------
		JLabel NIDLabel = new JLabel("NID:");
		NIDLabel.setBounds(33,270,119,20);
		NIDLabel.setForeground(Color.WHITE);
		NIDLabel.setFont(font);
		
		NIDTextField = new JTextField();
		NIDTextField.setBounds(33,300,120,40);
		NIDTextField.setOpaque(false);
		NIDTextField.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));		
		NIDTextField.setFont(font);
		//--------------------------------------
		JLabel AgeLabel = new JLabel("Age:");
		AgeLabel.setBounds(171,90,119,20);
		AgeLabel.setForeground(Color.WHITE);
		AgeLabel.setFont(font);
		
		AgeTextField = new JTextField();
		AgeTextField.setBounds(171,120,120,40);
		AgeTextField.setOpaque(false);
		AgeTextField.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
		AgeTextField.setFont(font);
 
		//--------------------------------------
		
		JLabel GenderLabel = new JLabel("Gender:");
		GenderLabel.setBounds(171,180,119,20); 
		GenderLabel.setForeground(Color.WHITE);
		GenderLabel.setFont(font);
		
		GenderTextField = new JTextField();
		GenderTextField.setBounds(171,210,120,40);
		GenderTextField.setOpaque(false);
		GenderTextField.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
		GenderTextField.setFont(font);
		//---------------------------------------
		JLabel CatagoryLabel = new JLabel("Catagory:");
		CatagoryLabel.setBounds(171,270,119,20); 
		CatagoryLabel.setForeground(Color.WHITE);
		CatagoryLabel.setFont(font);
		
		CatagoryTextField = new JTextField();
		CatagoryTextField.setBounds(171,300,120,40);
		CatagoryTextField.setOpaque(false);
		CatagoryTextField.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));		
		CatagoryTextField.setFont(font);
		//------------------------------------
 
		JLabel SalaryLabel = new JLabel("Salary:");
		SalaryLabel.setBounds(100,360,119,20);
		SalaryLabel.setForeground(Color.WHITE);
		SalaryLabel.setFont(font);
		
		SalaryTextField = new JTextField();
		SalaryTextField.setBounds(100,390,120,40);
		SalaryTextField.setOpaque(false);
		SalaryTextField.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
		SalaryTextField.setFont(font);
			
		//right part

		searchButton = new JButton("SEARCH");
		searchButton.setBounds(640,90,120,40); 
		searchButton.setBackground(Color.BLUE);
		searchButton.setForeground(Color.WHITE);
		searchButton.setFont(font);
		searchButton.addActionListener(this);

		searchTextField = new JTextField();
		searchTextField.setBounds(770,90,120,40);
		searchTextField.setOpaque(false);
		searchTextField.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
		searchTextField.setFont(font);
		
		textArea = new JTextArea();
		textArea.setFont(font);
		textArea.setBorder(BorderFactory.createLineBorder(Color.WHITE, 3));
		textArea.setOpaque(false);
		textArea.setEditable(false);
		textArea.setForeground(Color.WHITE);
		textArea.setText(EmpList.getAll());
		JScrollPane jsp = new JScrollPane(textArea);
		jsp.setOpaque(false);
		jsp.getViewport().setOpaque(false);
		jsp.setBorder(BorderFactory.createEmptyBorder());
		jsp.setBounds(390,200,500,350);
		super.add(jsp);
		//--------------------------------------------
		ImageIcon image = new ImageIcon("./GUI/Resources/Employee.png");
		JLabel background = new JLabel();
		background.setBounds(0,0,1000,700);
		background.setIcon(image);
		
		BackButton = new JButton();
		image = new ImageIcon("./GUI/Resources/back21.jpg");
		BackButton.setBounds(50,30,55,55);
		BackButton.setIcon(image);
		BackButton.addActionListener(this);
		
		super.add(title);
		super.add(addButton);
		super.add(bonusButton);
		super.add(updateButton);
		super.add(deleteButton);
		super.add(deleteTextField);
		super.add(searchButton);
		super.add(searchTextField);
		super.add(NameLabel);
		super.add(NameTextField);
		super.add(ContactLabel);
		super.add(ContactTextField);
		super.add(NIDLabel);
		super.add(NIDTextField);
		super.add(GenderLabel);
		super.add(GenderTextField);
		super.add(CatagoryLabel);
		super.add(CatagoryTextField);
		super.add(AgeLabel);
		super.add(AgeTextField);
		super.add(SalaryLabel);
		super.add(SalaryTextField);
		//Image 
		super.add(BackButton);
		super.add(background);
	    super.setVisible(true);	
	}
	
	public void actionPerformed(ActionEvent e){
	   
     try {
			
		if(e.getActionCommand().equals("ADD")){
			System.out.println("ADD CLICKED");
			
			if( !NameTextField.getText().isEmpty()&&!ContactTextField.getText().isEmpty()&&
			!NIDTextField.getText().isEmpty()&&!AgeTextField.getText().isEmpty()&&
			!GenderTextField.getText().isEmpty()&&!CatagoryTextField.getText().isEmpty()&&!SalaryTextField.getText().isEmpty())
			{ 
				if( EmpList.getByNID(NIDTextField.getText()) == null){
					
					Employee E = new Employee(
							      NameTextField.getText(),ContactTextField.getText(),
				                  NIDTextField.getText(),Integer.parseInt(AgeTextField.getText()),GenderTextField.getText(),
								  CatagoryTextField.getText(),Integer.parseInt(SalaryTextField.getText()));
					
					EmpList.insert(E);
					EmployeeFileIO.writeInFile(E);
					textArea.setText(EmpList.getAll());
					
				}
			}
		    else
		    {
			    JOptionPane.showMessageDialog(this,"please provide all information","Missing Information",JOptionPane.ERROR_MESSAGE);
		    }
		}
		else if(updateButton == e.getSource()){
			System.out.println("UPDATE CLICKED");
			if(!NIDTextField.getText().isEmpty())
			{
				Employee E =EmpList.getByNID(NIDTextField.getText());
				if(E!=null)
				{
					if(!NameTextField.getText().isEmpty()){
						E.setName(NameTextField.getText());
					}
					if(!ContactTextField.getText().isEmpty()){
						E.setContact(ContactTextField.getText());
					}
					if(!NIDTextField.getText().isEmpty()){
						E.setNID(NIDTextField.getText());
					}
					if(!AgeTextField.getText().isEmpty()){
						E.setAge(Integer.parseInt(AgeTextField.getText()));
					}
					if(!GenderTextField.getText().isEmpty()){
						E.setGender(GenderTextField.getText());
					}
					if(!CatagoryTextField.getText().isEmpty()){
						E.setEmployeeCatagory(CatagoryTextField.getText());
					}
					if(!SalaryTextField.getText().isEmpty()){
						E.setEmployeeSalary(Integer.parseInt(SalaryTextField.getText()));
					}
					textArea.setText(EmpList.getAll());
				}
			}
			else
			{
				JOptionPane.showMessageDialog(this,"please provide NID ","Missing Information",JOptionPane.ERROR_MESSAGE);
			}
		}
		else if(searchButton == e.getSource()){
			Employee E = EmpList.getByNID(searchTextField.getText());
			if(E!=null){
				textArea.setText( E.getEmployeeInfoAsString() );
			}
			else{
				JOptionPane.showMessageDialog(this,"NO NID FOUND.","Alert",JOptionPane.WARNING_MESSAGE);
			}
		}
		else if(deleteButton == e.getSource()){
			System.out.println("DELETE CLICKED");
			EmpList.deleteByNID(deleteTextField.getText());
			textArea.setText(EmpList.getAll());
			JOptionPane.showMessageDialog(this,"Deleted Successfully :D","Alert",JOptionPane.WARNING_MESSAGE);
		}
		
		else if(BackButton == e.getSource()) { 
		
		 ManagementFrame frame = new ManagementFrame();
	     this.setVisible(false);
		
		}
		
		else if(bonusButton == e.getSource()) { 
		
		 System.out.println("BONUS BUTTON CLICKED");
    
		BonusFrame bonusFrame = new BonusFrame(EmpList, this);
   
		bonusFrame.setVisible(true); 
		} 
		}
		catch (Exception ex) {
			System.out.println(ex.getMessage()); 
			}
	}
	
	
	public void updateEmployeeListTextArea() {
    textArea.setText(EmpList.getAll()); }
 
}