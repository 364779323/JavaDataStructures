package Array;

public class ArrayTest {
    public static void main(String[] args) {
        Array<Integer> arr=new Array<Integer>();
        for(int i=0;i<11;i++)
            arr.addLast(i);
        System.out.println(arr);

//        arr.addIndex(1,100);
//        System.out.println(arr);
//
//        arr.addFirst(-1);
//        System.out.println(arr);
//
//        System.out.println(arr.removeFirst());
//        System.out.println(arr);
//        arr.remoceElement(100);
//        System.out.println(arr);
    }


}
