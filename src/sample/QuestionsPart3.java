package sample;

import javafx.beans.property.BooleanProperty;
import javafx.geometry.Pos;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.FlowPane;

import java.util.ArrayList;

public class QuestionsPart3{

    private String rightAnswer;
    private static int score3;

    private String question;
    private String choice1;
    private String choice2;
    private String choice3;


    private FlowPane flowPane;

    private ToggleGroup tgl = new ToggleGroup();

    private Label label = new Label();
    private RadioButton check1 = new RadioButton();
    private RadioButton check2 = new RadioButton();
    private RadioButton check3 = new RadioButton();

    static ArrayList<String> list3 =new ArrayList<>();


//Constructor

    public QuestionsPart3(String question, String choice1, String choice2, String choice3, FlowPane flowPane) {
        this.question = question;
        this.choice1 = choice1;
        this.choice2 = choice2;
        this.choice3 = choice3;
        this.flowPane = flowPane;
    }

    //Get/Set

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

    public ToggleGroup getTgl() {
        return tgl;
    }

    public void setTgl(ToggleGroup tgl) {
        this.tgl = tgl;
    }

    public Label getLabel() {
        return label;
    }

    public void setLabel(Label label) {
        this.label = label;
    }

    public RadioButton getCheck1() {
        return check1;
    }

    public void setCheck1(RadioButton check1) {
        this.check1 = check1;
    }

    public RadioButton getCheck2() {
        return check2;
    }

    public void setCheck2(RadioButton check2) {
        this.check2 = check2;
    }

    public RadioButton getCheck3() {
        return check3;
    }

    public void setCheck3(RadioButton check3) {
        this.check3 = check3;
    }

    public String getRightAnswer() {
        return rightAnswer;
    }

    public void setRightAnswer(String rightAnswer) {
        this.rightAnswer = rightAnswer;
    }

    public static int getScore3() {
        return score3;
    }

    public static void setScore3(int score1) {
        QuestionsPart3.score3 = score1;
    }

    public static ArrayList<String> getList() {
        return list3;
    }

    public static void setList(ArrayList<String> list) {
        QuestionsPart3.list3 = list;
    }
//methodes



    public void constructQuestion() {

//set the texts
        label.setText(question);
        check1.setText(choice1);
        check2.setText(choice2);
        check3.setText(choice3);

//Toggle groupe
        check1.setToggleGroup(tgl);
        check2.setToggleGroup(tgl);
        check3.setToggleGroup(tgl);


//View
        //Center the FlowPane
        getFlowPane().setAlignment(Pos.CENTER);

        //fill the FlowPane
        flowPane.getChildren().add(label);
        flowPane.getChildren().add(new Label());
        flowPane.getChildren().add(check1);
        flowPane.getChildren().add(check2);
        flowPane.getChildren().add(check3);
        flowPane.getChildren().add(new Label());
        flowPane.getChildren().add(new Label());
    }


    public void toScore(){
        BooleanProperty checked1 =check1.selectedProperty();
        BooleanProperty checked2 =check2.selectedProperty();
        BooleanProperty checked3 =check3.selectedProperty();


        if (check1.isSelected()){
            list3.add(check1.getText());
            System.out.println(list3);
        }else
        if (check2.isSelected()){
            list3.add(check2.getText());
            System.out.println(list3);
        }else
        if (check3.isSelected()){
            list3.add(check3.getText());
            System.out.println(list3);
        }else {
            score3=0;
            System.out.println(score3);

        }


    }


    public void readAnswer(){
        if (list3.get(0).equals("b) surchargée")){
            score3+=20;
            System.out.println(score3);
        }else {
            System.out.println(score3);
        }
        if (list3.get(1).equals("a) vrai")){
            score3+=20;
            System.out.println(score3);
        }else {
            System.out.println(score3);
        }
        if (list3.get(2).equals("b) faux")){
            score3+=20;
            System.out.println(score3);
        }else {
            System.out.println(score3);
        }
        if (list3.get(3).equals("a) vrai")){
            score3+=20;
            System.out.println(score3);
        }else {
            System.out.println(score3);
        }
        if (list3.get(4).equals("b) a=10\n" + "b=0\n" + "Je suis à l’intérieur de finally")){
            score3+=20;
            System.out.println(score3);
        }else {
            System.out.println(score3);
        }

    }



}
