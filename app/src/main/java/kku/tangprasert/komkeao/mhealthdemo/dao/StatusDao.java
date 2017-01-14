package kku.tangprasert.komkeao.mhealthdemo.dao;

import com.google.gson.annotations.SerializedName;

/**
 * Created by MainUser on 8/1/2560.
 */

public class StatusDao {
    @SerializedName("status") int status;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
