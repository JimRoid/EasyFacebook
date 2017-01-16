package com.easyapp.facebook.module.entities;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by easyapp_jim on 2016/6/4.
 */
public class Feed {

    /**
     * previous : https://graph.facebook.com/v2.6/733901326716629/feed?fields=picture,full_picture,from,actions,message,link,created_time,updated_time,comments,likes&format=json&since=1441619433&access_token=EAAEHPiN70mEBAMrWiqcddVgKJDSJtZB74iGxgX2rFjlLqcqitqoupzE4FwajY3ZAp6JKqzV3k4rdq4kAnRy5o1nMvmzEojH5vqZAYcP7ytpWZCG8orX42VLq3jNnbCZBzG3VAXZCwDppdLyLV6O6Jva1gLEko2wX2zWI4gVImSpiZAOBt9V5w1m9eoZBnl20qB4ZA9JMWdqdaiGuwAMKU3wRG&limit=25&__paging_token=enc_AdCYyZA3gzwZBlDQzHZB3LwhZCZCdaqZCuaGTk0RhW9WSLZBkCrRHymTwUPmg8zeNxkMkQQchdGXEZCKZBJfJC2B6O7tNeE6WT6tLgtNrGVQ8CveWmOKUlwZDZD&__previous=1
     * next : https://graph.facebook.com/v2.6/733901326716629/feed?fields=picture,full_picture,from,actions,message,link,created_time,updated_time,comments,likes&format=json&access_token=EAAEHPiN70mEBAMrWiqcddVgKJDSJtZB74iGxgX2rFjlLqcqitqoupzE4FwajY3ZAp6JKqzV3k4rdq4kAnRy5o1nMvmzEojH5vqZAYcP7ytpWZCG8orX42VLq3jNnbCZBzG3VAXZCwDppdLyLV6O6Jva1gLEko2wX2zWI4gVImSpiZAOBt9V5w1m9eoZBnl20qB4ZA9JMWdqdaiGuwAMKU3wRG&limit=25&until=1440482285&__paging_token=enc_AdCpYuALRnvFqHorYoV3f8o9tkb6FQy2ZCQfrdZCvSQNVXSeQdITe3qslltZBK1u4RqZCiHkce1GY7ocuLT5jSKifi5luhoECTMqG5iii16AZCkS8XwZDZD
     */

    private PagingBean paging;
    /**
     * picture : https://external.xx.fbcdn.net/safe_image.php?d=AQCgfI4g8HUwqPal&w=130&h=130&url=http%3A%2F%2Ffanshop.easyapp.com.tw%2Ffifi%2Fassets%2Fdata%2F55ed5de0022fa62422439e17%2Fd9f5b0d0-5545-11e5-8dde-6992d357e51c.png&cfs=1
     * full_picture : https://external.xx.fbcdn.net/safe_image.php?d=AQAQgrNpUa-zSyug&url=http%3A%2F%2Ffanshop.easyapp.com.tw%2Ffifi%2Fassets%2Fdata%2F55ed5de0022fa62422439e17%2Fd9f5b0d0-5545-11e5-8dde-6992d357e51c.png
     * from : {"name":"Ｍibo 日韓精品","id":"733901326716629"}
     * actions : [{"name":"Comment","link":"https://www.facebook.com/733901326716629/posts/740145566092205"},{"name":"Like","link":"https://www.facebook.com/733901326716629/posts/740145566092205"},{"name":"Share","link":"https://www.facebook.com/733901326716629/posts/740145566092205"}]
     * message : #Ｍibo日韓精品_日韓衣服精品(商品已售完)
     * 韓國東大門空運回台
     * 售價:100
     * http://fanshop.easyapp.com.tw/fifi/show/proddetail/55ed5de0022fa62422439e17
     * link : http://fanshop.easyapp.com.tw/fifi/assets/data/55ed5de0022fa62422439e17/d9f5b0d0-5545-11e5-8dde-6992d357e51c.png
     * created_time : 2015-09-07T09:50:33+0000
     * updated_time : 2015-09-08T04:21:51+0000
     * id : 733901326716629_740145566092205
     * likes : {"data":[{"id":"1006302799454095","name":"KUn HUi ChAng"}],"paging":{"cursors":{"before":"MTAwNjMwMjc5OTQ1NDA5NQZDZD","after":"MTAwNjMwMjc5OTQ1NDA5NQZDZD"}}}
     */

    private List<DataBean> data;

    public PagingBean getPaging() {
        return paging;
    }

    public void setPaging(PagingBean paging) {
        this.paging = paging;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class PagingBean {
        @SerializedName("previous")
        private String previous;
        @SerializedName("next")
        private String next;

        public String getPrevious() {
            return previous;
        }

        public void setPrevious(String previous) {
            this.previous = previous;
        }

        public String getNext() {
            return next;
        }

        public void setNext(String next) {
            this.next = next;
        }
    }

    public static class DataBean {
        @SerializedName("picture")
        private String picture;
        @SerializedName("full_picture")
        private String full_picture;
        /**
         * name : Ｍibo 日韓精品
         * id : 733901326716629
         */

        private FromBean from;
        @SerializedName("message")
        private String message;
        @SerializedName("link")
        private String link;
        @SerializedName("created_time")
        private String created_time;
        @SerializedName("updated_time")
        private String updated_time;
        @SerializedName("id")
        private String id;
        /**
         * data : [{"id":"1006302799454095","name":"KUn HUi ChAng"}]
         * paging : {"cursors":{"before":"MTAwNjMwMjc5OTQ1NDA5NQZDZD","after":"MTAwNjMwMjc5OTQ1NDA5NQZDZD"}}
         */

        private LikesBean likes;
        /**
         * name : Comment
         * link : https://www.facebook.com/733901326716629/posts/740145566092205
         */

        private List<ActionsBean> actions;

        public String getPicture() {
            return picture;
        }

        public void setPicture(String picture) {
            this.picture = picture;
        }

        public String getFull_picture() {
            return full_picture;
        }

        public void setFull_picture(String full_picture) {
            this.full_picture = full_picture;
        }

        public FromBean getFrom() {
            return from;
        }

        public void setFrom(FromBean from) {
            this.from = from;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public String getLink() {
            return link;
        }

        public void setLink(String link) {
            this.link = link;
        }

        public String getCreated_time() {
            return created_time;
        }

        public void setCreated_time(String created_time) {
            this.created_time = created_time;
        }

        public String getUpdated_time() {
            return updated_time;
        }

        public void setUpdated_time(String updated_time) {
            this.updated_time = updated_time;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public LikesBean getLikes() {
            return likes;
        }

        public void setLikes(LikesBean likes) {
            this.likes = likes;
        }

        public List<ActionsBean> getActions() {
            return actions;
        }

        public void setActions(List<ActionsBean> actions) {
            this.actions = actions;
        }

        public static class FromBean {
            @SerializedName("name")
            private String name;
            @SerializedName("id")
            private String id;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }
        }

        public static class LikesBean {
            /**
             * cursors : {"before":"MTAwNjMwMjc5OTQ1NDA5NQZDZD","after":"MTAwNjMwMjc5OTQ1NDA5NQZDZD"}
             */

            private PagingBean paging;
            /**
             * id : 1006302799454095
             * name : KUn HUi ChAng
             */

            private List<LikeDataBean> data;

            public PagingBean getPaging() {
                return paging;
            }

            public void setPaging(PagingBean paging) {
                this.paging = paging;
            }

            public List<LikeDataBean> getData() {
                return data;
            }

            public void setData(List<LikeDataBean> data) {
                this.data = data;
            }

            public static class PagingBean {
                /**
                 * before : MTAwNjMwMjc5OTQ1NDA5NQZDZD
                 * after : MTAwNjMwMjc5OTQ1NDA5NQZDZD
                 */

                private CursorsBean cursors;

                public CursorsBean getCursors() {
                    return cursors;
                }

                public void setCursors(CursorsBean cursors) {
                    this.cursors = cursors;
                }

                public static class CursorsBean {
                    @SerializedName("before")
                    private String before;
                    @SerializedName("after")
                    private String after;

                    public String getBefore() {
                        return before;
                    }

                    public void setBefore(String before) {
                        this.before = before;
                    }

                    public String getAfter() {
                        return after;
                    }

                    public void setAfter(String after) {
                        this.after = after;
                    }
                }
            }

            public static class LikeDataBean {
                @SerializedName("id")
                private String id;
                @SerializedName("name")
                private String name;

                public String getId() {
                    return id;
                }

                public void setId(String id) {
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

        public static class ActionsBean {
            @SerializedName("name")
            private String name;
            @SerializedName("link")
            private String link;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getLink() {
                return link;
            }

            public void setLink(String link) {
                this.link = link;
            }
        }
    }
}
