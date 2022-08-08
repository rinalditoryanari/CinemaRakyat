/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pojo.CinemaRakyatUtil;
import pojo.TblPelanggan;

/**
 *
 * @author Rinaldito
 */
public class DAOPelanggan {
    
    public List<TblPelanggan> login1 (String uEmail, String uPass) {
        TblPelanggan u = new TblPelanggan();
        List<TblPelanggan> user = new ArrayList();
        Transaction trans = null;
        Session session = CinemaRakyatUtil.getSessionFactory().openSession();
        try{
            trans = session.beginTransaction();
            Query query = session.createQuery("from TblPelanggan where email="
                    + " :uEmail AND password= :uPass");
            System.out.println(query);
            query.setString("uEmail",uEmail);
            query.setString("uPass",uPass);
            u = (TblPelanggan) query.uniqueResult();
            user = query.list() ;
            trans.commit();
        } catch (Exception e){
            System.out.println("Error: " + e);
        }
        return user;
    }
    public List<TblPelanggan> cariEmail (String uEmail) {
        TblPelanggan u = new TblPelanggan();
        List<TblPelanggan> user = new ArrayList();
        Transaction trans = null;
        Session session = CinemaRakyatUtil.getSessionFactory().openSession();
        try{
            trans = session.beginTransaction();
            Query query = session.createQuery("from TblPelanggan where email="
                    + " :uEmail");
            System.out.println(query);
            query.setString("uEmail",uEmail);
            u = (TblPelanggan) query.uniqueResult();
            user = query.list() ;
            trans.commit();
        } catch (Exception e){
            System.out.println("Error: " + e);
        }
        return user;
    }
    
    public void deleteakun (int idP){
        Transaction trans = null;
        Session session = CinemaRakyatUtil.getSessionFactory().openSession();
        try{
            trans = session.beginTransaction();
            TblPelanggan plg = 
            (TblPelanggan) session.load(TblPelanggan.class, new Integer(idP));
            session.delete(plg);
            trans.commit();
        } catch(Exception e){
            System.out.println("eror" + e);
            e.printStackTrace();
        }
    }
    
    public void updateakun (TblPelanggan plg){
        System.out.println(plg);
        Transaction trans = null;
        Session session = CinemaRakyatUtil.getSessionFactory().openSession();
        try{
            trans = session.beginTransaction();
            session.update(plg);
            trans.commit();
        }catch(Exception e){
            System.out.println("eror" + e);
            e.printStackTrace();
        }
    }
    
    public void addPelanggan(TblPelanggan plg){
        TblPelanggan halo = new TblPelanggan();
        Transaction trans = null;
        Session session = CinemaRakyatUtil.getSessionFactory().openSession();
        try{
            trans =session.beginTransaction();
            session.save(plg);
            trans.commit();
        } catch(Exception e){
            System.out.println(e);
        }
    }
}
