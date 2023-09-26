import java.util.Scanner;
public class penggajiansmp {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int  tunjangan = 10000, jamMengajar; // input
        double gajiGuru, gajiAkhir;
        String namaGuru, statusGuru;

        System.out.print("Masukkan nama guru : ");
        namaGuru = input.next();
        System.out.print("Masukkan status guru : ");
        statusGuru = input.next();

        switch (statusGuru) {
            case "PNS":
                System.out.print("Masukkan gaji guru perjam : "); // proses
                gajiGuru = input.nextInt();
                System.out.print("Masukkan jam guru mengajar : ");
                jamMengajar = input.nextInt();
                gajiAkhir = gajiGuru * jamMengajar + tunjangan;


                System.out.println("=========================");
                System.out.println("Nama Guru : " + namaGuru);
                System.out.println(String.format("Gaji anda adalah: %s (sudah termasuk tunjangan)", gajiAkhir));
            break;
            case "honorer":
                System.out.println("Masukkan gaji guru perjam : "); // proses
                gajiGuru = input.nextInt();
                System.out.println("Masukkan jam guru mengajar : ");
                jamMengajar = input.nextInt();
                gajiAkhir = gajiGuru * jamMengajar;
                input.close();

                System.out.println("=========================");
                System.out.println("Nama Guru : " + namaGuru);
                System.out.println(String.format("Gaji anda adalah: %s ", gajiAkhir));
            break;
            default : 
                System.out.println("Status guru yang anda masukkan salah! ");
        }

    }
}