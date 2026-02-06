package GUI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.LineBorder;
import java.awt.Color;
import Entity.*;
import EntityList.*;
import File.*;

public class MemberFrame extends JFrame implements ActionListener {
	Font titleFont = new Font("Impact",Font.BOLD,35);
	Font font15 = new Font("ChunkFive",Font.BOLD,16);
	
	JTextField NameTextField,ContactTextField,NIDTextField,AgeTextField,GenderTextField,MemberRentTextField;
	JTextField searchTextField,deleteTextField;
	JButton addButton,updateButton,searchButton,deleteButton,BackButton, blacklistButton;
	JTextArea textArea;
	MemberList memList ;
	String[] blacklistedNIDs;
	
	public MemberFrame(MemberList memList){
		super("MANAGE MEMBERS");
		super.setDefaultCloseOperation(EXIT_ON_CLOSE);
		super.setSize(1000,700); 
		super.setLocation(170,0);
		super.getContentPane().setBackground(new Color(216, 191, 216));
		super.setLayout(null);
		this.memList= memList;
		JLabel title = new JLabel("MANAGE MEMBERS");
		title.setBounds(330,20,330,50);
		title.setForeground(new Color(0, 102, 204));
		title.setFont(titleFont);
		//left part 
		addButton = new JButton("ADD");
		addButton.setBounds(33,450,110,40); 
		addButton.setBackground(new Color(160, 32, 240));
		addButton.setFont(font15);
		addButton.addActionListener(this);
		
		updateButton = new JButton("UPDATE");
		updateButton.setBounds(160,450,100,40); 
		updateButton.setBackground(new Color(160, 32, 240));
		updateButton.setFont(font15);
		updateButton.addActionListener(this);
		
		blacklistButton = new JButton("BLACKLIST");
		blacklistButton.setBounds(100,550,130,40); 
		blacklistButton.setBackground(Color.RED);
		blacklistButton.setFont(font15);
		blacklistButton.addActionListener(this);
		
		blacklistedNIDs = new String[100];
		
		deleteButton = new JButton("DELETE");
		deleteButton.setBounds(345,90,100,40); 
		deleteButton.setBackground(Color.RED);
		deleteButton.setFont(font15);
		deleteButton.addActionListener(this);
		
		deleteTextField = new JTextField();
		deleteTextField.setBounds(460,90,120,40);
		deleteTextField.setOpaque(false);
		deleteTextField.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
		deleteTextField.setForeground(Color.WHITE);
		deleteTextField.setFont(font15);
		
		JLabel NameLabel = new JLabel("NAME");
		NameLabel.setBounds(33+40,90+50,119,20); 
		NameLabel.setFont(font15);
		NameLabel.setForeground(new Color(160, 32, 240));
		NameTextField = new JTextField();
		NameTextField.setBounds(33,120+50,120,40);
		NameTextField.setOpaque(false);
		NameTextField.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
		NameTextField.setForeground(Color.WHITE);
		NameTextField.setFont(font15);
		
		JLabel ContactLabel = new JLabel("CONTACT");
		ContactLabel.setBounds(33+20,180+50,119,20);
		ContactLabel.setFont(font15);
		ContactLabel.setForeground(new Color(160, 32, 240));
		ContactTextField = new JTextField();
		ContactTextField.setBounds(33,210+50,120,40);
		ContactTextField.setOpaque(false);
		ContactTextField.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
		ContactTextField.setForeground(Color.WHITE);
		ContactTextField.setFont(font15);
		//------------------------------------
		JLabel NIDLabel = new JLabel("NID");
		NIDLabel.setBounds(33+40,270+50,119,20);
		NIDLabel.setFont(font15);
		NIDLabel.setForeground(new Color(160, 32, 240));
		NIDTextField = new JTextField();
		NIDTextField.setBounds(33,300+50,120,40); 
		NIDTextField.setOpaque(false);
		NIDTextField.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
		NIDTextField.setForeground(Color.WHITE);
		NIDTextField.setFont(font15);
		//--------------------------------------
		JLabel AgeLabel = new JLabel("AGE");
		AgeLabel.setBounds(171+40,90+50,119,20);
		AgeLabel.setFont(font15);
		AgeLabel.setForeground(new Color(160, 32, 240));
		AgeTextField = new JTextField();
		AgeTextField.setBounds(171,120+50,120,40);
		AgeTextField.setOpaque(false);
		AgeTextField.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
		AgeTextField.setForeground(Color.WHITE);
		AgeTextField.setFont(font15);
		//--------------------------------------
		JLabel GenderLabel = new JLabel("GENDER");
		GenderLabel.setBounds(171+40,180+50,119,20); 
		GenderLabel.setFont(font15);
		GenderLabel.setForeground(new Color(160, 32, 240));
		GenderTextField = new JTextField();
		GenderTextField.setBounds(171,210+50,120,40);
		GenderTextField.setOpaque(false);
		GenderTextField.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
		GenderTextField.setForeground(Color.WHITE);
		GenderTextField.setFont(font15);
		//---------------------------------------
		JLabel MemberRentLabel = new JLabel("MEMBER RENT");
		MemberRentLabel.setBounds(171,270+50,125,20); 
		MemberRentLabel.setFont(font15);
		MemberRentLabel.setForeground(new Color(160, 32, 240));
		MemberRentTextField = new JTextField();
		MemberRentTextField.setBounds(171,300+50,120,40);
		MemberRentTextField.setOpaque(false);
		MemberRentTextField.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
		MemberRentTextField.setForeground(Color.WHITE);
		MemberRentTextField.setFont(font15);


		//right part
		searchButton = new JButton("SEARCH");
		searchButton.setBounds(640,90,120,40); 
		searchButton.setBackground(new Color(160, 32, 240));
		searchButton.setFont(font15);
		
		searchButton.addActionListener(this);
		searchTextField = new JTextField();
		searchTextField.setBounds(770,90,120,40);
		searchTextField.setOpaque(false);
		searchTextField.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
		searchTextField.setForeground(Color.WHITE);
		searchTextField.setFont(font15);

		textArea = new JTextArea();
		textArea.setFont(font15);
		textArea.setBorder(BorderFactory.createLineBorder(new Color(160, 32, 240), 3));		
		textArea.setEditable(false);
		textArea.setText(memList.getAll());
		JScrollPane jsp = new JScrollPane(textArea);
		jsp.setBounds(390,200,500,350);
		textArea.setOpaque(false);
		textArea.setForeground(new Color(160, 32, 240));
		jsp.setOpaque(false);
		jsp.getViewport().setOpaque(false);
		jsp.setBorder(BorderFactory.createEmptyBorder());
		super.add(jsp);
		//--------------------------------------------
		ImageIcon image = new ImageIcon("./GUI/Resources/Member.png");
			JLabel background = new JLabel();
			background.setBounds(0,0,1000,700);
			background.setIcon(image);
		
		BackButton = new JButton();
		image = new ImageIcon("./GUI/Resources/back21.jpg");
		 BackButton.setBounds(50,40,55,50);
		 BackButton.setIcon(image);
		 BackButton.addActionListener(this);
		 
		super.add(title);
		super.add(addButton);
		super.add(updateButton);
		super.add(blacklistButton);
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
		super.add(MemberRentLabel);
		super.add(MemberRentTextField);
		super.add(AgeLabel);
		super.add(AgeTextField);
		super.add(BackButton);
 
		//Image 
		super.add(background);
	    super.setVisible(true);
	}

	public void actionPerformed(ActionEvent e){
		try {
		
		 if (e.getActionCommand().equals("ADD")) {
        System.out.println("ADD CLICKED");
        if (!NameTextField.getText().isEmpty() && !ContactTextField.getText().isEmpty() &&
                !NIDTextField.getText().isEmpty() && !AgeTextField.getText().isEmpty() &&
                !GenderTextField.getText().isEmpty() && !MemberRentTextField.getText().isEmpty()) {
            if (memList.getByNID(NIDTextField.getText()) == null) {
 
                
                if (isBlacklisted(NIDTextField.getText())) {
                    JOptionPane.showMessageDialog(this, "NID is blacklisted. Cannot add member.", "Blacklisted NID", JOptionPane.ERROR_MESSAGE);
                } else {
                    Member m = new Member(
                            NameTextField.getText(), ContactTextField.getText(),
                            NIDTextField.getText(), Integer.parseInt(AgeTextField.getText()), GenderTextField.getText(),
                            MemberRentTextField.getText());
 
                    memList.insert(m);
                    MemberFileIO.writeInFile(m);
                    textArea.setText(memList.getAll());
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please provide all information", "Missing Information", JOptionPane.ERROR_MESSAGE); }
			}
		else if(e.getSource().equals(updateButton)){
			System.out.println("UPDATE CLICKED");
			if(!NIDTextField.getText().isEmpty())
			{
				Member m =memList.getByNID(NIDTextField.getText());
				if(m!=null)
				{
					if(!NameTextField.getText().isEmpty()){
						m.setName(NameTextField.getText());
					}
					if(!ContactTextField.getText().isEmpty()){
						m.setContact(ContactTextField.getText());
					}
					if(!NIDTextField.getText().isEmpty()){
						m.setNID(NIDTextField.getText());
					}
					if(!AgeTextField.getText().isEmpty()){
						m.setAge(Integer.parseInt(AgeTextField.getText()));
					}
					if(!GenderTextField.getText().isEmpty()){
						m.setGender(GenderTextField.getText());
					}
					if(!MemberRentTextField.getText().isEmpty()){
						m.setMemberRent(MemberRentTextField.getText());
				textArea.setText(memList.getAll()); } }
			else
			{
				JOptionPane.showMessageDialog(this,"please provide NID ","Missing Information",JOptionPane.ERROR_MESSAGE);
		} } }
		else if(searchButton == e.getSource()){
			Member a = memList.getByNID(searchTextField.getText());
			if(a!=null){
				textArea.setText( a.getMemberInfoAsString() );
			}
			else{
				JOptionPane.showMessageDialog(this,"NO NID FOUND.","Alert",JOptionPane.WARNING_MESSAGE);
			}
		}
		else if(deleteButton == e.getSource()){
			System.out.println("DELETE CLICKED");
			memList.deleteByNID(deleteTextField.getText());
			textArea.setText(memList.getAll());
		JOptionPane.showMessageDialog(this,"Deleted Successfully","Alert",JOptionPane.WARNING_MESSAGE); 
		}
		
		else if(BackButton == e.getSource()) { 
		 ManagementFrame frame = new ManagementFrame();
		this.setVisible(false);
		}
		
		else if (blacklistButton == e.getSource()) {
        String blacklistedNID = JOptionPane.showInputDialog(this, "Enter NID to blacklist:");
 
        if (!blacklistedNID.isEmpty()) {
            addBlacklistedNID(blacklistedNID);
        } }
	 }
	 catch (Exception a){
			System.out.println("Wrong input");
		}
	}
	
	
	private void addBlacklistedNID(String nid) {
	try {
    for (int i = 0; i < blacklistedNIDs.length; i++) {
        if (blacklistedNIDs[i] == null) {
            blacklistedNIDs[i] = nid;
            break;
        }
      } 
	}
	catch(ArrayIndexOutOfBoundsException e) {System.out.println(e.getMessage()); }
	catch(Exception e) {System.out.println(e.getMessage()); }
	}
	

	private boolean isBlacklisted(String nid) {
	try {
    for (int i = 0; i < blacklistedNIDs.length; i++) {
        if (nid.equals(blacklistedNIDs[i])) {
            return true;
        }
    }
    return false; }
	catch(ArrayIndexOutOfBoundsException e) {System.out.println(e.getMessage());
	return false;}
	catch(Exception e) {System.out.println(e.getMessage());
	return false;}
   }
	
	
 
}
 