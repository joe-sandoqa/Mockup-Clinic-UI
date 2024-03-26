//Joe Sandoqa, CSE 360, HW4, 03/23/2024
//imports & package
package homework4;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;
import javafx.scene.control.Button;
import javafx.scene.text.*;

public class MainUI extends Application{
	 public static void main(String[] args) {
	        launch(args);
	    }  	 
    public void start(Stage stage) {
    	//title   
    	Font font = Font.font("Times New Roman", FontWeight.BOLD, 20);
    	Font font2 = Font.font("Times New Roman", FontWeight.BOLD, 12.5);
        stage.setTitle("Joe Sandoqa HW4 CSE 360");
        Button exit = new Button();
        exit.setText("Exit");
        exit.setLayoutX(450);
        exit.setLayoutY(210);
        exit.setPrefWidth(40);
        exit.setPrefHeight(20);
        exit.setStyle("-fx-alignment: center;-fx-background-color: #D6191C;");
        exit.setFont(font2);
        //creation of buttons
        Button patientView = new Button();
        patientView.setText("Patient View");       
        Button CT = new Button();
        CT.setText("CT Scan Tech View");       
        Button patientIntake = new Button();
        patientIntake.setText("Patient Intake");
        //positioning
        CT.setLayoutX(150);
        CT.setLayoutY(110);
        patientIntake.setLayoutX(150);
        patientIntake.setLayoutY(50);
        patientView.setLayoutX(150);
        patientView.setLayoutY(170);              
        //set width and height of buttons and their texts
        CT.setPrefWidth(200);
        CT.setPrefHeight(50);
        patientIntake.setPrefWidth(200);
        patientIntake.setPrefHeight(50);
        patientView.setPrefWidth(200);
        patientView.setPrefHeight(50);        
        //font
        CT.setStyle("-fx-alignment: center;-fx-background-color: #4261B7;");
        patientIntake.setStyle("-fx-alignment: center;-fx-background-color: #4261B7;");
        patientView.setStyle("-fx-alignment: center;-fx-background-color: #4261B7;");
        CT.setFont(font);
        patientIntake.setFont(font);
        patientView.setFont(font);           
        //creation of texts + changing locations
        Text title = new Text();
        title.setText("Welcome to Heart Health Imaging and Recording System");        
        title.setLayoutX(100);
        title.setLayoutY(20);
       //event handlers      
        CT.setOnAction(event -> {
            CTScene ctScene = new CTScene(stage);
            stage.setScene(ctScene.getScene());
        });

        patientView.setOnAction(event -> {
            PatientView patientViewScene = new PatientView(stage);
            stage.setScene(patientViewScene.askForID());
        });

        patientIntake.setOnAction(event -> {
            PatientIntake patientIntakeScene = new PatientIntake(stage);
            stage.setScene(patientIntakeScene.getScene());
        });
        
        exit.setOnAction(event -> {
            System.exit(0);
        });     
       ////////////////////////////////finishing up
       Pane root = new Pane();
       root.getChildren().add(patientView);
       root.getChildren().add(patientIntake);
       root.getChildren().add(CT);
       root.getChildren().add(title);
       root.getChildren().add(exit);
       stage.setScene(new Scene(root, 500, 250));
       stage.show();
}}