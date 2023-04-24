package com.spotmini.playlists.db;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "playlists")
public class Playlist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "owner_id")
    private long ownerId;

    @OneToMany(mappedBy = "playlist")
    private List<Song> songs;

    public Playlist(String name, long owner_id) {
        this.name = name;
        this.ownerId = owner_id;
    }

    protected Playlist() { }
}
