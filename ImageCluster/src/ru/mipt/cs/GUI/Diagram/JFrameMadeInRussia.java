import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;

import javax.imageio.ImageIO;
import javax.swing.*;
public class JFrameMadeInRussia {
   public static void main(String[] a) {
      MyJFrame f = new MyJFrame();
      f.setTitle("��������� v1.0");
      f.setBounds(300,70,440,220);
      f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      f.setVisible(true);
   }
   static class MyJFrame extends JFrame {
      public void paint(Graphics g) {
    	  //������ ������ �� ����� �����
    	  int n=9;
    	  Color[] colo=new Color[n];
    	  float h[]=new float[n];    	  
    	  for(int i=0;i<n;i++){  
    		  colo[i]=new Color(255/n*i, 127/n*i+40, 196*(n-i)/n);
    		  h[i]=50+10*i;
    		  
    	  }//����� ��������� ��������� ���������    	  
    	  Diagram d=new Diagram();
    	  d.setStandart(n, colo, h);
    	  d.setLabels("Diagram", "X", "Y");
    	  d.setEndsquares(true);
    	  //������ ��������, � ������� ����� ��������� 
    	  BufferedImage dia=new BufferedImage(440,220,BufferedImage.TYPE_INT_RGB);
    	  Graphics s=dia.getGraphics();
    	  g.setColor(new Color(130,130,130));
    	  s.fillRect(0, 0, dia.getWidth(), dia.getHeight());
    	  //�������� ��������� �� �����������, � ����������� �� JFrame
    	  d.print(s);
    	  g.drawImage(dia, 0, 0, null);    	  
    	  //��������� �������� � png
    	  try{
    		 File out=new File("saved.png");
    		 ImageIO.write(dia, "png", out);
    		  
    	  }catch(IOException e){
    		  
    		  System.err.println("File was not saved");
    	  }
    	  }
   }
  }

