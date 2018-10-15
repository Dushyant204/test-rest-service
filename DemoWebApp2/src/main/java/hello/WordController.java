package hello;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/*
*
*This is programm to check 
*if words is Anagram/palindrome or not
*/
@RestController
public class WordController {

	
	 @RequestMapping("/words/{word}")
	    public Words greeting(@PathVariable("word") String inputWord) {
	    	 System.out.println("--------Serivces is called--------");
	    	 if(inputWord.matches("[a-z]+"))
	        return new Words(inputWord,checkPalindrome(inputWord),checkAnagram(inputWord));
	    	 else 
	    		 return new Words("Wrong word,Only small letter word is required",false,false);
		    	
	    }
	 @RequestMapping("/words")
	    public Words greeting() {
	    	 System.out.println("--------Serivces is called--------");
	    	
	    	 return new Words("aakakk",false,false);
		    	
	    }
	    public  boolean checkPalindrome(String input)
		{			
			int lengthOfInput=input.length();
			char[] inputChar=input.toCharArray();
			for(int i=0;i<lengthOfInput/2;i++) {
				if(inputChar[i]!=inputChar[(lengthOfInput-1)-i]) {
					return false;
				}
			}
			return true;
		}
		public  boolean checkAnagram(String input)
		{
			    int [] count = new int[26];
		        for( int i = 0; i < input.length(); i++ )
		        {
		            char ch = input.charAt(i);
		            count[ch-'a']++;// increase the indexe of character.
		            
		        }
		        System.out.println("--------------------");
		        int oddOccur = 0;
		        for( int cnt:count )
		        {
		        	    if( oddOccur > 1) //return false if more than 1 char should have odd frequency
		                return false;
		            if( cnt%2 == 1 )
		                oddOccur++;
		        }
		        return true;
		}
		
		// for any type of words irresptive of any meaning
}