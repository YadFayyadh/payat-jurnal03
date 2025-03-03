package Jurnal.Jurnal03;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SinglyLinkedList<Resep> daftarResep = new SinglyLinkedList<>();

        while (true) {
            System.out.println("1. Tambah Resep di Depan");
            System.out.println("2. Tambah Resep di Belakang");
            System.out.println("3. Hapus Resep dari Depan");
            System.out.println("4. Hapus Resep dari Belakang");
            System.out.println("5. Cetak Semua Resep");
            System.out.println("6. Cari Resep Berdasarkan Nama");
            System.out.println("7. Keluar");
            System.out.print("Pilih menu: ");
            int pilihan = scanner.nextInt();
            scanner.nextLine();

            switch (pilihan) {
                case 1:
                case 2:
                    System.out.print("Masukkan Nama Resep: ");
                    String nama = scanner.nextLine();
                    System.out.print("Masukkan Bahan Utama: ");
                    String bahan = scanner.nextLine();
                    System.out.print("Masukkan Waktu Memasak (menit): ");
                    int waktu = scanner.nextInt();
                    scanner.nextLine();
                    Resep resepBaru = new Resep(nama, bahan, waktu);
                    if (pilihan == 1) {
                        daftarResep.insertResepDepan(resepBaru);
                    } else {
                        daftarResep.insertResepBelakang(resepBaru);
                    }
                    break;
                case 3:

                    System.out.println("Menghapus: " + daftarResep.hapusResepDepan());

                    break;
                case 4:

                    System.out.println("Menghapus: " + daftarResep.hapusResepBelakang());

                    break;
                case 5:
                    daftarResep.cetakResep();
                    break;
                case 6:
                    System.out.print("Masukkan Nama Resep yang Dicari: ");
                    String cariNama = scanner.nextLine();
                    daftarResep.cari(cariNama);
                    break;
                case 7:
                    System.out.println("Keluar dari program.");
                    scanner.close();
                    return;

            }
        }
    }
}
