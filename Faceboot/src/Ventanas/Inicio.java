/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas;

import DAO.PostDAOImp;
import DAO.UsuarioDAOImp;
import Entidades.Usuario;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

/**
 *
 * @author juanc
 */
public class Inicio extends javax.swing.JFrame {

    final MongoClient mongo = new MongoClient("localhost");
    final MongoDatabase db = mongo.getDatabase("Faceboot");
    final MongoCollection<Document> users = db.getCollection("Usuarios");
    final MongoCollection<Document> posts = db.getCollection("Posts");
    final UsuarioDAOImp usuarioImp = new UsuarioDAOImp(users);
    final PostDAOImp postImp = new PostDAOImp(posts);

    /**
     * Creates new form Inicio
     */
    public Inicio() {
        initComponents();
        this.setLocationRelativeTo(null);
        errorPass.setVisible(false);
        errorUser.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        areaPassword = new javax.swing.JTextField();
        areaUsername = new javax.swing.JTextField();
        bRegister = new javax.swing.JButton();
        bLogin1 = new javax.swing.JButton();
        bUsuarios = new javax.swing.JButton();
        errorPass = new javax.swing.JLabel();
        errorUser = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(850, 550));
        setSize(new java.awt.Dimension(850, 550));
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Consolas", 0, 48)); // NOI18N
        jLabel1.setText("Faceboot");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(310, 10, 220, 70);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Password");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(210, 220, 80, 22);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Username");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(210, 160, 90, 22);

        areaPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                areaPasswordActionPerformed(evt);
            }
        });
        getContentPane().add(areaPassword);
        areaPassword.setBounds(300, 220, 240, 30);

        areaUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                areaUsernameActionPerformed(evt);
            }
        });
        getContentPane().add(areaUsername);
        areaUsername.setBounds(300, 160, 240, 30);

        bRegister.setText("Register");
        bRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bRegisterActionPerformed(evt);
            }
        });
        getContentPane().add(bRegister);
        bRegister.setBounds(450, 280, 79, 25);

        bLogin1.setText("Login");
        bLogin1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bLogin1ActionPerformed(evt);
            }
        });
        getContentPane().add(bLogin1);
        bLogin1.setBounds(310, 280, 79, 25);

        bUsuarios.setText("Usuarios");
        bUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bUsuariosActionPerformed(evt);
            }
        });
        getContentPane().add(bUsuarios);
        bUsuarios.setBounds(60, 430, 90, 25);

        errorPass.setForeground(new java.awt.Color(255, 0, 0));
        errorPass.setText("Password incorrecto");
        getContentPane().add(errorPass);
        errorPass.setBounds(560, 220, 120, 16);

        errorUser.setForeground(new java.awt.Color(255, 0, 0));
        errorUser.setText("Username incorrecto");
        getContentPane().add(errorUser);
        errorUser.setBounds(560, 160, 120, 16);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void areaPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_areaPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_areaPasswordActionPerformed

    private void areaUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_areaUsernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_areaUsernameActionPerformed

    private void bRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bRegisterActionPerformed
        RegistrarUsuario ru = new RegistrarUsuario(usuarioImp);
        ru.setVisible(true);
    }//GEN-LAST:event_bRegisterActionPerformed

    private void bUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bUsuariosActionPerformed
        Usuarios u = new Usuarios(usuarioImp);
        u.setVisible(true);
    }//GEN-LAST:event_bUsuariosActionPerformed

    private void bLogin1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bLogin1ActionPerformed
       Usuario user = new Usuario();
        try {
            user = usuarioImp.findByUsername(areaUsername.getText());
            errorUser.setVisible(false);
        } catch (Exception e) {
            errorUser.setVisible(true);            
        }
        
        if(user.getPassword().equals(areaPassword.getText())){
            UsuarioLogin ul = new UsuarioLogin(usuarioImp, user, postImp);
            ul.setVisible(true);
            this.dispose();
        }else{
            errorPass.setVisible(true);
        }
        
        
    }//GEN-LAST:event_bLogin1ActionPerformed

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
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Inicio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField areaPassword;
    private javax.swing.JTextField areaUsername;
    private javax.swing.JButton bLogin1;
    private javax.swing.JButton bRegister;
    private javax.swing.JButton bUsuarios;
    private javax.swing.JLabel errorPass;
    private javax.swing.JLabel errorUser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}
