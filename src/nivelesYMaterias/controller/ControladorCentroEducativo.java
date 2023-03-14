package nivelesYMaterias.controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import nivelesYMaterias.Conexion;
import nivelesYMaterias.model.CentroEducativo;

public class ControladorCentroEducativo {

	private static CentroEducativo getEntidadFromResultSet(String sql) {
		CentroEducativo curso = null;
		try {
			Connection conn = Conexion.getConexion();
			Statement st = conn.createStatement();

			ResultSet rs = st.executeQuery(sql);

			if (rs != null && rs.next()) {
				curso = new CentroEducativo();
				curso.setId(rs.getInt("id"));
				curso.setDescripcion(rs.getString("descripcion"));
			}
			rs.close();
			st.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return curso;
	}

	public static List<CentroEducativo> findAll() {
		List<CentroEducativo> centroEducativo = new ArrayList<CentroEducativo>();

		try {
			Connection conn = Conexion.getConexion();
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("select * from centroeducativo");

			while (rs.next()) {
				CentroEducativo c = new CentroEducativo();
				c.setId(rs.getInt("id"));
				c.setDescripcion(rs.getString("descripcion"));
				centroEducativo.add(c);
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return centroEducativo;
	}

	public static CentroEducativo findFirst() {
		return getEntidadFromResultSet("SELECT * FROM centroeducativo order by id limit 1");
	}
}
