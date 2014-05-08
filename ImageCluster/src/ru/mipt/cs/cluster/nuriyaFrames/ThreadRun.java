package ru.mipt.cs.cluster.nuriyaFrames;

import java.io.IOException;

import javax.swing.JFrame;

import ru.mipt.cs.cluster.io.ClusterisationInput;
import ru.mipt.cs.cluster.io.ClusterisationOutput;
import ru.mipt.cs.cluster.kmeans.KMeans;

//Thread for KMeans clustering
public class ThreadRun extends Thread {
	
	private Thread t;
	
	private ClusterisationInput input;
	private ClusterisationOutput output;
	
	public ThreadRun (ClusterisationInput input) {
		this.input = input;
	}
	
	public ClusterisationOutput getOutput() {
		return output;
	}

	public void setOutput(ClusterisationOutput output) {
		this.output = output;
	}

	public void run() {
		
		KMeans kmeans = new KMeans();
		try {
			setOutput(kmeans.calculate(input));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		JFrame frame = new ImageFrame(input, output);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.setSize(600, 300);
		frame.setLocation(400, 100);
		
		frame.setVisible(true);
	}
	
	public void start ()
	   {
	      if (t == null)
	      {
	         t = new Thread (this);
	         t.start ();
	      }
	   }

}
