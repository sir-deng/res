package com.tencent.tinker.loader;

import android.os.Build.VERSION;
import com.tencent.tinker.loader.shareutil.ShareFileLockHelper;
import com.tencent.tinker.loader.shareutil.SharePatchFileUtil;
import dalvik.system.DexFile;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public final class TinkerDexOptimizer {

    private static class OptimizeWorker {
        private static String AsD = null;
        private final File AsE;
        private final File AsF;
        private final ResultCallback AsG;
        private final boolean Asa;

        OptimizeWorker(File file, File file2, boolean z, String str, ResultCallback resultCallback) {
            this.AsE = file;
            this.AsF = file2;
            this.Asa = z;
            this.AsG = resultCallback;
            AsD = str;
        }

        public final boolean cHT() {
            try {
                if (SharePatchFileUtil.ae(this.AsE) || this.AsG == null) {
                    if (this.AsG != null) {
                        this.AsG.X(this.AsE);
                    }
                    String n = SharePatchFileUtil.n(this.AsE, this.AsF);
                    if (this.Asa) {
                        String absolutePath = this.AsE.getAbsolutePath();
                        File file = new File(n);
                        if (!file.exists()) {
                            file.getParentFile().mkdirs();
                        }
                        File file2 = new File(file.getParentFile(), "interpret.lock");
                        ShareFileLockHelper shareFileLockHelper = null;
                        try {
                            shareFileLockHelper = ShareFileLockHelper.ad(file2);
                            List arrayList = new ArrayList();
                            arrayList.add("dex2oat");
                            if (VERSION.SDK_INT >= 24) {
                                arrayList.add("--runtime-arg");
                                arrayList.add("-classpath");
                                arrayList.add("--runtime-arg");
                                arrayList.add("&");
                            }
                            arrayList.add("--dex-file=" + absolutePath);
                            arrayList.add("--oat-file=" + n);
                            arrayList.add("--instruction-set=" + AsD);
                            if (VERSION.SDK_INT > 25) {
                                arrayList.add("--compiler-filter=quicken");
                            } else {
                                arrayList.add("--compiler-filter=interpret-only");
                            }
                            ProcessBuilder processBuilder = new ProcessBuilder(arrayList);
                            processBuilder.redirectErrorStream(true);
                            Process start = processBuilder.start();
                            StreamConsumer.v(start.getInputStream());
                            StreamConsumer.v(start.getErrorStream());
                            int waitFor = start.waitFor();
                            if (waitFor != 0) {
                                throw new IOException("dex2oat works unsuccessfully, exit code: " + waitFor);
                            }
                            try {
                                shareFileLockHelper.close();
                            } catch (IOException e) {
                            }
                        } catch (Throwable e2) {
                            throw new IOException("dex2oat is interrupted, msg: " + e2.getMessage(), e2);
                        } catch (Throwable th) {
                            if (shareFileLockHelper != null) {
                                try {
                                    shareFileLockHelper.close();
                                } catch (IOException e3) {
                                }
                            }
                        }
                    } else {
                        DexFile.loadDex(this.AsE.getAbsolutePath(), n, 0);
                    }
                    if (this.AsG != null) {
                        this.AsG.l(this.AsE, new File(n));
                    }
                    return true;
                }
                this.AsG.b(this.AsE, new IOException("dex file " + this.AsE.getAbsolutePath() + " is not exist!"));
                return false;
            } catch (Throwable e22) {
                new StringBuilder("Failed to optimize dex: ").append(this.AsE.getAbsolutePath());
                if (this.AsG != null) {
                    this.AsG.b(this.AsE, e22);
                    return false;
                }
            }
        }
    }

    public interface ResultCallback {
        void X(File file);

        void b(File file, Throwable th);

        void l(File file, File file2);
    }

    private static class StreamConsumer {
        static final Executor AsH = Executors.newSingleThreadExecutor();

        private StreamConsumer() {
        }

        static void v(final InputStream inputStream) {
            AsH.execute(new Runnable() {
                public final void run() {
                    if (inputStream != null) {
                        while (true) {
                            try {
                                if (inputStream.read(new byte[256]) <= 0) {
                                    try {
                                        inputStream.close();
                                        return;
                                    } catch (Exception e) {
                                        return;
                                    }
                                }
                            } catch (IOException e2) {
                                try {
                                    inputStream.close();
                                    return;
                                } catch (Exception e3) {
                                    return;
                                }
                            } catch (Throwable th) {
                                try {
                                    inputStream.close();
                                } catch (Exception e4) {
                                }
                                throw th;
                            }
                        }
                    }
                }
            });
        }
    }

    public static boolean a(Collection<File> collection, File file, ResultCallback resultCallback) {
        return a(collection, file, false, null, resultCallback);
    }

    public static boolean a(Collection<File> collection, File file, boolean z, String str, ResultCallback resultCallback) {
        Object arrayList = new ArrayList(collection);
        Collections.sort(arrayList, new Comparator<File>() {
            public final /* synthetic */ int compare(Object obj, Object obj2) {
                long length = ((File) obj).length() - ((File) obj2).length();
                if (length > 0) {
                    return 1;
                }
                return length == 0 ? 0 : -1;
            }
        });
        Collections.reverse(arrayList);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            if (!new OptimizeWorker((File) it.next(), file, z, str, resultCallback).cHT()) {
                return false;
            }
        }
        return true;
    }
}
