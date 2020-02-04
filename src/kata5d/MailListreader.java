package kata5d;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class MailListreader {
    
     public static List<String> read(String fileName) throws Exception {
        List<String> lista = new ArrayList<>();
        File file = new File(fileName);
        try {
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                String email = sc.nextLine();
                if (email.indexOf('@') != -1) {
                    lista.add(email);
                }
            }
            sc.close();
        } 
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return lista;
    }
     
}