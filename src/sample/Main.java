package sample;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));

        //Controller ctrl = new Controller();
        //GridPane
        BorderPane root = new BorderPane();
        primaryStage.setTitle("JAVA Quiz");
        primaryStage.setScene(new Scene(root, 900, 900));
        primaryStage.show();
        root.setStyle("-fx-background-color:rgb(148, 156, 223)");

        //Top Border
        HBox Top = new HBox();
        Top.setAlignment(Pos.CENTER);
        root.setTop(Top);
        Top.setPadding(new Insets(20, 5, 10, 5));

        //Center Border
        HBox Center = new HBox();
        Center.setAlignment(Pos.CENTER);
        root.setCenter(Center);

        //Bottom Border
        HBox Bottom = new HBox();
        Bottom.setAlignment(Pos.CENTER);
        root.setBottom(Bottom);



        //1st page label
        Label greeting =new Label("Ready to take the Java Quiz ?");
        Top.getChildren().add(greeting);
        greeting.setFont(new Font("Tahoma ",19));

        //Image
        Image image = new Image(getClass().getResource("img/java.gif").toString());
        ImageView iv1 = new ImageView(image);
        Bottom.getChildren().add(iv1);


        //1st page Button
        Button btn1 = new Button("Start The Quiz");
        Center.getChildren().add(btn1);

        //to the Quiz
        btn1.setOnAction(e->{
            FlowPane flowPane= new FlowPane(Orientation.VERTICAL);
            flowPane.setAlignment(Pos.CENTER);
            FlowPane flowPane2= new FlowPane(Orientation.VERTICAL);
            flowPane2.setAlignment(Pos.CENTER);
            FlowPane flowPane3= new FlowPane(Orientation.VERTICAL);
            flowPane3.setAlignment(Pos.CENTER);

            //empty the Pane
            Top.getChildren().clear();
            Center.getChildren().clear();

            //add a FlowPane to the center
            Center.getChildren().add(flowPane);

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

            QuestionsPart1 question4 = new QuestionsPart1("Est-ce que on peut avoir plusieurs constructeurs pour la même classe: ","Oui","Non",null,flowPane);
            question4.constructQuestion();
            question4.setRightAnswer("Oui");

            QuestionsPart1 question5 = new QuestionsPart1("Dans la ligne public class A implements B, B est: ","Interface","Classe parent","Package",flowPane);
            question5.constructQuestion();
            question5.setRightAnswer("Interface");

            Button btn2 = new Button("Next");
            flowPane.getChildren().add(btn2);
            btn2.setOnAction(f->{
                flowPane.getChildren().clear();

                //add a FlowPane to the center
                Center.getChildren().add(flowPane2);

                //the 2nd step Quiz Questions
                QuestionsPart2 question6 = new QuestionsPart2("Après la compilation, un programme écrit en JAVA, il se transforme en programme en bytecode Quelle est l’extension du programme en bytecode ?: : ","a) aucun des choix","b) .JAVA ","c) Compilé et Interprété",flowPane2);
                question6.constructQuestion();

                QuestionsPart2 question7 = new QuestionsPart2("Class Test{ Public Test () { System.out.println(”Bonjour”);} public Test (int i) { this(); System.out.println(”Nous sommes en ”+i+ ” !”);}; } qu’affichera l’instruction suivante? Test t1=new Test (2018);: : ","a) aucun des choix","b) Bonjour Nous sommes en 2018 !","c) Nous sommes en 2018 !",flowPane2);
                question7.constructQuestion();

                QuestionsPart2 question8 = new QuestionsPart2("Voici un constructeur de la classe Employee, y-at'il un problème ?\\n\" +\n" +
                        "                        \"Public void Employe(String n){\\n\" +\n" +
                        "                        \"Nom=n;}: ","a) faux","b) vrai","c) aucun des choix",flowPane2);
                question8.constructQuestion();

                QuestionsPart2 question9 = new QuestionsPart2("Pour spécifier que la variable ne pourra plus être modifiée et doit être initialisée dès sa déclaration, on la déclare comme une constante avec le mot réservé: ","a) aucun des choix","b) final","c) const",flowPane2);
                question9.constructQuestion();

                QuestionsPart2 question10 = new QuestionsPart2("Dans une classe, on accède à ses variables grâce au mot clé: ","a) aucun des choix","b) this","c) super",flowPane2);
                question10.constructQuestion();

                Button btn3 = new Button("Next");
                flowPane2.getChildren().add(btn3);
                btn3.setOnAction(g->{
                    flowPane2.getChildren().clear();
                    //add a FlowPane to the center
                    Center.getChildren().add(flowPane3);

                    //the 3rd step Quiz Questions
                    QuestionsPart3 question11 = new QuestionsPart3("Niveau : 3\n" +
                            "calculerSalaire(int)\n" +
                            "calculerSalaire(int, double)\n" +
                            "La méthode calculerSalaire est :","a) aucun des choix","b) this","c) redéfinie", flowPane3);
                    question11.constructQuestion();

                    QuestionsPart3 question12 = new QuestionsPart3("Une classe qui contient au moins une méthode abstraite doit être déclarée abstraite.","a) vrai", "b) faux", null,flowPane3);
                    question12.constructQuestion();

                    QuestionsPart3 question13 = new QuestionsPart3("Est-ce qu’une classe peut implémenter plusieurs interfaces ?","a) vrai", "b) faux", null,flowPane3);
                    question13.constructQuestion();

                    QuestionsPart3 question14 = new QuestionsPart3("La déclaration d'une méthode suivante :\n" +
                            "public void traitement() throws IOException précise que la méthode propage une exception contrôlée","a) vrai", "b) faux", null,flowPane3);
                    question14.constructQuestion();

                    QuestionsPart3 question15 = new QuestionsPart3("","a) aucun des choix","a=10\n" + "b=0\n" + "Je suis à l’intérieur de finally","a=10\n" + "b=0\n" + "diviser par 0!\n"+"Je suis à l’intérieur de finally", flowPane3);
                    question15.constructQuestion();

                    Button btn4 = new Button("Done");
                    flowPane3.getChildren().add(btn4);

                });

            });
        });
    }


    public static void main(String[] args) {
        launch(args);
    }
}
