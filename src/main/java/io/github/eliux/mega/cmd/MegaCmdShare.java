package io.github.eliux.mega.cmd;

public class MegaCmdShare extends AbstractMegaCmdRunnerWithParams {

    private String remotePath;

    private String username;

    private boolean shared = true;

    private AccessLevel accessLevel = AccessLevel.READ_ONLY;

    protected MegaCmdShare() {
    }

    public MegaCmdShare(String remotePath, String username) {
        this.remotePath = remotePath;
        this.username = username;
    }

    @Override
    public String getCmd() {
        return "share";
    }

    @Override
    String cmdParams() {
        final StringBuilder cmdParamsBuilder = new StringBuilder();

        cmdParamsBuilder.append(shared ? "-a " : "-d ");

        if (username != null)
            cmdParamsBuilder.append(String.format("--with=%s ", username));

        if (shared)
            cmdParamsBuilder.append(String.format("--level=%s ", accessLevel));

        if (remotePath != null)
            cmdParamsBuilder.append(remotePath);

        return cmdParamsBuilder.toString();
    }

    public boolean isShared() {
        return shared;
    }

    public MegaCmdShare startSharing() {
        shared = true;
        return this;
    }

    public MegaCmdShare stopSharing() {
        shared = true;
        return this;
    }

    public MegaCmdShare grantReadOnlyAccess() {
        accessLevel = AccessLevel.READ_ONLY;
        return this;
    }

    public MegaCmdShare grantReadAndWriteAccess() {
        accessLevel = AccessLevel.READ_WRITE;
        return this;
    }

    public MegaCmdShare grantFullAccess() {
        accessLevel = AccessLevel.FULL;
        return this;
    }

    public MegaCmdShare grantOwnerAccess() {
        accessLevel = AccessLevel.OWNER;
        return this;
    }

    protected enum AccessLevel {
        READ_ONLY('0'), READ_WRITE('1'), FULL('2'), OWNER('3');

        private Character id;

        AccessLevel(char id) {
            this.id = id;
        }

        public char getId() {
            return id;
        }

        @Override
        public String toString() {
            return id.toString();
        }
    }
}
