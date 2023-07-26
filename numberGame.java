import java.util.*;

public class numberGame
{
  public static void main(String[] args) 
    {
        String name;
        int systemAnswer = (int)(Math.random() * 100) + 1;
        int chances = 5;
        
        //To check the output
        //System.out.println(systemAnswer);

        Scanner sc = new Scanner(System.in);
        System.out.println("\n--- Welcome to the Number Game ---");
        System.out.println("\nEnter Your Name : ");
        name = sc.next();

        System.out.println("\nHello "+name+", Hope you doing well.");
        System.out.println("I have guessed the number.");
        System.out.println("Now it's your turn to guess the number.");
        System.out.println("Let's see will you get it or not ?");
        System.out.println("Best of Luck..!!");
        System.out.println("Let's get started..");


        
        while (chances > 0) 
        {
            System.out.println("\nYou have "+ chances+" left to guess the number.");
            System.out.println("\nEnter your guessed Number : ");
            int userAnswer = sc.nextInt();
            
            if (userAnswer == systemAnswer) 
            {
                System.out.println("\nCongratulations !! You guessed the correct number!");
                System.out.println("You have won the game.");
                System.out.println("Ok, Bye.. Have a nice day !!!\n");
                break;
            }
            else if (userAnswer < systemAnswer)
            {
                System.out.println("\nYour guess is too low.");
                System.out.println("Try Again !!\n");
            }
            else
            {
                System.out.println("\nYour guess is too high.");
                System.out.println("Try Again !!\n");
            }
            chances--;
        }
           
        if (chances == 0)
        {
            System.out.println("\nSorry, Your chances are over.");
            System.out.println("You have lose the game.");
            System.out.println("\nCorrect answer is : "+systemAnswer+".\n");
            System.out.println("No worries, Better Luck Next Time :)\n");
        }
            

    }
}
