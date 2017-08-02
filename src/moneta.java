public class moneta {
    public static String moneta(){
        double rebro = 0.5;
        double random = Math.random();
        if (rebro==random)
            return "Ребро";
        else if (rebro>random)
            return "Решка";
        else return "Орел";
    }
}
