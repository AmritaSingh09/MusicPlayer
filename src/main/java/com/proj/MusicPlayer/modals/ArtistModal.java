package com.proj.MusicPlayer.modals;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(value = "artists")
public class ArtistModal {

    @Id
    @Indexed(unique = true, direction = IndexDirection.DESCENDING)
    private String id;

    private String name;
    private String photo_url;

    public ArtistModal(String id, String name, String photo_url) {
        this.id = id;
        this.name = name;
        this.photo_url = photo_url;
    }

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

    public String getPhoto_url() {
        return photo_url;
    }

    public void setPhoto_url(String photo_url) {
        this.photo_url = photo_url;
    }
}
