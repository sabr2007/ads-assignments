package assignment2;
import java.util.Queue;
import java.util.Stack;
import java.util.Scanner;
import java.util.LinkedList;



class BankAccount {

    int accountNumber;
    String username;
    int balance;
    BankAccount next;

    public BankAccount(int accountNumber, String username, int balance) {
        this.accountNumber = accountNumber;
        this.username = username;
        this.balance = balance;
    }

}


class Mylinkedlist {
    BankAccount head;
    Stack<String> history = new Stack<>();
    Queue<String> billQueue = new LinkedList<>();
    Queue<BankAccount> accountRequests = new LinkedList<>();

    void addAccount(BankAccount account) {
        account.next = head;
        head = account;
        System.out.println("account added: " + account.username);
    }

    void displayAllAccounts() {

        BankAccount current = head;
        int i = 1;
        System.out.println("account List: ");
        while (current != null) {
            System.out.println(i + ". " + current.username + ": " + current.balance);
            current = current.next;
            i++;
        }
    }

    void searchAccount(String username) {

        BankAccount current = head;
        while (current != null) {
            if (current.username.equals(username)) {
                System.out.println("account found: " + current.username + " balance: " + current.balance);
                return;
            }
            current = current.next;
        }
        System.out.println("account not found");
    }

    void depositMoney(String username, int amount) {

        BankAccount current = head;
        while (current != null) {
            if (current.username.equals(username)) {
                current.balance = current.balance + amount;
                System.out.println("deposit successful " + current.username + ", " + current.balance);
                history.push("Deposit " + amount + " to " + username);
                return;
            }
            current = current.next;
        }
    }

    void withdrawMoney(String username, int amount) {

        BankAccount current = head;
        while (current != null) {
            if (current.username.equals(username)) {
                current.balance = current.balance - amount;
                System.out.println("withdraw successful " + current.username + ", " + current.balance);
                history.push("Withdraw " + amount + " from " + username);
                return;
            }
            current = current.next;
        }

    }

    void undo() {
        if (!history.isEmpty()) {
            String removed = history.pop();
            System.out.println("undo " + removed + " removed");
        }
    }

    void showLastTransaction() {
        if (!history.isEmpty()) {
            System.out.println("last transaction: " + history.peek());
        }
    }

    void addBill(String bill) {

        billQueue.add(bill);
        System.out.println("added: " + bill);
    }

    void processNextBill() {
        if (!billQueue.isEmpty()) {
            String bill = billQueue.poll();
            System.out.println("processing: " + bill);
        }
    }

    void displayQueue() {
        System.out.println("remaining: ");
        for (String bill : billQueue) {
            System.out.println(bill);
        }
    }

    void submitRequest(BankAccount account) {

        accountRequests.add(account);
        System.out.println("account added to processing");
    }

    void processRequest() {

        BankAccount account = accountRequests.poll();
        addAccount(account);
    }

    void displayPendingRequests() {
        System.out.println("in process: ");
        for (BankAccount account : accountRequests) {
            System.out.println("- " + account.username);
        }
    }
}



class main {

    static void bankMenu(Scanner sc, Mylinkedlist bank) {
        System.out.println("1 - Submit account request");
        System.out.println("2 - Deposit");
        System.out.println("3 - Withdraw");

        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                System.out.print("account number: ");
                int num = sc.nextInt();
                System.out.print("username: ");
                String name = sc.next();
                System.out.print("balance: ");
                int bal = sc.nextInt();
                bank.submitRequest(new BankAccount(num, name, bal));
                break;
            case 2:
                System.out.print("username: ");
                String depUser = sc.next();
                System.out.print("amount: ");
                int depAmount = sc.nextInt();
                bank.depositMoney(depUser, depAmount);
                break;
            case 3:
                System.out.print("username: ");
                String witUser = sc.next();
                System.out.print("amount: ");
                int witAmount = sc.nextInt();
                bank.withdrawMoney(witUser, witAmount);
                break;
        }
    }

    static void atmMenu(Scanner sc, Mylinkedlist bank) {
        System.out.println("1 - Balance enquiry");
        System.out.println("2 - Withdraw");

        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                System.out.print("username: ");
                String username = sc.next();
                bank.searchAccount(username);
                break;
            case 2:
                System.out.print("username: ");
                String witUser = sc.next();
                System.out.print("amount: ");
                int amount = sc.nextInt();
                bank.withdrawMoney(witUser, amount);
                break;
        }
    }

    static void adminMenu(Scanner sc, Mylinkedlist bank) {
        System.out.println("1 - View account requests");
        System.out.println("2 - Process account request");
        System.out.println("3 - View bill payment queue");
        System.out.println("4 - Process next bill");

        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                bank.displayPendingRequests();
                break;
            case 2:
                bank.processRequest();
                break;
            case 3:
                bank.displayQueue();
                break;
            case 4:
                bank.processNextBill();
                break;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Mylinkedlist mylinkedlist = new Mylinkedlist();


        while (true) {
            System.out.println("1 - Enter Bank");
            System.out.println("2 - Enter ATM");
            System.out.println("3 - Admin Area");
            System.out.println("4 - Exit");

            int choice = sc.nextInt();

            switch (choice) {
                case 1: bankMenu(sc, mylinkedlist); break;
                case 2: atmMenu(sc, mylinkedlist); break;
                case 3: adminMenu(sc, mylinkedlist); break;
                case 4: return;
            }
        }
    }

}


