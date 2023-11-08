import java.util.Arrays;
import java.util.Scanner;

public class penggajiansmp {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // Variabel
        int  tunjangan = 1000000, percobaan = 5, jamMengajar, Jamlembur, bulan, pilihanMenu; 
        double gaji, gajiLembur, gajiPerHariStaff = 50000;
        String username, password;
        
        //Sistem login
        do {
            System.out.print("Masukkan Username : ");
            username = input.next();
            System.out.print("Masukkan Password : ");
            password = input.next();

            if (username.equalsIgnoreCase("admin") && password.equalsIgnoreCase("admin")){
                System.out.println("Anda berhasil masuk");
                break;
            } else {
                percobaan--;
                System.out.println("Username dan password yang anda masukkan salah!");
                System.out.println("Sisa Percobaan masuk : " + percobaan);
            }            
        } while (percobaan > 0); 
        
        if (percobaan == 0) {
            System.out.println("Sisa percobaan anda telah habis, ulangi dalam 1 menit!");
        }

        
        // Pilihan Menu
        System.out.println();
        System.out.println("======================================");
        System.out.println("||                                  ||");
        System.out.println("||      SISTEM PENGGAJIAN GURU      ||");
        System.out.println("||                                  ||");
        System.out.println("======================================");
        System.out.println();
        System.out.println("Selamat Datang di Sistem Penggajian Guru SMP");
        System.out.println();
        System.out.println("Silahkan Pilih Menu Penggajian (Pilih salah satu!) ");
        System.out.println("1. Guru");
        System.out.println("2. Staff");
        System.out.print("Masukkan pilihan anda : ");
        pilihanMenu = input.nextInt();
        
        switch (pilihanMenu) {
            // Case Guru
            case 1 :
            int jmlGuru;
            System.out.println("Anda berada di dalam menu guru");
            System.out.print("Masukkan Jumlah Penggajian Guru : ");
            jmlGuru = input.nextInt();
            
            String[] nama = new String[jmlGuru];
            String[] pilihanGuru = new String[jmlGuru];
            String[] pilihanJabatan = new String[jmlGuru];
            String[] jabatan = new String[jmlGuru];
            String[] menuLembur = new String[jmlGuru];
            double[] gajiAkhir = new double[jmlGuru];
            double[] totalLembur = new double[jmlGuru];

            for (int i = 0; i < jmlGuru; i++) {
            
                System.out.println();
                System.out.println("STATUS GURU SMP");
                System.out.println("1. Guru PNS");
                System.out.println("2. Guru Honorer");
                System.out.print("Masukkan status guru : "); 
                pilihanGuru[i] = input.next();

                // Pilihan Guru PNS
                if (pilihanGuru[i].equalsIgnoreCase("1")) {
                    System.out.println();
                    System.out.println("JABATAN GURU SMP");
                    System.out.println("1. Kepala Sekolah");
                    System.out.println("2. Guru Pengajar");
                    System.out.print("Masukkan Pilihan Anda : "); 
                    pilihanJabatan[i] = input.next();

                    // Menu Jabatan Kepala Sekolah (Tanpa jam Mengajar)
                    if (pilihanJabatan[i].equalsIgnoreCase("1")) {              
                        System.out.print("Masukkan Nama Guru : ");
                        nama[i] = input.next();
                        System.out.print("Masukkan Gaji Guru : ");
                        gaji = input.nextDouble();
                        
                        jabatan[i] = "Kepala Sekolah";
                        gajiAkhir[i] = gaji + tunjangan;

                        System.out.println();
                        System.out.println("======Slip Gaji Guru Kepala Sekolah SMP======");
                        System.out.println();
                        System.out.println("Nama Guru : " + nama[i]);
                        System.out.println("Tunjangan = " + tunjangan);
                        System.out.println("Jabatan : " + jabatan[i]);
                        System.out.println(String.format("Total gaji anda adalah : Rp. %s ", gajiAkhir[i]));

                    // Menu Jabatan Guru Mengajar 
                    } else if (pilihanJabatan[i].equalsIgnoreCase("2")) {
                        System.out.print("Masukkan nama guru : ");
                        nama[i] = input.next();
                        System.out.print("Masukkan gaji guru perjam : "); 
                        gaji = input.nextInt();
                        System.out.print("Masukkan jam guru mengajar : ");
                        jamMengajar = input.nextInt();

                        jabatan[i] = "Guru Pengajar";
                        gajiAkhir[i] = gaji * jamMengajar + tunjangan;

                        System.out.println();
                        System.out.println("======Slip Gaji Guru PNS SMP======");
                        System.out.println();
                        System.out.println("Nama Guru : " + nama[i]);
                        System.out.println("Jabatan : " + jabatan[i]);
                        System.out.println("Tunjangan = " + tunjangan);
                        System.out.println(String.format("Total gaji anda adalah : Rp. %s ", gajiAkhir[i]));

                    // Inputan Salah
                    }else {
                        System.out.println("Input Yang Anda Masukkan Salah");
                    }    

                // Pilihan Guru Honorer
                } else if (pilihanGuru[i].equalsIgnoreCase("2")) {
                    System.out.print("Masukkan nama guru : ");
                    nama[i] = input.next();
                    System.out.print("Masukkan gaji guru perjam : "); 
                    gaji = input.nextInt();
                    System.out.print("Masukkan jam guru mengajar : ");
                    jamMengajar = input.nextInt();
                    
                    //Menu Lembur
                    System.out.print("Apakah anda ingin menambah Gaji Lembur (y/t) : ");
                    menuLembur[i] = input.next();
                    if (menuLembur[i].equalsIgnoreCase("y")) {
                        System.out.print("Masukkan gaji lembur per jam : ");
                        gajiLembur = input.nextInt();
                        System.out.print ("Masukkan jam mengajar lembur : ");
                        Jamlembur = input.nextInt();

                        totalLembur[i] = Jamlembur * gajiLembur;
                        gajiAkhir[i] = (gaji * jamMengajar) + totalLembur[i] ;

                        System.out.println();
                        System.out.println("======Slip Gaji Guru Honorer SMP======");
                        System.out.println();
                        System.out.println("Nama Guru : " + nama[i]);
                        System.out.println("Gaji lembur = " + totalLembur[i]);
                        System.out.println(String.format("Total gaji anda adalah : Rp. %s ", gajiAkhir[i]));

                    } else if (menuLembur[i].equalsIgnoreCase("t")) {
                        gajiAkhir[i] = gaji * jamMengajar;

                        System.out.println();
                        System.out.println("======Slip Gaji Guru Honorer SMP======");
                        System.out.println();
                        System.out.println("Nama Guru : " + nama[i]);
                        System.out.println(String.format("Total gaji anda adalah : Rp. %s ", gajiAkhir[i]));

                    } else {
                        System.out.println("Input yang anda masukkan salah!");
                    }

                // Inputan Status Guru Salah   
                } else {
                    System.out.println("Status Guru yang Anda Masukkan Salah!");
                }
            }
                break;

            // Case Staff
            case 2 : 
                int jmlStaff;
                System.out.print("Masukkan Jumlah Penggajian Staff : ");
                jmlStaff = input.nextInt();

                int[] hariMasuk = new int[jmlStaff];
                String[] posisiStaff = new String[jmlStaff];
                String[] namaStaff = new String[jmlStaff];
                String[] menuStaff = new String[jmlStaff];
                double[] gajiBulananStaff = new double[jmlStaff];
                double[][] gajiStaff = new double[12][namaStaff.length];
                
                for (int i = 0; i < jmlStaff; i++) {
                    System.out.print("Masukkan nama staff : ");
                    namaStaff[i] = input.next();
                    System.out.println("POSISI STAFF SMP");
                    System.out.println("1. Security");
                    System.out.println("2. Office Boy");
                    System.out.println("3. Petugas Perpustakaan");
                    System.out.println("4. Tata Usaha");
                    System.out.print("Masukkan pilihan posisi staff : ");
                    menuStaff[i] = input.next();
                    System.out.print("Masukkan hari masuk staff : ");
                    hariMasuk[i] = input.nextInt();
                    System.out.print("Masukkan bulan : ");
                    bulan = input.nextInt();
                    
                
                    gajiBulananStaff[i] = hariMasuk[i] * gajiPerHariStaff;
                    
                    if (menuStaff[i].equalsIgnoreCase("1")) {
                        posisiStaff[i] = "Security";
                        
                        System.out.println();
                        System.out.println("======Slip Gaji Staff SMP======");
                        System.out.println();
                        System.out.println("Nama Staff : " + namaStaff[i]);
                        System.out.println("Posisi Staff : " + posisiStaff[i]);
                        System.out.println(String.format("Total gaji anda adalah : Rp. %s ", gajiBulananStaff[i]));

                        gajiStaff[bulan-1][i] = gajiBulananStaff[i];
                    } else if (menuStaff[i].equalsIgnoreCase("2")) {
                        posisiStaff[i] = "Office Boy";
                        
                        System.out.println();
                        System.out.println("======Slip Gaji Staff SMP======");
                        System.out.println();
                        System.out.println("Nama Staff : " + namaStaff[i]);
                        System.out.println("Posisi Staff : " + posisiStaff[i]);
                        System.out.println(String.format("Total gaji anda adalah : Rp. %s ", gajiBulananStaff[i]));

                        gajiStaff[bulan-1][i] = gajiBulananStaff[i];
                    } else if (menuStaff[i].equalsIgnoreCase("3")) {
                        posisiStaff[i] = "Petugas Perpustakaan";
                        
                        System.out.println();
                        System.out.println("======Slip Gaji Staff SMP======");
                        System.out.println();
                        System.out.println("Nama Staff : " + namaStaff[i]);
                        System.out.println("Posisi Staff : " + posisiStaff[i]);
                        System.out.println(String.format("Total gaji anda adalah : Rp. %s ", gajiBulananStaff[i]));

                        gajiStaff[bulan-1][i] = gajiBulananStaff[i];
                    } else if (menuStaff[i].equalsIgnoreCase("4")) {
                        posisiStaff[i] = "Tata Usaha";
                        
                        System.out.println();
                        System.out.println("======Slip Gaji Staff SMP======");
                        System.out.println();
                        System.out.println("Nama Staff : " + namaStaff[i]);
                        System.out.println("Posisi Staff : " + posisiStaff[i]);
                        System.out.println(String.format("Total gaji anda adalah : Rp. %s ", gajiBulananStaff[i]));

                        gajiStaff[bulan-1][i] = gajiBulananStaff[i];
                    } else {
                        System.out.println("Input yang anda masukkan salah!");
                    }


                    
                    // gajiBulananStaff = hariMasuk * gajiPerHariStaff;
                    // gajiStaff[namaStaff.length][bulan] = gajiBulananStaff;
                    
                }
                    for (int i = 0; i < gajiStaff.length; i++) {
                        System.out.println();
                        System.out.println("Gaji bulan ke-" + (i + 1) + " = " + Arrays.toString(gajiStaff[i]));
                    }
                    break;
                   
                default: 
                System.out.println("Menu yang anda masukkan salah! ");
            
        }
    }
}