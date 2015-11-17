import java.util.*;

public class Euler2{
    public static long sumFib(long max) {
        long previous, next, current, total;
        previous = 1;
        current = 2;
        total = previous + current;
        do {
            next = previous + current;
            previous = current;
            current = next;
            total = total + current;
        } while (current<max);
        return current;
    }
    
    public static void main(String args[]){
        long maximum, result;
        int number, power;
        
        Scanner keyboard = new Scanner(System.in);
        System.out.println("To what number and power do you want to calculate...\n (the question asks for 4*10^6)");
        number = keyboard.nextInt();
        power = keyboard.nextInt();
        //maximum = number*(10^power);
        maximum = 4000000;
        System.out.println(maximum);
        
        result = sumFib(maximum);
        System.out.println(result);
    }
}