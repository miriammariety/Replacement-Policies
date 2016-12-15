
import java.util.LinkedList;
import java.util.Queue;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ty
 */
public class FIFO {
    LinkedList frameQ;
    String[] reference;
    int frameSizeLimit;
    
    public FIFO(String[] reference, int frameSize){
        frameQ = new LinkedList();
        this.reference = reference;
        this.frameSizeLimit = frameSize;
    }
    
    public void start(){
        System.out.println("\n=====FIRST IN FIRST OUT REPLACEMENT POLICY=====");
        int faultCtr = 0;
        
        for (int i = 0; i < reference.length; i++){
            System.out.println("Run #: " + (i+1) +"\t");
            if(frameQ.size() == frameSizeLimit){
                if(frameQ.contains(reference[i])) display();
                else {
                    faultCtr++;
                    System.out.print("PAGE FAULT: Add element " + reference[i] + "\t");
                    frameQ.removeFirst();
                    frameQ.addLast(reference[i]);
                    display();
                }
            } else {
                if(frameQ.contains(reference[i])) display();
                else {
                    frameQ.addLast(reference[i]);
                    display();
                }
                
            }
        }
        System.out.println("\nTOTAL NUMBER OF PAGE FAULT: " + faultCtr);
    }
    
    public String display(){
        String elements = "";
        for (int index = 0; index < frameQ.size(); index++) {
            elements += frameQ.get(index) + " ";
        }
        System.out.println("Frame: [ " + elements + "]");
        return elements;
    }

}
