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
import org.carlospriego.Controllers.FormAsignarEncargadoController;
import org.carlospriego.Controllers.FormCargosController;
import org.carlospriego.Controllers.FormCategoriaProductosController;
import org.carlospriego.Controllers.FormClientesController;
import org.carlospriego.Controllers.FormComprasController;
import org.carlospriego.Controllers.FormDetalleFacturaController;
import org.carlospriego.Controllers.FormDistribuidorController;
import org.carlospriego.Controllers.FormEmpleadosController;
import org.carlospriego.Controllers.FormFacturasController;
import org.carlospriego.Controllers.FormProductosController;
import org.carlospriego.Controllers.FormPromocionesController;
import org.carlospriego.Controllers.MenuCargosController;
import org.carlospriego.Controllers.MenuCategoriaProductosController;
import org.carlospriego.Controllers.MenuClientesController;
import org.carlospriego.Controllers.MenuComprasController;
import org.carlospriego.Controllers.MenuDistribuidoresController;
import org.carlospriego.Controllers.MenuEmpleadosController;
import org.carlospriego.Controllers.MenuFacturasController;
import org.carlospriego.Controllers.MenuPrincipalController;
import org.carlospriego.Controllers.MenuProductosController;
import org.carlospriego.Controllers.MenuPromocionesController;
import org.carlospriego.Controllers.MenuTicketSoporteController;

public class Main extends Application {
    private final String URLVIEW = "/org/carlospriego/Views/";
    private Stage stage;
    private Scene scene;
    private int op;
    
    @Override
    public void start(Stage stage) throws Exception {
        this.stage = stage;
        stage.setTitle("Super Kinal");
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
            MenuClientesController menuClienteView = (MenuClientesController)switchScene("MenuClientesView.fxml", 750, 475);
            menuClienteView.setStage(this);
        }catch(Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
    
    public void menuTicketSoporteView(){
        try{
            MenuTicketSoporteController menuTicketSoporteView = (MenuTicketSoporteController)switchScene("MenuTicketSoporteView.fxml", 1000, 750);
            menuTicketSoporteView.setStage(this);
        }catch(Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
    
    public void formClientesView(int op){
        try{
            FormClientesController formClientesView = (FormClientesController)switchScene("FormClientesView.fxml", 400, 600);
            formClientesView.setOp(op);
            formClientesView.setStage(this);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void menuCargoView(){
        try{
            MenuCargosController menuCargosView = (MenuCargosController)switchScene("MenuCargosView.fxml", 750, 500);
            menuCargosView.setStage(this);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void formCargosView(int op){
        try{
            FormCargosController formCargoView = (FormCargosController)switchScene("FormCargosView.fxml", 400, 600);
            formCargoView.setOp(op);
            formCargoView.setStage(this);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void menuDistribuidoresView(){
        try{
            MenuDistribuidoresController menuCargosView = (MenuDistribuidoresController)switchScene("MenuDistribuidoresView.fxml", 750, 500);
            menuCargosView.setStage(this);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void formDistribuidoresView(int op){
        try{
            FormDistribuidorController formDistribuidorView = (FormDistribuidorController)switchScene("FormDistribuidorView.fxml", 400, 600);
            formDistribuidorView.setOp(op);
            formDistribuidorView.setStage(this);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void menuEmpleadosView(){
        try{
            MenuEmpleadosController menuEmpleado = (MenuEmpleadosController)switchScene("MenuEmpleadosView.fxml", 750, 500);
            menuEmpleado.setStage(this);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void formEmpleadosView(int op){
        try{
            FormEmpleadosController formEmpleado = (FormEmpleadosController)switchScene("FormEmpleadosView.fxml", 400, 600);
            formEmpleado.setOp(op);
            formEmpleado.setStage(this);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void formAsignarEView(){
        try{
            FormAsignarEncargadoController formAsignarE = (FormAsignarEncargadoController)switchScene("FormAsignarEncargadoView.fxml", 400, 600);
            formAsignarE.setStage(this);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void menuFacturasView(){
        try{
            MenuFacturasController menuFacturas = (MenuFacturasController)switchScene("MenuFacturasView.fxml", 750, 500);
            menuFacturas.setStage(this);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void formFacturasView(int op){
        try{
            FormFacturasController formFacturas = (FormFacturasController)switchScene("FormFacturasView.fxml", 400, 600);
            formFacturas.setOp(op);
            formFacturas.setStage(this);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void formDetalleFacturaView(int op){
        try{
            FormDetalleFacturaController formDetalleFactura = (FormDetalleFacturaController)switchScene("FormDetalleFacturaView.fxml", 400, 600);
            formDetalleFactura.setOp(op);
            formDetalleFactura.setStage(this);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void menuProductosView(){
        try{
            MenuProductosController menuProductos = (MenuProductosController)switchScene("MenuProductosView.fxml", 750, 500);
            menuProductos.setStage(this);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void formProductosView(int op){
        try{
            FormProductosController formProductos = (FormProductosController)switchScene("FormProductosView.fxml", 400, 600);
            formProductos.setOp(op);
            formProductos.setStage(this);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void menuComprasView(){
        try{
            MenuComprasController menuCompras = (MenuComprasController)switchScene("MenuComprasView.fxml", 750, 500);
            menuCompras.setStage(this);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void formComprasView(int op){
        try{
            FormComprasController formCompras = (FormComprasController)switchScene("FormComprasView.fxml", 500, 750);
            formCompras.setOp(op);
            formCompras.setStage(this);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void menuPromocionesView(){
        try{
            MenuPromocionesController menuPromociones = (MenuPromocionesController)switchScene("MenuPromocionesView.fxml", 750, 500);
            menuPromociones.setStage(this);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void formPromocionesView(int op){
        try{
            FormPromocionesController formPromociones = (FormPromocionesController)switchScene("FormPromocionesView.fxml", 400, 600);
            formPromociones.setOp(op);
            formPromociones.setStage(this);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void menuCategoriaPView(){
        try{
            MenuCategoriaProductosController menuCategoriaP = (MenuCategoriaProductosController)switchScene("MenuCategoriaProductosView.fxml", 750, 500);
            menuCategoriaP.setStage(this);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void formCategoriaPView(int op){
        try{
            FormCategoriaProductosController formCategoriaP = (FormCategoriaProductosController)switchScene("FormCategoriaProductosView.fxml", 400, 600);
            formCategoriaP.setOp(op);
            formCategoriaP.setStage(this);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    

 
    public static void main(String[] args) {
        launch(args);
    }
}