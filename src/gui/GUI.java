package gui;

import application.controller.Controller;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class GUI extends Application {

    @Override
    public void start(Stage stage) {
        stage.setTitle("Lommeregner");
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane, 400, 500);
        stage.setScene(scene);
        stage.show();
    }

    Controller controller = new Controller();
    private TextField txfTal = new TextField();

    private String displayValue = ""; // Instansvariabel til at holde den aktuelle værdi

    private Button currentButton; // Instansvariabel til at gemme den aktuelle knap


    private void initContent(GridPane pane) {
        pane.setGridLinesVisible(false);
        pane.setPadding(new Insets(20));
        pane.setHgap(40); // Juster værdien for mindre vandret mellemrum
        pane.setVgap(40); // Juster værdien for mindre lodret mellemrum


        //Textfield for tallene
        pane.add(txfTal, 0, 0,4,1);
        txfTal.setPrefHeight(80);
        txfTal.setEditable(false);
        txfTal.setStyle("-fx-font-size: 24px;"); // CSS-styling til at ændre skriftstørrelsen

        //Knap for at slette
        Button btnDelete = new Button("Delete");
        btnDelete.setPrefWidth(80);
        btnDelete.setPrefHeight(80);
        pane.add(btnDelete,4,0);
        btnDelete.setOnAction(event -> this.deleteAction());

        // Knapper for beregningerne
        Button btnAddition = new Button("+");
        btnAddition.setPrefWidth(80);
        btnAddition.setPrefHeight(80);
        pane.add(btnAddition, 4, 1);
        btnAddition.setOnAction(event -> this.additionAction());

        Button btnSubtraktion = new Button("-");
        btnSubtraktion.setPrefWidth(80);
        btnSubtraktion.setPrefHeight(80);
        pane.add(btnSubtraktion, 4, 2);
        btnSubtraktion.setOnAction(event -> this.subtraktionAction());

        Button btnDivision = new Button("/");
        btnDivision.setPrefWidth(80);
        btnDivision.setPrefHeight(80);
        pane.add(btnDivision, 4, 3);
        btnDivision.setOnAction(event -> this.divisionAction());

        Button btnMultiplikation = new Button("X");
        btnMultiplikation.setPrefWidth(80);
        btnMultiplikation.setPrefHeight(80);
        pane.add(btnMultiplikation, 4, 4);
        btnMultiplikation.setOnAction(event -> this.multiplikationAction());

        // Knapper for tallene
        int buttonIndex = 1;
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                Button btnNumber = new Button(Integer.toString(buttonIndex));
                btnNumber.setPrefWidth(80);
                btnNumber.setPrefHeight(80);
                pane.add(btnNumber, col, row + 1);
                btnNumber.setOnAction(event -> {
                    currentButton = btnNumber; // Opdater currentButton med den valgte knap
                    numberAction(); // Kald numberAction-metoden
                });
                buttonIndex++;
            }
        }
        // Knappen for tallet 0
        Button btnZero = new Button("0");
        btnZero.setPrefWidth(80);
        btnZero.setPrefHeight(80);
        pane.add(btnZero, 1, 4);
        btnZero.setOnAction(event -> {
            currentButton = btnZero; // Opdater currentButton med den valgte knap
            zeroAction(); // Kald zeroAction-metoden
        });

        // Knappen for tallet komma
        Button btnKomma = new Button(".");
        btnKomma.setPrefWidth(80);
        btnKomma.setPrefHeight(80);
        pane.add(btnKomma, 2, 4);
        btnKomma.setOnAction(event -> {
            currentButton = btnKomma; // Opdater currentButton med den valgte knap
            kommaAction(); // Kald kommaAction-metoden
        });
    }

    private void deleteAction() {
        /*
        For at fjerne det sidste tegn opdaterer vi displayets værdi ved at bruge substring fra index 0
        til displayets længde og minusser med 1, for at tage det sidste tegn fra.
         */
        if(!displayValue.isEmpty()){
            displayValue = displayValue.substring(0,displayValue.length()-1);
            txfTal.setText(displayValue);
        }
    }

    private void numberAction() {
        String btnTal = currentButton.getText();

        displayValue += btnTal;

        txfTal.setText(displayValue);
    }

    private void kommaAction() {
        String btnKomma = currentButton.getText();

        displayValue += btnKomma;

        txfTal.setText(displayValue);
    }

    private void zeroAction() {
        String btnZero = currentButton.getText();

        displayValue += btnZero;

        txfTal.setText(displayValue);
    }

    private void multiplikationAction() {
        double tal1 = Double.parseDouble(displayValue);
        displayValue = ""; // Ryd displayValue
        txfTal.setText(displayValue); // Opdater txfTal

        currentButton = null; // Nulstil currentButton

        txfTal.setOnAction(event -> {
            double tal2 = Double.parseDouble(txfTal.getText());
            double resultat = controller.udregnMultiplikation(tal1, tal2);
            displayValue = Double.toString(resultat);
            txfTal.setText(displayValue);

            txfTal.setOnAction(null); // Fjern handleAction for at undgå gentagelse af beregningen
        });
    }


    private void divisionAction() {
        //controller.udregnDivision();
    }

    private void subtraktionAction() {
        //controller.udregnSubtraktion();
    }

    private void additionAction() {
        //controller.udregnAddition();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

