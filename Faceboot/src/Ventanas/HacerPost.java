/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas;

import DAO.PostDAOImp;
import DAO.UsuarioDAOImp;
import Entidades.Post;
import Entidades.Usuario;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 *
 * @author juanc
 */
public class HacerPost extends javax.swing.JFrame {

    static PostDAOImp postImp;
    static Usuario usuario;
    static UsuarioDAOImp usuarioImp;
    /**
     * Creates new form HacerPost
     */
    public HacerPost(PostDAOImp postImp, Usuario usuario, UsuarioDAOImp usuarioImp) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.postImp = postImp;
        this.usuario = usuario;
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

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        areaContenido = new javax.swing.JTextArea();
        bPost = new javax.swing.JButton();
        bCancel = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        areaTags = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(850, 550));
        setSize(new java.awt.Dimension(850, 550));
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Consolas", 0, 48)); // NOI18N
        jLabel1.setText("Post");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(350, 10, 120, 70);

        areaContenido.setColumns(20);
        areaContenido.setRows(5);
        jScrollPane1.setViewportView(areaContenido);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(70, 100, 700, 220);

        bPost.setText("Post");
        bPost.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bPostActionPerformed(evt);
            }
        });
        getContentPane().add(bPost);
        bPost.setBounds(180, 400, 57, 25);

        bCancel.setText("Cancel");
        bCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCancelActionPerformed(evt);
            }
        });
        getContentPane().add(bCancel);
        bCancel.setBounds(600, 400, 71, 25);

        jLabel2.setText("Tags");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(70, 340, 28, 16);
        getContentPane().add(areaTags);
        areaTags.setBounds(110, 330, 660, 30);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCancelActionPerformed
        this.dispose();
    }//GEN-LAST:event_bCancelActionPerformed

    private void bPostActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bPostActionPerformed
        Post post = new Post();
        Date date = new Date();
        
        post.setUsuario(usuario.getUsername());
        post.setFecha(date);
        post.setContenido(areaContenido.getText());
        List<String> tags = new ArrayList<>();        
        String[] t = areaTags.getText().split(",");
        tags.addAll(Arrays.asList(t));       
        post.setTags(tags);          
        
        postImp.add(post);
        
        this.dispose();
        UsuarioLogin ul = new UsuarioLogin(usuarioImp, usuario, postImp);
        ul.setVisible(true);
        
    }//GEN-LAST:event_bPostActionPerformed

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
            java.util.logging.Logger.getLogger(HacerPost.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HacerPost.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HacerPost.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HacerPost.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HacerPost(postImp, usuario, usuarioImp).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea areaContenido;
    private javax.swing.JTextField areaTags;
    private javax.swing.JButton bCancel;
    private javax.swing.JButton bPost;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}