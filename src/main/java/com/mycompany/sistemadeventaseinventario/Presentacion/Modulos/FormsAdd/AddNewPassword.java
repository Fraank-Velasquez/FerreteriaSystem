/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package com.mycompany.sistemadeventaseinventario.Presentacion.Modulos.FormsAdd;

import com.mycompany.sistemadeventaseinventario.DAOImplementacion.DAOUsuariosImpl;
import com.mycompany.sistemadeventaseinventario.Entidades.Usuario;
import com.mycompany.sistemadeventaseinventario.PersistenciaDAO.DAOUsuarios;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * Diálogo modal para cambiar la contraseña del usuario actual.
 *
 * Esta clase extiende JDialog y permite al usuario visualizar su contraseña
 * actual (solo lectura) e ingresar una nueva. Si la nueva contraseña es válida
 * y diferente a la actual, se actualiza en la base de datos mediante el DAO.
 *
 * El formulario se muestra centrado respecto a la ventana principal.
 *
 * @author Frank
 */
public class AddNewPassword extends javax.swing.JDialog {

    private final Usuario usuarioActual;

    /**
     * Crea el diálogo para cambiar la contraseña de un usuario.
     *
     * @param ventana La ventana principal que actúa como contenedor del
     * diálogo.
     * @param usuarioActual El usuario que está autenticado actualmente y desea
     * cambiar su contraseña.
     */
    public AddNewPassword(JFrame ventana, Usuario usuarioActual) {
        super(ventana, "", true);
        /**
         * Constructor del formulario (JDialog) personalizado.
         *
         * Llama al constructor de la clase base JDialog con tres parámetros:
         *
         * @param owner La ventana padre (normalmente un JFrame) que invoca este
         * diálogo. - Permite que el diálogo se posicione relativo a esta
         * ventana. - Si el diálogo es modal, también bloquea la interacción con
         * esta ventana hasta que se cierre.
         *
         * @param title El título del diálogo (aparece en la barra superior de
         * la ventana). - Puede ser una cadena vacía ("") si no se desea mostrar
         * un título.
         *
         * @param modal Define si el diálogo es modal o no. - true: El diálogo
         * es modal (bloquea la ventana principal hasta cerrarse). - false: El
         * diálogo es no modal (permite seguir usando la ventana principal
         * mientras está abierto).
         */
        setLocationRelativeTo(ventana); // Centra el diálogo respecto a la ventana principal
        initComponents();
        this.usuarioActual = usuarioActual;
        txtActual.setText(usuarioActual.getContrasenia()); // Muestra la contraseña actual (modo lectura)
        txtNueva.requestFocus();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtActual = new javax.swing.JTextField();
        txtNueva = new javax.swing.JTextField();
        btnguardarPas = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setBackground(new java.awt.Color(0, 0, 0));
        jLabel3.setFont(new java.awt.Font("Roboto", 0, 25)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("Cambiar contraseña");

        jLabel4.setBackground(new java.awt.Color(0, 0, 0));
        jLabel4.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("Contraseña actual");

        jLabel5.setBackground(new java.awt.Color(0, 0, 0));
        jLabel5.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setText("Nueva contraseña");

        txtActual.setEditable(false);
        txtActual.setBackground(new java.awt.Color(255, 255, 255));
        txtActual.setForeground(new java.awt.Color(51, 51, 51));
        txtActual.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(51, 51, 51)));

        txtNueva.setBackground(new java.awt.Color(255, 255, 255));
        txtNueva.setForeground(new java.awt.Color(51, 51, 51));
        txtNueva.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(51, 51, 51)));

        btnguardarPas.setBackground(new java.awt.Color(153, 153, 153));
        btnguardarPas.setForeground(new java.awt.Color(51, 51, 51));
        btnguardarPas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources_img/save_30dp_FFFFFF_FILL0_wght400_GRAD0_opsz24.png"))); // NOI18N
        btnguardarPas.setText("Guardar");
        btnguardarPas.setBorderPainted(false);
        btnguardarPas.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnguardarPas.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnguardarPas.setIconTextGap(18);
        btnguardarPas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardarPasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNueva, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtActual, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addComponent(btnguardarPas, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtActual, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtNueva, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addComponent(btnguardarPas, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    /**
     * Valida que la nueva contraseña no esté vacía ni sea igual a la actual. Si
     * es válida, se actualiza en la base de datos y en el objeto en memoria. Si
     * ocurre un error, se muestra un mensaje al usuario.
     *
     */
    private void btnguardarPasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarPasActionPerformed

        String actual = txtActual.getText();
        String nueva = txtNueva.getText();

        if (nueva.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debe ingresar una contraseña", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        } else if (nueva.equals(actual)) {
            JOptionPane.showMessageDialog(this, "La nueva contraseña debe se diferente a la actual", "Error", JOptionPane.ERROR_MESSAGE);
            return;

        }

        try {
            DAOUsuarios dao = new DAOUsuariosImpl();
            dao.actualizar_password(usuarioActual, nueva);
            usuarioActual.setContrasenia(nueva); // actualiza el objeto en memoria con la nueva 
            JOptionPane.showMessageDialog(this, "Contraseña actualizada", "", JOptionPane.INFORMATION_MESSAGE);
            this.dispose();

        } catch (Exception e) {
            e.getMessage();
            JOptionPane.showMessageDialog(this, "Error al actualizar la contraseña", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnguardarPasActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnguardarPas;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtActual;
    private javax.swing.JTextField txtNueva;
    // End of variables declaration//GEN-END:variables
}
