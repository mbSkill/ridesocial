package com.bostic.ridesocial.park.skatepark;

import com.bostic.ridesocial.park.skatepark.Skatepark;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkateparkRepository extends JpaRepository<Skatepark, String> {
}