package com.mohammadmansour.musicalstructure;


/**
 * @link Songs is the songs list
 * It cantains the song title, artist, artwork and duration
 */

public class Songs {
    private String mSongTitle;
    private String mArtistName;
    // Resource ID of album artwork
    private int mArtworkResourceID;
    // song duration in minutes
    private double mDuration;

    /**
     * Creates new Songs object
     * @param songTitle is the title of the song.
     * @param artistName is the artist name of the song (obviously)
     * @param artworkResourceID is the album artwork image resource id
     * @param duration is the song duration in minutes
     * */
    public Songs(String songTitle, String artistName,
                 int artworkResourceID, double duration) {
        mSongTitle = songTitle;
        mArtistName = artistName;
        mArtworkResourceID = artworkResourceID;
        mDuration = duration;
    }


    /**
     * Get the song title
     */
    public String getSongTitle(){
        return mSongTitle;
    }

    /**
     * Get the artist name
     */
    public String getArtistName() {
        return mArtistName;
    }
    /**
     * Get the artwork resource ID.
     * */
    public int getArtworkResID(){
        return mArtworkResourceID;
    }
    /**
     * Get song duration
     * */
    public double getDuration(){
        return mDuration;
    }
}
