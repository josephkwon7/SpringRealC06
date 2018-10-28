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
        System.out.println("���� ID[" + player.getId() + "]�� ���� ������ �����߽��ϴ�.");
    }
    
    protected Player getPlayer() {
        final String playerId = "���� ID";
        showMenu(playerId);
        System.out.println("�ƹ��͵� �Է����� �ʰ� Enter�� ������ �޴��� ���ư��ϴ�.");
        String id = getInputedString();
        if (StringUtils.isEmpty(id)) {
            return null;
        } else if (UiUtils.isNumeric(id, playerId)) {
            Player player = this.playerDao.getPlayer(Integer.valueOf(id));
            //
            if (player == null) {
                System.out.println("�Էµ� ���� ID[" + id + "]�� ������ �������� �ʽ��ϴ�.");
                return getPlayer();
            }
            return player;
        }
        return getPlayer();
    }

    protected String getName(Player player) {
        final String playerName = "���� �̸�";
        
        showMenu(playerName);
        System.out.println("�ƹ��͵� �Է����� �ʰ� Enter�� ������ ������� �ʽ��ϴ�.");
        System.out.println("������ �� : " + player.getName());
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
        final String teamId = "�� ID";
        showMenu(teamId);
        System.out.println("�ƹ��͵� �Է����� �ʰ� Enter�� ������ ������� �ʽ��ϴ�.");
        System.out.println("������ �� : " + player.getTeam().getId() +
                " " + player.getTeam().getName());
        String id = getInputedString();
        if (StringUtils.isEmpty(id)) {
            return null;
        }
        
        if (UiUtils.isNumeric(id, teamId)) {
            Team team = this.teamDao.getTeam(Integer.valueOf(id));
            if (team == null) {
                System.out.println("�Էµ� ����[" + id + "]�� ���� �������� �ʽ��ϴ�.");
                return getTeam(player);
            }
            return team;
        }
        return getTeam(player);
    }
    
    protected void showMenu(String wanted) {
        System.out.println("------------------");
        System.out.println("���� ���� ����");
        System.out.println("");
        System.out.println(wanted + "�� �Է��ϰ� Enter�� ���� �ֽʽÿ�.");
    }
}















