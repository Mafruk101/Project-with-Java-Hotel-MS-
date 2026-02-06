package GUI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import Entity.*;
import EntityList.*;
import File.*;

public class RoomFrame extends JFrame implements ActionListener{
	Font titleFont = new Font("Impact",Font.BOLD,30);
	Font font15 = new Font("ChunkFive",Font.BOLD,15);
	//Color color1= new Color.decode("#ff6a00");
	JTextField RoomNumberTextField,RoomTypeTextField,RoomStatusTextField;
	JTextField searchTextField,deleteTextField;
	JButton addButton,updateButton,searchButton,deleteButton,BackButton;
	JTextArea textArea;
	
	RoomList roomList ;
	
	public RoomFrame(RoomList roomList){
		super("Room Manager");
		super.setDefaultCloseOperation(EXIT_ON_CLOSE);
		super.setSize(1000,700); 
		super.setLocation(170,0);
		super.getContentPane().setBackground(new Color(218,232,252));
		super.setLayout(null);
		
		this.roomList= roomList;
		
		JLabel title = new JLabel("MANAGE ROOMS");
		title.setForeground(Color.WHITE);
		title.setBounds(370,30,270,40); 
		title.setFont(titleFont);
		
		//left part 
		addButton = new JButton("ADD");
		addButton.setBounds(40,350,110,40); 
		addButton.setBackground(Color.GREEN);
		
		addButton.setFont(font15);
		addButton.addActionListener(this);
				
		updateButton = new JButton("UPDATE");
		updateButton.setBounds(190,350,110,40); 
		updateButton.setBackground(Color.BLUE);
		updateButton.setForeground(Color.WHITE);
		updateButton.setFont(font15);
		updateButton.addActionListener(this);
		
		deleteButton = new JButton("DELETE");
		deleteButton.setBounds(345,90,100,40); 
		deleteButton.setBackground(Color.RED);
		deleteButton.setForeground(Color.WHITE);
		deleteButton.setFont(font15);
		deleteButton.addActionListener(this);
		
		deleteTextField = new JTextField();
		deleteTextField.setBounds(460,90,120,40);
		deleteTextField.setOpaque(false);
		deleteTextField.setBorder(BorderFactory.createLineBorder(Color.WHITE, 3));
		deleteTextField.setFont(font15);
		
		JLabel RoomNumberLabel = new JLabel("Room NO.");
		RoomNumberLabel.setBounds(35,130,119,20); 
		RoomNumberLabel.setFont(font15);
		RoomNumberLabel.setForeground(Color.WHITE);
		
		RoomNumberTextField = new JTextField();
		RoomNumberTextField.setBounds(35,160,120,40);
		RoomNumberTextField.setOpaque(false);
		RoomNumberTextField.setBorder(BorderFactory.createLineBorder(Color.WHITE, 3));
		RoomNumberTextField.setFont(font15);
		
		JLabel RoomTypeLabel = new JLabel("Room Type:");
		RoomTypeLabel.setBounds(185,130,119,20);
		RoomTypeLabel.setForeground(Color.WHITE);
		RoomTypeLabel.setFont(font15);
		
		RoomTypeTextField = new JTextField();
		RoomTypeTextField.setBounds(185,160,120,40);
		RoomTypeTextField.setOpaque(false);
		RoomTypeTextField.setBorder(BorderFactory.createLineBorder(Color.WHITE, 3));		
		RoomTypeTextField.setFont(font15);

		JLabel RoomStatusLabel = new JLabel("Room Status:");
		RoomStatusLabel.setBounds(110,230,119,20);
		RoomStatusLabel.setForeground(Color.WHITE);
		RoomStatusLabel.setFont(font15);
		
		RoomStatusTextField = new JTextField();
		RoomStatusTextField.setBounds(110,270,120,40); 
		RoomStatusTextField.setOpaque(false);
		RoomStatusTextField.setBorder(BorderFactory.createLineBorder(Color.WHITE, 3));
		RoomStatusTextField.setFont(font15);
		//------------------------------------
	
			
		//right part

		searchButton = new JButton("SEARCH");
		searchButton.setBounds(640,90,120,40); 
		searchButton.setBackground(Color.YELLOW);
		searchButton.setFont(font15);
		searchButton.addActionListener(this);

		searchTextField = new JTextField();
		searchTextField.setBounds(770,90,120,40);
		searchTextField.setOpaque(false);
		searchTextField.setBorder(BorderFactory.createLineBorder(Color.WHITE, 3));
		searchTextField.setFont(font15);
		
		textArea = new JTextArea();
		textArea.setFont(font15);	
		textArea.setBorder(BorderFactory.createLineBorder(Color.WHITE, 3));
		textArea.setEditable(false);
		textArea.setText(roomList.getAll());
		JScrollPane jsp = new JScrollPane(textArea);
		jsp.setBounds(390,200,500,350);
		textArea.setOpaque(false);
		textArea.setForeground(Color.WHITE);
		jsp.setOpaque(false);
		jsp.getViewport().setOpaque(false);
		jsp.setBorder(BorderFactory.createEmptyBorder());		
		super.add(jsp);
		//--------------------------------------------
		ImageIcon image = new ImageIcon("./GUI/Resources/Room.png");
		JLabel background = new JLabel();
		background.setBounds(0,0,1000,700);
		background.setIcon(image);
			
		BackButton = new JButton();	
		image = new ImageIcon("./GUI/Resources/back21.jpg");
		BackButton.setBounds(50,40,55,55);
		BackButton.setIcon(image);
		BackButton.addActionListener(this);
		
		super.add(title);
		super.add(addButton);
		super.add(updateButton);
		super.add(deleteButton);
		super.add(deleteTextField);
		super.add(searchButton);
		super.add(searchTextField);
		
		super.add(RoomNumberLabel);
		super.add(RoomNumberTextField);
		super.add(RoomTypeLabel);
		super.add(RoomTypeTextField);
		super.add(RoomStatusLabel);
		super.add(RoomStatusTextField);
		super.add(BackButton);
		
	    super.add(background);
	    super.setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent e){
		
		try{

		if(e.getActionCommand().equals("ADD")){
			System.out.println("ADD CLICKED");
			
			if( !RoomNumberTextField.getText().isEmpty()&&!RoomTypeTextField.getText().isEmpty()&&
			!RoomStatusTextField.getText().isEmpty())
			{ 
				if( roomList.getByNumber(RoomNumberTextField.getText()) == null){
					
					Room R = new Room(
							RoomNumberTextField.getText(),RoomTypeTextField.getText(),
				                  RoomStatusTextField.getText());
					
					roomList.insert(R);
					RoomFileIO.writeInFile(R);
					textArea.setText(roomList.getAll());
					
				}
			}
		    else
		    {
			    JOptionPane.showMessageDialog(this,"please provide all information","Missing Information",JOptionPane.ERROR_MESSAGE);
		    }
			
		}
		else if(updateButton == e.getSource()){
			System.out.println("UPDATE CLICKED");
			if(!RoomNumberTextField.getText().isEmpty())
			{
				Room R =roomList.getByNumber(RoomNumberTextField.getText());
				if(R!=null)
				{
					if(!RoomNumberTextField.getText().isEmpty()){
						R.setRoomNumber(RoomNumberTextField.getText());
					}
					if(!RoomTypeTextField.getText().isEmpty()){
						R.setRoomType(RoomTypeTextField.getText());
					}
					if(!RoomStatusTextField.getText().isEmpty()){
						R.setRoomStatus(RoomStatusTextField.getText());
					}
					textArea.setText(roomList.getAll());
				}
			}
			else
			{
				JOptionPane.showMessageDialog(this,"please provide Room number ","Missing Information",JOptionPane.ERROR_MESSAGE);
			}
		}
		else if(searchButton == e.getSource()){
			Room R = roomList.getByNumber(searchTextField.getText());
			if(R!=null){
				textArea.setText( R.getRoomInfoAsString() );
			}
			else{
				JOptionPane.showMessageDialog(this,"NO ROOM FOUND.","Alert",JOptionPane.WARNING_MESSAGE);
			}
		}
		
		else if(deleteButton == e.getSource()){
			System.out.println("DELETE CLICKED");
			roomList.deleteByNumber(deleteTextField.getText());
			textArea.setText(roomList.getAll());
			JOptionPane.showMessageDialog(this,"Deleted Successfully :D","Alert",JOptionPane.WARNING_MESSAGE);
			
		}
		else if (BackButton == e.getSource()){
			System.out.println("Back Clicked ");
			ManagementFrame frame = new ManagementFrame();
			//frame.setVisible(true);
			this.setVisible(false);
		}
		}
		catch (Exception a){
			System.out.println("Somthing Wrong input");
		}

				
	}
	

}