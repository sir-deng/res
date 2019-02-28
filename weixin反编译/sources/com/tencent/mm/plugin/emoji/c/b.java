package com.tencent.mm.plugin.emoji.c;

import com.tencent.mm.a.e;
import com.tencent.mm.aj.a;
import com.tencent.mm.f.a.bc;
import com.tencent.mm.plugin.emoji.e.i;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.k;
import com.tencent.mm.sdk.platformtools.x;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import org.json.JSONObject;

public final class b extends c<bc> {
    public b() {
        this.xmG = bc.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
        return c((bc) bVar);
    }

    private static boolean c(bc bcVar) {
        Reader inputStreamReader;
        Reader reader;
        Throwable e;
        Throwable e2;
        int i;
        if (bcVar instanceof bc) {
            String str;
            if (bcVar.fqf.fqg == 33) {
                File file = new File(bcVar.fqf.filePath);
                if (file.exists()) {
                    x.i("MicroMsg.emoji.EmojiResUpdateListener", "checkResUpdateListener callback to update %s", file.getAbsoluteFile());
                    File file2 = new File(a.Nn(), "temp");
                    File file3 = new File(file2, "emoji_template.zip");
                    file2.mkdirs();
                    e.x(file.getAbsolutePath(), file3.getAbsolutePath());
                    if (bi.fz(file3.getAbsolutePath(), file2.getAbsolutePath()) >= 0) {
                        InputStream fileInputStream;
                        try {
                            String str2;
                            fileInputStream = new FileInputStream(new File(file2, "config.conf"));
                            try {
                                inputStreamReader = new InputStreamReader(fileInputStream);
                            } catch (Throwable e22) {
                                reader = null;
                                inputStreamReader = null;
                                e = e22;
                                i = 1;
                                try {
                                    x.printErrStackTrace("MicroMsg.emoji.EmojiResUpdateListener", e, e.getMessage(), new Object[0]);
                                    e.c(fileInputStream);
                                    e.a(inputStreamReader);
                                    e.a(reader);
                                    e.g(file2);
                                    com.tencent.mm.loader.stub.b.deleteFile(file3.getPath());
                                    if (a.hwC >= i) {
                                        x.i("MicroMsg.emoji.EmojiResUpdateListener", "res no need update template currentVersion:%d resVersion:%d", Integer.valueOf(a.hwC), Integer.valueOf(i));
                                    } else {
                                        x.i("MicroMsg.emoji.EmojiResUpdateListener", "res update template currentVersion:%d resVersion:%d", Integer.valueOf(a.hwC), Integer.valueOf(i));
                                        a.n(file);
                                    }
                                    return false;
                                } catch (Throwable th) {
                                    e22 = th;
                                    e.c(fileInputStream);
                                    e.a(inputStreamReader);
                                    e.a(reader);
                                    throw e22;
                                }
                            } catch (Throwable th2) {
                                e22 = th2;
                                reader = null;
                                inputStreamReader = null;
                                e.c(fileInputStream);
                                e.a(inputStreamReader);
                                e.a(reader);
                                throw e22;
                            }
                            try {
                                reader = new BufferedReader(inputStreamReader);
                                try {
                                    str = "";
                                    while (true) {
                                        str2 = str;
                                        str = reader.readLine();
                                        if (str == null) {
                                            break;
                                        }
                                        str = str2 + str;
                                    }
                                    i = new JSONObject(str2).getInt("version");
                                } catch (Throwable e222) {
                                    e = e222;
                                    i = 1;
                                    x.printErrStackTrace("MicroMsg.emoji.EmojiResUpdateListener", e, e.getMessage(), new Object[0]);
                                    e.c(fileInputStream);
                                    e.a(inputStreamReader);
                                    e.a(reader);
                                    e.g(file2);
                                    com.tencent.mm.loader.stub.b.deleteFile(file3.getPath());
                                    if (a.hwC >= i) {
                                        x.i("MicroMsg.emoji.EmojiResUpdateListener", "res update template currentVersion:%d resVersion:%d", Integer.valueOf(a.hwC), Integer.valueOf(i));
                                        a.n(file);
                                    } else {
                                        x.i("MicroMsg.emoji.EmojiResUpdateListener", "res no need update template currentVersion:%d resVersion:%d", Integer.valueOf(a.hwC), Integer.valueOf(i));
                                    }
                                    return false;
                                }
                            } catch (Throwable e2222) {
                                reader = null;
                                e = e2222;
                                i = 1;
                                x.printErrStackTrace("MicroMsg.emoji.EmojiResUpdateListener", e, e.getMessage(), new Object[0]);
                                e.c(fileInputStream);
                                e.a(inputStreamReader);
                                e.a(reader);
                                e.g(file2);
                                com.tencent.mm.loader.stub.b.deleteFile(file3.getPath());
                                if (a.hwC >= i) {
                                    x.i("MicroMsg.emoji.EmojiResUpdateListener", "res no need update template currentVersion:%d resVersion:%d", Integer.valueOf(a.hwC), Integer.valueOf(i));
                                } else {
                                    x.i("MicroMsg.emoji.EmojiResUpdateListener", "res update template currentVersion:%d resVersion:%d", Integer.valueOf(a.hwC), Integer.valueOf(i));
                                    a.n(file);
                                }
                                return false;
                            } catch (Throwable th3) {
                                e2222 = th3;
                                reader = null;
                                e.c(fileInputStream);
                                e.a(inputStreamReader);
                                e.a(reader);
                                throw e2222;
                            }
                            try {
                                x.d("MicroMsg.emoji.EmojiResUpdateListener", "config file content:%s version:%d", str2, Integer.valueOf(i));
                                e.c(fileInputStream);
                                e.a(inputStreamReader);
                                e.a(reader);
                            } catch (Exception e3) {
                                e = e3;
                                x.printErrStackTrace("MicroMsg.emoji.EmojiResUpdateListener", e, e.getMessage(), new Object[0]);
                                e.c(fileInputStream);
                                e.a(inputStreamReader);
                                e.a(reader);
                                e.g(file2);
                                com.tencent.mm.loader.stub.b.deleteFile(file3.getPath());
                                if (a.hwC >= i) {
                                    x.i("MicroMsg.emoji.EmojiResUpdateListener", "res update template currentVersion:%d resVersion:%d", Integer.valueOf(a.hwC), Integer.valueOf(i));
                                    a.n(file);
                                } else {
                                    x.i("MicroMsg.emoji.EmojiResUpdateListener", "res no need update template currentVersion:%d resVersion:%d", Integer.valueOf(a.hwC), Integer.valueOf(i));
                                }
                                return false;
                            }
                        } catch (Throwable e22222) {
                            reader = null;
                            inputStreamReader = null;
                            fileInputStream = null;
                            e = e22222;
                            i = 1;
                            x.printErrStackTrace("MicroMsg.emoji.EmojiResUpdateListener", e, e.getMessage(), new Object[0]);
                            e.c(fileInputStream);
                            e.a(inputStreamReader);
                            e.a(reader);
                            e.g(file2);
                            com.tencent.mm.loader.stub.b.deleteFile(file3.getPath());
                            if (a.hwC >= i) {
                                x.i("MicroMsg.emoji.EmojiResUpdateListener", "res no need update template currentVersion:%d resVersion:%d", Integer.valueOf(a.hwC), Integer.valueOf(i));
                            } else {
                                x.i("MicroMsg.emoji.EmojiResUpdateListener", "res update template currentVersion:%d resVersion:%d", Integer.valueOf(a.hwC), Integer.valueOf(i));
                                a.n(file);
                            }
                            return false;
                        } catch (Throwable th4) {
                            e22222 = th4;
                            reader = null;
                            inputStreamReader = null;
                            fileInputStream = null;
                            e.c(fileInputStream);
                            e.a(inputStreamReader);
                            e.a(reader);
                            throw e22222;
                        }
                    }
                    i = 1;
                    e.g(file2);
                    com.tencent.mm.loader.stub.b.deleteFile(file3.getPath());
                    if (a.hwC >= i) {
                        x.i("MicroMsg.emoji.EmojiResUpdateListener", "res update template currentVersion:%d resVersion:%d", Integer.valueOf(a.hwC), Integer.valueOf(i));
                        a.n(file);
                    } else {
                        x.i("MicroMsg.emoji.EmojiResUpdateListener", "res no need update template currentVersion:%d resVersion:%d", Integer.valueOf(a.hwC), Integer.valueOf(i));
                    }
                } else {
                    x.e("MicroMsg.emoji.EmojiResUpdateListener", "checkResUpdateListener file not exist");
                }
            } else if (bcVar.fqf.fqg == 37) {
                File file4;
                if (bcVar.fqf.fqh == 1) {
                    i.aBN().a(bcVar, false);
                } else if (bcVar.fqf.fqh == 2) {
                    i.aBN().b(bcVar, false);
                } else if (bcVar.fqf.fqh == 3) {
                    if (!i.aBN().a(bcVar, i.a.SUGGEST)) {
                        x.i("MicroMsg.emoji.EmojiResUpdateMgr", "updateEmojiSuggest need no update.");
                    } else if (i.a(bcVar, i.a.SUGGEST, i.lBB)) {
                        file4 = new File(new File(i.aBO(), i.lBB), i.lBM);
                        if (file4.exists()) {
                            i.B(file4);
                        } else {
                            x.i("MicroMsg.emoji.EmojiResUpdateMgr", "updateEmojiSuggest config don't exist.");
                        }
                    } else {
                        x.i("MicroMsg.emoji.EmojiResUpdateMgr", "updateEmojiSuggest unzip file failed.");
                    }
                } else if (bcVar.fqf.fqh == 5) {
                    if (i.aBN().a(bcVar, i.a.EGG)) {
                        if (i.a(bcVar, i.a.EGG, i.lBC)) {
                            file4 = new File(new File(i.aBO(), i.lBC), i.lBN);
                            if (file4.exists()) {
                                i.C(file4);
                            } else {
                                x.i("MicroMsg.emoji.EmojiResUpdateMgr", "updateEmojiEgg unzip file failed.");
                            }
                        } else {
                            x.i("MicroMsg.emoji.EmojiResUpdateMgr", "updateEmojiEgg unzip file failed.");
                        }
                    }
                } else if (bcVar.fqf.fqh == 4) {
                    i.aBN();
                    x.d("MicroMsg.emoji.EmojiResUpdateMgr", "updateAppleColorEmoji");
                    if (i.d(bcVar)) {
                        com.tencent.mm.bw.b.chK();
                        str = bcVar.fqf.filePath;
                        com.tencent.mm.bw.b.chL();
                        k.fv(str, com.tencent.mm.bw.b.xsJ);
                        com.tencent.mm.bw.b.chK().init();
                    }
                }
            }
        }
        return false;
    }
}
