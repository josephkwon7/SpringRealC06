package ui;

import model.Player;
import model.Team;

import org.apache.commons.lang.StringUtils;

import dao.PlayerDao;
import dao.TeamDao;

public class InsertPlayerUi extends AbstractUi {
    
    private TeamDao teamDao;
    
    private PlayerDao playerDao;

    public void setTeamDao(TeamDao teamDao) {
        this.teamDao = teamDao;
    }

    public void setPlayerDao(PlayerDao playerDao) {
        this.playerDao = playerDao;
    }

    public void show() {
        final String playerName = "선수 이름";
        //메뉴로 돌아감
        showMenu(playerName);
        //문자열을 입력받음
        String name = getInputedString();
        //문자열이 입력되었는지를 확인한다.
        if (StringUtils.isEmpty(name)) {
            //메뉴로 돌아감
            return;
        //128문자 이하인지를 확인한다.
        } else if (UiUtils.isSmallLength(name, playerName, 128)) {
            //새로운 선수를 생성한다.
            Player player = new Player();
            player.setName(name);
            //팀을 결정한다.
            showTeamField(player);
        } else {
            show();
        }
    }
    
    protected void showTeamField(Player player) {
        final String teamId = "팀 ID";
        //메뉴로 돌아감
        showMenu(teamId);
        //문자열을 입력받음
        String id = getInputedString();
        //문자열이 입력되었는지를 확인한다.
        if (StringUtils.isEmpty(id)) {
            return;
        //수치인지를 확인한다.
        } else if (UiUtils.isNumeric(id, teamId)) {
            //ID로 팀을 검색
            Team team = this.teamDao.getTeam(Integer.valueOf(id));
            if (team == null) {
                //해당하는 팀은 존재하지 않음
                System.out.println("입력된 팀명[" + id + "]의 팀은 존재하지 않는다.");
                showTeamField(player);
            } else {
                //팀을 선수에 세팅한다.
                player.setTeam(team);
                //테이터베이스로 선수를 등록
                playerDao.insertPlayer(player);
                System.out.println("팀[" + team.getName() + "]에 [" 
                        + player.getName() + "]선수를 추가했다.");
            }
        }
    }
    
    protected void showMenu(String wanted) {
        System.out.println("------------------------------------");
        System.out.println(wanted + "을 입력하고 Enter를 눌러 주십시오.");
        System.out.println("아무것도 입력하지 않고 Enter를 누르면 메뉴로 돌아갑니다.");
    }
}
