package dao.impl;

import java.util.List;

import model.Player;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import dao.PlayerDao;

public class PlayerDaoImpl extends JdbcDaoSupport implements PlayerDao {
    
    private InsertPlayer insertPlayer;
    private PlayerListQuery playerListQuery;
    private PlayerQuery playerQuery;
    private DeletePlayer deletePlayer;
    private UpdatePlayer updatePlayer;
    
    @Override
    protected void initDao() throws Exception {
        this.insertPlayer = new InsertPlayer(getDataSource());
        this.playerListQuery = new PlayerListQuery(getDataSource());
    }

    public void insertPlayer(Player player) throws DataAccessException {
        this.insertPlayer.update(
                new Object[]{player.getName(), player.getTeam().getId()});
    }

    public List getPlayerList(Integer teamId) throws DataAccessException {
        return this.playerListQuery.execute(teamId);
    }

    public Player getPlayer(Integer id) throws DataAccessException {
        return (Player)this.playerQuery.findObject(id);
    }

    public void deletePlayer(Player player) throws DataAccessException {
        this.deletePlayer.update(player.getId());
    }

    public void updataPlayer(Player player) throws DataAccessException {
        this.updatePlayer.update(
                new Object[]{player.getName(), player.getTeam().getId(), player.getId()}
        );
    }

}
