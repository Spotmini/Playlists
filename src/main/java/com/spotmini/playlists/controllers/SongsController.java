package com.spotmini.playlists.controllers;

import com.spotmini.playlists.db.Song;
import com.spotmini.playlists.models.SongsModel;
import com.spotmini.playlists.repositories.PlaylistRepository;
import com.spotmini.playlists.repositories.SongsRepository;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

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
    private void addSong(@RequestBody SongsModel newSong) {
        var toBeAddedIn = playlistRepository.findByNameAndOwnerId(newSong.getPlaylistName(), newSong.getOwnerId());

        if (toBeAddedIn == null) return;

        songsRepository.save(
            new Song(toBeAddedIn, newSong.getSongArtist(), newSong.getSongName())
        );
    }

    @DeleteMapping
    private void deleteSong(@RequestBody SongsModel songToBeDeleted) {
        var toBeDeletedIn = playlistRepository.findByNameAndOwnerId(songToBeDeleted.getPlaylistName(), songToBeDeleted.getOwnerId());

        if (toBeDeletedIn == null) return;

        var toBeDeleted = songsRepository.findBySongNameAndPlaylist(songToBeDeleted.getSongName(), toBeDeletedIn);

        songsRepository.delete(toBeDeleted);

    }

    @KafkaListener(topics = "deleteSong", groupId = "playlists")
    private void deleteSong(HashMap<String, String> data) {
        var songName = data.get("songName");
        var songArtist = data.get("artistName");
        if(songName == null) {
            songsRepository.deleteAllBySongArtist(songArtist);
            return;
        }
        songsRepository.deleteAllBySongArtistAndSongName(songArtist, songName);
    }

}
