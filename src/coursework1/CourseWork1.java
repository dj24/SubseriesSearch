/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coursework1;

import java.util.Arrays;

/**
 *
 * @author pdu15gsu
 */
public class CourseWork1 {
    
    static void run(double[] S, double[][] T){
        
        int k = S.length;
        double[] Q = new double[k];
        
        double distance = 0;
        int[] index = {0,0};
        for(int i = 0; i<T.length;i++)
        {
            for(int j = 0; j<T[i].length-k+1;j++)
            {
                Q = Arrays.copyOfRange(T[i], j, j+k);
                
                double sum = 0;
                for(int l = 0; l < S.length; l++)
                    sum+=(S[l]-Q[l])*(S[l]-Q[l]);
                sum = Math.sqrt(sum);
                
                if(sum < distance || (j == 0 && i == 0))
                {
                    index[0] = i;
                    index[1] = j;
                    distance = sum;
                    System.out.println(distance);
                }
            }
        }
    }
    
    static public void experiment(int n)
    {
        RandomGenerator T = new RandomGenerator();
        run(T.makeQuery(3), T.makeSet(n));
    }
    
    static public void timingExperiment(int n, int reps)
    {
        double sum = 0;
        for(int i = 0; i< reps; i++) 
        {
            long t1 = System.nanoTime();
            experiment(n);
            sum+= (System.nanoTime() - t1)/10000000.0; 
            //System.out.println(sum);
        }
        if(n != 0)
            System.out.println(sum/100);
    }
    public static void main(String[] args) 
    {
        experiment(50);
        
        
        
        
    }
    
}
