package com.socials.ImageService.repository;

import com.socials.ImageService.entity.UserImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserImageRepo extends JpaRepository<UserImage,Integer> {
    Optional<UserImage> findByName(String name);

    Optional<UserImage> findByEmail(String fileName);
}
