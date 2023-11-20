package tech.fanlinglong.common;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.project.MavenProject;

public abstract class AbstractDefinePropertyMojo extends AbstractMojo {
    /**
     * The maven project
     */
    @Parameter(readonly = true, defaultValue = "${project}")
    protected MavenProject project;

    protected void defineProperty(String name, String value) {
        if (getLog().isDebugEnabled()) {
            getLog().debug("define property " + name + " = \"" + value + "\"");
        }

        project.getProperties().put(name, value);
    }

    /**
     * Get the current project instance.
     *
     * @return the project
     */
    public MavenProject getProject() {
        return this.project;
    }
}