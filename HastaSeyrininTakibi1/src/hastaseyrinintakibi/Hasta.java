/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hastaseyrinintakibi;

import java.util.ArrayList;

/**
 *
 * @author bahadirsahin
 */
public class Hasta extends Personel{
    //Hastanın bilgilerinin tutulduğu ArrayListler burada tanımlandı.
    static ArrayList adi_soyadi = new ArrayList();
    static ArrayList cinsiyet = new ArrayList();
    static ArrayList dogum_tarihi = new ArrayList();
    static ArrayList TC = new ArrayList();
    static ArrayList hastalik = new ArrayList();
    static ArrayList durum = new ArrayList();
    
    public Hasta(){
        
    }
    
    public Hasta(String adi_soyadi, String cinsiyet,int dogum_tarihi, String TC, String hastalik, String durum){ 
        //Yeni hasta oluşturabilmek için bilgiler buraya geliyor.
        super(adi_soyadi, cinsiyet, dogum_tarihi, TC);
        this.adi_soyadi.add(adi_soyadi);
        this.cinsiyet.add(cinsiyet);
        this.dogum_tarihi.add(dogum_tarihi);
        this.TC.add(TC);
        this.hastalik.add(hastalik);
        this.durum.add(durum);
    }
    
    public void bilgileri_goster(String TC){
        //Hastanın bilgilerinin gösterilebilmesi için.
        int uzun = this.TC.indexOf(TC); //TC'si girilien hastanın ArrayListteki yerini gösteriyor.
        System.out.println("Hasta Numarası: " + (uzun+1));
        System.out.println("İsmi: " + this.adi_soyadi.get(uzun));
        System.out.println("Cinsiyet: "+this.cinsiyet.get(uzun));
        System.out.println("Doğum Tarihi: " + this.dogum_tarihi.get(uzun));
        System.out.println("TC'si: "+ this.TC.get(uzun));
        System.out.println("Hastalığı: "+ this.hastalik.get(uzun));
        System.out.println("Durumu: "+ this.durum.get(uzun));
        
    }
    
    public void hasta_sil(String TC){
        //Hastanın silinebilmesi için olan kısım
        int uzun = this.TC.indexOf(TC); //TC'si girilien hastanın ArrayListteki yerini gösteriyor.
        this.adi_soyadi.remove(uzun);
        this.cinsiyet.remove(uzun);
        this.TC.remove(uzun);
        this.dogum_tarihi.remove(uzun);
        this.hastalik.remove(uzun);
        this.durum.remove(uzun);
        System.out.println("Hasta silindi.");
    }
    
    public void bilgileri_degistir(String TC, String yeni_durum){
        //içine 2 tane String değişken alan hastanın durumunun değiştirildiği kısım.
        int uzun = this.TC.indexOf(TC); //TC'si girilien hastanın ArrayListteki yerini gösteriyor.
        this.durum.remove(uzun);
        this.durum.add(uzun, yeni_durum);
        System.out.println("Kişinin durumu başarıyla değiştirildi.");
    }
    
    public void bilgileri_degistir(String TC, String yeni_hastalik, String yeni_durum){
        //içine 2 tane String değişken alan hastanın hastalığının ve durumunun değiştirildiği kısım.
        int uzun = this.TC.indexOf(TC); //TC'si girilien hastanın ArrayListteki yerini gösteriyor.
        this.hastalik.remove(uzun);
        this.hastalik.add(uzun, yeni_hastalik);
        this.durum.remove(uzun);
        this.durum.add(uzun, yeni_durum);
        System.out.println("Kişinin hastalığı ve durumu başarıyla değiştirildi.");
    }

    public void bilgileri_degistir(String TC, String yeni_adi_soyadi, String yeni_cinsiyet, int yeni_dogum_tarihi, String yeni_TC){
        //içine 2 tane String değişken alan hastanın kişisel bilgilerinini değiştirildiği kısım.
        int uzun = this.TC.indexOf(TC); //TC'si girilien hastanın ArrayListteki yerini gösteriyor.
        this.adi_soyadi.remove(uzun);
        this.adi_soyadi.add(uzun, yeni_adi_soyadi);
        this.cinsiyet.remove(uzun);
        this.cinsiyet.add(uzun, yeni_cinsiyet);
        this.dogum_tarihi.remove(uzun);
        this.dogum_tarihi.add(uzun, yeni_dogum_tarihi);
        this.TC.remove(uzun);
        this.TC.add(uzun, yeni_TC);
        System.out.println("Kişinin kişisel bilgileri başarıyla değiştirildi.");
    }
    
    public void kayitli_hastalar(){
        //Sistemde kayıtlı olan hastaları gösteren kısım.
        System.out.println("Sistemde kayıtlı hastalar:");
        int uzunluk=TC.size(); //uzunluk değişkeni arrayListte kaç kişi olduğuna bakıyor
        for (int i=0; i<uzunluk; i++){ // for döngüsü uzunluk kadar dönüyor.
            System.out.println(adi_soyadi.get(i));
             }
    }
    
    public void dogum_tarihi_ortalamasi(){
        //Hastaların yaş ortalamasının hesaplandığı kısım.
        int uzunluk=TC.size(); //uzunluk değişkeni arrayListte kaç kişi olduğuna bakıyor
        int toplam=0;
        for (int i=0; i<uzunluk; i++){ // for döngüsü uzunluk kadar dönüyor.
            toplam += (int) dogum_tarihi.get(i); // Toplama tüm yaşlar ekleniyor
        }
        //toplam çıktıya verilirken hasta sayısına bölünüyor, yaş ortalaması ekrana veriliyor.
        System.out.println("Sistemdeki hastaların yaş ortalaması="+ (toplam/uzunluk));
    }
    
}
