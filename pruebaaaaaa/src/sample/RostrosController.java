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
    @FXML
    private Button botonSalir;
    @FXML
    private Button botonInicio;
    
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
        if(!nombrePersona.getText().equals("")){
            if(!descripcion.getText().equals("")){
                if(!fechaNacimiento.getText().equals("")){
                    if(!sexo.getText().equals("")){
                        File archivo = new File("personas.json");
                        if(archivo.exists()){
                            System.out.println("existe");
                            //leer archivo y setearlo en personas de guardadojson
                            guardadoGson guardado = new guardadoGson();
                            guardado.leerJson();
                            setPersonas(guardado.getPersonas());
                            
                            contador=personas.size()+1;
                            Persona persona = new Persona(nombrePersona.getText(),descripcion.getText(),fechaNacimiento.getText(),sexo.getText(),contador);
                            personas.add(persona);
                        
                            guardado.setPersonas(personas);
                            guardado.crearGson();

                            String nombreImagen=String.valueOf(contador)+".png";
                            File fotoPersona = new File(nombreImagen);
                            String formato="png";
                            BufferedImage imagen = SwingFXUtils.fromFXImage(imagenUsuario.getImage(), null);

                            ImageIO.write(imagen, formato, fotoPersona);

                            contador+=1;
                            
//                            for (Persona persona1 : personas) {
//                                persona1.mostrarPersona();
//                            }
                            
                            System.out.println(contador);
                            resetearTextos();
                            
                            cambioEscena("sample.fxml");

                            
                        }
                        else{
                            System.out.println("No existe, Creamos el archivo");
                            Persona persona = new Persona(nombrePersona.getText(),descripcion.getText(),fechaNacimiento.getText(),sexo.getText(),contador);
                            personas.add(persona);
                        
                            guardadoGson guardado = new guardadoGson();
                            guardado.setPersonas(personas);
                            guardado.crearGson();
                        
                            String nombreImagen=String.valueOf(contador)+".png";
                            File fotoPersona = new File(nombreImagen);
                            String formato="png";
                            BufferedImage imagen = SwingFXUtils.fromFXImage(imagenUsuario.getImage(), null);
                        
                            ImageIO.write(imagen, formato, fotoPersona);
                       
                            contador+=1;
                            
                            resetearTextos();
                            cambioEscena("sample.fxml");
                        }
                    }
                }
            }
        }
    }

    @FXML
    private void salir(ActionEvent event) {
        Stage stage = (Stage) this.botonSalir.getScene().getWindow();
        stage.close();
        System.exit(0);
    }
    

    @FXML
    private void irInicio(ActionEvent event) throws IOException {
        cambioEscena("sample.fxml");
    }
    
    
}
