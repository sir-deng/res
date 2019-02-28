package com.tencent.mm.plugin.report.kvdata;

import com.tencent.mm.bp.a;
import e.a.a.b;
import java.util.LinkedList;

public class SDStatusInfo extends a {
    public long eAvailableBlockCount_;
    public int eAvailablePer_;
    public long eAvailableSize_;
    public long eBlockCount_;
    public long eBlockSize_;
    public String ePath_;
    public long eTotalSize_;
    public String fSystem_;
    public int hasUnRemovable_;
    public int ratioHeavy_;
    public String root_;
    public long sAvailableBlockCount_;
    public int sAvailablePer_;
    public long sAvailableSize_;
    public long sBlockCount_;
    public long sBlockSize_;
    public long sTotalSize_;
    public int sizeHeavy_;
    public int useExternal_;
    public int weChatPer_;
    public WeChatSDInfo weChatSDInfo_;

    protected final int a(int i, Object... objArr) {
        int fW;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            if (this.weChatSDInfo_ == null) {
                throw new b("Not all required fields were included: weChatSDInfo_");
            }
            if (this.weChatSDInfo_ != null) {
                aVar.fZ(1, this.weChatSDInfo_.bkL());
                this.weChatSDInfo_.a(aVar);
            }
            aVar.fX(2, this.weChatPer_);
            aVar.fX(3, this.sizeHeavy_);
            aVar.fX(4, this.ratioHeavy_);
            aVar.fX(5, this.useExternal_);
            aVar.fX(6, this.hasUnRemovable_);
            aVar.S(7, this.sBlockSize_);
            aVar.S(8, this.sBlockCount_);
            aVar.S(9, this.sTotalSize_);
            aVar.S(10, this.sAvailableBlockCount_);
            aVar.S(11, this.sAvailableSize_);
            aVar.fX(12, this.sAvailablePer_);
            aVar.S(13, this.eBlockSize_);
            aVar.S(14, this.eBlockCount_);
            aVar.S(15, this.eTotalSize_);
            aVar.S(16, this.eAvailableBlockCount_);
            aVar.S(17, this.eAvailableSize_);
            aVar.fX(18, this.eAvailablePer_);
            if (this.ePath_ != null) {
                aVar.g(19, this.ePath_);
            }
            if (this.root_ != null) {
                aVar.g(20, this.root_);
            }
            if (this.fSystem_ == null) {
                return 0;
            }
            aVar.g(21, this.fSystem_);
            return 0;
        } else if (i == 1) {
            if (this.weChatSDInfo_ != null) {
                fW = e.a.a.a.fW(1, this.weChatSDInfo_.bkL()) + 0;
            } else {
                fW = 0;
            }
            fW = ((((((((((((((((fW + e.a.a.a.fU(2, this.weChatPer_)) + e.a.a.a.fU(3, this.sizeHeavy_)) + e.a.a.a.fU(4, this.ratioHeavy_)) + e.a.a.a.fU(5, this.useExternal_)) + e.a.a.a.fU(6, this.hasUnRemovable_)) + e.a.a.a.R(7, this.sBlockSize_)) + e.a.a.a.R(8, this.sBlockCount_)) + e.a.a.a.R(9, this.sTotalSize_)) + e.a.a.a.R(10, this.sAvailableBlockCount_)) + e.a.a.a.R(11, this.sAvailableSize_)) + e.a.a.a.fU(12, this.sAvailablePer_)) + e.a.a.a.R(13, this.eBlockSize_)) + e.a.a.a.R(14, this.eBlockCount_)) + e.a.a.a.R(15, this.eTotalSize_)) + e.a.a.a.R(16, this.eAvailableBlockCount_)) + e.a.a.a.R(17, this.eAvailableSize_)) + e.a.a.a.fU(18, this.eAvailablePer_);
            if (this.ePath_ != null) {
                fW += e.a.a.b.b.a.h(19, this.ePath_);
            }
            if (this.root_ != null) {
                fW += e.a.a.b.b.a.h(20, this.root_);
            }
            if (this.fSystem_ != null) {
                fW += e.a.a.b.b.a.h(21, this.fSystem_);
            }
            return fW;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fW = a.a(aVar2); fW > 0; fW = a.a(aVar2)) {
                if (!super.a(aVar2, this, fW)) {
                    aVar2.cKx();
                }
            }
            if (this.weChatSDInfo_ != null) {
                return 0;
            }
            throw new b("Not all required fields were included: weChatSDInfo_");
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            SDStatusInfo sDStatusInfo = (SDStatusInfo) objArr[1];
            int intValue = ((Integer) objArr[2]).intValue();
            switch (intValue) {
                case 1:
                    LinkedList JD = aVar3.JD(intValue);
                    int size = JD.size();
                    for (intValue = 0; intValue < size; intValue++) {
                        byte[] bArr = (byte[]) JD.get(intValue);
                        a weChatSDInfo = new WeChatSDInfo();
                        e.a.a.a.a aVar4 = new e.a.a.a.a(bArr, unknownTagHandler);
                        for (boolean z = true; z; z = weChatSDInfo.a(aVar4, weChatSDInfo, a.a(aVar4))) {
                        }
                        sDStatusInfo.weChatSDInfo_ = weChatSDInfo;
                    }
                    return 0;
                case 2:
                    sDStatusInfo.weChatPer_ = aVar3.AEQ.rz();
                    return 0;
                case 3:
                    sDStatusInfo.sizeHeavy_ = aVar3.AEQ.rz();
                    return 0;
                case 4:
                    sDStatusInfo.ratioHeavy_ = aVar3.AEQ.rz();
                    return 0;
                case 5:
                    sDStatusInfo.useExternal_ = aVar3.AEQ.rz();
                    return 0;
                case 6:
                    sDStatusInfo.hasUnRemovable_ = aVar3.AEQ.rz();
                    return 0;
                case 7:
                    sDStatusInfo.sBlockSize_ = aVar3.AEQ.rA();
                    return 0;
                case 8:
                    sDStatusInfo.sBlockCount_ = aVar3.AEQ.rA();
                    return 0;
                case 9:
                    sDStatusInfo.sTotalSize_ = aVar3.AEQ.rA();
                    return 0;
                case 10:
                    sDStatusInfo.sAvailableBlockCount_ = aVar3.AEQ.rA();
                    return 0;
                case 11:
                    sDStatusInfo.sAvailableSize_ = aVar3.AEQ.rA();
                    return 0;
                case 12:
                    sDStatusInfo.sAvailablePer_ = aVar3.AEQ.rz();
                    return 0;
                case 13:
                    sDStatusInfo.eBlockSize_ = aVar3.AEQ.rA();
                    return 0;
                case 14:
                    sDStatusInfo.eBlockCount_ = aVar3.AEQ.rA();
                    return 0;
                case 15:
                    sDStatusInfo.eTotalSize_ = aVar3.AEQ.rA();
                    return 0;
                case 16:
                    sDStatusInfo.eAvailableBlockCount_ = aVar3.AEQ.rA();
                    return 0;
                case 17:
                    sDStatusInfo.eAvailableSize_ = aVar3.AEQ.rA();
                    return 0;
                case 18:
                    sDStatusInfo.eAvailablePer_ = aVar3.AEQ.rz();
                    return 0;
                case 19:
                    sDStatusInfo.ePath_ = aVar3.AEQ.readString();
                    return 0;
                case 20:
                    sDStatusInfo.root_ = aVar3.AEQ.readString();
                    return 0;
                case 21:
                    sDStatusInfo.fSystem_ = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
