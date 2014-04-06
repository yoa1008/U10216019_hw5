import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import java.lang.*;

public class Calculator extends JFrame {

	private static JButton add = new JButton("+");
	private static JButton less = new JButton("-");
	private static JButton tan = new JButton(".");
	private static JButton sin = new JButton("sinx");
	private static JButton cos = new JButton("cosx");
	private static JButton clean = new JButton("C");
	private static JButton mul = new JButton("x");
	private static JButton div = new JButton("/");
	private static JButton inverse = new JButton("1/x");
	private static JButton equal = new JButton("=");
	private static JLabel result = new JLabel("0", JLabel.RIGHT);
	private static JTextField password = new JTextField(10);
	private static JButton pwc = new JButton("Confirm");

	private static JButton digits[] = new JButton[10];
	private static long num;
	private static byte op;

	public Calculator() {

		//
		JPanel p1 = new JPanel();
		p1.setLayout(new GridLayout(4, 3));
		for (int i = 9; i >= 0; i--) {
			digits[i] = new JButton(Integer.toString(i));
			p1.add(digits[i]);
			digits[i].addActionListener(new ActLis());
		}
		p1.add(clean);
		p1.add(equal);

		//
		JPanel p2 = new JPanel();
		p2.setLayout(new GridLayout(4, 2));
		p2.add(add);
		p2.add(sin);
		p2.add(less);
		p2.add(cos);
		p2.add(mul);
		p2.add(tan);
		p2.add(inverse);
		p2.add(div);

		//
		JPanel p3 = new JPanel();
		p3.add(result);
		result.setBackground(new Color(240, 220, 190));

		//
		JPanel p4 = new JPanel();
		p4.setLayout(new GridLayout(1, 3));
		p4.add(new JLabel("The password :"));
		p4.add(password);
		p4.add(pwc);
		pwc.setBackground(new Color(200, 150, 120));

		//
		add(p1, BorderLayout.CENTER);
		add(p2, BorderLayout.EAST);
		add(p3, BorderLayout.NORTH);
		add(p4, BorderLayout.SOUTH);

		//
		mul.addActionListener(new ActLis());
		div.addActionListener(new ActLis());
		sin.addActionListener(new ActLis());
		cos.addActionListener(new ActLis());
		inverse.addActionListener(new ActLis());
		add.addActionListener(new ActLis());
		less.addActionListener(new ActLis());
		equal.addActionListener(new ActLis());
		clean.addActionListener(new ActLis());
		tan.addActionListener(new ActLis());

	}

	public static class ActLis implements ActionListener {

		public void actionPerformed(ActionEvent e)
				throws NumberFormatException, ArithmeticException {
			long out;

			JButton btn = (JButton) e.getSource();
			try {
				// 處理數字1~9
				for (int i = 0; i <= 9; i++) {
					if (btn == digits[i]) {
						output_digit(digits[i]);
						break;
					}
				}
				if (btn == clean) {
					out = 0L; // 把儲存的結果歸0
					num = 0L;
					op = 0;
					result.setText(Long.toString(num));
				} else if (btn == add) { // 加
					save_num(add);
					op = 1;
				} else if (btn == less) { // 減
					save_num(less);
					op = 2;
				} else if (btn == mul) { // 乘
					save_num(mul);
					op = 3;
				} else if (btn == div) { // 除
					save_num(div);
					op = 4;
				} else if (btn == equal) {
					out = Long.parseLong(result.getText());

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
						break;
					default:
					}
					out = 0L;
					// 輸出運算後的結果到顯示器
					result.setText(Long.toString(num));
				}
			} catch (NumberFormatException ne) {
				// 捕捉例外
			} catch (ArithmeticException ae) {
				// 捕捉被除數是零的例外
			}
		}

		@SuppressWarnings("deprecation")
		private void output_digit(JButton btn) {
			result.setText(Long.toString(Long.parseLong(result.getText()
					+ btn.getLabel())));
		}

		private void save_num(JButton oper) {
			num = Long.parseLong(result.getText());
			result.setText(Long.toString(0L));
		}
	}

	/** Main method */
	public static void main(String[] args) {
		Calculator frame = new Calculator();
		frame.setTitle("Calculator");
		frame.setSize(300, 380);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
