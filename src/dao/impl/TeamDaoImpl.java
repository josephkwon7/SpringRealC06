package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Team;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import dao.TeamDao;

public class TeamDaoImpl extends JdbcDaoSupport implements TeamDao {

    public List getTeamList() throws DataAccessException {
        RowMapper rowMapper = new TeamRowMapper();
        return getJdbcTemplate().query("SELECT team_id, name FROM team", rowMapper);
    }
    
    protected class TeamRowMapper implements RowMapper  {
        private List teamList = new ArrayList();
        
        public List getResults() {
            return teamList;
        }
        public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
            Team team = new Team();
            team.setId(new Integer(rs.getInt("team_id")));
            team.setName(rs.getString("name"));
            return team;
        }
    }

    public Team getTeam(Integer teamId) throws DataAccessException {
        return (Team)getJdbcTemplate().query(new TeamPreparedStatementCreator(teamId), new TeamResultSetExtractor());
    }

    protected class TeamPreparedStatementCreator implements PreparedStatementCreator {
        private Integer teamId;
        
        public TeamPreparedStatementCreator(Integer id) {
            this.teamId = id;
        }

        public PreparedStatement createPreparedStatement(Connection con)
                throws SQLException {
            final String sql = "SELECT team_id, name FROM team WHERE team_id = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, this.teamId.intValue());
            return ps;
        }
    }
    
    protected class TeamResultSetExtractor implements ResultSetExtractor {

        public Object extractData(ResultSet rs) throws SQLException,
                DataAccessException {
            //SQL 결고가 적어도 1건이라도 있는지 검사한다.
            if (rs.next()) {
                Team team = new Team();
                team.setId(new Integer(rs.getInt("team_id")));
                team.setName(rs.getString("name"));
                return team;
            } else {
                return null;
            }
        }
    }
}
