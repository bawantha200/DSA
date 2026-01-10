/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package HanoiTower;

/**
 *
 * @author Bawantha
 */
public class HanoiTower {

    public void solveHanoi(int n, String source, String auxiliary, String destination){
        if(n == 1){
            System.out.println("Move disc 1 from " + source + " to " + destination);
            return;
        }
        
        //move n-1 discs from source to auxiliary, using destination as auxiliary
        solveHanoi(n-1, source, destination, auxiliary);
        
        //move the n th disc / largest from source to destination
        System.out.println("Move disc " + n + " from " + source + " to " + destination);
        
        //move the n-1 discs from auxiliary to destination, using source as auxiliary
        solveHanoi(n-1, auxiliary, source, destination);
    }
    public static void main(String[] args) {
        // TODO code application logic here
        HanoiTower hanoi = new HanoiTower();
        int numberOfDiscs = 3;
        
        System.out.println("Solving Tower of Hanoi for " + numberOfDiscs + " Discs.");
        
        //Source: A, Auxiliary: B, Destination: C
        hanoi.solveHanoi(numberOfDiscs, "Source", "Auxiliary", "Destination");
        
        //moves (2^3)-1 = 7
    }
    
}
