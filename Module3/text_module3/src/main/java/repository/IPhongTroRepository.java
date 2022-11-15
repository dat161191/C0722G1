package repository;

import model.PhongTro;

import java.util.List;

public interface IPhongTroRepository {
    List<PhongTro> findAll();

    boolean add(PhongTro phongTro);

    boolean remove(int id);

    boolean edit(int id, PhongTro phongTro);
    PhongTro findByID(int id);

    /*SEARCH NHIỀU TRƯỜNG 1 Ô*/
//    List<PhongTro> search(String name);

    /* SEARCH NHIỀU TRƯỜNG NHIỀU Ô*/
    List<PhongTro> search(String name,String sdt,String tenHinhThuc);

}
