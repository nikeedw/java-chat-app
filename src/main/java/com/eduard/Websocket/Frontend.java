package com.eduard.Websocket;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
@CrossOrigin(origins = "http://localhost:8088")
public class Frontend extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        WebView webView = new WebView();

        // error handler
        webView.getEngine().setOnError(event -> {
            System.out.println("WebView Error: " + event.getMessage());
        });

        // logs
        webView.getEngine().setOnStatusChanged(event -> {
            System.out.println("Status: " + event.getData());
        });

        // url to host
        webView.getEngine().load("http://localhost:8088");

        StackPane root = new StackPane();
        root.getChildren().add(webView);

        Scene scene = new Scene(root, 800, 600);

        primaryStage.setTitle("WebSocket Chat");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @Override
    public void stop() {
        Platform.exit();
    }
}
