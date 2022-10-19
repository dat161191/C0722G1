USE ss2_quan_ly_sinh_vien;
#Hiển thị số lượng sinh viên ở từng nơi
SELECT address, COUNT(address) AS 'Số lượng học viên'
FROM student
GROUP BY address;

#Tính điểm trung bình các môn học của mỗi học viên
SELECT s.student_id, s.student_name, AVG(mark)
FROM student s
         LEFT JOIN mark m on s.student_id = m.student_id
GROUP BY s.student_id, s.student_name
HAVING AVG(mark) >= 9;

#Hiển thị thông tin các học viên có điểm trung bình lớn nhất.
SELECT s.student_id, s.student_name, AVG(mark)
FROM student s join mark m on s.student_id = m.student_id
GROUP BY s.student_id, s.student_name
HAVING AVG(mark) >= ALL (SELECT AVG(mark) FROM mark GROUP BY mark.student_id);