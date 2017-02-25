/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ceasecipher;

import java.util.Scanner;

/**
 *
 * @author localhost
 */
public class CeaseCipher {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // variabel

        String kata = "NAMA SAYA ADALAH AHMAD FAUZI RAHMAN";
        int key = 5;
        String[] huruf = new String[26];

        // isi huruf array
        for (char c = 'A'; c <= 'Z'; c++) {
            huruf[c - 65] = String.valueOf(c);
        }
        //untuk menampilkan Plaint Text

        System.out.println("Plain Text :" + kata);

        //proses enkripsi dengan CeaserCipher
        String cipher = "";
        loop1:
        for (int a = 0; a < kata.length(); a++) {
            // cari nomor pada setiap huruf variabel kata
            int index_plain = -1;
            for (int b = 0; b < huruf.length; b++) {

                // Teknik penulisan short Hand If else
                index_plain = (String.valueOf(kata.charAt(a)).equals(huruf[b])) ? b : -1;
                // jika ketem karakternya
                if (index_plain != -1) {
                    // rumus enkripsi --> C = (nomor_karakter_plain + key) mode 6
                    cipher += huruf[(index_plain + key) % 26];
                    continue loop1;
                }
            }
            // jika plain text tidak mengandung huruf maka, langsung dimasukkan ke variabel cipher
            // misal spasi atau angka
            cipher += kata.charAt(a);
        }

        // tampilkan hasil cipher
        System.out.println("Cipher text : " + cipher);
        // konfirmasi apakah ingin dekripsi
        System.out.println("Apakah ingin didekripsi(Y/N)?");
        String jawab = new Scanner(System.in).nextLine();

        if (jawab.equalsIgnoreCase("Y")) {
            String plaintext = "";

            //proses deksripsi huruf yang sudah dideksripsi
            loop1:
            for (int a = 0; a < cipher.length(); a++) {
                // mencari nomor tiap karakter cipher

                int index_cipher = -1;
                for (int b = 0; b < huruf.length; b++) {
                    index_cipher = (String.valueOf(cipher.charAt(a)).equals(huruf[b])) ? b : -1;

                    // jika ketemu
                    if (index_cipher != -1) {
                        // rumus deskripsi --> P = (nomor_karakter_cipher - key) mod 26 
                        // jika (nomor_karakter_cipher - key) < 0 maka, 26 + (nomor_karakter_cipher - key)
                        // jika (nomor_karakter_cipher - key) >= 0 maka, (nomor_karakter_cipher - key) mod 26
                        
                        plaintext += ((index_cipher - key) >= 0) ? 
                                huruf[(index_cipher - key ) % 26]
                                : huruf[26 + (index_cipher - key)];
                        continue loop1;
                        
                    }

                }
            //jika tidak ketemu
                plaintext += cipher.charAt(a);
            }
            //tampilkan hasil deskripsi
            System.out.println("Hasil Deksripsi adalah : "+plaintext);
        }
    }

}
