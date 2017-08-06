public class roll {
    public static int roll(){
        int max = 100; // Максимальное число для диапазона от 0 до max

        return (int) (Math.random()* ++max);
    }
}
