import java.io.*;
import java.util.*;
class Bank{
    double balance;
    Bank(double balance){
        this.balance=balance;
    }
    void balance(){
        System.out.println("Balance Amount : "+this.balance);
    }
    void deposit(double depositAm){
        if(depositAm<0){
            System.out.println("Invalid Amount");
        }
        else{
            this.balance=this.balance+depositAm;
            System.out.println("Transaction Successful.");
            System.out.println("Available Balance : " + this.balance);
        }
    }
    void withdraw(double withdrawAm)
    {
        if(withdrawAm >this.balance){
            System.out.println("Insufficient balance...");
        }
        else if(withdrawAm<0){
            System.out.println("Invalid Amount");
        }
        else{
            this.balance=this.balance-withdrawAm;
            System.out.println("Transaction Successful");
            System.out.println("Available balance :"+this.balance);
        }
    }
}

public class ATM {
    public static void main(String[] args){
        Scanner input=new Scanner(System.in);
        Bank account=new Bank(5000);
        int[] validpins={1234,5678,456,9637};
        boolean validPin=false;
        
        System.out.println("Welcome to the ATM");
        System.out.println("Enter your PIN :");
        int PIN=input.nextInt();
        
        for(int validPIN:validpins){
            if(PIN==validPIN){
                validPin=true;
            }
        }
        if (validPin){
            while(true){ 
                System.out.println("Please select an option:");
                System.out.println("1. Check Balance");
                System.out.println("2. Deposit");
                System.out.println("3. Withdraw");
                System.out.println("4. Exit");
                int choice=input.nextInt();
                    switch(choice){
                        case 1:
                            account.balance();
                            break;
                        case 2:
                            System.out.println("Enter the amount :");
                            double dep=input.nextDouble();
                            account.deposit(dep);
                            break;
                        case 3:
                            System.out.println("Enter the amount :");
                            double with=input.nextDouble();
                            account.withdraw(with);
                            break;
                        case 4:
                            System.out.println("Thank you !....");
                            System.exit(0);
                            break;
                        default :
                            System.out.println("Invalid selection.Please try again.");
                            break;
                    }
                }
            }
        else{
                System.out.println("PIN is wrong !");
        }
    }
 }
