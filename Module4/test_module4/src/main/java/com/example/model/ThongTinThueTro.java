package com.example.model;

import javax.persistence.*;

import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@SQLDelete(sql = "UPDATE thong_tin_thue_tro SET  deleted = true WHERE id=?")
@Where(clause = "deleted=false")
public class ThongTinThueTro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String tenNguoiThue;
    private String soDienThoai;
    @Column(columnDefinition = "date")
    private String ngayThueTro;
    private boolean deleted = false;
    @ManyToOne
    private HinhThucThanhToan hinhThucThanhToans;

}
