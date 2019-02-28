package com.tencent.tinker.loader.shareutil;

import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileLock;

public class ShareFileLockHelper implements Closeable {
    private final FileOutputStream AuD;
    private final FileLock AuE;

    private ShareFileLockHelper(File file) {
        this.AuD = new FileOutputStream(file);
        Throwable th = null;
        FileLock fileLock = null;
        int i = 0;
        while (i < 3) {
            int i2 = i + 1;
            try {
                fileLock = this.AuD.getChannel().lock();
                if ((fileLock != null ? 1 : null) != null) {
                    break;
                }
                Thread.sleep(10);
                i = i2;
            } catch (Throwable e) {
                th = e;
                i = i2;
            }
        }
        if (fileLock == null) {
            throw new IOException("Tinker Exception:FileLockHelper lock file failed: " + file.getAbsolutePath(), th);
        }
        this.AuE = fileLock;
    }

    public static ShareFileLockHelper ad(File file) {
        return new ShareFileLockHelper(file);
    }

    public void close() {
        try {
            if (this.AuE != null) {
                this.AuE.release();
            }
            if (this.AuD != null) {
                this.AuD.close();
            }
        } catch (Throwable th) {
            if (this.AuD != null) {
                this.AuD.close();
            }
        }
    }
}
