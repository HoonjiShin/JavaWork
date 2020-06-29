package com.lec.sts13_jdbc.board.beans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;

import com.lec.sts13_jdbc.board.C;

public class BWriteDAO {
	JdbcTemplate template; //jsp에서 db연결하는 부분 대신

	public BWriteDAO() {
		this.template = 
				C.template; //<---- 애는 언제 생성되는거임? BoardController에 있음
	}
	
	//전체 select
	public List<BWriteDTO> select(){
		return template.query(C.SQL_WRITE_SELECT, 
				new BeanPropertyRowMapper<BWriteDTO>(BWriteDTO.class));
	}
	
public int insert(final BWriteDTO dto) {
		
		/* 2. update() + PreparedStatementSetter() 방식
		 * return template.update(C.SQL_WRITE_INSERT, new PreparedStatementSetter() {
		 * 
		 * @Override public void setValues(PreparedStatement ps) throws SQLException {
		 * ps.setString(1, dto.getSubject()); ps.setString(2, dto.getContent());
		 * ps.setString(3, dto.getName()); } } );
		 */
	
	// 2. update() + PreparedStatementCreator()방식
	return template.update(new PreparedStatementCreator() {
		
		@Override
		public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
			
			PreparedStatement ps = con.prepareStatement(C.SQL_WRITE_INSERT);
			ps.setString(1, dto.getSubject());
			ps.setString(2, dto.getContent());
			ps.setString(3, dto.getName());

			return ps;
		}
	});
		
	}

public List<BWriteDTO> readByUid(int uid) {
	
	return template.query(C.SQL_WRITE_SELECT_BY_ID,new BeanPropertyRowMapper<BWriteDTO>(BWriteDTO.class));
}



public int update(final BWriteDTO dto) {
return template.update(new PreparedStatementCreator() {
		
		@Override
		public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
			
			PreparedStatement ps = con.prepareStatement(C.SQL_WRITE_UPDATE);
			ps.setInt(1, dto.getUid());
			return ps;
		}
	});
}
	
	
	
}
