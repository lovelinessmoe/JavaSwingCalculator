import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.StringTokenizer;
import java.util.regex.Pattern;

public class ComputerListener implements ActionListener {
    JTextField output;
    public void setOutput(JTextField output) {
        this.output = output;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            StringTokenizer chaishu = new StringTokenizer(output.getText(), "+-*/");
            double number1 = Double.parseDouble(chaishu.nextToken());
            double number2 = Double.parseDouble(chaishu.nextToken());
            if(Pattern.matches("\\-+\\d+(\\.\\d+)?+.+\\d+(\\.\\d+)?",output.getText()))
                number1=-number1;
            System.out.println(chaishu.countTokens());
            //debug
            System.out.println(number1+"and"+number2);
            double result=0;
            if(Pattern.matches("(\\-+)?+\\d+(\\.\\d+)?+\\++\\d+(\\.\\d+)?",output.getText())){
                result=number1+number2;
            }
            else if(Pattern.matches("(\\-+)?+\\d+(\\.\\d+)?+\\-+\\d+(\\.\\d+)?",output.getText())) {
                result = number1-number2;
            }
            else if(Pattern.matches("(\\-+)?+\\d+(\\.\\d+)?+\\*+\\d+(\\.\\d+)?",output.getText())) {
                result = number1*number2;
            }
            else if(Pattern.matches("(\\-+)?+\\d+(\\.\\d+)?+\\/+\\d+(\\.\\d+)?",output.getText())) {
                result = number1/number2;
            }
            else {
                throw new Exception();
            }
            DecimalFormat df=new DecimalFormat("0.00");
            output.setText(output.getText()+"="+df.format(result));
        }
        catch (Exception exp){
            output.setText("你的操作不对");
        }
    }
}
