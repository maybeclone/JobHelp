package com.slient.jobhelp.models.data;

/**
 * Created by silent on 5/7/2018.
 */
public class ItemNews {

    public String title;
    public String dateTime;
    public String url;
    public String srcImage;

    public ItemNews(String title, String url, String dateTime, String srcImage){
        this.title = title;
        this.url = url;
        this.dateTime = dateTime;
        this.srcImage = srcImage;
    }

    @Override
    public String toString() {
        return "ItemNews{" +
                "title='" + title + '\'' +
                ", dateTime='" + dateTime + '\'' +
                ", url='" + url + '\'' +
                ", srcImage='" + srcImage + '\'' +
                '}';
    }
}
