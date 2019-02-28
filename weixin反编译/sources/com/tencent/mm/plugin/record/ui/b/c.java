package com.tencent.mm.plugin.record.ui.b;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.mm.R;
import com.tencent.mm.bl.d;
import com.tencent.mm.f.a.fw;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.GameJsApiLaunchApplication;
import com.tencent.mm.plugin.record.a.f;
import com.tencent.mm.plugin.record.b.h;
import com.tencent.mm.plugin.record.b.n;
import com.tencent.mm.plugin.record.ui.RecordMsgFileUI;
import com.tencent.mm.plugin.record.ui.h.b;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import java.util.HashMap;
import java.util.Map;

public final class c implements b {
    public static Map<String, View> pMz = new HashMap();
    private OnClickListener myR = new OnClickListener() {
        public final void onClick(View view) {
            com.tencent.mm.plugin.record.ui.a.b bVar = (com.tencent.mm.plugin.record.ui.a.b) view.getTag();
            Intent intent;
            if (bVar.bjS == 0) {
                if (h.d(bVar.fvZ, bVar.frh)) {
                    x.i("MicroMsg.SightViewWrapper", "onclick: play sight");
                    intent = new Intent(view.getContext(), RecordMsgFileUI.class);
                    intent.putExtra("message_id", bVar.frh);
                    intent.putExtra("record_xml", bVar.fFB);
                    intent.putExtra("record_data_id", bVar.fvZ.mBr);
                    view.getContext().startActivity(intent);
                    return;
                }
                f IO = n.getRecordMsgCDNStorage().IO(h.d(bVar.fvZ.mBr, bVar.frh, true));
                String str = "MicroMsg.SightViewWrapper";
                String str2 = "onclick: cdnInfo status %s";
                Object[] objArr = new Object[1];
                objArr[0] = IO == null ? "null" : Integer.valueOf(IO.field_status);
                x.i(str, str2, objArr);
                if (!(IO == null || 2 == IO.field_status || 3 == IO.field_status)) {
                    if (4 == IO.field_status) {
                        com.tencent.mm.ui.base.h.bu(view.getContext(), view.getResources().getString(R.l.egC));
                        return;
                    } else if (IO.field_status == 0 || 1 == IO.field_status) {
                        return;
                    }
                }
                h.a(bVar.fvZ, bVar.frh, true);
            } else if (bVar.bjS == 1) {
                com.tencent.mm.sdk.b.b fwVar;
                x.i("MicroMsg.SightViewWrapper", "click item favid %d, localid %d, itemstatus %d", Integer.valueOf(bVar.pLp.field_id), Long.valueOf(bVar.pLp.field_localId), Integer.valueOf(bVar.pLp.field_itemStatus));
                if (bVar.pLp.isDone()) {
                    fwVar = new fw();
                    fwVar.fwl.type = 14;
                    fwVar.fwl.fwn = bVar.fvZ;
                    a.xmy.m(fwVar);
                    x.i("MicroMsg.SightViewWrapper", "favItemInfo is Done,file exist ret = %d", Integer.valueOf(fwVar.fwm.ret));
                    if (fwVar.fwm.ret == 1) {
                        intent = new Intent();
                        intent.putExtra("key_detail_info_id", bVar.pLp.field_localId);
                        intent.putExtra("key_detail_data_id", bVar.fvZ.mBr);
                        intent.putExtra("key_detail_can_delete", false);
                        d.b(view.getContext(), "favorite", ".ui.detail.FavoriteFileDetailUI", intent, 1);
                        return;
                    } else if (bi.oN(bVar.fvZ.wjN)) {
                        x.w("MicroMsg.SightViewWrapper", "favItemInfo getCdnDataUrl empty");
                        return;
                    } else {
                        x.w("MicroMsg.SightViewWrapper", "? info is done, source file not exist, cdn data url is not null");
                    }
                } else if (bVar.pLp.aIu() || bVar.pLp.aIt()) {
                    x.i("MicroMsg.SightViewWrapper", "favItemInfo isDownLoadFaied or isUploadFailed, wait download");
                } else if (bVar.pLp.isDownloading() || bVar.pLp.aIs()) {
                    x.i("MicroMsg.SightViewWrapper", "favItemInfo isDownloading or isUploadding, wait download");
                    return;
                } else {
                    x.w("MicroMsg.SightViewWrapper", "other status, not done, downloading, uploading, downloadfail, uploadfail");
                }
                fwVar = new fw();
                fwVar.fwl.frf = bVar.pLp.field_localId;
                if (bVar.pLp.aIt()) {
                    x.w("MicroMsg.SightViewWrapper", "upload failed, try to restart...");
                    fwVar.fwl.type = 15;
                    a.xmy.m(fwVar);
                    return;
                }
                x.w("MicroMsg.SightViewWrapper", "download failed, try to restart...");
                fwVar.fwl.type = 16;
                a.xmy.m(fwVar);
            }
        }
    };
    private com.tencent.mm.plugin.record.ui.h.a pLK;

    public c(com.tencent.mm.plugin.record.ui.h.a aVar) {
        this.pLK = aVar;
    }

    public final View dq(Context context) {
        View inflate = View.inflate(context, R.i.dqF, null);
        ((com.tencent.mm.plugin.sight.decode.a.a) inflate.findViewById(R.h.image)).wB(com.tencent.mm.bu.a.fromDPToPix(context, GameJsApiLaunchApplication.CTRL_BYTE));
        return inflate;
    }

    public final void a(View view, int i, com.tencent.mm.plugin.record.ui.a.b bVar) {
        view.setTag(bVar);
        view.setOnClickListener(this.myR);
        com.tencent.mm.plugin.sight.decode.a.a aVar = (com.tencent.mm.plugin.sight.decode.a.a) view.findViewById(R.h.image);
        ImageView imageView = (ImageView) view.findViewById(R.h.cPs);
        MMPinProgressBtn mMPinProgressBtn = (MMPinProgressBtn) view.findViewById(R.h.progress);
        aVar.cR(i);
        com.tencent.mm.plugin.record.ui.a.c cVar = (com.tencent.mm.plugin.record.ui.a.c) bVar;
        com.tencent.mm.plugin.record.ui.h.a aVar2 = this.pLK;
        Map map = pMz;
        com.tencent.mm.plugin.record.ui.h.a.c cVar2 = new com.tencent.mm.plugin.record.ui.h.a.c();
        cVar2.fvZ = cVar.fvZ;
        String c;
        if (cVar.bjS == 0) {
            cVar2.pLM = cVar.frh;
            if (h.d(cVar.fvZ, cVar.frh)) {
                imageView.setVisibility(8);
                mMPinProgressBtn.setVisibility(8);
                c = h.c(cVar.fvZ, cVar.frh);
                if (!c.equals(aVar.Uy())) {
                    aVar.B(aVar2.a(cVar2));
                }
                aVar.aA(c, false);
                return;
            }
            f IO = n.getRecordMsgCDNStorage().IO(h.d(cVar.fvZ.mBr, cVar.frh, true));
            if (IO == null || 2 == IO.field_status) {
                imageView.setImageResource(R.k.dAT);
            } else if (3 == IO.field_status || 4 == IO.field_status) {
                imageView.setImageResource(R.g.bGg);
            } else if (IO.field_status == 0 || 1 == IO.field_status) {
                imageView.setVisibility(8);
                mMPinProgressBtn.setVisibility(0);
                mMPinProgressBtn.setProgress((int) ((((float) IO.field_offset) / ((float) Math.max(1, IO.field_totalLen))) * 100.0f));
                aVar.clear();
                aVar.B(aVar2.a(cVar2));
                return;
            } else {
                imageView.setImageResource(R.k.dAT);
            }
            imageView.setVisibility(0);
            mMPinProgressBtn.setVisibility(8);
            aVar.clear();
            aVar.B(aVar2.a(cVar2));
        } else if (cVar.bjS == 1) {
            map.put(cVar.fvZ.mBr, view);
            x.d("MicroMsg.SightRecordData", "dataId %s, status %s", Long.valueOf(cVar.pLp.field_localId), Integer.valueOf(cVar.pLp.field_itemStatus));
            cVar2.pLM = cVar.pLp.field_localId;
            com.tencent.mm.sdk.b.b fwVar = new fw();
            fwVar.fwl.type = 14;
            fwVar.fwl.fwn = cVar.fvZ;
            a.xmy.m(fwVar);
            if (cVar.pLp.isDone() || fwVar.fwm.ret == 1) {
                if (fwVar.fwm.ret == 1) {
                    imageView.setVisibility(8);
                    mMPinProgressBtn.setVisibility(8);
                    fwVar.fwl.type = 2;
                    a.xmy.m(fwVar);
                    c = fwVar.fwm.path;
                    if (bi.oN(c)) {
                        x.w("MicroMsg.SightRecordData", "videoPath is null!");
                        return;
                    }
                    if (!c.equals(aVar.Uy())) {
                        aVar.B(aVar2.a(cVar2));
                    }
                    aVar.aA(c, false);
                    return;
                } else if (bi.oN(cVar.fvZ.wjN)) {
                    imageView.setImageResource(R.g.bGg);
                } else {
                    x.w("MicroMsg.SightRecordData", "? info is done, source file not exist, cdn data url is not null");
                    imageView.setImageResource(R.k.dAT);
                }
            } else if (cVar.pLp.aIu() || cVar.pLp.aIt()) {
                imageView.setImageResource(R.k.dAT);
            } else if (cVar.pLp.isDownloading()) {
                imageView.setVisibility(8);
                mMPinProgressBtn.setVisibility(0);
                mMPinProgressBtn.czF();
                aVar.clear();
                aVar.B(aVar2.a(cVar2));
                return;
            } else {
                x.w("MicroMsg.SightRecordData", "other status, not done, downloading, uploading, downloadfail, uploadfail");
                imageView.setImageResource(R.k.dAT);
            }
            imageView.setVisibility(0);
            mMPinProgressBtn.setVisibility(8);
            aVar.clear();
            aVar.B(aVar2.a(cVar2));
        }
    }

    public final void destroy() {
        this.pLK = null;
    }

    public final void pause() {
    }
}
