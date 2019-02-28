package com.tencent.mm.pluginsdk.ui.tools;

import android.content.Intent;
import com.tencent.mm.af.d;
import com.tencent.mm.af.y;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.protocal.c.bfr;
import com.tencent.mm.protocal.c.bgg;
import com.tencent.mm.protocal.c.py;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.ui.e.a;

public final class c {
    public static void a(Intent intent, bfr bfr, int i) {
        String a = n.a(bfr.wfM);
        if (!bi.oN(a) || bfr.wRK.isEmpty()) {
            intent.putExtra("Contact_User", a);
            intent.putExtra("Contact_Nick", n.a(bfr.wzM));
            intent.putExtra("Contact_PyInitial", n.a(bfr.wfA));
            intent.putExtra("Contact_QuanPin", n.a(bfr.wfB));
            intent.putExtra("Contact_Alias", bfr.hxj);
            intent.putExtra("Contact_Sex", bfr.hxe);
            intent.putExtra("Contact_VUser_Info", bfr.wCr);
            intent.putExtra("Contact_VUser_Info_Flag", bfr.wCq);
            intent.putExtra("Contact_KWeibo_flag", bfr.wCu);
            intent.putExtra("Contact_KWeibo", bfr.wCs);
            intent.putExtra("Contact_KWeiboNick", bfr.wCt);
            intent.putExtra("Contact_Scene", i);
            intent.putExtra("Contact_KHideExpose", true);
            intent.putExtra("Contact_RegionCode", RegionCodeDecoder.ai(bfr.hxn, bfr.hxf, bfr.hxg));
            intent.putExtra("Contact_Signature", bfr.hxh);
            intent.putExtra("Contact_BrandList", bfr.hxo);
            intent.putExtra("Contact_KSnsIFlag", bfr.wCw.hxp);
            intent.putExtra("Contact_KSnsBgId", bfr.wCw.hxr);
            intent.putExtra("Contact_KSnsBgUrl", bfr.wCw.hxq);
            intent.putExtra("Contact_BIZ_KF_WORKER_ID", bfr.wRH);
            intent.putExtra(a.xML, bfr.woW);
            intent.putExtra("Contact_BIZ_PopupInfoMsg", bfr.wRI);
            x.i("MicroMsg.BuildContactInfoIntent", "[tomys] anti, content: %s", bfr.woW);
            d dVar = new d();
            dVar.field_username = a;
            dVar.field_brandList = bfr.hxo;
            dVar.field_kfWorkerId = bfr.wRH;
            py pyVar = bfr.wCx;
            if (pyVar != null) {
                dVar.field_brandFlag = pyVar.hxs;
                dVar.field_brandInfo = pyVar.hxu;
                dVar.field_extInfo = pyVar.hxt;
                dVar.field_brandIconURL = pyVar.hxv;
            }
            if (!y.Ml().e(dVar)) {
                y.Ml().d(dVar);
                return;
            }
            return;
        }
        a(intent, (bgg) bfr.wRK.getFirst(), i);
    }

    public static void a(Intent intent, bgg bgg, int i) {
        intent.putExtra("Contact_User", bgg.kyG);
        intent.putExtra("Contact_Nick", bgg.kzN);
        intent.putExtra("Contact_PyInitial", bgg.weO);
        intent.putExtra("Contact_QuanPin", bgg.weP);
        intent.putExtra("Contact_Sex", bgg.hxe);
        intent.putExtra("Contact_Scene", i);
        intent.putExtra("Contact_KHideExpose", true);
        intent.putExtra(a.xML, bgg.woW);
        intent.putExtra("key_add_contact_openim_appid", bgg.nlV);
        intent.putExtra("key_add_contact_match_type", bgg.wRE);
        intent.putExtra("key_add_contact_custom_detail_visible", bgg.wRV.wKb);
        intent.putExtra("key_add_contact_custom_detail", bgg.wRV.nlZ);
        intent.putExtra("key_add_contact_desc_wording_id", bgg.wRX);
        intent.putExtra("key_add_contact_desc_icon", bgg.wRW);
        x.i("MicroMsg.BuildContactInfoIntent", "[tomys] anti, content: %s", bgg.woW);
    }
}
