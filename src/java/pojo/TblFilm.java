package pojo;
// Generated Oct 19, 2020 11:40:46 AM by Hibernate Tools 4.3.1

import DAO.DAOFilm;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;

@ManagedBean

public class TblFilm  implements java.io.Serializable {


     private Integer idFilm;
     private String judul;
     private int totalseat;
     private int room;
     private Date jamTayang;

    public TblFilm() {
    }

    public void cariFilm(){
        DAOFilm aksesdb = new DAOFilm();
        List<TblFilm> listdaridb = aksesdb.cariFilm(idFilm) ;
        try{
            setJudul(listdaridb.get(0).getJudul());
            setTotalseat(listdaridb.get(0).getTotalseat());
            setIdFilm(listdaridb.get(0).getIdFilm());
            setRoom( listdaridb.get(0).getRoom());
            setJamTayang(listdaridb.get(0).getJamTayang());
        }catch(Exception e){
            System.out.println(e);
        }
    }
    public void z(int idp, Date wkt){
        System.out.println(idFilm);
        System.out.println(judul);
        System.out.println(totalseat);
        System.out.println(room);
        System.out.println(jamTayang);
        System.out.println(wkt);
        DAOFilm aksesdb = new DAOFilm();
        aksesdb.updateFilm(this);
        TblTiket tbl = new TblTiket(idFilm,idp, wkt);
    }
    
    public TblFilm(int idFilm, String judul, int totalseat, int room, Date jamTayang) {
        this.idFilm=idFilm;
       this.judul = judul;
       this.totalseat = totalseat;
       this.room = room;
       this.jamTayang = jamTayang;
    }
        
    public Integer getIdFilm() {
        return this.idFilm;
    }
    public void setIdFilm(Integer idFilm) {
        this.idFilm = idFilm;
    }
    public String getJudul() {
        return this.judul;
    }
    public void setJudul(String judul) {
        this.judul = judul;
    }
    public int getTotalseat() {
        return this.totalseat;
    }
    public void setTotalseat(int totalseat) {
        this.totalseat = totalseat;
    }
    public int getRoom() {
        return this.room;
    }
    public void setRoom(int room) {
        this.room = room;
    }
    public Date getJamTayang() {
        return this.jamTayang;
    }
    public void setJamTayang(Date jamTayang) {
        this.jamTayang = jamTayang;
    }
}


