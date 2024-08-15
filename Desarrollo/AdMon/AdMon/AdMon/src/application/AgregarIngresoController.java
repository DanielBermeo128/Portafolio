package application;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import objs.Fondos;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;

import db.Conexion;
import extras.MetodosComprobacion;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;

public class AgregarIngresoController implements Initializable{
	public Fondos posibleFondo;
	@FXML
	private TextField txtConceptoIngreso;
	@FXML
	private TextField txtMontoIgs;
	@FXML
	private Button btnIngresoListo;
	@FXML
	private Button btnDescartarIgs;
	@FXML
	private ComboBox cmbFondoDestino;


	// Event Listener on Button[#btnIngresoListo].onAction
	@FXML
	public void finalizadoIngreso(ActionEvent event) {
		Stage escenario = (Stage)btnDescartarIgs.getScene().getWindow();
    	Alert alerta = new Alert(AlertType.CONFIRMATION);
    	alerta.setTitle("Confirmar");
    	alerta.setContentText("¿Estas seguro de la creacion?\nEste registro es imborrable");
    	Optional<ButtonType> action = alerta.showAndWait();
    	if (action.get() == ButtonType.OK) {

    			MetodosComprobacion comprobar = new MetodosComprobacion(); 
				Boolean insercionLista = false;
				
				String concepto,montoIgs;
				Fondos fondoSeleccionado;
				
				concepto= txtConceptoIngreso.getText();
				montoIgs = txtMontoIgs.getText();
	    		fondoSeleccionado = (Fondos)cmbFondoDestino.getValue();
				
	    		if(concepto=="" || comprobar.sonEspacios(concepto)) {
	    			Alert alertaError = new Alert(AlertType.ERROR);
    				alertaError.setContentText("El Concepto es invalido");
    				alertaError.setTitle("Error en concepto");
    				alertaError.showAndWait();
    				alerta.close();
	    		}else if(comprobar.noEsNumerica(montoIgs)) {
	    			Alert alertaError = new Alert(AlertType.ERROR);
    				alertaError.setContentText("El monto es invalido");
    				alertaError.setTitle("Error en Monto");
    				alertaError.showAndWait();
    				alerta.close();
	    		}else if(cmbFondoDestino.getValue() == null){
	    			Alert alertaError = new Alert(AlertType.ERROR);
    				alertaError.setContentText("Falta fondo destino");
    				alertaError.setTitle("No se ha seleccionado un fondo destino");
    				alertaError.showAndWait();
    				alerta.close();
	    		}else {
	    			insercionLista = true;
	    		}
	    		
	    		if(insercionLista) {

	    			
	    			try {
						Conexion cn = new Conexion();
						cn.insertarIngreso(Integer.parseInt(montoIgs), concepto, fondoSeleccionado);
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
	// Event Listener on Button[#btnDescartarIgs].onAction
	@FXML
	public void descartarIngreso(ActionEvent event) {
		Stage escenario = (Stage) btnDescartarIgs.getScene().getWindow();
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
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		try {
			Conexion cn = new Conexion();
			ArrayList<Fondos> fondos =  cn.traerFondos();
			ObservableList<Fondos> fondosVis = FXCollections.observableArrayList();
			for(Fondos f: fondos) {
				fondosVis.add(f);
			}
			fondosVis.remove(0);
			cmbFondoDestino.setItems(fondosVis);
			cn.cerrarConexion();
		}catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	public void setPosibleFondo(Fondos posibleFondo) {
		this.posibleFondo = posibleFondo;
		cmbFondoDestino.getSelectionModel().select(posibleFondo);
	}

    
	
}
