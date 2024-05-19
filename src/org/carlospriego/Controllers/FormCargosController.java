/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.carlospriego.Controllers;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import org.carlospriego.Dao.Conexion;
import org.carlospriego.Dto.CargoDTO;
import org.carlospriego.Models.Cargo;
import org.carlospriego.System.Main;
import org.carlospriego.Utils.SuperKinalAlert;

/**
 * FXML Controller class
 *
 * @author aceyt
 */
public class FormCargosController implements Initializable {

    private Main stage;
    private int op;
    
    
    private static Connection conexion = null;
    private static PreparedStatement statement = null;
    
   @FXML
    Button btnCancelar,btnGuardar;
   
   @FXML
   TextField tfCargoId,tfNombreCargo,tfDescripcionCargo;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
    
        if(event.getSource() == btnCancelar){
            CargoDTO.getCargoDTO().setCargo(null);
            stage.menuCargoView();
        }else if(event.getSource() == btnGuardar){
            if(op == 1){
                if(!tfNombreCargo.getText().equals("") && !tfDescripcionCargo.getText().equals("")){
                    agregarCargo();
                    SuperKinalAlert.getInstance().mostrarAlertasInformacion(400);
                    stage.menuCargoView();
                }else{
                    SuperKinalAlert.getInstance().mostrarAlertasInformacion(600);
                    if(tfNombreCargo.getText().equals("")){
                        tfNombreCargo.requestFocus();
                    }else if(tfDescripcionCargo.getText().equals("")){
                        tfDescripcionCargo.requestFocus();
                    }
                }
                
            }else if(op == 2){
                if(!tfNombreCargo.getText().equals("") && !tfDescripcionCargo.getText().equals("")){
                    editarCargo();
                    if(SuperKinalAlert.getInstance().mostrarAlertaConfirmacion(505).get() == ButtonType.OK){
                        CargoDTO.getCargoDTO().setCargo(null);
                        SuperKinalAlert.getInstance().mostrarAlertasInformacion(500);
                        stage.menuCargoView();
                    }else{
                        stage.menuCargoView();
                    }
                }else{
                    SuperKinalAlert.getInstance().mostrarAlertasInformacion(600);
                    if(tfNombreCargo.getText().equals("")){
                        tfNombreCargo.requestFocus();
                    }else if(tfDescripcionCargo.getText().equals("")){
                        tfDescripcionCargo.requestFocus();
                    }
                }
                
            }
        }
    
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        if(CargoDTO.getCargoDTO().getCargo() != null){
            cargarDatos(CargoDTO.getCargoDTO().getCargo());
    }
}


    public void cargarDatos(Cargo cargo){
        tfCargoId.setText(Integer.toString(cargo.getCargoId()));
        tfNombreCargo.setText(cargo.getNombreCargo());
        tfDescripcionCargo.setText(cargo.getDescripcionCargo());

    }
    
    public void agregarCargo(){
        try{
            conexion = Conexion.getInstance().obtenerConexion();
            String sql = "call sp_agregarCargos(?,?)";
            statement = conexion.prepareStatement(sql);
            statement.setString(1, tfNombreCargo.getText());
            statement.setString(2, tfDescripcionCargo.getText());
            statement.execute();
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }finally{
            try{
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
    
    
    public void editarCargo(){
        try{
            conexion = Conexion.getInstance().obtenerConexion();
            String sql = "call sp_EditarCargo(?,?,?)";
            statement = conexion.prepareStatement(sql);
            statement.setInt(1, Integer.parseInt(tfCargoId.getText()));
            statement.setString(2, tfNombreCargo.getText());
            statement.setString(3, tfDescripcionCargo.getText());
            statement.execute();
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }finally{
            try{
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
    
    public void setStage(Main stage) {
        this.stage = stage;
    }
    
    public void setOp(int op) {
        this.op = op;
    }
}
