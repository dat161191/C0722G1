USE ss2_quan_ly_sinh_vien;

-- Hiển thị tất cả các sinh viên có tên bắt đầu bảng ký tự ‘h’
SELECT * FROM student
WHERE student.StudentName LIKE "h%";

-- Hiển thị các thông tin lớp học có thời gian bắt đầu vào tháng 12.
SELECT  * FROM class
WHERE StartDate LIKE "%12%";

-- Hiển thị tất cả các thông tin môn học có credit trong khoảng từ 3-5.
SELECT * FROM subject
WHERE Credit>=3 AND Credit<=5;

-- Thay đổi mã lớp(ClassID) của sinh viên có tên ‘Hung’ là 2.
SET SQL_SAFE_UPDATES = 0;
UPDATE student
SET class_id = 2
WHERE student_name="Hung";
SET SQL_SAFE_UPDATES = 1;

-- Hiển thị các thông tin: StudentName, SubName, Mark.
-- Dữ liệu sắp xếp theo điểm thi (mark) giảm dần. nếu trùng sắp theo tên tăng dần.
SELECT student.student_name,subject.sub_name,mark.mark
FROM mark
JOIN student ON mark.student_id=student.student_id 
JOIN subject ON mark.sub_id = subject.sub_id
ORDER BY mark.mark DESC, student.student_name;
