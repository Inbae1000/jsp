package com.beans;

import com.beans.MemberDTO;
import member.db.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class MemberDAO {
	
	private static MemberDAO mDao = new MemberDAO();
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private int result = 0;
	
	private MemberDAO() {
		super();
	}
	
	public static MemberDAO getInstance() {
		return mDao;
	}
	

	
	public void close(Connection conn, PreparedStatement pstmt, ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	// id 값 자동 추출 및 입력
	public int nextval() {
		conn = ConnectionDB.getConnection();
		StringBuffer query = new StringBuffer();
		query.append("SELECT MAX(id) ").append("FROM member");
		
		try {
			pstmt = conn.prepareStatement(query.toString());
			rs = pstmt.executeQuery();
			while (rs.next()) {
				result = rs.getInt("MAX(id)");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(conn, pstmt, rs);
		}
		return result;
	}
	
	
	
	// 정보 저장
	 public int insert(MemberDTO dto) {
	 
	 conn = ConnectionDB.getConnection();
	 StringBuffer query = new StringBuffer();
	 query.append("insert into Member ");
	 query.append("(id, name, birth, number, country, sex, age, type1, type2, company, coAddress, coDate1, coDate2, coResignation, coNumber, notice) ");
	 query.append("values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
	 
	 try {
		 pstmt = conn.prepareStatement(query.toString());
		 pstmt.setInt(1, dto.getId());
		 pstmt.setString(2, dto.getName());
		 pstmt.setString(3, dto.getBirth());
		 pstmt.setString(4, dto.getNumber());
		 pstmt.setString(5, dto.getCountry());
		 pstmt.setString(6, dto.getSex());
		 pstmt.setInt(7, dto.getAge());
		 pstmt.setString(8, dto.getType1());
		 pstmt.setString(9, dto.getType2());
		 pstmt.setString(10, dto.getCompany());
		 pstmt.setString(11, dto.getCoAddress());
		 pstmt.setString(12, dto.getCoDate1());
		 pstmt.setString(13, dto.getCoDate2());
		 pstmt.setString(14, dto.getCoResignation());
		 pstmt.setString(15, dto.getCoNumber());
		 pstmt.setString(16, dto.getNotice());
		 
		 return pstmt.executeUpdate();
		 
	 } catch(SQLException e) {
		 e.printStackTrace();
	 } finally {
		 close(conn, pstmt, null);
	 }
	 return -1;
}
	 
	// 전체 리스트 불러오기
	public List<MemberDTO> selectList(){

		List<MemberDTO> list = new ArrayList<>();
		
		try {
			conn = ConnectionDB.getConnection();
			String sql = "Select * from member";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			
			while (rs.next()) {
				MemberDTO tmp = new MemberDTO();
				tmp.setId(rs.getInt(1));
				tmp.setName(rs.getString(2));
				tmp.setBirth(rs.getString(3));
				tmp.setNumber(rs.getString(4));
				tmp.setCountry(rs.getString(5));
				tmp.setSex(rs.getString(6));
				tmp.setAge(rs.getInt(7));
				tmp.setType1(rs.getString(8));
				tmp.setType2(rs.getString(9));
				tmp.setCompany(rs.getString(10));
				tmp.setCoAddress(rs.getString(11));
				tmp.setCoDate1(rs.getString(12));
				tmp.setCoDate2(rs.getString(13));
				tmp.setCoResignation(rs.getString(14));
				tmp.setCoNumber(rs.getString(15));
				tmp.setNotice(rs.getString(16));
				
				list.add(tmp);
				
			}

		} catch(SQLException e){
			e.printStackTrace();
		} finally {
			close(conn, pstmt, rs);
		}
		return list;
	}
	
	public MemberDTO selectOne(int id) {
		String sql = "Select * from member where id = ?";
		
		try {
			conn = ConnectionDB.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			
			
			
			while (rs.next()) {
				MemberDTO tmp = new MemberDTO();
				tmp.setId(rs.getInt(1));
				tmp.setName(rs.getString(2));
				tmp.setBirth(rs.getString(3));
				tmp.setNumber(rs.getString(4));
				tmp.setCountry(rs.getString(5));
				tmp.setSex(rs.getString(6));
				tmp.setAge(rs.getInt(7));
				tmp.setType1(rs.getString(8));
				tmp.setType2(rs.getString(9));
				tmp.setCompany(rs.getString(10));
				tmp.setCoAddress(rs.getString(11));
				tmp.setCoDate1(rs.getString(12));
				tmp.setCoDate2(rs.getString(13));
				tmp.setCoResignation(rs.getString(14));
				tmp.setCoNumber(rs.getString(15));
				tmp.setNotice(rs.getString(16));
				
				return tmp;
			
			
		} 
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(conn, pstmt, rs);
		}
		return null;
		
}
	
	// 정보 수정
	public int update(MemberDTO dto) {
		
		String name = selectOne(dto.getId()).getName();
		String birth = selectOne(dto.getId()).getBirth();
		String number = selectOne(dto.getId()).getNumber();
		String country = selectOne(dto.getId()).getCountry();
		String sex = selectOne(dto.getId()).getSex();
		int age = selectOne(dto.getId()).getAge();
		String type1 = selectOne(dto.getId()).getType1();
		String type2 = selectOne(dto.getId()).getType2();
		String company = selectOne(dto.getId()).getCompany();
		String coAddress = selectOne(dto.getId()).getCoAddress();
		String coDate1 = selectOne(dto.getId()).getCoDate1();
		String coDate2 = selectOne(dto.getId()).getCoDate2();
		String coRe = selectOne(dto.getId()).getCoResignation();
		String coNumber = selectOne(dto.getId()).getCoNumber();
		String notice = selectOne(dto.getId()).getNotice();

		
		conn = ConnectionDB.getConnection();
		StringBuffer query = new StringBuffer();
		query.append("update member set ");
		query.append("name = ?, birth = ?, number = ?, country = ?, sex = ?, age = ?, type1 = ?, type2 = ?, ");
		query.append("company = ?, coAddress = ?, coDate1 = ?, coDate2 = ?, coResignation = ?, coNumber = ?, notice = ? ");
		query.append("where id = ?");
		
		
		try {
			 pstmt = conn.prepareStatement(query.toString());
			 
			 if(dto.getName() == "" || dto.getName() == null) {
				 pstmt.setString(1, name);
			 }else pstmt.setString(1, dto.getName());
			 
			 if(dto.getBirth() == "" || dto.getBirth() == null) {
				 pstmt.setString(2, birth);
			 } else pstmt.setString(2, dto.getBirth());
			 
			 if(dto.getNumber() == "" || dto.getNumber() == null) {
				pstmt.setString(3, number); 
			 } else pstmt.setString(3, dto.getNumber());
			 
			 if(dto.getCountry() == "" || dto.getCountry() == null) {
				 pstmt.setString(4, country);
			 } else pstmt.setString(4, dto.getCountry());
			 
			 if(dto.getSex() == "" || dto.getSex() == null) {
				 pstmt.setString(5, sex);
			 } else pstmt.setString(5, dto.getSex());
			 
				 pstmt.setInt(6, dto.getAge());
			 
			 if(dto.getType1() == "" || dto.getType1() == null) {
				 pstmt.setString(7, type1);
			 } else pstmt.setString(7, dto.getType1());
			 
			 if(dto.getType2() == "" || dto.getType2() == null) {
				 pstmt.setString(8, type2);
			 } else pstmt.setString(8, dto.getType2());
			 
			 if(dto.getCompany() == "" || dto.getCompany() == null) {
				 pstmt.setString(9, company);
			 } else pstmt.setString(9, dto.getCompany());
			 
			 if(dto.getCoAddress() == "" || dto.getCoAddress() == null) {
				pstmt.setString(10, coAddress); 
			 } else pstmt.setString(10, dto.getCoAddress());
			 
			 if(dto.getCoDate1() == "" || dto.getCoDate1() == null) {
				 pstmt.setString(11, coDate1);
			 } else pstmt.setString(11, dto.getCoDate1());
			 
			 if(dto.getCoDate2() == "" || dto.getCoDate2() == null) {
				 pstmt.setString(12, coDate2);
			 } else pstmt.setString(12, dto.getCoDate2());
			 
			 if(dto.getCoResignation() == "" || dto.getCoResignation() == null) {
				 pstmt.setString(13, coRe);
			 } else pstmt.setString(13, dto.getCoResignation());
			 
			 if(dto.getCoNumber() == "" || dto.getCoNumber() == null) {
				 pstmt.setString(14, coNumber);
			 } else pstmt.setString(14, dto.getCoNumber());
			 
			 if(dto.getNotice() == "" || dto.getNotice() == null) {
				 pstmt.setString(15, notice);
			 } else pstmt.setString(15, dto.getNotice());
			 
			 pstmt.setInt(16, dto.getId());
			 
			 return pstmt.executeUpdate();
			 
		 } catch(SQLException e) {
			 e.printStackTrace();
		 } finally {
			 close(conn, pstmt, null);
		 }
		 return -1;
		
	
	}
	
	public int delete(int id) {
		String sql = "delete from member where id = ?";
		
		try {
			conn = ConnectionDB.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			result = pstmt.executeUpdate();

		} catch(Exception e){
			e.printStackTrace();
		} finally {
			close(conn, pstmt, null);
		}
		return result;
	}


}

