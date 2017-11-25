/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coursework1;

import java.util.Arrays;


public class SubseriesSearch {
    
    int index;
    int T;
    double distance;
    
    public SubseriesSearch(){
        index = 0;
        T = 0; 
        distance = 0;
    }
    
    int getIndex(){
        return index;
    }
    
    double getDistance(){
        return distance;
    }
    
    void output(){
        System.out.println("index: " + T + ", " + index + "\ndistance: " + distance); 
    }
            
    double d(double[]Q, double[] S){
        double sum = 0;
        for(int i = 0; i < S.length; i++)
            sum+=(S[i]-Q[i])*(S[i]-Q[i]);
        return Math.sqrt(sum);
    }
    
    void printArrLine(double[] Q){
        for(int i = 0; i < Q.length; i++)
            System.out.print(i == Q.length-1 ? Q[i] + "\n" : Q[i] + ", ");
    }
    
    void run(double[] S, double[][] T){
        
        int k = S.length;
        double[] Q = new double[3];
        double temp;
        this.distance = 0;
        
        for(int i = 0; i<T.length;i++)
        {
            for(int j = 0; j<T[i].length-k+1;j++)
            {
                Q = Arrays.copyOfRange(T[i], j, j+k);
                
                temp = d(S,Q);
                
                if(temp < this.distance || (j == 0 && i == 0))
                {
                    this.T = i;
                    this.index = j;
                    this.distance = temp;
                }
            }
        }
    }
    
    public void experiment(int n)
    {
        RandomGenerator T = new RandomGenerator();
        run(T.makeQuery(3), T.makeSet(n));
    }
    
    public void timingExperiment(int n, int reps)
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
    
    
}
