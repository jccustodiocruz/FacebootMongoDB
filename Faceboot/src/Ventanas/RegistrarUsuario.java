/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas;

import DAO.UsuarioDAOImp;
import Entidades.Usuario;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 *
 * @author juanc
 */
public class RegistrarUsuario extends javax.swing.JFrame {
    
    static UsuarioDAOImp usuarioImp;

    /**
     * Creates new form RegistrarUsuario
     */
    public RegistrarUsuario(UsuarioDAOImp usuarioImp) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.usuarioImp = usuarioImp;

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgSexo = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        areaNombre = new javax.swing.JTextField();
        areaGPelicula = new javax.swing.JTextField();
        areaPassword = new javax.swing.JTextField();
        areaUsername = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        cbDia = new javax.swing.JComboBox();
        cbMes = new javax.swing.JComboBox();
        areaAnio = new javax.swing.JTextField();
        bRegistrar = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        areaEdad = new javax.swing.JTextField();
        areaGMusica = new javax.swing.JTextField();
        femenino = new javax.swing.JRadioButton();
        masculino = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(850, 550));
        setSize(new java.awt.Dimension(850, 550));
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Consolas", 0, 48)); // NOI18N
        jLabel1.setText("Usuario Faceboot");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(220, 10, 420, 70);

        jLabel2.setText("Géneros de Película");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(60, 380, 120, 16);

        jLabel3.setText("Nombre");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(80, 100, 50, 16);

        jLabel4.setText("Username");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(80, 140, 60, 16);

        jLabel5.setText("Password");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(80, 180, 60, 16);

        jLabel6.setText("Edad");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(90, 220, 60, 16);

        jLabel7.setText("Sexo");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(90, 260, 60, 16);
        getContentPane().add(areaNombre);
        areaNombre.setBounds(180, 100, 590, 30);
        getContentPane().add(areaGPelicula);
        areaGPelicula.setBounds(180, 380, 590, 30);
        getContentPane().add(areaPassword);
        areaPassword.setBounds(180, 180, 590, 30);
        getContentPane().add(areaUsername);
        areaUsername.setBounds(180, 140, 590, 30);

        jLabel8.setText("Año");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(390, 300, 30, 16);

        jLabel9.setText("Día");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(180, 300, 18, 16);

        jLabel10.setText("Mes");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(280, 300, 41, 16);

        cbDia.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
        cbDia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbDiaActionPerformed(evt);
            }
        });
        getContentPane().add(cbDia);
        cbDia.setBounds(210, 300, 60, 22);

        cbMes.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));
        cbMes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbMesActionPerformed(evt);
            }
        });
        getContentPane().add(cbMes);
        cbMes.setBounds(320, 300, 60, 22);
        getContentPane().add(areaAnio);
        areaAnio.setBounds(420, 300, 70, 30);

        bRegistrar.setText("Registrar");
        bRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bRegistrarActionPerformed(evt);
            }
        });
        getContentPane().add(bRegistrar);
        bRegistrar.setBounds(700, 450, 90, 25);

        jLabel11.setText("Fecha Nacimiento");
        getContentPane().add(jLabel11);
        jLabel11.setBounds(70, 300, 110, 16);

        jLabel12.setText("Géneros Musicales");
        getContentPane().add(jLabel12);
        jLabel12.setBounds(70, 340, 110, 16);
        getContentPane().add(areaEdad);
        areaEdad.setBounds(180, 220, 70, 30);
        getContentPane().add(areaGMusica);
        areaGMusica.setBounds(180, 340, 590, 30);

        bgSexo.add(femenino);
        femenino.setText("F");
        getContentPane().add(femenino);
        femenino.setBounds(230, 260, 50, 25);

        bgSexo.add(masculino);
        masculino.setText("M");
        getContentPane().add(masculino);
        masculino.setBounds(180, 260, 50, 25);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbDiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbDiaActionPerformed

    }//GEN-LAST:event_cbDiaActionPerformed

    private void cbMesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbMesActionPerformed

    }//GEN-LAST:event_cbMesActionPerformed

    private void bRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bRegistrarActionPerformed
        String name = areaNombre.getText();
        String username = areaUsername.getText();
        String password = areaPassword.getText();
        int edad = Integer.parseInt(areaEdad.getText());
        String sexo = null;
        if(masculino.isSelected()){
          sexo = "Masculino";  
        }else if(femenino.isSelected()){
            sexo = "Femenino";
        }        
        Date fechaNacimiento= new Date();
        fechaNacimiento.setYear(Integer.parseInt(areaAnio.getText())-1900);
        fechaNacimiento.setMonth(Integer.parseInt(cbMes.getSelectedItem().toString())-1);
        fechaNacimiento.setDate(Integer.parseInt(cbDia.getSelectedItem().toString()));    

        List<String> generosMusica = new ArrayList<>();
        List<String> generosPelicula = new ArrayList<>();
        String[] gm = areaGMusica.getText().split(",");
        String[] gp = areaGPelicula.getText().split(",");

        generosMusica.addAll(Arrays.asList(gm));
        generosPelicula.addAll(Arrays.asList(gp));
        
        Usuario usuario = new Usuario(username, password, name, edad, sexo, fechaNacimiento, generosMusica, generosPelicula);
        
        usuarioImp.add(usuario);
        this.dispose();
    }//GEN-LAST:event_bRegistrarActionPerformed

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
            java.util.logging.Logger.getLogger(RegistrarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistrarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistrarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistrarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistrarUsuario(usuarioImp).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField areaAnio;
    private javax.swing.JTextField areaEdad;
    private javax.swing.JTextField areaGMusica;
    private javax.swing.JTextField areaGPelicula;
    private javax.swing.JTextField areaNombre;
    private javax.swing.JTextField areaPassword;
    private javax.swing.JTextField areaUsername;
    private javax.swing.JButton bRegistrar;
    private javax.swing.ButtonGroup bgSexo;
    private javax.swing.JComboBox cbDia;
    private javax.swing.JComboBox cbMes;
    private javax.swing.JRadioButton femenino;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JRadioButton masculino;
    // End of variables declaration//GEN-END:variables
}
