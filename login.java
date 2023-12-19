import java.util.*;

public class login {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String username, password;
        int percobaan = 5;

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
        input.close();
    }
}