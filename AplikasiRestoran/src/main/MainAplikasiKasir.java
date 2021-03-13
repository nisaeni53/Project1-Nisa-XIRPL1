/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import classes.DaftarMenu;
import classes.Kuah;
import classes.Minuman;
import classes.Ramen;
import classes.Toping;
import java.util.Scanner;

/**
 *
 * @author DELL LATITUDE E6430s
 */
public class MainAplikasiKasir {
    public static void main(String[] args){
    //inisialisasi kelas Scanner untuk mengambil
    //input dari keyboars
    Scanner input = new Scanner(System.in);
    
    MainAplikasiKasir app = new MainAplikasiKasir();
    //tampilan daftar menu
    app.generateDaftarMenu();
    }
    public DaftarMenu daftarmenu;
    
    public void generateDaftarMenu(){
        daftarmenu = new DaftarMenu();
        daftarmenu.tambahMenu(new Ramen("Ramen Seafood", 25000));
        daftarmenu.tambahMenu(new Ramen("Ramen Original", 18000));
        daftarmenu.tambahMenu(new Ramen("Ramen Vegetarian", 22000));
        daftarmenu.tambahMenu(new Ramen("Ramen Karnivor", 28000));
        daftarmenu.tambahMenu(new Kuah("Kuah Orisinil"));
        daftarmenu.tambahMenu(new Kuah("Kuah Internasional"));
        daftarmenu.tambahMenu(new Kuah("Kuah Spicy Lada"));
        daftarmenu.tambahMenu(new Kuah("Kuah Soto Padang"));
        daftarmenu.tambahMenu(new Toping("Crab Stick Bakar", 6000));
        daftarmenu.tambahMenu(new Toping("Chicken Katsu", 8000));
        daftarmenu.tambahMenu(new Toping("Gyoza Goreng", 4000));
        daftarmenu.tambahMenu(new Toping("Bakso Goreng", 7000));
        daftarmenu.tambahMenu(new Toping("Enoki Goreng", 5000));
        daftarmenu.tambahMenu(new Minuman("Jus Alpukat SPC", 10000));
        daftarmenu.tambahMenu(new Minuman("Jus Stroberi", 11000));
        daftarmenu.tambahMenu(new Minuman("Capucino Coffe", 15000));
        daftarmenu.tambahMenu(new Minuman("Vietnam Dripp", 14000));
        
        daftarmenu.tampilDaftarMenu();
    }
   
    
}
