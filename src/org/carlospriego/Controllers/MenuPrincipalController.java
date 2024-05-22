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
import javafx.scene.control.MenuItem;
import org.carlospriego.System.Main;

/**
 *
 * @author aceyt
 */
public class MenuPrincipalController implements Initializable {
    private Main stage;
    
    
    @FXML
    MenuItem btnClientes, btnTicketSoporte, btnCargos, btnDistribuidores, btnEmpleados, btnFacturas, btnProductos, btnCompras, btnPromociones, btnCategoriaProductos;
    
    @FXML
    public void handleButtonAction(ActionEvent event) throws Exception{
        if(event.getSource() == btnClientes){
            stage.menuClienteView();
        }else if(event.getSource() == btnTicketSoporte){
            stage.menuTicketSoporteView();
        }else if(event.getSource() == btnCargos){
            stage.menuCargoView();
        }else if(event.getSource() == btnDistribuidores){
            stage.menuDistribuidoresView();
        } else if(event.getSource() == btnEmpleados){
            stage.menuEmpleadosView();
        }else if(event.getSource() == btnFacturas){
            stage.menuFacturasView();
        }else if(event.getSource() == btnProductos){
            stage.menuProductosView();
        }else if(event.getSource() == btnCompras){
            stage.menuComprasView();
        }else if(event.getSource() == btnPromociones){
            stage.menuPromocionesView();
        } else if(event.getSource() == btnCategoriaProductos){
            stage.menuCategoriaPView();
        }
    }
    

    public Main getStage() {
        return stage;
    }

    public void setStage(Main stage) {
        this.stage = stage;
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources){
        
    }
}
