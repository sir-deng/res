package com.tencent.mm.plugin.facedetect.model;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.f.a.np;
import com.tencent.mm.plugin.facedetect.ui.SettingsFacePrintManagerUI;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

public final class n extends c<np> {
    public n() {
        this.xmG = np.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        boolean z = false;
        np npVar = (np) bVar;
        if (npVar == null) {
            x.e("MicroMsg.FaceStartManageListener", "hy: event is null");
            return false;
        }
        Context context = npVar.fGz.context;
        np.b bVar2 = npVar.fGA;
        f fVar = f.mlS;
        x.i("MicroMsg.FaceDetectManager", "hy: start face manage process");
        if (context == null) {
            x.e("MicroMsg.FaceDetectManager", "hy: context is null. abort");
        } else if (fVar.eX(true)) {
            context.startActivity(new Intent(context, SettingsFacePrintManagerUI.class));
            z = true;
        } else {
            x.w("MicroMsg.FaceDetectManager", "hy: not support face detect. abort");
        }
        bVar2.fGy = z;
        return true;
    }
}
