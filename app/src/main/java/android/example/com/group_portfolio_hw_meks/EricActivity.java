package android.example.com.group_portfolio_hw_meks;

import android.app.ActionBar;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class EricActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eric);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.eric, menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemID = item.getItemId();

        switch (itemID){
            case R.id.git1:
                String ninjaTales = "https://github.com/ericdiazjr21/CYOA_PURSUIT_HW_DIAZ_ERIC.git";
                Uri ninjaTalesGit = Uri.parse(ninjaTales);
                Intent goToNinjaTales = new Intent(Intent.ACTION_VIEW,ninjaTalesGit);
                startActivity(goToNinjaTales);
                break;
            case R.id.git2:
                String tellerOperatingSystem = "https://github.com/ericdiazjr21/Teller-Operating-System.git";
                Uri tellerOperatingSystemGit = Uri.parse(tellerOperatingSystem);
                Intent goToTOSGit = new Intent(Intent.ACTION_VIEW,tellerOperatingSystemGit);
                startActivity(goToTOSGit);
                break;
            case R.id.git3:
                String ticTacToe = "https://github.com/ericdiazjr21/Tictacktoe-App.git";
                Uri ticTacTowGit = Uri.parse(ticTacToe);
                Intent goToTicTacToe = new Intent(Intent.ACTION_VIEW, ticTacTowGit);
                startActivity(goToTicTacToe);
                break;
            case android.R.id.home:
                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
        return true;
    }

}
