package dao_Transfer_Singelton;

import java.sql.ResultSet;
import java.sql.SQLException;


public abstract  class SingletonConexion{
	private static SingletonConexion conexion;
	
	public static SingletonConexion obtenerConexion() {
		if(conexion == null)
			conexion = new Conexion();
		return conexion;
	}
	
	protected abstract int conectarUpdate() throws SQLException;
	protected abstract ResultSet conectarExecute() throws SQLException;
	public abstract void close();
}
