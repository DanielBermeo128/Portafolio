package extras;

import java.sql.SQLException;
import java.util.ArrayList;

import db.Conexion;
import objs.Fondos;

public class MetodosComprobacion {
	
	
	public boolean nombreDuplicadoFondo(String nombreF){
		boolean desicion = false;
		Conexion cn;
		try {
			cn = new Conexion();
			ArrayList<Fondos> fondosExistentes = cn.traerFondos();
			for(Fondos f: fondosExistentes) {
				if(f.getNombre().equals(nombreF)) {
					desicion = true;
				}
			}
			cn.cerrarConexion();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return desicion;
		
		
	}
	
	public boolean sonEspacios(String cad)
	 {
	 for(int i =0; i<cad.length(); i++)
	 if(cad.charAt(i) != ' ')
	 return false;
	 
	 return true;
	 }
	
	public boolean noEsNumerica(String cadena) {

        boolean resultado;

        try {
            Integer.parseInt(cadena);
            resultado = false;
        } catch (NumberFormatException excepcion) {
            resultado = true;
        }

        return resultado;
    }

}
