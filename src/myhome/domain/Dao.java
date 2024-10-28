package myhome.domain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface Dao<T extends Dto> {
	
	T select(int no);
	List<T> selectAll();
	boolean update(T t);
	boolean insert(T t);
	boolean delete(int no); 
	
	String DB_URL = "jdbc:mysql://127.0.0.1:3306/myhomedb?useSSL=false&allowPublicKeyRetrieval=true&useUnicode=true&characterEncoding=utf8";
	String DB_USER = "root";
	String DB_PASSWORD = "Kgh0103!"; 
	
	default Connection getConnection() throws SQLException {
		return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
		}
	
	default void close(Connection conn, PreparedStatement ps) {
		close(conn, ps, null);
	}
	default void close(Connection conn, PreparedStatement ps, ResultSet rs) {
		try {
			if(rs != null) rs.close();
			if(ps != null) ps.close();
			if(conn != null) conn.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	static void loadDriverClass() {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
}






