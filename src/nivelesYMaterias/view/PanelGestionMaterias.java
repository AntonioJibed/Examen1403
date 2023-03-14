package nivelesYMaterias.view;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import javax.swing.JTextField;

import nivelesYMaterias.controller.ControladorMateria;
import nivelesYMaterias.controller.ControladorCentroEducativo;
import nivelesYMaterias.controller.ControladorNivel;
import nivelesYMaterias.model.CentroEducativo;
import nivelesYMaterias.model.Materia;
import nivelesYMaterias.model.Nivel;

public class PanelGestionMaterias extends JPanel {
	private JTextField jtfId;
	private JTextField jtfNombre;
	private JTextField jtfCodigo;
	private JTextField jtfUrl;
	private JTextField jtfFecha;
	private JButton btnGuardar, btnCargarNiveles, btnCargarMaterias, btnVerMateria;
	private JComboBox<CentroEducativo> jcbCentro;
	private JComboBox<Nivel> jcbNivel;
	private JComboBox<Materia> jcbMateria;
	private JCheckBox chkMatricula;

	/**
	 * Create the panel.
	 */
	public PanelGestionMaterias() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 1.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0,
				Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JLabel lblGestinDeMaterias = new JLabel("Gestión de Materias");
		lblGestinDeMaterias.setFont(new Font("Dialog", Font.BOLD, 15));
		GridBagConstraints gbc_lblGestinDeMaterias = new GridBagConstraints();
		gbc_lblGestinDeMaterias.insets = new Insets(0, 0, 5, 5);
		gbc_lblGestinDeMaterias.gridx = 1;
		gbc_lblGestinDeMaterias.gridy = 0;
		add(lblGestinDeMaterias, gbc_lblGestinDeMaterias);

		JLabel lblCentro = new JLabel("Centro:");
		GridBagConstraints gbc_lblCentro = new GridBagConstraints();
		gbc_lblCentro.anchor = GridBagConstraints.EAST;
		gbc_lblCentro.insets = new Insets(0, 0, 5, 5);
		gbc_lblCentro.gridx = 0;
		gbc_lblCentro.gridy = 1;
		add(lblCentro, gbc_lblCentro);

		jcbCentro = new JComboBox();
		GridBagConstraints gbc_jcbCentro = new GridBagConstraints();
		gbc_jcbCentro.insets = new Insets(0, 0, 5, 5);
		gbc_jcbCentro.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbCentro.gridx = 1;
		gbc_jcbCentro.gridy = 1;
		add(jcbCentro, gbc_jcbCentro);

		btnCargarNiveles = new JButton("Cargar niveles");
		btnCargarNiveles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarNivelEnJCombo();
			}
		});
		GridBagConstraints gbc_btnCargarNiveles = new GridBagConstraints();
		gbc_btnCargarNiveles.insets = new Insets(0, 0, 5, 0);
		gbc_btnCargarNiveles.gridx = 2;
		gbc_btnCargarNiveles.gridy = 1;
		add(btnCargarNiveles, gbc_btnCargarNiveles);

		JLabel lblNivel = new JLabel("Nivel:");
		GridBagConstraints gbc_lblNivel = new GridBagConstraints();
		gbc_lblNivel.anchor = GridBagConstraints.EAST;
		gbc_lblNivel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNivel.gridx = 0;
		gbc_lblNivel.gridy = 2;
		add(lblNivel, gbc_lblNivel);

		jcbNivel = new JComboBox();
		GridBagConstraints gbc_jcbNivel = new GridBagConstraints();
		gbc_jcbNivel.insets = new Insets(0, 0, 5, 5);
		gbc_jcbNivel.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbNivel.gridx = 1;
		gbc_jcbNivel.gridy = 2;
		add(jcbNivel, gbc_jcbNivel);

		btnCargarMaterias = new JButton("Cargar materias");
		btnCargarMaterias.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarMateriaEnJTextField(ControladorMateria.findAll());
			}
		});
		GridBagConstraints gbc_btnCargarMaterias = new GridBagConstraints();
		gbc_btnCargarMaterias.insets = new Insets(0, 0, 5, 0);
		gbc_btnCargarMaterias.gridx = 2;
		gbc_btnCargarMaterias.gridy = 2;
		add(btnCargarMaterias, gbc_btnCargarMaterias);

		JLabel lblMateria = new JLabel("Materia:");
		GridBagConstraints gbc_lblMateria = new GridBagConstraints();
		gbc_lblMateria.anchor = GridBagConstraints.EAST;
		gbc_lblMateria.insets = new Insets(0, 0, 5, 5);
		gbc_lblMateria.gridx = 0;
		gbc_lblMateria.gridy = 3;
		add(lblMateria, gbc_lblMateria);

		jcbMateria = new JComboBox();
		GridBagConstraints gbc_jcbMateria = new GridBagConstraints();
		gbc_jcbMateria.insets = new Insets(0, 0, 5, 5);
		gbc_jcbMateria.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbMateria.gridx = 1;
		gbc_jcbMateria.gridy = 3;
		add(jcbMateria, gbc_jcbMateria);

		btnVerMateria = new JButton("Ver Materia");
		btnVerMateria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		GridBagConstraints gbc_btnVerMateria = new GridBagConstraints();
		gbc_btnVerMateria.insets = new Insets(0, 0, 5, 0);
		gbc_btnVerMateria.gridx = 2;
		gbc_btnVerMateria.gridy = 3;
		add(btnVerMateria, gbc_btnVerMateria);

		JLabel lblDatosDeLa = new JLabel("Datos de la materia");
		GridBagConstraints gbc_lblDatosDeLa = new GridBagConstraints();
		gbc_lblDatosDeLa.insets = new Insets(0, 0, 5, 5);
		gbc_lblDatosDeLa.gridx = 1;
		gbc_lblDatosDeLa.gridy = 4;
		add(lblDatosDeLa, gbc_lblDatosDeLa);

		JLabel lblId = new JLabel("Id:");
		GridBagConstraints gbc_lblId = new GridBagConstraints();
		gbc_lblId.anchor = GridBagConstraints.EAST;
		gbc_lblId.insets = new Insets(0, 0, 5, 5);
		gbc_lblId.gridx = 0;
		gbc_lblId.gridy = 5;
		add(lblId, gbc_lblId);

		jtfId = new JTextField();
		jtfId.setEditable(false);
		GridBagConstraints gbc_jtfId = new GridBagConstraints();
		gbc_jtfId.gridwidth = 2;
		gbc_jtfId.insets = new Insets(0, 0, 5, 5);
		gbc_jtfId.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfId.gridx = 1;
		gbc_jtfId.gridy = 5;
		add(jtfId, gbc_jtfId);
		jtfId.setColumns(10);

		JLabel lblNombre = new JLabel("Nombre:");
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.anchor = GridBagConstraints.EAST;
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.gridx = 0;
		gbc_lblNombre.gridy = 6;
		add(lblNombre, gbc_lblNombre);

		jtfNombre = new JTextField();
		GridBagConstraints gbc_jtfNombre = new GridBagConstraints();
		gbc_jtfNombre.gridwidth = 2;
		gbc_jtfNombre.insets = new Insets(0, 0, 5, 5);
		gbc_jtfNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfNombre.gridx = 1;
		gbc_jtfNombre.gridy = 6;
		add(jtfNombre, gbc_jtfNombre);
		jtfNombre.setColumns(10);

		JLabel lblCdigo = new JLabel("Código:");
		GridBagConstraints gbc_lblCdigo = new GridBagConstraints();
		gbc_lblCdigo.anchor = GridBagConstraints.EAST;
		gbc_lblCdigo.insets = new Insets(0, 0, 5, 5);
		gbc_lblCdigo.gridx = 0;
		gbc_lblCdigo.gridy = 7;
		add(lblCdigo, gbc_lblCdigo);

		jtfCodigo = new JTextField();
		GridBagConstraints gbc_jtfCodigo = new GridBagConstraints();
		gbc_jtfCodigo.gridwidth = 2;
		gbc_jtfCodigo.insets = new Insets(0, 0, 5, 5);
		gbc_jtfCodigo.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfCodigo.gridx = 1;
		gbc_jtfCodigo.gridy = 7;
		add(jtfCodigo, gbc_jtfCodigo);
		jtfCodigo.setColumns(10);

		JLabel lblUrlClassroom = new JLabel("URL Classroom:");
		GridBagConstraints gbc_lblUrlClassroom = new GridBagConstraints();
		gbc_lblUrlClassroom.anchor = GridBagConstraints.EAST;
		gbc_lblUrlClassroom.insets = new Insets(0, 0, 5, 5);
		gbc_lblUrlClassroom.gridx = 0;
		gbc_lblUrlClassroom.gridy = 8;
		add(lblUrlClassroom, gbc_lblUrlClassroom);

		jtfUrl = new JTextField();
		GridBagConstraints gbc_jtfUrl = new GridBagConstraints();
		gbc_jtfUrl.gridwidth = 2;
		gbc_jtfUrl.insets = new Insets(0, 0, 5, 5);
		gbc_jtfUrl.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfUrl.gridx = 1;
		gbc_jtfUrl.gridy = 8;
		add(jtfUrl, gbc_jtfUrl);
		jtfUrl.setColumns(10);

		JLabel lblFechaInicio = new JLabel("Fecha inicio:");
		GridBagConstraints gbc_lblFechaInicio = new GridBagConstraints();
		gbc_lblFechaInicio.anchor = GridBagConstraints.EAST;
		gbc_lblFechaInicio.insets = new Insets(0, 0, 5, 5);
		gbc_lblFechaInicio.gridx = 0;
		gbc_lblFechaInicio.gridy = 9;
		add(lblFechaInicio, gbc_lblFechaInicio);

		jtfFecha = new JTextField();
		GridBagConstraints gbc_jtfFecha = new GridBagConstraints();
		gbc_jtfFecha.gridwidth = 2;
		gbc_jtfFecha.insets = new Insets(0, 0, 5, 5);
		gbc_jtfFecha.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfFecha.gridx = 1;
		gbc_jtfFecha.gridy = 9;
		add(jtfFecha, gbc_jtfFecha);
		jtfFecha.setColumns(10);

		chkMatricula = new JCheckBox("Admite matrícula");
		GridBagConstraints gbc_chkMatricula = new GridBagConstraints();
		gbc_chkMatricula.gridwidth = 2;
		gbc_chkMatricula.insets = new Insets(0, 0, 5, 5);
		gbc_chkMatricula.gridx = 0;
		gbc_chkMatricula.gridy = 10;
		add(chkMatricula, gbc_chkMatricula);

		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 3;
		gbc_panel.insets = new Insets(0, 0, 0, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 11;
		add(panel, gbc_panel);

		btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardar();
			}
		});
		panel.add(btnGuardar);

		cargarCentroEnJCombo();
		cargarPrimero();

	}

	private void cargarCentroEnJCombo() {
		List<CentroEducativo> centroEducativos = ControladorCentroEducativo.findAll();
		for (CentroEducativo centroEducativo : centroEducativos) {
			this.jcbCentro.addItem(centroEducativo);
		}
	}

	private void cargarNivelEnJCombo() {
		limpiarDatos();
		List<Nivel> nivel = ControladorNivel.findAll();
		for (Nivel nivels : nivel) {
			this.jcbNivel.addItem(nivels);
		}

	}

	private void cargarMateriaEnJTextField(Materia m) {
		this.jtfId.setText("" + m.getId());
		this.jtfNombre.setText(m.getNombre());
		this.jtfCodigo.setText(m.getCodigo());
		this.jtfUrl.setText(m.getUrlClassroom());
		this.jtfFecha.setText(m.getFechaInicio());
//			this.chkMatricula.action(null, m.isAdmiteMatricula());
	}

	private void cargarPrimero() {
		cargarEnPantalla(ControladorCentroEducativo.findFirst());
	}

	private void guardar() {
		Materia m = new Materia();
		m.setId(Integer.parseInt(this.jtfId.getText()));
		m.setNombre(this.jtfNombre.getText());
		m.setCodigo(this.jtfCodigo.getText());
		m.setUrlClassroom(this.jtfUrl.getText());
		m.setFechaInicio(this.jtfFecha.getText());
//		m.setAdmiteMatricula(this.chkMatricula.getText());

		String strError = "No se ha podido guardar";
		if (m.getId() == 0) {
			int nuevoIdInsertado = ControladorMateria.insertar(m);
			if (nuevoIdInsertado < 1) {
				JOptionPane.showMessageDialog(null, strError);
			} else {
				this.jtfId.setText("" + nuevoIdInsertado);
			}
		} else {
			if (ControladorMateria.modificar(m) != 1) {
				JOptionPane.showMessageDialog(null, strError);
			}
		}

	}

	private void limpiarDatos() {
		if (this.jcbNivel.getItemCount() > 0) {
			this.jcbNivel.setSelectedIndex(0);
		}
	}

	private void cargarEnPantalla(CentroEducativo m) {
		if (m != null) {
			for (int i = 0; i < this.jcbCentro.getItemCount(); i++) {
				CentroEducativo c = this.jcbCentro.getItemAt(i);
				if (m.getId() == c.getId()) {
					this.jcbCentro.setSelectedIndex(i);
				}
			}
		}

	}
}
