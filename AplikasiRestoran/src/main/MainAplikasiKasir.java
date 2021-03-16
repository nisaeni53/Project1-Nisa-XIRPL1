/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import classes.DaftarMenu;
import classes.Kuah;
import classes.Menu;
import classes.Minuman;
import classes.Pesanan;
import classes.Ramen;
import classes.Toping;
import classes.Transaksi;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author DELL LATITUDE E6430s
 */
public class MainAplikasiKasir {

    private static String pesan_lagi;
    
    public DaftarMenu daftarmenu;
    //Tambahkan 
    public static double PAJAK_PPN = 0.10;
    public static double BIAYA_SERVICE = 0.05;
    //End Of Tambahkan
    
    public static void main(String[] args){
    //inisialisasi kelas Scanner untuk mengambil
    //input dari keyboars
        Scanner input = new Scanner(System.in);
        //Tambahkan
        String no_transaksi, nama_pemesan, tanggal, no_meja = "";
        String transaksi_lagi = "", keterangan = "", makan_ditempat;
        int jumlah_pesanan, no_menu;
        //End Of Tambahkan
    
    
    MainAplikasiKasir app = new MainAplikasiKasir();
    //tampilan daftar menu
    app.generateDaftarMenu();
    //mulai transaksi
    System.out.println("======== TRANSAKSI ========");
    
    //ambil data transaksi
    System.out.print("No Transaksi : ");
    no_transaksi = input.next();
    System.out.print("Pemesanan : ");
    nama_pemesan = input.next();
    System.out.print("Tanggal : [dd-mm-yyyy] ");
    tanggal = input.next();
    System.out.print("Makan Ditempat? [Y/N] : ");
    makan_ditempat = input.next();
    
    if (makan_ditempat.equalsIgnoreCase("Y")) {
        System.out.print("Nomor Meja : ");
        no_meja = input.next();
    }
    
    //buat transaksi.baru
    Transaksi trans = new Transaksi(no_transaksi, nama_pemesan, tanggal, no_meja);
    System.out.println("======== PESANAN ========");
    int no_kuah;
    do {
        //ambil menu berdasarkan nomor urut yang dipilih
        Menu menu_yang_dipilih = app.daftarmenu.pilihMenu();
        
        jumlah_pesanan = (int) app.cekInputNumber("Jumlah : ");
        
        //buat pesanan
        Pesanan pesanan = new Pesanan(menu_yang_dipilih, jumlah_pesanan);
        trans.tambahPesanan(pesanan);
        //khusus untuk menu ramen, pesanan kuahnya langsung diinput juga
        if (menu_yang_dipilih.getKategori().equals("Ramen")) {
            //looping sesuai jumlah pesanan ramen
            int jumlah_ramen = jumlah_pesanan;
            do {
                //ambil objek menu berdasarkan nomor yang dipilih
                Menu kuah_yang_dipilih = app.daftarmenu.pilihKuah();
                
                System.out.print("Level : [0-5] : ");
                String level = input.next();
                
                //validasi jumlah kuah tidak boleh lebih besar dari jumlah_ramen
                int jumlah_kuah = 0;
                do {
                    jumlah_kuah = (int) app.cekInputNumber("Jumlah : ");
                    
                    if (jumlah_kuah > jumlah_ramen) {
                        System.out.println("[Err] Jumlah Kuah melebihi jumlah ramen yang sudah dipesan");
                    }else {
                        break;
                    }
                }while (jumlah_kuah > jumlah_ramen);
                
                //set pesanan kuah
                Pesanan pesanan_kuah = new Pesanan(kuah_yang_dipilih, jumlah_kuah);
                pesanan_kuah.setKeterangan("Level " + level);
                
                //tambahkan pesanan kuah ke transaksi
                trans.tambahPesanan(pesanan_kuah);
                
                //hitung jumlah ramen yang belum dipesan kuahnya
                jumlah_ramen -= jumlah_kuah; 
            }while (jumlah_ramen > 0);
        }else{
            //jika keterangan tidak diisi tulis -
            System.out.print("Keterangan [- jika kosong]: ");
            keterangan = input.next();
        }
        
        //cek jika keterangan diisi selain "-" set ke pesanan
        if (!keterangan.equals("-")) {
            pesanan.setKeterangan(keterangan);
        }
        //konfirmasi, mau tambah pesanan atau tidak
        System.out.print("Tambah Pesanan Lagi? [Y/N] ");
        pesan_lagi = input.next();
    } while (pesan_lagi.equalsIgnoreCase("Y"));
    
    }
    
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
   
    public double cekInputNumber(String label) {
        try{
            Scanner get_input = new Scanner(System.in);
            System.out.print(label);
            double nilai = get_input.nextDouble();
            
            return nilai;
        }catch(InputMismatchException ex){
            System.out.println("[Err] Harap masukkan angka");
            return cekInputNumber(label);
        }
    }
}
