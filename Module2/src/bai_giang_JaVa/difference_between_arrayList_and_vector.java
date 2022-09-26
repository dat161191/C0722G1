package bai_giang_JaVa;

public class difference_between_arrayList_and_vector {
    /*  ArrayList và Vector cả hai được impements giao diện List và duy trì thứ tự chèn của các phần tử.
        Tuy nhiên, có vài sự khác nhau giữa ArrayList và Vector được đưa ra dưới đây:
        1) ArrayList là không synchronized.
        +Vector là synchronized.
        2) ArrayList tăng 50% kích thước hiện tại nếu số phần tử vượt quá khả năng chứa của nó.
        +Vector tăng 100% nghĩa là tăng gấp đôi kích thước hiện tại nếu số phần tử vượt quá khả năng chứa của nó.
        3) ArrayList không là một lớp legacy, nó được tạo ra từ phiên bản JDK 1.2.
        +Vector là một lớp lớp legacy.
        4) ArrayList là nhanh hơn vì nó là non-synchronized.
        +Vector là chậm hơn ví nó là synchronized.Tức là, trong môi trường đa luồng,
         các thread giữ nó ở trong trạng thái runnable hoặc non-runnable cho đến khi thread hiện tại giải phóng đối tượng đó.
        5) ArrayList sử dụng Iterator để duyệt các phần tử.
        +Vector sử dụng Enumeration và Iterator để duyệt các phần tử.
*/
}
