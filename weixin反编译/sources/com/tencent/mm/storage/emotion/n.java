package com.tencent.mm.storage.emotion;

import android.database.Cursor;
import com.tencent.mm.bx.g;
import com.tencent.mm.bx.g.a;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class n extends i<m> implements a {
    public static final String[] gLy = new String[]{i.a(m.gKN, "EmotionRewardTipInfo")};
    private e gLA;

    public n(e eVar) {
        this(eVar, m.gKN, "EmotionRewardTipInfo");
    }

    private n(e eVar, c.a aVar, String str) {
        super(eVar, aVar, str, null);
        this.gLA = eVar;
    }

    public final int a(g gVar) {
        if (gVar != null) {
            this.gLA = gVar;
        }
        return 0;
    }

    public final m clz() {
        Throwable e;
        Cursor a;
        try {
            a = this.gLA.a("select * from EmotionRewardTipInfo order by modifyTime desc limit 1 ", new String[0], 2);
            if (a != null) {
                try {
                    if (a.moveToFirst()) {
                        m mVar = new m();
                        mVar.b(a);
                        if (a == null) {
                            return mVar;
                        }
                        a.close();
                        return mVar;
                    }
                } catch (Exception e2) {
                    e = e2;
                    try {
                        x.e("MicroMsg.emoji.EmotionRewardTipStorage", "getLastSendProductID failed. :%s", bi.i(e));
                        if (a != null) {
                            a.close();
                        }
                        return null;
                    } catch (Throwable th) {
                        e = th;
                        if (a != null) {
                            a.close();
                        }
                        throw e;
                    }
                }
            }
            if (a != null) {
                a.close();
            }
        } catch (Exception e3) {
            e = e3;
            a = null;
        } catch (Throwable th2) {
            e = th2;
            a = null;
            if (a != null) {
                a.close();
            }
            throw e;
        }
        return null;
    }

    public final boolean dg(String str, int i) {
        if (bi.oN(str)) {
            x.w("MicroMsg.emoji.EmotionRewardTipStorage", "product id is null.");
            return false;
        }
        x.i("MicroMsg.emoji.EmotionRewardTipStorage", "updateFlag result:%b", Boolean.valueOf(this.gLA.fD("EmotionRewardTipInfo", "UPDATE EmotionRewardTipInfo SET flag=" + i + ",setFlagTime=" + System.currentTimeMillis() + " WHERE prodcutID='" + str + "'")));
        return this.gLA.fD("EmotionRewardTipInfo", "UPDATE EmotionRewardTipInfo SET flag=" + i + ",setFlagTime=" + System.currentTimeMillis() + " WHERE prodcutID='" + str + "'");
    }

    public final boolean a(m mVar) {
        if (mVar == null) {
            x.w("MicroMsg.emoji.EmotionRewardTipStorage", "save failed info is null");
            return false;
        }
        long replace = this.gLA.replace("EmotionRewardTipInfo", "prodcutID", mVar.vP());
        if (replace > 0) {
            x.i("MicroMsg.emoji.EmotionRewardTipStorage", "save success");
        } else {
            x.i("MicroMsg.emoji.EmotionRewardTipStorage", "save failed");
        }
        if (replace > 0) {
            return true;
        }
        return false;
    }
}
