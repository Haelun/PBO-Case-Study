import java.util.ArrayList;

public class BankDemo {
    public static void main(String[] args) {

        Bank rekening1 = new SavingsAccount(100000);

        System.out.println("Welcome to BANK ABC");
        System.out.println("Current balance: Rp." + rekening1.getBalance());

        System.out.println("Withdraw: Rp.150000");
        rekening1.withdraw(150000);
        System.out.println("Balance rekening1 = Rp." + rekening1.getBalance());

        System.out.println("Deposit: Rp.500000");
        rekening1.deposit(500000);
        System.out.println("Balance rekening1 = Rp." + rekening1.getBalance());

        System.out.println("\nUsing Array of Bank accounts");

        Bank[] accountsArray = {
                new SavingsAccount(100000),
                new CheckingAccount(250000),
                new SavingsAccount(50000)
        };

        for (int i = 0; i < accountsArray.length; i++) {
            System.out.println("Account[" + i + "] balance: Rp." + accountsArray[i].getBalance());
        }

        Bank.depositAll(accountsArray, 20000);

        System.out.println("After depositing Rp.20000 into each account:");
        for (int i = 0; i < accountsArray.length; i++) {
            System.out.println("Account[" + i + "] balance: Rp." + accountsArray[i].getBalance());
        }

        System.out.println("\nUsing ArrayList of Bank accounts");

        ArrayList<Bank> accountsList = new ArrayList<>();
        accountsList.add(new SavingsAccount(300000));
        accountsList.add(new CheckingAccount(75000));
        accountsList.add(new SavingsAccount(120000));

        for (int i = 0; i < accountsList.size(); i++) {
            System.out.println("accountsList[" + i + "] balance: Rp." + accountsList.get(i).getBalance());
        }

        Bank.withdrawAll(accountsList, 50000);

        System.out.println("After withdrawing Rp.50000 from each account:");
        for (Bank account : accountsList) {
            System.out.println("Balance: Rp." + account.getBalance());
        }

        int total = Bank.totalBalance(accountsList);
        System.out.println("Total balance in ArrayList accounts: Rp." + total);

        accountsList.remove(accountsList.size() - 1);
        System.out.println("Number of accounts remaining after removal: " + accountsList.size());
    }
}