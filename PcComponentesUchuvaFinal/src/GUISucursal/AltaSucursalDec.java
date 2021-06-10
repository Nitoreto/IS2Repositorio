package GUISucursal;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class AltaSucursalDec extends JFrame{
	
	private JTextField textoSucursal;

	private JTextField textoCiudad;
	private JTextField textoId;
	public AltaSucursalDec() {
		initComponentes();
	}
	public void initComponentes() {
		textoSucursal= new JTextField();

		textoCiudad = new JTextField();
		textoId = new JTextField();
		backGroundDecorator backGround = new backGroundDecorator();
		backGround.setLayout(new BorderLayout());
		BorderDecorator mainPanel = new BorderDecorator();
		this.setSize(800,600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		backGround.add(mainPanel, BorderLayout.CENTER);
		this.setContentPane(backGround);
		mainPanel.addTopLabel("Alta de sucursal");
		mainPanel.addCp(new ButtonU("Dar De Alta"));
		textoSucursal.setEditable(true);
		textoSucursal.setText("Nombre");
		textoSucursal.setOpaque(false);
		textoSucursal.setFocusable(false);
		textoSucursal.setFont(new Font("Consolas", 2, 50));
		mainPanel.add(textoSucursal, BorderLayout.NORTH);
		textoCiudad.setEditable(true);
		textoCiudad.setText("Ciudad");
		textoCiudad.setOpaque(false);
		textoCiudad.setFocusable(false);
		textoCiudad.setFont(new Font("Consolas", 2, 50));
		mainPanel.add(textoCiudad, BorderLayout.NORTH);
		textoId.setEditable(true);
		textoId.setText("ID");
		textoId.setOpaque(false);
		textoId.setFocusable(false);
		textoId.setFont(new Font("Consolas", 2, 50));
		mainPanel.add(textoId, BorderLayout.NORTH);
		
		mainPanel.setAlignmentX(CENTER_ALIGNMENT);
		mainPanel.setAlignmentY(CENTER_ALIGNMENT);
		this.setVisible(true);
	}

	 public static void main(String[] args) {

			AltaSucursalDec t1 = new AltaSucursalDec();
			

		}
}
