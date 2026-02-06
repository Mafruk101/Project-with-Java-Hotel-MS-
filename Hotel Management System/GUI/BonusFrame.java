package GUI;
import Entity.*;
import EntityList.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BonusFrame extends JFrame implements ActionListener {
    Font font = new Font("Cambria", Font.BOLD, 17);
    JButton confirmButton;
    JTextField bonusTextField;
    EmployeeList empList;
	EmployeeFrame employeeFrame;

    public BonusFrame(EmployeeList empList, EmployeeFrame employeeFrame) {
        super("BONUS");
        super.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        super.setSize(440, 240);
        super.setLocation(240, 50);
        super.getContentPane().setBackground(new Color(150, 103, 208));
        super.setLayout(null);

        JLabel bonusLabel = new JLabel("PLEASE, ENTER THE BONUS AMOUNT TO ALL");
        bonusLabel.setBounds(40, 160 - 160, 500, 80);
		bonusLabel.setForeground(Color.WHITE);
        bonusLabel.setFont(font);

        bonusTextField = new JTextField();
        bonusTextField.setBounds(130, 160 - 90, 160, 40);
		bonusTextField.setOpaque(false);
		bonusTextField.setBorder(BorderFactory.createLineBorder(Color.WHITE, 3));
		bonusTextField.setForeground(Color.WHITE);
        bonusTextField.setFont(font);

        confirmButton = new JButton("CONFIRM");
        confirmButton.setBounds(130, 230 - 100, 160, 40);
        confirmButton.setBackground(new Color(134, 2, 222));
        confirmButton.setForeground(Color.WHITE);
        confirmButton.setFont(font);
        confirmButton.addActionListener(this);
		
		ImageIcon image = new ImageIcon("./GUI/Resources/Bonus.jpg");
		JLabel background = new JLabel();
		background.setBounds(0,0,440,240);
		background.setIcon(image);
		

        
        this.empList = empList;
		this.employeeFrame = employeeFrame;

        super.add(bonusLabel);
        super.add(bonusTextField);
        super.add(confirmButton);
		super.add(background);

        super.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
	try {
    if ("CONFIRM".equals(e.getActionCommand())) {
    System.out.println("CONFIRM Button Clicked");

    String bonusText = bonusTextField.getText();

    if (!bonusText.isEmpty()) {
        empList.addBonusToAll(Integer.parseInt(bonusText));
        employeeFrame.updateEmployeeListTextArea();

        JOptionPane.showMessageDialog(this, "Bonus added to all employees successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
    } else {
        JOptionPane.showMessageDialog(this, "Please enter a bonus amount.", "Missing Information", JOptionPane.ERROR_MESSAGE);
    }
	} }
   catch(Exception ex) {System.out.println(ex.getMessage()); }

  }
}