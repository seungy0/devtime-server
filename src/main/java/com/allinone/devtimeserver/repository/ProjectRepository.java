package com.allinone.devtimeserver.repository;

import com.allinone.devtimeserver.domain.Project;

import java.util.List;
import java.util.Optional;

public interface ProjectRepository {
    Project save(Project project);
    Optional<Project> findById(Long id);
    Optional<Project> findByName(String name);
    List<Project> findAll();
}
