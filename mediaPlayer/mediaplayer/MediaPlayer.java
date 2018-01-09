package mediaplayer;

import static com.sun.java.accessibility.util.AWTEventMonitor.addKeyListener;
import java.awt.event.KeyListener;
import javafx.beans.*;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import java.io.*;
import java.net.*;
import javafx.scene.input.KeyCode;


/**
 *
 * @author Ewa
 */

/* Media Player Server: przyjmuje polecenia (spacja, strzałki) i je wykonuje) */

public class MediaPlayer extends Application implements Runnable {
    /************************* VARIABLES *************************/
    ServerSocket serverSocket = null;   //server socket
    static FXMLDocumentController ctrl;  //fxml controller 
    char keyev; //string that stores key event
    String regex = "\\d+";
    
    /************** THE VIDEO PLAYER **************************************/
    
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLDocument.fxml"));
        Parent root = loader.load();
        
        ctrl = (FXMLDocumentController)loader.getController();
        
        Scene scene = new Scene(root);
    
        stage.setTitle("Video Player");
        stage.setFullScreen(true);
        stage.setScene(scene);
        stage.show();
    }  
    
   /************* SERVER IN A THREAD ********************************/
    @Override
    public void run() {
        //listening on a port
        System.out.println("Waiting...");
        try {
            serverSocket = new ServerSocket(6789);
        } catch (IOException e) {
            System.out.println("Could not listen on port: 6789");
            System.exit(-1);
        }
        //accepting client 
        Socket clientSocket = null;
        try {
        clientSocket = serverSocket.accept();
       
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        String inputLine;
 
        while ((inputLine = in.readLine()) != null) {
             out.println(inputLine);
             
		if(inputLine.equals("f")){
                    ctrl.forward();
                    System.out.println("5s forward");
		}
		else if(inputLine.equals("b")){
                    ctrl.backward();
                    System.out.println("5s backward");
		}
		else if(inputLine.equals("p")){
                    ctrl.pauseVideo();
                    System.out.println("pause/play");
		}
                else if(inputLine.equals("o")){
                    ctrl.filmList();
                    System.out.println("opening files...");
                }
                else if(inputLine.equals("x")){
                    ctrl.exit();
                }
                else if(inputLine.matches(regex)){
                    ctrl.openFile(inputLine);
                }
        }
		
        out.close();
        in.close();
        clientSocket.close();
        serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
     public static void main(String[] args) throws Exception {
         new Thread(new MediaPlayer()).start();
         launch(args);
    }
    
}
