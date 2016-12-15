
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ty
 */
public class LRU {
    ArrayList frame;
    int[] time;
    String[] reference;
    int limit;
    
    public LRU(String[] reference, int limit){
        this.time = new int[limit];
        frame = new ArrayList<>();
        this.reference = reference;
        this.limit = limit;
    }
    
    public void start(){
        System.out.println("\n=====LEAST RECENTLY USED REPLACEMENT POLICY=====");
        int faultCtr = 0;
        
        for(int i = 0; i < reference.length; i++){
            System.out.print("Run #: " + (i+1) + "\t");
            if(frame.size() == limit){
                if(frame.contains(reference[i])){
                    int index = frame.indexOf(reference[i]);
                    time[index] = i;
                    display();
                } else {
                    int minIndex = 0;
                    int min = 999999;
                    for(int index = 0; index < time.length; index++){
                        if(time[index] < min){
                            min = time[index];
                            minIndex = index;
                        }
                    }
                   
                    faultCtr++;
                    frame.set(minIndex, reference[i]);
                    time[minIndex] = i;
                    System.out.print("PAGE FAULT: Add element " + reference[i] + "\t");
                    
                    display();
                }
            } else {
                if(frame.contains(reference[i])) display();
                else {
                    frame.add(reference[i]);
                    display();
                }
            }
        }
        
        System.out.println("\nTOTAL NUMBER OF PAGE FAULT: " + faultCtr);
    }
    
    public void display(){
        String elements = "";
        for(int i = 0; i < frame.size(); i++){
            elements += frame.get(i) + " ";
        }
        System.out.println("Frame: [ " + elements + "]");
    }
}
