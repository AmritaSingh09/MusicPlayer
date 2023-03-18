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


    @RequestMapping(path = "/api/v1/admin/songs/artists/update/{ID}", method = RequestMethod.POST)
    public String updateArtist(@PathVariable String ID){

        return "";
    }


    @RequestMapping(path = "/api/v1/admin/songs/artists/delete/{ID}", method = RequestMethod.DELETE)
    public String deleteArtist(@PathVariable String ID){

        return "";
    }

    /**
     * CUD of GONERS
     */

    @RequestMapping(path = "/api/v1/admin/songs/goners/add", method = RequestMethod.POST)
    public String createGoners(@RequestBody GonerModal gonerModal){

        return "";
    }


    @RequestMapping(path = "/api/v1/admin/songs/goners/update/{ID}", method = RequestMethod.POST)
    public String updateGoners(@PathVariable String ID){

        return "";
    }


    @RequestMapping(path = "/api/v1/admin/songs/goners/delete/{ID}", method = RequestMethod.DELETE)
    public String deleteGoners(@PathVariable String ID){

        return "";
    }


    /**
     * CUD of TRACKS
     */

    @RequestMapping(path = "/api/v1/admin/songs/tracks/add", method = RequestMethod.POST)
    public String createTracks(@RequestBody TracksModal tracksModal){

        return "";
    }


    @RequestMapping(path = "/api/v1/admin/songs/tracks/update/{ID}", method = RequestMethod.POST)
    public String updateTracks(@PathVariable String ID){

        return "";
    }


    @RequestMapping(path = "/api/v1/admin/songs/tracks/delete/{ID}", method = RequestMethod.DELETE)
    public String deleteTracks(@PathVariable String ID){

        return "";
    }



}
