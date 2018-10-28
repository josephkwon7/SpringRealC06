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
        final String playerName = "���� �̸�";
        //�޴��� ���ư�
        showMenu(playerName);
        //���ڿ��� �Է¹���
        String name = getInputedString();
        //���ڿ��� �ԷµǾ������� Ȯ���Ѵ�.
        if (StringUtils.isEmpty(name)) {
            //�޴��� ���ư�
            return;
        //128���� ���������� Ȯ���Ѵ�.
        } else if (UiUtils.isSmallLength(name, playerName, 128)) {
            //���ο� ������ �����Ѵ�.
            Player player = new Player();
            player.setName(name);
            //���� �����Ѵ�.
            showTeamField(player);
        } else {
            show();
        }
    }
    
    protected void showTeamField(Player player) {
        final String teamId = "�� ID";
        //�޴��� ���ư�
        showMenu(teamId);
        //���ڿ��� �Է¹���
        String id = getInputedString();
        //���ڿ��� �ԷµǾ������� Ȯ���Ѵ�.
        if (StringUtils.isEmpty(id)) {
            return;
        //��ġ������ Ȯ���Ѵ�.
        } else if (UiUtils.isNumeric(id, teamId)) {
            //ID�� ���� �˻�
            Team team = this.teamDao.getTeam(Integer.valueOf(id));
            if (team == null) {
                //�ش��ϴ� ���� �������� ����
                System.out.println("�Էµ� ����[" + id + "]�� ���� �������� �ʴ´�.");
                showTeamField(player);
            } else {
                //���� ������ �����Ѵ�.
                player.setTeam(team);
                //�����ͺ��̽��� ������ ���
                playerDao.insertPlayer(player);
                System.out.println("��[" + team.getName() + "]�� [" 
                        + player.getName() + "]������ �߰��ߴ�.");
            }
        }
    }
    
    protected void showMenu(String wanted) {
        System.out.println("------------------------------------");
        System.out.println(wanted + "�� �Է��ϰ� Enter�� ���� �ֽʽÿ�.");
        System.out.println("�ƹ��͵� �Է����� �ʰ� Enter�� ������ �޴��� ���ư��ϴ�.");
    }
}
