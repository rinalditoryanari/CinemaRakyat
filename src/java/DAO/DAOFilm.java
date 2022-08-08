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
import pojo.TblFilm;
/**
 *
 * @author Rinaldito
 */
public class DAOFilm {
    public List<TblFilm> cariFilm(int idFilm) {
        TblFilm u = new TblFilm();
        List<TblFilm> user = new ArrayList();
        Transaction trans = null;
        Session session = CinemaRakyatUtil.getSessionFactory().openSession();
        try{
            trans = session.beginTransaction();
            Query query = session.createQuery("from TblFilm where id_film="
                    + " :id");
            query.setInteger("id",idFilm);
            System.out.println(query);
            u = (TblFilm) query.uniqueResult();
            user = query.list() ;
            trans.commit();
        } catch (Exception e){
            System.out.println("Error: " + e);
        }
        return user;
    }
    public void updateFilm (TblFilm plg){
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
}
