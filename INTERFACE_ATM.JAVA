import java.util.Scanner;

class ICICI_BANK {
    String name;
    String username;
    String password;
    String accountNo;
    float balanace = 100000f;
    int Transactions = 0;
    String transactionHistory = "";

    public void register() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\nEnter your Name :-");
        this.name = sc.nextLine();
        System.out.println("\nEnter your Username :-");
        this.username = sc.nextLine();
        System.out.println("\nEnter your Password :-");
        this.password = sc.nextLine();
        System.out.println("\nEnetr Your Account Number :-");
        this.accountNo = sc.nextLine();
        System.out.println("\n Registration Completed... Now You Can Login...");

    }

    public boolean Login() {
        boolean isLogin = false;
        Scanner sc = new Scanner(System.in);
        while (!isLogin) {
            System.out.println("\nEnter Your Username :- ");
            String Username = sc.nextLine();
            if (Username.equals(Username)) {
                while (!isLogin) {
                    System.out.println("\nEnter Your Password :- ");
                    String Password = sc.nextLine();
                    if (Password.equals(password)) {
                        System.out.println("\nLogin Successful!!");
                        isLogin = true;
                    } else {
                        System.out.println("\nIncorrect Password");
                    }
                }
            } else {
                System.out.println("\nUsername not found");
            }
        }
        return isLogin;

    }

    public void withdraw() {

        System.out.println("\nEnter amount to withdraw");
        Scanner sc = new Scanner(System.in);
        float amount = sc.nextFloat();
        try {

            if (balanace >= amount) {
                Transactions++;
                balanace -= amount;
                System.out.println("\nWithdraw Successfully");
                String str = amount + "Rs withdraw\n";
                transactionHistory = transactionHistory.concat(str);

            } else {
                System.out.println("\nInsufficient Balance");
            }
        } catch (Exception e) {

        }

    }

    public void deposit() {

        System.out.println("\nEnter amount to deposit :- ");
        Scanner sc = new Scanner(System.in);
        float amount = sc.nextFloat();

        try {
            if (amount <= 100000f) {
                Transactions++;
                balanace += amount;
                System.out.println("\nSuccessfully Deposited");
                String str = amount + " Rs deposited\n ";
                transactionHistory = transactionHistory.concat(str);

            } else {
                System.out.println("\nSorry...Limit is 100000.00");
            }
        } catch (Exception e) {

        }
    }

    public void transfer() {

        Scanner sc = new Scanner(System.in);
        System.out.println("\nEnter Receipent's Name :-");
        String receipent = sc.nextLine();
        System.out.println("\nEnter amount to transfer :- ");
        float amount = sc.nextFloat();

        try {
            if (balanace >= amount) {
                if (amount <= 50000f) {
                    Transactions++;
                    balanace -= amount;
                    System.out.println("\nSuccessfully Transfered to" + receipent);
                    String str = amount + " Rs transfered to " + receipent + "\n";
                    transactionHistory = transactionHistory.concat(str);

                } else {
                    System.out.println("\nSorry...Limit is 50000.00");
                }
            } else {
                System.out.println("\nInsufficient Balance");
            }
        } catch (Exception e) {

        }
    }

    public void checkBalance() {
        System.out.println("\n" + balanace + "Rs");
    }

    public void transactionHistory() {
        if (Transactions == 0) {
            System.out.println("\n Empty ");
        } else {
            System.out.println("\n" + transactionHistory);
        }
    }

}

public class INTERFACE_ATM {
    public int takeIntegerInput(int limit) {
        int input = 0;
        boolean flag = false;

        while (!flag) {
            try {
                Scanner sc = new Scanner(System.in);
                input = sc.nextInt();
                flag = true;

                if (flag && input > limit || input < 1) {
                    System.out.println("Choose the number between 1 to " + limit);
                    flag = false;

                }
            } catch (Exception e) {
                System.out.println("Enter only integer value");
                flag = false;
            }
        }
        ;
        return input;
    }

    public static void main(String[] args) {

        System.out.println("\n * WELCOME TO ATM SYSTEM *\n");
        System.out.println("1.Register \n2.Exit");
        System.out.println("Enter your Choice :- ");
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();

        if (choice == 1) {
            ICICI_BANK b = new ICICI_BANK();
            b.register();
            while (true) {
                System.out.println("\n1.Login \n2.Exit");
                System.out.println(" Enter Your Choice :-");
                int ch = sc.nextInt();

                if (ch == 1) {
                    if (b.Login()) {
                        System.out.println("\n\n * Welcome Back *" + b.name + "*\n");
                        boolean isFinished = false;
                        while (!isFinished) {
                            System.out.println(
                                    "\n1.Withdraw \n2.Deposit \n3.Transfer \n4.Check Balance \n5.transaction History");
                            System.out.println("\n Enter Your Choice :- ");
                            int c = sc.nextInt();

                            switch (c) {
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
                                    isFinished = true;
                                    break;
                            }
                        }
                    }
                } else if (choice == 2) {
                    System.exit(0);
                } else {
                    System.out.println("\n Please choice 1 or 2");
                }
            }
        } else if (choice == 2) {
            System.exit(0);
        } else {
            System.out.println("\n please Enter 1 or 2");
        }
    }
}