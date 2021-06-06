package DAO_Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import factoria.Transfer;

import java.sql.ResultSet;

public class Conexion extends SingletonConexion{

	protected Connection conexion;
	protected Statement statement;
	protected Transfer transfer;

	public Conexion()throws SQLException {
		conexion = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/pccomponentes?autoReconnect=true&useSSL=false", "root", "3110");
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
	public void close() {
		try {
			statement.close();
			conexion.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
