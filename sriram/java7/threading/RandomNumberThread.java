package threading;

import java.util.Random;

public class RandomNumberThread extends Thread {
    Random num = new Random();
    int value;

    @Override
    public void run() {
        while (true) {
            try {
                this.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            value = num.nextInt(1000);
            System.out.println("RandomNumberThread generated a number " + value);
            if (value % 2 == 0) {
                new SquareGenThread(value).start();
            } else {
                new CubeGenThread(value).start();
            }
        }
    }
}
