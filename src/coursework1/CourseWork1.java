package coursework1;

import java.util.Arrays;

public class CourseWork1 {
    
    static int[] subSeriesSearch(int[] S, int[][] T)
    {    
        int k = S.length;
        int[] Q = new int[k];
        double distance = 0;
        int[] index = new int[2];
        for(int i = 0; i<T.length;i++)
        {
            for(int j = 0; j<T[i].length;j++)
            {
                Q = Arrays.copyOfRange(T[i], j, j+k);
                double sum = 0;
                for(int l = 0; l < S.length; l++)
                    sum+=(S[l]-Q[l])*(S[l]-Q[l]);
                sum = Math.sqrt(sum);
                if(sum == 0)
                    return new int[] {i,j};
                else if(sum < distance || (j == 0 && i == 0))
                {
                    index = new int[] {i,j};
                    distance = sum;
                }
            }
        }
        return index;
    }
    static public void experiment(int n)
    {
        RandomGenerator T = new RandomGenerator();
        subSeriesSearch(T.makeQuery(3), T.makeSet(n));
    }
    
    static public void sd(int n, int reps)
    {
        double sum = 0;
        double sumSquared = 0;
        double stdDev = 0;

        for(int i = 0; i< reps; i++) 
        {
            long t1 = System.nanoTime();
            experiment(n);
            long t2 = System.nanoTime() - t1;
            double add = (double) t2 /1000000.0;
            sum+= add;
            sumSquared += add*add;

        }
        double mean = sum / reps;
        double variance = sumSquared / reps - (mean * mean);
        System.out.println(Math.sqrt(variance));
           
    }
    
    static public void mean(int n, int reps)
    {
        double sum = 0;
        for(int i = 0; i< reps; i++) 
        {
            long t1 = System.nanoTime();
            experiment(n);
            long t2 = System.nanoTime() - t1;
            sum+= (double) t2/1000000.0; 
        }
        System.out.println(sum/reps);
    }
    public static void main(String[] args) 
    {
        for(int i = 0;i<1000;i+=10)
            mean(i,1000);
        
        
        
    }
    
}
