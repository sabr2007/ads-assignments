import java.util.Scanner;

public static boolean is_prime(int n, int divisor){

    if(n == divisor)
        return true;
    if(n % divisor == 0) {
        return false;
    } else {
        return is_prime(n, divisor + 1);
    }
}

void main(){

    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    System.out.println(is_prime(n, 2) ? "Prime" : "Composite");
}
