package android.example.com.group_portfolio_hw_meks;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.app.ActionBar;

public class SamerActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_samer);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.samer, menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemID = item.getItemId();

        switch (itemID) {
            case R.id.git1:
                String textFilesProject = "https://github.com/plasticspork9/The_Text_Files_Project.git";
                Uri textFilesGit = Uri.parse(textFilesProject);
                Intent goToTextFiles = new Intent(Intent.ACTION_VIEW, textFilesGit);
                startActivity(goToTextFiles);
                break;
            case R.id.git2:
                String storybook = "https://github.com/plasticspork9/storybook.git";
                Uri storybookGit = Uri.parse(storybook);
                Intent goToStorybookGit = new Intent(Intent.ACTION_VIEW, storybookGit);
                startActivity(goToStorybookGit);
                break;
            case R.id.git3:
                String unitOneAssessment = "https://github.com/plasticspork9/Unit_01_Assessment.git";
                Uri unitOneAssessmentGit = Uri.parse(unitOneAssessment);
                Intent goToUnit = new Intent(Intent.ACTION_VIEW, unitOneAssessmentGit);
                startActivity(goToUnit);
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

