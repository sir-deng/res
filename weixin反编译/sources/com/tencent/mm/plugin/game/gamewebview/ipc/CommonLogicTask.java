package com.tencent.mm.plugin.game.gamewebview.ipc;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.f.a.cg;
import com.tencent.mm.f.a.go;
import com.tencent.mm.j.g;
import com.tencent.mm.plugin.game.c.dw;
import com.tencent.mm.plugin.game.model.i;
import com.tencent.mm.plugin.webview.model.ai;
import com.tencent.mm.plugin.webview.modeltools.f;
import com.tencent.mm.plugin.webview.ui.tools.game.GameSettingParams;
import com.tencent.mm.pluginsdk.q.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;
import java.util.ArrayList;

public class CommonLogicTask extends GWMainProcessTask {
    public static final Creator<CommonLogicTask> CREATOR = new Creator<CommonLogicTask>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new CommonLogicTask(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new CommonLogicTask[i];
        }
    };
    public Bundle mym = new Bundle();
    public Runnable nby;
    public int type;

    public final void YB() {
        if (this.nby != null) {
            this.nby.run();
        }
    }

    public final void YA() {
        int i = 0;
        boolean z = true;
        int oC;
        Bundle bundle;
        String str;
        switch (this.type) {
            case 1:
                if (this.mym != null) {
                    z = this.mym.getBoolean("permission_allow", false);
                    String string = this.mym.getString(SlookSmartClipMetaTag.TAG_TYPE_URL);
                    if (!bi.oN(string)) {
                        a.vjg.a(ad.getContext(), string, z);
                        break;
                    } else {
                        x.e("MicroMsg.ComonLogicTask", "ACTIVITY_JUMP_HANDLER, url is null");
                        return;
                    }
                }
                break;
            case 2:
                if (this.mym != null) {
                    int[] intArray = this.mym.getIntArray("getConfigStgKey");
                    if (intArray != null && intArray.length != 0) {
                        ArrayList arrayList = new ArrayList();
                        int length = intArray.length;
                        while (i < length) {
                            int i2 = intArray[i];
                            as.Hm();
                            arrayList.add(bi.oM((String) c.Db().get(i2, null)));
                            i++;
                        }
                        this.mym.putStringArrayList("getConfigStgValue", arrayList);
                        break;
                    }
                    return;
                }
                break;
            case 3:
                if (this.mym != null) {
                    Parcelable OS = f.bSo().OS(this.mym.getString("localId"));
                    if (OS != null) {
                        this.mym.putParcelable("item", OS);
                        break;
                    }
                }
                break;
            case 4:
                oC = oC("WebViewDownLoadFileSwitch");
                if (this.mym == null) {
                    this.mym = new Bundle();
                }
                bundle = this.mym;
                str = "allowDownloadFile";
                if (oC != 1) {
                    z = false;
                }
                bundle.putBoolean(str, z);
                break;
            case 5:
                oC = oC("EnableWebviewScanQRCode");
                bundle = this.mym;
                str = "allow_webview_scan";
                if (oC != 1) {
                    z = false;
                }
                bundle.putBoolean(str, z);
                break;
            case 6:
                this.mym.putBoolean("has_set_uin", as.Hp());
                break;
            case 7:
                cg cgVar = new cg();
                com.tencent.mm.pluginsdk.model.f.a(cgVar, 1, this.mym.getString("image_path", ""));
                com.tencent.mm.sdk.b.a.xmy.m(cgVar);
                this.mym.putInt("fav_simple_img_result", cgVar.frl.ret);
                break;
            case 8:
                this.mym.putString("file_path", ai.OW(this.mym.getString("localId")));
                break;
            case 9:
                String string2 = this.mym.getString("game_hv_menu_appid");
                b goVar = new go();
                goVar.fxy.pK = 3;
                goVar.fxy.fxA = string2;
                com.tencent.mm.sdk.b.a.xmy.m(goVar);
                this.mym.putString("game_hv_menu_pbcache", goVar.fxz.result);
                break;
            case 10:
                dw aQK = i.aQI().aQK();
                if (aQK != null) {
                    Parcelable gameSettingParams = new GameSettingParams();
                    gameSettingParams.fyv = aQK.hdx;
                    gameSettingParams.fyw = aQK.njP;
                    this.mym.putParcelable("game_setting_params", gameSettingParams);
                    break;
                }
                break;
            case 11:
                com.tencent.mm.plugin.webview.ui.tools.game.c.Y(this.mym);
                break;
        }
        afF();
    }

    private static int oC(String str) {
        int i = 1;
        try {
            return bi.getInt(g.Af().getValue(str), 1);
        } catch (Exception e) {
            x.e("MicroMsg.ComonLogicTask", "getIntValFromDynamicConfig parseInt failed, val: " + str);
            return i;
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.type);
        parcel.writeBundle(this.mym);
    }

    public final void f(Parcel parcel) {
        this.type = parcel.readInt();
        this.mym = parcel.readBundle(getClass().getClassLoader());
    }

    CommonLogicTask(Parcel parcel) {
        f(parcel);
    }
}
