package com.example.yzu_community;

public class ListCardView {
    private String tittle;
    private  int imageId;
    private String author;
    private String date;

    public ListCardView(String tittle, int imageId, String author,String date){
        this.tittle=tittle;
        this.imageId=imageId;
        this.author=author;
        this.date=date;
    }
    public String getTittle(){

        return tittle;
    }
    public int getImageId(){

        return imageId;
    }
    public String getAuthor(){

        return author;
    }
    public String getDate() {

        return date;
    }
}
