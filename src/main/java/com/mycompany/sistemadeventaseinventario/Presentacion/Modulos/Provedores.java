package com.mycompany.sistemadeventaseinventario.Presentacion.Modulos;

import com.mycompany.sistemadeventaseinventario.DAOImplementacion.DAOProveedoresImpl;
import com.mycompany.sistemadeventaseinventario.Presentacion.Modulos.FormsAdd.AddNuevoProveedor;
import com.mycompany.sistemadeventaseinventario.Presentacion.Modulos.FormsEdit.EditProveedor;
import com.mycompany.sistemadeventaseinventario.Entidades.Proveedor;
import com.mycompany.sistemadeventaseinventario.PersistenciaDAO.DAOProveedores;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Frank
 */
public class Provedores extends javax.swing.JPanel {

    /**
     * Creates new form Provedores
     */
    public Provedores() {
        initComponents();
        cargarTabla();
    }

    public final void cargarTabla() {
        DefaultTableModel tablaProveedores = new DefaultTableModel() {

            @Override
            public boolean isCellEditable(int row, int colum) {
                return false;
            }
        };

        String titulos[] = {"codigo", "Empresa", "Contacto", "Telefono", "Email", "Productos", "Direccion"};
        tablaProveedores.setColumnIdentifiers(titulos);

        //
        try {

            DAOProveedores daoP = new DAOProveedoresImpl();
            List<Proveedor> lista = daoP.listarProveedores();

            for (Proveedor prov : lista) {

                Object[] filas = new Object[]{
                    prov.getId_proveedor(),
                    prov.getEmpresa(),
                    prov.getContacto(),
                    prov.getTelefono(),
                    prov.getEmail(),
                    prov.getProdSuministrados(),
                    prov.getDireccion()
                };

                tablaProveedores.addRow(filas);

            }

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Error al cargar proveedores: " + e.getMessage());

        }

        TbListaProveedores.setModel(tablaProveedores);
        TbListaProveedores.getTableHeader().setReorderingAllowed(false);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelProveedores = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        btnAgregarProducto = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TbListaProveedores = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        txtnombre = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        btnEditar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();

        panelProveedores.setBackground(new java.awt.Color(255, 255, 255));
        panelProveedores.setMinimumSize(new java.awt.Dimension(830, 423));
        panelProveedores.setPreferredSize(new java.awt.Dimension(830, 426));

        jLabel1.setFont(new java.awt.Font("Roboto", 0, 21)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(33, 37, 41));
        jLabel1.setText("Proveedores");

        jSeparator1.setBackground(new java.awt.Color(242, 242, 242));
        jSeparator1.setForeground(new java.awt.Color(242, 242, 242));

        btnAgregarProducto.setBackground(new java.awt.Color(32, 138, 215));
        btnAgregarProducto.setFont(new java.awt.Font("Roboto Condensed", 0, 16)); // NOI18N
        btnAgregarProducto.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregarProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources_img/add_16dp_F3F3F3_FILL0_wght400_GRAD0_opsz20.png"))); // NOI18N
        btnAgregarProducto.setText("Nuevo Proveedor");
        btnAgregarProducto.setBorder(null);
        btnAgregarProducto.setIconTextGap(6);
        btnAgregarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarProductoActionPerformed(evt);
            }
        });

        TbListaProveedores.setBorder(javax.swing.BorderFactory.createEtchedBorder(null, new java.awt.Color(204, 204, 204)));
        TbListaProveedores.setFont(new java.awt.Font("Roboto Condensed Medium", 0, 12)); // NOI18N
        TbListaProveedores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        TbListaProveedores.setRowHeight(30);
        TbListaProveedores.setRowMargin(5);
        jScrollPane1.setViewportView(TbListaProveedores);

        jLabel3.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("Buscar : ");

        txtnombre.setBackground(new java.awt.Color(242, 242, 242));
        txtnombre.setBorder(null);
        txtnombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnombreActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setText("Acciones : ");

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

        javax.swing.GroupLayout panelProveedoresLayout = new javax.swing.GroupLayout(panelProveedores);
        panelProveedores.setLayout(panelProveedoresLayout);
        panelProveedoresLayout.setHorizontalGroup(
            panelProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(panelProveedoresLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAgregarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelProveedoresLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelProveedoresLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnBuscar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 160, Short.MAX_VALUE)
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1))
                .addGap(15, 15, 15))
        );
        panelProveedoresLayout.setVerticalGroup(
            panelProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelProveedoresLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(panelProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgregarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(panelProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelProveedoresLayout.createSequentialGroup()
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(panelProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnEliminar)
                                .addComponent(btnEditar)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel3))))
                    .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelProveedores, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelProveedores, javax.swing.GroupLayout.DEFAULT_SIZE, 423, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarProductoActionPerformed

        JFrame principal = (JFrame) SwingUtilities.getWindowAncestor(this);
        AddNuevoProveedor nuevaVentanaProveedor = new AddNuevoProveedor(principal, this);
        nuevaVentanaProveedor.setVisible(true);

    }//GEN-LAST:event_btnAgregarProductoActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed

        String nombre = txtnombre.getText();

        DefaultTableModel modelT = (DefaultTableModel) TbListaProveedores.getModel();
        modelT.setRowCount(0);

        try {
            DAOProveedores daoP = new DAOProveedoresImpl();
            List<Proveedor> lista = daoP.BuscarProveedor(nombre);

            for (Proveedor prov : lista) {

                Object[] fila = new Object[]{
                    prov.getId_proveedor(),
                    prov.getEmpresa(),
                    prov.getContacto(),
                    prov.getTelefono(),
                    prov.getEmail(),
                    prov.getProdSuministrados(),
                    prov.getDireccion()
                };

                modelT.addRow(fila);
            }

            if (lista.isEmpty()) {

                JOptionPane.showMessageDialog(this, "El proveedor no existe", "", JOptionPane.INFORMATION_MESSAGE);
                cargarTabla();

            }

        } catch (Exception e) {

            e.getMessage();
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed

        int[] filasSeleccionadas = TbListaProveedores.getSelectedRows();

        if (filasSeleccionadas.length == 1) {

            int fila = filasSeleccionadas[0];

            int id_proveedor = Integer.parseInt(TbListaProveedores.getValueAt(fila, 0).toString());
            String Empresa = TbListaProveedores.getValueAt(fila, 1).toString();
            String Contacto = TbListaProveedores.getValueAt(fila, 2).toString();
            String Telefono = TbListaProveedores.getValueAt(fila, 3).toString();
            String Email = TbListaProveedores.getValueAt(fila, 4).toString();
            String ProdSuministrados = TbListaProveedores.getValueAt(fila, 5).toString();
            String Direccion = TbListaProveedores.getValueAt(fila, 6).toString();

            Proveedor provEdit = new Proveedor();
            provEdit.setId_proveedor(id_proveedor);
            provEdit.setEmpresa(Empresa);
            provEdit.setContacto(Contacto);
            provEdit.setTelefono(Telefono);
            provEdit.setEmail(Email);
            provEdit.setProdSuministrados(ProdSuministrados);
            provEdit.setDireccion(Direccion);

            JFrame ventanaEdit = (JFrame) SwingUtilities.getWindowAncestor(this);
            EditProveedor editPr = new EditProveedor(ventanaEdit, this, provEdit, id_proveedor);
            editPr.setVisible(true);

            cargarTabla();

        } else if (filasSeleccionadas.length > 1) {

            JOptionPane.showMessageDialog(this, "Debe seleccionar solo 1 registro", "", JOptionPane.ERROR_MESSAGE);
        } else {

            JOptionPane.showMessageDialog(this, "Debe seleccionar un registro a editar", "", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed

        int[] filasSeleccionada = TbListaProveedores.getSelectedRows();

        if (filasSeleccionada.length == 1 || filasSeleccionada.length > 1) {

            DAOProveedores daoP = new DAOProveedoresImpl();
            int opcion = JOptionPane.showConfirmDialog(this, "Seguro que deseas eliminar ", "", JOptionPane.YES_NO_OPTION);
            if (opcion == JOptionPane.YES_OPTION) {

                for (int i : TbListaProveedores.getSelectedRows()) {
                    try {
                        int id_cliente = (int) TbListaProveedores.getValueAt(i, 0);
                        daoP.Eliminar(id_cliente);
                        cargarTabla();
                    } catch (Exception e) {
                        e.getMessage();
                    }
                }
            }
        } else {

            JOptionPane.showMessageDialog(this, "Debes seleccionar al menos un registro", "", JOptionPane.INFORMATION_MESSAGE);

        }


    }//GEN-LAST:event_btnEliminarActionPerformed

    private void txtnombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnombreActionPerformed
        btnBuscar.doClick();
    }//GEN-LAST:event_txtnombreActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TbListaProveedores;
    private javax.swing.JButton btnAgregarProducto;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPanel panelProveedores;
    private javax.swing.JTextField txtnombre;
    // End of variables declaration//GEN-END:variables
}
