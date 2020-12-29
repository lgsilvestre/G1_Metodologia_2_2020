/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.MatOfPoint;
import org.opencv.core.Point;
import org.opencv.core.Scalar;
import org.opencv.highgui.HighGui;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javax.imageio.ImageIO;
import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.MatOfPoint;
import org.opencv.core.Point;
import org.opencv.core.Scalar;
import org.opencv.highgui.HighGui;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;


public class PatronesController implements Initializable {

    @FXML
    private Button pca;
    @FXML
    private ImageView caraPersona;
    Image fotoCara;
    @FXML
    private Button botonInicio;
    @FXML
    private Button botonSalir;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        BufferedImage imagenTemporal;
        
        File fotoPersona = new File("fotoTest.png");
        try {
            imagenTemporal = ImageIO.read(fotoPersona);
            fotoCara = SwingFXUtils.toFXImage(imagenTemporal, null);
            
            System.out.println("Se ha leido la fotografia");
        } catch (IOException ex) {
            Logger.getLogger(PatronesController.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("No se ha leido la imagen");
        }
        
        
        caraPersona.setImage(fotoCara);
        caraPersona.setVisible(false);
    }    

    @FXML
    private void pca(ActionEvent event) {
        
      caraPersona.setVisible(true);
      
    }

    @FXML
    private void irInicio(ActionEvent event) throws IOException {
        cambioEscena("sample.fxml");
       
    }
    
    public void cambioEscena(String nombreFxml) throws IOException{
        Stage stage2 = (Stage) this.botonInicio.getScene().getWindow();
        stage2.close();
        Stage stage = new Stage();
        Parent root2 = FXMLLoader.load(getClass().getResource(nombreFxml));
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

    @FXML
    private void salir(ActionEvent event) {
        Stage stage = (Stage) this.botonSalir.getScene().getWindow();
        stage.close();
        System.exit(0);
    }
   
}
