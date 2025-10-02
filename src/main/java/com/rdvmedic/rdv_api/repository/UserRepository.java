package com.rdvmedic.rdv_api.repository;


public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}

