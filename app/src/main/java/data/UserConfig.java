package data;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by wumengmeng on 2016/8/9/0009.
 */
public class UserConfig {
    private Context context;
    private static UserConfig mInstance = null;
    private final String SP_NAME = "http_config";
    private final String SP_KEY_TOKEN = "user.token";
    private final String SP_KEY_USEID = "user.userid";
    private final String SP_KEY_TEL = "user.tel";
    private final String SP_KEY_TYPE = "user.type";
    private final String SP_KEY_PWD = "user.pwd";
    private final String SP_KEY_SESSION = "user.session";
    private SharedPreferences sp;
    private SharedPreferences.Editor mEditor;

    private UserConfig(Context context) {
        this.context = context;
        sp = context.getSharedPreferences(SP_NAME, Context.MODE_PRIVATE);
        mEditor = sp.edit();
    }

    public static UserConfig newInstance(Context context) {
        if (mInstance == null) {
            mInstance = new UserConfig(context);
        }
        return mInstance;
    }

    public void setAccessToken(String token) {
        mEditor.putString(SP_KEY_TOKEN, token).commit();
    }

    public String getAccessToken() {
        return sp.getString(SP_KEY_TOKEN, "");
    }

    public String getUserid() {
        return sp.getString(SP_KEY_USEID, "");
    }

    public void setUserid(String userId) {
        mEditor.putString(SP_KEY_USEID, userId).commit();
    }

    public String getUserTel() {
        return sp.getString(SP_KEY_TEL, "");
    }

    public void setUserTel(String tel) {
        mEditor.putString(SP_KEY_TEL, tel).commit();
    }

    public int getUserType() {
        return sp.getInt(SP_KEY_TYPE, 0);
    }

    public void setUserType(int type) {
        mEditor.putInt(SP_KEY_TYPE, type).commit();
    }

    public String getUserPwd() {
        return sp.getString(SP_KEY_PWD, "");
    }

    public void setUserPwd(String pwd) {
        mEditor.putString(SP_KEY_PWD, pwd).commit();
    }

    public String getUserSession() {
        return sp.getString(SP_KEY_SESSION, "");
    }

    public void setUserSession(String session) {
        mEditor.putString(SP_KEY_SESSION, session).commit();
    }

}
