package LearnJavaKatyBert.Thread;

public class ThreadRaceNFC  {
    public static void main(String[] args) {
        Runnable runnable1 = new Thread1();
        Runnable runnable2 = new Thread1();
        Thread thread1 = new Thread(runnable1);
        Thread thread2 = new Thread(runnable2);

        thread1.start();
        thread2.start();





    }

     static class Thread1 implements Runnable{
        @Override
        public void run() {
            for (int i = 1; i < 100 ; i++) {
                System.out.println("Поток  " + i);
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

}
