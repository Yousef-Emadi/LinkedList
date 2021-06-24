import Archive.LinkedList1;

public class sandbox {

    public static double twoInPower(int n){

        if (n==1) return 2;
        else return 2*twoInPower(n-1);

    }
/*
    0 1 1 2 3 5 8 13 21
    0 1 2 3 4 5 6 7  8
  */
    public static int fibo(int index){
        if (index == 0) return 0;
        if (index == 1) return 1;
        return fibo(index-1) + fibo(index-2);
    }

    public static boolean isPolindrome(String str){
        int head = 0;
        int tail = str.length()-1;

        while (head < tail) {
            if (str.charAt(head) != str.charAt(tail)) return false;
            head++;
            tail--;
        }
        return true;
    }


    public static boolean isIncludingPolindrome(String str){

        for (int i = 0; i < str.length(); i++){
            int j = 2;
            for (j = j+i ; j < str.length() ; j++){
               if(isPolindrome(str.substring(i,j))) return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {



    }
}
