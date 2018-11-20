package org.example.maventutorial;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("/")
public final class MavenTutorialApplication extends ResourceConfig {

    public MavenTutorialApplication() {
        packages("org.example.maventutorial");
    }
}