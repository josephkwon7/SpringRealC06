package ui;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;

public abstract class AbstractUiTemplate extends AbstractUi {

    public void show() {
        //메뉴를 출력한다.
        showMenu();
        //키보드에서 문자열을 읽어 옴
        String inputedString = getInputedString();
        //읽어온 문자열의 유효성 검사
        if (isValidNumber(inputedString)) {
            //메뉴번호에 해당되는 작업을 실행하기 위한 메소드 호출
            execute(NumberUtils.toInt(inputedString));
        }
    }
    
    abstract protected void showMenu();
    
    abstract protected int getMaxMenuNumber();
    
    abstract protected int getMinMenuNumber();
    
    abstract protected void execute(int number);
    
    //사용자가 입력한 문자열이 숫자인지 메뉴 번호에 존재하는 숫자인지를 검사하는 메소드
    protected boolean isValidNumber(String str) {
        //문자열이 입력되어 있는가?
        if (StringUtils.isBlank(str)) {
            return false;
        //수치인가?
        } else if (!StringUtils.isNumeric(str)) {
            return false;
        }
        //입력받은 메뉴번호는 문자열이므로 이를 int형으로 변환한다.
        int number = NumberUtils.toInt(str);
        //입력된 메뉴 번호가 범위 내에 존재하는 숫자인지를 판단한다.
        if (getMinMenuNumber() <= number && number <=getMaxMenuNumber()) {
            return true;
        }
        
        return false;
    }
}
