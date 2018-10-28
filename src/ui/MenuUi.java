package ui;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MenuUi extends AbstractUiTemplate {
    
    private SelectTeamUi selectTeamUi;
    private InsertPlayerUi insertPlayerUi;
    private SelectPlayerUi selectPlayerUi;

    public void setSelectTeamUi(SelectTeamUi selectTeamUi) {
        this.selectTeamUi = selectTeamUi;
    }
    
    public void setInsertPlayerUi(InsertPlayerUi insertPlayerUi) {
        this.insertPlayerUi = insertPlayerUi;
    }

    public void setSelectPlayerUi(SelectPlayerUi selectPlayerUi) {
        this.selectPlayerUi = selectPlayerUi;
    }


    protected void showMenu() {
        System.out.println("------------------");
        System.out.println("");
        System.out.println("1.종료");
        System.out.println("2.팀 전체 리스트");
        System.out.println("3.선수 정보 추가");
        System.out.println("4.선수 정보 관리");
        System.out.println("");
        System.out.println("번호를 입력하고 Enter를 눌러 주십시오.");
    }

    protected int getMaxMenuNumber() {
        return 4;
    }

    protected int getMinMenuNumber() {
        return 1;
    }
    
    protected void execute(int number) {
        switch (number) {
        case 1:
            //1.종료
            System.out.println("프로그램이 종료도었습니다.");
            System.exit(0);
        case 2:
            //2.팀 전체 리스트
            this.selectTeamUi.show();
            break;
        case 3:
            //3.선수 정보 추가
            this.insertPlayerUi.show();
            break;
        case 4:
            //4.선수 정보 관리
            this.selectPlayerUi.show();
            break;
        }
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        //스프링 설정 파일을 읽어 들임
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        MenuUi menuUi = (MenuUi)context.getBean("menuUi");
        while (true) {
            menuUi.show();
        }

    }

}
