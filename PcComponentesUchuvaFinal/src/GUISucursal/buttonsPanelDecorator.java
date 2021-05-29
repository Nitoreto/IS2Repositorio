package GUISucursal;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class buttonsPanelDecorator extends JPanel{
	
	
	public buttonsPanelDecorator() {
		initGUI();
	}
	public void initGUI() {
		this.setLayout(new FlowLayout(FlowLayout.CENTER));
		this.setBackground(Color.cyan);
		JButton boton1 = new JButton("boton 1");
		this.add(boton1);
		JButton boton2 = new JButton("boton 2");
		this.add(boton2);
		JButton boton3 = new JButton("boton 3");
		this.add(boton3);
		JButton boton4 = new JButton("boton 4");
		this.add(boton4);
		
	}

}
