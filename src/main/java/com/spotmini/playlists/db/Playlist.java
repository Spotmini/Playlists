package com.spotmini.playlists.db;

import jakarta.persistence.*;

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
    private long owner_id;

    public Playlist(String name, long owner_id) {
        this.name = name;
        this.owner_id = owner_id;
    }

    protected Playlist() { }
}
