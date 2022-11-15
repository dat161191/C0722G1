package service;

import model.PhongTro;

import java.util.List;

public interface IPhongTroService {
    List<PhongTro> findAll();

    boolean add(PhongTro phongTro);

    boolean remove(int id);

    boolean edit(int id, PhongTro phongTro);
    PhongTro findByID(int id);
//    List<PhongTro> search(String name);
    List<PhongTro> search(String name,String sdt,String tenHinhThuc);
}
