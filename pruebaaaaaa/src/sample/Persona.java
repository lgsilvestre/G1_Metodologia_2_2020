/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample;

/**
 *
 * @author Saaku
 */
public class Persona {
    
    private String nombre;
    private String descripcion;
    private String fechaNacimiento;
    private String sexo;
    private int cara;

    public Persona(String nombre, String descripcion, String fechaNacimiento, String sexo, int cara) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaNacimiento = fechaNacimiento;
        this.sexo = sexo;
        this.cara = cara;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public int getCara() {
        return cara;
    }

    public void setCara(int cara) {
        this.cara = cara;
    }
    
    
    public void mostrarPersona(){
        System.out.println("Nombre: "+nombre);
        System.out.println("Descripcion: "+descripcion);
        System.out.println("Fecha de Nacimiento: "+fechaNacimiento);
        System.out.println("Sexo: "+sexo);
        System.out.println("Id: "+cara);
    }
    
}
