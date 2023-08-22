package com.allinone.devtimeserver.service;

import com.allinone.devtimeserver.domain.Project;
import com.allinone.devtimeserver.repository.ProjectRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional
public class ProjectService {

    private final ProjectRepository projectRepository;

    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }


    public Project create(Project project) {
        return projectRepository.save(project);
    }

    public Optional<Project> findOne(Long projectId) {
        return projectRepository.findById(projectId);
    }
}
