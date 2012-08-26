package org.gradle.tooling.model.generic;

/**
 * Defines a task of a Gradle project.
 */
public interface GenericTask {
    /**
     * Returns the fully qualified name of this task. For example:
     * ":my-project:build". Passing this string to Gradle will only execute
     * this task and the tasks this task depends on.
     *
     * @return the fully qualified name of this task. This method may never
     *   return {@code null}.
     */
    public String getUniqueName();

    /**
     * Returns the last part of the fully qualified name of this task. For
     * example: "build". Passing this string to Gradle will execute
     * this task and tasks of child projects with the same simple name (and
     * their dependencies).
     *
     * @return the last part of the fully qualified name of this task. This
     *   method may never return {@code null}.
     */
    public String getSimpleName();

    /**
     * Returns the description of this task or {@code null} if no description
     * was specified for this task.
     *
     * @return the description of this task or {@code null} if no description
     *   was specified for this task
     */
    public String getDescription();

    /**
     * Returns the name of the group this task is part of or {@code null} if
     * this task is not part of any group.
     *
     * @return the name of the group this task is part of or {@code null} if
     *   this task is not part of any group
     */
    public String getGroup();
}
