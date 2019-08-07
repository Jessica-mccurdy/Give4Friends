package com.example.give4friends.models;

import com.example.give4friends.Adapters.DonateAdapter;
import com.parse.ParseClassName;
import com.parse.ParseException;
import com.parse.ParseFile;
import com.parse.ParseObject;
import com.parse.ParseUser;

import java.util.List;

@ParseClassName("Charity")
public class Charity extends ParseObject {

    public static final String KEY_NAME = "name";
    public static final String KEY_ID= "objectId";
    public static final String KEY_MISSION  = "mission";
    public static final String KEY_RATING  = "ratingURL";
    public static final String KEY_CATEGORY_NAME  = "categoryName";
    public static final String KEY_URL  = "websiteUrl";
    public static final String KEY_CAUSE_NAME  = "causeName";
    public static final String KEY_CHARITY_ID  = "charityName";
    public static final String KEY_LIKES_COUNT  = "likesCount";
    public static final String KEY_LIKES_USERS  = "likesUsers";
    public static final String KEY_WEBSITE = "websiteUrl";
    public static final String KEY_NUM_LIKES = "likesCount";
    public static final String KEY_CODE = "payPal";
    public static final String KEY_LOGO = "logoUrl";

    public Charity(){}

    public String getKeyName() {

        try {
            return fetchIfNeeded().getString(KEY_NAME);
        } catch (ParseException e) {
            e.printStackTrace();
            return("missing name");
        }
    }

    public void setKeyName(String name){ put(KEY_NAME, name); }

    public String getKeyCode() {
        return getString(KEY_CODE);
    }

    public String getKeyCharityID(){return getString(KEY_CHARITY_ID);}

    public void setKeyCharityID(String ID){put(KEY_CHARITY_ID, ID );}

    public String getKeyMission() {
        return getString(KEY_MISSION);
    }

    public void setKeyMission(String mission){
        put(KEY_MISSION, mission);
    }

    public String getKeyRatingURL() {
        return getString(KEY_RATING);
    }

    public void setKeyRatingURL(String url) {
        put(KEY_RATING, url);
    }

    public String getKeyCategoryName() {
        return getString(KEY_CATEGORY_NAME);
    }

    public void setKeyCategoryName(String name){
        put(KEY_CATEGORY_NAME, name);
    }

    public String getKeyUrl() {
        return getString(KEY_URL);
    }

    public void setKeyUrl(String url){
        put(KEY_URL, url);
    }

    public String getKeyCauseName() {
        return getString(KEY_CAUSE_NAME);
    }

    public void setKeyCauseName(String name){
        put(KEY_CAUSE_NAME, name);
    }

    public void incrementLikes(int amount){
        increment(KEY_LIKES_COUNT, amount );
    }

    public void setKeyLikesUsers(List<ParseUser> list){
        put(KEY_LIKES_USERS, list);
    }

    public void addLikesUser(String user){
        add(KEY_LIKES_USERS, user);
    }

    public int getKeyNumLikes(){
        return getInt(KEY_NUM_LIKES);
    }

    public String getKeyLogo() {
        return getString(KEY_LOGO);
    }

}
