package android.example.com.group_portfolio_hw_meks;


import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class KrishanActivity extends AppCompatActivity {
    private Button shareButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_krishan);
        shareButton = findViewById(R.id.share_button);
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
            case R.id.krishan_menu_project2:
                String urlTwo = "https://github.com/KrishanRoy/CYOA_Pursuit_HW_ROY_KRISHAN";
                Uri webpageTwo = Uri.parse(urlTwo);
                Intent krishanProjectTwoIntent = new Intent(Intent.ACTION_VIEW, webpageTwo);
                if (krishanProjectTwoIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(krishanProjectTwoIntent);
                } else {
                    Log.d("Kris Proj2 Implicit", "Can't handle this message");
                }
            case R.id.krishan_menu_project3:
                String urlThree = "https://github.com/KrishanRoy/Java_Bank_Pursuit_HW_ROY_KRISHAN";
                Uri webpageThree = Uri.parse(urlThree);
                Intent krishanProjectThreeIntent = new Intent(Intent.ACTION_VIEW, webpageThree);
                if (krishanProjectThreeIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(krishanProjectThreeIntent);
                } else {
                    Log.d("Kris Proj3 Implicit", "Can't handle this message");
                }
        }
        return super.onOptionsItemSelected(item);
    }
}
