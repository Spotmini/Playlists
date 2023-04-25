package com.spotmini.playlists.repositories;

import com.spotmini.playlists.db.Playlist;
import com.spotmini.playlists.db.Song;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SongsRepository extends JpaRepository<Song, Long> {
    Song findBySongNameAndPlaylist(String songName, Playlist playlist);
    void deleteAllBySongArtist(String artistName);
    void deleteAllBySongArtistAndSongName(String artistName, String songName);
}
