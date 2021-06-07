package GUISucursal;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Label;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class backGroundDecorator extends JPanel{

	JPanel centerpanel;
	private Image imagen;
	public backGroundDecorator() {
		initGUI();
	}
	public void initGUI() {
		this.setSize(1300, 900);
		
		}
	@Override
	public void paint(Graphics g) {
		imagen = new ImageIcon(getClass().getResource("/imagenes/bienvenida.jpg")).getImage();
		g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
		setOpaque(false);
		super.paint(g);
	}
	

}
