package myhome.domain;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MemberDao implements Dao<MemberDto> {
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;

	private static MemberDao instance;

	public static MemberDao getInstance() {
		if (instance == null)
			instance = new MemberDao();
		return instance;
	}

	
	public MemberDto findByUsernameAndPassword(String username, String password) {
		String sql = "SELECT no, username, nickname, password, email, type, regdate"
				+ " FROM member"
				+ " WHERE username = ? AND password = ?";
		MemberDto dto = null;
		try {
			conn = getConnection();
			ps = conn.prepareStatement(sql); 
			ps.setString(1, username);
			ps.setString(2, password);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				dto = new MemberDto();
				dto.setNo(rs.getInt("no"));
				dto.setUsername(rs.getString("username"));
				dto.setNickname(rs.getString("nickname"));
				dto.setPassword(rs.getString("password"));
				dto.setEmail(rs.getString("email"));
				dto.setType(rs.getInt("type"));
				dto.setRegdate(rs.getString("regdate"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(conn, ps, rs);
		}

		return dto;
	}
	
	@Override
	public MemberDto select(int no) {
		String sql = "SELECT no, username, nickname, password, email, type, regdate"
				+ " FROM member"
				+ " WHERE no = ?";
		MemberDto dto = null;
		try {
			conn = getConnection();
			ps = conn.prepareStatement(sql); 
			ps.setInt(1, no);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				dto = new MemberDto();
				dto.setNo(rs.getInt("no"));
				dto.setUsername(rs.getString("username"));
				dto.setNickname(rs.getString("nickname"));
				dto.setPassword(rs.getString("password"));
				dto.setEmail(rs.getString("email"));
				dto.setType(rs.getInt("type"));
				dto.setRegdate(rs.getString("regdate"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(conn, ps, rs);
		}

		return dto;
	}

	@Override
	public List<MemberDto> selectAll() {
	
		String sql = "SELECT no, username, nickname, password, email, type, regdate"
				+ " FROM member";
		List<MemberDto> list = new ArrayList<>();
		try {
			conn = getConnection();
			ps = conn.prepareStatement(sql); 
			rs = ps.executeQuery();
			
			while(rs.next()) {
				MemberDto dto = new MemberDto();
				dto = new MemberDto();
				dto.setNo(rs.getInt("no"));
				dto.setUsername(rs.getString("username"));
				dto.setNickname(rs.getString("nickname"));
				dto.setPassword(rs.getString("password"));
				dto.setType(rs.getInt("type"));
				dto.setEmail(rs.getString("email"));
				dto.setRegdate(rs.getString("regdate"));
				list.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(conn, ps, rs);
		}
		return list;
	}

	@Override
	public boolean update(MemberDto dto) {
		String sql = "UPDATE member"
				+ " SET nickname = ?, password = ?, email = ?, type = ? "
				+ " WHERE no = ?";
		boolean result = false;
		try {
			conn = getConnection();
			ps = conn.prepareStatement(sql); 
			ps.setString(1, dto.getNickname());
			ps.setString(2, dto.getPassword());
			ps.setString(3, dto.getEmail());
			ps.setInt(4, dto.getType());
			ps.setInt(5, dto.getNo());
			result = ps.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(conn, ps, rs);
		}
		return result;
	}

	@Override
	public boolean insert(MemberDto t) {
		String sql = "INSERT INTO member(username, nickname, password, email, type) "
					+ " VALUES(?,?,?,?,?)";
		boolean result = false;
		try {
			conn = getConnection();
			ps = conn.prepareStatement(sql); 
			ps.setString(1, t.getUsername());
			ps.setString(2, t.getNickname());
			ps.setString(3, t.getPassword());
			ps.setString(4, t.getEmail());
			ps.setInt(5, t.getType());
			result = ps.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(conn, ps, rs);
		}
		return result;
	}

	@Override
	public boolean delete(int no) {
		String sql = "DELETE FROM member"
					+ " WHERE no = ?"; 
		boolean result = false;
		try {
			conn = getConnection();
			ps = conn.prepareStatement(sql); 
			ps.setInt(1, no);
			result = ps.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(conn, ps, rs);
		}
		return result;
	}
}