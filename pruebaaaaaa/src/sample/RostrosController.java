/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javax.imageio.ImageIO;
import sample.Controller;

public class RostrosController implements Initializable{

    @FXML
    private Button guardarRostro;
    @FXML
    private TextField nombrePersona;
    @FXML
    private TextField descripcion;
    @FXML
    private TextField fechaNacimiento;
    @FXML
    private TextField sexo;
    @FXML
    private ImageView imagenUsuario;
    
    ArrayList<Persona> personas = new ArrayList<>();
    int contador=1;
    
    public void setPersonas(ArrayList<Persona> personas) {
        this.personas = personas;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        nombrePersona.setStyle("-fx-text-inner-color: white;-fx-background-color: #4d4d4d;");
        descripcion.setStyle("-fx-text-inner-color: white;-fx-background-color: #4d4d4d;");
        fechaNacimiento.setStyle("-fx-text-inner-color: white;-fx-background-color: #4d4d4d;");
        sexo.setStyle("-fx-text-inner-color: white;-fx-background-color: #4d4d4d;");
        imagenUsuario.setImage(Controller.imagenCapturada.getImage());
    }

    public void resetearTextos(){
        nombrePersona.clear();
        descripcion.clear();
        fechaNacimiento.clear();
        sexo.clear();
        imagenUsuario.setImage(null);
    }
    
    public void cambioEscena(String nombreFxml) throws IOException{
        Stage stage2 = (Stage) this.guardarRostro.getScene().getWindow();
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
    private void guardarFotografia(ActionEvent event) throws IOException {
        
        
    }
}
