package com.example.mymp3.util;

import android.content.res.XmlResourceParser;
import android.util.Xml;

import com.example.mymp3.po.Music;
/*import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;*/

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class XmlParserService {
    public static List<Music> getInfosFromXML(XmlResourceParser parser) throws IOException {
        List<Music> musics = null;
        Music music = null;
        try {
            int type = parser.getEventType(); //得到当前事件的类型
            while (type != XmlPullParser.END_DOCUMENT){ //文档结束标签
                switch (type){
                    case XmlPullParser.START_TAG:  //一个节点的开始标签
                        //解析到全局开始的标签MusicList根节点
                        if("MusicList".equals(parser.getName())){
                            musics = new ArrayList<Music>();
                        }else if("Music".equals(parser.getName())){
                            music = new Music();
                        }else if("title".equals(parser.getName())){
                            //parser.nextText()得到该tag节点中的内容
                            String title = parser.nextText();
                            music.setTitle(title);
                        }else if("author".equals(parser.getName())){
                            String author = parser.nextText();
                            music.setAuthor(author);
                        }else if("like".equals(parser.getName())){
                            int like = parser.next();
                            music.setLike(like);
                        }else if("url".equals(parser.getName())){
                            String url = parser.nextText();
                            music.setUrl(url);
                        }
                        break;
                    case XmlPullParser.END_TAG:  //一个节点结束的标签
                        //一个城市的信息处理完毕，city的结束标签
                        if("Music".equals(parser.getName())){
                            musics.add(music);
                            music = null;
                        }
                }
                type = parser.next();
            }
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        }
        return  musics;
    }

    /*public static List<Music> getInfosFromJson(InputStream is) throws IOException {
        byte[] buffer=new byte[is.available()];
        is.read(buffer);
        String json=new String(buffer,"utf-8");
        //利用Gson进行解析
        Gson gson=new Gson();
        Type type=new TypeToken<List<Music>>(){}.getType();
        List<Music> Musics=gson.fromJson(json, type);
        return  Musics;
    }*/
}
