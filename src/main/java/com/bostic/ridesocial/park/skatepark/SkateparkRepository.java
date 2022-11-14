package com.bostic.ridesocial.park.skatepark;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkateparkRepository extends JpaRepository<Skatepark, String> {
}