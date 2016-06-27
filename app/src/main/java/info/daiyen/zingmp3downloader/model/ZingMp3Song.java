
package info.daiyen.zingmp3downloader.model;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

@Generated("org.jsonschema2pojo")
public class ZingMp3Song implements Serializable{

    @SerializedName("song_id")
    @Expose
    private Integer songId;
    @SerializedName("song_id_encode")
    @Expose
    private String songIdEncode;
    @SerializedName("video_id_encode")
    @Expose
    private String videoIdEncode;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("artist_id")
    @Expose
    private String artistId;
    @SerializedName("artist")
    @Expose
    private String artist;
    @SerializedName("album_id")
    @Expose
    private Integer albumId;
    @SerializedName("album")
    @Expose
    private String album;
    @SerializedName("composer_id")
    @Expose
    private Integer composerId;
    @SerializedName("composer")
    @Expose
    private String composer;
    @SerializedName("genre_id")
    @Expose
    private String genreId;
    @SerializedName("isrc")
    @Expose
    private String isrc;
    @SerializedName("zaloid")
    @Expose
    private Integer zaloid;
    @SerializedName("username")
    @Expose
    private String username;
    @SerializedName("is_hit")
    @Expose
    private Integer isHit;
    @SerializedName("is_official")
    @Expose
    private Integer isOfficial;
    @SerializedName("duration")
    @Expose
    private Integer duration;
    @SerializedName("download_status")
    @Expose
    private Integer downloadStatus;
    @SerializedName("copyright")
    @Expose
    private String copyright;
    @SerializedName("co_id")
    @Expose
    private Integer coId;
    @SerializedName("ad_status")
    @Expose
    private Integer adStatus;
    @SerializedName("license_status")
    @Expose
    private Integer licenseStatus;
    @SerializedName("lyrics_file")
    @Expose
    private String lyricsFile;
    @SerializedName("download_disable")
    @Expose
    private Integer downloadDisable;
    @SerializedName("vn_only")
    @Expose
    private Boolean vnOnly;
    @SerializedName("total_play")
    @Expose
    private Integer totalPlay;
    @SerializedName("link")
    @Expose
    private String link;
    @SerializedName("source")
    @Expose
    private Source source;
    @SerializedName("link_download")
    @Expose
    private LinkDownload linkDownload;
    @SerializedName("thumbnail")
    @Expose
    private String thumbnail;
    @SerializedName("album_cover")
    @Expose
    private String albumCover;
    @SerializedName("likes")
    @Expose
    private Integer likes;
    @SerializedName("like_this")
    @Expose
    private Boolean likeThis;
    @SerializedName("favourites")
    @Expose
    private Integer favourites;
    @SerializedName("favourite_this")
    @Expose
    private Boolean favouriteThis;
    @SerializedName("comments")
    @Expose
    private Integer comments;
    @SerializedName("genre_name")
    @Expose
    private String genreName;
    @SerializedName("video")
    @Expose
    private Video video;
    @SerializedName("response")
    @Expose
    private Response response;

    @SerializedName("chosen")
    @Expose
    private boolean chosen;

    public ZingMp3Song(){
        this.chosen = false;
    }
    /**
     * 
     * @return
     *     The songId
     */
    public Integer getSongId() {
        return songId;
    }

    /**
     * 
     * @param songId
     *     The song_id
     */
    public void setSongId(Integer songId) {
        this.songId = songId;
    }

    /**
     * 
     * @return
     *     The songIdEncode
     */
    public String getSongIdEncode() {
        return songIdEncode;
    }

    /**
     * 
     * @param songIdEncode
     *     The song_id_encode
     */
    public void setSongIdEncode(String songIdEncode) {
        this.songIdEncode = songIdEncode;
    }

    /**
     * 
     * @return
     *     The videoIdEncode
     */
    public String getVideoIdEncode() {
        return videoIdEncode;
    }

    /**
     * 
     * @param videoIdEncode
     *     The video_id_encode
     */
    public void setVideoIdEncode(String videoIdEncode) {
        this.videoIdEncode = videoIdEncode;
    }

    /**
     * 
     * @return
     *     The title
     */
    public String getTitle() {
        return title;
    }

    /**
     * 
     * @param title
     *     The title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 
     * @return
     *     The artistId
     */
    public String getArtistId() {
        return artistId;
    }

    /**
     * 
     * @param artistId
     *     The artist_id
     */
    public void setArtistId(String artistId) {
        this.artistId = artistId;
    }

    /**
     * 
     * @return
     *     The artist
     */
    public String getArtist() {
        return artist;
    }

    /**
     * 
     * @param artist
     *     The artist
     */
    public void setArtist(String artist) {
        this.artist = artist;
    }

    /**
     * 
     * @return
     *     The albumId
     */
    public Integer getAlbumId() {
        return albumId;
    }

    /**
     * 
     * @param albumId
     *     The album_id
     */
    public void setAlbumId(Integer albumId) {
        this.albumId = albumId;
    }

    /**
     * 
     * @return
     *     The album
     */
    public String getAlbum() {
        return album;
    }

    /**
     * 
     * @param album
     *     The album
     */
    public void setAlbum(String album) {
        this.album = album;
    }

    /**
     * 
     * @return
     *     The composerId
     */
    public Integer getComposerId() {
        return composerId;
    }

    /**
     * 
     * @param composerId
     *     The composer_id
     */
    public void setComposerId(Integer composerId) {
        this.composerId = composerId;
    }

    /**
     * 
     * @return
     *     The composer
     */
    public String getComposer() {
        return composer;
    }

    /**
     * 
     * @param composer
     *     The composer
     */
    public void setComposer(String composer) {
        this.composer = composer;
    }

    /**
     * 
     * @return
     *     The genreId
     */
    public String getGenreId() {
        return genreId;
    }

    /**
     * 
     * @param genreId
     *     The genre_id
     */
    public void setGenreId(String genreId) {
        this.genreId = genreId;
    }

    /**
     * 
     * @return
     *     The isrc
     */
    public String getIsrc() {
        return isrc;
    }

    /**
     * 
     * @param isrc
     *     The isrc
     */
    public void setIsrc(String isrc) {
        this.isrc = isrc;
    }

    /**
     * 
     * @return
     *     The zaloid
     */
    public Integer getZaloid() {
        return zaloid;
    }

    /**
     * 
     * @param zaloid
     *     The zaloid
     */
    public void setZaloid(Integer zaloid) {
        this.zaloid = zaloid;
    }

    /**
     * 
     * @return
     *     The username
     */
    public String getUsername() {
        return username;
    }

    /**
     * 
     * @param username
     *     The username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 
     * @return
     *     The isHit
     */
    public Integer getIsHit() {
        return isHit;
    }

    /**
     * 
     * @param isHit
     *     The is_hit
     */
    public void setIsHit(Integer isHit) {
        this.isHit = isHit;
    }

    /**
     * 
     * @return
     *     The isOfficial
     */
    public Integer getIsOfficial() {
        return isOfficial;
    }

    /**
     * 
     * @param isOfficial
     *     The is_official
     */
    public void setIsOfficial(Integer isOfficial) {
        this.isOfficial = isOfficial;
    }

    /**
     * 
     * @return
     *     The duration
     */
    public Integer getDuration() {
        return duration;
    }

    /**
     * 
     * @param duration
     *     The duration
     */
    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    /**
     * 
     * @return
     *     The downloadStatus
     */
    public Integer getDownloadStatus() {
        return downloadStatus;
    }

    /**
     * 
     * @param downloadStatus
     *     The download_status
     */
    public void setDownloadStatus(Integer downloadStatus) {
        this.downloadStatus = downloadStatus;
    }

    /**
     * 
     * @return
     *     The copyright
     */
    public String getCopyright() {
        return copyright;
    }

    /**
     * 
     * @param copyright
     *     The copyright
     */
    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    /**
     * 
     * @return
     *     The coId
     */
    public Integer getCoId() {
        return coId;
    }

    /**
     * 
     * @param coId
     *     The co_id
     */
    public void setCoId(Integer coId) {
        this.coId = coId;
    }

    /**
     * 
     * @return
     *     The adStatus
     */
    public Integer getAdStatus() {
        return adStatus;
    }

    /**
     * 
     * @param adStatus
     *     The ad_status
     */
    public void setAdStatus(Integer adStatus) {
        this.adStatus = adStatus;
    }

    /**
     * 
     * @return
     *     The licenseStatus
     */
    public Integer getLicenseStatus() {
        return licenseStatus;
    }

    /**
     * 
     * @param licenseStatus
     *     The license_status
     */
    public void setLicenseStatus(Integer licenseStatus) {
        this.licenseStatus = licenseStatus;
    }

    /**
     * 
     * @return
     *     The lyricsFile
     */
    public String getLyricsFile() {
        return lyricsFile;
    }

    /**
     * 
     * @param lyricsFile
     *     The lyrics_file
     */
    public void setLyricsFile(String lyricsFile) {
        this.lyricsFile = lyricsFile;
    }

    /**
     * 
     * @return
     *     The downloadDisable
     */
    public Integer getDownloadDisable() {
        return downloadDisable;
    }

    /**
     * 
     * @param downloadDisable
     *     The download_disable
     */
    public void setDownloadDisable(Integer downloadDisable) {
        this.downloadDisable = downloadDisable;
    }

    /**
     * 
     * @return
     *     The vnOnly
     */
    public Boolean getVnOnly() {
        return vnOnly;
    }

    /**
     * 
     * @param vnOnly
     *     The vn_only
     */
    public void setVnOnly(Boolean vnOnly) {
        this.vnOnly = vnOnly;
    }

    /**
     * 
     * @return
     *     The totalPlay
     */
    public Integer getTotalPlay() {
        return totalPlay;
    }

    /**
     * 
     * @param totalPlay
     *     The total_play
     */
    public void setTotalPlay(Integer totalPlay) {
        this.totalPlay = totalPlay;
    }

    /**
     * 
     * @return
     *     The link
     */
    public String getLink() {
        return link;
    }

    /**
     * 
     * @param link
     *     The link
     */
    public void setLink(String link) {
        this.link = link;
    }

    /**
     * 
     * @return
     *     The source
     */
    public Source getSource() {
        return source;
    }

    /**
     * 
     * @param source
     *     The source
     */
    public void setSource(Source source) {
        this.source = source;
    }

    /**
     * 
     * @return
     *     The linkDownload
     */
    public LinkDownload getLinkDownload() {
        return linkDownload;
    }

    /**
     * 
     * @param linkDownload
     *     The link_download
     */
    public void setLinkDownload(LinkDownload linkDownload) {
        this.linkDownload = linkDownload;
    }

    /**
     * 
     * @return
     *     The thumbnail
     */
    public String getThumbnail() {
        return thumbnail;
    }

    /**
     * 
     * @param thumbnail
     *     The thumbnail
     */
    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    /**
     * 
     * @return
     *     The albumCover
     */
    public String getAlbumCover() {
        return albumCover;
    }

    /**
     * 
     * @param albumCover
     *     The album_cover
     */
    public void setAlbumCover(String albumCover) {
        this.albumCover = albumCover;
    }

    /**
     * 
     * @return
     *     The likes
     */
    public Integer getLikes() {
        return likes;
    }

    /**
     * 
     * @param likes
     *     The likes
     */
    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    /**
     * 
     * @return
     *     The likeThis
     */
    public Boolean getLikeThis() {
        return likeThis;
    }

    /**
     * 
     * @param likeThis
     *     The like_this
     */
    public void setLikeThis(Boolean likeThis) {
        this.likeThis = likeThis;
    }

    /**
     * 
     * @return
     *     The favourites
     */
    public Integer getFavourites() {
        return favourites;
    }

    /**
     * 
     * @param favourites
     *     The favourites
     */
    public void setFavourites(Integer favourites) {
        this.favourites = favourites;
    }

    /**
     * 
     * @return
     *     The favouriteThis
     */
    public Boolean getFavouriteThis() {
        return favouriteThis;
    }

    /**
     * 
     * @param favouriteThis
     *     The favourite_this
     */
    public void setFavouriteThis(Boolean favouriteThis) {
        this.favouriteThis = favouriteThis;
    }

    /**
     * 
     * @return
     *     The comments
     */
    public Integer getComments() {
        return comments;
    }

    /**
     * 
     * @param comments
     *     The comments
     */
    public void setComments(Integer comments) {
        this.comments = comments;
    }

    /**
     * 
     * @return
     *     The genreName
     */
    public String getGenreName() {
        return genreName;
    }

    /**
     * 
     * @param genreName
     *     The genre_name
     */
    public void setGenreName(String genreName) {
        this.genreName = genreName;
    }

    /**
     * 
     * @return
     *     The video
     */
    public Video getVideo() {
        return video;
    }

    /**
     * 
     * @param video
     *     The video
     */
    public void setVideo(Video video) {
        this.video = video;
    }

    /**
     * 
     * @return
     *     The response
     */
    public Response getResponse() {
        return response;
    }

    /**
     * 
     * @param response
     *     The response
     */
    public void setResponse(Response response) {
        this.response = response;
    }

    /**
     *
     * @return
     *     The chosen
     */
    public Boolean getChosen() {
        return chosen;
    }

    /**
     *
     * @param chosen
     *     The chosen
     */
    public void setChosen(Boolean chosen) {
        this.chosen = chosen;
    }
}
