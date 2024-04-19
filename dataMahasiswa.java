import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class dataMahasiswa {
    private static Map<String, Mahasiswa> mahasiswaMap = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int pilihan;

        do {
            tampilkanMenu();
            System.out.print("Pilih menu: ");
            pilihan = scanner.nextInt();
            scanner.nextLine(); // Membuang newline character

            switch (pilihan) {
                case 1:
                    tambahMahasiswa();
                    break;
                case 2:
                    hapusMahasiswa();
                    break;
                case 3:
                    tampilkanNilaiDanRataRata();
                    break;
                case 4:
                    System.out.println("Terima kasih!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan pilih menu yang sesuai.");
            }
        } while (pilihan != 4);
    }

    public static void tampilkanMenu() {
        System.out.println("Menu:");
        System.out.println("1. Tambah Mahasiswa");
        System.out.println("2. Hapus Mahasiswa");
        System.out.println("3. Tampilkan Nilai Mahasiswa dan Rata-rata");
        System.out.println("4. Keluar");
    }

    public static void tambahMahasiswa() {
        System.out.print("NIM: ");
        String nim = scanner.nextLine();
        System.out.print("Nama: ");
        String nama = scanner.nextLine();
        System.out.print("Kelas: ");
        String kelas = scanner.nextLine();
        System.out.print("Nilai: ");
        int nilai = scanner.nextInt();

        Mahasiswa mahasiswa = new Mahasiswa(nama, kelas, nilai);
        mahasiswaMap.put(nim, mahasiswa);
        System.out.println("Mahasiswa berhasil ditambahkan.");
    }

    public static void hapusMahasiswa() {
        System.out.print("Masukkan NIM mahasiswa yang ingin dihapus: ");
        String nim = scanner.nextLine();
        if (mahasiswaMap.containsKey(nim)) {
            mahasiswaMap.remove(nim);
            System.out.println("Mahasiswa dengan NIM " + nim + " berhasil dihapus.");
        } else {
            System.out.println("Mahasiswa dengan NIM " + nim + " tidak ditemukan.");
        }
    }

    public static void tampilkanNilaiDanRataRata() {
        if (mahasiswaMap.isEmpty()) {
            System.out.println("Tidak ada data mahasiswa.");
            return;
        }

        System.out.println("Nilai Mahasiswa:");
        for (Map.Entry<String, Mahasiswa> entry : mahasiswaMap.entrySet()) {
            System.out.println("NIM: " + entry.getKey());
            System.out.println("Nama: " + entry.getValue().getNama());
            System.out.println("Kelas: " + entry.getValue().getKelas());
            System.out.println("Nilai: " + entry.getValue().getNilai());
            System.out.println();
        }

        double rataRataNilai = hitungRataRataNilai();
        System.out.println("Rata-rata Nilai Mahasiswa: " + rataRataNilai);
    }

    public static double hitungRataRataNilai() {
        double totalNilai = 0;
        for (Mahasiswa mahasiswa : mahasiswaMap.values()) {
            totalNilai += mahasiswa.getNilai();
        }
        return totalNilai / mahasiswaMap.size();
    }
}

class Mahasiswa {
    private String nama;
    private String kelas;
    private int nilai;

    public Mahasiswa(String nama, String kelas, int nilai) {
        this.nama = nama;
        this.kelas = kelas;
        this.nilai = nilai;
    }

    public String getNama() {
        return nama;
    }

    public String getKelas() {
        return kelas;
    }

    public int getNilai() {
        return nilai;
    }
}
