import java.util.Scanner;

public class main {

    // Fungsi slip gaji Honorer
    static void slipHonorer(String nama, double totalLembur, double gajiAkhir) {
        System.out.println();
        System.out.println("======Slip Gaji Guru Honorer======");
        System.out.println();
        System.out.println("Nama Guru : " + nama);
        System.out.println("Gaji lembur : " + totalLembur);
        System.out.println(String.format("Total gaji anda adalah : Rp. %s ", gajiAkhir));         
    }

    // Fungsi slip gaji PNS
    static void slipGuru(String nama, String jabatan, int tunjangan, double gajiAkhir) {
        System.out.println();
        System.out.println("======Slip Gaji Guru PNS======");
        System.out.println();
        System.out.println("Nama Guru : " + nama);
        System.out.println("Jabatan : " + jabatan);
        System.out.println("Tunjangan : " + tunjangan);
        System.out.println(String.format("Total gaji anda adalah : Rp. %s ", gajiAkhir));
    }

    // Fungsi slip gaji Staff
    static void slipStaff(String nama, String posisi, double gajiAkhir) {
        System.out.println();
        System.out.println("======Slip Gaji Staff SMP Tadika Mesra======");
        System.out.println();
        System.out.println("Nama Staff : " + nama);
        System.out.println("Posisi Staff : " + posisi);
        System.out.println(String.format("Total gaji anda adalah : Rp. %s ", gajiAkhir));
    }

    // Fungsi perhitungan gaji akhir
    static double hitungGaji(double gaji, int jam) {
        double akhir = gaji * jam;
        return akhir;
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // Variabel
        int  tunjangan = 1000000, jamMengajar, Jamlembur, pilihanMenu, hariMasuk; 
        double gaji, gajiAkhir, gajiLembur, totalLembur, gajiStaff = 50000;
        String nama, pilihanGuru, menuLembur, posisiStaff, jabatan, pilihanJabatan, username, password;
        boolean login = true, exit = true;
        
        System.out.println();
        System.out.println("======================================");
        System.out.println("||                                  ||");
        System.out.println("||       SISTEM PENGGAJIAN SMP      ||");
        System.out.println("||                                  ||");
        System.out.println("======================================");
        System.out.println();
        System.out.println("Selamat Datang di Sistem Penggajian Guru SMP");
        
        while (login) {
            System.out.println();
            System.out.print("Masukkan Username : ");
            username = input.next();
            System.out.print("Masukkan Password : ");
            password = input.next();

            if (username.equalsIgnoreCase("admin") && password.equals("admin")) {
                login = false;
                System.out.println("Anda berhasil masuk");
            } else {
                System.out.println("Username dan password yang anda masukkan salah!, silahkan coba lagi.");
            }
        }

        while (exit) {
            // Pilihan Menu
            System.out.println();
            System.out.println("Silahkan Pilih Menu Penggajian (Pilih salah satu!) ");
            System.out.println("1. Guru");
            System.out.println("2. Staff");
            System.out.println("3. Guru Eksternal");
            System.out.println("0. Exit");
            System.out.print("Masukkan pilihan anda : ");
            pilihanMenu = input.nextInt();
            
            switch (pilihanMenu) {
                // Case Guru
                case 1 :
                
                System.out.println();
                System.out.println("======================================");
                System.out.println("||                                  ||");
                System.out.println("||          PENGGAJIAN GURU         ||");
                System.out.println("||                                  ||");
                System.out.println("======================================");
                System.out.println();
                System.out.print("Masukkan jumlah Guru : ");
                int jmlGuru = input.nextInt();

                String daftarGuru[][] = new String[jmlGuru][2];
                double daftarGajiGuru[] = new double[jmlGuru];

                for (int i = 0; i < daftarGuru.length; i++) {
                    System.out.println();
                    System.out.println("Anda berada di dalam menu guru, Silahkan pilih status guru");
                    System.out.println("1. Guru PNS");
                    System.out.println("2. Guru Honorer");
                    System.out.print("Masukkan status guru : "); 
                    pilihanGuru = input.next();

                    // Pilihan Jabatan PNS
                    if (pilihanGuru.equalsIgnoreCase("1")) {
                        System.out.println("Masukkan Pilihan Jabatan");
                        System.out.println("1. Kepala Sekolah");
                        System.out.println("2. Guru Pengajar");
                        System.out.print("Masukkan Pilihan Anda : "); 
                        pilihanJabatan = input.next();

                        // Menu Jabatan Kepala Sekolah (Tanpa jam Mengajar)
                        if (pilihanJabatan.equalsIgnoreCase("1")) {              
                            System.out.print("Masukkan Nama Guru : ");
                            nama = input.next();
                            System.out.print("Masukkan Gaji Guru : ");
                            gaji = input.nextDouble();
                            
                            jabatan = "Kepala Sekolah";
                            gajiAkhir = gaji + tunjangan;
                            daftarGuru[i][0] = nama;
                            daftarGuru[i][1] = jabatan;
                            daftarGajiGuru[i] = gajiAkhir;

                            slipGuru(nama, jabatan, tunjangan, gajiAkhir);

                        // Menu Jabatan Guru Mengajar 
                        } else if (pilihanJabatan.equalsIgnoreCase("2")) {
                            System.out.print("Masukkan nama guru : ");
                            nama = input.next();
                            System.out.print("Masukkan gaji guru perjam : "); 
                            gaji = input.nextInt();
                            System.out.print("Masukkan jam guru mengajar : ");
                            jamMengajar = input.nextInt();

                            jabatan = "Guru Pengajar";
                            gajiAkhir = hitungGaji(gaji, jamMengajar) + tunjangan;
                            daftarGuru[i][0] = nama;
                            daftarGuru[i][1] = jabatan;
                            daftarGajiGuru[i] = gajiAkhir;

                            slipGuru(nama, jabatan, tunjangan, gajiAkhir);

                        // Inputan Salah
                        }else {
                            System.out.println("Input Yang Anda Masukkan Salah");
                        }    

                    // Pilihan Guru Honorer
                    } else if (pilihanGuru.equalsIgnoreCase("2")) {
                        System.out.print("Masukkan nama guru : ");
                        nama = input.next();
                        System.out.print("Masukkan gaji guru perjam : "); 
                        gaji = input.nextInt();
                        System.out.print("Masukkan jam guru mengajar : ");
                        jamMengajar = input.nextInt();
                        
                        //Menu Lembur
                        System.out.println("Apakah anda ingin menambah Gaji Lembur (y/t)");
                        menuLembur = input.next();
                        if (menuLembur.equalsIgnoreCase("y")) {
                            System.out.print("Masukkan gaji lembur per jam : ");
                            gajiLembur = input.nextInt();
                            System.out.print ("Masukkan jam mengajar lembur : ");
                            Jamlembur = input.nextInt();

                            jabatan = "Honorer\t";
                            totalLembur = Jamlembur * gajiLembur;
                            gajiAkhir = hitungGaji(gaji, jamMengajar) + totalLembur;
                            daftarGuru[i][0] = nama;
                            daftarGuru[i][1] = jabatan;
                            daftarGajiGuru[i] = gajiAkhir;

                            slipHonorer(nama, totalLembur, gajiAkhir);

                        } else if (menuLembur.equalsIgnoreCase("t")) {
                            jabatan = "Honorer\t";
                            gajiAkhir = hitungGaji(gaji, jamMengajar);
                            daftarGuru[i][0] = nama;
                            daftarGuru[i][1] = jabatan;
                            daftarGajiGuru[i] = gajiAkhir;
                            totalLembur = 0;

                            slipHonorer(nama, totalLembur, gajiAkhir);

                        } else {
                            System.out.println("Input yang anda masukkan salah!");
                        }

                    // Inputan Status Guru Salah   
                    } else {
                        System.out.println("Status Guru yang Anda Masukkan Salah!");
                    }
                }

                System.out.println();
                System.out.println("======================================");
                System.out.println("||                                  ||");
                System.out.println("||      LAPORAN PENGGAJIAN GURU     ||");
                System.out.println("||                                  ||");
                System.out.println("======================================");
                System.out.println();

                for (int i = 0; i < daftarGuru.length; i++) {
                    System.out.println("Guru ke-" + (i+1) + ": " + daftarGuru[i][0] + "\t - \t" 
                    + daftarGuru[i][1] + "\t - \tTotal Gaji: Rp. " + daftarGajiGuru[i]);
                }

                break;

                // Case Staff
                case 2 : 

                System.out.println();
                System.out.println("======================================");
                System.out.println("||                                  ||");
                System.out.println("||          PENGGAJIAN STAFF        ||");
                System.out.println("||                                  ||");
                System.out.println("======================================");
                System.out.println();
                System.out.print("Masukkan jumlah Staff : ");
                int jmlStaff = input.nextInt();

                String daftarStaff[][] = new String[jmlStaff][2];
                double daftarGajiStaff[] = new double[jmlStaff];

                for (int i = 0; i < daftarStaff.length; i++) {
                    System.out.println();
                    System.out.print("Masukkan nama staff : ");
                    nama = input.next();
                    System.out.println("POSISI STAFF SMP");
                    System.out.println("1. Security");
                    System.out.println("2. Office Boy");
                    System.out.println("3. Petugas Perpustakaan");
                    System.out.println("4. Tata Usaha");
                    System.out.print("Masukkan pilihan posisi staff : ");
                    int menuStaff = input.nextInt();
                    System.out.print("Masukkan hari masuk staff : ");
                    hariMasuk = input.nextInt();;

                    switch (menuStaff) {
                        case 1:
                        posisiStaff = "Security";

                        gajiAkhir = hitungGaji(gajiStaff, hariMasuk);
                        daftarStaff[i][0] = nama;
                        daftarStaff[i][1] = posisiStaff;
                        daftarGajiStaff[i] = gajiAkhir;

                        slipStaff(nama, posisiStaff, gajiAkhir);
                        break;

                        case 2:
                        posisiStaff = "Office Boy";

                        gajiAkhir = hitungGaji(gajiStaff, hariMasuk);
                        daftarStaff[i][0] = nama;
                        daftarStaff[i][1] = posisiStaff;
                        daftarGajiStaff[i] = gajiAkhir;

                        slipStaff(nama, posisiStaff, gajiAkhir);
                        break;

                        case 3:
                        posisiStaff = "Petugas Perpustakaan";

                        gajiAkhir = hitungGaji(gajiStaff, hariMasuk);
                        daftarStaff[i][0] = nama;
                        daftarStaff[i][1] = posisiStaff;
                        daftarGajiStaff[i] = gajiAkhir;

                        slipStaff(nama, posisiStaff, gajiAkhir);
                        break;

                        case 4:
                        posisiStaff = "Tata Usaha";

                        gajiAkhir = hitungGaji(gajiStaff, hariMasuk);
                        daftarStaff[i][0] = nama;
                        daftarStaff[i][1] = posisiStaff;
                        daftarGajiStaff[i] = gajiAkhir;

                        slipStaff(nama, posisiStaff, gajiAkhir);
                        break;
                            
                        default:
                        break;
                    }

                }

                System.out.println();
                System.out.println("======================================");
                System.out.println("||                                  ||");
                System.out.println("||     LAPORAN PENGGAJIAN STAFF     ||");
                System.out.println("||                                  ||");
                System.out.println("======================================");
                System.out.println();

                for (int i = 0; i < daftarStaff.length; i++) {
                    System.out.println("Staff ke-" + (i+1) + ": " + daftarStaff[i][0] + "\t - \t" + daftarStaff[i][1] + "\t - \tTotal Gaji: Rp. " + daftarGajiStaff[i]);
                }
                break;
                    
                
                // Guru Eksternal
                case 3 :

                System.out.println();
                System.out.println("======================================");
                System.out.println("||                                  ||");
                System.out.println("||     PENGGAJIAN GURU EKSTERNAL    ||");
                System.out.println("||                                  ||");
                System.out.println("======================================");
                System.out.println();
                System.out.print("Masukkan jumlah guru Eksternal : ");
                int jmlEks = input.nextInt();

                String lapEks[][] = new String[jmlEks][3];

                for (int i = 0; i < lapEks.length; i++) {
                    System.out.println("Guru Eksternal ke-" + (i+1));
                    for (int j = 0; j < lapEks[0].length; j++) {
                        if (j == 0) {
                            System.out.print("Nama" + ": ");
                            lapEks[i][j] = input.next();
                        } else if (j == 1) {
                            System.out.print("Posisi" + ": ");
                            lapEks[i][j] = input.next();
                        } else if (j == 2) {
                            System.out.print("Gaji" + ": ");
                            lapEks[i][j] = input.next();
                        }
                    }
                    System.out.println();
                }

                System.out.println("======================================");
                System.out.println("||                                  ||");
                System.out.println("||   LAPORAN PENGGAJIAN EKSTERNAL   ||");
                System.out.println("||                                  ||");
                System.out.println("======================================");
                System.out.println();

                for (int i = 0; i < lapEks.length; i++) {
                    System.out.println("Guru Eksternal ke-" + (i+1) + ": ");
                    for (String out : lapEks[i]) {
                        System.out.print(out + " \t - \t ");
                    }
                    System.out.println();
                }
                break;
                
                case 0:
                System.out.println("Anda Berhasil keluar!");
                exit = false;
                break;

                default: 
                System.out.println("Menu yang anda masukkan SALAH! ");
                System.out.println("Silahkan ulangi lagi!");
            }
        }    
    }
}