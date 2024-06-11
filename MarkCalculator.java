import java.io.*;
import java.util.Scanner;

class Calculator {
    String name;
    double[] mark;

    Calculator(String name, double[] mark) {
        this.name = name;
        this.mark = mark;
    }

    double calculate() {
        double total = 0;
        for (double m : mark) {
            total += m;
        }
        System.out.println("Total Marks :" + total);
        return total / mark.length;
    }

    void grade() {
        double percentage = calculate();
        System.out.println("Percentage : " + percentage);
        if (percentage >= 90) {
            System.out.println("Grade : S");
        } else if (percentage >= 80) {
            System.out.println("Grade : A");
        } else if (percentage >= 70) {
            System.out.println("Grade : B");
        } else if (percentage >= 60) {
            System.out.println("Grade : C");
        } else if (percentage >= 50) {
            System.out.println("Grade : D");
        } else {
            System.out.println("Grade : F");
        }
    }
}

public class MarkCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean continueProgram = true;

        while (continueProgram) {
            System.out.println("WELCOME TO GRADE CALCULATOR");
            System.out.println();
            System.out.println();
            System.out.println("Enter the name");
            String name = sc.nextLine();
            System.out.println("Enter the number of subjects");
            int num = sc.nextInt();
            double[] marks = new double[num];
            System.out.println("Enter the marks of each subject (Out of 100)");
            for (int i = 0; i < num; i++) {
                System.out.print("Subject "+ (i+1)+" :");
                marks[i] = sc.nextDouble();
                sc.nextLine();
            }
            System.out.println();
            
            Calculator c = new Calculator(name, marks);
            System.out.println();
            System.out.println();
            System.out.println("RESULT");
            System.out.println();
            System.out.println("Name :" + name);
            c.grade();

            System.out.println("Do you want to continue - (yes/no) : ");
            String choice = sc.nextLine();

            if (!choice.equalsIgnoreCase("yes")) {
                System.out.println("Thank you !");
                continueProgram = false;
            }
        }
        sc.close();
    }
}

