package ui;

import model.Player;
import model.Team;

import org.apache.commons.lang.StringUtils;

import dao.PlayerDao;
import dao.TeamDao;

public class UpdatePlayerUi extends AbstractUi {

    private PlayerDao playerDao;
    private TeamDao teamDao;
    
    public void setPlayerDao(PlayerDao playerDao) {
        this.playerDao = playerDao;
    }

    public void setTeamDao(TeamDao teamDao) {
        this.teamDao = teamDao;
    }

    @Override
    public void show() {
        Player player = getPlayer();
        if (player == null) {
            return;
        }
        
        String name = getName(player);
        if (StringUtils.isNotEmpty(name)) {
            player.setName(name);
        }

        Team team = getTeam(player);
        if (team != null) {
            player.setTeam(team);
        }
        
        this.playerDao.updataPlayer(player);
        System.out.println("선수 ID[" + player.getId() + "]의 선수 정보를 수정했습니다.");
    }
    
    protected Player getPlayer() {
        final String playerId = "선수 ID";
        showMenu(playerId);
        System.out.println("아무것도 입력하지 않고 Enter를 누르면 메뉴로 돌아갑니다.");
        String id = getInputedString();
        if (StringUtils.isEmpty(id)) {
            return null;
        } else if (UiUtils.isNumeric(id, playerId)) {
            Player player = this.playerDao.getPlayer(Integer.valueOf(id));
            //
            if (player == null) {
                System.out.println("입력된 선수 ID[" + id + "]의 선수는 존재하지 않습니다.");
                return getPlayer();
            }
            return player;
        }
        return getPlayer();
    }

    protected String getName(Player player) {
        final String playerName = "선수 이름";
        
        showMenu(playerName);
        System.out.println("아무것도 입력하지 않고 Enter를 누르면 변경되지 않습니다.");
        System.out.println("원래의 값 : " + player.getName());
        String name = getInputedString();
        if (StringUtils.isEmpty(name)) {
            return null;
        }
        
        if (UiUtils.isSmallLength(name, playerName, 128)) {
            return name;
        }
        
        return getName(player);
    }
    
    protected Team getTeam(Player player) {
        final String teamId = "팀 ID";
        showMenu(teamId);
        System.out.println("아무것도 입력하지 않고 Enter를 누르면 변경되지 않습니다.");
        System.out.println("원래의 값 : " + player.getTeam().getId() +
                " " + player.getTeam().getName());
        String id = getInputedString();
        if (StringUtils.isEmpty(id)) {
            return null;
        }
        
        if (UiUtils.isNumeric(id, teamId)) {
            Team team = this.teamDao.getTeam(Integer.valueOf(id));
            if (team == null) {
                System.out.println("입력된 팀명[" + id + "]의 팀은 존재하지 않습니다.");
                return getTeam(player);
            }
            return team;
        }
        return getTeam(player);
    }
    
    protected void showMenu(String wanted) {
        System.out.println("------------------");
        System.out.println("선수 정보 수정");
        System.out.println("");
        System.out.println(wanted + "을 입력하고 Enter를 눌러 주십시오.");
    }
}















