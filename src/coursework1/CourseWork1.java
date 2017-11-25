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
    
    public static void main(String[] args) 
    {
        RandomGenerator T = new RandomGenerator();
        
        SubseriesSearch sub = new SubseriesSearch();
        
        
        
        for(int i = 0; i <= 500; i+=20)
        {
            sub.timingExperiment(i,1000);
        }
    }
    
}
