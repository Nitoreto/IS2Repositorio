package GUISucursal;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import GUIPersonal.LoginEmpleado;

public class sucursalDecorator extends JFrame{
	
	
	
	public sucursalDecorator() {
		initGUI();
	}

	public void initGUI() {

		
		backGroundDecorator backGround = new backGroundDecorator();
		backGround.setLayout(new BorderLayout());
		BorderDecorator mainPanel = new BorderDecorator();
		this.setSize(800,600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		backGround.add(mainPanel, BorderLayout.CENTER);
		this.setContentPane(backGround);
		mainPanel.addCp(new ButtonU("boton1"));
		mainPanel.addCp(new ButtonU("boton2"));
		mainPanel.addCp(new ButtonU("boton3"));
		mainPanel.addTopLabel("Entidad sucursal");
		
		this.setVisible(true);
		
	}
	 public static void main(String[] args) {

			sucursalDecorator t1 = new sucursalDecorator();
			

		}
}
