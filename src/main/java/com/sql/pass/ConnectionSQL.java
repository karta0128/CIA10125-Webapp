package com.sql.pass;

import static com.sql.pass.PassworldSQL.PASSWORD;
import static com.sql.pass.PassworldSQL.URL;
import static com.sql.pass.PassworldSQL.USER;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class ConnectionSQL {
	String mothodSQL;
	public static Connection con;
	public static PreparedStatement ps;
	int count = 0;
	static final String driver = "com.mysql.cj.jdbc.Driver";
	public ConnectionSQL(String mothodSQL) throws SQLException, ClassNotFoundException {
		Class.forName(driver);
		this.con = DriverManager.getConnection(URL, USER, PASSWORD);
		this.mothodSQL = mothodSQL;
	}

	public void PrepatedStatementSQL(String... mods) throws SQLException {
		this.ps = con.prepareStatement(mothodSQL);
		for (String mod : mods) {
			ps.executeUpdate(mod);
		}
	}

	public void setPS(String name) throws SQLException {
		this.count++;
		this.ps.setString(this.count, name);
	}

	public void setPS(int name) throws SQLException {
		this.count++;
		this.ps.setInt(this.count, name);
	}

	public void updata() throws SQLException {
		this.ps.executeUpdate();
	}
	public void off() throws SQLException {
		this.con.close();
	}
	public void setAutoCommit(boolean ch) throws SQLException {
		this.con.setAutoCommit(ch);
	}
	public void commit() throws SQLException {
		this.con.commit();
	}
	public ResultSet query() throws SQLException {
		return this.ps.executeQuery();
	}
//	public void getAllData(String name) {
//		if (name.equals("DeptVO")) {
//			List<DeptVO> list = new ArrayList<DeptVO>();
//		} else if(name.equals("EmpVO")) {
//			List<empVO> list = new ArrayList<empVO>();
//		}else {
//			System.out.println("getAllData 設定錯誤");
//		}
//	}
	
//	public void connectionSQL(String methodSQL, String Order ) throws SQLException {
//		Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
//		PreparedStatement ps = con.prepareStatement(methodSQL);
//	}
}
