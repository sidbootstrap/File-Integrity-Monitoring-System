import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;
import static java.lang.System.in;


public class WorkingDirectory{

    Scanner sc = new Scanner(in);

    public File[] ListingFiles(String path){
        File folder = new File(path);
        File[] ListFiles = folder.listFiles();
        return ListFiles;
    }

    public void Checksum() throws IOException, NoSuchAlgorithmException {
        File[] v01 = ListingFiles("/home/agusr-sb-07/");
        for(File file : v01){
            if(file.isFile()){
                FileInputStream fi0 = new FileInputStream(file);
                MessageDigest sha3_512 = MessageDigest.getInstance("SHA3-512");
                byte[] array = new byte[1024];
                int bytesCount = 0;
                while ((bytesCount = fi0.read(array)) != -1){
                    sha3_512.update(array,0,bytesCount);
                }
                fi0.close();
                byte[] bytes = sha3_512.digest();
                StringBuilder sb = new StringBuilder();

                for(int i=0;i<bytes.length;i++){
                    sb.append(Integer.toString((bytes[i] & 0xff) + 0x100,16).substring(1));
                }
                System.out.println(file+" "+sb.toString());
            }
            else{
                File[] v02 = ListingFiles(file.getPath());
                for(File file2 : v02){
                    if(file2.isFile()){
                        FileInputStream fi02 = new FileInputStream(file2);
                        MessageDigest sha3_512_1 = MessageDigest.getInstance("SHA3-512");
                        byte[] array1 = new byte[1024];
                        int bytesCount = 0;
                        while ((bytesCount = fi02.read(array1)) != -1){
                            sha3_512_1.update(array1,0,bytesCount);
                        }
                        fi02.close();
                        byte[] bytes1 = sha3_512_1.digest();
                        StringBuilder sb2 = new StringBuilder();

                        for(int i=0;i<bytes1.length;i++){
                            sb2.append(Integer.toString((bytes1[i] & 0xff) + 0x100,16).substring(1));
                        }
                        System.out.println(file2+" "+sb2.toString());}
                }
            }
        }
    }
}