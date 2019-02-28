package com.google.android.exoplayer2.e;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.media.MediaCodecInfo;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaCodecInfo.CodecProfileLevel;
import android.media.MediaCodecList;
import android.text.TextUtils;
import android.util.Pair;
import android.util.SparseIntArray;
import com.google.android.exoplayer2.i.t;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import com.tencent.wcdb.FileUtils;
import com.tencent.wcdb.database.SQLiteGlobal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

@SuppressLint({"InlinedApi"})
@TargetApi(16)
public final class d {
    private static final a aqf = new a("OMX.google.raw.decoder", null, null, false, false);
    private static final Pattern aqg = Pattern.compile("^\\D?(\\d+)$");
    private static final HashMap<a, List<a>> aqh = new HashMap();
    private static final SparseIntArray aqi;
    private static final SparseIntArray aqj;
    private static final Map<String, Integer> aqk;
    private static int aql = -1;

    private static final class a {
        public final boolean apo;
        public final String mimeType;

        public a(String str, boolean z) {
            this.mimeType = str;
            this.apo = z;
        }

        public final int hashCode() {
            return (this.apo ? 1231 : 1237) + (((this.mimeType == null ? 0 : this.mimeType.hashCode()) + 31) * 31);
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || obj.getClass() != a.class) {
                return false;
            }
            a aVar = (a) obj;
            if (TextUtils.equals(this.mimeType, aVar.mimeType) && this.apo == aVar.apo) {
                return true;
            }
            return false;
        }
    }

    private interface c {
        boolean a(String str, CodecCapabilities codecCapabilities);

        int getCodecCount();

        MediaCodecInfo getCodecInfoAt(int i);

        boolean jS();
    }

    @TargetApi(21)
    private static final class e implements c {
        private final int aqm;
        private MediaCodecInfo[] aqn;

        public e(boolean z) {
            this.aqm = z ? 1 : 0;
        }

        public final int getCodecCount() {
            jT();
            return this.aqn.length;
        }

        public final MediaCodecInfo getCodecInfoAt(int i) {
            jT();
            return this.aqn[i];
        }

        public final boolean jS() {
            return true;
        }

        public final boolean a(String str, CodecCapabilities codecCapabilities) {
            return codecCapabilities.isFeatureSupported("secure-playback");
        }

        private void jT() {
            if (this.aqn == null) {
                this.aqn = new MediaCodecList(this.aqm).getCodecInfos();
            }
        }
    }

    public static class b extends Exception {
        /* synthetic */ b(Throwable th, byte b) {
            this(th);
        }

        private b(Throwable th) {
            super("Failed to query underlying media codecs", th);
        }
    }

    private static final class d implements c {
        private d() {
        }

        /* synthetic */ d(byte b) {
            this();
        }

        public final int getCodecCount() {
            return MediaCodecList.getCodecCount();
        }

        public final MediaCodecInfo getCodecInfoAt(int i) {
            return MediaCodecList.getCodecInfoAt(i);
        }

        public final boolean jS() {
            return false;
        }

        public final boolean a(String str, CodecCapabilities codecCapabilities) {
            return "video/avc".equals(str);
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        aqi = sparseIntArray;
        sparseIntArray.put(66, 1);
        aqi.put(77, 2);
        aqi.put(88, 4);
        aqi.put(100, 8);
        sparseIntArray = new SparseIntArray();
        aqj = sparseIntArray;
        sparseIntArray.put(10, 1);
        aqj.put(11, 4);
        aqj.put(12, 8);
        aqj.put(13, 16);
        aqj.put(20, 32);
        aqj.put(21, 64);
        aqj.put(22, FileUtils.S_IWUSR);
        aqj.put(30, 256);
        aqj.put(31, WXMediaMessage.TITLE_LENGTH_LIMIT);
        aqj.put(32, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
        aqj.put(40, 2048);
        aqj.put(41, Downloads.RECV_BUFFER_SIZE);
        aqj.put(42, 8192);
        aqj.put(50, 16384);
        aqj.put(51, WXMediaMessage.THUMB_LENGTH_LIMIT);
        aqj.put(52, 65536);
        Map hashMap = new HashMap();
        aqk = hashMap;
        hashMap.put("L30", Integer.valueOf(1));
        aqk.put("L60", Integer.valueOf(4));
        aqk.put("L63", Integer.valueOf(16));
        aqk.put("L90", Integer.valueOf(64));
        aqk.put("L93", Integer.valueOf(256));
        aqk.put("L120", Integer.valueOf(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT));
        aqk.put("L123", Integer.valueOf(Downloads.RECV_BUFFER_SIZE));
        aqk.put("L150", Integer.valueOf(16384));
        aqk.put("L153", Integer.valueOf(65536));
        aqk.put("L156", Integer.valueOf(262144));
        aqk.put("L180", Integer.valueOf(1048576));
        aqk.put("L183", Integer.valueOf(4194304));
        aqk.put("L186", Integer.valueOf(16777216));
        aqk.put("H30", Integer.valueOf(2));
        aqk.put("H60", Integer.valueOf(8));
        aqk.put("H63", Integer.valueOf(32));
        aqk.put("H90", Integer.valueOf(FileUtils.S_IWUSR));
        aqk.put("H93", Integer.valueOf(WXMediaMessage.TITLE_LENGTH_LIMIT));
        aqk.put("H120", Integer.valueOf(2048));
        aqk.put("H123", Integer.valueOf(8192));
        aqk.put("H150", Integer.valueOf(WXMediaMessage.THUMB_LENGTH_LIMIT));
        aqk.put("H153", Integer.valueOf(WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT));
        aqk.put("H156", Integer.valueOf(SQLiteGlobal.journalSizeLimit));
        aqk.put("H180", Integer.valueOf(2097152));
        aqk.put("H183", Integer.valueOf(8388608));
        aqk.put("H186", Integer.valueOf(33554432));
    }

    public static a jQ() {
        return aqf;
    }

    public static a b(String str, boolean z) {
        List c = c(str, z);
        return c.isEmpty() ? null : (a) c.get(0);
    }

    private static synchronized List<a> c(String str, boolean z) {
        List<a> list;
        synchronized (d.class) {
            a aVar = new a(str, z);
            list = (List) aqh.get(aVar);
            if (list == null) {
                List a = a(aVar, t.SDK_INT >= 21 ? new e(z) : new d());
                if (z && a.isEmpty() && 21 <= t.SDK_INT && t.SDK_INT <= 23) {
                    List a2 = a(aVar, new d());
                    if (!a2.isEmpty()) {
                        new StringBuilder("MediaCodecList API didn't list secure decoder for: ").append(str).append(". Assuming: ").append(((a) a2.get(0)).name);
                    }
                    a = a2;
                }
                k(a);
                list = Collections.unmodifiableList(a);
                aqh.put(aVar, list);
            }
        }
        return list;
    }

    public static int jR() {
        int i = 0;
        if (aql == -1) {
            a b = b("video/avc", false);
            if (b != null) {
                int i2 = 0;
                for (CodecProfileLevel codecProfileLevel : b.jK()) {
                    switch (codecProfileLevel.level) {
                        case 1:
                            i = 25344;
                            break;
                        case 2:
                            i = 25344;
                            break;
                        case 8:
                            i = 101376;
                            break;
                        case 16:
                            i = 101376;
                            break;
                        case 32:
                            i = 101376;
                            break;
                        case 64:
                            i = 202752;
                            break;
                        case FileUtils.S_IWUSR /*128*/:
                            i = 414720;
                            break;
                        case 256:
                            i = 414720;
                            break;
                        case WXMediaMessage.TITLE_LENGTH_LIMIT /*512*/:
                            i = Downloads.SPLIT_RANGE_SIZE_NET;
                            break;
                        case WXMediaMessage.DESCRIPTION_LENGTH_LIMIT /*1024*/:
                            i = 1310720;
                            break;
                        case 2048:
                            i = 2097152;
                            break;
                        case Downloads.RECV_BUFFER_SIZE /*4096*/:
                            i = 2097152;
                            break;
                        case 8192:
                            i = 2228224;
                            break;
                        case 16384:
                            i = 5652480;
                            break;
                        case WXMediaMessage.THUMB_LENGTH_LIMIT /*32768*/:
                            i = 9437184;
                            break;
                        case 65536:
                            i = 9437184;
                            break;
                        default:
                            i = -1;
                            break;
                    }
                    i2 = Math.max(i, i2);
                }
                i = Math.max(i2, t.SDK_INT >= 21 ? 345600 : 172800);
            }
            aql = i;
        }
        return aql;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.util.Pair<java.lang.Integer, java.lang.Integer> Q(java.lang.String r9) {
        /*
        r5 = 3;
        r0 = 2;
        r1 = 0;
        r2 = 1;
        r3 = 0;
        if (r9 != 0) goto L_0x0009;
    L_0x0007:
        r0 = r3;
    L_0x0008:
        return r0;
    L_0x0009:
        r4 = "\\.";
        r6 = r9.split(r4);
        r7 = r6[r1];
        r4 = -1;
        r8 = r7.hashCode();
        switch(r8) {
            case 3006243: goto L_0x0035;
            case 3006244: goto L_0x0040;
            case 3199032: goto L_0x0020;
            case 3214780: goto L_0x002a;
            default: goto L_0x001a;
        };
    L_0x001a:
        r1 = r4;
    L_0x001b:
        switch(r1) {
            case 0: goto L_0x004b;
            case 1: goto L_0x004b;
            case 2: goto L_0x00a7;
            case 3: goto L_0x00a7;
            default: goto L_0x001e;
        };
    L_0x001e:
        r0 = r3;
        goto L_0x0008;
    L_0x0020:
        r8 = "hev1";
        r7 = r7.equals(r8);
        if (r7 == 0) goto L_0x001a;
    L_0x0029:
        goto L_0x001b;
    L_0x002a:
        r1 = "hvc1";
        r1 = r7.equals(r1);
        if (r1 == 0) goto L_0x001a;
    L_0x0033:
        r1 = r2;
        goto L_0x001b;
    L_0x0035:
        r1 = "avc1";
        r1 = r7.equals(r1);
        if (r1 == 0) goto L_0x001a;
    L_0x003e:
        r1 = r0;
        goto L_0x001b;
    L_0x0040:
        r1 = "avc2";
        r1 = r7.equals(r1);
        if (r1 == 0) goto L_0x001a;
    L_0x0049:
        r1 = r5;
        goto L_0x001b;
    L_0x004b:
        r1 = r6.length;
        r4 = 4;
        if (r1 >= r4) goto L_0x0051;
    L_0x004f:
        r0 = r3;
        goto L_0x0008;
    L_0x0051:
        r1 = aqg;
        r4 = r6[r2];
        r4 = r1.matcher(r4);
        r1 = r4.matches();
        if (r1 != 0) goto L_0x0061;
    L_0x005f:
        r0 = r3;
        goto L_0x0008;
    L_0x0061:
        r1 = r4.group(r2);
        r7 = "1";
        r7 = r7.equals(r1);
        if (r7 == 0) goto L_0x008d;
    L_0x006e:
        r1 = r2;
    L_0x006f:
        r0 = aqk;
        r5 = r6[r5];
        r0 = r0.get(r5);
        r0 = (java.lang.Integer) r0;
        if (r0 != 0) goto L_0x009b;
    L_0x007b:
        r0 = new java.lang.StringBuilder;
        r1 = "Unknown HEVC level string: ";
        r0.<init>(r1);
        r1 = r4.group(r2);
        r0.append(r1);
        r0 = r3;
        goto L_0x0008;
    L_0x008d:
        r7 = "2";
        r1 = r7.equals(r1);
        if (r1 == 0) goto L_0x0098;
    L_0x0096:
        r1 = r0;
        goto L_0x006f;
    L_0x0098:
        r0 = r3;
        goto L_0x0008;
    L_0x009b:
        r2 = new android.util.Pair;
        r1 = java.lang.Integer.valueOf(r1);
        r2.<init>(r1, r0);
        r0 = r2;
        goto L_0x0008;
    L_0x00a7:
        r0 = a(r9, r6);
        goto L_0x0008;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.e.d.Q(java.lang.String):android.util.Pair<java.lang.Integer, java.lang.Integer>");
    }

    private static List<a> a(a aVar, c cVar) {
        String name;
        try {
            List<a> arrayList = new ArrayList();
            String str = aVar.mimeType;
            int codecCount = cVar.getCodecCount();
            boolean jS = cVar.jS();
            loop0:
            for (int i = 0; i < codecCount; i++) {
                MediaCodecInfo codecInfoAt = cVar.getCodecInfoAt(i);
                name = codecInfoAt.getName();
                Object obj = (codecInfoAt.isEncoder() || (!jS && name.endsWith(".secure"))) ? null : (t.SDK_INT >= 21 || !("CIPAACDecoder".equals(name) || "CIPMP3Decoder".equals(name) || "CIPVorbisDecoder".equals(name) || "CIPAMRNBDecoder".equals(name) || "AACDecoder".equals(name) || "MP3Decoder".equals(name))) ? (t.SDK_INT >= 18 || !"OMX.SEC.MP3.Decoder".equals(name)) ? (t.SDK_INT < 18 && "OMX.MTK.AUDIO.DECODER.AAC".equals(name) && ("a70".equals(t.DEVICE) || ("Xiaomi".equals(t.MANUFACTURER) && t.DEVICE.startsWith("HM")))) ? null : (t.SDK_INT == 16 && "OMX.qcom.audio.decoder.mp3".equals(name) && ("dlxu".equals(t.DEVICE) || "protou".equals(t.DEVICE) || "ville".equals(t.DEVICE) || "villeplus".equals(t.DEVICE) || "villec2".equals(t.DEVICE) || t.DEVICE.startsWith("gee") || "C6602".equals(t.DEVICE) || "C6603".equals(t.DEVICE) || "C6606".equals(t.DEVICE) || "C6616".equals(t.DEVICE) || "L36h".equals(t.DEVICE) || "SO-02E".equals(t.DEVICE))) ? null : (t.SDK_INT == 16 && "OMX.qcom.audio.decoder.aac".equals(name) && ("C1504".equals(t.DEVICE) || "C1505".equals(t.DEVICE) || "C1604".equals(t.DEVICE) || "C1605".equals(t.DEVICE))) ? null : (t.SDK_INT >= 24 || !(("OMX.SEC.aac.dec".equals(name) || "OMX.Exynos.AAC.Decoder".equals(name)) && t.MANUFACTURER.equals("samsung") && (t.DEVICE.startsWith("zeroflte") || t.DEVICE.startsWith("zerolte") || t.DEVICE.startsWith("zenlte") || t.DEVICE.equals("SC-05G") || t.DEVICE.equals("marinelteatt") || t.DEVICE.equals("404SC") || t.DEVICE.equals("SC-04G") || t.DEVICE.equals("SCV31")))) ? (t.SDK_INT <= 19 && "OMX.SEC.vp8.dec".equals(name) && "samsung".equals(t.MANUFACTURER) && (t.DEVICE.startsWith("d2") || t.DEVICE.startsWith("serrano") || t.DEVICE.startsWith("jflte") || t.DEVICE.startsWith("santos") || t.DEVICE.startsWith("t0"))) ? null : (t.SDK_INT <= 19 && t.DEVICE.startsWith("jflte") && "OMX.qcom.video.decoder.vp8".equals(name)) ? null : 1 : null : null : null;
                if (obj != null) {
                    for (String str2 : codecInfoAt.getSupportedTypes()) {
                        if (str2.equalsIgnoreCase(str)) {
                            CodecCapabilities capabilitiesForType = codecInfoAt.getCapabilitiesForType(str2);
                            boolean a = cVar.a(str, capabilitiesForType);
                            boolean z = t.SDK_INT <= 22 && ((t.MODEL.equals("ODROID-XU3") || t.MODEL.equals("Nexus 10")) && ("OMX.Exynos.AVC.Decoder".equals(name) || "OMX.Exynos.AVC.Decoder.secure".equals(name)));
                            if ((!jS || aVar.apo != a) && (jS || aVar.apo)) {
                                if (!jS && a) {
                                    arrayList.add(a.a(name + ".secure", str, capabilitiesForType, z, true));
                                    break loop0;
                                }
                            }
                            arrayList.add(a.a(name, str, capabilitiesForType, z, false));
                        }
                    }
                    continue;
                }
            }
            return arrayList;
        } catch (Exception e) {
            if (t.SDK_INT > 23 || arrayList.isEmpty()) {
                new StringBuilder("Failed to query codec ").append(name).append(" (").append(str2).append(")");
                throw e;
            }
            new StringBuilder("Skipping codec ").append(name).append(" (failed to query capabilities)");
        } catch (Throwable e2) {
            throw new b(e2, (byte) 0);
        }
    }

    private static void k(List<a> list) {
        int i = 1;
        if (t.SDK_INT < 26 && list.size() > 1 && "OMX.MTK.AUDIO.DECODER.RAW".equals(((a) list.get(0)).name)) {
            while (i < list.size()) {
                a aVar = (a) list.get(i);
                if ("OMX.google.raw.decoder".equals(aVar.name)) {
                    list.remove(i);
                    list.add(0, aVar);
                    return;
                }
                i++;
            }
        }
    }

    private static Pair<Integer, Integer> a(String str, String[] strArr) {
        if (strArr.length < 2) {
            return null;
        }
        try {
            Integer valueOf;
            Integer valueOf2;
            if (strArr[1].length() == 6) {
                valueOf = Integer.valueOf(Integer.parseInt(strArr[1].substring(0, 2), 16));
                valueOf2 = Integer.valueOf(Integer.parseInt(strArr[1].substring(4), 16));
            } else if (strArr.length < 3) {
                return null;
            } else {
                valueOf = Integer.valueOf(Integer.parseInt(strArr[1]));
                valueOf2 = Integer.valueOf(Integer.parseInt(strArr[2]));
            }
            Integer valueOf3 = Integer.valueOf(aqi.get(valueOf.intValue()));
            if (valueOf3 == null) {
                new StringBuilder("Unknown AVC profile: ").append(valueOf);
                return null;
            }
            Integer valueOf4 = Integer.valueOf(aqj.get(valueOf2.intValue()));
            if (valueOf4 != null) {
                return new Pair(valueOf3, valueOf4);
            }
            new StringBuilder("Unknown AVC level: ").append(valueOf2);
            return null;
        } catch (NumberFormatException e) {
            return null;
        }
    }
}
