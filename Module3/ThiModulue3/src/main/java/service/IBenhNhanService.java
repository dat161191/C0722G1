package service;

import model.BenhNhan;

import java.util.List;

public interface IBenhNhanService {
    List<BenhNhan> findAll();
    boolean remove(String maBenhAn);
    BenhNhan findByID(String maBenhNhan);

}
