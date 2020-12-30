/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baseDeDatos;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonParser;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.lang.reflect.Type;
import com.google.gson.reflect.TypeToken;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import sample.Persona;
/**
 *
 * @author ckill
 */
public class guardadoGson {
    
    ArrayList<Persona> personas = new ArrayList<>();

    public ArrayList<Persona> getPersonas() {
        return personas;
    }

    public void setPersonas(ArrayList<Persona> personas) {
        this.personas = personas;
    }
    
    
    public void crearGson(){
       try {
            
            if(personas.size()!=0){ //Revisar que existan rectangulos
                String nombreArchivo = "personas.json";
                GsonBuilder gsonBuilder = new GsonBuilder();
                Gson gson = gsonBuilder.create();
                Writer writer = new FileWriter(nombreArchivo); //Crea el archivo gson en la ruta especifica
                gson.toJson(personas, writer); //Crea el json
                writer.close(); 
            }
            
        } catch (IOException iOException) {
        } catch (JsonIOException jsonIOException) {
        }
        
    }
    
    public void leerJson(){
        
        try {
            //Se lee el archivo 
            BufferedReader bufferedReader = new BufferedReader(new FileReader("personas.json"));
            //creamos un gson para luego transformar el archivo en tipo json
            Gson gson2 = new Gson();
            //guardamos en un objeto el archivo convertido en json
            Object jsonLeido = gson2.fromJson(bufferedReader, Object.class);
            //creamos un String para convertir nuevamente el json en una cadena
            String jsonPersonas = gson2.toJson(jsonLeido);
            //creamos un parser para convertir de array a jsonElement
            JsonParser parser = new JsonParser();
            //Hacemos el parse
            JsonElement datos = parser.parse(jsonPersonas);
            bufferedReader.close();

            
            Type type = new TypeToken<ArrayList<Persona>>() {
            }.getType();

            
            ArrayList<Persona> inpList = new Gson().fromJson(datos, type);
            setPersonas(inpList);
            
        } catch (FileNotFoundException fileNotFound) {
            System.out.println("No se ha encontrado el archivo");
            
        } catch (IOException ex) {
            Logger.getLogger(guardadoGson.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    
    
}
