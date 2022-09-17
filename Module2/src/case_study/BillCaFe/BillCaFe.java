package case_study.BillCaFe;

import java.util.Scanner;

public class BillCaFe {
    private String nameCaFe;
    private double price1kg;
    private double massCaFe;

    BillCaFe() {
    }

    BillCaFe(String nameCaFe, double massCaFe, double price1kg) {
        this.nameCaFe = nameCaFe;
        this.massCaFe = massCaFe;
        this.price1kg = price1kg;
    }

    public double getPrice1kg() {
        return price1kg;
    }

    public double getMassCaFe() {
        return massCaFe;
    }

    public double totalMoney() {
        return this.price1kg * this.massCaFe;
    }

    public boolean checkMass(double kl) {
        return this.massCaFe > kl;
    }

    public boolean checkTotalMoney() {
        return this.totalMoney() > 500000;
    }

    public double discount() {
        if (this.checkTotalMoney()) {
            return totalMoney() * 5 / 100;
        } else {
            return 0;
        }
    }

    public double moneyAfterDiscount() {
        return totalMoney() - discount();
    }

    @Override
    public String toString() {
        return "BillCaFe{" +
                "nameCaFe='" + nameCaFe + '\'' +
                ", price1kg=" + price1kg +
                ", massCaFe=" + massCaFe + ", total money= " + moneyAfterDiscount() + " VND" +
                '}';
    }
}




//
//    public static class Test {
//        public static void main(String[] args) {
//            Scanner input = new Scanner(System.in);
//            System.out.print("Nhập loại cafe bạn muốn mua: ");
//            String nameCF = input.nextLine();
//            System.out.print("Nhập số lượng bạn muốn mua: ");
//            double mass = input.nextDouble();
////            double mass = Integer.parseInt(input.nextLine());
//            System.out.print("Nhập giá cf/1kg: ");
//            double prince = input.nextDouble();
////            double prince = Integer.parseInt(input.nextLine());
//            BillCaFe bill1 = new BillCaFe(nameCF, mass, prince);
//            System.out.println(bill1.toString());
//        }
//    }
//}

