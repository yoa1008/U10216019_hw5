import java.awt.*;
import java.awt.event.*;
import javax.swing.*;



public class Calculator extends JFrame {

	// Create 按鈕
	private static JButton add = new JButton("+"); // The add button
	private static JButton less = new JButton("-"); // The subtraction button
	private static JButton clean = new JButton("C"); // The clean button
	private static JButton mul = new JButton("x"); // 乘紐
	private static JButton div = new JButton("÷"); // 除紐
	private static JButton equal = new JButton("="); // The equal button
	private static JLabel result = new JLabel("0", JLabel.RIGHT); // Label to show the number and result
	private static JButton digits[] = new JButton[10]; // Number from 0 to 9
	private static long num;
	private static byte op; // 運算子

	public Calculator() {

		//數字0~9以及 C , =
		JPanel p1 = new JPanel();
		p1.setLayout(new GridLayout(4, 3));
		for (int i = 9; i >= 0; i--) {
			digits[i] = new JButton(Integer.toString(i));
			p1.add(digits[i]);
			digits[i].addActionListener(new ActLis());
		}
		p1.add(clean);
		p1.add(equal);

		// +, -, *, /, sin, cos, tan, inverse紐
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

		// 按下按鈕時執行按鈕
		mul.addActionListener(new ActLis());
		div.addActionListener(new ActLis());
		add.addActionListener(new ActLis());
		less.addActionListener(new ActLis());
		equal.addActionListener(new ActLis());
		clean.addActionListener(new ActLis());
		
		// The window of the calculator
		this.setTitle("小算盤 (Easy)");
		this.setSize(270, 380);
		this.setVisible(true);
		this.setResizable(false); // 不能放大視窗
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
					out = 0; // 把儲存的結果歸0
					num = 0;
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

					// 運算
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

					// 輸出運算後的結果到顯示器
					result.setText(Long.toString(num));
				}
			} catch (NumberFormatException ne) {
				// 捕捉例外
			} catch (ArithmeticException ae) {
				// 捕捉被除數是零的例外
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
