package com.spotmini.playlists.db;
import jakarta.persistence.*;

@Entity
@Table(name = "songs")
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

//    @Column(name = "playlist_id")
//    private long playlistId;

    @Column(name = "song_artist")
    private String songArtist;

    @Column(name = "song_name")
    private String songName;

    @ManyToOne
    @JoinColumn(name = "playlist_id")
    private Playlist playlist;

    public Song(Playlist playlist, String song_artist, String song_name) {
        //this.playlistId = playlist_id;
        this.songArtist = song_artist;
        this.songName = song_name;
        this.playlist = playlist;
    }

    protected Song() { }
}
