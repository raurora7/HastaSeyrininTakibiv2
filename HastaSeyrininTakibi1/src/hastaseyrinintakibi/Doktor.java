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
public class Doktor extends Personel {
    String adi_soyadi, cinsiyet, TC, doktor_no;
    int dogum_tarihi;
    private String kullanici_adi="admin"; //Uygulamayı kullanabilmek için girilmesi gereken kullanıcı adı
    private String sifre="parola"; //Uygulamayı kullanabilmek için girilmesi gereken sifre
    public Doktor(String adi_soyadi, String cinsiyet, int dogum_tarihi, String TC, String doktor_no) { //Doktor oluşturmak için.
        super(adi_soyadi, cinsiyet, dogum_tarihi, TC);
        this.adi_soyadi=adi_soyadi;
        this.cinsiyet=cinsiyet;
        this.dogum_tarihi=dogum_tarihi;
        this.TC=TC;
        this.doktor_no=doktor_no;
        
}
    
    
    
    public void bilgileri_goster(){ //doktorun bilgilerini yazdırmak için
        super.bilgileri_goster(); //upperclass a bilgileri göster metoduna gidiyor.
        System.out.println("Doktorun numarası: "+doktor_no);
    }
    
    public Boolean doktor_girisi(String kullanici_adi, String sifre){ // Uygulamanın kullanıp kullanılmayacağını söyleyen method.
        if (kullanici_adi.equals(this.kullanici_adi) && sifre.equals(this.sifre)){
            System.out.println("\nBaşarıyla giriş yaptınız.\n");
            return false;
        }
        else{
            System.out.println("\nGiriş yapamadınız.\n");
            return true;
        }
    }
}
