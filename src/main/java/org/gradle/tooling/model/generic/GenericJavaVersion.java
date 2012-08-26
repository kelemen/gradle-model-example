package org.gradle.tooling.model.generic;

/**
 * Defines a version of Java.
 */
public interface GenericJavaVersion {
    /**
     * Returns the version of Java as a string. The format of the string is
     * the same as the values returned by the
     * {@code System.getProperty("java.version")} invocation. For example:
     * "1.7.0_05".
     *
     * @return the version of Java as a string. This method may never return
     *   {@code null}.
     */
    public String getVersionString();

    /**
     * Returns the second number in the {@link #getVersionString() version string}.
     * That is, for "1.7.0._05", this method return 7.
     *
     * @return the second number in the {@link #getVersionString() version string}
     */
    public int getMajorVersion();
}
