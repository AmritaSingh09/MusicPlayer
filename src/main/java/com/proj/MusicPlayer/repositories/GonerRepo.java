package com.proj.MusicPlayer.repositories;

import com.proj.MusicPlayer.modals.ArtistModal;
import com.proj.MusicPlayer.modals.GonerModal;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface GonerRepo extends MongoRepository<GonerModal, String> {
    GonerModal findArtistByName(String name);
}
