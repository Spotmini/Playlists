package com.spotmini.playlists.controllers;

import com.spotmini.playlists.db.Playlist;
import com.spotmini.playlists.models.PlaylistModel;
import com.spotmini.playlists.repositories.PlaylistRepository;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/playlists")
@EnableKafka
public class PlaylistsController {
    private PlaylistRepository repository;

    public PlaylistsController(PlaylistRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    private void addPlaylist(@RequestBody PlaylistModel newPlaylist) {
        repository.save(new Playlist(newPlaylist.getName(), newPlaylist.getOwner()));
    }

    @DeleteMapping
    private void deletePlaylist(@RequestBody PlaylistModel playlistToDelete) {
        var toBeDeleted = repository.findByNameAndOwnerId(playlistToDelete.getName(), playlistToDelete.getOwner());
        repository.delete(toBeDeleted);
    }
}
