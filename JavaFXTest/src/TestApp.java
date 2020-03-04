///////////////////////////////////////////
//  THIS IS A TEST APPLICATION TO VERIFY
//  THAT YOUR JAVAFX ENVIRONMENT WORKS IN
//  ECLIPSE.  IF YOU SEE COMPILER ERRORS 
//  IN THIS FILE OR CANNOT RUN THIS PROGRAM
//  PLEASE SEE ONE OF THE COURSE STAFF 
//  MEMBERS TO HELP YOU RESOLVE ECLIPSE
//  SETUP ISSUES.
///////////////////////////////////////////

import javafx.application.Application;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class TestApp extends Application
{
	@Override
	public void start(Stage theStage) throws Exception
	{
		// TODO Auto-generated method stub
		
		Pane theCanvas = new Pane();
		theCanvas.setStyle("-fx-background-color: white;");
		Scene scene = new Scene(theCanvas, 300, 200, Color.WHITE);
		scene.setCursor(Cursor.NONE);
		
		//Now open the GUI
		theStage.setTitle("CS2 JavaFX Test");
		theStage.setScene(scene);
		theStage.show();
		
		Text t = new Text(10, 100, "JavaFX WORKS!");
		t.setFont(Font.font("Verdana", 34));
		t.setFill(Color.GREEN);
		theCanvas.getChildren().add(t);
	}

	/**
	 * Skeleton main method as required for launching a JavaFX application.
	 * 
	 * @param args Not used.
	 */
	public static void main(String[] args)
	{
		launch(args);
	}

}
