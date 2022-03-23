package me.sdkssh.gitprofilemanager.components;

import com.intellij.openapi.components.ProjectComponent;
import com.intellij.openapi.project.Project;
import me.sdkssh.gitprofilemanager.GitProfileManager;

public class GitProfileProjectComponent implements ProjectComponent {
    private Project project;

    public GitProfileProjectComponent(Project project){
        this.project = project;
    }

    @Override
    public void projectOpened() {
        ProjectComponent.super.projectOpened();
        GitProfileManager.load();
    }

    @Override
    public void projectClosed() {
        ProjectComponent.super.projectClosed();
    }
}
