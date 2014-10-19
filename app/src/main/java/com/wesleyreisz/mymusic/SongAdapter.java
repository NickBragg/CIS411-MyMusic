package com.wesleyreisz.mymusic;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.wesleyreisz.mymusic.model.Song;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by Patrick on 10/18/2014.
 */
public class SongAdapter extends ArrayAdapter<Song> {
    private SimpleDateFormat df = new SimpleDateFormat("MMM d, yyyy (EEE)");
    private Context mContext;
    private List<Song> mEntries;


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null)
        {
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            convertView = inflater.inflate(R.layout.listview_for_each_song, parent, false);

        }

        final Song song = mEntries.get(position);

        TextView textViewSongTitle = (TextView)convertView.findViewById(R.id.songTitle);
        textViewSongTitle.setText(song.getSongTitle());

        TextView textViewSongArtist = (TextView)convertView.findViewById(R.id.songArtist);
        textViewSongArtist.setText(song.getArtistName());

        TextView textViewDate = (TextView)convertView.findViewById(R.id.date);
        textViewDate.setText(df.format(song.getSongPublishedDate()));

        return convertView;
    }

    public SongAdapter(Context context, int textViewResourceId, List<Song> entries) {
        super(context, textViewResourceId, entries);

        mContext = context;
        mEntries = entries;
    }
}
