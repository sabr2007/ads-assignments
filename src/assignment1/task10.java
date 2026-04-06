import java.util.Scanner;

public static int gcd(int a, int b){

    if(b == 0){
        return a;
    } else {
        return gcd(b, a % b);
    }
}

void main(){
    Scanner sc = new Scanner(System.in);

    int a = sc.nextInt();
    int b = sc.nextInt();
    System.out.println(gcd(a, b));
}