package sample;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicInteger;

public class Main extends Application {
    Timer timer = new Timer();
    HBox timeBox = new HBox();
    TimerTask task;

    int secondPassed = 300;
    Label timeLabel = new Label();

    public void start(){
        timer.scheduleAtFixedRate(task,0,1000);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));

        //Controller ctrl = new Controller();
        //BorderPane
        BorderPane root = new BorderPane();
        primaryStage.setTitle("JAVA Quiz");
        primaryStage.setScene(new Scene(root, 1800, 900));
        primaryStage.show();
        primaryStage.onCloseRequestProperty();
        root.setStyle("-fx-background-color:rgb(148, 156, 223)");

        //Top Border
        HBox Top = new HBox();
        Top.setAlignment(Pos.CENTER);
        root.setTop(Top);
        Top.setPadding(new Insets(20, 5, 10, 0));

        //Center Border
        GridPane Center = new GridPane();
        Center.setAlignment(Pos.CENTER);
        root.setCenter(Center);

        //Bottom Border
        HBox Bottom = new HBox();
        Bottom.setAlignment(Pos.CENTER);
        root.setBottom(Bottom);



        //1st page label
        Label greeting =new Label("Ready to take the Java Quiz ?");

        Center.add(greeting,0,0);
        greeting.setFont(new Font("Courier New bold",19));
        greeting.setPadding(new Insets(0,0,20,50));

        //Image
        Image image = new Image(getClass().getResource("img/java.gif").toString());
        ImageView iv1 = new ImageView(image);
        Center.add(iv1, 0,1);



        HBox center2 = new HBox();
        center2.setAlignment(Pos.CENTER);
        center2.setPadding(new Insets(50, 0, 0, 0));

//1st page Button
        Button btn1 = new Button("Start The Quiz");
        Center.add(center2,0,2);
        center2.getChildren().add(btn1);
        center2.setPadding(new Insets(0,0,0,40));

//Timer
        Bottom.getChildren().add(timeBox);
        timeBox.getChildren().add(timeLabel);
        task = new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(()->{
                    secondPassed--;
                    timeLabel.setText(secondPassed + " Seconds is left");
                    timeLabel.setPadding(new Insets(0,0,20,0));
                    timeLabel.setFont(new Font("New Times bold",20));
                    if (secondPassed == 0){
                        Center.getChildren().clear();

                        //add a FlowPane to the center
                        Center.getChildren().add(new Label("YOU RUN OUT OF TIME"));
                        timer.cancel();
                        timer.purge();
                    }
                });

            }
        };





        //to the Quiz
        btn1.setOnAction(e->{

            FlowPane flowPane= new FlowPane(Orientation.VERTICAL);
            flowPane.setAlignment(Pos.CENTER);
            flowPane.setHgap(50);
            flowPane.setPadding(new Insets(0,0,0,20));
            FlowPane flowPane2= new FlowPane(Orientation.VERTICAL);
            flowPane2.setAlignment(Pos.CENTER);
            flowPane2.setHgap(50);
            flowPane2.setPadding(new Insets(0,0,0,20));
            FlowPane flowPane3= new FlowPane(Orientation.VERTICAL);
            flowPane3.setAlignment(Pos.CENTER);
            flowPane3.setHgap(50);
            flowPane3.setPadding(new Insets(0,0,0,20));

            //empty the Pane
            Top.getChildren().clear();
            Center.getChildren().clear();
            center2.getChildren().clear();

            //add a FlowPane to the center
            Center.getChildren().add(flowPane);
            start();




            //the 1st step Quiz Questions
            QuestionsPart1 question1 = new QuestionsPart1("JAVA est un langage: ","Compilé","Interprété","Compilé et Interprété",flowPane);
            question1.constructQuestion();
            question1.setRightAnswer("Compilé");

         QuestionsPart1 question2 = new QuestionsPart1("Toutes les classes héritent de la classe: ","Main","Object","AWT",flowPane);
            question2.constructQuestion();
            question2.setRightAnswer("Object");

            QuestionsPart1 question3 = new QuestionsPart1("Par convention une classe: ","est en minuscule","commence par une majuscule","est en majuscule",flowPane);
            question3.constructQuestion();
            question3.setRightAnswer("commence par une majuscule");

            QuestionsPart1 question4 = new QuestionsPart1("Est-ce que on peut avoir plusieurs constructeurs\npour la même classe: ","Oui","Non",null,flowPane);
            question4.constructQuestion();
            question4.setRightAnswer("Oui");

            QuestionsPart1 question5 = new QuestionsPart1("Dans la ligne public class A implements B, B est: ","Interface","Classe parent","Package",flowPane);
            question5.constructQuestion();
            question5.setRightAnswer("Interface");



            Center.add(center2,0,1);
            Button btn2 = new Button("Next");
            center2.getChildren().add(btn2);


            btn2.setOnAction(f->{
                flowPane.getChildren().clear();

                //add a FlowPane to the center
                Center.getChildren().add(flowPane2);
                question1.toScore();
                question2.toScore();
                question3.toScore();
                question4.toScore();
                question5.toScore();
                question1.readAnswer();

                AtomicInteger score = new AtomicInteger(question1.getScore1());

                if (score.get() >=40){
                    Center.getChildren().clear();
                    center2.getChildren().clear();

                    //add a FlowPane to the center
                    Center.getChildren().add(flowPane2);

                    QuestionsPart2 question6 = new QuestionsPart2("Après la compilation, un programme écrit en JAVA,\nil se transforme en programme en bytecode.\nQuelle est l’extension du programme en bytecode ?:","a) aucun des choix","b) .JAVA ","c) .Class",flowPane2);
                    question6.constructQuestion();

                    QuestionsPart2 question7 = new QuestionsPart2("Class Test{\nPublic Test () { System.out.println(”Bonjour”);}\npublic Test (int i) {\nthis();\nSystem.out.println(”Nous sommes en ”+i+ ” !”);}; }\nqu’affichera l’instruction suivante?\nTest t1=new Test (2018);: : ","a) aucun des choix","b) Bonjour Nous sommes en 2018 !","c) Nous sommes en 2018 !",flowPane2);
                    question7.constructQuestion();

                    QuestionsPart2 question8 = new QuestionsPart2("Voici un constructeur de la classe Employee,\n y-at'il un problème ?\nPublic void Employe(String n){Nom=n;}: ","a) faux","b) vrai","c) aucun des choix",flowPane2);
                    question8.constructQuestion();

                    QuestionsPart2 question9 = new QuestionsPart2("Pour spécifier que la variable ne pourra plus être modifiée\net doit être initialisée dès sa déclaration,\non la déclare comme une constante avec le mot réservé: ","a) aucun des choix","b) final","c) const",flowPane2);
                    question9.constructQuestion();

                    QuestionsPart2 question10 = new QuestionsPart2("Dans une classe, on accède à ses variables\ngrâce au mot clé: ","a) aucun des choix","b) this","c) super",flowPane2);
                    question10.constructQuestion();


                    Center.add(center2,0,1);
                    Button btn3 = new Button("Next");
                    center2.getChildren().add(btn3);
                    btn3.setOnAction(l->{
                                flowPane2.getChildren().clear();
                                center2.getChildren().clear();

                                //add a FlowPane to the center
                                Center.getChildren().add(flowPane3);
                                question6.toScore();
                                question7.toScore();
                                question8.toScore();
                                question9.toScore();
                                question10.toScore();
                                question6.readAnswer();
                                score.addAndGet(question6.getScore2());
                        if (score.get() >= 100){
                            //the 3rd step Quiz Questions
                            QuestionsPart3 question11 = new QuestionsPart3("calculerSalaire(int)\n" +
                                    "calculerSalaire(int, double)\n" +
                                    "La méthode calculerSalaire est :","a) aucun des choix","b) surchargée","c) redéfinie", flowPane3);
                            question11.constructQuestion();

                            QuestionsPart3 question12 = new QuestionsPart3("Une classe qui contient au moins une méthode abstraite doit être déclarée abstraite.","a) vrai", "b) faux", null,flowPane3);
                            question12.constructQuestion();

                            QuestionsPart3 question13 = new QuestionsPart3("Est-ce qu’une classe peut implémenter plusieurs interfaces ?","a) vrai", "b) faux", "c) aucun des choix",flowPane3);
                            question13.constructQuestion();

                            QuestionsPart3 question14 = new QuestionsPart3("La déclaration d'une méthode suivante :\n" +
                                    "public void traitement() throws IOException précise\nque la méthode propage une exception contrôlée","a) vrai", "b) faux", "c) aucun des choix",flowPane3);
                            question14.constructQuestion();

                            QuestionsPart3 question15 = new QuestionsPart3("class Test{\n" +
                                    "public static void main (String[] args) {\n" +
                                    "try {\n" +
                                    "int a =10;\n" +
                                    "System.out.println (\"a = \" + a );\n" +
                                    "int b = 0 / a;\n" +
                                    "System.out.println (\"b = \" + b);\n" +
                                    "}\n" +
                                    "catch(ArithmeticException e)\n" +
                                    "{System.out.println (\"diviser par 0!\"); }\n" +
                                    "finally\n" +
                                    "{System.out.println (\"je suis à l’intérieur de\n" +
                                    "finally\");}}}\n","a) aucun des choix","b) a=10\n" + "b=0\n" + "Je suis à l’intérieur de finally","c) a=10\n" + "b=0\n" + "diviser par 0!\n"+"Je suis à l’intérieur de finally", flowPane3);
                            question15.constructQuestion();

                            Button btn4 = new Button("Done");
                            center2.getChildren().add(btn4);
                            btn4.setOnAction(p-> {
                                //flowPane.getChildren().clear();

                                //add a FlowPane to the center
                                //Center.getChildren().add(flowPane2);
                                question11.toScore();
                                question12.toScore();
                                question13.toScore();
                                question14.toScore();
                                question15.toScore();
                                question11.readAnswer();
                                score.addAndGet(question11.getScore3());
                                if (score.get() >= 180 && question15.getScore3()>=80) {
                                    Center.getChildren().clear();

                                    //add a FlowPane to the center
                                    Center.getChildren().add(flowPane2);
                                    flowPane2.getChildren().add(new Label("Test is Done CONGRATS!!"));
                                    timer.cancel();
                                    timer.purge();
                                } else {
                                    Center.getChildren().clear();

                                    //add a FlowPane to the center
                                    Center.getChildren().add(flowPane2);
                                    flowPane2.getChildren().add(new Label("Test is Done you failed!!"));
                                    timer.cancel();
                                    timer.purge();
                                }
                            });

                        }else {

                            flowPane2.getChildren().add(new Label("Test is Done you failed!!"));
                            timer.cancel();
                            timer.purge();
                        }

                    });



                    }
                else {

                        Center.getChildren().clear();

                        //add a FlowPane to the center
                        Center.getChildren().add(flowPane2);
                        flowPane2.getChildren().add(new Label("Test is Done you failed!!"));
                    timer.cancel();
                    timer.purge();

                }






                //the 2nd step Quiz Questions

        });




                });

    }


    public static void main(String[] args) {
        launch(args);
    }
}
