package com.internshala.Javafx;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Optional;

public class MyMain extends Application {

    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void init() throws Exception {
        super.init();

        System.out.println("Inin");
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        System.out.println("start");
        FXMLLoader loader = new
                FXMLLoader(getClass().getResource("app_layout.fxml"));
        VBox rootNode = loader.load();

        MenuBar menuBar = creatMenu();
        rootNode.getChildren().add(0,menuBar);

        Scene scene = new Scene(rootNode);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Temperature Converter Tool");
        primaryStage.show();

    }

    private MenuBar creatMenu(){
        // File Menu
        Menu fileMenu = new Menu("File");


        MenuItem newMenuItem = new MenuItem("New");

        newMenuItem.setOnAction(event -> System.out.println("New Menu Item Clicked"));

        MenuItem quitMenuItem = new MenuItem("Quit");

        quitMenuItem.setOnAction(event -> {
            Platform.exit();
            System.exit(0);
        });

        SeparatorMenuItem separatorMenuItem = new SeparatorMenuItem();

        fileMenu.getItems().addAll(newMenuItem,separatorMenuItem,quitMenuItem);

        // Help Menu
        Menu helpMenu = new Menu("Help");
        MenuItem aboutApp = new MenuItem("About");
        aboutApp.setOnAction(event -> AboutApp());

        helpMenu.getItems().addAll(aboutApp);



        // Menu Bar
        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(fileMenu,helpMenu);
        return menuBar;


    }

    public static void AboutApp() {

        Alert alertDialog = new Alert(Alert.AlertType.INFORMATION);
        alertDialog.setTitle("My first JAVA desktop App");
        alertDialog.setHeaderText("This is a temperature converter tool");
        alertDialog.setContentText("You can convert temperature from Celsius to Fahrenheit & Fahrenheit to Celsius using this application." +" "+
                "First select the checkbox and enter a valid temperature and click on the convert button to get the result.");
        alertDialog.show();



    }

    @Override
    public void stop() throws Exception {
        super.stop();
        System.out.println("stop");
    }
}

