/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hastaseyrinintakibi;

/**
 *
 * @author bahadirsahin
 */
public class Personel { //Personel upperClass görevi görüyor.
    String adi_soyadi, cinsiyet, TC;
    int dogum_tarihi;
    public Personel(){
        
    }
    
    public Personel(String adi_soyadi, String cinsiyet,int dogum_tarihi, String TC){
        this.adi_soyadi=adi_soyadi;
        this.cinsiyet=cinsiyet;
        this.dogum_tarihi=dogum_tarihi;
        this.TC=TC;
    }
    
    public void bilgileri_al(String adi_soyadi, String cinsiyet,int dogum_tarihi, String TC){
        
        
    }
    
    
    public void bilgileri_goster(){ //hasta veya dkotor bilgileri gösterirken buraya gelip buradaki bilgileri yazdırıyor, ondan sonra kendilerine has olan bilgileri kendi classlarındaki methodlardan alıyorlar.
        System.out.println("Adı soyadı: "+adi_soyadi);
        System.out.println("Cinsiyeti: "+cinsiyet);
        System.out.println("Yaşı: "+dogum_tarihi);
        System.out.println("TC'si: "+TC);
        
    }
}
