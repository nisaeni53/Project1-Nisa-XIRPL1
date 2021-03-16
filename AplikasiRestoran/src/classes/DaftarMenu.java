/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

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
    public void getMenuByKategori(String kategori){
    System.out.println("======== " + kategori + "========");
    
    for (int i = 0; i < daftarmenu.size(); i++) {
        Menu m = daftarmenu.get(i);
        if (m.getKategori().equals(kategori)) {
            System.out.println((i + 1) + ". " + m.getNama_menu() + "\t" + m.getHarga());
        }
    }
    }
    
    public void tampilDaftarMenu() {
        System.out.println("======== ALDEBARAMEN ========");
        getMenuByKategori("Ramen");
        getMenuByKategori("Kuah");
        getMenuByKategori("Toping");
        getMenuByKategori("Minuman");
    }
   
    //tambah method
    public Menu pilihMenu() {
        try{
            Scanner input = new Scanner(System.in);
            
            System.out.print("Nomor Menu yang dipesan : ");
            int no_menu = input.nextInt();
            
            //get menu berdasarkan  no_menu, di -1 karena arrayList mulai dari 0
            Menu m = daftarmenu.get(no_menu-1);
            
            //cek apakah menu kuah?
            if(!m.getKategori().equalsIgnoreCase("Kuah")){
                return m;
            }else{
                //jika yang dipilih adalah menu kuah, maka tidak bisa, user harus memilih lagi
                System.out.println("[Err] Pesan dulu Menu Ramen");
                return pilihMenu();
            }
        }catch(IndexOutOfBoundsException err){
            //jika no_menu tidak ada, maka akan masuk kee sini
            //no_menu dianggap tidak ada ketika no_menu diluar dari pada arrayList
            
            System.out.println("[Err] Pesanan Tidak Tersedia");
            //jika tidak ada, maka user akan diminta untuk mengulang memasukkan nomor menu
            //teknik ini disebut dengan rekursif
            return pilihMenu(); 
        }catch(InputMismatchException err){
            //jika input bukan berupa angka akan masuk kesini
            System.out.println("[Err] Mohon masukkan nomor menu");
            return pilihMenu();
        }
    }
    
    public Menu pilihKuah(){
        try{
            Scanner input = new Scanner(System.in);
            
            System.out.print("Kuah [sesuai nomor menu] : ");
            int no_menu = input.nextInt();
            
            //get menu berdasarkan  no_menu, di -1 karena arrayList mulai dari 0
            Menu m = daftarmenu.get(no_menu-1);
            
            //cek apakah menu kuah?
            if(!m.getKategori().equalsIgnoreCase("Kuah")){
                return m;
            }else{
                System.out.println("[Err] Bukan Menu Kuah");
                return pilihKuah();
            }
        }catch(IndexOutOfBoundsException err){
            //jika no_menu tidak ada, maka akan masuk kee sini
            //no_menu dianggap tidak ada ketika no_menu diluar dari pada arrayList
            
            System.out.println("[Err] Pesanan Tidak Tersedia");
            //jika tidak ada, maka user akan diminta untuk mengulang memasukkan nomor menu
            //teknik ini disebut dengan rekursif
            return pilihKuah(); 
        }catch(InputMismatchException err){
            //jika input bukan berupa angka akan masuk kesini
            System.out.println("[Err] Mohon masukkan nomor Kuah");
            return pilihKuah();
        }
    }
}
