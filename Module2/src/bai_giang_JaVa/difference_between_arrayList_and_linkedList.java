package bai_giang_JaVa;

public class difference_between_arrayList_and_linkedList {
    /*ArrayList và LinkedList đều là lớp triển khai của List Interface.
        Cả hai lớp ArrayList và LinkedList đều được implements từ giao tiếp List và duy trì thứ tự của phần tử được thêm vào.
        Cả hai lớp này đều là lớp không đồng bộ (non-synchronized).
        Chúng ta sẽ sử dụng ArrayList khi ứng dụng của chúng ta cần truy xuất phần tử nhiều hơn cập nhật và xóa phần tử
        Chúng ta sẽ sử dụng LinkedList khi ứng dụng của chúng ta cần cập nhật và xóa phần tử nhiều hơn là truy cập phần tử.
     * Khác nhau:
        1)  ArrayList nội bộ sử dụng mảng động để lưu trữ các phần tử.
            +LinkedList nội bộ sử dụng danh sách liên kết doubly để lưu trữ các phần tử.
        2)  Thao tác với ArrayList là chậm bởi vì nó sử dụng nội bộ mảng.
            Nếu bất kỳ phần tử nào được xoá khỏi mảng, tất cả các bit được chuyển trong bộ nhớ.
            +Thao tác với LinkedList là nhanh hơn so với ArrayList.
            Nó sử dụng danh sách liên kết doubly do đó không cần chuyển đổi bit nào trong bộ nhớ.
        3) Lớp ArrayList trong java chỉ có thể hoạt động như một list vì nó chỉ implements giao tiếp List.
            +Lớp LinkedList trong java có thể hoạt động như một list và queue(hàng đợi) vì nó implements các giao tiếp List và Deque.
        4) ArrayList là tốt hơn trong việc lưu trữ và truy cập dữ liệu.
            +LinkedList là tốt hơn trong việc thao tác dữ liệu.
       */
}
