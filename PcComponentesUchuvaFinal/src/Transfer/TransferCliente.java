package Transfer;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TransferCliente extends Transfer {
	private String nombre, DNI;
	private int telefono;
	private Boolean activo;

	public TransferCliente(ResultSet resultado) throws SQLException {
		super(resultado);
	}

	public TransferCliente(String[] datos) throws Exception {
		super(datos);
	}

	public String getDNI() {
		return DNI;
	}

	public String getNombre() {
		return nombre;
	}

	public int getTelefono() {
		return telefono;
	}

	public Boolean getActivo() {
		return activo;
	}

	public void inicializarObjeto(String[] datos) throws Exception {
		DNI = datos[0];
		nombre = datos[1];
		
		try {
			telefono = Integer.parseInt(datos[2]);
		} catch (NumberFormatException e) {
			throw new Exception("Formato del telefono incorrecto");
		}
		
		if (datos[3].equals("1")) {
			activo = true;
		} else if (datos[3].equals("0")) {
			activo = false;
		} else {
			throw new Exception("Formato del campo activo incorrecto");
		}
	}

}
