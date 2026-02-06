package GUI;
import File.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

 
public class LoginPage extends JFrame implements ActionListener{
	JTextField nameTextField;
	JPasswordField passField;
	JButton loginButton;
	Font font = new Font("Cambria",Font.BOLD,20);
	public LoginPage(){
		super("Login page");
		super.setSize(870,580);
		super.setLocation(300,100);
		super.setDefaultCloseOperation(EXIT_ON_CLOSE);
		super.setLayout(null);
		
		
		
		JLabel nameLabel = new JLabel("User Name");
		nameLabel.setFont(font);
		nameLabel.setBounds(40,50,120,40);
		this.add(nameLabel);
		
		nameTextField = new JTextField();
		nameTextField.setFont(font);
		nameTextField.setBounds(40,100,190,40);
		this.add(nameTextField);
		
		JLabel passLabel = new JLabel("Password");
		passLabel.setFont(font);
		passLabel.setBounds(40,150,120,40);
		this.add(passLabel);
		
		passField = new JPasswordField();
		passField.setFont(font);
		passField.setBounds(40,200,190,40);
		passField.setEchoChar('*');
		this.add(passField);
		
		loginButton = new JButton("Login");
		loginButton.setFont(font);
		loginButton.setBounds(75,260,120,40);
		loginButton.addActionListener(this);
		this.add(loginButton);
		
		ImageIcon image= new ImageIcon("./GUI/Resources/login1.png");
		JLabel background = new JLabel();
		background.setBounds(0,0,870,580);
		background.setIcon(image);
		this.add(background);
		this.setVisible(true);
	}
	public void actionPerformed(ActionEvent e){
		try {
			String userName = nameTextField.getText();
			String userPass = new String(passField.getPassword());
			if(loginButton == e.getSource()){
				if(UserFileIO.checkUserFromFile(userName,userPass)){
					JOptionPane.showMessageDialog(this,"Login Successful");	
					ManagementFrame frame = new ManagementFrame();	
					//frame.setVisible(true);
					this.setVisible(false);
				}
				else{
					JOptionPane.showMessageDialog(this,"Login Failed");
				}
		} }
	catch(Exception ex) {System.out.println(ex.getMessage()); }
	
	} 
}
