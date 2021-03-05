import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;

public class ButtonListener implements ActionListener {
    JTextField output;

    public void setOutput(JTextField output) {
        this.output = output;
    }

    String a[] = {"+", "-", "*", "/", "."};

    @Override
    public void actionPerformed(ActionEvent e) {
        if(Pattern.matches("^[\\u2E80-\\u9FFF]+$",output.getText()))
            output.setText(null);
        if(Pattern.matches("(\\-+)?+\\d+(\\.\\d+)?+.+\\d+(\\.\\d+)?+\\=+(\\-+)?+\\d+(\\.\\d+)?",output.getText()))
            output.setText(null);
        for (int i = 0; i <= 9; i++) {
            String temp = e.getActionCommand();
            if (temp.equals(String.valueOf(i))) {
                String str = output.getText();
                output.setText(str + i);
            }
        }
        for (int i = 0; i < 5; i++) {
            String temp = e.getActionCommand();
            if (temp.equals(a[i])) {
                String str = output.getText();
                output.setText(str + a[i]);
            }
        }
        if (e.getActionCommand() == "C") {
            String temp=output.getText();
            temp=temp.substring(0,temp.length()-1);
            output.setText(temp);
        }
        if (e.getActionCommand() == "CE") {
            System.out.println("CE");
            output.setText(null);
        }
        if (e.getActionCommand() == "取负") {
            try{
                if(Pattern.matches("\\d+(\\.\\d+)?",output.getText())){
                    output.setText("-"+output.getText());
                }
                else
                    throw new Exception();
            }
            catch (Exception exp){
                output.setText("操作有误");
            }
        }
        System.out.println("按下了 " + e.getActionCommand());

    }
}
