
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
public class LFU {
    ArrayList frame;
    int[] count;
    String[] reference;
    int limit;
    
    public LFU(String[] reference, int frameSize){
        this.frame = new ArrayList<>();
        this.reference = reference;
        this.count = new int[frameSize];
        this.limit = frameSize;
    }
    
    public void start(){
        System.out.println("\n=====LEAST FREQUENTLY USED REPLACEMENT POLICY=====");
        int faultCtr = 0;
        
        for(int i = 0; i < reference.length; i++){
            System.out.print("Run #: " + (i+1) +"\t");
            if(frame.size() == limit){
                if(frame.contains(reference[i])){
                    int index = frame.indexOf(reference[i]);
                    count[index] += 1;
                    display();
                } else {
                    int minIndex = 0;
                    int min = 0;
                    for(int index = 0; index < count.length; index++){
                        if(count[index] < min){
                            min = count[index];
                            minIndex = index;
                        }
                    }
                   
                    faultCtr++;
                    frame.set(minIndex, reference[i]);
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
