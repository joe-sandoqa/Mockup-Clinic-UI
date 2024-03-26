//Joe Sandoqa, CSE 360, HW4, 03/23/2024
package homework4;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import java.io.*;
import javafx.stage.Stage;

//import javafx.stage.Stage;

public class PatientIntake {
	private Stage mainStage;

    public PatientIntake(Stage mainStage) {
        this.mainStage = mainStage;
    }
	public Scene getScene() {
		//save button
		Button save = new Button();
	       save.setText("Save");
	       save.setLayoutX(380);
	       save.setLayoutY(190);
	       save.setPrefWidth(80);
	       save.setPrefHeight(40);
	       save.setStyle("-fx-alignment: center;-fx-background-color: #368BC1;");     
       //creation of texts
		Label greeting = new Label();
		greeting.setText("Patient Intake Form");
		greeting.setLayoutX(160);
		greeting.setLayoutY(10);
       Text firstText = new Text();
       firstText.setText("First Name:");        
       firstText.setLayoutX(20);
       firstText.setLayoutY(60);
       Text lastText = new Text();
       lastText.setText("Last Name:");        
       lastText.setLayoutX(20);
       lastText.setLayoutY(90);
       Text emailText = new Text();
       emailText.setText("Email:");        
       emailText.setLayoutX(20);
       emailText.setLayoutY(120);
       Text phoneText = new Text();
       phoneText.setText("Phone Number:");        
       phoneText.setLayoutX(20);
       phoneText.setLayoutY(150);
       Text history = new Text();
       history.setText("Health History:");        
       history.setLayoutX(20);
       history.setLayoutY(180);
       Text insurance = new Text();
       insurance.setText("Insurance ID:");        
       insurance.setLayoutX(20);
       insurance.setLayoutY(210);
       //Textfields for input 
       TextField firstField = new TextField();
       firstField.setLayoutX(120);
       firstField.setLayoutY(45);
       firstField.setPrefWidth(200);
       firstField.setPrefHeight(10);
       TextField lastField = new TextField();
       lastField.setLayoutX(120);
       lastField.setLayoutY(75);
       lastField.setPrefWidth(200);
       lastField.setPrefHeight(10);
       TextField emailField = new TextField();
       emailField.setLayoutX(120);
       emailField.setLayoutY(105);
       emailField.setPrefWidth(200);
       emailField.setPrefHeight(10);
       TextField phoneField = new TextField();
       phoneField.setLayoutX(120);
       phoneField.setLayoutY(135);
       phoneField.setPrefWidth(200);
       phoneField.setPrefHeight(10);
       TextField historyField = new TextField();
       historyField.setLayoutX(120);
       historyField.setLayoutY(165);
       historyField.setPrefWidth(200);
       historyField.setPrefHeight(10);
       TextField insuranceField = new TextField();
       insuranceField.setLayoutX(120);
       insuranceField.setLayoutY(195);
       insuranceField.setPrefWidth(200);
       insuranceField.setPrefHeight(10);
       //event handler     
       save.setOnAction(event -> {
    	    String firstName = firstField.getText();
    	    String lastName = lastField.getText();
    	    String email = emailField.getText();
    	    String phoneNumber = phoneField.getText();
    	    String historyS = historyField.getText();
    	    String insuranceS = insuranceField.getText();
    	    String patientID = makeID();
    	    String nameFile = patientID + "_PatientInfo.txt";
    	    // Writing to file all the info inputted by receptionist
    	    try {
    	        FileWriter fileWriter = new FileWriter(nameFile);
    	        PrintWriter printWriter = new PrintWriter(fileWriter);
    	        printWriter.println("Patient First Name: " + firstName);
    	        printWriter.println("Patient Last Name: " + lastName);
    	        printWriter.println("Patient Email: " + email);
    	        printWriter.println("Patient Phone Number: " + phoneNumber);
    	        printWriter.println("Patient Health History: " + historyS);
    	        printWriter.println("Patient Insurance ID: " + insuranceS);
    	        printWriter.close();
    	        System.out.println("All information is now saved");
    	    }catch(IOException e){
    	        System.out.println("Error");
    	        e.printStackTrace();
    	    }
    	    MainUI mainUI = new MainUI();
            mainUI.start(mainStage);
    	    });      
   //VBox to hold the  info
   Pane root = new Pane();
   root.getChildren().add(insurance);
   root.getChildren().add(emailText);
   root.getChildren().add(phoneText);
   root.getChildren().add(firstText);
   root.getChildren().add(lastText);
   root.getChildren().add(greeting);
   root.getChildren().add(history);
   root.getChildren().add(insuranceField);
   root.getChildren().add(phoneField);
   root.getChildren().add(firstField);
   root.getChildren().add(lastField);
   root.getChildren().add(historyField);
   root.getChildren().add(emailField);
   root.getChildren().add(save);  
   // Creating scene
   return new Scene(root, 500, 250);
   }
	private String makeID() { //creation of a random 5 digit ID
		int randomID = (int) (Math.random() * 99999);
		String ID = Integer.toString(randomID);
	    return ID;
}}