package info.daiyen.zingmp3downloader.service;

import android.app.DownloadManager;
import android.app.IntentService;
import android.content.Intent;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.util.Log;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

import info.daiyen.zingmp3downloader.R;
import info.daiyen.zingmp3downloader.SongChoosingActivity;
import info.daiyen.zingmp3downloader.model.ZingMp3Song;
import info.daiyen.zingmp3downloader.model.ZingMp3SongList;
import info.daiyen.zingmp3downloader.utilities.ZingMp3LinkUtility;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * <p/>
 * TODO: Customize class - update intent actions, extra parameters and static
 * helper methods.
 */
public class ZingMp3DownloaderService extends IntentService {
    public ZingMp3DownloaderService() {
        super("ZingMp3DownloaderService");
    }

    private static final String LOG_TAG_NAME = "ZingMp3DownloadService";
    private static final String ACTION_DOWNLOAD_SONG = "info.daiyen.ActionDownloadSong";
    private static final String ACTION_GET_SONG_LIST = "info.daiyen.action.ACTION_GET_SONG_LIST";
    private static final String ACTION_DOWNLOAD_SONG_LIST = "info.daiyen.action.ACTION_DOWNLOAD_SONG_LIST";
    private static final String EXTRA_PARAM_LINK = "info.daiyen.ExtraParam_Link";
    private static final String EXTRA_PARAM_SONGLIST = "info.daiyen.EXTRA_PARAM_SONGLIST";

    /**
     * Starts this service to perform action Foo with the given parameters. If
     * the service is already performing a task this action will be queued.
     *
     * @see IntentService
     */
    // TODO: Customize helper method
    public static void startDownloadSong(Context context, String link) {
        Intent intent = new Intent(context, ZingMp3DownloaderService.class);
        intent.setAction(ACTION_DOWNLOAD_SONG);
        intent.putExtra(EXTRA_PARAM_LINK, link);
        context.startService(intent);
    }

    public static void startGetSongList(Context context, String link) {
        Intent intent = new Intent(context, ZingMp3DownloaderService.class);
        intent.setAction(ACTION_GET_SONG_LIST);
        intent.putExtra(EXTRA_PARAM_LINK, link);
        context.startService(intent);
    }

    public static void startDownloadSongList(Context context, ArrayList<ZingMp3Song> songList) {
        Intent intent = new Intent(context, ZingMp3DownloaderService.class);
        intent.setAction(ACTION_DOWNLOAD_SONG_LIST);
        intent.putExtra(EXTRA_PARAM_SONGLIST, songList);
        context.startService(intent);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            final String action = intent.getAction();
            if (ACTION_DOWNLOAD_SONG.equals(action)) {
                final String link = intent.getStringExtra(EXTRA_PARAM_LINK);

                ZingMp3LinkUtility.LINK_TYPE linkType = ZingMp3LinkUtility.getLinkType(link);
                if (linkType == ZingMp3LinkUtility.LINK_TYPE.SONG) {
                    handleActionDownloadSong(link);
                } else if (linkType == ZingMp3LinkUtility.LINK_TYPE.ALBUM) {
                    handleActionDownloadAlbum(link);
                }
            }
            else if (action.equals(ACTION_GET_SONG_LIST)){
                final String link = intent.getStringExtra(EXTRA_PARAM_LINK);

                ZingMp3LinkUtility.LINK_TYPE linkType = ZingMp3LinkUtility.getLinkType(link);
                if (linkType == ZingMp3LinkUtility.LINK_TYPE.ALBUM) {
                    getSongListFromAlbum(link);
                }
            }
            else if (action.equals(ACTION_DOWNLOAD_SONG_LIST)){
                ArrayList<ZingMp3Song> songList =
                        (ArrayList<ZingMp3Song>) intent.getSerializableExtra(EXTRA_PARAM_SONGLIST);

                downloadSongList(songList);
            }
        }
    }

    /**
     * Handle action Foo in the provided background thread with the provided
     * parameters.
     */
    private void handleActionDownloadSong(String link) {
        Log.i(LOG_TAG_NAME, "Start handleActionDownloadSong");
        if (link == null) {
            return;
        }
        final String songID = ZingMp3LinkUtility.getSongID(link);
        Log.i(LOG_TAG_NAME, "Download song ID " + link);
        ZingMp3Song zingMp3Song;
        try {

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(getString(R.string.ZING_MP3_API_ENDPOINT))
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            ZingMp3Service zingmp3 = retrofit.create(ZingMp3Service.class);


            try {
                // Create a call instance
                Call<ZingMp3Song> call = zingmp3.getSongInfo("{ \"id\": \"" + songID + "\"}");
                zingMp3Song = call.execute().body();
                this.addDownloadQueue(zingMp3Song);

            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Handle action Foo in the provided background thread with the provided
     * parameters.
     */
    private void handleActionDownloadAlbum(String link) {
        Log.i(LOG_TAG_NAME, "Start handleActionDownloadAlbum");
        if (link == null) {
            return;
        }
        final String albumID = ZingMp3LinkUtility.getAlbumID(link);
        Log.i(LOG_TAG_NAME, "Download album ID " + link);
        ZingMp3SongList zingMp3SongList;

        try {

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(getString(R.string.ZING_MP3_API_ENDPOINT))
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            ZingMp3Service zingmp3 = retrofit.create(ZingMp3Service.class);


            try {
                // Create a call instance
                Call<ZingMp3SongList> call = zingmp3.getAlbumInfo("{ \"id\": \"" + albumID + "\",\"start\":0,\"length\":200}");
                zingMp3SongList = call.execute().body();
                for (ZingMp3Song zingMp3Song : zingMp3SongList.getDocs()
                        ) {
                    this.addDownloadQueue(zingMp3Song);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void getSongListFromAlbum(String link) {
        Log.i(LOG_TAG_NAME, "Start getSongListFromAlbum");
        if (link == null) {
            return;
        }
        final String albumID = ZingMp3LinkUtility.getAlbumID(link);
        Log.i(LOG_TAG_NAME, "Get album ID " + link);
        ZingMp3SongList zingMp3SongList;

        try {

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(getString(R.string.ZING_MP3_API_ENDPOINT))
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            ZingMp3Service zingmp3 = retrofit.create(ZingMp3Service.class);


            try {
                // Create a call instance
                Call<ZingMp3SongList> call = zingmp3.getAlbumInfo("{ \"id\": \"" + albumID + "\",\"start\":0,\"length\":200}");
                zingMp3SongList = call.execute().body();
                if (!zingMp3SongList.getDocs().isEmpty()){
                    Intent i = new Intent(ZingMp3DownloaderService.this, SongChoosingActivity.class);
                    i.setAction(ACTION_GET_SONG_LIST);
                    i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    i.putExtra("song_list", (ArrayList<ZingMp3Song>) zingMp3SongList.getDocs());
                    startActivity(i);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void downloadSongList(ArrayList<ZingMp3Song> songList){
        for(ZingMp3Song song: songList){
            if (song.getChosen()){
                addDownloadQueue(song);
            }
        }
    }
    private void addDownloadQueue(ZingMp3Song song) {
        try {

            DownloadManager.Request request = new DownloadManager.Request(Uri.parse(song.getSource().get320()));
            request.setDescription("Zing MP3 Downloader");
            request.setTitle(song.getTitle() + ".mp3");
            request.setMimeType("audio/mpeg");
            // in order for this if to run, you must use the android 3.2 to compile your app
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
                request.allowScanningByMediaScanner();
                //request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
                request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE);
            }
            request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, song.getTitle() + ".mp3");


            // get download service and enqueue file
            DownloadManager manager = (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);
            manager.enqueue(request);
        } catch (Exception e) {

        }
    }
}
