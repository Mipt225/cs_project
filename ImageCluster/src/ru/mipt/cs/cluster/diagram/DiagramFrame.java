package ru.mipt.cs.cluster.diagram;

import java.awt.*;
import java.awt.image.BufferedImage;

import javax.swing.*;

import ru.mipt.cs.cluster.io.ClusterisationOutput;
import ru.mipt.cs.cluster.nuriyaFrames.OpenSaveDialogFrame;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DiagramFrame extends JFrame {
	
	private ClusterisationOutput output;
	private BufferedImage dia;
	private JPopupMenu popupMenu;
	private JMenuItem mntmSaveAs;
	
   public DiagramFrame (ClusterisationOutput output) {
	   
	   this.output = output;
	   initComponents();
   }
   
   private void initComponents() {
	   setTitle("Diagram");
	   setBounds(300,70,640,220);
	   setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);      
	   setVisible(true);
	   
	   popupMenu = new JPopupMenu();
	   addPopup(getContentPane(), popupMenu);
	   
	   mntmSaveAs = new JMenuItem("Save as");
	   popupMenu.add(mntmSaveAs);
	   mntmSaveAs.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				mntmSaveAsActionPerformed(evt);
			}
		});
	   
   }
   
   public void paint(Graphics g) {
	   
	   int n = output.getClusterColor().length;
	   Color[] colo = output.getClusterColor();
	   float[] h = new float[n];
	   int summ = 0;
	   for (int i = 0; i < n; i++) {
		   summ += output.getClusterDistribution()[i];
	   }
	   
	   for (int i = 0; i < n; i++) {
		   h[i] = output.getClusterDistribution()[i]*100/summ;
	   }
	   
	   Diagram d = new Diagram(n, colo, h);
 	   d.setLabels("Diagram", "cluster color", "percentage");
 	   d.setWhere(Diagram.BOT);
 	   d.setEndsquares(true);
 	  
 	   dia = new BufferedImage(640,220,BufferedImage.TYPE_INT_RGB);
 	   Graphics s = dia.getGraphics();
 	   g.setColor(new Color(130,130,130));
 	   s.fillRect(0, 0, dia.getWidth(), dia.getHeight());
 	  
 	   d.print(s);
 	   g.drawImage(dia, 0, 0, null);    	  
 	  
   }
	   
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
	
	private void mntmSaveAsActionPerformed(java.awt.event.ActionEvent evt) {
		
		JFrame saveFrame = new OpenSaveDialogFrame(dia);
		saveFrame.dispose();
	}
	
}