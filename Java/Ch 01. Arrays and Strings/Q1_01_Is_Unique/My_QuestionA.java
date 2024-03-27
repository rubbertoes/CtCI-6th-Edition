package Q1_01_Is_Unique;

public class My_QuestionA {
   	public static boolean isUniqueChars(String str) {
        return false;
		//comments for those green boxes
	}
	
	public static void main(String[] args) {
		String[] words = {"abcde", "hello", "apple", "kite", "padle"};
		for (String word : words) {
			System.out.println(word + ": " + isUniqueChars(word));
		}
	}
 
}
