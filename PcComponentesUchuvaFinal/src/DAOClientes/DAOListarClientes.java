package DAOClientes;

import java.sql.SQLException;
import DAOAndTransfer.DAOSuper;
import DAOAndTransfer.Transfer;
import factoria.Cliente;

public class DAOListarClientes extends DAOSuper {
  
        
     public DAOListarClientes(Cliente cliente) {
 		super();
 		this.query = "SELECT * FROM clientes";
 	} 

    public String conectar() {


		try {
		
			this.transfer = new Transfer(super.conectarExecute());
			
		} catch (SQLException e) {
			return e.getMessage();
		}
		
		return "Exito";
	}   
}