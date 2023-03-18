package com.proj.MusicPlayer.controllers;

import com.proj.MusicPlayer.modals.ArtistModal;
import com.proj.MusicPlayer.modals.GonerModal;
import com.proj.MusicPlayer.modals.TracksModal;
import org.springframework.web.bind.annotation.*;

@RestController
public class AdminController {


    /**
     * CUD of ARTISTS
     */

    @RequestMapping(name = "/api/v1/admin/songs/artists/add", method = RequestMethod.POST)
    public String createArtist(@RequestBody ArtistModal artistModal){

        return "";
    }


    @RequestMapping(name = "/api/v1/admin/songs/artists/update/{ID}", method = RequestMethod.POST)
    public String updateArtist(@RequestParam String ID){

        return "";
    }


    @RequestMapping(name = "/api/v1/admin/songs/artists/delete/{ID}", method = RequestMethod.DELETE)
    public String deleteArtist(@RequestParam String ID){

        return "";
    }

    /**
     * CUD of GONERS
     */

    @RequestMapping(name = "/api/v1/admin/songs/goners/add", method = RequestMethod.POST)
    public String createGoners(@RequestBody GonerModal gonerModal){

        return "";
    }


    @RequestMapping(name = "/api/v1/admin/songs/goners/update/{ID}", method = RequestMethod.POST)
    public String updateGoners(@RequestParam String ID){

        return "";
    }


    @RequestMapping(name = "/api/v1/admin/songs/goners/delete/{ID}", method = RequestMethod.DELETE)
    public String deleteGoners(@RequestParam String ID){

        return "";
    }


    /**
     * CUD of TRACKS
     */

    @RequestMapping(name = "/api/v1/admin/songs/tracks/add", method = RequestMethod.POST)
    public String createTracks(@RequestBody TracksModal tracksModal){

        return "";
    }


    @RequestMapping(name = "/api/v1/admin/songs/tracks/update/{ID}", method = RequestMethod.POST)
    public String updateTracks(@RequestParam String ID){

        return "";
    }


    @RequestMapping(name = "/api/v1/admin/songs/tracks/delete/{ID}", method = RequestMethod.DELETE)
    public String deleteTracks(@RequestParam String ID){

        return "";
    }



}
