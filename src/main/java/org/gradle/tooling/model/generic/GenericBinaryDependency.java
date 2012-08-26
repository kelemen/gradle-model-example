package org.gradle.tooling.model.generic;

import java.io.File;
import java.io.IOException;
import org.jtrim.cancel.CancellationToken;

/**
 * Defines a compiled dependency of a Java project. This is usually a jar file
 * but can be a directory as well.
 *
 * @see GenericJavaProject
 */
public interface GenericBinaryDependency extends GenericDependency {
    /**
     * Returns the file or directory containing the dependency of the associated
     * project. This method may either return a file of a directory.
     *
     * @return the file or directory containing the dependency of the associated
     *   project. This method never returns {@code null}.
     */
    public File getFile();

    /**
     * Retrieves the sources of this dependency if they are available.
     * This method blocks and waits until the sources were retrieved or this
     * operation has been canceled.
     *
     * @param cancelToken  the {@code CancellationToken} which is to be checked
     *   if the current operation is to be canceled. This argument cannot be
     *   {@code null}.
     * @return the sources of this dependency or {@code null} if they are not
     *   available. The result can be either a file or a directory.
     *
     * @throws org.jtrim.cancel.OperationCanceledException thrown if the current
     *   operation could not be completed because cancellation has been
     *   requested
     * @throws IOException thrown if the sources could not be collected
     *   because of some external error. This exception is not thrown if the
     *   sources are simply not available.
     */
    public File tryResolveSources(CancellationToken cancelToken) throws IOException;

    /**
     * Retrieves the apidoc of this dependency if it is available.
     * This method blocks and waits until the apidoc was retrieved or this
     * operation has been canceled.
     *
     * @param cancelToken  the {@code CancellationToken} which is to be checked
     *   if the current operation is to be canceled. This argument cannot be
     *   {@code null}.
     * @return the apidoc of this dependency or {@code null} if it is not
     *   available. The result can be either a file or a directory.
     *
     * @throws org.jtrim.cancel.OperationCanceledException thrown if the current
     *   operation could not be completed because cancellation has been
     *   requested
     * @throws IOException thrown if the apidoc could not be collected
     *   because of some external error. This exception is not thrown if the
     *   sources are simply not available.
     */
    public File tryResolveJavadoc(CancellationToken cancelToken) throws IOException;
}
