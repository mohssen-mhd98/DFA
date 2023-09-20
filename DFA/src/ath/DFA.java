package ath;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
public class DFA {
	private final String[] states; //set of sates Q
    private final char[] inputAlphabet; //Σ
    private final String[] ultimateStates; //final states F

    private final HashMap<String, Transition> transitions = new HashMap<>();
    List<Character> listC = new ArrayList<Character>();
    private String startState;
    private String currentState;


    public DFA(String[] states, char[] inputAlphabet,
        String[] acceptingStates, Transition[] transitions, String startState) {

        this.states = states;
        this.inputAlphabet = inputAlphabet;
        this.ultimateStates = acceptingStates;

        this.startState = startState;
        this.currentState = startState;
       
        for (Transition t : transitions) {
            List<String> statesAsList = Arrays.asList(this.states);
            if (!statesAsList.contains(t.newState)
                || !statesAsList.contains(t.startState)) {
                throw new InvalidParameterException
                    ("Transition refers to state which does not exist");
            }
            //System.out.print(Arrays.asList(inputAlphabet));
            
            for (char c : inputAlphabet) {
                listC.add(c);
            }
            if (!listC.contains(t.input)) {
                throw new InvalidParameterException
                    ("Transition refers to input which does not exist");
            }

            String key = getKeyForTransition(t.input, t.startState);

            this.transitions.put(key, t);   
        }     
    }

    public DFA reset() {
        currentState = startState;
        return this;
    }


    public DFA input(char input) {
        // Check that this input is contained within the input alphabet
        if (!listC.contains(input)) {
            throw new InvalidParameterException
                ("'" + input + "' is not a valid input");
        }

        String key = getKeyForTransition(input, currentState);

        Transition transition = transitions.get(key);
        if (transition == null) {
            throw new InvalidParameterException
                ("No transition found for: " + input);
        }

        currentState = transition.newState;

        return this;
    }


    public String getState() {
        return currentState;
    }

    public boolean isAccepting(String st) {
		try {
			 for(int i=0;i<st.length();i++)
				 input(st.charAt(i));
	        return Arrays.asList(ultimateStates).contains(currentState);
	        
		} catch (InvalidParameterException e) {
			System.out.println(getState());
			System.out.println(e.getMessage());
			return false;
			
		}
    }

   
    private String getKeyForTransition(char input, String state) {
        return input + "," + state;
    }//returns a key for special transition
}

