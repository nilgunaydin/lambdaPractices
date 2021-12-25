package javaLambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Lambda02 {

	  public static void main(String[] args) {
	        List<Integer> list = new ArrayList<>(Arrays.asList(12, -3, 65, 3, 7, 34, 22, -60, 42, 15));
	        ciftKareMax(list);
	        System.out.println();
	        heleHele(list);
	        System.out.println();
	        ccarp(list);
	    }

	    //List'in cift olan elemanlarin karelerini aliniz ve en buyugunu yazdiriniz
	    public static void ciftKareMax(List<Integer> list) {
	        // Optional<Integer> maxEl = list.stream().filter(Lambda01::ciftBul).map(t -> t * t).reduce(Integer::max);
	        Optional<Integer> maxEl = list.stream().filter(Lambda01::ciftBul).map(t -> t * t).reduce(Math::max);
	        //reduce(Math::max) da kullanilabilir ancak reduce(Integer::max); daha specific  oldugu icin hzili calisir

	        // int maxEl = list.stream().filter(Lambda01::ciftBul).map(t -> t * t).reduce(Integer::max);
	        // reduce() returne edilen elelman null yada int 'den buyuk olur ihtimali icin Java guvenlik olarak handle ederek
	        //Optional class' sart kosuyor
	        System.out.println(maxEl);
	    }

	    //Listteki tum elemanlarin toplamini yazdiriniz
	    // Lambda Expression
	    public static void hele(List<Integer> list) {
	        int toplam = list.stream().reduce(0, (t, u) -> t + u);
	        //t degirkeni ilk degerini her zaman atanan degerden (0) alir.
	        // u her zaman degerini list.stream()'den alir(akistan).
	        //x ilk degerden sonraki degerlerini islemden alir.
	        System.out.println(toplam);
	    }

	    public static void heleHele(List<Integer> list) {
	        int toplam = list.stream().reduce(0, Integer::sum);
	        System.out.println(toplam);
	    }

	    //List'teki cift elemanlarin carpimini yazdiriniz.
	//Method Reference...
	    public static void ccarp(List<Integer> list) {
	        int carpim = list.stream().filter(Lambda01::ciftBul).reduce(1, Math::multiplyExact);
	        System.out.println(carpim);

	    }
	}
