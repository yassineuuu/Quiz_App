package sample;

import javafx.geometry.Pos;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;

import java.util.ArrayList;

public class QuestionsPart2 extends Questions{

    private ArrayList<String> answers2 = new ArrayList<>();
    
    public QuestionsPart2(String question, String choice1, String choice2, String choice3, FlowPane flowPane) {
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
                answers2.add(check1.getText());
                System.out.println("Part2 Answers"+answers2);
            }else {
                int in = answers2.indexOf(check1.getText());
                answers2.remove(in);
                System.out.println("Part2 Answers"+answers2);
            }
        });
        check2.setOnAction(answer2->{
            if (check2.isSelected()){
                answers2.add(check2.getText());
                System.out.println("Part2 Answers"+answers2);
            }else {
                int in = answers2.indexOf(check2.getText());
                answers2.remove(in);
                System.out.println("Part2 Answers"+answers2);
            }
        });
        check3.setOnAction(answer3->{
            if (check3.isSelected()){
                answers2.add(check3.getText());
                System.out.println("Part2 Answers"+answers2);
            }else {
                int in = answers2.indexOf(check3.getText());
                answers2.remove(in);
                System.out.println("Part2 Answers"+answers2);
            }
        });
    }
}
