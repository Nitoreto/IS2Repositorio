package GUIMarca;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;

import Model.Observer;
import main.PantallaPrincipalPccomponentes;
import main.Mediator;

public class PantallaPrincipalMarca extends JFrame implements Observer{
	private static final long serialVersionUID = 1L;
	private JTextArea textoMarca;
	private JButton botonListar;
	private JButton botonAlta;
	private JButton botonBaja;
	private JPanel panel;
	private JButton botonVolver;
	private Mediator mediator;

	public PantallaPrincipalMarca(Mediator mediator) {
		super("PCComponentes Uchuva");
		this.mediator = mediator;
		mediator.asignarObserver(this);
		initComponents();
	}

	private void initComponents() {
		panel = new JPanel();
		textoMarca = new JTextArea();
		botonListar = new JButton();
		botonAlta = new JButton();
		botonBaja = new JButton();
		botonVolver = new JButton();

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(900, 720));
		panel.setLayout(new GridLayout(5, 1));

		textoMarca.setEditable(false);
		textoMarca.setText("Marcas");
		textoMarca.setBackground(Color.orange);
		textoMarca.setForeground(Color.WHITE);
		textoMarca.setFocusable(false);
		textoMarca.setFont(new Font("Consolas", 2, 100));
		textoMarca.setBounds(400, 200, 200, 400);
		panel.add(textoMarca);

		botonAlta.setText("Alta");
		botonAlta.setFont(new Font("Consolas", 4, 80));
		botonAlta.setBackground(Color.white);
		botonAlta.setForeground(Color.orange);
		botonAlta.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				botonAltaActionPerformed(evt);
			}
		});
		panel.add(botonAlta);

		botonBaja.setText("Buscar");
		botonBaja.setFont(new Font("Consolas", 4, 80));
		botonBaja.setBackground(Color.white);
		botonBaja.setForeground(Color.orange);
		botonBaja.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				botonBuscarActionPerformed(evt);
			}
		});
		panel.add(botonBaja);
		
		botonListar.setText("Listar");
		botonListar.setFont(new Font("Consolas", 4, 80));
		botonListar.setBackground(Color.white);
		botonListar.setForeground(Color.orange);
		botonListar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				botonListarActionPerformed(evt);
			}
		});
		panel.add(botonListar);


		botonVolver.setText("Volver");
		botonVolver.setFont(new Font("Consolas", 4, 80));
		botonVolver.setBackground(Color.white);
		botonVolver.setForeground(Color.red);
		botonVolver.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				botonVolverActionPerformed(evt);
			}
		});
		panel.add(botonVolver);

		this.getContentPane().add(panel);
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	protected void botonVolverActionPerformed(ActionEvent evt) {
		new PantallaPrincipalPccomponentes(mediator);
		this.dispose();

	}

	private void botonListarActionPerformed(ActionEvent evt) {
		new ListarMarcas(mediator);
		this.dispose();
	}

	private void botonAltaActionPerformed(ActionEvent evt) {
		new AltaMarca(mediator);
		this.dispose();
	}

	private void botonBuscarActionPerformed(ActionEvent evt) {
		new BuscarMarca(mediator);
		this.dispose();
	}

	@Override
	public void onCorrectMessage(String msg) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onIncorrectMessage(String msg) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTableChange(Object[][] generarTabla, String[] generarTitulo) {
		// TODO Auto-generated method stub
		
	}

}