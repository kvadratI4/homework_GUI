package com.example.hometask3_gui_javafx_start;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Arrays;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException, InterruptedException {
        Group group = new Group();
        Scene scene = new Scene(group, 800, 800);

        Button first_button = new Button("I'm first");
        first_button.setLayoutX(0);
        first_button.setLayoutY(0);
        first_button.setMinSize(100,100);
        first_button.setStyle("-fx-color: #32a85e; ");
        group.getChildren().add(first_button);

        Button second_button = new Button("I'm second");
        second_button.setLayoutX(700);
        second_button.setLayoutY(700);
        second_button.setMinSize(100,100);
        second_button.setStyle("-fx-color: #a83232; ");
        group.getChildren().add(second_button);

        stage.setTitle("My homework task");
        stage.setScene(scene);
        stage.show();

        final double[] firstButtonCoords = new double[2];
        final double[] secondButtonCoords = new double[2];

        /* FIRST_BUTTON */
        first_button.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                //System.out.println("X: " + mouseEvent.getSceneX());
                //System.out.println("Y: " + mouseEvent.getSceneY());
                firstButtonCoords[0] = mouseEvent.getX();
                firstButtonCoords[1] = mouseEvent.getY();
                scene.setCursor(Cursor.CLOSED_HAND);
            }
        });

        first_button.setOnMouseReleased(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                scene.setCursor(Cursor.DEFAULT);
                isCornerInOtherArea(getFirstCoords_(first_button), getSecondCoords_(second_button));
                System.out.println("Total area: " + areaCalculating(getFirstCoords_(first_button), getSecondCoords_(second_button)));
            }
        });

        first_button.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                first_button.setLayoutX(mouseEvent.getSceneX() - firstButtonCoords[0]);
                first_button.setLayoutY(mouseEvent.getSceneY() - firstButtonCoords[1]);
            }
        });
        /* -------->  */


        /* SECOND_BUTTON */
        second_button.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                //System.out.println("X: " + mouseEvent.getSceneX());
                //System.out.println("Y: " + mouseEvent.getSceneY());
                secondButtonCoords[0] = mouseEvent.getX();
                secondButtonCoords[1] = mouseEvent.getY();
                scene.setCursor(Cursor.CLOSED_HAND);
            }
        });

        second_button.setOnMouseReleased(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                scene.setCursor(Cursor.DEFAULT);
                isCornerInOtherArea(getFirstCoords_(first_button), getSecondCoords_(second_button));
                System.out.println("Total area: " + areaCalculating(getFirstCoords_(first_button), getSecondCoords_(second_button)));
            }
        });

        second_button.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                second_button.setLayoutX(mouseEvent.getSceneX() - secondButtonCoords[0]);
                second_button.setLayoutY(mouseEvent.getSceneY() - secondButtonCoords[1]);
            }
        });
        /* -------->  */
    }


    /* BUTTONS COORDINATES */
    public void isCornerInOtherArea(double [][] firstButtonCoords_, double [][] secondButtonCoords_){
        System.out.println("first button: " + Arrays.deepToString(firstButtonCoords_));
        System.out.println("second button: " + Arrays.deepToString(secondButtonCoords_));
        System.out.println("=================================");

    }

    public double[][] getFirstCoords_(Button first_button) {
        final double[][] firstButtonCoords_ = {
                {first_button.getLayoutX(), first_button.getLayoutY()},
                {first_button.getLayoutX() + 100, first_button.getLayoutY()},
                {first_button.getLayoutX() + 100, first_button.getLayoutY() + 100},
                {first_button.getLayoutX(), first_button.getLayoutY() + 100}
        };

        return firstButtonCoords_;
    }

    public double[][] getSecondCoords_(Button second_button) {
        final double[][] secondButtonCoords_ = {
                {second_button.getLayoutX(), second_button.getLayoutY()},
                {second_button.getLayoutX() + 100, second_button.getLayoutY()},
                {second_button.getLayoutX() + 100, second_button.getLayoutY() + 100},
                {second_button.getLayoutX(), second_button.getLayoutY() + 100}
        };

        return secondButtonCoords_;
        /* -------->  */
    }


    /* AREA CALCULATING */
    public double areaCalculating(double [][] firstButtonCoords_, double [][] secondButtonCoords_) {
        double left = Math.max(firstButtonCoords_[0][0], secondButtonCoords_[0][0]);
        double bottom = Math.max(firstButtonCoords_[0][1], secondButtonCoords_[0][1]);
        double top = Math.min(firstButtonCoords_[2][1], secondButtonCoords_[2][1]);
        double right = Math.min(firstButtonCoords_[2][0], secondButtonCoords_[2][0]);

        double width = right - left;
        double height = top - bottom;

        if (width < 0 || height < 0) {
            return 0; }
        return width * height;
        /* -------->  */
    }

    public static void main(String[] args) {
        launch();
    }
}