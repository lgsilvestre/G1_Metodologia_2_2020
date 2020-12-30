/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ayuda;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 * FXML Controller class
 *
 * @author Ryuk
 */
public class AyudaSoporteController implements Initializable {
    
    
    @FXML
    private Button botonInicio;
    @FXML
    private TextField problema;
    @FXML
    private TextArea descripcion;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
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
}
