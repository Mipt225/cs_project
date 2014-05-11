package ru.mipt.cs.cluster.nuriyaFrames;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;


public class OpenSaveDialogFrame extends JFrame {
	
	private BufferedImage image;
	private String filePath = new String();
	private JFileChooser fileChooser; 

	public OpenSaveDialogFrame(BufferedImage outputImage) {
		
		image = outputImage;
		initComponentsSave();
	}
	
	public OpenSaveDialogFrame() {
		initComponentsOpen();
	}
	
	public String getFilePath() {
		return filePath;
	}


	private void initComponentsSave() {
		fileChooser = new JFileChooser();
		fileChooser.setDialogTitle("Save as");
		
		int userSelection = fileChooser.showSaveDialog(this);
		if (userSelection == JFileChooser.APPROVE_OPTION) {
			File fileToSave = fileChooser.getSelectedFile();
			try {
				ImageIO.write(image, fileToSave.getPath().substring(fileToSave.getPath().lastIndexOf(".") + 1), fileToSave);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	private void initComponentsOpen() {
		fileChooser = new JFileChooser();
		fileChooser.setDialogTitle("Choose file");
		
		fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		int userSelection = fileChooser.showOpenDialog(this);
		if (userSelection == JFileChooser.APPROVE_OPTION) {
			File fileToOpen = fileChooser.getSelectedFile();
			
			filePath = fileToOpen.getAbsolutePath();
			}
	}
}
	

