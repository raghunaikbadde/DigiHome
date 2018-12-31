package Log;

import android.util.Log;

import Constants.Constants;

public class Logger implements Constants{

    public static void LogMessage(String message){
        Log.d(LOG_TAG,message);
    }
}
