package reponsitory.impl;


import model.BenhNhan;
import reponsitory.IBenhNhanRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class BenhNhanRepository implements IBenhNhanRepository {
    private final String SELECT_SQL = "SELECT bn.*,ba.ma_benh_an,ba.ten_benh_an FROM benh_nhan bn JOIN benh_an ba ON bn.ma_benh_an=ba.ma_benh_an WHERE flag =0;";
    private final String SELECT_BY_ID = "SELECT benh_nhan.*,benh_an.ma_benh_an,benh_an.ten_benh_an FROM benh_nhan JOIN benh_an ON benh_nhan.ma_benh_an=benh_an.ma_benh_an WHERE ma_benh_nhan = ?";
    private final String DELETE_SQL = "UPDATE benh_nhan SET flag =1 WHERE ma_benh_an = ?;";
    @Override
    public List<BenhNhan> findAll() {
        List<BenhNhan> benhNhanList = new ArrayList<BenhNhan>();
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_SQL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String maBenhNhan = resultSet.getString("ma_benh_nhan");
                String tenBenhNhan = resultSet.getString("ten_benh_nhan");
                String ngayNhapVien = resultSet.getString("ngay_nhap_vien");
                String ngayRaVien = resultSet.getString("ngay_ra_vien");
                String lyDoNhapVien = resultSet.getString("ly_do_nhap_vien");
                String phuongPhapDieuTri = resultSet.getString("phuong_phap_dieu_tri");
                String bacSiDieuTri = resultSet.getString("bac_si_dieu_tri");
                String maBenhAn = resultSet.getString("ma_benh_an");
                String maHoSo = resultSet.getString("ma_benh_an");
                String tenBenhAn = resultSet.getString("ten_benh_an");
                BenhNhan benhNhan = new BenhNhan(maBenhNhan,tenBenhNhan,ngayNhapVien,ngayRaVien,lyDoNhapVien,phuongPhapDieuTri,bacSiDieuTri,maBenhAn,maHoSo,tenBenhAn);
                benhNhanList.add(benhNhan);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return benhNhanList;
    }

    @Override
    public BenhNhan findByID(String maBenhNhan) {
        return null;
    }

    @Override
    public boolean remove(String maBenhNhan) {
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement ps = connection.prepareStatement(DELETE_SQL);
            ps.setString(1, maBenhNhan);
            return ps.executeUpdate() > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }
}
