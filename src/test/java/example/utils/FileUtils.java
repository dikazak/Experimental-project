package example.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Random;

public class FileUtils {

    public static byte[] fromFile(String fileName) throws IOException {
        return new FileInputStream(fileName).readAllBytes();
    }

    public static byte[] generateVideo() {
        // video/quicktime format
        return new byte[] {0, 0, 0, 32, 102, 116, 121, 112, 105, 115, 111, 109, 0, 0, 2, 0, 105, 115, 111, 109, 105, 115, 111, 50, 97, 118, 99, 49, 109, 112, 52, 49, 0, 0, 0, 8, 119, 105, 100, 101, 0, 0, 0, 1, 109, 100, 97, 116};
    }

    public static byte[] generateImage() {
        // png
        return new byte[] {-119, 80, 78, 71, 13, 10, 26, 10, 0, 0, 0, 13, 73, 72, 68, 82, 0, 0, 8, 0, 0, 0, 8, 0, 8, 6, 0, 0, 0, -78, -89, -45, 48, 0, 0, 0, 4, 103, 65, 77, 65, 0, 0, -79, -113, 11, -4, 97, 5, 0, 0, 0, 32, 99, 72, 82, 77, 0, 0, 122, 38, 0, 0, -128, -124, 0, 0, -6, 0, 0, 0, -128, -24, 0, 0, 117, 48, 0, 0, -22, 96, 0, 0, 58, -104, 0, 0, 23, 112, -100, -70, 81, 60, 0, 0, 0, 6, 98, 75, 71};
    }

    public static byte[] generateTextFile() {
        int size = 1024;
        byte[] array = new byte[size];
        new Random().nextBytes(array);
        return new String(array, StandardCharsets.UTF_8).getBytes();
    }

}
