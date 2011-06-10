package jenkinsci.plugins.pmccabe;

import hudson.FilePath;
import hudson.Launcher;
import hudson.model.AbstractBuild;
import hudson.model.BuildListener;

import hudson.model.Result;
import hudson.tasks.BuildStepMonitor;
import hudson.tasks.Recorder;

import org.kohsuke.stapler.DataBoundConstructor;

import java.io.IOException;
import java.io.PrintStream;
import java.io.Serializable;


public class PmccabeRecorder extends Recorder implements Serializable {
	private final String outputFilePath;
	private static final long serialVersionUID = 1L;

    @DataBoundConstructor
    public PmccabeRecorder(String outputFilePath) {
        this.outputFilePath = outputFilePath;
    }


	public BuildStepMonitor getRequiredMonitorService() {
		// TODO Auto-generated method stub
		return BuildStepMonitor.NONE;
	}

	@Override
    public boolean perform(AbstractBuild<?, ?> build, Launcher launcher, BuildListener listener) {

		listener.getLogger().println("Parsing pmccabe results");

		FilePath workspace = build.getWorkspace();
		PrintStream logger = listener.getLogger();

		FilePath metricFile = new FilePath(build.getWorkspace(), outputFilePath);
		try {
			if (!metricFile.exists()) {
				listener.getLogger().println(String.format("The given '%s' metric path doesn't exist.", outputFilePath));
				build.setResult(Result.FAILURE);
				return false;
			}
		} catch (IOException ioe) {
			ioe.printStackTrace(logger);
			build.setResult(Result.FAILURE);
			return false;

		} catch (InterruptedException ie) {
			ie.printStackTrace(logger);
			build.setResult(Result.FAILURE);
			return false;
		} catch (Throwable t) {
			t.printStackTrace(logger);
			build.setResult(Result.FAILURE);
			return false;
		}

		listener.getLogger().println("End Processing pmccabe results");
		return true;
	}
	
    @SuppressWarnings("unused")
    public String getOutputFilePath() {
        return outputFilePath;
    }

}

