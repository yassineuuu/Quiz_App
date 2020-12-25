package sample;

import javafx.geometry.Pos;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.FlowPane;

import java.util.ArrayList;

public class QuestionsPart1 extends Questions {

    private String rightAnswer;
    private static int score1;

    private ArrayList<String> answers1 = new ArrayList<>();

    public QuestionsPart1(String question, String choice1, String choice2, String choice3, FlowPane flowPane) {
        super(question, choice1, choice2, choice3, flowPane);
    }

    public String getRightAnswer() {
        return rightAnswer;
    }

    public void setRightAnswer(String rightAnswer) {
        this.rightAnswer = rightAnswer;
    }

    @Override
    public void constructQuestion() {

        ToggleGroup tgl = new ToggleGroup();

        Label label = new Label(getQuestion());
        RadioButton check1 = new RadioButton(getChoice1());
        RadioButton check2 = new RadioButton(getChoice2());
        RadioButton check3 = new RadioButton(getChoice3());

        check1.setToggleGroup(tgl);
        check2.setToggleGroup(tgl);
        check3.setToggleGroup(tgl);

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
        check1.setOnAction(a->{
             if (check1.isSelected()){
                answers1.add(check1.getText());
                System.out.println("Part1 Answers"+answers1);
                if (check1.getText().equals(rightAnswer)){
                     score1+= 20;
                    System.out.println(score1);
                }else if (!check1.getText().equals(rightAnswer)){
                    System.out.println(score1);
                }
            }else if (!check1.isSelected()){
                int in = answers1.indexOf(check1.getText());
                answers1.remove(in);
                System.out.println("Part1 Answers"+answers1);
                 if (check1.getText().equals(rightAnswer)){
                     score1-= 20;
                     System.out.println(score1);
                 }else if (!check1.getText().equals(rightAnswer)){
                     System.out.println(score1);
                 }
            }
        });
        check2.setOnAction(answer2->{
            if (check2.isSelected()){
                answers1.add(check2.getText());
                System.out.println("Part1 Answers"+answers1);
                if (check2.getText().equals(rightAnswer)){
                    score1 += 20;
                    System.out.println(score1);
                }else if (!check2.getText().equals(rightAnswer)){
                    System.out.println(score1);
                }
            }else if(!check1.isSelected()){
                int in = answers1.indexOf(check2.getText());
                answers1.remove(in);
                System.out.println("Part1 Answers"+answers1);
                if (check2.getText().equals(rightAnswer)){
                    score1 -= 20;
                    System.out.println(score1);
                }else if (!check2.getText().equals(rightAnswer)){
                    System.out.println(score1);
                }


            }
        });
        check3.setOnAction(answer3->{
            if (check3.isSelected()){
                answers1.add(check3.getText());
                System.out.println("Part1 Answers"+answers1);
                if (check3.getText().equals(rightAnswer)){
                    score1+= 20;
                    System.out.println(score1);
                }else if (!check3.getText().equals(rightAnswer)){
                    System.out.println(score1);
                }
            }else if (!check3.isSelected()){
                int in = answers1.indexOf(check3.getText());
                answers1.remove(in);
                System.out.println("Part1 Answers"+answers1);
                if (check3.getText().equals(rightAnswer)){
                    score1-= 20;
                    System.out.println(score1);
                }else if (!check3.getText().equals(rightAnswer)){
                    System.out.println(score1);
                }
            }
        });
    }
}
