package exercise_HotelManager;



import java.util.ArrayList;
import java.util.Scanner;

class Test {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n;	// số khách trọ
        Hotel hotel;

        // tạo 1 ArrayList lưu thông tin khách trọ
        ArrayList<Hotel> arrHotel = new ArrayList<>();

        System.out.println("Nhập số lượng khách trọ: ");
        n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            hotel = new Hotel();
            System.out.println("Nhập thông tin khách hàng thứ " + (i+1) + ":");
            hotel.inputManagementInformation();
            arrHotel.add(hotel);
        }

        // hiển thị danh sách khách trọ
        for (int i = 0; i < arrHotel.size(); i++) {
            System.out.println("\nThông tin khách hàng thứ " + (i+1) + ": ");
            arrHotel.get(i).displayManagementInformation();
        }

        // tính tiền phòng khi khách hàng trả phòng
        System.out.println("\nNhập số chứng minh nhân dân của khách trả phòng: ");
        String tim = scanner.nextLine();
        for (int i = 0; i < arrHotel.size(); i++) {
            if (arrHotel.get(i).getHuman().getIdCard().equalsIgnoreCase(tim)) {
                System.out.println("Số tiền phòng = " + arrHotel.get(i).totalMoney());
            }
        }
    }

}