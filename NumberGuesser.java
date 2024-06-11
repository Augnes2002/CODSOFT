import java.io.*;
import java.util.*;
import java.util.Random;

public class NumberGuesser {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        Random rand =new Random();
        Boolean trial=true;
        int round=1;
        
         /*System.out.println(ran_num);*/

        while(trial){

            int score=100;
            int ran_num=rand.nextInt(101);

            System.out.println("ROUND : "+round);
            int guess_count=0;
            System.out.println("You have 10 tries..");
            for(int i=0;i<10;i++){
                System.out.println("Enter the guess");
                int guess = input.nextInt();
                guess_count++;
                if(guess==ran_num){
                    System.out.println("Correct!.... ");
                    break;
                }
                if(guess>ran_num){
                    System.out.println("Too High...GUESS LOWER");
                    score=score-10;
                }
                if(guess<ran_num){
                    System.out.println("Too low ...GUESS HIGHER");
                    score=score-10;
                }

                if(i==9){
                    System.out.println("Better luck next time...");
                }

                System.out.println("You have "+" "+(10-guess_count)+" "+"tries left");
            }
            System.out.println("");
            System.out.println("Correct Answer : "+ ran_num);
            System.out.println("Score : "+score);
            input.nextLine();
            System.out.println("Do you want to continue the game ?(yes/no)");
            String choice=input.nextLine();
            if(!choice.equalsIgnoreCase("yes")){
                trial=false;
            }
            else{
                ran_num=rand.nextInt(101);
                round++;
                score=50;
            }
            
        }

        input.close();
        System.out.println("Thanks for playing...");
        
    }
    
}
