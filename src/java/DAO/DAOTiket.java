/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pojo.CinemaRakyatUtil;
import pojo.TblTiket;

/**
 *
 * @author Rinaldito
 */
public class DAOTiket {
    public void pesantiket(TblTiket plg){
        TblTiket halo = new TblTiket();
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
    
    public List<TblTiket> cariidtiket (int idPelanggan,int idFilm,Date waktuTrx) {
        System.out.println(idFilm);
        TblTiket u = new TblTiket();
        List<TblTiket> user = new ArrayList();
        Transaction trans = null;
        Session session = CinemaRakyatUtil.getSessionFactory().openSession();
        try{
            trans = session.beginTransaction();
            Query query = session.createQuery("from TblTiket where waktu_trx= :wkt");
            query.setDate("wkt",waktuTrx);
            u = (TblTiket) query.uniqueResult();
            user = query.list() ;
            trans.commit();
        } catch (Exception e){
            System.out.println("Error: " + e);
        }
        return user;
    }
}
