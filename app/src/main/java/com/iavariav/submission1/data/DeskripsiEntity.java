package com.iavariav.submission1.data;

public class DeskripsiEntity {
    private String id;
    private String imageURL;
    private String title;
    private String overview;
    private String releaseDate;

    public DeskripsiEntity(String id, String imageURL, String title, String overview, String releaseDate) {
        this.id = id;
        this.imageURL = imageURL;
        this.title = title;
        this.overview = overview;
        this.releaseDate = releaseDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImageURL() {
        return imageURL;
    }


    public String gettitle() {
        return title;
    }

    public String getDeskripsi() {
        return overview;
    }

    public String getreleaseDate() {
        return releaseDate;
    }
}
