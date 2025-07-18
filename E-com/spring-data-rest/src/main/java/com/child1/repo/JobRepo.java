package com.child1.repo;

import com.child1.modal.JobModal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface JobRepo  extends JpaRepository<JobModal, Long> {




}
