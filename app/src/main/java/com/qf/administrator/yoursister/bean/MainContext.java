package com.qf.administrator.yoursister.bean;

import java.util.List;

/**
 * Created by Shinelon on 2016/7/6.
 */
public class MainContext {

    /**
     * count : 1000
     * np : 1.467779642E9
     */

    private InfoBean info;
    /**
     * comment : 31
     * tags : [{"id":1,"name":"搞笑"},{"id":263,"name":"科技"},{"id":1073,"name":"正能量"},{"id":4670,"name":"涨姿势"},{"id":18910,"name":"hx"}]
     * bookmark : 151
     * text : 你对Google了解多少？百度的对手？NONONO，简直是一个改变未来的科技霸主啊
     * up : 1297
     * share_url : http://b.f.winapp111.com/share/19145720.html?wx.qq.com
     * down : 263
     * forward : 93
     * u : {"header":["http://wimg.spriteapp.cn/profile/large/2016/06/08/57576b6432993_mini.jpg","http://dimg.spriteapp.cn/profile/large/2016/06/08/57576b6432993_mini.jpg"],"is_v":true,"uid":"16167593","is_vip":true,"name":"小妖精-加V"}
     * passtime : 2016-07-06 17:39:01
     * video : {"playfcount":1154,"height":360,"width":640,"video":["http://wvideo.spriteapp.cn/video/2016/0702/b7d40504-3fac-11e6-af59-90b11c479401_wpd.mp4","http://bvideo.spriteapp.cn/video/2016/0702/b7d40504-3fac-11e6-af59-90b11c479401_wpd.mp4"],"duration":496,"playcount":27399,"thumbnail":["http://wimg.spriteapp.cn/picture/2016/0702/b7d40504-3fac-11e6-af59-90b11c479401_wpd_86_74.jpg","http://dimg.spriteapp.cn/picture/2016/0702/b7d40504-3fac-11e6-af59-90b11c479401_wpd_86_74.jpg"],"download":["http://wvideo.spriteapp.cn/video/2016/0702/b7d40504-3fac-11e6-af59-90b11c479401_wpc.mp4","http://bvideo.spriteapp.cn/video/2016/0702/b7d40504-3fac-11e6-af59-90b11c479401_wpc.mp4"]}
     * type : video
     * id : 19145720
     */

    private List<ListBean> list;

    public InfoBean getInfo() {
        return info;
    }

    public void setInfo(InfoBean info) {
        this.info = info;
    }

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    public static class InfoBean {
        private int count;
        private double np;

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public double getNp() {
            return np;
        }

        public void setNp(double np) {
            this.np = np;
        }
    }

    public static class ListBean {
        private String comment;
        private String bookmark;
        private String text;
        private String up;
        private String share_url;
        private int down;
        private int forward;
        /**
         * header : ["http://wimg.spriteapp.cn/profile/large/2016/06/08/57576b6432993_mini.jpg","http://dimg.spriteapp.cn/profile/large/2016/06/08/57576b6432993_mini.jpg"]
         * is_v : true
         * uid : 16167593
         * is_vip : true
         * name : 小妖精-加V
         */

        private UBean u;
        private String passtime;
        /**
         * playfcount : 1154
         * height : 360
         * width : 640
         * video : ["http://wvideo.spriteapp.cn/video/2016/0702/b7d40504-3fac-11e6-af59-90b11c479401_wpd.mp4","http://bvideo.spriteapp.cn/video/2016/0702/b7d40504-3fac-11e6-af59-90b11c479401_wpd.mp4"]
         * duration : 496
         * playcount : 27399
         * thumbnail : ["http://wimg.spriteapp.cn/picture/2016/0702/b7d40504-3fac-11e6-af59-90b11c479401_wpd_86_74.jpg","http://dimg.spriteapp.cn/picture/2016/0702/b7d40504-3fac-11e6-af59-90b11c479401_wpd_86_74.jpg"]
         * download : ["http://wvideo.spriteapp.cn/video/2016/0702/b7d40504-3fac-11e6-af59-90b11c479401_wpc.mp4","http://bvideo.spriteapp.cn/video/2016/0702/b7d40504-3fac-11e6-af59-90b11c479401_wpc.mp4"]
         */

        private VideoBean video;
        private GifBean gif;
        private String type;
        private String id;
        private ImagerBean imageBean;

        public static class ImagerBean{
            private String medium;
            private String big;
            private String download_url;
            private int width;
            private int height;
            private String small;

            public String getSmall() {
                return small;
            }

            public void setSmall(String small) {
                this.small = small;
            }

            public ImagerBean() {
            }

            public String getMedium() {
                return medium;
            }

            public void setMedium(String medium) {
                this.medium = medium;
            }

            public String getBig() {
                return big;
            }

            public void setBig(String big) {
                this.big = big;
            }

            public String getDownload_url() {
                return download_url;
            }

            public void setDownload_url(String download_url) {
                this.download_url = download_url;
            }

            public int getWidth() {
                return width;
            }

            public void setWidth(int width) {
                this.width = width;
            }

            public int getHeight() {
                return height;
            }

            public void setHeight(int height) {
                this.height = height;
            }
        }

        public ImagerBean getImage() {
            return imageBean;
        }

        public void setImage(ImagerBean imageBean) {
            this.imageBean = imageBean;
        }

        public GifBean getGif() {
            return gif;
        }

        public void setGif(GifBean gif) {
            this.gif = gif;
        }

        /**
         * id : 1

         * name : 搞笑
         */

        private List<TagsBean> tags;

        public String getComment() {
            return comment;
        }

        public void setComment(String comment) {
            this.comment = comment;
        }

        public String getBookmark() {
            return bookmark;
        }

        public void setBookmark(String bookmark) {
            this.bookmark = bookmark;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public String getUp() {
            return up;
        }

        public void setUp(String up) {
            this.up = up;
        }

        public String getShare_url() {
            return share_url;
        }

        public void setShare_url(String share_url) {
            this.share_url = share_url;
        }

        public int getDown() {
            return down;
        }

        public void setDown(int down) {
            this.down = down;
        }

        public int getForward() {
            return forward;
        }

        public void setForward(int forward) {
            this.forward = forward;
        }

        public UBean getU() {
            return u;
        }

        public void setU(UBean u) {
            this.u = u;
        }

        public String getPasstime() {
            return passtime;
        }

        public void setPasstime(String passtime) {
            this.passtime = passtime;
        }

        public VideoBean getVideo() {
            return video;
        }

        public void setVideo(VideoBean video) {
            this.video = video;
        }


        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public List<TagsBean> getTags() {
            return tags;
        }

        public void setTags(List<TagsBean> tags) {
            this.tags = tags;
        }

        public static class UBean {
            private boolean is_v;
            private String uid;
            private boolean is_vip;
            private String name;
            private String header;

            public boolean isIs_v() {
                return is_v;
            }

            public void setIs_v(boolean is_v) {
                this.is_v = is_v;
            }

            public String getUid() {
                return uid;
            }

            public void setUid(String uid) {
                this.uid = uid;
            }

            public boolean isIs_vip() {
                return is_vip;
            }

            public void setIs_vip(boolean is_vip) {
                this.is_vip = is_vip;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getHeader() {
                return header;
            }

            public void setHeader(String header) {
                this.header = header;
            }
        }
        public static class GifBean{
            private int height;
            private int width;
            private String images;
            private String gif_thumbnail;
            private String download_url;

            public int getHeight() {
                return height;
            }

            public void setHeight(int height) {
                this.height = height;
            }

            public int getWidth() {
                return width;
            }

            public void setWidth(int width) {
                this.width = width;
            }

            public String getImages() {
                return images;
            }

            public void setImages(String images) {
                this.images = images;
            }

            public String getGif_thumbnail() {
                return gif_thumbnail;
            }

            public void setGif_thumbnail(String gif_thumbnail) {
                this.gif_thumbnail = gif_thumbnail;
            }

            public String getDownload_url() {
                return download_url;
            }

            public void setDownload_url(String download_url) {
                this.download_url = download_url;
            }
        }

        public static class VideoBean {
            private int playfcount;
            private int height;
            private int width;
            private int duration;
            private int playcount;
            private String video;
            private String thumbnail;
            private String download;

            public int getPlayfcount() {
                return playfcount;
            }

            public void setPlayfcount(int playfcount) {
                this.playfcount = playfcount;
            }

            public int getHeight() {
                return height;
            }

            public void setHeight(int height) {
                this.height = height;
            }

            public int getWidth() {
                return width;
            }

            public void setWidth(int width) {
                this.width = width;
            }

            public int getDuration() {
                return duration;
            }

            public void setDuration(int duration) {
                this.duration = duration;
            }

            public int getPlaycount() {
                return playcount;
            }

            public void setPlaycount(int playcount) {
                this.playcount = playcount;
            }

            public String getVideo() {
                return video;
            }

            public void setVideo(String video) {
                this.video = video;
            }

            public String getThumbnail() {
                return thumbnail;
            }

            public void setThumbnail(String thumbnail) {
                this.thumbnail = thumbnail;
            }

            public String getDownload() {
                return download;
            }

            public void setDownload(String download) {
                this.download = download;
            }
        }

        public static class TagsBean {
            private int id;
            private String name;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }
        }
    }
}
