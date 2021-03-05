import javax.swing.*;
import java.awt.*;

public class Windows extends JFrame {
    JTextField output;
    JButton num[], fx[], c, ce;

    ComputerListener computer;
    ButtonListener button;

    JPanel p1;
    JPanel jp[];

    public Windows() {
        init();
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    void init() {
        //setLayout(new FlowLayout());
        int i;

        output = new JTextField(25);
        output.setEditable(false);
        //设置不可编辑状态
        output.setHorizontalAlignment(JTextField.TRAILING);
        //尾部对齐
        output.setText("只能两位运算");
        output.setFont(new Font("华文行楷",Font.PLAIN,50));
        p1 = new JPanel();
        p1.setLayout(new GridLayout(5, 1));
        computer = new ComputerListener();
        button = new ButtonListener();
        computer.setOutput(output);
        button.setOutput(output);
        num = new JButton[10];
        for (i = 0; i < 10; i++) {
            num[i] = new JButton(String.valueOf(i));
            num[i].addActionListener(button);
        }
        fx = new JButton[7];
        String a[] = {"+", "-", "*", "/", ".", "取负", "="};
        for (i = 0; i < fx.length; i++) {
            fx[i] = new JButton(a[i]);
            if (i != 6)
                fx[i].addActionListener(button);
        }
        fx[6].addActionListener(computer);
        c = new JButton("C");
        ce = new JButton("CE");
        c.addActionListener(button);
        ce.addActionListener(button);
        add(output, BorderLayout.NORTH);
        add(p1, BorderLayout.CENTER);
        output.setPreferredSize(new Dimension(0,100));
        fx[6].setPreferredSize(new Dimension(0,50));
        add(fx[6], BorderLayout.SOUTH);
        jp = new JPanel[5];
        for (i = 0; i < jp.length; i++) {
            jp[i] = new JPanel();
            jp[i].setLayout(new GridLayout());
        }
        jp[0].add(c);
        jp[0].add(ce);
        jp[1].add(num[7]);
        jp[1].add(num[8]);
        jp[1].add(num[9]);
        jp[1].add(fx[0]);
        jp[2].add(num[4]);
        jp[2].add(num[5]);
        jp[2].add(num[6]);
        jp[2].add(fx[1]);
        jp[3].add(num[1]);
        jp[3].add(num[2]);
        jp[3].add(num[3]);
        jp[3].add(fx[2]);
        jp[4].add(num[0]);
        jp[4].add(fx[5]);
        jp[4].add(fx[4]);
        jp[4].add(fx[3]);

        p1.add(jp[0]);
        p1.add(jp[1]);
        p1.add(jp[2]);
        p1.add(jp[3]);
        p1.add(jp[4]);
    }
}
