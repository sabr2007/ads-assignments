import java.util.Scanner;

public static int reverse(int[] arr, int n){

    if(n == 0){
        System.out.print(arr[0] + " ");
    } else {
        System.out.print(arr[n] + " ");
        return reverse(arr, n - 1);
    }
    return 0;
}

void main(){

    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] arr = new int[n];
    for(int i = 0; i < n; i++){
        arr[i] = sc.nextInt();
    }
    reverse(arr, n - 1);
}