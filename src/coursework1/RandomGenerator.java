/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coursework1;
import java.util.Random;
/**
 *
 * @author User
 */
public class RandomGenerator {
    
    public static Random rand()
    {
        return new Random();
    }
    
    public static double[] makeQuery(int s)
    {
        double[] q = new double[s];
        
        for(int i = 0; i < s; i++)
        {
            q[i] = new Random().nextDouble();
        }
        
        return q;
    }
    
    public static double[][] makeSet(int n)
    {
        double[][] T = new double[n][n];
        
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            {
                T[i][j] = new Random().nextDouble();
            }  
        }
        return T;
    }
    
    
    
}
