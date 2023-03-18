package com.proj.MusicPlayer.controllers;

import com.proj.MusicPlayer.modals.GonerModal;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminControllerOne {


    @PostMapping(path = "/api/v1/admin/songs/goners/add",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createGoners(@RequestBody GonerModal gonerModal){
        return ResponseEntity.ok("ok");
    }

    @PostMapping(path = "/api/v1/admin/songs/artists/update/{ID}",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateArtists(@PathVariable GonerModal ID){
        return ResponseEntity.ok("ok");
    }
}
