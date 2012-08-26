package org.gradle.tooling.model.generic;

import java.util.Collection;

/**
 * Defines a project dependency of a Java project.
 */
public interface GenericProjectDependency extends GenericDependency {
    /**
     * Returns the Java project associated with this dependency.
     *
     * @return the Java project associated with this dependency. This method
     *   never returns {@code null}.
     */
    public GenericJavaProject getProject();

    /**
     * Returns the sources required from this project to be compiled for the
     * project of which {@code GenericProjectDependency} is the dependency of.
     * <P>
     * Usually this returns the sources of this project but can be different
     * when configurations are specified explicitly.
     *
     * @return the sources required from this project to be compiled for the
     *   project of which {@code GenericProjectDependency} is the dependency of.
     *   This method never returns {@code null} but may return an empty
     *   collection.
     */
    public Collection<GenericContentRoot> getRequiredContent();
}
