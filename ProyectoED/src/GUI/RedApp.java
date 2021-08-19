/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import data.Perfil;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.filechooser.FileNameExtensionFilter;
import List.*;
import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.util.Scanner;

public class RedApp extends javax.swing.JFrame {

    //HashMap<String,Perfil> usuarios = new HashMap<String,Perfil>();
    DoubleLinkedList<Perfil> usuarios = new DoubleLinkedList<>();
    Perfil perfil;
    Perfil auxPerfil;
    ImageIcon fotoDePerfil;
    String ubicacionFoto = "";
    ImageIcon fotoDePerfilPorDefecto;
    //Perfil soporte;
            
    public RedApp() {
        initComponents();
        copiarUsuarios();
        mostrarImagen();
        fotoDePerfilPorDefecto();
        habilitarLogin();
        deshabilitarRegistro();
        deshabilitarMenuInicio();
        deshabilitarMiPerfil();
        deshabilitarPerfil();
    }
    
    private void copiarUsuarios(){
        try{
            File savefile = new File("data/usuarios10K.txt");
            if (!savefile.exists()){
                savefile.createNewFile();
            }
            Scanner sc = new Scanner(savefile);
            
            while (sc.hasNextLine()){
                String line = sc.nextLine();
//                System.out.println(line);
                String[] lineD = line.split(",");
//                for (int i = 0; i < lineD.length;i++){
//                    System.out.println(lineD[i]);
//                }
                usuarios.PushBack(new Perfil(new DoubleLinkedList<String>(), new DoubleLinkedList<String>(), lineD[3], new DoubleLinkedList<String>(), null, lineD[2], lineD[0], lineD[1], Integer.parseInt(lineD[4]), lineD[5]));
            }
            System.out.println("Terminado");
            
            sc.close();
//            ObjectInputStream oldClients = new ObjectInputStream(new FileInputStream("usuarios.txt"));
            
//            usuarios = (HashMap<String,Perfil>) oldClients.readObject();
//            usuarios = (DoubleLinkedList<Perfil>) oldClients.readObject();
//            Perfil[] perfiles = (Perfil[]) oldClients.readObject();
//            for (int i = 0; i < perfiles.length; i++){
//                usuarios.PushBack(perfiles[i]);
//            }
            
            
            /*for (Perfil aux1 : aux) {
                usuarios.put(aux1.getCorreo(), aux1);
            }*/
            
//            oldClients.close();
        }catch(FileNotFoundException e){
            System.out.println("El archivo no ha sido creado(se creara automaticamente pero no habran usuarios previos ) ");
        }catch(IOException e){
            System.out.println(e);
            
        }
    }
    /*private void soporte(){
        soporte.setNombre("Soporte");
        soporte.setApellido("");
        soporte.setEdad(0);
        soporte.setCorreo("soporte@unal.edu.co");
        soporte.setContraseña("123456");
        soporte.setGenero("");
        soporte.setFotoDePerfil(fotoDePerfilPorDefecto);
        
        ArrayList<String> listaDeAmigos;
        
        soporte.setListaDeAmigos(listaDeAmigos);
        soporte.setMuro(muro);
        soporte.setSolicitudes(solicitudes);
        
        usuarios.put(soporte.getCorreo(), soporte);
    }*/
    
    private void guardarUsuarios(){
        
        try {
            
            BufferedWriter writer = new BufferedWriter(new FileWriter("data/usuarios10K.txt"));
            
            String save = "";
            
//            for (int i = 0; i < usuarios.size; i++){
//                Perfil temp = usuarios.getItem(i);
//                save += temp.getNombre() + "," + temp.getApellido() + "," + temp.getCorreo();
//                save += "," + temp.getContraseña() + "," + temp.getGenero() + "," + temp.getEdad();
//                save += '\n';
//            }
            for (int i = 0; i < usuarios.size; i++){
                save += usuarios.getItem(i).getInfo();
                save += '\n';
            }
            
            writer.write(save);
            
            writer.flush();
            writer.close();
            
            /*File file = new File("usuarios.txt");
            file.delete();*/            
            
//            ObjectOutputStream archivoClientes = new ObjectOutputStream(new FileOutputStream("usuarios.txt"));
//            
//            archivoClientes.writeObject(usuarios);
//            archivoClientes.close();
            
        } catch(Exception e){
            System.out.println(e);
        }
        
    }
    
    private void fotoDePerfilPorDefecto(){
        ImageIcon auxImage = new ImageIcon("./fotoDePerfilPorDefecto.jpg");//ImageIcon auxImage = new ImageIcon("./sources/images/fotoDePerfilPorDefecto.jpg");
        fotoDePerfilPorDefecto = new ImageIcon(auxImage.getImage().getScaledInstance(50,50,Image.SCALE_SMOOTH));
    }
        
    private void mostrarImagen(){
        
        ImageIcon icon = new ImageIcon("./src/GUI/images/red.png");
        jlImagen.setIcon(icon);
  
    
    }
    private void habilitarLogin(){
        
        txtContraseña.setEnabled(true);
        txtCorreo.setEnabled(true);
        jbtEntrar.setEnabled(true);
        jbtRegistro.setEnabled(true);
        
    }
    private void limpiarLogin(){
        txtContraseña.setText("");
        txtCorreo.setText("");
    }
    
    private void limpiarRegistro(){
        txtCorreoReg.setText("");
        txtContraseñaReg.setText("");
        txtNombreReg.setText("");
        txtApellidoReg.setText("");
        txtEdadReg.setText("");
        rbtMasculino.setSelected(true);
    }
    
    private void deshabilitarLogin(){
        
        txtContraseña.setEnabled(false);
        txtCorreo.setEnabled(false);
        jbtEntrar.setEnabled(false);
        jbtRegistro.setEnabled(false);
    }
    
    private void habilitarRegistro(){
        txtCorreoReg.setEnabled(true);
        txtContraseñaReg.setEnabled(true);
        txtNombreReg.setEnabled(true);
        txtApellidoReg.setEnabled(true);
        txtEdadReg.setEnabled(true);
        rbtFemenino.setEnabled(true);
        rbtMasculino.setEnabled(true);
        rbtMasculino.setSelected(true);
        jbtConfirmar.setEnabled(true);
        jbtSeleccionarFoto.setEnabled(true);
        jbtRegresarReg.setEnabled(true);
       
    }
    
    private void deshabilitarRegistro(){
        txtCorreoReg.setEnabled(false);
        txtContraseñaReg.setEnabled(false);
        txtNombreReg.setEnabled(false);
        txtApellidoReg.setEnabled(false);
        txtEdadReg.setEnabled(false);
        rbtFemenino.setEnabled(false);
        rbtMasculino.setEnabled(false);
        jbtConfirmar.setEnabled(false);
        jbtSeleccionarFoto.setEnabled(false);
        jbtRegresarReg.setEnabled(false);
       
    }
    
    private void deshabilitarMenuInicio(){
        jbtMiPerfil.setEnabled(false);
        jbtMisSolicitudes.setEnabled(false);
        jbtCerrarSesion.setEnabled(false);
        jbtBuscar.setEnabled(false);
    }
    
    private void habilitarMenuInicio(){
        jbtMiPerfil.setEnabled(true);
        jbtMisSolicitudes.setEnabled(true);
        jbtCerrarSesion.setEnabled(true);
        jbtBuscar.setEnabled(true);
    }
    
    private void habilitarMiPerfil(){
        jbtInfo.setEnabled(true);
        jbtMuro.setEnabled(true);
        jbtAmigos.setEnabled(true);
        jbtRegresar.setEnabled(true);
        
    }
    
    private void deshabilitarMiPerfil(){
        jbtInfo.setEnabled(false);
        jbtMuro.setEnabled(false);
        jbtAmigos.setEnabled(false);
        jbtRegresar.setEnabled(false);
        jlbMiFotoDePerfil.setIcon(fotoDePerfilPorDefecto);
        jlbMiNombre.setText("");
    }
    private void deshabilitarMiPropioPerfil(){
        jbtInfo.setEnabled(false);
        jbtMuro.setEnabled(false);
        jbtAmigos.setEnabled(false);
        jbtRegresar.setEnabled(false);
    }
    
    private void deshabilitarPerfil(){
        jlbFotoDePerfil.setIcon(fotoDePerfilPorDefecto);
        jbtInfoPerfil.setEnabled(false);
        jbtRegresarOtro.setEnabled(false);
        jbtEliminar.setEnabled(false);
        jlbNombre.setText("");
    }
    private void habilitarPerfil(){
        
        jbtInfoPerfil.setEnabled(true);
        jbtRegresarOtro.setEnabled(true);
        jbtEliminar.setEnabled(true);
    }
    
    
        
    
    private boolean validCorreo(String correo){
        boolean b = false;
        for(int i = 0;i<correo.length();i++){
            if(correo.charAt(i)=='@'){
                for(int j = (i+1);j<correo.length();j++){
                    if(correo.charAt(j)=='.'){
                        b = true;
                        break;
                    }
                }
            }
        }
        return b;
    }
    
    
    
    
    private void pruebaImagen(){
        
    
        ImageIcon icon = new ImageIcon("./src/GUI/images/foto.jpg");
        Image scaleIcon = icon.getImage().getScaledInstance(50,50,Image.SCALE_SMOOTH);
        icon.setImage(scaleIcon);
        jlbMiFotoDePerfil.setIcon(icon);
        
    }
    
    public static boolean numberChar(char n) {
        boolean b = false;
        if (n == '1' || n == '2' || n == '3' || n == '4' || n == '5' || n == '6' || n == '7' || n == '8' || n == '9' || n == '0') {
            b = true;
        }
        return b;
    }
    
    public static boolean validStringInt(String cad) {
        boolean b = true;
        for (int i = 0; i < cad.length(); i++) {
            if (numberChar(cad.charAt(i))) {

            } else {
                b = false;
                break;
            }
        }
        return b;
    }
    
    public static int stringToInt(String cad) {
        int a = 0;
        a = Integer.parseInt(cad);

        return a;
    }
    
    private boolean validFoto(){
        boolean b = true;
            Path path;
            
        
        return b;
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jpLogin = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtCorreo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtContraseña = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        jbtRegistro = new javax.swing.JButton();
        jbtEntrar = new javax.swing.JButton();
        jlImagen = new javax.swing.JLabel();
        jpRegistro = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtCorreoReg = new javax.swing.JTextField();
        txtNombreReg = new javax.swing.JTextField();
        txtApellidoReg = new javax.swing.JTextField();
        txtEdadReg = new javax.swing.JTextField();
        txtContraseñaReg = new javax.swing.JPasswordField();
        rbtMasculino = new javax.swing.JRadioButton();
        rbtFemenino = new javax.swing.JRadioButton();
        jbtConfirmar = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jbtSeleccionarFoto = new javax.swing.JButton();
        jbtRegresarReg = new javax.swing.JButton();
        JpMenuInicio = new javax.swing.JPanel();
        jbtMiPerfil = new javax.swing.JButton();
        jbtMisSolicitudes = new javax.swing.JButton();
        jbtCerrarSesion = new javax.swing.JButton();
        jbtBuscar = new javax.swing.JButton();
        jpMiPerfil = new javax.swing.JPanel();
        jlbMiFotoDePerfil = new javax.swing.JLabel();
        jlbMiNombre = new javax.swing.JLabel();
        jbtInfo = new javax.swing.JButton();
        jbtAmigos = new javax.swing.JButton();
        jbtMuro = new javax.swing.JButton();
        jbtRegresar = new javax.swing.JButton();
        jpPerfil = new javax.swing.JPanel();
        jlbFotoDePerfil = new javax.swing.JLabel();
        jlbNombre = new javax.swing.JLabel();
        jbtRegresarOtro = new javax.swing.JButton();
        jbtInfoPerfil = new javax.swing.JButton();
        jbtEliminar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("RedSocial");

        jpLogin.setBackground(new java.awt.Color(102, 153, 255));
        jpLogin.setBorder(javax.swing.BorderFactory.createTitledBorder("Login"));
        jpLogin.setName(""); // NOI18N

        jLabel1.setText("Correo");

        jLabel2.setText("Contraseña");

        jLabel3.setText("Crear Una Cuenta");

        jbtRegistro.setText("Registro");
        jbtRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtRegistroActionPerformed(evt);
            }
        });

        jbtEntrar.setText("Entrar");
        jbtEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtEntrarActionPerformed(evt);
            }
        });

        jlImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/images/red.png"))); // NOI18N

        javax.swing.GroupLayout jpLoginLayout = new javax.swing.GroupLayout(jpLogin);
        jpLogin.setLayout(jpLoginLayout);
        jpLoginLayout.setHorizontalGroup(
            jpLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpLoginLayout.createSequentialGroup()
                .addGroup(jpLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpLoginLayout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jLabel1))
                    .addGroup(jpLoginLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2)))
                .addGap(65, 65, 65)
                .addGroup(jpLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbtEntrar)
                    .addGroup(jpLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtCorreo)
                        .addComponent(txtContraseña, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)))
                .addGroup(jpLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpLoginLayout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(jbtRegistro))
                    .addGroup(jpLoginLayout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jlImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        jpLoginLayout.setVerticalGroup(
            jpLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpLoginLayout.createSequentialGroup()
                .addGroup(jpLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpLoginLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(jpLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jpLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jlImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(70, 70, 70)
                .addComponent(jbtEntrar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jpLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtRegistro)
                    .addComponent(jLabel3))
                .addContainerGap())
        );

        jpRegistro.setBackground(new java.awt.Color(153, 153, 153));
        jpRegistro.setBorder(javax.swing.BorderFactory.createTitledBorder("Registro"));

        jLabel4.setText("Correo");

        jLabel5.setText("Nombre");

        jLabel6.setText("Apellido");

        jLabel7.setText("Edad");

        jLabel8.setText("Contraseña");

        jLabel9.setText("Genero");

        txtCorreoReg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCorreoRegActionPerformed(evt);
            }
        });

        buttonGroup1.add(rbtMasculino);
        rbtMasculino.setText("Masculino");

        buttonGroup1.add(rbtFemenino);
        rbtFemenino.setText("Femenino");

        jbtConfirmar.setText("Confirmar");
        jbtConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtConfirmarActionPerformed(evt);
            }
        });

        jLabel10.setText("Foto De Perfil");

        jbtSeleccionarFoto.setText("Seleccionar foto de Perfil");
        jbtSeleccionarFoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtSeleccionarFotoActionPerformed(evt);
            }
        });

        jbtRegresarReg.setText("Regresar");
        jbtRegresarReg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtRegresarRegActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpRegistroLayout = new javax.swing.GroupLayout(jpRegistro);
        jpRegistro.setLayout(jpRegistroLayout);
        jpRegistroLayout.setHorizontalGroup(
            jpRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpRegistroLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpRegistroLayout.createSequentialGroup()
                        .addGroup(jpRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel8)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel9))
                        .addGap(18, 18, 18)
                        .addGroup(jpRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpRegistroLayout.createSequentialGroup()
                                .addGroup(jpRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtContraseñaReg)
                                    .addComponent(txtEdadReg)
                                    .addComponent(txtApellidoReg)
                                    .addComponent(txtCorreoReg)
                                    .addComponent(txtNombreReg)
                                    .addGroup(jpRegistroLayout.createSequentialGroup()
                                        .addComponent(rbtMasculino)
                                        .addGap(18, 18, 18)
                                        .addComponent(rbtFemenino)
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addGap(32, 32, 32))
                            .addGroup(jpRegistroLayout.createSequentialGroup()
                                .addComponent(jbtSeleccionarFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(35, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpRegistroLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jpRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpRegistroLayout.createSequentialGroup()
                                .addComponent(jbtConfirmar)
                                .addGap(109, 109, 109))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpRegistroLayout.createSequentialGroup()
                                .addComponent(jbtRegresarReg)
                                .addContainerGap())))))
        );
        jpRegistroLayout.setVerticalGroup(
            jpRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpRegistroLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jpRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtCorreoReg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(jpRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombreReg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtApellidoReg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtEdadReg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtContraseñaReg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(rbtMasculino)
                    .addComponent(rbtFemenino))
                .addGap(18, 18, 18)
                .addGroup(jpRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jbtSeleccionarFoto))
                .addGap(45, 45, 45)
                .addComponent(jbtConfirmar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbtRegresarReg)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        JpMenuInicio.setBackground(new java.awt.Color(102, 153, 255));
        JpMenuInicio.setBorder(javax.swing.BorderFactory.createTitledBorder("Menu De Inicio"));

        jbtMiPerfil.setText("Mi Perfil");
        jbtMiPerfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtMiPerfilActionPerformed(evt);
            }
        });

        jbtMisSolicitudes.setText("Mis Solicitudes");
        jbtMisSolicitudes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtMisSolicitudesActionPerformed(evt);
            }
        });

        jbtCerrarSesion.setText("Cerrar Sesion");
        jbtCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtCerrarSesionActionPerformed(evt);
            }
        });

        jbtBuscar.setText("Buscar Amigos");
        jbtBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout JpMenuInicioLayout = new javax.swing.GroupLayout(JpMenuInicio);
        JpMenuInicio.setLayout(JpMenuInicioLayout);
        JpMenuInicioLayout.setHorizontalGroup(
            JpMenuInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpMenuInicioLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(JpMenuInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jbtCerrarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtMisSolicitudes, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtMiPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        JpMenuInicioLayout.setVerticalGroup(
            JpMenuInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpMenuInicioLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jbtMiPerfil)
                .addGap(34, 34, 34)
                .addComponent(jbtBuscar)
                .addGap(34, 34, 34)
                .addComponent(jbtMisSolicitudes)
                .addGap(36, 36, 36)
                .addComponent(jbtCerrarSesion)
                .addGap(84, 84, 84))
        );

        jpMiPerfil.setBackground(new java.awt.Color(102, 153, 255));
        jpMiPerfil.setBorder(javax.swing.BorderFactory.createTitledBorder("Mi Perfil"));

        jbtInfo.setText("Info");
        jbtInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtInfoActionPerformed(evt);
            }
        });

        jbtAmigos.setText("Amigos");
        jbtAmigos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtAmigosActionPerformed(evt);
            }
        });

        jbtMuro.setText("Muro");
        jbtMuro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtMuroActionPerformed(evt);
            }
        });

        jbtRegresar.setText("Regresar");
        jbtRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtRegresarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpMiPerfilLayout = new javax.swing.GroupLayout(jpMiPerfil);
        jpMiPerfil.setLayout(jpMiPerfilLayout);
        jpMiPerfilLayout.setHorizontalGroup(
            jpMiPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpMiPerfilLayout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(jpMiPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpMiPerfilLayout.createSequentialGroup()
                        .addComponent(jbtRegresar)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpMiPerfilLayout.createSequentialGroup()
                        .addComponent(jlbMiFotoDePerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jlbMiNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(123, 123, 123))))
            .addGroup(jpMiPerfilLayout.createSequentialGroup()
                .addGroup(jpMiPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jpMiPerfilLayout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jbtInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpMiPerfilLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jpMiPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jbtAmigos, javax.swing.GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE)
                            .addComponent(jbtMuro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpMiPerfilLayout.setVerticalGroup(
            jpMiPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpMiPerfilLayout.createSequentialGroup()
                .addGroup(jpMiPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpMiPerfilLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jlbMiFotoDePerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jpMiPerfilLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jlbMiNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)))
                .addComponent(jbtInfo)
                .addGap(18, 18, 18)
                .addComponent(jbtAmigos)
                .addGap(30, 30, 30)
                .addComponent(jbtMuro)
                .addGap(26, 26, 26)
                .addComponent(jbtRegresar)
                .addContainerGap())
        );

        jpPerfil.setBackground(new java.awt.Color(102, 153, 255));
        jpPerfil.setBorder(javax.swing.BorderFactory.createTitledBorder("Perfil"));
        jpPerfil.setToolTipText("");

        jbtRegresarOtro.setText("Regresar");
        jbtRegresarOtro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtRegresarOtroActionPerformed(evt);
            }
        });

        jbtInfoPerfil.setText("Info");
        jbtInfoPerfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtInfoPerfilActionPerformed(evt);
            }
        });

        jbtEliminar.setText("Eliminar");
        jbtEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtEliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpPerfilLayout = new javax.swing.GroupLayout(jpPerfil);
        jpPerfil.setLayout(jpPerfilLayout);
        jpPerfilLayout.setHorizontalGroup(
            jpPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpPerfilLayout.createSequentialGroup()
                .addGroup(jpPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpPerfilLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jlbFotoDePerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jlbNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpPerfilLayout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(jbtInfoPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jpPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbtRegresarOtro)
                    .addComponent(jbtEliminar))
                .addContainerGap())
        );
        jpPerfilLayout.setVerticalGroup(
            jpPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpPerfilLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jpPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpPerfilLayout.createSequentialGroup()
                        .addComponent(jbtEliminar)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jpPerfilLayout.createSequentialGroup()
                        .addGroup(jpPerfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jlbFotoDePerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlbNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(48, 48, 48)
                        .addComponent(jbtInfoPerfil)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbtRegresarOtro)
                        .addGap(77, 77, 77))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jpRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JpMenuInicio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jpLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jpMiPerfil, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpPerfil, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jpMiPerfil, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jpRegistro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JpMenuInicio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpPerfil, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtRegistroActionPerformed
        deshabilitarLogin();
        limpiarLogin();
        habilitarRegistro();
    }//GEN-LAST:event_jbtRegistroActionPerformed

    private void jbtEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtEntrarActionPerformed
        
        String correo = this.txtCorreo.getText();
        String contraseña = this.txtContraseña.getText();
        
        Perfil perfilEncontrado = null;
        for (int i = 0; i < usuarios.size; i++){
            Perfil temp = usuarios.getItem(i);
            if (temp.getCorreo().equals(correo)){
                perfilEncontrado = temp;
            }
        }
        
        if(correo.length()>0 && contraseña.length()>0){
            if(perfilEncontrado != null){
                perfil = perfilEncontrado;
                if(contraseña.equals(perfil.getContraseña())){
                    deshabilitarLogin();
                    limpiarLogin();
                    habilitarMenuInicio();
                    
                    
                }else{
                    JOptionPane.showMessageDialog(rootPane,"CONTRASEÑA INCORRECTA","CONTRASEÑA INCORRECTA",JOptionPane.ERROR_MESSAGE);
                }
            }else{
                JOptionPane.showMessageDialog(rootPane,"Ese correo no esta registrado en nuestro sistema","No registrado",JOptionPane.ERROR_MESSAGE);
            }
        }else{
            JOptionPane.showMessageDialog(rootPane,"Debe rellenar los campos de texto ","Campos vacios",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jbtEntrarActionPerformed

    private void jbtConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtConfirmarActionPerformed
        
        String correo = this.txtCorreoReg.getText();
        String contraseña = this.txtContraseñaReg.getText();
        String nombre = this.txtNombreReg.getText();
        String apellido = this.txtApellidoReg.getText();
        String edadaux = this.txtEdadReg.getText();
        String genero;
        int edad;
        if(this.rbtFemenino.isSelected()){
            genero = this.rbtFemenino.getText();
        }else{
            genero = this.rbtMasculino.getText();
        }
        
        Perfil perfilEncontrado = null;
        for (int i = 0; i < usuarios.size; i++){
            Perfil temp = usuarios.getItem(i);
            if (temp.getCorreo().equals(correo)){
                perfilEncontrado = temp;
            }
        }
        
        if(correo.length()>0 && contraseña.length()>0 && nombre.length()>0 && apellido.length()>0 && edadaux.length()>0 && genero.length()>0){
            if(perfilEncontrado != null){
                JOptionPane.showMessageDialog(rootPane,"el correo ingresado ya se encuentra en uso","Correo usado",JOptionPane.ERROR_MESSAGE);
                limpiarRegistro();
            }else{
                if(!validCorreo(correo)){
                    JOptionPane.showMessageDialog(rootPane,"el correo ingresado no es valido, debe tener un @ y un punto ","Correo no Valido",JOptionPane.ERROR_MESSAGE);
                    limpiarRegistro();
                }else{
                    if(!validStringInt(edadaux)){
                        JOptionPane.showMessageDialog(rootPane,"la edad ingresada se encuentra en caracteres distintos a numeros ","Edad No numerica",JOptionPane.ERROR_MESSAGE);
                        limpiarRegistro();
                    }else{
                        if(ubicacionFoto.equals("") && !validFoto()){
                            JOptionPane.showMessageDialog(rootPane,"El archivo seleccionado no es valido recomendamos archivos .jpg .png .jpeg","Archivo Seleccionado Invalido",JOptionPane.ERROR_MESSAGE);
                            limpiarRegistro();
                        }else{
                            edad = stringToInt(edadaux);
                            DoubleLinkedList<String> muro = new DoubleLinkedList<>();
                            ImageIcon auxIcon = new ImageIcon(ubicacionFoto);
                            Image scaleIcon = auxIcon.getImage().getScaledInstance(50,50,Image.SCALE_SMOOTH);
                            auxIcon.setImage(scaleIcon);
                            fotoDePerfil = auxIcon;
                            DoubleLinkedList<String> listaDeAmigos = new DoubleLinkedList<>();
                            DoubleLinkedList<String> solicitudes = new DoubleLinkedList<>();
                            perfil = new Perfil(solicitudes, muro, contraseña, listaDeAmigos, fotoDePerfil, correo, nombre, apellido, edad, genero);
                            usuarios.PushBack(perfil);
                            JOptionPane.showMessageDialog(rootPane,"PERFIL CREADO EXITOSAMENTE");
                            limpiarRegistro();
                            deshabilitarRegistro();
                            habilitarLogin();
                            ubicacionFoto = "";
                            guardarUsuarios();
                            
                        }  
                    }
                }
            
            }
        }else{
            JOptionPane.showMessageDialog(rootPane,"Al menos uno de los campos esta vacio","Campos vacios",JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_jbtConfirmarActionPerformed

    private void jbtMiPerfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtMiPerfilActionPerformed
        habilitarMiPerfil();
        jlbMiFotoDePerfil.setIcon(perfil.getFotoDePerfil());
        jlbMiNombre.setText(perfil.getNombre()+" "+perfil.getApellido());
        deshabilitarMenuInicio();
    }//GEN-LAST:event_jbtMiPerfilActionPerformed

    private void jbtMisSolicitudesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtMisSolicitudesActionPerformed
        int sizeSolicitudes = perfil.getSolicitudes().size;
        
        JFrame frameSolicitudes = new JFrame("Solicitudes");
        JPanel panelSolicitudes = new JPanel(new GridLayout(sizeSolicitudes,1));
        
        JCheckBox[] cbSolicitudes = new JCheckBox[sizeSolicitudes];
        JButton boton = new JButton();
        boton.setText("Confirmar");
        ActionListener action = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                int i = 0;
                for(JCheckBox jcb : cbSolicitudes){
                    if(jcb == null){
                        
                    }else{
                        i++;
                        if(jcb.isSelected()){
                        
                        Perfil perfilEncontrado = null;
                        for (int m = 0; m < usuarios.size; m++){
                            Perfil temp = usuarios.getItem(m);
                            if (temp.getCorreo().equals(jcb.getText())){
                                perfilEncontrado = temp;
                            }
                        }
                            
                        auxPerfil = perfilEncontrado;
                        perfil.getListaDeAmigos().PushBack(auxPerfil.getCorreo());
                        auxPerfil.getListaDeAmigos().PushBack(perfil.getCorreo());
                        
                        
                        
                        }
                        
                        
                        perfil.getSolicitudes().Erase(jcb.getText());
                        guardarUsuarios();
                        frameSolicitudes.setVisible(false);
                    }
                    if(i==0){
                        frameSolicitudes.setVisible(false);
                    }
                }
                
            }
        };
        boton.addActionListener(action);
        int i =0;
        for (int j = 0; j < perfil.getSolicitudes().size; j++){
            Perfil AuxSolicitud;
            Perfil perfilEncontrado = null;
            for (int m = 0; m < usuarios.size; m++){
                Perfil temp = usuarios.getItem(m);
                if (temp.getCorreo().equals(perfil.getSolicitudes().getItem(j))){
                    perfilEncontrado = temp;
                }
            }
            if(perfilEncontrado != null){
                AuxSolicitud = perfil;
                i++;
            }else{
                continue;
                
            }
            cbSolicitudes[i] = new JCheckBox(AuxSolicitud.getCorreo(),true);
            cbSolicitudes[i].setSelected(false);
            panelSolicitudes.add(cbSolicitudes[i]);
            
            
            
        }
        
        if(i!=0){
            panelSolicitudes.add(boton);
            frameSolicitudes.add(panelSolicitudes);
            frameSolicitudes.setSize(300,300);
            frameSolicitudes.setLocationRelativeTo(null);
            frameSolicitudes.setVisible(true);
        }else{
            frameSolicitudes.setVisible(false);
            JOptionPane.showMessageDialog(rootPane,"Usted no tiene solicitudes ","No Tiene Solicitudes",JOptionPane.ERROR_MESSAGE);
        }
        
        
    }//GEN-LAST:event_jbtMisSolicitudesActionPerformed

    private void jbtCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtCerrarSesionActionPerformed
        deshabilitarMenuInicio();
        habilitarLogin();
    }//GEN-LAST:event_jbtCerrarSesionActionPerformed

    private void jbtSeleccionarFotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtSeleccionarFotoActionPerformed
        
        FileNameExtensionFilter filter = new FileNameExtensionFilter("archivo De Imagen","jpg","png","jpeg");
        JFileChooser chooser = new JFileChooser();
        chooser.setMultiSelectionEnabled(false);
        this.setLocationRelativeTo(null);
        chooser.setFileFilter(filter);
        chooser.setDragEnabled(false);
        chooser.setDialogTitle("Seleccione su foto de perfil");
        int option = chooser.showOpenDialog(this);
        if(option == JFileChooser.APPROVE_OPTION){
            ubicacionFoto = chooser.getSelectedFile().getAbsolutePath();
        }
        
        
    }//GEN-LAST:event_jbtSeleccionarFotoActionPerformed

    private void jbtInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtInfoActionPerformed
        
        JOptionPane.showMessageDialog(rootPane,perfil.toString(),"Info",JOptionPane.INFORMATION_MESSAGE,perfil.getFotoDePerfil());
    }//GEN-LAST:event_jbtInfoActionPerformed
    
    private void jbtAmigosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtAmigosActionPerformed
        
        
        int size = perfil.getListaDeAmigos().size;
        JFrame frameAmigos = new JFrame("Amigos");
        JPanel panelAmigos = new JPanel(new GridLayout(size,1));
        final JButton[] amigos = new JButton[size];
        int i=0;
        for (int j = 0; j < perfil.getListaDeAmigos().size; j++){
            Perfil auxAmigo;
            Perfil perfilEncontrado = null;
            for (int m = 0; m < usuarios.size; m++){
                Perfil temp = usuarios.getItem(m);
                if (temp.getCorreo().equals(perfil.getListaDeAmigos().getItem(j))){
                    perfilEncontrado = temp;
                }
            }
            if(perfilEncontrado != null){
                auxAmigo = perfilEncontrado;
                amigos[i] = new JButton(auxAmigo.getNombre()+" "+auxAmigo.getApellido(),auxAmigo.getFotoDePerfil());
                ActionListener action = new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                    
                        jpPerfil.setBorder(javax.swing.BorderFactory.createTitledBorder(auxAmigo.getNombre()+" "+ auxAmigo.getApellido()));
                        auxPerfil = auxAmigo;
                        jlbFotoDePerfil.setIcon(auxAmigo.getFotoDePerfil());
                        jlbNombre.setText(auxAmigo.getNombre()+" "+auxAmigo.getApellido());
                        frameAmigos.setVisible(false);
                        deshabilitarMiPropioPerfil();
                        habilitarPerfil();
                        
                         
                      
                        
                    }
                };
                amigos[i].addActionListener(action);
                
            }else{
                amigos[i] = null;
            }
            i++;
            
            
        }
 
            if(amigos == null){
                JOptionPane.showMessageDialog(rootPane,"Usted no tiene amigos debe tener amigos para seleccionar esa opcion ","#404 not friend found ",JOptionPane.ERROR_MESSAGE);
            
            }else{
                int k=0;
                for(JButton boton : amigos){
                    
                    if(boton == null){
                        k++;
                    }else{
                        panelAmigos.add(boton);
                        k--;
                    }
                }
                if(k==size){
                    JOptionPane.showMessageDialog(rootPane,"Usted no tiene amigos debe tener amigos para seleccionar esa opcion ","#404 not friend found ",JOptionPane.ERROR_MESSAGE);
                }else{
                    frameAmigos.add(panelAmigos);
                    frameAmigos.pack();
                    int h = frameAmigos.getHeight();
                    frameAmigos.setSize(300, h);
                    frameAmigos.setLocationRelativeTo(null);
                    frameAmigos.setVisible(true);
                    
                    
                }
                    
                
            }
        
            
        
        
        
    }//GEN-LAST:event_jbtAmigosActionPerformed

    private void jbtRegresarOtroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtRegresarOtroActionPerformed
        deshabilitarPerfil();
        habilitarMiPerfil();
        jpPerfil.setBorder(javax.swing.BorderFactory.createTitledBorder("Perfil"));
    }//GEN-LAST:event_jbtRegresarOtroActionPerformed

    private void jbtInfoPerfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtInfoPerfilActionPerformed
        JOptionPane.showMessageDialog(rootPane,auxPerfil.toString(),"Info",JOptionPane.INFORMATION_MESSAGE,auxPerfil.getFotoDePerfil());
    }//GEN-LAST:event_jbtInfoPerfilActionPerformed

    private void jbtRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtRegresarActionPerformed
        deshabilitarMiPerfil();
        habilitarMenuInicio();
    }//GEN-LAST:event_jbtRegresarActionPerformed

    private void txtCorreoRegActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCorreoRegActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCorreoRegActionPerformed

    private void jbtMuroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtMuroActionPerformed
        
        JFrame frameMuro = new JFrame("Muro");
        JPanel panelMuro = new JPanel(new GridLayout(perfil.getMuro().size,1));
        JButton boton = new JButton();
        String publicaciones ="<html>";
        for (int i = 0; i < perfil.getMuro().size; i++){
            publicaciones += perfil.getMuro().getItem(i);
            publicaciones += "<p>";
        }
        publicaciones +="<html>";
        JLabel pub = new JLabel();
        pub.setText(publicaciones);
        ActionListener action = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frameadd = new JFrame("Publicacion");
                JPanel paneladd = new JPanel();
                JTextField field = new JTextField(20);
                
                field.setText("");
                
                
                JButton btConfirmarP = new JButton();
                ActionListener act = new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent q){
                    perfil.getMuro().PushBack(field.getText());
                    //guardarUsuarios();
                    frameadd.setVisible(false);
                    frameMuro.setVisible(false);
                    }
                };
                btConfirmarP.addActionListener(act);
                btConfirmarP.setText("Aceptar");
                paneladd.add(field);
                paneladd.add(btConfirmarP);
                frameadd.add(paneladd);
                field.setBounds(20,20,100,30);
                frameadd.setSize(300,300);
                paneladd.setSize(300,300);
                frameadd.setLocationRelativeTo(null);
                frameadd.setVisible(true);
                       
            }
        
        };
        boton.addActionListener(action);
        boton.setText("Publicar");
        frameMuro.setSize(800,300);
        pub.setSize(150,150);
        pub.setHorizontalAlignment(JLabel.CENTER);
        
        panelMuro.add(pub);
        panelMuro.add(boton);
        frameMuro.add(panelMuro);
        frameMuro.setLocationRelativeTo(null);
        
        frameMuro.setVisible(true);
    }//GEN-LAST:event_jbtMuroActionPerformed

    private void jbtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtBuscarActionPerformed
        JFrame frameBuscar = new JFrame("Buscar Amigos");
        JPanel panelBuscar = new JPanel();
        JTextField field = new JTextField(20);
        JButton button = new JButton();
        button.setText("Confirmar");
        field.setText("");
        ActionListener action = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                Perfil perfilEncontrado = null;
                for (int i = 0; i < usuarios.size; i++){
                    Perfil temp = usuarios.getItem(i);
                    if (temp.getCorreo().equals(field.getText())){
                        perfilEncontrado = temp;
                    }
                }
                if (!perfil.getListaDeAmigos().EmptyList()){
                    if(perfilEncontrado != null && !(perfil.getListaDeAmigos().Find(field.getText()))){
                        Perfil auxP;
                        auxP = perfilEncontrado;
                        auxP.getSolicitudes().PushBack(perfil.getCorreo());
                        JOptionPane.showMessageDialog(rootPane,auxP.toString(),"Info",JOptionPane.INFORMATION_MESSAGE,auxP.getFotoDePerfil());
                        frameBuscar.setVisible(false);
                        guardarUsuarios();
                    }else{
                        JOptionPane.showMessageDialog(rootPane,"Perfil no encontrado en nuestro sistema  o ya se encuentra en su lista de amigos","No encontrado ",JOptionPane.ERROR_MESSAGE);
                        frameBuscar.setVisible(false);
                    }
                }
                
            }
        };
        button.addActionListener(action);
        panelBuscar.add(field);
        panelBuscar.add(button);
        frameBuscar.add(panelBuscar);
        frameBuscar.pack();
        frameBuscar.setLocationRelativeTo(null);
        frameBuscar.setVisible(true);
    }//GEN-LAST:event_jbtBuscarActionPerformed

    private void jbtRegresarRegActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtRegresarRegActionPerformed
        deshabilitarRegistro();
        habilitarLogin();
    }//GEN-LAST:event_jbtRegresarRegActionPerformed

    private void jbtEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtEliminarActionPerformed
        
        String tuCorreo;
        String suCorreo;
        
        tuCorreo = perfil.getCorreo();
        suCorreo = auxPerfil.getCorreo();
        
        perfil.getListaDeAmigos().Erase(suCorreo);
        auxPerfil.getListaDeAmigos().Erase(tuCorreo);
        deshabilitarPerfil();
        habilitarMiPerfil();
        guardarUsuarios();
        jpPerfil.setBorder(javax.swing.BorderFactory.createTitledBorder("Perfil"));
        JOptionPane.showMessageDialog(rootPane,"Perfil Eliminado exitosamente de tu lista de amigos ","Perfil Eliminado ",JOptionPane.ERROR_MESSAGE);
    }//GEN-LAST:event_jbtEliminarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(RedApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RedApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RedApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RedApp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RedApp().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel JpMenuInicio;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JButton jbtAmigos;
    private javax.swing.JButton jbtBuscar;
    private javax.swing.JButton jbtCerrarSesion;
    private javax.swing.JButton jbtConfirmar;
    private javax.swing.JButton jbtEliminar;
    private javax.swing.JButton jbtEntrar;
    private javax.swing.JButton jbtInfo;
    private javax.swing.JButton jbtInfoPerfil;
    private javax.swing.JButton jbtMiPerfil;
    private javax.swing.JButton jbtMisSolicitudes;
    private javax.swing.JButton jbtMuro;
    private javax.swing.JButton jbtRegistro;
    private javax.swing.JButton jbtRegresar;
    private javax.swing.JButton jbtRegresarOtro;
    private javax.swing.JButton jbtRegresarReg;
    private javax.swing.JButton jbtSeleccionarFoto;
    private javax.swing.JLabel jlImagen;
    private javax.swing.JLabel jlbFotoDePerfil;
    private javax.swing.JLabel jlbMiFotoDePerfil;
    private javax.swing.JLabel jlbMiNombre;
    private javax.swing.JLabel jlbNombre;
    private javax.swing.JPanel jpLogin;
    private javax.swing.JPanel jpMiPerfil;
    private javax.swing.JPanel jpPerfil;
    private javax.swing.JPanel jpRegistro;
    private javax.swing.JRadioButton rbtFemenino;
    private javax.swing.JRadioButton rbtMasculino;
    private javax.swing.JTextField txtApellidoReg;
    private javax.swing.JPasswordField txtContraseña;
    private javax.swing.JPasswordField txtContraseñaReg;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtCorreoReg;
    private javax.swing.JTextField txtEdadReg;
    private javax.swing.JTextField txtNombreReg;
    // End of variables declaration//GEN-END:variables

    
}
