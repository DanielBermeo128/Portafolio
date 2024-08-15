package application;

import javafx.fxml.FXML;
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

import javafx.scene.control.Label;

import javafx.scene.control.ComboBox;

import javafx.scene.control.RadioButton;

public class RegistrarGastoController implements Initializable {
	Fondos podibleFondo;


	@FXML
	private TextField txtConceptoGts;
	@FXML
	private TextField txtMontoGts;
	@FXML
	private ComboBox cmbClasificacionGts;
	@FXML
	private ComboBox cmbFondosDisponibles;
	@FXML
	private Button btnGastoListo;
	@FXML
	private RadioButton rdButtonPagarConDeuda;
	@FXML
	private Label lblRegistroDeuda;
	@FXML
	private Label lblMonto;
	@FXML
	private TextField txtMontoDeuda;
	@FXML
	private Label lblConcepto;
	@FXML
	private TextField txtConptoDeuda;
	@FXML
	private Button btnDescartar;

	// Event Listener on Button[#btnGastoListo].onAction
	@FXML
	public void finalizadoIngreso(ActionEvent event) {
		Stage escenario = (Stage) btnDescartar.getScene().getWindow();
		Alert alerta = new Alert(AlertType.CONFIRMATION);
		alerta.setTitle("Confirmar");
		alerta.setContentText("¿Estas del registro?\nEsta accion es inalterable");
		Optional<ButtonType> action = alerta.showAndWait();
		if (action.get() == ButtonType.OK) {
			String concepto = txtConceptoGts.getText();
			MetodosComprobacion comprobar = new MetodosComprobacion();
			if (concepto == "" || comprobar.sonEspacios(concepto)) {
				Alert alertaError = new Alert(AlertType.ERROR);
				alertaError.setContentText("El concepto es invalido");
				alertaError.setTitle("Agregue una descripcion");
				alertaError.showAndWait();

			} else if (cmbClasificacionGts.getSelectionModel().getSelectedItem() == null) {
				Alert alertaError = new Alert(AlertType.ERROR);
				alertaError.setContentText("Seleccione una clasificacion");
				alertaError.setTitle("No se ha seleccionado una clasificacion");
				alertaError.showAndWait();
			} else if (cmbFondosDisponibles.getSelectionModel().getSelectedItem() == null && !rdButtonPagarConDeuda.isSelected()) {
				Alert alertaError = new Alert(AlertType.ERROR);
				alertaError.setContentText("Seleccione un fondo");
				alertaError.setTitle("No se ha seleccionado un fondo");
				alertaError.showAndWait();
			} else {
				try {
					Conexion cn = new Conexion();
					if (rdButtonPagarConDeuda.isSelected()) {
						// Deuda
						if (txtConptoDeuda.getText() == "" || comprobar.sonEspacios(txtConptoDeuda.getText())) {
							Alert alertaError = new Alert(AlertType.ERROR);
							alertaError.setContentText("El concepto de deuda es invalido");
							alertaError.setTitle("Agregue una descripcion a la deuda");
							alertaError.showAndWait();

						} else if (comprobar.noEsNumerica(txtMontoGts.getText())) {
							Alert alertaError = new Alert(AlertType.ERROR);
							alertaError.setContentText("El monto no es valido");
							alertaError.setTitle("El monto " + txtMontoGts.getText() + " no es valido");
							alertaError.showAndWait();
						} else {
							Fondos fon = cn.traerFondos().get(0);
							int idGasto = cn.registrarGasto(Integer.parseInt(txtMontoGts.getText()), concepto,
									(String) cmbClasificacionGts.getSelectionModel().getSelectedItem(), fon);
							cn.insertarDeuda(Integer.parseInt(txtMontoGts.getText()), txtConptoDeuda.getText(), 1,
									idGasto);
							escenario.close();

						}
					} else {
						// Gasto a fondo

						Fondos f = (Fondos) cmbFondosDisponibles.getSelectionModel().getSelectedItem();
						cn.registrarGasto(Integer.parseInt(txtMontoGts.getText()), concepto,
								(String) cmbClasificacionGts.getSelectionModel().getSelectedItem(), f);
						escenario.close();
					}

				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} else {
			alerta.close();
		}
	}

	@FXML
	void pagarConDeuda(ActionEvent event) throws ClassNotFoundException, SQLException {

		if (rdButtonPagarConDeuda.isSelected()) {

			cmbFondosDisponibles.getSelectionModel().select(0);
			cmbFondosDisponibles.setDisable(true);
			lblRegistroDeuda.setVisible(true);
			lblConcepto.setVisible(true);

			txtConptoDeuda.setVisible(true);

			
		} else {
			cmbFondosDisponibles.getSelectionModel().select(1);
			cmbFondosDisponibles.setDisable(false);
			lblRegistroDeuda.setVisible(false);
			lblConcepto.setVisible(false);

			txtConptoDeuda.setVisible(false);

			
		}
	}

	// Event Listener on Button[#btnDescartar].onAction
	@FXML
	public void descartarGasto(ActionEvent event) {
		Stage escenario = (Stage) btnDescartar.getScene().getWindow();
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
		// TODO Auto-generated method stub
		try {

			Conexion cn = new Conexion();
			ArrayList<Fondos> fondos = cn.traerFondos();
			ObservableList<Fondos> fondosVis = FXCollections.observableArrayList();
			for (Fondos f : fondos) {
				fondosVis.add(f);
			}
			cmbFondosDisponibles.setItems(fondosVis);
			ObservableList<String> clasificacion = FXCollections.observableArrayList();
			clasificacion.add("Bueno");
			clasificacion.add("Necesario");
			clasificacion.add("Innecesario");
			cmbClasificacionGts.setItems(clasificacion);

			this.cmbFondosDisponibles.getSelectionModel().selectedItemProperty()
					.addListener(new ChangeListener<Object>() {

						@Override
						public void changed(ObservableValue<? extends Object> arg0, Object arg1, Object arg2) {
							Fondos f = (Fondos) arg2;
							if (f.getIdFondo() == 1) {
								rdButtonPagarConDeuda.setSelected(true);
								try {
									pagarConDeuda(null);
								} catch (ClassNotFoundException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}

						}
					});

			txtMontoGts.textProperty().addListener(new ChangeListener<Object>() {

				@Override
				public void changed(ObservableValue<? extends Object> arg0, Object arg1, Object arg2) {
					// TODO Auto-generated method stub
					if (rdButtonPagarConDeuda.isSelected()) {

					} else {
						MetodosComprobacion comprobacion = new MetodosComprobacion();
						String monto = (String) arg2;
						if (comprobacion.noEsNumerica(monto) && monto != null && !monto.equals("")) {
							Alert alerta = new Alert(AlertType.ERROR);
							alerta.setTitle("Error en el monto");
							alerta.setContentText("El monto " + monto + " no es valido");
							alerta.showAndWait();
							txtMontoGts.setText("");
						} else {
							int montoNum = Integer.parseInt(monto);

							try {
								ArrayList<Fondos> filtroFondos = cn.traerFondos();
								ObservableList<Fondos> fondosPudientes = FXCollections.observableArrayList();
								for (Fondos f : filtroFondos) {
									if (f.getCapitalActual() >= montoNum) {

										fondosPudientes.add(f);
									}
								}
								cmbFondosDisponibles.setItems(fondosPudientes);

							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}

						}
					}
				}

			});

		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	

	public void setPosibleFondo(Fondos f){
		this.podibleFondo = f;
		cmbFondosDisponibles.getSelectionModel().select(f);
		
	}

}
