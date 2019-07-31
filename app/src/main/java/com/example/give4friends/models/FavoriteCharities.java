package com.example.give4friends.models;

import android.graphics.Color;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.give4friends.Adapters.CharityProfileAdapter;
import com.example.give4friends.Adapters.DonateSearchAdapter;
import com.example.give4friends.R;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseRelation;
import com.parse.ParseUser;

import java.util.List;

public final class FavoriteCharities {


        public static void setUpFavorites(Charity parseCharity, ParseUser myUser, ImageButton ibCPLike, TextView tvCPLikedNum)

    {
        //pass in this for view holder (ViewHolderCharity) viewHolder
        //check if user is in likes list
        //final List<Charity> array = myUser.getList("favCharities" );
        List<User> array = parseCharity.getList("likesUsers");


        if (array == null || !(array.contains(myUser.getObjectId()))) {

            ibCPLike.setImageResource(R.drawable.ic_like_icon);
            ibCPLike.setColorFilter(Color.BLACK);

        } else {

             ibCPLike.setImageResource(R.drawable.ic_like_filled_con);
             ibCPLike.setColorFilter(Color.YELLOW);

        }

        ibCPLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ParseRelation<ParseObject> relation = myUser.getRelation("favCharities");
                List<User> array = parseCharity.getList("likesUsers");

                if (array == null || !(array.contains(myUser.getObjectId()))) {

                    ibCPLike.setImageResource(R.drawable.ic_like_filled_con);

                    ibCPLike.setColorFilter(Color.YELLOW);

                    //update parse
                    //updateUser
                    relation.add(parseCharity);
                    myUser.saveInBackground();

                    //increment likes for charity
                    parseCharity.incrementLikes(1);
                    //add user to array
                    parseCharity.addLikesUser(myUser.getObjectId());
                    try {
                        parseCharity.save();
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    tvCPLikedNum.setText("" + parseCharity.getKeyNumLikes());
                    //tvCPLikedNum.setText("Favorited by " + parseCharity.getKeyNumLikes() + " users");
                } else {
                    ibCPLike.setImageResource(R.drawable.ic_like_icon);
                    ibCPLike.setColorFilter(Color.BLACK);

                    //update user
                    relation.remove(parseCharity);
                    myUser.saveInBackground();
                    //update charity
                    parseCharity.incrementLikes(-1);
                    //add user to array
                    array.remove(myUser.getObjectId());
                    parseCharity.setKeyLikesUsers(array);
                    try {
                        parseCharity.save();
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    tvCPLikedNum.setText("" + parseCharity.getKeyNumLikes());
                    //tvCPLikedNum.setText("Liked by " + parseCharity.getKeyNumLikes() + " users");

                }


            }
        });
    }
}