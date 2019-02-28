package com.tencent.mm.plugin.card.b;

import android.text.TextUtils;
import com.tencent.mm.plugin.card.model.d;
import com.tencent.mm.sdk.platformtools.bj;
import java.util.Map;

public final class g {
    public static d xp(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        d dVar = new d();
        Map y = bj.y(str, "msg");
        dVar.kQJ = (String) y.get(".msg.appmsg.carditem.from_username");
        dVar.fHP = (String) y.get(".msg.appmsg.carditem.card_id");
        dVar.kPz = xr((String) y.get(".msg.appmsg.carditem.card_type"));
        dVar.fHR = xr((String) y.get(".msg.appmsg.carditem.from_scene"));
        dVar.hdx = (String) y.get(".msg.appmsg.carditem.color");
        dVar.kQK = (String) y.get(".msg.appmsg.carditem.card_type_name");
        dVar.kQL = (String) y.get(".msg.appmsg.carditem.brand_name");
        dVar.fHQ = (String) y.get(".msg.appmsg.carditem.card_ext");
        dVar.kQM = xr((String) y.get(".msg.appmsg.carditem.is_recommend"));
        dVar.kQN = (String) y.get(".msg.appmsg.carditem.recommend_card_id");
        return dVar;
    }

    public static String xq(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return (String) bj.y(str, "msg").get(".msg.appmsg.fromusername");
    }

    private static int xr(String str) {
        if (TextUtils.isEmpty(str) || !l.xv(str)) {
            return 0;
        }
        return Integer.valueOf(str).intValue();
    }

    public static String a(d dVar) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<from_username>").append(dVar.kQJ).append("</from_username>");
        stringBuilder.append("<card_id>").append(dVar.fHP).append("</card_id>");
        stringBuilder.append("<card_type>").append(dVar.kPz).append("</card_type>");
        stringBuilder.append("<from_scene>").append(dVar.fHR).append("</from_scene>");
        stringBuilder.append("<color>").append(dVar.hdx).append("</color>");
        stringBuilder.append("<card_type_name>").append(dVar.kQK).append("</card_type_name>");
        stringBuilder.append("<brand_name>").append(dVar.kQL).append("</brand_name>");
        if (TextUtils.isEmpty(dVar.fHQ)) {
            stringBuilder.append("<card_ext></card_ext>");
        } else {
            stringBuilder.append("<card_ext>").append(dVar.fHQ).append("</card_ext>");
        }
        stringBuilder.append("<is_recommend>").append(dVar.kQM).append("</is_recommend>");
        stringBuilder.append("<recommend_card_id>").append(dVar.kQN).append("</recommend_card_id>");
        return stringBuilder.toString();
    }
}
