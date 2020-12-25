package sample;

import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;

import java.util.ArrayList;

public class Questions {
//Variables
    private String question;
    private String choice1;
    private String choice2;
    private String choice3;


    private static int score;

    private FlowPane flowPane= new FlowPane(Orientation.VERTICAL);


//Constructor

    public Questions(String question, String choice1, String choice2, String choice3, FlowPane flowPane) {
        this.question = question;
        this.choice1 = choice1;
        this.choice2 = choice2;
        this.choice3 = choice3;
        this.flowPane=flowPane;
    }

//Getters/Setters

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getChoice1() {
        return choice1;
    }

    public void setChoice1(String choice1) {
        this.choice1 = choice1;
    }

    public String getChoice2() {
        return choice2;
    }

    public void setChoice2(String choice2) {
        this.choice2 = choice2;
    }

    public String getChoice3() {
        return choice3;
    }

    public void setChoice3(String choice3) {
        this.choice3 = choice3;
    }

    public FlowPane getFlowPane() {
        return flowPane;
    }

    public void setFlowPane(FlowPane flowPane) {
        this.flowPane = flowPane;
    }

    public static int getScore() {
        return score;
    }

    public static void setScore(int score) {
        Questions.score = score;
    }

    //Methods
    public void constructQuestion(){
        //elements

        Label label = new Label(question);
        CheckBox check1 = new CheckBox(choice1);
        CheckBox check2 = new CheckBox(choice2);
        CheckBox check3 = new CheckBox(choice3);

        flowPane.setAlignment(Pos.CENTER);


        //View
        flowPane.getChildren().add(label);
        flowPane.getChildren().add(new Label());
        flowPane.getChildren().add(check1);
        flowPane.getChildren().add(check2);
        flowPane.getChildren().add(check3);
        flowPane.getChildren().add(new Label());
        flowPane.getChildren().add(new Label());



    }
}
