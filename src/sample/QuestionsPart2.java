package sample;

import javafx.beans.property.BooleanProperty;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Font;

import java.util.ArrayList;

public class QuestionsPart2{

    private String rightAnswer;
    private static int score2;
    
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

    static ArrayList<String> list2 =new ArrayList<>();


//Constructor

    public QuestionsPart2(String question, String choice1, String choice2, String choice3, FlowPane flowPane) {
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

    public static int getScore2() {
        return score2;
    }

    public static void setScore2(int score1) {
        QuestionsPart2.score2 = score1;
    }

    public static ArrayList<String> getList() {
        return list2;
    }

    public static void setList(ArrayList<String> list) {
        QuestionsPart2.list2 = list;
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
        label.setFont(new Font("Courier New bold",15));
        flowPane.getChildren().add(new Label());
        flowPane.getChildren().add(check1);
        flowPane.getChildren().add(check2);
        flowPane.getChildren().add(check3);
        flowPane.getChildren().add(new Label());
        check1.setPadding(new Insets(0,0,0,20));
        check2.setPadding(new Insets(0,0,0,20));
        check3.setPadding(new Insets(0,0,0,20));

    }


    public void toScore(){
        BooleanProperty checked1 =check1.selectedProperty();
        BooleanProperty checked2 =check2.selectedProperty();
        BooleanProperty checked3 =check3.selectedProperty();


        if (check1.isSelected()){
            list2.add(check1.getText());
            System.out.println(list2);
        }else
        if (check2.isSelected()){
            list2.add(check2.getText());
            System.out.println(list2);
        }else
        if (check3.isSelected()){
            list2.add(check3.getText());
            System.out.println(list2);
        }else {
            score2=0;
            System.out.println(score2);

        }


    }


    public void readAnswer(){
        if (list2.get(0).equals("c) .Class")){
            score2+=20;
            System.out.println(score2);
        }else {
            System.out.println(score2);
        }
        if (list2.get(1).equals("b) Bonjour Nous sommes en 2018 !")){
            score2+=20;
            System.out.println(score2);
        }else {
            System.out.println(score2);
        }
        if (list2.get(2).equals("b) vrai")){
            score2+=20;
            System.out.println(score2);
        }else {
            System.out.println(score2);
        }
        if (list2.get(3).equals("b) final")){
            score2+=20;
            System.out.println(score2);
        }else {
            System.out.println(score2);
        }
        if (list2.get(4).equals("b) this")){
            score2+=20;
            System.out.println(score2);
        }else {
            System.out.println(score2);
        }

    }




}
