package nivelesYMaterias.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import nivelesYMaterias.Conexion;
import nivelesYMaterias.model.Materia;
import nivelesYMaterias.model.Nivel;

public class ControladorMateria {

	private static Materia getEntidadFromResultSet(String sql) {
		Materia materia = null;
		try {
			Connection conn = Conexion.getConexion();
			Statement st = conn.createStatement();

			ResultSet rs = st.executeQuery(sql);

			if (rs != null && rs.next()) {
				materia = new Materia();
				materia.setId(rs.getInt("id"));
				materia.setNombre(rs.getString("nombre"));
				materia.setCodigo(rs.getString("codigo"));
				materia.setUrlClassroom(rs.getString("urlClassroom"));
				materia.setFechaInicio(rs.getString("fechaInicio"));
				materia.setAdmiteMatricula(rs.getBoolean("admiteMatricula"));
			}
			rs.close();
			st.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return materia;
	}

	public static int modificar(Materia m) {

		try {
			Connection conn = Conexion.getConexion();
			PreparedStatement ps = conn.prepareStatement(
					"update materia set nombre = ?, codigo = ?, urlClassroom = ?, fechaInicio = ?, admiteMatricula = ? where id = ?");

			ps.setString(1, m.getNombre());
			ps.setString(2, m.getCodigo());
			ps.setString(3, m.getUrlClassroom());
			ps.setString(4, m.getFechaInicio());
			ps.setInt(5, m.getId());
			int rows = ps.executeUpdate();
			ps.close();
			conn.close();
			return rows;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	/**
	 * 
	 * @param c
	 * @return
	 */
	public static int insertar(Materia m) {

		try {
			Connection conn = Conexion.getConexion();
			PreparedStatement ps = conn.prepareStatement(
					"insert into materia (id, nombre, codigo, urlClassrom, fechaInicio, admiteMatricula) "
							+ " values (?, ?, ?, ?, ?, ?)");

			int siguienteIdValido = getSiguientIdValido();
			ps.setInt(1, siguienteIdValido);
			ps.setString(2, m.getNombre());
			ps.setString(3, m.getCodigo());
			ps.setString(4, m.getUrlClassroom());
			ps.setString(5, m.getFechaInicio());
			ps.setBoolean(6, m.isAdmiteMatricula());
			ps.executeUpdate();
			ps.close();
			conn.close();
			return siguienteIdValido;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	private static int getSiguientIdValido() {
		try {
			Connection conn = Conexion.getConexion();
			PreparedStatement ps = conn.prepareStatement("select max(id) from materia");

			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				int maximoIdActual = rs.getInt(1);
				return maximoIdActual + 1;
			}

			ps.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public static Materia findAll() {
		return getEntidadFromResultSet("SELECT * FROM nivelesymaterias.materia order by id limit 1");

	}

}
