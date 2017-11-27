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
public class UI extends JFrame implements ActionListener{

	private JButton b1, b2;
	private PanelCrono pi ;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UI crono = new UI();
		crono.setVisible(true);
		
	}
	
	public UI() {
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
		
		pi = new PanelCrono();
		pi.setPreferredSize(new Dimension(300, 200));
		add(pi, BorderLayout.SOUTH);
		pack();
		
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {

		if(e.getActionCommand().equals("B1")) {
			
			JButton b = (JButton) e.getSource();
			if(b.getText().equals("Iniciar")) {
				b.setText("Pausa");
				pi.iniciarCrono();
			} else if (b.getText().equals("Pausa")) {
				b.setText("Reanudar");
				pi.pausarCrono();
			} else if (b.getText().equals("Reanudar")) {
				b.setText("Pausa");
				pi.reanudarCrono();
			}
			
		} else if(e.getActionCommand().equals("B2")) {
			JButton b = (JButton) e.getSource();
			if(b.getText().equals("Detener")) {
				b.setText("Reiniciar");
				b1.setText("Reanudar");
				pi.detenerCrono();
			} else if (b.getText().equals("Reiniciar")) {
				b.setText("Detener");
				pi.resetearCrono();
			}
		}
		
		
	}

}
