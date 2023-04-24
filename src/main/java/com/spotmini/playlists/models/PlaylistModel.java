package com.spotmini.playlists.models;

public class PlaylistModel {
    private String name;
    private long owner;

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
