package com.nikesh;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("MSDFormatter1.fxml"));
        root.getStylesheets().add("com/nikesh/Style.css");
        
        primaryStage.getIcons().add(new Image(this.getClass().getResourceAsStream("logo_eye.png")));
        primaryStage.setTitle("MSD Formatter");
        primaryStage.setScene(new Scene(root, 1060, 800));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
