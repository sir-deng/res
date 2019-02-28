package com.tencent.mm.plugin.appbrand.jsapi.voicejoint.c;

public final class a implements com.tencent.mm.audio.voicejoint.model.d.a<a> {
    private String jzU;
    private String jzV;

    public class a {
        boolean ftC = false;
        public byte[] jzX = null;

        public a(byte[] bArr) {
            this.jzX = bArr;
        }
    }

    public a(String str, String str2) {
        this.jzU = str;
        this.jzV = str2;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(final com.tencent.mm.audio.voicejoint.model.d.b<com.tencent.mm.plugin.appbrand.jsapi.voicejoint.c.a.a> r7) {
        /*
        r6 = this;
        r3 = new com.tencent.mm.plugin.appbrand.jsapi.voicejoint.a.b;
        r0 = r6.jzU;
        r1 = r6.jzV;
        r3.<init>(r0, r1);
        r0 = new com.tencent.mm.plugin.appbrand.jsapi.voicejoint.c.a$1;
        r0.<init>(r7);
        r3.jyZ = r0;
        r0 = r3.init();
        if (r0 == 0) goto L_0x001a;
    L_0x0016:
        r3.onError();
    L_0x0019:
        return;
    L_0x001a:
        r0 = r3.jyZ;
        if (r0 == 0) goto L_0x0023;
    L_0x001e:
        r0 = r3.jyZ;
        r0.ahR();
    L_0x0023:
        r2 = 0;
        r1 = new java.io.ByteArrayOutputStream;	 Catch:{ Exception -> 0x009d, all -> 0x0091 }
        r1.<init>();	 Catch:{ Exception -> 0x009d, all -> 0x0091 }
    L_0x0029:
        r0 = -16;
        android.os.Process.setThreadPriority(r0);	 Catch:{ Exception -> 0x005a }
        r0 = r3.mSampleRate;	 Catch:{ Exception -> 0x005a }
        r2 = 2;
        r4 = 2;
        r0 = android.media.AudioTrack.getMinBufferSize(r0, r2, r4);	 Catch:{ Exception -> 0x005a }
        r0 = r0 << 1;
        r0 = new byte[r0];	 Catch:{ Exception -> 0x005a }
        r2 = r3.mSampleRate;	 Catch:{ Exception -> 0x005a }
        r2 = r2 * 20;
        r2 = r2 / 1000;
        r2 = (short) r2;	 Catch:{ Exception -> 0x005a }
        r4 = com.tencent.mm.modelvoice.MediaRecorder.SilkDoDec(r0, r2);	 Catch:{ Exception -> 0x005a }
        if (r4 < 0) goto L_0x0072;
    L_0x0047:
        r4 = 0;
        r5 = r2 * 2;
        r1.write(r0, r4, r5);	 Catch:{ Exception -> 0x005a }
        r4 = r3.jzb;	 Catch:{ Exception -> 0x005a }
        if (r4 == 0) goto L_0x0029;
    L_0x0051:
        r4 = r3.jzb;	 Catch:{ Exception -> 0x005a }
        r5 = 0;
        r2 = r2 * 2;
        r4.write(r0, r5, r2);	 Catch:{ Exception -> 0x005a }
        goto L_0x0029;
    L_0x005a:
        r0 = move-exception;
    L_0x005b:
        r2 = "MicroMsg.SilkDecoder";
        r4 = "alvinluo silk decode exception";
        r5 = 0;
        r5 = new java.lang.Object[r5];	 Catch:{ all -> 0x009b }
        com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r2, r0, r4, r5);	 Catch:{ all -> 0x009b }
        r3.onError();	 Catch:{ all -> 0x009b }
        if (r1 == 0) goto L_0x0019;
    L_0x006c:
        r1.close();	 Catch:{ Exception -> 0x0070 }
        goto L_0x0019;
    L_0x0070:
        r0 = move-exception;
        goto L_0x0019;
    L_0x0072:
        r1.flush();	 Catch:{ Exception -> 0x005a }
        r0 = r1.toByteArray();	 Catch:{ Exception -> 0x005a }
        r2 = r3.jzb;	 Catch:{ Exception -> 0x005a }
        if (r2 == 0) goto L_0x0082;
    L_0x007d:
        r2 = r3.jzb;	 Catch:{ Exception -> 0x005a }
        r2.flush();	 Catch:{ Exception -> 0x005a }
    L_0x0082:
        r2 = r3.jyZ;	 Catch:{ Exception -> 0x005a }
        if (r2 == 0) goto L_0x008b;
    L_0x0086:
        r2 = r3.jyZ;	 Catch:{ Exception -> 0x005a }
        r2.X(r0);	 Catch:{ Exception -> 0x005a }
    L_0x008b:
        r1.close();	 Catch:{ Exception -> 0x008f }
        goto L_0x0019;
    L_0x008f:
        r0 = move-exception;
        goto L_0x0019;
    L_0x0091:
        r0 = move-exception;
        r1 = r2;
    L_0x0093:
        if (r1 == 0) goto L_0x0098;
    L_0x0095:
        r1.close();	 Catch:{ Exception -> 0x0099 }
    L_0x0098:
        throw r0;
    L_0x0099:
        r1 = move-exception;
        goto L_0x0098;
    L_0x009b:
        r0 = move-exception;
        goto L_0x0093;
    L_0x009d:
        r0 = move-exception;
        r1 = r2;
        goto L_0x005b;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.jsapi.voicejoint.c.a.a(com.tencent.mm.audio.voicejoint.model.d$b):void");
    }
}
