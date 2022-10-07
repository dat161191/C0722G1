package case_study_module2.model.Booking;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Booking {
    private String codeBooking;
    private LocalDate startDay;
    private LocalDate endDay;
    private String codeCustomer;
    private String serviceCode;
    private String serviceType;

    public Booking() {
    }

    public Booking(String codeBooking, LocalDate startDay, LocalDate endDay, String codeCustomer, String serviceCode, String serviceType) {
        this.codeBooking = codeBooking;
        this.startDay = startDay;
        this.endDay = endDay;
        this.codeCustomer = codeCustomer;
        this.serviceCode = serviceCode;
        this.serviceType = serviceType;
    }

    public String getCodeBooking() {
        return codeBooking;
    }

    public void setCodeBooking(String codeBooking) {
        this.codeBooking = codeBooking;
    }

    public LocalDate getStartDay() {
        return startDay;
    }

    public void setStartDay(LocalDate startDay) {
        this.startDay = startDay;
    }

    public LocalDate getEndDay() {
        return endDay;
    }

    public void setEndDay(LocalDate endDay) {
        this.endDay = endDay;
    }

    public String getCodeCustomer() {
        return codeCustomer;
    }

    public void setCodeCustomer(String codeCustomer) {
        this.codeCustomer = codeCustomer;
    }

    public  String getServiceCode() {
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        this.serviceCode = serviceCode;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "codeBooking='" + codeBooking + '\'' +
                ", startDay=" + startDay.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) +
                ", endDay=" + endDay.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) +
                ", codeCustomer='" + codeCustomer + '\'' +
                ", serviceName='" + serviceCode + '\'' +
                ", serviceType='" + serviceType + '\'' +
                '}';
    }
}
