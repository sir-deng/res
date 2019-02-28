package com.tencent.mm.sdk.platformtools;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.os.Looper;
import android.util.LruCache;
import android.util.Xml;
import com.tencent.mm.sdk.f.e;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.CountDownLatch;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public final class an implements SharedPreferences {
    private static final Object xoH = new Object();
    private static final LruCache<String, an> xoJ = new LruCache(5);
    private static Class<?> xoK = null;
    private static Method xoL = null;
    private static Method xoM = null;
    private static boolean xoN = false;
    private static ag xoz = null;
    private Map<String, Object> gOF = null;
    private boolean gRq = false;
    private File iHM = null;
    private int mMode = 0;
    private FLock xoA = null;
    private File xoB = null;
    private boolean xoC = false;
    private int xoD = 0;
    private long xoE = 0;
    private long xoF = 0;
    private final Object xoG = new Object();
    private final WeakHashMap<OnSharedPreferenceChangeListener, Object> xoI = new WeakHashMap();

    public static class a {
        private static SharedPreferences mPref = ad.getContext().getSharedPreferences("pref_MultiProcSP_dyncfg", 4);
        public static String xoP = "pref_key_is_enable_MultiProcSP";
        public static String xoQ = "pref_key_is_disabled_MultiProcSP_manually";

        public static void lI(boolean z) {
            setValue(xoQ, z);
        }

        public static boolean cgB() {
            return !VN(xoQ) && VN(xoP);
        }

        private static boolean VN(String str) {
            SharedPreferences sharedPreferences = ad.getContext().getSharedPreferences("pref_MultiProcSP_dyncfg", 4);
            mPref = sharedPreferences;
            if (sharedPreferences == null) {
                x.w("MicroMsg.MultiProcSharedPreferences", "SharedPreferences in DynamicConfigStorage initialize failed.");
                return false;
            }
            x.d("MicroMsg.MultiProcSharedPreferences", "DynamicConfigStorage, getValue:%b", Boolean.valueOf(mPref.getBoolean(str, false)));
            return mPref.getBoolean(str, false);
        }

        public static void setValue(String str, boolean z) {
            if (mPref == null) {
                x.w("MicroMsg.MultiProcSharedPreferences", "SharedPreferences in DynamicConfigStorage initialize failed.");
                return;
            }
            Editor edit = mPref.edit();
            edit.putBoolean(str, z);
            edit.commit();
        }
    }

    private final class b implements Editor {
        private final Map<String, Object> xoR;
        private boolean xoS;

        private b() {
            this.xoR = new HashMap();
            this.xoS = false;
        }

        /* synthetic */ b(an anVar, byte b) {
            this();
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        static /* synthetic */ void a(com.tencent.mm.sdk.platformtools.an.b r5, com.tencent.mm.sdk.platformtools.an.c r6) {
            /*
            r3 = 0;
            r0 = com.tencent.mm.sdk.platformtools.an.this;
            r0 = r0.xoC;
            if (r0 == 0) goto L_0x0012;
        L_0x0009:
            r0 = com.tencent.mm.sdk.platformtools.an.this;	 Catch:{ Exception -> 0x003a }
            r0 = r0.xoA;	 Catch:{ Exception -> 0x003a }
            r0.cfH();	 Catch:{ Exception -> 0x003a }
        L_0x0012:
            r0 = com.tencent.mm.sdk.platformtools.an.this;	 Catch:{ all -> 0x00ae }
            r0 = r0.iHM;	 Catch:{ all -> 0x00ae }
            r0 = r0.exists();	 Catch:{ all -> 0x00ae }
            if (r0 == 0) goto L_0x00ca;
        L_0x001e:
            monitor-enter(r5);	 Catch:{ all -> 0x00ae }
            r0 = r6.xoX;	 Catch:{ all -> 0x00ab }
            if (r0 != 0) goto L_0x0047;
        L_0x0023:
            r0 = 1;
            r6.lJ(r0);	 Catch:{ all -> 0x00ab }
            monitor-exit(r5);	 Catch:{ all -> 0x00ab }
            r0 = com.tencent.mm.sdk.platformtools.an.this;
            r0 = r0.xoC;
            if (r0 == 0) goto L_0x0039;
        L_0x0030:
            r0 = com.tencent.mm.sdk.platformtools.an.this;	 Catch:{ Exception -> 0x01e4 }
            r0 = r0.xoA;	 Catch:{ Exception -> 0x01e4 }
            r0.unlock();	 Catch:{ Exception -> 0x01e4 }
        L_0x0039:
            return;
        L_0x003a:
            r0 = move-exception;
            r1 = "MicroMsg.MultiProcSharedPreferences";
            r2 = "";
            r3 = new java.lang.Object[r3];
            com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r1, r0, r2, r3);
            goto L_0x0012;
        L_0x0047:
            monitor-exit(r5);	 Catch:{ all -> 0x00ab }
            r0 = com.tencent.mm.sdk.platformtools.an.this;	 Catch:{ all -> 0x00ae }
            r0 = r0.xoB;	 Catch:{ all -> 0x00ae }
            r0 = r0.exists();	 Catch:{ all -> 0x00ae }
            if (r0 != 0) goto L_0x00c1;
        L_0x0054:
            r0 = com.tencent.mm.sdk.platformtools.an.this;	 Catch:{ all -> 0x00ae }
            r0 = r0.iHM;	 Catch:{ all -> 0x00ae }
            r1 = com.tencent.mm.sdk.platformtools.an.this;	 Catch:{ all -> 0x00ae }
            r1 = r1.xoB;	 Catch:{ all -> 0x00ae }
            r0 = r0.renameTo(r1);	 Catch:{ all -> 0x00ae }
            if (r0 != 0) goto L_0x00ca;
        L_0x0066:
            r0 = "MicroMsg.MultiProcSharedPreferences";
            r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00ae }
            r2 = "Couldn't rename file ";
            r1.<init>(r2);	 Catch:{ all -> 0x00ae }
            r2 = com.tencent.mm.sdk.platformtools.an.this;	 Catch:{ all -> 0x00ae }
            r2 = r2.iHM;	 Catch:{ all -> 0x00ae }
            r1 = r1.append(r2);	 Catch:{ all -> 0x00ae }
            r2 = " to backup file ";
            r1 = r1.append(r2);	 Catch:{ all -> 0x00ae }
            r2 = com.tencent.mm.sdk.platformtools.an.this;	 Catch:{ all -> 0x00ae }
            r2 = r2.xoB;	 Catch:{ all -> 0x00ae }
            r1 = r1.append(r2);	 Catch:{ all -> 0x00ae }
            r1 = r1.toString();	 Catch:{ all -> 0x00ae }
            com.tencent.mm.sdk.platformtools.x.e(r0, r1);	 Catch:{ all -> 0x00ae }
            r0 = 0;
            r6.lJ(r0);	 Catch:{ all -> 0x00ae }
            r0 = com.tencent.mm.sdk.platformtools.an.this;
            r0 = r0.xoC;
            if (r0 == 0) goto L_0x0039;
        L_0x009f:
            r0 = com.tencent.mm.sdk.platformtools.an.this;	 Catch:{ Exception -> 0x00a9 }
            r0 = r0.xoA;	 Catch:{ Exception -> 0x00a9 }
            r0.unlock();	 Catch:{ Exception -> 0x00a9 }
            goto L_0x0039;
        L_0x00a9:
            r0 = move-exception;
            goto L_0x0039;
        L_0x00ab:
            r0 = move-exception;
            monitor-exit(r5);	 Catch:{ all -> 0x00ab }
            throw r0;	 Catch:{ all -> 0x00ae }
        L_0x00ae:
            r0 = move-exception;
            r1 = com.tencent.mm.sdk.platformtools.an.this;
            r1 = r1.xoC;
            if (r1 == 0) goto L_0x00c0;
        L_0x00b7:
            r1 = com.tencent.mm.sdk.platformtools.an.this;	 Catch:{ Exception -> 0x01e1 }
            r1 = r1.xoA;	 Catch:{ Exception -> 0x01e1 }
            r1.unlock();	 Catch:{ Exception -> 0x01e1 }
        L_0x00c0:
            throw r0;
        L_0x00c1:
            r0 = com.tencent.mm.sdk.platformtools.an.this;	 Catch:{ all -> 0x00ae }
            r0 = r0.iHM;	 Catch:{ all -> 0x00ae }
            r0.delete();	 Catch:{ all -> 0x00ae }
        L_0x00ca:
            r0 = com.tencent.mm.sdk.platformtools.an.this;	 Catch:{ XmlPullParserException -> 0x0172, IOException -> 0x01d0 }
            r0 = r0.iHM;	 Catch:{ XmlPullParserException -> 0x0172, IOException -> 0x01d0 }
            r0 = r5.F(r0);	 Catch:{ XmlPullParserException -> 0x0172, IOException -> 0x01d0 }
            if (r0 != 0) goto L_0x00f0;
        L_0x00d6:
            r0 = 0;
            r6.lJ(r0);	 Catch:{ XmlPullParserException -> 0x0172, IOException -> 0x01d0 }
            r0 = com.tencent.mm.sdk.platformtools.an.this;
            r0 = r0.xoC;
            if (r0 == 0) goto L_0x0039;
        L_0x00e2:
            r0 = com.tencent.mm.sdk.platformtools.an.this;	 Catch:{ Exception -> 0x00ed }
            r0 = r0.xoA;	 Catch:{ Exception -> 0x00ed }
            r0.unlock();	 Catch:{ Exception -> 0x00ed }
            goto L_0x0039;
        L_0x00ed:
            r0 = move-exception;
            goto L_0x0039;
        L_0x00f0:
            r1 = r6.xoZ;	 Catch:{ XmlPullParserException -> 0x0172, IOException -> 0x01d0 }
            r2 = android.util.Xml.newSerializer();	 Catch:{ XmlPullParserException -> 0x0172, IOException -> 0x01d0 }
            r3 = "utf-8";
            r2.setOutput(r0, r3);	 Catch:{ XmlPullParserException -> 0x0172, IOException -> 0x01d0 }
            r3 = 0;
            r4 = 1;
            r4 = java.lang.Boolean.valueOf(r4);	 Catch:{ XmlPullParserException -> 0x0172, IOException -> 0x01d0 }
            r2.startDocument(r3, r4);	 Catch:{ XmlPullParserException -> 0x0172, IOException -> 0x01d0 }
            r3 = "http://xmlpull.org/v1/doc/features.html#indent-output";
            r4 = 1;
            r2.setFeature(r3, r4);	 Catch:{ XmlPullParserException -> 0x0172, IOException -> 0x01d0 }
            r3 = 0;
            com.tencent.mm.sdk.platformtools.bk.a(r1, r3, r2);	 Catch:{ XmlPullParserException -> 0x0172, IOException -> 0x01d0 }
            r2.endDocument();	 Catch:{ XmlPullParserException -> 0x0172, IOException -> 0x01d0 }
            r1 = r0.getFD();	 Catch:{ XmlPullParserException -> 0x0172, IOException -> 0x01d0 }
            r1.sync();	 Catch:{ XmlPullParserException -> 0x0172, IOException -> 0x01d0 }
            r0.close();	 Catch:{ XmlPullParserException -> 0x0172, IOException -> 0x01d0 }
            r0 = com.tencent.mm.sdk.platformtools.an.this;	 Catch:{ XmlPullParserException -> 0x0172, IOException -> 0x01d0 }
            r0 = r0.iHM;	 Catch:{ XmlPullParserException -> 0x0172, IOException -> 0x01d0 }
            r1 = com.tencent.mm.sdk.platformtools.an.this;	 Catch:{ XmlPullParserException -> 0x0172, IOException -> 0x01d0 }
            r1 = r1.mMode;	 Catch:{ XmlPullParserException -> 0x0172, IOException -> 0x01d0 }
            com.tencent.mm.sdk.platformtools.an.g(r0, r1);	 Catch:{ XmlPullParserException -> 0x0172, IOException -> 0x01d0 }
            monitor-enter(r5);	 Catch:{ XmlPullParserException -> 0x0172, IOException -> 0x01d0 }
            r0 = com.tencent.mm.sdk.platformtools.an.this;	 Catch:{ all -> 0x016f }
            r1 = com.tencent.mm.sdk.platformtools.an.this;	 Catch:{ all -> 0x016f }
            r1 = r1.iHM;	 Catch:{ all -> 0x016f }
            r2 = r1.lastModified();	 Catch:{ all -> 0x016f }
            r0.xoE = r2;	 Catch:{ all -> 0x016f }
            r0 = com.tencent.mm.sdk.platformtools.an.this;	 Catch:{ all -> 0x016f }
            r1 = com.tencent.mm.sdk.platformtools.an.this;	 Catch:{ all -> 0x016f }
            r1 = r1.iHM;	 Catch:{ all -> 0x016f }
            r2 = r1.length();	 Catch:{ all -> 0x016f }
            r0.xoF = r2;	 Catch:{ all -> 0x016f }
            monitor-exit(r5);	 Catch:{ all -> 0x016f }
            r0 = com.tencent.mm.sdk.platformtools.an.this;	 Catch:{ XmlPullParserException -> 0x0172, IOException -> 0x01d0 }
            r0 = r0.xoB;	 Catch:{ XmlPullParserException -> 0x0172, IOException -> 0x01d0 }
            r0.delete();	 Catch:{ XmlPullParserException -> 0x0172, IOException -> 0x01d0 }
            r0 = 1;
            r6.lJ(r0);	 Catch:{ XmlPullParserException -> 0x0172, IOException -> 0x01d0 }
            r0 = com.tencent.mm.sdk.platformtools.an.this;
            r0 = r0.xoC;
            if (r0 == 0) goto L_0x0039;
        L_0x0161:
            r0 = com.tencent.mm.sdk.platformtools.an.this;	 Catch:{ Exception -> 0x016c }
            r0 = r0.xoA;	 Catch:{ Exception -> 0x016c }
            r0.unlock();	 Catch:{ Exception -> 0x016c }
            goto L_0x0039;
        L_0x016c:
            r0 = move-exception;
            goto L_0x0039;
        L_0x016f:
            r0 = move-exception;
            monitor-exit(r5);	 Catch:{ all -> 0x016f }
            throw r0;	 Catch:{ XmlPullParserException -> 0x0172, IOException -> 0x01d0 }
        L_0x0172:
            r0 = move-exception;
            r1 = "MicroMsg.MultiProcSharedPreferences";
            r2 = "writeToFile: Got exception:";
            r3 = 1;
            r3 = new java.lang.Object[r3];	 Catch:{ all -> 0x00ae }
            r4 = 0;
            r3[r4] = r0;	 Catch:{ all -> 0x00ae }
            com.tencent.mm.sdk.platformtools.x.w(r1, r2, r3);	 Catch:{ all -> 0x00ae }
        L_0x0182:
            r0 = com.tencent.mm.sdk.platformtools.an.this;	 Catch:{ all -> 0x00ae }
            r0 = r0.iHM;	 Catch:{ all -> 0x00ae }
            r0 = r0.exists();	 Catch:{ all -> 0x00ae }
            if (r0 == 0) goto L_0x01b6;
        L_0x018e:
            r0 = com.tencent.mm.sdk.platformtools.an.this;	 Catch:{ all -> 0x00ae }
            r0 = r0.iHM;	 Catch:{ all -> 0x00ae }
            r0 = r0.delete();	 Catch:{ all -> 0x00ae }
            if (r0 != 0) goto L_0x01b6;
        L_0x019a:
            r0 = "MicroMsg.MultiProcSharedPreferences";
            r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00ae }
            r2 = "Couldn't clean up partially-written file ";
            r1.<init>(r2);	 Catch:{ all -> 0x00ae }
            r2 = com.tencent.mm.sdk.platformtools.an.this;	 Catch:{ all -> 0x00ae }
            r2 = r2.iHM;	 Catch:{ all -> 0x00ae }
            r1 = r1.append(r2);	 Catch:{ all -> 0x00ae }
            r1 = r1.toString();	 Catch:{ all -> 0x00ae }
            com.tencent.mm.sdk.platformtools.x.e(r0, r1);	 Catch:{ all -> 0x00ae }
        L_0x01b6:
            r0 = 0;
            r6.lJ(r0);	 Catch:{ all -> 0x00ae }
            r0 = com.tencent.mm.sdk.platformtools.an.this;
            r0 = r0.xoC;
            if (r0 == 0) goto L_0x0039;
        L_0x01c2:
            r0 = com.tencent.mm.sdk.platformtools.an.this;	 Catch:{ Exception -> 0x01cd }
            r0 = r0.xoA;	 Catch:{ Exception -> 0x01cd }
            r0.unlock();	 Catch:{ Exception -> 0x01cd }
            goto L_0x0039;
        L_0x01cd:
            r0 = move-exception;
            goto L_0x0039;
        L_0x01d0:
            r0 = move-exception;
            r1 = "MicroMsg.MultiProcSharedPreferences";
            r2 = "writeToFile: Got exception:";
            r3 = 1;
            r3 = new java.lang.Object[r3];	 Catch:{ all -> 0x00ae }
            r4 = 0;
            r3[r4] = r0;	 Catch:{ all -> 0x00ae }
            com.tencent.mm.sdk.platformtools.x.w(r1, r2, r3);	 Catch:{ all -> 0x00ae }
            goto L_0x0182;
        L_0x01e1:
            r1 = move-exception;
            goto L_0x00c0;
        L_0x01e4:
            r0 = move-exception;
            goto L_0x0039;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.sdk.platformtools.an.b.a(com.tencent.mm.sdk.platformtools.an$b, com.tencent.mm.sdk.platformtools.an$c):void");
        }

        public final Editor putString(String str, String str2) {
            synchronized (this) {
                this.xoR.put(str, str2);
            }
            return this;
        }

        public final Editor putStringSet(String str, Set<String> set) {
            synchronized (this) {
                this.xoR.put(str, set);
            }
            return this;
        }

        public final Editor putInt(String str, int i) {
            synchronized (this) {
                this.xoR.put(str, Integer.valueOf(i));
            }
            return this;
        }

        public final Editor putLong(String str, long j) {
            synchronized (this) {
                this.xoR.put(str, Long.valueOf(j));
            }
            return this;
        }

        public final Editor putFloat(String str, float f) {
            synchronized (this) {
                this.xoR.put(str, Float.valueOf(f));
            }
            return this;
        }

        public final Editor putBoolean(String str, boolean z) {
            synchronized (this) {
                this.xoR.put(str, Boolean.valueOf(z));
            }
            return this;
        }

        public final Editor remove(String str) {
            synchronized (this) {
                this.xoR.put(str, this);
            }
            return this;
        }

        public final Editor clear() {
            synchronized (this) {
                this.xoS = true;
            }
            return this;
        }

        public final boolean commit() {
            c cgC = cgC();
            a(cgC, null);
            try {
                cgC.xpa.await();
                a(cgC);
                return cgC.xpb;
            } catch (InterruptedException e) {
                return false;
            }
        }

        public final void apply() {
            final c cgC = cgC();
            final Runnable anonymousClass1 = new Runnable() {
                public final void run() {
                    try {
                        cgC.xpa.await();
                    } catch (InterruptedException e) {
                    }
                }
            };
            au.M(anonymousClass1);
            a(cgC, new Runnable() {
                public final void run() {
                    anonymousClass1.run();
                    au.N(anonymousClass1);
                }
            });
            a(cgC);
        }

        private c cgC() {
            c cVar = new c();
            synchronized (an.this) {
                if (an.this.xoD > 0) {
                    an.this.gOF = new HashMap(an.this.gOF);
                }
                cVar.xoZ = an.this.gOF;
                an.this.xoD = an.this.xoD + 1;
                byte b = an.this.xoI.size() > 0 ? (byte) 1 : (byte) 0;
                if (b != (byte) 0) {
                    cVar.xoY = new ArrayList();
                    cVar.gDT = new HashSet(an.this.xoI.keySet());
                }
                synchronized (this) {
                    if (this.xoS) {
                        if (!an.this.gOF.isEmpty()) {
                            cVar.xoX = true;
                            an.this.gOF.clear();
                        }
                        this.xoS = false;
                    }
                    for (Entry entry : this.xoR.entrySet()) {
                        String str = (String) entry.getKey();
                        b value = entry.getValue();
                        if (value != this) {
                            if (an.this.gOF.containsKey(str)) {
                                Object obj = an.this.gOF.get(str);
                                if (obj != null && obj.equals(value)) {
                                }
                            }
                            an.this.gOF.put(str, value);
                        } else if (an.this.gOF.containsKey(str)) {
                            an.this.gOF.remove(str);
                        }
                        cVar.xoX = true;
                        if (b != (byte) 0) {
                            cVar.xoY.add(str);
                        }
                    }
                    this.xoR.clear();
                }
            }
            return cVar;
        }

        private void a(final c cVar, final Runnable runnable) {
            Object obj = 1;
            Runnable anonymousClass3 = new Runnable() {
                public final void run() {
                    synchronized (an.this.xoG) {
                        b.a(b.this, cVar);
                    }
                    synchronized (an.this) {
                        an.this.xoD = an.this.xoD - 1;
                    }
                    if (runnable != null) {
                        runnable.run();
                    }
                }
            };
            if ((runnable == null ? 1 : null) != null) {
                synchronized (an.this) {
                    if (an.this.xoD != 1) {
                        obj = null;
                    }
                }
                if (obj != null) {
                    anonymousClass3.run();
                    return;
                }
            }
            au.cgH().execute(anonymousClass3);
        }

        private FileOutputStream F(File file) {
            try {
                return new FileOutputStream(file);
            } catch (FileNotFoundException e) {
                File parentFile = file.getParentFile();
                if (parentFile.mkdir()) {
                    an.g(parentFile, an.this.mMode);
                    try {
                        return new FileOutputStream(file);
                    } catch (FileNotFoundException e2) {
                        x.e("MicroMsg.MultiProcSharedPreferences", "Couldn't create SharedPreferences file " + file, e2);
                        return null;
                    }
                }
                x.e("MicroMsg.MultiProcSharedPreferences", "Couldn't create directory for SharedPreferences file " + file);
                return null;
            }
        }

        private void a(final c cVar) {
            if (cVar.gDT != null && cVar.xoY != null && cVar.xoY.size() != 0) {
                if (Looper.myLooper() == Looper.getMainLooper()) {
                    for (int size = cVar.xoY.size() - 1; size >= 0; size--) {
                        String str = (String) cVar.xoY.get(size);
                        for (OnSharedPreferenceChangeListener onSharedPreferenceChangeListener : cVar.gDT) {
                            if (onSharedPreferenceChangeListener != null) {
                                onSharedPreferenceChangeListener.onSharedPreferenceChanged(an.this, str);
                            }
                        }
                    }
                    return;
                }
                an.xoz.post(new Runnable() {
                    public final void run() {
                        b.this.a(cVar);
                    }
                });
            }
        }
    }

    private static class c {
        public Set<OnSharedPreferenceChangeListener> gDT;
        public boolean xoX;
        public List<String> xoY;
        public Map<String, Object> xoZ;
        public final CountDownLatch xpa;
        public volatile boolean xpb;

        private c() {
            this.xoX = false;
            this.xoY = null;
            this.gDT = null;
            this.xoZ = null;
            this.xpa = new CountDownLatch(1);
            this.xpb = false;
        }

        /* synthetic */ c(byte b) {
            this();
        }

        public final void lJ(boolean z) {
            this.xpb = z;
            this.xpa.countDown();
        }
    }

    static /* synthetic */ void a(an anVar) {
        Object obj;
        XmlPullParserException e;
        FileNotFoundException e2;
        IOException e3;
        Map obj2 = null;
        if (anVar.xoC) {
            try {
                anVar.xoA.cfF();
            } catch (Throwable e4) {
                x.printErrStackTrace("MicroMsg.MultiProcSharedPreferences", e4, "", new Object[0]);
            }
        }
        try {
            if (!anVar.gRq) {
                if (anVar.xoB.exists()) {
                    anVar.iHM.delete();
                    anVar.xoB.renameTo(anVar.iHM);
                }
                if (anVar.iHM.exists() && !anVar.iHM.canRead()) {
                    x.w("MicroMsg.MultiProcSharedPreferences", "Attempt to read preferences file " + anVar.iHM + " without permission");
                }
                if (anVar.iHM.canRead()) {
                    InputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(anVar.iHM), 16384);
                    XmlPullParser newPullParser = Xml.newPullParser();
                    newPullParser.setInput(bufferedInputStream, null);
                    HashMap hashMap = (HashMap) bk.a(newPullParser, new String[1]);
                    try {
                        bufferedInputStream.close();
                        obj2 = hashMap;
                    } catch (XmlPullParserException e5) {
                        XmlPullParserException xmlPullParserException = e5;
                        obj2 = hashMap;
                        e = xmlPullParserException;
                        x.w("MicroMsg.MultiProcSharedPreferences", "getSharedPreferences", e);
                        anVar.gRq = true;
                        if (obj2 != null) {
                            anVar.gOF = new HashMap();
                        } else {
                            anVar.gOF = obj2;
                            anVar.xoE = anVar.iHM.lastModified();
                            anVar.xoF = anVar.iHM.length();
                        }
                        anVar.notifyAll();
                        if (!anVar.xoC) {
                            try {
                                anVar.xoA.unlock();
                            } catch (Exception e6) {
                                return;
                            }
                        }
                    } catch (FileNotFoundException e7) {
                        FileNotFoundException fileNotFoundException = e7;
                        obj2 = hashMap;
                        e2 = fileNotFoundException;
                        x.w("MicroMsg.MultiProcSharedPreferences", "getSharedPreferences", e2);
                        anVar.gRq = true;
                        if (obj2 != null) {
                            anVar.gOF = obj2;
                            anVar.xoE = anVar.iHM.lastModified();
                            anVar.xoF = anVar.iHM.length();
                        } else {
                            anVar.gOF = new HashMap();
                        }
                        anVar.notifyAll();
                        if (!anVar.xoC) {
                            anVar.xoA.unlock();
                        }
                    } catch (IOException e8) {
                        IOException iOException = e8;
                        obj2 = hashMap;
                        e3 = iOException;
                        x.w("MicroMsg.MultiProcSharedPreferences", "getSharedPreferences", e3);
                        anVar.gRq = true;
                        if (obj2 != null) {
                            anVar.gOF = new HashMap();
                        } else {
                            anVar.gOF = obj2;
                            anVar.xoE = anVar.iHM.lastModified();
                            anVar.xoF = anVar.iHM.length();
                        }
                        anVar.notifyAll();
                        if (!anVar.xoC) {
                            anVar.xoA.unlock();
                        }
                    }
                }
                anVar.gRq = true;
                if (obj2 != null) {
                    anVar.gOF = obj2;
                    anVar.xoE = anVar.iHM.lastModified();
                    anVar.xoF = anVar.iHM.length();
                } else {
                    anVar.gOF = new HashMap();
                }
                anVar.notifyAll();
                if (!anVar.xoC) {
                    anVar.xoA.unlock();
                }
            } else if (anVar.xoC) {
                try {
                    anVar.xoA.unlock();
                } catch (Exception e9) {
                }
            }
        } catch (XmlPullParserException e10) {
            e = e10;
            x.w("MicroMsg.MultiProcSharedPreferences", "getSharedPreferences", e);
            anVar.gRq = true;
            if (obj2 != null) {
                anVar.gOF = obj2;
                anVar.xoE = anVar.iHM.lastModified();
                anVar.xoF = anVar.iHM.length();
            } else {
                anVar.gOF = new HashMap();
            }
            anVar.notifyAll();
            if (!anVar.xoC) {
                anVar.xoA.unlock();
            }
        } catch (FileNotFoundException e11) {
            e2 = e11;
            x.w("MicroMsg.MultiProcSharedPreferences", "getSharedPreferences", e2);
            anVar.gRq = true;
            if (obj2 != null) {
                anVar.gOF = new HashMap();
            } else {
                anVar.gOF = obj2;
                anVar.xoE = anVar.iHM.lastModified();
                anVar.xoF = anVar.iHM.length();
            }
            anVar.notifyAll();
            if (!anVar.xoC) {
                anVar.xoA.unlock();
            }
        } catch (IOException e12) {
            e3 = e12;
            x.w("MicroMsg.MultiProcSharedPreferences", "getSharedPreferences", e3);
            anVar.gRq = true;
            if (obj2 != null) {
                anVar.gOF = obj2;
                anVar.xoE = anVar.iHM.lastModified();
                anVar.xoF = anVar.iHM.length();
            } else {
                anVar.gOF = new HashMap();
            }
            anVar.notifyAll();
            if (!anVar.xoC) {
                anVar.xoA.unlock();
            }
        } catch (Throwable th) {
            if (anVar.xoC) {
                try {
                    anVar.xoA.unlock();
                } catch (Exception e13) {
                }
            }
        }
    }

    static /* synthetic */ void g(File file, int i) {
        boolean z = false;
        file.setReadable(true, (i & 1) == 0);
        if ((i & 2) == 0) {
            z = true;
        }
        file.setWritable(true, z);
    }

    public static SharedPreferences bh(Context context, String str) {
        int i = 1;
        if (a.cgB()) {
            x.i("MicroMsg.MultiProcSharedPreferences", "sp: %s, use Flock version MultiProcessSP.", str);
            an anVar = (an) xoJ.get(str);
            if (anVar == null) {
                SharedPreferences anVar2 = new an(context, str, 4);
                xoJ.put(str, anVar2);
                return anVar2;
            }
            synchronized (anVar) {
                if (anVar.xoD > 0 || (anVar.xoE == anVar.iHM.lastModified() && anVar.xoF == anVar.iHM.length())) {
                    i = 0;
                }
                if (i == 0) {
                    return anVar;
                }
                anVar.cgy();
                return anVar;
            }
        }
        x.i("MicroMsg.MultiProcSharedPreferences", "sp: %s, use system sp.", str);
        return context.getSharedPreferences(str, 4);
    }

    private an() {
        throw new RuntimeException("Not supported.");
    }

    private an(Context context, String str, int i) {
        Context applicationContext = context.getApplicationContext();
        if (xoz == null) {
            xoz = new ag(Looper.getMainLooper());
        }
        String str2 = applicationContext.getApplicationInfo().dataDir;
        if (str2 == null || str2.length() == 0) {
            x.w("MicroMsg.MultiProcSharedPreferences", "Failed to retrive data path by ApplicationInfo.dataDir, use prefix hardcoded version instead.");
            str2 = "/data/data/" + applicationContext.getPackageName();
        }
        x.i("MicroMsg.MultiProcSharedPreferences", "Path to store sp data: " + str2);
        File file = new File(str2, "shared_prefs");
        if (!file.exists()) {
            file.mkdirs();
        } else if (!(file.canRead() && file.canWrite())) {
            file.setReadable(true, true);
            file.setWritable(true, true);
        }
        this.iHM = new File(file, str + ".xml");
        this.xoB = new File(this.iHM.getPath() + ".bak");
        this.mMode = 4;
        this.xoC = true;
        if (this.xoC) {
            this.xoA = new FLock(this.iHM.getPath() + ".lock");
        }
        cgy();
    }

    private void cgy() {
        synchronized (this) {
            this.gRq = false;
        }
        e.b(new Runnable() {
            public final void run() {
                synchronized (an.this) {
                    an.a(an.this);
                }
            }
        }, "MultiProcessSP-LoadThread").start();
    }

    public final void registerOnSharedPreferenceChangeListener(OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        synchronized (this) {
            this.xoI.put(onSharedPreferenceChangeListener, xoH);
        }
    }

    public final void unregisterOnSharedPreferenceChangeListener(OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        synchronized (this) {
            this.xoI.remove(onSharedPreferenceChangeListener);
        }
    }

    private void cgz() {
        if (!(this.gRq || xoN)) {
            if (xoK == null) {
                try {
                    xoK = Class.forName("dalvik.system.BlockGuard");
                } catch (Throwable th) {
                    xoN = true;
                }
            }
            if (xoL == null) {
                try {
                    Method declaredMethod = xoK.getDeclaredMethod("getThreadPolicy", new Class[0]);
                    xoL = declaredMethod;
                    declaredMethod.setAccessible(true);
                } catch (Throwable th2) {
                    xoN = true;
                }
            }
            try {
                if (xoL != null) {
                    Object invoke = xoL.invoke(null, new Object[0]);
                    if (xoM == null) {
                        Method declaredMethod2 = invoke.getClass().getDeclaredMethod("onReadFromDisk", new Class[0]);
                        xoM = declaredMethod2;
                        declaredMethod2.setAccessible(true);
                    }
                    xoM.invoke(invoke, new Object[0]);
                }
            } catch (Throwable th3) {
                xoN = true;
            }
        }
        while (!this.gRq) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
    }

    public final Map<String, ?> getAll() {
        Map hashMap;
        synchronized (this) {
            cgz();
            hashMap = new HashMap(this.gOF);
        }
        return hashMap;
    }

    public final String getString(String str, String str2) {
        String str3;
        synchronized (this) {
            cgz();
            str3 = (String) this.gOF.get(str);
            if (str3 == null) {
                str3 = str2;
            }
        }
        return str3;
    }

    public final Set<String> getStringSet(String str, Set<String> set) {
        Set<String> set2;
        synchronized (this) {
            cgz();
            set2 = (Set) this.gOF.get(str);
            if (set2 == null) {
                set2 = set;
            }
        }
        return set2;
    }

    public final int getInt(String str, int i) {
        synchronized (this) {
            cgz();
            Integer num = (Integer) this.gOF.get(str);
            if (num != null) {
                i = num.intValue();
            }
        }
        return i;
    }

    public final long getLong(String str, long j) {
        synchronized (this) {
            cgz();
            Long l = (Long) this.gOF.get(str);
            if (l != null) {
                j = l.longValue();
            }
        }
        return j;
    }

    public final float getFloat(String str, float f) {
        synchronized (this) {
            cgz();
            Float f2 = (Float) this.gOF.get(str);
            if (f2 != null) {
                f = f2.floatValue();
            }
        }
        return f;
    }

    public final boolean getBoolean(String str, boolean z) {
        synchronized (this) {
            cgz();
            Boolean bool = (Boolean) this.gOF.get(str);
            if (bool != null) {
                z = bool.booleanValue();
            }
        }
        return z;
    }

    public final boolean contains(String str) {
        boolean containsKey;
        synchronized (this) {
            cgz();
            containsKey = this.gOF.containsKey(str);
        }
        return containsKey;
    }

    public final Editor edit() {
        synchronized (this) {
            cgz();
        }
        return new b();
    }
}
