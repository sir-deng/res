package com.tencent.mm.plugin.appbrand.jsapi.voicejoint.d;

import android.content.Context;
import com.tencent.mm.a.e;
import com.tencent.mm.audio.c.d;
import com.tencent.mm.compatible.util.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObjectManager;
import com.tencent.mm.plugin.appbrand.j;
import com.tencent.mm.plugin.appbrand.jsapi.voicejoint.a.c;
import com.tencent.mm.plugin.appbrand.jsapi.voicejoint.b.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.i;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.t;
import com.tencent.mm.y.o;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Arrays;

public final class a {
    private static boolean jyS = false;
    private static int sampleRate = -1;

    private static String ahZ() {
        if (jyS) {
            return h.getExternalStorageDirectory().getAbsolutePath() + File.separator + "voice_split_joint/";
        }
        return ad.getContext().getFilesDir().getParent() + File.separator + "voice_split_joint/";
    }

    public static String la(int i) {
        if (i == 100) {
            return ahZ() + "voicesplitmodel.bin";
        }
        if (i == 101) {
            return ahZ() + "voiceblackmodel.bin";
        }
        return null;
    }

    public static String lb(int i) {
        String str = aia() + i + File.separator;
        i.QZ(str);
        return str;
    }

    private static String aia() {
        String str = ahZ() + "silk_voice/";
        i.QZ(str);
        return str;
    }

    private static String aib() {
        String str = ahZ() + "temp/";
        i.QZ(str);
        return str;
    }

    public static String bO(int i, int i2) {
        if (i == 100) {
            return ahZ() + i2 + "voicesplitmodel.bin";
        }
        if (i == 101) {
            return ahZ() + i2 + "voiceblackmodel.bin";
        }
        return null;
    }

    public static void O(int i, String str) {
        t Db = g.Dq().Db();
        if (Db == null) {
            return;
        }
        if (i == 100) {
            Db.a(com.tencent.mm.storage.w.a.USERINFO_V8_CURRENT_USED_VOICE_SPLIT_MODEL_PATH_STRING_SYNC, (Object) str);
        } else if (i == 101) {
            Db.a(com.tencent.mm.storage.w.a.USERINFO_V8_CURRENT_USED_VOICE_BLACK_MODEL_PATH_STRING_SYNC, (Object) str);
        }
    }

    public static String lc(int i) {
        t Db = g.Dq().Db();
        if (Db != null) {
            if (i == 100) {
                return (String) Db.get(com.tencent.mm.storage.w.a.USERINFO_V8_CURRENT_USED_VOICE_SPLIT_MODEL_PATH_STRING_SYNC, la(i));
            }
            if (i == 101) {
                return (String) Db.get(com.tencent.mm.storage.w.a.USERINFO_V8_CURRENT_USED_VOICE_BLACK_MODEL_PATH_STRING_SYNC, la(i));
            }
        }
        return null;
    }

    public static void aic() {
        try {
            e.c(ahZ(), aid(), aia(), aib());
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.VoiceJointUtils", e, "alvinluo create voice directory exception", new Object[0]);
        }
    }

    public static void m(Context context, String str, String str2) {
        Throwable e;
        InputStream inputStream = null;
        x.i("MicroMsg.VoiceJointUtils", "alvinluo copyFileFromAssets src: %s, dst: %s", str, str2);
        InputStream open;
        FileOutputStream fileOutputStream;
        try {
            File file = new File(str2);
            open = context.getAssets().open(str);
            try {
                fileOutputStream = new FileOutputStream(file);
                try {
                    byte[] bArr = new byte[WXMediaMessage.DESCRIPTION_LENGTH_LIMIT];
                    while (true) {
                        int read = open.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        fileOutputStream.write(bArr, 0, read);
                    }
                    fileOutputStream.flush();
                    x.i("MicroMsg.VoiceJointUtils", "alvinluo copyFileFromAssets %s successfully, file len: %d", str, Long.valueOf(file.length()));
                    if (open != null) {
                        try {
                            open.close();
                        } catch (Exception e2) {
                            return;
                        }
                    }
                    fileOutputStream.close();
                } catch (Exception e3) {
                    e = e3;
                    inputStream = open;
                    try {
                        x.printErrStackTrace("MicroMsg.VoiceJointUtils", e, "alvinluo copyFileFromAssets exception", new Object[0]);
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Exception e4) {
                                return;
                            }
                        }
                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                        }
                    } catch (Throwable th) {
                        e = th;
                        open = inputStream;
                        if (open != null) {
                            try {
                                open.close();
                            } catch (Exception e5) {
                                throw e;
                            }
                        }
                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                        }
                        throw e;
                    }
                } catch (Throwable th2) {
                    e = th2;
                    if (open != null) {
                        open.close();
                    }
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    throw e;
                }
            } catch (Exception e6) {
                e = e6;
                fileOutputStream = null;
                inputStream = open;
                x.printErrStackTrace("MicroMsg.VoiceJointUtils", e, "alvinluo copyFileFromAssets exception", new Object[0]);
                if (inputStream != null) {
                    inputStream.close();
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
            } catch (Throwable th3) {
                e = th3;
                fileOutputStream = null;
                if (open != null) {
                    open.close();
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                throw e;
            }
        } catch (Exception e7) {
            e = e7;
            fileOutputStream = null;
        } catch (Throwable th4) {
            e = th4;
            fileOutputStream = null;
            open = null;
            if (open != null) {
                open.close();
            }
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
            throw e;
        }
    }

    private static boolean a(byte[] bArr, int i, String str) {
        x.d("MicroMsg.VoiceJointUtils", "alvinluo pcm save as silk file");
        if (bi.by(bArr)) {
            return false;
        }
        try {
            x.i("MicroMsg.VoiceJointUtils", "alvinluo savePcmAsSilk dynamicSample: %s sampleRate: %d dynamicEncoding: %s audioEncoding: %d", ((com.tencent.mm.plugin.zero.b.a) g.h(com.tencent.mm.plugin.zero.b.a.class)).Af().getValue("VoiceSamplingRate"), Integer.valueOf(bi.getInt(((com.tencent.mm.plugin.zero.b.a) g.h(com.tencent.mm.plugin.zero.b.a.class)).Af().getValue("VoiceSamplingRate"), 16000)), r0, Integer.valueOf(bi.getInt(((com.tencent.mm.plugin.zero.b.a) g.h(com.tencent.mm.plugin.zero.b.a.class)).Af().getValue("VoiceRate"), 16000)));
            d dVar = new d(r4, r5);
            dVar.cL(str);
            dVar.b(bArr, i, true);
            dVar.vK();
            return true;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.VoiceJointUtils", e, "alvinluo savePcmAsSilk exception", new Object[0]);
            return false;
        }
    }

    public static boolean b(byte[] bArr, int i, String str) {
        try {
            if (bi.by(bArr)) {
                x.e("MicroMsg.VoiceJointUtils", "alvinluo savePcmAsWAV pcmData is null");
                return false;
            } else if (bi.oN(str)) {
                x.e("MicroMsg.VoiceJointUtils", "alvinluo savePcmAsWAV wavFileName is null");
                return false;
            } else {
                if (sampleRate == -1) {
                    sampleRate = bi.getInt(((com.tencent.mm.plugin.zero.b.a) g.h(com.tencent.mm.plugin.zero.b.a.class)).Af().getValue("VoiceSamplingRate"), 16000);
                }
                x.i("MicroMsg.VoiceJointUtils", "alvinluo savePcmAsWAV sampleRate: %d, channel: %d", Integer.valueOf(sampleRate), Integer.valueOf(1));
                byte[] c = c.c(bArr, (long) sampleRate);
                if (c != null) {
                    x.i("MicroMsg.VoiceJointUtils", "alvinluo savePcmAsWAV success");
                    e.b(str, c, c.length);
                    return true;
                }
                x.e("MicroMsg.VoiceJointUtils", "alvinluo encode pcm to wav failed");
                return false;
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.VoiceJointUtils", e, "alvinluo savePcmAsWAV exception", new Object[0]);
            return false;
        }
    }

    public static boolean bw(String str, String str2) {
        byte[] d = e.d(str, 0, -1);
        if (d != null) {
            return b(d, d.length, str2);
        }
        return false;
    }

    public static boolean c(byte[] bArr, int i, String str) {
        byte[] copyOfRange = Arrays.copyOfRange(bArr, 44, i);
        return a(copyOfRange, copyOfRange.length, str);
    }

    public static String ts(String str) {
        return aib() + o.k(str, bi.Wy());
    }

    public static boolean tt(String str) {
        return (str.startsWith("http") || str.startsWith("https") || str.startsWith(AppBrandLocalMediaObjectManager.OBJECT_NAME_PREFIX)) ? false : true;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void f(com.tencent.mm.plugin.appbrand.j r6, java.lang.String r7, java.lang.String r8) {
        /*
        r2 = 0;
        if (r6 != 0) goto L_0x0004;
    L_0x0003:
        return;
    L_0x0004:
        r0 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;
        r0 = new byte[r0];	 Catch:{ Exception -> 0x0063, all -> 0x004b }
        r1 = r6.iuk;	 Catch:{ Exception -> 0x0063, all -> 0x004b }
        r3 = com.tencent.mm.plugin.appbrand.appcache.ao.d(r1, r7);	 Catch:{ Exception -> 0x0063, all -> 0x004b }
        r1 = new java.io.FileOutputStream;	 Catch:{ Exception -> 0x0066, all -> 0x005a }
        r1.<init>(r8);	 Catch:{ Exception -> 0x0066, all -> 0x005a }
    L_0x0013:
        r2 = 0;
        r4 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;
        r2 = r3.read(r0, r2, r4);	 Catch:{ Exception -> 0x0022, all -> 0x005e }
        r4 = -1;
        if (r2 == r4) goto L_0x003d;
    L_0x001d:
        r4 = 0;
        r1.write(r0, r4, r2);	 Catch:{ Exception -> 0x0022, all -> 0x005e }
        goto L_0x0013;
    L_0x0022:
        r0 = move-exception;
        r2 = r3;
    L_0x0024:
        r3 = "MicroMsg.VoiceJointUtils";
        r4 = "alvinluo saveToLocalFile exception";
        r5 = 0;
        r5 = new java.lang.Object[r5];	 Catch:{ all -> 0x0061 }
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r3, r0, r4, r5);	 Catch:{ all -> 0x0061 }
        if (r2 == 0) goto L_0x0035;
    L_0x0032:
        r2.close();	 Catch:{ Exception -> 0x003b }
    L_0x0035:
        if (r1 == 0) goto L_0x0003;
    L_0x0037:
        r1.close();	 Catch:{ Exception -> 0x003b }
        goto L_0x0003;
    L_0x003b:
        r0 = move-exception;
        goto L_0x0003;
    L_0x003d:
        r1.flush();	 Catch:{ Exception -> 0x0022, all -> 0x005e }
        if (r3 == 0) goto L_0x0045;
    L_0x0042:
        r3.close();	 Catch:{ Exception -> 0x0049 }
    L_0x0045:
        r1.close();	 Catch:{ Exception -> 0x0049 }
        goto L_0x0003;
    L_0x0049:
        r0 = move-exception;
        goto L_0x0003;
    L_0x004b:
        r0 = move-exception;
        r1 = r2;
    L_0x004d:
        if (r2 == 0) goto L_0x0052;
    L_0x004f:
        r2.close();	 Catch:{ Exception -> 0x0058 }
    L_0x0052:
        if (r1 == 0) goto L_0x0057;
    L_0x0054:
        r1.close();	 Catch:{ Exception -> 0x0058 }
    L_0x0057:
        throw r0;
    L_0x0058:
        r1 = move-exception;
        goto L_0x0057;
    L_0x005a:
        r0 = move-exception;
        r1 = r2;
        r2 = r3;
        goto L_0x004d;
    L_0x005e:
        r0 = move-exception;
        r2 = r3;
        goto L_0x004d;
    L_0x0061:
        r0 = move-exception;
        goto L_0x004d;
    L_0x0063:
        r0 = move-exception;
        r1 = r2;
        goto L_0x0024;
    L_0x0066:
        r0 = move-exception;
        r1 = r2;
        r2 = r3;
        goto L_0x0024;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.jsapi.voicejoint.d.a.f(com.tencent.mm.plugin.appbrand.j, java.lang.String, java.lang.String):void");
    }

    public static void a(String str, String str2, final b bVar) {
        com.tencent.mm.sdk.f.e.post(new com.tencent.mm.audio.voicejoint.model.d.AnonymousClass1(new com.tencent.mm.plugin.appbrand.jsapi.voicejoint.c.a(str, str2), new com.tencent.mm.audio.voicejoint.model.d.b() {
            public final void vI() {
                x.i("MicroMsg.VoiceJointUtils", "alvinluo silkToPcm success");
                if (bVar != null) {
                    bVar.onSuccess();
                }
            }

            public final void vJ() {
                x.e("MicroMsg.VoiceJointUtils", "alvinluo silkToPcm failed");
                if (bVar != null) {
                    bVar.ahO();
                }
            }
        }), "VoiceAsyncProcessTask");
    }

    public static String tu(String str) {
        return com.tencent.mm.a.g.s((bi.Wz() + ", " + str).getBytes());
    }

    public static String aid() {
        String str = ahZ() + "download/";
        i.QZ(str);
        return str;
    }

    public static String P(int i, String str) {
        return lb(i) + str;
    }

    public static String Q(int i, String str) {
        return aia() + ac.VF(i + str) + ".pcm";
    }

    public static String c(j jVar, String str) {
        if (bi.oN(str) || jVar == null) {
            return null;
        }
        if (jVar.iuk == null || jVar.iuk.isU == null) {
            x.e("MicroMsg.VoiceJointUtils", "alvinluo runtime or fileSystem is null");
            return null;
        }
        File ql = jVar.iuk.isU.ql(str);
        if (ql == null || !ql.exists()) {
            return null;
        }
        return ql.getAbsolutePath();
    }
}
