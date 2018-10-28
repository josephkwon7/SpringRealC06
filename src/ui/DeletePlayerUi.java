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
        } else if (UiUtils.isNumeric(id, "선수 ID")) {
            Player player = this.playerDao.getPlayer(Integer.valueOf(id));
            if (player == null) {
                System.out.println("입력된 선수 ID[" + id + "]의 선수는 존재하지 않습니다.");
                show();
            } else {
                this.playerDao.deletePlayer(player);
                System.out.println("입력된 선수 ID[" + id + "]의 선수를 삭제하였습니다.");
            }
        } else {
            show();
        }
    }
    
    protected void showMenu() {
        System.out.println("---------------------------");
        System.out.println("선수정보 삭제");
        System.out.println("");
        System.out.println("선수 ID를 입력하여 Enter를 눌러 주십시오.");
        System.out.println("아무것도 입력하지 않고 Enter를 누르면 메뉴로 돌아갑니다.");
    }

}
