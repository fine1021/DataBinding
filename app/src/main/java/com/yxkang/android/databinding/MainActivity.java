package com.yxkang.android.databinding;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.yxkang.android.databinding.databinding.ActivityMainBinding;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private ActivityMainBinding mainBinding;
    private int index;
    private String key;
    private User mUser;
    private Map<String, String> mMap = new HashMap<>();
    private MessageHandler mHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /**
         * 如果是<tt>include</tt>布局，只需要获取根布局的<tt>ViewDataBinding</tt>就可以了；单层布局就直接获取就好了
         */
        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        //setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        assert fab != null;
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        mHandler = new MessageHandler(getMainLooper());

        setBindingData();
    }

    /**
     * 如果是<tt>include</tt>布局有id，可以通过<tt>mainBinding.id</tt>方式获取到<tt>include</tt>布局的<tt>ViewDataBinding</tt>,
     * 不过目前这种方式设置绑定数据无效，直接设置<tt>mainBinding</tt>的值然后传递到<tt>include</tt>布局中
     */
    private void setBindingData() {
        // initialize value
        mUser = new User("first", "last");
        mainBinding.setUser(mUser);
        index = 1;
        key = getString(R.string.app_name);
        mMap.put(key, "Test for map values");
        mMap.put("value", "This is a value");

        // set value
        mainBinding.setIndex(index);
        mainBinding.setKey(key);
        mainBinding.setMap(mMap);
        mUser.setAge(20);
        mUser.setDescribe("This is a describe");

        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Log.i(TAG, "run: Time Up");
                index = 2;
                key = "Nice day";
                mMap.put(key, "Life is just a series of trying to make up your mind");
                mMap.put("value", "A day is a miniature of eternity");
                mainBinding.setIndex(index);
                mainBinding.setKey(key);
                mainBinding.setMap(mMap);
                mUser.setDescribe("You may be crazy");
            }
        }, 3000);
    }

    @Override
    protected void onDestroy() {
        mHandler.removeCallbacksAndMessages(null);
        super.onDestroy();
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
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private class MessageHandler extends Handler {

        public MessageHandler(Looper looper) {
            super(looper);
        }

        @Override
        public void handleMessage(Message msg) {

        }
    }
}
