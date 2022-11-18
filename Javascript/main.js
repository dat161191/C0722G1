// var string = 'Trần Quốc Đạt c0722g1 Tp đà tp nẵng'
// //TÌM KIẾM KEYWORK: JS STRING METHOD
document.write(string.length+'<br>')                   //KIỂM TRA ĐỘ DÀI chuỗi
document.write(string.indexOf('tp')+'<br>')               //TÌM CHỮ ở vị trí
document.write(string.indexOf('ancn')+'<br>')           //không tìm thấy kq=-1
document.write(string.indexOf('tp',25)+'<br>')           //tim từ xuất hiện lần thứ 2,3,... bắt đầu tìm kiếm sau vị trí của chữ đã tìm thấy đầu tiên
document.write(string.slice(3)+'<br>')            //CẮT CHUỖI từ vị trí thứ 3 đến hết chuỗi
document.write(string.slice(3,8)+'<br>')              // cắt chuỗi từ vị trí thứ 3 vị trí thứ 5 trong chuỗi
document.write(string.replace('tp','city')+'<br>')      // THAY CHỮ 'tp'xuất hiện lần đầu tiên ='city'
document.write(string.replace(/tp/g,'city')+'<br>')     // thay tất cả chữ 'tp' ='city'
document.write(string.toLowerCase()+'<br>')            // thay chữ hoa thành chữ thường
document.write(string.toUpperCase()+'<br>')             // thay chữ thường thành chữ hoa
document.write(string.trim()+'<br>')                    //loại bỏ ký tự khoảng trắng ở 2 đầu chuỗi
document.write(string.split(' ')+'<br>')                 //chia chuỗi thành từng cụm
document.write(string.split('')+'<br>')                  // chia chuỗi thành từng ký tự
lấy ra ký tự từ vị trí index
document.write(string.charAt('5')+'<br>')
// // document.write(string[1]+'<br>')
// // //KIỂU SỐ - NUMBER
// var million = 10000900.6215457845;
// var million1 = 1e6; // xóa phần tử ở vị trí đặt trỏ bao nhiêu số,thêm vào vị trí đó phần tử khác
// // Phương thức	Vai trò
// // Number.isFinite()	             Xác định xem giá trị đã cho có phải là số hữu hạn hay không. Trả về boolean
// // Number.isInteger()	        Xác định xem giá trị đã cho có phải là số nguyên hay không. Trả về boolean
// // Number.parseFloat()	        Chuyển đổi chuỗi đã cho thành một số dấu phẩy động
// // Number.parseInt()	            Chuyển đổi chuỗi đã cho thành một số nguyên
// // Number.prototype.toFixed()	Chuyển đổi và trả về chuỗi đại diện cho số đã cho, có số chữ số chính xác sau dấu thập phân
// // Number.prototype.toString()	Chuyển đổi và trả về số đã cho dưới dạng chuỗi
// //kiểm tra một có phải là 1 number hay không
// console.log(isNaN(million))//trả về giá trị true nếu đó không phải là 1 số
// //TÌM KIẾM KEYWORK: JS NUMBER METHOD
// console.log (typeof million.toString())//chuyển số sang chuỗi
// console.log(million.toFixed())//chuyển về dạng chuỗi và làm tròn số<5 or >5 sau dấu phẩy
// console.log(million.toFixed(3))//chuyển về dạng chuỗi và lấy sau dấu phẩy bằng số truyền vào.
// console.log(typeof (999/'ada'))


// //MẢNG (ARRAY)
// var so = [1, 2, 3, 4, 5]
// let a="20/12/2022"
// document.write(a.split("/"))

// console.log(Array.isArray(so));// kiểm tra đối tượng có phải mảng hay không, để phân biệt vs ký tự kiểu dữ liệu Object( vd: {})
// console.log(so.toString()); // chuyển mảng sang chuỗi
// console.log(so.join('+'))//chuyển mảng sang chuỗi+thay thế dấu phẩy bằng ký tự trong ('')
// console.log(so.pop()) //xóa phần tử cuối mảng và trả về phần tử bị xóa.
// console.log(so.push('abc', '1', 2))//thêm 1 or nhiều phần tử cuối mảng và trả về độ dài mảng mới
// console.log(so.shift())//xóa phần tử đàu mảng và trả về phần tử bị xóa.
// console.log(so.unshift('a', 1, {}))//thêm 1 or nhiều phần tử đầu mảng và trả về độ dài mảng
// console.log(so.splice(2, 1, "alo"))//xóa phần 1 tử bắt đầu ở vị trí  và thêm vào đó phần tử "alo"
// let so1 = ['a', 'b', 'c', 'd'];
// console.log(so.concat(so1))// nối hai chuỗi thành 1 chuỗi console.log(so.slice(5, 8))//cắt phần tử bắt đàu ở vị trí thứ 5 và kết thúc ở đàu vị trí 8
// console.log(so.slice(0))//coppy ra 1 mảng mới
// let b=[]
// b.push(so1[2]);
// b.push(so.pop());
// alert(b)
// var d = new Date("March 16, 2018 13:34:45:500");
// var n = d.getMonth()+1;
// document.writeln(n)

