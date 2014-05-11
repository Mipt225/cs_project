package ru.mipt.cs.cluster.nuriyaFrames;

import javax.imageio.ImageIO;
import javax.swing.*;

import ru.mipt.cs.cluster.diagram.DiagramFrame;
import ru.mipt.cs.cluster.io.ClusterisationInput;
import ru.mipt.cs.cluster.io.ClusterisationOutput;

import java.awt.image.BufferedImage;
import java.awt.BorderLayout;
import java.io.File;
import java.io.IOException;


//Frame displaying the image
public class ImageFrame extends JFrame {
	
	private ClusterisationInput input;
	private ClusterisationOutput output;
	private JMenuBar menuBar;
	private JMenu mnProject;
	private JMenuItem mntmNewProject;
	private JMenu mnImage;
	private JMenuItem mntmShowInputImage;
	private JMenuItem mntmSaveAs;
	private JMenu mnAnalysis;
	private JMenuItem mntmBuildGraph;
	private JMenu mnHelp;
	private JMenuItem mntmHelp;
	private JMenuItem mntmContacts;
	private JLabel lblImage;
	
	
	public ImageFrame(ClusterisationInput input, ClusterisationOutput output) {
		this.input = input;
		this.output = output;
		
		initComponents();
	}
	
	private void initComponents() {
		
		setTitle("Cluster Image");
		setSize(output.getOutputImage().getWidth() + 10, output.getOutputImage().getHeight() + 10);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnProject = new JMenu("Project");
		menuBar.add(mnProject);
		
		mntmNewProject = new JMenuItem("New project");
		mnProject.add(mntmNewProject);
		mntmNewProject.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				mntmNewProjectActionPerformed(evt);
			}
		});
		
		mnImage = new JMenu("Image");
		menuBar.add(mnImage);
		
		mntmShowInputImage = new JMenuItem("Show input image");
		mnImage.add(mntmShowInputImage);
		mntmShowInputImage.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				mntmShowInputImageActionPerformed(evt);
			}
		});
		
		mntmSaveAs = new JMenuItem("Save as");
		mnImage.add(mntmSaveAs);
		mntmSaveAs.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				mntmSaveAsActionPerformed(evt);
			}
		});
		
		mnAnalysis = new JMenu("Analysis");
		menuBar.add(mnAnalysis);
		
		mntmBuildGraph = new JMenuItem("Build graph");
		mnAnalysis.add(mntmBuildGraph);
		mntmBuildGraph.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				mntmBuildGraphActionPerformed(evt);
			}
		});
		
		mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		
		mntmHelp = new JMenuItem("Help");
		mnHelp.add(mntmHelp);
		mntmHelp.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				mntmHelpActionPerformed(evt);
			}
		});
		
		mntmContacts = new JMenuItem("Contacts");
		mnHelp.add(mntmContacts);
		mntmContacts.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				mntmContactsActionPerformed(evt);
			}
		});
		
		BufferedImage img = output.getOutputImage();
        ImageIcon icon = new ImageIcon(img);
		lblImage = new JLabel(icon);
		getContentPane().add(lblImage, BorderLayout.CENTER);
	}
	
	private void mntmNewProjectActionPerformed(java.awt.event.ActionEvent evt) {
		JFrame parFrame = new ParametersFrame();
		parFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		parFrame.setSize(400, 400);
		
		parFrame.setVisible(true);
	}

	private void mntmShowInputImageActionPerformed(java.awt.event.ActionEvent evt) {
		BufferedImage img;
		try {
			img = ImageIO.read(new File(input.getInputImage()));
			ImageIcon icon = new ImageIcon(img);
			JFrame inputImageFrame = new JFrame();
			JLabel lbl = new JLabel(icon);
			
			inputImageFrame.add(lbl);
			inputImageFrame.setTitle(input.getInputImage());
			inputImageFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			inputImageFrame.setSize(img.getWidth(), img.getHeight());
			inputImageFrame.setVisible(true);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private void mntmSaveAsActionPerformed(java.awt.event.ActionEvent evt) {
		
		JFrame saveFrame = new OpenSaveDialogFrame(output.getOutputImage());
		saveFrame.dispose();
	}

	private void mntmBuildGraphActionPerformed(java.awt.event.ActionEvent evt) {
		JFrame buildGraphFrame = new DiagramFrame(output);
		buildGraphFrame.setVisible(true);
	}

	private void mntmHelpActionPerformed(java.awt.event.ActionEvent evt) {
		JFrame helpFrame = new HelpFrame();
		helpFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		helpFrame.setSize(600, 300);
		helpFrame.setLocation(400, 100);
		
		helpFrame.setVisible(true);
	}

	private void mntmContactsActionPerformed(java.awt.event.ActionEvent evt) {
		String contacts = "<html><h1>Contacts</h1>" +
                "<font face=’verdana’ size = 4>" +
				"<alignment = center>" +
                " jangnurgin@gmail.com <br>" +
                " Nurgalieva Nuriya<br>" +
                " MIPT, Russia  <br>" +
                " <br>" +
                " </html>";
		
		JOptionPane.showMessageDialog(this, contacts);
	}

	
}
