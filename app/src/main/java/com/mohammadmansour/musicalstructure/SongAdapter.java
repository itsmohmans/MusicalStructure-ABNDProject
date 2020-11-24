package com.mohammadmansour.musicalstructure;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

import java.util.ArrayList;

public class SongAdapter extends ArrayAdapter<Songs> {

    public SongAdapter(Activity context, ArrayList<Songs> songs) {
        super(context, 0, songs);
    }

    /**
     * Provides a view for an AdapterView (ListView, GridView, etc.)
     *
     * @param position    The position in the list of data that should be displayed in the
     *                    list item view.
     * @param convertView The recycled view to populate.
     * @param parent      The parent ViewGroup that is used for inflation.
     * @return The View for the position in the AdapterView.
     */

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.songs_listview, parent, false);
        }

        // Get the {@link Songs} object located at this position in the list
        Songs currentSong = getItem(position);

        // set the song title to its TextView
        TextView songTitle = (TextView) listItemView.findViewById(R.id.song_txt);
        songTitle.setText(currentSong.getSongTitle());

        // set the artist name to its TextView
        TextView artistName = (TextView) listItemView.findViewById(R.id.artist_txt);
        artistName.setText(currentSong.getArtistName());

        // set the album artwork image to its ImageView
        ImageView artworkImg = (ImageView) listItemView.findViewById(R.id.artwork_img);
        artworkImg.setImageResource(currentSong.getArtworkResID());

        // convert duration from seconds to minutes & set it to its TextView
        TextView durationTxt = (TextView) listItemView.findViewById(R.id.duration_txt);

        String durationStr = String.valueOf(currentSong.getDuration());
        String[] timeParts = durationStr.split("\\.");
        durationTxt.setText(String.format("0%s:%s", timeParts[0], timeParts[1]));

        return listItemView;
    }
}
