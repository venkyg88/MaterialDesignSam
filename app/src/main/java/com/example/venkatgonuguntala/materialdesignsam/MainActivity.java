package com.example.venkatgonuguntala.materialdesignsam;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {


    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_appbar);

        toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        NavigationFragmentDrawer drawerFragment = (NavigationFragmentDrawer) getSupportFragmentManager().findFragmentById(R.id.navigation_fragment_drawer);
        DrawerLayout drawerLayout= (DrawerLayout) findViewById(R.id.drawer_layout);
        drawerFragment.setUp(R.id.navigation_fragment_drawer, drawerLayout, toolbar);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
            Toast.makeText(this, "Hey you hit settings?", Toast.LENGTH_SHORT).show();
            return true;
        }

        if (id == R.id.navigate) {
            Intent intent = new Intent(this, SubActivity.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }
}
