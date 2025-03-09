package TASK;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

@SuppressWarnings("resource")
class BankAccount{
    String name, userName, password, accountNo;
    float balance = 10000f;
    int transactions = 0;
    String transactionHistory = "";

    private String getCurrentTimestamp() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return now.format(formatter);
    }
//Registration class..........................................
    public void register(){
        Scanner sc = new Scanner(System.in);
        System.out.println("\nEnter your Name: ");
        this.name = sc.nextLine();
        System.out.println("\nEnter Username: ");
        this.userName = sc.nextLine();
        System.out.println("\nEnter your Password: ");
        this.password = sc.nextLine();
        System.out.println("\nEnter your Account Number: ");
        this.accountNo = sc.nextLine();
        System.out.println("\nRegistration Successful!-----");
        System.out.println("Please login to your Account");
    }
    public boolean login(){
        boolean isLogin = false;
        Scanner sc = new Scanner(System.in);
        while( !isLogin){
            System.out.println("\nEnter you username: ");
            String Username = sc.nextLine();
            if(Username.equals(userName)){
                while(!isLogin){
                    System.out.println("\nEnter your password: ");
                    String Password = sc.nextLine();
                    if(Password.equals(password)){
                        System.out.println("\nLogin Successful\n");
                        isLogin = true;
                    }
                    else{
                        System.out.println("\nIncorrect Password\n");
                    }
                }
            }
            else{
                System.out.println("\nUsername not matched");
            }
        }
        return isLogin;
    }
//Withdraw Money ......................................................
    public void withdraw(){
        System.out.println("\nEnter Amount to Withdraw: ");
        Scanner sc = new Scanner(System.in);
        float amount = sc.nextFloat();
            if(balance>= amount){
                transactions++;
                balance -= amount;
                System.out.println("\nWithdraw Successful.\n");
                transactionHistory += getCurrentTimestamp()+ " - Rs." +amount+ "Withdraw\n";
            }
            else{
                System.out.println("Insufficient Balance.");
            }
    }
//Deposit Money.............................................................
    public void deposit(){
        System.out.println("\nEnter Amount to Deposit: ");
        Scanner sc = new Scanner(System.in);
        float amount = sc.nextFloat();
        try{
            if(amount <= 50000f){
                transactions++;
                balance += amount;
                System.out.println("\nDeposit Successfully.\n");
                transactionHistory += getCurrentTimestamp() + " - Rs." + amount + " Deposited\n";
            }
            else{
                System.out.println("Sorry! The limit is 50000\n");
            }
        }
        catch(Exception e){
            
        }
    }
//Transfer Money................................................................
    public void transfer(){
        Scanner sc = new Scanner(System.in);
        System.out.println("\nEnter Receipent's Name: ");
        String recipient = sc.nextLine();
        System.out.println("\nEnter amount to transfer:");
        float amount = sc.nextFloat();
        try{
            if(balance>= amount){
                if(amount <= 50000f){       //transfer limit
                    transactions++;
                    balance -= amount;
                    System.out.println("\nSuccessfully transfered "+amount+" to "+recipient+ "\n");
                    transactionHistory += getCurrentTimestamp() + " - Rs." + amount + " Transferred to " + recipient + "\n";
                }
                else{
                    System.out.println("Sorry! The limit exceeded 50000.\n");
                }
            }
            else{
                System.out.println("\nInsufficient Balance!\n");
            }
        }
        catch(Exception e){      
        }
    }
//Check Balance in your account.....................................................
    public void checkBalance(){
        System.out.println("\nYour current balance is:"+balance+"\n");
    }
// Transaction history of your account..............................................
    public void transactionHistory(){
        if(transactions == 0){
            System.out.println("No Transactions Until Yet.");
        }
        else{
            System.out.println("\n-----Transaction History-----");
            System.out.println(transactionHistory);
        }
    }
//Change password...............................................................
    public void changePassword() {
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter Current Password: ");
        String oldPassword = sc.nextLine();
    
        if (!oldPassword.equals(password)) {
            System.out.println("Incorrect Password! Returning to main menu.");
            return;
        }
    
        System.out.print("Enter New Password: ");
        String newPassword = sc.nextLine();
    
        System.out.print("Confirm New Password: ");
        String confirmPassword = sc.nextLine();
    
        if (newPassword.equals(confirmPassword) && newPassword.length() >= 4) {
            password = newPassword;
            System.out.println("Password Changed Successfully!");
        } else {
            System.out.println("Password Change Failed! Ensure both entries match and have at least 4 characters.");
        }
    }
    
}
//Main class ...................................................................
public class ATM{
    public static int takenIntegerInput(int limit){
        int input = 0;
        boolean flag = false;

        while(!flag){
            try{
                @SuppressWarnings("resource")
                Scanner sc = new Scanner(System.in);
                input = sc.nextInt();
                flag = true;

                if(flag && input>limit || input<1){
                    System.out.println("Choose number between 1 to"+limit);
                    flag=false;
                }
            }
            catch(Exception e){
                System.out.println("Enter only integer value.");
                flag=false;
            }
        }
        return input;
    }

    public static void main(String args[]){
        System.out.println("\n-----------WELCOME TO ATM-----------\n");
        System.out.println("1.Register \n2.Exit");
        System.out.println("Choose one option: ");
        int choose = takenIntegerInput(2);

        if(choose == 1){
            BankAccount b = new BankAccount();
            b.register();
            while(true){
                System.out.println("1.Login \n2.Exit");
                System.out.println("Enter your choice: ");
                int ch = takenIntegerInput(2);
                if(ch == 1){
                    if(b.login()){
                        System.out.println("\n----"+b.name+" LOGGED-IN SUCCESSFULLY!----\n");
                        boolean isFinished = false;
                        while(!isFinished){
                            System.out.println("1.Withdraw \n2.Deposit \n3.Transfer \n4.Check Balance \n5.Transaction History \n6.Change Password \n7.Exit");
                            System.out.println("Enter your choice: ");
                            int c = takenIntegerInput(7);
                            switch(c){
                                case 1: 
                                    b.withdraw();
                                    break;
                                case 2:
                                    b.deposit();
                                    break;
                                case 3:
                                    b.transfer();
                                    break;
                                case 4:
                                    b.checkBalance();
                                    break;
                                case 5:
                                    b.transactionHistory();
                                    break;
                                case 6:
                                    b.changePassword();
                                    break;
                                case 7: 
                                    isFinished = true;
                                    break;
                            }
                        }
                    }
                }
                else{
                    System.exit(0);
                }
            }
        }
        else{
            System.exit(0);
        }
    }
}
