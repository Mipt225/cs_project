package ru.mipt.cs.cluster.nuriyaFrames;

import javax.swing.*;

import ru.mipt.cs.cluster.io.ClusterisationInput;
import ru.mipt.cs.cluster.io.ClusterisationOutput;


//Frame displaying the image
public class ImageFrame extends JFrame {
	
	private ClusterisationInput input;
	private ClusterisationOutput output;
	
	public ImageFrame(ClusterisationInput input, ClusterisationOutput output) {
		this.input = input;
		this.output = output;
		
		initComponents();
	}
	
	private void initComponents() {
		
	}
}
