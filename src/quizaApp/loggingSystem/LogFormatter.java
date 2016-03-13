package quizaApp.loggingSystem;

import java.text.MessageFormat;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;

/**
 * Created by nayan on 2/24/16.
 */

public class LogFormatter extends Formatter {

    @Override
    public String format(final LogRecord record) {

        StringBuffer sb = new StringBuffer();
        sb.append(record.getMessage());
        sb.append("n");


        return sb.toString();
    }
}