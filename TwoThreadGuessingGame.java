import java.util.Random;
import java.util.Scanner;

public class TwoThreadGuessingGame implements Runnable {
    public int guessNumber;

    public TwoThreadGuessingGame(int num){
        this.guessNumber = num;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("User enter a number: ");

        int result = sc.nextInt();
        TwoThreadGuessingGame obj = new TwoThreadGuessingGame(result);
        
        Thread thread1 = new Thread(obj);
        Thread thread2 = new Thread(obj);


        thread1.setName("thread so 1");
        thread2.setName("thread so 2");
        thread1.start();
        thread2.start();
    }

    public void run(){
        Random r = new Random();
        int low = 1;
        int high = 10;
        int guessingNumber = r.nextInt(high - low) + low;

        int counter = 0;
        
        
        try {
            while (guessingNumber != this.guessNumber){
                guessingNumber = r.nextInt(high - low) + low;
                System.out.println(Thread.currentThread().getName() + " is guessing number "
                + guessingNumber);
                counter++;
            }
        } 
        finally {
            System.out.println("After " + counter + " times, "
            + Thread.currentThread().getName() + " guess the right number.");
        }
    }

   
}
