package jenkinsci.plugins.pmccabe;

import hudson.model.AbstractBuild;
import hudson.model.Action;
import org.kohsuke.stapler.StaplerProxy;
import java.io.Serializable;

import jenkinsci.plugins.pmccabe.utils.PmccabeReport;


public class PmccabeAction implements Action {

    public static final String URL_NAME = "PmccabeReport";

    private AbstractBuild<?, ?> build;
    private PmccabeReport report;
    private boolean isModifiedComplexity;

    public boolean isModifiedComplexity() {
		return isModifiedComplexity;
	}

	public PmccabeAction(AbstractBuild<?, ?> build, PmccabeReport report, boolean isModifiedComplexity) {
        this.build = build;
        this.report = report;
        this.isModifiedComplexity = isModifiedComplexity;
    }

    public String getIconFileName() {
        return "/plugin/pmccabe/icons/pmccabe-24.png";
    }

    public String getDisplayName() {
        return "PMcCabe Results";
    }

    public String getUrlName() {
        return URL_NAME;
    }

    @SuppressWarnings("unused")
    public String getSummary() {
    	return "Here getSummary()";
    }

    @SuppressWarnings("unused")
    public String getDetails() {
    	return "Here getDetails()";
    }

    public AbstractBuild<?, ?> getBuild() {
        return build;
    }
    
    public PmccabeReport getReport() {
        return report;
    }

	public Object getTarget() {
		return report;
	}
	
    private PmccabeReport getPreviousResult() {
        PmccabeAction previousAction = this.getPreviousAction();
        PmccabeReport previousReport = null;
        if (previousAction != null) {
            previousReport = previousAction.getReport();
        }

        return previousReport;
    }

    private PmccabeAction getPreviousAction() {
        AbstractBuild<?, ?> previousBuild = this.build.getPreviousBuild();
        if (previousBuild != null) {
            return previousBuild.getAction(PmccabeAction.class);
        }
        return null;
    }

}
