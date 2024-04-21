//package com.bemarzprj;
//
//import javafx.application.Application;
//import javafx.fxml.FXMLLoader;
//import javafx.scene.Parent;
//import javafx.scene.Scene;
//import javafx.stage.Stage;
//import org.springframework.boot.SpringApplication;
//import org.springframework.context.ConfigurableApplicationContext;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//
//import java.io.IOException;
//
//@Configuration
//public class Main extends Application {
//    private ConfigurableApplicationContext springContext;
//
//    private Parent rootNode;
//
//    @Override
//    public void start(Stage stage) throws IOException
//    {
//        Scene scene = new Scene(rootNode);
//        stage.setTitle("منو اصلی");
//        stage.setScene(scene);
//        stage.setResizable(false);
//        stage.show();
//    }
//
//    public void init() throws IOException
//    {
//        springContext = SpringApplication.run(Main.class);
//        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("MainWindow.fxml"));
//        fxmlLoader.setControllerFactory(springContext::getBean);
//        rootNode = fxmlLoader.load();
//    }
//
//    public void stop() throws Exception
//    {
//        springContext.stop();
//    }
//
//    public static void main(String[] args) {
////        launch();
//        // Manually start the ServletWebServerFactory
////        ServletWebServerApplicationContext serverContext = (ServletWebServerApplicationContext) springContext;
////        ServletWebServerFactory serverFactory = (ServletWebServerFactory) serverContext.getWebServer();
////        WebServer webServer = serverFactory.getWebServer();
////        webServer.start();
//        Application.launch(args);
//    }
//}