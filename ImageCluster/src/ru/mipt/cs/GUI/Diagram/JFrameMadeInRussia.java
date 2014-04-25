package ru.mipt.cs.GUI.Diagram;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.*;

import javax.imageio.ImageIO;
import javax.swing.*;
public class JFrameMadeInRussia {
   public static void main(String[] a) {
      MyJFrame f = new MyJFrame();
      f.setTitle("Диаграмма v1.1");
      f.setBounds(300,70,640,220);
      f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);      
      f.setVisible(true);
      
     JButton jb=new JButton();
     jb.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			
		}
	});
      
      
      
      
   }
   static class MyJFrame extends JFrame {
      public void paint(Graphics g) {
    	  //Создаём Данные из войда Нурии
    	  int n=9;
    	  Color[] colo=new Color[n];
    	  float h[]=new float[n];    	  
    	  for(int i=0;i<n;i++){  
    		  colo[i]=new Color(255/n*i, 127/n*i+40, 196*(n-i)/n);
    		  h[i]=50+10*i;
    		  
    	  }//Задаём параметры диаграммы диаграмму    	  
    	  Diagram d=new Diagram(n, colo, h);
    	  d.setLabels("Diagram", "X", "Y");
    	  d.setWhere(Diagram.BOT);
    	  d.setEndsquares(true);
    	  //Создаём картинку, в которую будет вставлена 
    	  BufferedImage dia=new BufferedImage(640,220,BufferedImage.TYPE_INT_RGB);
    	  Graphics s=dia.getGraphics();
    	  g.setColor(new Color(130,130,130));
    	  s.fillRect(0, 0, dia.getWidth(), dia.getHeight());
    	  //Помещаем диаграмму на изображение, а изображение на JFrame
    	  d.print(s);
    	  g.drawImage(dia, 0, 0, null);    	  
    	  //Сохраняем картинку в png
    	  try{
    		 File out=new File("saved.png");
    		 ImageIO.write(dia, "png", out);
    		  
    	  }catch(IOException e){
    		  
    		  System.err.println("File was not saved");
    	  }
    	  }
   }
  }

