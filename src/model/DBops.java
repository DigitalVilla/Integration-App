/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

/**
 *
 * @author john
 */
public class DBops {

	private Connection conn = null;

	public Connection getConnection(String username, String password) throws SQLException {

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:sait", username, password);

		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		}

		return conn;

	}
	public void closeConn() {
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public boolean checkPriviledges() {

		boolean result = false;

		try {
			CallableStatement st = conn.prepareCall("{? = call func_verify_privs()}");
			st.registerOutParameter(1, Types.CHAR);
			st.execute();
			result = st.getString(1).equals("Y");
			st.close();
		} catch (SQLException e) {
			for (Throwable t : e) {
				e.printStackTrace();
			}
		}
		return result;

	}

	public void zeroOut() {
		try {
			CallableStatement st = conn.prepareCall("{call proc_month_end()}");
			st.execute();
			st.close();
		} catch (SQLException e) {
			for (Throwable t : e) {
				e.printStackTrace();
			}
		}
	}

	public void createDIr(String alias, String directory) {
		String createDir = "CREATE OR REPLACE DIRECTORY " + alias.toUpperCase() + " AS '" + directory + "'";
		try {
			PreparedStatement st = conn.prepareStatement(createDir);
			st.executeUpdate();
			st.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public void exportTrans(String alias, String filename) {
		try {
			CallableStatement cs = conn.prepareCall("{call export_new_transactions(?,?)}");
			cs.setString(1, alias.toUpperCase());
			cs.setString(2, filename);
			cs.execute();
			cs.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	


}
