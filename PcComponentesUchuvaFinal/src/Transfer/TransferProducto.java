package Transfer;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TransferProducto extends Transfer {
	private String nombre, descripcion, CifMarca;
	private int ID, idSucursal;
	private float precio;
	private Boolean activo;

	public TransferProducto(ResultSet resultado) throws SQLException {
		super(resultado);
	}

	public TransferProducto(String[] datos) throws Exception {
		switch (datos.length) {
		case 7:
			if (datos[6].equals("1")) {
				activo = true;
			} else if (datos[6].equals("0")) {
				activo = false;
			} else {
				throw new Exception("Formato del campo activo incorrecto");
			}
		case 6:
			idSucursal = Integer.parseInt(datos[5]);
			
		case 5:
			try {
				precio = Float.parseFloat(datos[4]);
			} catch (NumberFormatException e) {
				throw new Exception("Formato del sueldo incorrecto, solo numeros");
			}
		case 4:
			descripcion = datos[3];
		case 3:
			CifMarca = datos[2];
		case 2:
			nombre = datos[1];
		case 1:
			if (datos[0].equalsIgnoreCase("rand")) {
				ID = idRandom();
			} else
				try {
					ID = Integer.parseInt(datos[0]);
				} catch (NumberFormatException e) {
					throw new Exception("Formato del sueldo incorrecto, solo numeros");
				}
		}
	}

	public int getID() {
		return ID;
	}

	public String getCifMarca() {
		return CifMarca;
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

	public int getIdSucursal() {
		return idSucursal;
	}

}
