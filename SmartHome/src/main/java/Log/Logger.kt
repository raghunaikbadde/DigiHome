package Log

import android.util.Log

import Constants.Constants

class Logger : Constants {
    companion object {

        fun LogMessage(message: String) {
            Log.d(Constants.LOG_TAG, message)
        }
    }
}
