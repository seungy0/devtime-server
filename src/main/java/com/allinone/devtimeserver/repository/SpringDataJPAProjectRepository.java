package com.allinone.devtimeserver.repository;

import com.allinone.devtimeserver.domain.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataJPAProjectRepository extends JpaRepository<Project, Long>, ProjectRepository {
}
