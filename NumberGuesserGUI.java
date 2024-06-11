import java.io.*;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import java.lang.Exception;

class GUI implements ActionListener{
    JFrame frame;
    JButton button;
    JButton restart;
    JTextField t_1;
    JLabel result;
    int ran_num;
    int rem_trial=10;
    int score=100;
    GUI(){
        frame = new JFrame();
        frame.setSize(300,300);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setTitle("Number Guesser");
        frame.setLayout(new FlowLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel l1=new JLabel("Welcome to the game !..");
        frame.add(l1);

        JLabel l2=new JLabel("Enter the guess");
        frame.add(l2);

        t_1=new JTextField(10);
        frame.add(t_1);

        result=new JLabel("");
        frame.add(result);

        button = new JButton("Guess");
        button.addActionListener(this);
        frame.add(button);

        restart = new JButton("Restart");
        restart.addActionListener(this);
        frame.add(restart);

        restart.setEnabled(false);
        frame.revalidate();

        ran_num=createRandomNum();

    }

    public int createRandomNum(){
        Random rand = new Random();
        int random= rand.nextInt(101);
        return random;
    }

    public void actionPerformed(ActionEvent e){
        
        if(e.getSource() == button){
            String s;
            s=t_1.getText();
            int guess;
            try{
                guess=Integer.parseInt(s);
            }
            catch(NumberFormatException obj){
                result.setText("Please enter a valid number.");
                return;
            }
            rem_trial=rem_trial-1;

            if(guess==ran_num){
                result.setText("Correct ! Your score is :"+score);
                button.setEnabled(false); 
                restart.setEnabled(true);
            }
            else if(guess>ran_num){
                result.setText("Too high ... Guess LOWER.Remaining tries : "+ rem_trial);
                score=score-10;
            }
            else {
                result.setText("Too low ... Guess HIGHER. Remaining tries : "+ rem_trial);
                score=score-10;
            }
            if(rem_trial==0){
                result.setText("Out of tries... Your score: " + score+"Correct answer : "+ran_num);
                restart.setEnabled(true);
                button.setEnabled(false);
            }
            t_1.setText("");   
           
        }
        else if(e.getSource()== restart){
            ran_num = createRandomNum(); 
            rem_trial = 10;
            score = 100; 
            result.setText(""); 
            restart.setEnabled(false);
            button.setEnabled(true);
        }
       
    }
}
public class NumberGuesserGUI{
    public static void main(String[] args) {
        new GUI();
    }
}