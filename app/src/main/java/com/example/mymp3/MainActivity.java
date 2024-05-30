package com.example.mymp3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void click(View view) {
       if(view.getId()==R.id.ivList || view.getId()==R.id.tvList){
           replaceFragement(new ListFragment());
       }else if(view.getId()==R.id.ivPlay || view.getId()==R.id.tvPlay){
           replaceFragement(new PlayFragment());
        }else{
           replaceFragement(new MyFragment());
       }
    }
    private  void replaceFragement(Fragment fragment){
      FragmentManager fm= getSupportFragmentManager();
      FragmentTransaction transaction=fm.beginTransaction();
      transaction.replace(R.id.fragmentContent,fragment);
      transaction.commit();

    }
}