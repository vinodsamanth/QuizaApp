package quizaApp.loggingSystem;

import com.sun.javafx.binding.StringFormatter;

import java.io.*;
import java.text.MessageFormat;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 * Created by nayan on 2/13/16.
 */
public class Log {

    private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    private static Log log;
    private Logger logger;

    private Log(){
        setupLogger();
    }

    public static Log getInstance(){
        if(log == null)
            log = new Log();
        return log;
    }

    public void record(String msg){

       // System.out.println(msg);
        logger.info(msg);


    }

    public void setupLogger(){

        logger = Logger.getLogger("QuizaAppLog");
        FileHandler fh;

        try {
            fh = new FileHandler("QuizaApp_log.log");
            logger.addHandler(fh);
            SimpleFormatter sf = new SimpleFormatter();
            fh.setFormatter(sf);


        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
