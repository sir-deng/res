package com.tencent.mm.plugin.freewifi.f;

import com.tencent.mm.plugin.freewifi.d.e;
import com.tencent.mm.plugin.freewifi.g.f;
import com.tencent.mm.plugin.freewifi.k;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.protocal.c.wn;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class b {
    private static volatile boolean mLO = true;
    static Pattern mLP = Pattern.compile("\"result\":(-?[0-9]+)");
    static Pattern mLQ = Pattern.compile("\"stageName\":\"(.+?)\"");

    public static void qq(final int i) {
        j.aMz().aMg().post(new Runnable() {
            public final void run() {
                if (b.mLO) {
                    if (i == 0) {
                        long currentTimeMillis = System.currentTimeMillis() - a.mIc.oO("LOCAL_CONFIG_LAST_MOBILE_NETWORK_REPORT_TIMEMILLIS");
                        x.v("MicroMsg.FreeWifi.FreeWifiServerReporter", "mobile netowrk report interval between last time is : " + currentTimeMillis);
                        if (currentTimeMillis < 0 || currentTimeMillis > 86400000) {
                            a.mIc.B("LOCAL_CONFIG_LAST_MOBILE_NETWORK_REPORT_TIMEMILLIS", System.currentTimeMillis());
                        } else {
                            x.v("MicroMsg.FreeWifi.FreeWifiServerReporter", "interval less than 24 hours. return.");
                            return;
                        }
                    }
                    b.mLO = false;
                    i aMx = j.aMx();
                    m.a("FreeWifiLog", f.mLU, aMx, "MicroMsg.FreeWifi.FreeWifiLogStorage");
                    LinkedList aMY = aMx.aMY();
                    String str = "ServerReportSimpleLog:" + b.M(aMY);
                    m.Bl(str);
                    x.i("MicroMsg.FreeWifi.FreeWifiServerReporter", str);
                    if (aMY.size() > 0) {
                        new e(aMY).b(new com.tencent.mm.ad.e() {
                            /* JADX WARNING: inconsistent code. */
                            /* Code decompiled incorrectly, please refer to instructions dump. */
                            public final void a(int r11, int r12, java.lang.String r13, com.tencent.mm.ad.k r14) {
                                /*
                                r10 = this;
                                r9 = 1;
                                r0 = "MicroMsg.FreeWifi.FreeWifiServerReporter";
                                r1 = "errType=%d, errCode=%d, errMsg=%s";
                                r2 = 3;
                                r2 = new java.lang.Object[r2];	 Catch:{ Exception -> 0x009c }
                                r3 = 0;
                                r4 = java.lang.Integer.valueOf(r11);	 Catch:{ Exception -> 0x009c }
                                r2[r3] = r4;	 Catch:{ Exception -> 0x009c }
                                r3 = 1;
                                r4 = java.lang.Integer.valueOf(r12);	 Catch:{ Exception -> 0x009c }
                                r2[r3] = r4;	 Catch:{ Exception -> 0x009c }
                                r3 = 2;
                                r2[r3] = r13;	 Catch:{ Exception -> 0x009c }
                                com.tencent.mm.sdk.platformtools.x.i(r0, r1, r2);	 Catch:{ Exception -> 0x009c }
                                r0 = com.tencent.mm.plugin.freewifi.m.cD(r11, r12);	 Catch:{ Exception -> 0x009c }
                                if (r0 == 0) goto L_0x00ab;
                            L_0x0024:
                                r14 = (com.tencent.mm.plugin.freewifi.d.e) r14;	 Catch:{ Exception -> 0x009c }
                                r0 = r14.aML();	 Catch:{ Exception -> 0x009c }
                                if (r0 == 0) goto L_0x00ab;
                            L_0x002c:
                                r1 = r0.size();	 Catch:{ Exception -> 0x009c }
                                if (r1 <= 0) goto L_0x00ab;
                            L_0x0032:
                                r1 = com.tencent.mm.plugin.freewifi.model.j.aMx();	 Catch:{ Exception -> 0x009c }
                                r2 = r0.iterator();	 Catch:{ Exception -> 0x009c }
                            L_0x003a:
                                r0 = r2.hasNext();	 Catch:{ Exception -> 0x009c }
                                if (r0 == 0) goto L_0x00ab;
                            L_0x0040:
                                r0 = r2.next();	 Catch:{ Exception -> 0x009c }
                                r0 = (com.tencent.mm.protocal.c.wn) r0;	 Catch:{ Exception -> 0x009c }
                                r3 = r0.id;	 Catch:{ Exception -> 0x009c }
                                r0 = r0.fun;	 Catch:{ Exception -> 0x009c }
                                r4 = "MicroMsg.FreeWifi.FreeWifiServerReporter";
                                r5 = "resp LinkedList<FreeWifiReport>. id=%s, errcode=%d";
                                r6 = 2;
                                r6 = new java.lang.Object[r6];	 Catch:{ Exception -> 0x009c }
                                r7 = 0;
                                r6[r7] = r3;	 Catch:{ Exception -> 0x009c }
                                r7 = 1;
                                r8 = java.lang.Integer.valueOf(r0);	 Catch:{ Exception -> 0x009c }
                                r6[r7] = r8;	 Catch:{ Exception -> 0x009c }
                                com.tencent.mm.sdk.platformtools.x.i(r4, r5, r6);	 Catch:{ Exception -> 0x009c }
                                r4 = com.tencent.mm.plugin.freewifi.m.Bf(r3);	 Catch:{ Exception -> 0x009c }
                                if (r4 != 0) goto L_0x003a;
                            L_0x0066:
                                if (r0 != 0) goto L_0x003a;
                            L_0x0068:
                                r0 = "MicroMsg.FreeWifi.FreeWifiLogStorage";
                                r4 = "delete. id=%s";
                                r5 = 1;
                                r5 = new java.lang.Object[r5];	 Catch:{ Exception -> 0x009c }
                                r6 = 0;
                                r5[r6] = r3;	 Catch:{ Exception -> 0x009c }
                                com.tencent.mm.sdk.platformtools.x.i(r0, r4, r5);	 Catch:{ Exception -> 0x009c }
                                r0 = new com.tencent.mm.plugin.freewifi.g.e;	 Catch:{ Exception -> 0x009c }
                                r0.<init>();	 Catch:{ Exception -> 0x009c }
                                r0.field_id = r3;	 Catch:{ Exception -> 0x009c }
                                r3 = 0;
                                r3 = new java.lang.String[r3];	 Catch:{ Exception -> 0x009c }
                                r0 = r1.a(r0, r3);	 Catch:{ Exception -> 0x009c }
                                r3 = "MicroMsg.FreeWifi.FreeWifiLogStorage";
                                r4 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x009c }
                                r5 = "delete ret";
                                r4.<init>(r5);	 Catch:{ Exception -> 0x009c }
                                r0 = r4.append(r0);	 Catch:{ Exception -> 0x009c }
                                r0 = r0.toString();	 Catch:{ Exception -> 0x009c }
                                com.tencent.mm.sdk.platformtools.x.i(r3, r0);	 Catch:{ Exception -> 0x009c }
                                goto L_0x003a;
                            L_0x009c:
                                r0 = move-exception;
                                r1 = "MicroMsg.FreeWifi.FreeWifiServerReporter";
                                r0 = com.tencent.mm.plugin.freewifi.m.f(r0);	 Catch:{ all -> 0x00af }
                                com.tencent.mm.sdk.platformtools.x.e(r1, r0);	 Catch:{ all -> 0x00af }
                                com.tencent.mm.plugin.freewifi.f.b.mLO = r9;
                            L_0x00aa:
                                return;
                            L_0x00ab:
                                com.tencent.mm.plugin.freewifi.f.b.mLO = r9;
                                goto L_0x00aa;
                            L_0x00af:
                                r0 = move-exception;
                                com.tencent.mm.plugin.freewifi.f.b.mLO = r9;
                                throw r0;
                                */
                                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.freewifi.f.b.1.1.a(int, int, java.lang.String, com.tencent.mm.ad.k):void");
                            }
                        });
                    } else {
                        b.mLO = true;
                    }
                }
            }
        });
    }

    static String M(LinkedList<wn> linkedList) {
        if (linkedList == null || linkedList.size() == 0) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            wn wnVar = (wn) it.next();
            stringBuilder.append("|id=").append(m.Bh(wnVar.id)).append("|");
            for (CharSequence charSequence : m.Bh(wnVar.wnG).split("\\},")) {
                Matcher matcher = mLQ.matcher(charSequence);
                String str = "";
                if (matcher.find()) {
                    str = matcher.group(1);
                }
                matcher = mLP.matcher(charSequence);
                String str2 = "0";
                if (matcher.find()) {
                    str2 = matcher.group(1);
                }
                stringBuilder.append(k.Be(str) + "=" + str2).append("|");
            }
        }
        return stringBuilder.toString();
    }
}
