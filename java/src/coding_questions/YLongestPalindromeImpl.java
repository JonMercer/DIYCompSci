package coding_questions;

/**
 * Created by Odin on 2017-03-24.
 */
public class YLongestPalindromeImpl implements YLongestPalindrome {

    //WARNING: Incomplete
    @Override
    public String findLongestPalindrome(String str) {
        str = str.toLowerCase();

        String toReturn = "";

        for(int i = 0; i < str.length(); i++) {
            //odd
            int limit = Math.min( str.length() - i, i );
            for(int j = 0; j <= limit; j++) {
                if (str.charAt( i - j ) == str.charAt( i + j )) {
                    if (str.substring( i - j, i + j + 1 ).length() > toReturn.length()) {
                        toReturn = str.substring( i - j, i + j + 1);
                    } else {
                        break;
                    }
                }
            }

            //even
            for (int j = 0; j < limit - 1; j++) {
                if (str.charAt( i + j + 1 ) == str.charAt( i - j )) {
                    if (str.substring( i - j, i + j + 1 ).length() > toReturn.length()) {
                        toReturn = str.substring( i - j, i + 1 + j );
                    } else {
                        break;
                    }
                }
            }
        }

        return toReturn;
    }
}
