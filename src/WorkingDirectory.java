import javax.swing.JOptionPane;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
public class WorkingDirectory extends BaseLine{
    public HashMap<File,String> readMap(){
        HashMap<File, String> map = new HashMap<>();
        BufferedReader br = null;
        try {
            File file = new File("baseLine.txt");
            br = new BufferedReader(new FileReader(file));
            String line = null;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("=");
                String file_path = parts[0].trim();
                String hash = parts[1].trim();
                if (!file_path.equals("") && !hash.equals(""))
                    map.put(new File(file_path), hash);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            if (br != null) {
                try {
                    br.close();
                }
                catch (Exception e) {
                }
            }
        }
        return map;
    }
    public void CheckAlerts(String path) throws IOException, NoSuchAlgorithmException{
        while (true) {
            Toolkit tk = Toolkit.getDefaultToolkit();
            HashMap<File, String> map = new HashMap<>();
            File files = new File(path);
            File[] list = files.listFiles();
            for (File file : list) {
                if (file.isFile()) {
                    map.put(file, Sha3_512Conversion(file));
                }
            }
            if (!map.equals(readMap())) {
                tk.beep();
                JOptionPane.showMessageDialog(null, "Alert, FILE INTEGRITY COMPROMISED");
            }
        }
    }

}