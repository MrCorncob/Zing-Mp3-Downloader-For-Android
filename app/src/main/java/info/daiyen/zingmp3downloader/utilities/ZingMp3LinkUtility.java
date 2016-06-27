package info.daiyen.zingmp3downloader.utilities;

import java.lang.reflect.Type;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by corncob on 6/25/16.
 */
public class ZingMp3LinkUtility {
    public enum LINK_TYPE {
        UNKNOWN(0),
        SONG(1),
        ALBUM(2),
        CHART(3),
        PLAYLIST(4);

        private int value;
        private LINK_TYPE(int value) {
            this.value = value;
        }
    }

    public static String getSongID(String rawLink){
        String songID;
        Pattern p = Pattern.compile("http://mp3\\.zing\\.vn/bai-hat/.*/(\\w+)\\.html");
        Matcher m = p.matcher(rawLink);

        if (m.find()) {
            songID = m.group(1);
        }
        else{
            songID = null;
        }

        return songID;
    }

    public static String getAlbumID(String rawLink){
        String albumID;
        Pattern p = Pattern.compile("http://mp3\\.zing\\.vn/album/.*/(\\w+)\\.html");
        Matcher m = p.matcher(rawLink);

        if (m.find()) {
            albumID = m.group(1);
        }
        else{
            albumID = null;
        }

        return albumID;
    }

    public static LINK_TYPE getLinkType(String rawLink){
        LINK_TYPE type = LINK_TYPE.UNKNOWN;

        Pattern pSongPattern = Pattern.compile("http://mp3\\.zing\\.vn/bai-hat/.*/(\\w+)\\.html");
        Pattern pAlbumPattern = Pattern.compile("http://mp3\\.zing\\.vn/album/.*/(\\w+)\\.html");

        if (pSongPattern.matcher(rawLink).find()){
            type = LINK_TYPE.SONG;
        }
        else if(pAlbumPattern.matcher(rawLink).find()){
            type = LINK_TYPE.ALBUM;
        }

        return type;
    }
}
