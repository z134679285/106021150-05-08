import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frame4 extends JFrame {
    private JButton run = new JButton("RUN");
    private JButton reset = new JButton("RESET");
    private JButton exit = new JButton("EXIT");
    private Container cp;
    private JPanel jpnc = new JPanel();
    private JPanel jpnr = new JPanel(new GridLayout(3, 3, 3, 3));
    private JButton jbtn[][] = new JButton[3][3];
    private boolean flag = true;

    public Frame4() {
        init();
    }

    private void init() {
        this.setBounds(100, 100, 600, 500);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        cp = this.getContentPane();
        cp.setLayout(new BorderLayout(3, 3));
        cp.add(jpnc, BorderLayout.CENTER);
        cp.add(jpnr, BorderLayout.EAST);
        jpnc.setLayout(new GridLayout(3, 3, 3, 3));
        jpnr.add(run);
        jpnr.add(reset);
        jpnr.add(exit);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                jbtn[i][j] = new JButton();
                jbtn[i][j].setFont(new Font(null, Font.BOLD, 72));
                jpnc.add(jbtn[i][j]);
                jbtn[i][j].setEnabled(false);
                jbtn[i][j].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JButton tmp = (JButton) e.getSource();
                        if (tmp.getText().equals("")) {
                            if (flag) {
                                tmp.setText("o");
                                tmp.setBackground(new Color(222, 215, 0));
                            } else {
                                tmp.setText("x");
                                tmp.setBackground(new Color(34, 222, 2));
                            }
                            flag = !flag;
                        }
                        check();

                    }
                });
                jbtn[i][j].setBackground(new Color(255, 8, 25));
            }
        }
        run.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              for(int i=0 ;i<3;i++){
                  for(int j=0;j<3;j++){
                      jbtn[i][j].setEnabled(true);
                  }
              }
            }
        });
        reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        jbtn[i][j].setText("");
                        jbtn[i][j].setEnabled(false);
                        jbtn[i][j].setBackground(new Color(255, 8, 25));
                    }
                }
            }
        });
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(EXIT_ON_CLOSE);
            }
        });
    }


    private void check() {
        if (jbtn[0][0].getText().equals(jbtn[0][1].getText()) &&
                jbtn[0][0].getText().equals(jbtn[0][2].getText()) && !jbtn[0][0].getText().equals("")) {
            JOptionPane.showMessageDialog(Frame4.this, jbtn[0][0].getText() + ("  win!"));
        } else if(jbtn[1][0].getText().equals(jbtn[1][1].getText()) &&
                jbtn[1][0].getText().equals(jbtn[1][2].getText()) && !jbtn[1][0].getText().equals(""))
            JOptionPane.showMessageDialog(Frame4.this, jbtn[1][0].getText() + ("  win!"));
        else if(jbtn[2][0].getText().equals(jbtn[2][1].getText()) &&
                jbtn[2][0].getText().equals(jbtn[2][2].getText()) && !jbtn[2][0].getText().equals(""))
            JOptionPane.showMessageDialog(Frame4.this, jbtn[2][0].getText() + ("  win!"));
        else if(jbtn[0][0].getText().equals(jbtn[1][0].getText()) &&
                jbtn[0][0].getText().equals(jbtn[2][0].getText()) && !jbtn[0][0].getText().equals(""))
            JOptionPane.showMessageDialog(Frame4.this, jbtn[0][0].getText() + ("  win!"));
        else if(jbtn[0][1].getText().equals(jbtn[1][1].getText()) &&
                jbtn[0][1].getText().equals(jbtn[2][1].getText()) && !jbtn[0][1].getText().equals(""))
            JOptionPane.showMessageDialog(Frame4.this, jbtn[0][1].getText() + ("  win!"));
        else if(jbtn[0][2].getText().equals(jbtn[1][2].getText()) &&
                jbtn[0][2].getText().equals(jbtn[2][2].getText()) && !jbtn[0][2].getText().equals(""))
            JOptionPane.showMessageDialog(Frame4.this, jbtn[0][2].getText() + ("  win!"));
        else if(jbtn[0][0].getText().equals(jbtn[1][1].getText()) &&
                jbtn[0][0].getText().equals(jbtn[2][2].getText()) && !jbtn[0][0].getText().equals(""))
            JOptionPane.showMessageDialog(Frame4.this, jbtn[0][0].getText() + ("  win!"));
        else if(jbtn[0][2].getText().equals(jbtn[1][1].getText()) &&
                jbtn[0][2].getText().equals(jbtn[2][0].getText()) && !jbtn[0][2].getText().equals(""))
            JOptionPane.showMessageDialog(Frame4.this, jbtn[0][2].getText() + ("  win!"));
    }
}
