import java.util.Scanner;

public static int sum_elements(int[] arr, int index ){

    int sum = 0;
    if(index == 0){
        sum = sum + arr[0];
        return sum;
    } else{
        sum = arr[index] + sum_elements(arr, index - 1);
    }
    return sum;
}

void main(){

    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int arr[] = new int[n];
    for(int i = 0; i < n; i++){
        arr[i] = sc.nextInt();
    }
    float sum = sum_elements(arr, n - 1);
    float avg = sum / n;
    System.out.println(avg);
}