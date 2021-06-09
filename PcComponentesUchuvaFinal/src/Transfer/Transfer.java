package Transfer;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public abstract class Transfer {

	ResultSet resultado;
	ResultSetMetaData metaDat;

	public Transfer(ResultSet resultado) throws SQLException {
		this.resultado = resultado;
		if (!resultado.next()) {
			// ResultSet is empty
			throw new SQLException("No se ha encontrado ningun Elemento");
		}
		this.metaDat = resultado.getMetaData();
	}
	
	public Transfer(String[] datos) throws Exception {
		this.inicializarObjeto(datos);
	}

	public Object[][] generarTabla() {
		try {
			int columTam = metaDat.getColumnCount();
			resultado.last();
			int rowTam = resultado.getRow();
			Object[][] datos = new Object[rowTam][columTam];
			int i = 0;
			resultado.absolute(1);
			do {
				for (int a = 0; a < columTam; a++) {
					datos[i][a] = resultado.getObject(a + 1);
				}
				i++;
			} while (resultado.next());
			return datos;
		} catch (SQLException e) {
		}
		return null;

	}

	public String[] generarTitulos() {

		try {
			int tam = metaDat.getColumnCount();
			String[] titulos = new String[tam];
			for (int i = 0; i < tam; i++) {
				titulos[i] = metaDat.getColumnName(i + 1);
			}
			return titulos;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public abstract void inicializarObjeto(String[] datos) throws Exception;

}
