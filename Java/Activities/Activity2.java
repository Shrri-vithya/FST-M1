package activities;

public class Activity2 {
    public static void main(String[] args) {
        int[] num = {10, 77, 10, 54, -11, 10};
        int res = 0, i = 0;

        System.out.println(result(num, res, i));
    }

     public static boolean result(int[] num1,int res1,int i1){
            for (i1 = 0; i1 < num1.length; i1++) {
                if (num1[i1] / 10 == 1) {
                    res1 += num1[i1];
                }
            }
            return res1 == 30;
        }
}
