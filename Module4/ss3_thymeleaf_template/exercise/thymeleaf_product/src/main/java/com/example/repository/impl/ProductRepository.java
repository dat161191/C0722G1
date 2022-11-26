package com.example.repository.impl;

import com.example.model.Product;
import com.example.repository.IProductRepository;
import com.example.service.IProductService;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProductRepository implements IProductRepository {

    @Override
    public List<Product> findAll() {
        Session session = null;
        List<Product> productList = null;
        try {
            session = ConnectionUtil.sessionFactory.openSession();
            productList = session.createQuery("FROM Product ").getResultList();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return productList;
    }


    @Override
    public void removeProduct(Product product) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = ConnectionUtil.sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.remove(product);
            transaction.commit();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }


    @Override
    public void addProduct(Product product) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = ConnectionUtil.sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.save(product);
            transaction.commit();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public void updateProduct(Product product) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = ConnectionUtil.sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.merge(product);
            transaction.commit();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }


    @Override
    public Product findProductById(int id) {
        Session session = null;
        Product product = null;
        try {
            session = ConnectionUtil.sessionFactory.openSession();
            product = (Product) session.createQuery("FROM Product where id=:id").setParameter("id", id).getSingleResult();

        } finally {
            if (session != null) {
                session.close();
            }
        }
        return product;
    }

    @Override
    public List<Product> searchByName(String name) {
        List<Product> productList = new ArrayList<>();
        Session session = null;
        try {
            session = ConnectionUtil.sessionFactory.openSession();
            productList = session.createQuery("FROM Product where name like :name").setParameter("name", "%" + name + "%").getResultList();
        } catch (NoResultException e) {
        } finally {
            if (session != null) {
                session.close();
            }
        }

        return productList;
    }
}
