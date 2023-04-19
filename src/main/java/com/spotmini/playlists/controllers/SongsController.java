package com.spotmini.playlists.controllers;

import com.spotmini.playlists.db.Song;
import com.spotmini.playlists.models.SongsModel;
import com.spotmini.playlists.repositories.SongsRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/songs")
public class SongsController {
    private SongsRepository repository;

    public SongsController(SongsRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    private void addSong(@RequestBody SongsModel newSong) {
        repository.save(new Song(newSong.getPlaylist_id(),
                                newSong.getSong_artist(),
                                newSong.getSong_name()));
    }
}
