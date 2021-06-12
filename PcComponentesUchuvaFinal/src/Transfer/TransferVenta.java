package Transfer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

public class TransferVenta extends Transfer {
	private int idVentas, idSucursal, IdProducto, precioTotal;
	private String DNIEmpleado, DNICliente, fecha;
	private Boolean activo;

	public TransferVenta(ResultSet resultado) throws SQLException {
		super(resultado);
	}

	public TransferVenta(String[] datos) throws Exception {
		switch (datos.length) {
		case 8:
			if (datos[7].equals("1")) {
				activo = true;
			} else if (datos[7].equals("0")) {
				activo = false;
			} else {
				throw new Exception("Formato del campo activo incorrecto");
			}
		case 7:
			try {
				idSucursal = Integer.parseInt(datos[6]);
			} catch (NumberFormatException e) {
				throw new Exception("Formato del id del sucursal incorrecto, solo numeros");
			}
		case 6:
			fecha = datos[5];
		case 5:
			try {
				this.precioTotal = Integer.parseInt(datos[4]);
			} catch (NumberFormatException e) {
				throw new Exception("Formato del precio total incorrecto, solo numeros");
			}
		case 4:
			try{
				this.IdProducto = Integer.parseInt(datos[3]);
			} catch (NumberFormatException e) {
				throw new Exception("Formato del id de empleado incorrecto, solo numeros");
			}
		case 3:
				this.DNIEmpleado = datos[2];

			case 2:
				this.DNICliente = datos[1];
			case 1:
				if (datos[0].equalsIgnoreCase("rand")) {
					idVentas = idRandom();
				} else {
					try {
						this.idVentas = Integer.parseInt(datos[0]);
					} catch (NumberFormatException e) {
						throw new Exception("Formato del id incorrecto, solo numeros");
					}
				}
			}

		}

	public String getDNIEmpleado() {
		return this.DNIEmpleado;
	}

	public int getPrecioTotal() {
		return precioTotal;
	}

	public int getIdVenta() {
		return idVentas;
	}

	public String getDNICliente() {
		return DNICliente;
	}

	public int getIdProducto() {
		return IdProducto;
	}

	public int isActivo() {
		int valor = this.activo ? 1 : 0;
		return valor;
	}

	public String getFecha() {
		return fecha;
	}

	public int getIdSucursal() {
		return idSucursal;
	}
}
