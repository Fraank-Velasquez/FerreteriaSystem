package com.mycompany.sistemadeventaseinventario.Presentacion.Principal;

import com.mycompany.sistemadeventaseinventario.Presentacion.Login.Login;
import com.mycompany.sistemadeventaseinventario.Presentacion.Modulos.Clientes;
import com.mycompany.sistemadeventaseinventario.Presentacion.Modulos.Inicio;
import com.mycompany.sistemadeventaseinventario.Presentacion.Modulos.Inventario;
import com.mycompany.sistemadeventaseinventario.Presentacion.Modulos.PerfilView;
import com.mycompany.sistemadeventaseinventario.Presentacion.Modulos.Provedores;
import com.mycompany.sistemadeventaseinventario.Presentacion.Modulos.Reportes;
import com.mycompany.sistemadeventaseinventario.Presentacion.Modulos.Ventas;
import com.mycompany.sistemadeventaseinventario.Entidades.Usuario;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Taskbar;
import java.awt.image.BufferedImage;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.border.MatteBorder;

/**
 * Clase de la ventana principal del sistema. Esta interfaz permite al usuario
 * navegar entre los módulos disponibles: inicio, inventario, ventas, clientes,
 * proveedores, reportes y perfil de usuario.
 *
 * @author Frank
 */
public class Principal extends javax.swing.JFrame {

    //Usuario actual que ha iniciado sesión.
    Usuario usuarioActual;
    //Bordes para los botones del menu lateral 
    MatteBorder bordeNormal = new MatteBorder(0, 7, 0, 0, new Color(44, 62, 80));
    MatteBorder bordeHover = new MatteBorder(0, 7, 0, 0, new Color(247, 127, 27));

    //Instancias de los módulos principales que se cargan en el panel central. //
    Inicio ini = new Inicio();
    Inventario inven = new Inventario();
    Ventas vent = new Ventas();
    Clientes client = new Clientes();
    Reportes report = new Reportes();
    Provedores proved = new Provedores();

    /**
     * Constructor principal de la ventana
     *
     * @param usuario Usuario autenticado que ha iniciado sesión
     */
    public Principal(Usuario usuario) {
        this.usuarioActual = usuario;
        initComponents();
        initStyles();
        initContent();
        iconoEnBarraTareas();
    }

    /**
     * Inicializa el contenido por defecto de la pantalla principal. Carga el
     * módulo de Inicio y muestra el nombre del rol del usuario.
     */
    private void initContent() {

        //Abrir la pantalla principal en pantalla completa
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);

        content.removeAll(); // importante cuando se realizar cambios dinamincamente en los componentes dentro de un mismo panel
        content.add(ini, BorderLayout.CENTER);
        content.revalidate(); // indica al panel que ha cambiado su contenido y necesita reiniciarse
        content.repaint(); // se usa para volver a dibujar el panel. Después de hacer cambios en los componentes, 
        //esto indica al sistema que el panel necesita ser actualizado visualmente para mostrar los cambios más recientes. 

        /* Validar e mostrar el rol del usuario que inicio session*/
        if (usuarioActual != null) {
            btnUsuario.setText(usuarioActual.getRol() + "      ▼");
        } else {
            btnUsuario.setText("NA  ▼");

        }
    }

    private void iconoEnBarraTareas() {

        try {
            String iconPath = "/resources_img/Logo-ferreteri.png"; // Se recomienda usar .png
            URL iconURL = getClass().getResource(iconPath);

            if (iconURL != null) {
                BufferedImage image = ImageIO.read(iconURL);

                // 1. Establece el icono para la ventana (esto siempre funciona)
                setIconImage(image);

                // 2. Intenta establecer el icono para la barra de tareas (con la validación correcta)
                // Primero, verificamos si la barra de tareas existe.
                if (Taskbar.isTaskbarSupported()) {
                    Taskbar taskbar = Taskbar.getTaskbar();

                    // --- ¡LA LÍNEA CLAVE DE CORRECCIÓN! ---
                    // Ahora, verificamos si la *funcionalidad específica* de cambiar el icono es compatible.
                    if (taskbar.isSupported(Taskbar.Feature.ICON_IMAGE)) {
                        taskbar.setIconImage(image);
                        System.out.println("Icono de la barra de tareas configurado exitosamente.");
                    } else {
                        System.out.println("La funcionalidad de icono en la barra de tareas no es compatible en este entorno (ej: corriendo desde el IDE).");
                    }
                }
            } else {
                System.err.println("Error: No se pudo encontrar el icono en la ruta: " + iconPath);
            }
        } catch (Exception e) {
            System.err.println("Error al cargar el icono de la aplicación: " + e.getMessage());
        }

    }

    /**
     * Aplica estilos iniciales a los botones y carga el ícono por defecto del
     * header.
     */
    private void initStyles() {

        setTitle("");
        btnInvemtario.setBorder(bordeNormal);
        btnVentas.setBorder(bordeNormal);
        btnclientes.setBorder(bordeNormal);
        btnprovedores.setBorder(bordeNormal);
        btnInicio.setBorder(bordeNormal);
        btnReportes.setBorder(bordeNormal);
        GettexIcon(btnInicio);
        InsetarNuevoIcon("/resources_img/home_40dp_2C3E50_FILL0_wght400_GRAD0_opsz40.png");

    }

    /**
     * Cambiar el ícono principal del header.
     *
     * @param rutaIcon Ruta del ícono a insertar (debe estar en la carpeta de
     * recursos).
     */
    private void InsetarNuevoIcon(String rutaIcon) {

        ImageIcon newIcon = new ImageIcon(getClass().getResource(rutaIcon));
        txtHeadder.setIcon(newIcon);

    }

    /**
     * Actualiza el texto del header superior con el nombre del botón
     * seleccionado en el menu lateral.
     *
     * @param buton Botón del cual se obtiene el texto a mostrar
     */
    private void GettexIcon(JButton buton) {

        String textto = buton.getText();
        txtHeadder.setText(textto);
        txtHeadder.setForeground(new Color(44, 62, 80));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menuUsuario = new javax.swing.JPopupMenu();
        Perfil = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        cerrarSesion = new javax.swing.JMenuItem();
        BackgroundPrincipal = new javax.swing.JPanel();
        MenuPanel = new javax.swing.JPanel();
        btnprovedores = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        btnInvemtario = new javax.swing.JButton();
        btnVentas = new javax.swing.JButton();
        btnclientes = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        btnReportes = new javax.swing.JButton();
        btnInicio = new javax.swing.JButton();
        EncabezadoPanel = new javax.swing.JPanel();
        lbFrase = new javax.swing.JLabel();
        btnUsuario = new javax.swing.JButton();
        content = new javax.swing.JPanel();
        txtHeadder = new javax.swing.JLabel();

        menuUsuario.setBackground(new java.awt.Color(242, 242, 242));
        menuUsuario.setBorder(null);

        Perfil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources_img/person_25dp_143F66_FILL0_wght400_GRAD0_opsz24.png"))); // NOI18N
        Perfil.setText("Perfil");
        Perfil.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PerfilMouseClicked(evt);
            }
        });
        Perfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PerfilActionPerformed(evt);
            }
        });
        menuUsuario.add(Perfil);
        menuUsuario.add(jSeparator2);

        cerrarSesion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources_img/logout_25dp_BB271A_FILL0_wght400_GRAD0_opsz24.png"))); // NOI18N
        cerrarSesion.setText("Cerrar sesión");
        cerrarSesion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cerrarSesionMouseClicked(evt);
            }
        });
        cerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cerrarSesionActionPerformed(evt);
            }
        });
        menuUsuario.add(cerrarSesion);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        BackgroundPrincipal.setBackground(new java.awt.Color(245, 250, 254));

        MenuPanel.setBackground(new java.awt.Color(44, 62, 80));

        btnprovedores.setBackground(new java.awt.Color(44, 62, 80));
        btnprovedores.setFont(new java.awt.Font("Roboto Medium", 0, 18)); // NOI18N
        btnprovedores.setForeground(new java.awt.Color(255, 255, 255));
        btnprovedores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources_img/delivery_truck_bolt_32dp_E3E3E3_FILL0_wght400_GRAD0_opsz40.png"))); // NOI18N
        btnprovedores.setText("Provedores");
        btnprovedores.setBorder(null);
        btnprovedores.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnprovedores.setIconTextGap(15);
        btnprovedores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnprovedoresMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnprovedoresMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnprovedoresMouseExited(evt);
            }
        });
        btnprovedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnprovedoresActionPerformed(evt);
            }
        });

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources_img/Logo-min (1) (1).png"))); // NOI18N

        jLabel5.setFont(new java.awt.Font("Roboto Black", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("FERRETERIA");

        jSeparator1.setBackground(new java.awt.Color(153, 153, 153));
        jSeparator1.setForeground(new java.awt.Color(153, 153, 153));

        btnInvemtario.setBackground(new java.awt.Color(44, 62, 80));
        btnInvemtario.setFont(new java.awt.Font("Roboto Medium", 0, 18)); // NOI18N
        btnInvemtario.setForeground(new java.awt.Color(255, 255, 255));
        btnInvemtario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources_img/inventory_32dp_E3E3E3_FILL0_wght400_GRAD0_opsz40.png"))); // NOI18N
        btnInvemtario.setText("Inventario");
        btnInvemtario.setBorder(null);
        btnInvemtario.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnInvemtario.setIconTextGap(15);
        btnInvemtario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnInvemtarioMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnInvemtarioMouseExited(evt);
            }
        });
        btnInvemtario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInvemtarioActionPerformed(evt);
            }
        });

        btnVentas.setBackground(new java.awt.Color(44, 62, 80));
        btnVentas.setFont(new java.awt.Font("Roboto Medium", 0, 18)); // NOI18N
        btnVentas.setForeground(new java.awt.Color(255, 255, 255));
        btnVentas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources_img/point_of_sale_32dp_E3E3E3_FILL0_wght400_GRAD0_opsz40_1.png"))); // NOI18N
        btnVentas.setText(" Ventas");
        btnVentas.setBorder(null);
        btnVentas.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnVentas.setIconTextGap(15);
        btnVentas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnVentasMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnVentasMouseExited(evt);
            }
        });
        btnVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVentasActionPerformed(evt);
            }
        });

        btnclientes.setBackground(new java.awt.Color(44, 62, 80));
        btnclientes.setFont(new java.awt.Font("Roboto Medium", 0, 18)); // NOI18N
        btnclientes.setForeground(new java.awt.Color(255, 255, 255));
        btnclientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources_img/contacts_product_32dp_E3E3E3_FILL0_wght400_GRAD0_opsz40.png"))); // NOI18N
        btnclientes.setText("Clientes");
        btnclientes.setBorder(null);
        btnclientes.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnclientes.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnclientes.setIconTextGap(15);
        btnclientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnclientesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnclientesMouseExited(evt);
            }
        });
        btnclientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnclientesActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Roboto Black", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(247, 127, 27));
        jLabel7.setText("EL YUNQUE");

        btnReportes.setBackground(new java.awt.Color(44, 62, 80));
        btnReportes.setFont(new java.awt.Font("Roboto Medium", 0, 18)); // NOI18N
        btnReportes.setForeground(new java.awt.Color(255, 255, 255));
        btnReportes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources_img/finance_mode_32dp_E3E3E3_FILL0_wght400_GRAD0_opsz40.png"))); // NOI18N
        btnReportes.setText("Reportes");
        btnReportes.setBorder(null);
        btnReportes.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnReportes.setIconTextGap(15);
        btnReportes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnReportesMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnReportesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnReportesMouseExited(evt);
            }
        });
        btnReportes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReportesActionPerformed(evt);
            }
        });

        btnInicio.setBackground(new java.awt.Color(44, 62, 80));
        btnInicio.setFont(new java.awt.Font("Roboto Medium", 0, 18)); // NOI18N
        btnInicio.setForeground(new java.awt.Color(255, 255, 255));
        btnInicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources_img/home_32dp_E3E3E3_FILL0_wght400_GRAD0_opsz40.png"))); // NOI18N
        btnInicio.setText("Inicio");
        btnInicio.setBorder(null);
        btnInicio.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnInicio.setIconTextGap(15);
        btnInicio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnInicioMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnInicioMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnInicioMouseExited(evt);
            }
        });
        btnInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInicioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout MenuPanelLayout = new javax.swing.GroupLayout(MenuPanel);
        MenuPanel.setLayout(MenuPanelLayout);
        MenuPanelLayout.setHorizontalGroup(
            MenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuPanelLayout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(MenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(btnInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(btnInvemtario, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(btnVentas, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(btnclientes, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(btnprovedores, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(btnReportes, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        MenuPanelLayout.setVerticalGroup(
            MenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuPanelLayout.createSequentialGroup()
                .addGroup(MenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(MenuPanelLayout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(MenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(MenuPanelLayout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MenuPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)))
                .addGroup(MenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 5, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(MenuPanelLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(btnInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(8, 8, 8)
                .addComponent(btnInvemtario, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(btnVentas, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(btnclientes, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(btnprovedores, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(btnReportes, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        EncabezadoPanel.setBackground(new java.awt.Color(255, 255, 255));
        EncabezadoPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(233, 234, 235), 2));

        lbFrase.setFont(new java.awt.Font("Roboto Condensed Medium", 0, 14)); // NOI18N
        lbFrase.setForeground(new java.awt.Color(0, 0, 0));
        lbFrase.setText("\"Cree en tu visión, trabaja con pasión y cada paso te acercará al éxito que soñaste.\"");

        btnUsuario.setBackground(new java.awt.Color(243, 255, 255));
        btnUsuario.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnUsuario.setForeground(new java.awt.Color(0, 0, 0));
        btnUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources_img/usuario.png"))); // NOI18N
        btnUsuario.setBorderPainted(false);
        btnUsuario.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnUsuario.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnUsuario.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnUsuario.setIconTextGap(3);
        btnUsuario.setMargin(new java.awt.Insets(2, 5, 2, 5));
        btnUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnUsuarioMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout EncabezadoPanelLayout = new javax.swing.GroupLayout(EncabezadoPanel);
        EncabezadoPanel.setLayout(EncabezadoPanelLayout);
        EncabezadoPanelLayout.setHorizontalGroup(
            EncabezadoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, EncabezadoPanelLayout.createSequentialGroup()
                .addGap(87, 87, 87)
                .addComponent(lbFrase, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(76, 76, 76)
                .addComponent(btnUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );
        EncabezadoPanelLayout.setVerticalGroup(
            EncabezadoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, EncabezadoPanelLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(lbFrase, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(25, 25, 25))
            .addGroup(EncabezadoPanelLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(btnUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addGap(17, 17, 17))
        );

        content.setBackground(new java.awt.Color(255, 255, 255));
        content.setLayout(new java.awt.CardLayout());

        txtHeadder.setFont(new java.awt.Font("Roboto Black", 0, 36)); // NOI18N
        txtHeadder.setForeground(new java.awt.Color(44, 62, 80));
        txtHeadder.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(247, 127, 27)));

        javax.swing.GroupLayout BackgroundPrincipalLayout = new javax.swing.GroupLayout(BackgroundPrincipal);
        BackgroundPrincipal.setLayout(BackgroundPrincipalLayout);
        BackgroundPrincipalLayout.setHorizontalGroup(
            BackgroundPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BackgroundPrincipalLayout.createSequentialGroup()
                .addComponent(MenuPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(BackgroundPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(BackgroundPrincipalLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(EncabezadoPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BackgroundPrincipalLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(BackgroundPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtHeadder, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(content, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(9, 9, 9))))
        );
        BackgroundPrincipalLayout.setVerticalGroup(
            BackgroundPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MenuPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(BackgroundPrincipalLayout.createSequentialGroup()
                .addComponent(EncabezadoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtHeadder, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(content, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(BackgroundPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(BackgroundPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Carga el panel de inicio en el contenedor principal.
     */
    private void btnInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInicioActionPerformed

        //ini.setSize(1366, 768);
        //ini.setLocation(0, 0);
        content.removeAll();
        content.add(ini, BorderLayout.CENTER);
        content.revalidate();
        content.repaint();

        GettexIcon(btnInicio);
        InsetarNuevoIcon("/resources_img/home_40dp_2C3E50_FILL0_wght400_GRAD0_opsz40.png");


    }//GEN-LAST:event_btnInicioActionPerformed
    /**
     * Restaura el borde normal del botón "Inicio" al salir el cursor.
     */
    private void btnInicioMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInicioMouseExited

        btnInicio.setBorder(bordeNormal);
    }//GEN-LAST:event_btnInicioMouseExited
    /**
     * Aplica borde resaltado al pasar el cursor sobre el botón "Inicio".
     */
    private void btnInicioMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInicioMouseEntered

        btnInicio.setBorder(bordeHover);

    }//GEN-LAST:event_btnInicioMouseEntered

    private void btnInicioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInicioMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnInicioMouseClicked
    /**
     * Carga el panel de reportes.
     */
    private void btnReportesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReportesActionPerformed

        //report.setSize(1366, 768);
        //report.setLocation(0, 0);
        content.removeAll();
        content.add(report, BorderLayout.CENTER);
        content.revalidate();
        content.repaint();

        GettexIcon(btnReportes);
        InsetarNuevoIcon("/resources_img/reportesHeader.png");


    }//GEN-LAST:event_btnReportesActionPerformed
    /**
     * Restaura el borde normal del botón "Reportes" al salir el cursor.
     */
    private void btnReportesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnReportesMouseExited
        btnReportes.setBorder(bordeNormal);
    }//GEN-LAST:event_btnReportesMouseExited
    /**
     * Aplica borde resaltado al pasar el cursor sobre el botón "Reportes".
     */
    private void btnReportesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnReportesMouseEntered
        btnReportes.setBorder(bordeHover);
    }//GEN-LAST:event_btnReportesMouseEntered

    private void btnReportesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnReportesMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnReportesMouseClicked
    /**
     * Carga el panel de clientes.
     */
    private void btnclientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnclientesActionPerformed

        //client.setSize(1366, 768);
        //client.setLocation(0, 0);
        content.removeAll();
        content.add(client, BorderLayout.CENTER);
        content.revalidate();
        content.repaint();

        GettexIcon(btnclientes);
        InsetarNuevoIcon("/resources_img/ClientesHeader.png");
    }//GEN-LAST:event_btnclientesActionPerformed
    /**
     * Restaura el borde del botón "Clientes" al salir el cursor.
     */
    private void btnclientesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnclientesMouseExited
        btnclientes.setBorder(bordeNormal);

    }//GEN-LAST:event_btnclientesMouseExited
    /**
     * Aplica borde resaltado al pasar el cursor sobre el botón "Clientes".
     */
    private void btnclientesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnclientesMouseEntered
        btnclientes.setBorder(bordeHover);
    }//GEN-LAST:event_btnclientesMouseEntered
    /**
     * Carga el panel de ventas.
     */
    private void btnVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVentasActionPerformed

        //vent.setSize(1366, 768);
        //vent.setLocation(0, 0);
        content.removeAll();
        content.add(vent, BorderLayout.CENTER);
        content.revalidate();
        content.repaint();

        GettexIcon(btnVentas);
        InsetarNuevoIcon("/resources_img/ventasHeader.png");

    }//GEN-LAST:event_btnVentasActionPerformed
    /**
     * Restaura el borde del botón "Ventas" al salir el cursor.
     */
    private void btnVentasMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVentasMouseExited
        btnVentas.setBorder(bordeNormal);
    }//GEN-LAST:event_btnVentasMouseExited
    /**
     * Aplica borde resaltado al pasar el cursor sobre el botón "Ventas".
     */
    private void btnVentasMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVentasMouseEntered

        btnVentas.setBorder(bordeHover);
    }//GEN-LAST:event_btnVentasMouseEntered
    /**
     * Carga el panel de inventario.
     */
    private void btnInvemtarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInvemtarioActionPerformed

        content.removeAll();
        content.add(inven, BorderLayout.CENTER);
        content.revalidate();
        content.repaint();

        GettexIcon(btnInvemtario);
        InsetarNuevoIcon("/resources_img/invtHeader.png");
    }//GEN-LAST:event_btnInvemtarioActionPerformed

    /**
     * Restaura el borde del botón "Inventario" al salir el cursor.
     */
    private void btnInvemtarioMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInvemtarioMouseExited

        btnInvemtario.setBorder(bordeNormal);
    }//GEN-LAST:event_btnInvemtarioMouseExited
    /**
     * Aplica borde resaltado al pasar el cursor sobre el botón "Inventario".
     */
    private void btnInvemtarioMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInvemtarioMouseEntered

        btnInvemtario.setBorder(bordeHover);
    }//GEN-LAST:event_btnInvemtarioMouseEntered
    /**
     * Carga el panel de proveedores.
     */
    private void btnprovedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnprovedoresActionPerformed

        //proved.setSize(1366, 768);
        //proved.setLocation(0, 0);
        content.removeAll();
        content.add(proved, BorderLayout.CENTER);
        content.revalidate();
        content.repaint();

        GettexIcon(btnprovedores);
        InsetarNuevoIcon("/resources_img/provedoresHeader.png");
    }//GEN-LAST:event_btnprovedoresActionPerformed
    /**
     * Restaura el borde del botón "Proveedores" al salir el cursor.
     */
    private void btnprovedoresMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnprovedoresMouseExited
        btnprovedores.setBorder(bordeNormal);
    }//GEN-LAST:event_btnprovedoresMouseExited
    /**
     * Aplica borde resaltado al pasar el cursor sobre el botón "Proveedores".
     */
    private void btnprovedoresMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnprovedoresMouseEntered
        btnprovedores.setBorder(bordeHover);
    }//GEN-LAST:event_btnprovedoresMouseEntered

    private void btnprovedoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnprovedoresMouseClicked

    }//GEN-LAST:event_btnprovedoresMouseClicked

    private void cerrarSesionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cerrarSesionMouseClicked
    }//GEN-LAST:event_cerrarSesionMouseClicked
    /**
     * Muestra un mensaje de confirmación y, si el usuario acepta, cierra sesión
     * y vuelve al login.
     */
    private void cerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cerrarSesionActionPerformed

        int opcion = JOptionPane.showConfirmDialog(this, "¿Deseas cerrar sesión?", "Cerrar sesión", JOptionPane.YES_NO_OPTION);
        if (opcion == JOptionPane.YES_OPTION) {
            Login login = new Login();
            login.setVisible(true);
            login.setLocationRelativeTo(null);
            this.dispose();
        }
    }//GEN-LAST:event_cerrarSesionActionPerformed
    /**
     * Muestra el menú contextual del usuario al hacer clic en el botón de
     * usuario.
     */
    private void btnUsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUsuarioMouseClicked

        menuUsuario.show(btnUsuario, 0, btnUsuario.getHeight());

    }//GEN-LAST:event_btnUsuarioMouseClicked

    private void PerfilMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PerfilMouseClicked

    }//GEN-LAST:event_PerfilMouseClicked

    /**
     * Carga el perfil del usuario actual en el contenedor principal.
     */
    private void PerfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PerfilActionPerformed

        PerfilView perfil = new PerfilView(usuarioActual);
        // perfil.setSize(1366, 768);
        // perfil.setLocation(0, 0);
        content.removeAll(); // importante cuando se realizar cambios dinamincamente en los componentes dentro de un mismo panel
        content.add(perfil, BorderLayout.CENTER);
        content.revalidate(); // indica al panel que ha cambiado su contenido y necesita reiniciarse
        content.repaint();

        String textto = Perfil.getText();
        txtHeadder.setText(textto);
        txtHeadder.setForeground(new Color(44, 62, 80));
        InsetarNuevoIcon("/resources_img/PerfilHeader.png");

    }//GEN-LAST:event_PerfilActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel BackgroundPrincipal;
    private javax.swing.JPanel EncabezadoPanel;
    private javax.swing.JPanel MenuPanel;
    private javax.swing.JMenuItem Perfil;
    private javax.swing.JButton btnInicio;
    private javax.swing.JButton btnInvemtario;
    private javax.swing.JButton btnReportes;
    private javax.swing.JButton btnUsuario;
    private javax.swing.JButton btnVentas;
    private javax.swing.JButton btnclientes;
    private javax.swing.JButton btnprovedores;
    private javax.swing.JMenuItem cerrarSesion;
    private javax.swing.JPanel content;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JLabel lbFrase;
    private javax.swing.JPopupMenu menuUsuario;
    private javax.swing.JLabel txtHeadder;
    // End of variables declaration//GEN-END:variables

}
