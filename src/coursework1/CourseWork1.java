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
    
    static void run(int[] S, int[][] T){
        
        int k = S.length;
        int[] Q = new int[k];
        
        double distance = 0;
        int[] index = new int[2];
        for(int i = 0; i<T.length;i++)
        {
            for(int j = 0; j<T[i].length;j++)
            {
                Q = Arrays.copyOfRange(T[i], j, j+k);
                System.out.print(T[i][j] + " , ");
                double sum = 0;
                for(int l = 0; l < S.length; l++)
                    sum+=(S[l]-Q[l])*(S[l]-Q[l]);
                sum = Math.sqrt(sum);
                
                if(sum < distance || (j == 0 && i == 0))
                {
                    index = new int[] {i,j};
                    distance = sum;
                    //System.out.println(i + "," + j);
                }
            }
            System.out.println();
        }
        System.out.println(T[index[0]][index[1]]);
    }
    
    static public void experiment(int n)
    {
        RandomGenerator T = new RandomGenerator();
        run(T.makeQuery(8), T.makeSet(n));
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
        experiment(10);
        
        
        
        
    }
    
}
