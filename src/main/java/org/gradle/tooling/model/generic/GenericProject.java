package org.gradle.tooling.model.generic;

import java.io.File;
import java.util.Collection;

/**
 * Defines a generic Gradle project.
 *
 * @see GenericJavaProject
 */
public interface GenericProject {
    /**
     * Returns the unique name of this project in the project hierarchy.
     * This name might be used in a gradle script to refer to the project.
     * For example: ":apps:my-app".
     *
     * @return the unique name of this project in the project hierarchy. This
     *   method never return {@code null}.
     */
    public String getUniqueName();

    /**
     * Returns the last part of the {@link #getUniqueName() unique name} of this
     * project. That is, the value after the last ':' character.
     *
     * @return the last part of the {@link #getUniqueName() unique name} of this
     *   project. This method never returns {@code null}.
     */
    public String getSimpleName();

    /**
     * Returns the directory of this project. This is the directory where the
     * build script can be found (if there is any).
     *
     * @return the directory of this project. This method never returns
     *   {@code null}.
     */
    public File getProjectDirectory();

    /**
     * Returns the path to the build script or {@code null} if there is no
     * build script for this project. The returned build script file may not
     * necessarily exists.
     *
     * @return the path to the build script or {@code null} if there is no
     *   build script for this project
     */
    public File getBuildScript();

    /**
     * Returns the settings file (settings.gradle) of this project or
     * {@code null} if there is no settings file for this project. The settings
     * file is the same for every project in a project hierarchy.
     *
     * @return the settings file (settings.gradle) of this project or
     *   {@code null} if there is no settings file for this project
     */
    public File getSettingsFile();

    /**
     * Returns the tasks configured in the build script of this Gradle project.
     *
     * @return the tasks configured in the build script of this Gradle project.
     *   This method never returns {@code null} but may return an empty
     *   collection.
     */
    public Collection<GenericTask> getTasks();

    /**
     * Returns the parent project of this project. The parent project can
     * usually (but not necessarily) be found in the parent directory of this
     * project's directory.
     *
     * @return the parent project of this project or {@code null} if this
     *   project is the root project
     */
    public GenericProject getParent();

    /**
     * Returns the child projects of this project. The child projects can
     * usually (but not necessarily) be found in the subdirectories of this
     * project's directory.
     *
     * @return the child projects of this project. This method may never return
     *   {@code null} but may return an empty collection.
     */
    public Collection<GenericProject> getChildren();
}
