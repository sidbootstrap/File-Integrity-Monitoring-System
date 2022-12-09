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
        File[] v01 = ListingFiles("/boot");
        for(File file : v01){
            if(file.isFile()){
                FileInputStream fi0 = new FileInputStream(file);
                MessageDigest sha3_512 = MessageDigest.getInstance("SHA3-512");
                byte[] array = new byte[1024];
                int bytesCount = 0;
                while ((bytesCount = fi0.read(array)) != -1){
                    sha3_512.update(array,0,bytesCount);
                };
                fi0.close();
                byte[] bytes = sha3_512.digest();
                StringBuilder sb = new StringBuilder();

                for(int i=0;i<bytes.length;i++){
                    sb.append(Integer.toString((bytes[i] & 0xff) + 0x100,16).substring(1));
                }
                System.out.println(file+" "+sb.toString());
            }
            else{
                System.out.println(file + "is a folder");
            }
        }
    }
}