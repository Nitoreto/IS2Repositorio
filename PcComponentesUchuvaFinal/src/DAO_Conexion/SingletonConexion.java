package DAO_Conexion;

import java.sql.ResultSet;
import java.sql.SQLException;


public abstract  class SingletonConexion{
	private static SingletonConexion conexion;
	
	public static SingletonConexion obtenerConexion() throws SQLException {
		if(conexion == null)
			conexion = new Conexion();
		return conexion;
	}
	
	public abstract int conectarUpdate(String query) throws SQLException;
	public abstract ResultSet conectarExecute(String query) throws SQLException;
	public abstract void close() throws SQLException;
}
