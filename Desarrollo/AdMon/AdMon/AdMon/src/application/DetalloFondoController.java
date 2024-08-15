package application;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import db.Conexion;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventType;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.util.Callback;
import objs.Fondos;
import objs.Gastos;
import objs.Ingresos;
import javafx.scene.control.TableColumn;

public class DetalloFondoController{
	Fondos fondo;
	@FXML
	private TableView<Ingresos> tblIngresos;
	@FXML
	private TableColumn<Ingresos, String> clmnFechaIgs;
	@FXML
	private TableColumn<Ingresos, Integer> clmnMontoIgs;
	@FXML
	private TableColumn<Ingresos, String> clmnConceptoIgs;
	@FXML
	private TableView<Gastos> tblGastos;
	@FXML
	private TableColumn<Gastos, String> clmnFechaGts;
	@FXML
	private TableColumn<Gastos, Integer> clmnMontoGts;
	@FXML
	private TableColumn<Gastos, String> clmnClasificacionGts;
	@FXML
	private TableColumn<Gastos, String> clmnConceptoGts;
	@FXML
	private Label lblNombre;
	@FXML
	private Label lblMontoDeseado;
	@FXML
	private Label lblCapActual;
	@FXML
	private Label lblEstabilidad;
	@FXML
	private Button btnCerrar;

	// Event Listener on Button[#btnCerrar].onAction
	@FXML
	public void cerrarDetalle(ActionEvent event) {
		Stage escenario = (Stage)btnCerrar.getScene().getWindow();
		escenario.close();
	}
	
	public void setFondo(Fondos fondo) {
		this.fondo = fondo;
		
		this.lblNombre.setText("Fondo: " + fondo.getNombre());
		this.lblMontoDeseado.setText("Monto Deseado\t$" + fondo.getMontoDeseado());
		this.lblCapActual.setText(   "Capital Actual\t\t$" + fondo.getCapitalActual());
		this.lblEstabilidad.setText( "Estabilidad\t\t$" + (fondo.getMontoDeseado() - fondo.getCapitalActual()));
		
		try {
			Conexion cn = new Conexion();
			
			
			// Llenado de la tablas
			this.clmnFechaIgs.setCellValueFactory(new PropertyValueFactory<>("fecha"));
			this.clmnMontoIgs.setCellValueFactory(new PropertyValueFactory<>("monto"));
			this.clmnConceptoIgs.setCellValueFactory(new PropertyValueFactory<>("concepto"));
			
			ArrayList<Ingresos> ingresos = cn.ingresosDeFondo(fondo.getIdFondo());
			this.tblIngresos.setItems(FXCollections.observableArrayList(ingresos));
			
			this.clmnFechaGts.setCellValueFactory(new PropertyValueFactory<>("fecha"));
			this.clmnMontoGts.setCellValueFactory(new PropertyValueFactory<>("monto"));
			this.clmnClasificacionGts.setCellValueFactory(new PropertyValueFactory<>("clasificacion"));
			this.clmnConceptoGts.setCellValueFactory(new PropertyValueFactory<>("concepto"));
			
			ArrayList<Gastos> gastos = cn.gastosDeFondo(fondo.getIdFondo());
			this.tblGastos.setItems(FXCollections.observableArrayList(gastos));
			
			
			
			// Cerrar conexion
			cn.cerrarConexion();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
