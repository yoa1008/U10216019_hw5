import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class pwf extends JFrame {

	public static String ps1;
	private static JLabel showp = new JLabel("Password :");
	private static JTextField password = new JTextField(10);
	private static JButton pwc = new JButton("Confirm");

	public pwf() {

		JPanel p0 = new JPanel();
		p0.add(showp);
		showp.setForeground(Color.BLACK);
		p0.add(password);
		p0.add(pwc);
		pwc.setBackground(new Color(240, 100, 150));
		pwc.setForeground(Color.BLUE);
		add(p0, BorderLayout.CENTER);
		
		pwc.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ps1 = password.getText(); // Get the password user enter
				if (ps1.equals("0000")) {
					new Calculator(); // If password is right, then invoke Calculator()
				} else {
					password.setText(""); // 輸入錯誤時清除Textfield的內容值
					System.out.println("Error");
				}
			}
		});
		
		// The window of entering password
		this.setTitle("Please the password to the calculator");
		this.setSize(400, 70);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false); // 視窗不能放大

	}


	/** Main method */

	public static void main(String[] args) {

		pwf p = new pwf(); // Invoke the windows of entering password 
	}

}
