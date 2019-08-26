package com.dongnao.live.live2.list;

import java.util.List;

/**
 * 父频道
 */
public class ParentList {

    /**
     * error : 0
     * data : [{"cate_id":"1","cate_name":"网游竞技","short_name":"PCgame","push_ios":"1","push_show":"0","push_vertical_screen":"0","push_nearby":"0"},{"cate_id":"15","cate_name":"单机热游","short_name":"djry","push_ios":"1","push_show":"0","push_vertical_screen":"0","push_nearby":"0"},{"cate_id":"9","cate_name":"手游休闲","short_name":"syxx","push_ios":"1","push_show":"0","push_vertical_screen":"0","push_nearby":"0"},{"cate_id":"2","cate_name":"娱乐天地","short_name":"yl","push_ios":"1","push_show":"0","push_vertical_screen":"0","push_nearby":"0"},{"cate_id":"8","cate_name":"颜值","short_name":"yz","push_ios":"1","push_show":"0","push_vertical_screen":"1","push_nearby":"1"},{"cate_id":"11","cate_name":"科技教育","short_name":"kjjy","push_ios":"1","push_show":"0","push_vertical_screen":"0","push_nearby":"0"},{"cate_id":"18","cate_name":"语音互动","short_name":"voice","push_ios":"1","push_show":"0","push_vertical_screen":"0","push_nearby":"1"},{"cate_id":"13","cate_name":"正能量","short_name":"znl","push_ios":"1","push_show":"0","push_vertical_screen":"0","push_nearby":"0"}]
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
         * cate_id : 1
         * cate_name : 网游竞技
         * short_name : PCgame
         * push_ios : 1
         * push_show : 0
         * push_vertical_screen : 0
         * push_nearby : 0
         */

        private String cate_id;
        private String cate_name;
        private String short_name;
        private String push_ios;
        private String push_show;
        private String push_vertical_screen;
        private String push_nearby;

        public String getCate_id() {
            return cate_id;
        }

        public void setCate_id(String cate_id) {
            this.cate_id = cate_id;
        }

        public String getCate_name() {
            return cate_name;
        }

        public void setCate_name(String cate_name) {
            this.cate_name = cate_name;
        }

        public String getShort_name() {
            return short_name;
        }

        public void setShort_name(String short_name) {
            this.short_name = short_name;
        }

        public String getPush_ios() {
            return push_ios;
        }

        public void setPush_ios(String push_ios) {
            this.push_ios = push_ios;
        }

        public String getPush_show() {
            return push_show;
        }

        public void setPush_show(String push_show) {
            this.push_show = push_show;
        }

        public String getPush_vertical_screen() {
            return push_vertical_screen;
        }

        public void setPush_vertical_screen(String push_vertical_screen) {
            this.push_vertical_screen = push_vertical_screen;
        }

        public String getPush_nearby() {
            return push_nearby;
        }

        public void setPush_nearby(String push_nearby) {
            this.push_nearby = push_nearby;
        }
    }
}
