package ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public abstract class AbstractUi {
    protected String getInputedString() {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        try {
            return input.readLine();
        } catch (IOException e) {
            return "예외발생";
        }
    }
    
    abstract public void show();
}
