package gui;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class GUI extends Application {


    @Override
    public void start(Stage stage) {
        stage.setTitle("Lommeregner");
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane, 400,500);
        stage.setScene(scene);
        stage.show();
    }

    private void initContent(GridPane pane) {
        pane.setGridLinesVisible(false);
        pane.setPadding(new Insets(20));
        pane.setHgap(50);
        pane.setVgap(50);

        Button btnAddition = new Button("+");
        pane.add(btnAddition, 6, 7);
        btnAddition.setOnAction(event -> this.additionAction());

        Button btnSubtraktion = new Button("-");
        pane.add(btnSubtraktion, 6, 6);
        btnSubtraktion.setOnAction(event -> this.subtraktionAction());

        Button btnDivision = new Button("/");
        pane.add(btnDivision, 6, 5);
        btnDivision.setOnAction(event -> this.divisionAction());

        Button btnMultiplikation = new Button("X");
        pane.add(btnMultiplikation, 6, 4);
        btnMultiplikation.setOnAction(event -> this.multiplikationAction());
    }

    private void multiplikationAction() {
    }

    private void divisionAction() {
    }

    private void subtraktionAction() {
    }

    private void additionAction() {
    }

}
