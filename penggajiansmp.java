import java.util.Scanner;
public class penggajiansmp {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int  tunjangan = 10000, jamMengajar, statusGuru; // input
        double gajiGuru, gajiAkhir;
        String namaGuru;

        System.out.println("======Sistem Penggajian Guru======");
        System.out.println();
        System.out.print("Masukkan nama guru : ");
        namaGuru = input.next();
        System.out.println("Masukkan status guru (Pilih salah satu!) ");
        System.out.println("1. PNS");
        System.out.println("2. Honorer");
        System.out.print("Masukkan pilihan anda : ");
        statusGuru = input.nextInt();

        switch (statusGuru) {
            case 1 :
                System.out.print("Masukkan gaji guru perjam : "); // proses
                gajiGuru = input.nextInt();
                System.out.print("Masukkan jam guru mengajar : ");
                jamMengajar = input.nextInt();
                gajiAkhir = gajiGuru * jamMengajar + tunjangan;

                System.out.println();
                System.out.println("======Laporan Gaji Guru PNS======");
                System.out.println();
                System.out.println("Nama Guru : " + namaGuru);
                System.out.println(String.format("Gaji anda adalah: Rp. %s (sudah termasuk tunjangan)", gajiAkhir));
            break;
            case 2 :
                System.out.println("Masukkan gaji guru perjam : "); // proses
                gajiGuru = input.nextInt();
                System.out.println("Masukkan jam guru mengajar : ");
                jamMengajar = input.nextInt();
                gajiAkhir = gajiGuru * jamMengajar;
                input.close();

                System.out.println();
                System.out.println("======Laporan Gaji Guru Honorer======");
                System.out.println();
                System.out.println("Nama Guru : " + namaGuru);
                System.out.println(String.format("Gaji anda adalah: Rp. %s ", gajiAkhir));
            break;
            default : 
                System.out.println("Status guru yang anda masukkan salah! ");
        }

    }
}