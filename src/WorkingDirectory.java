import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
public class WorkingDirectory {
    public File[] ListingFiles(String path) {
        File folder = new File(path);
        File[] ListFiles = folder.listFiles();
        return ListFiles;
    }


    public void Checksum() throws IOException, NoSuchAlgorithmException {


        File[] v01 = ListingFiles("/home/agusr-sb-07/Documents");
        for (File file : v01) {
            if (file.isFile()) {
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
                System.out.println(file + " " + sb.toString());
            } else {
                File[] v02 = ListingFiles(file.getPath());
                for (File file2 : v02) {
                    if (file2.isFile()) {
                        FileInputStream fi0 = new FileInputStream(file2);
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
                        System.out.println(file2 + " " + sb.toString());

                    } else {
                        File[] v03 = ListingFiles(file2.getPath());
                        for (File file3 : v03) {
                            if (file3.isFile()) {
                                FileInputStream fi0 = new FileInputStream(file3);
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
                                System.out.println(file3 + " " + sb.toString());
                            } else {
                                File[] v04 = ListingFiles(file3.getPath());
                                for (File file4 : v04) {
                                    if (file4.isFile()) {
                                        FileInputStream fi0 = new FileInputStream(file4);
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
                                        System.out.println(file4 + " " + sb.toString());
                                    } else {
                                        File[] v05 = ListingFiles(file4.getPath());
                                        for (File file5 : v05) {
                                            if (file5.isFile()) {
                                                FileInputStream fi0 = new FileInputStream(file5);
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
                                                System.out.println(file5 + " " + sb.toString());
                                            } else {
                                                File[] v06 = ListingFiles(file5.getPath());
                                                for (File file6 : v06) {
                                                    if (file6.isFile()) {
                                                        FileInputStream fi0 = new FileInputStream(file6);
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
                                                        System.out.println(file6 + " " + sb.toString());
                                                    } else {
                                                        File[] v07 = ListingFiles(file6.getPath());
                                                        for (File file7 : v07) {
                                                            if (file7.isFile()) {
                                                                FileInputStream fi0 = new FileInputStream(file6);
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
                                                                System.out.println(file7 + " " + sb.toString());
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
                    }
                }
            }
        }
    }
}