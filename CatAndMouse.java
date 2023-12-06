package assignment1;

//Joshua Safford, Programming Assignment #1: Simulating a Chase
//Feb 3 2021 
//Description: A simulation of a cat chasing a mouse if either hit a rock the slow down for that turn
//Help: Dr. Simon



import java.util.*;
import java.util.Arrays;
public class CatAndMouse { 
private static int move(int p, int s, String [] t){    
 while(s>0){
  s--;
  p++;
  
  if(p == t.length){
         p=0;
 }
  if(t[p].equals("x")){
     s--;
  }
 }
 return p;
}  
private static void printTrack(String [] t, int x, int y){
 for(int i=1; i<t.length; i++){
   if(i == x){
     t[x] = "c";
   }
   if(i == y){
   t[y]= "m";
   }       
   if((i != x) && (i != y) && (t[i] != "x")){
     t[i] = " ";
   }
   if((i == x) && (i == y)){
     t[i] = "*";
   }      
   System.out.print(t[i]);
 }
 System.out.println();
}                          
public static void main(String[] args) {
 
 Scanner sc = new Scanner(System.in);
 
 System.out.println("Enter the Track Length, Cats moves per turn, and Mouses moves per turn in that order separated by spaces");
 String info = sc.nextLine();
 System.out.println("/" + info + "/");
 String [] info1 = info.split(" ");
 int n = Integer.parseInt( info1[0] );
 int c = Integer.parseInt( info1[1] );
 int m = Integer.parseInt( info1[2] );
 
 System.out.println("Enter the number of rocks and position of each rock separated by a space");
 String rocks = sc.nextLine();
 System.out.println("/" + rocks + "/");
 String [] rp = rocks.split(" ");
 int r = Integer.parseInt( rp[0] );
 String [] track = new String[n];

 for(int i=1; i<rp.length; i++) {
  int rp1 = Integer.parseInt( rp[i] );
   track[rp1] = "x";
 }
 for(int i=0; i<track.length; i++){
   if(track[i] == null)
     track[i] = " ";
 }
 
 int counter = 0;
 int cp = 0;
 int mp = 0;
 track[0]= "*";
 
 for(int i=0; i<track.length; i++){
   System.out.print(track[i]);
 }
 System.out.println();
 do 
 {

  cp = move(cp, c, track);
  mp = move(mp, m, track);
  printTrack(track, cp, mp);
  
   for(int i=1; i<rp.length; i++) {
  int rp1 = Integer.parseInt( rp[i] );
   track[rp1] = "x";
 }     
  counter++;     
 }
 while(cp != mp);
 
 System.out.println("Number of turns before the cat caught the mouse: " + counter);
 
}
}