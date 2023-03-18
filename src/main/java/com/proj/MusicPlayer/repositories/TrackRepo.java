package com.proj.MusicPlayer.repositories;

import com.proj.MusicPlayer.modals.ArtistModal;
import com.proj.MusicPlayer.modals.GonerModal;
import com.proj.MusicPlayer.modals.TracksModal;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TrackRepo extends MongoRepository<TracksModal, String> {
    TracksModal findArtistByTitle(String title);

}
