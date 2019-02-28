package com.tencent.mm.bh;

import com.tencent.mm.compatible.util.e;
import com.tencent.mm.pluginsdk.model.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.as;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Set;
import org.json.JSONObject;

public final class a {
    private static String hbw = "";
    public static Set<String> ibe;
    public static int ibf = 1;

    private static String cf(boolean z) {
        if (z && c.vjO) {
            as.Hm();
            return com.tencent.mm.y.c.FJ();
        }
        if (bi.oN(hbw)) {
            hbw = e.hbw.replace("/data/user/0", "/data/data");
        }
        return hbw;
    }

    public static String Vn() {
        File file;
        if (ax.cgP() > 1048576) {
            file = new File(cf(false), "wenote/res");
        } else {
            file = new File(e.bnF, "wenote/res");
        }
        return file.getAbsolutePath();
    }

    public static String Vo() {
        File file = new File(cf(false), "wenote/res");
        if (new File(file, "WNNote.zip").exists()) {
            return file.getAbsolutePath();
        }
        file = new File(e.bnF, "wenote/res");
        if (new File(file, "WNNote.zip").exists()) {
            return file.getAbsolutePath();
        }
        return "";
    }

    public static String Vp() {
        File file = new File(cf(true), "wenote/loc/data");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file.getAbsolutePath();
    }

    public static String Vq() {
        StringBuilder stringBuilder = new StringBuilder();
        File file = new File(cf(false), "wenote/html/upload");
        if (!file.exists()) {
            file.mkdirs();
        }
        return stringBuilder.append(file.getAbsolutePath()).append("/wenoteupload.htm").toString();
    }

    public static String Vr() {
        File file = new File(cf(true), "wenote/image/localpath");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file.getAbsolutePath();
    }

    public static String Vs() {
        File file = new File(cf(true), "wenote/voice/data");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file.getAbsolutePath();
    }

    public static int Np() {
        Throwable e;
        InputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream(new File(Vo(), "config.conf"));
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
                String str = "";
                while (true) {
                    String str2 = str;
                    str = bufferedReader.readLine();
                    if (str != null) {
                        str = str2 + str;
                    } else {
                        x.d("MicroMsg.WNNote.WNNoteExportLogic", "config file content:%s version:%d", str2, Integer.valueOf(new JSONObject(str2).getInt("version")));
                        com.tencent.mm.a.e.c(fileInputStream);
                        return r0;
                    }
                }
            } catch (Exception e2) {
                e = e2;
                try {
                    x.printErrStackTrace("MicroMsg.WNNote.WNNoteExportLogic", e, e.getMessage(), new Object[0]);
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
            x.printErrStackTrace("MicroMsg.WNNote.WNNoteExportLogic", e, e.getMessage(), new Object[0]);
            com.tencent.mm.a.e.c(fileInputStream);
            return 1;
        } catch (Throwable th2) {
            e = th2;
            fileInputStream = null;
            com.tencent.mm.a.e.c(fileInputStream);
            throw e;
        }
    }

    public static int Nq() {
        Reader bufferedReader;
        Throwable e;
        InputStream inputStream;
        Reader reader = null;
        InputStream open;
        Reader inputStreamReader;
        try {
            open = ad.getContext().getAssets().open("wenote_config.conf");
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
                        x.printErrStackTrace("MicroMsg.WNNote.WNNoteExportLogic", e, e.getMessage(), new Object[0]);
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
                            x.d("MicroMsg.WNNote.WNNoteExportLogic", "config file content:%s version:%d", str2, Integer.valueOf(new JSONObject(str2).getInt("version")));
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
                    x.printErrStackTrace("MicroMsg.WNNote.WNNoteExportLogic", e, e.getMessage(), new Object[0]);
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
                x.printErrStackTrace("MicroMsg.WNNote.WNNoteExportLogic", e, e.getMessage(), new Object[0]);
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
}
