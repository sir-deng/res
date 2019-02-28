package com.tencent.mm.aw;

import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import java.util.LinkedList;
import java.util.Map;

public final class d extends a {
    public String fCl;
    public LinkedList<String> hKw = new LinkedList();
    public String url;

    public d(Map<String, String> map, au auVar) {
        super(map, auVar);
    }

    protected final boolean QH() {
        if (this.values == null) {
            x.e("MicroMsg.DelChatroomMemberNewXmlMsg", "[parseXml] values == null ");
            return false;
        }
        x.i("MicroMsg.DelChatroomMemberNewXmlMsg", "[parseXml] type:%s, values size:%s", bi.oM(this.TYPE), Integer.valueOf(this.values.size()));
        if (bi.oN(this.TYPE) || !this.TYPE.equalsIgnoreCase("delchatroommember")) {
            x.e("MicroMsg.DelChatroomMemberNewXmlMsg", "[parseXml] type err :%s", bi.oM(this.TYPE));
            return false;
        }
        this.url = bi.oM((String) this.values.get(".sysmsg.delchatroommember.url"));
        this.fCl = bi.oM((String) this.values.get(".sysmsg.delchatroommember.link.qrcode"));
        this.hKw.add(this.values.get(".sysmsg.delchatroommember.link.memberlist.username"));
        for (String str : this.values.keySet()) {
            if (str.startsWith(".sysmsg.delchatroommember.link.memberlist.username#")) {
                this.hKw.add(this.values.get(str));
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        int i = 0;
        for (String str2 : this.values.keySet()) {
            if (!str2.startsWith(hKf)) {
                int length;
                if (str2.startsWith(".sysmsg.delchatroommember.link.text")) {
                    stringBuilder.append((String) this.values.get(str2));
                    this.hKj.add(this.values.get(str2));
                    length = ((String) this.values.get(str2)).length();
                } else {
                    length = i;
                }
                i = length;
            } else if (stringBuilder.length() > 0) {
                stringBuilder.insert(0, (String) this.values.get(str2));
            } else {
                stringBuilder.append((String) this.values.get(str2));
            }
        }
        this.hKk.addFirst(Integer.valueOf(stringBuilder.length() - i));
        this.hKl.add(Integer.valueOf(stringBuilder.length()));
        this.hKh = stringBuilder.toString();
        x.i("MicroMsg.DelChatroomMemberNewXmlMsg", "[parseXml] url:%s, qrcode:%s, members size :%s", this.url, this.fCl, Integer.valueOf(this.hKw.size()));
        return true;
    }
}
