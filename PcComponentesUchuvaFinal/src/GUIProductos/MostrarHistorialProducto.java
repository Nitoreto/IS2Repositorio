package GUIProductos;

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

import Model.ModeloTabla;
import Model.ModeloTablaEditable;
import Model.Observer;
import main.Mediator;

public class MostrarHistorialProducto extends JFrame implements Observer {
	private static final long serialVersionUID = 1L;

	private JPanel panel;

	private ModeloTabla model;
	private JTextArea textoMostrarHistorialProducto;

	private JTable tabla;

	private JButton botonCancelar;

	private Mediator mediator;

	public MostrarHistorialProducto(Mediator mediator) {
		super("PCComponentes Uchuva");
		this.mediator = mediator;
		mediator.asignarObserver(this);
		initComponents();
	}

	private void initComponents() {
		// inicializar objetos
		panel = new JPanel();

		textoMostrarHistorialProducto = new JTextArea();

		botonCancelar = new JButton();

		this.getContentPane().setLayout(new BorderLayout());

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(1920, 1080));

		textoMostrarHistorialProducto.setEditable(false);
		textoMostrarHistorialProducto.setText("Mostrar Historial Producto");
		textoMostrarHistorialProducto.setFocusable(false);
		textoMostrarHistorialProducto.setFont(new Font("Consolas", 4, 80));
		textoMostrarHistorialProducto.setBackground(Color.pink);
		textoMostrarHistorialProducto.setForeground(Color.white);
		this.getContentPane().add(textoMostrarHistorialProducto, BorderLayout.NORTH);

		mediator.listar("ControllerProducto");

		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 100, 100));

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

	private void botonCancelarActionPerformed(ActionEvent evt) {
		new PantallaPrincipalProducto(mediator);
		this.dispose();

	}

	@Override
	public void onCorrectMessage(String msg) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onIncorrectMessage(String msg) {
		// TODO Auto-generated method stub
		JOptionPane.showMessageDialog(null, "Error: " + msg, "ERROR AL CONECTAR", JOptionPane.ERROR_MESSAGE);

	}

	@Override
	public void onTableChange(Object[][] generarTabla, String[] generarTitulo) {
		// TODO Auto-generated method stub
		model = new ModeloTabla(generarTabla, generarTitulo);
		tabla = new JTable(model);
		tabla.setFont(new java.awt.Font("Consolas", 4, 40));
		tabla.setRowHeight(50);
		tabla.getTableHeader().setFont(new java.awt.Font("Consolas", 2, 50));
		JScrollPane paneScroll = new JScrollPane(tabla);
		this.getContentPane().add(paneScroll, BorderLayout.CENTER);

		this.validate();

	}

}