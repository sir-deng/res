package com.tencent.mm.plugin.appbrand.config;

import com.tencent.mm.ad.k;
import com.tencent.mm.ad.u;
import com.tencent.mm.plugin.appbrand.app.e;
import com.tencent.mm.protocal.c.buj;
import com.tencent.mm.protocal.c.cv;
import com.tencent.mm.protocal.c.yd;
import com.tencent.mm.protocal.c.ye;
import com.tencent.mm.protocal.c.yf;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Iterator;
import java.util.LinkedList;

public final class m {

    public static class a {
        private static String aq(String str, int i) {
            return String.format("%s_%s_local_version", new Object[]{str, Integer.valueOf(i)});
        }

        public static String ar(String str, int i) {
            return String.format("%s_%s_server_version", new Object[]{str, Integer.valueOf(i)});
        }

        private static String as(String str, int i) {
            return String.format("%s_%s_config", new Object[]{str, Integer.valueOf(i)});
        }

        public static void z(String str, int i, int i2) {
            if (e.Zw() != null) {
                e.Zw().aY(aq(str, i), String.valueOf(i2));
            }
        }

        public static void A(String str, int i, int i2) {
            if (e.Zw() != null) {
                e.Zw().aY(ar(str, i), String.valueOf(i2));
            }
        }

        public static void h(String str, int i, String str2) {
            if (e.Zw() != null) {
                e.Zw().aY(as(str, i), str2);
            }
        }

        public static int at(String str, int i) {
            if (e.Zw() == null) {
                return 0;
            }
            return bi.getInt(e.Zw().get(aq(str, i), "0"), 0);
        }

        public static String au(String str, int i) {
            if (e.Zw() == null) {
                return "";
            }
            return e.Zw().get(as(str, i), "");
        }
    }

    public interface b {
        void a(int i, int i2, String str, com.tencent.mm.ad.b bVar);
    }

    public interface c {
        void qe(String str);
    }

    public static void a(String str, LinkedList<buj> linkedList) {
        a(str, linkedList, true);
    }

    public static void a(final String str, LinkedList<buj> linkedList, boolean z) {
        if (bi.oN(str)) {
            x.e("MicroMsg.CommonConfigManager", "setVersion, app_id is null");
        } else if (linkedList == null || linkedList.size() == 0) {
            x.e("MicroMsg.CommonConfigManager", "setVersion, versionItems is empty");
        } else {
            LinkedList linkedList2 = new LinkedList();
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                buj buj = (buj) it.next();
                x.d("MicroMsg.CommonConfigManager", "versionItem.version:%d,version.type:%d", Integer.valueOf(buj.version), Integer.valueOf(buj.type));
                int at = a.at(str, buj.type);
                int i = buj.version;
                a.A(str, buj.type, i);
                if (i != 0) {
                    if (i > at) {
                        linkedList2.add(y(str, buj.type, buj.version));
                    } else if (i != at) {
                        x.i("MicroMsg.CommonConfigManager", "local_version:%d, server_version:%d", Integer.valueOf(at), Integer.valueOf(i));
                        if (bi.oN(a.au(str, buj.type))) {
                            linkedList2.add(y(str, buj.type, buj.version));
                        }
                    } else if (bi.oN(a.au(str, buj.type))) {
                        linkedList2.add(y(str, buj.type, buj.version));
                    }
                }
            }
            x.i("MicroMsg.CommonConfigManager", "setVersion appid:%s,versionItems.size:%d,getAppConfigItems.size:%d", str, Integer.valueOf(linkedList.size()), Integer.valueOf(linkedList2.size()));
            if (z && linkedList2.size() != 0) {
                x.d("MicroMsg.CommonConfigManager", "setVersion appid:%s, need sync from server", str);
                a(linkedList2, new b() {
                    public final void a(int i, int i2, String str, com.tencent.mm.ad.b bVar) {
                        if (i == 0 && i2 == 0) {
                            yf yfVar = (yf) bVar.hnR.hnY;
                            if (yfVar.wpx == null || yfVar.wpx.size() == 0) {
                                x.e("MicroMsg.CommonConfigManager", "setVersion syncConfigFromServer, AppConfigList is empty");
                                return;
                            }
                            x.i("MicroMsg.CommonConfigManager", "setVersion syncConfigFromServer appConfigList.size:%d", Integer.valueOf(yfVar.wpx.size()));
                            Iterator it = yfVar.wpx.iterator();
                            while (it.hasNext()) {
                                cv cvVar = (cv) it.next();
                                x.i("MicroMsg.CommonConfigManager", "setVersion syncConfigFromServer, the config is %s, the configVersion is %d", cvVar.vOz, Integer.valueOf(cvVar.vOy));
                                if (!bi.oN(cvVar.vOz)) {
                                    a.z(str, cvVar.kzz, cvVar.vOy);
                                    a.A(str, cvVar.kzz, cvVar.vOy);
                                    a.h(str, cvVar.kzz, cvVar.vOz);
                                }
                            }
                            return;
                        }
                        x.e("MicroMsg.CommonConfigManager", "setVersion syncConfigFromServer, errType = %d, errCode = %d, errMsg = %s", Integer.valueOf(i), Integer.valueOf(i2), str);
                    }
                });
            }
        }
    }

    private static yd y(String str, int i, int i2) {
        yd ydVar = new yd();
        ydVar.nlV = str;
        ydVar.kzz = i;
        ydVar.vOy = i2;
        return ydVar;
    }

    public static String a(final String str, int i, int i2, final c cVar, boolean z) {
        if (e.Zw() == null) {
            return "";
        }
        boolean z2;
        int at = a.at(str, i);
        int i3 = e.Zw() == null ? 0 : bi.getInt(e.Zw().get(a.ar(str, i), "0"), 0);
        String au = a.au(str, i);
        if (i3 == 0 || (!bi.oN(au) && i3 <= at)) {
            z2 = false;
        } else {
            z2 = true;
        }
        x.i("MicroMsg.CommonConfigManager", "getConfig the server_version is %d ,the local_version is %d", Integer.valueOf(i3), Integer.valueOf(at));
        x.i("MicroMsg.CommonConfigManager", "the config is \n %s \n isShouldSyncFromServer:%b", au, Boolean.valueOf(z2));
        if (!z2) {
            cVar.qe(au);
        } else if (z) {
            b anonymousClass2 = new b() {
                public final void a(int i, int i2, String str, com.tencent.mm.ad.b bVar) {
                    if (i == 0 && i2 == 0) {
                        yf yfVar = (yf) bVar.hnR.hnY;
                        if (yfVar.wpx == null || yfVar.wpx.size() == 0) {
                            x.e("MicroMsg.CommonConfigManager", "getConfig syncConfigFromServer, AppConfigList is empty");
                            if (cVar != null) {
                                cVar.qe("");
                                return;
                            }
                            return;
                        }
                        cv cvVar = (cv) yfVar.wpx.get(0);
                        x.i("MicroMsg.CommonConfigManager", "getConfig syncConfigFromServer, the config is %s, the configVersion is %d", cvVar.vOz, Integer.valueOf(cvVar.vOy));
                        if (!bi.oN(cvVar.vOz)) {
                            a.z(str, cvVar.kzz, cvVar.vOy);
                            a.A(str, cvVar.kzz, cvVar.vOy);
                            a.h(str, cvVar.kzz, cvVar.vOz);
                            if (cVar != null) {
                                cVar.qe(cvVar.vOz);
                                return;
                            }
                            return;
                        } else if (cVar != null) {
                            cVar.qe("");
                            return;
                        } else {
                            return;
                        }
                    }
                    x.e("MicroMsg.CommonConfigManager", "getConfig syncConfigFromServer, errType = %d, errCode = %d, errMsg = %s", Integer.valueOf(i), Integer.valueOf(i2), str);
                    if (cVar != null) {
                        cVar.qe("");
                    }
                }
            };
            LinkedList linkedList = new LinkedList();
            yd ydVar = new yd();
            ydVar.nlV = str;
            ydVar.kzz = i;
            ydVar.vOy = i3;
            ydVar.wpv = i2;
            linkedList.add(ydVar);
            a(linkedList, anonymousClass2);
        }
        return au;
    }

    private static void a(LinkedList<yd> linkedList, final b bVar) {
        com.tencent.mm.ad.b.a aVar = new com.tencent.mm.ad.b.a();
        aVar.hnS = 1138;
        aVar.uri = "/cgi-bin/mmbiz-bin/wxausrevent/getappconfig";
        aVar.hnU = new yf();
        aVar.hnV = 0;
        aVar.hnW = 0;
        com.tencent.mm.bp.a yeVar = new ye();
        yeVar.wpw = linkedList;
        aVar.hnT = yeVar;
        u.a(aVar.Kf(), new com.tencent.mm.ad.u.a() {
            public final int a(int i, int i2, String str, com.tencent.mm.ad.b bVar, k kVar) {
                if (bVar != null) {
                    bVar.a(i, i2, str, bVar);
                }
                return 0;
            }
        }, true);
    }
}
