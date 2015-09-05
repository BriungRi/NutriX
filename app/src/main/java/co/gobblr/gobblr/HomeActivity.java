package co.gobblr.gobblr;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class HomeActivity extends ActionBarActivity {

    TextView tvGreeting;
    UserLocalStore uls;
    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        uls = new UserLocalStore(this);
        if (uls.getLoggedInUser() == null)
            startActivity(new Intent(this, LoginRegisterActivity.class)); //Checks to see if user is logged in

        user = uls.getLoggedInUser(); //assigns current logged in user

        tvGreeting = (TextView) findViewById(R.id.tvGreeting);
        tvGreeting.setText(tvGreeting.getText() + " " + user.getName());

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
