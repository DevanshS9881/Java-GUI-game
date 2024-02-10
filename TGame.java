
//import java.awt.BorderLayout;
//import java.awt.Font;
//import java.awt.GridLayout;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
import java.awt.*;
import java.awt.event.*;
//import javax.swing.JButton;
//import javax.swing.JFrame;
//import javax.swing.JLabel;
//import javax.swing.JOptionPane;
//import javax.swing.JPanel;
import javax.swing.*;

public class TGame extends JFrame implements ActionListener {
    JLabel heading;
    JLabel heading2;
    Font font = new Font("", Font.BOLD, 40);
    JPanel mainPanel;
     JButton []btn=new JButton[9];
    int gamechances[] = { 2, 2, 2, 2, 2, 2, 2, 2, 2 };
    int activeP = 0;
    int count = 0;
    int score[];
    int Windex[][]={{0,1,2},{0,3,6},{0,4,8},{8,2,5},{8,6,7},{1,4,7},{3,4,5},{2,4,6}};
    TGame(int s[]) 
    {
        setTitle("My Tic Tac game");
        setSize(850, 850);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        score=s;
        GUIcreate();
        setVisible(true);

    }

    public void GUIcreate() {
        this.getContentPane().setBackground(Color.yellow);
        this.setLayout(new BorderLayout());
        heading = new JLabel("TIC TAC TOE");
        heading2=new JLabel("SCOREBOARD    PLAYER 0: "+score[0]+"     PLAYER 1: "+score[1]);
        heading.setFont(font);
        heading.setForeground(Color.green);
        this.add(heading, BorderLayout.NORTH);
        heading.setHorizontalAlignment(SwingConstants.CENTER);
        heading2.setFont(font);
        heading2.setForeground(Color.black);
        this.add(heading2, BorderLayout.SOUTH);
        heading2.setHorizontalAlignment(SwingConstants.CENTER);
        // panel section
        mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(3, 3));
        for (int i = 1; i <= 9; i++) {
            JButton bt = new JButton();
            bt.setBackground(Color.cyan);
            bt.setFont(font);
            mainPanel.add(bt);
             btn[i-1]=bt;
            bt.addActionListener(this);
            bt.setName(String.valueOf(i - 1));
        }
        this.add(mainPanel, BorderLayout.CENTER);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("clicked");
        JButton currentB = (JButton) e.getSource();
        String name = currentB.getName();
        int n = Integer.parseInt(name.trim());
        int i=0;
        int s[];
        if (gamechances[n] == 2) 
        {
            if (activeP == 1) 
            {
                currentB.setText("X");
                activeP = 0;
                gamechances[n] = 1;
                count++;
                
            } else 
            {
                currentB.setText("O ");
                activeP = 1;
                gamechances[n] = 0;
                count++;
            }
            //winner logic
            for(int[] temp: Windex)
            {
                if(gamechances[temp[0]]==gamechances[temp[1]]&&(gamechances[temp[0]]==gamechances[temp[2]])&&(gamechances[temp[0]]!=2))
                {
                    btn[temp[0]].setBackground(Color.red);
                    btn[temp[1]].setBackground(Color.red);
                    btn[temp[2]].setBackground(Color.red);
                    score[gamechances[temp[0]]]++;
                    JOptionPane.showMessageDialog(this,"Player "+gamechances[temp[0]]+" Wins!!");
                    //JoptionPane.showMessageDialog(this,"SCORES")
                    //System.exit(0);
                    i=JOptionPane.showConfirmDialog(this, "Do you want to play more");
                    if(i==0)
                    {
                        this.setVisible(false);
                        new TGame(score);
                       
                    }
                    else 
                    {
                      System.exit(0);

                    }
                }
            }
             if(count==9)
                {
                        JOptionPane.showMessageDialog(this, "MATCH DRAW!!!!");
                        System.exit(0);
                }
                

            
        } 
        else {
            JOptionPane.showMessageDialog(this, "Position already occupied!!!!");
        }

    }

    //public boolean Logic() {
        //if (((gamechances[0] == gamechances[1]) && (gamechances[2] == gamechances[1]) && (gamechances[1] != 2)) ||
                //((gamechances[0] == gamechances[3]) && (gamechances[6] == gamechances[0]) && (gamechances[0] != 2)) ||
                //((gamechances[0] == gamechances[4]) && (gamechances[8] == gamechances[0]) && (gamechances[0] != 2)) ||
                //((gamechances[8] == gamechances[2]) && (gamechances[5] == gamechances[8]) && (gamechances[8] != 2)) ||
                //((gamechances[8] == gamechances[0]) && (gamechances[4] == gamechances[8]) && (gamechances[8] != 2)) ||
                //((gamechances[8] == gamechances[6]) && (gamechances[7] == gamechances[8]) && (gamechances[8] != 2)) ||
                //((gamechances[1] == gamechances[4]) && (gamechances[7] == gamechances[1]) && (gamechances[1] != 2)) ||
                //((gamechances[3] == gamechances[4]) && (gamechances[5] == gamechances[4]) && (gamechances[4] != 2)))

        //{
            //if (activeP == 1) {
                //JOptionPane.showMessageDialog(this, "Player O Wins!!!!");
                //return true;
           // } else {
                //JOptionPane.showMessageDialog(this, "Player X Wins !!!!");
               // return true;
           // }
       // } else {
           // if (count == 9) {
                //JOptionPane.showMessageDialog(this, "MATCH DRAW!!!!");
                //System.exit(0);

           // }
            //return false;
       // }
    //}

}
