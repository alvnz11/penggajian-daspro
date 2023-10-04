import java.util.Scanner;
public class penggajiansmp {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int  tunjangan = 10000, jamMengajar,Jamlembur, pilihanMenu; // input
        double gajiGuru, gajiAkhir, gajiLembur, totalLembur;
        String namaGuru, pilihanGuru;

        // Pilihan Menu
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
                    System.out.print("Masukkan nama guru : ");
                    namaGuru = input.next();
                    System.out.print("Masukkan gaji guru perjam : "); // proses
                    gajiGuru = input.nextInt();
                    System.out.print("Masukkan jam guru mengajar : ");
                    jamMengajar = input.nextInt();
                    gajiAkhir = gajiGuru * jamMengajar + tunjangan;

                    System.out.println();
                    System.out.println("======Slip Gaji Guru PNS======");
                    System.out.println();
                    System.out.println("Nama Guru : " + namaGuru);
                    System.out.println("Tunjangan = " + tunjangan);
                    System.out.println(String.format("Total gaji anda adalah : Rp. %s ", gajiAkhir));
                } else if (pilihanGuru.equalsIgnoreCase("2")) {
                    System.out.print("Masukkan nama guru : ");
                    namaGuru = input.next();
                    System.out.print("Masukkan gaji guru perjam : "); // proses
                    gajiGuru = input.nextInt();
                    System.out.print("Masukkan jam guru mengajar : ");
                    jamMengajar = input.nextInt();
                    System.out.print("Masukkan gaji lembur per jam : ");
                    gajiLembur = input.nextInt();
                    System.out.print ("Masukkan jam mengajar lembur : ");
                    Jamlembur = input.nextInt();
                    totalLembur = Jamlembur * gajiLembur;
                    gajiAkhir = (gajiGuru * jamMengajar) + totalLembur ;
                    input.close();

                    System.out.println();
                    System.out.println("======Slip Gaji Guru Honorer======");
                    System.out.println();
                    System.out.println("Nama Guru : " + namaGuru);
                    System.out.println("Gaji lembur = " + totalLembur);
                    System.out.println(String.format("Total gaji anda adalah : Rp. %s ", gajiAkhir));
                } else {
                    System.out.println("Status Guru yang Anda Masukkan Salah!");
                }
                break;


            // Penggajian Staff
            case 2 : 
                System.out.println();
            break;
            default : 
                System.out.println("Menu yang anda masukkan salah! ");
        }

    }
}