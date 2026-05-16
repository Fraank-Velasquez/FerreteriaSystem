package com.mycompany.sistemadeventaseinventario.Entidades;

import java.awt.Color;
import java.util.List;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
/**
 *
 * @author Frank
 */

public class GraficoDeVentas {

    // Este método recibe la lista de datos y devuelve un panel con el gráfico listo para mostrar.
    public ChartPanel crearGraficoVentasAnual(List<Object[]> datosMensuales) {

        // CREAR LOS DATASETS (uno para cada línea/eje)
        DefaultCategoryDataset datasetVentas = new DefaultCategoryDataset(); // Para "Ventas Totales"
        DefaultCategoryDataset datasetNumVentas = new DefaultCategoryDataset(); // Para "Número de Ventas"

        // POBLAR LOS DATASETS 
        for (Object[] mesData : datosMensuales) {
            String mesNombre = (String) mesData[0].toString().split(" ")[0]; // Extrae "Marzo" de "Marzo 2023"
            double ingresosMes = Double.parseDouble(mesData[1].toString().replace("S/ ", "").replace(",", ""));
            int ventasMes = (int) mesData[2];

            datasetVentas.addValue(ingresosMes, "Ventas Totales", mesNombre);
            datasetNumVentas.addValue(ventasMes, "Número de Ventas", mesNombre);
        }

        // CREAR EL GRÁFICO INICIAL 
        JFreeChart lineChart = ChartFactory.createLineChart(
                "Evolución Anual de Ventas", // Título del gráfico
                "Mes", // Label Eje X
                "Ventas Totales (S/)", // Label Eje Y 
                datasetVentas, // Dataset primario
                PlotOrientation.VERTICAL,
                true, true, false);         // Leyenda, Tooltips, URLs

        // CONFIGURAR EL GRÁFICO DE DOBLE EJE 
        CategoryPlot plot = lineChart.getCategoryPlot();
        plot.setBackgroundPaint(Color.white);

        // EJE SECUNDARIO (para el Número de Ventas) 
        NumberAxis axis2 = new NumberAxis("Número de Ventas");
        plot.setRangeAxis(1, axis2); // Asignamos el eje 2 al índice 1

        // DATASET SECUNDARIO 
        plot.setDataset(1, datasetNumVentas);
        plot.mapDatasetToRangeAxis(1, 1); // Mapeamos el dataset 1 al eje 1

        // RENDERER SECUNDARIO 
        LineAndShapeRenderer renderer2 = new LineAndShapeRenderer();
        plot.setRenderer(1, renderer2);

        // DEVOLVER EL GRÁFICO DENTRO DEL PANEL
        ChartPanel chartPanel = new ChartPanel(lineChart);
        return chartPanel;
    }
}

