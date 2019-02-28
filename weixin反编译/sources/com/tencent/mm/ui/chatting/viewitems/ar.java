package com.tencent.mm.ui.chatting.viewitems;

import android.os.Bundle;
import com.tencent.mm.pluginsdk.ui.chat.c;
import com.tencent.mm.storage.au;
import com.tencent.mm.x.g.a;

public class ar extends c {
    public String chatroomName;
    public String desc;
    public String designerName;
    public String designerRediretctUrl;
    public int designerUIN;
    public a fFo;
    public String fHu;
    public String fHv;
    public String fMx;
    public String frQ;
    public String gkB;
    public String heX;
    public String iconUrl;
    public int pageType;
    public int position;
    public String secondUrl;
    public int tid;
    public String title;
    public long tzD;
    public int tzE;
    public String userName;
    public boolean yXA;
    public String yXB;
    public Bundle yXC;
    public boolean yXv;
    public String yXw;
    public boolean yXx;
    public boolean yXy;
    public String yXz;
    public boolean yxU;

    public ar(au auVar, int i, String str, String str2, String str3, String str4, String str5, int i2, String str6, String str7, String str8) {
        this.fFE = auVar;
        this.yxU = false;
        this.position = i;
        this.userName = str;
        this.yXv = false;
        this.title = str2;
        this.fHu = str3;
        this.fHv = str4;
        this.yXw = str5;
        this.designerUIN = i2;
        this.designerName = str6;
        this.designerRediretctUrl = str7;
        this.gkB = str8;
    }

    public ar(au auVar, boolean z, int i, String str, boolean z2, String str2, String str3, String str4, String str5, String str6, String str7, boolean z3, boolean z4) {
        this.fFE = auVar;
        this.yxU = z;
        this.position = i;
        this.userName = str;
        this.yXv = z2;
        this.title = str2;
        this.fHu = str3;
        this.fHv = str4;
        this.yXw = str5;
        this.frQ = str6;
        this.gkB = str7;
        this.yXx = z3;
        this.yXy = z4;
    }

    public ar(au auVar, boolean z, int i, String str, boolean z2, String str2, String str3, String str4, String str5) {
        this(auVar, z, i, str, z2, str2, str3, str4, str5, null, null, false, false);
    }

    public ar(au auVar, boolean z, int i, String str, boolean z2, String str2, String str3, String str4) {
        this(auVar, z, i, str, z2, str2, str3, str4, null);
    }

    private ar(au auVar, boolean z, int i, String str, boolean z2) {
        this(auVar, z, i, str, false, null, null, null);
    }

    private ar(au auVar, boolean z, int i, String str) {
        this(auVar, z, i, str, false);
    }

    public ar(au auVar, boolean z, int i, String str, byte b) {
        this(auVar, z, i, str);
    }

    public ar(au auVar, boolean z, int i, String str, String str2) {
        this(auVar, z, i, str);
        this.chatroomName = str2;
    }

    public ar(au auVar, String str) {
        this(str);
        this.fFE = auVar;
    }

    private ar(String str) {
        this.userName = str;
    }

    public ar(String str, String str2) {
        this.userName = str;
        this.chatroomName = str2;
    }

    public ar(au auVar, String str, String str2) {
        this.fFE = auVar;
        this.userName = str;
        this.fFE = auVar;
        this.yXB = str2;
    }

    public static ar aae(String str) {
        ar arVar = new ar();
        arVar.gkB = str;
        return arVar;
    }

    public static ar a(a aVar, au auVar) {
        ar arVar = new ar();
        arVar.fFo = aVar;
        arVar.fFE = auVar;
        return arVar;
    }

    public static ar b(au auVar, boolean z, int i) {
        ar arVar = new ar();
        arVar.fFE = auVar;
        arVar.yxU = z;
        arVar.position = i;
        arVar.yXA = false;
        return arVar;
    }
}
