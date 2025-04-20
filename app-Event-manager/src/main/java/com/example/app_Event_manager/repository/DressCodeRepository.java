package com.example.app_Event_manager.repository;

import com.example.app_Event_manager.model.DressCode;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DressCodeRepository extends MongoRepository<DressCode, String> {
    DressCode findById(UUID id);
}
