package info.daiyen.zingmp3downloader.service;

import java.util.List;

import info.daiyen.zingmp3downloader.model.ZingMp3Song;
import info.daiyen.zingmp3downloader.model.ZingMp3SongList;
import retrofit2.Call;
import retrofit2.Converter;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.Path;

/**
 * Created by corncob on 6/25/16.
 */
public interface ZingMp3Service {

    @GET("api/mobile/song/getsonginfo")
    Call<ZingMp3Song> getSongInfo(@Query("requestdata") String requestdata);

    @GET("api/mobile/playlist/getsonglist")
    Call<ZingMp3SongList> getAlbumInfo(@Query("requestdata") String requestdata);
}
