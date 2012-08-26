package org.gradle.tooling.model.generic;

import java.io.IOException;
import java.util.Collection;
import org.jtrim.cancel.CancellationToken;

/**
 * Defines a Java based Gradle project.
 */
public interface GenericJavaProject extends GenericProject {
    /**
     * Returns the Java language version to which the sources of this project
     * are compiled against. For example, if this value is lower than "1.5", the
     * project may not use generics in its sources.
     *
     * @return the java version to which the sources of this project are
     *   compiled against. This method may never returns {@code null}.
     */
    public GenericJavaVersion getSourceLevel();

    /**
     * Returns the Java version to which class files are generated for.
     *
     * @return the Java version to which class files are generated for. This
     *   method may never return {@code null}.
     */
    public GenericJavaVersion getTargetVersion();

    /**
     * Returns the directories of this project containing its source, resources,
     * etc.
     *
     * @return the directories of this project containing its source, resources,
     *   etc. This method may never return {@code null} but may return an empty
     *   collection for an empty Java project.
     */
    public Collection<GenericContentRoot> getContentRoots();

    /**
     * Returns the directories to which Gradle tasks will write their output.
     * Most notably, the directories of the compiled sources.
     *
     * @return the directories to which Gradle tasks will write their output.
     *   This method may never return {@code null}.
     */
    public GenericProjectOutput getOutput();

    /**
     * Collects all the dependencies of this project. This method blocks and
     * waits until all the dependencies were collected or this method has been
     * canceled.
     * <P>
     * This method will collect every dependency of a specific group (e.g.: test
     * compile). That is, for "test compile" dependencies, this method will
     * return compile time dependencies as well. The dependencies inherited
     * from other dependency groups are defined by the
     * {@link GenericDependency.Kind#getInherited()} method.
     * <P>
     * <B>Adjustment note</B>: This method may need to be modified so that it
     * takes an argument which is the resolver of the sources, such like a
     * {@code ProjectConnection}. Also this method relies on the JTrim
     * library which is not an option for Gradle because (JTrim is Java 7
     * based).
     * <P>
     * It might be reasonable to be able specify what to do when a dependency
     * cannot be retrieved: Continue retrieve other dependencies or fail with an
     * {@code IOException}.
     *
     * @param cancelToken the {@code CancellationToken} which is to be checked
     *   if the current operation is to be canceled. This argument cannot be
     *   {@code null}.
     * @param dependencyKind the type of the dependencies to be collected.
     *   This argument cannot be {@code null}.
     * @param recursive {@code true} if transitive dependencies of dependencies
     *   must also be returned, {@code false} if only the direct dependencies
     *   of this project are to be returned
     * @return the collected dependencies of the project. This method never
     *   returns {@code null} but may return an empty collection.
     *
     * @throws org.jtrim.cancel.OperationCanceledException thrown if the current
     *   operation could not be completed because cancellation has been
     *   requested
     * @throws IOException thrown if the dependencies could not be collected
     *   because of some external error or missing dependencies
     *
     * @see GenericBinaryDependency
     * @see GenericProjectDependency
     */
    public Collection<GenericDependency> resolveDependencies(
            CancellationToken cancelToken,
            GenericDependency.Kind dependencyKind,
            boolean recursive) throws IOException;
}
