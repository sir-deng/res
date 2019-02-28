package com.tencent.mm.plugin.report.kvdata;

import com.tencent.mm.bp.a;

public class VoiceInputBehavior extends a {
    public int cancel;
    public int clear;
    public int click;
    public int fail;
    public int fullScreenVoiceLongClick;
    public long fullScreenVoiceLongClickTime;
    public int longClick;
    public long longClickTime;
    public int send;
    public int smileIconClick;
    public int textChangeCount;
    public int textChangeReturn;
    public long textChangeTime;
    public int textClick;
    public int voiceIconClick;
    public long voiceInputTime;

    protected final int a(int i, Object... objArr) {
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fX(1, this.cancel);
            aVar.fX(2, this.send);
            aVar.fX(3, this.click);
            aVar.fX(4, this.longClick);
            aVar.S(5, this.longClickTime);
            aVar.fX(6, this.textClick);
            aVar.fX(7, this.textChangeCount);
            aVar.S(8, this.textChangeTime);
            aVar.fX(9, this.textChangeReturn);
            aVar.S(10, this.voiceInputTime);
            aVar.fX(11, this.fail);
            aVar.fX(12, this.clear);
            aVar.fX(13, this.smileIconClick);
            aVar.fX(14, this.voiceIconClick);
            aVar.fX(15, this.fullScreenVoiceLongClick);
            aVar.S(16, this.fullScreenVoiceLongClickTime);
            return 0;
        } else if (i == 1) {
            return (((((((((((((((e.a.a.a.fU(1, this.cancel) + 0) + e.a.a.a.fU(2, this.send)) + e.a.a.a.fU(3, this.click)) + e.a.a.a.fU(4, this.longClick)) + e.a.a.a.R(5, this.longClickTime)) + e.a.a.a.fU(6, this.textClick)) + e.a.a.a.fU(7, this.textChangeCount)) + e.a.a.a.R(8, this.textChangeTime)) + e.a.a.a.fU(9, this.textChangeReturn)) + e.a.a.a.R(10, this.voiceInputTime)) + e.a.a.a.fU(11, this.fail)) + e.a.a.a.fU(12, this.clear)) + e.a.a.a.fU(13, this.smileIconClick)) + e.a.a.a.fU(14, this.voiceIconClick)) + e.a.a.a.fU(15, this.fullScreenVoiceLongClick)) + e.a.a.a.R(16, this.fullScreenVoiceLongClickTime);
        } else {
            if (i == 2) {
                e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
                for (int a = a.a(aVar2); a > 0; a = a.a(aVar2)) {
                    if (!super.a(aVar2, this, a)) {
                        aVar2.cKx();
                    }
                }
                return 0;
            } else if (i != 3) {
                return -1;
            } else {
                e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
                VoiceInputBehavior voiceInputBehavior = (VoiceInputBehavior) objArr[1];
                switch (((Integer) objArr[2]).intValue()) {
                    case 1:
                        voiceInputBehavior.cancel = aVar3.AEQ.rz();
                        return 0;
                    case 2:
                        voiceInputBehavior.send = aVar3.AEQ.rz();
                        return 0;
                    case 3:
                        voiceInputBehavior.click = aVar3.AEQ.rz();
                        return 0;
                    case 4:
                        voiceInputBehavior.longClick = aVar3.AEQ.rz();
                        return 0;
                    case 5:
                        voiceInputBehavior.longClickTime = aVar3.AEQ.rA();
                        return 0;
                    case 6:
                        voiceInputBehavior.textClick = aVar3.AEQ.rz();
                        return 0;
                    case 7:
                        voiceInputBehavior.textChangeCount = aVar3.AEQ.rz();
                        return 0;
                    case 8:
                        voiceInputBehavior.textChangeTime = aVar3.AEQ.rA();
                        return 0;
                    case 9:
                        voiceInputBehavior.textChangeReturn = aVar3.AEQ.rz();
                        return 0;
                    case 10:
                        voiceInputBehavior.voiceInputTime = aVar3.AEQ.rA();
                        return 0;
                    case 11:
                        voiceInputBehavior.fail = aVar3.AEQ.rz();
                        return 0;
                    case 12:
                        voiceInputBehavior.clear = aVar3.AEQ.rz();
                        return 0;
                    case 13:
                        voiceInputBehavior.smileIconClick = aVar3.AEQ.rz();
                        return 0;
                    case 14:
                        voiceInputBehavior.voiceIconClick = aVar3.AEQ.rz();
                        return 0;
                    case 15:
                        voiceInputBehavior.fullScreenVoiceLongClick = aVar3.AEQ.rz();
                        return 0;
                    case 16:
                        voiceInputBehavior.fullScreenVoiceLongClickTime = aVar3.AEQ.rA();
                        return 0;
                    default:
                        return -1;
                }
            }
        }
    }
}
