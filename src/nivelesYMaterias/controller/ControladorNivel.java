package nivelesYMaterias.controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import nivelesYMaterias.Conexion;
import nivelesYMaterias.model.Nivel;

public class ControladorNivel {

	private static Nivel getEntidadFromResultSet(String sql) {
		Nivel nivel = null;
		try {
			Connection conn = Conexion.getConexion();
			Statement st = conn.createStatement();

			ResultSet rs = st.executeQuery(sql);

			if (rs != null && rs.next()) {
				nivel = new Nivel();
				nivel.setId(rs.getInt("id"));
				nivel.setDescripcion(rs.getString("descripcion"));
				nivel.setIdCentro(rs.getInt("idCentro"));
			}
			rs.close();
			st.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return nivel;
	}

	public static List<Nivel> findAll() {

		List<Nivel> nivel = new ArrayList<Nivel>();

		try {
			Connection conn = Conexion.getConexion();
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("select * from nivel");

			while (rs.next()) {
				Nivel c = new Nivel();
				c.setId(rs.getInt("id"));
				c.setDescripcion(rs.getString("descripcion"));
				c.setIdCentro(rs.getInt("idCentro"));

				nivel.add(c);
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return nivel;
	}

}
