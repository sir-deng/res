package com.tencent.mm.f.b;

import com.tencent.mm.bx.h;
import com.tencent.mm.bx.h.d;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import junit.framework.Assert;

public final class ew extends h {
    private static ew gyF = null;
    private static HashMap<Integer, d> gyG;

    static {
        HashMap hashMap = new HashMap();
        gyG = hashMap;
        hashMap.put(Integer.valueOf("FavItemInfo".hashCode()), new d() {
            public final String[] wn() {
                return new String[]{i.a(bc.vQ(), "FavItemInfo")};
            }
        });
        gyG.put(Integer.valueOf("FavSearchInfo".hashCode()), new d() {
            public final String[] wn() {
                return new String[]{i.a(bd.vQ(), "FavSearchInfo")};
            }
        });
        gyG.put(Integer.valueOf("FavEditInfo".hashCode()), new d() {
            public final String[] wn() {
                return new String[]{i.a(bb.vQ(), "FavEditInfo")};
            }
        });
        gyG.put(Integer.valueOf("FavCdnInfo".hashCode()), new d() {
            public final String[] wn() {
                return new String[]{i.a(az.vQ(), "FavCdnInfo")};
            }
        });
        gyG.put(Integer.valueOf("FavConfigInfo".hashCode()), new d() {
            public final String[] wn() {
                return new String[]{i.a(ba.vQ(), "FavConfigInfo")};
            }
        });
    }

    private ew() {
        boolean z;
        long currentTimeMillis = System.currentTimeMillis();
        g.Do();
        if (a.Cn() != 0) {
            z = true;
        } else {
            z = false;
        }
        Assert.assertTrue(z);
        x.d("MicroMsg.FavoriteDataBase", "db path", g.Dq().cachePath + "enFavorite.db");
        g.Do();
        if (a("", g.Dq().cachePath + "enFavorite.db", (long) a.Cn(), q.yL(), gyG)) {
            String str = this.xJT;
            if (!bi.oN(str)) {
                x.e("MicroMsg.FavoriteDataBase", "dbinit failed :" + str);
                b.z("init db Favorite Failed: [ " + str + "]", "DBinit");
            }
            x.d("MicroMsg.FavoriteDataBase", "init db Favorite time:%d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            return;
        }
        throw new com.tencent.mm.y.b((byte) 0);
    }

    public static ew wm() {
        if (gyF == null) {
            gyF = new ew();
        }
        return gyF;
    }

    public final void ed(String str) {
        super.ed(str);
        gyF = null;
    }
}
