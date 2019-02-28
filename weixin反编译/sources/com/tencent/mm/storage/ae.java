package com.tencent.mm.storage;

import com.tencent.mm.l.a;

public final class ae extends a implements com.tencent.mm.bx.a.a<String> {
    public au xGE;

    public final /* bridge */ /* synthetic */ Object getKey() {
        return this.field_username;
    }

    public ae(String str) {
        super(str);
    }

    public final void ac(au auVar) {
        ae aeVar;
        long j;
        ae aeVar2;
        eR(auVar.field_status);
        eS(auVar.field_isSend);
        if (auVar.cjX()) {
            aeVar = this;
        } else if (auVar.field_status == 1) {
            j = Long.MAX_VALUE;
            aeVar2 = this;
            aeVar2.aj(j);
            if (auVar.cjS()) {
                setContent(auVar.field_content);
            } else {
                setContent(auVar.ckt());
            }
        } else {
            aeVar = this;
        }
        aeVar2 = aeVar;
        j = auVar.field_createTime;
        aeVar2.aj(j);
        if (auVar.cjS()) {
            setContent(auVar.field_content);
        } else {
            setContent(auVar.ckt());
        }
    }

    public final void cjn() {
        eR(0);
        eS(0);
        setContent("");
        dG("0");
        eP(0);
        eY(0);
        al(0);
        eX(0);
        eX(0);
        super.dH("");
        super.dI("");
    }

    public final void o(int i, byte[] bArr) {
    }

    public final void Q(int i, long j) {
        switch (i) {
            case 0:
                eP((int) j);
                return;
            case 1:
                eR((int) j);
                return;
            case 2:
                eS((int) j);
                return;
            case 3:
                aj(j);
                return;
            case 7:
                ak(j);
                return;
            case 10:
                eU((int) j);
                return;
            case 12:
                eV((int) j);
                return;
            case 14:
                eY((int) j);
                return;
            default:
                return;
        }
    }

    public final void aX(int i, String str) {
        switch (i) {
            case 4:
                setUsername(str);
                return;
            case 5:
                setContent(str);
                return;
            case 6:
                dG(str);
                return;
            case 8:
                dH(str);
                return;
            case 9:
                dI(str);
                return;
            case 11:
                dK(str);
                return;
            default:
                return;
        }
    }

    public final void cix() {
    }
}
