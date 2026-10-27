import java.util.ArrayList;

public abstract class Bank {

    protected int balance;

    public Bank() {
        this.balance = 0;
    }

    public Bank(int balance) {
        this.balance = balance;
    }

    public int getBalance() {
        return this.balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int deposit(int amount) {
        this.balance = this.balance + amount;
        return this.balance;
    }

    public abstract int withdraw(int amount);

    public static void depositAll(Bank[] accounts, int amount) {
        for (Bank account : accounts) {
            account.deposit(amount);
        }
    }

    public static void depositAll(ArrayList<Bank> accounts, int amount) {
        for (Bank account : accounts) {
            account.deposit(amount);
        }
    }

    public static void withdrawAll(Bank[] accounts, int amount) {
        for (Bank account : accounts) {
            account.withdraw(amount);
        }
    }

    public static void withdrawAll(ArrayList<Bank> accounts, int amount) {
        for (Bank account : accounts) {
            account.withdraw(amount);
        }
    }

    public static int totalBalance(Bank[] accounts) {
        int total = 0;
        for (Bank account : accounts) {
            total += account.getBalance();
        }
        return total;
    }

    public static int totalBalance(ArrayList<Bank> accounts) {
        int total = 0;
        for (Bank account : accounts) {
            total += account.getBalance();
        }
        return total;
    }
}

class SavingsAccount extends Bank {

    public SavingsAccount(int balance) {
        super(balance);
    }

    @Override
    public int withdraw(int amount) {
        if (amount > this.balance) {
            System.out.println("Withdrawal rejected: U dont have enough money in ur account man.");
            return this.balance;
        }
        this.balance = this.balance - amount;
        return this.balance;
    }
}

class CheckingAccount extends Bank {

    private static final int FEE = 2500;

    public CheckingAccount(int balance) {
        super(balance);
    }

    @Override
    public int withdraw(int amount) {
        if (amount + FEE > this.balance) {
            System.out.println("Withdrawal rejected: Not enough balance to cover amount + Rp." + FEE + " fee.");
            return this.balance;
        }
        this.balance = this.balance - (amount + FEE);
        return this.balance;
    }
}