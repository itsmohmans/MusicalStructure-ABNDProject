package com.mohammadmansour.musicalstructure;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NowPlayingActivity extends AppCompatActivity {

    private boolean isPlaying = false;
    @BindView(R.id.song_artwork_img)
    ImageView albumArt;
    @BindView(R.id.song_txt)
    TextView title;
    @BindView(R.id.artist_txt)
    TextView artist;
    @BindView(R.id.duration_txt)
    TextView duration;
    @BindView(R.id.play_btn)
    ImageView playBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_now_playing);
        ButterKnife.bind(this);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

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

        // get selected song data
        Intent i = getIntent();
        String songTitle = Objects.requireNonNull(i.getExtras()).getString("title");
        String songArtist = i.getExtras().getString("artist");
        int songAlbumArt = i.getExtras().getInt("albumArt");
        double songDuration = i.getExtras().getDouble("duration");

        // set song data to their views
        albumArt.setImageResource(songAlbumArt);
        title.setText(songTitle);
        artist.setText(songArtist);
        String[] timeParts = String.valueOf(songDuration).split("\\.");
        duration.setText(String.format("0%s:%s", timeParts[0], timeParts[1]));

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}