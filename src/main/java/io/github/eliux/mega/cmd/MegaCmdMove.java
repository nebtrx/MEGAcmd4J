package io.github.eliux.mega.cmd;

import io.github.eliux.mega.MegaUtils;

public class MegaCmdMove extends AbstractMegaCmdRunnerWithParams {

    private final String sourceRemotePath;

    private final String remoteTarget;

    public MegaCmdMove(String sourceRemotePath, String remoteTarget) {
        this.sourceRemotePath = sourceRemotePath;
        this.remoteTarget = remoteTarget;
    }

    @Override
    String cmdParams() {
        return String.format("%s %s", sourceRemotePath, remoteTarget);
    }

    @Override
    public String getCmd() {
        return "mv";
    }

    public String getSourceRemotePath() {
        return sourceRemotePath;
    }

    public String getRemoteTarget() {
        return remoteTarget;
    }
}
