package org.dopcode;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;

/**
 * Goal which touches a timestamp file.
 * @goal touch
 * @phase process-sources
 */
public class ProcessMojo extends AbstractMojo {

    /**
     * @parameter
     * @required
     */
    private File outputDirectory;

    public void execute() throws MojoExecutionException {

        if (!outputDirectory.exists()) {
            outputDirectory.mkdirs();
        }

        File touch = new File(outputDirectory, "touch.txt");
        try (FileWriter w = new FileWriter(touch)) {
            w.write("plugin is working!");
            System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaatouche.txt's path: " + touch.getPath());
        }
        catch (IOException e) {
            throw new MojoExecutionException("Error creating file " + touch, e);
        }
    }
}
