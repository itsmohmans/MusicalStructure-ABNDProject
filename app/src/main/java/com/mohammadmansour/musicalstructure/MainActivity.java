package com.mohammadmansour.musicalstructure;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    private boolean isPlaying = false;
    @BindView(R.id.now_playing_footer)
    LinearLayout nowPlayingFooter;
    @BindView(R.id.songs_list)
    ListView listView;
    @BindView(R.id.artist_txt)
    TextView nowPlayingArtist;
    @BindView(R.id.song_txt)
    TextView nowPlayingSong;
    @BindView(R.id.play_btn)
    ImageView playBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


        playBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isPlaying){
                    playBtn.setImageResource(R.drawable.ic_pause);
                    isPlaying = true;
                }
                else{
                    playBtn.setImageResource(R.drawable.ic_play_arrow);
                    isPlaying = false;
                }
            }
        });

        final ArrayList<Songs> songsList = new ArrayList<>();
        // add some music data to the list
        songsList.add(new Songs("Last Song", "Cairokee",
                R.drawable.a_drop_of_white_album_cover, 4.47));
        songsList.add(new Songs("Dinosaur", "Cairokee",
                R.drawable.a_drop_of_white_album_cover, 4.18));
        SongAdapter adapter = new SongAdapter(this, songsList);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Songs song = songsList.get(position);
                Intent i = new Intent(getApplicationContext(), NowPlaying.class);
                i.putExtra("title", song.getSongTitle());
                i.putExtra("artist", song.getArtistName());
                i.putExtra("albumArt", song.getArtworkResID());
                i.putExtra("duration", song.getDuration());
                nowPlayingSong.setText(song.getSongTitle());
                nowPlayingArtist.setText(song.getArtistName());
                startActivity(i);
            }
        });
    }
}