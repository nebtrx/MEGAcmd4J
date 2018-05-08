package io.github.eliux.mega.cmd;

import io.github.eliux.mega.MegaUtils;
import io.github.eliux.mega.error.MegaIOException;
import io.github.eliux.mega.error.MegaLoginRequiredException;

import java.io.IOException;
import java.util.Optional;

public class MegaCmdSession extends AbstractMegaCmdCaller<String> {

    @Override
    public String getCmd() {
        return "session";
    }

    static final Optional<String> parseSessionID(String response) {
        return Optional.ofNullable(response)
                .map(s -> s.split(":"))
                .filter(x -> x.length == 2)
                .map(s -> s[1].trim());
    }

    @Override
    public String call() {
        try {
            final String response =
                    MegaUtils.execWithOutput(executableCommand()).get(0);

            return parseSessionID(response)
                    .orElseThrow(()-> new MegaLoginRequiredException());
        } catch (IOException e) {
            throw new MegaIOException();
        }
    }
}
