package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

import objs.Deudas;
import objs.Fondos;
import objs.Gastos;
import objs.Ingresos;
import objs.Saldos;

public class Conexion {

	private String url = "jdbc:mariadb://127.0.0.1:3306/admon?serverTimezone = UTC";
	private String usuario = "root";
	private String pass = "1234";
	private Connection conexion;
	public Conexion() throws ClassNotFoundException, SQLException {
		
			Class.forName("org.mariadb.jdbc.Driver");
			conexion = DriverManager.getConnection(url,usuario,pass);
			
		
		
	}
	
	public int capitalTotal() throws SQLException {
		String query = " select sum(capital)-(select capital from fondos where id_fondo=1) from fondos";
		int sumaCapFondos=0;
		
		Statement st = conexion.createStatement();
		ResultSet rs = st.executeQuery(query); 
		
		rs.next();
		sumaCapFondos = rs.getInt(1);
		
		rs.close();
		st.close();
			
		
		return sumaCapFondos;
	}
	
	public int deudaActiva()  throws SQLException {
		String query = " select capital from fondos where id_fondo = 1;";
		int sumaDeuda=0;
		
		Statement st = conexion.createStatement();
		ResultSet rs = st.executeQuery(query); 
		
		rs.next();
		sumaDeuda = rs.getInt(1);
		
		rs.close();
		st.close();
			
		
		return sumaDeuda;
	}
	
	public int estabilidad()  throws SQLException {
		String query = " select sum(monto) - sum(capital) from fondos where id_fondo != 1;";
		int estabilidad=0;
		
		Statement st = conexion.createStatement();
		ResultSet rs = st.executeQuery(query); 
		
		rs.next();
		estabilidad = rs.getInt(1);
		
		rs.close();
		st.close();
			
		
		return estabilidad;
	}
	
	public int saldoActivoTotal()  throws SQLException {
		String query = " select  sum(d.monto) from gastos g, deudas d where g.id_gasto=d.id_gasto and d.estado= 1";
		int sumaDeuda=0;
		
		Statement st = conexion.createStatement();
		ResultSet rs = st.executeQuery(query); 
		
		rs.next();
		sumaDeuda = rs.getInt(1);
		
		rs.close();
		st.close();
			
		
		return sumaDeuda;
	}
	
	public ArrayList<Fondos> traerFondos() throws SQLException {
		String query = "SELECT * FROM fondos";
		Statement st = conexion.createStatement();
		ResultSet rs = st.executeQuery(query);
		ArrayList<Fondos> datos = new ArrayList<>();
		while (rs.next()) {
			datos.add(new Fondos(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getInt(4)));
		}
		rs.close();
		st.close();

		return datos;
	}
	
	public void cerrarConexion() throws SQLException {
		conexion.close();
	}

	public void insertarFondo(Fondos fondoAinsertar) throws SQLException {
		String query = "INSERT INTO fondos(monto,nom_fondo,capital) VALUES"
				+ "(?,?,?)";
		PreparedStatement ps = conexion.prepareStatement(query);
		ps.setInt(1, fondoAinsertar.getMontoDeseado());
		ps.setString(2, fondoAinsertar.getNombre());
		ps.setInt(3, fondoAinsertar.getCapitalActual());
		ps.execute();
		ps.close();
	}

	public void updateFondo(int idFondo, String nombre, int parseInt) throws SQLException {
		String query = "update fondos set nom_fondo = ?, monto = ? where id_fondo = ?;";
		PreparedStatement ps = conexion.prepareStatement(query);
		ps.setString(1, nombre);
		ps.setInt(2, parseInt);
		ps.setInt(3, idFondo);
		ps.execute();
		ps.close();
		
	}

	public ArrayList<Ingresos> ingresosDeFondo(int idFondo) throws SQLException{
		String query = "SELECT * FROM ingresos where fondo_destino = " + idFondo;
		Statement st = conexion.createStatement();
		ResultSet rs = st.executeQuery(query);
		ArrayList<Ingresos> datos = new ArrayList<>();
		while (rs.next()) {
			datos.add(new Ingresos(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getInt(5)));
		}
		rs.close();
		st.close();

		return datos;
	}

	public ArrayList<Gastos> gastosDeFondo(int idFondo) throws SQLException{
		String query = "SELECT * FROM gastos where fondo_tomado = " + idFondo;
		Statement st = conexion.createStatement();
		ResultSet rs = st.executeQuery(query);
		ArrayList<Gastos> datos = new ArrayList<>();
		while (rs.next()) {
			datos.add(new Gastos(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5),rs.getInt(6)));
		}
		rs.close();
		st.close();

		return datos;
	}

	public void insertarIngreso(int monto, String concepto, Fondos fondoSeleccionado)  throws SQLException{
		String query = "INSERT INTO ingresos(monto,concepto,fondo_destino) VALUES"
				+ "(?,?,?)";
		PreparedStatement ps = conexion.prepareStatement(query);
		ps.setInt(1, monto);
		ps.setString(2, concepto);
		ps.setInt(3, fondoSeleccionado.getIdFondo());
		ps.execute();
		query = "update fondos set capital = ? where id_fondo= ?;";
		ps = conexion.prepareStatement(query);
		ps.setInt(1, fondoSeleccionado.getCapitalActual()+monto);
		ps.setInt(2, fondoSeleccionado.getIdFondo());
		ps.execute();
		ps.close();
		
		
		
	}

	public ArrayList<Ingresos> consultarIngresos(String ini, String fin) throws SQLException {
		String query = "select * from ingresos where fecha >= '"+ ini +"' and fecha <= '"+ fin + "'";
		Statement st = conexion.createStatement();
		ResultSet rs = st.executeQuery(query);
		ArrayList<Ingresos> datos = new ArrayList<>();
		while (rs.next()) {
			datos.add(new Ingresos(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getInt(5)));
			
		}
		rs.close();
		st.close();

		return datos;
	}

	public int ingresosPeriodo(String ini, String fin) throws SQLException {
		String query = "  select sum(monto) from ingresos where fecha >= '"+ ini +"' and fecha <= '"+ fin + "'";
		int ingresoTotal=0;
		
		Statement st = conexion.createStatement();
		ResultSet rs = st.executeQuery(query); 
		
		rs.next();
		ingresoTotal = rs.getInt(1);
		
		rs.close();
		st.close();
			
		
		return ingresoTotal;
	}

	public int registrarGasto(int monto, String concepto, String clasificacion, Fondos fondoTomado) throws SQLException {
		String query = "INSERT INTO gastos(monto,concepto,clasificacion, fondo_tomado) VALUES"
				+ "(?,?,?,?)";
		PreparedStatement ps = conexion.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
		
		ps.setInt(1, monto);
		ps.setString(2, concepto);
		ps.setString(3, clasificacion);
		ps.setInt(4, fondoTomado.getIdFondo());
		ps.execute();ResultSet rs = ps.getGeneratedKeys();
		int id=-1;
		if(rs.next()) {
			id=rs.getInt(1);
		}
		rs.close();
		if(fondoTomado.getIdFondo()==1) {
			monto = 0 - monto;
		}
		query = "update fondos set capital = ? where id_fondo= ?;";
		ps = conexion.prepareStatement(query);
		ps.setInt(1, (fondoTomado.getCapitalActual()-monto));
		ps.setInt(2, fondoTomado.getIdFondo());
		ps.execute();
		ps.close();
		return id;
	}
	
	public void insertarDeuda(int monto, String conepto, int estado, int idGasto) throws SQLException {
		String query = "INSERT INTO deudas(monto,concepto,estado, id_gasto) VALUES"
				+ "(?,?,?,?)";
		PreparedStatement ps = conexion.prepareStatement(query);
		ps.setInt(1, monto);
		ps.setString(2,conepto);
		ps.setInt(3, estado);
		ps.setInt(4, idGasto);
		ps.execute();
		ps.close();
	}

	public ArrayList<Gastos> consultarGastos(String ini, String fin) throws SQLException {
		String query = "select * from gastos where fecha >= '"+ ini +"' and fecha <= '"+ fin + "'";
		Statement st = conexion.createStatement();
		ResultSet rs = st.executeQuery(query);
		ArrayList<Gastos> datos = new ArrayList<>();
		while (rs.next()) {
			datos.add(new Gastos(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4),rs.getString(5), rs.getInt(6)));
			
		}
		rs.close();
		st.close();

		return datos;
	}

	public int gastosPeriodo(String ini, String fin) throws SQLException {
		String query = "  select sum(monto) from gastos where fecha >= '"+ ini +"' and fecha <= '"+ fin + "'";
		int gastoTotal=0;
		
		Statement st = conexion.createStatement();
		ResultSet rs = st.executeQuery(query); 
		
		rs.next();
		gastoTotal = rs.getInt(1);
		
		rs.close();
		st.close();
			
		
		return gastoTotal;
	}

	public ArrayList<Saldos> saldosActivos() throws SQLException {
		// TODO Auto-generated method stub
		String query = "select  d.id_deuda,g.id_gasto,g.concepto,g.fecha,d.monto from gastos g, deudas d where g.id_gasto=d.id_gasto and d.estado= 1;";
		Statement st = conexion.createStatement();
		ResultSet rs = st.executeQuery(query);
		ArrayList<Saldos> datos = new ArrayList<>();
		while (rs.next()) {
			datos.add(new Saldos(rs.getInt(1),rs.getInt(2), rs.getString(3), rs.getString(4), rs.getInt(5)));
		}
		rs.close();
		st.close();

		return datos;
	}

	public void desactivarDeuda(int idDeuda) throws SQLException {
		String query = "update deudas set estado = 0 where id_deuda = ?;";
		PreparedStatement ps = conexion.prepareStatement(query);
		ps.setInt(1, idDeuda);
		ps.execute();
		ps.close();
		
	}
	
	public ArrayList<Gastos> gastosDeDeuda() throws SQLException{
		String query = "select * from gastos where fondo_tomado=1";
		Statement st = conexion.createStatement();
		ResultSet rs = st.executeQuery(query);
		ArrayList<Gastos> datos = new ArrayList<>();
		while (rs.next()) {
			datos.add(new Gastos(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4),rs.getString(5), rs.getInt(6)));
			
		}
		rs.close();
		st.close();

		return datos;
	}
	
	public ArrayList<Saldos> buscarSaldos(String ini, String fin, Gastos filtro) throws SQLException {
		// TODO Auto-generated method stub
		String query = "select  d.id_deuda,g.id_gasto,g.concepto,d.fecha,d.concepto from gastos g, deudas d where g.id_gasto=d.id_gasto and d.fecha >= '" + ini +"' and d.fecha <= '"+ fin +"'";
		if(filtro!=null) {
			query = query + " and d.id_gasto = " + filtro.getIdGasto();
		}
		Statement st = conexion.createStatement();
		ResultSet rs = st.executeQuery(query);
		ArrayList<Saldos> datos = new ArrayList<>();
		while (rs.next()) {
			datos.add(new Saldos(rs.getInt(1),rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5)));
		}
		rs.close();
		st.close();
		return datos;
	}

	public ArrayList<Deudas> traerDeudas(String fecha, int i) throws SQLException {
		String query = "select id_deuda,concepto, monto, estado, fecha from deudas where fecha >= '" + fecha + "'";
		if(i==1) {
			query = query + " and estado = 1" ;
		}
		Statement st = conexion.createStatement();
		ResultSet rs = st.executeQuery(query);
		ArrayList<Deudas> datos = new ArrayList<>();
		while (rs.next()) {
			datos.add(new Deudas(rs.getInt(1),rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getString(5)));
		}
		rs.close();
		st.close();
		return datos;
	}
}
