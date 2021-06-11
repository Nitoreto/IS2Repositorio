package GUIPersonal;

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

import Model.ModeloTablaEditable;
import Model.Observer;
import main.Mediator;

public class ListaEmpleados extends JFrame implements Observer{
	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private JTextArea textoListaEmpleados;
	private JTable tabla;
	private JButton botonBorrar;
	private JButton botonCancelar;
	private Mediator mediator;
	private ModeloTablaEditable model;

	public ListaEmpleados(Mediator mediator) {
		super("PCComponentes Uchuva");
		this.mediator = mediator;
		mediator.asignarObserver(this);
		initComponents();
	}

	private void initComponents() {
		// inicalizar objetos
		panel = new JPanel();

		textoListaEmpleados = new JTextArea();

		botonBorrar = new JButton();
		botonCancelar = new JButton();

		this.getContentPane().setLayout(new BorderLayout());

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(1920, 1080));
		mediator.listar("ControllerEmpleado");
		textoListaEmpleados.setEditable(false);
		textoListaEmpleados.setText("Listar Empleados");
		textoListaEmpleados.setFocusable(false);
		textoListaEmpleados.setFont(new Font("Consolas", 2, 100));
		textoListaEmpleados.setBackground(Color.cyan);
		textoListaEmpleados.setForeground(Color.white);
		this.getContentPane().add(textoListaEmpleados, BorderLayout.NORTH);

		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 100, 10));

		botonBorrar.setText("Borrar");
		botonBorrar.setFont(new Font("Consolas", 4, 80));
		botonBorrar.setForeground(Color.cyan);
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

		int rowSeleccionada = tabla.getSelectedRow();
		if (rowSeleccionada > -1) {
			String[] opciones = { "Eliminar", "Desactivar" };
			String[] datos = { tabla.getValueAt(rowSeleccionada, 0).toString() };

			int elecion = JOptionPane.showOptionDialog(null, "� Deseas borrarlo o desactivarlo ?", "Eliminar",
					JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
			if (elecion == 0) {
				mediator.baja("ControllerEmpleado", datos);
				mediator.listar("ControllerEmpleado");
				
				
			} else if (elecion == 1) {
				mediator.desactivar("ControllerEmpleado", datos);
				mediator.listar("ControllerEmpleado");
				
			}

		} else {
			JOptionPane.showMessageDialog(null, "Error: No esta seleccionada ninguna fila de la tabla",
					"ERROR AL CONECTAR", JOptionPane.ERROR_MESSAGE);
		}

	}


	private void botonCancelarActionPerformed(ActionEvent evt) {
			this.dispose();
			new PantallaPrincipalEmpleado(mediator);		
	}

	@Override
	public void onCorrectMessage(String msg) {
		// TODO Auto-generated method stub
		JOptionPane.showMessageDialog(null, "Se ha podido dar de baja de la base de datos ", "Exito",
				JOptionPane.INFORMATION_MESSAGE);
	}

	@Override
	public void onIncorrectMessage(String msg) {
		// TODO Auto-generated method stub
		JOptionPane.showMessageDialog(null, "Error: " + msg, "ERROR AL Modificar", JOptionPane.ERROR_MESSAGE);
	}

	@Override
	public void onTableChange(Object[][] generarTabla, String[] generarTitulo) {
		// TODO Auto-generated method stub
		mediator.listar("ControllerEmpleado");

		model = new ModeloTablaEditable(generarTabla, generarTitulo);
		tabla = new JTable(model);
		tabla.setFont(new java.awt.Font("Consolas", 4, 40));
		tabla.setRowHeight(50);
		tabla.getTableHeader().setFont(new java.awt.Font("Consolas", 2, 50));
		tabla.revalidate();
		tabla.repaint();
		JScrollPane paneScroll = new JScrollPane(tabla);
		this.getContentPane().add(paneScroll, BorderLayout.CENTER);

		this.validate();
		
	}
}
