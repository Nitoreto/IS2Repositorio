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

		
		
		JPanel mainPanel = new BorderDecorator();
		this.setSize(1300, 900);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setContentPane(mainPanel);
		mainPanel.add(new buttonsPanelDecorator(), BorderLayout.CENTER);
	
		this.add(mainPanel);
		this.setVisible(true);
	}
	 public static void main(String[] args) {

			sucursalDecorator t1 = new sucursalDecorator();
			

		}
}
