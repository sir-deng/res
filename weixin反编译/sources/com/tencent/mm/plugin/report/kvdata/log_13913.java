package com.tencent.mm.plugin.report.kvdata;

import com.tencent.mm.bp.a;

public class log_13913 extends a {
    public int clientVersion_;
    public int device_;
    public int ds_;
    public String error_;
    public int import_ds_;
    public int scene_;
    public long time_stamp_;
    public long uin_;

    protected final int a(int i, Object... objArr) {
        int fU;
        if (i == 0) {
            e.a.a.c.a aVar = (e.a.a.c.a) objArr[0];
            aVar.fX(1, this.import_ds_);
            aVar.fX(2, this.ds_);
            aVar.S(3, this.uin_);
            aVar.fX(4, this.device_);
            aVar.fX(5, this.clientVersion_);
            aVar.S(6, this.time_stamp_);
            aVar.fX(7, this.scene_);
            if (this.error_ != null) {
                aVar.g(8, this.error_);
            }
            return 0;
        } else if (i == 1) {
            fU = ((((((e.a.a.a.fU(1, this.import_ds_) + 0) + e.a.a.a.fU(2, this.ds_)) + e.a.a.a.R(3, this.uin_)) + e.a.a.a.fU(4, this.device_)) + e.a.a.a.fU(5, this.clientVersion_)) + e.a.a.a.R(6, this.time_stamp_)) + e.a.a.a.fU(7, this.scene_);
            if (this.error_ != null) {
                return fU + e.a.a.b.b.a.h(8, this.error_);
            }
            return fU;
        } else if (i == 2) {
            e.a.a.a.a aVar2 = new e.a.a.a.a((byte[]) objArr[0], unknownTagHandler);
            for (fU = a.a(aVar2); fU > 0; fU = a.a(aVar2)) {
                if (!super.a(aVar2, this, fU)) {
                    aVar2.cKx();
                }
            }
            return 0;
        } else if (i != 3) {
            return -1;
        } else {
            e.a.a.a.a aVar3 = (e.a.a.a.a) objArr[0];
            log_13913 log_13913 = (log_13913) objArr[1];
            switch (((Integer) objArr[2]).intValue()) {
                case 1:
                    log_13913.import_ds_ = aVar3.AEQ.rz();
                    return 0;
                case 2:
                    log_13913.ds_ = aVar3.AEQ.rz();
                    return 0;
                case 3:
                    log_13913.uin_ = aVar3.AEQ.rA();
                    return 0;
                case 4:
                    log_13913.device_ = aVar3.AEQ.rz();
                    return 0;
                case 5:
                    log_13913.clientVersion_ = aVar3.AEQ.rz();
                    return 0;
                case 6:
                    log_13913.time_stamp_ = aVar3.AEQ.rA();
                    return 0;
                case 7:
                    log_13913.scene_ = aVar3.AEQ.rz();
                    return 0;
                case 8:
                    log_13913.error_ = aVar3.AEQ.readString();
                    return 0;
                default:
                    return -1;
            }
        }
    }
}
