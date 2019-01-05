package android.example.com.group_portfolio_hw_meks;


import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class KrishanActivity extends AppCompatActivity {
    private Button shareButton;
    private Button button_notify;
    private static final String PRIMARY_CHANNEL_ID = "primary_notification_channel";
    private NotificationManager mNotifyManager;
    private static final int NOTIFICATION_ID = 0;
    private static final String ACTION_UPDATE_NOTIFICATION =
            "com.example.android.notifyme.ACTION_UPDATE_NOTIFICATION";
    private NotificationReceiver mReceiver = new NotificationReceiver();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_krishan);
        shareButton = findViewById(R.id.share_button);
        button_notify = findViewById(R.id.notify);
        registerReceiver(mReceiver, new IntentFilter(ACTION_UPDATE_NOTIFICATION));
        button_notify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendNotification();
            }
        });
        shareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mailto = "mailto:ericdiaz@pursuit.org?cc=mlosa001@gmail.com&bcc=samermehany@pursuit.org&subject=MEKS%20direct%20messaging%20system&body=Are%20We%20doing%20a%20presentation%20today?";
                Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
                emailIntent.setData(Uri.parse(mailto));
                startActivity(emailIntent);

            }
        });
    }
    public void sendNotification() {
        NotificationCompat.Builder notifyBuilder = getNotificationBuilder();
        mNotifyManager.notify(NOTIFICATION_ID, notifyBuilder.build());
        //setNotificationButtonState(false, true, true);
        Intent updateIntent = new Intent(ACTION_UPDATE_NOTIFICATION);
        PendingIntent updatePendingIntent = PendingIntent.getBroadcast
                (this, NOTIFICATION_ID, updateIntent, PendingIntent.FLAG_ONE_SHOT);

        notifyBuilder.addAction(R.drawable.ic_update, "Update Notification", updatePendingIntent);

    }
    public void createNotificationChannel() {
        mNotifyManager = (NotificationManager)
                getSystemService(NOTIFICATION_SERVICE);
        if (android.os.Build.VERSION.SDK_INT >=
                android.os.Build.VERSION_CODES.O) { //this condition checks for higher level of api
            // Create a NotificationChannel
            NotificationChannel notificationChannel = new NotificationChannel
                    (PRIMARY_CHANNEL_ID, "Mascot Notification",
                            NotificationManager.IMPORTANCE_HIGH);
            notificationChannel.enableLights(true);
            notificationChannel.setLightColor(Color.RED);
            notificationChannel.enableVibration(true);
            notificationChannel.setDescription("Notification from Mascot");
            mNotifyManager.createNotificationChannel(notificationChannel);

        }
    }
    private NotificationCompat.Builder getNotificationBuilder() {
        Intent notificationIntent = new Intent(this, MainActivity.class);

        PendingIntent notificationPendingIntent = PendingIntent.getActivity(this,
                NOTIFICATION_ID, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        NotificationCompat.Builder notifyBuilder = new NotificationCompat.Builder(this, PRIMARY_CHANNEL_ID)
                .setContentTitle("You've been notified!")
                .setContentText("This is your notification text.")
                .setSmallIcon(R.drawable.ic_android)
                .setContentIntent(notificationPendingIntent)
                .setAutoCancel(true)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setDefaults(NotificationCompat.DEFAULT_ALL);
        return notifyBuilder;

    }
    public class NotificationReceiver extends BroadcastReceiver {

        public NotificationReceiver() {
        }

        @Override
        public void onReceive(Context context, Intent intent) {
            // Update the notification
            //updateNotification();
        }
    }
//    public void updateNotification() {
////        Bitmap androidImage = BitmapFactory
////                .decodeResource(getResources(), R.drawable.mascot_1);
////        NotificationCompat.Builder notifyBuilder = getNotificationBuilder();
////
////        notifyBuilder.setStyle(new NotificationCompat.BigPictureStyle()
////                .bigPicture(androidImage)
////                .setBigContentTitle("Notification Updated!"));
////
////        mNotifyManager.notify(NOTIFICATION_ID, notifyBuilder.build());
////
////        //setNotificationButtonState(false, false, true);
////
////    }

    @Override
    protected void onDestroy() {
        unregisterReceiver(mReceiver);
        super.onDestroy();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.krishan, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.krishan_menu_project1:
                String urlOne = "https://github.com/KrishanRoy/A-Mad-Libs-App_Krishan_Roy";
                Uri webpageOne = Uri.parse(urlOne);
                Intent krishanProjectOneIntent = new Intent(Intent.ACTION_VIEW, webpageOne);
                if (krishanProjectOneIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(krishanProjectOneIntent);
                } else {
                    Log.d("Kris Proj1 Implicit", "Can't handle this message");
                }
                break;
            case R.id.krishan_menu_project2:
                String urlTwo = "https://github.com/KrishanRoy/CYOA_Pursuit_HW_ROY_KRISHAN";
                Uri webpageTwo = Uri.parse(urlTwo);
                Intent krishanProjectTwoIntent = new Intent(Intent.ACTION_VIEW, webpageTwo);
                if (krishanProjectTwoIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(krishanProjectTwoIntent);
                } else {
                    Log.d("Kris Proj2 Implicit", "Can't handle this message");
                }
                break;
            case R.id.krishan_menu_project3:
                String urlThree = "https://github.com/KrishanRoy/Java_Bank_Pursuit_HW_ROY_KRISHAN";
                Uri webpageThree = Uri.parse(urlThree);
                Intent krishanProjectThreeIntent = new Intent(Intent.ACTION_VIEW, webpageThree);
                if (krishanProjectThreeIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(krishanProjectThreeIntent);
                } else {
                    Log.d("Kris Proj3 Implicit", "Can't handle this message");
                }
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
