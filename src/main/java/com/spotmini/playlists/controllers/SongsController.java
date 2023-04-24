package com.spotmini.playlists.controllers;

import com.spotmini.playlists.db.Song;
import com.spotmini.playlists.models.SongsModel;
import com.spotmini.playlists.repositories.PlaylistRepository;
import com.spotmini.playlists.repositories.SongsRepository;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/songs")
@EnableKafka
public class SongsController {
    private SongsRepository songsRepository;
    private PlaylistRepository playlistRepository;
    private RestTemplate restTemplate;

    public SongsController(SongsRepository repository, PlaylistRepository playlistRepository, RestTemplate restTemplate) {
        this.songsRepository = repository;
        this.playlistRepository = playlistRepository;
        this.restTemplate = restTemplate;
    }

    @PostMapping
    private void addSong(@RequestBody SongsModel newSong, @RequestParam String playlistName, @RequestParam long playlistOwner) {
        var toBeAddedIn = playlistRepository.findByNameAndOwnerId(playlistName, playlistOwner);

        if (toBeAddedIn == null) return;

        songsRepository.save(
            new Song(toBeAddedIn, newSong.getSongArtist(), newSong.getSongName())
        );
    }

    @DeleteMapping
    private void deleteSong(@RequestBody SongsModel songToBeDeleted, @RequestParam String playlistName, @RequestParam long playlistOwner) {
        var toBeDeletedIn = playlistRepository.findByNameAndOwnerId(playlistName, playlistOwner);

        if (toBeDeletedIn == null) return;

        var toBeDeleted = songsRepository.findBySongNameAndPlaylist(songToBeDeleted.getSongName(), toBeDeletedIn);

        songsRepository.delete(toBeDeleted);

    }

}
