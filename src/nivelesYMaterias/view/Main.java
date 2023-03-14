package nivelesYMaterias.view;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

public class Main extends JFrame {

	public Main() {
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);

		JTabbedPane tabedPane = new JTabbedPane();

		tabedPane.add("Niveles y Materia", new PanelGestionMaterias());

		this.setMinimumSize(new Dimension(800, 600));

		this.setContentPane(tabedPane);
	}

	public static void main(String args[]) {
		Main v = new Main();
		v.setVisible(true);

	}

}
