package chapter;

import someclas.ArrayAlg;
import someclas.Pairr;

public class Eight {
    public void function(){

//        useGenericClas();
        useGenericMethod();
    }

    //泛型类
    public void useGenericClas(){
        String[] words = {"Mary", "had", "A", "little", "lamb"};
        Pairr<String> mm = ArrayAlg.minmax(words);
        System.out.println("min = " + mm.getFirst());
        System.out.println("max = " + mm.getSecond());
    }

    //泛型方法
    public void useGenericMethod(){
        String middle = ArrayAlg.getMiddle("I", "have", "an", "apple", "!");
        System.out.println(middle);
        double d = ArrayAlg.getMiddle(10.0, 21.8, 23.5, 25.6, 32.0, 25.0);
        System.out.println("middle = " + d);

        int min = ArrayAlg.min(2, 10, -6, 5, 7, 18, 1000);
        System.out.println("min = " + min);
    }
}
