/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coursework1;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
/**
 *
 * @author User
 */
public class RandomGenerator {
    
    public static Random rand()
    {
        return new Random();
    }
    
    public static int[] makeQuery(int s)
    {
        int[] q = new int[s];
        
        for(int i = 0; i < s; i++)
        {
            q[i] = ThreadLocalRandom.current().nextInt(0,10);
        }
        
        return q;
    }
    
    public static int[][] makeSet(int n)
    {
        int[][] T = new int[n][n];
        
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            {
                T[i][j] = ThreadLocalRandom.current().nextInt(0,10);
            }  
        }
        return T;
    }
    
    
    
}
