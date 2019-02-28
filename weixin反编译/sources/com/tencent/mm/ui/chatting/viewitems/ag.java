package com.tencent.mm.ui.chatting.viewitems;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.BuildConfig;
import com.tencent.mm.R;
import com.tencent.mm.af.f;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.f.a.di;
import com.tencent.mm.f.a.ou;
import com.tencent.mm.f.b.cg;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.network.ab;
import com.tencent.mm.plugin.appbrand.jsapi.bc;
import com.tencent.mm.plugin.appbrand.jsapi.map.j;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.pluginsdk.model.k;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.chatting.gallery.ImageGalleryUI;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import com.tencent.mm.y.as;
import com.tencent.mm.y.s;
import com.tencent.wcdb.FileUtils;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

public final class ag {

    public static class b extends b {
        private c yWk;
        private com.tencent.mm.ui.chatting.ChattingUI.a yyH;

        private c cwq() {
            if (this.yWk == null) {
                this.yWk = new c(this.yyH);
            }
            return this.yWk;
        }

        public final boolean aXP() {
            return true;
        }

        public final boolean ak(int i, boolean z) {
            if (z && i == 43) {
                return true;
            }
            return false;
        }

        public final View a(LayoutInflater layoutInflater, View view) {
            if (view != null && view.getTag() != null) {
                return view;
            }
            view = new p(layoutInflater, R.i.dej);
            view.setTag(new d().q(view, false));
            return view;
        }

        public final void a(com.tencent.mm.ui.chatting.viewitems.b.a aVar, int i, com.tencent.mm.ui.chatting.ChattingUI.a aVar2, au auVar, String str) {
            this.yyH = aVar2;
            d dVar = (d) aVar;
            d.a(dVar, auVar, false, i, aVar2, R.g.bAI, cwq(), s(aVar2));
            if (b.cwm()) {
                r nJ = t.nJ(auVar.field_imgPath);
                if (nJ != null && nJ.status == 199 && b.a(aVar2.yAM, auVar.field_msgId)) {
                    if (dVar.yRZ != null) {
                        dVar.yRZ.setVisibility(0);
                    }
                } else if (dVar.yRZ != null) {
                    dVar.yRZ.setVisibility(8);
                }
            }
        }

        public final boolean a(ContextMenu contextMenu, View view, au auVar) {
            as.Hm();
            if (com.tencent.mm.y.c.isSDCardAvailable()) {
                if (view == null) {
                    return false;
                }
                int i = ((ar) view.getTag()).position;
                r nv = o.Ub().nv(auVar.field_imgPath);
                MenuItem add = contextMenu.add(i, 129, 0, view.getContext().getString(R.l.dRW));
                int width = view.getWidth();
                int height = view.getHeight();
                int[] iArr = new int[2];
                view.getLocationInWindow(iArr);
                Intent intent = new Intent();
                intent.putExtra("img_gallery_width", width).putExtra("img_gallery_height", height).putExtra("img_gallery_left", iArr[0]).putExtra("img_gallery_top", iArr[1]);
                add.setIntent(intent);
                if (nv != null) {
                    int i2 = nv.status;
                    if (!(104 == i2 || 103 == i2 || 105 == i2 || 106 == i2)) {
                        contextMenu.add(i, 107, 0, view.getContext().getString(R.l.eEP));
                    }
                }
                if (nv != null && (nv.status == 199 || nv.status == 199)) {
                    if (com.tencent.mm.bl.d.Pu("favorite")) {
                        contextMenu.add(i, 116, 0, view.getContext().getString(R.l.eAq));
                    }
                    com.tencent.mm.sdk.b.b diVar = new di();
                    diVar.fsL.frh = auVar.field_msgId;
                    com.tencent.mm.sdk.b.a.xmy.m(diVar);
                    if (diVar.fsM.fsk) {
                        contextMenu.add(i, FileUtils.S_IWUSR, 0, view.getContext().getString(R.l.dRX));
                    }
                    if (!auVar.cjK() && ((auVar.cjW() || auVar.cjX()) && b.a(auVar, this.yyH) && ((nv.status == 199 || nv.status == 199 || auVar.gkH == 1) && b.ZX(auVar.field_talker)))) {
                        contextMenu.add(i, 123, 0, view.getContext().getString(R.l.dSb));
                    }
                    if (f.LU() && !this.yyH.ctJ()) {
                        contextMenu.add(i, 114, 0, view.getContext().getString(R.l.dRO));
                    }
                }
                if (!this.yyH.ctJ()) {
                    contextMenu.add(i, 100, 0, view.getContext().getString(R.l.dRT));
                }
            }
            return true;
        }

        public final boolean a(MenuItem menuItem, com.tencent.mm.ui.chatting.ChattingUI.a aVar, au auVar) {
            return false;
        }

        public final boolean b(View view, com.tencent.mm.ui.chatting.ChattingUI.a aVar, au auVar) {
            cwq().onClick(view);
            return true;
        }
    }

    protected static class e extends ar {
        int kZv;

        public e(au auVar, boolean z, int i, String str) {
            super(auVar, z, i, str, (byte) 0);
        }
    }

    public static class c extends com.tencent.mm.ui.chatting.r.d {
        public static boolean yOC = false;

        public c(com.tencent.mm.ui.chatting.ChattingUI.a aVar) {
            super(aVar);
        }

        public final void a(View view, com.tencent.mm.ui.chatting.ChattingUI.a aVar, au auVar) {
            ar arVar = (ar) view.getTag();
            com.tencent.mm.modelstat.b.hRo.w(arVar.fFE);
            e eVar = (e) arVar;
            com.tencent.mm.modelstat.a.a(eVar.fFE, com.tencent.mm.modelstat.a.a.Click);
            if (2 != eVar.kZv) {
                cg cgVar = eVar.fFE;
                if (cgVar.field_isSend == 0) {
                    cg cgVar2 = eVar.fFE;
                    r nJ = t.nJ(cgVar2.field_imgPath);
                    x.i("MicroMsg.DesignerClickListener", "videoReceiverEvent video status:" + nJ.status + " is sender:" + cgVar2.field_isSend);
                    switch (eVar.kZv) {
                        case 3:
                            h(nJ);
                            break;
                        case 4:
                            as.Hm();
                            if (!com.tencent.mm.y.c.isSDCardAvailable()) {
                                u.fJ(this.yyH.getContext());
                                break;
                            } else {
                                t.nG(cgVar2.field_imgPath);
                                break;
                            }
                    }
                }
                if (cgVar.field_isSend == 1) {
                    au auVar2 = eVar.fFE;
                    if (auVar2 == null) {
                        x.w("MicroMsg.DesignerClickListener", "videoSendEvent but msg is null ");
                        return;
                    }
                    r nv = o.Ub().nv(auVar2.field_imgPath);
                    if (nv == null) {
                        x.w("MicroMsg.DesignerClickListener", "videoSendEvent but video info is null [%s]", auVar2.field_imgPath);
                        return;
                    }
                    int i = nv.status;
                    x.i("MicroMsg.DesignerClickListener", " videoSendEvent status : " + i);
                    String string;
                    switch (eVar.kZv) {
                        case 3:
                            as.Hm();
                            if (!com.tencent.mm.y.c.isSDCardAvailable()) {
                                u.fJ(this.yyH.getContext());
                                return;
                            } else if (i == 113) {
                                x.i("MicroMsg.DesignerClickListener", "this video come from pc weixin, user restart now.");
                                h(nv);
                                return;
                            } else if (nv.Uo()) {
                                x.e("MicroMsg.DesignerClickListener", "this video come from gallery, but it is illegal.");
                                string = this.yyH.getContext().getString(R.l.eTn);
                                if (i == 142) {
                                    string = this.yyH.getContext().getString(R.l.eTn);
                                } else if (i == j.CTRL_INDEX) {
                                    string = this.yyH.getContext().getString(R.l.eTo);
                                } else if (i == com.tencent.mm.plugin.appbrand.jsapi.map.b.CTRL_INDEX) {
                                    string = this.yyH.getContext().getString(R.l.eTm);
                                }
                                h.b(this.yyH.getContext(), string, this.yyH.getContext().getString(R.l.cSb), true);
                                return;
                            } else {
                                auVar2.ckj();
                                as.Hm();
                                com.tencent.mm.y.c.Fh().a(auVar2.field_msgId, auVar2);
                                if (nv.status == bc.CTRL_INDEX) {
                                    t.nI(auVar2.field_imgPath);
                                    return;
                                } else {
                                    t.nE(auVar2.field_imgPath);
                                    return;
                                }
                            }
                        case 4:
                            as.Hm();
                            if (!com.tencent.mm.y.c.isSDCardAvailable()) {
                                u.fJ(this.yyH.getContext());
                                return;
                            } else if (i == MMGIFException.D_GIF_ERR_IMAGE_DEFECT) {
                                x.i("MicroMsg.DesignerClickListener", "this video come from pc weixin, user pause recv now.");
                                t.nG(auVar2.field_imgPath);
                                return;
                            } else {
                                string = auVar2.field_imgPath;
                                nv = t.nJ(string);
                                if (nv == null) {
                                    x.e("MicroMsg.VideoLogic", "ERR:" + g.zo() + " getinfo failed: " + string);
                                    g.getLine();
                                } else if (nv.status == 104 || nv.status == 103) {
                                    nv.status = 105;
                                    nv.hXt = bi.Wx();
                                    nv.fEo = BuildConfig.VERSION_CODE;
                                    if (!t.e(nv)) {
                                        x.e("MicroMsg.VideoLogic", "ERR:" + g.zo() + " update failed: " + string);
                                        g.getLine();
                                    }
                                } else {
                                    x.e("MicroMsg.VideoLogic", "ERR:" + g.zo() + " get status failed: " + string + " status:" + nv.status);
                                    g.getLine();
                                }
                                x.d("MicroMsg.DesignerClickListener", "pause video, publish SendMsgFailEvent");
                                com.tencent.mm.sdk.b.b ouVar = new ou();
                                ouVar.fHF.fou = auVar2;
                                com.tencent.mm.sdk.b.a.xmy.m(ouVar);
                                return;
                            }
                        default:
                            return;
                    }
                }
            } else if (com.tencent.mm.o.a.aW(this.yyH.getContext()) || com.tencent.mm.o.a.aU(this.yyH.getContext())) {
                x.i("MicroMsg.DesignerClickListener", "Voip or multitalk is running, can't do this");
            } else {
                Bundle bundle;
                cg cgVar3 = eVar.fFE;
                int[] iArr = new int[2];
                int i2 = 0;
                int i3 = 0;
                if (view != null) {
                    view.getLocationInWindow(iArr);
                    i2 = view.getWidth();
                    i3 = view.getHeight();
                }
                long j = cgVar3.field_msgId;
                long j2 = cgVar3.field_msgSvrId;
                String str = eVar.userName;
                String str2 = eVar.chatroomName;
                Intent intent = new Intent(this.yyH.getContext(), ImageGalleryUI.class);
                intent.putExtra("show_search_chat_content_result", this.yyH.yEG.yAH);
                intent.putExtra("img_gallery_msg_id", j);
                intent.putExtra("key_is_biz_chat", this.yyH.yEL.vus);
                intent.putExtra("key_biz_chat_id", this.yyH.yEL.ctW());
                intent.putExtra("img_gallery_msg_svr_id", j2);
                intent.putExtra("img_gallery_talker", str);
                intent.putExtra("img_gallery_chatroom_name", str2);
                intent.putExtra("img_gallery_left", iArr[0]);
                intent.putExtra("img_gallery_top", iArr[1]);
                intent.putExtra("img_gallery_width", i2);
                intent.putExtra("img_gallery_height", i3);
                intent.putExtra("img_gallery_enter_from_chatting_ui", this.yyH.yEG.yJq);
                String csn = this.yyH.csn();
                String str3 = cgVar3.field_isSend == 1 ? this.yyH.yAM.hnt : str;
                Bundle bundle2 = new Bundle();
                if (this.yyH.yAR) {
                    str = "stat_scene";
                    i2 = 2;
                    bundle = bundle2;
                } else {
                    str = "stat_scene";
                    if (s.gI(csn)) {
                        i2 = 7;
                        bundle = bundle2;
                    } else {
                        i2 = 1;
                        bundle = bundle2;
                    }
                }
                bundle.putInt(str, i2);
                bundle2.putString("stat_msg_id", "msg_" + Long.toString(j2));
                bundle2.putString("stat_chat_talker_username", csn);
                bundle2.putString("stat_send_msg_user", str3);
                intent.putExtra("_stat_obj", bundle2);
                this.yyH.startActivity(intent);
                this.yyH.overridePendingTransition(0, 0);
                if (cgVar3.cjX() && eVar.userName != null) {
                    com.tencent.mm.ui.chatting.a.a(com.tencent.mm.ui.chatting.a.a.EnterFullScreen, cgVar3);
                    if (eVar.userName.toLowerCase().endsWith("@chatroom")) {
                        com.tencent.mm.plugin.report.service.g.pWK.h(11444, Integer.valueOf(2));
                    } else {
                        com.tencent.mm.plugin.report.service.g.pWK.h(11444, Integer.valueOf(1));
                    }
                }
            }
        }

        private void h(final r rVar) {
            as.Hm();
            if (!com.tencent.mm.y.c.isSDCardAvailable()) {
                u.fJ(this.yyH.getContext());
            } else if (rVar.status == bc.CTRL_INDEX) {
                t.nH(rVar.getFileName());
            } else if (ab.bC(this.yyH.getContext()) || yOC) {
                t.nF(rVar.getFileName());
            } else {
                yOC = true;
                h.a(this.yyH.getContext(), R.l.eTp, R.l.dGZ, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        t.nF(rVar.getFileName());
                    }
                }, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
            }
        }
    }

    public static class d extends com.tencent.mm.ui.chatting.viewitems.b.a {
        private static Map<String, WeakReference<d>> yTa = new HashMap();
        private static SparseArray<String> yWr = new SparseArray();
        TextView pxC;
        ImageView rqV;
        ImageView yRI;
        ImageView yRJ;
        TextView yRL;
        ImageView yRZ;
        ImageView ySW;
        ImageView yVw;
        TextView yWm;
        MMPinProgressBtn yWn;
        View yWo;
        ProgressBar yWp;
        View yWq;

        public static boolean b(com.tencent.mm.modelvideo.s.a.a aVar) {
            if (aVar.hXL != com.tencent.mm.modelvideo.s.a.b.hXP) {
                return false;
            }
            final r nJ = t.nJ(aVar.fileName);
            if (nJ == null) {
                x.w("MicroMsg.VideoItemHoder", "update status, filename %s, videoInfo not found", aVar.fileName);
                return false;
            } else if (nJ.status != MMGIFException.D_GIF_ERR_IMAGE_DEFECT && nJ.status != 104 && nJ.status != 103) {
                return false;
            } else {
                ah.y(new Runnable() {
                    public final void run() {
                        WeakReference weakReference = (WeakReference) d.yTa.get(nJ.getFileName());
                        if (weakReference == null) {
                            x.w("MicroMsg.VideoItemHoder", "update status, filename %s, holder not found", nJ.getFileName());
                            return;
                        }
                        d dVar = (d) weakReference.get();
                        if (dVar == null) {
                            x.w("MicroMsg.VideoItemHoder", "update status, filename %s, holder gc!", nJ.getFileName());
                            return;
                        }
                        dVar.yRI.setVisibility(8);
                        dVar.rqV.setVisibility(8);
                        dVar.yWn.setVisibility(0);
                        int i = nJ.status;
                        x.i("MicroMsg.VideoItemHoder", "updateStatus videoStatus : " + i);
                        if (i == MMGIFException.D_GIF_ERR_IMAGE_DEFECT || i == 122 || i == 120) {
                            dVar.yWn.setProgress(t.f(nJ));
                        } else {
                            dVar.yWn.setProgress(t.g(nJ));
                        }
                    }
                });
                return true;
            }
        }

        public final com.tencent.mm.ui.chatting.viewitems.b.a q(View view, boolean z) {
            ImageView imageView;
            ProgressBar progressBar;
            View view2 = null;
            super.ds(view);
            this.ljv = (TextView) view.findViewById(R.h.bVh);
            this.ySW = (ImageView) view.findViewById(R.h.bTK);
            this.qng = (TextView) view.findViewById(R.h.bVm);
            this.pxC = (TextView) view.findViewById(R.h.bVb);
            this.yWm = (TextView) view.findViewById(R.h.bUw);
            this.rqV = (ImageView) view.findViewById(R.h.bVe);
            this.yRI = (ImageView) view.findViewById(R.h.bTO);
            this.yRJ = (ImageView) view.findViewById(R.h.bVg);
            this.yWn = (MMPinProgressBtn) view.findViewById(R.h.bTS);
            this.yWo = view.findViewById(R.h.bVo);
            this.yRn = view.findViewById(R.h.bTF);
            this.yRL = (TextView) view.findViewById(R.h.bTb);
            this.mXO = (CheckBox) view.findViewById(R.h.bTE);
            this.kbO = view.findViewById(R.h.bUE);
            this.yVw = (ImageView) view.findViewById(R.h.bTM);
            if (z) {
                imageView = null;
            } else {
                imageView = (ImageView) view.findViewById(R.h.bVf);
            }
            this.yRZ = imageView;
            if (z) {
                progressBar = null;
            } else {
                progressBar = (ProgressBar) view.findViewById(R.h.bVp);
            }
            this.yWp = progressBar;
            if (!z) {
                view2 = view.findViewById(R.h.cUi);
            }
            this.yWq = view2;
            return this;
        }

        public static void a(d dVar, au auVar, boolean z, int i, com.tencent.mm.ui.chatting.ChattingUI.a aVar, int i2, View.OnClickListener onClickListener, OnLongClickListener onLongClickListener) {
            int fromDPToPix;
            String str = (String) yWr.get(dVar.hashCode());
            if (str != null) {
                yTa.remove(str);
            }
            yWr.put(dVar.hashCode(), auVar.field_imgPath);
            yTa.put(auVar.field_imgPath, new WeakReference(dVar));
            r nJ = t.nJ(auVar.field_imgPath);
            if (nJ == null) {
                nJ = new r();
            }
            o.Ub();
            Bitmap a = com.tencent.mm.ap.o.PC().a(com.tencent.mm.modelvideo.s.ny(auVar.field_imgPath), com.tencent.mm.bu.a.getDensity(aVar.getContext()), aVar.getContext(), i2);
            dVar.yVw.setLayoutParams(new LayoutParams(0, 0));
            if (a == null) {
                fromDPToPix = com.tencent.mm.bu.a.fromDPToPix(aVar.getContext(), 85);
                int aa = com.tencent.mm.bu.a.aa(aVar.getContext(), R.f.bux);
                Bitmap a2 = com.tencent.mm.sdk.platformtools.d.a(com.tencent.mm.sdk.platformtools.d.ah(aVar.getContext().getResources().getColor(R.e.bsI), fromDPToPix, aa), i2, fromDPToPix, aa);
                as.Hm();
                if (com.tencent.mm.y.c.isSDCardAvailable()) {
                    dVar.ySW.setImageBitmap(com.tencent.mm.sdk.platformtools.d.a(a2, i2, fromDPToPix, aa));
                } else {
                    dVar.ySW.setImageDrawable(com.tencent.mm.bu.a.b(aVar.getContext(), R.k.dBH));
                    dVar.ySW.setBackground(new BitmapDrawable(a2));
                }
                ViewGroup.LayoutParams layoutParams = new LayoutParams(fromDPToPix, aa);
                dVar.yVw.setLayoutParams(layoutParams);
                if (dVar.yWq != null) {
                    dVar.yWq.setLayoutParams(layoutParams);
                }
            } else {
                dVar.ySW.setImageBitmap(a);
                ViewGroup.LayoutParams layoutParams2 = new LayoutParams(a.getWidth(), a.getHeight());
                dVar.yVw.setLayoutParams(layoutParams2);
                if (dVar.yWq != null) {
                    dVar.yWq.setLayoutParams(layoutParams2);
                }
            }
            if (z) {
                dVar.pxC.setText(com.tencent.mm.platformtools.t.by((long) nJ.hmZ));
                dVar.yWm.setText(com.tencent.mm.platformtools.t.iZ(nJ.hXv));
                fromDPToPix = nJ.status;
                x.i("MicroMsg.VideoItemHoder", "parseVideo from video status : " + fromDPToPix + " info : " + nJ.getFileName());
                if (fromDPToPix == 199) {
                    dVar.rqV.setImageDrawable(com.tencent.mm.bu.a.b(aVar.getContext(), R.k.dAT));
                } else {
                    dVar.rqV.setImageDrawable(com.tencent.mm.bu.a.b(aVar.getContext(), R.k.dAT));
                    dVar.pxC.setVisibility(8);
                }
                if (fromDPToPix == MMGIFException.D_GIF_ERR_IMAGE_DEFECT || fromDPToPix == 122 || fromDPToPix == 120) {
                    dVar.yRI.setVisibility(8);
                    dVar.rqV.setVisibility(8);
                    dVar.yWn.setVisibility(0);
                    dVar.yWn.setProgress(t.f(nJ));
                    x.v("MicroMsg.VideoItemHoder", "status begin");
                    dVar.yWn.invalidate();
                } else if (fromDPToPix == 113 || fromDPToPix == bc.CTRL_INDEX || nJ.Uo()) {
                    dVar.yRI.setVisibility(0);
                    dVar.yRJ.setVisibility(8);
                    dVar.yWn.setVisibility(8);
                    dVar.rqV.setVisibility(0);
                    x.v("MicroMsg.VideoItemHoder", "status pause");
                } else {
                    dVar.yRJ.setVisibility(8);
                    dVar.yRI.setVisibility(8);
                    dVar.yWn.setVisibility(8);
                    dVar.rqV.setVisibility(0);
                    x.v("MicroMsg.VideoItemHoder", "status gone");
                }
            } else {
                dVar.pxC.setText(com.tencent.mm.platformtools.t.by((long) nJ.hmZ));
                dVar.yWm.setText(com.tencent.mm.platformtools.t.iZ(nJ.hXv));
                fromDPToPix = nJ.status;
                dVar.rqV.setImageDrawable(com.tencent.mm.bu.a.b(aVar.getContext(), R.k.dAT));
                if (dVar.yWp != null) {
                    dVar.yWp.setVisibility(8);
                }
                if (dVar.yWq != null) {
                    dVar.yWq.setVisibility(8);
                }
                x.v("MicroMsg.VideoItemHoder", "video status %d", Integer.valueOf(fromDPToPix));
                if (fromDPToPix == 104 || fromDPToPix == 103) {
                    if (com.tencent.mm.plugin.mmsight.c.sZ(nJ.hXw)) {
                        if (dVar.yWp != null) {
                            dVar.yWp.setVisibility(0);
                        }
                        if (dVar.yWq != null) {
                            dVar.yWq.setVisibility(0);
                        }
                        dVar.yWm.setText(null);
                        dVar.pxC.setText(null);
                        dVar.rqV.setImageDrawable(null);
                        dVar.yRJ.setVisibility(8);
                        dVar.yRI.setVisibility(8);
                        dVar.yWn.setVisibility(8);
                    } else {
                        if (dVar.yWp != null) {
                            dVar.yWp.setVisibility(8);
                        }
                        if (dVar.yWq != null) {
                            dVar.yWq.setVisibility(8);
                        }
                        dVar.yRI.setVisibility(8);
                        dVar.rqV.setVisibility(8);
                        dVar.yWn.setVisibility(0);
                        dVar.yWn.setProgress(t.g(nJ));
                    }
                    x.v("MicroMsg.VideoItemHoder", "status begin");
                } else if (fromDPToPix == 105 || fromDPToPix == bc.CTRL_INDEX || nJ.Uo()) {
                    dVar.yRI.setVisibility(0);
                    dVar.yRJ.setVisibility(8);
                    dVar.yWn.setVisibility(8);
                    dVar.rqV.setVisibility(0);
                    x.v("MicroMsg.VideoItemHoder", "status pause");
                } else if (fromDPToPix != 106) {
                    dVar.yRJ.setVisibility(8);
                    dVar.yRI.setVisibility(8);
                    dVar.yWn.setVisibility(8);
                    dVar.rqV.setVisibility(0);
                    x.v("MicroMsg.VideoItemHoder", "status gone");
                } else if (k.Sa(auVar.field_imgPath)) {
                    if (dVar.yWp != null) {
                        dVar.yWp.setVisibility(0);
                    }
                    if (dVar.yWq != null) {
                        dVar.yWq.setVisibility(0);
                    }
                    dVar.yWm.setText(null);
                    dVar.pxC.setText(null);
                    dVar.rqV.setImageDrawable(null);
                    dVar.yRJ.setVisibility(8);
                    dVar.yRI.setVisibility(8);
                    dVar.yWn.setVisibility(8);
                } else {
                    t.nC(auVar.field_imgPath);
                }
            }
            ImageView imageView = dVar.yRJ;
            e eVar = new e(auVar, aVar.yxU, i, auVar.field_talker);
            eVar.kZv = 4;
            imageView.setTag(eVar);
            dVar.yRJ.setOnClickListener(onClickListener);
            imageView = dVar.yRI;
            eVar = new e(auVar, aVar.yxU, i, auVar.field_talker);
            eVar.kZv = 3;
            imageView.setTag(eVar);
            dVar.yRI.setOnClickListener(onClickListener);
            View view = dVar.yRn;
            eVar = new e(auVar, aVar.yxU, i, auVar.field_talker);
            eVar.kZv = 2;
            view.setTag(eVar);
            dVar.yRn.setOnClickListener(onClickListener);
            dVar.yRn.setOnLongClickListener(onLongClickListener);
            dVar.yRn.setOnTouchListener(aVar.yAM.yBC);
        }
    }

    public static class a extends b {
        private c yWk;
        private com.tencent.mm.ui.chatting.ChattingUI.a yyH;

        private c cwq() {
            if (this.yWk == null) {
                this.yWk = new c(this.yyH);
            }
            return this.yWk;
        }

        public final boolean aXP() {
            return false;
        }

        public final boolean ak(int i, boolean z) {
            if (z || i != 43) {
                return false;
            }
            return true;
        }

        public final View a(LayoutInflater layoutInflater, View view) {
            if (view != null && view.getTag() != null) {
                return view;
            }
            view = new p(layoutInflater, R.i.ddG);
            view.setTag(new d().q(view, true));
            return view;
        }

        public final void a(com.tencent.mm.ui.chatting.viewitems.b.a aVar, int i, com.tencent.mm.ui.chatting.ChattingUI.a aVar2, au auVar, String str) {
            this.yyH = aVar2;
            d dVar = (d) aVar;
            d.a(dVar, auVar, true, i, aVar2, R.g.bAI, cwq(), s(aVar2));
            String str2 = auVar.gkB;
            if (str2 == null || str2.length() == 0) {
                dVar.yRL.setVisibility(8);
                return;
            }
            dVar.yRL.setVisibility(0);
            b(aVar2, dVar.yRL, (Object) ar.aae(str2));
        }

        public final boolean a(ContextMenu contextMenu, View view, au auVar) {
            as.Hm();
            if (com.tencent.mm.y.c.isSDCardAvailable()) {
                int i = ((ar) view.getTag()).position;
                r nv = o.Ub().nv(auVar.field_imgPath);
                contextMenu.add(i, 129, 0, view.getContext().getString(R.l.dRW));
                contextMenu.add(i, 107, 0, view.getContext().getString(R.l.eEP));
                if (com.tencent.mm.bl.d.Pu("favorite")) {
                    contextMenu.add(i, 116, 0, view.getContext().getString(R.l.eAq));
                }
                com.tencent.mm.sdk.b.b diVar = new di();
                diVar.fsL.frh = auVar.field_msgId;
                com.tencent.mm.sdk.b.a.xmy.m(diVar);
                if (diVar.fsM.fsk) {
                    contextMenu.add(i, FileUtils.S_IWUSR, 0, view.getContext().getString(R.l.dRX));
                }
                if (nv != null && ((nv.status == 199 || nv.status == 199) && f.LU() && !this.yyH.ctJ())) {
                    contextMenu.add(i, 114, 0, view.getContext().getString(R.l.dRO));
                }
                if (!this.yyH.ctJ()) {
                    contextMenu.add(i, 100, 0, view.getContext().getString(R.l.dRT));
                }
            }
            return true;
        }

        public final boolean a(MenuItem menuItem, com.tencent.mm.ui.chatting.ChattingUI.a aVar, au auVar) {
            return false;
        }

        public final boolean b(View view, com.tencent.mm.ui.chatting.ChattingUI.a aVar, au auVar) {
            cwq().onClick(view);
            return true;
        }
    }
}
