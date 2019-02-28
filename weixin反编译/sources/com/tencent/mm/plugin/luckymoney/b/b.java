package com.tencent.mm.plugin.luckymoney.b;

import android.text.TextUtils;
import com.tencent.mm.f.a.ai;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w.a;
import java.io.File;
import java.util.ArrayList;

public final class b extends c<ai> {
    private ArrayList<String> ohd;

    public b() {
        this.ohd = new ArrayList();
        this.xmG = ai.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
        ai aiVar = (ai) bVar;
        if (!g.Do().CF()) {
            x.e("MicroMsg.LuckyMoneyC2CNYPredownloadImgListener", "ljd:callback() acc not ready!");
        } else if (aiVar instanceof ai) {
            x.i("MicroMsg.LuckyMoneyC2CNYPredownloadImgListener", "ljd:callback() receive C2CNYPredownloadImgEvent event!");
            g.Dr();
            int intValue = ((Integer) g.Dq().Db().get(a.USERINFO_NEWYEAR_HONGBAO_IMAGE_PRESTRAIN_FLAG_INT_SYNC, Integer.valueOf(1))).intValue();
            x.i("MicroMsg.LuckyMoneyC2CNYPredownloadImgListener", "prestrainFlag:" + intValue);
            if (intValue == 0) {
                x.e("MicroMsg.LuckyMoneyC2CNYPredownloadImgListener", "ljd:prestrainFlag is 0, do nothing!");
            } else {
                String str = aiVar.fpj.fpk;
                String str2 = aiVar.fpj.fpl;
                int i = aiVar.fpj.fpm;
                if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || i <= 0) {
                    x.e("MicroMsg.LuckyMoneyC2CNYPredownloadImgListener", "ljd:c2c new year msg image param is invalid!");
                } else if (!ao.isWifi(ad.getContext())) {
                    x.e("MicroMsg.LuckyMoneyC2CNYPredownloadImgListener", "ljd:is not wifi network, do nothing!");
                } else if (this.ohd.contains(str)) {
                    x.e("MicroMsg.LuckyMoneyC2CNYPredownloadImgListener", "ljd:imageid is exist!, do nothing!  imageid:" + str);
                } else {
                    String str3 = n.EC(str) + ".temp";
                    if (new File(str3).exists()) {
                        x.i("MicroMsg.LuckyMoneyC2CNYPredownloadImgListener", "ljd:imagePath file is exist! not download it!");
                    } else {
                        x.i("MicroMsg.LuckyMoneyC2CNYPredownloadImgListener", "ljd:callback() imagePath:" + str3 + " is not exist!");
                        this.ohd.add(str);
                        new j().a(str, str2, i, str3, new j.a() {
                            public final void a(keep_SceneResult keep_sceneresult, String str, boolean z) {
                                if (z) {
                                    x.i("MicroMsg.LuckyMoneyC2CNYPredownloadImgListener", "the download image data is success! filePath:" + str);
                                } else {
                                    x.e("MicroMsg.LuckyMoneyC2CNYPredownloadImgListener", "download image fail!  filePath:" + str);
                                }
                            }
                        });
                    }
                }
            }
        }
        return false;
    }
}
