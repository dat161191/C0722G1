package service.impl;

import model.BenhNhan;
import reponsitory.IBenhNhanRepository;
import reponsitory.impl.BenhNhanRepository;
import service.IBenhNhanService;

import java.util.List;

public class BenhNhanService implements IBenhNhanService {
    private IBenhNhanRepository benhNhanRepository = new BenhNhanRepository();


    @Override
    public List<BenhNhan> findAll() {
        return benhNhanRepository.findAll();
    }

    @Override
    public boolean remove(String maBenhAn) {
        return benhNhanRepository.remove(maBenhAn);
    }

    @Override
    public BenhNhan findByID(String maBenhNhan) {
        return benhNhanRepository.findByID(maBenhNhan);
    }
}
