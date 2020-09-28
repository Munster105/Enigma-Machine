package constants;

import javax.swing.text.PlainDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;

public class JTextFieldLimit extends PlainDocument {
    private int limit;

    public JTextFieldLimit(int limit) {
        super();
        this.limit = limit;
    }

    public void insertString(int offset, String  str, AttributeSet attr) throws BadLocationException {
        if (str == null)
            return;

        //Makes it so that only letters are accepted
        if(str.charAt(0) < 'a' || str.charAt(0) > 'z'){
            return;
        }

        //Makes it that only one letter is accepted at a time
        if ((getLength() + str.length()) <= limit) {
            super.insertString(offset, str, attr);
        }
    }
}