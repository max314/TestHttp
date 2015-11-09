package ru.max314.testhttp;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;

import org.restlet.Server;
import org.restlet.data.Protocol;
import org.restlet.engine.Engine;
import org.restlet.ext.nio.HttpServerHelper;

import org.restlet.engine.connector.HttpProtocolHelper;

public class MainActivity extends ActionBarActivity {

    WebView vewbView;
    Engine e;
    Server server;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        vewbView  = (WebView) findViewById(R.id.webView);
        try {
            //Engine.getInstance().getRegisteredProtocols().clear();

            e = Engine.getInstance();
            //e.getRegisteredProtocols().add(new HttpProtocolHelper());
            Engine.getInstance().getRegisteredServers().clear();
            Engine.getInstance().getRegisteredServers().add(new HttpServerHelper(null));

            server = new Server(Protocol.HTTP, 8090, Part03.class);
            server.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
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

    public void onClick(View view) {
        vewbView.loadUrl("http://localhost:8090");
    }

    public void onClick2(View view) {
        vewbView.loadUrl("http://localhost:8090/test/tutorial");
    }
}
