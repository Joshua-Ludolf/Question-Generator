/**
        Name: Joshua Ludolf
        Date: 05/2022
  -----------------------------------------------------------

 */

package com.example.csci_1437_javafx;

// All the imports need to create these objects in the RandomQuestions class

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;



//  The main class that makes this program work

public class RandomQuestions extends Application {
    /*
    These are the two randomly generated numbers, but I declare them here as they need to be in the outer scope to be used by the
    events (the event handlers)
     */
    private int num1 = 0;
    private int num2 = 0;

    //This method actually launches the window so the GUI is intractable through java
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

//        This part is where I started creating the pane and adding in the nodes...

        Button getQuestion = new Button("Get Question");

        TextField textBox1 = new TextField();

        Text addition = new Text("+");

        TextField textBox2 = new TextField();

        Text equal = new Text("=");

        TextField userGuess = new TextField();

        FlowPane main1 = new FlowPane();

        main1.setHgap(5);
        main1.setVgap(25);

        main1.getChildren().addAll(getQuestion,textBox1, addition, textBox2, equal, userGuess);

        Button checkAnswer = new Button("Check Answer");

        main1.setAlignment(Pos.CENTER);

        main1.getChildren().add(checkAnswer);

        Text solution = new Text();

        main1.getChildren().add(solution);

//       This is the event handler for Getting Questions Button

        getQuestion.setOnAction(actionEvent -> {
            if(!(userGuess.getText().equals(""))){
                userGuess.setText("");
            }
            if(!(solution.getText().equals(""))){
                solution.setText("");
            }
            num1 = (int) (Math.random() * 101);
                num2 = (int) (Math.random() * 101);
                textBox1.setText("" + num1);
                textBox2.setText("" + num2);
        });

//        This is the event handler for Check Answer Button

        checkAnswer.setOnAction(actionEvent -> {
            int num4 = Integer.parseInt(userGuess.getText());
            if (num4 == (num1 + num2)) {
                solution.setText("Correct");
            }
             else {
                solution.setText("Incorrect");
            }
        });

//        This is where we put the pane into the scene, and then the scene into the stage, also where I name and show the window

            Scene mainScene = new Scene(main1, 600, 75);
            primaryStage.setTitle("Random Questions");
            primaryStage.setScene(mainScene);
            primaryStage.show();
        }
}
