package sample;

import javafx.geometry.Pos;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;

import java.util.ArrayList;

public class QuestionsPart3 extends Questions{

    private ArrayList<String> answers3 = new ArrayList<>();
    
    public QuestionsPart3(String question, String choice1, String choice2, String choice3, FlowPane flowPane) {
        super(question, choice1, choice2, choice3, flowPane);
    }


    @Override
    public void constructQuestion() {
        Label label = new Label(getQuestion());
        CheckBox check1 = new CheckBox(getChoice1());
        CheckBox check2 = new CheckBox(getChoice2());
        CheckBox check3 = new CheckBox(getChoice3());

        getFlowPane().setAlignment(Pos.CENTER);


        //View
        getFlowPane().getChildren().add(label);
        getFlowPane().getChildren().add(new Label());
        getFlowPane().getChildren().add(check1);
        getFlowPane().getChildren().add(check2);
        getFlowPane().getChildren().add(check3);
        getFlowPane().getChildren().add(new Label());
        getFlowPane().getChildren().add(new Label());


        //Events
        check1.setOnAction(answer1->{
            if (check1.isSelected()){
                answers3.add(check1.getText());
                System.out.println("Part Answers"+answers3);
            }else {
                int in = answers3.indexOf(check1.getText());
                answers3.remove(in);
                System.out.println("Part Answers"+answers3);
            }
        });
        check2.setOnAction(answer2->{
            if (check2.isSelected()){
                answers3.add(check2.getText());
                System.out.println("Part Answers"+answers3);
            }else {
                int in = answers3.indexOf(check2.getText());
                answers3.remove(in);
                System.out.println("Part Answers"+answers3);
            }
        });
        check3.setOnAction(answer3->{
            if (check3.isSelected()){
                answers3.add(check3.getText());
                System.out.println("Part Answers"+answers3);
            }else {
                int in = answers3.indexOf(check3.getText());
                answers3.remove(in);
                System.out.println("Part Answers"+answers3);
            }
        });
    }
}
