package com.mycompany.sistemadeventaseinventario.Presentacion.Modulos.FormsAdd;

import com.mycompany.sistemadeventaseinventario.DAOImplementacion.DAOClientesImpl;
import com.mycompany.sistemadeventaseinventario.DAOImplementacion.DAOProductoImpl;
import com.mycompany.sistemadeventaseinventario.DAOImplementacion.DAOVentaImpl;
import com.mycompany.sistemadeventaseinventario.Presentacion.Modulos.Ventas;
import com.mycompany.sistemadeventaseinventario.Entidades.Cliente;
import com.mycompany.sistemadeventaseinventario.Entidades.DetalleVenta;
import com.mycompany.sistemadeventaseinventario.Entidades.Producto;
import com.mycompany.sistemadeventaseinventario.Entidades.Venta;
import com.mycompany.sistemadeventaseinventario.PersistenciaDAO.DAOClientes;
import com.mycompany.sistemadeventaseinventario.PersistenciaDAO.DAOProducto;
import com.mycompany.sistemadeventaseinventario.PersistenciaDAO.DAOVenta;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class AddNuevasVentas extends JDialog {

    private DAOProducto daoProducto = new DAOProductoImpl();
    private final Ventas ventana_ventas;

    private List<Producto> productosBusqueda;       // Para guardar los resultados de la búsqueda
    private List<DetalleVenta> carritoDeVenta;      // Para guardar los productos agregados a la venta
    private double totalVenta = 0.0;                // Para llevar la cuenta del total a pagar

    /**
     *
     * @param ventana
     *
     * Contructor para crear el formulario Dialog dentro de un Jframe
     * @param ventanaVenta
     */
    public AddNuevasVentas(JFrame ventana, Ventas ventanaVenta) {

        super(ventana, "Nueva Venta", true);
        setLocationRelativeTo(ventana);
        initComponents();
        InitStyles();
        this.carritoDeVenta = new ArrayList<>(); // Inicializar la lista del carrito
        this.ventana_ventas = ventanaVenta;
    }

    private void InitStyles() {

        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        cargarTbInven();
        cargarTbventa();
    }

    private void cargarTbInven() {

        DefaultTableModel newTable = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int colum) {
                return false;
            }
        };

        String[] Titulos = {"Nombre", "Marca", "Stock", "Precio", "Observacion"};
        newTable.setColumnIdentifiers(Titulos);

        tbMostrarProductos.setModel(newTable);
        tbMostrarProductos.getTableHeader().setReorderingAllowed(false);

    }

    private void cargarTbventa() {

        DefaultTableModel tbventa = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        String titulos[] = {"Codigo producto", "Producto", "Cantidad", "Precio", "Sub-total"};
        tbventa.setColumnIdentifiers(titulos);

        tbProdAgregadosAventa.setModel(tbventa);
        tbProdAgregadosAventa.getTableHeader().setReorderingAllowed(false);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtCliente = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbProdAgregadosAventa = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtNotasDeVentas = new javax.swing.JTextArea();
        txtBuscarproductos = new javax.swing.JTextField();
        txtCantidad = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbMostrarProductos = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        btnAgregarProd = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        btnGuardarVenta = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JButton();
        BGTotal = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel10 = new javax.swing.JLabel();
        btnQuitarProd = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setLocationByPlatform(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(242, 242, 242));

        jLabel2.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(33, 37, 41));
        jLabel2.setText("Cliente");

        txtCliente.setBackground(new java.awt.Color(254, 254, 254));
        txtCliente.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        txtCliente.setForeground(new java.awt.Color(51, 51, 51));
        txtCliente.setBorder(null);

        tbProdAgregadosAventa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tbProdAgregadosAventa);

        jLabel4.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("Buscar productos");

        jScrollPane2.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane2.setBorder(null);
        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        txtNotasDeVentas.setBackground(new java.awt.Color(254, 254, 254));
        txtNotasDeVentas.setColumns(20);
        txtNotasDeVentas.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        txtNotasDeVentas.setForeground(new java.awt.Color(51, 51, 51));
        txtNotasDeVentas.setRows(5);
        txtNotasDeVentas.setBorder(null);
        jScrollPane2.setViewportView(txtNotasDeVentas);

        txtBuscarproductos.setBackground(new java.awt.Color(254, 254, 254));
        txtBuscarproductos.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        txtBuscarproductos.setForeground(new java.awt.Color(51, 51, 51));
        txtBuscarproductos.setBorder(null);
        txtBuscarproductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarproductosActionPerformed(evt);
            }
        });

        txtCantidad.setBackground(new java.awt.Color(254, 254, 254));
        txtCantidad.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        txtCantidad.setForeground(new java.awt.Color(51, 51, 51));
        txtCantidad.setBorder(null);

        tbMostrarProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane3.setViewportView(tbMostrarProductos);

        jLabel6.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setText("de venta : ");

        btnAgregarProd.setBackground(new java.awt.Color(25, 135, 84));
        btnAgregarProd.setFont(new java.awt.Font("Roboto Condensed", 0, 16)); // NOI18N
        btnAgregarProd.setForeground(new java.awt.Color(255, 255, 255));
        btnAgregarProd.setText("Agregar Producto");
        btnAgregarProd.setBorder(null);
        btnAgregarProd.setIconTextGap(6);
        btnAgregarProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarProdActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setText("Cantidad :");

        btnCancelar.setBackground(new java.awt.Color(108, 117, 125));
        btnCancelar.setFont(new java.awt.Font("Roboto Black", 0, 12)); // NOI18N
        btnCancelar.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources_img/close_30dp_FFFFFF_FILL0_wght400_GRAD0_opsz24.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.setBorder(null);
        btnCancelar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnGuardarVenta.setBackground(new java.awt.Color(52, 152, 219));
        btnGuardarVenta.setFont(new java.awt.Font("Roboto Black", 0, 12)); // NOI18N
        btnGuardarVenta.setForeground(new java.awt.Color(255, 255, 255));
        btnGuardarVenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources_img/save_30dp_FFFFFF_FILL0_wght400_GRAD0_opsz24.png"))); // NOI18N
        btnGuardarVenta.setText("Guardar venta");
        btnGuardarVenta.setBorder(null);
        btnGuardarVenta.setBorderPainted(false);
        btnGuardarVenta.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnGuardarVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarVentaActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(51, 51, 51));
        jLabel9.setText("Productos Agregados a la venta");

        btnBuscar.setBackground(new java.awt.Color(153, 204, 255));
        btnBuscar.setFont(new java.awt.Font("Roboto Condensed", 0, 16)); // NOI18N
        btnBuscar.setForeground(new java.awt.Color(255, 255, 255));
        btnBuscar.setText("Buscar");
        btnBuscar.setBorder(null);
        btnBuscar.setIconTextGap(6);
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        BGTotal.setBackground(new java.awt.Color(204, 204, 204));

        jLabel8.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 51, 51));
        jLabel8.setText("Total a Pagar:");

        jLabel5.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setText("S/.");

        txtTotal.setBackground(new java.awt.Color(204, 204, 204));
        txtTotal.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        txtTotal.setForeground(new java.awt.Color(51, 51, 51));
        txtTotal.setText("00.00");
        txtTotal.setBorder(null);
        txtTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout BGTotalLayout = new javax.swing.GroupLayout(BGTotal);
        BGTotal.setLayout(BGTotalLayout);
        BGTotalLayout.setHorizontalGroup(
            BGTotalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BGTotalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BGTotalLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );
        BGTotalLayout.setVerticalGroup(
            BGTotalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BGTotalLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(BGTotalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(41, Short.MAX_VALUE))
        );

        jSeparator1.setBackground(new java.awt.Color(204, 204, 204));
        jSeparator1.setForeground(new java.awt.Color(242, 242, 242));

        jLabel10.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(51, 51, 51));
        jLabel10.setText("Notas");

        btnQuitarProd.setBackground(new java.awt.Color(255, 51, 51));
        btnQuitarProd.setFont(new java.awt.Font("Roboto Condensed", 0, 16)); // NOI18N
        btnQuitarProd.setForeground(new java.awt.Color(255, 255, 255));
        btnQuitarProd.setText("Quitar Producto");
        btnQuitarProd.setBorder(null);
        btnQuitarProd.setIconTextGap(6);
        btnQuitarProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitarProdActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(btnGuardarVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(264, 264, 264))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtBuscarproductos)
                                .addGap(18, 18, 18)
                                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCliente))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane2))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 431, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(BGTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnAgregarProd, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnQuitarProd, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(249, 249, 249))))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(11, 11, 11)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(244, Short.MAX_VALUE)))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(775, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBuscarproductos, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgregarProd, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnQuitarProd, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BGTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardarVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(19, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(336, 336, 336)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(327, Short.MAX_VALUE)))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                    .addContainerGap(556, Short.MAX_VALUE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(92, 92, 92)))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 620, 680));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed

        try {

            String nombreABuscar = txtBuscarproductos.getText();

            DefaultTableModel modeloTabla = (DefaultTableModel) tbMostrarProductos.getModel();
            modeloTabla.setRowCount(0);

            // La línea daoProducto.BuscarProductos(nombreABuscar) ahora hace dos cosas:
            // 1. Busca en la DB. 
            // 2. Guarda el resultado en nuestra variable de clase.
            this.productosBusqueda = daoProducto.BuscarProductos(nombreABuscar);

            if (productosBusqueda.isEmpty()) {
                JOptionPane.showMessageDialog(this, "No se encontraron productos que coincidan.", "Búsqueda", JOptionPane.INFORMATION_MESSAGE);
            } else {
                // 6. Recorrer la lista y añadir cada producto a la tabla
                for (Producto prod : productosBusqueda) {
                    Object[] fila = new Object[]{
                        // El orden debe coincidir con las columnas de cargarTbInven()
                        prod.getNombre(),
                        prod.getMarca(),
                        prod.getStock(),
                        prod.getPrecio(),
                        prod.getObservacion()
                    };
                    modeloTabla.addRow(fila);
                }
            }

        } catch (Exception e) {

            JOptionPane.showMessageDialog(this, "Ocurrió un error al buscar los productos: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }


    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnGuardarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarVentaActionPerformed

// 1. VALIDACIONES INICIALES (igual que antes)
        if (this.carritoDeVenta.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No se puede registrar una venta sin productos.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String dniCliente = txtCliente.getText().trim();
        if (dniCliente.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debe especificar el DNI del cliente.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            // 2. BUSCAR AL CLIENTE POR SU DNI USANDO EL NUEVO MÉTODO
            DAOClientes daoCliente = new DAOClientesImpl();
            Cliente clienteEncontrado = daoCliente.buscarPorDNI(dniCliente);

            // 3. VALIDAR SI EL CLIENTE EXISTE
            if (clienteEncontrado == null) {
                JOptionPane.showMessageDialog(this, "Cliente con DNI " + dniCliente + " no encontrado. Verifique el DNI o registre al cliente primero.", "Cliente no existe", JOptionPane.ERROR_MESSAGE);
                return; // Detiene la operación si el cliente no existe
            }

            // 4. SI EL CLIENTE EXISTE, PROCEDEMOS CON LA VENTA (usamos su ID)
            long milisegundos = System.currentTimeMillis();
            java.sql.Date fechaActual = new java.sql.Date(milisegundos);

            Venta nuevaVenta = new Venta();
            nuevaVenta.setId_cliente(clienteEncontrado.getId_cliente()); // <-- Usamos el ID del cliente que encontramos
            nuevaVenta.setFecha(fechaActual);
            nuevaVenta.setTotal(this.totalVenta);
            nuevaVenta.setDetalles(this.carritoDeVenta);

            DAOVenta daoVenta = new DAOVentaImpl();
            daoVenta.registrar(nuevaVenta);

            ventana_ventas.CargarTablaVentas();
            JOptionPane.showMessageDialog(this, "Venta registrada exitosamente para el cliente: " + clienteEncontrado.getNombres(), "Éxito", JOptionPane.INFORMATION_MESSAGE);
            this.dispose();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al registrar la venta: " + e.getMessage(), "Error de Base de Datos", JOptionPane.ERROR_MESSAGE);
            // Muy útil para ver el error completo en la consola
        }

    }//GEN-LAST:event_btnGuardarVentaActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed

        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnAgregarProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarProdActionPerformed

        // 1. OBTENER EL PRODUCTO SELECCIONADO DE LA TABLA SUPERIOR
        int filaSeleccionada = tbMostrarProductos.getSelectedRow();
        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un producto de la lista.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // 2. OBTENER Y VALIDAR LA CANTIDAD
        int cantidad;
        try {
            cantidad = Integer.parseInt(txtCantidad.getText());
            if (cantidad <= 0) {
                JOptionPane.showMessageDialog(this, "La cantidad debe ser mayor a cero.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "La cantidad ingresada no es un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // 3. OBTENER EL OBJETO PRODUCTO COMPLETO USANDO NUESTRA LISTA EN MEMORIA
        Producto productoSeleccionado = this.productosBusqueda.get(filaSeleccionada);

        // 4. VALIDAR EL STOCK
        if (cantidad > productoSeleccionado.getStock()) {
            JOptionPane.showMessageDialog(this, "No hay suficiente stock. Stock disponible: " + productoSeleccionado.getStock(), "Error de Stock", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // 5. VALIDAR QUE EL PRODUCTO NO ESTÉ YA EN EL CARRITO
        for (DetalleVenta detalle : carritoDeVenta) {
            if (detalle.getProducto().getId_producto() == productoSeleccionado.getId_producto()) {
                JOptionPane.showMessageDialog(this, "El producto ya fue agregado a la venta.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }

        // 6. CALCULAR SUBTOTAL Y ACTUALIZAR TOTAL
        double subtotal = cantidad * productoSeleccionado.getPrecio();
        this.totalVenta += subtotal;

        // 7. AGREGAR AL MODELO DE DATOS (AL CARRITO)
        DetalleVenta nuevoDetalle = new DetalleVenta(productoSeleccionado, cantidad, subtotal);
        this.carritoDeVenta.add(nuevoDetalle);

        // 8. AGREGAR A LA TABLA VISUAL (la tabla inferior)
        DefaultTableModel modeloVenta = (DefaultTableModel) tbProdAgregadosAventa.getModel();
        Object[] filaVenta = {
            productoSeleccionado.getId_producto(),
            productoSeleccionado.getNombre(),
            cantidad,
            String.format("%.2f", productoSeleccionado.getPrecio()),
            String.format("%.2f", subtotal)
        };
        modeloVenta.addRow(filaVenta);

        // 9. ACTUALIZAR EL CAMPO DE TEXTO DEL TOTAL
        txtTotal.setText(String.format("%.2f", this.totalVenta));

        // 10. LIMPIAR CAMPOS PARA LA SIGUIENTE ADICIÓN
        txtCantidad.setText("");
        tbMostrarProductos.clearSelection();


    }//GEN-LAST:event_btnAgregarProdActionPerformed

    private void txtBuscarproductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarproductosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarproductosActionPerformed

    private void txtTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotalActionPerformed

    private void btnQuitarProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitarProdActionPerformed

        // 1. OBTENER LA FILA SELECCIONADA DE LA TABLA DEL CARRITO (la de abajo)
        int filaSeleccionada = tbProdAgregadosAventa.getSelectedRow();

        // 2. VALIDAR QUE SE HAYA SELECCIONADO UNA FILA
        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un producto del carrito para quitarlo.", "Error", JOptionPane.ERROR_MESSAGE);
            return; // Detiene la ejecución si no hay nada seleccionado
        }

        // 3. OBTENER EL DETALLE DE VENTA ANTES DE BORRARLO PARA PODER RESTAR EL SUBTOTAL
        // Usamos nuestra lista en memoria, que es la fuente de verdad.
        DetalleVenta detalleARemover = this.carritoDeVenta.get(filaSeleccionada);

        // 4. ACTUALIZAR EL TOTAL DE LA VENTA
        this.totalVenta -= detalleARemover.getSubtotal();

        // 5. ELIMINAR EL PRODUCTO DEL CARRITO (EL MODELO DE DATOS EN MEMORIA)
        this.carritoDeVenta.remove(filaSeleccionada);

        // 6. ELIMINAR LA FILA DE LA TABLA (LA VISTA)
        DefaultTableModel modeloVenta = (DefaultTableModel) tbProdAgregadosAventa.getModel();
        modeloVenta.removeRow(filaSeleccionada);

        // 7. ACTUALIZAR EL CAMPO DE TEXTO DEL TOTAL
        txtTotal.setText(String.format("%.2f", this.totalVenta));

        JOptionPane.showMessageDialog(this, "Producto quitado de la venta.", "Éxito", JOptionPane.INFORMATION_MESSAGE);


    }//GEN-LAST:event_btnQuitarProdActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel BGTotal;
    private javax.swing.JButton btnAgregarProd;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardarVenta;
    private javax.swing.JButton btnQuitarProd;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable tbMostrarProductos;
    private javax.swing.JTable tbProdAgregadosAventa;
    private javax.swing.JTextField txtBuscarproductos;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtCliente;
    private javax.swing.JTextArea txtNotasDeVentas;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}
