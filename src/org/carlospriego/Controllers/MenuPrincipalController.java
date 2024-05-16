/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.carlospriego.Controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import org.carlospriego.System.Main;

/**
 *
 * @author aceyt
 */
public class MenuPrincipalController implements Initializable {
    private Main stage;
    
    @FXML
    MenuItem btnClientes, btnTicketSoporte, btnCargos, btnCompras, btnDistribuidores, btnCategoriaProductos, btnEmpleados, btnFacturas, btnProductos;
    
    @FXML
    public void handleButtonAction(ActionEvent event){
        if(event.getSource() == btnClientes){
            stage.menuClienteView();
        }else if(event.getSource() == btnTicketSoporte){
            stage.menuTicketSoporteView();
        }else if(event.getSource() == btnCargos){
            stage.menuCargoView();
        }else if(event.getSource() == btnCompras){
            stage.menuCompraView();
        }else if(event.getSource() == btnDistribuidores){
            stage.menuDistribuidorView();
        }else if(event.getSource() == btnCategoriaProductos){
            stage.menuCategoriaProductoView();
        }else if(event.getSource() == btnEmpleados){
            stage.menuEmpleadoView();
        }else if(event.getSource() == btnFacturas){
            stage.menuFacturaView();
        }/**else if(event.getSource() == btnProductos){
            stage.menuProductoView();
        }**/
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources){
    
    }

    public Main getStage() {
        return stage;
    }

    public void setStage(Main stage) {
        this.stage = stage;
    }
}
