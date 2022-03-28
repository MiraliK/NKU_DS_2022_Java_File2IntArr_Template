### Metin Dosyasindaki Degerleri Diziye Aktarma

Eliminiz altinda `liste.txt' isimli bir metin dosyasi olsun ve bu dosyada tam sayilar saklansin. Tam sayilar birbirinden bosluk (space) karakteri ile ayrilsin. Ornegin liste.txt dosyamizin icerigi asagidaki gibi olabilir.

`5 6 7 8 9 4 3 5 4 3`

Bu dosyayi okuyup icerigini int turde bir diziye aktarabiliriz. Parametre olarak dosya ismi (ya da yolu) alip o dosyadaki degerleri sirasiyla iceren int dizisi donduren `ReadIntArrayFromFile` metodunu inceleyiniz. Bu metodu icinde tam sayilarin birbirlerinden bosluk karakteri ile ayrildigi turde bir metin dosyasinda kullabiliriz; ama bu fonksiyonu bu formatta olmayan bir dosyanin iceriginden dizi elde etmek icin kullanmak beklenmeyen sonuclar uretebilir. Bu  metodu bundan sonraki bazi odevlerde kullanmaniz gerekecektir. Bu nedenle metodun amacinin ne oldugunu ve metodun nasil kullanilabilecegini anlamaniz bazi odevleri kolay kodlayabilmenizde faydali olacaktir. 

```java
import java.io.FileReader;
import java.util.*;

public class Main {
    public static void main(String[] args){
        int[] elems = ReadIntArrayFromFile("list.txt");
        int i = 1;
        for (int v : elems){
            System.out.println("Dosyadaki " + i  + ". tam sayi " + v + "'dir.");
            i++;
        }
    }

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
```

Yukaridaki programin ciktisi:

```bash
Dosyadaki 1. tam sayi 5'dir.
Dosyadaki 2. tam sayi 6'dir.
Dosyadaki 3. tam sayi 7'dir.
Dosyadaki 4. tam sayi 8'dir.
Dosyadaki 5. tam sayi 9'dir.
Dosyadaki 6. tam sayi 4'dir.
Dosyadaki 7. tam sayi 3'dir.
Dosyadaki 8. tam sayi 5'dir.
Dosyadaki 9. tam sayi 4'dir.
Dosyadaki 10. tam sayi 3'dir.
```

Asagida bu metodu kullanan baska bir kod ve bu kodun terminal ciktisi verilmektedir. Verilen kod komut satiri argumani olarak alinan dosyadaki sayilarin toplamini ekrana yazdirmaktadir.

```java
import java.io.FileReader;
import java.util.*;

public class Main {
    public static void main(String[] args){
       int[] arr = ReadIntArrayFromFile(args[0]);
       int sum = 0;
       for (int i = 0; i < arr.length; i++){
           sum += arr[i];
       }
       System.out.println(sum);
    }

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
```

```bash
cat listem.txt #cat komutu ile dosya icerigini ekrana yazdirabilirsiniz
1 3 5 89 -9 87 34
javac Main.java #Yukaridaki kodu derlemek icin terminale yazdigimiz komut
java Main.class listem.txt #Derlenmis programi listem.txt argumani ile calistirma
210 #Calistirdigimiz programin ciktisi
