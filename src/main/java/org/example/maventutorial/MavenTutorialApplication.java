package org.example.maventutorial;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;

/**
 * An application that responds to all requests under its context root.
 */
@ApplicationPath("/")
public final class MavenTutorialApplication extends ResourceConfig {

    /**
     * The constructor for the application that includes the packages that can
     * serve the requests.
     */
    public MavenTutorialApplication() {
        packages("org.example.maventutorial");
    }
}
