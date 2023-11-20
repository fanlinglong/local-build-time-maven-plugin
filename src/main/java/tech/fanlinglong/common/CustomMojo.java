package tech.fanlinglong.common;

import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

/**
 * Custom Maven plugin to get local build time and pass it to maven-jar-plugin.
 */
//@Mojo(name = "custom-time")
@Mojo(
        name = "timestamp-property",
        defaultPhase = LifecyclePhase.COMPILE,
        threadSafe = true
)
public class CustomMojo extends AbstractDefinePropertyMojo {

    /**
     * The property to set.
     */
    @Parameter(property = "propertyName", defaultValue = "local.build.timestamp")
    private String propertyName;

    /**
     * The date/time pattern to be used. The values are as defined by the Java SimpleDateFormat class.
     */
    @Parameter(property = "pattern", defaultValue = "yyyy-MM-dd HH:mm:ss")
    private String pattern;

    /**
     * The zoneId to use for displaying time. The values are as defined by the Java {$link TimeZone} class.
     */
    @Parameter(property = "zoneId", defaultValue = "UTC+8")
    private String zoneId;

    public void execute() throws MojoExecutionException, MojoFailureException {

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(pattern);
        LocalDateTime now = LocalDateTime.now(ZoneId.of(zoneId));


        String dateTimeStr = now.format(dateTimeFormatter);
        getLog().info("Local build time: " + dateTimeStr);

//        System.out.println("========================================");
//        System.out.println("pattern:" + pattern);
//        System.out.println("timeZone:" + zoneId);
//        System.out.println("Local build time: " + dateTimeStr);
//        System.out.println("========================================");

        // Pass the timestamp to maven-jar-plugin
        this.defineProperty(propertyName, dateTimeStr);
    }
}