package com.tencent.mm.plugin.card.a;

import com.tencent.mm.a.o;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.x.g.a;
import java.util.Map;

public final class h {
    public int hdY;
    public String hdZ;
    public String hea;
    public String heb;
    public String hec;
    public String hed;
    public String hee;
    public String hef;
    public int ver;

    public static h b(a aVar) {
        Map map = aVar.hfv;
        h hVar = new h();
        hVar.hdZ = bi.aD((String) map.get(".msg.appmsg.giftcard_info.order_id"), "");
        hVar.hdY = o.bY((String) map.get(".msg.appmsg.giftcard_info.biz_uin"));
        hVar.hea = bi.aD((String) map.get(".msg.appmsg.giftcard_info.app_name"), "");
        hVar.heb = bi.aD((String) map.get(".msg.appmsg.giftcard_info.recv_digest"), "");
        hVar.hec = bi.aD((String) map.get(".msg.appmsg.giftcard_info.send_digest"), "");
        hVar.hed = bi.aD((String) map.get(".msg.appmsg.giftcard_info.background_pic_url"), "");
        hVar.hee = bi.aD((String) map.get(".msg.appmsg.giftcard_info.title_color"), "");
        hVar.hef = bi.aD((String) map.get(".msg.appmsg.giftcard_info.des_color"), "");
        hVar.ver = o.bY((String) map.get(".msg.appmsg.giftcard_info.ver"));
        return hVar;
    }
}
