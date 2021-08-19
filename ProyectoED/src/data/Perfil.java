
package data;

import List.DoubleLinkedList;
import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.ImageIcon;


public class Perfil extends Persona implements Serializable{
    
    private String correo;
    private ImageIcon fotoDePerfil;
//    private ArrayList<String> listaDeAmigos = new ArrayList<>();
    private DoubleLinkedList<String> listaDeAmigos = new DoubleLinkedList<>();
    private String contraseña;
//    private ArrayList<String> muro = new ArrayList<>();
    private DoubleLinkedList<String> muro = new DoubleLinkedList<>();
//    private ArrayList<String> solicitudes = new ArrayList<>();
    private DoubleLinkedList<String> solicitudes;

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public ImageIcon getFotoDePerfil() {
        return fotoDePerfil;
    }

    public void setFotoDePerfil(ImageIcon fotoDePerfil) {
        this.fotoDePerfil = fotoDePerfil;
    }

    public DoubleLinkedList<String> getListaDeAmigos() {
        return listaDeAmigos;
    }

    public void setListaDeAmigos(DoubleLinkedList<String> listaDeAmigos) {
        this.listaDeAmigos = listaDeAmigos;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public DoubleLinkedList<String> getMuro() {
        return muro;
    }

    public void setMuro(DoubleLinkedList<String> muro) {
        this.muro = muro;
    }

    public DoubleLinkedList<String> getSolicitudes() {
        return solicitudes;
    }

    public void setSolicitudes(DoubleLinkedList<String> solicitudes) {
        this.solicitudes = solicitudes;
    }
    
    
    public Perfil(DoubleLinkedList<String> solicitudes,DoubleLinkedList<String> muro,String contraseña,
    DoubleLinkedList<String> listaDeAmigos, ImageIcon fotoDePerfil, String correo, String nombre, String apellido, int edad,String genero) {
        
        
        super(nombre, apellido, edad, genero);
        this.correo = correo;
        this.fotoDePerfil = fotoDePerfil;
        this.listaDeAmigos = listaDeAmigos;
        this.contraseña = contraseña;
        this.muro = muro;
        this.solicitudes = solicitudes;
    } 
    
    public String getInfo () {
        String mostrar;
        mostrar = this.getNombre()+ "," + this.getApellido()+ "," + this.getCorreo() + "," + this.getContraseña() +
                "," + String.valueOf(this.getEdad())+"," + this.getGenero();
        
        
        return mostrar;
    }
    @Override
    public String toString(){
        
        String mostrar;
        mostrar = this.getNombre()+ "," + this.getApellido()+ "," + this.getCorreo()+ "," + this.getContraseña() +
                "," + String.valueOf(this.getEdad())+"," + this.getGenero();
        
        
        return mostrar;
    } 
}
    

