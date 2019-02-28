package com.tencent.mm.ui.chatting;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Looper;
import com.tencent.mm.ap.o;
import com.tencent.mm.f.a.ob;
import com.tencent.mm.f.b.cg;
import com.tencent.mm.modelcdntran.d;
import com.tencent.mm.modelcdntran.g;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.chatting.gallery.ImageGalleryUI;
import com.tencent.mm.ui.chatting.gallery.b;
import com.tencent.mm.y.as;
import com.tencent.mm.y.bb;
import org.xwalk.core.R;

public final class ag extends c<ob> {
    Activity activity = null;
    private a yGc = null;

    public enum a {
        CHATTING_ITEM_VIDEO,
        IMAGE_GALLERY_UI,
        VIDEO_GALLERY
    }

    public ag(a aVar, Activity activity) {
        super(0);
        this.yGc = aVar;
        this.activity = activity;
        this.xmG = ob.class.getName().hashCode();
    }

    private boolean a(ob obVar) {
        int i = 1;
        if (!(this.yGc == null || obVar == null || !(obVar instanceof ob))) {
            cg cgVar;
            long j = obVar.fGN.frh;
            String str = obVar.fGN.fGO;
            cg cgVar2 = obVar.fGN.fGP;
            if (cgVar2 == null || cgVar2.field_msgId <= 0) {
                cgVar = obVar.fGN.fGP;
            } else {
                cgVar = cgVar2;
            }
            if (cgVar != null) {
                switch (cgVar.getType()) {
                    case 3:
                        switch (this.yGc) {
                            case IMAGE_GALLERY_UI:
                                if (cgVar != null && cgVar.field_msgId > 0) {
                                    try {
                                        g.MP().kL(d.a("downimg", cgVar.field_createTime, cgVar.field_talker, cgVar.field_msgId));
                                        x.i("MicroMsg.RevokeMsgListener", "[oneliang][revokeMsgImage] cancel result:%s", Boolean.valueOf(true));
                                        as.CN().cancel(109);
                                        o.PD().m(com.tencent.mm.ui.chatting.gallery.d.bl(cgVar).hBA, j);
                                    } catch (Throwable e) {
                                        x.printErrStackTrace("MicroMsg.RevokeMsgListener", e, "[oneliang][revokeMsgImage] cancel failure:%s", e.getMessage());
                                    }
                                }
                                if (this.activity != null && (this.activity instanceof ImageGalleryUI)) {
                                    x.i("MicroMsg.RevokeMsgListener", "[oneliang][revokeMsgImage] image gallery ui,msg id is:%s,downloadingImageMsgId: %s", Long.valueOf(j), Long.valueOf(((ImageGalleryUI) this.activity).frh));
                                    if (j == ((ImageGalleryUI) this.activity).frh) {
                                        h.a(this.activity, str, "", false, new OnClickListener() {
                                            public final void onClick(DialogInterface dialogInterface, int i) {
                                                dialogInterface.dismiss();
                                                ag.this.activity.finish();
                                            }
                                        });
                                        break;
                                    }
                                }
                                break;
                        }
                        break;
                    case R.styleable.AppCompatTheme_dialogPreferredPadding /*43*/:
                    case 62:
                        String str2 = "MicroMsg.RevokeMsgListener";
                        String str3 = "ashutest::revoke msg, type %s, isWorkerThread %B";
                        Object[] objArr = new Object[2];
                        objArr[0] = this.yGc;
                        objArr[1] = Boolean.valueOf(Looper.myLooper() == as.Dt().oFY.getLooper());
                        x.v(str2, str3, objArr);
                        switch (this.yGc) {
                            case VIDEO_GALLERY:
                                aL(cgVar);
                                if (this.activity instanceof ImageGalleryUI) {
                                    ImageGalleryUI imageGalleryUI = (ImageGalleryUI) this.activity;
                                    if (!(imageGalleryUI.yLG != null && b.aX(cgVar) && cgVar.field_msgId == imageGalleryUI.yLG.cvm().field_msgId)) {
                                        i = 0;
                                    }
                                    if (i != 0) {
                                        imageGalleryUI.Gw(imageGalleryUI.cvH());
                                        h.a(this.activity, str, "", false, new OnClickListener() {
                                            public final void onClick(DialogInterface dialogInterface, int i) {
                                                dialogInterface.dismiss();
                                                ag.this.activity.finish();
                                            }
                                        });
                                        break;
                                    }
                                }
                                break;
                            case CHATTING_ITEM_VIDEO:
                                aL(cgVar);
                                break;
                        }
                        break;
                }
            }
            x.e("MicroMsg.RevokeMsgListener", "in callback msgInfo null");
        }
        return false;
    }

    private static void aL(au auVar) {
        r nJ = t.nJ(auVar.field_imgPath);
        if (nJ != null) {
            try {
                g.MP().kL(d.a("downvideo", nJ.hXs, nJ.Uk(), nJ.getFileName()));
                x.i("MicroMsg.RevokeMsgListener", "ashutest::[oneliang][revokeMsgVideo] cancel result:%s", Boolean.valueOf(true));
                com.tencent.mm.modelvideo.x.a Ug = com.tencent.mm.modelvideo.o.Ug();
                com.tencent.mm.kernel.g.CN().c(Ug.hYf);
                Ug.vC();
                bb.j(auVar);
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.RevokeMsgListener", e, "[oneliang][revokeMsgVideo] chatting item video,cancel failure:%s", e.getMessage());
            }
        }
    }
}
