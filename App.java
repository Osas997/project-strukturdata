import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Queue queue = new Queue(10);

        int pilihan;
        do {
            tampilanAwal();
            pilihan = input.nextInt();
            if (pilihan == 1) {
                queue.enqueue();
            } else if (pilihan == 2) {
                queue.dequeue();
            } else if (pilihan == 3) {
                System.out.println("Cari Nama :");
                String name = input.next();
                queue.searchUser(name);
            } else if (pilihan == 4) {
                queue.printQueue();
            } else if (pilihan == 5) {
                System.out.println("Terima Kasih !!");
            } else {
                System.out.println("Pilihan Tidak Valid");
            }
        } while (pilihan != 5);
    }

    static void tampilanAwal() {
        System.out.println("==================================================================================");
        System.out.println("Selamat Datang Pemesanan Tiket Bioskop Jati Makmur\nPilih Menu Dibawah !!!!");
        System.out.println("\t1. Pesan Tiket");
        System.out.println("\t2. Proses Tiket");
        System.out.println("\t3. Cari User");
        System.out.println("\t4. Tampilkan Semua Pemesanan");
        System.out.println("\t5. Keluar");
        System.out.println("==================================================================================");
    }

}

class Queue {
    PemesananTiket[] element;
    int front;
    int rear;
    int maxQueue;

    public Queue(int max) {
        front = 0;
        rear = -1;
        element = new PemesananTiket[max];
        maxQueue = max - 1;
    }

    public boolean isEmpty() {
        boolean flag;
        if (rear < 0) {
            flag = true;
        } else {
            flag = false;
        }
        return flag;
    }

    public boolean isFull() {
        boolean flag;
        if (rear == maxQueue) {
            flag = true;
        } else {
            flag = false;
        }
        return flag;
    }

    public void enqueue() {
        if (isFull()) {
            System.out.println("Overflow, tidak dapat mengisi data lagi");
        } else {
            PemesananTiket data = new PemesananTiket();
            data.pesan();
            rear += 1;
            element[rear] = data;
        }
    }

    public void dequeue() {
        PemesananTiket data;
        if (isEmpty()) {
            System.out.println("Tidak ada pesanan");
        } else {
            data = element[front];
            element[front] = null;
            front += 1;
            if (data != null) {
                System.out.println("===============================================");
                System.out.println("Tiket Atas Nama : " + data.nama + "\nDengan Judul Film : " + data.Film.getJudul()
                        + " Kursi : " + data.kursi + "\nTelah Di Proses Silahkan Diambil");
            } else {
                System.out.println("Tidak ada Pesanan");
            }
        }
    }

    public void printQueue() {
        if (!isEmpty() && element[front] != null) {
            System.out.println("Isi antrian:\n");
            for (int i = front; i <= rear; i++) {
                System.out.println("===============================================");
                System.out.println("Pesanan Ke " + (i + 1));
                System.out.println("Nama Pemesan : " + element[i].nama);
                System.out.println("No HP : " + element[i].noHp);
                System.out.println("Jam Tayang : " + element[i].jamTayang);
                System.out.println("Tempat Duduk : " + element[i].kursi);
                System.out.println("Judul Film : " + element[i].Film.getJudul());
                System.out.println("Genre Film : " + element[i].Film.getGenre());
                System.out.println("Durasi Film : " + element[i].Film.getDurasi());
                System.out.println("Harga : Rp 40.000,00");
            }
        } else {
            System.out.println("Tidak Ada Pesanan");
        }
    }

    public void searchUser(String name) {
        boolean ketemu = false;
        for (int i = front; i <= rear; i++) {
            if (element[i].nama.equalsIgnoreCase(name)) {
                System.out.println("===============================================");
                System.out.println("Nama Pemesan : " + element[i].nama);
                System.out.println("No HP : " + element[i].noHp);
                System.out.println("Jam Tayang : " + element[i].jamTayang);
                System.out.println("Tempat Duduk : " + element[i].kursi);
                System.out.println("Judul Film : " + element[i].Film.getJudul());
                System.out.println("Genre Film : " + element[i].Film.getGenre());
                System.out.println("Durasi Film : " + element[i].Film.getDurasi());
                System.out.println("Harga : Rp 40.000,00");
                ketemu = true;
            }
        }
        if (!ketemu) {
            System.out.println("User tidak ditemukan");
        }
    }

}

class Movie {
    private String judulFIlm;
    private String genre;
    private String durasi;

    public String getJudul() {
        return this.judulFIlm;
    }

    public String getGenre() {
        return this.genre;
    }

    public String getDurasi() {
        return this.durasi;
    }

    Movie(String judulFilm, String genre, String durasi) {
        this.judulFIlm = judulFilm;
        this.genre = genre;
        this.durasi = durasi;
    }
}

class PemesananTiket {
    public String nama;
    public String noHp;
    public Movie Film;
    public String jamTayang;
    public String kursi;
    static Scanner str = new Scanner(System.in);

    static void listFilm() {
        System.out.println("===========================================================");
        System.out.println("\tLIST FILM YANG SEDANG TAYANG");
        System.out.println("\t1 . Spiderman \tGenre : Action \t Durasi : 60 menit");
        System.out.println("\t2 . Batman \tGenre : Action \t Durasi : 70 menit");
        System.out.println("\t3 . Superman \tGenre : Action \t Durasi : 80 menit");
        System.out.println("\t4 . Antman \tGenre : Action \t Durasi : 90 menit");
        System.out.println("===========================================================");
    }

    static void listJam() {
        System.out.println("=================");
        System.out.println("1. 10.00 WIB");
        System.out.println("2. 13.00 WIB");
        System.out.println("3. 15.00 WIB");
        System.out.println("4. 18.00 WIB");
        System.out.println("=================");
    }

    static void listKursi() {
        System.out.println("===========");
        System.out.println("1. A1");
        System.out.println("2. B1");
        System.out.println("3. C1");
        System.out.println("4. D1");
        System.out.println("===========");
    }

    public void pesan() {
        System.out.println("Masukkan nama ");
        this.nama = str.next();
        System.out.println("Masukkan no Hp");
        this.noHp = str.next();
        System.out.println("Pilih List Film !!!");
        listFilm();
        int pilih = str.nextInt();
        switch (pilih) {
            case 1:
                Film = new Movie("Spiderman", "Action", "60 Menit");
                break;
            case 2:
                Film = new Movie("Batman", "Action", "70 Menit");
                break;
            case 3:
                Film = new Movie("Superman", "Action", "80 Menit");
                break;
            case 4:
                Film = new Movie("Antman", "Action", "90 Menit");
                break;
        }
        System.out.println("Pilih Jam Tayang !!!");
        listJam();
        int pilihJam = str.nextInt();
        switch (pilihJam) {
            case 1:
                this.jamTayang = "10.00 WIB";
                break;
            case 2:
                this.jamTayang = "13.00 WIB";
                break;
            case 3:
                this.jamTayang = "15.00 WIB";
                break;
            case 4:
                this.jamTayang = "18.00 WIB";
                break;
        }
        System.out.println("Pilih Tempat Duduk !!!");
        listKursi();
        int pilihKursi = str.nextInt();
        switch (pilihKursi) {
            case 1:
                this.kursi = "A1";
                break;
            case 2:
                this.kursi = "B1";
                break;
            case 3:
                this.kursi = "C1";
                break;
            case 4:
                this.kursi = "D1";
                break;
        }
        System.out.println("Tiket Berhasil Di Pesan ....");
    }
}
