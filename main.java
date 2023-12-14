import java.util.Scanner;

public class main {

    private static Scanner input = new Scanner(System.in);

    // Fungsi login
    static void login() {
        boolean login = true;
        String username, password;
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
    }

    // Fungsi slip gaji Honorer
    static void slipHonorer(String nama, double totalLembur, double gajiAkhir) {
        System.out.println();
        System.out.println("+-------------------------------------------+");
        System.out.println("|            Slip Gaji Guru Honorer         |");
        System.out.println("+-------------------------------------------+");
        System.out.printf("| %-20s | %-18s |\n", "Nama Guru", nama);
        System.out.printf("| %-20s | %-18s |\n", "Gaji Lembur", totalLembur);
        System.out.printf("| %-20s | %-18s |\n", "Total Gaji", String.format("Rp. %,.2f", gajiAkhir));
        System.out.println("+-------------------------------------------+");
        System.out.println();
    }
    

    // Fungsi slip gaji PNS
    static void slipGuru(String nama, String jabatan, int tunjangan, double gajiAkhir) {
        System.out.println();
        System.out.println("+---------------------------------------------+");
        System.out.println("|              Slip Gaji Guru PNS             |");
        System.out.println("+---------------------------------------------+");
        System.out.printf("| %-20s | %-20s |\n", "Nama Guru", nama);
        System.out.printf("| %-20s | %-20s |\n", "Jabatan", jabatan);
        System.out.printf("| %-20s | %-20s |\n", "Tunjangan", tunjangan);
        System.out.printf("| %-20s | %-20s |\n", "Total Gaji", String.format("Rp. %,.2f", gajiAkhir));
        System.out.println("+---------------------------------------------+");
        System.out.println();
    }
    
    

    // Fungsi slip gaji Staff
    static void slipStaff(String nama, String posisi, double gajiAkhir) {
        System.out.println();
        System.out.println("+---------------------------------------------+");
        System.out.println("|       Slip Gaji Staff SMP Tadika Mesra      |");
        System.out.println("+---------------------------------------------+");
        System.out.printf("| %-20s | %-20s |\n", "Nama Staff", nama);
        System.out.printf("| %-20s | %-20s |\n", "Posisi Staff", posisi);
        System.out.printf("| %-20s | %-20s |\n", "Total Gaji", String.format("Rp. %,.2f", gajiAkhir));
        System.out.println("+---------------------------------------------+");
        System.out.println();
    }

    // Fungsi perhitungan gaji akhir
    static double hitungGaji(double gaji, int jam) {
        double akhir = gaji * jam;
        return akhir;
    }

    public static void main(String[] args) {
        // Variabel
        int  tunjangan = 1000000, jamMengajar, Jamlembur, hariMasuk; 
        double gaji, gajiAkhir, gajiLembur, totalLembur, gajiStaff = 50000;
        String nama, menuLembur, posisiStaff, jabatan;
        boolean exit = true, loop1 = true, loop2 = true, loop3 = true;

        String daftarGuru[][] = new String[15][2];
        double daftarGajiGuru[] = new double[15];
        String daftarStaff[][] = new String[15][2];
        double daftarGajiStaff[] = new double[15];
        String lapEks[][] = new String[5][3];
        
        System.out.println();
        System.out.println("======================================");
        System.out.println("||                                  ||");
        System.out.println("||       SISTEM PENGGAJIAN SMP      ||");
        System.out.println("||                                  ||");
        System.out.println("======================================");
        System.out.println();
        System.out.println("Selamat Datang di Sistem Penggajian Guru SMP");
        
        // login();

        int g = 0;
        int s = 0;
        while (exit) {
            System.out.println();
            System.out.println("======================================");
            System.out.println("||                                  ||");
            System.out.println("||        MENU PENGGAJIAN SMP       ||");
            System.out.println("||                                  ||");
            System.out.println("======================================");
            System.out.println();
            System.out.println("Silahkan Pilih Menu Penggajian (Pilih salah satu!) ");
            System.out.println("1. Input Data Guru");
            System.out.println("2. Cetak Laporan Penggajian");
            System.out.println("3. Edit Data Guru");
            System.out.println("0. Exit");
            System.out.print("Masukkan pilihan anda : ");
            char menu = input.next().charAt(0);

            switch (menu) {
                // Case Exit
                case '0':
                    exit = false;
                    break;

                // Case input data
                case '1':
                    loop1 = true;
                    while (loop1) {
                        System.out.println();
                        System.out.println("   ## Menu Penggajian ## ");
                        System.out.println("---------------------------");
                        System.out.println("1. Guru");
                        System.out.println("2. Staff");
                        System.out.println("3. Guru Eksternal");
                        System.out.println("0. Keluar");
                        System.out.println("---------------------------");
                        System.out.print("Masukkan pilihan anda : ");
                        char menuGaji = input.next().charAt(0);
                        input.nextLine();

                        switch (menuGaji) {
                            // Keluar dari menu Input data guru
                            case '0':
                                loop1 = false;
                                break;

                            // Penggajian Guru
                            case '1':
                                System.out.println();
                                System.out.println("======================================");
                                System.out.println("||                                  ||");
                                System.out.println("||          PENGGAJIAN GURU         ||");
                                System.out.println("||                                  ||");
                                System.out.println("======================================");
                                System.out.println();
                                System.out.println("Anda berada di dalam menu guru, Silahkan pilih status guru!");
                                System.out.print("1. Guru PNS\t\t");
                                System.out.println("2. Guru Honorer");
                                System.out.println();
                                System.out.print("Masukkan pilihan anda : "); 
                                char statusGuru = input.next().charAt(0);
                                System.out.println("---------------------------------------------------------------");
                                input.nextLine();

                                switch (statusGuru) {
                                    // PNS
                                    case '1':
                                        System.out.println("Masukkan Pilihan Jabatan");
                                        System.out.print("1. Kepala Sekolah\t\t");
                                        System.out.println("2. Guru Pengajar");
                                        System.out.println();
                                        System.out.print("Masukkan Pilihan Anda : "); 
                                        char jabatanGuru = input.next().charAt(0);
                                        System.out.println("---------------------------------------------------------------");
                                        input.nextLine();

                                        switch (jabatanGuru) {
                                            // Kepala Sekolah
                                            case '1':
                                                System.out.print("Masukkan Nama Guru : ");
                                                nama = input.nextLine();
                                                System.out.print("Masukkan Gaji Guru : ");
                                                gaji = input.nextDouble();
                                                input.nextLine();

                                                jabatan = "Kepala Sekolah";
                                                gajiAkhir = gaji + tunjangan;
                                                daftarGuru[g][0] = nama;
                                                daftarGuru[g][1] = jabatan;
                                                daftarGajiGuru[g] = gajiAkhir;
                                                g++;

                                                slipGuru(nama, jabatan, tunjangan, gajiAkhir);
                                                break;

                                            // Guru Pengajar
                                            case '2':
                                                System.out.print("Masukkan nama guru : ");
                                                nama = input.nextLine();
                                                System.out.print("Masukkan gaji guru perjam : "); 
                                                gaji = input.nextInt();
                                                System.out.print("Masukkan jam guru satu bulan : ");
                                                jamMengajar = input.nextInt();
                                                input.nextLine();

                                                jabatan = "Guru Pengajar";
                                                gajiAkhir = hitungGaji(gaji, jamMengajar) + tunjangan;
                                                daftarGuru[g][0] = nama;
                                                daftarGuru[g][1] = jabatan;
                                                daftarGajiGuru[g] = gajiAkhir;
                                                g++;

                                                slipGuru(nama, jabatan, tunjangan, gajiAkhir);

                                                break;
                                        
                                            default:
                                                System.out.println("Menu yang anda masukkan salah! Silahkan coba lagi!");
                                                break;
                                        }
                                        break;

                                    // Honorer
                                    case '2':
                                        System.out.print("Masukkan nama guru : ");
                                        nama = input.nextLine();
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
                                            input.nextLine();

                                            jabatan = "Honorer\t";
                                            totalLembur = Jamlembur * gajiLembur;
                                            gajiAkhir = hitungGaji(gaji, jamMengajar) + totalLembur;
                                            daftarGuru[g][0] = nama;
                                            daftarGuru[g][1] = jabatan;
                                            daftarGajiGuru[g] = gajiAkhir;
                                            g++;

                                            slipHonorer(nama, totalLembur, gajiAkhir);

                                        } else if (menuLembur.equalsIgnoreCase("t")) {
                                            jabatan = "Honorer\t";
                                            gajiAkhir = hitungGaji(gaji, jamMengajar);
                                            daftarGuru[g][0] = nama;
                                            daftarGuru[g][1] = jabatan;
                                            daftarGajiGuru[g] = gajiAkhir;
                                            totalLembur = 0;
                                            g++;

                                            slipHonorer(nama, totalLembur, gajiAkhir);

                                        } else {
                                            System.out.println("Input yang anda masukkan salah!");
                                        }
                                        break;
                                
                                    default:
                                        System.out.println("Menu yang anda masukkan salah! Silahkan coba lagi!");
                                        break;
                                }
                                break;

                            // Penggajian Staff
                            case '2':
                                System.out.println();
                                System.out.println("======================================");
                                System.out.println("||                                  ||");
                                System.out.println("||          PENGGAJIAN STAFF        ||");
                                System.out.println("||                                  ||");
                                System.out.println("======================================");
                                System.out.println();
                                System.out.print("Masukkan nama staff : ");
                                nama = input.nextLine();
                                System.out.println("POSISI STAFF SMP");
                                System.out.println("1. Security\t\t\t3. Petugas Perpustakaan");
                                System.out.println("2. Office Boy\t\t\t4. Tata Usaha");
                                System.out.println();
                                System.out.print("Masukkan pilihan posisi staff : ");
                                int menuStaff = input.nextInt();
                                System.out.print("Masukkan hari masuk staff : ");
                                hariMasuk = input.nextInt();;
                                input.nextLine();

                                gajiAkhir = hitungGaji(gajiStaff, hariMasuk);
                                daftarStaff[s][0] = nama;
                                daftarGajiStaff[s] = gajiAkhir;

                                switch (menuStaff) {
                                    case 1:
                                    posisiStaff = "Security";
                                    daftarStaff[s][1] = posisiStaff;
                                    s++;

                                    slipStaff(nama, posisiStaff, gajiAkhir);
                                    break;

                                    case 2:
                                    posisiStaff = "Office Boy";
                                    daftarStaff[s][1] = posisiStaff;
                                    s++;

                                    slipStaff(nama, posisiStaff, gajiAkhir);
                                    break;

                                    case 3:
                                    posisiStaff = "Petugas Perpustakaan";
                                    daftarStaff[s][1] = posisiStaff;
                                    s++;

                                    slipStaff(nama, posisiStaff, gajiAkhir);
                                    break;

                                    case 4:
                                    posisiStaff = "Tata Usaha";
                                    daftarStaff[s][1] = posisiStaff;
                                    s++;

                                    slipStaff(nama, posisiStaff, gajiAkhir);
                                    break;
                                        
                                    default:
                                    break;
                                }
                                break;

                            // Penggajian Eksternal
                            case '3':
                                System.out.println();
                                System.out.println("======================================");
                                System.out.println("||                                  ||");
                                System.out.println("||     PENGGAJIAN GURU EKSTERNAL    ||");
                                System.out.println("||                                  ||");
                                System.out.println("======================================");
                                System.out.println();

                                for (int i = 0; i < lapEks.length; i++) {
                                    System.out.println("Guru Eksternal ke-" + (i+1));
                                    for (int j = 0; j < lapEks[0].length; j++) {
                                        if (j == 0) {
                                            System.out.print("Nama" + ": ");
                                            lapEks[i][j] = input.nextLine();
                                        } else if (j == 1) {
                                            System.out.print("Posisi" + ": ");
                                            lapEks[i][j] = input.nextLine();
                                        } else if (j == 2) {
                                            System.out.print("Gaji" + ": ");
                                            lapEks[i][j] = input.nextLine();
                                        }
                                    }
                                    System.out.println();
                                }
                                break;
                        
                            default:
                                System.out.println("Menu yang anda masukkan salah! Silahkan coba lagi!");
                                break;
                        }
                    }
                    break;

                // Case Menampilkan Data
                case '2':
                    loop2 = true;
                    while (loop2) {
                        System.out.println();
                        System.out.println("   ## Menu Penggajian ## ");
                        System.out.println("---------------------------");
                        System.out.println("1. Guru");
                        System.out.println("2. Staff");
                        System.out.println("3. Guru Eksternal");
                        System.out.println("0. Keluar");
                        System.out.println("---------------------------");
                        System.out.print("Masukkan pilihan anda : ");
                        char menuLaporan = input.next().charAt(0);

                        switch (menuLaporan) {
                            case '0':
                                loop2 = false;
                                break;

                            // Laporan Penggajian Guru
                            case '1':
                                System.out.println();
                                System.out.println("======================================");
                                System.out.println("||                                  ||");
                                System.out.println("||      LAPORAN PENGGAJIAN GURU     ||");
                                System.out.println("||                                  ||");
                                System.out.println("======================================");
                                System.out.println();

                                System.out.println(String.format("%-15s %-15s %-17s %-15s", "Guru ke-", "Nama Guru", "Jabatan Guru", "Total Gaji"));
                                System.out.println(String.format("%-15s %-15s %-17s %-15s", "-----------", "------------", "--------------", "-------------"));

                                for (int i = 0; i < daftarGuru.length; i++) {
                                    System.out.println(String.format("%-15s %-15s %-17s %-15s", + (i+1), daftarGuru[i][0], daftarGuru[i][1], "Rp. " + daftarGajiGuru[i]));
                                }
                                break;

                            // Laporan Penggajian Staff
                            case '2':
                                System.out.println();
                                System.out.println("======================================");
                                System.out.println("||                                  ||");
                                System.out.println("||     LAPORAN PENGGAJIAN STAFF     ||");
                                System.out.println("||                                  ||");
                                System.out.println("======================================");
                                System.out.println();

                                System.out.println(String.format("%-15s %-15s %-22s %-15s", "Staff ke-", "Nama Staff", "Posisi Staff", "Total Gaji"));
                                System.out.println(String.format("%-15s %-15s %-22s %-15s", "-----------", "------------", "------------", "-------------"));

                                for (int i = 0; i < daftarStaff.length; i++) {
                                    System.out.println(String.format("%-15s %-15s %-22s %-15s", + (i+1), daftarStaff[i][0], daftarStaff[i][1], "Rp. " + daftarGajiStaff[i]));
                                }
                                break;

                            // Laporan Penggajian Eksternal
                            case '3':
                                System.out.println();
                                System.out.println("======================================");
                                System.out.println("||                                  ||");
                                System.out.println("||   LAPORAN PENGGAJIAN EKSTERNAL   ||");
                                System.out.println("||                                  ||");
                                System.out.println("======================================");
                                System.out.println();

                                System.out.println(String.format("%-15s %-15s %-15s %-15s", "Eksternal ke-", "Nama Eksternal", "Posisi", "Total Gaji"));
                                System.out.println(String.format("%-15s %-15s %-15s %-15s", "-----------", "------------", "------------", "-------------"));

                                for (int i = 0; i < lapEks.length; i++) {
                                    System.out.println(String.format("%-15s %-15s %-15s %-15s", + (i+1), lapEks[i][0], lapEks[i][1], "Rp. " + lapEks[i][2]));
                                }
                                break;
                        
                            default:
                                System.out.println("Menu yang anda masukkan salah! Silahkan coba lagi!");
                                break;
                        }
                    }
                    break;

                // Case Edit data
                case '3':
                    loop3 = true;
                    while (loop3) {
                        System.out.println();
                        System.out.println("   ## Menu Penggajian ## ");
                        System.out.println("---------------------------");
                        System.out.println("1. Guru");
                        System.out.println("2. Staff");
                        System.out.println("3. Guru Eksternal");
                        System.out.println("0. Keluar");
                        System.out.println("---------------------------");
                        System.out.print("Masukkan pilihan anda : ");
                        char menuEdit = input.next().charAt(0);
                        input.nextLine();

                        switch (menuEdit) {
                            // Menu keluar
                            case '0':
                                loop3 = false;
                                break;

                            // Edit Menu Guru
                            case '1':
                                System.out.println();
                                System.out.println("======================================");
                                System.out.println("||                                  ||");
                                System.out.println("||            Daftar GURU           ||");
                                System.out.println("||                                  ||");
                                System.out.println("======================================");
                                System.out.println();

                                System.out.println(String.format("%-15s %-15s %-17s %-15s", "Guru ke-", "Nama Guru", "Jabatan Guru", "Total Gaji"));
                                System.out.println(String.format("%-15s %-15s %-17s %-15s", "-----------", "------------", "--------------", "-------------"));

                                for (int i = 0; i < daftarGuru.length; i++) {
                                    System.out.println(String.format("%-15s %-15s %-17s %-15s", + (i+1), daftarGuru[i][0], daftarGuru[i][1], "Rp. " + daftarGajiGuru[i]));
                                }
                                
                                System.out.println();
                                System.out.print("Edit Guru ke- : ");
                                int edit = input.nextInt();
                                input.nextLine();

                                System.out.print("Masukkan Nama Guru : ");
                                daftarGuru[edit-1][0] = input.nextLine();
                                System.out.print("Masukkan Jabatan Guru : ");
                                daftarGuru[edit-1][1] = input.nextLine();
                                System.out.print("Masukkan Total Gaji Guru : ");
                                daftarGajiGuru[edit-1] = input.nextDouble();

                                System.out.println("Apakah anda ingin lanjut mengedit? (y/t)");
                                char lanjutEdit = input.next().charAt(0);
                                input.nextLine();
                                if (lanjutEdit == 't') {
                                    loop3 = false;
                                }
                                break;

                            // Edit Menu Staff
                            case '2':
                                System.out.println();
                                System.out.println("======================================");
                                System.out.println("||                                  ||");
                                System.out.println("||            Daftar STAFF          ||");
                                System.out.println("||                                  ||");
                                System.out.println("======================================");
                                System.out.println();

                                System.out.println(String.format("%-15s %-15s %-22s %-15s", "Staff ke-", "Nama Staff", "Posisi Staff", "Total Gaji"));
                                System.out.println(String.format("%-15s %-15s %-22s %-15s", "-----------", "------------", "------------", "-------------"));

                                for (int i = 0; i < daftarStaff.length; i++) {
                                    System.out.println(String.format("%-15s %-15s %-22s %-15s", + (i+1), daftarStaff[i][0], daftarStaff[i][1], "Rp. " + daftarGajiStaff[i]));
                                }

                                System.out.println();
                                System.out.print("Edit Staff ke- : ");
                                edit = input.nextInt();
                                input.nextLine();

                                System.out.print("Masukkan Nama Staff : ");
                                daftarStaff[edit-1][0] = input.nextLine();
                                System.out.print("Masukkan Posisi Staff : ");
                                daftarStaff[edit-1][1] = input.nextLine();
                                System.out.print("Masukkan Total Gaji Staff : ");
                                daftarGajiStaff[edit-1] = input.nextDouble();

                                System.out.println("Apakah anda ingin lanjut mengedit? (y/t)");
                                lanjutEdit = input.next().charAt(0);
                                input.nextLine();
                                if (lanjutEdit == 't') {
                                    loop3 = false;
                                }
                                break;

                            // Edit Menu Eksternal
                            case '3':
                                System.out.println();
                                System.out.println("======================================");
                                System.out.println("||                                  ||");
                                System.out.println("||          DAFTAR EKSTERNAL        ||");
                                System.out.println("||                                  ||");
                                System.out.println("======================================");
                                System.out.println();

                                System.out.println(String.format("%-15s %-15s %-15s %-15s", "Eksternal ke-", "Nama Eksternal", "Posisi", "Total Gaji"));
                                System.out.println(String.format("%-15s %-15s %-15s %-15s", "-----------", "------------", "------------", "-------------"));

                                for (int i = 0; i < lapEks.length; i++) {
                                    System.out.println(String.format("%-15s %-15s %-15s %-15s", + (i+1), lapEks[i][0], lapEks[i][1], "Rp. " + lapEks[i][2]));
                                }

                                System.out.println();
                                System.out.print("Edit Eksternal ke- : ");
                                edit = input.nextInt();
                                input.nextLine();

                                System.out.print("Masukkan Nama Guru Eksternal : ");
                                lapEks[edit-1][0] = input.nextLine();
                                System.out.print("Masukkan Posisi Guru Eksternal : ");
                                lapEks[edit-1][1] = input.nextLine();
                                System.out.print("Masukkan Total Gaji Guru Eksternal : ");
                                lapEks[edit-1][2] = input.nextLine();

                                System.out.println("Apakah anda ingin lanjut mengedit? (y/t)");
                                lanjutEdit = input.next().charAt(0);
                                input.nextLine();
                                if (lanjutEdit == 't') {
                                    loop3 = false;
                                }
                                break;
                        
                            default:
                                System.out.println("Menu yang anda masukkan salah! Silahkan coba lagi!");
                                break;
                        }
                    }
                    break;
            
                default:
                    System.out.println("Menu yang anda masukkan salah! Silahkan coba lagi!");
                    break;
            }
        }    
    }
}



// // Pilihan Menu
//             System.out.println();
//             System.out.println("======================================");
//             System.out.println("||                                  ||");
//             System.out.println("||       SISTEM PENGGAJIAN SMP      ||");
//             System.out.println("||                                  ||");
//             System.out.println("======================================");
//             System.out.println();
//             System.out.println("Silahkan Pilih Menu Penggajian (Pilih salah satu!) ");
//             System.out.println("1. Guru");
//             System.out.println("2. Staff");
//             System.out.println("3. Guru Eksternal");
//             System.out.println("0. Exit");
//             System.out.print("Masukkan pilihan anda : ");
//             pilihanMenu = input.nextInt();
            
//             switch (pilihanMenu) {
//                 // Case Guru
//                 case 1 :

//                 System.out.println();
//                 System.out.println("======================================");
//                 System.out.println("||                                  ||");
//                 System.out.println("||          PENGGAJIAN GURU         ||");
//                 System.out.println("||                                  ||");
//                 System.out.println("======================================");
//                 System.out.println();
//                 System.out.print("Masukkan jumlah Guru : ");
//                 int jmlGuru = input.nextInt();

//                 String daftarGuru[][] = new String[jmlGuru][2];
//                 double daftarGajiGuru[] = new double[jmlGuru];

//                 for (int i = 0; i < daftarGuru.length; i++) {
//                     System.out.println();
//                     System.out.println("Anda berada di dalam menu guru, Silahkan pilih status guru");
//                     System.out.println("1. Guru PNS");
//                     System.out.println("2. Guru Honorer");
//                     System.out.print("Masukkan status guru : "); 
//                     pilihanGuru = input.next();

//                     // Pilihan Jabatan PNS
//                     if (pilihanGuru.equalsIgnoreCase("1")) {
//                         System.out.println("Masukkan Pilihan Jabatan");
//                         System.out.println("1. Kepala Sekolah");
//                         System.out.println("2. Guru Pengajar");
//                         System.out.print("Masukkan Pilihan Anda : "); 
//                         pilihanJabatan = input.next();

//                         // Menu Jabatan Kepala Sekolah (Tanpa jam Mengajar)
//                         if (pilihanJabatan.equalsIgnoreCase("1")) {              
//                             System.out.print("Masukkan Nama Guru : ");
//                             nama = input.next();
//                             System.out.print("Masukkan Gaji Guru : ");
//                             gaji = input.nextDouble();

//                             jabatan = "Kepala Sekolah";
//                             gajiAkhir = gaji + tunjangan;
//                             daftarGuru[i][0] = nama;
//                             daftarGuru[i][1] = jabatan;
//                             daftarGajiGuru[i] = gajiAkhir;

//                             slipGuru(nama, jabatan, tunjangan, gajiAkhir);

//                         // Menu Jabatan Guru Mengajar 
//                         } else if (pilihanJabatan.equalsIgnoreCase("2")) {
//                             System.out.print("Masukkan nama guru : ");
//                             nama = input.next();
//                             System.out.print("Masukkan gaji guru perjam : "); 
//                             gaji = input.nextInt();
//                             System.out.print("Masukkan jam guru satu bulan : ");
//                             jamMengajar = input.nextInt();

//                             jabatan = "Guru Pengajar";
//                             gajiAkhir = hitungGaji(gaji, jamMengajar) + tunjangan;
//                             daftarGuru[i][0] = nama;
//                             daftarGuru[i][1] = jabatan;
//                             daftarGajiGuru[i] = gajiAkhir;

//                             slipGuru(nama, jabatan, tunjangan, gajiAkhir);

//                         // Inputan Salah
//                         }else {
//                             System.out.println("Input Yang Anda Masukkan Salah");
//                         }    

//                     // Pilihan Guru Honorer
//                     } else if (pilihanGuru.equalsIgnoreCase("2")) {
//                         System.out.print("Masukkan nama guru : ");
//                         nama = input.next();
//                         System.out.print("Masukkan gaji guru perjam : "); 
//                         gaji = input.nextInt();
//                         System.out.print("Masukkan jam guru mengajar : ");
//                         jamMengajar = input.nextInt();
                        
//                         //Menu Lembur
//                         System.out.println("Apakah anda ingin menambah Gaji Lembur (y/t)");
//                         menuLembur = input.next();
//                         if (menuLembur.equalsIgnoreCase("y")) {
//                             System.out.print("Masukkan gaji lembur per jam : ");
//                             gajiLembur = input.nextInt();
//                             System.out.print ("Masukkan jam mengajar lembur : ");
//                             Jamlembur = input.nextInt();

//                             jabatan = "Honorer\t";
//                             totalLembur = Jamlembur * gajiLembur;
//                             gajiAkhir = hitungGaji(gaji, jamMengajar) + totalLembur;
//                             daftarGuru[i][0] = nama;
//                             daftarGuru[i][1] = jabatan;
//                             daftarGajiGuru[i] = gajiAkhir;

//                             slipHonorer(nama, totalLembur, gajiAkhir);

//                         } else if (menuLembur.equalsIgnoreCase("t")) {
//                             jabatan = "Honorer\t";
//                             gajiAkhir = hitungGaji(gaji, jamMengajar);
//                             daftarGuru[i][0] = nama;
//                             daftarGuru[i][1] = jabatan;
//                             daftarGajiGuru[i] = gajiAkhir;
//                             totalLembur = 0;

//                             slipHonorer(nama, totalLembur, gajiAkhir);

//                         } else {
//                             System.out.println("Input yang anda masukkan salah!");
//                         }

//                     // Inputan Status Guru Salah   
//                     } else {
//                         System.out.println("Status Guru yang Anda Masukkan Salah!");
//                     }
//                 }

//                 System.out.println();
//                 System.out.println("======================================");
//                 System.out.println("||                                  ||");
//                 System.out.println("||      LAPORAN PENGGAJIAN GURU     ||");
//                 System.out.println("||                                  ||");
//                 System.out.println("======================================");
//                 System.out.println();

//                 for (int i = 0; i < daftarGuru.length; i++) {
//                     System.out.println("Guru ke-" + (i+1) + ": " + daftarGuru[i][0] + "\t - \t" 
//                     + daftarGuru[i][1] + "\t - \tTotal Gaji: Rp. " + daftarGajiGuru[i]);
//                 }

//                 break;

//                 // Case Staff
//                 case 2 : 

//                 System.out.println();
//                 System.out.println("======================================");
//                 System.out.println("||                                  ||");
//                 System.out.println("||          PENGGAJIAN STAFF        ||");
//                 System.out.println("||                                  ||");
//                 System.out.println("======================================");
//                 System.out.println();
//                 System.out.print("Masukkan jumlah Staff : ");
//                 int jmlStaff = input.nextInt();

//                 String daftarStaff[][] = new String[jmlStaff][2];
//                 double daftarGajiStaff[] = new double[jmlStaff];

//                 for (int i = 0; i < daftarStaff.length; i++) {
//                     System.out.println();
//                     System.out.print("Masukkan nama staff : ");
//                     nama = input.next();
//                     System.out.println("POSISI STAFF SMP");
//                     System.out.println("1. Security");
//                     System.out.println("2. Office Boy");
//                     System.out.println("3. Petugas Perpustakaan");
//                     System.out.println("4. Tata Usaha");
//                     System.out.print("Masukkan pilihan posisi staff : ");
//                     int menuStaff = input.nextInt();
//                     System.out.print("Masukkan hari masuk staff : ");
//                     hariMasuk = input.nextInt();;

//                     gajiAkhir = hitungGaji(gajiStaff, hariMasuk);
//                     daftarStaff[i][0] = nama;
//                     daftarGajiStaff[i] = gajiAkhir;

//                     switch (menuStaff) {
//                         case 1:
//                         posisiStaff = "Security";
//                         daftarStaff[i][1] = posisiStaff;

//                         slipStaff(nama, posisiStaff, gajiAkhir);
//                         break;

//                         case 2:
//                         posisiStaff = "Office Boy";
//                         daftarStaff[i][1] = posisiStaff;

//                         slipStaff(nama, posisiStaff, gajiAkhir);
//                         break;

//                         case 3:
//                         posisiStaff = "Petugas Perpustakaan";
//                         daftarStaff[i][1] = posisiStaff;

//                         slipStaff(nama, posisiStaff, gajiAkhir);
//                         break;

//                         case 4:
//                         posisiStaff = "Tata Usaha";
//                         daftarStaff[i][1] = posisiStaff;

//                         slipStaff(nama, posisiStaff, gajiAkhir);
//                         break;
                            
//                         default:
//                         break;
//                     }

//                 }

//                 System.out.println();
//                 System.out.println("======================================");
//                 System.out.println("||                                  ||");
//                 System.out.println("||     LAPORAN PENGGAJIAN STAFF     ||");
//                 System.out.println("||                                  ||");
//                 System.out.println("======================================");
//                 System.out.println();

//                 for (int i = 0; i < daftarStaff.length; i++) {
//                     System.out.println("Staff ke-" + (i+1) + ": " + daftarStaff[i][0] + "\t - \t" + daftarStaff[i][1] + "\t - \tTotal Gaji: Rp. " + daftarGajiStaff[i]);
//                 }
//                 break;
    
                
//                 // Guru Eksternal
//                 case 3 :

//                 System.out.println();
//                 System.out.println("======================================");
//                 System.out.println("||                                  ||");
//                 System.out.println("||     PENGGAJIAN GURU EKSTERNAL    ||");
//                 System.out.println("||                                  ||");
//                 System.out.println("======================================");
//                 System.out.println();
//                 System.out.print("Masukkan jumlah guru Eksternal : ");
//                 int jmlEks = input.nextInt();

//                 String lapEks[][] = new String[jmlEks][3];

//                 for (int i = 0; i < lapEks.length; i++) {
//                     System.out.println("Guru Eksternal ke-" + (i+1));
//                     for (int j = 0; j < lapEks[0].length; j++) {
//                         if (j == 0) {
//                             System.out.print("Nama" + ": ");
//                             lapEks[i][j] = input.next();
//                         } else if (j == 1) {
//                             System.out.print("Posisi" + ": ");
//                             lapEks[i][j] = input.next();
//                         } else if (j == 2) {
//                             System.out.print("Gaji" + ": ");
//                             lapEks[i][j] = input.next();
//                         }
//                     }
//                     System.out.println();
//                 }

//                 System.out.println("======================================");
//                 System.out.println("||                                  ||");
//                 System.out.println("||   LAPORAN PENGGAJIAN EKSTERNAL   ||");
//                 System.out.println("||                                  ||");
//                 System.out.println("======================================");
//                 System.out.println();

//                 for (int i = 0; i < lapEks.length; i++) {
//                     System.out.println("Guru Eksternal ke-" + (i+1) + ": ");
//                     for (String out : lapEks[i]) {
//                         System.out.print(out + " \t - \t ");
//                     }
//                     System.out.println();
//                 }
//                 break;
                
//                 case 0:
//                 System.out.println("Anda Berhasil keluar!");
//                 exit = false;
//                 break;

//                 default: 
//                 System.out.println("Menu yang anda masukkan SALAH! ");
//                 System.out.println("Silahkan ulangi lagi!");
//             }