package com.wesleyreisz.mymusic;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.wesleyreisz.mymusic.model.Song;
import com.wesleyreisz.mymusic.service.MockMusicService;

import java.util.List;
import java.util.zip.Inflater;

/**
 * Created by Patrick on 10/19/2014.
 */
public class fragment_MusicList extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        return inflater.inflate(R.layout.fragment_music_list,container,false);
    }

    @Override
    public void onStart() {
        super.onStart();
        ListView listView = (ListView) getView().findViewById(R.id.fragment_list);
        List<Song> songs = new MockMusicService().findAll();

        SongAdapter songAdapter = new SongAdapter(getActivity(),R.layout.fragment_music_list,songs);
        listView.setAdapter(songAdapter);
    }
}
