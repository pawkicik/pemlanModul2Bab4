import java.util.Scanner;

class AkunPelanggan {
    // Poin 1: Atribut private (tidak bisa diubah langsung)
    private String nama;
    private String nomorPelanggan;
    private double saldo;
    private String pin;
    private int percobaanSalah = 0;
    private boolean isBlokir = false;

    public AkunPelanggan(String nama, String nomorPelanggan, double saldo, String pin) {
        this.nama = nama;
        this.nomorPelanggan = nomorPelanggan;
        this.saldo = saldo;
        this.pin = pin;
    }

    // Poin 4 & 5: Autentikasi PIN & Nomor Pelanggan
    public boolean autentikasi(String nomor, String inputPin) {
        if (isBlokir) {
            System.out.println("Akun Anda telah diblokir (Defreeze).");
            return false;
        }

        if (this.nomorPelanggan.equals(nomor) && this.pin.equals(inputPin)) {
            percobaanSalah = 0; // Reset jika berhasil
            return true;
        } else {
            percobaanSalah++;
            System.out.println("Autentikasi Gagal! Percobaan ke-" + percobaanSalah);
            if (percobaanSalah >= 3) {
                isBlokir = true;
                System.out.println("Akun Anda OTOMATIS DIBLOKIR.");
            }
            return false;
        }
    }

    // Poin 2: Logika Cashback berdasarkan 2 digit depan nomor
    private double hitungCashback(double nominalBelanja) {
        String jenis = nomorPelanggan.substring(0, 2);
        double persen = 0;

        switch (jenis) {
            case "38": // Silver
                if (nominalBelanja > 1000000) persen = 0.05;
                break;
            case "56": // Gold
                if (nominalBelanja > 1000000) persen = 0.07;
                else persen = 0.02;
                break;
            case "74": // Platinum
                if (nominalBelanja > 1000000) persen = 0.10;
                else persen = 0.05;
                break;
        }
        return nominalBelanja * persen;
    }

    // Poin 3 & 4: Transaksi Pembelian
    public void transaksiPembelian(double nominal) {
        if (isBlokir) return;

        double cashback = hitungCashback(nominal);
        double totalPotongSaldo = nominal - cashback;

        // Cek apakah saldo setelah transaksi tetap minimal 10.000
        if (this.saldo - totalPotongSaldo < 10000) {
            System.out.println("Transaksi GAGAL: Saldo tidak mencukupi batas minimal Rp10.000.");
        } else {
            this.saldo -= totalPotongSaldo;
            System.out.println("Transaksi Berhasil!");
            System.out.println("Cashback didapat: Rp" + cashback);
            System.out.println("Saldo sekarang: Rp" + this.saldo);
        }
    }

    public void topUp(double nominal) {
        if (isBlokir) return;
        this.saldo += nominal;
        System.out.println("Top Up Berhasil! Saldo sekarang: Rp" + this.saldo);
    }

    // Getter untuk info akun (Poin 1: Read-only)
    public String getNama() { return nama; }
    public double getSaldo() { return saldo; }
}

