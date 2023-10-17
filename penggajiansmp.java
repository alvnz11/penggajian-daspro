import java.util.Scanner;
public class penggajiansmp {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // input
        int  tunjangan = 10000, percobaan = 5, jamMengajar,Jamlembur, pilihanMenu, hariMasuk; 
        double gaji, gajiAkhir, gajiLembur, totalLembur;
        String nama, pilihanGuru, menuLembur, posisiStaff, jabatan, pilihanJabatan, username, password;

        // System login
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
            //Penggajian Guru
            case 1 :
                System.out.println("Anda berada di dalam menu guru, Silahkan pilih status guru");
                System.out.println("1. Guru PNS");
                System.out.println("2. Guru Honorer");
                System.out.print("Masukkan status guru : "); 
                pilihanGuru = input.next();

                if (pilihanGuru.equalsIgnoreCase("1")) {
                    System.out.println("Masukkan Pilihan Jabatan");
                    System.out.println("1. Kepala Sekolah");
                    System.out.println("2. Guru Pengajar");
                    System.out.print("Masukkan Pilihan Anda : "); 
                    pilihanJabatan = input.next();

                    if (pilihanJabatan.equalsIgnoreCase("1")) {              
                        System.out.print("Masukkan Nama Guru : ");
                        nama = input.next();
                        System.out.print("Masukkan Gaji Guru : ");
                        gaji = input.nextDouble();
                        
                        jabatan = "Kepala Sekolah";
                        gajiAkhir = gaji + tunjangan;

                        System.out.println();
                        System.out.println("======Slip Gaji Guru Kepala Sekolah======");
                        System.out.println();
                        System.out.println("Nama Guru : " + nama);
                        System.out.println("Tunjangan = " + tunjangan);
                        System.out.println("Jabatan : " + jabatan);
                        System.out.println(String.format("Total gaji anda adalah : Rp. %s ", gajiAkhir));

                    } else if (pilihanJabatan.equalsIgnoreCase("2")) {
                        System.out.print("Masukkan nama guru : ");
                        nama = input.next();
                        System.out.print("Masukkan gaji guru perjam : "); // proses
                        gaji = input.nextInt();
                        System.out.print("Masukkan jam guru mengajar : ");
                        jamMengajar = input.nextInt();

                        jabatan = "Guru Pengajar";
                        gajiAkhir = gaji * jamMengajar + tunjangan;

                        System.out.println();
                        System.out.println("======Slip Gaji Guru PNS======");
                        System.out.println();
                        System.out.println("Nama Guru : " + nama);
                        System.out.println("Jabatan : " + jabatan);
                        System.out.println("Tunjangan = " + tunjangan);
                        System.out.println(String.format("Total gaji anda adalah : Rp. %s ", gajiAkhir));
                    }else {
                        System.out.println("Input Yang Anda Masukkan Salah");
                    }

                } else if (pilihanGuru.equalsIgnoreCase("2")) {
                    System.out.print("Masukkan nama guru : ");
                    nama = input.next();
                    System.out.print("Masukkan gaji guru perjam : "); // proses
                    gaji = input.nextInt();
                    System.out.print("Masukkan jam guru mengajar : ");
                    jamMengajar = input.nextInt();
                    System.out.println("Apakah anda ingin menambah Gaji (Ya/tidak)");
                    menuLembur = input.next();

                    if (menuLembur.equalsIgnoreCase("ya")) {
                        System.out.print("Masukkan gaji lembur per jam : ");
                        gajiLembur = input.nextInt();
                        System.out.print ("Masukkan jam mengajar lembur : ");
                        Jamlembur = input.nextInt();
                        totalLembur = Jamlembur * gajiLembur;
                        gajiAkhir = (gaji * jamMengajar) + totalLembur ;
                        input.close();

                        System.out.println();
                        System.out.println("======Slip Gaji Guru Honorer======");
                        System.out.println();
                        System.out.println("Nama Guru : " + nama);
                        System.out.println("Gaji lembur = " + totalLembur);
                        System.out.println(String.format("Total gaji anda adalah : Rp. %s ", gajiAkhir));
                    } else if (menuLembur.equalsIgnoreCase("tidak")) {
                        gajiAkhir = gaji * jamMengajar;

                        System.out.println();
                        System.out.println("======Slip Gaji Guru Honorer======");
                        System.out.println();
                        System.out.println("Nama Guru : " + nama);
                        System.out.println(String.format("Total gaji anda adalah : Rp. %s ", gajiAkhir));
                    } else {
                        System.out.println("Input yang anda masukkan salah!");
                    }
                } else {
                    System.out.println("Status Guru yang Anda Masukkan Salah!");
                }
                break;


            // Penggajian Staff
            case 2 : 
                System.out.print("Masukkan nama staff : ");
                nama = input.next();
                System.out.print("Masukkan posisi staff : ");
                posisiStaff = input.next();
                System.out.print("Masukkan hari masuk staff : ");
                hariMasuk = input.nextInt();
                System.out.print("Masukkan gaji staff : ");
                gaji = input.nextInt();
                gajiAkhir = (gaji * hariMasuk);

                System.out.println();
                System.out.println("======Slip Gaji Staff SMP Tadika Mesra======");
                System.out.println();
                System.out.println("Nama Staff : " + nama);
                System.out.println("Posisi Staff : " + posisiStaff);
                System.out.println(String.format("Total gaji anda adalah : Rp. %s ", gajiAkhir));
            break;
            default : 
                System.out.println("Menu yang anda masukkan salah! ");
        }

    }
}