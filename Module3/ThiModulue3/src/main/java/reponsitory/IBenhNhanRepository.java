package reponsitory;

import model.BenhNhan;

import java.util.List;

public interface IBenhNhanRepository {
    List<BenhNhan> findAll();
    BenhNhan findByID(String maBenhNhan);
    boolean remove(String maBenhAn);

}
