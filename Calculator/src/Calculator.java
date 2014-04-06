import java.awt.*;
import java.awt.event.*;
import javax.swing.*;



public class Calculator extends JFrame {

	// Create ���s
	private static JButton add = new JButton("+"); // The add button
	private static JButton less = new JButton("-"); // The subtraction button
	private static JButton clean = new JButton("C"); // The clean button
	private static JButton mul = new JButton("x"); // ����
	private static JButton div = new JButton("��"); // ����
	private static JButton equal = new JButton("="); // The equal button
	private static JLabel result = new JLabel("0", JLabel.RIGHT); // Label to show the number and result
	private static JButton digits[] = new JButton[10]; // Number from 0 to 9
	private static long num;
	private static byte op; // �B��l

	public Calculator() {

		//�Ʀr0~9�H�� C , =
		JPanel p1 = new JPanel();
		p1.setLayout(new GridLayout(4, 3));
		for (int i = 9; i >= 0; i--) {
			digits[i] = new JButton(Integer.toString(i));
			p1.add(digits[i]);
			digits[i].addActionListener(new ActLis());
		}
		p1.add(clean);
		p1.add(equal);

		// +, -, *, /, sin, cos, tan, inverse��
		JPanel p2 = new JPanel();
		p2.setLayout(new GridLayout(4, 1));
		p2.add(add);
		p2.add(less);
		p2.add(mul);
		p2.add(div);


		//
		JPanel p3 = new JPanel();
		p3.add(result);
		result.setForeground(Color.RED); // Change the color of the result

		//
		add(p1, BorderLayout.CENTER);
		add(p2, BorderLayout.EAST);
		add(p3, BorderLayout.NORTH);

		// ���U���s�ɰ�����s
		mul.addActionListener(new ActLis());
		div.addActionListener(new ActLis());
		add.addActionListener(new ActLis());
		less.addActionListener(new ActLis());
		equal.addActionListener(new ActLis());
		clean.addActionListener(new ActLis());
		
		// The window of the calculator
		this.setTitle("�p��L (Easy)");
		this.setSize(270, 380);
		this.setVisible(true);
		this.setResizable(false); // �����j����
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static class ActLis implements ActionListener {

		public void actionPerformed(ActionEvent e)
				throws NumberFormatException, ArithmeticException {

			long out;
			JButton btn = (JButton) e.getSource();
			try {
				// �B�z�Ʀr1~9
				for (int i = 0; i <= 9; i++) {
					if (btn == digits[i]) {
						output_digit(digits[i]);
						break;
					}
				}
				if (btn == clean) {
					out = 0; // ���x�s�����G�k0
					num = 0;
					op = 0;
					result.setText(Long.toString(num));
				} else if (btn == add) { // �[
					save_num(add);
					op = 1;
				} else if (btn == less) { // ��
					save_num(less);
					op = 2;
				} else if (btn == mul) { // ��
					save_num(mul);
					op = 3;
				} else if (btn == div) { // ��
					save_num(div);
					op = 4;
				} else if (btn == equal) {
					out = Long.parseLong(result.getText());

					// �B��
					switch (op) {
					case 1:
						num += out;
						break;
					case 2:
						num -= out;
						break;
					case 3:
						num *= out;
						break;
					case 4:
						num /= out;
						if(out == 0)
							System.out.println("The number you enter can't be 0");
						break;
					default:
					}

					// ��X�B��᪺���G����ܾ�
					result.setText(Long.toString(num));
				}
			} catch (NumberFormatException ne) {
				// �����ҥ~
			} catch (ArithmeticException ae) {
				// �����Q���ƬO�s���ҥ~
			}
		}

		
		// Show out the number
		@SuppressWarnings("deprecation")
		private void output_digit(JButton btn) {
			result.setText(Long.toString(Long.parseLong(result.getText()
					+ btn.getLabel())));
		}
		
		// Save the number
		private void save_num(JButton oper) {
			num = Long.parseLong(result.getText());
			result.setText(Long.toString(0));
		}
	}

}
