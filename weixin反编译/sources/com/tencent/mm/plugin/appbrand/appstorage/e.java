package com.tencent.mm.plugin.appbrand.appstorage;

import com.tencent.mm.plugin.appbrand.q.h;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.k;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.io.Closeable;
import java.io.File;
import java.io.FileFilter;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.zip.ZipInputStream;

public class e implements l {
    public final String iKP;
    private final b iKQ = new b() {
        public final j r(File file) {
            return file.exists() ? j.OK : j.RET_NOT_EXISTS;
        }
    };
    private final b iKR = new b() {
        public final j r(File file) {
            if (file.exists()) {
                return file.isDirectory() ? j.OK : j.ERR_IS_FILE;
            } else {
                return j.RET_NOT_EXISTS;
            }
        }
    };
    private final b iKS = new b() {
        public final j r(File file) {
            if (file.exists()) {
                return j.RET_ALREADY_EXISTS;
            }
            return file.mkdir() ? j.OK : j.ERR_OP_FAIL;
        }
    };
    private final b iKT = new b() {
        public final j r(File file) {
            if (file.isFile() || !file.exists()) {
                return j.RET_NOT_EXISTS;
            }
            if (file.equals(e.this.aaQ())) {
                return j.ERR_PERMISSION_DENIED;
            }
            File[] listFiles = file.listFiles();
            if (listFiles.length > 0) {
                if (listFiles.length != 1) {
                    return j.ERR_DIR_NOT_EMPTY;
                }
                if (!listFiles[0].getName().equals(".nomedia")) {
                    return j.ERR_DIR_NOT_EMPTY;
                }
                listFiles[0].delete();
            }
            if (file.delete()) {
                return j.OK;
            }
            return j.ERR_OP_FAIL;
        }
    };
    private final a iKU = new a() {
        public final j a(File file, Object... objArr) {
            if (!file.isDirectory()) {
                return j.ERR_IS_FILE;
            }
            if (k.u(file)) {
                return j.ERR_SYMLINK;
            }
            final List linkedList = new LinkedList();
            final String quote = Pattern.quote(file.getAbsolutePath());
            file.listFiles(new FileFilter() {
                public final boolean accept(File file) {
                    boolean z = !file.getName().endsWith(".nomedia");
                    if (z) {
                        h hVar = new h();
                        hVar.fileName = com.tencent.mm.plugin.appbrand.appcache.a.pP(file.getAbsolutePath().replaceFirst(quote, ""));
                        linkedList.add(hVar);
                    }
                    return z;
                }
            });
            ((h) objArr[0]).jXv = linkedList;
            return j.OK;
        }
    };
    private final a iKV = new a() {
        public final j a(File file, Object... objArr) {
            h hVar = (h) objArr[0];
            if (!file.exists()) {
                return j.RET_NOT_EXISTS;
            }
            if (!file.isFile()) {
                return j.ERR_PERMISSION_DENIED;
            }
            if (k.u(file)) {
                return j.ERR_SYMLINK;
            }
            if (hVar != null) {
                hVar.jXv = k.s(file);
            }
            return j.OK;
        }
    };
    private final a iKW = new a() {
        public final j a(File file, Object... objArr) {
            Exception e;
            Throwable th;
            if (k.u(file)) {
                return j.ERR_SYMLINK;
            }
            InputStream inputStream = (InputStream) objArr[0];
            if (inputStream instanceof ZipInputStream) {
                if (k.a((ZipInputStream) inputStream, file.getAbsolutePath()) == 0) {
                    return j.OK;
                }
                return j.ERR_OP_FAIL;
            } else if (file.isDirectory()) {
                return j.RET_ALREADY_EXISTS;
            } else {
                Closeable fileOutputStream;
                j jVar;
                try {
                    fileOutputStream = new FileOutputStream(file);
                    try {
                        byte[] bArr = new byte[Downloads.RECV_BUFFER_SIZE];
                        while (true) {
                            int read = inputStream.read(bArr, 0, Downloads.RECV_BUFFER_SIZE);
                            if (read != -1) {
                                fileOutputStream.write(bArr, 0, read);
                            } else {
                                fileOutputStream.flush();
                                jVar = j.OK;
                                bi.d(fileOutputStream);
                                bi.d(inputStream);
                                return jVar;
                            }
                        }
                    } catch (Exception e2) {
                        e = e2;
                        try {
                            x.i("MicroMsg.AppBrandNonFlattenedFileStorage", "writeFile exp %s", e);
                            jVar = j.ERR_OP_FAIL;
                            bi.d(fileOutputStream);
                            bi.d(inputStream);
                            return jVar;
                        } catch (Throwable th2) {
                            th = th2;
                            bi.d(fileOutputStream);
                            bi.d(inputStream);
                            throw th;
                        }
                    }
                } catch (Exception e3) {
                    e = e3;
                    fileOutputStream = null;
                    x.i("MicroMsg.AppBrandNonFlattenedFileStorage", "writeFile exp %s", e);
                    jVar = j.ERR_OP_FAIL;
                    bi.d(fileOutputStream);
                    bi.d(inputStream);
                    return jVar;
                } catch (Throwable th3) {
                    th = th3;
                    fileOutputStream = null;
                    bi.d(fileOutputStream);
                    bi.d(inputStream);
                    throw th;
                }
            }
        }
    };
    private final b iKX = new b() {
        public final j r(File file) {
            if (file.isDirectory()) {
                return j.ERR_IS_DIRECTORY;
            }
            if (!file.exists()) {
                return j.RET_NOT_EXISTS;
            }
            int unlink = FileUnlink.unlink(file.getPath());
            if (unlink != 0) {
                x.e("MicroMsg.AppBrandNonFlattenedFileStorage", "unlink err %d, %s", Integer.valueOf(unlink), file.getPath());
            }
            return unlink == 0 ? j.OK : j.ERR_OP_FAIL;
        }
    };
    private final a iKY = new a() {
        public final j a(File file, Object... objArr) {
            if (!file.exists()) {
                return j.RET_NOT_EXISTS;
            }
            int stat = FileStat.stat(file.getPath(), (FileStructStat) objArr[0]);
            if (stat != 0) {
                x.e("MicroMsg.AppBrandNonFlattenedFileStorage", "stat err %d, %s", Integer.valueOf(stat), file.getPath());
            }
            return stat == 0 ? j.OK : j.ERR_OP_FAIL;
        }
    };
    private final a iKZ = new a() {
        public final j a(File file, Object... objArr) {
            File file2 = (File) objArr[0];
            boolean booleanValue = ((Boolean) objArr[1]).booleanValue();
            if (file.isDirectory()) {
                return j.RET_ALREADY_EXISTS;
            }
            if (k.u(file)) {
                return j.ERR_SYMLINK;
            }
            return booleanValue ? i.aS(file2.getAbsolutePath(), file.getAbsolutePath()) ? j.OK : j.ERR_OP_FAIL : k.r(file2.getAbsolutePath(), file.getAbsolutePath(), false) ? j.OK : j.ERR_OP_FAIL;
        }
    };
    private final a iLa = new a() {
        public final j a(File file, Object... objArr) {
            ((h) objArr[0]).jXv = file;
            return j.OK;
        }
    };

    private abstract class b implements a {
        public abstract j r(File file);

        private b() {
        }

        /* synthetic */ b(e eVar, byte b) {
            this();
        }

        public final j a(File file, Object... objArr) {
            return r(file);
        }
    }

    private interface a {
        j a(File file, Object... objArr);
    }

    public e(String... strArr) {
        this.iKP = m.h(strArr);
    }

    public final boolean bE(String str) {
        return bi.oM(str).startsWith("wxfile://usr");
    }

    public final void initialize() {
    }

    public final void release() {
    }

    private File aaQ() {
        if ("[INVALID]".equals(this.iKP)) {
            return null;
        }
        File file = new File(this.iKP);
        if (file.exists() && file.isFile()) {
            file.delete();
        }
        file.mkdirs();
        try {
            new File(file.getPath() + "/.nomedia").createNewFile();
            return file;
        } catch (Exception e) {
            return file;
        }
    }

    private j a(String str, a aVar, Object... objArr) {
        if (bi.oN(str)) {
            return j.ERR_PERMISSION_DENIED;
        }
        String pP = com.tencent.mm.plugin.appbrand.appcache.a.pP(str.replaceFirst(Pattern.quote("wxfile://usr"), ""));
        File aaQ = aaQ();
        if (aaQ == null) {
            return j.ERR_FS_NOT_MOUNTED;
        }
        pP = org.a.a.a.a.gr(aaQ.getAbsolutePath(), pP);
        if (bi.oN(pP)) {
            return j.ERR_PERMISSION_DENIED;
        }
        aaQ = new File(pP);
        if (!m.c(aaQ(), aaQ)) {
            return j.ERR_PERMISSION_DENIED;
        }
        if (aaQ.getParentFile().exists()) {
            return aVar.a(aaQ, objArr);
        }
        return j.ERR_PARENT_DIR_NOT_EXISTS;
    }

    public final j qk(String str) {
        return a(str, this.iKQ, new Object[0]);
    }

    public final j qp(String str) {
        return a(str, this.iKR, new Object[0]);
    }

    public final j qq(String str) {
        return a(str, this.iKS, new Object[0]);
    }

    public final j qr(String str) {
        return a(str, this.iKT, new Object[0]);
    }

    public final j b(String str, h<List<h>> hVar) {
        return a(str, this.iKU, hVar);
    }

    public final j a(String str, h<ByteBuffer> hVar) {
        return a(str, this.iKV, hVar);
    }

    public final j d(String str, InputStream inputStream) {
        if (inputStream == null) {
            return j.ERR_OP_FAIL;
        }
        return a(str, this.iKW, inputStream);
    }

    public final j qs(String str) {
        return a(str, this.iKX, new Object[0]);
    }

    public final j a(String str, FileStructStat fileStructStat) {
        return a(str, this.iKY, fileStructStat);
    }

    public final j a(String str, File file, boolean z) {
        return a(str, this.iKZ, file, Boolean.valueOf(z));
    }

    public final File ql(String str) {
        h hVar = new h();
        a(str, this.iLa, hVar);
        return (File) hVar.jXv;
    }
}
