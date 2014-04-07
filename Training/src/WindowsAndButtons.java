import javax.swing.*;

public class WindowsAndButtons extends JFrame{
	
	private JLabel firstNumber;
	
	private JLabel secondNumber;
	
	private JLabel result;
	
	private JButton calcButton;
	
	private JTextField numFieldOne;
	
	private JTextField numFieldTwo;
	
	public WindowsAndButtons() {
		initComponents();
	}
	
	private void initComponents() {
		firstNumber = new JLabel();
		secondNumber = new JLabel();
		result = new JLabel();
		calcButton = new JButton();
		numFieldOne = new JTextField("", 3);
		numFieldTwo = new JTextField("", 3);
		
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		setTitle("Summarizer");
		
		firstNumber.setText("First number");
		secondNumber.setText("Second number");
		result.setText("");
		calcButton.setText("Calculate summ");
		
		calcButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				calcButtonActionPerformed(evt);
			}
		});
		
		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		
		layout.setHorizontalGroup(
				layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addContainerGap()
						.addComponent(firstNumber)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(numFieldOne, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(secondNumber)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(numFieldTwo, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGroup(layout.createSequentialGroup()
						.addComponent(calcButton))
				.addGroup(layout.createSequentialGroup()
						.addContainerGap()
						.addComponent(result))
				);
		
		layout.setVerticalGroup(
				layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addComponent(firstNumber)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(calcButton)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(result))
				.addGroup(layout.createSequentialGroup()
						.addComponent(numFieldOne, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
						.addContainerGap())
				.addGroup(layout.createSequentialGroup()
						.addComponent(secondNumber))
				.addGroup(layout.createSequentialGroup()
						.addComponent(numFieldTwo, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
				);
	}
	
	private void calcButtonActionPerformed(java.awt.event.ActionEvent evt) {
		int sum = (int) ((Double.parseDouble(numFieldOne.getText())) + (Double.parseDouble(numFieldTwo.getText())));
		result.setText("The result is " + sum);
	}
	
	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				WindowsAndButtons takeOne = new WindowsAndButtons();
				takeOne.setSize(400, 150);
				takeOne.setVisible(true);
			}
		});
	}
}
