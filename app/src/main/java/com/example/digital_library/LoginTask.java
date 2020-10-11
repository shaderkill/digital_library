package com.example.digital_library;

import android.os.AsyncTask;

public class LoginTask extends AsyncTask<String, Integer, Boolean> {
    protected Boolean doInBackground(String... userInfo) {
        int count = userInfo.length;
        boolean isValid = false;
        for (int i = 0; i < count; i++) {
            String info = userInfo[i];
            isValid = info.length() > 0;
            // Escape early if cancel() is called
            if (isCancelled()) break;
        }
        return isValid;
    }

    protected void onPostExecute(Boolean result) {
        super.onPostExecute(result);
    }

}
