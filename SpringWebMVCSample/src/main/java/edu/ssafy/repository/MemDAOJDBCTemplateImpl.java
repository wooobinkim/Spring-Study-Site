package edu.ssafy.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import edu.ssafy.dto.MemDTO;

@Repository("MemDAOJDBCTemplateImpl")
public class MemDAOJDBCTemplateImpl implements MemDAO {

//	@Autowired
//	private DataSource source;
	@Autowired
	private JdbcTemplate jt;

	@Override
	public boolean idCheck(String id) throws SQLException {
		try {
			MemDTO m = jt.queryForObject("select id, pw, name, addr, age from members_2 where id = ?",
					new Object[] { id }, new MemberMapper());
			return false;
		} catch (EmptyResultDataAccessException e) {
			return true;
		}
	}

	@Override
	public boolean login(String id, String pw) throws SQLException {
		MemDTO m = jt.queryForObject("select id, pw, name, addr, age from members_2 where id=? and pw=?",
				new Object[] { id, pw }, new MemberMapper());
		if (m == null) {
			return false;
		} else {
			return true;
		}
	}

	class MemberMapper implements RowMapper<MemDTO> {

		@Override
		public MemDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
			MemDTO m = new MemDTO();
			m.setId(rs.getString("id"));
			m.setPw(rs.getString("pw"));
			m.setName(rs.getString("name"));
			m.setAddr(rs.getString("addr"));
			m.setAge(rs.getString("age"));
			return m;
		}
	}

	@Override
	public void regMember(MemDTO m) throws SQLException {
		jt.update("insert into members_2 (id, pw, name, addr, age) values(?, ?, ?, ?, ?)",
				new Object[] { m.getId(), m.getPw(), m.getName(), m.getAddr(), m.getAge() });
	}

	@Override
	public List<MemDTO> listMember() throws SQLException {
		List<MemDTO> list = jt.query("select id, pw, name, addr, age from members_2", new MemberMapper());
		return list;
	}

	@Override
	public void deleteMember(MemDTO m) throws SQLException {
		jt.update("delete from members_2 where id=?", new Object[] { m.getId() });
	}

	@Override
	public void updateMember(MemDTO m) throws SQLException {
		jt.update("update members_2 set pw=?, name=?, addr=?, age=? where id=?",
				new Object[] { m.getPw(), m.getName(), m.getAddr(), m.getAge(), m.getId() });
	}

	@Override
	public MemDTO viewMember(MemDTO m) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
}