package dao;

import java.util.List;

import model.Player;

import org.springframework.dao.DataAccessException;

public interface PlayerDao {
    
    void insertPlayer(Player player) throws DataAccessException;
    
    List getPlayerList(Integer teamId) throws DataAccessException;
    
    Player getPlayer(Integer id) throws DataAccessException;
    
    void deletePlayer(Player player) throws DataAccessException;
    
    void updataPlayer(Player player) throws DataAccessException;
    
}
