//Joe Sandoqa, CSE 360, HW4, 03/23/2024
package homework4;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class CTScene {
	private Stage mainStage;

    public CTScene(Stage mainStage) {
        this.mainStage = mainStage;
    }
	public  Scene getScene() {
        
	     //creation of buttons
       Button save = new Button();
       save.setText("Save");
       save.setLayoutX(380);
       save.setLayoutY(190);
       save.setPrefWidth(80);
       save.setPrefHeight(40);
       save.setStyle("-fx-alignment: center;-fx-background-color: #368BC1;");
       
       //creation of texts
       Text patientID = new Text();
       patientID.setText("Patient ID:");        
       patientID.setLayoutX(20);
       patientID.setLayoutY(30);
       Text totalCAC = new Text();
       totalCAC.setText("The total Agatston CAC score");        
       totalCAC.setLayoutX(20);
       totalCAC.setLayoutY(60);
       Text vessel = new Text();
       vessel.setText("Vessel level Agatston CAC score");        
       vessel.setLayoutX(20);
       vessel.setLayoutY(80);
       Text lm = new Text();
       lm.setText("LM:");        
       lm.setLayoutX(40);
       lm.setLayoutY(110);
       Text LAD = new Text();
       LAD.setText("LAD:");        
       LAD.setLayoutX(40);
       LAD.setLayoutY(140);
       Text LCX = new Text();
       LCX.setText("LCX:");        
       LCX.setLayoutX(40);
       LCX.setLayoutY(170);
       Text RCA = new Text();
       RCA.setText("RCA:");        
       RCA.setLayoutX(40);
       RCA.setLayoutY(200);
       Text PDA = new Text();
       PDA.setText("PDA:");        
       PDA.setLayoutX(40);
       PDA.setLayoutY(230);
       //creation of textfields for input
       TextField patientText = new TextField();
       patientText.setLayoutX(200);
       patientText.setLayoutY(10);
       patientText.setPrefWidth(280);
       patientText.setPrefHeight(10);
       TextField totalText = new TextField();
       totalText.setLayoutX(200);
       totalText.setLayoutY(40);
       totalText.setPrefWidth(280);
       totalText.setPrefHeight(10);
       TextField LMtext = new TextField();
       LMtext.setLayoutX(80);
       LMtext.setLayoutY(90);
       LMtext.setPrefWidth(140);
       LMtext.setPrefHeight(10);
       TextField LADtext = new TextField();
       LADtext.setLayoutX(80);
       LADtext.setLayoutY(120);
       LADtext.setPrefWidth(140);
       LADtext.setPrefHeight(10);
       TextField LCXtext = new TextField();
       LCXtext.setLayoutX(80);
       LCXtext.setLayoutY(150);
       LCXtext.setPrefWidth(140);
       LCXtext.setPrefHeight(10);
       TextField RCAtext = new TextField();
       RCAtext.setLayoutX(80);
       RCAtext.setLayoutY(180);
       RCAtext.setPrefWidth(140);
       RCAtext.setPrefHeight(10);
       TextField PDAtext = new TextField();
       PDAtext.setLayoutX(80);
       PDAtext.setLayoutY(210);
       PDAtext.setPrefWidth(140);
       PDAtext.setPrefHeight(10);
     //event handlers      
       save.setOnAction(event -> {
   	    String LMdata = LMtext.getText();
   	    String LADdata = LADtext.getText();
   	    String LCXdata = LCXtext.getText();
   	    String RCAdata = RCAtext.getText();
   	    String PDAdata = PDAtext.getText();
   	    String totalData = totalText.getText();
   	    String patient = patientText.getText();
   	    String nameFile = patient + "CTResults.txt";
   	    // Writing to fill
   	    try {
   	        FileWriter fileWriter = new FileWriter(nameFile);
   	        PrintWriter printWriter = new PrintWriter(fileWriter);
   	        printWriter.println("Patient ID: " + patient);
   	        printWriter.println("Total Agtston CAC Score: " + totalData);
   	        printWriter.println("LM: " + LMdata);
   	        printWriter.println("LAD: " + LADdata);
   	        printWriter.println("LCX: " + LCXdata);
   	        printWriter.println("RCA: " + RCAdata);
   	        printWriter.println("PDA: " + PDAdata);
   	        printWriter.close();
   	        System.out.println("All information is now saved");
   	    }catch(IOException e){
   	        System.out.println("Error");
   	        e.printStackTrace();
   	    }
   	    MainUI mainUI = new MainUI();
           mainUI.start(mainStage);
   	    }); //will write all info that was inputted by the technician      
   //VBox to hold the  info
   Pane root = new Pane();
   root.getChildren().add(save);
   root.getChildren().add(PDA);
   root.getChildren().add(RCA);
   root.getChildren().add(LCX);
   root.getChildren().add(LAD);
   root.getChildren().add(lm);
   root.getChildren().add(vessel);
   root.getChildren().add(totalCAC);
   root.getChildren().add(patientID);
   root.getChildren().add(patientText);
   root.getChildren().add(totalText);
   root.getChildren().add(LMtext);
   root.getChildren().add(LADtext);
   root.getChildren().add(LCXtext);
   root.getChildren().add(RCAtext);
   root.getChildren().add(PDAtext);  
   // Create the scene with VBox as the root node
   return new Scene(root, 500, 250);
   }}