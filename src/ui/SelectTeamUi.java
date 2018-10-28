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
        System.out.println("Enter�� ���� �ֽʽÿ�.");
        getInputedString();
    }
    
    private void showTeamList(List teamList) {
        System.out.println("---------------------");
        System.out.println(" �� ����");
        System.out.println("");
        System.out.println("ID ����");
        for (Iterator iter = teamList.iterator(); iter.hasNext();) {
            Team team = (Team) iter.next();
            System.out.println(team.getId() + " " + team.getName());
        }
        
    }

}
