
package info.daiyen.zingmp3downloader.model;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

@Generated("org.jsonschema2pojo")
public class LinkDownload  implements Serializable {

    @SerializedName("128")
    @Expose
    private String _128;
    @SerializedName("lossless")
    @Expose
    private String lossless;
    @SerializedName("320")
    @Expose
    private String _320;

    /**
     * 
     * @return
     *     The _128
     */
    public String get128() {
        return _128;
    }

    /**
     * 
     * @param _128
     *     The 128
     */
    public void set128(String _128) {
        this._128 = _128;
    }

    /**
     * 
     * @return
     *     The lossless
     */
    public String getLossless() {
        return lossless;
    }

    /**
     * 
     * @param lossless
     *     The lossless
     */
    public void setLossless(String lossless) {
        this.lossless = lossless;
    }

    /**
     * 
     * @return
     *     The _320
     */
    public String get320() {
        return _320;
    }

    /**
     * 
     * @param _320
     *     The 320
     */
    public void set320(String _320) {
        this._320 = _320;
    }

}
