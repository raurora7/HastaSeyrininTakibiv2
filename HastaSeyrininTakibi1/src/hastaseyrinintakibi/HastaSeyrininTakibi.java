/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hastaseyrinintakibi;

/**
 *
 * @author Bahadır
 */


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

public class HastaSeyrininTakibi {
    private Connection con;
    String host = "jdbc:derby://localhost:1527/maskama";
    String uName = "maskama";
    String uPass= "123654789";

    /**
     * @param args the command line arguments
     */
    public HastaSeyrininTakibi(){
        
        try{
        
        con = DriverManager.getConnection( host, uName, uPass );
        
        Statement stmt = con.createStatement();
        String SQL = "SELECT * FROM HASTALAR";
        ResultSet rs = stmt.executeQuery( SQL );
        
        while(rs.next( )){
        String TC = rs.getString("TC");
        String isim = rs.getString("ISIM");
        String dogum_tarihi = rs.getString("DOGUM_TARIHI");
        String cinsiyet = rs.getString("CINSIYET");
        String hastalik = rs.getString("HASTALIK");
        String durum = rs.getString("DURUM");
        
        System.out.println( TC + " " + isim + " " + dogum_tarihi + " " + cinsiyet + " "+ hastalik + " " + durum);
        }
        }
        catch(SQLException err){
            System.out.println(err.getMessage());
        }
        
    }
    
    public void Hastayi_Ekle(String TC_ekle, String isim_ekle, int dogum_tarihi_ekle, String cinsiyet_ekle, String hastalik_ekle, String durum_ekle) throws SQLException{
       
        Statement stmt = con.createStatement();
        String SQL = String.format("INSERT INTO HASTALAR VALUES('%s', '%s', %d, '%s', '%s', '%s')",TC_ekle,isim_ekle,dogum_tarihi_ekle,cinsiyet_ekle,hastalik_ekle,durum_ekle);
        stmt.executeUpdate( SQL );
    }
    
    public Boolean kullanici_girisi(String kullanici_adi, String sifre) throws SQLException{
        Statement stmt = con.createStatement();
        String SQL = String.format("select kullanici_adi, sifre from KULLANICI where kullanici_adi = '%s' and sifre = '%s'",kullanici_adi, sifre);
        ResultSet rs = stmt.executeQuery( SQL );
        
        return rs.next( );
    }
    
    
    public Boolean Hastayi_Sil(String TC_sil) throws SQLException{
        int hasta_sayisi=0;
        hasta_sayisi = hasta_adet_al();
        Statement stmt = con.createStatement();
        String SQL = String.format("DELETE FROM HASTALAR WHERE TC = '%s' ", TC_sil);
        stmt.executeUpdate( SQL );
        if (hasta_sayisi != hasta_adet_al()){
            return true;
        }
        else
            return false;
    }
    
    public String[] Kayitli_Hastalar() throws SQLException{
        int i=0;
        int hasta_sayisi = hasta_adet_al();
        String[] kayitli_hasta = new String[hasta_sayisi];
        Statement stmt = con.createStatement();
        String SQL = "SELECT ISIM FROM HASTALAR";
        ResultSet rs = stmt.executeQuery( SQL );
        while(rs.next()){
            if(i != hasta_sayisi){
                kayitli_hasta[i] = rs.getString(1);
                i++;
            }
            else
                break;
        }
        return kayitli_hasta;
    }
    
    public int hasta_adet_al() throws SQLException{
        int kayitli_hasta_sayisi=0;
        Statement stmt = con.createStatement();
        String SQL = "SELECT COUNT(*) FROM HASTALAR";
        ResultSet rs = stmt.executeQuery( SQL );
        if(rs.next())
            kayitli_hasta_sayisi = rs.getInt(1);
        return kayitli_hasta_sayisi;
    }
    
    public float hasta_yas_ortalama() throws SQLException{
        int yil=0;
        int yas=0;
        float yas_toplami=0;
        Statement stmt = con.createStatement();
        String SQL = "SELECT DOGUM_TARIHI FROM HASTALAR";
        ResultSet rs = stmt.executeQuery( SQL );
        while(rs.next()){
            yil=rs.getInt(1);
            yas=2019-yil;
            yas_toplami+=yas;
        }
        yas_toplami= yas_toplami/(hasta_adet_al());
        return yas_toplami;
    }
    
    public String hasta_goster(String TC_sorgula) throws SQLException{
        String TC="";
        String isim="";
        String dogum_tarihi="";
        String cinsiyet="";
        String hastalik="";
        String durum="";
        
        Statement stmt = con.createStatement();
        String SQL = String.format("select * from hastalar where TC = '%s'", TC_sorgula);
        ResultSet rs = stmt.executeQuery( SQL );
        
        while(rs.next( )){
        TC = rs.getString("TC");
        isim = rs.getString("ISIM");
        dogum_tarihi = String.valueOf(rs.getInt("DOGUM_TARIHI"));
        cinsiyet = rs.getString("CINSIYET");
        hastalik = rs.getString("HASTALIK");
        durum = rs.getString("DURUM");
        }
        return  "Hastanın TC'si: "+TC +"\nHastanın İsmi: "+isim +"\nHastanın Doğum Tarihi: " +dogum_tarihi + "\nHastanın Cinsiyeti: " +cinsiyet + "\nHastanın Hastalığı: "+hastalik + "\nHastanın Durumu: "+durum;
    }
    
    public void hasta_duzenle(String TC_duzenle, String isim_duzenle, int dogum_tarihi_duzenle, String cinsiyet_duzenle, String hastalik_duzenle, String durum_duzenle) throws SQLException{
        Statement stmt = con.createStatement();
        String SQL = String.format("DELETE FROM HASTALAR WHERE TC = '%s' ", TC_duzenle);
        stmt.executeUpdate( SQL );
        SQL = String.format("INSERT INTO HASTALAR VALUES('%s', '%s', %d, '%s', '%s', '%s')",TC_duzenle,isim_duzenle,dogum_tarihi_duzenle,cinsiyet_duzenle,hastalik_duzenle,durum_duzenle);
        stmt.executeUpdate( SQL );
    }
    
    public int kadin_sayisi() throws SQLException{
        int kadinSayac=0;
        Statement stmt = con.createStatement();
        String SQL = String.format("select * from hastalar where cinsiyet = 'Kadın'");
        ResultSet rs = stmt.executeQuery( SQL );
        while(rs.next()){
            kadinSayac+=1;
        }
        return kadinSayac;
    }
    
    public int erkek_sayisi() throws SQLException{
        int erkekSayac=0;
        Statement stmt = con.createStatement();
        String SQL = String.format("select * from hastalar where cinsiyet = 'Erkek'");
        ResultSet rs = stmt.executeQuery( SQL );
        while(rs.next()){
            erkekSayac+=1;
        }
        return erkekSayac;
    }
    
    public static void main(String[] args) throws SQLException {
        
    }
}
