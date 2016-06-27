package info.daiyen.zingmp3downloader.model;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
public class ZingMp3SongList {

    @SerializedName("numFound")
    @Expose
    private Integer numFound;
    @SerializedName("docs")
    @Expose
    private List<ZingMp3Song> docs = new ArrayList<ZingMp3Song>();
    @SerializedName("response")
    @Expose
    private Response response;

    /**
     *
     * @return
     * The numFound
     */
    public Integer getNumFound() {
        return numFound;
    }

    /**
     *
     * @param numFound
     * The numFound
     */
    public void setNumFound(Integer numFound) {
        this.numFound = numFound;
    }

    /**
     *
     * @return
     * The docs
     */
    public List<ZingMp3Song> getDocs() {
        return docs;
    }

    /**
     *
     * @param docs
     * The docs
     */
    public void setDocs(List<ZingMp3Song> docs) {
        this.docs = docs;
    }

    /**
     *
     * @return
     * The response
     */
    public Response getResponse() {
        return response;
    }

    /**
     *
     * @param response
     * The response
     */
    public void setResponse(Response response) {
        this.response = response;
    }

}