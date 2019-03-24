package application;
	
import javafx.application.Application; 
import javafx.stage.Stage; 
import javafx.animation.KeyFrame; 
import javafx.animation.Timeline; 
import javafx.event.ActionEvent; 
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.util.Duration; 

public class Main extends Application { 
	
	@Override 
	public void start(Stage primaryStage) { 
		
		Clockness stopWatch = new Clockness();		
		ClockPane clock = new ClockPane(); // Create a clock // Create a handler for animation 
		EventHandler<ActionEvent> eventHandler = e -> { 
			clock.setCurrentTime(); // Set a new clock time
			}; 
			// Create an animation for a running clock 
			Timeline animation = new Timeline( new KeyFrame(Duration.millis(1000), eventHandler)); 
			animation.setCycleCount(Timeline.INDEFINITE); animation.play(); 
			// Start animation 
			stopWatch.create();
			BorderPane pane = new BorderPane();
		    pane.setCenter(clock);
		    pane.setBottom(stopWatch);
		    BorderPane.setAlignment(stopWatch, Pos.TOP_CENTER);
			
			Scene scene = new Scene(pane, 250, 400); primaryStage.setTitle("ClockAnimation"); 
			primaryStage.setScene(scene); 
			primaryStage.show();
	}
	public static void main(String[] args) {
		launch(args);
	}
}
