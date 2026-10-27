# PBO-Case-Study
## Name : Nyoman Adhi Dhira Purnomo
## NIM : F1D02410132

# Bank ABC - OOP Case Study (Abstract Class, Interface, Inheritance & Polymorphism)

## OOP Concepts Implemented

### 1. Interface (`Transaction.java`)
* **`Transaction`** is an interface that defines the core contract for all bank transactions: `deposit(int amount)` and `withdraw(int amount)`.
* Any class implementing `Transaction` must provide concrete implementations for these methods.

### 2. Abstract Class & Abstract Method (`Bank.java`)
* **`Bank`** is an abstract class (`public abstract class Bank implements Transaction`) that holds shared attributes (`balance`, `accountName`) and common behaviors (`deposit`, getters/setters, and batch processing methods).
* Because `Bank` is abstract, it cannot be instantiated directly (`new Bank()` is prevented).
* **`displayAccountInfo()`** is an **abstract method** (`public abstract void displayAccountInfo();`). It has no body in `Bank`, forcing every subclass to define how its specific account details are displayed.

### 3. Inheritance (`SavingsAccount.java` & `CheckingAccount.java`)
* Both **`SavingsAccount`** and **`CheckingAccount`** inherit from `Bank` using the `extends` keyword.
* They reuse the fields (`balance`, `accountName`), constructors (via `super(...)`), and methods (`deposit()`, `getBalance()`) defined in `Bank` without rewriting code.

### 4. Polymorphism
This project demonstrates both types of polymorphism:
* **Runtime Polymorphism (Method Overriding & Dynamic Dispatch):**
  * `SavingsAccount` overrides `withdraw()` to enforce a minimum balance of Rp. 20,000.
  * `CheckingAccount` overrides `withdraw()` to deduct an administrative fee of Rp. 2,500 per withdrawal.
  * In `BankDemo.java`, a single `Bank[]` array and `ArrayList<Bank>` hold both `SavingsAccount` and `CheckingAccount` objects. Calling `Bank.withdrawAll(...)` or `acc.displayAccountInfo()` automatically executes the correct subclass method at runtime.
* **Compile-Time Polymorphism (Method & Constructor Overloading):**
  * `Bank` overloads its constructors (`Bank()` and `Bank(String, int)`).
  * `depositAll()`, `withdrawAll()`, and `totalBalance()` are overloaded to accept either a standard array (`Bank[]`) or a generic list (`ArrayList<Bank>`).
