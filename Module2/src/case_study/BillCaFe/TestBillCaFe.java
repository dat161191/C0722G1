package case_study.BillCaFe;

import java.util.Scanner;

public class TestBillCaFe {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Nhập loại cafe bạn muốn mua: ");
        String nameCF = input.nextLine();
        System.out.print("Nhập số lượng bạn muốn mua: ");
        double mass = Double.parseDouble(input.nextLine());
        System.out.print("Nhập giá cf/1kg: ");
        double prince = Double.parseDouble(input.nextLine());
        BillCaFe bill1 = new BillCaFe(nameCF, mass, prince);
        System.out.println(bill1.toString());
    }
}
