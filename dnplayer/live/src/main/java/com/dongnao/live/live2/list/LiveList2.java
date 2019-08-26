package com.dongnao.live.live2.list;

import java.util.List;

public class LiveList2 {
    /**
     * error : 0
     * data : [{"room_id":"30","room_src":"https://rpic.douyucdn.cn/live-cover/roomCover/cover_update/2019/08/22/08b1d7779fdbb61767948d86d37fe916.jpg/dy1","vertical_src":"https://rpic.douyucdn.cn/live-cover/roomCover/cover_update/2019/08/22/08b1d7779fdbb61767948d86d37fe916.jpg/dy1","isVertical":0,"cate_id":3,"room_name":"【TI9】Mineski-Secret","show_status":"1","subject":"","show_time":"1565318131","owner_uid":"1640","specific_catalog":"","specific_status":"0","vod_quality":"","nickname":"DOTA2官方赛事","online":4759431,"hn":4759431,"url":"/30","game_url":"/directory/game/DOTA2","game_name":"DOTA2","child_id":95,"avatar":"https://apic.douyucdn.cn/upload/avatar_v3/201908/8d9b51c99a264e8492aaad36b1ee4355_big.jpg?rltime","avatar_mid":"https://apic.douyucdn.cn/upload/avatar_v3/201908/8d9b51c99a264e8492aaad36b1ee4355_middle.jpg?rltime","avatar_small":"https://apic.douyucdn.cn/upload/avatar_v3/201908/8d9b51c99a264e8492aaad36b1ee4355_small.jpg?rltime","jumpUrl":"","fans":"863615","ranktype":0,"is_noble_rec":0,"anchor_city":""},{"room_id":"9999","room_src":"https://rpic.douyucdn.cn/live-cover/roomCover/cover_update/2019/08/15/a3da50b01b0362bac3ff4c43bad18460.jpg/dy1","vertical_src":"https://rpic.douyucdn.cn/live-cover/roomCover/cover_update/2019/08/15/a3da50b01b0362bac3ff4c43bad18460.jpg/dy1","isVertical":0,"cate_id":3,"room_name":"清扬无懈可击：解说TI9国际邀请赛","show_status":"1","subject":"","show_time":"1566439147","owner_uid":"204389","specific_catalog":"","specific_status":"0","vod_quality":"","nickname":"yyfyyf","online":4051988,"hn":4051988,"url":"/9999","game_url":"/directory/game/DOTA2","game_name":"DOTA2","child_id":1033,"avatar":"https://apic.douyucdn.cn/upload/avanew/face/201803/23/17/faa711e232041d7525a1bd695bf8fa8e_big.jpg?rltime","avatar_mid":"https://apic.douyucdn.cn/upload/avanew/face/201803/23/17/faa711e232041d7525a1bd695bf8fa8e_middle.jpg?rltime","avatar_small":"https://apic.douyucdn.cn/upload/avanew/face/201803/23/17/faa711e232041d7525a1bd695bf8fa8e_small.jpg?rltime","jumpUrl":"","fans":"2287193","ranktype":0,"is_noble_rec":0,"anchor_city":""},{"room_id":"312719","room_src":"https://rpic.douyucdn.cn/asrpic/190822/312719_1422.png/dy1","vertical_src":"https://rpic.douyucdn.cn/asrpic/190822/312719_1422.png/dy1","isVertical":0,"cate_id":917,"room_name":"贵族king！","show_status":"1","subject":"","show_time":"1566407476","owner_uid":"14916176","specific_catalog":"","specific_status":"0","vod_quality":"","nickname":"丶弗拉基米嫂","online":85816,"hn":85816,"url":"/312719","game_url":"/directory/game/ydzhy","game_name":"lol云顶之弈","child_id":1640,"avatar":"https://apic.douyucdn.cn/upload/avatar_v3/201902/6f047e08d5d2441c992bbd1f49f07259_big.jpg?rltime","avatar_mid":"https://apic.douyucdn.cn/upload/avatar_v3/201902/6f047e08d5d2441c992bbd1f49f07259_middle.jpg?rltime","avatar_small":"https://apic.douyucdn.cn/upload/avatar_v3/201902/6f047e08d5d2441c992bbd1f49f07259_small.jpg?rltime","jumpUrl":"","fans":"20183","ranktype":0,"is_noble_rec":0,"anchor_city":""}]
     */

    private int error;
    private List<DataBean> data;

    public int getError() {
        return error;
    }

    public void setError(int error) {
        this.error = error;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * room_id : 30
         * room_src : https://rpic.douyucdn.cn/live-cover/roomCover/cover_update/2019/08/22/08b1d7779fdbb61767948d86d37fe916.jpg/dy1
         * vertical_src : https://rpic.douyucdn.cn/live-cover/roomCover/cover_update/2019/08/22/08b1d7779fdbb61767948d86d37fe916.jpg/dy1
         * isVertical : 0
         * cate_id : 3
         * room_name : 【TI9】Mineski-Secret
         * show_status : 1
         * subject :
         * show_time : 1565318131
         * owner_uid : 1640
         * specific_catalog :
         * specific_status : 0
         * vod_quality :
         * nickname : DOTA2官方赛事
         * online : 4759431
         * hn : 4759431
         * url : /30
         * game_url : /directory/game/DOTA2
         * game_name : DOTA2
         * child_id : 95
         * avatar : https://apic.douyucdn.cn/upload/avatar_v3/201908/8d9b51c99a264e8492aaad36b1ee4355_big.jpg?rltime
         * avatar_mid : https://apic.douyucdn.cn/upload/avatar_v3/201908/8d9b51c99a264e8492aaad36b1ee4355_middle.jpg?rltime
         * avatar_small : https://apic.douyucdn.cn/upload/avatar_v3/201908/8d9b51c99a264e8492aaad36b1ee4355_small.jpg?rltime
         * jumpUrl :
         * fans : 863615
         * ranktype : 0
         * is_noble_rec : 0
         * anchor_city :
         */

        private String room_id;
        private String room_src;
        private String vertical_src;
        private int isVertical;
        private int cate_id;
        private String room_name;
        private String show_status;
        private String subject;
        private String show_time;
        private String owner_uid;
        private String specific_catalog;
        private String specific_status;
        private String vod_quality;
        private String nickname;
        private int online;
        private int hn;
        private String url;
        private String game_url;
        private String game_name;
        private int child_id;
        private String avatar;
        private String avatar_mid;
        private String avatar_small;
        private String jumpUrl;
        private String fans;
        private int ranktype;
        private int is_noble_rec;
        private String anchor_city;

        public String getRoom_id() {
            return room_id;
        }

        public void setRoom_id(String room_id) {
            this.room_id = room_id;
        }

        public String getRoom_src() {
            return room_src;
        }

        public void setRoom_src(String room_src) {
            this.room_src = room_src;
        }

        public String getVertical_src() {
            return vertical_src;
        }

        public void setVertical_src(String vertical_src) {
            this.vertical_src = vertical_src;
        }

        public int getIsVertical() {
            return isVertical;
        }

        public void setIsVertical(int isVertical) {
            this.isVertical = isVertical;
        }

        public int getCate_id() {
            return cate_id;
        }

        public void setCate_id(int cate_id) {
            this.cate_id = cate_id;
        }

        public String getRoom_name() {
            return room_name;
        }

        public void setRoom_name(String room_name) {
            this.room_name = room_name;
        }

        public String getShow_status() {
            return show_status;
        }

        public void setShow_status(String show_status) {
            this.show_status = show_status;
        }

        public String getSubject() {
            return subject;
        }

        public void setSubject(String subject) {
            this.subject = subject;
        }

        public String getShow_time() {
            return show_time;
        }

        public void setShow_time(String show_time) {
            this.show_time = show_time;
        }

        public String getOwner_uid() {
            return owner_uid;
        }

        public void setOwner_uid(String owner_uid) {
            this.owner_uid = owner_uid;
        }

        public String getSpecific_catalog() {
            return specific_catalog;
        }

        public void setSpecific_catalog(String specific_catalog) {
            this.specific_catalog = specific_catalog;
        }

        public String getSpecific_status() {
            return specific_status;
        }

        public void setSpecific_status(String specific_status) {
            this.specific_status = specific_status;
        }

        public String getVod_quality() {
            return vod_quality;
        }

        public void setVod_quality(String vod_quality) {
            this.vod_quality = vod_quality;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public int getOnline() {
            return online;
        }

        public void setOnline(int online) {
            this.online = online;
        }

        public int getHn() {
            return hn;
        }

        public void setHn(int hn) {
            this.hn = hn;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getGame_url() {
            return game_url;
        }

        public void setGame_url(String game_url) {
            this.game_url = game_url;
        }

        public String getGame_name() {
            return game_name;
        }

        public void setGame_name(String game_name) {
            this.game_name = game_name;
        }

        public int getChild_id() {
            return child_id;
        }

        public void setChild_id(int child_id) {
            this.child_id = child_id;
        }

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        public String getAvatar_mid() {
            return avatar_mid;
        }

        public void setAvatar_mid(String avatar_mid) {
            this.avatar_mid = avatar_mid;
        }

        public String getAvatar_small() {
            return avatar_small;
        }

        public void setAvatar_small(String avatar_small) {
            this.avatar_small = avatar_small;
        }

        public String getJumpUrl() {
            return jumpUrl;
        }

        public void setJumpUrl(String jumpUrl) {
            this.jumpUrl = jumpUrl;
        }

        public String getFans() {
            return fans;
        }

        public void setFans(String fans) {
            this.fans = fans;
        }

        public int getRanktype() {
            return ranktype;
        }

        public void setRanktype(int ranktype) {
            this.ranktype = ranktype;
        }

        public int getIs_noble_rec() {
            return is_noble_rec;
        }

        public void setIs_noble_rec(int is_noble_rec) {
            this.is_noble_rec = is_noble_rec;
        }

        public String getAnchor_city() {
            return anchor_city;
        }

        public void setAnchor_city(String anchor_city) {
            this.anchor_city = anchor_city;
        }
    }
}
