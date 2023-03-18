package com.proj.MusicPlayer.repositories;

import com.proj.MusicPlayer.modals.ArtistModal;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ArtistRepo extends MongoRepository<ArtistModal, String> {
    ArtistModal findArtistByName(String name);
}
