package org.gradle.tooling.model.generic;

import java.io.File;

/**
 * Defines the directory of a Gradle project to which tasks are to be generate
 * their output.
 */
public interface GenericProjectOutput {
    /**
     * The root directory containing the output of every task of the associated
     * project. This is the directory removed by the "clean" task. Note that
     * the returned directory does not need to exist.
     *
     * @return the root directory containing the output of every task of the
     *   associated project. This method never returns {@code null} but the
     *   returned directory may not need to exist.
     */
    public File getOutputRoot();

    /**
     * The directory containing the compiled sources of the associated project.
     * This directory should be within the {@link #getOutputRoot() root directory}
     * but try not to rely on this for correctness. Note that the returned
     * directory does not need to exist.
     *
     * @return the directory containing the compiled sources of the associated
     *   project. This method never returns {@code null} but the returned
     *   directory may not need to exist.
     */
    public File getBuildOutput();

    /**
     * The directory containing the compiled test sources of the associated
     * project. This directory should be within the
     * {@link #getOutputRoot() root directory} but try not to rely on this for
     * correctness. Note that the returned directory does not need to exist.
     *
     * @return the directory containing the compiled test sources of the
     *   associated project. This method never returns {@code null} but the
     *   returned directory may not need to exist.
     */
    public File getTestBuildOutput();
}
