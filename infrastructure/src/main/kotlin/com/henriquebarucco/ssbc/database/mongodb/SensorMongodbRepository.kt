package com.henriquebarucco.ssbc.database.mongodb

import com.henriquebarucco.ssbc.database.mongodb.document.SensorDocument
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.mongodb.repository.MongoRepository

interface SensorMongodbRepository : MongoRepository<SensorDocument, String>
