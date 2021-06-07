package GUIMarca;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;
import main.Mediator;

public class ListarMarcas extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private JTextArea textoListarMarca;
	private JTable tabla;
	private JButton botonBorrar;
	private JButton botonCancelar;
	private Mediator controlador;

	public ListarMarcas(Mediator controlador) {
		super("PCComponentes Uchuva");
		this.controlador = controlador;
		initComponents();
	}

	private void initComponents() {
		// inicalizar objetos
		panel = new JPanel();

		textoListarMarca = new JTextArea();

		botonBorrar = new JButton();
		botonCancelar = new JButton();

		this.getContentPane().setLayout(new BorderLayout());

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(1920, 1080));
		CrearTabla();
		textoListarMarca.setEditable(false);
		textoListarMarca.setText("Listar ControllerMarca");
		textoListarMarca.setFocusable(false);
		textoListarMarca.setFont(new Font("Consolas", 2, 100));
		textoListarMarca.setBackground(Color.orange);
		textoListarMarca.setForeground(Color.white);
		this.getContentPane().add(textoListarMarca, BorderLayout.NORTH);

		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 100, 10));

		botonBorrar.setText("Borrar");
		botonBorrar.setFont(new Font("Consolas", 4, 80));
		botonBorrar.setForeground(Color.orange);
		botonBorrar.setContentAreaFilled(false);
		botonBorrar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				botonBorrarActionPerformed(evt);
			}
		});
		panel.add(botonBorrar);

		botonCancelar.setText("Cancelar");
		botonCancelar.setFont(new Font("Consolas", 4, 80));
		botonCancelar.setForeground(Color.red);
		botonCancelar.setContentAreaFilled(false);
		botonCancelar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {

				botonCancelarActionPerformed(evt);
			}
		});
		panel.add(botonCancelar);

		this.getContentPane().add(panel, BorderLayout.SOUTH);
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	private void botonBorrarActionPerformed(ActionEvent evt) {

		// ----------------------------
		int rowSeleccionada = tabla.getSelectedRow();
		if (rowSeleccionada > -1) {
			String[] opciones = { "Eliminar", "Desactivar" };
			String[] datos = { tabla.getValueAt(rowSeleccionada, 0).toString() };
			String inf = "Exito";

			int elecion = JOptionPane.showOptionDialog(null, "¿ Deseas borrarlo o desactivarlo ?", "Eliminar",
					JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
			if (elecion == 0) {
				inf = controlador.baja("ControllerMarca", datos);
				controlador.listar("ControllerMarca");
				tabla.setModel(controlador.actualizarTabla());
				tabla.revalidate();
				tabla.repaint();
			} else if (elecion == 1) {
				inf = controlador.desactivar("ControllerMarca", datos);
				controlador.listar("ControllerMarca");
				tabla.setModel(controlador.actualizarTabla());
				tabla.revalidate();
				tabla.repaint();
			}	
			if (inf != "Exito") {
				JOptionPane.showMessageDialog(null, "Error: " + inf, "ERROR AL CONECTAR", JOptionPane.ERROR_MESSAGE);
			}

		} else {
			JOptionPane.showMessageDialog(null, "Error: No esta seleccionada ninguna fila de la tabla",
					"ERROR AL CONECTAR", JOptionPane.ERROR_MESSAGE);
		}

	}

	private void CrearTabla() {
		String inf = controlador.listar("ControllerMarca");
		if (inf != "Exito") {
			JOptionPane.showMessageDialog(null, "Error: " + inf, "ERROR AL CONECTAR", JOptionPane.ERROR_MESSAGE);
		}
		
		tabla = new JTable(controlador.actualizarTabla());
		tabla.setFont(new java.awt.Font("Consolas", 4, 40));
		tabla.setRowHeight(50);
		tabla.getTableHeader().setFont(new java.awt.Font("Consolas", 2, 50));
		JScrollPane paneScroll = new JScrollPane(tabla);
		this.getContentPane().add(paneScroll, BorderLayout.CENTER);
		this.validate();
	}

	private void botonCancelarActionPerformed(ActionEvent evt) {
		String inf = controlador.cancelar();
		if (inf != "Exito") {
			JOptionPane.showMessageDialog(null, "Error: " + inf, "ERROR AL CONECTAR", JOptionPane.ERROR_MESSAGE);
		} else {
			this.dispose();
			new PantallaPrincipalMarca(controlador);
		}
	}

}
