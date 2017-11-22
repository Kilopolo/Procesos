/**
 * 
 */
package com.gmail.pablo23dr.Ej01;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author Pablo
 *
 */
public class Crono extends JFrame implements ActionListener{

	private JButton b1, b2;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Crono crono = new Crono();
		crono.setVisible(true);
		
	}
	
	public Crono() {
		super("Cronometro");
//		setTitle("Cronometro");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
//		setSize(400,400);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		
		JPanel ps= new JPanel();
		add(ps, BorderLayout.NORTH);
		
		b1 = new JButton("Iniciar");
		b1.setActionCommand("B1");
		b1.addActionListener(this);
		ps.add(b1);
		
		b2 = new JButton("Detener");
		b2.setActionCommand("B2");
		b2.addActionListener(this);
		ps.add(b2);
		
		PanelCrono pi = new PanelCrono();
		pi.setPreferredSize(new Dimension(200, 200));
		add(pi, BorderLayout.SOUTH);
		pack();
		
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("B1")) {
			
		} else if(e.getActionCommand().equals("B2")) {
			
		}
		
		
	}

}
