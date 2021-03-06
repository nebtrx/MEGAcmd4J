package io.github.eliux.mega.error;

/**
 * Defines expected errors based on behaviours of failure defined by MEGA or the library itself.
 */
public class MegaException extends RuntimeException {

    public MegaException(String errorMessage) {
        super(errorMessage);
    }

    public MegaException(String errorMessage, Object... args) {
        super(String.format(errorMessage, args));
    }

    public MegaException(String errorMessage, Throwable errCause) {
        super(errorMessage, errCause);
    }

    public static final MegaException nonExistingEnvVariable(String envVarName) {
        return new MegaException(
                "You must define the variable %s in your environment",
                envVarName
        );
    }
}
