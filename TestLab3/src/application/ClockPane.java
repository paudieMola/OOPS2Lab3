package application;
import javafx.scene.layout.Pane;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;


public class ClockPane extends Pane{
	
	private int hour;
	private int minute;
	private int second;
	private String day;
	private double w = 250, h = 250;
	
	public ClockPane()
	{
		setCurrentTime();
	}
	
	public void paintClock() {
		double clockRadius = Math.min(w, h) * 0.8 * 0.5;
		double centreX = w/2;
		double centreY = h/2;
		
		Circle circle = new Circle(centreX, centreY, clockRadius);
		circle.setFill(Color.WHITESMOKE);
		Text t1 = new Text(centreX + 42, centreY-76, "1");
		Text t2 = new Text(centreX+ 76, centreY-43, "2");
		Text t3 = new Text(centreX + clockRadius-10, centreY+3, "3");
		Text t4 = new Text(centreX+76, centreY+43, "4");
		Text t5 = new Text(centreX+46, centreY+80, "5");
		Text t6 = new Text(centreX -3, centreY+clockRadius -3, "6");
		Text t7 = new Text(centreX-46, centreY+86, "7");
		Text t8 = new Text(centreX-76, centreY+50, "8");
		Text t9 = new Text(centreX-clockRadius +3, centreY +5, "9");
		Text t10 = new Text(centreX- 82, centreY-43, "10");
		Text t11 = new Text(centreX - 46, centreY-76, "11");
		Text t12 = new Text(centreX -5, centreY-clockRadius+12, "12");
		
		double sLength = clockRadius*0.9;
		double secondX = centreX+sLength*Math.sin(second*(2*Math.PI/60));
		double secondY = centreY-sLength*Math.cos(second*(2*Math.PI/60));
		Line sLine = new Line (centreX, centreY, secondX, secondY);
		sLine.setStroke(Color.CYAN);
		
		double mLength = clockRadius*0.9;
		double xMinute = centreX+mLength*Math.sin(minute*(2*Math.PI/60));
		double yMinute = centreY-mLength*Math.cos(minute*(2*Math.PI/60));
		Line mLine = new Line (centreX, centreY, xMinute, yMinute);
		mLine.setStroke(Color.BLACK);
		
		double hLength = clockRadius*0.75;
		double hourX = centreX+hLength*Math.sin((hour%12 + minute/60)*(2*Math.PI/12));
		double hourY = centreY-hLength*Math.cos((hour%12 + minute/60)*(2*Math.PI/12));
		Line hLine = new Line(centreX, centreY, hourX, hourY);
		hLine.setStroke(Color.BLACK);
		
		int dayW = day.length()*2;
		Text dayDate = new Text(centreX - dayW, h,day);
		
		getChildren().clear();
		getChildren().addAll(circle, t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, sLine, mLine, hLine, dayDate);
		
	}

	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {
		this.hour = hour;
		paintClock();
	}

	public int getMinute() {
		return minute;
	}

	public void setMinute(int minute) {
		this.minute = minute;
		paintClock();
	}

	public int getSecond() {
		return second;
	}

	public void setSecond(int second) {
		this.second = second;
		paintClock();
	}

	public double getW() {
		return w;
	}

	public void setW(double w) {
		this.w = w;
		paintClock();
	}

	public double getH() {
		return h;
	}

	public void setH(double h) {
		this.h = h;
		paintClock();
	}
	
	public ClockPane(int hour, int minute, int second) {
		this.hour = hour;
		this.minute = minute;
		this.second = second;
		paintClock();
	}
	
	public void setCurrentTime() {
		Calendar calendar = new GregorianCalendar();
		this.hour = calendar.get(Calendar.HOUR);
		this.minute = calendar.get(Calendar.MINUTE);
		this.second = calendar.get(Calendar.SECOND);
		Date now = new Date();
		SimpleDateFormat dFormat = new SimpleDateFormat("EEEE, MMMM d, yyyy");
		this.day = dFormat.format(now);
		paintClock();
	}
}
