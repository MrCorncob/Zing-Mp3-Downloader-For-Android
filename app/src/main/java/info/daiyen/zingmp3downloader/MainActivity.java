package info.daiyen.zingmp3downloader;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;

import info.daiyen.zingmp3downloader.model.ZingMp3Song;
import info.daiyen.zingmp3downloader.service.ZingMp3DownloaderService;
import info.daiyen.zingmp3downloader.service.ZingMp3Service;
import info.daiyen.zingmp3downloader.utilities.ZingMp3LinkUtility;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Get intent, action and MIME type
        Intent intent = getIntent();
        String action = intent.getAction();
        String type = intent.getType();

        if (Intent.ACTION_SEND.equals(action) && type != null) {
            if ("text/plain".equals(type)) {
                handleSendText(intent); // Handle text being sent
            }
        }

        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        assert toolbar != null;
        getSupportActionBar().setTitle("Zing MP3 Downloader");
        WebView webView = (WebView) findViewById(R.id.webView);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("https://daiyen.info/?ref=zing-mp3-downloader");

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

    private void handleSendText(Intent intent) {
        String link = intent.getStringExtra(Intent.EXTRA_TEXT);

        if (link == null) {
            return;
        }

        ZingMp3LinkUtility.LINK_TYPE linkType = ZingMp3LinkUtility.getLinkType(link);
        if (linkType == ZingMp3LinkUtility.LINK_TYPE.SONG) {
            ZingMp3DownloaderService.startDownloadSong(MainActivity.this, link);
            super.finish();
        } else if (linkType == ZingMp3LinkUtility.LINK_TYPE.ALBUM) {
            ZingMp3DownloaderService.startGetSongList(MainActivity.this, link);
            super.finish();
        }

    }
}
