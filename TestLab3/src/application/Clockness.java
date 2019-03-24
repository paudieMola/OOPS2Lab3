package application;


import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

public class Clockness extends Pane{
	
	Button start = new Button("Start");
	Button stop = new Button("Stop");
    Button reset = new Button("Reset");
    TextField display = new TextField("00:00:00");
    private int second = 0;
    private int minute = 0;
    private int hour = 0;
    boolean notGoing = true;
    
    
    public void create() {
    	BorderPane pane = new BorderPane();
    	pane.setMinWidth(250);
    	display.setAlignment(Pos.CENTER);
		pane.setTop(display);
		pane.setCenter(start);
		pane.setRight(reset);
		pane.setLeft(stop);
		
		getChildren().addAll(pane);
		start.setOnAction(e -> startStopwatch());
		stop.setOnAction(e -> stopStopwatch());
		reset.setOnAction(e -> resetStopwatch());
    }
    
    
	private void resetStopwatch() {
		display.setText("00:00:00");
	}


	private void stopStopwatch() {
		notGoing = false;
	}


	private void startStopwatch() {
		
		while(!notGoing)
		{
    		start.setText("Stop");
    		EventHandler<ActionEvent> eventHandler = e -> { 
    			second++;
    			if (second == 60)
    	        {
    	            second = 0;
    	            minute++;
    	        }
    	        if (minute == 60)
    	         {
    	                minute = 0;
    	                hour++;
    	         }

    	        display.setText(this.toString()); 
    			}; 
    		
    		Timeline animation = new Timeline( new KeyFrame(Duration.millis(1000), eventHandler)); 
			animation.setCycleCount(Timeline.INDEFINITE); 
			animation.play(); 
			start.setOnAction(e -> {notGoing = false;});
		}
		
	}
    
    public String toString() {
		return this.hour+":"+this.minute+":"+this.second;
	}
}
