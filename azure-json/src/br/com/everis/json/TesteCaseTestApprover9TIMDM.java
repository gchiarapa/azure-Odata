
package br.com.everis.json;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TesteCaseTestApprover9TIMDM {

    @SerializedName("UserName")
    @Expose
    private String userName;
    @SerializedName("UserEmail")
    @Expose
    private String userEmail;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

}
