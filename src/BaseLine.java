import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Iterator;
public class BaseLine {
    public String Sha3_512Conversion(File file) throws IOException, NoSuchAlgorithmException {
        FileInputStream fi0 = new FileInputStream(file);
        MessageDigest sha3_512 = MessageDigest.getInstance("SHA3-512");
        byte[] array = new byte[4096];
        int bytesCount;
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

    public HashMap<File,String> Checksum(String path) throws IOException, NoSuchAlgorithmException {

        HashMap<File,String> map = new HashMap<>();
        File files= new File(path);
        File[] listFiles = files.listFiles();
        for(File file : listFiles){
            if(file.isFile()){
                map.put(file,Sha3_512Conversion(file));
            }
        }
        return map;
    }
    public void BaseFileOrigin(String path) throws NoSuchAlgorithmException{
        HashMap<File,String> map = new HashMap<>();
        // Collecting all files checksum and storing it in a baseline file.
        try {
            File file = new File("baseLine.txt");
            if(!file.exists()){
                file.createNewFile();
            }
            PrintWriter pw = new PrintWriter(file);
            map.putAll(Checksum(path));
            Iterator<HashMap.Entry<File,String>> it = map.entrySet().iterator();
            while (it.hasNext()){
                pw.println(it.next());
            }
            pw.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

}
