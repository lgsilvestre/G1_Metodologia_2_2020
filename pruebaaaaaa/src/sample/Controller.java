package sample;


import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

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
    
    static ImageView imagenCapturada;

    public static ImageView getImagenCapturada() {
        return imagenCapturada;
    }

    public static void setImagenCapturada(ImageView imagenCapturada) {
        Controller.imagenCapturada = imagenCapturada;
    }
    
    
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
    private void takePicture(ActionEvent event) throws IOException {
        if(webCamCapture != null){
//            webCamCapture.stop();
//            prender.setVisible(false);
//            apagar.setVisible(true);

            setImagenCapturada(cameraFrame);
            
            //System.out.println("width: "+cameraFrame.getImage().getWidth());
            //System.out.println("heigh: "+cameraFrame.getImage().getHeight());
            
            Stage stage2 = (Stage) this.TakePicture.getScene().getWindow();
            stage2.close();
            Stage stage = new Stage();
            Parent root2 = FXMLLoader.load(getClass().getResource("rostros.fxml"));
            Scene scene = new Scene(root2);

            stage.setScene(scene);
            stage.show();
            
            stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
                @Override
                public void handle(WindowEvent t) {
                    Platform.exit();
                    System.exit(0);
                }
            });
        }
    }
    
    
    
    
    
    
    
    
}
