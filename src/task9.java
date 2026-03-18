import java.util.Scanner;

public static int count_chars(String str){

    if(str.isEmpty()){
        return 0;
    } else {
        return 1 + count_chars(str.substring(1));
    }
}

void main(){

    Scanner sc = new Scanner(System.in);
    String str = sc.next();
    System.out.println(count_chars(str));
}