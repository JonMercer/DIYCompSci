package coding_questions;

/**
 * Created by Odin on 2016-10-26.
 */
//Given a string of certain format, find the thief
public interface PTrading {
    /**
     * 0;55
     * 0;B;20000;Jim
     * 0;S;300;Sam
     * 3;B;2000;Jane
     * 4;300
     * 4;S;90000;Jim
     * ...
     * @param str
     * @return
     */
    String detect(String str);
}
