package pojo;
// Generated Oct 19, 2020 11:40:46 AM by Hibernate Tools 4.3.1


import DAO.DAOFilm;
import DAO.DAOPelanggan;
import DAO.DAOTiket;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;

@ManagedBean
public class TblTiket implements java.io.Serializable {
     private int idTiket;
     private int idFilm;
     private int idPelanggan;
     private Date waktuTrx;
     private boolean simpan;
     private String email;
     private String password;
     
    public TblTiket() {
    }

     public String c(){
        System.out.println("C");
        String judul;
        int totalseat;
        int room;
        Date jamTayang;        
        DAOFilm aksesdb = new DAOFilm();
        List<TblFilm> listdaridb = aksesdb.cariFilm(getIdFilm()) ;
        try{            
            judul=listdaridb.get(0).getJudul();
            room=listdaridb.get(0).getRoom();
            jamTayang=listdaridb.get(0).getJamTayang();
            setIdFilm(listdaridb.get(0).getIdFilm());
            totalseat = listdaridb.get(0).getTotalseat();
            if(totalseat > 0){
                b();
                totalseat -= 1;
                TblFilm tblFilm = new TblFilm(idFilm, judul, totalseat, room, jamTayang);
                tblFilm.z(idPelanggan, waktuTrx);
                System.out.println(totalseat);
                System.out.println(idFilm +""+ idPelanggan +""+ waktuTrx);
                return "hasiltiket";
            } else{
                return"kosong";
            }
        }catch(Exception e){
            System.out.println(e);
        }
        return "";
    }
    public void b(){
        System.out.println("B");
        DAOPelanggan aksesdb = new DAOPelanggan();
        List<TblPelanggan> listdaridb = aksesdb.login1(getEmail(), getPassword()) ;
        try{
            setEmail(listdaridb.get(0).getEmail());
            setPassword(listdaridb.get(0).getPassword());
            setIdPelanggan(listdaridb.get(0).getIdPelanggan());
            pesan();
        }catch(Exception e){
            System.out.println(e);
        }
    }
    public void pesan(){
         try {
             LocalDateTime timenow = LocalDateTime.now();
             DateTimeFormatter format = DateTimeFormatter.ofPattern("HH:mm:ss");
             String timestr = timenow.format(format);
             DateFormat Format1 = new SimpleDateFormat("hh:mm"); 
             setWaktuTrx(Format1.parse(timestr));
             simpan_tiket();             
         } catch (Exception e) {
             System.out.println(e);
         }
    }    
    public void simpan_tiket(){
        DAOTiket aksesdb = new DAOTiket();
        aksesdb.pesantiket(this);
        System.out.println(getWaktuTrx());        
    }
        
    public TblTiket(int idFilm, int idPelanggan, Date waktuTrx) {
       this.idFilm = idFilm;
       this.idPelanggan = idPelanggan;
       this.waktuTrx = waktuTrx;
    }
    public int getIdTiket() {
        return this.idTiket;
    }
    public void setIdTiket(int idTiket) {
        this.idTiket = idTiket;
    }
    public int getIdFilm() {
        return this.idFilm;
    }
    public void setIdFilm(int idFilm) {
        this.idFilm = idFilm;
    }
    public int getIdPelanggan() {
        return this.idPelanggan;
    }
    public void setIdPelanggan(int idPelanggan) {
        this.idPelanggan = idPelanggan;
    }
    public Date getWaktuTrx() {
        return this.waktuTrx;
    }
    public void setWaktuTrx(Date waktuTrx) {
        this.waktuTrx = waktuTrx;
    }

    /**
     * @return the simpan
     */
    public boolean isSimpan() {
        return simpan;
    }

    /**
     * @param simpan the simpan to set
     */
    public void setSimpan(boolean simpan) {
        this.simpan = simpan;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

}


