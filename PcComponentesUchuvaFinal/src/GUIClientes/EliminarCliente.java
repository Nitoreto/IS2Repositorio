package GUIClientes;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import Model.Observer;
import main.Mediator;

public class EliminarCliente extends JFrame implements Observer{
	private static final long serialVersionUID = 1L;

	private JPanel panel;
	private JPanel panelDatos;
	private JPanel panelMostrar;

	private JTextArea textoDNI;
	private JTextArea textoCliente;
	private JTextField campoDNI;

	private JButton botonEliminar;
	private JButton botonCancelar;
	private Mediator mediator;

	public EliminarCliente(Mediator meditar) {
		super("PCComponentes Uchuva");
		this.mediator = meditar;
		mediator.asignarObserver(this);
		initComponents();
	}

	private void initComponents() {
		// inicializar objetos
		panel = new JPanel();
		panelMostrar = new JPanel();
		panelDatos = new JPanel();

		textoDNI = new JTextArea();
		campoDNI = new JTextField();
		textoCliente = new JTextArea();

		botonEliminar = new JButton();
		botonCancelar = new JButton();

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(1080, 720));
		this.getContentPane().setLayout(new BorderLayout());

		textoCliente.setEditable(false);
		textoCliente.setText("Baja Cliente");
		textoCliente.setBackground(Color.lightGray);
		textoCliente.setForeground(Color.white);
		textoCliente.setFocusable(false);
		textoCliente.setFont(new Font("Consolas", 2, 100));
		this.getContentPane().add(textoCliente, BorderLayout.NORTH);

		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 100, 10));
		panelMostrar.setLayout(new BorderLayout());
		panelDatos.setLayout(new GridLayout(1, 2, 0, 100));

		textoDNI.setEditable(false);
		textoDNI.setText("DNI");
		textoDNI.setForeground(Color.lightGray);
		textoDNI.setFocusable(false);
		textoDNI.setFont(new Font("Consolas", 4, 80));
		panelDatos.add(textoDNI);

		campoDNI.setFont(new Font("Consolas", 4, 80));
		panelDatos.add(campoDNI);

		botonEliminar.setText("Eliminar");
		botonEliminar.setFont(new Font("Consolas", 4, 80));
		botonEliminar.setForeground(Color.lightGray);
		botonEliminar.setContentAreaFilled(false);
		botonEliminar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				botonEliminarActionPerformed(evt);
			}
		});
		panel.add(botonEliminar);

		botonCancelar.setText("Cancelar");
		botonCancelar.setFont(new Font("Consolas", 2, 80));
		botonCancelar.setForeground(Color.red);
		botonCancelar.setContentAreaFilled(false);
		botonCancelar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				botonCancelarActionPerformed(evt);
			}
		});
		panel.add(botonCancelar);

		panelMostrar.add(panelDatos, BorderLayout.NORTH);
		this.getContentPane().add(panelMostrar, BorderLayout.CENTER);
		this.getContentPane().add(panel, BorderLayout.SOUTH);
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	private void botonEliminarActionPerformed(ActionEvent evt) {
		String[] opciones = { "Eliminar", "Desactivar" };
		String[] Datos = { campoDNI.getText() };
		int elecion = JOptionPane.showOptionDialog(null, "� Deseas borrarlo o desactivarlo ?", "Eliminar",
				JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
		if (elecion == 0) {
			mediator.baja("ControllerCliente", Datos);
		} else if (elecion == 1) {
			mediator.desactivar("ControllerCliente", Datos);
		}
	}

	private void botonCancelarActionPerformed(ActionEvent evt) {
		new PantallaPrincipalClientes(mediator);
		this.dispose();
	}

	@Override
	public void onCorrectMessage(String msg) {
		JOptionPane.showMessageDialog(null, "Se ha podido dar de baja de la base de datos ", "Exito",
				JOptionPane.INFORMATION_MESSAGE);
	}

	@Override
	public void onIncorrectMessage(String msg) {
		JOptionPane.showMessageDialog(null, "Error: " + msg, "ERROR AL CONECTAR", JOptionPane.ERROR_MESSAGE);
	}

	@Override
	public void onTableChange(Object[][] generarTabla, String[] generarTitulo) {
		// TODO Auto-generated method stub
		
	}

}
