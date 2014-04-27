package ru.mipt.cs.cluster.nuriyaFrames;

import java.awt.*;
import java.net.*;

import javax.swing.*;

public class HelpFrame extends JFrame {
	
	private JButton wikiButton;
	
	private JButton googleButton;
	
	private JLabel introduction;
	
	private JList paramInfo;
	
	public HelpFrame() {
		initComponents();
	}
	
	private void initComponents() {
		wikiButton = new JButton();
		googleButton = new JButton();
		introduction = new JLabel();
		paramInfo = new JList();
		
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		setTitle("Help");
		
		wikiButton.setText("Look up in Wikipedia");
		googleButton.setText("Look up in Google");
		
		String text = "<html><h2>Welcome to Cluster Image Help!</h2>" +
                "<font face=’verdana’ size = 4>" +
                " This program runs cluster analysis of an image. <br>" +
                " During the process, the image's pixels are divided into <br>" +
                " particular number of groups given by user. <br>" +
                " To get more information about cluster analysis click buttons on the left<br>" +
                " Here you can see the table with useful information about the parameters: <br>" +
                "  <br>" +
                " </html>";
		
		introduction.setText(text);
		introduction.setFont(new Font(null, Font.ROMAN_BASELINE, 10));
		
		wikiButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				try {
					
					wikiButtonActionPerformed(evt);
				} 
				catch (MalformedURLException e) {
					
					e.printStackTrace();
				}
			}
		});
		
		googleButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				try {
					
					googleButtonActionPerformed(evt);
				} 
				catch (MalformedURLException e) {
					
					e.printStackTrace();
				}
			}
		});
		
		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		
		layout.setHorizontalGroup(
				layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addContainerGap()
						.addComponent(introduction)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED))
				.addGroup(layout.createSequentialGroup()
						.addComponent(introduction)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(wikiButton)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED))
				.addGroup(layout.createSequentialGroup()
						.addComponent(introduction)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED))
				.addGroup(layout.createSequentialGroup()
						.addContainerGap()
						.addComponent(introduction)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(googleButton)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED))
				.addGroup(layout.createSequentialGroup()
						.addContainerGap()
						.addComponent(paramInfo))
				);
		
		layout.setVerticalGroup(
				layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addComponent(introduction)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(paramInfo)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED))
				.addGroup(layout.createSequentialGroup()
						.addComponent(introduction)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(paramInfo)
						.addContainerGap())
				.addGroup(layout.createSequentialGroup()
						.addContainerGap()
						.addComponent(wikiButton)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(googleButton)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(paramInfo))
				);
	}
	
	private void wikiButtonActionPerformed(java.awt.event.ActionEvent evt) throws MalformedURLException {
		
		URL url = new URL("http://en.wikipedia.org/wiki/Cluster_analysis");
		openWebpage(url);
	}
	
	private void googleButtonActionPerformed(java.awt.event.ActionEvent evt) throws MalformedURLException {
		
		URL url = new URL("https://www.google.ru/#newwindow=1&q=cluster+analysis");
		openWebpage(url);
	}
	
	public static void openWebpage(URI uri) {
	    Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
	    if (desktop != null && desktop.isSupported(Desktop.Action.BROWSE)) {
	        try {
	            desktop.browse(uri);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	}

	public static void openWebpage(URL url) {
	    try {
	        openWebpage(url.toURI());
	    } catch (URISyntaxException e) {
	        e.printStackTrace();
	    }
	}
}
