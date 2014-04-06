import java.awt.*;
import java.awt.event.*;

import javax.swing.*;


public class pwf extends JFrame{
	
	public static String ps1;
	public static String ps2;
	private static JTextField password = new JTextField(10);
	private static JButton pwc = new JButton("Confirm");
	
	public pwf() {
		
	JPanel p0 = new JPanel();
	p0.add(new JLabel("Password :"));
	p0.add(password);
	p0.add(pwc);
	add(p0, BorderLayout.CENTER);
	pwc.addActionListener(new ActionListener(){
		@Override
		public void actionPerformed(ActionEvent e){
			ps1 = password.getText();
			if (ps1.equals("0000")) {
				new Calculator();
			}
		}
	});
	this.setTitle("Please the password to the calculator");
	this.setSize(500, 70);
	this.setVisible(true);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.setLocationRelativeTo(null);
	this.setResizable(false);
	
	}
	
	
	String getp() {
		return ps1;
	}
	
	/** Main method */
	public static void main(String[] args) {
		pwf p = new pwf();
			
		}
	}




