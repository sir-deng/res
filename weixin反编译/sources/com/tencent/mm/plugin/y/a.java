package com.tencent.mm.plugin.y;

import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.tencent.mm.bx.h.d;
import com.tencent.mm.f.a.gz;
import com.tencent.mm.kernel.api.bucket.b;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.api.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.pluginsdk.model.app.i;
import com.tencent.mm.pluginsdk.model.app.k;
import com.tencent.mm.pluginsdk.model.app.m;
import com.tencent.mm.pluginsdk.model.app.t;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class a implements com.tencent.mm.kernel.api.bucket.a, b, c, e, com.tencent.mm.kernel.b.c {
    private static HashMap<Integer, d> gyG;
    private static volatile a pfj;
    private com.tencent.mm.pluginsdk.model.app.c pfk;
    private com.tencent.mm.pluginsdk.model.app.e pfl;
    private h pfm;
    private i pfn;
    private k pfo;
    private m pfp;
    private com.tencent.mm.pluginsdk.model.app.d pfq;
    private com.tencent.mm.sdk.b.c pfr = new com.tencent.mm.sdk.b.c<gz>() {
        {
            this.xmG = gz.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            a.biV().Pm(((gz) bVar).fyb.appId);
            return false;
        }
    };

    private a() {
        com.tencent.mm.plugin.y.a.a.a.a(new com.tencent.mm.plugin.y.a.a() {
            public final f HL(String str) {
                return a.biT().Sk(str);
            }

            public final Cursor uN(int i) {
                Cursor rawQuery = a.biT().rawQuery("select * from AppInfo where status = 5" + " order by modifyTime asc", new String[0]);
                if (rawQuery != null) {
                    return rawQuery;
                }
                x.e("MicroMsg.AppInfoStorage", "getAppByStatus : cursor is null");
                return null;
            }

            public final Cursor k(int[] iArr) {
                i biT = a.biT();
                String str = "select * from AppInfo where ";
                for (int i = 0; i <= 0; i++) {
                    str = str + " status = " + iArr[0];
                }
                Cursor rawQuery = biT.rawQuery(str + " order by status desc, modifyTime asc", new String[0]);
                if (rawQuery != null) {
                    return rawQuery;
                }
                x.e("MicroMsg.AppInfoStorage", "getAppByStatus : cursor is null");
                return null;
            }

            public final Bitmap a(String str, int i, float f) {
                a.biT();
                if (str == null || str.length() == 0) {
                    x.e("MicroMsg.AppInfoStorage", "getIcon : invalid argument");
                    return null;
                } else if (str.equals("wx7fa037cc7dfabad5")) {
                    return BitmapFactory.decodeResource(ad.getContext().getResources(), com.tencent.mm.plugin.comm.a.d.bKz);
                } else {
                    String cU = i.cU(str, i);
                    if (com.tencent.mm.a.e.bO(cU)) {
                        return BackwardSupportUtil.b.b(cU, f);
                    }
                    x.e("MicroMsg.AppInfoStorage", "icon does not exist, iconPath = " + cU + ", iconType = " + i);
                    return null;
                }
            }

            public final void bU(String str, int i) {
                a.biR().cS(str, i);
            }

            public final void HM(String str) {
                a.biS().Si(str);
            }

            public final void c(f fVar) {
                i biT = a.biT();
                if (fVar != null && fVar.field_status != 5) {
                    fVar.field_status = 3;
                    x.i("MicroMsg.AppInfoStorage", "setBlack package name = %s", fVar.field_packageName);
                    biT.a(fVar, new String[0]);
                }
            }

            public final void d(f fVar) {
                i biT = a.biT();
                if (fVar != null && fVar.field_status == 3) {
                    fVar.field_status = 4;
                    biT.a(fVar, new String[0]);
                }
            }

            public final void e(f fVar) {
                a.biT().a(fVar, new String[0]);
            }

            public final i biW() {
                return a.biT();
            }

            public final void aa(LinkedList<String> linkedList) {
                a.biS().au(linkedList);
            }

            public final Cursor dj(int i, int i2) {
                return a.biT().dj(i, i2);
            }

            public final Cursor biX() {
                i biT = a.biT();
                StringBuilder stringBuilder = new StringBuilder(256);
                stringBuilder.append("select * from AppInfo");
                stringBuilder.append(" where ");
                stringBuilder.append("serviceAppType > 0");
                Cursor rawQuery = biT.rawQuery(stringBuilder.toString(), new String[0]);
                if (rawQuery == null) {
                    x.e("MicroMsg.AppInfoStorage", "getAllServices : cursor is null");
                    return null;
                }
                x.d("MicroMsg.AppInfoStorage", "getAllServices count = %d", Integer.valueOf(rawQuery.getCount()));
                return rawQuery;
            }
        });
    }

    public static a biQ() {
        if (pfj == null) {
            synchronized (a.class) {
                if (pfj == null) {
                    pfj = new a();
                }
            }
        }
        return pfj;
    }

    public List<String> collectStoragePaths() {
        Object linkedList = new LinkedList();
        Collections.addAll(linkedList, new String[]{"openapi/"});
        return linkedList;
    }

    public static String FA() {
        return g.Dq().gRT + "openapi/";
    }

    public static com.tencent.mm.pluginsdk.model.app.c aqK() {
        g.Do().CA();
        if (biQ().pfk == null) {
            biQ().pfk = new com.tencent.mm.pluginsdk.model.app.c(g.Dq().gRU);
        }
        return biQ().pfk;
    }

    public static com.tencent.mm.pluginsdk.model.app.e biR() {
        g.Do().CA();
        if (biQ().pfl == null) {
            biQ().pfl = new com.tencent.mm.pluginsdk.model.app.e();
        }
        return biQ().pfl;
    }

    public static h biS() {
        g.Do().CA();
        if (biQ().pfm == null) {
            biQ().pfm = new h();
        }
        return biQ().pfm;
    }

    public static i biT() {
        g.Do().CA();
        if (biQ().pfn == null) {
            biQ().pfn = new i(g.Dq().gRU);
        }
        return biQ().pfn;
    }

    public static k biU() {
        g.Do().CA();
        if (biQ().pfo == null) {
            biQ().pfo = new k(g.Dq().gRU);
        }
        return biQ().pfo;
    }

    public static m biV() {
        g.Do().CA();
        if (biQ().pfp == null) {
            biQ().pfp = new m();
        }
        return biQ().pfp;
    }

    public static com.tencent.mm.pluginsdk.model.app.d aRP() {
        g.Do().CA();
        if (biQ().pfq == null) {
            biQ().pfq = new com.tencent.mm.pluginsdk.model.app.d();
        }
        return biQ().pfq;
    }

    public void onAccountInitialized(com.tencent.mm.kernel.e.c cVar) {
        com.tencent.mm.y.ab.a.hht = biS();
        com.tencent.mm.sdk.b.a.xmy.b(this.pfr);
    }

    public void onAccountRelease() {
        com.tencent.mm.ad.e eVar = biQ().pfm;
        if (eVar != null) {
            g.Dp().gRu.b(231, eVar);
            aRP().b(7, eVar);
        }
        com.tencent.mm.pluginsdk.model.app.e eVar2 = biQ().pfl;
        if (eVar2 != null) {
            eVar2.vkK.clear();
            eVar2.qqZ.clear();
            eVar2.iYc.clear();
        }
        t tVar = biQ().pfp;
        if (tVar != null) {
            x.d("MicroMsg.AppSettingService", "stop service");
            tVar.vlg.clear();
            aRP().b(1, tVar);
        }
        if (this.pfq != null) {
            eVar = this.pfq;
            g.Dp().gRu.b(452, eVar);
            eVar.hoJ.clear();
        }
        if (biQ().pfn != null) {
            biQ().pfn.vkY.clear();
        }
        com.tencent.mm.sdk.b.a.xmy.c(this.pfr);
        x.i("XPinOpenApi", "onAccountRelease");
    }

    static {
        HashMap hashMap = new HashMap();
        gyG = hashMap;
        hashMap.put(Integer.valueOf("APPATTACHINFO_TABLE".hashCode()), new d() {
            public final String[] wn() {
                return com.tencent.mm.pluginsdk.model.app.c.gLy;
            }
        });
        gyG.put(Integer.valueOf("APPINFO_TABLE".hashCode()), new d() {
            public final String[] wn() {
                return i.gLy;
            }
        });
    }

    public HashMap<Integer, d> collectDatabaseFactory() {
        return gyG;
    }

    public void onDataBaseOpened(com.tencent.mm.bx.h hVar, com.tencent.mm.bx.h hVar2) {
    }

    public void onDataBaseClosed(com.tencent.mm.bx.h hVar, com.tencent.mm.bx.h hVar2) {
        this.pfk = null;
        this.pfn = null;
        x.i("XPinOpenApi", "onDataBaseClosed");
    }
}
