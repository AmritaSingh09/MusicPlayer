package com.proj.MusicPlayer.modals;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "artists")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ArtistModal {

    @Id
    @Indexed(unique = true, direction = IndexDirection.DESCENDING)
    private String id;
    private String name;
    private String photo_url;

}
