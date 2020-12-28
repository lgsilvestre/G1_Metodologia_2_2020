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
import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.core.Scalar;
import org.opencv.imgproc.Imgproc;

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
    
    @FXML
    private Button aplicarPatron;
    
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

    @FXML
    private void aplicarPatron(ActionEvent event) {
        
        
    }
    
    private void drawAxis(Mat img, Point p_, Point q_, Scalar colour, float scale) {
        Point p = new Point(p_.x, p_.y);
        Point q = new Point(q_.x, q_.y);
        double angle = Math.atan2(p.y - q.y, p.x - q.x); // Angulo en radianes
        double hypotenuse = Math.sqrt((p.y - q.y) * (p.y - q.y) + (p.x - q.x) * (p.x - q.x));
        // Aquí alargamos la flecha en un factor de escala
        q.x = (int) (p.x - scale * hypotenuse * Math.cos(angle));
        q.y = (int) (p.y - scale * hypotenuse * Math.sin(angle));
        Imgproc.line(img, p, q, colour, 1, Imgproc.LINE_AA, 0);
        // Se crean las anclas de la flechas
        p.x = (int) (q.x + 9 * Math.cos(angle + Math.PI / 4));
        p.y = (int) (q.y + 9 * Math.sin(angle + Math.PI / 4));
        Imgproc.line(img, p, q, colour, 1, Imgproc.LINE_AA, 0);
        p.x = (int) (q.x + 9 * Math.cos(angle - Math.PI / 4));
        p.y = (int) (q.y + 9 * Math.sin(angle - Math.PI / 4));
        Imgproc.line(img, p, q, colour, 1, Imgproc.LINE_AA, 0);
    }
    
}
