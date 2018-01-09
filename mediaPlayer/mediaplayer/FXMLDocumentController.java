/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mediaplayer;


import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaView;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaPlayer.Status;
import javafx.stage.FileChooser;
import javafx.util.Duration;

/**
 *
 * @author Ewa
 */

public class FXMLDocumentController implements Initializable {
   
    public MediaPlayer mediaPlayer;
    
    @FXML
    private MediaView mediaView;
    private String filepath;
    private List<String> movieList = new ArrayList<String>();
    
    @FXML
    public void openFile(String fileno) {
        int no = Integer.parseInt(fileno);
        String film = movieList.get(no);
        filepath = 
     "file:/C:/Users/asus1/Documents/NetBeansProjects/MediaPlayer/src/movies/" + film;
        if(filepath!=null){
         Media media = new Media(filepath);
         mediaPlayer = new MediaPlayer(media);
         mediaView.setMediaPlayer(mediaPlayer);
         DoubleProperty width = mediaView.fitWidthProperty();
         DoubleProperty height = mediaView.fitHeightProperty();
         
         width.bind(Bindings.selectDouble(mediaView.sceneProperty(), "width"));
         height.bind(Bindings.selectDouble(mediaView.sceneProperty(), "height"));
        } 
    }
    
    @FXML
    public void filmList(){
        File folder = new File("C:/Users/asus1/Documents/NetBeansProjects/MediaPlayer/src/movies");
        File[] listOfFiles = folder.listFiles();

        //dodawanie filmów z katalogu do ArrayList
        for (File file : listOfFiles) {
        if (file.isFile()) {
            String filename = file.getName();
            movieList.add(filename);
            }
        }
        //wystwietlanie filmow z ArrayList
        System.out.println("Type a number of a film: ");
        for (int i=0; i<movieList.size(); i++){
            String path = i + ") " + movieList.get(i);
            System.out.println(path);
        }
    }
    
    @FXML
    public void playVideo(){
        mediaPlayer.play();
    }
    
    @FXML
    public void forward(){
         Duration forward = Duration.millis(5000);
         Duration pos = mediaPlayer.getCurrentTime().add(forward);
         mediaPlayer.seek(pos);
    }
    
    @FXML
    public void backward(){
        Duration backward = Duration.millis(-5000);
        Duration pos = mediaPlayer.getCurrentTime().add(backward);
        mediaPlayer.seek(pos);
    }
    
    @FXML
    public void pauseVideo(){
       Status status = mediaPlayer.getStatus();
       if(status.equals(Status.PLAYING)){
           mediaPlayer.pause();
       }
       else if(status.equals(Status.PAUSED) || status.equals(Status.READY) || 
               status.equals(Status.STOPPED)){
           mediaPlayer.play();
       }
       else mediaPlayer.play();
    }
    
    
    @FXML
    public void exit(){
        System.exit(0);
    }
    
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
