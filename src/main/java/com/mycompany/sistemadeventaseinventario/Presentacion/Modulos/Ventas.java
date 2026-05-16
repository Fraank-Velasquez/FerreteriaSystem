package com.mycompany.sistemadeventaseinventario.Presentacion.Modulos;

import com.mycompany.sistemadeventaseinventario.DAOImplementacion.DAOVentaImpl;
import com.mycompany.sistemadeventaseinventario.Presentacion.Modulos.FormsAdd.AddNuevasVentas;
import com.mycompany.sistemadeventaseinventario.Presentacion.Modulos.FormsAdd.DetalleDeVenta;
import com.mycompany.sistemadeventaseinventario.Entidades.FacturasEnPDF;
import com.mycompany.sistemadeventaseinventario.PersistenciaDAO.DAOVenta;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Frank
 */
public class Ventas extends javax.swing.JPanel {

    DAOVenta daoVenta = new DAOVentaImpl();

    /**
     * Creates new form Ventas
     */
    public Ventas() {
        initComponents();
        CargarTablaVentas();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelVentas = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        btnNuevaVenta = new javax.swing.JButton();
        txtCriterioBusqueda = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TbRegistroDeVentas = new javax.swing.JTable();
        btnVerDetalle = new javax.swing.JButton();
        btnGenerarFactura = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JButton();

        panelVentas.setBackground(new java.awt.Color(255, 255, 255));
        panelVentas.setMaximumSize(new java.awt.Dimension(2147483647, 2147483647));
        panelVentas.setPreferredSize(new java.awt.Dimension(830, 423));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setMinimumSize(new java.awt.Dimension(830, 423));
        jPanel3.setPreferredSize(new java.awt.Dimension(830, 426));

        jLabel1.setFont(new java.awt.Font("Roboto", 0, 21)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(33, 37, 41));
        jLabel1.setText("Registro de Ventas");

        jSeparator1.setBackground(new java.awt.Color(242, 242, 242));
        jSeparator1.setForeground(new java.awt.Color(242, 242, 242));

        btnNuevaVenta.setBackground(new java.awt.Color(32, 138, 215));
        btnNuevaVenta.setFont(new java.awt.Font("Roboto Condensed", 0, 16)); // NOI18N
        btnNuevaVenta.setForeground(new java.awt.Color(255, 255, 255));
        btnNuevaVenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources_img/add_16dp_F3F3F3_FILL0_wght400_GRAD0_opsz20.png"))); // NOI18N
        btnNuevaVenta.setText("Nueva Venta");
        btnNuevaVenta.setBorder(null);
        btnNuevaVenta.setIconTextGap(6);
        btnNuevaVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevaVentaActionPerformed(evt);
            }
        });

        txtCriterioBusqueda.setBackground(new java.awt.Color(242, 242, 242));
        txtCriterioBusqueda.setBorder(null);
        txtCriterioBusqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCriterioBusquedaActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("Buscar : ");

        TbRegistroDeVentas.setBorder(javax.swing.BorderFactory.createEtchedBorder(null, new java.awt.Color(204, 204, 204)));
        TbRegistroDeVentas.setFont(new java.awt.Font("Roboto Condensed Medium", 0, 12)); // NOI18N
        TbRegistroDeVentas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        TbRegistroDeVentas.setRowHeight(30);
        TbRegistroDeVentas.setRowMargin(5);
        jScrollPane1.setViewportView(TbRegistroDeVentas);

        btnVerDetalle.setBackground(new java.awt.Color(242, 242, 242));
        btnVerDetalle.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        btnVerDetalle.setForeground(new java.awt.Color(51, 51, 51));
        btnVerDetalle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources_img/read_more_30dp_434343_FILL0_wght400_GRAD0_opsz24.png"))); // NOI18N
        btnVerDetalle.setText("Ver detalle");
        btnVerDetalle.setBorder(null);
        btnVerDetalle.setBorderPainted(false);
        btnVerDetalle.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnVerDetalle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerDetalleActionPerformed(evt);
            }
        });

        btnGenerarFactura.setBackground(new java.awt.Color(242, 242, 242));
        btnGenerarFactura.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        btnGenerarFactura.setForeground(new java.awt.Color(51, 51, 51));
        btnGenerarFactura.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources_img/picture_as_pdf_30dp_198754_FILL0_wght400_GRAD0_opsz24.png"))); // NOI18N
        btnGenerarFactura.setText("Generar Factura");
        btnGenerarFactura.setBorder(null);
        btnGenerarFactura.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnGenerarFactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarFacturaActionPerformed(evt);
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

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCriterioBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBuscar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnVerDetalle, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21)
                        .addComponent(btnGenerarFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1))
                .addGap(14, 14, 14))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnNuevaVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNuevaVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCriterioBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnVerDetalle, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnGenerarFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout panelVentasLayout = new javax.swing.GroupLayout(panelVentas);
        panelVentas.setLayout(panelVentasLayout);
        panelVentasLayout.setHorizontalGroup(
            panelVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelVentasLayout.setVerticalGroup(
            panelVentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelVentasLayout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 423, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelVentas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelVentas, javax.swing.GroupLayout.DEFAULT_SIZE, 429, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevaVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevaVentaActionPerformed

        JFrame principal = (JFrame) SwingUtilities.getWindowAncestor(this);
        AddNuevasVentas nuevaVenta = new AddNuevasVentas(principal, this);
        nuevaVenta.setVisible(true);


    }//GEN-LAST:event_btnNuevaVentaActionPerformed

    public final void CargarTablaVentas() {

        DefaultTableModel tablaVentas = new DefaultTableModel() {

            @Override
            public boolean isCellEditable(int row, int colum) {

                return false;

            }
        };

        String Titulos[] = {"Codigo", "Fecha", "Cliente", "DNI Cliente", "Total"};
        tablaVentas.setColumnIdentifiers(Titulos);

        try {
            List<Object[]> lista = daoVenta.listaDeVentas();

            for (Object[] fila : lista) {
                // AJUSTAR EL ÍNDICE DEL TOTAL 
                fila[4] = String.format("S/ %.2f", fila[4]); // Añadir formato de moneda
                tablaVentas.addRow(fila);
            }

        } catch (Exception e) {
            System.out.println("Error al cargar ventas: " + e.getMessage());
        }

        TbRegistroDeVentas.setModel(tablaVentas);
        TbRegistroDeVentas.getTableHeader().setReorderingAllowed(false);

    }

    public Ventas(JTable TbRegistroDeVentas, JButton btnAgregarProducto, JButton jButton2, JButton jButton3, JLabel jLabel1, JLabel jLabel2, JLabel jLabel4, JPanel jPanel3, JScrollPane jScrollPane1, JSeparator jSeparator1, JTextField jTextField1, JPanel panelVentas) {
        this.TbRegistroDeVentas = TbRegistroDeVentas;
        this.btnNuevaVenta = btnAgregarProducto;
        this.btnVerDetalle = jButton2;
        this.btnGenerarFactura = jButton3;
        this.jLabel1 = jLabel1;
        this.jLabel2 = jLabel2;
        this.jLabel4 = jLabel4;
        this.jPanel3 = jPanel3;
        this.jScrollPane1 = jScrollPane1;
        this.jSeparator1 = jSeparator1;
        this.txtCriterioBusqueda = jTextField1;
        this.panelVentas = panelVentas;
    }


    private void txtCriterioBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCriterioBusquedaActionPerformed

        btnBuscar.doClick();


    }//GEN-LAST:event_txtCriterioBusquedaActionPerformed

    private void btnGenerarFacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarFacturaActionPerformed

// validación de selección única
        int[] filasSeleccionadas = TbRegistroDeVentas.getSelectedRows();
        if (filasSeleccionadas.length != 1) {
            JOptionPane.showMessageDialog(this, "Por favor, seleccione una única venta para generar su factura.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            int idVenta = (int) TbRegistroDeVentas.getValueAt(filasSeleccionadas[0], 0);

            FacturasEnPDF pdfService = new FacturasEnPDF();

            // Llamamos al método para generar el PDF
            String rutaArchivo = pdfService.generarFactura(idVenta);

            // Informamos al usuario que todo salió bien
            JOptionPane.showMessageDialog(this,
                    "Factura generada exitosamente.\nArchivo guardado en: " + rutaArchivo,
                    "Éxito",
                    JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al generar la factura en PDF: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }


    }//GEN-LAST:event_btnGenerarFacturaActionPerformed

    private void btnVerDetalleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerDetalleActionPerformed

        // OBTENER UN ARRAY CON TODAS LAS FILAS SELECCIONADAS
        int[] filasSeleccionadas = TbRegistroDeVentas.getSelectedRows();

        // VALIDAR EL NÚMERO DE FILAS SELECCIONADAS
        if (filasSeleccionadas.length == 0) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar una venta para ver sus detalles.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (filasSeleccionadas.length > 1) {
            JOptionPane.showMessageDialog(this, "Por favor, seleccione solo UNA venta para ver los detalles.", "Selección Múltiple", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            // Obtenemos el índice de la única fila seleccionada
            int filaUnica = filasSeleccionadas[0];

            // Obtenemos el ID de la venta de la columna 0 de esa fila
            int idVenta = (int) TbRegistroDeVentas.getValueAt(filaUnica, 0);

            // Abrimos el JDialog del detalle, pasándole el ID
            JFrame principal = (JFrame) SwingUtilities.getWindowAncestor(this);
            DetalleDeVenta detalleDialogo = new DetalleDeVenta(principal, idVenta);
            detalleDialogo.setVisible(true);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al intentar mostrar los detalles: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }


    }//GEN-LAST:event_btnVerDetalleActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed

        try {
            String criterio = txtCriterioBusqueda.getText().trim();

            // Si el campo está vacío, mostramos todas las ventas 
            if (criterio.isEmpty()) {
                CargarTablaVentas();
                return;
            }

            // Obtenemos el modelo de la tabla
            DefaultTableModel modelo = (DefaultTableModel) TbRegistroDeVentas.getModel();
            modelo.setRowCount(0); // Limpiamos la tabla para los nuevos resultados

            // Llamamos al método del DAO
            List<Object[]> lista = daoVenta.buscar(criterio);

            if (lista.isEmpty()) {
                JOptionPane.showMessageDialog(this, "No se encontraron ventas que coincidan con el criterio.", "Búsqueda", JOptionPane.INFORMATION_MESSAGE);
            } else {
                // Llenamos la tabla con los resultados
                for (Object[] fila : lista) {
                    fila[4] = String.format("S/ %.2f", fila[4]);
                    modelo.addRow(fila);
                }
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Ocurrió un error al buscar las ventas: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }


    }//GEN-LAST:event_btnBuscarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TbRegistroDeVentas;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnGenerarFactura;
    private javax.swing.JButton btnNuevaVenta;
    private javax.swing.JButton btnVerDetalle;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPanel panelVentas;
    private javax.swing.JTextField txtCriterioBusqueda;
    // End of variables declaration//GEN-END:variables
}
