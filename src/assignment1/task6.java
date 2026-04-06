import java.util.Scanner;

public static int power(int a, int n) {

    if (n == 0) return 1;
    else{
        return a * power(a, n - 1);
    }
}

void main(){

    Scanner sc = new Scanner(System.in);
    int a = sc.nextInt();
    int n = sc.nextInt();
    System.out.println(power(a, n));
}