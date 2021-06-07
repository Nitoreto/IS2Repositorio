package Transfer;

public class TransferCliente {
	private String nombre, DNI;
	private int telefono;
	private Boolean activo;
	
	public TransferCliente() {
		
	}

	public String getDNI() {
		return DNI;
	}

	public void setDNI(String dNI) {
		DNI = dNI;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public Boolean getActivo() {
		return activo;
	}

	public void setActivo(Boolean activo) {
		this.activo = activo;
	}
	
	@Override
	public void inicializarObjeto(String[] datos) throws NumberFormatException{
		for (int i = 0; i < datos.length; i++) {
			switch (i) {
			case 0:
				DNI = datos[0];
				break;
			case 1:
				nombre = datos[1];
				break;
			case 2:
				telefono = Integer.parseInt(datos[2]);
				break;
			case 3:
				if (datos[3].equals("1")) {
					activo = true;
				} else if(datos[3].equals("0")){
					activo = false;
				}else{
					throw new NumberFormatException();
				}
			}
		}
	}
	
}
