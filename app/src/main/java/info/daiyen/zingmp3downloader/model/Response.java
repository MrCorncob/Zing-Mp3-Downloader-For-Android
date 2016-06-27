
package info.daiyen.zingmp3downloader.model;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

@Generated("org.jsonschema2pojo")
public class Response  implements Serializable {

    @SerializedName("msgCode")
    @Expose
    private Integer msgCode;
    @SerializedName("msg")
    @Expose
    private String msg;

    /**
     * 
     * @return
     *     The msgCode
     */
    public Integer getMsgCode() {
        return msgCode;
    }

    /**
     * 
     * @param msgCode
     *     The msgCode
     */
    public void setMsgCode(Integer msgCode) {
        this.msgCode = msgCode;
    }

    /**
     * 
     * @return
     *     The msg
     */
    public String getMsg() {
        return msg;
    }

    /**
     * 
     * @param msg
     *     The msg
     */
    public void setMsg(String msg) {
        this.msg = msg;
    }

}
