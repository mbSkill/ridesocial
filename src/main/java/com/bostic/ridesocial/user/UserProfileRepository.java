package com.bostic.ridesocial.user;

import com.bostic.ridesocial.user.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserProfileRepository extends JpaRepository<UserProfile, String> {
}