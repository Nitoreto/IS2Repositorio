package dao_Transfer_Singelton;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract  class SingletonConexion {
	private static SingletonConexion conexion;
	
	public static SingletonConexion obtenerConexion() {
		if(conexion == null)
			conexion = try {
				conexion = DriverManager.getConnection(
						"jdbc:mysql://localhost:3306/pccomponentes?autoReconnect=true&useSSL=false", "root", "3110");
			} catch (SQLException e1) {
			}
		return conexion;
	}
	
	protected abstract int conectarUpdate() throws SQLException;
	protected abstract ResultSet conectarExecute() throws SQLException;
	public abstract void close();
}
