import java.util.Scanner;

public class SwalayanTiny {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        // Contoh Data Dummy Pelanggan (Jenis Gold - 56)
        AkunPelanggan user = new AkunPelanggan("Andi", "5612345678", 1500000, "1234");

        boolean running = true;
        while (running) {
            System.out.println("\n--- SISTEM TRANSAKSI SWALAYAN TINY ---");
            System.out.println("1. Pembelian");
            System.out.println("2. Top Up");
            System.out.println("3. Keluar");
            System.out.print("Pilih Menu: ");
            int menu = input.nextInt();

            if (menu == 3) break;

            System.out.print("Masukkan Nomor Pelanggan: ");
            String no = input.next();
            System.out.print("Masukkan PIN: ");
            String pin = input.next();

            if (user.autentikasi(no, pin)) {
                if (menu == 1) {
                    System.out.print("Total Belanja: Rp");
                    double belanja = input.nextDouble();
                    user.transaksiPembelian(belanja);
                } else if (menu == 2) {
                    System.out.print("Nominal Top Up: Rp");
                    double topup = input.nextDouble();
                    user.topUp(topup);
                }
            }
        }
        System.out.println("Terima kasih telah menggunakan layanan Tiny.");
    }
}