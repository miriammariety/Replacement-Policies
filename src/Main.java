
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ty
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int length, frames;
        String choice;
        String[] reference;
        
        System.out.print("Input your choice of replacement policy: ");
        choice = in.nextLine().toLowerCase();
        System.out.print("Input length of reference string: ");
        length = in.nextInt();in.nextLine();
        System.out.print("Input number of frames: ");
        frames = in.nextInt();in.nextLine();
        System.out.print("Input reference string (Separate by comma): ");
        reference = in.nextLine().split(",");
        while(reference.length != length){
            if(reference.length > length){
                System.out.println("Invalid input. Reference string > Inputted length.");
                System.out.print("Input reference string (Separate by comma): ");
                reference = in.nextLine().split(",");
            } else {
                System.out.println("Invalid input. Reference string < Inputted length."); 
                System.out.print("Input reference string (Separate by comma): ");
                reference = in.nextLine().split(",");
            }
        }
        switch(choice){
            case "fifo":
                FIFO fifo = new FIFO(reference, frames);
                fifo.start();
                break;
            case "lfu":
                LFU lfu = new LFU(reference, frames);
                lfu.start();
                break;
            case "lru":
                LRU lru = new LRU(reference, frames);
                lru.start();
                break;
        }
        
    }
}
