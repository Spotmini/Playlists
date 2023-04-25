package com.spotmini.playlists.models;

public class SongsModel {
    private String songArtist;
    private String songName;
    private String playlistName;
    private long ownerId;

    public String getSongArtist() {
        return songArtist;
    }

    public void setOwnerId(long ownerId) {
        this.ownerId = ownerId;
    }

    public long getOwnerId() {
        return ownerId;
    }

    public String getPlaylistName() {
        return playlistName;
    }


    public void setPlaylistName(String playlistName) {
        this.playlistName = playlistName;
    }

    public void setSongArtist(String songArtist) {
        this.songArtist = songArtist;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }
}
