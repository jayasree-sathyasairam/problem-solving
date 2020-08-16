public class sample {
    public static void main(String[] args)
    {
        long start = System.currentTimeMillis();
        sample obj = new sample();
        for (long i = 0; i < 2; i++);
        long end = System.currentTimeMillis();
        System.out.println(end - start);
        System.out.println(Character.getNumericValue('A'));
    }
    public long factorial(int num){
        if((num==0)||(num==1))
            return 1;
        else
            return num * factorial(num-1);
    }
}
