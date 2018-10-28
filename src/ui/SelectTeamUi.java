package ui;

import java.util.Iterator;
import java.util.List;

import model.Team;
import dao.TeamDao;

public class SelectTeamUi extends AbstractUi {

    private TeamDao teamDao;
    
    public void setTeamDao(TeamDao teamDao) {
        this.teamDao = teamDao;
    }
    
    public void show() {
        showTeamList(this.teamDao.getTeamList());
        System.out.println("Enter를 눌러 주십시오.");
        getInputedString();
    }
    
    private void showTeamList(List teamList) {
        System.out.println("---------------------");
        System.out.println(" 팀 관리");
        System.out.println("");
        System.out.println("ID 팀명");
        for (Iterator iter = teamList.iterator(); iter.hasNext();) {
            Team team = (Team) iter.next();
            System.out.println(team.getId() + " " + team.getName());
        }
        
    }

}
