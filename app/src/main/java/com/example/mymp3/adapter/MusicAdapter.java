package com.example.mymp3.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.mymp3.ListFragment;
import com.example.mymp3.PlayFragment;
import com.example.mymp3.R;
import com.example.mymp3.po.Music;

import java.util.List;

public class MusicAdapter extends BaseAdapter {
    List<Music> musicList;
    AppCompatActivity context;

    public MusicAdapter(AppCompatActivity context, List<Music> musicList) {
        this.musicList = musicList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return musicList.size();
    }

    @Override
    public Object getItem(int i) {
        return musicList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = View.inflate(context, R.layout.item, null);
        TextView tvNo = view.findViewById(R.id.tvNo);
        TextView tvTitle = view.findViewById(R.id.tvTitle);
        TextView tvAuthor = view.findViewById(R.id.tvAuthor);
        Music music = musicList.get(i);
        tvNo.setText((i + 1) + "");
        tvTitle.setText(music.getTitle());
        tvAuthor.setText(music.getAuthor());
        view.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                PlayFragment playFragment = new PlayFragment();
                playFragment.setMusicList(musicList, i);
                FragmentManager fm = context.getSupportFragmentManager();
                FragmentTransaction transaction = fm.beginTransaction();
                transaction.replace(R.id.fragmentContent,playFragment);
                transaction.commit();
            }
        });
        return view;
    }
}
