package GUISucursal;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Label;
import java.awt.Rectangle;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class BorderDecorator extends JPanel{
	JPanel centerpanel;
	public BorderDecorator() {
		initGUI();
	}
	public void initGUI() {
		this.setBackground(Color.LIGHT_GRAY);
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		centerpanel = new JPanel();
		centerpanel.setLayout(new BoxLayout(centerpanel, BoxLayout.Y_AXIS));
		centerpanel.setOpaque(false);
		this.setOpaque(false);
		this.add(centerpanel);
		centerpanel.setAlignmentX(CENTER_ALIGNMENT);
		centerpanel.setAlignmentY(CENTER_ALIGNMENT);
	}
	public void addCp(Component c) {
		this.centerpanel.add(c);
		
		this.centerpanel.add(Box.createRigidArea(new Dimension(5, 5)));
	}
	public void addJtext(String s) {
		JTextField textoSucursal = new JTextField(s);
		textoSucursal.setOpaque(false);
		textoSucursal.setFont(new Font("Consolas", 2, 50));
		addCp(textoSucursal);
		
	}
	public void addTopLabel(String s) {
		JLabel label = new JLabel(s);
		label.setBounds(300, 0,120, 30); // se coloca y da tamaño

		label.setHorizontalAlignment(JLabel.CENTER); // se centra en su rectángulo
		label.setOpaque(false);
		label.setForeground(Color.black);
		centerpanel.add(label, 0);
	}
}
