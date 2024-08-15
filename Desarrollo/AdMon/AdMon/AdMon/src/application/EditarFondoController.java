package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import objs.Fondos;

import java.net.URL;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;

import db.Conexion;
import extras.MetodosComprobacion;
import javafx.event.ActionEvent;

public class EditarFondoController{
	Fondos fondo;
	
	@FXML
	private Button btnDescartar;
	@FXML
	private Button btnFondoFinalizado;
	@FXML
	private TextField estadoDeseado;
	@FXML
	private TextField nombreFondo;

	
	// Event Listener on Button[#btnDescartar].onAction
	@FXML
	public void descartarFondo(ActionEvent event) {
		Stage escenario = (Stage)btnDescartar.getScene().getWindow();
    	Alert alerta = new Alert(AlertType.CONFIRMATION);
    	alerta.setTitle("Descartar");
    	alerta.setContentText("¿Estas seguro de descartar los cambios?");
    	Optional<ButtonType> action = alerta.showAndWait();
    	if (action.get() == ButtonType.OK) {
    	    escenario.close();
    	} else {
    	    alerta.close();
    	}
	}
	// Event Listener on Button[#btnFondoFinalizado].onAction
	@FXML
	public void finalizadoFondo(ActionEvent event) {
		Stage escenario = (Stage)btnDescartar.getScene().getWindow();
    	Alert alerta = new Alert(AlertType.CONFIRMATION);
    	alerta.setTitle("Confirmar");
    	alerta.setContentText("¿Estas seguro de la creacion?\nEsta accion es irreversible por ahora");
    	Optional<ButtonType> action = alerta.showAndWait();
    	if (action.get() == ButtonType.OK) {

    			MetodosComprobacion comprobar = new MetodosComprobacion(); 
				Boolean insercionLista = false;
				
				String nombre,montoDeseado,capitalIni;
				nombre= nombreFondo.getText();
				montoDeseado = estadoDeseado.getText();
	    		
	    		if(nombre=="" || comprobar.sonEspacios(nombre)) {
	    			Alert alertaError = new Alert(AlertType.ERROR);
    				alertaError.setContentText("El nombre es invalido");
    				alertaError.setTitle("Error en nombre del fondo");
    				alertaError.showAndWait();
    				alerta.close();
	    		}else if(comprobar.nombreDuplicadoFondo(nombre)) {
	    			Alert alertaError = new Alert(AlertType.ERROR);
    				alertaError.setContentText("El nombre ya existe");
    				alertaError.setTitle("Error en nombre del fondo");
    				alertaError.showAndWait();
    				alerta.close();
	    		}else if(comprobar.noEsNumerica(montoDeseado)) {
	    			Alert alertaError = new Alert(AlertType.ERROR);
    				alertaError.setContentText("El monto de estado deseado es invalido");
    				alertaError.setTitle("Error en estado ideal");
    				alertaError.showAndWait();
    				alerta.close();
	    		}else if(Integer.parseInt(montoDeseado) <= 100) {
	    			Alert alertaError = new Alert(AlertType.ERROR);
    				alertaError.setContentText("El monto es muy pequeño");
    				alertaError.setTitle("Error en estado ideal");
    				alertaError.showAndWait();
    				alerta.close();
    			}else {
	    			insercionLista = true;
	    		}
	    		
	    		if(insercionLista) {

	    			try {
						Conexion cn = new Conexion();
						cn.updateFondo(fondo.getIdFondo(), nombre, Integer.parseInt(montoDeseado));
						Alert alertaCorrecto = new Alert(AlertType.INFORMATION);
						alertaCorrecto.setTitle("Correcto");
						alertaCorrecto.setContentText("Insercion correcta");
						alertaCorrecto.showAndWait();
						
						cn.cerrarConexion();
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (SQLException e) {
						Alert alertaCorrecto = new Alert(AlertType.ERROR);
						alertaCorrecto.setTitle("Fallo");
						alertaCorrecto.setContentText("Error al insertar");
						e.printStackTrace();
					}
	    			
	    			
	    			escenario.close();
	    			
	    		}
	    		
	    		
    	} else {
    	    alerta.close();
    	}
    }
	
	
	public void setFondo(Fondos fondo) {
		
		this.fondo = fondo;
		nombreFondo.setText(fondo.getNombre());
		estadoDeseado.setText(""+fondo.getMontoDeseado());
	}
	
	
}
