package com.tencent.mm.plugin.appbrand.appstorage;

import com.tencent.mm.loader.stub.b;
import com.tencent.mm.sdk.platformtools.bi;
import java.io.File;
import java.io.FileFilter;
import java.util.concurrent.TimeUnit;

public final class d {
    public static final Runnable iIC = new Runnable() {
        public final void run() {
            File file = new File(AppBrandLocalMediaObjectManager.OBJECT_ROOT_DIR_PATH);
            if (file.exists() && file.isDirectory()) {
                File[] listFiles = file.listFiles();
                if (listFiles != null && listFiles.length > 0) {
                    for (File q : listFiles) {
                        q(q);
                    }
                }
            }
        }

        private void q(File file) {
            if (file.exists() && file.isDirectory()) {
                File[] listFiles = file.listFiles(new FileFilter() {
                    public final boolean accept(File file) {
                        return (file.getName().endsWith(".dat") || file.getName().startsWith("store_") || file.getName().endsWith(".nomedia")) ? false : true;
                    }
                });
                if (listFiles != null && listFiles.length > 0) {
                    long Wy = bi.Wy();
                    for (File file2 : listFiles) {
                        if (Wy - file2.lastModified() >= d.iKN) {
                            b.deleteFile(file2.getAbsolutePath());
                        }
                    }
                }
            }
        }
    };
    private static final long iKN = TimeUnit.MINUTES.toMillis(30);
}
