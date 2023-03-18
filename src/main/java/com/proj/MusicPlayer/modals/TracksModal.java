package com.proj.MusicPlayer.modals;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "track")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TracksModal {
    @Id
    @Indexed(unique = true, direction = IndexDirection.DESCENDING)
    private String id;

    private String title, media_url, cover_pic_url, caption;

    @DBRef
    private ArtistModal artistModal;

    @DBRef
    private GonerModal gonerModal;

}
