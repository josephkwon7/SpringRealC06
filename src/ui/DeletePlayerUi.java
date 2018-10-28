package ui;

import model.Player;

import org.apache.commons.lang.StringUtils;

import dao.PlayerDao;

public class DeletePlayerUi extends AbstractUi {

    private PlayerDao playerDao;
    
    public void setPlayerDao(PlayerDao dao) {
        this.playerDao = dao;
    }
    
    @Override
    public void show() {
        showMenu();
        String id = getInputedString();
        if (StringUtils.isEmpty(id)) {
            return;
        } else if (UiUtils.isNumeric(id, "���� ID")) {
            Player player = this.playerDao.getPlayer(Integer.valueOf(id));
            if (player == null) {
                System.out.println("�Էµ� ���� ID[" + id + "]�� ������ �������� �ʽ��ϴ�.");
                show();
            } else {
                this.playerDao.deletePlayer(player);
                System.out.println("�Էµ� ���� ID[" + id + "]�� ������ �����Ͽ����ϴ�.");
            }
        } else {
            show();
        }
    }
    
    protected void showMenu() {
        System.out.println("---------------------------");
        System.out.println("�������� ����");
        System.out.println("");
        System.out.println("���� ID�� �Է��Ͽ� Enter�� ���� �ֽʽÿ�.");
        System.out.println("�ƹ��͵� �Է����� �ʰ� Enter�� ������ �޴��� ���ư��ϴ�.");
    }

}
