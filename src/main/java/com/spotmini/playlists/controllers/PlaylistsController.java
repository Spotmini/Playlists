package com.spotmini.playlists.controllers;

import com.spotmini.playlists.db.Playlist;
import com.spotmini.playlists.models.PlaylistModel;
import com.spotmini.playlists.repositories.PlaylistRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/playlists")
public class PlaylistsController {
    private PlaylistRepository repository;

    public PlaylistsController(PlaylistRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    private void addPlaylist(@RequestBody PlaylistModel newPlaylist) {
        repository.save(new Playlist(newPlaylist.getName(), newPlaylist.getOwner()));
    }
}
