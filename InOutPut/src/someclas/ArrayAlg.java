package someclas;


public class ArrayAlg {
    public static Pairr<String> minmax(String[] a){
        if (null == a || 0 == a.length) return null;
        String min = a[0];
        String max = a[0];
        for (int i = 0; i < a.length; i++){
            if (min.compareTo(a[i]) > 0) min = a[i];
            if (max.compareTo(a[i]) < 0) max = a[i];
        }
        return new Pairr(min, max);
    }
}
