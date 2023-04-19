package com.spotmini.playlists.db;
import jakarta.persistence.*;

@Entity
@Table(name = "songs")
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "playlist_id")
    private long playlist_id;

    @Column(name = "song_artist")
    private String song_artist;

    @Column(name = "song_name")
    private String song_name;

    public Song(long playlist_id, String song_artist, String song_name) {
        this.playlist_id = playlist_id;
        this.song_artist = song_artist;
        this.song_name = song_name;
    }

    protected Song() { }
}
