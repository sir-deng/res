package com.tencent.mm.plugin.webview.model;

import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.webview.model.aj.m;
import com.tencent.mm.plugin.webview.stub.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bj;
import com.tencent.mm.sdk.platformtools.x;
import java.net.InetAddress;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public final class a {
    public volatile ah tyk = new ah("WebviewWorkerThread");
    aj tyl;

    /* renamed from: com.tencent.mm.plugin.webview.model.a$1 */
    class AnonymousClass1 implements Runnable {
        final /* synthetic */ String tym;
        final /* synthetic */ d tyn;

        public AnonymousClass1(String str, d dVar) {
            this.tym = str;
            this.tyn = dVar;
        }

        public final void run() {
            Map y = bj.y(this.tym, "DNSAdvanceRelateDomain");
            LinkedList linkedList = new LinkedList();
            if (y != null && y.size() > 0) {
                String str;
                int i = 0;
                while (i < y.size()) {
                    str = (String) y.get(".DNSAdvanceRelateDomain.RelateDomain" + (i == 0 ? "" : Integer.valueOf(i)) + ".$domain");
                    if (bi.oN(str)) {
                        x.i("MicroMsg.DNSPreGetOptimize", "now break for main domain i = %d", Integer.valueOf(i));
                        break;
                    }
                    if (!linkedList.contains(str)) {
                        linkedList.add(str);
                    }
                    i++;
                }
                int i2 = 0;
                while (true) {
                    String str2 = (String) y.get(".DNSAdvanceRelateDomain.RelateDomain" + (i2 == 0 ? "" : Integer.valueOf(i2)) + ".Relate");
                    str = (String) y.get(".DNSAdvanceRelateDomain.RelateDomain.Relate" + (i2 == 0 ? "" : Integer.valueOf(i2)));
                    if (bi.oN(str2) && bi.oN(str)) {
                        break;
                    }
                    if (!(bi.oN(str2) || linkedList.contains(str2))) {
                        linkedList.add(str2);
                    }
                    if (!(bi.oN(str) || linkedList.contains(str))) {
                        linkedList.add(str);
                    }
                    i2++;
                }
                x.i("MicroMsg.DNSPreGetOptimize", "now break for releated domain j = %d", Integer.valueOf(i2));
                m bRJ = a.this.tyl.bRJ();
                Iterator it = linkedList.iterator();
                while (it.hasNext()) {
                    InetAddress inetAddress;
                    long currentTimeMillis;
                    str = (String) it.next();
                    long currentTimeMillis2 = System.currentTimeMillis();
                    InetAddress inetAddress2 = null;
                    try {
                        inetAddress2 = InetAddress.getByName(str);
                        x.i("MicroMsg.DNSPreGetOptimize", "get dns for domain : %s, cost time : %d", str, Long.valueOf(System.currentTimeMillis() - currentTimeMillis2));
                        inetAddress = inetAddress2;
                        currentTimeMillis = System.currentTimeMillis() - currentTimeMillis2;
                    } catch (Exception e) {
                        x.e("MicroMsg.DNSPreGetOptimize", "get dns failed : %s", e.getMessage());
                        inetAddress = inetAddress2;
                        currentTimeMillis = System.currentTimeMillis() - currentTimeMillis2;
                    }
                    try {
                        bRJ.jNF = currentTimeMillis;
                        bRJ.url = str;
                        if (inetAddress != null) {
                            bRJ.ftC = true;
                        } else {
                            bRJ.ftC = false;
                        }
                        d dVar = this.tyn;
                        if (dVar != null) {
                            x.i("MicroMsg.WebviewReporter", "WebviewPreGetDNSReporter, netType = %d, costTime = %d, url = %s, isSuccess = %s", Integer.valueOf(aj.bRH()), Long.valueOf(bRJ.jNF), bRJ.url, Boolean.valueOf(bRJ.ftC));
                            String str3 = bRJ.tzz;
                            Object[] objArr = new Object[11];
                            objArr[0] = Integer.valueOf(1);
                            objArr[1] = Long.valueOf(bRJ.jNF);
                            objArr[2] = Integer.valueOf(ao.getNetType(ad.getContext()));
                            objArr[3] = bRJ.url == null ? bRJ.url : bRJ.url.replace(",", "!");
                            objArr[4] = Integer.valueOf(0);
                            objArr[5] = Integer.valueOf(0);
                            objArr[6] = Integer.valueOf(0);
                            objArr[7] = Integer.valueOf(aj.ndJ);
                            objArr[8] = Integer.valueOf(aj.tzq);
                            objArr[9] = Integer.valueOf(bRJ.fNt);
                            objArr[10] = bRJ.tzz;
                            aj.a(dVar, str3, objArr);
                            if (!bRJ.ftC) {
                                g.pWK.a(32, 12, 1, true);
                            }
                            g.pWK.a(32, 1, 1, true);
                            g.pWK.a(32, 5, bRJ.jNF, true);
                        }
                    } catch (Exception e2) {
                        x.e("MicroMsg.DNSPreGetOptimize", "get dns failed 2 : %s", e2.getMessage());
                        return;
                    }
                }
            }
        }
    }

    public a(aj ajVar) {
        this.tyl = ajVar;
    }

    public final ah Dt() {
        if (this.tyk == null) {
            this.tyk = new ah("WebviewWorkerThread");
        }
        return this.tyk;
    }
}
