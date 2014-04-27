package ru.mipt.cs.cluster.nuriyaFrames;

import java.awt.Font;

import javax.swing.*;

public class FirstFrame extends JFrame{
	
	private JLabel label;
	
	private JButton startButton;
	
	private JButton helpButton;
	
	public FirstFrame() {
		initComponents();
	}
	
	private void initComponents() {
		startButton = new JButton();
		helpButton = new JButton();
		label = new JLabel();
		
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		setTitle("Cluster Image");
		
		startButton.setText("Start!");
		helpButton.setText("Help");
		
		String text = "<html><h2>Welcome to Cluster Image!</h2>" +
                "<font face=’verdana’ size = 4>" +
				"<alignment = center>" +
                " Glad to see you! <br>" +
                " <br>" +
                " To enter parameters, press Start  <br>" +
                " <br>" +
                " To understand things, click Help <br>" +
                " </html>";
		
		label.setText(text);
		label.setFont(new Font(null, Font.ROMAN_BASELINE, 10));
		
		startButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				startButtonActionPerformed(evt);
			}
		});
		
		helpButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				helpButtonActionPerformed(evt);
			}
		});
		
		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		
		layout.setHorizontalGroup(
				layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addContainerGap()
						.addComponent(label))
				.addGroup(layout.createSequentialGroup()
						.addContainerGap()
						.addComponent(startButton)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(helpButton)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED))
				);
		
		layout.setVerticalGroup(
				layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addComponent(label)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(startButton)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED))
				.addGroup(layout.createSequentialGroup()
						.addComponent(label)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(helpButton)
						.addContainerGap())
				);
	}
	
	private void startButtonActionPerformed(java.awt.event.ActionEvent evt) {
		JFrame parFrame = new ParametersFrame();
		parFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		parFrame.setSize(400, 200);
		
		setVisible(false);
		parFrame.setVisible(true);
	}
	
	private void helpButtonActionPerformed(java.awt.event.ActionEvent evt) {
		JFrame helpFrame = new HelpFrame();
		helpFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		helpFrame.setSize(1000, 500);
		
		setVisible(false);
		helpFrame.setVisible(true);
	}
	
}
