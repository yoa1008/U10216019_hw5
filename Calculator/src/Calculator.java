import java.awt.*;
import javax.swing.*;

public class Calculator extends JFrame{
	
	private JButton b1 = new JButton("" + 1);
	private JButton b2 = new JButton("" + 2);
	private JButton b3 = new JButton("" + 3);
	private JButton b4 = new JButton("" + 4);
	private JButton b5 = new JButton("" + 5);
	private JButton b6 = new JButton("" + 6);
	private JButton b7 = new JButton("" + 7);
	private JButton b8 = new JButton("" + 8);
	private JButton b9 = new JButton("" + 9);
	private JButton b0 = new JButton("" + 0);
	private JButton add = new JButton("+");
	private JButton less = new JButton("-");
	private JButton point = new JButton(".");
	private JButton sin = new JButton("sinx");
	private JButton cos = new JButton("cosx");
	private JButton tan = new JButton("tanx");
	private JButton multiplication = new JButton("x");
	private JButton division = new JButton("/");
	private JButton inverse = new JButton("1/x");
	private JButton equal = new JButton("=");
	private JTextField result = new JTextField("0" , 32);
	private JTextField password = new JTextField(10);
	private JButton pwc = new JButton("Confirm");
	
	
	public Calculator(){
		//
		JPanel p1 = new JPanel();
		p1.setLayout(new GridLayout(4 , 3));
		p1.add(b1);
		p1.add(b2);
		p1.add(b3);
		p1.add(b4);
		p1.add(b5);
		p1.add(b6);
		p1.add(b7);
		p1.add(b8);
		p1.add(b9);
		p1.add(b0);
		p1.add(point);
		p1.add(equal);
		
		// 
		JPanel p2 = new JPanel();
		p2.setLayout(new GridLayout(4 , 2));
		p2.add(add);
		p2.add(sin);
		p2.add(less);
		p2.add(cos);
		p2.add(multiplication);
		p2.add(tan);
		p2.add(division);
		p2.add(inverse);
		
		//
		JPanel p3 = new JPanel();
		result.setHorizontalAlignment(JTextField.RIGHT);
		p3.add(result);
		
		//
		JPanel p4 = new JPanel();
		p4.setLayout(new GridLayout(1 , 3));
		p4.add(new JLabel("Enter the password : "));
		p4.add(password);
		p4.add(pwc);
		
		//
		add(p1, BorderLayout.CENTER);
		add(p2, BorderLayout.EAST);
		add(p3, BorderLayout.NORTH);
		add(p4, BorderLayout.SOUTH);
		
		//

	}
	
	
	
	public static void main(String[] args){
		Calculator frame = new Calculator();
		frame.setTitle("Calculator");
		frame.setSize(400 , 400);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}

