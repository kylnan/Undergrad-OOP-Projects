public class BankAccount {
    private final String name;
    private double balance;
    BankAccount(String newName, double newBalance) {
        name = newName;
        balance = newBalance;
    }

    public void display(){
        System.out.println("** Account Details **");
        System.out.println("Name: " + this.getName());
        System.out.println("Balance: " + this.getBalance() + "\n");
    }

    public void withdraw(double amount){
        double newBalance = balance - amount;
        setBalance(newBalance);
    }

    public void deposit(double amount){
        double newBalance = balance + amount;
        setBalance(newBalance);
    }

    public String getName(){
        return name;
    }

    public double getBalance(){
        return balance;
    }

    public void setBalance(double newBalance){
        balance = newBalance;
    }
}