package org.gradle.tooling.model.generic;

import java.io.File;
import java.nio.charset.Charset;
import java.util.Set;

/**
 * Defines a directory of a Java project containing some of its sources,
 * resources, etc.
 */
public interface GenericContentRoot {
    /**
     * Returns the type of the content of this directory.
     *
     * @return the type of the content of this directory. This method never
     *   returns {@code null}.
     */
    public Kind getContentKind();

    /**
     * Returns the name for this content directory. This value might be used to
     * distinguish between content directories of the same type. This value
     * is not required to be unique.
     *
     * @return the name for this content directory. This method may never return
     *   {@code null} and should always have a reasonable default.
     */
    public String getContentName();

    /**
     * Returns the set of directories to be excluded from the content directory
     * returned by the {@link #getContentDir()} method. These directories need
     * to be the subdirectories of the content directory but clients need to
     * be able to handle the case when some of them are not.
     * <P>
     * The content of this directory is expected to be used recursively,
     * including its subdirectories.
     *
     * @return the set of directories to be excluded from the content directory
     *   returned by the {@link #getContentDir()} method. This method never
     *   returns {@code null} but may be an empty set.
     */
    public Set<File> getExcludedDirs();

    /**
     * Returns the content directory which is expected to be used recursively
     * with its subdirectories.
     *
     * @return the content directory. This method never returns {@code null}.
     */
    public File getContentDir();

    /**
     * Returns the encoding of the files in this content root.
     *
     * @return the encoding of the files in this content root. This method may
     *   never return {@code null}.
     */
    public Charset getSourceEncoding();

    /**
     * The possible types of content directories.
     */
    public enum Kind {
        /**
         * This type means that the directory contains sources, required for
         * compiling the project.
         */
        SOURCE,
        /**
         * This type means that the directory contains sources, required for
         * unit testing.
         */
        TEST,
        /**
         * This type means that the directory contains files, needed on the
         * runtime class path.
         */
        RESOURCE,
        /**
         * This type means that the directory contains files, needed on the
         * runtime class path when unit testing.
         */
        TEST_RESOURCE,
        /**
         * This type means that the directory contains unknown files probably
         * not required for any phases.
         */
        OTHER
    }
}
