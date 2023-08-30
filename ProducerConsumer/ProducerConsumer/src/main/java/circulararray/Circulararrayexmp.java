package circulararray;

public class Circulararrayexmp {
    public static void main(String[] args){
        CircularArray<Integer> myArray = new CircularArray<>(5);
        myArray.addfirst(1);
        myArray.addfirst(2);
        System.out.println(myArray.show());
    }
}
