package com.poluectov.rvproject.repository.jpa;

import com.poluectov.rvproject.model.Issue;
import com.poluectov.rvproject.repository.IssueRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface JpaIssueRepository extends CrudRepository<Issue, Long> { }
