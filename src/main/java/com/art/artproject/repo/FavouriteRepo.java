package com.art.artproject.repo;

import com.art.artproject.entity.Favourite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FavouriteRepo extends JpaRepository<Favourite, Long> {
}
