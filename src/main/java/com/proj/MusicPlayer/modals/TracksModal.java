package com.proj.MusicPlayer.modals;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(value = "track")
public class TracksModal {
    @Id
    @Indexed(unique = true, direction = IndexDirection.DESCENDING)
    private String id;

    private String title, media_url, cover_pic_url, caption;

    @DBRef
    private ArtistModal artistModal;

    @DBRef
    private GonerModal gonerModal;

    public TracksModal(String id, String title, String media_url, String cover_pic_url, String caption, ArtistModal artistModal, GonerModal gonerModal) {
        this.id = id;
        this.title = title;
        this.media_url = media_url;
        this.cover_pic_url = cover_pic_url;
        this.caption = caption;
        this.artistModal = artistModal;
        this.gonerModal = gonerModal;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMedia_url() {
        return media_url;
    }

    public void setMedia_url(String media_url) {
        this.media_url = media_url;
    }

    public String getCover_pic_url() {
        return cover_pic_url;
    }

    public void setCover_pic_url(String cover_pic_url) {
        this.cover_pic_url = cover_pic_url;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public ArtistModal getArtistModal() {
        return artistModal;
    }

    public void setArtistModal(ArtistModal artistModal) {
        this.artistModal = artistModal;
    }

    public GonerModal getGonerModal() {
        return gonerModal;
    }

    public void setGonerModal(GonerModal gonerModal) {
        this.gonerModal = gonerModal;
    }
}
