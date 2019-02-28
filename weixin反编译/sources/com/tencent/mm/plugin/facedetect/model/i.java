package com.tencent.mm.plugin.facedetect.model;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.f.a.no;
import com.tencent.mm.plugin.facedetect.ui.FaceDetectConfirmUI;
import com.tencent.mm.plugin.facedetect.ui.FaceDetectPrepareUI;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

public final class i extends c<no> {
    public i() {
        this.xmG = no.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        no noVar = (no) bVar;
        if (noVar == null) {
            return false;
        }
        boolean z;
        no.b bVar2 = noVar.fGw;
        f fVar = f.mlS;
        Context context = noVar.fGv.context;
        Bundle bundle = noVar.fGv.extras;
        int i = noVar.fGv.fGx;
        x.i("MicroMsg.FaceDetectManager", "start face detect process");
        FaceDetectReporter.aHr().aHs();
        FaceDetectReporter aHr = FaceDetectReporter.aHr();
        x.v("MicroMsg.FaceDetectReporter", "create interface called session");
        aHr.mmE = System.currentTimeMillis();
        aHr.mmH = 0;
        aHr.mmI = false;
        aHr.mmF = -1;
        aHr.mmG = -1;
        long j = aHr.mmE;
        FaceDetectReporter.aHr().mmF = System.currentTimeMillis();
        if (context == null) {
            z = false;
        } else if (bundle != null) {
            int i2 = bundle.getInt("k_server_scene", 2);
            FaceDetectReporter.aHr().appId = bundle.getString("k_app_id", "");
            if (fVar.eX(bundle.getBoolean("is_check_dyncfg", false))) {
                Intent intent = (i2 == 2 || i2 == 5) ? new Intent(context, FaceDetectConfirmUI.class) : new Intent(context, FaceDetectPrepareUI.class);
                intent.putExtras(bundle);
                ((Activity) context).startActivityForResult(intent, i);
                z = true;
            } else {
                x.w("MicroMsg.FaceDetectManager", "alvinluo: not support face detect");
                FaceDetectReporter aHr2 = FaceDetectReporter.aHr();
                aHr2.D(FaceDetectReporter.pN(i2), false);
                aHr2.a(FaceDetectReporter.pN(i2), false, 3, 4, 90001);
                z = false;
            }
        } else {
            x.e("MicroMsg.FaceDetectManager", "hy: extras is null! should not happen");
            z = false;
        }
        bVar2.fGy = z;
        if (!noVar.fGw.fGy) {
            noVar.fGw.extras = new Bundle();
            noVar.fGw.extras.putInt("err_code", 90001);
            noVar.fGw.extras.putString("err_msg", "face detect not support");
        }
        return true;
    }
}
