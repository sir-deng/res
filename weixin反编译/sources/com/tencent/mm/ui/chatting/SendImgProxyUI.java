package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.a.e;
import com.tencent.mm.ap.n;
import com.tencent.mm.ap.o;
import com.tencent.mm.hardcoder.HardCoderJNI;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.ae;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.r;
import com.tencent.mm.y.as;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SendImgProxyUI extends MMBaseActivity {
    private static boolean bgH = false;
    private r jQQ = null;

    static /* synthetic */ void a(SendImgProxyUI sendImgProxyUI, Intent intent) {
        if (intent == null) {
            x.e("MicroMsg.SendImgProxyUI", "data is empty!");
            return;
        }
        boolean booleanExtra = intent.getBooleanExtra("CropImage_Compress_Img", true);
        intent.getStringExtra("GalleryUI_ToUser");
        ArrayList arrayList = new ArrayList();
        ArrayList a = a(intent.getStringArrayListExtra("CropImage_OutputPath_List"), intent.getIntExtra("CropImage_limit_Img_Size", 26214400), arrayList, booleanExtra);
        intent.putStringArrayListExtra("CropImage_OutputPath_List", a);
        List stringArrayListExtra = intent.getStringArrayListExtra("key_select_video_list");
        if (a.size() == 0 && arrayList.size() == 0 && (stringArrayListExtra == null || stringArrayListExtra.size() == 0)) {
            Toast.makeText(sendImgProxyUI, sendImgProxyUI.getString(R.l.elo), 0).show();
            x.e("MicroMsg.SendImgProxyUI", "filelist is empty!");
            return;
        }
        int intExtra = intent.getIntExtra("from_source", 0);
        int intExtra2 = intent.getIntExtra("CropImage_rotateCount", 0);
        String stringExtra = intent.getStringExtra("GalleryUI_ToUser");
        x.d("MicroMsg.SendImgProxyUI", "toUserName : " + stringExtra);
        x.d("MicroMsg.SendImgProxyUI", "dkimgsource" + intent.getIntExtra("from_source", 0));
        if (arrayList.size() > 0) {
            n.Pt().a(arrayList, true, intExtra, intExtra2, stringExtra, R.g.bAI);
            e(n.Pt().ls(stringExtra), arrayList);
            x.e("MicroMsg.SendImgProxyUI", "overSizeList size:%s!", Integer.valueOf(arrayList.size()));
        }
        n.Pt().a(a, booleanExtra, intExtra, intExtra2, stringExtra, R.g.bAI);
    }

    public void onCreate(Bundle bundle) {
        int i = 0;
        super.onCreate(bundle);
        overridePendingTransition(0, 0);
        ae.a(getWindow());
        x.i("MicroMsg.SendImgProxyUI", "onCreate isRunning:%b ,%d", Boolean.valueOf(bgH), Integer.valueOf(hashCode()));
        if (bgH) {
            x.w("MicroMsg.SendImgProxyUI", "duplicate instance");
            finish();
            return;
        }
        bgH = true;
        setContentView(R.i.daS);
        this.jQQ = h.a((Context) this, getString(R.l.euN), false, null);
        final boolean isWifi = ao.isWifi((Context) this);
        boolean z = HardCoderJNI.hcSendPicMsgEnable;
        int i2 = HardCoderJNI.hcSendPicMsgDelay;
        int i3 = HardCoderJNI.hcSendPicMsgCPU;
        int i4 = HardCoderJNI.hcSendPicMsgIO;
        if (HardCoderJNI.hcSendPicMsgThr) {
            i = g.Dt().cgq();
        }
        final int startPerformance = HardCoderJNI.startPerformance(z, i2, i3, i4, i, HardCoderJNI.hcSendPicMsgTimeout, 203, HardCoderJNI.hcSendPicMsgAction, "MicroMsg.SendImgProxyUI");
        as.Dt().F(new Runnable() {
            public final void run() {
                x.i("MicroMsg.SendImgProxyUI", "test before sendMutiImage");
                SendImgProxyUI.a(SendImgProxyUI.this, SendImgProxyUI.this.getIntent());
                ArrayList arrayList = new ArrayList();
                arrayList.add(Integer.valueOf(-1));
                as.Dt().cgr();
                x.i("MicroMsg.SendImgProxyUI", "test before finish");
                SendImgProxyUI.this.jQQ.dismiss();
                SendImgProxyUI.this.setResult(-1, SendImgProxyUI.this.getIntent().putIntegerArrayListExtra("GalleryUI_ImgIdList", arrayList));
                SendImgProxyUI.bgH = false;
                SendImgProxyUI.this.finish();
                if (ao.isWifi(SendImgProxyUI.this) == isWifi) {
                    HardCoderJNI.stopPerformace(HardCoderJNI.hcSendPicMsgEnable, startPerformance);
                }
            }
        });
    }

    protected void onDestroy() {
        x.i("MicroMsg.SendImgProxyUI", "onDestroy isRunning:%b , %d", Boolean.valueOf(bgH), Integer.valueOf(hashCode()));
        super.onDestroy();
    }

    public void onResume() {
        x.i("MicroMsg.SendImgProxyUI", "onResume isRunning:%b ,%d", Boolean.valueOf(bgH), Integer.valueOf(hashCode()));
        super.onResume();
    }

    private static ArrayList<String> a(ArrayList<String> arrayList, int i, ArrayList<String> arrayList2, boolean z) {
        InputStream inputStream;
        ArrayList<String> arrayList3 = new ArrayList();
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                if (str.toLowerCase().endsWith(".png")) {
                    InputStream inputStream2 = null;
                    try {
                        inputStream2 = FileOp.openRead(str);
                        try {
                            if (MMBitmapFactory.checkIsImageLegal(inputStream2)) {
                                int bN = e.bN(str);
                                if (z || bN <= i) {
                                    arrayList3.add(str);
                                } else {
                                    arrayList2.add(str);
                                }
                            }
                            if (inputStream2 != null) {
                                try {
                                    inputStream2.close();
                                } catch (Exception e) {
                                }
                            }
                        } catch (Exception e2) {
                            inputStream = inputStream2;
                        } catch (Throwable th) {
                            if (inputStream2 != null) {
                                try {
                                    inputStream2.close();
                                } catch (Exception e3) {
                                }
                            }
                        }
                    } catch (Exception e4) {
                        inputStream = inputStream2;
                    } catch (Throwable th2) {
                        if (inputStream2 != null) {
                            try {
                                inputStream2.close();
                            } catch (Exception e32) {
                            }
                        }
                    }
                } else {
                    int bN2 = e.bN(str);
                    if (z || bN2 <= i) {
                        arrayList3.add(str);
                    } else {
                        arrayList2.add(str);
                    }
                }
            }
        }
        return arrayList3;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (Exception e5) {
            }
        }
    }

    private static void e(ArrayList<Integer> arrayList, ArrayList<String> arrayList2) {
        if (arrayList.size() != arrayList2.size()) {
            x.e("MicroMsg.SendImgProxyUI", "[insertErrMsg] WTF");
            return;
        }
        for (int i = 0; i < arrayList2.size(); i++) {
            int intValue = ((Integer) arrayList.get(i)).intValue();
            com.tencent.mm.ap.e hT = o.PC().hT(intValue);
            int bN = e.bN((String) arrayList2.get(i));
            hT.setOffset(bN);
            hT.hO(bN);
            o.PC().a(intValue, hT);
            long j = hT.hBI;
            x.i("MicroMsg.SendImgProxyUI", "[insertErrMsg] msgLocalId:%s oriImgLocalId:%s", Long.valueOf(j), Integer.valueOf(intValue));
            au dI = ((com.tencent.mm.plugin.messenger.foundation.a.h) g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aZO().dI(j);
            dI.eR(5);
            dI.fc(80);
            ((com.tencent.mm.plugin.messenger.foundation.a.h) g.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).aZO().a(j, dI);
            x.i("MicroMsg.SendImgProxyUI", "after update msgInfo, localId[%d] svrId[%d] talker[%s] type[%d] isSend[%d] imgPath[%s], status[%d] createTime[%d]", Long.valueOf(dI.field_msgId), Long.valueOf(dI.field_msgSvrId), dI.field_talker, Integer.valueOf(dI.getType()), Integer.valueOf(dI.field_isSend), dI.field_imgPath, Integer.valueOf(dI.field_status), Long.valueOf(dI.field_createTime));
        }
    }
}
