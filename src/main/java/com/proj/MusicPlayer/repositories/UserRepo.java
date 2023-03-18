package com.proj.MusicPlayer.repositories;

import com.proj.MusicPlayer.modals.UserDetailModal;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepo extends MongoRepository<UserDetailModal, String> {
    UserDetailModal findByEmail(String emailId);
}
