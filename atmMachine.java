import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;  

class userBanchancesAcc
{
	static int balance = 100000;
	static int chances = 3;
	static ArrayList<String> transactionHist = new ArrayList<>();
 	final static int userAccountNo = 1234;
	final static int userPin = 1234;
	static int deposit[];
	static int bal[]; 

	public static boolean checchancesPassword()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("\nEnter PIN : ");
		int pin = sc.nextInt();
		if(pin == userPin)
		{ return true; }
		else
		{
			while( chances >0 && pin != userPin)
			{
				System.out.println("\nYou have entered wrong pin !! ");
				System.out.println("Try Again.. ");
				System.out.println("You have "+chances+" chances left !! \n");
				System.out.println("Enter PIN : ");
				pin = sc.nextInt();
				if(pin == userPin )
				{
					return true;
				}
				chances--;
			}
			return false;
		}
	}

	
	public static boolean checchancesAccountNumber()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("\nEnter Account Number : ");
		int accountNo = sc.nextInt();
		if(accountNo == userAccountNo)
		{ return true; }
		else
		{
			while( chances >0 && accountNo != userAccountNo)
			{
				System.out.println("\nYou have entered wrong Account Number !! ");
				System.out.println("Try Again.. ");
				System.out.println("You have "+chances+" chances left !! \n");
				System.out.println("Enter Account Number : ");
				accountNo = sc.nextInt();
				if(accountNo == userAccountNo )
				{
					return true;
				}
				chances--;
			}
			return false;
		}
	}


	
	public static boolean checchancesValidation()
	{
		boolean accountNumberStatus = checchancesAccountNumber();
		if(accountNumberStatus)
		{
			boolean pinStatus = checchancesPassword();
			if(pinStatus)
			{ return true; }
			else if(pinStatus == false && chances == 0)
			{ return false; }	
			else
			{ return false; }
		}
		else
		{
			return false;
		}
	}
}
	
  
public class atmMachine extends userBanchancesAcc
{   
	public static void withdraw(int amount)
	{    
	        //checchances whether the balance is greater than or equal to the withdrawal amount  
	        if(balance >= amount)  
	        {  
	            //remove the withdrawl amount from the total balance  
	            balance = balance - amount;  
	            System.out.println("\nPlease collect your money\n");
		    transactionHist.add("Withdrawn : "+amount+" \tCurrent Balance : "+balance);
		}
	        else  
	        {    
	            System.out.println("\nInsufficient Balance\n\n");
	        }  
	}
	
	
	
	public static void deposit(int amount)
	{
		//add the deposit amount to the total balanace  
	        balance = balance + amount;  
	        System.out.println("\nYour Money has been successfully depsited\n\n");
		transactionHist.add("Deposit : "+amount+" \tCurrent Balance : "+balance);

	}

	
	public static void transactionHistory()
	{
		System.out.println("\n---- Transaction History ----\n");
		if(transactionHist.size() == 0)
		{
			System.out.println("No Transaction History.");
		}
		for(int i=0 ;i<transactionHist.size();i++)
		{
			System.out.println(transactionHist.get(i));
		}
	}
	
	public static void checkBalance()
	{
		//displaying the total balance of the user  
        	System.out.println("\n\nBalance : "+balance); 
	}
	
	
    	public static void main(String args[] )  
    	{  
		Scanner sc = new Scanner(System.in);
        	int amount;
		System.out.println("\n--- Welcome to ATM Machine ---\n");
        	boolean loop = checchancesValidation();
		
		if( loop == false)
		{
			System.out.println("Sorry Your Account is blocchancesed !!!");
			System.out.println("Try After 24 hours or Contact to Banchances.");
		}
		else
		{
			System.out.println("\nWelcome Account Number : "+userAccountNo);
			while(loop)  
			{  
				
				System.out.println("\nAutomated Teller Machine");  
				System.out.println("1 for Withdraw");  
				System.out.println("2 for Deposit");  
				System.out.println("3 for Check Balance"); 
				System.out.println("4 for Transaction History"); 
				System.out.println("5 for EXIT");  
				System.out.print("Choose the operation you want to perform:");  
				  
				//get choice from user  
				int choice = sc.nextInt(); 
				switch(choice)  
				{  
					case 1:
						System.out.print("Enter money to be withdrawn:");  
						amount = sc.nextInt(); 
						withdraw(amount);   
						break;
	   
					case 2:  
						System.out.print("Enter money to be deposited:");   
						amount = sc.nextInt();  
						deposit(amount);
						break;  
	   
					case 3:
						checkBalance();
						break;  

					case 4:
						transactionHistory();
						break;

					case 5: 
						loop = false;
						System.out.println("\n\nHave a Nice Day !!!!! :) ");
						break;

					default:
						System.out.println("You have choose wrong operation");
						System.out.println("Try Again\n");
				}
				System.out.println();
			}  
		}
		sc.close();
    	}  
}  
