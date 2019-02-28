package com.tencent.mm.plugin.appbrand.appstorage;

import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.appbrand.k.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public final class k {
    static ByteBuffer s(File file) {
        Throwable e;
        Throwable th;
        if (file == null || !file.exists() || !file.isFile()) {
            return ByteBuffer.allocateDirect(0);
        }
        int length = (int) file.length();
        if (length < 0) {
            return ByteBuffer.allocateDirect(0);
        }
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(length);
        Closeable fileInputStream;
        try {
            fileInputStream = new FileInputStream(file);
            try {
                byte[] bArr = new byte[Downloads.RECV_BUFFER_SIZE];
                while (true) {
                    int read = fileInputStream.read(bArr, 0, Downloads.RECV_BUFFER_SIZE);
                    if (read != -1) {
                        allocateDirect.put(bArr, 0, read);
                    } else {
                        allocateDirect.flip();
                        bi.d(fileInputStream);
                        return allocateDirect;
                    }
                }
            } catch (IOException e2) {
                e = e2;
                try {
                    x.printErrStackTrace("MicroMsg.AppBrand.FileSystemUtil", e, "readAsDirectByteBuffer", new Object[0]);
                    a.i(allocateDirect);
                    bi.d(fileInputStream);
                    return ByteBuffer.allocateDirect(0);
                } catch (Throwable th2) {
                    th = th2;
                    bi.d(fileInputStream);
                    throw th;
                }
            } catch (BufferOverflowException e3) {
                x.e("MicroMsg.AppBrand.FileSystemUtil", "BufferOverflow, file_length %d, byte_allocated %d", Long.valueOf(file.length()), Integer.valueOf(allocateDirect.capacity()));
                a.i(allocateDirect);
                bi.d(fileInputStream);
                return ByteBuffer.allocateDirect(0);
            }
        } catch (IOException e4) {
            e = e4;
            fileInputStream = null;
            x.printErrStackTrace("MicroMsg.AppBrand.FileSystemUtil", e, "readAsDirectByteBuffer", new Object[0]);
            a.i(allocateDirect);
            bi.d(fileInputStream);
            return ByteBuffer.allocateDirect(0);
        } catch (BufferOverflowException e5) {
            fileInputStream = null;
            x.e("MicroMsg.AppBrand.FileSystemUtil", "BufferOverflow, file_length %d, byte_allocated %d", Long.valueOf(file.length()), Integer.valueOf(allocateDirect.capacity()));
            a.i(allocateDirect);
            bi.d(fileInputStream);
            return ByteBuffer.allocateDirect(0);
        } catch (Throwable th3) {
            th = th3;
            fileInputStream = null;
            bi.d(fileInputStream);
            throw th;
        }
    }

    static int a(ZipInputStream zipInputStream, String str) {
        Closeable fileOutputStream;
        Exception e;
        Throwable th;
        while (true) {
            try {
                ZipEntry nextEntry = zipInputStream.getNextEntry();
                if (nextEntry != null) {
                    String name = nextEntry.getName();
                    if (!(name.contains("../") || name.contains("..\\"))) {
                        if (nextEntry.isDirectory()) {
                            new File(str + File.separator + name.substring(0, name.length() - 1)).mkdirs();
                        } else {
                            File file = new File(str + File.separator + name);
                            file.getParentFile().mkdirs();
                            file.createNewFile();
                            try {
                                fileOutputStream = new FileOutputStream(file);
                                try {
                                    byte[] bArr = new byte[WXMediaMessage.DESCRIPTION_LENGTH_LIMIT];
                                    while (true) {
                                        int read = zipInputStream.read(bArr);
                                        if (read == -1) {
                                            break;
                                        }
                                        fileOutputStream.write(bArr, 0, read);
                                        fileOutputStream.flush();
                                    }
                                    bi.d(fileOutputStream);
                                } catch (Exception e2) {
                                    e = e2;
                                }
                            } catch (Exception e3) {
                                e = e3;
                                fileOutputStream = null;
                            } catch (Throwable th2) {
                                th = th2;
                                fileOutputStream = null;
                            }
                        }
                    }
                } else if (zipInputStream == null) {
                    return 0;
                } else {
                    try {
                        zipInputStream.close();
                        return 0;
                    } catch (IOException e4) {
                        x.e("MicroMsg.AppBrand.FileSystemUtil", "close zip stream failed.");
                        return 0;
                    }
                }
            } catch (Throwable th3) {
                x.printErrStackTrace("MicroMsg.AppBrand.FileSystemUtil", th3, "", new Object[0]);
                if (zipInputStream != null) {
                    try {
                        zipInputStream.close();
                    } catch (IOException e5) {
                        x.e("MicroMsg.AppBrand.FileSystemUtil", "close zip stream failed.");
                    }
                }
                return -1;
            } catch (Throwable th32) {
                x.printErrStackTrace("MicroMsg.AppBrand.FileSystemUtil", th32, "", new Object[0]);
                if (zipInputStream != null) {
                    try {
                        zipInputStream.close();
                    } catch (IOException e6) {
                        x.e("MicroMsg.AppBrand.FileSystemUtil", "close zip stream failed.");
                    }
                }
                return -2;
            } catch (Throwable th4) {
                if (zipInputStream != null) {
                    try {
                        zipInputStream.close();
                    } catch (IOException e7) {
                        x.e("MicroMsg.AppBrand.FileSystemUtil", "close zip stream failed.");
                    }
                }
            }
        }
        try {
            throw e;
        } catch (Throwable th5) {
            th32 = th5;
        }
        bi.d(fileOutputStream);
        throw th32;
    }

    public static void t(File file) {
        if (file.exists()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                for (File file2 : listFiles) {
                    if (file2.isDirectory()) {
                        t(file2);
                    }
                    file2.delete();
                }
            }
        }
    }

    public static boolean u(File file) {
        if (file == null) {
            throw new NullPointerException("file should not be NULL");
        } else if (!file.exists()) {
            return false;
        } else {
            try {
                FileStructStat fileStructStat = new FileStructStat();
                if (FileStat.stat(file.getAbsolutePath(), fileStructStat) != 0) {
                    return false;
                }
                x.i("MicroMsg.AppBrand.FileSystemUtil", "constainsSymLink, path %s, stat.st_mode %d", file.getAbsolutePath(), Integer.valueOf(fileStructStat.st_mode));
                if ((fileStructStat.st_mode & 61440) == 40960) {
                    return true;
                }
                return false;
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.AppBrand.FileSystemUtil", e, "", new Object[0]);
                return false;
            }
        }
    }
}
