package kku.tangprasert.komkeao.mhealthdemo.dao;

import com.google.gson.annotations.SerializedName;

/**
 * Created by MainUser on 8/1/2560.
 */

public class LoginDao {
    @SerializedName("userId") int userId;
    @SerializedName("userName") String userName;
    @SerializedName("userProfilePicture") String userProfilePicture;

    public int getUserId() {
        return userId;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserProfilePicture() {
        return userProfilePicture;
    }

    public void setUserProfilePicture(String userProfilePicture) {
        this.userProfilePicture = userProfilePicture;
    }
}
