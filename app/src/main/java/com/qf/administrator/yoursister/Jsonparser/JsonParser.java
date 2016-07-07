package com.qf.administrator.yoursister.Jsonparser;

import android.text.TextUtils;
import android.util.Log;

import com.qf.administrator.yoursister.bean.MainContext;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shinelon on 2016/7/6.
 */
public class JsonParser {
    public static List<MainContext> parserContext(String jsonString) {
        if(!TextUtils.isEmpty(jsonString)){
            try {
                JSONObject object=new JSONObject(jsonString);
                JSONArray listArray=object.getJSONArray("list");

                MainContext mainContext=new MainContext();
                List<MainContext.ListBean> list=new ArrayList<>();
                for (int i = 0; i < listArray.length(); i++) {
                    JSONObject jsonObject=listArray.getJSONObject(i);
                    MainContext.ListBean listBean=new MainContext.ListBean();
                    List<MainContext.ListBean.TagsBean> tags=new ArrayList<>();
                    JSONArray tag=jsonObject.getJSONArray("tags");
                    for (int j = 0; j < tag.length(); j++) {
                        JSONObject tagsObject = tag.getJSONObject(j);
                        MainContext.ListBean.TagsBean tagsBean=new MainContext.ListBean.TagsBean();
                        tagsBean.setId(tagsObject.getInt("id"));
                        tagsBean.setName(tagsObject.getString("name"));
                        tags.add(tagsBean);
                    }
                    listBean.setTags(tags);
                    listBean.setComment(jsonObject.getString("comment"));
                    listBean.setBookmark(jsonObject.getString("bookmark"));
                    listBean.setText(jsonObject.getString("text"));
                    try {
                        if(jsonObject.has("image")){
                            JSONObject image = jsonObject.getJSONObject("image");
                            listBean.setImage(image.getJSONArray("medium").getString(0));
                        }
                        if(jsonObject.has("video")){
                            JSONObject videoObject = jsonObject.getJSONObject("video");
                            MainContext.ListBean.VideoBean video=new MainContext.ListBean.VideoBean();
                            video.setPlayfcount(videoObject.getInt("playfcount"));
                            video.setWidth(videoObject.getInt("width"));
                            video.setHeight(videoObject.getInt("height"));

                            video.setVideo(videoObject.getJSONArray("video").getString(0));
                            video.setThumbnail(videoObject.getJSONArray("thumbnail").getString(0));
                            video.setDownload(videoObject.getJSONArray("download").getString(0));
//                            Log.e("parserContext: ", video.getVideo());

                            video.setDuration(videoObject.getInt("duration"));
                            video.setPlaycount(videoObject.getInt("playcount"));
                            listBean.setVideo(video);
                        }
                        if(jsonObject.has("gif")){
                            JSONObject gifObject = jsonObject.getJSONObject("gif");
                            MainContext.ListBean.GifBean gif=new MainContext.ListBean.GifBean();
                            gif.setWidth(gifObject.getInt("width"));
                            gif.setHeight(gifObject.getInt("height"));

                            gif.setImages(gifObject.getJSONArray("images").getString(0));
                            gif.setGif_thumbnail(gifObject.getJSONArray("gif_thumbnail").getString(0));
                            gif.setDownload_url(gifObject.getJSONArray("download_url").getString(0));
//                            Log.e("parserContext: ",gif.getImages() );

                            listBean.setGif(gif);
                        }
                    } catch (JSONException e) {
                    }
                    //用户头像
                    JSONObject user = jsonObject.getJSONObject("u");
                    MainContext.ListBean.UBean u=new MainContext.ListBean.UBean();
                    u.setHeader(user.getJSONArray("header").getString(0));
                    u.setIs_v(user.getBoolean("is_v"));
                    u.setUid(user.getString("uid"));
                    u.setIs_vip(user.getBoolean("is_vip"));
                    u.setName(user.getString("name"));

                    listBean.setU(u);
                    listBean.setUp(jsonObject.getString("up"));
                    listBean.setDown(jsonObject.getInt("down"));
                    listBean.setForward(jsonObject.getInt("forward"));
                    listBean.setPasstime(jsonObject.getString("passtime"));
                    listBean.setType(jsonObject.getString("type"));
                    listBean.setId(jsonObject.getString("id"));


                    list.add(listBean);
                }
                mainContext.setList(list);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
