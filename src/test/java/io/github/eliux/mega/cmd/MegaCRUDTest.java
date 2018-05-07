package io.github.eliux.mega.cmd;

import io.github.eliux.mega.Mega;
import io.github.eliux.mega.MegaSession;
import io.github.eliux.mega.MegaTestUtils;
import io.github.eliux.mega.MegaUtilsTest;
import io.github.eliux.mega.error.MegaException;
import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.stream.IntStream;

import static io.github.eliux.mega.MegaTestUtils.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MegaCRUDTest {

    private static final String TEST_FILE_PREFIX = "yolo";

    MegaSession sessionMega;

    @Before
    public void setup() {
        sessionMega = Mega.init();
    }

    @Test
    public void shouldUploadFileToRoot() {
        createTextFile("target/yolo-test.txt", "You only live once...");

        sessionMega.uploadFile("target/yolo-test.txt")
                .call();

        removeFile("target/yolo-test.txt");
    }

    @Test
    public void shouldUploadFileToTargetFolder() {
        createTextFile("target/yolo-infinite.txt", "You only live infinitive times...");

        sessionMega.uploadFile("target/yolo-infinite.txt", "megacmd4j/")
                .createRemoteIfNotPresent()
                .call();

        removeFile("target/yolo-infinite.txt");
    }

    @Test
    public void shouldUploadMultipleFilesOkAndCreateRemoteFolder() {
        createTextFiles(TEST_FILE_PREFIX, 10);

        final MegaCmdPutMultiple megaCmd = sessionMega.uploadFiles("megacmd4j/")
                .createRemoteIfNotPresent();

        IntStream.rangeClosed(1, 10).forEach(i -> {
            String filename = testTextFileName(TEST_FILE_PREFIX, i);
            megaCmd.addLocalFileToUpload(filename);
        });

        megaCmd.call();

        removeTextFiles(TEST_FILE_PREFIX, 10);
    }

    @Test
    public void given_multilevelfolder_when_mkdir_withoutRecursivelyFlag_then_fail() {
        sessionMega.mkdir("megacmd4j/level2/level3").call();
    }

    @Test(expected = MegaException.class)
    public void given_multilevelfolder_when_mkdir_withRecursivelyFlag_then_Success() {
        sessionMega.mkdir("megacmd4j/level2/level3")
                .recursively()
                .call();
    }

    @After
    public void logout() {
        sessionMega.logout();
    }
}
