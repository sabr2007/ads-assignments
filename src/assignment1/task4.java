import java.util.Scanner;

public static int fact(int n){

    if(n == 0 || n == 1)
        return 1;
    else{
        return n * fact(n - 1);
    }
}

void main(){

    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    System.out.println(fact(n));
}
