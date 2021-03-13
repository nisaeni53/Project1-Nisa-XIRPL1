/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.util.ArrayList;

/**
 *
 * @author DELL LATITUDE E6430s
 */
public class DaftarMenu {

    private ArrayList<Menu> daftarmenu;
    public DaftarMenu(){
        daftarmenu =new ArrayList<>();
    }
    public void tambahMenu (Menu menu) {
        daftarmenu.add(menu);
    }
    public void getMenuByKategori(String kategori){}
    public void tampilDaftarMenu() {}
    
}
