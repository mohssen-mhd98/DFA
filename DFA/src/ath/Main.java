package ath;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
public class Main {
	
	static BufferedReader br;
	public static void main(String[] args) {
		
		String st;
		int i = 0;
		/*String[] states;
		char[] alphabet;
		String[] Fstates;
		String startState;
	    String TstartState;
		   char input;
		String newState;*/
		Transition[] t = new Transition[6];
		Scanner inp = new Scanner(System.in);
		//System.out.println("input data:");

		/*while(true)
		{
			int i=0;
			states[i] = 
		}*/
		
		File file = new File("\\D:\\documents\\java.exercises\\Testm\\src\\ath\\DFA_Input_1.txt"); 
		try {
			br = new BufferedReader(new FileReader(file));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		String[][] l = new String[10][];
		
		for(i=0;i<10;i++)
			try {
				l[i] = br.readLine().split(" ");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		String l1[] = new String[3];
		String l3[] = new String[3];
		for(i=0;i<3;i++) {
			
			l1[i] = l[1][i];
			System.out.println(l1[i]);
		}
		System.out.println();
		l3[0] = l[3][0]; 
		
		int j = 4;
		for(i=0;i<6;i++) {
			
			t[i] = new Transition(l[j][0], l[j][1].charAt(0), l[j][2]);
			j++;
		}
			
			/*for(i=0;i<6;i++)
				System.out.println(t[i].startState);*/
			i=0;
		char[] c = new char [l[0].length];
		for (String str : l[0]) {
		    for (char a : str.toCharArray()) {
		        c[i++] = a;
		    }
		}
		
		System.out.println(l1[0]);
		System.out.println(c);
		System.out.println(l3[0]);
		System.out.println(l[3][0]);
		
		DFA turnstileDfa = new DFA(l1, c, l3, t, l[2][0]);
		/*DFA turnstileDfa =
			    new DFA(
			        new String[] { "q0", "q1","q2" },
			        new char[] { 'a', 'b' },
			        new String[] { "q1" },
			        new Transition[] {
				        new Transition("q0", 'a', "q1"),
				        new Transition("q0", 'b', "q1"),
			        	new Transition("q1", 'a', "q2"),
			            new Transition("q1", 'b', "q2"),
			            new Transition("q2", 'a', "q2"),
			            new Transition("q2", 'b', "q2"),
			        },
			        "q0"
			    );*/

			System.out.println("Enter your desired string!!");
			st = inp.next();			

			if(turnstileDfa.isAccepting(st))
				System.out.println("Yes");
			else 
				System.out.println("No");
			
			inp.close();
	}

}

