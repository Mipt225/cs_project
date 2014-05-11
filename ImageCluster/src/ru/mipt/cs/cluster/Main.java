package ru.mipt.cs.cluster;

import javax.swing.JFrame;

import ru.mipt.cs.cluster.nuriyaFrames.FirstFrame;

public class Main {
	
	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				FirstFrame takeOne = new FirstFrame();
				takeOne.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				takeOne.setSize(400, 200);
				takeOne.setVisible(true);
			}
		});
	}


}

