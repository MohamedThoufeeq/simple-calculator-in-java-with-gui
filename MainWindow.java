import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MainWindow implements ActionListener {

	public JFrame jframe;
	
	public JTextField textField;
	public JButton oneButton, twoButton, threeButton, fourButton, fiveButton,
					sixButton, sevenButton, eightButton, nineButton, zeroButton,
					addButton, subButton, mulButton, divButton, equalsButton, dotButton,
					clearButton, deleteButton;
	
	public JButton[] numberButtons = new JButton[10];
	public JButton[] functionButtons = new JButton[8];
	public JLabel jlabel;
	String num1, num2, operator, result = null;
	
	public MainWindow() {
		prepareCalci();
		
		setTextFields();
		
		setButtons();
		
		processInput();
	}


	private void setButtons() {
		// Create Math operation buttons
		functionButtons[0] = addButton = new JButton("+");
		functionButtons[1] = subButton = new JButton("-");
		functionButtons[2] = mulButton = new JButton("*");
		functionButtons[3] = divButton = new JButton("÷");
		functionButtons[4] = equalsButton = new JButton("=");
		functionButtons[5] = dotButton = new JButton(".");
		functionButtons[6] = clearButton = new JButton("Clear");
		functionButtons[7] = deleteButton = new JButton("←");
		
		// Create buttons from 0 to 9
		for (int i = 0; i < numberButtons.length; i++) {
			JButton jButton = numberButtons[i] = new JButton(String.valueOf(i));
			jButton.setVisible(true);
			jButton.addActionListener(this);
			jButton.setFocusable(false);
		}
		for (int i = 0; i < functionButtons.length; i++) {
			functionButtons[i].addActionListener(this);
		}
		
		// Create Panel
		JPanel jpanel = new JPanel();
		jpanel.setLayout(new GridLayout(4,4,10,10));
		jpanel.setBounds(40, 70, 310, 350);
		
		//Set the buttons inside the panel as a row
		jpanel.add(numberButtons[1]);
		jpanel.add(numberButtons[2]);
		jpanel.add(numberButtons[3]);
		jpanel.add(addButton);//1st row
		jpanel.add(numberButtons[4]);
		jpanel.add(numberButtons[5]);
		jpanel.add(numberButtons[6]);
		jpanel.add(subButton);//2nd row
		jpanel.add(numberButtons[7]);
		jpanel.add(numberButtons[8]);
		jpanel.add(numberButtons[9]);
		jpanel.add(mulButton);//3rd row
		jpanel.add(dotButton);
		jpanel.add(numberButtons[0]);
		jpanel.add(equalsButton);
		jpanel.add(divButton);//4th row
		
		jframe.add(jpanel);
		
		JPanel bottomRow = new JPanel();
		bottomRow.setLayout(new GridLayout(1,2));
		bottomRow.setBounds(40,430, 310, 60);
		bottomRow.add(clearButton);
		bottomRow.add(deleteButton);
		
		jframe.add(bottomRow);
	}


	private void setTextFields() {
		//Jlabel
		jlabel = new JLabel();
		jlabel.setVisible(true);
		jlabel.setBounds(250, 0, 50, 50);
		jlabel.setForeground(Color.white);
		jframe.add(jlabel);
		
		//text fields
		textField = new JTextField();
		textField.setVisible(true);
		textField.setForeground(Color.white);
		textField.setFont(new Font(Font.SERIF, Font.BOLD, 20));
		textField.setBounds(40, 10,310, 50);
//		textField.setBounds(10, 40, 360, 40);
//		textField.setHorizontalAlignment(SwingConstants.CENTER);
//		textField.setEditable(false);

		jframe.add(textField);
	}
	
	private void processInput() {
		
	}

	private void prepareCalci() {
		jframe = new JFrame("Calculator");
		jframe.setBackground(Color.black);
		jframe.getContentPane().setLayout(null);
		jframe.getContentPane().setBackground(Color.DARK_GRAY);
		jframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		jframe.setSize(400, 550);
		jframe.setLocationRelativeTo(null);
	}


	public void show() {
		jframe.setVisible(true);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		
		// clear button
		if(source == clearButton) {
			textField.setText("");
		}
		//delete button
		if(source == deleteButton) {
			String text = textField.getText();
			int length = text.length();
			StringBuilder sb = new StringBuilder(text);
			if(length != 0) {
				sb.deleteCharAt(length-1);
				textField.setText(sb.toString());
			} else {
				textField.setText("");
			}
		}
		// math operation button
		if(source == addButton) {
			num1 = textField.getText();
			textField.setText("");
			operator = "+";
		}
		if(source == subButton) {
			num1 = textField.getText();
			textField.setText("");
			operator = "-";
		}
		if(source == mulButton) {
			num1 = textField.getText();
			textField.setText("");
			operator = "*";
		}
		if(source == divButton) {
			num1 = textField.getText();
			textField.setText("");
			operator = "÷";
		}
		if(source == equalsButton) {
			switch (operator) {
			case "+":
				num2 = textField.getText();
				float sum = Float.parseFloat(num1) + Float.parseFloat(num2);
				result = String.valueOf(sum);
				break;
			case "-":
				num2 = textField.getText();
				float diff = Float.parseFloat(num1) - Float.parseFloat(num2);
				result = String.valueOf(diff);
				break;
			case "*":
				num2 = textField.getText();
				float prod = Float.parseFloat(num1) * Float.parseFloat(num2);
				result = String.valueOf(prod);
				break;
			case "÷":
				num2 = textField.getText();
				float qoutient = Float.parseFloat(num1) / Float.parseFloat(num2);
				result = String.valueOf(qoutient);
				break;

			default:
				break;
			}
			num1 = result;
			textField.setText(num1);
		}
		
		for(int j=0; j<functionButtons.length-4; j++) {
		}
		
		// number button
		for(int i=0; i<numberButtons.length; i++) {
			if(source == numberButtons[i]) {
				JButton b = (JButton)source;
				textField.setText(textField.getText()+b.getText());
				textField.setForeground(Color.BLACK);
			}
		}
		if(source == dotButton) {
			textField.setText(textField.getText()+dotButton.getText());
		}
	}

}
