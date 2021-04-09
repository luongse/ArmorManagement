package luongnd.dao;

import luongnd.dto.ArmorDTO;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class FileDAO {
    public static List<ArmorDTO> openFile(String filename) {
        List<ArmorDTO> listArmor = new ArrayList<>();
        FileReader f = null;
        BufferedReader bf = null;
        try {
            f = new FileReader(filename);
            bf = new BufferedReader(f);
            
            while (bf.ready()) {                
                String temp = bf.readLine();
                String[] arr = temp.split(";");
                if (arr.length == 6) {
                    ArmorDTO dto = new ArmorDTO(arr[0], arr[1], arr[2], arr[3], arr[4], Integer.parseInt(arr[5]));
                    listArmor.add(dto);
                }
            }    
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        } finally {
            try {
                if (f != null) {
                    f.close();
                }
                if (bf != null) {
                    bf.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        
        return listArmor;
    }
    
    public static boolean writeFile(List<ArmorDTO> listArmor, String filename)throws FileNotFoundException{
        if (listArmor == null || listArmor.isEmpty()) 
            return false;
        
        try {
            File f = new File(filename);
            FileWriter fw = new FileWriter(f);
            PrintWriter pw = new PrintWriter(fw);
            
            for (ArmorDTO x : listArmor) {
                pw.println(x.getArmorID() + ";" 
                        + x.getClassification() + ";" 
                        + x.getDescription() + ";" 
                        + x.getStatus() + ";" 
                        + x.getDate() + ";" 
                        + x.getDefense());
            }
            pw.close();
            fw.close();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return true;
    }
}
