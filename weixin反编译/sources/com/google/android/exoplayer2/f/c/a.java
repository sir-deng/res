package com.google.android.exoplayer2.f.c;

import com.google.android.exoplayer2.f.b;
import com.google.android.exoplayer2.f.d;
import com.google.android.exoplayer2.i.e;
import com.google.android.exoplayer2.i.j;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class a extends b {
    private static final Pattern ays = Pattern.compile("(?:(\\d+):)?(\\d+):(\\d+)(?::|\\.)(\\d+)");
    private final boolean ayt;
    private int ayu;
    private int ayv;
    private int ayw;
    private int ayx;

    protected final /* synthetic */ d a(byte[] bArr, int i, boolean z) {
        List arrayList = new ArrayList();
        e eVar = new e();
        j jVar = new j(bArr, i);
        if (!this.ayt) {
            f(jVar);
        }
        a(jVar, arrayList, eVar);
        com.google.android.exoplayer2.f.a[] aVarArr = new com.google.android.exoplayer2.f.a[arrayList.size()];
        arrayList.toArray(aVarArr);
        return new b(aVarArr, eVar.lA());
    }

    public a() {
        this(null);
    }

    public a(List<byte[]> list) {
        super("SsaDecoder");
        if (list != null) {
            this.ayt = true;
            String str = new String((byte[]) list.get(0));
            com.google.android.exoplayer2.i.a.ao(str.startsWith("Format: "));
            S(str);
            f(new j((byte[]) list.get(1)));
            return;
        }
        this.ayt = false;
    }

    private static void f(j jVar) {
        String readLine;
        do {
            readLine = jVar.readLine();
            if (readLine == null) {
                return;
            }
        } while (!readLine.startsWith("[Events]"));
    }

    private void a(j jVar, List<com.google.android.exoplayer2.f.a> list, e eVar) {
        while (true) {
            String readLine = jVar.readLine();
            if (readLine == null) {
                return;
            }
            if (!this.ayt && readLine.startsWith("Format: ")) {
                S(readLine);
            } else if (readLine.startsWith("Dialogue: ") && this.ayu != 0) {
                String[] split = readLine.substring(10).split(",", this.ayu);
                long T = T(split[this.ayv]);
                if (T != -9223372036854775807L) {
                    long j;
                    readLine = split[this.ayw];
                    if (readLine.trim().isEmpty()) {
                        j = -9223372036854775807L;
                    } else {
                        j = T(readLine);
                        if (j == -9223372036854775807L) {
                        }
                    }
                    list.add(new com.google.android.exoplayer2.f.a(split[this.ayx].replaceAll("\\{.*?\\}", "").replaceAll("\\\\N", "\n").replaceAll("\\\\n", "\n")));
                    eVar.O(T);
                    if (j != -9223372036854775807L) {
                        list.add(null);
                        eVar.O(j);
                    }
                }
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void S(java.lang.String r7) {
        /*
        r6 = this;
        r1 = 0;
        r3 = -1;
        r0 = 8;
        r0 = r7.substring(r0);
        r2 = ",";
        r4 = android.text.TextUtils.split(r0, r2);
        r0 = r4.length;
        r6.ayu = r0;
        r6.ayv = r3;
        r6.ayw = r3;
        r6.ayx = r3;
        r0 = r1;
    L_0x0019:
        r2 = r6.ayu;
        if (r0 >= r2) goto L_0x005f;
    L_0x001d:
        r2 = r4[r0];
        r2 = r2.trim();
        r2 = com.google.android.exoplayer2.i.t.ai(r2);
        r5 = r2.hashCode();
        switch(r5) {
            case 100571: goto L_0x0040;
            case 3556653: goto L_0x004b;
            case 109757538: goto L_0x0035;
            default: goto L_0x002e;
        };
    L_0x002e:
        r2 = r3;
    L_0x002f:
        switch(r2) {
            case 0: goto L_0x0056;
            case 1: goto L_0x0059;
            case 2: goto L_0x005c;
            default: goto L_0x0032;
        };
    L_0x0032:
        r0 = r0 + 1;
        goto L_0x0019;
    L_0x0035:
        r5 = "start";
        r2 = r2.equals(r5);
        if (r2 == 0) goto L_0x002e;
    L_0x003e:
        r2 = r1;
        goto L_0x002f;
    L_0x0040:
        r5 = "end";
        r2 = r2.equals(r5);
        if (r2 == 0) goto L_0x002e;
    L_0x0049:
        r2 = 1;
        goto L_0x002f;
    L_0x004b:
        r5 = "text";
        r2 = r2.equals(r5);
        if (r2 == 0) goto L_0x002e;
    L_0x0054:
        r2 = 2;
        goto L_0x002f;
    L_0x0056:
        r6.ayv = r0;
        goto L_0x0032;
    L_0x0059:
        r6.ayw = r0;
        goto L_0x0032;
    L_0x005c:
        r6.ayx = r0;
        goto L_0x0032;
    L_0x005f:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.f.c.a.S(java.lang.String):void");
    }

    private static long T(String str) {
        Matcher matcher = ays.matcher(str);
        if (!matcher.matches()) {
            return -9223372036854775807L;
        }
        return (Long.parseLong(matcher.group(4)) * 10000) + (((((Long.parseLong(matcher.group(1)) * 60) * 60) * 1000000) + ((Long.parseLong(matcher.group(2)) * 60) * 1000000)) + (Long.parseLong(matcher.group(3)) * 1000000));
    }
}
