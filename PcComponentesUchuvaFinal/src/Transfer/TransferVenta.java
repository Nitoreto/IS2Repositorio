package Transfer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

public class TransferVenta extends Transfer {
	private int idVentas, idEmpleado, precioTotal;
	private String DNICliente, listaProductos;
	private Boolean activo;

	public TransferVenta(ResultSet resultado) throws SQLException {
		super(resultado);
	}

	public TransferVenta(String[] datos) throws Exception {
		if (datos[0].equalsIgnoreCase("rand")) {
			idVentas = idRandom();
		} else {
			try {
				this.idVentas = Integer.parseInt(datos[0]);
			} catch (NumberFormatException e) {
				throw new Exception("Formato del id incorrecto, solo numero");
			}
		}
		
		this.DNICliente = datos[1];
		
		try {
			this.idEmpleado = Integer.parseInt(datos[2]);
		} catch (NumberFormatException e) {
			throw new Exception("Formato del id de empleado incorrecto, solo numero");
		}
		
		this.listaProductos = datos[3];
		
		try {
			this.precioTotal = Integer.parseInt(datos[4]);
		} catch (NumberFormatException e) {
			throw new Exception("Formato del precio total incorrecto, solo numero");
		}

		if (datos[5].equals("1")) {
			activo = true;
		} else if (datos[5].equals("0")) {
			activo = false;
		} else {
			throw new Exception("Formato del campo activo incorrecto");
		}

	}

	private int idRandom() {
		Random r = new Random();
		return r.nextInt(1000000);
	}

	public int getIdEmpleado() {
		return idEmpleado;
	}

	public int getPrecioTotal() {
		return precioTotal;
	}

	public int getIdVentas() {
		return idVentas;
	}

	public String getDNICliente() {
		return DNICliente;
	}

	public String getListaProductos() {
		return listaProductos;
	}

	public int getActivo() {
		int valor = this.activo ? 1 : 0;
		return valor;
	}
}
