package application;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import objs.Fondos;
import objs.Saldos;

import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;

import db.Conexion;
import extras.MetodosComprobacion;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;

import javafx.scene.control.TableView;

import javafx.scene.control.TableColumn;

public class AbonarADeudaController implements Initializable {
	Saldos saldoSeleccionado = null;
	@FXML
	private TableView tblSaldosActivos;
	@FXML
	private TableColumn clmnConceptoGasto;
	@FXML
	private TableColumn clmnFechaGasto;
	@FXML
	private TableColumn clmnMontoPendiente;
	@FXML
	private Button btnDescartarIgs;
	@FXML
	private Button btnIngresoListo;
	@FXML
	private TextField txtMontoIgs;
	@FXML
	private TextField txtConceptoIngreso;

	// Event Listener on Button[#btnDescartarIgs].onAction
	@FXML
	public void descartarPago(ActionEvent event) {
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

	// Event Listener on Button[#btnIngresoListo].onAction
	@FXML
	public void finalizadoPagoDeuda(ActionEvent event) {
	try {
		
		Conexion cn = new Conexion();
		ArrayList<Fondos> fondos= cn.traerFondos();
		Stage escenario = (Stage)btnDescartarIgs.getScene().getWindow();
		MetodosComprobacion comprobacion = new MetodosComprobacion();
		String concepto = txtConceptoIngreso.getText(), 
				monto = txtMontoIgs.getText();
		
		if(saldoSeleccionado==null) {
			Alert alertaError = new Alert(AlertType.ERROR);
			alertaError.setContentText("Seleccionar saldo");
			alertaError.setTitle("Se debe elegir un saldo a pagar");
			alertaError.showAndWait();
		}else if(concepto=="" || comprobacion.sonEspacios(concepto)) {
			Alert alertaError = new Alert(AlertType.ERROR);
			alertaError.setContentText("El Concepto es invalido");
			alertaError.setTitle("Error en concepto");
			alertaError.showAndWait();
		}else if(comprobacion.noEsNumerica(monto)) {
			Alert alertaError = new Alert(AlertType.ERROR);
			alertaError.setContentText("El monto es invalido");
			alertaError.setTitle("El monto " + monto + " no es valido");
			txtMontoIgs.setText("0");
			alertaError.showAndWait();
		}else if(Integer.parseInt(monto)>saldoSeleccionado.getMontoPendiente()){
			Alert alertaError = new Alert(AlertType.ERROR);
			alertaError.setContentText("El monto es invalido");
			alertaError.setTitle("El monto es superior al saldo\nSalda con" + saldoSeleccionado.getMontoPendiente());
			txtMontoIgs.setText("0");
			alertaError.showAndWait();
		}else {
		
			cn.insertarIngreso((0-Integer.parseInt(monto)), concepto, fondos.get(0));
			cn.desactivarDeuda(saldoSeleccionado.getIdDeuda());
			if(Integer.parseInt(monto)<saldoSeleccionado.getMontoPendiente()) {	
				int saldoNuevo = saldoSeleccionado.getMontoPendiente()-Integer.parseInt(monto); 
				cn.insertarDeuda(saldoNuevo, concepto, 1, saldoSeleccionado.getIdGasto());
			}
				
			
			escenario.close();
		}
	} catch (Exception e) {
		// TODO: handle exception
	}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		try {

			Conexion cn = new Conexion();
			clmnConceptoGasto.setCellValueFactory(new PropertyValueFactory<>("conceptoGasto"));
			clmnFechaGasto.setCellValueFactory(new PropertyValueFactory<>("fechaGasto"));
			clmnMontoPendiente.setCellValueFactory(new PropertyValueFactory<>("montoPendiente"));

			tblSaldosActivos.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Object>() {
				@Override
				public void changed(ObservableValue<? extends Object> arg0, Object arg1, Object arg2) {
					// TODO Auto-generated method stub
					saldoSeleccionado = (Saldos) arg2;
				}
			}
			);

			ArrayList<Saldos> saldos = cn.saldosActivos();
			tblSaldosActivos.setItems(FXCollections.observableArrayList(saldos));
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}

	}
}
