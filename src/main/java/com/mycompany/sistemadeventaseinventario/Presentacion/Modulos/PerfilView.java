/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.sistemadeventaseinventario.Presentacion.Modulos;

import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatMTMaterialLighterIJTheme;
import com.mycompany.sistemadeventaseinventario.DAOImplementacion.DAOUsuariosImpl;
import com.mycompany.sistemadeventaseinventario.Presentacion.Modulos.FormsAdd.AddNewPassword;
import com.mycompany.sistemadeventaseinventario.Presentacion.Modulos.FormsAdd.AddNuevoUsuarios;
import com.mycompany.sistemadeventaseinventario.Entidades.Usuario;
import com.mycompany.sistemadeventaseinventario.PersistenciaDAO.DAOUsuarios;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/**
 * Clase para mostrar y manipular los datos de usuario en el panelContent
 *
 * @author Frank
 */
public class PerfilView extends javax.swing.JPanel {

    Usuario usuarioActual = null;

    /**
     * Constructor del panel de perfil del usuario. Inicializa los estilos y
     * muestra los datos del usuario.
     *
     * @param user Usuario actual que ha iniciado sesión.
     */
    public PerfilView(Usuario user) {
        this.usuarioActual = user;
        initComponents();
        initStyles();
        mostrardatosUser();
    }

    /**
     * Establecer el estilo visual del panel, incluyendo visibilidad de botones
     * según el rol del usuario.
     */
    private void initStyles() {

        /* Inicializacion de la libreria flatlaf para los estilos del sistema  */
        FlatMTMaterialLighterIJTheme.setup();

        /*Validacion para poder mostrar el boton de agregar un nuevo usuario*/
        if (usuarioActual.getRol().equalsIgnoreCase("admin")) {
            btnNuevoUsuario.setVisible(true);
        } else {
            btnNuevoUsuario.setVisible(false);
        }

    }

    /**
     * Muestra los datos del usuario actual en los campos de texto del
     * formulario.
     */
    private void mostrardatosUser() {

        txtnombre.setText(usuarioActual.getNombres());
        txtApellido1.setText(usuarioActual.getPrimer_apellido());
        txtApellido2.setText(usuarioActual.getSegundo_apellido());
        txtdni.setText(usuarioActual.getDNI());
        txtcorreo.setText(usuarioActual.getCorreo());
        txtPassword.setText(usuarioActual.getContrasenia());

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BackGround = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        btnNuevoUsuario = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtnombre = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtApellido2 = new javax.swing.JTextField();
        txtApellido1 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtcorreo = new javax.swing.JTextField();
        txtdni = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        btnCambiarPas = new javax.swing.JButton();
        txtPassword = new javax.swing.JPasswordField();

        setLayout(new java.awt.BorderLayout());

        BackGround.setBackground(new java.awt.Color(245, 250, 254));
        BackGround.setPreferredSize(new java.awt.Dimension(830, 423));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        btnNuevoUsuario.setBackground(new java.awt.Color(153, 153, 153));
        btnNuevoUsuario.setForeground(new java.awt.Color(51, 51, 51));
        btnNuevoUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources_img/person_add_30dp_F3F3F3_FILL0_wght400_GRAD0_opsz24.png"))); // NOI18N
        btnNuevoUsuario.setText("Nuevo usuario");
        btnNuevoUsuario.setBorderPainted(false);
        btnNuevoUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoUsuarioActionPerformed(evt);
            }
        });

        btnGuardar.setBackground(new java.awt.Color(153, 153, 153));
        btnGuardar.setForeground(new java.awt.Color(51, 51, 51));
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources_img/save_30dp_FFFFFF_FILL0_wght400_GRAD0_opsz24.png"))); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.setBorderPainted(false);
        btnGuardar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnGuardar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnGuardar.setIconTextGap(18);
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnNuevoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar)
                    .addComponent(btnNuevoUsuario))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setBackground(new java.awt.Color(0, 0, 0));
        jLabel3.setFont(new java.awt.Font("Roboto", 0, 28)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("Datos Personales");

        txtnombre.setBackground(new java.awt.Color(255, 255, 255));
        txtnombre.setForeground(new java.awt.Color(51, 51, 51));
        txtnombre.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(51, 51, 51)));

        jLabel4.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("Nombres");

        txtApellido2.setBackground(new java.awt.Color(255, 255, 255));
        txtApellido2.setForeground(new java.awt.Color(51, 51, 51));
        txtApellido2.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(51, 51, 51)));

        txtApellido1.setBackground(new java.awt.Color(255, 255, 255));
        txtApellido1.setForeground(new java.awt.Color(51, 51, 51));
        txtApellido1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(51, 51, 51)));

        jLabel5.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setText("Primer Apellido");

        jLabel6.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setText("Segundo Apellido");

        txtcorreo.setBackground(new java.awt.Color(255, 255, 255));
        txtcorreo.setForeground(new java.awt.Color(51, 51, 51));
        txtcorreo.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(51, 51, 51)));

        txtdni.setEditable(false);
        txtdni.setBackground(new java.awt.Color(255, 255, 255));
        txtdni.setForeground(new java.awt.Color(51, 51, 51));
        txtdni.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(51, 51, 51)));
        txtdni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtdniActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setText("DNI");

        jLabel8.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 51, 51));
        jLabel8.setText("Correo electrónico");

        jLabel9.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(51, 51, 51));
        jLabel9.setText("Contraseña");

        btnCambiarPas.setBackground(new java.awt.Color(255, 255, 255));
        btnCambiarPas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources_img/edit_24dp_5985E1_FILL0_wght400_GRAD0_opsz24.png"))); // NOI18N
        btnCambiarPas.setBorder(null);
        btnCambiarPas.setBorderPainted(false);
        btnCambiarPas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCambiarPasActionPerformed(evt);
            }
        });

        txtPassword.setEditable(false);
        txtPassword.setBackground(new java.awt.Color(255, 255, 255));
        txtPassword.setForeground(new java.awt.Color(51, 51, 51));
        txtPassword.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(51, 51, 51)));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(423, 423, 423))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(txtnombre)
                                        .addGap(1, 1, 1))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE)
                                        .addGap(151, 151, 151))
                                    .addComponent(txtdni))
                                .addGap(40, 40, 40)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(txtcorreo, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGap(125, 125, 125))
                                            .addComponent(txtApellido1, javax.swing.GroupLayout.Alignment.LEADING))
                                        .addGap(40, 40, 40)))))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                                .addGap(97, 97, 97))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(txtApellido2, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtPassword, javax.swing.GroupLayout.Alignment.LEADING))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnCambiarPas, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap())))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtApellido1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtApellido2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7)
                        .addGap(16, 16, 16)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtcorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtdni, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnCambiarPas, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37))
        );

        javax.swing.GroupLayout BackGroundLayout = new javax.swing.GroupLayout(BackGround);
        BackGround.setLayout(BackGroundLayout);
        BackGroundLayout.setHorizontalGroup(
            BackGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BackGroundLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(BackGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        BackGroundLayout.setVerticalGroup(
            BackGroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BackGroundLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(39, Short.MAX_VALUE))
        );

        add(BackGround, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void txtdniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdniActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtdniActionPerformed
    /**
     * Muestra un formulario emergente para registrar un nuevo usuario. Visible
     * solo si el usuario actual tiene rol de administrador.
     */
    private void btnNuevoUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoUsuarioActionPerformed

        JFrame principal = (JFrame) SwingUtilities.getWindowAncestor(this);
        AddNuevoUsuarios newUser = new AddNuevoUsuarios(principal);
        newUser.setVisible(true);
        /**
         * Obtiene la ventana principal que contiene este panel y muestra el
         * formulario emergente para registrar un nuevo usuario.
         *
         * Este método obtiene la referencia al `JFrame` que actúa como
         * contenedor del panel actual usando
         * `SwingUtilities.getWindowAncestor(this)`, lo cual es necesario para
         * que el nuevo formulario modal (`AddNuevoUsuarios`) se asocie
         * correctamente a esa ventana principal.
         *
         * Luego, se crea una instancia de `AddNuevoUsuarios`, pasando esa
         * ventana como parámetro, y se hace visible con `setVisible(true)`.
         */


    }//GEN-LAST:event_btnNuevoUsuarioActionPerformed
    /**
     * Guarda los cambios realizados por el usuario en sus datos personales.
     * Actualiza la información mediante la capa DAO. Muestra mensajes de éxito
     * o error según corresponda.
     */
    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed

        try {
            // Obtener los nuevos valores del formulario
            String nuevoNombre = txtnombre.getText();
            String nuevoApellido1 = txtApellido1.getText();
            String nuevoApellido2 = txtApellido2.getText();
            String nuevoCorreo = txtcorreo.getText();

            // Actualizar el objeto usuarioActual con los nuevos valores
            usuarioActual.setNombres(nuevoNombre);
            usuarioActual.setPrimer_apellido(nuevoApellido1);
            usuarioActual.setSegundo_apellido(nuevoApellido2);
            usuarioActual.setCorreo(nuevoCorreo);

            // Actualizar en la base de datos
            DAOUsuarios dao = new DAOUsuariosImpl();
            dao.editar(usuarioActual);

             // Confirmar actualización
            JOptionPane.showMessageDialog(this, "Datos actualizados", "Actualizacion de datos", JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception e) {
            e.getMessage();
            JOptionPane.showMessageDialog(this, "Error al actualizar los datos", "ERROR", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_btnGuardarActionPerformed
    /**
     * Abre una ventana emergente para cambiar la contraseña del usuario actual.
     */
    private void btnCambiarPasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCambiarPasActionPerformed

        JFrame principal = (JFrame) SwingUtilities.getWindowAncestor(this);
        AddNewPassword newPas = new AddNewPassword(principal, usuarioActual);
        newPas.setVisible(true);


    }//GEN-LAST:event_btnCambiarPasActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel BackGround;
    private javax.swing.JButton btnCambiarPas;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnNuevoUsuario;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField txtApellido1;
    private javax.swing.JTextField txtApellido2;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtcorreo;
    private javax.swing.JTextField txtdni;
    private javax.swing.JTextField txtnombre;
    // End of variables declaration//GEN-END:variables
}
