package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsns.b;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.model.at;
import com.tencent.mm.plugin.sns.storage.h;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.protocal.c.are;
import com.tencent.mm.protocal.c.bpb;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class ao {
    private Activity fBA;
    private List<are> list = new ArrayList();

    public ao(Activity activity) {
        this.fBA = activity;
    }

    public final void a(View view, int i, at atVar) {
        if (view == null) {
            x.e("MicroMsg.SnsImageDialogShowerMgr", "[showImg] view is null! scene:%s", Integer.valueOf(i));
            return;
        }
        Object tag = view.getTag();
        if (tag instanceof ap) {
            ap apVar = (ap) tag;
            String str = apVar.fvn;
            int i2 = apVar.index;
            int i3 = apVar.position;
            if (cm(str, i2)) {
                g.Dr();
                if (g.Dq().isSDCardAvailable()) {
                    m LR = h.LR(str);
                    if (cm(str, i2)) {
                        Intent intent = new Intent();
                        if (LR != null) {
                            b ix;
                            if (atVar != null) {
                                atVar.rcW.v(LR);
                            }
                            bpb byF = LR.byF();
                            are are = apVar.index < byF.wYj.wfh.size() ? (are) byF.wYj.wfh.get(apVar.index) : new are();
                            if (i == 1) {
                                ix = b.ix(716);
                            } else {
                                ix = b.iy(716);
                            }
                            ix.mF(i.g(LR)).iA(LR.field_type).bW(LR.xD(32)).mF(LR.bzk()).mF(are.nMq).iA(apVar.index).iA(byF.wYj.wfh.size());
                            ix.SE();
                            if (i == 1) {
                                ix = b.ix(744);
                            } else {
                                ix = b.iy(744);
                            }
                            ix.mF(i.g(LR)).iA(LR.field_type).bW(LR.xD(32)).mF(LR.bzk());
                            ix.b(intent, "intent_key_StatisticsOplog");
                            Bundle bundle = new Bundle();
                            bundle.putInt("stat_scene", 3);
                            bundle.putString("stat_msg_id", "sns_" + i.er(LR.field_snsId));
                            bundle.putString("stat_send_msg_user", LR.field_userName);
                            intent.putExtra("_stat_obj", bundle);
                        } else {
                            x.e("MicroMsg.SnsImageDialogShowerMgr", "[showImg] info is null!");
                        }
                        int[] iArr = new int[2];
                        view.getLocationInWindow(iArr);
                        int width = view.getWidth();
                        int height = view.getHeight();
                        if (i == -1) {
                            intent.putExtra("k_is_from_sns_msg_ui", true);
                        }
                        intent.putExtra("sns_gallery_localId", str);
                        intent.putExtra("sns_gallery_position", i2);
                        intent.putExtra("sns_position", i3);
                        intent.putExtra("sns_gallery_showtype", 1);
                        intent.putExtra("K_ad_scene", i);
                        intent.putExtra("k_is_from_sns_main_timeline", apVar.rFe);
                        intent.putExtra("img_gallery_left", iArr[0]);
                        intent.putExtra("img_gallery_top", iArr[1]);
                        intent.putExtra("img_gallery_width", width);
                        intent.putExtra("img_gallery_height", height);
                        intent.setClass(this.fBA, SnsBrowseUI.class);
                        this.fBA.startActivity(intent);
                        this.fBA.overridePendingTransition(0, 0);
                        return;
                    }
                    x.e("MicroMsg.SnsImageDialogShowerMgr", "[showImg] initDataMediaList, localId:%s position:%s", str, Integer.valueOf(i2));
                    return;
                }
                x.e("MicroMsg.SnsImageDialogShowerMgr", "[showImg] isSDCardAvailable:false");
                return;
            }
            x.e("MicroMsg.SnsImageDialogShowerMgr", "[showImg] initDataMediaList, localId:%s position:%s", str, Integer.valueOf(i2));
        }
    }

    private boolean cm(String str, int i) {
        m LR = h.LR(str);
        if (LR == null) {
            x.e("MicroMsg.SnsImageDialogShowerMgr", "[initDataMediaList] snsinfo is null! localId:%s index:%ss", str, Integer.valueOf(i));
            return false;
        }
        bpb byF = LR.byF();
        if (byF.wYj == null) {
            x.e("MicroMsg.SnsImageDialogShowerMgr", "[initDataMediaList] timeline.ContentObj is null!");
            return false;
        } else if (byF.wYj.wfh.size() == 0) {
            x.e("MicroMsg.SnsImageDialogShowerMgr", "[initDataMediaList] timeline.ContentObj.MediaObjList.size() == 0");
            return false;
        } else {
            this.list.clear();
            Iterator it = byF.wYj.wfh.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                are are = (are) it.next();
                this.list.add(are);
                if (i != i2 || ae.bwc().B(are)) {
                    i2++;
                } else {
                    x.e("MicroMsg.SnsImageDialogShowerMgr", "[initDataMediaList] is not exists");
                    return false;
                }
            }
            return true;
        }
    }
}
