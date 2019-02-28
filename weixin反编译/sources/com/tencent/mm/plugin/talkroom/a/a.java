package com.tencent.mm.plugin.talkroom.a;

import com.tencent.mm.protocal.c.bot;
import e.a.a.b;
import java.util.LinkedList;

public final class a extends com.tencent.mm.bp.a {
    public LinkedList<bot> fBS = new LinkedList();
    public int sceneType;
    public String username;

    protected final int a(int i, Object... objArr) {
        int h;
        byte[] bArr;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.username == null) {
                throw new b("Not all required fields were included: username");
            }
            if (this.username != null) {
                aVar.g(1, this.username);
            }
            aVar.d(2, 8, this.fBS);
            aVar.fX(3, this.sceneType);
            return 0;
        } else if (i == 1) {
            if (this.username != null) {
                h = e.a.a.b.b.a.h(1, this.username) + 0;
            } else {
                h = 0;
            }
            return (h + e.a.a.a.c(2, 8, this.fBS)) + e.a.a.a.fU(3, this.sceneType);
        } else if (i == 2) {
            bArr = (byte[]) objArr[0];
            this.fBS.clear();
            e.a.a.a.a aVar2 = new e.a.a.a.a(bArr, unknownTagHandler);
            for (h = com.tencent.mm.bp.a.a(aVar2); h > 0; h = com.tencent.mm.bp.a.a(aVar2)) {
                if (!super.a(aVar2, this, h)) {
                    aVar2.cKx();
                }
            }
            if (this.username != null) {
                return 0;
            }
            throw new b("Not all required fields were included: username");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            a aVar4 = (a) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    aVar4.username = aVar3.AEQ.readString();
                    return 0;
                case 2:
                    LinkedList JD = aVar3.JD(intValue);
                    int size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        bArr = (byte[]) JD.get(intValue);
                        com.tencent.mm.bp.a bot = new bot();
                        e.a.a.a.a aVar5 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = bot.a(aVar5, bot, com.tencent.mm.bp.a.a(aVar5))) {
                        }
                        aVar4.fBS.add(bot);
                    }
                    return 0;
                case 3:
                    aVar4.sceneType = aVar3.AEQ.rz();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
