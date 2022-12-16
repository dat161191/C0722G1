package com.example.model;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import javax.persistence.*;
import java.util.Set;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@SQLDelete(sql = "UPDATE hinh_thuc_thanh_toan SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
public class HinhThucThanhToan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String tenHinhThuc;
    @OneToMany(mappedBy = "hinhThucThanhToans")
    private Set<ThongTinThueTro> thongTinThueTros;
    private boolean deleted = false;
}
