package GUISucursal;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Label;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class BorderDecorator extends JPanel{
	JPanel centerpanel;
	public BorderDecorator() {
		initGUI();
	}
	public void initGUI() {
		this.setLayout(new BorderLayout());
		this.setBackground(Color.LIGHT_GRAY);
		centerpanel = new JPanel();
		centerpanel.setLayout(new BoxLayout(centerpanel, BoxLayout.Y_AXIS));
		centerpanel.setOpaque(false);
		this.setOpaque(false);
		this.add(centerpanel, BorderLayout.CENTER);
	}
	public void addCp(Component c) {
		this.centerpanel.add(c);
	}
	public void addTopLabel(String s) {
		JLabel label = new JLabel(s);
		label.setBounds(130, 0,120, 30); // se coloca y da tamaño

		label.setHorizontalAlignment(JLabel.CENTER); // se centra en su rectángulo
		label.setOpaque(false);
		label.setForeground(Color.black);
		this.add(label, BorderLayout.PAGE_START);
	}
}
