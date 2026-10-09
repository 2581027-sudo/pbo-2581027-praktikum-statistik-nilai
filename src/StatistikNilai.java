import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;
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
            System.out.print("Nilai ke-" + (daftar.size() + 1) + " : ");
            nilai = input.nextInt();

            if (nilai == SELESAI) {
                continue;
            }
            if (nilai < 0 || nilai > 100) {
                System.out.println("  Ditolak, harus 0-100");
                continue;
            }
            daftar.add(nilai);
        } while (nilai != SELESAI);

        System.out.println();

        if (daftar.isEmpty()) {
            System.out.println("Tidak ada nilai yang dimasukkan.");
            return;
        }

        // PUTARAN 1: jumlah, tertinggi, terendah (mulai dari elemen pertama,
        // karena mulai dari 0 membuat terendah selalu 0).
        int jumlah = 0;
        int tertinggi = daftar.get(0);
        int terendah = daftar.get(0);
        for (int x : daftar) {
            jumlah += x;
            if (x > tertinggi) tertinggi = x;
            if (x < terendah) terendah = x;
        }
        double rata = (double) jumlah / daftar.size();

        // PUTARAN 2: di atas rata-rata. Harus putaran terpisah karena
        // rata-rata baru diketahui setelah semua nilai dijumlahkan.
        int diAtasRata = 0;
        for (int x : daftar) {
            if (x > rata) diAtasRata++;
        }

        // Distribusi grade: index 0=A, 1=B, 2=C, 3=D, 4=E
        String[] huruf = {"A", "B", "C", "D", "E"};
        int[] jumlahGrade = new int[5];
        for (int x : daftar) {
            if (x >= 90)      jumlahGrade[0]++;
            else if (x >= 80) jumlahGrade[1]++;
            else if (x >= 70) jumlahGrade[2]++;
            else if (x >= 60) jumlahGrade[3]++;
            else              jumlahGrade[4]++;
        }

        // Daftar terurut dibuat dari SALINAN, daftar asli tidak disentuh.
        ArrayList<Integer> terurut = new ArrayList<>(daftar);
        Collections.sort(terurut);

        System.out.println("Nilai tersimpan : " + daftar);
        System.out.println("Jumlah          : " + daftar.size());
        System.out.println("Rata-rata       : "
                + String.format(Locale.forLanguageTag("id-ID"), "%.2f", rata));
        System.out.println("Tertinggi       : " + tertinggi);
        System.out.println("Terendah        : " + terendah);
        System.out.println("Di atas rata2   : " + diAtasRata + " orang");

        System.out.print("Distribusi      : ");
        for (int i = 0; i < jumlahGrade.length; i++) {
            System.out.print(huruf[i] + "=" + jumlahGrade[i]);
            if (i < jumlahGrade.length - 1) System.out.print(" ");
        }
        System.out.println();

        System.out.println("Terurut         : " + terurut);
        System.out.println("Urutan asli     : " + daftar); // bukti daftar asli tidak berubah
    }
}