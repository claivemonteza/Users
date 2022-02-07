package com.example.demo.access.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.access.domain.Profile;

public interface ProfileRepository extends JpaRepository<Profile, Long> {

}
