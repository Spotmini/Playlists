package com.spotmini.playlists.models;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

import java.util.List;

public class PlaylistModel {
    private String name;
    private long owner;
    @OneToMany
    @JoinColumn(referencedColumnName = "songs.playlist_id")
    private List<SongsModel> songs;

    public List<SongsModel> getSongs() {
        return songs;
    }

    public void setSongs(List<SongsModel> songs) {
        this.songs = songs;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getOwner() {
        return owner;
    }

    public void setOwner(long owner) {
        this.owner = owner;
    }
}
