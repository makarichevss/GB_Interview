package HW3.task1;

public class PingPong {
    private String startStatus = "pong";

    private synchronized void action(String currentStatus){
        while (true){
            if (startStatus.equals(currentStatus)){
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println(currentStatus);
                startStatus = currentStatus;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                notify();
            }
        }
    }

    public static void main(String[] args) {
        PingPong pingPong = new PingPong();
        new Thread(() -> pingPong.action("ping")).start();
        new Thread(() -> pingPong.action("pong")).start();
    }
}
