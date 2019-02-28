package com.tencent.wecall.talkroom.model;

import com.tencent.pb.a.a.a;
import com.tencent.pb.common.b.a.a.av;
import com.tencent.pb.common.b.a.a.aw;
import com.tencent.pb.common.c.c;
import com.tencent.pb.common.c.g;

public final class d {
    av Awq;
    private aw Awr;
    private String rQb;

    public d(av avVar) {
        a(avVar);
    }

    public d(av avVar, aw awVar) {
        a(avVar);
        if (awVar == null) {
            c.m("tagorewang:TalkRoomMember", "set null profile");
            return;
        }
        this.Awr = awVar;
    }

    public final void a(av avVar) {
        if (avVar == null) {
            c.m("tagorewang:TalkRoomMember", "set null info");
            return;
        }
        this.Awq = avVar;
    }

    public final String cIC() {
        if (this.Awq != null) {
            return this.Awq.zXO;
        }
        return "";
    }

    public final String getDisplayName() {
        try {
            String str = this.rQb;
            if (str == null || str.trim().length() == 0) {
                return str;
            }
            char[] toCharArray = str.trim().toCharArray();
            int i = 0;
            for (char c : toCharArray) {
                i = c >= 161 ? i + 2 : i + 1;
            }
            if (i <= 10) {
                return str;
            }
            StringBuilder stringBuilder = new StringBuilder();
            i = 0;
            for (int i2 = 0; i2 < toCharArray.length; i2++) {
                i = toCharArray[i2] >= 161 ? i + 2 : i + 1;
                if (i + 1 > 10) {
                    break;
                }
                stringBuilder.append(toCharArray[i2]);
            }
            stringBuilder.append(8230);
            return stringBuilder.toString();
        } catch (Exception e) {
            c.m("tagorewang:TalkRoomMember", "getDisplayName err: ", e);
            return this.rQb;
        }
    }

    public final int getState() {
        if (this.Awq == null) {
            return 0;
        }
        return this.Awq.status;
    }

    public final int cID() {
        if (this.Awq == null) {
            return -1;
        }
        return this.Awq.nJK;
    }

    public final String toString() {
        int i = 0;
        if (this.Awq != null) {
            i = this.Awq.vJp;
        } else if (this.Awr != null) {
            i = this.Awr.vJp;
        }
        if (this.Awq == null || this.Awr == null) {
            return "invlaid TalkRoomMember which uuid is " + i;
        }
        String str;
        StringBuilder stringBuilder;
        StringBuilder stringBuilder2 = new StringBuilder();
        av avVar = this.Awq;
        if (avVar == null) {
            str = "null";
        } else {
            stringBuilder = new StringBuilder();
            stringBuilder.append("VoiceGroupMem");
            stringBuilder.append(" uuid:").append(avVar.vJp);
            stringBuilder.append(" openClientId:").append(avVar.zYK);
            stringBuilder.append(" invite uuid: ").append(avVar.zYG);
            stringBuilder.append(" member id:").append(avVar.nJK);
            stringBuilder.append(" status: ").append(avVar.status);
            stringBuilder.append(" reason: ").append(avVar.aAk);
            str = stringBuilder.toString();
        }
        stringBuilder = stringBuilder2.append(str).append(" ");
        aw awVar = this.Awr;
        if (awVar == null) {
            str = "null";
        } else {
            StringBuilder stringBuilder3 = new StringBuilder();
            stringBuilder3.append("VoiceGroupUsrProfile");
            stringBuilder3.append(" uuid: ").append(awVar.vJp);
            stringBuilder3.append(" user name: ").append(awVar.username);
            stringBuilder3.append(" head url: ").append(awVar.pIQ);
            str = stringBuilder3.toString();
        }
        stringBuilder.append(str);
        return stringBuilder2.toString();
    }

    public final boolean equals(Object obj) {
        if (obj == null || !(obj instanceof d)) {
            return false;
        }
        return g.equals(cIC(), ((d) obj).cIC());
    }

    public final int hashCode() {
        String cIC = cIC();
        return cIC == null ? 0 : cIC.hashCode();
    }

    public final boolean cIE() {
        return g.equals(a.cDO(), cIC());
    }
}
