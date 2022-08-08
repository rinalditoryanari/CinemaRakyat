package pojo;
// Generated Oct 19, 2020 11:40:46 AM by Hibernate Tools 4.3.1

import DAO.DAOPelanggan;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;

@ManagedBean
public class TblPelanggan  implements java.io.Serializable {


     private boolean adaEmail;
     private boolean bisaedit;
     private boolean bisahapus;
     private Integer idPelanggan;
     private String email;
     private String password;
     private String nama;
     private int noTelp;
     private int idFilm;
     private Date waktu;

    public TblPelanggan() {
    }
    
    public void cariakun(){
        DAOPelanggan aksesdb = new DAOPelanggan();
        List<TblPelanggan> listdaridb = aksesdb.login1(getEmail(), getPassword()) ;
        try{
            System.out.println("a");
            setEmail(listdaridb.get(0).getEmail());
            setPassword(listdaridb.get(0).getPassword());
            setNama(listdaridb.get(0).getNama());
            setIdPelanggan(listdaridb.get(0).getIdPelanggan());
            setNoTelp(listdaridb.get(0).getNoTelp());
            setAdaEmail(true);
        }catch(Exception e){
            System.out.println(e);
            setAdaEmail(false);
        }    
    }
  
    
    public void delete(){
        DAOPelanggan aksesdb = new DAOPelanggan();
        aksesdb.deleteakun(getIdPelanggan());
        reset();
        bisahapusnotif();        
    }    
    public void updateakun (){        
        DAOPelanggan aksesdb = new DAOPelanggan();
        aksesdb.updateakun(this);
        reset();
        bisaeditnotif();
        System.out.println(isBisaedit());
    }
    
    public void reset(){
        setEmail("");
        setIdPelanggan(0);
        setPassword("");
        setNama("");
        setNoTelp(0);
    }
    
     public String daftarakun(){
        DAOPelanggan aksesdb = new DAOPelanggan();
        List<TblPelanggan> listdaridb = aksesdb.cariEmail(getEmail()) ;
        try{
            if(email == listdaridb.get(0).getEmail()){
                adaEmail=true;
            }                        
        }catch(Exception e){
            aksesdb.addPelanggan(this);
            return"profile";
        }
        return "";
    }
     

    
    public String loginakun(){
        DAOPelanggan aksesdb = new DAOPelanggan();
        List<TblPelanggan> listdaridb = aksesdb.login1(getEmail(), getPassword()) ;
        try{
            setEmail(listdaridb.get(0).getEmail());
            setPassword(listdaridb.get(0).getPassword());
            setNama(listdaridb.get(0).getNama());
            setIdPelanggan(listdaridb.get(0).getIdPelanggan());
            setNoTelp(listdaridb.get(0).getNoTelp());
        }catch(Exception e){
            System.out.println(e);
        }
        return"profile";
    }
    
    public String pindahlogin(){
        return "login";
    }
    
    public String pindahsignup(){
        return "signup";
    }
        
    public String pindahedit(){
        return "edit_profile";
    }
    
    private void resetnotif(){
        setAdaEmail(false);
        setBisaedit(false);
        setBisahapus(false);
    }
    
    private void adaEmailnotif(){
        setAdaEmail(true);
        setBisaedit(false);
        setBisahapus(false);        
    }
    
    private void bisaeditnotif(){
        setAdaEmail(false);
        setBisaedit(true);
        setBisahapus(false);        
    }    
    
    private void bisahapusnotif(){
        setAdaEmail(false);
        setBisaedit(false);
        setBisahapus(true);        
    }
    
    public TblPelanggan(int idPelanggan, String email, String password, String nama, int noTelp) {
       this.email = email;
       this.idPelanggan = idPelanggan;
       this.password = password;
       this.nama = nama;
       this.noTelp = noTelp;
    }
   
    public Integer getIdPelanggan() {
        return this.idPelanggan;
    }
    
    public void setIdPelanggan(Integer idPelanggan) {
        this.idPelanggan = idPelanggan;
    }
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    public String getNama() {
        return this.nama;
    }
    
    public void setNama(String nama) {
        this.nama = nama;
    }
    public int getNoTelp() {
        return this.noTelp;
    }
    
    public void setNoTelp(int noTelp) {
        this.noTelp = noTelp;
    }

    /**
     * @return the idFilm
     */
    public int getIdFilm() {
        return idFilm;
    }

    /**
     * @param idFilm the idFilm to set
     */
    public void setIdFilm(int idFilm) {
        this.idFilm = idFilm;
    }

    /**
     * @return the waktu
     */
    public Date getWaktu() {
        return waktu;
    }

    /**
     * @param waktu the waktu to set
     */
    public void setWaktu(Date waktu) {
        this.waktu = waktu;
    }

    

    /**
     * @return the bisaedit
     */
    public boolean isBisaedit() {
        return bisaedit;
    }

    /**
     * @param bisaedit the bisaedit to set
     */
    public void setBisaedit(boolean bisaedit) {
        this.bisaedit = bisaedit;
    }

    /**
     * @return the bisahapus
     */
    public boolean isBisahapus() {
        return bisahapus;
    }

    /**
     * @param bisahapus the bisahapus to set
     */
    public void setBisahapus(boolean bisahapus) {
        this.bisahapus = bisahapus;
    }

    /**
     * @return the adaEmail
     */
    public boolean isAdaEmail() {
        return adaEmail;
    }

    /**
     * @param adaEmail the adaEmail to set
     */
    public void setAdaEmail(boolean adaEmail) {
        this.adaEmail = adaEmail;
    }




}


