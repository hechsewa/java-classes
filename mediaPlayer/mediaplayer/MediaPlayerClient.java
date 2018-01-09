/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mediaplayer;

import java.io.*;
import java.net.*;
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

/* Media Player Client: wysyła: spacja,strzałka prawa, lewa */ 

public class MediaPlayerClient {
    private Socket echoSocket = null;
    private PrintWriter out = null;
    private BufferedReader in = null;
    
    public MediaPlayerClient(){
        connect();
    }
    
     private void connect(){
         try {
            echoSocket = new Socket("localhost", 6789);
            out = new PrintWriter(echoSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(echoSocket.getInputStream()));
        
        System.out.println("Connected to server... ");
        } catch(Exception e){
             e.printStackTrace();
         }
     }
     
     public void closeStreams(){
         try{
            out.close();
            in.close();
            echoSocket.close(); 
            System.out.println("disconnected");
         } catch(Exception e){
             e.printStackTrace();
         }
     }
     
     public void play(){
         out.println("p");
         System.out.println("p");
     }
     
     public void forward(){
         out.println("f");
         System.out.println("f");
     }
     
     public void backward(){
         out.println("b");
         System.out.println("b");
     }
     
     public void openFile(){
         out.println("o");
         System.out.println("o");
     }
     
     public void closeWin(){
         out.println("x");
         System.out.println("x");
     }
     
     public void number0(){
         out.println("0");
         System.out.println("0");
     }
     public void number1(){
         out.println("1");
         System.out.println("1");
     }
     public void number2(){
         out.println("2");
         System.out.println("2");
     }
     
     public void getNumber(KeyEvent e){
         String number = e.getCode().getName();
         out.println(number);
         System.out.println(number);
     }
 
}
