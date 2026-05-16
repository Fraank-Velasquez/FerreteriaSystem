package com.mycompany.sistemadeventaseinventario.Presentacion.Modulos;

import com.mycompany.sistemadeventaseinventario.DAOImplementacion.DAOClientesImpl;
import com.mycompany.sistemadeventaseinventario.Presentacion.Modulos.FormsAdd.AddNuevoClientes;
import com.mycompany.sistemadeventaseinventario.Presentacion.Modulos.FormsEdit.EditClientes;
import com.mycompany.sistemadeventaseinventario.Entidades.Cliente;
import com.mycompany.sistemadeventaseinventario.PersistenciaDAO.DAOClientes;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Frank
 */
public class Clientes extends javax.swing.JPanel {

    /**
     * Creates new form Clien_proved
     */
    public Clientes() {
        initComponents();
        cargarTablaClientes();

    }

    public final void cargarTablaClientes() {

        DefaultTableModel tablaClientes = new DefaultTableModel() {

            @Override
            public boolean isCellEditable(int row, int colum) {
                return false;
            }
        };

        String titulos[] = {"Codigo", "Nombres", "DNI", "Telefono", "Email", "Dirección"};
        tablaClientes.setColumnIdentifiers(titulos);

        //cargar tabla desde la DB
        try {

            DAOClientes daoc = new DAOClientesImpl();
            List<Cliente> lista = daoc.listarClientes();

            for (Cliente cl : lista) {

                Object[] filas = new Object[]{
                    cl.getId_cliente(),
                    cl.getNombres(),
                    cl.getDNI(),
                    cl.getTelefono(),
                    cl.getEmail(),
                    cl.getDireccion()

                };

                tablaClientes.addRow(filas);

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al cargar productos: " + e.getMessage());

        }

        TbListaProductos.setModel(tablaClientes);
        TbListaProductos.getTableHeader().setReorderingAllowed(false);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelClientes = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        btnAgregarProducto = new javax.swing.JButton();
        txtDNI = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TbListaProductos = new javax.swing.JTable();
        btnEditar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JButton();

        PanelClientes.setBackground(new java.awt.Color(255, 255, 255));
        PanelClientes.setMinimumSize(new java.awt.Dimension(830, 423));
        PanelClientes.setPreferredSize(new java.awt.Dimension(830, 426));

        jLabel1.setFont(new java.awt.Font("Roboto", 0, 21)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(33, 37, 41));
        jLabel1.setText("Clientes ");

        jSeparator1.setBackground(new java.awt.Color(242, 242, 242));
        jSeparator1.setForeground(new java.awt.Color(242, 242, 242));

        btnAgregarProducto.setBackground(new java.awt.Color(32, 138, 215));
        btnAgregarProducto.setFont(new java.awt.Font("Roboto Condensed", 0, 16)); // NOI18N
        btnAgregarProducto.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregarProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources_img/add_16dp_F3F3F3_FILL0_wght400_GRAD0_opsz20.png"))); // NOI18N
        btnAgregarProducto.setText("Nuevo Cliente");
        btnAgregarProducto.setBorder(null);
        btnAgregarProducto.setIconTextGap(6);
        btnAgregarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarProductoActionPerformed(evt);
            }
        });

        txtDNI.setBackground(new java.awt.Color(242, 242, 242));
        txtDNI.setForeground(new java.awt.Color(153, 153, 153));
        txtDNI.setBorder(null);
        txtDNI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDNIActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("Buscar : ");

        TbListaProductos.setBorder(javax.swing.BorderFactory.createEtchedBorder(null, new java.awt.Color(204, 204, 204)));
        TbListaProductos.setFont(new java.awt.Font("Roboto Condensed Medium", 0, 12)); // NOI18N
        TbListaProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        TbListaProductos.setRowHeight(30);
        TbListaProductos.setRowMargin(5);
        jScrollPane1.setViewportView(TbListaProductos);

        btnEditar.setBackground(new java.awt.Color(242, 242, 242));
        btnEditar.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        btnEditar.setForeground(new java.awt.Color(51, 51, 51));
        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources_img/edit_square_30dp_5084C1_FILL0_wght400_GRAD0_opsz24.png"))); // NOI18N
        btnEditar.setText("Editar");
        btnEditar.setBorder(null);
        btnEditar.setBorderPainted(false);
        btnEditar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnEliminar.setBackground(new java.awt.Color(242, 242, 242));
        btnEliminar.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        btnEliminar.setForeground(new java.awt.Color(51, 51, 51));
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources_img/delete_30dp_RGB(220, 53, 69)_FILL0_wght400_GRAD0_opsz24.png"))); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.setBorder(null);
        btnEliminar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("Acciones : ");

        btnBuscar.setBackground(new java.awt.Color(255, 255, 255));
        btnBuscar.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        btnBuscar.setForeground(new java.awt.Color(51, 51, 51));
        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources_img/search_30dp_000000_FILL0_wght400_GRAD0_opsz24.png"))); // NOI18N
        btnBuscar.setBorder(null);
        btnBuscar.setBorderPainted(false);
        btnBuscar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelClientesLayout = new javax.swing.GroupLayout(PanelClientes);
        PanelClientes.setLayout(PanelClientesLayout);
        PanelClientesLayout.setHorizontalGroup(
            PanelClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(PanelClientesLayout.createSequentialGroup()
                .addGroup(PanelClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelClientesLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAgregarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelClientesLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(PanelClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelClientesLayout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtDNI, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnBuscar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 102, Short.MAX_VALUE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1))))
                .addGap(14, 14, 14))
        );
        PanelClientesLayout.setVerticalGroup(
            PanelClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelClientesLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(PanelClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgregarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addGroup(PanelClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelClientesLayout.createSequentialGroup()
                        .addGroup(PanelClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtDNI, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(13, 13, 13)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 291, Short.MAX_VALUE))
                    .addGroup(PanelClientesLayout.createSequentialGroup()
                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelClientes, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 836, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelClientes, javax.swing.GroupLayout.DEFAULT_SIZE, 433, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarProductoActionPerformed

        JFrame principal = (JFrame) SwingUtilities.getWindowAncestor(this);
        AddNuevoClientes nuevoClienteVentana = new AddNuevoClientes(principal, this);
        nuevoClienteVentana.setVisible(true);


    }//GEN-LAST:event_btnAgregarProductoActionPerformed

    private void txtDNIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDNIActionPerformed

       /** if (!txtDNI.getText().isEmpty()) {
            txtDNI.setText("");
            txtDNI.setForeground(Color.BLACK);
        }
        if (txtDNI.getText().isEmpty()) {
            txtDNI.setText("Ingrese el DNI del cliente");
        }**/
        btnBuscar.doClick();

    }//GEN-LAST:event_txtDNIActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed

        int[] filasSeleccionada = TbListaProductos.getSelectedRows();

        if (filasSeleccionada.length == 1 || filasSeleccionada.length > 1) {

            DAOClientes daoc = new DAOClientesImpl();
            int opcion = JOptionPane.showConfirmDialog(this, "Seguro que deseas eliminar ", "", JOptionPane.YES_NO_OPTION);
            if (opcion == JOptionPane.YES_OPTION) {

                for (int i : TbListaProductos.getSelectedRows()) {
                    try {
                        int id_cliente = (int) TbListaProductos.getValueAt(i, 0);
                        daoc.Eliminar(id_cliente);
                        cargarTablaClientes();
                    } catch (Exception e) {
                        e.getMessage();
                    }
                }
            }
        } else {

            JOptionPane.showMessageDialog(this, "Debes seleccionar al menos un registro", "", JOptionPane.INFORMATION_MESSAGE);

        }


    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed

        String Dni = txtDNI.getText();

        DefaultTableModel modelT = (DefaultTableModel) TbListaProductos.getModel();
        modelT.setRowCount(0);

        try {
            DAOClientes daoC = new DAOClientesImpl();
            List<Cliente> lista = daoC.BuscarClientes(Dni);

            for (Cliente cli : lista) {

                Object[] fila = new Object[]{
                    cli.getId_cliente(),
                    cli.getNombres(),
                    cli.getDNI(),
                    cli.getTelefono(),
                    cli.getEmail(),
                    cli.getDireccion()
                };

                modelT.addRow(fila);
            }

            if (lista.isEmpty()) {

                JOptionPane.showMessageDialog(this, "El cliente no existe", "", JOptionPane.INFORMATION_MESSAGE);
                cargarTablaClientes();

            }

        } catch (Exception e) {

            e.getMessage();
        }

    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed

        int[] filasSelecciondas = TbListaProductos.getSelectedRows();

        if (filasSelecciondas.length == 1) {

            int fila = filasSelecciondas[0];

            int id_cliente = Integer.parseInt(TbListaProductos.getValueAt(fila, 0).toString());
            String Nombres = TbListaProductos.getValueAt(fila, 1).toString();
            String DNI = TbListaProductos.getValueAt(fila, 2).toString();
            String Telefono = TbListaProductos.getValueAt(fila, 3).toString();
            String Email = TbListaProductos.getValueAt(fila, 4).toString();
            String Direccion = TbListaProductos.getValueAt(fila, 5).toString();

            Cliente client = new Cliente();
            client.setNombres(Nombres);
            client.setDNI(DNI);
            client.setTelefono(Telefono);
            client.setEmail(Email);
            client.setDireccion(Direccion);

            JFrame ventanaEdit = (JFrame) SwingUtilities.getWindowAncestor(this);
            EditClientes editCl = new EditClientes(ventanaEdit, this, client, id_cliente);
            editCl.setVisible(true);

            cargarTablaClientes();

        } else if (filasSelecciondas.length > 1) {

            JOptionPane.showMessageDialog(this, "Debe seleccionar solo 1 registro", "", JOptionPane.ERROR_MESSAGE);
        } else {

            JOptionPane.showMessageDialog(this, "Debe seleccionar un registro a editar", "", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_btnEditarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelClientes;
    private javax.swing.JTable TbListaProductos;
    private javax.swing.JButton btnAgregarProducto;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField txtDNI;
    // End of variables declaration//GEN-END:variables

}
