package co.gobblr.gobblr;

import android.content.Context;
import android.content.SharedPreferences;


/**
 * Created by Brian on 9/4/2015.
 */
public class UserLocalStore {
    public static final String SP_NAME = "userDetails";

    SharedPreferences userLocalDatabase;

    public UserLocalStore(Context context) {
        userLocalDatabase = context.getSharedPreferences(SP_NAME, 0);
    }

    public void storeUserData(User user) {
        SharedPreferences.Editor userLocalDatabaseEditor = userLocalDatabase.edit();
        userLocalDatabaseEditor.putString("name", user.getName());
        userLocalDatabaseEditor.putString("username", user.getUsername());
        userLocalDatabaseEditor.putString("password", user.getPassword());
        userLocalDatabaseEditor.putString("sex", user.getSex());
        userLocalDatabaseEditor.putInt("age", user.getAge());
        userLocalDatabaseEditor.putInt("height", user.getHeight());
        userLocalDatabaseEditor.putInt("weight", user.getWeight());
        userLocalDatabaseEditor.putInt("physAct", user.getPhysAct());
        userLocalDatabaseEditor.commit();
    }

    public void setUserLoggedIn(boolean loggedIn) {
        SharedPreferences.Editor userLocalDatabaseEditor = userLocalDatabase.edit();
        userLocalDatabaseEditor.putBoolean("loggedIn", loggedIn);
        userLocalDatabaseEditor.commit();
    }

    public void clearUserData() {
        SharedPreferences.Editor userLocalDatabaseEditor = userLocalDatabase.edit();
        userLocalDatabaseEditor.clear();
        userLocalDatabaseEditor.commit();
    }

    public boolean authenticate(String username, String password){
        return username.equals(userLocalDatabase.getString("username", "")) && password.equals(userLocalDatabase.getString("password", ""));
    }

    public User getLoggedInUser() {
        if (userLocalDatabase.getBoolean("loggedIn", false) == false) {
            return null;
        }

        String name = userLocalDatabase.getString("name", "");
        String username = userLocalDatabase.getString("username", "");
        String password = userLocalDatabase.getString("password", "");
        String sex = userLocalDatabase.getString("sex", "");
        int age = userLocalDatabase.getInt("age", -1);
        int weight = userLocalDatabase.getInt("weight", -1);
        int height = userLocalDatabase.getInt("height", -1);
        int physAct = userLocalDatabase.getInt("physAct", -1);

        User user = new User(name, username, password, age + "", weight + "", height + "");
        user.setPhysAct(physAct);
        user.setSex(sex);
        return user;
    }
}
