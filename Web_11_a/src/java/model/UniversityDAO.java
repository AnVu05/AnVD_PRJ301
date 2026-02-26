/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import utils.DbUtils;
import utils.JPAUtils;

/**
 *
 * @author tungi
 */
public class UniversityDAO {

    public UniversityDAO() {
    }

    public UniversityDTO searchByID(String ID) {
        EntityManager em = JPAUtils.getEntityManager();
        try {
            return em.find(UniversityDTO.class, ID);
        } finally{
            em.close();
        }
    }

    public List<UniversityDTO> searchByName(String name) {
        EntityManager em = JPAUtils.getEntityManager();
        String jpql = "Select u from University u where u.status = true and u.name like :name";
         return em.createQuery(jpql, UniversityDTO.class)
                .setParameter("name", name)
                .getResultList();
    }

    public List<UniversityDTO> filterByName(String name) {
        name = "%" + name + "%";
        return searchByName(name);
    }

    public boolean softDelete(String id) {
        EntityManager em = JPAUtils.getEntityManager();
        EntityTransaction tx = em .getTransaction();
        try {
            tx.begin();
            UniversityDTO u = em.find(UniversityDTO.class, id);
            u.setStatus(false);
            tx.commit();
            return true;
        }catch(Exception e){
            tx.rollback();
            return false;
        }finally{
            em.close();
        }
    }

    public boolean add(UniversityDTO u) {
        EntityManager em = JPAUtils.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(u);
            tx.commit();
            return true;
        } catch (Exception e) {
            tx.rollback();
            return false;
        }finally{
            em.close();
        }
    }

    public boolean update(UniversityDTO u) {
        EntityManager em = JPAUtils.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.merge(u);
            tx.commit();
            return true;
        } catch (Exception e) {
            tx.rollback();
            return false;
        }finally{
            em.close();
        }
    }

}
