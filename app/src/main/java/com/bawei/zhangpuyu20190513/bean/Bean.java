package com.bawei.zhangpuyu20190513.bean;

import java.util.List;

public class Bean {

    private List<ItemsBean> items;

    public List<ItemsBean> getItems() {
        return items;
    }

    public void setItems(List<ItemsBean> items) {
        this.items = items;
    }

    public static class ItemsBean {
        /**
         * type : 0
         * title : 这三家美国律所为什么要调查京东？
         * desc : Rosen、Schall、Pomerantz三家美国律师事务所分别在官网宣布，将调查京东是否失实披露刘强东案情
         * image : https://img.huxiucdn.com/article/cover/201809/05/214458200889.jpg?imageView2/1/w/710/h/400/|imageMogr2/strip/interlace/1/quality/85/format/jpg
         * images : []
         */

        private int type;
        private String title;
        private String desc;
        private String image;
        private List<?> images;

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public List<?> getImages() {
            return images;
        }

        public void setImages(List<?> images) {
            this.images = images;
        }
    }
}
