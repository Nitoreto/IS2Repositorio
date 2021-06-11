package DAO_Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class Conexion extends SingletonConexion{

	protected Connection conexion;
	protected Statement statement;
	private int puerto = 3306;
	private String nombreBBDD = "pccomponentes";
	private String user = "root";
	private String paswordd = "3110";

	public Conexion()throws SQLException {
		conexion = DriverManager.getConnection(
				"jdbc:mysql://localhost:" + puerto +"/"+nombreBBDD+"?autoReconnect=true&useSSL=false", user, paswordd);
	}

	@Override
	public int conectarUpdate(String query) throws SQLException {
		int row;
		statement = conexion.prepareStatement(query);
		row = statement.executeUpdate(query);
		statement.close();
		return row;
	}

	@Override
	public ResultSet conectarExecute(String query) throws SQLException {
		ResultSet resultado;
		statement = conexion.prepareStatement(query);
		resultado = statement.executeQuery(query);
		return resultado;
	}

	@Override
	public void close() throws SQLException {
		statement.close();
		conexion.close();

	}

}
