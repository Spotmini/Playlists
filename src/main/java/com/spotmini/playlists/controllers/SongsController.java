package com.spotmini.playlists.controllers;

import com.spotmini.playlists.db.Song;
import com.spotmini.playlists.models.PlaylistModel;
import com.spotmini.playlists.models.SongsModel;
import com.spotmini.playlists.repositories.PlaylistRepository;
import com.spotmini.playlists.repositories.SongsRepository;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/songs")
@EnableKafka
public class SongsController {
    private SongsRepository repository;
    private PlaylistRepository playlistRepository;

    public SongsController(SongsRepository repository, PlaylistRepository playlistRepository) {
        this.repository = repository;
        this.playlistRepository = playlistRepository;
    }

    @PostMapping
    private void addSong(@RequestBody SongsModel newSong, @RequestParam String playlistName, @RequestParam long playlistOwner) {
        var toBeAddedIn = playlistRepository.findByNameAndOwnerId(playlistName, playlistOwner);

        if (toBeAddedIn == null) return;

        repository.save(
            new Song(toBeAddedIn, newSong.getSongArtist(), newSong.getSongName())
        );
    }

//    @DeleteMapping
//    private void deleteSong(@RequestBody SongsModel songToBeDeleted, PlaylistModel) {
//
//    }
}
