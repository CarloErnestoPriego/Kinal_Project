package org.carlospriego.System;
 
import java.io.InputStream;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.carlospriego.Controllers.FormCargosController;
import org.carlospriego.Controllers.FormCategoriaProductosController;
import org.carlospriego.Controllers.FormClientesController;
import org.carlospriego.Controllers.FormComprasController;
import org.carlospriego.Controllers.FormDistribuidorController;
import org.carlospriego.Controllers.MenuCargosController;
import org.carlospriego.Controllers.MenuCategoriaProductosController;
import org.carlospriego.Controllers.MenuClientesController;
import org.carlospriego.Controllers.MenuComprasController;
import org.carlospriego.Controllers.MenuDistribuidoresController;
import org.carlospriego.Controllers.MenuEmpleadosController;
import org.carlospriego.Controllers.MenuFacturasController;
import org.carlospriego.Controllers.MenuPrincipalController;
import org.carlospriego.Controllers.MenuTicketSoporteController;

public class Main extends Application {
    private final String URLVIEW = "/org/carlospriego/Views/";
    private Stage stage;
    private Scene scene;
    
    @Override
    public void start(Stage stage) throws Exception {
        this.stage = stage;
        stage.setTitle("SuperKinal");
        menuPrincipalView();
        stage.show();
    }
    
    public Initializable switchScene(String fxmlName, int width, int height) throws Exception{
        Initializable resultado = null;
        FXMLLoader loader = new FXMLLoader();
        
        InputStream file = Main.class.getResourceAsStream(URLVIEW + fxmlName);
        loader.setBuilderFactory(new JavaFXBuilderFactory());
        loader.setLocation(Main.class.getResource(URLVIEW + fxmlName));
        
        scene = new Scene((AnchorPane)loader.load(file), width, height);
        stage.setScene(scene);
        stage.sizeToScene();
        
        resultado = (Initializable)loader.getController();
        
        return resultado;
    }
    
    public void menuPrincipalView(){
        try{
            MenuPrincipalController menuPrincipalView = (MenuPrincipalController)switchScene("MenuPrincipalView.fxml", 700, 475);
            menuPrincipalView.setStage(this);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void menuClienteView(){
        try{
            MenuClientesController menuClienteView = (MenuClientesController)switchScene("MenuClientesView.fxml", 750, 500);
            menuClienteView.setStage(this);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void formClienteView(int op){
        try{
            FormClientesController formClienteView = (FormClientesController)switchScene("FormClientesView.fxml", 400, 600);
            formClienteView.setOp(op);
            formClienteView.setStage(this);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void menuTicketSoporteView(){
        try{
            MenuTicketSoporteController menuTicketSoporteView = (MenuTicketSoporteController)switchScene("MenuTicketSoporteView.fxml", 750, 500);
            menuTicketSoporteView.setStage(this);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void menuCargoView(){
        try{
            MenuCargosController menuCargoView = (MenuCargosController)switchScene("MenuCargosView.fxml", 750, 500);
            menuCargoView.setStage(this);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void formCargoView(int op){
        try{
            FormCargosController formCargoView = (FormCargosController)switchScene("FormCargosView.fxml", 400, 600);
            formCargoView.setOp(op);
            formCargoView.setStage(this);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void menuCompraView(){
        try{
            MenuComprasController menuCompraView = (MenuComprasController)switchScene("MenuComprasView.fxml", 750, 500);
            menuCompraView.setStage(this);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void formCompraView(int op){
        try{
            FormComprasController formCompraView = (FormComprasController)switchScene("FormComprasView.fxml", 400, 600);
            formCompraView.setOp(op);
            formCompraView.setStage(this);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void menuDistribuidorView(){
        try{
            MenuDistribuidoresController menuDistribuidorView = (MenuDistribuidoresController)switchScene("MenuDistribuidoresView.fxml", 750, 500);
            menuDistribuidorView.setStage(this);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void formDistribuidorView(int op){
        try{
            FormDistribuidorController formDistribuidorView = (FormDistribuidorController)switchScene("FormDistribuidorView.fxml", 400, 600);
            formDistribuidorView.setOp(op);
            formDistribuidorView.setStage(this);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void menuCategoriaProductoView(){
        try{
            MenuCategoriaProductosController menuCategoriaProductoView = (MenuCategoriaProductosController)switchScene("MenuCategoriaProductosView.fxml", 750, 500);
            menuCategoriaProductoView.setStage(this);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void formCategoriaProductoView(int op){
        try{
            FormCategoriaProductosController formCategoriaProductoView = (FormCategoriaProductosController)switchScene("FormCategoriaProductosView.fxml", 400, 600);
            formCategoriaProductoView.setOp(op);
            formCategoriaProductoView.setStage(this);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void menuEmpleadoView(){
        try{
            MenuEmpleadosController menuEmpleadoView = (MenuEmpleadosController)switchScene("MenuEmpleadosView.fxml", 1000, 750);
            menuEmpleadoView.setStage(this);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void menuFacturaView(){
        try{
            MenuFacturasController menuFacturaView = (MenuFacturasController)switchScene("MenuFacturasView.fxml", 1000, 750);
            menuFacturaView.setStage(this);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    /**public void menuProductoView(){
        try{
            MenuProductoController menuProductoView = (MenuProductoController)switchScene("MenuProductoView.fxml", 1000, 750);
            menuProductoView.setStage(this);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
     * @param args}**/
    
    public static void main(String[] args) {
        launch(args);
    }
  
}