package info.daiyen.zingmp3downloader;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.CheckBox;

import java.util.ArrayList;

import info.daiyen.zingmp3downloader.model.ZingMp3Song;
import info.daiyen.zingmp3downloader.service.ZingMp3DownloaderService;
import info.daiyen.zingmp3downloader.utilities.ZingMp3LinkUtility;

public class SongChoosingActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter<SongChoosingAdapter.SongViewHolder> mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private ArrayList<ZingMp3Song> mDataset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song_choosing);
        mRecyclerView = (RecyclerView) findViewById(R.id.song_choosing_recycle_view);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Select Songs To Download");
        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        // Get intent, action and MIME type
        Intent intent = getIntent();
        String action = intent.getAction();
        String type = intent.getType();

        if (action.equals("info.daiyen.action.ACTION_GET_SONG_LIST")) {
            handleReceiveSongList(intent);
        }

        View all_button_layout = findViewById(R.id.all_button_layout);
        assert all_button_layout != null;
        all_button_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CheckBox checkBox = (CheckBox) v.findViewById(R.id.checkbox_all);
                boolean isChecked = checkBox.isChecked();
                for(ZingMp3Song song: mDataset){
                    song.setChosen(!isChecked);
                }
                checkBox.setChecked(!isChecked);
                mAdapter.notifyDataSetChanged();
            }
        });

        View downloadButton = findViewById(R.id.download_button);
        assert downloadButton != null;
        downloadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendDownloadRequest();
            }
        });
    }

    private void handleReceiveSongList(Intent intent) {

        mDataset = (ArrayList<ZingMp3Song>) intent.getSerializableExtra("song_list");
        mAdapter = new SongChoosingAdapter(
                this.mDataset,
                SongChoosingActivity.this,
                new SongChoosingAdapter.OnItemClick() {
            @Override
            public void onClick(int position) {
                mDataset.get(position).setChosen(!mDataset.get(position).getChosen());
                mAdapter.notifyDataSetChanged();
            }
        });

        mRecyclerView.setAdapter(mAdapter);
    }

    private void sendDownloadRequest() {
        ZingMp3DownloaderService.startDownloadSongList(SongChoosingActivity.this, mDataset);
        super.finish();
    }

}
