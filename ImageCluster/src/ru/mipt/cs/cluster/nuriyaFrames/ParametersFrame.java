package ru.mipt.cs.cluster.nuriyaFrames;

import java.awt.event.KeyEvent;
import java.io.*;
import java.net.*;
import java.nio.channels.*;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.*;

import ru.mipt.cs.cluster.io.ClusterisationInput;


//Frame to input the parameters
public class ParametersFrame extends JFrame {
		
		private JTextField textFieldNumOfClusters;
		private JTextField textFieldConvergence;
		private JTextField textFieldLocalFile;
		private JTextField textFieldUrl;
		private JTextField textFieldFolder;
		private JLabel lblConvergence;
		private JLabel lblInputImage;
		private JLabel lblAlgorithm;
		private JLabel lblNumberOfClusters; 
		private JRadioButton rdbtnLocalFile;
		private JRadioButton rdbtnUrl;
		private JRadioButton rdbtnFolder;
		private JRadioButton rdbtnEuclidian;
		private JRadioButton rdbtnEuclidianSquared;
		private JRadioButton rdbtnManhattan;
		private JButton btnCluster;
		private JButton btnHelp;
		
		private ClusterisationInput input = new ClusterisationInput();
		
		public ParametersFrame() {
			initComponents();
			initLayout();
		}
		
		private void initComponents() {
			
			setSize(400,400);
			setTitle("Parameters input");
			
			lblNumberOfClusters = new JLabel("Number of clusters");
			
			textFieldNumOfClusters = new JTextField();
			textFieldNumOfClusters.setColumns(10);
			
			lblConvergence = new JLabel("Convergence");
			
			textFieldConvergence = new JTextField();
			textFieldConvergence.setColumns(10);
			
			lblInputImage = new JLabel("Input image");
			
			lblAlgorithm = new JLabel("Algorithm");
			
			ButtonGroup file = new ButtonGroup();
			ButtonGroup algorithm = new ButtonGroup();
			
			rdbtnLocalFile = new JRadioButton("Local file");
			rdbtnLocalFile.setSelected(true);
			
			rdbtnUrl = new JRadioButton("URL");
			
			rdbtnFolder = new JRadioButton("Folder");
			
			rdbtnEuclidian = new JRadioButton("Euclidian");
			rdbtnEuclidian.setSelected(true);
			
			rdbtnEuclidianSquared = new JRadioButton("Euclidian squared");
		
			rdbtnManhattan = new JRadioButton("Manhattan");
			
			file.add(rdbtnLocalFile);
			file.add(rdbtnUrl);
			file.add(rdbtnFolder);
			
			algorithm.add(rdbtnEuclidian);
			algorithm.add(rdbtnEuclidianSquared);
			algorithm.add(rdbtnManhattan);
			
			textFieldLocalFile = new JTextField();
			textFieldLocalFile.setColumns(10);
			
			textFieldUrl = new JTextField();
			textFieldUrl.setColumns(10);
			
			textFieldFolder = new JTextField();
			textFieldFolder.setColumns(10);
			
			btnCluster = new JButton("Cluster!");
			btnCluster.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent evt) {
					btnClusterActionPerformed(evt);
				}
			});
			
			btnHelp = new JButton("Help");
			btnHelp.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent evt) {
					btnHelpActionPerformed(evt);
				}
			});
			
		}
		
		private void initLayout() {
			
			GroupLayout groupLayout = new GroupLayout(getContentPane());
			groupLayout.setHorizontalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
					.addGroup(groupLayout.createSequentialGroup()
						.addContainerGap()
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNumberOfClusters)
								.addComponent(lblConvergence)
								.addComponent(lblInputImage)
								.addComponent(lblAlgorithm))
							.addComponent(btnHelp, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
							.addGroup(groupLayout.createSequentialGroup()
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
									.addComponent(rdbtnManhattan)
									.addComponent(rdbtnEuclidianSquared)
									.addComponent(textFieldConvergence, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
									.addComponent(textFieldNumOfClusters, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
									.addComponent(rdbtnEuclidian)
									.addGroup(groupLayout.createSequentialGroup()
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
											.addComponent(rdbtnLocalFile)
											.addComponent(rdbtnUrl)
											.addComponent(rdbtnFolder))
										.addPreferredGap(ComponentPlacement.RELATED)
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
											.addComponent(textFieldFolder, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
											.addComponent(textFieldUrl, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
											.addComponent(textFieldLocalFile, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
								.addContainerGap(38, Short.MAX_VALUE))
							.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
								.addGap(161)
								.addComponent(btnCluster)
								.addGap(19))))
			);
			groupLayout.setVerticalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
					.addGroup(groupLayout.createSequentialGroup()
						.addGap(22)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblNumberOfClusters)
							.addComponent(textFieldNumOfClusters, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblConvergence)
							.addComponent(textFieldConvergence, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
							.addComponent(lblInputImage)
							.addGroup(groupLayout.createSequentialGroup()
								.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
									.addComponent(rdbtnLocalFile)
									.addComponent(textFieldLocalFile, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
									.addComponent(rdbtnUrl)
									.addComponent(textFieldUrl, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
									.addComponent(rdbtnFolder)
									.addComponent(textFieldFolder, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
									.addComponent(rdbtnEuclidian)
									.addComponent(lblAlgorithm, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(rdbtnEuclidianSquared)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(rdbtnManhattan)
						.addGap(18)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnCluster)
							.addComponent(btnHelp))
						.addContainerGap(28, Short.MAX_VALUE))
			);
			getContentPane().setLayout(groupLayout);
		}
		
		private void btnHelpActionPerformed(java.awt.event.ActionEvent evt) {
			
			JFrame helpFrame = new HelpFrame();
			helpFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
			helpFrame.setSize(600, 300);
			helpFrame.setLocation(400, 100);
			
			helpFrame.setVisible(true);
		}
		
		private void btnClusterActionPerformed(java.awt.event.ActionEvent evt)  {
			
			ClusterisationInput input = new ClusterisationInput();
			
			input.setNumOfClusters ((int) Double.parseDouble(textFieldNumOfClusters.getText()));
		
			input.setConvergence (Double.parseDouble(textFieldConvergence.getText()));
			
			algorithmButtonHandler();
			
			if (rdbtnFolder.isSelected())
			{
				final ImageFilter imageFilter = new ImageFilter();
			      final File dir = new File(textFieldFolder.getText());
			      for (File imgFile : dir.listFiles()) {
			          if(imageFilter.accept(imgFile)){
			              input.setInputImage(imgFile.getPath());
			              
			              Thread t =new ThreadRun(input);
			              t.start();
			          }
			      }
			}
			else {
				if (rdbtnLocalFile.isSelected()) 
					input.setInputImage(textFieldLocalFile.getText());
				if (rdbtnUrl.isSelected())
					input.setInputImage(loadImage(textFieldUrl.getText()));
				
				ThreadRun t = new ThreadRun(input);
				t.start();
			}
			
		}
		
		private void algorithmButtonHandler() {
			
			if (rdbtnEuclidian.isSelected()) 
			{
				input.setAlgorithm(0);
			}

			if (rdbtnEuclidianSquared.isSelected())
				input.setAlgorithm(1);
			if (rdbtnManhattan.isSelected())
				input.setAlgorithm(2);
		}
		
	
		private String loadImage(String adr) {
			String destname = null;
			
			try {
					URL website = new URL(adr);
				
				String filename = website.getFile();
				
				destname = "./" + filename.substring(filename.lastIndexOf("/"));
				InputStream is = website.openStream();
				OutputStream os = new FileOutputStream(destname);
			 
				byte[] b = new byte[2048];
				int length;
			 
				while ((length = is.read(b)) != -1) {
					os.write(b, 0, length);
				}
			 
				is.close();
				os.close();
				} catch (MalformedURLException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				return destname;
		}
	
}
