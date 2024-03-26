//Joe Sandoqa, CSE 360, HW4, 03/23/2024
package homework4;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.control.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.io.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;



public class PatientView {
	private Stage mainStage;

    public PatientView(Stage mainStage) {
        this.mainStage = mainStage;
    }
    
    public Scene askForID() {
    	
    	Label greeting = new Label();
		greeting.setText("Enter Patient ID here: ");
		greeting.setLayoutX(10);
		greeting.setLayoutY(10);
		
		TextField id = new TextField();
		id.setLayoutX(150);
		id.setLayoutY(5);
		
		Button enter = new Button();
		enter.setText("Enter");
		enter.setLayoutX(325);
		enter.setLayoutY(5);
		enter.setPrefWidth(60);
		enter.setPrefHeight(15);
		enter.setStyle("-fx-alignment: center;-fx-background-color: #368BC1;");
		
		enter.setOnAction(event -> {
	   	    
			mainStage.setScene(getScene(id.getText())); //on press for entering patientID you go to main UI
	   	    });
		
    	Pane root = new Pane();
    	 root.getChildren().add(greeting);
    	   root.getChildren().add(id);
    	   root.getChildren().add(enter);
    	  
    	   // Create the scene with VBox as the root node
    	   return new Scene(root, 400, 50);
    }
    

	public Scene getScene(String x) { //mainUI
        //variable
		String patientNumber = x;
        String totalCAC = "";
        String LM = "";
        String LAD = "";
        String LCX = "";
        String RCA = "";
        String PDA = "";
        File directory = new File("."); //curr dir
        File[] files = directory.listFiles();
        String patientName = "";      
        //Code is used to read and parse the text files created by CT and Intake and intialize variables
        for(File file : files) {
            if (file.isFile() && file.getName().startsWith(patientNumber) && file.getName().endsWith("_PatientInfo.txt")) {               
                try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                    String line;                   
                    if ((line = br.readLine()) != null) {                   
                        patientName = line.split(":")[1].trim();
                        break;
                    }}catch(IOException e){
                    e.printStackTrace();
                }}}
        for (File file : files) {
            if (file.isFile() && file.getName().startsWith(patientNumber) && file.getName().endsWith("CTResults.txt")) {           
                try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                    String line;                   
                    while ((line = br.readLine()) != null) {
                        if (line.startsWith("Total Agtston CAC Score")) {
                            totalCAC = line.split(":")[1].trim();
                        }else if(line.startsWith("LM")){
                            LM = line.split(":")[1].trim();
                        }else if(line.startsWith("LAD")){
                            LAD = line.split(":")[1].trim();
                        }else if(line.startsWith("LCX")){
                            LCX = line.split(":")[1].trim();
                        }else if(line.startsWith("RCA")){
                            RCA = line.split(":")[1].trim();
                        }else if(line.startsWith("PDA")){
                            PDA = line.split(":")[1].trim();
                        }}
                }catch(IOException e){
                    e.printStackTrace();
                }}}
		//Done button that will return to Main UI
		Button done = new Button();
		done.setText("Done");
		done.setLayoutX(380);
		done.setLayoutY(190);
		done.setPrefWidth(80);
		done.setPrefHeight(40);
		done.setStyle("-fx-alignment: center;-fx-background-color: #368BC1;");     
      
       //creation of texts and formatting
		Label greeting = new Label();
		Font font = Font.font("Times New Roman", FontWeight.BOLD, 20);
		greeting.setText(String.format("Hello %s", patientName));
		greeting.setFont(font);
		greeting.setLayoutX(190);
		greeting.setLayoutY(10);
       Text totalLabel = new Text();
       totalLabel.setText("The total Agatston CAC score:");        
       totalLabel.setLayoutX(20);
       totalLabel.setLayoutY(60);
       Text lm = new Text();
       lm.setText("LM:");        
       lm.setLayoutX(40);
       lm.setLayoutY(110);
       Text lad = new Text();
       lad.setText("LAD:");        
       lad.setLayoutX(40);
       lad.setLayoutY(140);
       Text lcx = new Text();
       lcx.setText("LCX:");        
       lcx.setLayoutX(40);
       lcx.setLayoutY(170);
       Text rca = new Text();
       rca.setText("RCA:");        
       rca.setLayoutX(40);
       rca.setLayoutY(200);
       Text pda = new Text();
       pda.setText("PDA:");        
       pda.setLayoutX(40);
       pda.setLayoutY(230);  
       Text totalText = new Text(totalCAC);     
       totalText.setLayoutX(200);
       totalText.setLayoutY(60);      
       Text LADtext = new Text(LAD);
       LADtext.setLayoutX(80);
       LADtext.setLayoutY(140);
       Text LCXtext = new Text(LCX);
       LCXtext.setLayoutX(80);
       LCXtext.setLayoutY(170);
       Text RCAtext = new Text(RCA);
       RCAtext.setLayoutX(80);
       RCAtext.setLayoutY(200);
       Text PDAtext = new Text(PDA);
       PDAtext.setLayoutX(80);
       PDAtext.setLayoutY(230);
       Text LMtext = new Text(LM);
       LMtext.setLayoutX(80);
       LMtext.setLayoutY(110);
       
     //rectangle for borders
       Rectangle rect1 = new Rectangle();
       rect1.setFill(null); 
       rect1.setStroke(Color.BLACK);
       rect1.setStrokeWidth(2);
       rect1.setLayoutX(190);
       rect1.setLayoutY(45);
       rect1.setWidth(200);
       rect1.setHeight(20);
       Rectangle rect2 = new Rectangle();
       rect2.setFill(null);
       rect2.setStroke(Color.BLACK);
       rect2.setStrokeWidth(2);
       rect2.setLayoutX(75);
       rect2.setLayoutY(125);
       rect2.setWidth(200);
       rect2.setHeight(20);
       Rectangle rect3 = new Rectangle();
       rect3.setFill(null);
       rect3.setStroke(Color.BLACK);
       rect3.setStrokeWidth(2);
       rect3.setLayoutX(75);
       rect3.setLayoutY(95);
       rect3.setWidth(200); 
       rect3.setHeight(20);
       Rectangle rect4 = new Rectangle();
       rect4.setFill(null);
       rect4.setStroke(Color.BLACK);
       rect4.setStrokeWidth(2);
       rect4.setLayoutX(75);
       rect4.setLayoutY(155);
       rect4.setWidth(200); 
       rect4.setHeight(20);
       Rectangle rect5 = new Rectangle();
       rect5.setFill(null);
       rect5.setStroke(Color.BLACK);
       rect5.setStrokeWidth(2); 
       rect5.setLayoutX(75);
       rect5.setLayoutY(185);
       rect5.setWidth(200);
       rect5.setHeight(20);
       Rectangle rect6 = new Rectangle();
       rect6.setFill(null);
       rect6.setStroke(Color.BLACK); 
       rect6.setStrokeWidth(2);
       rect6.setLayoutX(75);
       rect6.setLayoutY(215);
       rect6.setWidth(200);
       rect6.setHeight(20);

     //event handlers
       done.setOnAction(event -> {
   	    
   	    MainUI mainUI = new MainUI();
           mainUI.start(mainStage); //go back to mainUI
   	    });      
      
   //VBox to hold the  info
   Pane root = new Pane();
   root.getChildren().add(pda);
   root.getChildren().add(rca);
   root.getChildren().add(lcx);
   root.getChildren().add(lad);
   root.getChildren().add(lm);
   root.getChildren().add(greeting);
   root.getChildren().add(totalLabel);
   root.getChildren().add(done);
   root.getChildren().add(totalText);
   root.getChildren().add(LMtext);
   root.getChildren().add(LADtext);
   root.getChildren().add(LCXtext);
   root.getChildren().add(RCAtext);
   root.getChildren().add(PDAtext);  
   root.getChildren().add(rect1);
   root.getChildren().add(rect2);
   root.getChildren().add(rect3);
   root.getChildren().add(rect4);
   root.getChildren().add(rect5);
   root.getChildren().add(rect6);
   // Create the scene with VBox as the root node
   return new Scene(root, 500, 250);
   }}