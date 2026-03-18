import java.util.Scanner;

public static boolean check_digits(String str, int index){

    if(str.length() == index) return true;
    if(Character.isDigit(str.charAt(index))){
        return check_digits(str, index + 1);
    } else {
        return false;
    }
}

void main(){

    Scanner sc = new Scanner(System.in);
    String str = sc.next();
    System.out.println(check_digits(str, 0) ? "Yes" : "No");
}