import java.awt.Color;
import java.awt.Graphics;

public class Diagram{
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
	public Diagram(){
		xlabel="";
		ylabel="";
		dlabel="";
		yscale=1;
		endsquares=false;
		dx=0;
		dy=40;
		
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
		}
		g.setColor(Color.black);
		g.drawLine(dx, dy+dheigth, dx+dwidth, dy+dheigth);
		g.drawLine(dx, dy, dx, dy+dheigth);
		g.drawString(ylabel, dx+10, dy+10);
		g.drawString(dlabel, dx+dwidth/2-4*dlabel.length()+4, dy+10);
		g.drawString(xlabel, dx+dwidth-10-4*xlabel.length(), dy+dheigth+20);
		
	}
	//Создание какой-то диаграммы. Стоит доделать под конкретную задачу
	public void setStandart(int columns, Color[] colors, float h[]) {
		this.columns = columns;
		this.colo = colors;
		this.h=h;
		this.dwidth = 360;
		this.cwidth = 24;
		this.dheigth = 150;
		this.yscale = 1;
		this.dx = 30;
		this.dy = 35;
		this.endsquares = false;
		this.endColor = new Color(50,50,50);
		this.xlabel = "";
		this.dlabel = "";
		this.ylabel = "";

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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
