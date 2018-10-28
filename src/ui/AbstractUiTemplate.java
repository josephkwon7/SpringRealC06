package ui;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;

public abstract class AbstractUiTemplate extends AbstractUi {

    public void show() {
        //�޴��� ����Ѵ�.
        showMenu();
        //Ű���忡�� ���ڿ��� �о� ��
        String inputedString = getInputedString();
        //�о�� ���ڿ��� ��ȿ�� �˻�
        if (isValidNumber(inputedString)) {
            //�޴���ȣ�� �ش�Ǵ� �۾��� �����ϱ� ���� �޼ҵ� ȣ��
            execute(NumberUtils.toInt(inputedString));
        }
    }
    
    abstract protected void showMenu();
    
    abstract protected int getMaxMenuNumber();
    
    abstract protected int getMinMenuNumber();
    
    abstract protected void execute(int number);
    
    //����ڰ� �Է��� ���ڿ��� �������� �޴� ��ȣ�� �����ϴ� ���������� �˻��ϴ� �޼ҵ�
    protected boolean isValidNumber(String str) {
        //���ڿ��� �ԷµǾ� �ִ°�?
        if (StringUtils.isBlank(str)) {
            return false;
        //��ġ�ΰ�?
        } else if (!StringUtils.isNumeric(str)) {
            return false;
        }
        //�Է¹��� �޴���ȣ�� ���ڿ��̹Ƿ� �̸� int������ ��ȯ�Ѵ�.
        int number = NumberUtils.toInt(str);
        //�Էµ� �޴� ��ȣ�� ���� ���� �����ϴ� ���������� �Ǵ��Ѵ�.
        if (getMinMenuNumber() <= number && number <=getMaxMenuNumber()) {
            return true;
        }
        
        return false;
    }
}
