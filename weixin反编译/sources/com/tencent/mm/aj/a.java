package com.tencent.mm.aj;

import com.tencent.mm.compatible.util.e;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import org.json.JSONObject;

public final class a {
    private static String hbw = "";
    public static int hwC = 1;

    private static String Nm() {
        if (bi.oN(hbw)) {
            hbw = e.hbw.replace("/data/user/0", "/data/data");
        }
        return hbw;
    }

    public static String Nn() {
        File file = new File(Nm(), "emoji/res");
        if (!file.exists()) {
            file.mkdir();
        }
        return file.getAbsolutePath();
    }

    public static String No() {
        return Nm() + "emoji/newemoji";
    }

    public static int Np() {
        Throwable e;
        InputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream(new File(Nn(), "config.conf"));
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
                String str = "";
                while (true) {
                    String str2 = str;
                    str = bufferedReader.readLine();
                    if (str != null) {
                        str = str2 + str;
                    } else {
                        x.d("MicroMsg.emoji.EmojiStoreExportLogic", "config file content:%s version:%d", str2, Integer.valueOf(new JSONObject(str2).getInt("version")));
                        com.tencent.mm.a.e.c(fileInputStream);
                        return r0;
                    }
                }
            } catch (Exception e2) {
                e = e2;
                try {
                    x.printErrStackTrace("MicroMsg.emoji.EmojiStoreExportLogic", e, e.getMessage(), new Object[0]);
                    com.tencent.mm.a.e.c(fileInputStream);
                    return 1;
                } catch (Throwable th) {
                    e = th;
                    com.tencent.mm.a.e.c(fileInputStream);
                    throw e;
                }
            }
        } catch (Exception e3) {
            e = e3;
            fileInputStream = null;
            x.printErrStackTrace("MicroMsg.emoji.EmojiStoreExportLogic", e, e.getMessage(), new Object[0]);
            com.tencent.mm.a.e.c(fileInputStream);
            return 1;
        } catch (Throwable th2) {
            e = th2;
            fileInputStream = null;
            com.tencent.mm.a.e.c(fileInputStream);
            throw e;
        }
    }

    private static int Nq() {
        Reader bufferedReader;
        Throwable e;
        InputStream inputStream;
        Reader reader = null;
        InputStream open;
        Reader inputStreamReader;
        try {
            open = ad.getContext().getAssets().open("emoji_config.conf");
            try {
                inputStreamReader = new InputStreamReader(open);
                try {
                    bufferedReader = new BufferedReader(inputStreamReader);
                } catch (Exception e2) {
                    e = e2;
                    bufferedReader = null;
                    reader = inputStreamReader;
                    inputStream = open;
                    try {
                        x.printErrStackTrace("MicroMsg.emoji.EmojiStoreExportLogic", e, e.getMessage(), new Object[0]);
                        com.tencent.mm.a.e.c(inputStream);
                        com.tencent.mm.a.e.a(reader);
                        com.tencent.mm.a.e.a(bufferedReader);
                        return 1;
                    } catch (Throwable th) {
                        e = th;
                        open = inputStream;
                        inputStreamReader = reader;
                        com.tencent.mm.a.e.c(open);
                        com.tencent.mm.a.e.a(inputStreamReader);
                        com.tencent.mm.a.e.a(bufferedReader);
                        throw e;
                    }
                } catch (Throwable th2) {
                    e = th2;
                    bufferedReader = null;
                    com.tencent.mm.a.e.c(open);
                    com.tencent.mm.a.e.a(inputStreamReader);
                    com.tencent.mm.a.e.a(bufferedReader);
                    throw e;
                }
                try {
                    String str = "";
                    while (true) {
                        String str2 = str;
                        str = bufferedReader.readLine();
                        if (str != null) {
                            str = str2 + str;
                        } else {
                            x.d("MicroMsg.emoji.EmojiStoreExportLogic", "config file content:%s version:%d", str2, Integer.valueOf(new JSONObject(str2).getInt("version")));
                            com.tencent.mm.a.e.c(open);
                            com.tencent.mm.a.e.a(inputStreamReader);
                            com.tencent.mm.a.e.a(bufferedReader);
                            return r0;
                        }
                    }
                } catch (Exception e3) {
                    e = e3;
                    reader = inputStreamReader;
                    inputStream = open;
                    x.printErrStackTrace("MicroMsg.emoji.EmojiStoreExportLogic", e, e.getMessage(), new Object[0]);
                    com.tencent.mm.a.e.c(inputStream);
                    com.tencent.mm.a.e.a(reader);
                    com.tencent.mm.a.e.a(bufferedReader);
                    return 1;
                } catch (Throwable th3) {
                    e = th3;
                    com.tencent.mm.a.e.c(open);
                    com.tencent.mm.a.e.a(inputStreamReader);
                    com.tencent.mm.a.e.a(bufferedReader);
                    throw e;
                }
            } catch (Exception e4) {
                e = e4;
                bufferedReader = null;
                inputStream = open;
                x.printErrStackTrace("MicroMsg.emoji.EmojiStoreExportLogic", e, e.getMessage(), new Object[0]);
                com.tencent.mm.a.e.c(inputStream);
                com.tencent.mm.a.e.a(reader);
                com.tencent.mm.a.e.a(bufferedReader);
                return 1;
            } catch (Throwable th4) {
                e = th4;
                bufferedReader = null;
                inputStreamReader = null;
                com.tencent.mm.a.e.c(open);
                com.tencent.mm.a.e.a(inputStreamReader);
                com.tencent.mm.a.e.a(bufferedReader);
                throw e;
            }
        } catch (Exception e5) {
            e = e5;
            bufferedReader = null;
            inputStream = null;
        } catch (Throwable th5) {
            e = th5;
            bufferedReader = null;
            inputStreamReader = null;
            open = null;
            com.tencent.mm.a.e.c(open);
            com.tencent.mm.a.e.a(inputStreamReader);
            com.tencent.mm.a.e.a(bufferedReader);
            throw e;
        }
    }

    private static boolean kQ(String str) {
        InputStream open;
        try {
            open = ad.getContext().getAssets().open("emoji_template.zip");
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.emoji.EmojiStoreExportLogic", e, "", new Object[0]);
            open = null;
        }
        if (open == null) {
            x.e("MicroMsg.emoji.EmojiStoreExportLogic", "file inputStream not found");
            return false;
        }
        OutputStream fileOutputStream;
        File file = new File(str);
        if (file.exists()) {
            file.delete();
        }
        file.getParentFile().mkdirs();
        try {
            fileOutputStream = new FileOutputStream(file);
        } catch (Throwable e2) {
            x.printErrStackTrace("MicroMsg.emoji.EmojiStoreExportLogic", e2, "", new Object[0]);
            fileOutputStream = null;
        }
        if (fileOutputStream != null) {
            try {
                d(open, fileOutputStream);
                return true;
            } catch (Throwable e3) {
                x.printErrStackTrace("MicroMsg.emoji.EmojiStoreExportLogic", e3, "", new Object[0]);
                return false;
            } finally {
                com.tencent.mm.a.e.c(open);
                com.tencent.mm.a.e.a(fileOutputStream);
            }
        } else {
            com.tencent.mm.a.e.c(open);
            return false;
        }
    }

    private static void d(InputStream inputStream, OutputStream outputStream) {
        byte[] bArr = new byte[WXMediaMessage.DESCRIPTION_LENGTH_LIMIT];
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                outputStream.write(bArr, 0, read);
            } else {
                return;
            }
        }
    }

    public static void bN(boolean z) {
        File file = new File(Nn());
        x.i("MicroMsg.emoji.EmojiStoreExportLogic", "copy search template file to path: %s", file.getAbsoluteFile());
        if (d.vHo || d.vHp) {
            x.i("MicroMsg.emoji.EmojiStoreExportLogic", "need to init search template folder %b", Boolean.valueOf(z));
            com.tencent.mm.a.e.g(file);
            m(file);
        } else {
            hwC = Np();
            if (z) {
                x.i("MicroMsg.emoji.EmojiStoreExportLogic", "need update assetVersion=%d currentVersion=%d", Integer.valueOf(Nq()), Integer.valueOf(hwC));
                if (hwC < Nq()) {
                    com.tencent.mm.a.e.g(file);
                    m(file);
                }
            } else if (hwC == 1) {
                x.i("MicroMsg.emoji.EmojiStoreExportLogic", "no need update currentVersion=%d", Integer.valueOf(hwC));
                com.tencent.mm.a.e.g(file);
                m(file);
            }
        }
        com.tencent.mm.a.e.g(new File(e.bnF, "emoji"));
    }

    private static void m(File file) {
        if (!file.exists()) {
            file.mkdirs();
        }
        File file2 = new File(file, ".nomedia");
        if (!file2.exists()) {
            try {
                file2.createNewFile();
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.emoji.EmojiStoreExportLogic", e, "create nomedia file error", new Object[0]);
            }
        }
        file2 = new File(file, "emoji_template.zip");
        if (kQ(file2.getAbsolutePath())) {
            int fz = bi.fz(file2.getAbsolutePath(), file2.getParent());
            if (fz < 0) {
                x.e("MicroMsg.emoji.EmojiStoreExportLogic", "unzip fail, ret = " + fz + ", zipFilePath = " + file2.getAbsolutePath() + ", unzipPath = " + file2.getParent());
                return;
            }
            hwC = Np();
            x.i("MicroMsg.emoji.EmojiStoreExportLogic", "Unzip Path%s version=%d", file2.getParent(), Integer.valueOf(hwC));
            return;
        }
        x.i("MicroMsg.emoji.EmojiStoreExportLogic", "copy template file from asset fail %s", file2.getAbsolutePath());
    }

    public static void n(File file) {
        File file2 = new File(Nn());
        com.tencent.mm.a.e.g(file2);
        file2.mkdirs();
        File file3 = new File(file2, ".nomedia");
        if (!file3.exists()) {
            try {
                file3.createNewFile();
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.emoji.EmojiStoreExportLogic", e, "create nomedia file error", new Object[0]);
            }
        }
        file3 = new File(file2, "emoji_template.zip");
        com.tencent.mm.a.e.x(file.getAbsolutePath(), file3.getAbsolutePath());
        int fz = bi.fz(file3.getAbsolutePath(), file3.getParent());
        if (fz < 0) {
            x.e("MicroMsg.emoji.EmojiStoreExportLogic", "unzip fail, ret = " + fz + ", zipFilePath = " + file3.getAbsolutePath() + ", unzipPath = " + file3.getParent());
            return;
        }
        hwC = Np();
        x.i("MicroMsg.emoji.EmojiStoreExportLogic", "Unzip Path%s version=%d", file3.getParent(), Integer.valueOf(hwC));
    }
}
