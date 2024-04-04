package com.poluectov.rvproject.repository.jpa;

import com.poluectov.rvproject.model.Message;
import com.poluectov.rvproject.repository.MessageRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface JpaMessageRepository extends CrudRepository<Message, Long> { }
