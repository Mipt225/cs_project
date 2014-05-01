package ru.mipt.cs.cluster.nuriyaFrames;

import java.awt.*;
import java.awt.event.*;
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
		
		DefaultListModel listModel = new DefaultListModel(); 
		paramInfo = new JList(listModel);
		JScrollPane sp = new JScrollPane(paramInfo);   
		
		String cluster = "<html><h2>Cluster</h2>" +
                "<font face=’verdana’ size = 4>" +
                " In our case, cluster is a group of pixels which values are very close. <br>" +
                " Every pixel is a vector which has three coordinates in a special basis called RGB.<br>" +
                " Each cluster has a center; when pixel is added, center changes.<br>" +
                " The final color of a particular cluster is the color of its center.<br>" +
                " The number of clusters must be between 1 and 255. The number of clusters <br>" +
                " represents the total number of colors in output image. <br>" +
                " You should try to estimate the number of clusters you need for this picture by yourself." +
                " </html>";
		
		String convergence = "<html><h2>Convergence</h2>" +
                "<font face=’verdana’ size = 4>" +
                " The value of convergence depends on how accurate the distribution of pixels must be.<br>" +
                " There are two different ways: you can enter the number less than 1 and the algorithm will run until <br>" +
                " the difference between the center and the pixels in cluster will be less than this percent;<br>" +
                " or you can enter number bigger than 1 and in that case algorithm will run <br>" +
                " until given number of iterations is done. <br>" +
                " We recommend you to choose convergence near 0,9 or number of iterations 3 or 4, as they show the best results. <br>" +
                " </html>";
		
		String algorithm = "<html><h2>Algorithm</h2>" +
                "<font face=’verdana’ size = 4>" +
                " Distance algorithm is an algorithm by which we estimate the distances between pixels.<br>" +
                " Distance algorithms can be different. You can choose between three of them:  <br>" +
                " Euclidian squared distance; Euclidian distance and Manhattan distance. <br>" +
                " They all use different formulas, so the result is slightly different. <br>" +
                " We recommend you to try all of this algorithms and then choose the best. <br>" +
                " </html>";;
		
		listModel.addElement(new ParameterDescription("Cluster", cluster));  
	    listModel.addElement(new ParameterDescription("Convergence",convergence));  
	    listModel.addElement(new ParameterDescription("Algorithm", algorithm));  
	    
	    paramInfo.addMouseListener(new MouseAdapter(){  
	    	
	      public void mouseClicked(MouseEvent me){ 
	    	  
	        ParameterDescription temp = (ParameterDescription)paramInfo.getSelectedValue();  
	        if(temp != null)  
	        {  
	          JOptionPane.showMessageDialog(HelpFrame.this, temp.getDescription());  
	        }}});  
		
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
