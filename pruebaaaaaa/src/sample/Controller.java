package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import org.opencv.core.Mat;
import org.opencv.imgproc.Imgproc;
import org.opencv.videoio.VideoCapture;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Controller {
    private WebCamCapture webCamCapture;
    @FXML
    private ImageView cameraFrame;
    @FXML
    private Button prender;
    @FXML
    private Button apagar;
    @FXML
    private ImageView background;
    @FXML
    private Button TakePicture;
    
    @FXML
    protected void prender(ActionEvent event){
        webCamCapture = new WebCamCapture(this.cameraFrame);
        cameraFrame.setVisible(true);
        apagar.setVisible(false);
        prender.setVisible(true);
    }

    @FXML
    protected void stopCamera(ActionEvent event){
        if(webCamCapture != null){
            webCamCapture.stop();
            cameraFrame.setVisible(false);
            apagar.setVisible(true);
            prender.setVisible(false);
        }
    }

    @FXML
    private void takePicture(ActionEvent event) {
        if(webCamCapture != null){
            webCamCapture.stop();
            prender.setVisible(false);
            apagar.setVisible(true);
            
        }
    }
    
    
    
    
    
    
    
    
}
