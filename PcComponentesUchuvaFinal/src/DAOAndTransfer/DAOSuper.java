package DAOAndTransfer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class DAOSuper {

	protected Connection conexion;
	protected String query;
	protected Statement statement;
	protected Transfer transfer;
	private Boolean instancia;

	public DAOSuper() {
		instancia = true;

		try {
			conexion = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/pccomponentes?autoReconnect=true&useSSL=false", "root", "3110");
		} catch (SQLException e1) {
		}
	}

	protected int conectarUpdate() throws SQLException {
		int row;
		statement = conexion.prepareStatement(query);
		row = statement.executeUpdate(query);
		statement.close();
		conexion.close();
		instancia = false;
		;

		return row;
	}

	protected ResultSet conectarExecute() throws SQLException {
		ResultSet resultado;
		statement = conexion.prepareStatement(query);
		resultado = statement.executeQuery(query);

		return resultado;
	}

	public Object[][] generarTabla() {
		return this.transfer.generarObject();
	}

	public String[] generarTitulos() {
		return this.transfer.generarTitulos();
	}

	public void close() {
		if (instancia == true) {
			try {
				statement.close();
				conexion.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			instancia = false;
		}

	}

}
