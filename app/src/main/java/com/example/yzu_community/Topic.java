package com.example.yzu_community;

public class Topic {
    private String name;
    private  int imageId;
    private String hot;

    public Topic(String name,int imageId,String hot){
        this.name=name;
        this.imageId=imageId;
        this.hot=hot;
    }
    public String getName(){
        return name;
    }
    public int getImageId(){

        return imageId;
    }
    public String getHot() {
        return hot;
    }
}
