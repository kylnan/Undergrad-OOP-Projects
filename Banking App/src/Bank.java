import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class Bank {
    private static final Scanner sc = new Scanner(System.in);
    private static final HashMap<String, BankAccount> accounts = new HashMap<>();
    public static void main (String[] arg) {

        int menuSelect;


        while (true) {
            /* menu section */
            System.out.println("*** Menu ***");
            System.out.println("1. Create Account");
            System.out.println("2. Display");
            System.out.println("3. Withdraw");
            System.out.println("4. Deposit");
            System.out.println("5. Display All");
            System.out.println("6. Remove Account");
            System.out.println("7. Exit");

            System.out.print("Enter your choice: ");
            menuSelect = sc.nextInt();
            System.out.print("\n");
            String name;
            double balance;
            switch (menuSelect) {
                case 1 -> createAccount();
                case 2 -> {
                    System.out.print("Enter Account Name: ");
                    name = sc.next();
                    if(accounts.containsKey(name)){
                        accounts.get(name).display();
                    }
                    else{
                        System.out.println("Name : " + name + " does not exist\n");
                    }
                }

                case 3 -> {
                    System.out.println("** Transaction - Withdraw");
                    System.out.print("Enter Account Name: ");
                    name = sc.next();
                    if(accounts.containsKey(name)){
                        System.out.print("Enter the amount you would like to withdraw: ");
                        balance = sc.nextDouble();
                        accounts.get(name).withdraw(balance);
                        accounts.get(name).display();
                    }
                    else{
                        System.out.println("Name" + name + "does not exist\n");
                    }
                }
                case 4 -> {
                    System.out.println("** Transaction - Deposit");
                    System.out.print("Enter Account Name: ");
                    name = sc.next();
                    if(accounts.containsKey(name)){
                        System.out.print("Enter the amount you would like to deposit: ");
                        balance = sc.nextDouble();
                        accounts.get(name).deposit(balance);
                        accounts.get(name).display();
                    }
                    else{
                        System.out.println("Name" + name + "does not exist\n");
                    }
                }
                case 5 -> displayAll();
                case 6 -> {
                    System.out.print("Enter Account Name: ");
                    name = sc.next();
                    remove(name);
                }
                case 7 -> {
                    System.out.println("Thank you for banking with us!");
                    sc.close();
                    System.exit(0);
                }
            }
        }
    }

    public static void createAccount(){
        String accountName;
        double balance = 0;
        boolean inputError = true;

        System.out.println("** Create New Account **");
        System.out.print("Enter name: ");
        accountName = sc.next();

            try {
                System.out.print("Starting Balance: ");
                balance = sc.nextDouble();
                inputError = false;
                System.out.println("Account Created!!");
            }
            catch (InputMismatchException e) {
                System.out.println("Invalid input, please input a proper numerical value for balance");
                sc.next();
            }
        if(!inputError){
            accounts.put(accountName, new BankAccount(accountName, balance));
        }
    }

    public static void displayAll(){
        System.out.println("Bank Account Details");
        accounts.forEach(((s, bankAccount) -> System.out.println("Name: " + s + "\t\t" + "Balance: " + bankAccount.getBalance())));
    }

    public static void remove(String key){
        accounts.remove(key);
        System.out.println("Account Removed!");
    }
}
