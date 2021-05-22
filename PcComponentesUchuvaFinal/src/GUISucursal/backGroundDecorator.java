package GUISucursal;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import GUIPersonal.LoginEmpleado;

public class backGroundDecorator extends JFrame{
	
	JLabel img = new JLabel();
	
	public backGroundDecorator() {
		initGUI();
	}

	public void initGUI() {

		this.setSize(1000, 1000);
		
		JPanel mainPanel = new JPanel(new BorderLayout());
		this.setSize(300, 250);
		mainPanel.setBackground(Color.WHITE);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setContentPane(mainPanel);
		img.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/sucursal.jpg")));
		mainPanel.add(img, BorderLayout.CENTER);
		this.setVisible(true);
	}
	 public static void main(String[] args) {

			backGroundDecorator t1 = new backGroundDecorator();
			

		}
}
