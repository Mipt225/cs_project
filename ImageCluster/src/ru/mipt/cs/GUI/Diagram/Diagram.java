package ru.mipt.cs.GUI.Diagram;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class Diagram{
	public final static int TOP=0;
	public final static int MID=1;
	public final static int BOT=2;
	
	
	protected int columns;
	protected int dwidth;
	protected int cwidth;
	protected int dheigth;
	protected int dx;
	protected int dy;
	protected float yscale;
	protected Color[] colo;
	protected float h[];
	protected boolean endsquares;
	protected String ylabel,dlabel,xlabel;
	protected Color endColor;
	protected boolean legend;
	protected int where;
	protected boolean percents;
	protected Font labelsFont;
	protected Font columnFont;
	public Diagram(int columns, Color[] colors, float h[]){
		this.columns = columns;
		this.colo = colors;
		this.h = h;
		this.dwidth = 570;
		this.cwidth = 32;
		this.dheigth = 150;
		this.yscale = 1;
		this.dx = 30;
		this.dy = 35;
		this.endsquares = false;
		this.endColor = new Color(50,50,50);
		this.setColumnFont(new Font("Arial", 0, 10));
		this.where=Diagram.TOP;
		this.legend = true;
		this.percents = true;
		this.setLabelsFont(new Font("Arial", Font.BOLD, 12));
		this.xlabel = "";
		this.dlabel = "";
		this.ylabel = "";			
	}
	//Основной метод, печатающий матрицу с помощью Graphics g
	void print(Graphics g) {
		for (int i = 0; i < columns; i++) {
			g.setColor(colo[i]);
			g.fillRect(
					dx+((dwidth / columns) * (2 * i + 1)) / 2 - cwidth / 2,
					(int) (-h[i] * yscale + dheigth+dy), 
					cwidth,
					(int) (h[i] * yscale));
			if(endsquares==true){
				g.setColor(endColor);
				g.fillRect(
						dx+((dwidth / columns) * (2 * i + 1)) / 2 - cwidth / 2,
						(int) (-h[i] * yscale + dheigth+dy), 
						cwidth,
						(int) ((h[i]*yscale<cwidth)?(h[i] * yscale):cwidth) );
				
			}
			g.setFont(columnFont);
			g.setColor(Color.BLACK);
			if(legend==true){
				switch (where){
					case 1:{//MID
						g.drawString(Float.toString(h[i])+((percents==true)? "%":""), 
							(int)(dx+(dwidth / columns)*(2*i+1)/2 - cwidth / 2),
							(int) (-h[i] / 2 * yscale + 3 + dheigth+dy+ ((endsquares==true)?cwidth/2:0)) ) ;break;}
					case 2:{//BOT
						g.drawString(Float.toString(h[i])+((percents==true)? "%":""), 
							(int)(dx+(dwidth / columns)*(2*i+1)/2 - cwidth / 2),
							(int) (13 + dheigth+dy)) ;break;}
					default:{//TOP
						g.drawString(Float.toString(h[i])+((percents==true)? "%":""), 
							(int)(dx+(dwidth / columns)*(2*i+1)/2 - cwidth / 2),
							(int) (-h[i] * yscale - 4 + dheigth+dy)) ;break;}	
				}
			}
			
			
		}
		g.setFont(labelsFont);
		g.setColor(Color.black);
		g.drawLine(dx, dy+dheigth, dx+dwidth, dy+dheigth);
		g.drawLine(dx, dy, dx, dy+dheigth);
		g.drawString(ylabel, dx+10, dy+10);
		g.drawString(dlabel, dx+dwidth/2-4*dlabel.length()+4, dy+10);
		g.drawString(xlabel, dx+dwidth-10-4*xlabel.length(), dy+dheigth+20);
		
	}
	//Число столбцов
	public void setColumns(int columns) {
		this.columns = columns;
	}
	//Изменение размеров диаграммы
	public void setDSize(int dwidth, int dheigth) {
		this.dwidth = dwidth;
	}
	//Изменение размеров колонок
	public void setCSize(int cwidth, float[] h) {
		this.cwidth = cwidth;
		this.h=h;
	}
	//Изменение смещения диаграммы относительтно угла изображения или JFrame
	public void setDOffset(int dx, int dy) {
		this.dx = dx;
		this.dy = dy;
	}
	//Позволяет выражать высоту столбцов не в пикселах. Больше yscale-больше столбцы
	public void setYscale(float yscale) {
		this.yscale = yscale;
	}
	//Определяет цвета колонок
	public void setColors(Color[] colo) {
		this.colo = colo;
	}
	//Add labels to each column
	public void setLegend(boolean legend){
		this.legend=legend;
	}
	//Add "%" to labels
	public void setPercents(boolean percents){
		this.percents=percents;
		
		
	}
	//where to draw labels
	public void setWhere(int where){
		this.where=where;		
	}
	//Позволяет отметить вершины столбцов квадратными метками для пущей красоты
	public void setEndsquares(boolean endsquares) {
		this.endsquares = endsquares;
	}
	public void setEndColor(Color endColor){
		this.endColor=endColor;
	}
	//Добавляет подписи к диаграмме и осям
	public void setLabels(String dlabel, String xlabel, String ylabel) {
		this.dlabel = dlabel;
		this.xlabel = xlabel;
		this.ylabel = ylabel;
	}
	public void setLabelsFont(Font labelsFont) {
		this.labelsFont = labelsFont;
	}
	public void setColumnFont(Font columnFont) {
		this.columnFont = columnFont;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
