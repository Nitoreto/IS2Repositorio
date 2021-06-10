package GUIVenta;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;

import main.Mediator;

public class ListarTablaDec extends JFrame{
	private JTextArea textoListarVentas;

	private JButton botonOk;
	private JTable tabla;
	private Mediator controlador;
	private String DNICliente;
	public ListarTablaDec(Mediator controlador, String DNICliente) {
		super("PCComponentes Uchuva");
		this.controlador = controlador;
		this.DNICliente = DNICliente;
		this.getContentPane().setLayout(new BorderLayout());
		if (CrearTabla().equalsIgnoreCase("Exito"))
			initComponentes();
		
	}
	private String CrearTabla() {
		String[] datos = { "rand", DNICliente };
		String inf = controlador.mostrarHistorial("ControllerVenta", datos);

		if (inf != "Exito") {
			JOptionPane.showMessageDialog(null, "Error: " + inf, "ERROR AL CONECTAR", JOptionPane.ERROR_MESSAGE);
			return "Error";
		} else {
			tabla = new JTable(controlador.actualizarTabla());
			tabla.setFont(new java.awt.Font("Consolas", 4, 40));
			tabla.setRowHeight(50);
			tabla.getTableHeader().setFont(new java.awt.Font("Consolas", 2, 50));
			JScrollPane paneScroll = new JScrollPane(tabla);
			this.getContentPane().add(paneScroll, BorderLayout.CENTER);
			this.validate();
			return "Exito";
		}
	}

}
