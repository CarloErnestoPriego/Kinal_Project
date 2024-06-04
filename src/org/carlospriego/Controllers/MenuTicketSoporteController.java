/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.carlospriego.Controllers;

import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import org.carlospriego.Dao.Conexion;
import org.carlospriego.Models.Clientes;
import org.carlospriego.Models.Factura;
import org.carlospriego.Models.TicketSoporte;
import org.carlospriego.System.Main;
import org.carlospriego.Utils.SuperKinalAlert;

public class MenuTicketSoporteController implements Initializable {
    private Main stage;
    
    private static Connection conexion = null;
    private static PreparedStatement statement = null;
    private static ResultSet resultSet = null;
    
    @FXML
    TextField tfTicketId;
            
    @FXML
    TextField tfDescripcion;
    
    @FXML
    ComboBox cmbEstatus,cmbClientes,cmbFacturas;
    
    @FXML
    TableView tblTickets;
    
    @FXML
    TableColumn colTicketId,colDescripcion,colEstatus,colCliente,colFacturaId;
    
    @FXML
    Button btnRegresar,btnGuardar,btnVaciarForm;
    
    @FXML
    public void handleButtonAction(ActionEvent event) {
        if(event.getSource() == btnRegresar){
            stage.menuPrincipalView();
        }else if(event.getSource() == btnGuardar){
            if (!tfDescripcion.getText().equals("") && cmbClientes.getValue() != null) {
                if (tfTicketId.getText().equals("")) {
                    SuperKinalAlert.getInstance().mostrarAlertasInformacion(400);
                    agregarTicket();
                    cargarDatos();
                } else {
                    if(SuperKinalAlert.getInstance().mostrarAlertaConfirmacion(505).get() == ButtonType.OK){
                        SuperKinalAlert.getInstance().mostrarAlertasInformacion(500);
                        editarTicket();
                        cargarDatos();
                    }else{
                        stage.menuTicketSoporteView();
                    }
                }
            } else {
                SuperKinalAlert.getInstance().mostrarAlertasInformacion(600);
            }

        }else if(event.getSource() == btnVaciarForm){
            vaciarForm();
            tblTickets.getItems().clear();
            cargarDatos();
        }
    }
    
    public void cargarCMBEstatus(){
        cmbEstatus.getItems().add("En Proceso");
        cmbEstatus.getItems().add("Finalizado");
    }
    
    
    @FXML
    public void cargarForm(){
       TicketSoporte tc = (TicketSoporte)tblTickets.getSelectionModel().getSelectedItem();
       
       if(tc != null){
           tfTicketId.setText(Integer.toString(tc.getTicketId()));
           tfDescripcion.setText(tc.getDescripcion());
           cmbEstatus.getSelectionModel().select(0);
           cmbClientes.getSelectionModel().select(obtenerIndexCliente());
           cmbFacturas.getSelectionModel().select(0);
       }
    }
    
    public int obtenerIndexCliente(){
        int index = 0;
        
        String clienteTbl = ((TicketSoporte)tblTickets.getSelectionModel().getSelectedItem()).getCliente();
        
        for(int i = 0; i <= cmbClientes.getItems().size(); i++){
            String clienteCmb = cmbClientes.getItems().get(i).toString();
            
            if(clienteTbl.equals(clienteCmb)){
                index = i;
                
                break;
            }
        }
        return index;
    }
    
    public void vaciarForm(){
        tfTicketId.clear();
        tfDescripcion.clear();
        cmbEstatus.getSelectionModel().clearSelection();
        cmbClientes.getSelectionModel().clearSelection();
        cmbFacturas.getSelectionModel().clearSelection();
    }
    public void cargarDatos(){
        
        tblTickets.setItems(listarTickets()); 
     
        colTicketId.setCellValueFactory(new PropertyValueFactory<TicketSoporte, Integer>("ticketId"));
        colDescripcion.setCellValueFactory(new PropertyValueFactory<TicketSoporte, String>("descripcion"));
        colEstatus.setCellValueFactory(new PropertyValueFactory<TicketSoporte, String>("estatus"));
        colCliente.setCellValueFactory(new PropertyValueFactory<TicketSoporte, String>("cliente"));
        colFacturaId.setCellValueFactory(new PropertyValueFactory<TicketSoporte, String>("factura"));
        
    }
    
    public ObservableList<TicketSoporte> listarTickets(){
        ArrayList<TicketSoporte> tickets = new ArrayList<>();
        
        try{
            conexion = Conexion.getInstance().obtenerConexion();
            String sql = "call sp_ListarTicketsSoporte()";
            statement = conexion.prepareStatement(sql);
            resultSet = statement.executeQuery();
            
            while(resultSet.next()){
                int ticketId = resultSet.getInt("ticketSoporteId");
                String descripcion = resultSet.getString("descripcionTicket");
                String estatus = resultSet.getString("estatus");
                String cliente = resultSet.getString("cliente");
                String facturaId = resultSet.getString("facturaId");
            
                tickets.add(new TicketSoporte(ticketId, descripcion, estatus, cliente, facturaId));
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }finally{
            try{
                if(resultSet != null){
                    resultSet.close();
                }
                
                if(statement != null){
                    statement.close();
                }
                
                if(conexion != null){
                    conexion.close();
                }
            }catch(SQLException e){
                System.out.println(e.getMessage());
            }
        }
        
        
        return FXCollections.observableList(tickets);
    }
    
    public void agregarTicket(){
        try{
            conexion = Conexion.getInstance().obtenerConexion();
            String sql = "call sp_agregarTicketSoporte(?,?,?)";
            statement = conexion.prepareStatement(sql);
            statement.setString(1, tfDescripcion.getText());
            statement.setInt(2, ((Clientes)cmbClientes.getSelectionModel().getSelectedItem()).getClienteId());
            statement.setInt(3, ((Factura)cmbFacturas.getSelectionModel().getSelectedItem()).getFacturaId());
            statement.execute();
            
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }finally{
            try{
                if(resultSet != null){
                    resultSet.close();
                }
                
                if(statement != null){
                    statement.close();
                }
                
                if(conexion != null){
                    conexion.close();
                }
            }catch(SQLException e){
                System.out.println(e.getMessage());
            }
        
        }
    
    }
    
    public ObservableList<Clientes> listarClientes(){
        ArrayList<Clientes> clientes = new ArrayList<>();
        
        try{
            conexion = Conexion.getInstance().obtenerConexion();
            String sql = "call sp_ListarClientes()";
            statement = conexion.prepareStatement(sql);
            resultSet = statement.executeQuery();
            
            while(resultSet.next()){
                int clienteId = resultSet.getInt("clienteId");
                String nombre = resultSet.getString("nombre");
                String apellido = resultSet.getString("apellido");
                String telefono = resultSet.getString("telefono");
                String direccion = resultSet.getString("direccion");
                String nit = resultSet.getString("nit");
            
                clientes.add(new Clientes(clienteId, nombre, apellido, telefono, direccion, nit));
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }finally{
            try{
                if(resultSet != null){
                    resultSet.close();
                }
                
                if(statement != null){
                    statement.close();
                }
                
                if(conexion != null){
                    conexion.close();
                }
            }catch(SQLException e){
                System.out.println(e.getMessage());
            }
        }
        
        
        return FXCollections.observableList(clientes);
    }
    
    public void editarTicket(){
        try{
            conexion = Conexion.getInstance().obtenerConexion();
            String sql = "call sp_EditarTicketSoporte(?,?,?,?,?)";
            statement = conexion.prepareStatement(sql);
            statement.setInt(1, Integer.parseInt(tfTicketId.getText()));
            statement.setString(2, tfDescripcion.getText());
            statement.setString(3,(cmbEstatus.getSelectionModel().getSelectedItem().toString()));
            statement.setInt(4, ((Clientes)cmbClientes.getSelectionModel().getSelectedItem()).getClienteId());
            statement.setInt(5, ((Factura)cmbFacturas.getSelectionModel().getSelectedItem()).getFacturaId());
            statement.execute();
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }finally{
            try{
                if(resultSet != null){
                    resultSet.close();
                }
                
                if(statement != null){
                    statement.close();
                }
                
                if(conexion != null){
                    conexion.close();
                }
            }catch(SQLException e){
                System.out.println(e.getMessage());
            }
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cargarCMBEstatus();
        cmbFacturas.setItems(listarFacturas());
        cmbClientes.setItems(listarClientes());
        cargarDatos();
    }    
    
    public ObservableList<Factura> listarFacturas(){
        ArrayList<Factura> facturas = new ArrayList<>();
        
        try{
            conexion = Conexion.getInstance().obtenerConexion();
            String sql = "call sp_ListarFacturas()";
            statement = conexion.prepareStatement(sql);
            resultSet = statement.executeQuery();
            
            while(resultSet.next()){
                int facturaId = resultSet.getInt("facturaId");
                Date fecha = resultSet.getDate("fecha");
                Time hora = resultSet.getTime("hora");
                String cliente = resultSet.getString("cliente");
                String empleado = resultSet.getString("empleado");
                Double total = resultSet.getDouble("total");
            
                facturas.add(new Factura(facturaId, fecha, hora, cliente, empleado, total));
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }finally{
            try{
                if(resultSet != null){
                    resultSet.close();
                }
                
                if(statement != null){
                    statement.close();
                }
                
                if(conexion != null){
                    conexion.close();
                }
            }catch(SQLException e){
                System.out.println(e.getMessage());
            }
        }
        
        
        return FXCollections.observableList(facturas);
    }

    public Main getStage() {
        return stage;
    }

    public void setStage(Main stage) {
        this.stage = stage;
    }
}