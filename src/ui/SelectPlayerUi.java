package ui;

import java.util.Iterator;
import java.util.List;

import model.Player;

import org.apache.commons.lang.StringUtils;

import dao.PlayerDao;

public class SelectPlayerUi extends AbstractUiTemplate {
    
    private PlayerDao playerDao;
    private UpdatePlayerUi updatePlayerUi;
    private DeletePlayerUi deletePlayerUi;

    public void setPlayerDao(PlayerDao playerDao) {
        this.playerDao = playerDao;
    }

    public void setUpdatePlayerUi(UpdatePlayerUi updatePlayerUi) {
        this.updatePlayerUi = updatePlayerUi;
    }

    public void setDeletePlayerUi(DeletePlayerUi deletePlayerUi) {
        this.deletePlayerUi = deletePlayerUi;
    }
    
    public void show() {
        showHeader();
        Integer teamId = getTeamId();
        showPlayerList(this.playerDao.getPlayerList(teamId));
        System.out.println("Enter를 눌러 주십시오.");
        getInputedString();
        super.show();
    }
    
    protected Integer getTeamId() {
        System.out.println("선수가 속한 팀 ID를 입력하고  Enter를 눌러 주십시오.");
        String teamId = getInputedString();
        if(StringUtils.isNumeric(teamId)) {
            return Integer.valueOf(teamId);
        }
        return getTeamId();
    }
    
    protected void showHeader(){
        System.out.println("-----------------");
        System.out.println("선수 정보 관리");
        System.out.println("");
    }
    
    @Override
    protected void showMenu() {
        showHeader();
        System.out.println("1. 선수 정보 수정");
        System.out.println("2. 선수 정보 삭제");
        System.out.println("3. 메뉴로 돌아감");
        System.out.println("");
        System.out.println("번호를 입력하고 Enter를 눌러 주십시오.");
    }

    protected void showPlayerList(List playerList) {
        if (!playerList.isEmpty()) {
           Player player = (Player)playerList.get(0);
           System.out.println("팀명 : " + player.getTeam().getName());
        }
        System.out.println("ID\t 이름");
        for (Iterator iter = playerList.iterator(); iter.hasNext();) {
            Player player = (Player)iter.next();
            System.out.println(player.getId() + "\t" + player.getName());
        }
    }

    @Override
    protected int getMaxMenuNumber() {
        return 3;
    }

    @Override
    protected int getMinMenuNumber() {
        return 1;
    }
    
    @Override
    protected void execute(int number) {
        switch (number) {
        case 1: 
            updatePlayerUi.show();
            break;
        case 2:
            deletePlayerUi.show();
            break;
        default:
            return;
        }
    }


}
