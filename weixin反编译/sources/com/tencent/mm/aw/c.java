package com.tencent.mm.aw;

import com.tencent.mm.plugin.chatroom.c.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import java.util.LinkedList;
import java.util.Map;

public final class c extends a {
    public String fsK;
    public String hKn;
    public LinkedList<String> hKo = new LinkedList();
    public int hKq;
    public LinkedList<String> hKr = new LinkedList();
    public LinkedList<String> hKs = new LinkedList();
    public String hKt = null;
    public String hKu = null;
    public String hKv = null;
    public String text = null;

    public c(Map<String, String> map, au auVar) {
        super(map, auVar);
    }

    protected final boolean QH() {
        int i = 0;
        if (this.values == null) {
            x.e("MicroMsg.ChatroomAccessVerifyApplicationNewXmlMsg", "[parseXml] values == null ");
            return false;
        }
        x.i("MicroMsg.ChatroomAccessVerifyApplicationNewXmlMsg", "[parseXml] type:%s, values size:%s", bi.oM(this.TYPE), Integer.valueOf(this.values.size()));
        if (bi.oN(this.TYPE) || !this.TYPE.equalsIgnoreCase("NewXmlChatRoomAccessVerifyApplication")) {
            x.e("MicroMsg.ChatroomAccessVerifyApplicationNewXmlMsg", "[parseXml] type err :%s", bi.oM(this.TYPE));
            return false;
        }
        this.hKn = (String) this.values.get(".sysmsg.NewXmlChatRoomAccessVerifyApplication.RoomName");
        String str = ".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.text";
        String str2 = ".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.ticket";
        String str3 = ".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.inviterusername";
        String str4 = ".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.invitationreason";
        String str5 = ".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.memberlist.memberlistsize";
        if (this.values.containsKey(str)) {
            this.hKv = bi.oM((String) this.values.get(str));
        }
        if (this.values.containsKey(str3)) {
            this.hKt = bi.oM((String) this.values.get(str3));
        }
        if (this.values.containsKey(str4)) {
            this.hKu = bi.oM((String) this.values.get(str4));
        }
        if (this.values.containsKey(hKf)) {
            this.text = bi.oM((String) this.values.get(hKf));
        }
        if (this.values.containsKey(str2)) {
            this.fsK = (String) this.values.get(str2);
        }
        if (this.values.containsKey(str5)) {
            this.hKq = bi.getInt((String) this.values.get(str5), 0);
        }
        if (this.fFE.cko()) {
            this.hKj.clear();
            this.hKk.clear();
            this.hKl.clear();
            this.hKh = this.text + " ";
            this.hKk.add(Integer.valueOf(this.hKh.length()));
            this.hKj.add(ad.getContext().getString(a.epm));
            this.hKh += ad.getContext().getString(a.epm);
            this.hKl.add(Integer.valueOf(this.hKh.length()));
        } else {
            this.hKk.add(Integer.valueOf(this.text.length()));
            this.hKj.add(this.hKv);
            this.hKh = this.text + this.hKv;
            this.hKl.add(Integer.valueOf(this.hKh.length()));
        }
        while (i < this.hKq) {
            if (i == 0) {
                this.hKo.add(bi.oM((String) this.values.get(".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.memberlist.member.username")));
                this.hKr.add(bi.oM((String) this.values.get(".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.memberlist.member.nickname")));
                this.hKs.add(bi.oM((String) this.values.get(".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.memberlist.member.headimgurl")));
            } else {
                this.hKo.add(bi.oM((String) this.values.get(".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.memberlist.member" + i + ".username")));
                this.hKr.add(bi.oM((String) this.values.get(".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.memberlist.member" + i + ".nickname")));
                this.hKs.add(bi.oM((String) this.values.get(".sysmsg.NewXmlChatRoomAccessVerifyApplication.link.memberlist.member" + i + ".headimgurl")));
            }
            i++;
        }
        return true;
    }
}
