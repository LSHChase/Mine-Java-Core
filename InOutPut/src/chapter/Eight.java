package chapter;

import someclas.ArrayAlg;
import someclas.Pairr;

public class Eight {
    public void function(){
        useGenericClas();
    }

    //泛型类
    public void useGenericClas(){
        String[] words = {"Mary", "had", "a", "little", "lamb"};
        Pairr<String> mm = ArrayAlg.minmax(words);
        System.out.println("min = " + mm.getFirst());
        System.out.println("max = " + mm.getSecond());
    }
}
