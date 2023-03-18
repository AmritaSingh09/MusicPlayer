package com.proj.MusicPlayer.repositories;

import com.proj.MusicPlayer.modals.RolesModal;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RoleRepo extends MongoRepository<RolesModal, String> {
    RolesModal findByRole(String roles);
}
