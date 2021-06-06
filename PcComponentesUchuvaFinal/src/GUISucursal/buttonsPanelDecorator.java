package GUISucursal;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class buttonsPanelDecorator extends JPanel{
	
	
	public buttonsPanelDecorator() {
		initGUI();
	}
	public void initGUI() {
		this.setLayout(new FlowLayout());
		this.setSize(500, 500);
		this.setBackground(Color.cyan);
		JButton boton1 = new JButton("boton 1");
		boton1.setMinimumSize(new Dimension(20,20));
		boton1.setMaximumSize(new Dimension(150,60));
		boton1.setPreferredSize(new Dimension(120,30));
		this.add(boton1);
		JButton boton2 = new JButton("boton 2");
		boton2.setMinimumSize(new Dimension(20,20));
		boton2.setMaximumSize(new Dimension(150,60));
		boton2.setPreferredSize(new Dimension(120,30));
		this.add(boton2);
		JButton boton3 = new JButton("boton 3");
		boton3.setMinimumSize(new Dimension(20,20));
		boton3.setMaximumSize(new Dimension(150,60));
		boton3.setPreferredSize(new Dimension(120,30));
		this.add(boton3);
		JButton boton4 = new JButton("boton 4");
		boton4.setMinimumSize(new Dimension(20,20));
		boton4.setMaximumSize(new Dimension(150,60));
		boton4.setPreferredSize(new Dimension(120,30));
		this.add(boton4);
		
	}
	

}
