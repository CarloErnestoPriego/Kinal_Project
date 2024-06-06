/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.carlospriego.Report;

import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import org.carlospriego.Dao.Conexion;
import win.zqxu.jrviewer.JRViewerFX;

/**
 *
 * @author aceyt
 */
public class GenerarReporte {
    private static GenerarReporte instance;
    
    private static Connection conexion = null;
    
    private GenerarReporte(){
    
    }
    
    public static GenerarReporte getInstance(){
        if(instance == null){
            instance = new GenerarReporte();
        }
        return instance;
    }
    
    public void generarFactura(int factId){
        try{
            // paso 1: abrir la conexion a la base de datos
            conexion = Conexion.getInstance().obtenerConexion();
            
            // paso 2: enviar los parametros al reporte por medio de un MAP
            Map<String, Object> parametros = new HashMap<>();
            parametros.put("factId", factId);
            
            // paso 3: crear un stage nuevo 
            Stage reportStage = new Stage();
            
            // paso 4: generar el reporte:
            JasperPrint reporte = JasperFillManager.fillReport(GenerarReporte.class.getResourceAsStream("/org/carlospriego/Report/Factura.jasper"), parametros, conexion);
            
            // paso 5: colocar el reporte en el stage
            JRViewerFX reportView = new JRViewerFX(reporte);
            
            // paso 6: mostrar el stage
            Pane root = new Pane();
            root.getChildren().add(reportView);
            
            reportView.setPrefSize(1000, 800);
            
            Scene scene = new Scene(root);
            reportStage.setScene(scene);
            reportStage.setTitle("Factura");
            reportStage.show();
            
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
     public void generarClientes(){
        try{
            conexion = Conexion.getInstance().obtenerConexion();
            
            Map<String, Object> parametros = new HashMap<>();
            
            Stage reportStage = new Stage();
            
            JasperPrint reporte = JasperFillManager.fillReport(GenerarReporte.class.getResourceAsStream("/org/carlospriego/Report/Cliente.jasper"), parametros, conexion);
            
            JRViewerFX reportView = new JRViewerFX(reporte);
            
            Pane root = new Pane();
            root.getChildren().add(reportView);
            
            reportView.setPrefSize(1000, 800);
            
            Scene scene = new Scene(root);
            reportStage.setScene(scene);
            reportStage.setTitle("Reporte de Clientes");
            reportStage.show();
                    
        }catch(Exception e){
            e.printStackTrace();
        }
    }
     
     public void generarProductos(){
        try{
            conexion = Conexion.getInstance().obtenerConexion();
            
            Map<String, Object> parametros = new HashMap<>();
            
            Stage reportStage = new Stage();
            
            JasperPrint reporte = JasperFillManager.fillReport(GenerarReporte.class.getResourceAsStream("/org/carlospriego/Report/Productos.jasper"), parametros, conexion);
            
            JRViewerFX reportView = new JRViewerFX(reporte);
            
            Pane root = new Pane();
            root.getChildren().add(reportView);
            
            reportView.setPrefSize(950, 550);
            
            Scene scene = new Scene(root);
            reportStage.setScene(scene);
            reportStage.setTitle("Reporte de Productos");
            reportStage.show();
                    
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
