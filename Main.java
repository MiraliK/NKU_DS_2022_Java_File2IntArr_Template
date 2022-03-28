import java.io.FileReader;
import java.util.*;

public class Main {
    public static void main(String[] args){
       //kodlarinizi buraya yazabilirsiniz. Gerek duyarsaniz yeni metod tanimlari yapabilirsiniz. 
       // Lutfen tum kodunuzu bu dosya (Main.java) icinde yaziniz.
    }
    
    //Bu metodun kodlari ile oynamayiniz. Yazacaginiz kodda bu metodu kullanmaniz gerekecektir.
    public static int[] ReadIntArrayFromFile(String path){
        List<Integer> intList = new ArrayList<Integer>();
        Scanner sc;
        try {
            sc = new Scanner(new FileReader(path)).useDelimiter("\\s+");
        }
        catch(Exception ex){
            return null;
        }

        while (sc.hasNext()) {
            String token = sc.next();
            int num = Integer.parseInt(token);
            intList.add(num);
        }

        int[] intArray = new int[intList.size()];
        int ind = 0;
        for (Integer v:intList){
            intArray[ind++] = v.intValue();
        }
        return intArray;
    }
}


