package org.gradle.tooling.model.generic;

import java.util.Collections;
import java.util.EnumSet;
import java.util.Set;

/**
 * Defines the dependency of a Java project.
 *
 * @see GenericJavaProject
 * @see GenericBinaryDependency
 * @see GenericProjectDependency
 */
public interface GenericDependency {
    /**
     * Returns for what task this dependency is required.
     *
     * @return for what task this dependency is required. This method may never
     *   return {@code null}.
     */
    public Kind getKind();

    /**
     * The kind of task a dependency is required for.
     */
    public enum Kind {
        /**
         * Defines that the dependency is needed for compiling the sources of
         * the project.
         */
        COMPILE(EnumSet.noneOf(Kind.class)),
        /**
         * Defines that the dependency is needed for executing a compiled
         * project.
         */
        RUNTIME(EnumSet.of(COMPILE)),
        /**
         * Defines that the dependency is needed for compiling the test sources
         * of the project.
         */
        TEST(EnumSet.of(COMPILE)),
        /**
         * Defines that the dependency is needed for executing the unit tests of
         * a compiled project.
         */
        TEST_RUNTIME(EnumSet.of(COMPILE, TEST, RUNTIME)),
        /**
         * Defines that it is not know for what these dependencies are needed.
         */
        OTHER(EnumSet.of(COMPILE, TEST, RUNTIME, TEST_RUNTIME));

        private final Set<Kind> inherited;

        private Kind(Set<Kind> inherited) {
            this.inherited = Collections.unmodifiableSet(inherited);
        }

        /**
         * Returns the kind of dependencies that are also needed for this kind
         * of dependency. For example: {@link #TEST test} dependencies also
         * require the {@link #COMPILE compile time} dependencies.
         *
         * @return the kind of dependencies that are also needed for this kind
         *   of dependency. this method never returns {@code null} but may
         *   return an empty set.
         */
        public Set<Kind> getInherited() {
            return inherited;
        }
    }
}
