package ath;

import java.io.*; 
public class TestFile 
{ 
  public static void main(String[] args)throws Exception 
  { 
  // We need to provide file path as the parameter: 
  // double backquote is to avoid compiler interpret words 
  // like \test as \t (ie. as a escape sequence) 
  File file = new File("\\D:\\documents\\java.exercises\\Testm\\src\\ath\\DFA_Input_1.txt"); 
  BufferedReader br = new BufferedReader(new FileReader(file)); 
  String[][] l1 = new String[10][];
		 l1[0] =  br.readLine().split(" ");
  char[] c = new char [l1.length];
  char[] c1 = new char[2];
  c[0] =  l1[0][0].charAt(0);
  		 c[1] = l1[0][1].charAt(0);
  System.out.println(c[1]);
  
  int i = 0;
  for (String str : l1[0]) {
      for (char a : str.toCharArray()) {
          c1[i++] = a;
      }
  }
  System.out.println(c1);
  
  } 
} 


