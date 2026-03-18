import java.util.Scanner;

public static void printDigits(int n){

    if(n < 10){
        System.out.println(n);
    } else {
        printDigits(n / 10);
        System.out.println(n % 10);
    }
}

void main() {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    printDigits(n);
}
