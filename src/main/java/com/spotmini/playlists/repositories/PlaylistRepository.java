package com.spotmini.playlists.repositories;

import com.spotmini.playlists.db.Playlist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaylistRepository extends JpaRepository<Playlist, Long> {
}
