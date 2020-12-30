/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample;

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
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 * FXML Controller class
 *
 * @author Ryuk
 */
public class AyudaSoporteController implements Initializable {
    
    
    @FXML
    private Button inicio;
    
    @FXML
    private Button rostros;
    
    @FXML
    private Button patrones;
    
    @FXML
    private Button enviar;

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
    
    @FXML
    private void irRostros(ActionEvent event) throws IOException {
        cambioEscena("rostros.fxml");
    }
    
    @FXML
    private void irPatrones(ActionEvent event) throws IOException {
        cambioEscena("patrones.fxml");
    }
    
    
    public void cambioEscena(String nombreFxml) throws IOException{
        Stage stage2 = (Stage) this.inicio.getScene().getWindow();
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
