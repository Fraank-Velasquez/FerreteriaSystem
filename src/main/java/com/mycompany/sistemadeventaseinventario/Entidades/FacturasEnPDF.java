package com.mycompany.sistemadeventaseinventario.Entidades;

import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.properties.TextAlignment;
import com.mycompany.sistemadeventaseinventario.DAOImplementacion.DAOVentaImpl;
import com.mycompany.sistemadeventaseinventario.PersistenciaDAO.DAOVenta;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.List;

public class FacturasEnPDF {

    DAOVenta daoVenta = new DAOVentaImpl();

    public String generarFactura(int idVenta) throws Exception {

        //  OBTENER LOS DATOS DE LA VENTA 
        Object[] datosVenta = daoVenta.obtenerVentaConCliente(idVenta);
        List<Object[]> detallesVenta = daoVenta.listarDetallesPorVenta(idVenta);

        if (datosVenta == null) {
            throw new Exception("No se encontraron los datos de la venta especificada.");
        }

        //  DEFINIR LA RUTA DE GUARDADO 
        // Obtenemos la carpeta de descargas del usuario
        String userHome = System.getProperty("user.home");
        String downloadsPath = userHome + File.separator + "Downloads";

        // Creamos un nombre de archivo único para la factura
        String dest = downloadsPath + File.separator + "Factura_Venta_" + idVenta + ".pdf";

        // CREAR EL DOCUMENTO PDF 
        PdfWriter writer = new PdfWriter(dest);
        PdfDocument pdf = new PdfDocument(writer);
        Document document = new Document(pdf, PageSize.A4);
        document.setMargins(20, 20, 20, 20);

        // AÑADIR CONTENIDO AL DOCUMENTO 
        // Título
        Paragraph titulo = new Paragraph("FACTURA DE VENTA\n").setBold().setFontSize(20).setTextAlignment(TextAlignment.CENTER);
        document.add(titulo);

        // Información de la empresa 
        document.add(new Paragraph("Ferretería 'El YUNQUE'\n").setTextAlignment(TextAlignment.CENTER));
        document.add(new Paragraph("RUC: 12345678901\n").setTextAlignment(TextAlignment.CENTER));
        document.add(new Paragraph("------------------------------------------------------------------------------------------------------------------------------------------"));

        // Datos de la venta y del cliente
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String fechaFormateada = dateFormat.format(datosVenta[1]);

        document.add(new Paragraph("Código de venta: N°" + datosVenta[0]));
        document.add(new Paragraph("Fecha: " + fechaFormateada));
        document.add(new Paragraph("Cliente: " + datosVenta[2]));
        document.add(new Paragraph("DNI: " + datosVenta[3]));
        document.add(new Paragraph("------------------------------------------------------------------------------------------------------------------------------------------\n"));

        // Tabla de productos
        Table tabla = new Table(new float[]{3, 1, 2, 2}); // 4 columnas con anchos relativos
        tabla.setWidth(PageSize.A4.getWidth() - 40); // Ancho total

        // Encabezados de la tabla
        tabla.addHeaderCell(new Cell().add(new Paragraph("Producto").setBold()));
        tabla.addHeaderCell(new Cell().add(new Paragraph("Cant.").setBold()));
        tabla.addHeaderCell(new Cell().add(new Paragraph("P. Unit.").setBold()));
        tabla.addHeaderCell(new Cell().add(new Paragraph("Subtotal").setBold()));

        // Contenido de la tabla (productos)
        for (Object[] detalle : detallesVenta) {
            tabla.addCell(new Cell().add(new Paragraph(String.valueOf(detalle[1])))); // Nombre prod
            tabla.addCell(new Cell().add(new Paragraph(String.valueOf(detalle[2])))); // Cantidad
            tabla.addCell(new Cell().add(new Paragraph(String.format("%.2f", detalle[3])))); // Precio Unit
            tabla.addCell(new Cell().add(new Paragraph(String.format("%.2f", detalle[4])))); // Subtotal
        }
        document.add(tabla);

        // Total
        Paragraph total = new Paragraph("\nTOTAL A PAGAR: S/ " + String.format("%.2f", datosVenta[4]))
                .setBold()
                .setFontSize(14)
                .setTextAlignment(TextAlignment.RIGHT);
        document.add(total);

        // CERRAR EL DOCUMENTO ---
        document.close();

        // Devolvemos la ruta donde se guardó el archivo
        return dest;
    }

}
