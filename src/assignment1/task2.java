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
public static void fillArray(int[] arr, int index, Scanner scanner) {
    if (index == arr.length) return; // базовый случай

    arr[index] = scanner.nextInt();
    fillArray(arr, index + 1, scanner); // рекурсия
}

public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();

    int[] arr = new int[n];
    fillArray(arr, 0, sc);

    System.out.println(sum_elements(arr, 0));
}