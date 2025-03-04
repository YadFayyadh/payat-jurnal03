package Jurnal.Jurnal03;

public class Resep {
    public String namaResep;
    private String bahanUtama;
    private int waktu;

    public Resep(String namaResep, String bahanUtama, int waktu) {
        this.namaResep = namaResep;
        this.bahanUtama = bahanUtama;
        this.waktu = waktu;
    }

    @Override
    public String toString() {
        return "\n Nama Resep = " + namaResep + ", \n bahanUtama = " + bahanUtama + ", \n waktu = " + waktu + " Menit \n\n";
    }
}
