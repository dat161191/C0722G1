package service.impl;

import model.PhongTro;
import repository.IPhongTroRepository;
import repository.impl.PhongTroRepository;
import service.IPhongTroService;

import java.util.List;

public class PhongTroService implements IPhongTroService {
    private IPhongTroRepository phongTroRepository = new PhongTroRepository();

    @Override
    public List<PhongTro> findAll() {
        return phongTroRepository.findAll();
    }

    @Override
    public boolean add(PhongTro phongTro) {
        return phongTroRepository.add(phongTro);
    }

    @Override
    public boolean remove(int id) {
        return phongTroRepository.remove(id);
    }

    @Override
    public boolean edit(int id,PhongTro phongTro) {
        return phongTroRepository.edit(id,phongTro);
    }

    @Override
    public PhongTro findByID(int id) {
        return phongTroRepository.findByID(id);
    }

    @Override
//    public List<PhongTro> search(String name) {
//        return phongTroRepository.search(name);
//    }

    public List<PhongTro> search(String name,String sdt,String tenHinhThuc){
        return phongTroRepository.search(name,sdt,tenHinhThuc);
    }
}
