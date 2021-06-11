package GUIClientes;

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

public class ListarClientes extends JFrame implements Observer {
	private static final long serialVersionUID = 1L;

	private JPanel panel;
	private JTextArea textoListarClientes;
	private JTable tabla;
	private JButton botonVolver;
	private Mediator mediator;

	public ListarClientes(Mediator mediator) {
		super("PCComponentes Uchuva");
		this.mediator = mediator;
		mediator.asignarObserver(this);
		initComponents();
	}

	private void initComponents() {
		// inicalizar objetos
		panel = new JPanel();

		textoListarClientes = new JTextArea();

		botonVolver = new JButton();

		this.getContentPane().setLayout(new BorderLayout());

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(1920, 1080));

		textoListarClientes.setEditable(false);
		textoListarClientes.setText("Listar Cliente");
		textoListarClientes.setFocusable(false);
		textoListarClientes.setBackground(Color.lightGray);
		textoListarClientes.setForeground(Color.white);
		textoListarClientes.setFont(new Font("Consolas", 1, 100));
		this.getContentPane().add(textoListarClientes, BorderLayout.NORTH);

		mediator.listar("ControllerCliente");

		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 100, 0));

		botonVolver.setText("Cancelar");
		botonVolver.setFont(new Font("Consolas", 1, 80));
		botonVolver.setForeground(Color.lightGray);
		botonVolver.setContentAreaFilled(false);
		botonVolver.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				botonVolverActionPerformed(evt);
			}
		});
		panel.add(botonVolver);

		this.getContentPane().add(panel, BorderLayout.SOUTH);
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	private void botonVolverActionPerformed(ActionEvent evt) {
		new PantallaPrincipalClientes(mediator);
		this.dispose();
	}

	@Override
	public void onCorrectMessage(String msg) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onIncorrectMessage(String msg) {
		JOptionPane.showMessageDialog(null, "Error: " + msg, "ERROR AL CONECTAR", JOptionPane.ERROR_MESSAGE);

	}

	@Override
	public void onTableChange(Object[][] generarTabla, String[] generarTitulo) {
		tabla = new JTable(new ModeloTablaEditable(generarTabla, generarTitulo));
		tabla.setFont(new java.awt.Font("Consolas", 4, 40));
		tabla.setRowHeight(50);
		tabla.getTableHeader().setFont(new java.awt.Font("Consolas", 2, 50));
		JScrollPane paneScroll = new JScrollPane(tabla);
		this.getContentPane().add(paneScroll, BorderLayout.CENTER);
		this.validate();
	}
}