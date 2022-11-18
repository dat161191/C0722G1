package repository.impl;

import model.PhongTro;
import repository.BaseRepository;
import repository.IPhongTroRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PhongTroRepository implements IPhongTroRepository {
    private final String SELECT_SQL = "SELECT ttpt.*,httt.ten_hinh_thuc FROM thong_tin_phong_tro ttpt JOIN hinh_thuc_thanh_toan httt ON ttpt.ma_hinh_thuc_thanh_toan=httt.ma_hinh_thuc_thanh_toan WHERE flag =0;";
    private final String DELETE_SQL = "UPDATE thong_tin_phong_tro SET flag =1 WHERE ma_phong_tro = ?;";
    private final String INSERT_SQL = "INSERT INTO thong_tin_phong_tro (ten_nguoi_thue, so_dien_thoai, ngay_thue_tro, ghi_chu,email, ma_hinh_thuc_thanh_toan) VALUES ( ?, ?, ?, ?,?, ?);";
    private final String UPDATE_SQL =
            "UPDATE thong_tin_phong_tro SET ten_nguoi_thue = ? ,so_dien_thoai = ?, ngay_thue_tro = ?, ghi_chu = ?,email= ?, ma_hinh_thuc_thanh_toan = ? WHERE flag =0 and ma_phong_tro = ?;";

    /* QUERY TÌM 1 Ô NHIỀU TRƯỜNG*/
//    private final String SEARCH_SQL =
//            "SELECT ttpt.*,httt.ten_hinh_thuc FROM thong_tin_phong_tro ttpt JOIN hinh_thuc_thanh_toan httt ON ttpt.ma_hinh_thuc_thanh_toan=httt.ma_hinh_thuc_thanh_toan WHERE flag = 0 and (ten_nguoi_thue like ? OR  ghi_chu like ? );";

    /* QUERY TÌM NHIỀU Ô NHIỀU TRƯỜNG*/
    private final String SEARCH_SQL =
            "SELECT ttpt.*,httt.ten_hinh_thuc FROM thong_tin_phong_tro ttpt JOIN hinh_thuc_thanh_toan httt ON ttpt.ma_hinh_thuc_thanh_toan=httt.ma_hinh_thuc_thanh_toan WHERE flag = 0 AND (ten_nguoi_thue LIKE ? AND so_dien_thoai LIKE ? AND  ten_hinh_thuc like ? );";

    private final String SELECT_BY_ID = "SELECT * FROM thong_tin_phong_tro WHERE flag =0 and ma_phong_tro = ?";

    @Override
    public List<PhongTro> findAll() {
        List<PhongTro> phongTroList = new ArrayList<PhongTro>();
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_SQL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int maPhongTro = resultSet.getInt("ma_phong_tro");
                String ten = resultSet.getString("ten_nguoi_thue");
                String sdt = resultSet.getString("so_dien_thoai");
                String ngayThue = resultSet.getString("ngay_thue_tro");
                String ghiChu = resultSet.getString("ghi_chu");
                String email = resultSet.getString("email");

                int maThanhToan = resultSet.getInt("ma_hinh_thuc_thanh_toan");
                String tenHinhThuc = resultSet.getString("ten_hinh_thuc");
                PhongTro phongTro = new PhongTro(maPhongTro, ten, sdt, ngayThue, ghiChu,email, maThanhToan, tenHinhThuc);
                phongTroList.add(phongTro);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return phongTroList;
    }

    /*===== ADD===========*/
    @Override
    public boolean add(PhongTro phongTro) {
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_SQL);
            preparedStatement.setString(1, phongTro.getTen());
            preparedStatement.setDate(3, Date.valueOf(phongTro.getNgayThue()));
//            preparedStatement.setBoolean(2, customer.isGender());
            preparedStatement.setString(2, phongTro.getSdt());
            preparedStatement.setString(4, phongTro.getGhiChu());
            preparedStatement.setString(5, phongTro.getEmail());
//            preparedStatement.setString(7, customer.getAddress());
            preparedStatement.setInt(6, phongTro.getMaThanhToan());
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


    /*=======================REMOVE================*/
    @Override
    public boolean remove(int id) {
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement ps = connection.prepareStatement(DELETE_SQL);
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }


    /*============EDIT==============*/
    @Override
    public boolean edit(int ma_phong_tro, PhongTro phongTro) {
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_SQL);
            preparedStatement.setString(1, phongTro.getTen());
            preparedStatement.setDate(3, Date.valueOf(phongTro.getNgayThue()));
            preparedStatement.setString(2, phongTro.getSdt());
            preparedStatement.setString(4, phongTro.getGhiChu());
            preparedStatement.setInt(6, phongTro.getMaThanhToan());
            preparedStatement.setString(5, phongTro.getEmail());
            preparedStatement.setInt(7, phongTro.getMaPhongTro());
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


    /*==========FIND BY ID=============*/
    @Override
    public PhongTro findByID(int ma_phong_tro) {
        PhongTro phongTro = null;
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_ID);
            preparedStatement.setInt(1, ma_phong_tro);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String ten = resultSet.getString("ten_nguoi_thue");
                String sdt = resultSet.getString("so_dien_thoai");
                String ngayThue = resultSet.getString("ngay_thue_tro");
                String ghiChu = resultSet.getString("ghi_chu");
                String email = resultSet.getString("email");
                int maThanhToan = resultSet.getInt("ma_hinh_thuc_thanh_toan");
                phongTro = new PhongTro(ma_phong_tro, ten, sdt, ngayThue, ghiChu,email, maThanhToan);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return phongTro;
    }


    /*============= SEARCH================*/
    @Override
//    public List<PhongTro> search(String ten) {
    public List<PhongTro> search(String ten, String sdt, String tenHinhThuc) {
        List<PhongTro> phongTroList = new ArrayList<>();

        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_SQL);
            preparedStatement.setString(1, "%" + ten + "%");
            // Tham số tìm nhiều trường 1 ô
//            preparedStatement.setString(2, "%" + ten + "%");

            preparedStatement.setString(2, "%" + sdt + "%");
            preparedStatement.setString(3, "%" + tenHinhThuc + "%");

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("ma_phong_tro");
                String tenSearch = resultSet.getString("ten_nguoi_thue");
                String sdtSearch = resultSet.getString("so_dien_thoai");
                String ngayThue = resultSet.getString("ngay_thue_tro");
                String ghiChuSearch = resultSet.getString("ghi_chu");
                String email = resultSet.getString("email");
                int maThanhToan = resultSet.getInt("ma_hinh_thuc_thanh_toan");
                String tenHinhThucSearch = resultSet.getString("ten_hinh_thuc");

                phongTroList.add(new PhongTro(id, tenSearch, sdtSearch, ngayThue, ghiChuSearch,email, maThanhToan, tenHinhThucSearch));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return phongTroList;
    }
}
