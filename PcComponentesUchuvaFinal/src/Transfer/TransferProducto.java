package Transfer;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TransferProducto extends Transfer {
	private String nombre, descripcion, nombreMarca;
	private int ID;
	private float precio;
	private Boolean activo;

	public TransferProducto(ResultSet resultado) throws SQLException {
		super(resultado);
	}

	public TransferProducto(String[] datos) throws Exception {
		super();

		nombre = datos[1];
		nombreMarca = datos[2];
		descripcion = datos[3];
		precio = Float.parseFloat(datos[4]);

		if (datos[5].equals("1")) {
			activo = true;
		} else if (datos[5].equals("0")) {
			activo = false;
		} else {
			throw new NumberFormatException();
		}
	}

	public int getID() {
		return ID;
	}

	public String getNombreMarca() {
		return nombreMarca;
	}

	public float getPrecio() {
		return precio;
	}

	public String getNombre() {
		return nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public int isActivo() {
		int valor = this.activo ? 1 : 0;
		return valor;
	}

}
