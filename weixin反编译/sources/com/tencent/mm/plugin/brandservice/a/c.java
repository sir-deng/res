package com.tencent.mm.plugin.brandservice.a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.f.a.ag;
import com.tencent.mm.plugin.brandservice.ui.BizSearchDetailPageUI;
import com.tencent.mm.protocal.c.aou;
import com.tencent.mm.protocal.c.jm;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.as;
import com.tencent.wcdb.database.SQLiteDatabase;

public final class c {

    private static class a implements e {
        private Context context;
        private String foW;
        private long foX;
        private boolean foY;
        private int fromScene;
        private ag kKp;
        private int offset;
        private String title;

        public a(Context context, String str, long j, int i, int i2, String str2, boolean z, ag agVar) {
            this.context = context;
            this.foW = str;
            this.foX = j;
            this.offset = i;
            this.fromScene = i2;
            this.title = str2;
            this.foY = z;
            this.kKp = agVar;
        }

        public final void a(int i, int i2, String str, k kVar) {
            x.i("MicroMsg.BrandService.BrandServiceLogic", "errType (%d) , errCode (%d) , errMsg (errMsg)", Integer.valueOf(i), Integer.valueOf(i2), str);
            if (i != 0 || i2 != 0) {
                dZ(false);
            } else if (kVar == null) {
                x.e("MicroMsg.BrandService.BrandServiceLogic", "scene is null.");
                dZ(false);
            } else if (kVar.getType() != 1071) {
                x.i("MicroMsg.BrandService.BrandServiceLogic", "The NetScene is not a instanceof BizSearchDetailPage.");
            } else {
                x.i("MicroMsg.BrandService.BrandServiceLogic", "BizSearchDetailPage.");
                jm asS = ((h) kVar).asS();
                if (asS == null || asS.nmz == null) {
                    x.e("MicroMsg.BrandService.BrandServiceLogic", "response or BusinessContent or itemList is null.");
                    dZ(false);
                    return;
                }
                x.d("MicroMsg.BrandService.BrandServiceLogic", "searchId : %s.", asS.vWw);
                Intent intent = new Intent(this.context, BizSearchDetailPageUI.class);
                intent.putExtra("addContactScene", 35);
                intent.putExtra("fromScene", this.fromScene);
                intent.putExtra("keyword", this.foW);
                intent.putExtra("businessType", this.foX);
                intent.putExtra("offset", this.offset);
                intent.putExtra("title", this.title);
                intent.putExtra("showEditText", this.foY);
                try {
                    intent.putExtra("result", asS.toByteArray());
                    if (!(this.context instanceof Activity)) {
                        intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                    }
                    dZ(true);
                } catch (Throwable e) {
                    dZ(false);
                    x.printErrStackTrace("MicroMsg.BrandService.BrandServiceLogic", e, "", new Object[0]);
                }
            }
        }

        private void dZ(boolean z) {
            as.CN().b(1071, (e) this);
            if (this.kKp != null && this.kKp.foU.foZ != null) {
                this.kKp.foV.fpa = z;
                this.kKp.foU.foZ.run();
            }
        }
    }

    public static aou Jk() {
        try {
            as.Hm();
            String str = (String) com.tencent.mm.y.c.Db().get(67591, null);
            if (str != null) {
                aou aou = new aou();
                String[] split = str.split(",");
                aou.wjv = Integer.valueOf(split[0]).intValue();
                aou.wjy = Integer.valueOf(split[1]).intValue();
                aou.vXy = ((float) Integer.valueOf(split[2]).intValue()) / 1000000.0f;
                aou.vXx = ((float) Integer.valueOf(split[3]).intValue()) / 1000000.0f;
                x.i("MicroMsg.BrandService.BrandServiceLogic", "lbs location is not null, %f, %f", Float.valueOf(aou.vXy), Float.valueOf(aou.vXx));
                return aou;
            }
            x.i("MicroMsg.BrandService.BrandServiceLogic", "lbs location is null, lbsContent is null!");
            return null;
        } catch (Exception e) {
            x.i("MicroMsg.BrandService.BrandServiceLogic", "lbs location is null, reason %s", e.getMessage());
            return null;
        }
    }
}
