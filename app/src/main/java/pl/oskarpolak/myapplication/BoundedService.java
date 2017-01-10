package pl.oskarpolak.myapplication;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by OskarPraca on 2017-01-10.
 */

public class BoundedService extends Service {

    Handler handler = new Handler();

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {

        Log.e("debug", "uruchomiłem serwis");
        for (int i = 0; i <= 15; i++) {
            try {
                Thread.sleep(3000);
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getBaseContext(), "To jest wiadomość z serwisu", Toast.LENGTH_SHORT).show();

                    }
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }
        return null;
    }
}

