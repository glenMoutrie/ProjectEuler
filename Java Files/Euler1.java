public class Euler1 {
    public static void main(String args[]) {
        int[] factors = {3,5};
        int summation = -1;
        for(int i = 1; i < 999; i++) {
            if (i%factors[0]==0) {
                summation += i;
            } else if (i%factors[1]==0) {
                summation += i;
            }
        }
        System.out.println(summation);
    }

}
