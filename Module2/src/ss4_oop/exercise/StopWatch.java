package ss4_oop.exercise;

import java.util.Scanner;

public class StopWatch {
    static Scanner input = new Scanner(System.in);
    private long startTime;
    private long endTime;

    public StopWatch() {
    }
    public long getStartTime() {
        return startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public void start() {
        this.startTime = System.currentTimeMillis();
    }

    public void stop() {
        this.endTime = System.currentTimeMillis();
        System.out.println("thời gian đã chạy: " + getElapsedTime());
    }

    public long getElapsedTime() {
        return getEndTime() - getStartTime();

    }

    public static void main(String[] args) {
        StopWatch example = new StopWatch();
        while (true) {
            System.out.print("Nhập lựa chọn của bạn: \n" +
                    "1.Bắt đầu bấm giờ\n" + "2.Kết thúc bấm giờ\n" + "3.Thoát chương trình");

            int choice = Integer.parseInt(input.nextLine());
            switch (choice) {
                case 1:
                    example.start();
                    break;
                case 2:
                    example.stop();
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("Nhập sai rồi!Vui lòng nhập lại");
            }
        }
    }
}



