package neander;
import java.awt.FlowLayout;
import javax.swing.*;

public class JanelaGrafica extends JFrame {
	private JLabel lbPc, lbRem, lbRdm, lbRi, lbAc;
	private JTextField tfPc, tfRem, tfRdm, tfRi, tfAc;

	public JanelaGrafica() {
		setLayout(new FlowLayout());
		setTitle("Simulador Neander");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		lbPc = new JLabel("PC:");
		tfPc = new JTextField(5);
		tfPc.setEditable(false);
		
		lbRem = new JLabel("REM:");
		tfRem = new JTextField(5);
		tfRem.setEditable(false);
		
		lbRdm = new JLabel("RDM:");
		tfRdm = new JTextField(5);
		tfRdm.setEditable(false);
		
		lbRi = new JLabel("RI:");
		tfRi = new JTextField(5);
		tfRi.setEditable(false);
		
		lbAc = new JLabel("AC:");
		tfAc = new JTextField(5);
		tfAc.setEditable(false);
		
		add(lbPc);
		add(tfPc);
		add(lbRem);
		add(tfRem);
		add(lbRdm);
		add(tfRdm);
		add(lbRi);
		add(tfRi);
		add(lbAc);
		add(tfAc);
                
		
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public void atualizaValores(String pc, String rem, String rdm, String ri, String ac) {
		tfPc.setText(pc);
		tfRem.setText(rem);
		tfRdm.setText(rdm);
		tfRi.setText(ri);
		tfAc.setText(ac);
	}
}
