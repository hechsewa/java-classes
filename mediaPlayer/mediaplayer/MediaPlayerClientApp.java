/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mediaplayer;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Ewa
 */
public class MediaPlayerClientApp extends Application {
    
    /****** WINDOW & KEY LISTENER ********************/    
    @Override
    public void start(Stage stage) throws Exception {
       
        MediaPlayerClient mp = new MediaPlayerClient();
        StackPane root = new StackPane();
        Scene scene = new Scene(root, 300, 300); //Parent, width, height
        
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                switch(event.getCode()){
                    case RIGHT: 
                        mp.forward();
                        break;
                    case LEFT:
                        mp.backward();
                        break;
                    case O:
                        mp.openFile();
                        break;
                    case X:
                        mp.closeWin();
                        mp.closeStreams();
                        System.exit(0);
                        break;
                }
            }
        });
        
        scene.addEventFilter(KeyEvent.KEY_PRESSED, event -> {
        if (event.getCode()== KeyCode.SPACE) {
            mp.play();
            event.consume();
        }
        else if(event.getCode().isDigitKey()){
            mp.getNumber(event);
        }
       });
        
        stage.setTitle("Video Controller");
        stage.setScene(scene);
        stage.show();
    }
    
    public static void main(String[] args) throws Exception {
        System.out.println("Menu:");
        System.out.println("O: open files");
        System.out.println("SPACE: pause/play");
        System.out.println("RIGHT ARROW: 5s forward");
        System.out.println("LEFT ARROW: 5s backward");
        System.out.println("X: exit");
        launch(args);
    }
    
}
