import java.util.ArrayList;
import java.util.Scanner;

public class StatistikNilai {
    static final int SELESAI = -1;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Integer> daftar = new ArrayList<>();

        System.out.println("===== STATISTIK NILAI KELAS =====");
        System.out.println("Ketik -1 kalau sudah selesai.");

        int nilai;
        do {
            // Nomor prompt diambil dari size(), bukan counter terpisah,
            // jadi nomornya tetap sama setelah nilai ditolak.
            System.out.print("Nilai ke-" + (daftar.size() + 1) + " : ");
            nilai = input.nextInt();

            // -1 dicek lebih dulu, kalau tidak akan dianggap "di luar 0-100".
            // continue di do-while lompat ke kondisi, dan -1 menghentikan loop.
            if (nilai == SELESAI) {
                continue;
            }

            if (nilai < 0 || nilai > 100) {
                System.out.println("  Ditolak, harus 0-100");
                continue; // tidak di-add, kondisi loop tetap true
            }

            daftar.add(nilai);
        } while (nilai != SELESAI);

        System.out.println();
        System.out.println("Nilai tersimpan : " + daftar);
    }
}