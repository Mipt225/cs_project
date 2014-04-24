import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

public class ImageViewer{
	public static void main(String[] args){
		JFrame frame = new ImageViewerFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.show();
	}
}


class ImageViewerFrame extends JFrame {
	private JLabel label;
	private JFileChooser chooser;
	private static final int DEFAULT_WIDTH = 300;
	private static final int DEFAULT_HEIGHT = 400;
	
	public ImageViewerFrame(){
		setTitle("Image Viewer");
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);// To display the image use the label 
		label = new JLabel();//Introduced as a hidden field.
		Container contentPane = getContentPane();
		contentPane.add(label);// Installation dialog to select files.
		chooser = new JFileChooser();  //Introduced as a hidden field.
		chooser.setCurrentDirectory(new File (".."));// Set the menu bar.
		MenuBar menuBar = new MenuBar();
		setMenuBar(menuBar);
		Menu menu = new Menu("File");
		menuBar.add(menu);
		MenuItem openltem = new MenuItem("Open");
		menu.add(openltem);
		openltem.addActionListener(new ActionListener(){
					public void actionPerformed (ActionEvent event){
						//Display a file selection dialog
						int r = chooser.showOpenDialog(null);
						// If a file is selected, make it an icon.
						if (r == JFileChooser.APPROVE_OPTION){
							String name = chooser.getSelectedFile().getPath();
						label.setIcon(new ImageIcon(name));
						}
					}
		} );

		MenuItem exitltem = new MenuItem("Exit");
		menu.add(exitltem);
		exitltem.addActionListener(new ActionListener(){
			public void actionPerformed (ActionEvent event) {
				System.exit(0) ;
			}
		});
	}
}
