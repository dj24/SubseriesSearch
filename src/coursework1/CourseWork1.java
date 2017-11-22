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
        int[] S = {0,1,5};
        
        int[][] T = {{1,2,3,0,1,5},{1,2,3,0,1,5},{0,1,5},{1,2,3,1,0,3}};
        
        SubseriesSearch sub = new SubseriesSearch();
        
        sub.run(S, T);
        
        sub.output();
    }
    
}
