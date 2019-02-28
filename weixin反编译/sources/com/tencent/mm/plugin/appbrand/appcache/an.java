package com.tencent.mm.plugin.appbrand.appcache;

import android.widget.Toast;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.appbrand.app.e;
import com.tencent.mm.plugin.appbrand.config.m;
import com.tencent.mm.plugin.appbrand.config.q;
import com.tencent.mm.plugin.appbrand.config.r;
import com.tencent.mm.plugin.appbrand.q.j;
import com.tencent.mm.protocal.c.buj;
import com.tencent.mm.protocal.c.cch;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bj;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public final class an implements com.tencent.mm.y.bt.a {
    public static final Map<String, c> iID;

    public interface c {
        void u(Map<String, String> map);
    }

    private static final class a implements c {
        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }

        public final void u(Map<String, String> map) {
            if (map.get(".sysmsg.mmbizwxaconfig") != null) {
                int i = bi.getInt((String) map.get(".sysmsg.mmbizwxaconfig.command"), -1);
                final int i2 = bi.getInt((String) map.get(".sysmsg.mmbizwxaconfig.type"), 0);
                final String str = (String) map.get(".sysmsg.mmbizwxaconfig.appid");
                x.i("MicroMsg.AppBrand.WxaPkgPushingXmlHandler", "handle common config, command = %d, type = %d, appid = %s, configversion = %d", Integer.valueOf(i), Integer.valueOf(i2), str, Integer.valueOf(bi.getInt((String) map.get(".sysmsg.mmbizwxaconfig.configversion"), 0)));
                LinkedList linkedList = new LinkedList();
                buj buj = new buj();
                buj.version = r1;
                buj.type = i2;
                linkedList.add(buj);
                m.a(str, linkedList, false);
                m.a(str, i2, i, new com.tencent.mm.plugin.appbrand.config.m.c() {
                    public final void qe(String str) {
                        x.i("MicroMsg.AppBrand.WxaPkgPushingXmlHandler", "CommonConfigManager.getConfig config:%s", str);
                        com.tencent.mm.plugin.appbrand.ipc.d.k(str, i2, str);
                    }
                }, true);
            }
        }
    }

    private static final class b implements c {
        private b() {
        }

        /* synthetic */ b(byte b) {
            this();
        }

        public final void u(Map<String, String> map) {
            d(".sysmsg.AppBrandNotify.DebugInfoList.DebugInfo", map);
            int i = 0;
            do {
                i++;
            } while (d(".sysmsg.AppBrandNotify.DebugInfoList.DebugInfo" + i, map));
        }

        private boolean d(String str, Map<String, String> map) {
            x.d("MicroMsg.AppBrand.WxaPkgPushingXmlHandler", "optDebugInfo, prefix = %s", str);
            if (map.get(str) == null) {
                return false;
            }
            final String str2 = (String) map.get(str + ".AppID");
            String str3 = (String) map.get(str + ".UserName");
            final int i = bi.getInt((String) map.get(str + ".Type"), 1);
            String str4 = (String) map.get(str + ".URL");
            long j = bi.getLong((String) map.get(str + ".StartTime"), bi.Wx());
            x.i("MicroMsg.AppBrand.WxaPkgPushingXmlHandler", "handle debug notify, appId = %s, username = %s, debugType = %d, url = %s, start = %d, end = %d, md5 = %s, updated = %b", str2, str3, Integer.valueOf(i), str4, Long.valueOf(j), Long.valueOf(bi.getLong((String) map.get(str + ".EndTime"), 7200 + j)), r7, Boolean.valueOf(e.Zz().a(str2, i, str4, (String) map.get(str + ".MD5"), j, r10)));
            if (e.Zz().a(str2, i, str4, (String) map.get(str + ".MD5"), j, r10)) {
                if (999 != i) {
                    r.rt(str3);
                    final String rm = q.rm(str2);
                    ah.y(new Runnable() {
                        public final void run() {
                            com.tencent.mm.plugin.appbrand.task.d.aL(str2, i);
                            Toast.makeText(ad.getContext(), ad.getContext().getString(j.iDn, new Object[]{bi.aD(rm, str2)}), 1).show();
                        }
                    });
                } else {
                    l.iGR.cp(false);
                }
                e.Zx().a(str3, i, false, false, 0, 0, null);
            }
            return true;
        }
    }

    private static final class d implements c {
        private d() {
        }

        /* synthetic */ d(byte b) {
            this();
        }

        public final void u(Map<String, String> map) {
            if (map.get(".sysmsg.AppPublicLibraryNotify") != null) {
                int i = bi.getInt((String) map.get(".sysmsg.AppPublicLibraryNotify.Version"), 0);
                String str = (String) map.get(".sysmsg.AppPublicLibraryNotify.MD5");
                String str2 = (String) map.get(".sysmsg.AppPublicLibraryNotify.URL");
                int i2 = bi.getInt((String) map.get(".sysmsg.AppPublicLibraryNotify.ForceUpdate"), 0);
                if (bi.oN(str2) || bi.oN(str) || i <= 0) {
                    x.i("MicroMsg.AppBrand.WxaPkgPushingXmlHandler", "handle library notify, invalid params: url = %s, md5 = %s, version = %d", str2, str, Integer.valueOf(i));
                    return;
                }
                x.i("MicroMsg.AppBrand.WxaPkgPushingXmlHandler", "handle library notify, version = %d, md5 = %s, url = %s, forceUpdate = %d", Integer.valueOf(i), str, str2, Integer.valueOf(i2));
                cch cch = new cch();
                cch.version = i;
                cch.frM = str;
                cch.url = str2;
                cch.wNv = i2;
                ac.a(cch);
            }
        }
    }

    static /* synthetic */ void qd(String str) {
        if (e.Zz() == null) {
            x.e("MicroMsg.AppBrand.WxaPkgPushingXmlHandler", "parseAndDownload, but storage not ready");
            return;
        }
        Map y = bj.y(str, "sysmsg");
        if (y == null || y.size() <= 0) {
            x.e("MicroMsg.AppBrand.WxaPkgPushingXmlHandler", "parseImpl, parse failed");
            return;
        }
        String str2 = (String) y.get(".sysmsg.$type");
        x.i("MicroMsg.AppBrand.WxaPkgPushingXmlHandler", "parseImpl, type = %s", str2);
        if (!bi.oN(str2)) {
            c cVar = (c) iID.get(str2);
            if (cVar != null) {
                cVar.u(y);
            }
        }
    }

    static {
        Map hashMap = new HashMap();
        hashMap.put("AppBrandNotify", new b());
        hashMap.put("AppPublicLibraryNotify", new d());
        hashMap.put("mmbizwxaconfig", new a());
        hashMap.put("ForceOpenAppNotify", new com.tencent.mm.plugin.appbrand.debugger.c());
        hashMap.put("AppBrandForceKill", new com.tencent.mm.plugin.appbrand.debugger.b());
        iID = Collections.unmodifiableMap(hashMap);
    }

    public final void a(com.tencent.mm.ad.d.a aVar) {
        final String a = n.a(aVar.hoa.vNO);
        if (bi.oN(a)) {
            x.w("MicroMsg.AppBrand.WxaPkgPushingXmlHandler", "msg content is null");
        } else {
            com.tencent.mm.plugin.appbrand.r.c.Dt().F(new Runnable() {
                public final void run() {
                    an.qd(a);
                }
            });
        }
    }
}
