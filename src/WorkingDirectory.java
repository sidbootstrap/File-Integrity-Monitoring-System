import java.awt.font.ShapeGraphicAttribute;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
public class WorkingDirectory {
    public File[] ListingFiles(String path) {
        File folder = new File(path);
        File[] ListFiles = folder.listFiles();
        return ListFiles;
    }

    public String Sha3_512Conversion(File file) throws IOException, NoSuchAlgorithmException {
        FileInputStream fi0 = new FileInputStream(file);
        MessageDigest sha3_512 = MessageDigest.getInstance("SHA3-512");
        byte[] array = new byte[1024];
        int bytesCount = 0;
        while ((bytesCount = fi0.read(array)) != -1) {
            sha3_512.update(array, 0, bytesCount);
        }
        fi0.close();
        byte[] bytes = sha3_512.digest();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < bytes.length; i++) {
            sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
        }
        return sb.toString();

    }

    public HashMap<File, String> Checksum() throws IOException, NoSuchAlgorithmException {

        HashMap<File, String> map = new HashMap<File, String>();
        File[] v01 = ListingFiles("/home/agusr-sb-07/Documents");
        for (File file : v01) {
            if (file.isFile()) {
                map.put(file, Sha3_512Conversion(file));
            } else {
                File[] v02 = ListingFiles(file.getPath());
                for (File file1 : v02) {
                    if (file1.isFile()) {
                        map.put(file1, Sha3_512Conversion(file1));
                    } else {
                        File[] v03 = ListingFiles(file1.getPath());
                        for (File file2 : v03) {
                            if (file2.isFile()) {
                                map.put(file2, Sha3_512Conversion(file2));

                            } else {
                                File[] v04 = ListingFiles(file2.getPath());
                                for (File file3 : v04) {
                                    if (file3.isFile()) {
                                        map.put(file3, Sha3_512Conversion(file3));
                                    } else {
                                        File[] v05 = ListingFiles(file3.getPath());
                                        for (File file4 : v05) {
                                            if (file4.isFile()) {
                                                map.put(file4, Sha3_512Conversion(file4));
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return map;
    }
}

