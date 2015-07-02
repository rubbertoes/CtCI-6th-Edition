package Q5_03_Flip_Bit_to_Win;

import java.util.ArrayList;

public class QuestionB {
	public static int SEQUENCE_LENGTH = 32;
	
	/* Return a list of the sizes of the sequences. The sequence starts 
	 * off with the number of 0s (which might be 0) and then alternates
	 * with the counts of each value.*/
	public static ArrayList<Integer> getAlternatingSequences(int n) {
		ArrayList<Integer> sequences = new ArrayList<Integer>();
		
		int searchingFor = 0;
		int counter = 0;
		
		for (int i = 0; i < SEQUENCE_LENGTH; i++) {
			if ((n & 1) != searchingFor) {
				sequences.add(counter);
				searchingFor = n & 1; // Flip 1 to 0 or 0 to 1
				counter = 0;	
			}
			counter++;
			n >>>= 1;
		}
		sequences.add(counter);
		
		return sequences;
	}
	
	public static int findLongestSequence(ArrayList<Integer> seq) {
		int maxSeq = 1;
		
		for (int i = 0; i < seq.size(); i += 2) {
			int zerosSeq = seq.get(i);
			int onesSeqRight = i - 1 >= 0 ? seq.get(i - 1) : 0;
			int onesSeqLeft = i + 1 < seq.size() ? seq.get(i + 1) : 0;
			
			int thisSeq = 0;
			if (zerosSeq == 1) { // Can merge
				thisSeq = onesSeqLeft + 1 + onesSeqRight; 
			} if (zerosSeq > 1) { // Just add a zero to either side
				thisSeq = 1 + Math.max(onesSeqRight, onesSeqLeft);
			} else if (zerosSeq == 0) { // No zero, but take either side
				thisSeq = Math.max(onesSeqRight, onesSeqLeft);
			}
			maxSeq = Math.max(thisSeq, maxSeq);
		}
		
		return maxSeq;
	}
	
	public static int longestSequence(int n) {
		if (n == -1) return SEQUENCE_LENGTH;
		ArrayList<Integer> sequences = getAlternatingSequences(n);
		return findLongestSequence(sequences);
	}	
	
	public static void main(String[] args) {
		int original_number = Integer.MAX_VALUE;
		int new_number = longestSequence(original_number);
			
		System.out.println(Integer.toBinaryString(original_number));
		System.out.println(new_number);				
	}

}