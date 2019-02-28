package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ap.o;
import com.tencent.mm.f.a.di;
import com.tencent.mm.f.a.hz;
import com.tencent.mm.f.a.mv;
import com.tencent.mm.modelcdntran.keep_ProgressInfo;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.sns.b.i;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.protocal.c.uz;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.MMImageView;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.chatting.ah;
import com.tencent.mm.ui.chatting.q;
import com.tencent.mm.ui.chatting.r;
import com.tencent.mm.ui.chatting.r.k;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import com.tencent.mm.y.as;
import com.tencent.mm.y.bb;
import com.tencent.mm.y.s;
import com.tencent.mm.y.u;
import com.tencent.wcdb.FileUtils;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONObject;

public final class c {
    private static com.tencent.mm.ap.a.a.c liE;

    static class b {
        static boolean a(Context context, com.tencent.mm.x.g.a aVar) {
            if (aVar == null || context == null) {
                return false;
            }
            if (aVar.type == 3) {
                return g.m(context, 16);
            }
            if (aVar.type == 4) {
                return g.m(context, 8);
            }
            if (aVar.type == 5) {
                return g.m(context, 32);
            }
            if (aVar.type != 6) {
                return false;
            }
            Long RH = com.tencent.mm.pluginsdk.b.a.RH(aVar.hcN);
            if (RH != null) {
                return g.m(context, RH.longValue());
            }
            return false;
        }

        static void a(final com.tencent.mm.ui.chatting.ChattingUI.a aVar, final au auVar, String str) {
            String dn = aVar.dn(auVar.field_content, auVar.field_isSend);
            final Intent intent = new Intent(aVar.getContext(), MsgRetransmitUI.class);
            intent.putExtra("Retr_Msg_content", dn);
            intent.putExtra("Retr_MsgFromScene", 2);
            com.tencent.mm.x.g.a fV = com.tencent.mm.x.g.a.fV(dn);
            if (fV != null && 19 == fV.type) {
                intent.putExtra("Retr_Msg_Type", 10);
            } else if (fV != null && 24 == fV.type) {
                intent.putExtra("Retr_Msg_Type", 10);
            } else if (fV == null || 16 != fV.type) {
                intent.putExtra("Retr_Msg_Type", 2);
                dn = auVar.field_talker;
                String hC = u.hC(auVar.field_msgSvrId);
                intent.putExtra("reportSessionId", hC);
                com.tencent.mm.y.u.b t = u.GQ().t(hC, true);
                t.o("prePublishId", "msg_" + auVar.field_msgSvrId);
                t.o("preUsername", str);
                t.o("preChatName", dn);
                if (!(fV == null || fV.r(com.tencent.mm.x.a.class) == null)) {
                    t.o("appservicetype", Integer.valueOf(((com.tencent.mm.x.a) fV.r(com.tencent.mm.x.a.class)).hcm));
                    intent.putExtra("Retr_MsgAppBrandServiceType", ((com.tencent.mm.x.a) fV.r(com.tencent.mm.x.a.class)).hcm);
                }
                if (fV != null && 33 == fV.type) {
                    if (aVar.yAR) {
                        t.o("fromScene", Integer.valueOf(2));
                        intent.putExtra("Retr_MsgAppBrandFromScene", 2);
                    } else {
                        t.o("fromScene", Integer.valueOf(1));
                        intent.putExtra("Retr_MsgAppBrandFromScene", 1);
                    }
                    intent.putExtra("Retr_MsgFromUserName", str);
                    intent.putExtra("Retr_MsgTalker", auVar.field_talker);
                }
                t.o("sendAppMsgScene", Integer.valueOf(1));
                ((i) com.tencent.mm.kernel.g.h(i.class)).a("adExtStr", t, auVar);
            } else {
                intent.putExtra("Retr_Msg_Type", 14);
            }
            intent.putExtra("Retr_Msg_Id", auVar.field_msgId);
            if (fV == null || fV.type != 6) {
                aVar.startActivity(intent);
                return;
            }
            com.tencent.mm.plugin.report.service.g gVar = com.tencent.mm.plugin.report.service.g.pWK;
            Object[] objArr = new Object[6];
            objArr[0] = fV.hcT;
            objArr[1] = Integer.valueOf(fV.hcQ == 1 ? 7 : 5);
            objArr[2] = Integer.valueOf(fV.hcM);
            objArr[3] = Integer.valueOf(2);
            objArr[4] = Long.valueOf((System.currentTimeMillis() - auVar.field_createTime) / 1000);
            objArr[5] = fV.hcN;
            gVar.h(14665, objArr);
            boolean z = fV.hcQ != 0 || fV.hcM > 26214400;
            intent.putExtra("Retr_Big_File", z);
            final com.tencent.mm.pluginsdk.model.app.b Sn = l.Sn(fV.for);
            if (Sn != null) {
                File file = new File(Sn.field_fileFullPath);
                if (file.exists() && file.length() == Sn.field_totalLen) {
                    aVar.startActivity(intent);
                    return;
                } else if (Sn.field_offset > 0 && Sn.field_totalLen > Sn.field_offset) {
                    a(aVar, intent, auVar, Sn.field_fileFullPath);
                    return;
                }
            }
            x.i("MicroMsg.AppMessageUtil", "summerbig retrans content.attachlen[%d], cdnAttachUrl[%s], aesKey[%s]", Integer.valueOf(fV.hcM), fV.hcT, bi.Wz(fV.hda));
            if (z) {
                intent.putExtra("Retr_Big_File", z);
                com.tencent.mm.modelcdntran.i iVar = new com.tencent.mm.modelcdntran.i();
                iVar.hve = new com.tencent.mm.modelcdntran.i.a() {
                    public final int a(String str, int i, keep_ProgressInfo keep_progressinfo, keep_SceneResult keep_sceneresult, boolean z) {
                        String str2 = "MicroMsg.AppMessageUtil";
                        String str3 = "summerbig cdnCallback mediaId:%s startRet:%d proginfo:[%s] res:[%s], progressing[%b], finish[%b], onlyCheckExist[%b]";
                        Object[] objArr = new Object[7];
                        objArr[0] = str;
                        objArr[1] = Integer.valueOf(i);
                        objArr[2] = keep_progressinfo;
                        objArr[3] = keep_sceneresult;
                        objArr[4] = Boolean.valueOf(keep_progressinfo != null);
                        objArr[5] = Boolean.valueOf(keep_sceneresult != null);
                        objArr[6] = Boolean.valueOf(z);
                        x.i(str2, str3, objArr);
                        if (keep_sceneresult != null) {
                            if (keep_sceneresult.field_exist_whencheck) {
                                aVar.startActivity(intent);
                            } else if (auVar.ckh() || (Sn != null && b.c(auVar, Sn.field_fileFullPath))) {
                                x.i("MicroMsg.AppMessageUtil", "appmsg is expired or clean!!!");
                                h.a(aVar.getContext(), aVar.getContext().getString(R.l.ehy), aVar.getContext().getString(R.l.dGZ), new OnClickListener() {
                                    public final void onClick(DialogInterface dialogInterface, int i) {
                                    }
                                });
                            } else {
                                h.b(aVar.getContext(), aVar.getString(R.l.dXN), "", true);
                            }
                        }
                        return 0;
                    }

                    public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
                    }

                    public final byte[] h(String str, byte[] bArr) {
                        return new byte[0];
                    }
                };
                iVar.field_mediaId = com.tencent.mm.modelcdntran.d.a("checkExist", bi.Wy(), str, auVar.field_msgId);
                iVar.field_fileId = fV.hcT;
                iVar.field_aesKey = fV.hda;
                iVar.field_filemd5 = fV.filemd5;
                iVar.field_fileType = com.tencent.mm.modelcdntran.b.htw;
                iVar.field_talker = str;
                iVar.field_priority = com.tencent.mm.modelcdntran.b.htu;
                iVar.field_svr_signature = "";
                iVar.field_onlycheckexist = true;
                x.i("MicroMsg.AppMessageUtil", "summerbig retrans to startupDownloadMedia ret[%b], field_fileId[%s], field_mediaId[%s], field_aesKey[%s]", Boolean.valueOf(com.tencent.mm.modelcdntran.g.MP().c(iVar)), iVar.field_fileId, iVar.field_mediaId, bi.Wz(iVar.field_aesKey));
                if (!com.tencent.mm.modelcdntran.g.MP().c(iVar)) {
                    a(aVar, intent, auVar, null);
                    return;
                }
                return;
            }
            a(aVar, intent, auVar, null);
        }

        private static void a(com.tencent.mm.ui.chatting.ChattingUI.a aVar, Intent intent, au auVar, String str) {
            if (auVar.ckh() || c(auVar, str)) {
                x.i("MicroMsg.AppMessageUtil", "appmsg is expired or clean!!!");
                h.a(aVar.getContext(), aVar.getContext().getString(R.l.ehy), aVar.getContext().getString(R.l.dGZ), new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                return;
            }
            aVar.startActivity(intent);
        }

        public static boolean c(au auVar, String str) {
            if (System.currentTimeMillis() - auVar.field_createTime <= 259200000 || (!bi.oN(str) && com.tencent.mm.a.e.bO(str))) {
                return false;
            }
            return true;
        }
    }

    static final class c extends com.tencent.mm.ui.chatting.viewitems.b.a {
        public static int[] mDJ = new int[]{R.h.bUL, R.h.bUM, R.h.bUN, R.h.bUO, R.h.bUP};
        protected TextView ikL;
        protected TextView ikM;
        protected TextView mDG;
        protected TextView ntj;
        private ArrayList<MMImageView> rBE = new ArrayList();
        protected MMImageView yRA;
        protected ImageView yRB;
        protected ImageView yRC;
        protected TextView yRD;
        protected LinearLayout yRE;
        protected ImageView yRF;
        protected MMPinProgressBtn yRG;
        protected ImageView yRH;
        protected ImageView yRI;
        protected ImageView yRJ;
        protected ImageView yRK;
        protected TextView yRL;
        protected ChattingItemFooter yRM;
        protected ImageView yRN;
        protected LinearLayout yRO;
        protected ViewGroup yRP;
        protected TextView yRQ;
        protected LinearLayout yRR;
        protected RelativeLayout yRS;
        protected FrameLayout yRT;
        protected LinearLayout yRU;
        protected LinearLayout yRV;
        protected ViewStub yRW;
        protected ImageView yRX;
        protected ImageView yRY;
        ImageView yRZ;
        protected LinearLayout ySa;
        protected ImageView ySb;
        protected TextView ySc;
        protected TextView ySd;
        protected ImageView ySe;
        protected TextView ySf;
        protected TextView ySg;
        protected LinearLayout ySh;
        protected ImageView ySi;
        protected ImageView ySj;
        protected TextView ySk;
        public int ySl = 0;
        private int ySm = Integer.MAX_VALUE;

        c() {
        }

        public final c p(View view, boolean z) {
            super.ds(view);
            this.yRA = (MMImageView) view.findViewById(R.h.bTq);
            this.ikL = (TextView) view.findViewById(R.h.bTs);
            this.ntj = (TextView) view.findViewById(R.h.bTt);
            this.ikM = (TextView) view.findViewById(R.h.bTe);
            this.mDG = (TextView) view.findViewById(R.h.bTn);
            this.yRB = (ImageView) view.findViewById(R.h.bTk);
            this.yRD = (TextView) view.findViewById(R.h.bTm);
            this.yRC = (ImageView) view.findViewById(R.h.bTl);
            this.yRE = (LinearLayout) view.findViewById(R.h.bTj);
            this.yRF = (ImageView) view.findViewById(R.h.bTo);
            this.yRG = (MMPinProgressBtn) view.findViewById(R.h.bTW);
            this.yRH = (ImageView) this.nav.findViewById(R.h.bTV);
            this.yRI = (ImageView) this.nav.findViewById(R.h.bTO);
            this.yRJ = (ImageView) this.nav.findViewById(R.h.bVg);
            this.yRK = (ImageView) view.findViewById(R.h.bTf);
            this.yRL = (TextView) view.findViewById(R.h.bTb);
            this.yRN = (ImageView) view.findViewById(R.h.bTi);
            this.mXO = (CheckBox) view.findViewById(R.h.bTE);
            this.kbO = view.findViewById(R.h.bUE);
            this.qng = (TextView) view.findViewById(R.h.bVm);
            this.yRM = (ChattingItemFooter) view.findViewById(R.h.ciZ);
            this.yRO = (LinearLayout) view.findViewById(R.h.bKE);
            this.yRP = (ViewGroup) view.findViewById(R.h.cug);
            this.yRQ = (TextView) view.findViewById(R.h.cue);
            this.yRR = (LinearLayout) view.findViewById(R.h.bTu);
            this.yRT = (FrameLayout) view.findViewById(R.h.bTF);
            this.yRU = (LinearLayout) view.findViewById(R.h.bTc);
            this.yRY = (ImageView) view.findViewById(R.h.bTM);
            this.yRS = (RelativeLayout) view.findViewById(R.h.bTp);
            this.yRW = (ViewStub) view.findViewById(R.h.cAZ);
            this.yRX = (ImageView) view.findViewById(R.h.bTR);
            if (!z) {
                this.yRZ = (ImageView) this.nav.findViewById(R.h.bVf);
                this.pyj = (ProgressBar) this.nav.findViewById(R.h.cUg);
            }
            this.ySh = (LinearLayout) view.findViewById(R.h.bSU);
            this.ySi = (ImageView) view.findViewById(R.h.bSV);
            this.ySj = (ImageView) view.findViewById(R.h.ceO);
            this.ySk = (TextView) view.findViewById(R.h.bSX);
            this.ySa = (LinearLayout) view.findViewById(R.h.bST);
            this.ySb = (ImageView) view.findViewById(R.h.bSR);
            this.ySc = (TextView) view.findViewById(R.h.bSS);
            this.ySd = (TextView) view.findViewById(R.h.bSW);
            this.ySe = (ImageView) view.findViewById(R.h.bSY);
            this.ySf = (TextView) view.findViewById(R.h.bTa);
            this.ySg = (TextView) view.findViewById(R.h.bSZ);
            if (this.ntj != null && VERSION.SDK_INT >= 16) {
                this.ySm = this.ntj.getMaxLines();
            }
            this.ySl = b.fP(ad.getContext());
            return this;
        }

        public final void reset() {
            if (this.ntj != null) {
                this.ntj.setMaxLines(this.ySm);
            }
        }

        public static void a(c cVar, String str, int i) {
            int Sm = l.Sm(str);
            if (Sm == -1 || Sm >= 100 || i <= 0) {
                cVar.yRG.setVisibility(8);
                cVar.yRH.setVisibility(8);
                return;
            }
            cVar.yRG.setVisibility(0);
            cVar.yRH.setVisibility(0);
            cVar.yRG.setProgress(Sm);
        }

        public static void a(c cVar, Boolean bool, au auVar, String str, String str2) {
            final long j = auVar.field_msgId;
            com.tencent.mm.pluginsdk.model.app.b fp = an.aqK().fp(j);
            if (fp == null) {
                x.w("MicroMsg.AppMsgViewHolder", "attach info is null, msgId: %s, attachName: %s", Long.valueOf(j), str2);
                return;
            }
            if (bool.booleanValue()) {
                if (fp.field_status == 101) {
                    cVar.yRJ.setVisibility(0);
                    cVar.yRG.setVisibility(0);
                    cVar.yRH.setVisibility(0);
                } else if (fp.field_status == 102) {
                    cVar.yRJ.setVisibility(8);
                    cVar.yRG.setVisibility(8);
                    cVar.yRH.setVisibility(8);
                } else {
                    cVar.yRJ.setVisibility(8);
                    cVar.yRG.setVisibility(8);
                    cVar.yRH.setVisibility(8);
                }
            } else if (fp.field_status == 101) {
                cVar.yRJ.setVisibility(0);
                cVar.yRI.setVisibility(8);
            } else if (fp.field_status == 105) {
                cVar.yRJ.setVisibility(8);
                cVar.yRI.setVisibility(0);
            } else {
                cVar.yRJ.setVisibility(8);
                cVar.yRI.setVisibility(8);
            }
            if (auVar.field_status == 5) {
                cVar.yRJ.setVisibility(8);
                cVar.yRI.setVisibility(8);
            }
            final Boolean bool2 = bool;
            final String str3 = str;
            final String str4 = str2;
            final au auVar2 = auVar;
            cVar.yRJ.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    long j;
                    String str;
                    com.tencent.mm.sdk.e.c fp;
                    if (bool2.booleanValue()) {
                        j = j;
                        str = str4;
                        fp = an.aqK().fp(j);
                        if (fp == null) {
                            x.e("MicroMsg.AppMsgLogic", "ERR:" + com.tencent.mm.compatible.util.g.zo() + " getinfo failed: " + str);
                            return;
                        } else if (fp.field_status != 101) {
                            x.e("MicroMsg.AppMsgLogic", "ERR:" + com.tencent.mm.compatible.util.g.zo() + " get status failed: " + str + " status:" + fp.field_status);
                            return;
                        } else {
                            fp.field_status = 102;
                            fp.field_lastModifyTime = bi.Wx();
                            an.aqK().c(fp, new String[0]);
                            return;
                        }
                    }
                    j = j;
                    str = str4;
                    fp = an.aqK().fp(j);
                    if (fp == null) {
                        x.e("MicroMsg.AppMsgLogic", "ERR:" + com.tencent.mm.compatible.util.g.zo() + " getinfo failed: " + str);
                    } else if (fp.field_status != 101) {
                        x.e("MicroMsg.AppMsgLogic", "ERR:" + com.tencent.mm.compatible.util.g.zo() + " get status failed: " + str + " status:" + fp.field_status);
                    } else {
                        if (!bi.oN(fp.field_clientAppDataId) || bi.oN(fp.field_mediaSvrId)) {
                            fp.field_status = 105;
                        } else {
                            fp.field_status = 102;
                        }
                        fp.field_lastModifyTime = bi.Wx();
                        an.aqK().c(fp, new String[0]);
                    }
                    auVar2.eR(5);
                    as.Hm();
                    com.tencent.mm.y.c.Fh().dI(j);
                }
            });
            bool2 = bool;
            str3 = str2;
            final au auVar3 = auVar;
            cVar.yRI.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    if (!bool2.booleanValue()) {
                        long j = j;
                        String str = str3;
                        com.tencent.mm.sdk.e.c fp = an.aqK().fp(j);
                        if (fp == null) {
                            x.e("MicroMsg.AppMsgLogic", "ERR:" + com.tencent.mm.compatible.util.g.zo() + " getinfo failed: " + str);
                        } else if (fp.field_status != 105) {
                            x.e("MicroMsg.AppMsgLogic", "ERR:" + com.tencent.mm.compatible.util.g.zo() + " get status failed: " + str + " status:" + fp.field_status);
                        } else {
                            fp.field_status = 101;
                            fp.field_lastModifyTime = bi.Wx();
                            an.aqK().c(fp, new String[0]);
                            an.bZH().run();
                        }
                        auVar3.eR(1);
                        as.Hm();
                        com.tencent.mm.y.c.Fh().dI(j);
                    }
                }
            });
        }

        static void a(com.tencent.mm.ui.chatting.ChattingUI.a aVar, c cVar, com.tencent.mm.x.g.a aVar2, boolean z) {
            String str;
            CharSequence charSequence;
            cVar.ikL.setVisibility(8);
            if (aVar2.title == null || aVar2.title.trim().length() <= 0) {
                cVar.ntj.setVisibility(8);
                str = null;
            } else {
                str = aVar2.title;
                cVar.ntj.setVisibility(0);
                cVar.ntj.setMaxLines(2);
            }
            cVar.ikM.setMaxLines(4);
            cVar.yRK.setVisibility(8);
            cVar.yRF.setVisibility(4);
            if (z) {
                cVar.yRA.setVisibility(8);
            }
            com.tencent.mm.sdk.b.b mvVar = new mv();
            mvVar.fFz.type = 0;
            mvVar.fFz.fFB = aVar2.hdm;
            com.tencent.mm.sdk.b.a.xmy.m(mvVar);
            com.tencent.mm.protocal.b.a.c cVar2 = mvVar.fFA.fFJ;
            if (cVar2 != null) {
                cVar.ntj.setText(com.tencent.mm.pluginsdk.ui.d.i.b(cVar.ntj.getContext(), bi.aD(cVar2.title, aVar2.title), cVar.ntj.getTextSize()));
                String str2 = cVar2.desc;
                if (str2 == null) {
                    x.e("MicroMsg.AppMsgViewHolder", "recordMsg desc is null !! recordInfo = [%s]", aVar2.hdm);
                } else {
                    str2 = str2.replaceAll("&lt;", "<").replaceAll("&gt;", ">");
                }
                if (str2 != null && str2.length() > 100) {
                    str2 = str2.substring(0, 100);
                }
                cVar.ikM.setText(com.tencent.mm.pluginsdk.ui.d.i.b(cVar.ikM.getContext(), bi.aD(str2, aVar2.description), cVar.ikM.getTextSize()));
                Iterator it = cVar2.hfI.iterator();
                Object obj = null;
                String str3 = null;
                charSequence = str;
                int i = 0;
                while (it.hasNext()) {
                    uz uzVar = (uz) it.next();
                    if (bi.oN(uzVar.wkc) || !uzVar.wkc.equals(".htm") || bi.oN(uzVar.wkP) || !uzVar.wkP.equals("WeNoteHtmlFile")) {
                        if (uzVar.wkH.wlb.wlx != null) {
                            charSequence = aVar.getContext().getString(R.l.eCN);
                            i = 1;
                        } else if (uzVar.wkH.wlb.fAJ != null) {
                            if (str3 == null) {
                                str3 = uzVar.wkJ;
                            } else if (str3 != uzVar.wkJ) {
                                obj = uzVar.wkJ;
                            }
                        }
                        switch (uzVar.bjS) {
                            case 1:
                                break;
                            case 2:
                                if (!z) {
                                    break;
                                }
                                cVar.yRA.setVisibility(0);
                                cVar.yRA.setImageResource(R.g.byW);
                                break;
                            case 3:
                                if (!z) {
                                    break;
                                }
                                cVar.yRA.setVisibility(0);
                                cVar.yRA.setImageResource(R.k.dvN);
                                break;
                            case 4:
                                if (z) {
                                    cVar.yRA.setVisibility(0);
                                    cVar.yRA.setImageResource(R.k.dvL);
                                }
                                cVar.yRK.setVisibility(0);
                                cVar.yRK.setImageResource(R.g.bHg);
                                break;
                            case 5:
                                if (!z) {
                                    break;
                                }
                                cVar.yRA.setVisibility(0);
                                cVar.yRA.setImageResource(R.k.dvO);
                                break;
                            case 6:
                                cVar.yRA.setVisibility(0);
                                cVar.yRA.setImageResource(R.k.dvx);
                                break;
                            case 7:
                                if (z) {
                                    cVar.yRA.setVisibility(0);
                                    cVar.yRA.setImageResource(R.k.dvy);
                                }
                                cVar.yRK.setVisibility(0);
                                cVar.yRK.setImageResource(R.g.bDT);
                                break;
                            case 8:
                                if (!z) {
                                    break;
                                }
                                cVar.yRA.setVisibility(0);
                                cVar.yRA.setImageResource(com.tencent.mm.pluginsdk.c.RI(uzVar.wkc));
                                break;
                            case 10:
                            case 11:
                            case 14:
                                if (!z) {
                                    break;
                                }
                                cVar.yRA.setVisibility(0);
                                cVar.yRA.setImageResource(R.k.dvI);
                                break;
                            case 16:
                                if (!z) {
                                    break;
                                }
                                cVar.yRA.setVisibility(0);
                                cVar.yRA.setImageResource(R.g.bBC);
                                break;
                            default:
                                break;
                        }
                    }
                }
                if (str3 != null && obj == null && i == 0) {
                    charSequence = aVar.getContext().getString(R.l.egw, new Object[]{str3});
                } else if (!(str3 == null || obj == null || str3.equals(obj) || i != 0)) {
                    charSequence = aVar.getContext().getString(R.l.egv, new Object[]{str3, obj});
                }
            } else {
                Object obj2 = str;
            }
            if (!bi.oN(charSequence)) {
                cVar.ntj.setText(charSequence);
            }
            cVar.yRA.setVisibility(8);
            cVar.yRS.setVisibility(8);
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        static void a(com.tencent.mm.ui.chatting.ChattingUI.a r22, com.tencent.mm.ui.chatting.viewitems.c.c r23, com.tencent.mm.x.g.a r24, com.tencent.mm.storage.au r25, boolean r26) {
            /*
            r2 = new com.tencent.mm.f.a.mv;
            r2.<init>();
            r3 = r2.fFz;
            r4 = 0;
            r3.type = r4;
            r3 = r2.fFz;
            r0 = r24;
            r4 = r0.hdm;
            r3.fFB = r4;
            r3 = com.tencent.mm.sdk.b.a.xmy;
            r3.m(r2);
            r2 = r2.fFA;
            r15 = r2.fFJ;
            r0 = r23;
            r2 = r0.yRS;
            r3 = 8;
            r2.setVisibility(r3);
            r2 = 4;
            r7 = new java.lang.String[r2];
            r2 = 4;
            r6 = new java.lang.String[r2];
            r2 = 4;
            r8 = new int[r2];
            r2 = 4;
            r10 = new java.lang.String[r2];
            r2 = 4;
            r9 = new java.lang.String[r2];
            r2 = 4;
            r11 = new int[r2];
            r2 = 4;
            r5 = new java.lang.String[r2];
            if (r15 == 0) goto L_0x02df;
        L_0x003b:
            r12 = 0;
            r2 = r15.desc;
            r0 = r24;
            r3 = r0.description;
            r4 = com.tencent.mm.sdk.platformtools.bi.aD(r2, r3);
            r3 = 0;
            r2 = 0;
            r13 = r15.hfI;
            r14 = r13.iterator();
            r13 = r2;
            r21 = r3;
            r3 = r12;
            r12 = r4;
            r4 = r21;
        L_0x0055:
            r2 = r14.hasNext();
            if (r2 == 0) goto L_0x0160;
        L_0x005b:
            r2 = r14.next();
            r2 = (com.tencent.mm.protocal.c.uz) r2;
            r0 = r2.wkc;
            r16 = r0;
            r16 = com.tencent.mm.sdk.platformtools.bi.oN(r16);
            if (r16 != 0) goto L_0x008f;
        L_0x006b:
            r0 = r2.wkc;
            r16 = r0;
            r17 = ".htm";
            r16 = r16.equals(r17);
            if (r16 == 0) goto L_0x008f;
        L_0x0078:
            r0 = r2.wkP;
            r16 = r0;
            r16 = com.tencent.mm.sdk.platformtools.bi.oN(r16);
            if (r16 != 0) goto L_0x008f;
        L_0x0082:
            r0 = r2.wkP;
            r16 = r0;
            r17 = "WeNoteHtmlFile";
            r16 = r16.equals(r17);
            if (r16 != 0) goto L_0x0055;
        L_0x008f:
            r0 = r2.bjS;
            r16 = r0;
            switch(r16) {
                case 1: goto L_0x0099;
                case 2: goto L_0x00d8;
                case 3: goto L_0x0055;
                case 4: goto L_0x0096;
                case 5: goto L_0x0096;
                case 6: goto L_0x0055;
                case 7: goto L_0x0096;
                case 8: goto L_0x0138;
                default: goto L_0x0096;
            };
        L_0x0096:
            r2 = r12;
        L_0x0097:
            r12 = r2;
            goto L_0x0055;
        L_0x0099:
            if (r4 != 0) goto L_0x0096;
        L_0x009b:
            r0 = r2.desc;
            r16 = r0;
            r17 = com.tencent.mm.sdk.platformtools.bi.oN(r16);
            if (r17 != 0) goto L_0x0096;
        L_0x00a5:
            r4 = "\n";
            r17 = "";
            r0 = r16;
            r1 = r17;
            r4 = r0.replaceAll(r4, r1);
            r4 = r4.trim();
            r4 = com.tencent.mm.sdk.platformtools.bi.oN(r4);
            if (r4 != 0) goto L_0x0398;
        L_0x00bd:
            r2 = r2.desc;
            r3 = "&lt;";
            r4 = "<";
            r2 = r2.replaceAll(r3, r4);
            r3 = "&gt;";
            r4 = ">";
            r2 = r2.replaceAll(r3, r4);
        L_0x00d3:
            r3 = 1;
            r4 = r3;
            r3 = r2;
            goto L_0x0055;
        L_0x00d8:
            if (r26 == 0) goto L_0x00fb;
        L_0x00da:
            r0 = r23;
            r0 = r0.yRS;
            r16 = r0;
            r17 = 0;
            r16.setVisibility(r17);
            r0 = r23;
            r0 = r0.yRA;
            r16 = r0;
            r17 = 0;
            r16.setVisibility(r17);
            r0 = r23;
            r0 = r0.yRA;
            r16 = r0;
            r17 = com.tencent.mm.R.g.byW;
            r16.setImageResource(r17);
        L_0x00fb:
            r16 = 4;
            r0 = r16;
            if (r13 >= r0) goto L_0x0133;
        L_0x0101:
            r0 = r2.hcU;
            r16 = r0;
            r7[r13] = r16;
            r0 = r2.wjJ;
            r16 = r0;
            r6[r13] = r16;
            r0 = r2.wkt;
            r16 = r0;
            r0 = r16;
            r0 = (int) r0;
            r16 = r0;
            r8[r13] = r16;
            r0 = r2.wjN;
            r16 = r0;
            r10[r13] = r16;
            r0 = r2.wjP;
            r16 = r0;
            r9[r13] = r16;
            r0 = r2.wki;
            r16 = r0;
            r0 = r16;
            r0 = (int) r0;
            r16 = r0;
            r11[r13] = r16;
            r2 = r2.mBr;
            r5[r13] = r2;
        L_0x0133:
            r2 = r13 + 1;
            r13 = r2;
            goto L_0x0055;
        L_0x0138:
            r16 = com.tencent.mm.sdk.platformtools.bi.oN(r12);
            if (r16 == 0) goto L_0x0096;
        L_0x013e:
            r12 = new java.lang.StringBuilder;
            r12.<init>();
            r16 = com.tencent.mm.sdk.platformtools.ad.getContext();
            r17 = com.tencent.mm.R.l.dFu;
            r16 = r16.getString(r17);
            r0 = r16;
            r12 = r12.append(r0);
            r2 = r2.title;
            r2 = r12.append(r2);
            r12 = r2.toString();
            r2 = r12;
            goto L_0x0097;
        L_0x0160:
            r2 = 0;
            if (r3 == 0) goto L_0x0348;
        L_0x0163:
            r14 = "\n";
            r16 = 2;
            r0 = r16;
            r16 = r3.split(r14, r0);
            r17 = new java.util.ArrayList;
            r17.<init>();
            r0 = r16;
            r14 = r0.length;
            if (r14 <= 0) goto L_0x0194;
        L_0x0178:
            r0 = r16;
            r0 = r0.length;
            r18 = r0;
            r14 = 0;
        L_0x017e:
            r0 = r18;
            if (r14 >= r0) goto L_0x0194;
        L_0x0182:
            r19 = r16[r14];
            r20 = r19.length();
            if (r20 <= 0) goto L_0x0191;
        L_0x018a:
            r0 = r17;
            r1 = r19;
            r0.add(r1);
        L_0x0191:
            r14 = r14 + 1;
            goto L_0x017e;
        L_0x0194:
            r14 = r17.size();
            r16 = 1;
            r0 = r16;
            if (r14 != r0) goto L_0x0395;
        L_0x019e:
            r2 = 1;
            r14 = r2;
        L_0x01a0:
            r2 = r17.size();
            r16 = 1;
            r0 = r16;
            if (r2 != r0) goto L_0x02e0;
        L_0x01aa:
            r2 = r15.hfI;
            r2 = r2.size();
            r15 = 2;
            if (r2 != r15) goto L_0x02e0;
        L_0x01b3:
            r2 = com.tencent.mm.sdk.platformtools.ad.getContext();
            r12 = com.tencent.mm.R.l.ehj;
            r2 = r2.getString(r12);
        L_0x01bd:
            r2 = r2.trim();
        L_0x01c1:
            if (r2 == 0) goto L_0x01d7;
        L_0x01c3:
            r12 = "&lt;";
            r15 = "<";
            r2 = r2.replaceAll(r12, r15);
            r12 = "&gt;";
            r15 = ">";
            r2 = r2.replaceAll(r12, r15);
        L_0x01d7:
            r0 = r23;
            r12 = r0.ntj;
            r12 = r12.getContext();
            r0 = r23;
            r15 = r0.ntj;
            r15 = r15.getTextSize();
            r15 = (int) r15;
            r2 = com.tencent.mm.pluginsdk.ui.d.i.c(r12, r2, r15);
            r0 = r23;
            r12 = r0.ntj;
            r12.setText(r2);
            if (r3 == 0) goto L_0x0392;
        L_0x01f5:
            r2 = r3.length();
            r12 = 100;
            if (r2 <= r12) goto L_0x0392;
        L_0x01fd:
            r2 = 0;
            r12 = 100;
            r2 = r3.substring(r2, r12);
            r3 = "&lt;";
            r12 = "<";
            r2 = r2.replaceAll(r3, r12);
            r3 = "&gt;";
            r12 = ">";
            r2 = r2.replaceAll(r3, r12);
        L_0x0218:
            r0 = r23;
            r3 = r0.ikM;
            r3 = r3.getContext();
            r0 = r23;
            r12 = r0.ikM;
            r12 = r12.getTextSize();
            r12 = (int) r12;
            r3 = com.tencent.mm.pluginsdk.ui.d.i.c(r3, r2, r12);
            r0 = r23;
            r12 = r0.ikM;
            r12.setText(r3);
            if (r13 <= 0) goto L_0x037f;
        L_0x0236:
            r0 = r23;
            r3 = r0.yRS;
            r12 = 8;
            r3.setVisibility(r12);
            if (r14 != 0) goto L_0x0249;
        L_0x0241:
            if (r4 == 0) goto L_0x0249;
        L_0x0243:
            r2 = com.tencent.mm.sdk.platformtools.bi.oN(r2);
            if (r2 == 0) goto L_0x0357;
        L_0x0249:
            r0 = r23;
            r2 = r0.ikM;
            r3 = 8;
            r2.setVisibility(r3);
            r0 = r23;
            r2 = r0.ntj;
            r3 = 2;
            r2.setMaxLines(r3);
        L_0x025a:
            r0 = r23;
            r2 = r0.yRX;
            r3 = 8;
            r2.setVisibility(r3);
            r0 = r23;
            r2 = r0.yRW;
            r3 = com.tencent.mm.R.i.ddO;
            r2.setLayoutResource(r3);
            r0 = r23;
            r2 = r0.yRW;	 Catch:{ Exception -> 0x0371 }
            r2 = r2.inflate();	 Catch:{ Exception -> 0x0371 }
            r2 = (android.widget.LinearLayout) r2;	 Catch:{ Exception -> 0x0371 }
            r0 = r23;
            r0.yRV = r2;	 Catch:{ Exception -> 0x0371 }
        L_0x027a:
            r2 = 4;
            if (r13 <= r2) goto L_0x037c;
        L_0x027d:
            r4 = 4;
        L_0x027e:
            r0 = r25;
            r12 = r0.field_talker;
            r2 = r22;
            r3 = r23;
            a(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12);
            r0 = r23;
            r2 = r0.yRV;
            r3 = com.tencent.mm.R.h.bUQ;
            r2 = r2.findViewById(r3);
            r2 = (android.widget.ImageView) r2;
            r0 = r23;
            r3 = r0.yRV;
            r4 = com.tencent.mm.R.h.bUK;
            r3 = r3.findViewById(r4);
            r3 = (android.widget.TextView) r3;
            if (r3 == 0) goto L_0x02b6;
        L_0x02a3:
            r4 = 0;
            r5 = com.tencent.mm.sdk.platformtools.ad.getContext();
            r5 = r5.getResources();
            r6 = com.tencent.mm.R.f.bvT;
            r5 = r5.getDimensionPixelSize(r6);
            r5 = (float) r5;
            r3.setTextSize(r4, r5);
        L_0x02b6:
            r4 = 4;
            if (r13 <= r4) goto L_0x02df;
        L_0x02b9:
            if (r2 == 0) goto L_0x02bf;
        L_0x02bb:
            r4 = 0;
            r2.setVisibility(r4);
        L_0x02bf:
            if (r3 == 0) goto L_0x02df;
        L_0x02c1:
            r2 = new java.lang.StringBuilder;
            r4 = "(";
            r2.<init>(r4);
            r2 = r2.append(r13);
            r4 = ")";
            r2 = r2.append(r4);
            r2 = r2.toString();
            r3.setText(r2);
            r2 = 0;
            r3.setVisibility(r2);
        L_0x02df:
            return;
        L_0x02e0:
            if (r13 <= 0) goto L_0x0300;
        L_0x02e2:
            r2 = 0;
            r0 = r17;
            r2 = r0.get(r2);
            r2 = (java.lang.String) r2;
            r3 = r17.size();
            r12 = 1;
            if (r3 <= r12) goto L_0x02fd;
        L_0x02f2:
            r3 = 1;
            r0 = r17;
            r3 = r0.get(r3);
            r3 = (java.lang.String) r3;
            goto L_0x01bd;
        L_0x02fd:
            r3 = 0;
            goto L_0x01bd;
        L_0x0300:
            r2 = 0;
            r0 = r17;
            r2 = r0.get(r2);
            r2 = (java.lang.String) r2;
            r3 = java.util.regex.Pattern.quote(r2);
            r15 = 2;
            r12 = r12.split(r3, r15);
            r3 = 0;
            r3 = r12[r3];
            r3 = r3.trim();
            r15 = r12.length;
            r16 = 1;
            r0 = r16;
            if (r15 <= r0) goto L_0x01bd;
        L_0x0320:
            r3 = new java.lang.StringBuilder;
            r15 = 0;
            r15 = r12[r15];
            r15 = r15.trim();
            r3.<init>(r15);
            r15 = "\n";
            r3 = r3.append(r15);
            r15 = 1;
            r12 = r12[r15];
            r12 = r12.trim();
            r3 = r3.append(r12);
            r3 = r3.toString();
            r3 = r3.trim();
            goto L_0x01bd;
        L_0x0348:
            r3 = com.tencent.mm.sdk.platformtools.ad.getContext();
            r14 = com.tencent.mm.R.l.ehj;
            r3 = r3.getString(r14);
            r14 = r2;
            r2 = r3;
            r3 = r12;
            goto L_0x01c1;
        L_0x0357:
            r0 = r23;
            r2 = r0.ikM;
            r3 = 1;
            r2.setMaxLines(r3);
            r0 = r23;
            r2 = r0.ikM;
            r3 = 0;
            r2.setVisibility(r3);
            r0 = r23;
            r2 = r0.ntj;
            r3 = 1;
            r2.setMaxLines(r3);
            goto L_0x025a;
        L_0x0371:
            r2 = move-exception;
            r0 = r23;
            r2 = r0.yRW;
            r3 = 0;
            r2.setVisibility(r3);
            goto L_0x027a;
        L_0x037c:
            r4 = r13;
            goto L_0x027e;
        L_0x037f:
            r0 = r23;
            r2 = r0.yRW;
            r3 = 8;
            r2.setVisibility(r3);
            r0 = r23;
            r2 = r0.yRX;
            r3 = 0;
            r2.setVisibility(r3);
            goto L_0x02df;
        L_0x0392:
            r2 = r3;
            goto L_0x0218;
        L_0x0395:
            r14 = r2;
            goto L_0x01a0;
        L_0x0398:
            r2 = r3;
            goto L_0x00d3;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.chatting.viewitems.c.c.a(com.tencent.mm.ui.chatting.ChattingUI$a, com.tencent.mm.ui.chatting.viewitems.c$c, com.tencent.mm.x.g$a, com.tencent.mm.storage.au, boolean):void");
        }

        private static void a(com.tencent.mm.ui.chatting.ChattingUI.a aVar, c cVar, int i, String[] strArr, String[] strArr2, String[] strArr3, int[] iArr, String[] strArr4, String[] strArr5, int[] iArr2, String str) {
            MMImageView mMImageView;
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 > 4) {
                    break;
                }
                mMImageView = (MMImageView) cVar.yRV.findViewById(mDJ[i3]);
                if (mMImageView != null) {
                    mMImageView.setImageDrawable(null);
                    mMImageView.setVisibility(8);
                }
                i2 = i3 + 1;
            }
            ImageView imageView = (ImageView) cVar.yRV.findViewById(R.h.bUQ);
            TextView textView = (TextView) cVar.yRV.findViewById(R.h.bUK);
            if (imageView != null) {
                imageView.setVisibility(8);
            }
            if (textView != null) {
                textView.setVisibility(8);
            }
            i2 = 0;
            while (true) {
                int i4 = i2;
                if (i4 < i) {
                    MMImageView mMImageView2;
                    if (i == 1) {
                        mMImageView = (MMImageView) cVar.yRV.findViewById(mDJ[i4]);
                        mMImageView.setImageResource(R.k.dxU);
                        mMImageView2 = mMImageView;
                    } else {
                        mMImageView = (MMImageView) cVar.yRV.findViewById(mDJ[i4 + 1]);
                        mMImageView.setImageResource(R.k.dxT);
                        mMImageView2 = mMImageView;
                    }
                    mMImageView2.setVisibility(0);
                    an.bZE().a(aVar.yAM, strArr[i4], bi.Wy(), strArr2[i4], strArr3[i4], iArr[i4], str);
                    String m = o.PC().m("Note_" + strArr[i4], "", "");
                    Bitmap a;
                    if (FileOp.bO(m)) {
                        a = o.PC().a(m, true, com.tencent.mm.bu.a.getDensity(ad.getContext()), false, true, false, 0, false);
                        if (a == null || a.isRecycled()) {
                            mMImageView2.setImageResource(R.k.dxT);
                        } else {
                            mMImageView2.setImageBitmap(a);
                        }
                    } else {
                        an.bZE().a(aVar.yAM, strArr[i4], bi.Wy(), strArr4[i4], strArr5[i4], iArr2[i4], str);
                        o.PC().m("Note_" + strArr[i4], "", "");
                        com.tencent.mm.bu.a.fromDPToPix(aVar.getContext(), 45);
                        if (FileOp.bO(m)) {
                            a = o.PC().b(m, com.tencent.mm.bu.a.getDensity(ad.getContext()), false);
                            if (a == null || a.isRecycled()) {
                                mMImageView2.setImageResource(R.k.dxT);
                            } else {
                                mMImageView2.setImageBitmap(a);
                            }
                        } else {
                            x.i("MicroMsg.AppMsgViewHolder", "thumb file not exist!");
                        }
                    }
                    i2 = i4 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public static class e extends b {
        private com.tencent.mm.ap.a.a.c yPP;
        protected r.h ySp;
        protected k ySq;
        protected r.i ySr;
        private com.tencent.mm.ui.chatting.ChattingUI.a yyH;

        public final boolean aXP() {
            return true;
        }

        public e() {
            com.tencent.mm.ap.a.a.c.a aVar = new com.tencent.mm.ap.a.a.c.a();
            aVar.hFA = R.k.dvR;
            this.yPP = aVar.PQ();
        }

        public final boolean ak(int i, boolean z) {
            if ((z && i == 49) || i == 335544369 || i == 402653233 || i == 369098801) {
                return true;
            }
            return false;
        }

        public final View a(LayoutInflater layoutInflater, View view) {
            if (view != null && view.getTag() != null) {
                return view;
            }
            view = new p(layoutInflater, R.i.ddU);
            view.setTag(new c().p(view, false));
            return view;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void a(com.tencent.mm.ui.chatting.viewitems.b.a r25, int r26, com.tencent.mm.ui.chatting.ChattingUI.a r27, com.tencent.mm.storage.au r28, java.lang.String r29) {
            /*
            r24 = this;
            r20 = r25;
            r20 = (com.tencent.mm.ui.chatting.viewitems.c.c) r20;
            r0 = r27;
            r1 = r24;
            r1.yyH = r0;
            r0 = r27;
            r6 = r0.yEx;
            r0 = r28;
            r6.aT(r0);
            r20.reset();
            r0 = r28;
            r0 = r0.field_content;
            r16 = r0;
            r0 = r27;
            r6 = r0.yEx;
            r0 = r28;
            r6.aR(r0);
            r7 = 0;
            r6 = 0;
            if (r16 == 0) goto L_0x1460;
        L_0x0029:
            r0 = r28;
            r6 = r0.field_reserved;
            r0 = r16;
            r7 = com.tencent.mm.x.g.a.I(r0, r6);
            r6 = com.tencent.mm.x.k.fZ(r16);
            r14 = r6;
            r21 = r7;
        L_0x003a:
            r6 = new com.tencent.mm.ui.chatting.viewitems.ar;
            r0 = r27;
            r8 = r0.yxU;
            r10 = 0;
            r11 = 0;
            r7 = r28;
            r9 = r26;
            r6.<init>(r7, r8, r9, r10, r11);
            r15 = 0;
            if (r21 == 0) goto L_0x02ee;
        L_0x004c:
            r0 = r21;
            r7 = r0.appId;
            r0 = r21;
            r8 = r0.fJh;
            r9 = com.tencent.mm.pluginsdk.model.app.g.cT(r7, r8);
            r0 = r20;
            r7 = r0.ikL;
            r0 = r21;
            r8 = r0.title;
            r7.setText(r8);
            r0 = r20;
            r7 = r0.ikM;
            r0 = r21;
            r8 = r0.description;
            r7.setText(r8);
            r0 = r20;
            r7 = r0.ntj;
            r8 = 1;
            r7.setMaxLines(r8);
            r0 = r20;
            r7 = r0.ikL;
            r8 = r27.getContext();
            r8 = r8.getResources();
            r10 = com.tencent.mm.R.e.btv;
            r8 = r8.getColor(r10);
            r7.setTextColor(r8);
            r0 = r20;
            r7 = r0.ikM;
            r8 = r27.getContext();
            r8 = r8.getResources();
            r10 = com.tencent.mm.R.e.bsO;
            r8 = r8.getColor(r10);
            r7.setTextColor(r8);
            r0 = r20;
            r7 = r0.yRU;
            r8 = com.tencent.mm.R.g.bAQ;
            r7.setBackgroundResource(r8);
            r0 = r20;
            r7 = r0.yRU;
            r8 = 0;
            r10 = r27.getContext();
            r10 = r10.getResources();
            r11 = com.tencent.mm.R.f.bvC;
            r10 = r10.getDimensionPixelSize(r11);
            r11 = 0;
            r12 = 0;
            r7.setPadding(r8, r10, r11, r12);
            r0 = r20;
            r7 = r0.yRA;
            r8 = 0;
            r7.setVisibility(r8);
            r0 = r20;
            r7 = r0.yRS;
            r8 = 0;
            r7.setVisibility(r8);
            r0 = r20;
            r7 = r0.ikM;
            r8 = 0;
            r7.setVisibility(r8);
            r0 = r20;
            r7 = r0.yRW;
            r8 = 8;
            r7.setVisibility(r8);
            r0 = r20;
            r7 = r0.yRX;
            r8 = 8;
            r7.setVisibility(r8);
            r0 = r20;
            r7 = r0.yRJ;
            r8 = 8;
            r7.setVisibility(r8);
            r0 = r20;
            r7 = r0.yRI;
            r8 = 8;
            r7.setVisibility(r8);
            r0 = r20;
            r7 = r0.yRF;
            r8 = 8;
            r7.setVisibility(r8);
            r0 = r20;
            r7 = r0.yRD;
            r8 = 8;
            r7.setVisibility(r8);
            r0 = r20;
            r7 = r0.yRC;
            r8 = 8;
            r7.setVisibility(r8);
            r0 = r20;
            r7 = r0.ySh;
            r8 = 8;
            r7.setVisibility(r8);
            r0 = r20;
            r7 = r0.ySa;
            r8 = 8;
            r7.setVisibility(r8);
            r0 = r20;
            r7 = r0.yRU;
            r8 = 0;
            r7.setVisibility(r8);
            r0 = r20;
            r7 = r0.yRT;
            r0 = r20;
            r8 = r0.ySl;
            com.tencent.mm.ui.chatting.viewitems.b.a.O(r7, r8);
            if (r9 == 0) goto L_0x014f;
        L_0x013f:
            r7 = r9.field_appName;
            if (r7 == 0) goto L_0x014f;
        L_0x0143:
            r7 = r9.field_appName;
            r7 = r7.trim();
            r7 = r7.length();
            if (r7 > 0) goto L_0x0340;
        L_0x014f:
            r0 = r21;
            r7 = r0.appName;
        L_0x0153:
            r8 = 1;
            r10 = r27.getContext();
            r11 = 12;
            com.tencent.mm.bu.a.fromDPToPix(r10, r11);
            r0 = r21;
            r10 = r0.type;
            r11 = 20;
            if (r10 == r11) goto L_0x0172;
        L_0x0165:
            r10 = "wxaf060266bfa9a35c";
            r0 = r21;
            r11 = r0.appId;
            r10 = r10.equals(r11);
            if (r10 == 0) goto L_0x017a;
        L_0x0172:
            r8 = com.tencent.mm.pluginsdk.q.a.bYL();
            r8 = r8.bsk();
        L_0x017a:
            if (r8 == 0) goto L_0x0353;
        L_0x017c:
            r0 = r21;
            r8 = r0.appId;
            if (r8 == 0) goto L_0x0353;
        L_0x0182:
            r0 = r21;
            r8 = r0.appId;
            r8 = r8.length();
            if (r8 <= 0) goto L_0x0353;
        L_0x018c:
            r8 = com.tencent.mm.pluginsdk.model.app.g.cz(r7);
            if (r8 == 0) goto L_0x0353;
        L_0x0192:
            r0 = r20;
            r8 = r0.mDG;
            r10 = r27.getContext();
            r7 = com.tencent.mm.pluginsdk.model.app.g.a(r10, r9, r7);
            r8.setText(r7);
            r0 = r20;
            r7 = r0.yRE;
            r8 = 0;
            r7.setVisibility(r8);
            r0 = r20;
            r7 = r0.mDG;
            r8 = 0;
            r7.setVisibility(r8);
            r0 = r20;
            r7 = r0.mDG;
            r8 = 0;
            r10 = 0;
            r11 = 0;
            r12 = 0;
            r7.setCompoundDrawables(r8, r10, r11, r12);
            r0 = r20;
            r7 = r0.yRB;
            r8 = 0;
            r7.setVisibility(r8);
            if (r9 == 0) goto L_0x0344;
        L_0x01c6:
            r7 = r9.YI();
            if (r7 == 0) goto L_0x0344;
        L_0x01cc:
            r0 = r20;
            r8 = r0.mDG;
            r11 = r9.field_packageName;
            r0 = r28;
            r12 = r0.field_msgSvrId;
            r7 = r27;
            r9 = r28;
            r10 = r21;
            com.tencent.mm.ui.chatting.viewitems.b.a(r7, r8, r9, r10, r11, r12);
        L_0x01df:
            r0 = r20;
            r7 = r0.yRB;
            r0 = r21;
            r8 = r0.appId;
            r0 = r27;
            com.tencent.mm.ui.chatting.viewitems.b.a(r0, r7, r8);
        L_0x01ec:
            r7 = 0;
            r0 = r20;
            r8 = r0.yRA;
            r9 = 0;
            r8.setVisibility(r9);
            r0 = r24;
            r8 = r0.vGb;
            if (r8 == 0) goto L_0x03eb;
        L_0x01fb:
            r8 = 0;
            r0 = r21;
            r9 = r0.type;
            r10 = 33;
            if (r9 == r10) goto L_0x0221;
        L_0x0204:
            r0 = r21;
            r9 = r0.type;
            r10 = 36;
            if (r9 == r10) goto L_0x0221;
        L_0x020c:
            r8 = com.tencent.mm.ap.o.PC();
            r0 = r28;
            r9 = r0.field_imgPath;
            r10 = r27.getContext();
            r10 = com.tencent.mm.bu.a.getDensity(r10);
            r11 = 0;
            r8 = r8.a(r9, r10, r11);
        L_0x0221:
            if (r8 == 0) goto L_0x03e8;
        L_0x0223:
            r9 = r8.isRecycled();
            if (r9 != 0) goto L_0x03e8;
        L_0x0229:
            r0 = r20;
            r9 = r0.yRA;
            r9.setImageBitmap(r8);
        L_0x0230:
            r0 = r21;
            r9 = r0.type;
            r10 = 3;
            if (r9 != r10) goto L_0x024d;
        L_0x0237:
            r0 = r20;
            r9 = r0.yRU;
            r9 = r9.getViewTreeObserver();
            r10 = new com.tencent.mm.ui.chatting.viewitems.c$e$1;
            r0 = r24;
            r1 = r20;
            r2 = r27;
            r10.<init>(r1, r2, r8);
            r9.addOnPreDrawListener(r10);
        L_0x024d:
            r22 = r7;
        L_0x024f:
            r23 = 0;
            r0 = r20;
            r7 = r0.yRK;
            r8 = 0;
            r7.setOnClickListener(r8);
            r0 = r21;
            r7 = r0.type;
            switch(r7) {
                case 0: goto L_0x0cd2;
                case 1: goto L_0x0260;
                case 2: goto L_0x0260;
                case 3: goto L_0x0400;
                case 4: goto L_0x05e9;
                case 5: goto L_0x079b;
                case 6: goto L_0x0538;
                case 7: goto L_0x0a6b;
                case 8: goto L_0x0260;
                case 9: goto L_0x0260;
                case 10: goto L_0x0b23;
                case 11: goto L_0x0260;
                case 12: goto L_0x0260;
                case 13: goto L_0x0bde;
                case 14: goto L_0x0260;
                case 15: goto L_0x0d53;
                case 16: goto L_0x1060;
                case 17: goto L_0x0260;
                case 18: goto L_0x0260;
                case 19: goto L_0x11d8;
                case 20: goto L_0x0c54;
                case 21: goto L_0x0260;
                case 22: goto L_0x0260;
                case 23: goto L_0x0260;
                case 24: goto L_0x10f7;
                case 25: goto L_0x0e1a;
                case 26: goto L_0x0ef0;
                case 27: goto L_0x0ef0;
                case 28: goto L_0x0260;
                case 29: goto L_0x0260;
                case 30: goto L_0x0260;
                case 31: goto L_0x0260;
                case 32: goto L_0x0260;
                case 33: goto L_0x08b8;
                case 34: goto L_0x122b;
                case 35: goto L_0x0260;
                case 36: goto L_0x0677;
                case 37: goto L_0x0260;
                case 38: goto L_0x0260;
                case 39: goto L_0x0260;
                case 40: goto L_0x13e6;
                default: goto L_0x0260;
            };
        L_0x0260:
            r7 = 1;
            r12 = r6;
            r6 = r7;
        L_0x0263:
            if (r6 == 0) goto L_0x1454;
        L_0x0265:
            r0 = r21;
            r6 = r0.title;
            if (r6 == 0) goto L_0x13fc;
        L_0x026b:
            r0 = r21;
            r6 = r0.title;
            r6 = r6.length();
            if (r6 <= 0) goto L_0x13fc;
        L_0x0275:
            r0 = r20;
            r6 = r0.ntj;
            r7 = 0;
            r6.setVisibility(r7);
            r0 = r20;
            r6 = r0.ntj;
            r7 = 2;
            r6.setMaxLines(r7);
            r0 = r20;
            r6 = r0.ntj;
            r0 = r21;
            r7 = r0.title;
            r6.setText(r7);
        L_0x0290:
            r0 = r20;
            r6 = r0.ikL;
            r7 = 8;
            r6.setVisibility(r7);
            if (r22 == 0) goto L_0x1454;
        L_0x029b:
            r0 = r21;
            r6 = r0.type;
            r7 = 33;
            if (r6 == r7) goto L_0x02ab;
        L_0x02a3:
            r0 = r21;
            r6 = r0.type;
            r7 = 36;
            if (r6 != r7) goto L_0x1407;
        L_0x02ab:
            r6 = com.tencent.mm.ap.o.PC();
            r0 = r28;
            r7 = r0.field_imgPath;
            r8 = r6.lq(r7);
            r0 = r20;
            r6 = r0.yRA;
            r7 = com.tencent.mm.R.k.dvO;
            r6.setImageResource(r7);
            r6 = com.tencent.mm.modelappbrand.a.b.Jp();
            r0 = r20;
            r7 = r0.yRA;
            r9 = new java.lang.StringBuilder;
            r10 = "file://";
            r9.<init>(r10);
            r8 = r9.append(r8);
            r8 = r8.toString();
            r9 = 0;
            r10 = 0;
            r11 = com.tencent.mm.modelappbrand.g.class;
            r11 = com.tencent.mm.kernel.g.h(r11);
            r11 = (com.tencent.mm.modelappbrand.g) r11;
            r13 = 50;
            r14 = 50;
            r11 = r11.aZ(r13, r14);
            r6.a(r7, r8, r9, r10, r11);
            r6 = r12;
        L_0x02ee:
            if (r15 != 0) goto L_0x0306;
        L_0x02f0:
            r0 = r20;
            r7 = r0.yRT;
            r7.setTag(r6);
            r0 = r20;
            r6 = r0.yRT;
            r0 = r24;
            r1 = r27;
            r7 = r0.t(r1);
            r6.setOnClickListener(r7);
        L_0x0306:
            r0 = r24;
            r6 = r0.vGb;
            if (r6 == 0) goto L_0x0328;
        L_0x030c:
            r0 = r20;
            r6 = r0.yRT;
            r0 = r24;
            r1 = r27;
            r7 = r0.s(r1);
            r6.setOnLongClickListener(r7);
            r0 = r20;
            r6 = r0.yRT;
            r0 = r27;
            r7 = r0.yAM;
            r7 = r7.yBC;
            r6.setOnTouchListener(r7);
        L_0x0328:
            r0 = r27;
            r6 = r0.yAM;
            r10 = r6.hnt;
            r0 = r27;
            r11 = r0.yxU;
            r6 = r24;
            r7 = r26;
            r8 = r20;
            r9 = r28;
            r12 = r27;
            r6.a(r7, r8, r9, r10, r11, r12);
            return;
        L_0x0340:
            r7 = r9.field_appName;
            goto L_0x0153;
        L_0x0344:
            r0 = r20;
            r7 = r0.mDG;
            r0 = r21;
            r8 = r0.appId;
            r0 = r27;
            com.tencent.mm.ui.chatting.viewitems.b.a(r0, r7, r8);
            goto L_0x01df;
        L_0x0353:
            r0 = r21;
            r7 = r0.type;
            r8 = 24;
            if (r7 != r8) goto L_0x0387;
        L_0x035b:
            r0 = r20;
            r7 = r0.mDG;
            r8 = com.tencent.mm.sdk.platformtools.ad.getContext();
            r9 = com.tencent.mm.R.l.eeR;
            r8 = r8.getString(r9);
            r7.setText(r8);
            r0 = r20;
            r7 = r0.yRE;
            r8 = 0;
            r7.setVisibility(r8);
            r0 = r20;
            r7 = r0.mDG;
            r8 = 0;
            r7.setVisibility(r8);
            r0 = r20;
            r7 = r0.yRB;
            r8 = 8;
            r7.setVisibility(r8);
            goto L_0x01ec;
        L_0x0387:
            r0 = r21;
            r7 = r0.type;
            r8 = 19;
            if (r7 == r8) goto L_0x0395;
        L_0x038f:
            r7 = r14.hfL;
            r8 = 19;
            if (r7 != r8) goto L_0x03c1;
        L_0x0395:
            r0 = r20;
            r7 = r0.mDG;
            r8 = com.tencent.mm.sdk.platformtools.ad.getContext();
            r9 = com.tencent.mm.R.l.dRH;
            r8 = r8.getString(r9);
            r7.setText(r8);
            r0 = r20;
            r7 = r0.yRE;
            r8 = 0;
            r7.setVisibility(r8);
            r0 = r20;
            r7 = r0.mDG;
            r8 = 0;
            r7.setVisibility(r8);
            r0 = r20;
            r7 = r0.yRB;
            r8 = 8;
            r7.setVisibility(r8);
            goto L_0x01ec;
        L_0x03c1:
            r0 = r21;
            r1 = r20;
            r7 = com.tencent.mm.ui.chatting.viewitems.c.a(r0, r1);
            if (r7 != 0) goto L_0x01ec;
        L_0x03cb:
            r0 = r20;
            r7 = r0.yRE;
            r8 = 8;
            r7.setVisibility(r8);
            r0 = r20;
            r7 = r0.mDG;
            r8 = 8;
            r7.setVisibility(r8);
            r0 = r20;
            r7 = r0.yRB;
            r8 = 8;
            r7.setVisibility(r8);
            goto L_0x01ec;
        L_0x03e8:
            r7 = 1;
            goto L_0x0230;
        L_0x03eb:
            r0 = r20;
            r8 = r0.yRA;
            r9 = r27.getResources();
            r10 = com.tencent.mm.R.g.bEi;
            r9 = android.graphics.BitmapFactory.decodeResource(r9, r10);
            r8.setImageBitmap(r9);
            r22 = r7;
            goto L_0x024f;
        L_0x0400:
            r0 = r21;
            r7 = r0.title;
            if (r7 == 0) goto L_0x04f8;
        L_0x0406:
            r0 = r21;
            r7 = r0.title;
            r7 = r7.length();
            if (r7 <= 0) goto L_0x04f8;
        L_0x0410:
            r0 = r20;
            r7 = r0.ikL;
            r8 = 0;
            r7.setVisibility(r8);
            r0 = r20;
            r7 = r0.ikL;
            r8 = r27.getContext();
            r8 = r8.getResources();
            r9 = com.tencent.mm.R.e.white;
            r8 = r8.getColor(r9);
            r7.setTextColor(r8);
        L_0x042d:
            r0 = r20;
            r7 = r0.ikM;
            r8 = 0;
            r7.setVisibility(r8);
            r0 = r20;
            r7 = r0.ikM;
            r8 = r27.getContext();
            r8 = r8.getResources();
            r9 = com.tencent.mm.R.e.white;
            r8 = r8.getColor(r9);
            r7.setTextColor(r8);
            r0 = r20;
            r7 = r0.ntj;
            r8 = 8;
            r7.setVisibility(r8);
            r0 = r20;
            r7 = r0.yRF;
            r8 = 4;
            r7.setVisibility(r8);
            r0 = r20;
            r7 = r0.ikM;
            r8 = 2;
            r7.setMaxLines(r8);
            r0 = r20;
            r7 = r0.yRK;
            r8 = 0;
            r7.setVisibility(r8);
            r7 = new java.lang.StringBuilder;
            r7.<init>();
            r0 = r28;
            r8 = r0.field_msgId;
            r7 = r7.append(r8);
            r7 = r7.toString();
            r0 = r25;
            r8 = r0.yRp;
            r7 = r7.equals(r8);
            if (r7 == 0) goto L_0x0503;
        L_0x0486:
            r0 = r20;
            r7 = r0.yRK;
            r8 = com.tencent.mm.R.g.bDS;
            r7.setImageResource(r8);
        L_0x048f:
            r7 = new com.tencent.mm.ui.chatting.viewitems.c$f;
            r7.<init>();
            r0 = r28;
            r8 = r0.field_msgId;
            r7.frh = r8;
            r0 = r28;
            r8 = r0.field_content;
            r7.fDn = r8;
            r0 = r28;
            r8 = r0.field_imgPath;
            r7.fAn = r8;
            r0 = r20;
            r8 = r0.yRK;
            r8.setTag(r7);
            r0 = r20;
            r7 = r0.yRK;
            r0 = r27;
            r8 = r0.yAM;
            r8 = r8.yBH;
            r7.setOnClickListener(r8);
            if (r22 == 0) goto L_0x04de;
        L_0x04bc:
            r0 = r21;
            r7 = r0.appId;
            r8 = 1;
            r9 = r27.getContext();
            r9 = com.tencent.mm.bu.a.getDensity(r9);
            r7 = com.tencent.mm.pluginsdk.model.app.g.b(r7, r8, r9);
            if (r7 == 0) goto L_0x04d5;
        L_0x04cf:
            r8 = r7.isRecycled();
            if (r8 == 0) goto L_0x050d;
        L_0x04d5:
            r0 = r20;
            r7 = r0.yRA;
            r8 = com.tencent.mm.R.k.dvy;
            r7.setImageResource(r8);
        L_0x04de:
            r7 = com.tencent.mm.ui.chatting.viewitems.b.cwm();
            if (r7 == 0) goto L_0x0515;
        L_0x04e4:
            r0 = r20;
            r7 = r0.pyj;
            if (r7 == 0) goto L_0x1457;
        L_0x04ea:
            r0 = r20;
            r7 = r0.pyj;
            r8 = 8;
            r7.setVisibility(r8);
            r12 = r6;
            r6 = r23;
            goto L_0x0263;
        L_0x04f8:
            r0 = r20;
            r7 = r0.ikL;
            r8 = 8;
            r7.setVisibility(r8);
            goto L_0x042d;
        L_0x0503:
            r0 = r20;
            r7 = r0.yRK;
            r8 = com.tencent.mm.R.g.bDT;
            r7.setImageResource(r8);
            goto L_0x048f;
        L_0x050d:
            r0 = r20;
            r8 = r0.yRA;
            r8.setImageBitmap(r7);
            goto L_0x04de;
        L_0x0515:
            r0 = r20;
            r7 = r0.pyj;
            if (r7 == 0) goto L_0x1457;
        L_0x051b:
            r0 = r20;
            r7 = r0.pyj;
            r8 = 0;
            r7.setVisibility(r8);
            r0 = r28;
            r7 = r0.field_status;
            r8 = 2;
            if (r7 < r8) goto L_0x1457;
        L_0x052a:
            r0 = r20;
            r7 = r0.pyj;
            r8 = 8;
            r7.setVisibility(r8);
            r12 = r6;
            r6 = r23;
            goto L_0x0263;
        L_0x0538:
            r0 = r21;
            r7 = r0.title;
            if (r7 == 0) goto L_0x05cb;
        L_0x053e:
            r0 = r21;
            r7 = r0.title;
            r7 = r7.length();
            if (r7 <= 0) goto L_0x05cb;
        L_0x0548:
            r0 = r20;
            r7 = r0.ikL;
            r8 = 0;
            r7.setVisibility(r8);
            r0 = r20;
            r7 = r0.ikL;
            r8 = 2;
            r7.setMaxLines(r8);
        L_0x0558:
            r0 = r20;
            r7 = r0.ikM;
            r8 = 0;
            r7.setVisibility(r8);
            r0 = r20;
            r7 = r0.ntj;
            r8 = 8;
            r7.setVisibility(r8);
            r0 = r20;
            r7 = r0.yRF;
            r8 = 4;
            r7.setVisibility(r8);
            r0 = r20;
            r7 = r0.ikM;
            r8 = 2;
            r7.setMaxLines(r8);
            r0 = r20;
            r7 = r0.ikM;
            r0 = r21;
            r8 = r0.hcM;
            r8 = (long) r8;
            r8 = com.tencent.mm.sdk.platformtools.bi.by(r8);
            r7.setText(r8);
            r0 = r20;
            r7 = r0.yRK;
            r8 = 8;
            r7.setVisibility(r8);
            r0 = r21;
            r7 = r0.hcM;
            r0 = r20;
            r1 = r16;
            com.tencent.mm.ui.chatting.viewitems.c.c.a(r0, r1, r7);
            r7 = 0;
            r7 = java.lang.Boolean.valueOf(r7);
            r0 = r21;
            r8 = r0.for;
            r0 = r21;
            r9 = r0.title;
            r0 = r20;
            r1 = r28;
            com.tencent.mm.ui.chatting.viewitems.c.c.a(r0, r7, r1, r8, r9);
            if (r22 == 0) goto L_0x1457;
        L_0x05b3:
            r0 = r21;
            r7 = r0.hcN;
            r7 = com.tencent.mm.sdk.platformtools.bi.WC(r7);
            if (r7 == 0) goto L_0x05d5;
        L_0x05bd:
            r0 = r20;
            r7 = r0.yRA;
            r8 = com.tencent.mm.R.g.byZ;
            r7.setImageResource(r8);
            r12 = r6;
            r6 = r23;
            goto L_0x0263;
        L_0x05cb:
            r0 = r20;
            r7 = r0.ikL;
            r8 = 8;
            r7.setVisibility(r8);
            goto L_0x0558;
        L_0x05d5:
            r0 = r20;
            r7 = r0.yRA;
            r0 = r21;
            r8 = r0.hcN;
            r8 = com.tencent.mm.pluginsdk.model.r.Sd(r8);
            r7.setImageResource(r8);
            r12 = r6;
            r6 = r23;
            goto L_0x0263;
        L_0x05e9:
            r0 = r21;
            r7 = r0.title;
            if (r7 == 0) goto L_0x0665;
        L_0x05ef:
            r0 = r21;
            r7 = r0.title;
            r7 = r7.length();
            if (r7 <= 0) goto L_0x0665;
        L_0x05f9:
            r0 = r20;
            r7 = r0.ikL;
            r8 = 0;
            r7.setVisibility(r8);
        L_0x0601:
            r0 = r20;
            r7 = r0.ikM;
            r8 = 0;
            r7.setVisibility(r8);
            r0 = r20;
            r7 = r0.ntj;
            r8 = 8;
            r7.setVisibility(r8);
            r0 = r20;
            r7 = r0.ikM;
            r8 = 2;
            r7.setMaxLines(r8);
            r0 = r20;
            r7 = r0.yRF;
            r8 = 4;
            r7.setVisibility(r8);
            r0 = r20;
            r7 = r0.yRK;
            r8 = 0;
            r7.setVisibility(r8);
            r0 = r20;
            r7 = r0.yRK;
            r8 = com.tencent.mm.R.g.bHg;
            r7.setImageResource(r8);
            if (r22 == 0) goto L_0x1457;
        L_0x0635:
            r0 = r21;
            r7 = r0.appId;
            r8 = 1;
            r9 = r27.getContext();
            r9 = com.tencent.mm.bu.a.getDensity(r9);
            r7 = com.tencent.mm.pluginsdk.model.app.g.b(r7, r8, r9);
            if (r7 == 0) goto L_0x064e;
        L_0x0648:
            r8 = r7.isRecycled();
            if (r8 == 0) goto L_0x066f;
        L_0x064e:
            r0 = r20;
            r7 = r0.yRA;
            r8 = com.tencent.mm.R.k.dvL;
            r7.setImageResource(r8);
        L_0x0657:
            r0 = r20;
            r7 = r0.yRK;
            r8 = 8;
            r7.setVisibility(r8);
            r12 = r6;
            r6 = r23;
            goto L_0x0263;
        L_0x0665:
            r0 = r20;
            r7 = r0.ikL;
            r8 = 8;
            r7.setVisibility(r8);
            goto L_0x0601;
        L_0x066f:
            r0 = r20;
            r8 = r0.yRA;
            r8.setImageBitmap(r7);
            goto L_0x0657;
        L_0x0677:
            r7 = com.tencent.mm.plugin.appbrand.n.c.class;
            r7 = com.tencent.mm.kernel.g.h(r7);
            r7 = (com.tencent.mm.plugin.appbrand.n.c) r7;
            r0 = r21;
            r8 = r0.hfi;
            r9 = r7.rf(r8);
            if (r9 == 0) goto L_0x0755;
        L_0x0689:
            r7 = r9.field_nickname;
            r8 = r7;
        L_0x068c:
            if (r9 == 0) goto L_0x075c;
        L_0x068e:
            r7 = r9.field_brandIconURL;
        L_0x0690:
            r0 = r20;
            r9 = r0.yRU;
            r10 = 8;
            r9.setVisibility(r10);
            r0 = r20;
            r9 = r0.ySh;
            r10 = 0;
            r9.setVisibility(r10);
            r0 = r20;
            r9 = r0.ySa;
            r10 = 8;
            r9.setVisibility(r10);
            r0 = r20;
            r9 = r0.ySd;
            r10 = 8;
            r9.setVisibility(r10);
            r0 = r20;
            r9 = r0.ySk;
            r0 = r21;
            r10 = r0.title;
            r9.setText(r10);
            r0 = r20;
            r9 = r0.ySd;
            r0 = r21;
            r10 = r0.description;
            r9.setText(r10);
            r0 = r20;
            r9 = r0.ySf;
            r9.setText(r8);
            r0 = r21;
            r8 = r0.hfp;
            switch(r8) {
                case 1: goto L_0x0762;
                case 2: goto L_0x076d;
                default: goto L_0x06d7;
            };
        L_0x06d7:
            r0 = r20;
            r8 = r0.ySg;
            r9 = com.tencent.mm.R.l.dEe;
            r8.setText(r9);
        L_0x06e0:
            r8 = com.tencent.mm.ap.o.PG();
            r0 = r20;
            r9 = r0.ySe;
            r0 = r24;
            r10 = r0.yPP;
            r8.a(r7, r9, r10);
            r7 = com.tencent.mm.ap.o.PC();
            r0 = r28;
            r8 = r0.field_imgPath;
            r9 = r7.lq(r8);
            r0 = r20;
            r7 = r0.ySi;
            r8 = 0;
            r7.setImageBitmap(r8);
            r7 = com.tencent.mm.modelappbrand.a.b.Jp();
            r0 = r20;
            r8 = r0.ySi;
            r10 = new java.lang.StringBuilder;
            r11 = "file://";
            r10.<init>(r11);
            r9 = r10.append(r9);
            r9 = r9.toString();
            r10 = 0;
            r11 = 0;
            r12 = com.tencent.mm.modelappbrand.g.class;
            r12 = com.tencent.mm.kernel.g.h(r12);
            r12 = (com.tencent.mm.modelappbrand.g) r12;
            r13 = 240; // 0xf0 float:3.36E-43 double:1.186E-321;
            r14 = 192; // 0xc0 float:2.69E-43 double:9.5E-322;
            r12 = r12.aZ(r13, r14);
            r7.a(r8, r9, r10, r11, r12);
            r7 = com.tencent.mm.ui.chatting.viewitems.b.cwm();
            if (r7 == 0) goto L_0x0778;
        L_0x0736:
            r0 = r27;
            r7 = r0.yAM;
            r0 = r20;
            r1 = r28;
            a(r0, r7, r1);
            r0 = r20;
            r7 = r0.pyj;
            if (r7 == 0) goto L_0x1457;
        L_0x0747:
            r0 = r20;
            r7 = r0.pyj;
            r8 = 8;
            r7.setVisibility(r8);
            r12 = r6;
            r6 = r23;
            goto L_0x0263;
        L_0x0755:
            r0 = r21;
            r7 = r0.fHv;
            r8 = r7;
            goto L_0x068c;
        L_0x075c:
            r0 = r21;
            r7 = r0.hfr;
            goto L_0x0690;
        L_0x0762:
            r0 = r20;
            r8 = r0.ySg;
            r9 = com.tencent.mm.R.l.dEw;
            r8.setText(r9);
            goto L_0x06e0;
        L_0x076d:
            r0 = r20;
            r8 = r0.ySg;
            r9 = com.tencent.mm.R.l.dEv;
            r8.setText(r9);
            goto L_0x06e0;
        L_0x0778:
            r0 = r20;
            r7 = r0.pyj;
            if (r7 == 0) goto L_0x1457;
        L_0x077e:
            r0 = r20;
            r7 = r0.pyj;
            r8 = 0;
            r7.setVisibility(r8);
            r0 = r28;
            r7 = r0.field_status;
            r8 = 2;
            if (r7 < r8) goto L_0x1457;
        L_0x078d:
            r0 = r20;
            r7 = r0.pyj;
            r8 = 8;
            r7.setVisibility(r8);
            r12 = r6;
            r6 = r23;
            goto L_0x0263;
        L_0x079b:
            r0 = r20;
            r7 = r0.ikL;
            r8 = 8;
            r7.setVisibility(r8);
            r0 = r21;
            r7 = r0.title;
            if (r7 == 0) goto L_0x0867;
        L_0x07aa:
            r0 = r21;
            r7 = r0.title;
            r7 = r7.length();
            if (r7 <= 0) goto L_0x0867;
        L_0x07b4:
            r0 = r20;
            r7 = r0.ntj;
            r8 = 2;
            r7.setMaxLines(r8);
            r0 = r20;
            r7 = r0.ntj;
            r8 = 0;
            r7.setVisibility(r8);
            r0 = r20;
            r7 = r0.ntj;
            r0 = r21;
            r8 = r0.title;
            r7.setText(r8);
        L_0x07cf:
            r0 = r20;
            r7 = r0.ikM;
            r8 = 3;
            r7.setMaxLines(r8);
            r0 = r20;
            r7 = r0.yRF;
            r8 = 4;
            r7.setVisibility(r8);
            r7 = com.tencent.mm.ui.chatting.viewitems.c.h(r21);
            if (r7 == 0) goto L_0x0872;
        L_0x07e5:
            r0 = r20;
            r7 = r0.yRK;
            r8 = com.tencent.mm.R.g.bHg;
            r7.setImageResource(r8);
            r0 = r20;
            r7 = r0.yRK;
            r8 = 0;
            r7.setVisibility(r8);
        L_0x07f6:
            if (r22 == 0) goto L_0x0842;
        L_0x07f8:
            r0 = r21;
            r7 = r0.appId;
            r8 = 1;
            r9 = r27.getContext();
            r9 = com.tencent.mm.bu.a.getDensity(r9);
            r7 = com.tencent.mm.pluginsdk.model.app.g.b(r7, r8, r9);
            if (r7 != 0) goto L_0x087d;
        L_0x080b:
            r7 = new com.tencent.mm.ap.a.a.c$a;
            r7.<init>();
            r8 = com.tencent.mm.R.k.dvO;
            r7.hFA = r8;
            r8 = com.tencent.mm.sdk.platformtools.ad.getContext();
            r9 = 50;
            r8 = com.tencent.mm.bu.a.fromDPToPix(r8, r9);
            r9 = com.tencent.mm.sdk.platformtools.ad.getContext();
            r10 = 50;
            r9 = com.tencent.mm.bu.a.fromDPToPix(r9, r10);
            r8 = r7.bc(r8, r9);
            r9 = 1;
            r8.hFj = r9;
            r8 = com.tencent.mm.ap.o.PG();
            r0 = r21;
            r9 = r0.thumburl;
            r0 = r20;
            r10 = r0.yRA;
            r7 = r7.PQ();
            r8.a(r9, r10, r7);
        L_0x0842:
            r7 = com.tencent.mm.ui.chatting.viewitems.b.cwm();
            if (r7 == 0) goto L_0x0895;
        L_0x0848:
            r0 = r27;
            r7 = r0.yAM;
            r0 = r20;
            r1 = r28;
            a(r0, r7, r1);
            r0 = r20;
            r7 = r0.pyj;
            if (r7 == 0) goto L_0x1457;
        L_0x0859:
            r0 = r20;
            r7 = r0.pyj;
            r8 = 8;
            r7.setVisibility(r8);
            r12 = r6;
            r6 = r23;
            goto L_0x0263;
        L_0x0867:
            r0 = r20;
            r7 = r0.ntj;
            r8 = 8;
            r7.setVisibility(r8);
            goto L_0x07cf;
        L_0x0872:
            r0 = r20;
            r7 = r0.yRK;
            r8 = 8;
            r7.setVisibility(r8);
            goto L_0x07f6;
        L_0x087d:
            r8 = r7.isRecycled();
            if (r8 == 0) goto L_0x088d;
        L_0x0883:
            r0 = r20;
            r7 = r0.yRA;
            r8 = com.tencent.mm.R.k.dvO;
            r7.setImageResource(r8);
            goto L_0x0842;
        L_0x088d:
            r0 = r20;
            r8 = r0.yRA;
            r8.setImageBitmap(r7);
            goto L_0x0842;
        L_0x0895:
            r0 = r20;
            r7 = r0.pyj;
            if (r7 == 0) goto L_0x1457;
        L_0x089b:
            r0 = r20;
            r7 = r0.pyj;
            r8 = 0;
            r7.setVisibility(r8);
            r0 = r28;
            r7 = r0.field_status;
            r8 = 2;
            if (r7 < r8) goto L_0x1457;
        L_0x08aa:
            r0 = r20;
            r7 = r0.pyj;
            r8 = 8;
            r7.setVisibility(r8);
            r12 = r6;
            r6 = r23;
            goto L_0x0263;
        L_0x08b8:
            r7 = com.tencent.mm.plugin.appbrand.n.c.class;
            r7 = com.tencent.mm.kernel.g.h(r7);
            r7 = (com.tencent.mm.plugin.appbrand.n.c) r7;
            r0 = r21;
            r8 = r0.hfi;
            r9 = r7.rf(r8);
            r0 = r21;
            r7 = r0.hfk;
            switch(r7) {
                case 1: goto L_0x09cb;
                case 2: goto L_0x08f9;
                case 3: goto L_0x08f9;
                default: goto L_0x08cf;
            };
        L_0x08cf:
            r23 = 1;
            r7 = r23;
        L_0x08d3:
            if (r7 != 0) goto L_0x145c;
        L_0x08d5:
            r8 = com.tencent.mm.ui.chatting.viewitems.b.cwm();
            if (r8 == 0) goto L_0x0a49;
        L_0x08db:
            r0 = r27;
            r8 = r0.yAM;
            r0 = r20;
            r1 = r28;
            a(r0, r8, r1);
            r0 = r20;
            r8 = r0.pyj;
            if (r8 == 0) goto L_0x145c;
        L_0x08ec:
            r0 = r20;
            r8 = r0.pyj;
            r9 = 8;
            r8.setVisibility(r9);
            r12 = r6;
            r6 = r7;
            goto L_0x0263;
        L_0x08f9:
            if (r9 == 0) goto L_0x09aa;
        L_0x08fb:
            r7 = r9.field_nickname;
            r8 = r7;
        L_0x08fe:
            if (r9 == 0) goto L_0x09b1;
        L_0x0900:
            r7 = r9.field_brandIconURL;
        L_0x0902:
            r0 = r20;
            r9 = r0.yRU;
            r10 = 8;
            r9.setVisibility(r10);
            r0 = r20;
            r9 = r0.ySh;
            r10 = 0;
            r9.setVisibility(r10);
            r0 = r20;
            r9 = r0.ySa;
            r10 = 8;
            r9.setVisibility(r10);
            r0 = r20;
            r9 = r0.ySd;
            r10 = 8;
            r9.setVisibility(r10);
            r0 = r20;
            r9 = r0.ySk;
            r0 = r21;
            r10 = r0.title;
            r9.setText(r10);
            r0 = r20;
            r9 = r0.ySd;
            r0 = r21;
            r10 = r0.description;
            r9.setText(r10);
            r0 = r20;
            r9 = r0.ySf;
            r9.setText(r8);
            r0 = r21;
            r8 = r0.hfp;
            switch(r8) {
                case 1: goto L_0x09b7;
                case 2: goto L_0x09c1;
                default: goto L_0x0949;
            };
        L_0x0949:
            r0 = r20;
            r8 = r0.ySg;
            r9 = com.tencent.mm.R.l.dEe;
            r8.setText(r9);
        L_0x0952:
            r8 = com.tencent.mm.ap.o.PG();
            r0 = r20;
            r9 = r0.ySe;
            r0 = r24;
            r10 = r0.yPP;
            r8.a(r7, r9, r10);
            r7 = com.tencent.mm.ap.o.PC();
            r0 = r28;
            r8 = r0.field_imgPath;
            r7 = r7.lq(r8);
            r0 = r20;
            r8 = r0.ySi;
            r9 = 0;
            r8.setImageBitmap(r9);
            r8 = com.tencent.mm.modelappbrand.a.b.Jp();
            r9 = new com.tencent.mm.ui.chatting.viewitems.c$e$2;
            r0 = r24;
            r1 = r20;
            r9.<init>(r1);
            r10 = new java.lang.StringBuilder;
            r11 = "file://";
            r10.<init>(r11);
            r7 = r10.append(r7);
            r10 = r7.toString();
            r11 = 0;
            r7 = com.tencent.mm.modelappbrand.g.class;
            r7 = com.tencent.mm.kernel.g.h(r7);
            r7 = (com.tencent.mm.modelappbrand.g) r7;
            r12 = 240; // 0xf0 float:3.36E-43 double:1.186E-321;
            r13 = 192; // 0xc0 float:2.69E-43 double:9.5E-322;
            r7 = r7.aZ(r12, r13);
            r8.a(r9, r10, r11, r7);
            r7 = r23;
            goto L_0x08d3;
        L_0x09aa:
            r0 = r21;
            r7 = r0.fHv;
            r8 = r7;
            goto L_0x08fe;
        L_0x09b1:
            r0 = r21;
            r7 = r0.hfr;
            goto L_0x0902;
        L_0x09b7:
            r0 = r20;
            r8 = r0.ySg;
            r9 = com.tencent.mm.R.l.dEw;
            r8.setText(r9);
            goto L_0x0952;
        L_0x09c1:
            r0 = r20;
            r8 = r0.ySg;
            r9 = com.tencent.mm.R.l.dEv;
            r8.setText(r9);
            goto L_0x0952;
        L_0x09cb:
            if (r9 == 0) goto L_0x0a2c;
        L_0x09cd:
            r7 = r9.field_nickname;
            r8 = r7;
        L_0x09d0:
            if (r9 == 0) goto L_0x0a32;
        L_0x09d2:
            r7 = r9.field_brandIconURL;
        L_0x09d4:
            r0 = r20;
            r9 = r0.yRU;
            r10 = 8;
            r9.setVisibility(r10);
            r0 = r20;
            r9 = r0.ySh;
            r10 = 8;
            r9.setVisibility(r10);
            r0 = r20;
            r9 = r0.ySa;
            r10 = 0;
            r9.setVisibility(r10);
            r0 = r20;
            r9 = r0.ySc;
            r9.setText(r8);
            r8 = com.tencent.mm.sdk.platformtools.bi.oN(r7);
            if (r8 == 0) goto L_0x0a34;
        L_0x09fb:
            r7 = com.tencent.mm.ap.o.PC();
            r0 = r28;
            r8 = r0.field_imgPath;
            r7 = r7.lq(r8);
            r8 = com.tencent.mm.modelappbrand.a.b.Jp();
            r0 = r20;
            r9 = r0.ySb;
            r10 = new java.lang.StringBuilder;
            r11 = "file://";
            r10.<init>(r11);
            r7 = r10.append(r7);
            r7 = r7.toString();
            r10 = com.tencent.mm.modelappbrand.a.a.Jo();
            r11 = com.tencent.mm.modelappbrand.a.f.hmb;
            r8.a(r9, r7, r10, r11);
            r7 = r23;
            goto L_0x08d3;
        L_0x0a2c:
            r0 = r21;
            r7 = r0.title;
            r8 = r7;
            goto L_0x09d0;
        L_0x0a32:
            r7 = 0;
            goto L_0x09d4;
        L_0x0a34:
            r8 = com.tencent.mm.modelappbrand.a.b.Jp();
            r0 = r20;
            r9 = r0.ySb;
            r10 = com.tencent.mm.modelappbrand.a.a.Jo();
            r11 = com.tencent.mm.modelappbrand.a.f.hmb;
            r8.a(r9, r7, r10, r11);
            r7 = r23;
            goto L_0x08d3;
        L_0x0a49:
            r0 = r20;
            r8 = r0.pyj;
            if (r8 == 0) goto L_0x145c;
        L_0x0a4f:
            r0 = r20;
            r8 = r0.pyj;
            r9 = 0;
            r8.setVisibility(r9);
            r0 = r28;
            r8 = r0.field_status;
            r9 = 2;
            if (r8 < r9) goto L_0x145c;
        L_0x0a5e:
            r0 = r20;
            r8 = r0.pyj;
            r9 = 8;
            r8.setVisibility(r9);
            r12 = r6;
            r6 = r7;
            goto L_0x0263;
        L_0x0a6b:
            r0 = r20;
            r7 = r0.ikL;
            r8 = 8;
            r7.setVisibility(r8);
            r0 = r21;
            r7 = r0.title;
            if (r7 == 0) goto L_0x0aee;
        L_0x0a7a:
            r0 = r21;
            r7 = r0.title;
            r7 = r7.length();
            if (r7 <= 0) goto L_0x0aee;
        L_0x0a84:
            r0 = r20;
            r7 = r0.ntj;
            r8 = 0;
            r7.setVisibility(r8);
            r0 = r20;
            r7 = r0.ntj;
            r0 = r21;
            r8 = r0.title;
            r7.setText(r8);
        L_0x0a97:
            r0 = r20;
            r7 = r0.ikM;
            r8 = 3;
            r7.setMaxLines(r8);
            r0 = r20;
            r7 = r0.yRF;
            r8 = 0;
            r7.setVisibility(r8);
            r0 = r20;
            r7 = r0.yRK;
            r8 = 8;
            r7.setVisibility(r8);
            if (r22 == 0) goto L_0x0ad4;
        L_0x0ab2:
            r0 = r21;
            r7 = r0.appId;
            r8 = 1;
            r9 = r27.getContext();
            r9 = com.tencent.mm.bu.a.getDensity(r9);
            r7 = com.tencent.mm.pluginsdk.model.app.g.b(r7, r8, r9);
            if (r7 == 0) goto L_0x0acb;
        L_0x0ac5:
            r8 = r7.isRecycled();
            if (r8 == 0) goto L_0x0af8;
        L_0x0acb:
            r0 = r20;
            r7 = r0.yRA;
            r8 = com.tencent.mm.R.k.dvO;
            r7.setImageResource(r8);
        L_0x0ad4:
            r7 = com.tencent.mm.ui.chatting.viewitems.b.cwm();
            if (r7 == 0) goto L_0x0b00;
        L_0x0ada:
            r0 = r20;
            r7 = r0.pyj;
            if (r7 == 0) goto L_0x1457;
        L_0x0ae0:
            r0 = r20;
            r7 = r0.pyj;
            r8 = 8;
            r7.setVisibility(r8);
            r12 = r6;
            r6 = r23;
            goto L_0x0263;
        L_0x0aee:
            r0 = r20;
            r7 = r0.ntj;
            r8 = 8;
            r7.setVisibility(r8);
            goto L_0x0a97;
        L_0x0af8:
            r0 = r20;
            r8 = r0.yRA;
            r8.setImageBitmap(r7);
            goto L_0x0ad4;
        L_0x0b00:
            r0 = r20;
            r7 = r0.pyj;
            if (r7 == 0) goto L_0x1457;
        L_0x0b06:
            r0 = r20;
            r7 = r0.pyj;
            r8 = 0;
            r7.setVisibility(r8);
            r0 = r28;
            r7 = r0.field_status;
            r8 = 2;
            if (r7 < r8) goto L_0x1457;
        L_0x0b15:
            r0 = r20;
            r7 = r0.pyj;
            r8 = 8;
            r7.setVisibility(r8);
            r12 = r6;
            r6 = r23;
            goto L_0x0263;
        L_0x0b23:
            r0 = r20;
            r7 = r0.ntj;
            r8 = 0;
            r7.setVisibility(r8);
            r0 = r21;
            r7 = r0.hdh;
            r8 = 1;
            if (r7 != r8) goto L_0x0ba2;
        L_0x0b32:
            r0 = r20;
            r7 = r0.ntj;
            r8 = com.tencent.mm.R.l.eIh;
            r7.setText(r8);
        L_0x0b3b:
            r0 = r21;
            r7 = r0.title;
            if (r7 == 0) goto L_0x0b5e;
        L_0x0b41:
            r0 = r21;
            r7 = r0.title;
            r7 = r7.length();
            if (r7 <= 0) goto L_0x0b5e;
        L_0x0b4b:
            r0 = r20;
            r7 = r0.ikL;
            r8 = 0;
            r7.setVisibility(r8);
            r0 = r20;
            r7 = r0.ikL;
            r0 = r21;
            r8 = r0.title;
            r7.setText(r8);
        L_0x0b5e:
            r0 = r20;
            r7 = r0.ikM;
            r8 = 4;
            r7.setMaxLines(r8);
            r0 = r20;
            r7 = r0.yRF;
            r8 = 4;
            r7.setVisibility(r8);
            r0 = r20;
            r7 = r0.yRK;
            r8 = 8;
            r7.setVisibility(r8);
            if (r22 == 0) goto L_0x1457;
        L_0x0b79:
            r7 = com.tencent.mm.ap.o.PC();
            r0 = r28;
            r8 = r0.field_imgPath;
            r9 = r27.getContext();
            r9 = com.tencent.mm.bu.a.getDensity(r9);
            r10 = 0;
            r7 = r7.b(r8, r9, r10);
            if (r7 == 0) goto L_0x0bd0;
        L_0x0b90:
            r8 = r7.isRecycled();
            if (r8 != 0) goto L_0x0bd0;
        L_0x0b96:
            r0 = r20;
            r8 = r0.yRA;
            r8.setImageBitmap(r7);
            r12 = r6;
            r6 = r23;
            goto L_0x0263;
        L_0x0ba2:
            r0 = r21;
            r7 = r0.hdh;
            r8 = 2;
            if (r7 != r8) goto L_0x0bb3;
        L_0x0ba9:
            r0 = r20;
            r7 = r0.ntj;
            r8 = com.tencent.mm.R.l.eIj;
            r7.setText(r8);
            goto L_0x0b3b;
        L_0x0bb3:
            r0 = r21;
            r7 = r0.hdh;
            r8 = 3;
            if (r7 != r8) goto L_0x0bc5;
        L_0x0bba:
            r0 = r20;
            r7 = r0.ntj;
            r8 = com.tencent.mm.R.l.eIi;
            r7.setText(r8);
            goto L_0x0b3b;
        L_0x0bc5:
            r0 = r20;
            r7 = r0.ntj;
            r8 = com.tencent.mm.R.l.eIk;
            r7.setText(r8);
            goto L_0x0b3b;
        L_0x0bd0:
            r0 = r20;
            r7 = r0.yRA;
            r8 = com.tencent.mm.R.k.dvO;
            r7.setImageResource(r8);
            r12 = r6;
            r6 = r23;
            goto L_0x0263;
        L_0x0bde:
            r0 = r20;
            r7 = r0.ikL;
            r8 = 0;
            r7.setVisibility(r8);
            r0 = r20;
            r7 = r0.ikL;
            r0 = r21;
            r8 = r0.title;
            r7.setText(r8);
            r0 = r20;
            r7 = r0.ntj;
            r8 = 0;
            r7.setVisibility(r8);
            r0 = r20;
            r7 = r0.ntj;
            r8 = com.tencent.mm.R.l.dSn;
            r7.setText(r8);
            r0 = r20;
            r7 = r0.ikM;
            r8 = 4;
            r7.setMaxLines(r8);
            r0 = r20;
            r7 = r0.yRF;
            r8 = 4;
            r7.setVisibility(r8);
            r0 = r20;
            r7 = r0.yRK;
            r8 = 8;
            r7.setVisibility(r8);
            if (r22 == 0) goto L_0x1457;
        L_0x0c1d:
            r7 = com.tencent.mm.ap.o.PC();
            r0 = r28;
            r8 = r0.field_imgPath;
            r9 = r27.getContext();
            r9 = com.tencent.mm.bu.a.getDensity(r9);
            r10 = 0;
            r7 = r7.b(r8, r9, r10);
            if (r7 == 0) goto L_0x0c46;
        L_0x0c34:
            r8 = r7.isRecycled();
            if (r8 != 0) goto L_0x0c46;
        L_0x0c3a:
            r0 = r20;
            r8 = r0.yRA;
            r8.setImageBitmap(r7);
            r12 = r6;
            r6 = r23;
            goto L_0x0263;
        L_0x0c46:
            r0 = r20;
            r7 = r0.yRA;
            r8 = com.tencent.mm.R.k.dvO;
            r7.setImageResource(r8);
            r12 = r6;
            r6 = r23;
            goto L_0x0263;
        L_0x0c54:
            r0 = r21;
            r7 = r0.title;
            if (r7 == 0) goto L_0x0c80;
        L_0x0c5a:
            r0 = r21;
            r7 = r0.title;
            r7 = r7.length();
            if (r7 <= 0) goto L_0x0c80;
        L_0x0c64:
            r0 = r20;
            r7 = r0.ikL;
            r8 = 0;
            r7.setVisibility(r8);
            r0 = r20;
            r7 = r0.ikL;
            r0 = r21;
            r8 = r0.title;
            r7.setText(r8);
            r0 = r20;
            r7 = r0.ntj;
            r8 = 8;
            r7.setVisibility(r8);
        L_0x0c80:
            r0 = r20;
            r7 = r0.ikM;
            r8 = 4;
            r7.setMaxLines(r8);
            r0 = r20;
            r7 = r0.yRF;
            r8 = 4;
            r7.setVisibility(r8);
            r0 = r20;
            r7 = r0.yRK;
            r8 = 8;
            r7.setVisibility(r8);
            if (r22 == 0) goto L_0x1457;
        L_0x0c9b:
            r7 = com.tencent.mm.ap.o.PC();
            r0 = r28;
            r8 = r0.field_imgPath;
            r9 = r27.getContext();
            r9 = com.tencent.mm.bu.a.getDensity(r9);
            r10 = 0;
            r7 = r7.b(r8, r9, r10);
            if (r7 == 0) goto L_0x0cc4;
        L_0x0cb2:
            r8 = r7.isRecycled();
            if (r8 != 0) goto L_0x0cc4;
        L_0x0cb8:
            r0 = r20;
            r8 = r0.yRA;
            r8.setImageBitmap(r7);
            r12 = r6;
            r6 = r23;
            goto L_0x0263;
        L_0x0cc4:
            r0 = r20;
            r7 = r0.yRA;
            r8 = com.tencent.mm.R.k.dvO;
            r7.setImageResource(r8);
            r12 = r6;
            r6 = r23;
            goto L_0x0263;
        L_0x0cd2:
            r0 = r21;
            r7 = r0.title;
            if (r7 == 0) goto L_0x0d3d;
        L_0x0cd8:
            r0 = r21;
            r7 = r0.title;
            r7 = r7.length();
            if (r7 <= 0) goto L_0x0d3d;
        L_0x0ce2:
            r0 = r20;
            r7 = r0.ikL;
            r8 = 0;
            r7.setVisibility(r8);
        L_0x0cea:
            r0 = r20;
            r7 = r0.ikM;
            r8 = 0;
            r7.setVisibility(r8);
            r0 = r20;
            r7 = r0.ntj;
            r8 = 8;
            r7.setVisibility(r8);
            r0 = r20;
            r7 = r0.yRF;
            r8 = 8;
            r7.setVisibility(r8);
            r0 = r20;
            r7 = r0.yRK;
            r8 = 4;
            r7.setVisibility(r8);
            r0 = r20;
            r7 = r0.ikM;
            r8 = 2;
            r7.setMaxLines(r8);
            if (r22 == 0) goto L_0x1457;
        L_0x0d16:
            r0 = r21;
            r7 = r0.appId;
            r8 = 1;
            r9 = r27.getContext();
            r9 = com.tencent.mm.bu.a.getDensity(r9);
            r7 = com.tencent.mm.pluginsdk.model.app.g.b(r7, r8, r9);
            if (r7 == 0) goto L_0x0d2f;
        L_0x0d29:
            r8 = r7.isRecycled();
            if (r8 == 0) goto L_0x0d47;
        L_0x0d2f:
            r0 = r20;
            r7 = r0.yRA;
            r8 = com.tencent.mm.R.k.dvO;
            r7.setImageResource(r8);
            r12 = r6;
            r6 = r23;
            goto L_0x0263;
        L_0x0d3d:
            r0 = r20;
            r7 = r0.ikL;
            r8 = 8;
            r7.setVisibility(r8);
            goto L_0x0cea;
        L_0x0d47:
            r0 = r20;
            r8 = r0.yRA;
            r8.setImageBitmap(r7);
            r12 = r6;
            r6 = r23;
            goto L_0x0263;
        L_0x0d53:
            r0 = r21;
            r6 = r0.title;
            if (r6 == 0) goto L_0x0e07;
        L_0x0d59:
            r0 = r21;
            r6 = r0.title;
            r6 = r6.length();
            if (r6 <= 0) goto L_0x0e07;
        L_0x0d63:
            r0 = r20;
            r6 = r0.ikL;
            r7 = 0;
            r6.setVisibility(r7);
        L_0x0d6b:
            r0 = r20;
            r6 = r0.ikM;
            r7 = 0;
            r6.setVisibility(r7);
            r0 = r20;
            r6 = r0.ntj;
            r7 = 8;
            r6.setVisibility(r7);
            r0 = r20;
            r6 = r0.yRK;
            r7 = 8;
            r6.setVisibility(r7);
            r0 = r20;
            r6 = r0.yRF;
            r7 = 4;
            r6.setVisibility(r7);
            r0 = r20;
            r6 = r0.ikM;
            r7 = 2;
            r6.setMaxLines(r7);
            if (r22 == 0) goto L_0x0dbd;
        L_0x0d97:
            r6 = com.tencent.mm.ap.o.PC();
            r0 = r28;
            r7 = r0.field_imgPath;
            r8 = r27.getContext();
            r8 = com.tencent.mm.bu.a.getDensity(r8);
            r9 = 0;
            r6 = r6.b(r7, r8, r9);
            if (r6 == 0) goto L_0x0db4;
        L_0x0dae:
            r7 = r6.isRecycled();
            if (r7 == 0) goto L_0x0e12;
        L_0x0db4:
            r0 = r20;
            r6 = r0.yRA;
            r7 = com.tencent.mm.R.k.dvO;
            r6.setImageResource(r7);
        L_0x0dbd:
            r6 = new com.tencent.mm.ui.chatting.viewitems.ar;
            r8 = 0;
            r10 = "";
            r11 = 0;
            r12 = r27.ctL();
            r0 = r21;
            r13 = r0.fHu;
            r0 = r21;
            r14 = r0.fHv;
            r0 = r21;
            r15 = r0.title;
            r0 = r21;
            r0 = r0.hdp;
            r16 = r0;
            r0 = r21;
            r0 = r0.url;
            r17 = r0;
            r18 = 0;
            r19 = 0;
            r7 = r28;
            r9 = r26;
            r6.<init>(r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19);
            r0 = r20;
            r7 = r0.yRT;
            r7.setTag(r6);
            r0 = r20;
            r7 = r0.yRT;
            r0 = r24;
            r1 = r27;
            r8 = r0.x(r1);
            r7.setOnClickListener(r8);
            r15 = 1;
            r12 = r6;
            r6 = r23;
            goto L_0x0263;
        L_0x0e07:
            r0 = r20;
            r6 = r0.ikL;
            r7 = 8;
            r6.setVisibility(r7);
            goto L_0x0d6b;
        L_0x0e12:
            r0 = r20;
            r7 = r0.yRA;
            r7.setImageBitmap(r6);
            goto L_0x0dbd;
        L_0x0e1a:
            r0 = r21;
            r6 = r0.title;
            if (r6 == 0) goto L_0x0edd;
        L_0x0e20:
            r0 = r21;
            r6 = r0.title;
            r6 = r6.length();
            if (r6 <= 0) goto L_0x0edd;
        L_0x0e2a:
            r0 = r20;
            r6 = r0.ikL;
            r7 = 0;
            r6.setVisibility(r7);
        L_0x0e32:
            r0 = r20;
            r6 = r0.ikM;
            r7 = 0;
            r6.setVisibility(r7);
            r0 = r20;
            r6 = r0.ntj;
            r7 = 8;
            r6.setVisibility(r7);
            r0 = r20;
            r6 = r0.yRK;
            r7 = 8;
            r6.setVisibility(r7);
            r0 = r20;
            r6 = r0.yRF;
            r7 = 4;
            r6.setVisibility(r7);
            r0 = r20;
            r6 = r0.ikM;
            r7 = 2;
            r6.setMaxLines(r7);
            if (r22 == 0) goto L_0x0e84;
        L_0x0e5e:
            r6 = com.tencent.mm.ap.o.PC();
            r0 = r28;
            r7 = r0.field_imgPath;
            r8 = r27.getContext();
            r8 = com.tencent.mm.bu.a.getDensity(r8);
            r9 = 0;
            r6 = r6.b(r7, r8, r9);
            if (r6 == 0) goto L_0x0e7b;
        L_0x0e75:
            r7 = r6.isRecycled();
            if (r7 == 0) goto L_0x0ee8;
        L_0x0e7b:
            r0 = r20;
            r6 = r0.yRA;
            r7 = com.tencent.mm.R.k.dvO;
            r6.setImageResource(r7);
        L_0x0e84:
            r6 = new com.tencent.mm.ui.chatting.viewitems.ar;
            r9 = "";
            r10 = r27.ctL();
            r0 = r21;
            r11 = r0.fHu;
            r0 = r21;
            r12 = r0.fHv;
            r0 = r21;
            r13 = r0.title;
            r0 = r21;
            r14 = r0.heW;
            r0 = r21;
            r15 = r0.designerName;
            r0 = r21;
            r0 = r0.designerRediretctUrl;
            r16 = r0;
            r0 = r21;
            r0 = r0.url;
            r17 = r0;
            r7 = r28;
            r8 = r26;
            r6.<init>(r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17);
            r0 = r20;
            r7 = r0.yRT;
            r7.setTag(r6);
            r0 = r20;
            r7 = r0.yRT;
            r0 = r24;
            r8 = r0.ySp;
            if (r8 != 0) goto L_0x0ed0;
        L_0x0ec5:
            r8 = new com.tencent.mm.ui.chatting.r$h;
            r0 = r27;
            r8.<init>(r0);
            r0 = r24;
            r0.ySp = r8;
        L_0x0ed0:
            r0 = r24;
            r8 = r0.ySp;
            r7.setOnClickListener(r8);
            r15 = 1;
            r12 = r6;
            r6 = r23;
            goto L_0x0263;
        L_0x0edd:
            r0 = r20;
            r6 = r0.ikL;
            r7 = 8;
            r6.setVisibility(r7);
            goto L_0x0e32;
        L_0x0ee8:
            r0 = r20;
            r7 = r0.yRA;
            r7.setImageBitmap(r6);
            goto L_0x0e84;
        L_0x0ef0:
            r0 = r21;
            r6 = r0.title;
            if (r6 == 0) goto L_0x0fcd;
        L_0x0ef6:
            r0 = r21;
            r6 = r0.title;
            r6 = r6.length();
            if (r6 <= 0) goto L_0x0fcd;
        L_0x0f00:
            r0 = r20;
            r6 = r0.ikL;
            r7 = 0;
            r6.setVisibility(r7);
        L_0x0f08:
            r0 = r20;
            r6 = r0.ikM;
            r7 = 0;
            r6.setVisibility(r7);
            r0 = r20;
            r6 = r0.ntj;
            r7 = 8;
            r6.setVisibility(r7);
            r0 = r20;
            r6 = r0.yRK;
            r7 = 8;
            r6.setVisibility(r7);
            r0 = r20;
            r6 = r0.yRF;
            r7 = 4;
            r6.setVisibility(r7);
            r0 = r20;
            r6 = r0.ikM;
            r7 = 2;
            r6.setMaxLines(r7);
            if (r22 == 0) goto L_0x0f4d;
        L_0x0f34:
            r0 = r28;
            r6 = r0.field_imgPath;
            r6 = com.tencent.mm.sdk.platformtools.bi.oN(r6);
            if (r6 == 0) goto L_0x0fd8;
        L_0x0f3e:
            r6 = com.tencent.mm.ap.o.PG();
            r0 = r21;
            r7 = r0.thumburl;
            r0 = r20;
            r8 = r0.yRA;
            r6.a(r7, r8);
        L_0x0f4d:
            r12 = new com.tencent.mm.ui.chatting.viewitems.ar;
            r12.<init>();
            r0 = r28;
            r12.fFE = r0;
            r6 = 0;
            r12.yxU = r6;
            r0 = r26;
            r12.position = r0;
            r6 = 0;
            r12.yXv = r6;
            r6 = r27.ctL();
            r12.title = r6;
            r0 = r21;
            r6 = r0.fHu;
            r12.fHu = r6;
            r0 = r21;
            r6 = r0.fHv;
            r12.fHv = r6;
            r0 = r21;
            r6 = r0.title;
            r12.yXw = r6;
            r0 = r21;
            r6 = r0.type;
            r7 = 26;
            if (r6 != r7) goto L_0x1009;
        L_0x0f80:
            r0 = r21;
            r6 = r0.tid;
            r12.tid = r6;
            r0 = r21;
            r6 = r0.heX;
            r12.heX = r6;
            r0 = r21;
            r6 = r0.desc;
            r12.desc = r6;
            r0 = r21;
            r6 = r0.iconUrl;
            r12.iconUrl = r6;
            r0 = r21;
            r6 = r0.secondUrl;
            r12.secondUrl = r6;
            r0 = r21;
            r6 = r0.pageType;
            r12.pageType = r6;
            r0 = r20;
            r6 = r0.yRT;
            r0 = r24;
            r7 = r0.ySq;
            if (r7 != 0) goto L_0x0fb9;
        L_0x0fae:
            r7 = new com.tencent.mm.ui.chatting.r$k;
            r0 = r27;
            r7.<init>(r0);
            r0 = r24;
            r0.ySq = r7;
        L_0x0fb9:
            r0 = r24;
            r7 = r0.ySq;
            r6.setOnClickListener(r7);
            r6 = 1;
        L_0x0fc1:
            r0 = r20;
            r7 = r0.yRT;
            r7.setTag(r12);
            r15 = r6;
            r6 = r23;
            goto L_0x0263;
        L_0x0fcd:
            r0 = r20;
            r6 = r0.ikL;
            r7 = 8;
            r6.setVisibility(r7);
            goto L_0x0f08;
        L_0x0fd8:
            r6 = com.tencent.mm.ap.o.PC();
            r0 = r28;
            r7 = r0.field_imgPath;
            r8 = r27.getContext();
            r8 = com.tencent.mm.bu.a.getDensity(r8);
            r9 = 0;
            r6 = r6.b(r7, r8, r9);
            if (r6 == 0) goto L_0x0ff5;
        L_0x0fef:
            r7 = r6.isRecycled();
            if (r7 == 0) goto L_0x1000;
        L_0x0ff5:
            r0 = r20;
            r6 = r0.yRA;
            r7 = com.tencent.mm.R.k.dvO;
            r6.setImageResource(r7);
            goto L_0x0f4d;
        L_0x1000:
            r0 = r20;
            r7 = r0.yRA;
            r7.setImageBitmap(r6);
            goto L_0x0f4d;
        L_0x1009:
            r0 = r21;
            r6 = r0.type;
            r7 = 27;
            if (r6 != r7) goto L_0x1054;
        L_0x1011:
            r0 = r21;
            r6 = r0.tid;
            r12.tid = r6;
            r0 = r21;
            r6 = r0.heX;
            r12.heX = r6;
            r0 = r21;
            r6 = r0.desc;
            r12.desc = r6;
            r0 = r21;
            r6 = r0.iconUrl;
            r12.iconUrl = r6;
            r0 = r21;
            r6 = r0.secondUrl;
            r12.secondUrl = r6;
            r0 = r21;
            r6 = r0.pageType;
            r12.pageType = r6;
            r0 = r20;
            r6 = r0.yRT;
            r0 = r24;
            r7 = r0.ySr;
            if (r7 != 0) goto L_0x104a;
        L_0x103f:
            r7 = new com.tencent.mm.ui.chatting.r$i;
            r0 = r27;
            r7.<init>(r0);
            r0 = r24;
            r0.ySr = r7;
        L_0x104a:
            r0 = r24;
            r7 = r0.ySr;
            r6.setOnClickListener(r7);
            r6 = 1;
            goto L_0x0fc1;
        L_0x1054:
            r6 = "MicroMsg.ChattingItemAppMsgTo";
            r7 = "unknow view type";
            com.tencent.mm.sdk.platformtools.x.i(r6, r7);
            r6 = r15;
            goto L_0x0fc1;
        L_0x1060:
            r0 = r20;
            r7 = r0.ikL;
            r8 = 0;
            r7.setVisibility(r8);
            r0 = r20;
            r7 = r0.ikL;
            r0 = r21;
            r8 = r0.description;
            r7.setText(r8);
            r0 = r20;
            r7 = r0.ikM;
            r0 = r21;
            r8 = r0.hdV;
            r7.setText(r8);
            r0 = r21;
            r7 = r0.title;
            if (r7 == 0) goto L_0x10df;
        L_0x1084:
            r0 = r21;
            r7 = r0.title;
            r7 = r7.length();
            if (r7 <= 0) goto L_0x10df;
        L_0x108e:
            r0 = r20;
            r7 = r0.ntj;
            r8 = 0;
            r7.setVisibility(r8);
            r0 = r20;
            r7 = r0.ntj;
            r0 = r21;
            r8 = r0.title;
            r7.setText(r8);
        L_0x10a1:
            r0 = r20;
            r7 = r0.ikM;
            r8 = 4;
            r7.setMaxLines(r8);
            r0 = r20;
            r7 = r0.yRF;
            r8 = 4;
            r7.setVisibility(r8);
            r0 = r20;
            r7 = r0.yRK;
            r8 = 8;
            r7.setVisibility(r8);
            if (r22 == 0) goto L_0x1457;
        L_0x10bc:
            r7 = com.tencent.mm.ap.o.PC();
            r0 = r28;
            r8 = r0.field_imgPath;
            r9 = r27.getContext();
            r9 = com.tencent.mm.bu.a.getDensity(r9);
            r10 = 0;
            r7 = r7.b(r8, r9, r10);
            if (r7 == 0) goto L_0x10e9;
        L_0x10d3:
            r0 = r20;
            r8 = r0.yRA;
            r8.setImageBitmap(r7);
            r12 = r6;
            r6 = r23;
            goto L_0x0263;
        L_0x10df:
            r0 = r20;
            r7 = r0.ntj;
            r8 = 8;
            r7.setVisibility(r8);
            goto L_0x10a1;
        L_0x10e9:
            r0 = r20;
            r7 = r0.yRA;
            r8 = com.tencent.mm.R.k.dvO;
            r7.setImageResource(r8);
            r12 = r6;
            r6 = r23;
            goto L_0x0263;
        L_0x10f7:
            r0 = r20;
            r7 = r0.ikL;
            r8 = 8;
            r7.setVisibility(r8);
            r0 = r20;
            r7 = r0.ntj;
            r8 = 0;
            r7.setVisibility(r8);
            r0 = r21;
            r7 = r0.title;
            if (r7 == 0) goto L_0x118e;
        L_0x110e:
            r0 = r21;
            r7 = r0.title;
            r7 = r7.length();
            if (r7 <= 0) goto L_0x118e;
        L_0x1118:
            r0 = r20;
            r7 = r0.ntj;
            r0 = r20;
            r8 = r0.ntj;
            r8 = r8.getContext();
            r0 = r21;
            r9 = r0.title;
            r0 = r20;
            r10 = r0.ntj;
            r10 = r10.getTextSize();
            r10 = (int) r10;
            r8 = com.tencent.mm.pluginsdk.ui.d.i.c(r8, r9, r10);
            r7.setText(r8);
        L_0x1138:
            r0 = r20;
            r7 = r0.ikM;
            r8 = 3;
            r7.setMaxLines(r8);
            r0 = r20;
            r7 = r0.yRF;
            r8 = 4;
            r7.setVisibility(r8);
            r0 = r20;
            r7 = r0.yRK;
            r8 = 8;
            r7.setVisibility(r8);
            if (r22 == 0) goto L_0x115c;
        L_0x1153:
            r0 = r20;
            r7 = r0.yRA;
            r8 = 8;
            r7.setVisibility(r8);
        L_0x115c:
            r0 = r27;
            r1 = r20;
            r2 = r21;
            r3 = r28;
            r4 = r22;
            com.tencent.mm.ui.chatting.viewitems.c.c.a(r0, r1, r2, r3, r4);
            r7 = com.tencent.mm.ui.chatting.viewitems.b.cwm();
            if (r7 == 0) goto L_0x11b5;
        L_0x116f:
            r0 = r27;
            r7 = r0.yAM;
            r0 = r20;
            r1 = r28;
            a(r0, r7, r1);
            r0 = r20;
            r7 = r0.pyj;
            if (r7 == 0) goto L_0x1457;
        L_0x1180:
            r0 = r20;
            r7 = r0.pyj;
            r8 = 8;
            r7.setVisibility(r8);
            r12 = r6;
            r6 = r23;
            goto L_0x0263;
        L_0x118e:
            r0 = r20;
            r7 = r0.ntj;
            r0 = r20;
            r8 = r0.ntj;
            r8 = r8.getContext();
            r9 = com.tencent.mm.sdk.platformtools.ad.getContext();
            r10 = com.tencent.mm.R.l.ehj;
            r9 = r9.getString(r10);
            r0 = r20;
            r10 = r0.ntj;
            r10 = r10.getTextSize();
            r10 = (int) r10;
            r8 = com.tencent.mm.pluginsdk.ui.d.i.c(r8, r9, r10);
            r7.setText(r8);
            goto L_0x1138;
        L_0x11b5:
            r0 = r20;
            r7 = r0.pyj;
            if (r7 == 0) goto L_0x1457;
        L_0x11bb:
            r0 = r20;
            r7 = r0.pyj;
            r8 = 0;
            r7.setVisibility(r8);
            r0 = r28;
            r7 = r0.field_status;
            r8 = 2;
            if (r7 < r8) goto L_0x1457;
        L_0x11ca:
            r0 = r20;
            r7 = r0.pyj;
            r8 = 8;
            r7.setVisibility(r8);
            r12 = r6;
            r6 = r23;
            goto L_0x0263;
        L_0x11d8:
            r0 = r27;
            r1 = r20;
            r2 = r21;
            r3 = r22;
            com.tencent.mm.ui.chatting.viewitems.c.c.a(r0, r1, r2, r3);
            r7 = com.tencent.mm.ui.chatting.viewitems.b.cwm();
            if (r7 == 0) goto L_0x1208;
        L_0x11e9:
            r0 = r27;
            r7 = r0.yAM;
            r0 = r20;
            r1 = r28;
            a(r0, r7, r1);
            r0 = r20;
            r7 = r0.pyj;
            if (r7 == 0) goto L_0x1457;
        L_0x11fa:
            r0 = r20;
            r7 = r0.pyj;
            r8 = 8;
            r7.setVisibility(r8);
            r12 = r6;
            r6 = r23;
            goto L_0x0263;
        L_0x1208:
            r0 = r20;
            r7 = r0.pyj;
            if (r7 == 0) goto L_0x1457;
        L_0x120e:
            r0 = r20;
            r7 = r0.pyj;
            r8 = 0;
            r7.setVisibility(r8);
            r0 = r28;
            r7 = r0.field_status;
            r8 = 2;
            if (r7 < r8) goto L_0x1457;
        L_0x121d:
            r0 = r20;
            r7 = r0.pyj;
            r8 = 8;
            r7.setVisibility(r8);
            r12 = r6;
            r6 = r23;
            goto L_0x0263;
        L_0x122b:
            r0 = r21;
            r7 = r0.title;
            if (r7 == 0) goto L_0x1388;
        L_0x1231:
            r0 = r21;
            r7 = r0.title;
            r7 = r7.length();
            if (r7 <= 0) goto L_0x1388;
        L_0x123b:
            r0 = r20;
            r7 = r0.ikL;
            r8 = 0;
            r7.setVisibility(r8);
            r0 = r21;
            r7 = r0.hee;
            r7 = com.tencent.mm.sdk.platformtools.bi.oN(r7);
            if (r7 != 0) goto L_0x1371;
        L_0x124d:
            r0 = r21;
            r7 = r0.hee;
            r7 = com.tencent.mm.sdk.platformtools.bi.oN(r7);
            if (r7 != 0) goto L_0x135a;
        L_0x1257:
            r0 = r20;
            r7 = r0.ikL;
            r0 = r21;
            r8 = r0.hee;
            r9 = r27.getContext();
            r9 = r9.getResources();
            r10 = com.tencent.mm.R.e.black;
            r9 = r9.getColor(r10);
            r8 = com.tencent.mm.sdk.platformtools.bi.bc(r8, r9);
            r7.setTextColor(r8);
        L_0x1274:
            r0 = r20;
            r7 = r0.ikM;
            r8 = 2;
            r7.setMaxLines(r8);
            r0 = r20;
            r7 = r0.ikM;
            r8 = 0;
            r7.setVisibility(r8);
            r0 = r21;
            r7 = r0.hef;
            r7 = com.tencent.mm.sdk.platformtools.bi.oN(r7);
            if (r7 != 0) goto L_0x1393;
        L_0x128e:
            r0 = r20;
            r7 = r0.ikM;
            r0 = r21;
            r8 = r0.hef;
            r9 = r27.getContext();
            r9 = r9.getResources();
            r10 = com.tencent.mm.R.e.bsF;
            r9 = r9.getColor(r10);
            r8 = com.tencent.mm.sdk.platformtools.bi.bc(r8, r9);
            r7.setTextColor(r8);
        L_0x12ab:
            r0 = r20;
            r7 = r0.ntj;
            r8 = 8;
            r7.setVisibility(r8);
            r0 = r20;
            r7 = r0.yRF;
            r8 = 4;
            r7.setVisibility(r8);
            r0 = r20;
            r7 = r0.yRK;
            r8 = 8;
            r7.setVisibility(r8);
            r0 = r20;
            r7 = r0.yRE;
            r8 = 0;
            r7.setVisibility(r8);
            r0 = r20;
            r7 = r0.mDG;
            r8 = 0;
            r7.setVisibility(r8);
            r0 = r21;
            r7 = r0.hea;
            r7 = com.tencent.mm.sdk.platformtools.bi.oN(r7);
            if (r7 != 0) goto L_0x13aa;
        L_0x12df:
            r0 = r20;
            r7 = r0.mDG;
            r0 = r21;
            r8 = r0.hea;
            r7.setText(r8);
        L_0x12ea:
            r0 = r24;
            r7 = r0.vGb;
            if (r7 == 0) goto L_0x13d0;
        L_0x12f0:
            r7 = com.tencent.mm.ap.o.PC();
            r0 = r28;
            r8 = r0.field_imgPath;
            r9 = r27.getContext();
            r9 = com.tencent.mm.bu.a.getDensity(r9);
            r10 = 0;
            r7 = r7.a(r8, r9, r10);
            if (r7 == 0) goto L_0x1320;
        L_0x1307:
            r8 = r7.isRecycled();
            if (r8 != 0) goto L_0x1320;
        L_0x130d:
            r8 = 0;
            r9 = r7.getWidth();
            r9 = r9 / 2;
            r9 = (float) r9;
            r8 = com.tencent.mm.sdk.platformtools.d.a(r7, r8, r9);
            r0 = r20;
            r9 = r0.yRA;
            r9.setImageBitmap(r8);
        L_0x1320:
            r0 = r21;
            r8 = r0.hed;
            r8 = com.tencent.mm.sdk.platformtools.bi.oN(r8);
            if (r8 != 0) goto L_0x13b5;
        L_0x132a:
            r7 = com.tencent.mm.ap.o.PG();
            r0 = r21;
            r8 = r0.hed;
            r9 = new android.widget.ImageView;
            r10 = r27.getContext();
            r9.<init>(r10);
            r10 = new com.tencent.mm.ap.a.a.c$a;
            r10.<init>();
            r11 = 1;
            r10.hFl = r11;
            r10 = r10.PQ();
            r11 = new com.tencent.mm.ui.chatting.viewitems.c$e$3;
            r0 = r24;
            r1 = r20;
            r2 = r27;
            r11.<init>(r1, r2);
            r7.a(r8, r9, r10, r11);
            r12 = r6;
            r6 = r23;
            goto L_0x0263;
        L_0x135a:
            r0 = r20;
            r7 = r0.ikL;
            r8 = r27.getContext();
            r8 = r8.getResources();
            r9 = com.tencent.mm.R.e.black;
            r8 = r8.getColor(r9);
            r7.setTextColor(r8);
            goto L_0x1274;
        L_0x1371:
            r0 = r20;
            r7 = r0.ikL;
            r8 = r27.getContext();
            r8 = r8.getResources();
            r9 = com.tencent.mm.R.e.black;
            r8 = r8.getColor(r9);
            r7.setTextColor(r8);
            goto L_0x1274;
        L_0x1388:
            r0 = r20;
            r7 = r0.ikL;
            r8 = 8;
            r7.setVisibility(r8);
            goto L_0x1274;
        L_0x1393:
            r0 = r20;
            r7 = r0.ikM;
            r8 = r27.getContext();
            r8 = r8.getResources();
            r9 = com.tencent.mm.R.e.bsF;
            r8 = r8.getColor(r9);
            r7.setTextColor(r8);
            goto L_0x12ab;
        L_0x13aa:
            r0 = r20;
            r7 = r0.mDG;
            r8 = com.tencent.mm.R.l.dRG;
            r7.setText(r8);
            goto L_0x12ea;
        L_0x13b5:
            r0 = r20;
            r8 = r0.yRU;
            r8 = r8.getViewTreeObserver();
            r9 = new com.tencent.mm.ui.chatting.viewitems.c$e$4;
            r0 = r24;
            r1 = r20;
            r2 = r27;
            r9.<init>(r1, r2, r7);
            r8.addOnPreDrawListener(r9);
            r12 = r6;
            r6 = r23;
            goto L_0x0263;
        L_0x13d0:
            r0 = r20;
            r7 = r0.yRA;
            r8 = r27.getResources();
            r9 = com.tencent.mm.R.g.bEi;
            r8 = android.graphics.BitmapFactory.decodeResource(r8, r9);
            r7.setImageBitmap(r8);
            r12 = r6;
            r6 = r23;
            goto L_0x0263;
        L_0x13e6:
            r7 = r14.hfL;
            r8 = 19;
            if (r7 != r8) goto L_0x1457;
        L_0x13ec:
            r0 = r27;
            r1 = r20;
            r2 = r21;
            r3 = r22;
            com.tencent.mm.ui.chatting.viewitems.c.c.a(r0, r1, r2, r3);
            r12 = r6;
            r6 = r23;
            goto L_0x0263;
        L_0x13fc:
            r0 = r20;
            r6 = r0.ntj;
            r7 = 8;
            r6.setVisibility(r7);
            goto L_0x0290;
        L_0x1407:
            r6 = com.tencent.mm.ap.o.PC();
            r0 = r28;
            r7 = r0.field_imgPath;
            r8 = r27.getContext();
            r8 = com.tencent.mm.bu.a.getDensity(r8);
            r9 = 0;
            r6 = r6.b(r7, r8, r9);
            if (r6 == 0) goto L_0x1424;
        L_0x141e:
            r7 = r6.isRecycled();
            if (r7 == 0) goto L_0x1439;
        L_0x1424:
            r6 = com.tencent.mm.ap.o.PC();
            r0 = r28;
            r7 = r0.field_imgPath;
            r8 = r27.getContext();
            r8 = com.tencent.mm.bu.a.getDensity(r8);
            r9 = 0;
            r6 = r6.a(r7, r8, r9);
        L_0x1439:
            if (r6 == 0) goto L_0x144b;
        L_0x143b:
            r7 = r6.isRecycled();
            if (r7 != 0) goto L_0x144b;
        L_0x1441:
            r0 = r20;
            r7 = r0.yRA;
            r7.setImageBitmap(r6);
            r6 = r12;
            goto L_0x02ee;
        L_0x144b:
            r0 = r20;
            r6 = r0.yRA;
            r7 = com.tencent.mm.R.g.byZ;
            r6.setImageResource(r7);
        L_0x1454:
            r6 = r12;
            goto L_0x02ee;
        L_0x1457:
            r12 = r6;
            r6 = r23;
            goto L_0x0263;
        L_0x145c:
            r12 = r6;
            r6 = r7;
            goto L_0x0263;
        L_0x1460:
            r14 = r6;
            r21 = r7;
            goto L_0x003a;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.chatting.viewitems.c.e.a(com.tencent.mm.ui.chatting.viewitems.b$a, int, com.tencent.mm.ui.chatting.ChattingUI$a, com.tencent.mm.storage.au, java.lang.String):void");
        }

        private static void a(c cVar, q qVar, au auVar) {
            if (auVar.field_status == 2 && b.a(qVar, auVar.field_msgId)) {
                if (cVar.yRZ != null) {
                    cVar.yRZ.setVisibility(0);
                }
            } else if (cVar.yRZ != null) {
                cVar.yRZ.setVisibility(8);
            }
        }

        public final boolean a(ContextMenu contextMenu, View view, au auVar) {
            int i = ((ar) view.getTag()).position;
            String str = auVar.field_content;
            if (str == null) {
                return true;
            }
            com.tencent.mm.x.g.a fV = com.tencent.mm.x.g.a.fV(this.yyH.dn(str, auVar.field_isSend));
            if (fV == null) {
                return true;
            }
            boolean LR;
            com.tencent.mm.pluginsdk.model.app.f aZ = g.aZ(fV.appId, false);
            if (g.h(aZ) && !com.tencent.mm.ui.chatting.i.an(auVar)) {
                contextMenu.add(i, 111, 0, this.yyH.getString(R.l.eEP));
            }
            if ((auVar.field_status == 2 || auVar.gkH == 1) && b.a(auVar, this.yyH) && b.ZX(auVar.field_talker)) {
                contextMenu.add(i, 123, 0, view.getContext().getString(R.l.dSb));
            }
            switch (fV.type) {
                case 1:
                    LR = com.tencent.mm.af.f.LR();
                    break;
                case 2:
                    LR = com.tencent.mm.af.f.LT();
                    break;
                case 3:
                    LR = com.tencent.mm.af.f.Mc();
                    break;
                case 4:
                    LR = com.tencent.mm.af.f.LU();
                    break;
                case 5:
                    LR = com.tencent.mm.af.f.Ma();
                    break;
                case 6:
                    LR = com.tencent.mm.af.f.Mb();
                    break;
                case 8:
                    LR = com.tencent.mm.af.f.LY();
                    break;
                case 16:
                    if (fV.hdW != 5 && fV.hdW != 6 && fV.hdW != 2) {
                        LR = false;
                        break;
                    }
                    if (fV.hdW != 2) {
                        contextMenu.clear();
                    }
                    contextMenu.add(i, 100, 0, this.yyH.getString(R.l.dRS));
                    return false;
                    break;
                case 34:
                    contextMenu.clear();
                    contextMenu.add(i, 100, 0, this.yyH.getString(R.l.dRS));
                    return false;
                default:
                    LR = false;
                    break;
            }
            if (LR && !this.yyH.ctJ()) {
                contextMenu.add(i, 114, 0, view.getContext().getString(R.l.dRO));
            }
            if (com.tencent.mm.bl.d.Pu("favorite") && (aZ == null || !aZ.YI())) {
                switch (fV.type) {
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                    case 10:
                    case 13:
                    case 19:
                    case 20:
                    case 24:
                        contextMenu.add(i, 116, 0, view.getContext().getString(R.l.eAq));
                        break;
                }
            }
            com.tencent.mm.sdk.b.b diVar = new di();
            diVar.fsL.frh = auVar.field_msgId;
            com.tencent.mm.sdk.b.a.xmy.m(diVar);
            if (diVar.fsM.fsk || b.a(this.yyH.getContext(), fV)) {
                contextMenu.add(i, FileUtils.S_IWUSR, 0, view.getContext().getString(R.l.dRX));
            }
            if (!this.yyH.ctJ()) {
                contextMenu.add(i, 100, 0, this.yyH.getString(R.l.dRS));
            }
            return true;
        }

        public final boolean a(MenuItem menuItem, com.tencent.mm.ui.chatting.ChattingUI.a aVar, au auVar) {
            com.tencent.mm.x.g.a aVar2;
            com.tencent.mm.sdk.b.b mvVar;
            String str;
            switch (menuItem.getItemId()) {
                case 100:
                    String str2 = auVar.field_content;
                    aVar2 = null;
                    if (str2 != null) {
                        aVar2 = com.tencent.mm.x.g.a.fV(str2);
                    }
                    if (aVar2 != null && 19 == aVar2.type) {
                        mvVar = new mv();
                        mvVar.fFz.type = 3;
                        mvVar.fFz.frh = auVar.field_msgId;
                        com.tencent.mm.sdk.b.a.xmy.m(mvVar);
                    }
                    bb.aL(auVar.field_msgId);
                    if (aVar2 != null) {
                        com.tencent.mm.pluginsdk.model.app.f aZ = g.aZ(aVar2.appId, false);
                        if (aZ != null && aZ.YI()) {
                            b.a(aVar, aVar2, auVar, aZ);
                            break;
                        }
                    }
                    break;
                case 103:
                    str = auVar.field_content;
                    if (str != null) {
                        aVar2 = com.tencent.mm.x.g.a.fV(str);
                        if (aVar2 != null) {
                            switch (aVar2.type) {
                                case 16:
                                    mvVar = new hz();
                                    mvVar.fzm.fzn = aVar2.fzn;
                                    mvVar.fzm.fqB = auVar.field_msgId;
                                    mvVar.fzm.fzo = auVar.field_talker;
                                    com.tencent.mm.sdk.b.a.xmy.m(mvVar);
                                    break;
                            }
                        }
                    }
                    break;
                case 111:
                    b.a(aVar, auVar, a(aVar, auVar));
                    break;
                case 114:
                    str = auVar.field_content;
                    if (str != null) {
                        aVar2 = com.tencent.mm.x.g.a.fV(str);
                        if (aVar2 != null) {
                            switch (aVar2.type) {
                                case 1:
                                    ah.k(aVar.dn(auVar.field_content, auVar.field_isSend), aVar.getContext());
                                    break;
                                case 2:
                                    ah.a(auVar, aVar.getContext(), a(aVar, auVar), aVar.yAR);
                                    break;
                                case 3:
                                    ah.a(auVar, aVar.dn(auVar.field_content, auVar.field_isSend), aVar.getContext());
                                    break;
                                case 4:
                                    ah.a(auVar, aVar.getContext());
                                    break;
                                case 5:
                                    ah.c(auVar, aVar.dn(auVar.field_content, auVar.field_isSend), aVar.getContext());
                                    break;
                                case 6:
                                    ah.b(auVar, aVar.dn(auVar.field_content, auVar.field_isSend), aVar.getContext());
                                    break;
                                case 8:
                                    ah.b(auVar, aVar.getContext());
                                    break;
                            }
                        }
                    }
                    break;
            }
            return false;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean b(android.view.View r16, com.tencent.mm.ui.chatting.ChattingUI.a r17, com.tencent.mm.storage.au r18) {
            /*
            r15 = this;
            r16.getTag();
            r0 = r18;
            r2 = r0.field_content;
            if (r2 != 0) goto L_0x000b;
        L_0x0009:
            r2 = 0;
        L_0x000a:
            return r2;
        L_0x000b:
            r3 = com.tencent.mm.x.g.a.fV(r2);
            if (r3 != 0) goto L_0x0013;
        L_0x0011:
            r2 = 0;
            goto L_0x000a;
        L_0x0013:
            r2 = r3.appId;
            r4 = 1;
            r5 = com.tencent.mm.pluginsdk.model.app.g.aZ(r2, r4);
            if (r5 == 0) goto L_0x0037;
        L_0x001c:
            r2 = r5.field_appId;
            r2 = com.tencent.mm.sdk.platformtools.bi.oN(r2);
            if (r2 != 0) goto L_0x0037;
        L_0x0024:
            r2 = r5.YI();
            if (r2 == 0) goto L_0x0037;
        L_0x002a:
            r4 = com.tencent.mm.y.q.FY();
            r0 = r18;
            r6 = r0.field_msgSvrId;
            r2 = r17;
            com.tencent.mm.ui.chatting.viewitems.b.a(r2, r3, r4, r5, r6);
        L_0x0037:
            r7 = 0;
            r2 = r3.type;
            switch(r2) {
                case 3: goto L_0x0167;
                case 4: goto L_0x0183;
                case 5: goto L_0x01ce;
                case 6: goto L_0x0091;
                case 7: goto L_0x067d;
                case 8: goto L_0x003d;
                case 9: goto L_0x003d;
                case 10: goto L_0x069c;
                case 11: goto L_0x003d;
                case 12: goto L_0x003d;
                case 13: goto L_0x0724;
                case 14: goto L_0x003d;
                case 15: goto L_0x003d;
                case 16: goto L_0x0758;
                case 17: goto L_0x003d;
                case 18: goto L_0x003d;
                case 19: goto L_0x078d;
                case 20: goto L_0x06e0;
                case 21: goto L_0x003d;
                case 22: goto L_0x003d;
                case 23: goto L_0x003d;
                case 24: goto L_0x07bb;
                case 25: goto L_0x003d;
                case 26: goto L_0x003d;
                case 27: goto L_0x003d;
                case 28: goto L_0x003d;
                case 29: goto L_0x003d;
                case 30: goto L_0x003d;
                case 31: goto L_0x003d;
                case 32: goto L_0x003d;
                case 33: goto L_0x0468;
                case 34: goto L_0x07eb;
                case 35: goto L_0x003d;
                case 36: goto L_0x05b4;
                default: goto L_0x003d;
            };
        L_0x003d:
            r2 = r3.url;
            if (r2 == 0) goto L_0x0a82;
        L_0x0041:
            r2 = r3.url;
            r4 = "";
            r2 = r2.equals(r4);
            if (r2 != 0) goto L_0x0a82;
        L_0x004c:
            r2 = r3.canvasPageXml;
            r2 = com.tencent.mm.sdk.platformtools.bi.oN(r2);
            if (r2 != 0) goto L_0x083a;
        L_0x0054:
            r2 = new android.content.Intent;
            r2.<init>();
            r4 = "sns_landig_pages_from_source";
            r5 = 5;
            r2.putExtra(r4, r5);
            r4 = "msg_id";
            r0 = r18;
            r6 = r0.field_msgId;
            r2.putExtra(r4, r6);
            r4 = "sns_landing_pages_xml";
            r3 = r3.canvasPageXml;
            r2.putExtra(r4, r3);
            r3 = "sns_landing_pages_share_thumb_url";
            r0 = r18;
            r4 = r0.field_imgPath;
            r2.putExtra(r3, r4);
            r3 = 268435456; // 0x10000000 float:2.5243549E-29 double:1.32624737E-315;
            r2.addFlags(r3);
            r3 = r17.getContext();
            r4 = "sns";
            r5 = ".ui.SnsAdNativeLandingPagesPreviewUI";
            com.tencent.mm.bl.d.b(r3, r4, r5, r2);
            r2 = 1;
            goto L_0x000a;
        L_0x0091:
            com.tencent.mm.y.as.Hm();
            r2 = com.tencent.mm.y.c.isSDCardAvailable();
            if (r2 != 0) goto L_0x00a4;
        L_0x009a:
            r2 = r17.getContext();
            com.tencent.mm.ui.base.u.fJ(r2);
            r2 = 1;
            goto L_0x000a;
        L_0x00a4:
            r2 = r3.hcN;
            r2 = com.tencent.mm.sdk.platformtools.bi.WC(r2);
            if (r2 == 0) goto L_0x0146;
        L_0x00ac:
            r0 = r18;
            r4 = r0.field_msgId;
            r2 = r3.for;
            r3 = com.tencent.mm.pluginsdk.model.app.an.aqK();
            r3 = r3.Se(r2);
            if (r3 == 0) goto L_0x00c2;
        L_0x00bc:
            r6 = r3.aPj();
            if (r6 != 0) goto L_0x00c8;
        L_0x00c2:
            r2 = 0;
        L_0x00c3:
            if (r2 == 0) goto L_0x0146;
        L_0x00c5:
            r2 = 1;
            goto L_0x000a;
        L_0x00c8:
            com.tencent.mm.y.as.Hm();
            r6 = com.tencent.mm.y.c.Fh();
            r6 = r6.dI(r4);
            r7 = r6.ckh();
            if (r7 == 0) goto L_0x011c;
        L_0x00d9:
            r3 = "MicroMsg.ChattingItemAppMsgTo";
            r7 = "openImg:: msg is clean, attachId %s, msgId: %d, msgSvrId: %d, imgPath: %s";
            r8 = 4;
            r8 = new java.lang.Object[r8];
            r9 = 0;
            r8[r9] = r2;
            r2 = 1;
            r4 = java.lang.Long.valueOf(r4);
            r8[r2] = r4;
            r2 = 2;
            r4 = r6.field_msgSvrId;
            r4 = java.lang.Long.valueOf(r4);
            r8[r2] = r4;
            r2 = 3;
            r4 = r6.field_imgPath;
            r8[r2] = r4;
            com.tencent.mm.sdk.platformtools.x.i(r3, r7, r8);
            r2 = new android.content.Intent;
            r2.<init>();
            r3 = r15.yyH;
            r3 = r3.getContext();
            r4 = "com.tencent.mm.ui.chatting.ResourcesExceedUI";
            r2.setClassName(r3, r4);
            r3 = "clean_view_type";
            r4 = 1;
            r2.putExtra(r3, r4);
            r3 = r15.yyH;
            r3.startActivity(r2);
            r2 = 1;
            goto L_0x00c3;
        L_0x011c:
            r2 = new android.content.Intent;
            r6 = r15.yyH;
            r6 = r6.getContext();
            r7 = com.tencent.mm.ui.tools.ShowImageUI.class;
            r2.<init>(r6, r7);
            r6 = "key_image_path";
            r3 = r3.field_fileFullPath;
            r2.putExtra(r6, r3);
            r3 = "key_message_id";
            r2.putExtra(r3, r4);
            r3 = "key_favorite";
            r4 = 1;
            r2.putExtra(r3, r4);
            r3 = r15.yyH;
            r3.startActivity(r2);
            r2 = 1;
            goto L_0x00c3;
        L_0x0146:
            r2 = new android.content.Intent;
            r2.<init>();
            r3 = r17.getContext();
            r4 = "com.tencent.mm.ui.chatting.AppAttachDownloadUI";
            r2.setClassName(r3, r4);
            r3 = "app_msg_id";
            r0 = r18;
            r4 = r0.field_msgId;
            r2.putExtra(r3, r4);
            r0 = r17;
            r0.startActivity(r2);
            r2 = 1;
            goto L_0x000a;
        L_0x0167:
            r2 = com.tencent.mm.plugin.report.service.g.pWK;
            r4 = 13043; // 0x32f3 float:1.8277E-41 double:6.444E-320;
            r5 = 3;
            r5 = new java.lang.Object[r5];
            r6 = 0;
            r7 = 2;
            r7 = java.lang.Integer.valueOf(r7);
            r5[r6] = r7;
            r6 = 1;
            r7 = r3.description;
            r5[r6] = r7;
            r6 = 2;
            r7 = r3.appId;
            r5[r6] = r7;
            r2.h(r4, r5);
        L_0x0183:
            r0 = r17;
            r1 = r18;
            r2 = r15.a(r0, r3, r1);
            if (r2 == 0) goto L_0x0190;
        L_0x018d:
            r2 = 1;
            goto L_0x000a;
        L_0x0190:
            r2 = r3.url;
            r4 = "message";
            r4 = com.tencent.mm.pluginsdk.model.app.p.A(r2, r4);
            r2 = r3.hcL;
            r5 = "message";
            r5 = com.tencent.mm.pluginsdk.model.app.p.A(r2, r5);
            r2 = r17.getContext();
            r6 = r3.appId;
            r2 = com.tencent.mm.ui.chatting.viewitems.b.getPackageInfo(r2, r6);
            if (r2 != 0) goto L_0x01c8;
        L_0x01ae:
            r6 = 0;
        L_0x01af:
            if (r2 != 0) goto L_0x01cb;
        L_0x01b1:
            r7 = 0;
        L_0x01b2:
            r8 = r3.appId;
            r9 = 1;
            r0 = r18;
            r10 = r0.field_msgId;
            r0 = r18;
            r12 = r0.field_msgSvrId;
            r2 = r15;
            r3 = r17;
            r14 = r18;
            r2.a(r3, r4, r5, r6, r7, r8, r9, r10, r12, r14);
            r2 = 1;
            goto L_0x000a;
        L_0x01c8:
            r6 = r2.versionName;
            goto L_0x01af;
        L_0x01cb:
            r7 = r2.versionCode;
            goto L_0x01b2;
        L_0x01ce:
            r2 = r3.canvasPageXml;
            r2 = com.tencent.mm.sdk.platformtools.bi.oN(r2);
            if (r2 != 0) goto L_0x0213;
        L_0x01d6:
            r2 = new android.content.Intent;
            r2.<init>();
            r4 = "sns_landig_pages_from_source";
            r5 = 5;
            r2.putExtra(r4, r5);
            r4 = "msg_id";
            r0 = r18;
            r6 = r0.field_msgId;
            r2.putExtra(r4, r6);
            r4 = "sns_landing_pages_xml";
            r3 = r3.canvasPageXml;
            r2.putExtra(r4, r3);
            r3 = "sns_landing_pages_share_thumb_url";
            r0 = r18;
            r4 = r0.field_imgPath;
            r2.putExtra(r3, r4);
            r3 = 268435456; // 0x10000000 float:2.5243549E-29 double:1.32624737E-315;
            r2.addFlags(r3);
            r3 = r17.getContext();
            r4 = "sns";
            r5 = ".ui.SnsAdNativeLandingPagesPreviewUI";
            com.tencent.mm.bl.d.b(r3, r4, r5, r2);
            r2 = 1;
            goto L_0x000a;
        L_0x0213:
            r2 = com.tencent.mm.plugin.webview.fts.topstory.a.a.class;
            r2 = r3.r(r2);
            r2 = (com.tencent.mm.plugin.webview.fts.topstory.a.a) r2;
            if (r2 == 0) goto L_0x02a7;
        L_0x021d:
            r4 = r2.ttO;
            r4 = com.tencent.mm.sdk.platformtools.bi.oN(r4);
            if (r4 != 0) goto L_0x02a7;
        L_0x0225:
            r4 = new android.content.Intent;
            r4.<init>();
            r5 = "key_scene";
            r6 = 2;
            r4.putExtra(r5, r6);
            r5 = new com.tencent.mm.protocal.c.cbj;
            r5.<init>();
            r6 = r2.ttO;
            r5.ttO = r6;
            r6 = r2.ttP;
            r5.ttP = r6;
            r6 = r2.ttQ;
            r5.ttQ = r6;
            r6 = r2.ttR;
            r5.ttR = r6;
            r6 = r2.ttS;
            r5.ttS = r6;
            r6 = r2.skL;
            r5.skL = r6;
            r6 = r2.lUI;
            r5.lUI = r6;
            r6 = r2.lUJ;
            r5.lUJ = r6;
            r6 = r2.rlx;
            r5.rlx = r6;
            r6 = r2.skF;
            r5.skF = r6;
            r6 = r2.skG;
            r5.skG = r6;
            r6 = r2.skH;
            r5.skH = r6;
            r6 = r2.bhd;
            r5.bhd = r6;
            r6 = r2.pka;
            r5.pka = r6;
            r2 = r2.skM;
            r5.skM = r2;
            r2 = 0;
            r2 = r5.toByteArray();	 Catch:{ IOException -> 0x0299 }
        L_0x0277:
            if (r2 == 0) goto L_0x02a7;
        L_0x0279:
            r3 = 1;
            com.tencent.mm.ui.e.i.xMT = r3;
            r3 = "key_search_web_data";
            r4.putExtra(r3, r2);
            r2 = "key_proxy_fts_rec_ui";
            r3 = 1;
            r4.putExtra(r2, r3);
            r2 = r17.getContext();
            r3 = "webview";
            r5 = ".fts.topstory.ui.TopStoryVideoListUI";
            com.tencent.mm.bl.d.b(r2, r3, r5, r4);
            r2 = 1;
            goto L_0x000a;
        L_0x0299:
            r5 = move-exception;
            r6 = "MicroMsg.ChattingItemAppMsgTo";
            r7 = "";
            r8 = 0;
            r8 = new java.lang.Object[r8];
            com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r6, r5, r7, r8);
            goto L_0x0277;
        L_0x02a7:
            r2 = r3.url;
            if (r2 == 0) goto L_0x0448;
        L_0x02ab:
            r2 = r3.url;
            r4 = "";
            r2 = r2.equals(r4);
            if (r2 != 0) goto L_0x0448;
        L_0x02b6:
            r4 = r3.url;
            r0 = r17;
            r2 = r0.yAR;
            if (r2 == 0) goto L_0x044b;
        L_0x02be:
            r2 = "groupmessage";
        L_0x02c1:
            r2 = com.tencent.mm.pluginsdk.model.app.p.A(r4, r2);
            r4 = r3.hcL;
            r5 = r17.getContext();
            r6 = r3.appId;
            r5 = com.tencent.mm.ui.chatting.viewitems.b.getPackageInfo(r5, r6);
            r6 = new android.content.Intent;
            r6.<init>();
            r7 = "rawUrl";
            r6.putExtra(r7, r2);
            r2 = "webpageTitle";
            r7 = r3.title;
            r6.putExtra(r2, r7);
            r2 = new android.os.Bundle;
            r2.<init>();
            r7 = "key_snsad_statextstr";
            r8 = r3.fHB;
            r2.putString(r7, r8);
            r7 = r3.appId;
            if (r7 == 0) goto L_0x031e;
        L_0x02f5:
            r7 = "wx751a1acca5688ba3";
            r8 = r3.appId;
            r7 = r7.equals(r8);
            if (r7 != 0) goto L_0x0316;
        L_0x0300:
            r7 = "wxfbc915ff7c30e335";
            r8 = r3.appId;
            r7 = r7.equals(r8);
            if (r7 != 0) goto L_0x0316;
        L_0x030b:
            r7 = "wx482a4001c37e2b74";
            r8 = r3.appId;
            r7 = r7.equals(r8);
            if (r7 == 0) goto L_0x031e;
        L_0x0316:
            r7 = "jsapi_args_appid";
            r8 = r3.appId;
            r2.putString(r7, r8);
        L_0x031e:
            r7 = "jsapiargs";
            r6.putExtra(r7, r2);
            r2 = com.tencent.mm.sdk.platformtools.bi.oN(r4);
            if (r2 != 0) goto L_0x0450;
        L_0x032a:
            r2 = "shortUrl";
            r6.putExtra(r2, r4);
        L_0x0330:
            r4 = "version_name";
            if (r5 != 0) goto L_0x045a;
        L_0x0335:
            r2 = 0;
        L_0x0336:
            r6.putExtra(r4, r2);
            r4 = "version_code";
            if (r5 != 0) goto L_0x045e;
        L_0x033e:
            r2 = 0;
        L_0x033f:
            r6.putExtra(r4, r2);
            r2 = r3.fHu;
            r2 = com.tencent.mm.sdk.platformtools.bi.oN(r2);
            if (r2 != 0) goto L_0x035a;
        L_0x034a:
            r2 = "srcUsername";
            r4 = r3.fHu;
            r6.putExtra(r2, r4);
            r2 = "srcDisplayname";
            r4 = r3.fHv;
            r6.putExtra(r2, r4);
        L_0x035a:
            r2 = "msg_id";
            r0 = r18;
            r4 = r0.field_msgId;
            r6.putExtra(r2, r4);
            r2 = "KPublisherId";
            r4 = new java.lang.StringBuilder;
            r5 = "msg_";
            r4.<init>(r5);
            r0 = r18;
            r8 = r0.field_msgSvrId;
            r5 = java.lang.Long.toString(r8);
            r4 = r4.append(r5);
            r4 = r4.toString();
            r6.putExtra(r2, r4);
            r2 = "KAppId";
            r4 = r3.appId;
            r6.putExtra(r2, r4);
            r2 = "geta8key_username";
            r4 = r17.csn();
            r6.putExtra(r2, r4);
            r2 = "pre_username";
            r0 = r17;
            r1 = r18;
            r4 = r15.a(r0, r1);
            r6.putExtra(r2, r4);
            r2 = "from_scence";
            r4 = 2;
            r6.putExtra(r2, r4);
            r0 = r17;
            r1 = r18;
            r2 = r15.a(r0, r1);
            r4 = r17.csn();
            r2 = com.tencent.mm.y.t.N(r2, r4);
            r4 = "prePublishId";
            r5 = new java.lang.StringBuilder;
            r7 = "msg_";
            r5.<init>(r7);
            r0 = r18;
            r8 = r0.field_msgSvrId;
            r7 = java.lang.Long.toString(r8);
            r5 = r5.append(r7);
            r5 = r5.toString();
            r6.putExtra(r4, r5);
            r4 = "preUsername";
            r0 = r17;
            r1 = r18;
            r5 = r15.a(r0, r1);
            r6.putExtra(r4, r5);
            r4 = "preChatName";
            r5 = r17.csn();
            r6.putExtra(r4, r5);
            r4 = "preChatTYPE";
            r6.putExtra(r4, r2);
            r4 = "preMsgIndex";
            r5 = 0;
            r6.putExtra(r4, r5);
            switch(r2) {
                case 1: goto L_0x0464;
                case 2: goto L_0x0462;
                case 3: goto L_0x03ff;
                case 4: goto L_0x03ff;
                case 5: goto L_0x03ff;
                case 6: goto L_0x0466;
                case 7: goto L_0x0466;
                default: goto L_0x03ff;
            };
        L_0x03ff:
            r2 = 0;
        L_0x0400:
            r4 = "share_report_pre_msg_url";
            r5 = r3.url;
            r6.putExtra(r4, r5);
            r4 = "share_report_pre_msg_title";
            r5 = r3.title;
            r6.putExtra(r4, r5);
            r4 = "share_report_pre_msg_desc";
            r5 = r3.description;
            r6.putExtra(r4, r5);
            r4 = "share_report_pre_msg_icon_url";
            r5 = r3.thumburl;
            r6.putExtra(r4, r5);
            r4 = "share_report_pre_msg_appid";
            r3 = r3.appId;
            r6.putExtra(r4, r3);
            r3 = "share_report_from_scene";
            r6.putExtra(r3, r2);
            r3 = 5;
            if (r2 != r3) goto L_0x043b;
        L_0x0431:
            r2 = "share_report_biz_username";
            r3 = r17.csn();
            r6.putExtra(r2, r3);
        L_0x043b:
            r2 = r17.getContext();
            r3 = "webview";
            r4 = ".ui.tools.WebViewUI";
            com.tencent.mm.bl.d.b(r2, r3, r4, r6);
        L_0x0448:
            r2 = 1;
            goto L_0x000a;
        L_0x044b:
            r2 = "singlemessage";
            goto L_0x02c1;
        L_0x0450:
            r2 = "shortUrl";
            r4 = r3.url;
            r6.putExtra(r2, r4);
            goto L_0x0330;
        L_0x045a:
            r2 = r5.versionName;
            goto L_0x0336;
        L_0x045e:
            r2 = r5.versionCode;
            goto L_0x033f;
        L_0x0462:
            r2 = 2;
            goto L_0x0400;
        L_0x0464:
            r2 = 3;
            goto L_0x0400;
        L_0x0466:
            r2 = 5;
            goto L_0x0400;
        L_0x0468:
            r2 = "MicroMsg.ChattingItemAppMsgTo";
            r4 = "username: %s , path: %s ,appid %s ,url : %s, pkgType : %s, md5 : %s";
            r5 = 6;
            r5 = new java.lang.Object[r5];
            r6 = 0;
            r8 = r3.hfi;
            r5[r6] = r8;
            r6 = 1;
            r8 = r3.hfh;
            r5[r6] = r8;
            r6 = 2;
            r8 = r3.hfj;
            r5[r6] = r8;
            r6 = 3;
            r8 = r3.url;
            r5[r6] = r8;
            r6 = 4;
            r8 = r3.hfp;
            r8 = java.lang.Integer.valueOf(r8);
            r5[r6] = r8;
            r6 = 5;
            r8 = r3.hfl;
            r5[r6] = r8;
            com.tencent.mm.sdk.platformtools.x.i(r2, r4, r5);
            r8 = r17.csn();
            r0 = r17;
            r1 = r18;
            r9 = r15.a(r0, r1);
            r6 = new android.os.Bundle;
            r6.<init>();
            r0 = r17;
            r2 = r0 instanceof com.tencent.mm.ui.chatting.AppBrandServiceChattingUI.a;
            if (r2 == 0) goto L_0x04eb;
        L_0x04ad:
            r4 = "stat_scene";
            r2 = 10;
            r5 = r6;
        L_0x04b3:
            r5.putInt(r4, r2);
            r2 = "stat_msg_id";
            r4 = new java.lang.StringBuilder;
            r5 = "msg_";
            r4.<init>(r5);
            r0 = r18;
            r10 = r0.field_msgSvrId;
            r5 = java.lang.Long.toString(r10);
            r4 = r4.append(r5);
            r4 = r4.toString();
            r6.putString(r2, r4);
            r2 = "stat_chat_talker_username";
            r6.putString(r2, r8);
            r2 = "stat_send_msg_user";
            r6.putString(r2, r9);
            r2 = r3.hfk;
            switch(r2) {
                case 1: goto L_0x0506;
                case 2: goto L_0x0584;
                case 3: goto L_0x05aa;
                default: goto L_0x04e5;
            };
        L_0x04e5:
            r2 = 1;
        L_0x04e6:
            if (r2 != 0) goto L_0x003d;
        L_0x04e8:
            r2 = 1;
            goto L_0x000a;
        L_0x04eb:
            r0 = r17;
            r2 = r0.yAR;
            if (r2 == 0) goto L_0x04f7;
        L_0x04f1:
            r4 = "stat_scene";
            r2 = 2;
            r5 = r6;
            goto L_0x04b3;
        L_0x04f7:
            r4 = "stat_scene";
            r2 = com.tencent.mm.y.s.gI(r8);
            if (r2 == 0) goto L_0x0503;
        L_0x0500:
            r2 = 7;
            r5 = r6;
            goto L_0x04b3;
        L_0x0503:
            r2 = 1;
            r5 = r6;
            goto L_0x04b3;
        L_0x0506:
            r2 = new android.content.Intent;
            r2.<init>();
            r4 = "key_username";
            r5 = r3.hfi;
            r2.putExtra(r4, r5);
            r0 = r17;
            r4 = r0.yAR;
            if (r4 == 0) goto L_0x0576;
        L_0x0519:
            r4 = "key_from_scene";
            r5 = 1;
            r2.putExtra(r4, r5);
            r4 = "key_scene_note";
            r5 = new java.lang.StringBuilder;
            r5.<init>();
            r8 = r17.csn();
            r5 = r5.append(r8);
            r8 = ":";
            r5 = r5.append(r8);
            r5 = r5.append(r9);
            r5 = r5.toString();
            r2.putExtra(r4, r5);
        L_0x0542:
            r4 = "_stat_obj";
            r2.putExtra(r4, r6);
            r4 = new com.tencent.mm.plugin.appbrand.config.WxaExposedParams$a;
            r4.<init>();
            r5 = r3.hfj;
            r4.appId = r5;
            r5 = 6;
            r4.fqZ = r5;
            r5 = r3.hfp;
            r4.iJa = r5;
            r5 = r3.hfm;
            r4.iJb = r5;
            r5 = "key_scene_exposed_params";
            r4 = r4.acv();
            r2.putExtra(r5, r4);
            r4 = r17.getContext();
            r5 = "appbrand";
            r6 = ".ui.AppBrandProfileUI";
            com.tencent.mm.bl.d.b(r4, r5, r6, r2);
            r2 = r7;
            goto L_0x04e6;
        L_0x0576:
            r4 = "key_from_scene";
            r5 = 2;
            r2.putExtra(r4, r5);
            r4 = "key_scene_note";
            r2.putExtra(r4, r8);
            goto L_0x0542;
        L_0x0584:
            r0 = r17;
            r2 = r0 instanceof com.tencent.mm.ui.chatting.AppBrandServiceChattingUI.a;
            if (r2 == 0) goto L_0x0592;
        L_0x058a:
            r2 = 1073; // 0x431 float:1.504E-42 double:5.3E-321;
            com.tencent.mm.modelappbrand.a.a(r8, r2, r3, r6);
            r2 = r7;
            goto L_0x04e6;
        L_0x0592:
            r2 = com.tencent.mm.y.s.gI(r8);
            if (r2 == 0) goto L_0x05a0;
        L_0x0598:
            r2 = 1074; // 0x432 float:1.505E-42 double:5.306E-321;
            com.tencent.mm.modelappbrand.a.a(r8, r2, r3, r6);
            r2 = r7;
            goto L_0x04e6;
        L_0x05a0:
            r0 = r17;
            r2 = r0.yAR;
            com.tencent.mm.modelappbrand.a.a(r8, r9, r2, r3, r6);
            r2 = r7;
            goto L_0x04e6;
        L_0x05aa:
            r0 = r17;
            r2 = r0.yAR;
            com.tencent.mm.modelappbrand.a.b(r8, r9, r2, r3, r6);
            r2 = r7;
            goto L_0x04e6;
        L_0x05b4:
            r2 = r3.hfj;
            r2 = com.tencent.mm.sdk.platformtools.bi.oN(r2);
            if (r2 == 0) goto L_0x0602;
        L_0x05bc:
            r2 = r3.hfi;
            r2 = com.tencent.mm.sdk.platformtools.bi.oN(r2);
            if (r2 == 0) goto L_0x0602;
        L_0x05c4:
            r4 = r3.url;
            r0 = r17;
            r2 = r0.yAR;
            if (r2 == 0) goto L_0x05fe;
        L_0x05cc:
            r2 = "groupmessage";
        L_0x05cf:
            r2 = com.tencent.mm.pluginsdk.model.app.p.A(r4, r2);
            r4 = new android.content.Intent;
            r4.<init>();
            r5 = "rawUrl";
            r4.putExtra(r5, r2);
            r2 = "webpageTitle";
            r5 = r3.title;
            r4.putExtra(r2, r5);
            r2 = "shortUrl";
            r3 = r3.url;
            r4.putExtra(r2, r3);
            r2 = r17.getContext();
            r3 = "webview";
            r5 = ".ui.tools.WebViewUI";
            com.tencent.mm.bl.d.b(r2, r3, r5, r4);
            r2 = 1;
            goto L_0x000a;
        L_0x05fe:
            r2 = "singlemessage";
            goto L_0x05cf;
        L_0x0602:
            r7 = r17.csn();
            r0 = r17;
            r1 = r18;
            r8 = r15.a(r0, r1);
            r6 = new android.os.Bundle;
            r6.<init>();
            r0 = r17;
            r2 = r0.yAR;
            if (r2 == 0) goto L_0x066e;
        L_0x0619:
            r4 = "stat_scene";
            r2 = 2;
            r5 = r6;
        L_0x061e:
            r5.putInt(r4, r2);
            r2 = "stat_msg_id";
            r4 = new java.lang.StringBuilder;
            r5 = "msg_";
            r4.<init>(r5);
            r0 = r18;
            r10 = r0.field_msgSvrId;
            r5 = java.lang.Long.toString(r10);
            r4 = r4.append(r5);
            r4 = r4.toString();
            r6.putString(r2, r4);
            r2 = "stat_chat_talker_username";
            r6.putString(r2, r7);
            r2 = "stat_send_msg_user";
            r6.putString(r2, r8);
            r2 = com.tencent.mm.plugin.appbrand.n.d.class;
            r4 = com.tencent.mm.kernel.g.h(r2);
            r4 = (com.tencent.mm.plugin.appbrand.n.d) r4;
            r5 = r17.getContext();
            r6 = r17.csn();
            r0 = r17;
            r1 = r18;
            r7 = r15.a(r0, r1);
            r0 = r17;
            r8 = r0.yAR;
            r9 = r3;
            r4.a(r5, r6, r7, r8, r9);
            r2 = 1;
            goto L_0x000a;
        L_0x066e:
            r4 = "stat_scene";
            r2 = com.tencent.mm.y.s.gI(r7);
            if (r2 == 0) goto L_0x067a;
        L_0x0677:
            r2 = 7;
            r5 = r6;
            goto L_0x061e;
        L_0x067a:
            r2 = 1;
            r5 = r6;
            goto L_0x061e;
        L_0x067d:
            if (r5 == 0) goto L_0x0690;
        L_0x067f:
            r2 = r5.YI();
            if (r2 == 0) goto L_0x0690;
        L_0x0685:
            r0 = r17;
            r2 = com.tencent.mm.ui.chatting.viewitems.b.a(r0, r5);
            if (r2 == 0) goto L_0x0690;
        L_0x068d:
            r2 = 1;
            goto L_0x000a;
        L_0x0690:
            r0 = r17;
            r2 = r0.yEI;
            r0 = r18;
            r2.aM(r0);
            r2 = 1;
            goto L_0x000a;
        L_0x069c:
            r2 = r3.hdi;
            r2 = com.tencent.mm.sdk.platformtools.bi.oN(r2);
            if (r2 == 0) goto L_0x06a7;
        L_0x06a4:
            r2 = 0;
            goto L_0x000a;
        L_0x06a7:
            r2 = new android.content.Intent;
            r2.<init>();
            r4 = 65536; // 0x10000 float:9.18355E-41 double:3.2379E-319;
            r2.setFlags(r4);
            r4 = "key_Product_xml";
            r3 = r3.hdi;
            r2.putExtra(r4, r3);
            r3 = "key_ProductUI_getProductInfoScene";
            r4 = 1;
            r2.putExtra(r3, r4);
            r0 = r18;
            r3 = r0.field_imgPath;
            if (r3 != 0) goto L_0x06d0;
        L_0x06c6:
            r3 = "key_ProductUI_chatting_msgId";
            r0 = r18;
            r4 = r0.field_msgId;
            r2.putExtra(r3, r4);
        L_0x06d0:
            r3 = r17.getContext();
            r4 = "scanner";
            r5 = ".ui.ProductUI";
            com.tencent.mm.bl.d.b(r3, r4, r5, r2);
            r2 = 1;
            goto L_0x000a;
        L_0x06e0:
            r2 = r3.hdl;
            r2 = com.tencent.mm.sdk.platformtools.bi.oN(r2);
            if (r2 == 0) goto L_0x06eb;
        L_0x06e8:
            r2 = 0;
            goto L_0x000a;
        L_0x06eb:
            r2 = new android.content.Intent;
            r2.<init>();
            r4 = 65536; // 0x10000 float:9.18355E-41 double:3.2379E-319;
            r2.setFlags(r4);
            r4 = "key_TV_xml";
            r3 = r3.hdl;
            r2.putExtra(r4, r3);
            r3 = "key_TV_getProductInfoScene";
            r4 = 1;
            r2.putExtra(r3, r4);
            r0 = r18;
            r3 = r0.field_imgPath;
            if (r3 != 0) goto L_0x0714;
        L_0x070a:
            r3 = "key_TVInfoUI_chatting_msgId";
            r0 = r18;
            r4 = r0.field_msgId;
            r2.putExtra(r3, r4);
        L_0x0714:
            r3 = r17.getContext();
            r4 = "shake";
            r5 = ".ui.TVInfoUI";
            com.tencent.mm.bl.d.b(r3, r4, r5, r2);
            r2 = 1;
            goto L_0x000a;
        L_0x0724:
            r2 = r3.hdo;
            r2 = com.tencent.mm.sdk.platformtools.bi.oN(r2);
            if (r2 == 0) goto L_0x072f;
        L_0x072c:
            r2 = 0;
            goto L_0x000a;
        L_0x072f:
            r2 = new android.content.Intent;
            r2.<init>();
            r4 = 65536; // 0x10000 float:9.18355E-41 double:3.2379E-319;
            r2.setFlags(r4);
            r4 = "key_product_info";
            r3 = r3.hdo;
            r2.putExtra(r4, r3);
            r3 = "key_product_scene";
            r4 = 1;
            r2.putExtra(r3, r4);
            r3 = r17.getContext();
            r4 = "product";
            r5 = ".ui.MallProductUI";
            com.tencent.mm.bl.d.b(r3, r4, r5, r2);
            r2 = 1;
            goto L_0x000a;
        L_0x0758:
            r2 = r3.fzn;
            r2 = com.tencent.mm.sdk.platformtools.bi.oN(r2);
            if (r2 == 0) goto L_0x0763;
        L_0x0760:
            r2 = 0;
            goto L_0x000a;
        L_0x0763:
            r2 = new android.content.Intent;
            r2.<init>();
            r4 = 65536; // 0x10000 float:9.18355E-41 double:3.2379E-319;
            r2.setFlags(r4);
            r4 = "key_card_app_msg";
            r5 = r3.fzn;
            r2.putExtra(r4, r5);
            r4 = "key_from_scene";
            r3 = r3.hdW;
            r2.putExtra(r4, r3);
            r3 = r17.getContext();
            r4 = "card";
            r5 = ".ui.CardDetailUI";
            com.tencent.mm.bl.d.b(r3, r4, r5, r2);
            r2 = 1;
            goto L_0x000a;
        L_0x078d:
            r2 = new android.content.Intent;
            r2.<init>();
            r4 = "message_id";
            r0 = r18;
            r6 = r0.field_msgId;
            r2.putExtra(r4, r6);
            r4 = "record_xml";
            r3 = r3.hdm;
            r2.putExtra(r4, r3);
            r0 = r17;
            r1 = r18;
            com.tencent.mm.ui.chatting.viewitems.c.a.a(r2, r0, r1, r15);
            r3 = r17.getContext();
            r4 = "record";
            r5 = ".ui.RecordMsgDetailUI";
            com.tencent.mm.bl.d.b(r3, r4, r5, r2);
            r2 = 1;
            goto L_0x000a;
        L_0x07bb:
            r2 = new com.tencent.mm.f.a.lj;
            r2.<init>();
            r4 = r2.fDA;
            r5 = r17.getContext();
            r4.context = r5;
            r4 = r2.fDA;
            r0 = r18;
            r6 = r0.field_msgId;
            r4.frh = r6;
            r4 = r2.fDA;
            r0 = r17;
            r5 = r0.yAR;
            r4.fCQ = r5;
            r4 = r2.fDA;
            r3 = r3.hdm;
            r4.fDB = r3;
            r3 = r2.fDA;
            r4 = 6;
            r3.scene = r4;
            r3 = com.tencent.mm.sdk.b.a.xmy;
            r3.m(r2);
            r2 = 1;
            goto L_0x000a;
        L_0x07eb:
            r2 = new android.content.Intent;
            r2.<init>();
            r4 = "key_biz_uin";
            r5 = r3.hdY;
            r2.putExtra(r4, r5);
            r4 = "key_order_id";
            r3 = r3.hdZ;
            r2.putExtra(r4, r3);
            r0 = r18;
            r3 = r0.field_talker;
            if (r3 == 0) goto L_0x082a;
        L_0x0806:
            r0 = r18;
            r3 = r0.field_talker;
            r4 = "";
            r3 = r3.equals(r4);
            if (r3 != 0) goto L_0x082a;
        L_0x0813:
            r0 = r18;
            r3 = r0.field_talker;
            r4 = "@chatroom";
            r3 = r3.endsWith(r4);
            if (r3 == 0) goto L_0x082a;
        L_0x0820:
            r3 = "key_chatroom_name";
            r0 = r18;
            r4 = r0.field_talker;
            r2.putExtra(r3, r4);
        L_0x082a:
            r3 = r17.getContext();
            r4 = "card";
            r5 = ".ui.CardGiftAcceptUI";
            com.tencent.mm.bl.d.b(r3, r4, r5, r2);
            r2 = 1;
            goto L_0x000a;
        L_0x083a:
            r2 = com.tencent.mm.plugin.webview.fts.topstory.a.a.class;
            r2 = r3.r(r2);
            r2 = (com.tencent.mm.plugin.webview.fts.topstory.a.a) r2;
            if (r2 == 0) goto L_0x08ce;
        L_0x0844:
            r4 = r2.ttO;
            r4 = com.tencent.mm.sdk.platformtools.bi.oN(r4);
            if (r4 != 0) goto L_0x08ce;
        L_0x084c:
            r4 = new android.content.Intent;
            r4.<init>();
            r5 = "key_scene";
            r6 = 2;
            r4.putExtra(r5, r6);
            r5 = new com.tencent.mm.protocal.c.cbj;
            r5.<init>();
            r6 = r2.ttO;
            r5.ttO = r6;
            r6 = r2.ttP;
            r5.ttP = r6;
            r6 = r2.ttQ;
            r5.ttQ = r6;
            r6 = r2.ttR;
            r5.ttR = r6;
            r6 = r2.ttS;
            r5.ttS = r6;
            r6 = r2.skL;
            r5.skL = r6;
            r6 = r2.lUI;
            r5.lUI = r6;
            r6 = r2.lUJ;
            r5.lUJ = r6;
            r6 = r2.rlx;
            r5.rlx = r6;
            r6 = r2.skF;
            r5.skF = r6;
            r6 = r2.skG;
            r5.skG = r6;
            r6 = r2.skH;
            r5.skH = r6;
            r6 = r2.bhd;
            r5.bhd = r6;
            r6 = r2.pka;
            r5.pka = r6;
            r2 = r2.skM;
            r5.skM = r2;
            r2 = 0;
            r2 = r5.toByteArray();	 Catch:{ IOException -> 0x08c0 }
        L_0x089e:
            if (r2 == 0) goto L_0x08ce;
        L_0x08a0:
            r3 = 1;
            com.tencent.mm.ui.e.i.xMT = r3;
            r3 = "key_proxy_fts_rec_ui";
            r5 = 1;
            r4.putExtra(r3, r5);
            r3 = "key_search_web_data";
            r4.putExtra(r3, r2);
            r2 = r17.getContext();
            r3 = "webview";
            r5 = ".fts.topstory.ui.TopStoryVideoListUI";
            com.tencent.mm.bl.d.b(r2, r3, r5, r4);
            r2 = 1;
            goto L_0x000a;
        L_0x08c0:
            r5 = move-exception;
            r6 = "MicroMsg.ChattingItemAppMsgTo";
            r7 = "";
            r8 = 0;
            r8 = new java.lang.Object[r8];
            com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r6, r5, r7, r8);
            goto L_0x089e;
        L_0x08ce:
            r4 = r3.url;
            r0 = r17;
            r2 = r0.yAR;
            if (r2 == 0) goto L_0x0a65;
        L_0x08d6:
            r2 = "groupmessage";
        L_0x08d9:
            r2 = com.tencent.mm.pluginsdk.model.app.p.A(r4, r2);
            r4 = r3.url;
            r5 = r17.getContext();
            r6 = r3.appId;
            r5 = com.tencent.mm.ui.chatting.viewitems.b.getPackageInfo(r5, r6);
            r6 = new android.content.Intent;
            r6.<init>();
            r7 = "rawUrl";
            r6.putExtra(r7, r2);
            r2 = "webpageTitle";
            r7 = r3.title;
            r6.putExtra(r2, r7);
            r2 = r3.appId;
            if (r2 == 0) goto L_0x0934;
        L_0x0900:
            r2 = "wx751a1acca5688ba3";
            r7 = r3.appId;
            r2 = r2.equals(r7);
            if (r2 != 0) goto L_0x0921;
        L_0x090b:
            r2 = "wxfbc915ff7c30e335";
            r7 = r3.appId;
            r2 = r2.equals(r7);
            if (r2 != 0) goto L_0x0921;
        L_0x0916:
            r2 = "wx482a4001c37e2b74";
            r7 = r3.appId;
            r2 = r2.equals(r7);
            if (r2 == 0) goto L_0x0934;
        L_0x0921:
            r2 = new android.os.Bundle;
            r2.<init>();
            r7 = "jsapi_args_appid";
            r8 = r3.appId;
            r2.putString(r7, r8);
            r7 = "jsapiargs";
            r6.putExtra(r7, r2);
        L_0x0934:
            r2 = com.tencent.mm.sdk.platformtools.bi.oN(r4);
            if (r2 != 0) goto L_0x0a6a;
        L_0x093a:
            r2 = "shortUrl";
            r6.putExtra(r2, r4);
        L_0x0940:
            r4 = "version_name";
            if (r5 != 0) goto L_0x0a74;
        L_0x0945:
            r2 = 0;
        L_0x0946:
            r6.putExtra(r4, r2);
            r4 = "version_code";
            if (r5 != 0) goto L_0x0a78;
        L_0x094e:
            r2 = 0;
        L_0x094f:
            r6.putExtra(r4, r2);
            r2 = r3.fHu;
            r2 = com.tencent.mm.sdk.platformtools.bi.oN(r2);
            if (r2 != 0) goto L_0x096a;
        L_0x095a:
            r2 = "srcUsername";
            r4 = r3.fHu;
            r6.putExtra(r2, r4);
            r2 = "srcDisplayname";
            r4 = r3.fHv;
            r6.putExtra(r2, r4);
        L_0x096a:
            r2 = "msg_id";
            r0 = r18;
            r4 = r0.field_msgId;
            r6.putExtra(r2, r4);
            r2 = "KPublisherId";
            r4 = new java.lang.StringBuilder;
            r5 = "msg_";
            r4.<init>(r5);
            r0 = r18;
            r8 = r0.field_msgSvrId;
            r5 = java.lang.Long.toString(r8);
            r4 = r4.append(r5);
            r4 = r4.toString();
            r6.putExtra(r2, r4);
            r2 = "KAppId";
            r4 = r3.appId;
            r6.putExtra(r2, r4);
            r2 = "geta8key_username";
            r4 = r17.csn();
            r6.putExtra(r2, r4);
            r2 = "pre_username";
            r0 = r17;
            r1 = r18;
            r4 = r15.a(r0, r1);
            r6.putExtra(r2, r4);
            r2 = "from_scence";
            r4 = 2;
            r6.putExtra(r2, r4);
            r2 = "expid_str";
            r0 = r18;
            r4 = r0.gkM;
            r6.putExtra(r2, r4);
            r0 = r17;
            r1 = r18;
            r2 = r15.a(r0, r1);
            r4 = r17.csn();
            r2 = com.tencent.mm.y.t.N(r2, r4);
            r4 = "prePublishId";
            r5 = new java.lang.StringBuilder;
            r7 = "msg_";
            r5.<init>(r7);
            r0 = r18;
            r8 = r0.field_msgSvrId;
            r7 = java.lang.Long.toString(r8);
            r5 = r5.append(r7);
            r5 = r5.toString();
            r6.putExtra(r4, r5);
            r4 = "preUsername";
            r0 = r17;
            r1 = r18;
            r5 = r15.a(r0, r1);
            r6.putExtra(r4, r5);
            r4 = "preChatName";
            r5 = r17.csn();
            r6.putExtra(r4, r5);
            r4 = "preChatTYPE";
            r6.putExtra(r4, r2);
            r4 = "preMsgIndex";
            r5 = 0;
            r6.putExtra(r4, r5);
            switch(r2) {
                case 1: goto L_0x0a7e;
                case 2: goto L_0x0a7c;
                case 3: goto L_0x0a19;
                case 4: goto L_0x0a19;
                case 5: goto L_0x0a19;
                case 6: goto L_0x0a80;
                case 7: goto L_0x0a80;
                default: goto L_0x0a19;
            };
        L_0x0a19:
            r2 = 0;
        L_0x0a1a:
            r4 = "share_report_pre_msg_url";
            r5 = r3.url;
            r6.putExtra(r4, r5);
            r4 = "share_report_pre_msg_title";
            r5 = r3.title;
            r6.putExtra(r4, r5);
            r4 = "share_report_pre_msg_desc";
            r5 = r3.description;
            r6.putExtra(r4, r5);
            r4 = "share_report_pre_msg_icon_url";
            r5 = r3.thumburl;
            r6.putExtra(r4, r5);
            r4 = "share_report_pre_msg_appid";
            r3 = r3.appId;
            r6.putExtra(r4, r3);
            r3 = "share_report_from_scene";
            r6.putExtra(r3, r2);
            r3 = 5;
            if (r2 != r3) goto L_0x0a55;
        L_0x0a4b:
            r2 = "share_report_biz_username";
            r3 = r17.csn();
            r6.putExtra(r2, r3);
        L_0x0a55:
            r2 = r17.getContext();
            r3 = "webview";
            r4 = ".ui.tools.WebViewUI";
            com.tencent.mm.bl.d.b(r2, r3, r4, r6);
            r2 = 1;
            goto L_0x000a;
        L_0x0a65:
            r2 = "singlemessage";
            goto L_0x08d9;
        L_0x0a6a:
            r2 = "shortUrl";
            r4 = r3.url;
            r6.putExtra(r2, r4);
            goto L_0x0940;
        L_0x0a74:
            r2 = r5.versionName;
            goto L_0x0946;
        L_0x0a78:
            r2 = r5.versionCode;
            goto L_0x094f;
        L_0x0a7c:
            r2 = 2;
            goto L_0x0a1a;
        L_0x0a7e:
            r2 = 3;
            goto L_0x0a1a;
        L_0x0a80:
            r2 = 5;
            goto L_0x0a1a;
        L_0x0a82:
            r2 = 0;
            goto L_0x000a;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.chatting.viewitems.c.e.b(android.view.View, com.tencent.mm.ui.chatting.ChattingUI$a, com.tencent.mm.storage.au):boolean");
        }
    }

    static final class a {
        static void a(Intent intent, com.tencent.mm.ui.chatting.ChattingUI.a aVar, au auVar, b bVar) {
            String str;
            int i;
            Bundle bundle;
            String csn = aVar.csn();
            String a = bVar.a(aVar, auVar);
            Bundle bundle2 = new Bundle();
            if (aVar.yAR) {
                str = "stat_scene";
                i = 2;
                bundle = bundle2;
            } else {
                str = "stat_scene";
                if (s.gI(csn)) {
                    i = 7;
                    bundle = bundle2;
                } else {
                    i = 1;
                    bundle = bundle2;
                }
            }
            bundle.putInt(str, i);
            bundle2.putString("stat_msg_id", "msg_" + Long.toString(auVar.field_msgSvrId));
            bundle2.putString("stat_chat_talker_username", csn);
            bundle2.putString("stat_send_msg_user", a);
            intent.putExtra("_stat_obj", bundle2);
        }
    }

    public static class d extends b {
        private boolean tYt;
        private com.tencent.mm.ap.a.a.c yPP;
        protected r.h ySp;
        protected k ySq;
        protected r.i ySr;
        private com.tencent.mm.ui.chatting.ChattingUI.a yyH;

        public final boolean aXP() {
            return false;
        }

        public d() {
            com.tencent.mm.ap.a.a.c.a aVar = new com.tencent.mm.ap.a.a.c.a();
            aVar.hFA = R.k.dvR;
            this.yPP = aVar.PQ();
        }

        public final boolean ak(int i, boolean z) {
            if ((!z && i == 49) || i == 335544369 || i == 402653233 || i == 369098801) {
                return true;
            }
            return false;
        }

        public final View a(LayoutInflater layoutInflater, View view) {
            if (view != null && view.getTag() != null) {
                return view;
            }
            view = new p(layoutInflater, R.i.ddp);
            view.setTag(new c().p(view, true));
            return view;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void a(com.tencent.mm.ui.chatting.viewitems.b.a r26, int r27, com.tencent.mm.ui.chatting.ChattingUI.a r28, com.tencent.mm.storage.au r29, java.lang.String r30) {
            /*
            r25 = this;
            r20 = r26;
            r20 = (com.tencent.mm.ui.chatting.viewitems.c.c) r20;
            r0 = r28;
            r1 = r25;
            r1.yyH = r0;
            r20.reset();
            r0 = r29;
            r6 = r0.field_content;
            r0 = r28;
            r7 = r0.yEx;
            r0 = r29;
            r7.aR(r0);
            r0 = r28;
            r7 = r0.yEx;
            r0 = r29;
            r7.aS(r0);
            r0 = r28;
            r7 = r0.yEx;
            r0 = r29;
            r7.aT(r0);
            r0 = r25;
            r7 = r0.tYt;
            if (r7 == 0) goto L_0x13b2;
        L_0x0032:
            r0 = r29;
            r7 = r0.field_content;
            r8 = 58;
            r7 = r7.indexOf(r8);
            r8 = -1;
            if (r7 == r8) goto L_0x13b2;
        L_0x003f:
            r0 = r29;
            r6 = r0.field_content;
            r7 = r7 + 1;
            r6 = r6.substring(r7);
            r16 = r6;
        L_0x004b:
            r7 = 0;
            r6 = 0;
            if (r16 == 0) goto L_0x0418;
        L_0x004f:
            r0 = r29;
            r6 = r0.field_reserved;
            r0 = r16;
            r7 = com.tencent.mm.x.g.a.I(r0, r6);
            r6 = com.tencent.mm.x.k.fZ(r16);
            r14 = r6;
            r21 = r7;
        L_0x0060:
            r6 = new com.tencent.mm.ui.chatting.viewitems.ar;
            r0 = r28;
            r8 = r0.yxU;
            r10 = 0;
            r11 = 0;
            r7 = r29;
            r9 = r27;
            r6.<init>(r7, r8, r9, r10, r11);
            r15 = 0;
            if (r21 == 0) goto L_0x03dd;
        L_0x0072:
            r0 = r20;
            r7 = r0.ikL;
            r8 = r21.getTitle();
            r7.setText(r8);
            r0 = r20;
            r7 = r0.ikM;
            r8 = r21.getDescription();
            r7.setText(r8);
            r0 = r20;
            r7 = r0.ntj;
            r8 = 1;
            r7.setMaxLines(r8);
            r0 = r20;
            r7 = r0.ikL;
            r8 = r28.getContext();
            r8 = r8.getResources();
            r9 = com.tencent.mm.R.e.btv;
            r8 = r8.getColor(r9);
            r7.setTextColor(r8);
            r0 = r20;
            r7 = r0.ikM;
            r8 = r28.getContext();
            r8 = r8.getResources();
            r9 = com.tencent.mm.R.e.bsO;
            r8 = r8.getColor(r9);
            r7.setTextColor(r8);
            r0 = r20;
            r7 = r0.yRU;
            r8 = com.tencent.mm.R.g.bAE;
            r7.setBackgroundResource(r8);
            r0 = r20;
            r7 = r0.yRU;
            r8 = 0;
            r9 = r28.getContext();
            r9 = r9.getResources();
            r10 = com.tencent.mm.R.f.bvC;
            r9 = r9.getDimensionPixelSize(r10);
            r10 = 0;
            r11 = 0;
            r7.setPadding(r8, r9, r10, r11);
            r0 = r20;
            r7 = r0.yRA;
            r8 = 0;
            r7.setVisibility(r8);
            r0 = r20;
            r7 = r0.yRS;
            r8 = 0;
            r7.setVisibility(r8);
            r0 = r20;
            r7 = r0.ikM;
            r8 = 0;
            r7.setVisibility(r8);
            r0 = r20;
            r7 = r0.yRG;
            r8 = 8;
            r7.setVisibility(r8);
            r0 = r20;
            r7 = r0.yRJ;
            r8 = 8;
            r7.setVisibility(r8);
            r0 = r20;
            r7 = r0.yRI;
            r8 = 8;
            r7.setVisibility(r8);
            r0 = r20;
            r7 = r0.yRW;
            r8 = 8;
            r7.setVisibility(r8);
            r0 = r20;
            r7 = r0.yRX;
            r8 = 8;
            r7.setVisibility(r8);
            r0 = r20;
            r7 = r0.yRC;
            r8 = 8;
            r7.setVisibility(r8);
            r0 = r20;
            r7 = r0.yRD;
            r8 = 8;
            r7.setVisibility(r8);
            r0 = r20;
            r7 = r0.ySh;
            r8 = 8;
            r7.setVisibility(r8);
            r0 = r20;
            r7 = r0.ySa;
            r8 = 8;
            r7.setVisibility(r8);
            r0 = r20;
            r7 = r0.yRU;
            r8 = 0;
            r7.setVisibility(r8);
            r0 = r20;
            r7 = r0.yRT;
            r0 = r20;
            r8 = r0.ySl;
            com.tencent.mm.ui.chatting.viewitems.b.a.O(r7, r8);
            r7 = com.tencent.mm.x.e.class;
            r0 = r21;
            r7 = r0.r(r7);
            r7 = (com.tencent.mm.x.e) r7;
            r0 = r20;
            r8 = r0.yRM;
            if (r7 != 0) goto L_0x0437;
        L_0x0167:
            r7 = 0;
        L_0x0168:
            r0 = r29;
            r9 = r0.field_talker;
            r7 = r8.n(r7, r9);
            if (r7 == 0) goto L_0x043b;
        L_0x0172:
            r0 = r20;
            r7 = r0.yRT;
            r8 = com.tencent.mm.R.g.bAX;
            r7.setBackgroundResource(r8);
        L_0x017b:
            r0 = r21;
            r7 = r0.appId;
            r0 = r21;
            r8 = r0.fJh;
            r24 = com.tencent.mm.pluginsdk.model.app.g.cT(r7, r8);
            if (r24 == 0) goto L_0x0198;
        L_0x0189:
            r7 = r24.YI();
            if (r7 == 0) goto L_0x0198;
        L_0x018f:
            r0 = r28;
            r1 = r21;
            r2 = r29;
            com.tencent.mm.ui.chatting.viewitems.b.b(r0, r1, r2);
        L_0x0198:
            if (r24 == 0) goto L_0x01ae;
        L_0x019a:
            r0 = r24;
            r7 = r0.field_appName;
            if (r7 == 0) goto L_0x01ae;
        L_0x01a0:
            r0 = r24;
            r7 = r0.field_appName;
            r7 = r7.trim();
            r7 = r7.length();
            if (r7 > 0) goto L_0x0446;
        L_0x01ae:
            r0 = r21;
            r7 = r0.appName;
        L_0x01b2:
            r8 = 1;
            r9 = r28.getContext();
            r10 = 12;
            com.tencent.mm.bu.a.fromDPToPix(r9, r10);
            r0 = r21;
            r9 = r0.type;
            r10 = 20;
            if (r9 == r10) goto L_0x01d1;
        L_0x01c4:
            r9 = "wxaf060266bfa9a35c";
            r0 = r21;
            r10 = r0.appId;
            r9 = r9.equals(r10);
            if (r9 == 0) goto L_0x01d9;
        L_0x01d1:
            r8 = com.tencent.mm.pluginsdk.q.a.bYL();
            r8 = r8.bsk();
        L_0x01d9:
            if (r8 == 0) goto L_0x045b;
        L_0x01db:
            r0 = r21;
            r8 = r0.appId;
            if (r8 == 0) goto L_0x045b;
        L_0x01e1:
            r0 = r21;
            r8 = r0.appId;
            r8 = r8.length();
            if (r8 <= 0) goto L_0x045b;
        L_0x01eb:
            r8 = com.tencent.mm.pluginsdk.model.app.g.cz(r7);
            if (r8 == 0) goto L_0x045b;
        L_0x01f1:
            r0 = r20;
            r8 = r0.mDG;
            r9 = r28.getContext();
            r0 = r24;
            r7 = com.tencent.mm.pluginsdk.model.app.g.a(r9, r0, r7);
            r8.setText(r7);
            r0 = r20;
            r7 = r0.mDG;
            r8 = 0;
            r7.setVisibility(r8);
            r0 = r20;
            r7 = r0.mDG;
            r8 = 0;
            r9 = 0;
            r10 = 0;
            r11 = 0;
            r7.setCompoundDrawables(r8, r9, r10, r11);
            r0 = r20;
            r7 = r0.yRE;
            r8 = 0;
            r7.setVisibility(r8);
            r0 = r20;
            r7 = r0.yRB;
            r8 = 0;
            r7.setVisibility(r8);
            if (r24 == 0) goto L_0x044c;
        L_0x0227:
            r7 = r24.YI();
            if (r7 == 0) goto L_0x044c;
        L_0x022d:
            r0 = r20;
            r8 = r0.mDG;
            r0 = r24;
            r11 = r0.field_packageName;
            r0 = r29;
            r12 = r0.field_msgSvrId;
            r7 = r28;
            r9 = r29;
            r10 = r21;
            com.tencent.mm.ui.chatting.viewitems.b.a(r7, r8, r9, r10, r11, r12);
        L_0x0242:
            r0 = r20;
            r7 = r0.yRB;
            r0 = r21;
            r8 = r0.appId;
            r0 = r28;
            com.tencent.mm.ui.chatting.viewitems.b.a(r0, r7, r8);
        L_0x024f:
            r0 = r21;
            r7 = r0.hcJ;
            if (r7 == 0) goto L_0x04f0;
        L_0x0255:
            r0 = r21;
            r7 = r0.hcJ;
            r7 = r7.hfD;
            if (r7 == 0) goto L_0x04f0;
        L_0x025d:
            r7 = 1;
        L_0x025e:
            if (r7 == 0) goto L_0x0269;
        L_0x0260:
            r0 = r20;
            r7 = r0.yRE;
            r8 = 8;
            r7.setVisibility(r8);
        L_0x0269:
            r7 = 0;
            r0 = r20;
            r8 = r0.yRA;
            r9 = 0;
            r8.setVisibility(r9);
            r0 = r21;
            r8 = r0.hcJ;
            if (r8 == 0) goto L_0x04f3;
        L_0x0278:
            r0 = r21;
            r8 = r0.hcJ;
            r8 = r8.hfA;
            r9 = 1;
            if (r8 != r9) goto L_0x04f3;
        L_0x0281:
            r8 = 1;
        L_0x0282:
            if (r8 != 0) goto L_0x04f9;
        L_0x0284:
            r0 = r25;
            r8 = r0.vGb;
            if (r8 == 0) goto L_0x04f9;
        L_0x028a:
            r8 = 0;
            r0 = r21;
            r9 = r0.type;
            r10 = 33;
            if (r9 == r10) goto L_0x02b0;
        L_0x0293:
            r0 = r21;
            r9 = r0.type;
            r10 = 36;
            if (r9 == r10) goto L_0x02b0;
        L_0x029b:
            r8 = com.tencent.mm.ap.o.PC();
            r0 = r29;
            r9 = r0.field_imgPath;
            r10 = r28.getContext();
            r10 = com.tencent.mm.bu.a.getDensity(r10);
            r11 = 0;
            r8 = r8.a(r9, r10, r11);
        L_0x02b0:
            if (r8 == 0) goto L_0x04f6;
        L_0x02b2:
            r9 = r8.isRecycled();
            if (r9 != 0) goto L_0x04f6;
        L_0x02b8:
            r0 = r20;
            r9 = r0.yRA;
            r9.setImageBitmap(r8);
        L_0x02bf:
            r0 = r21;
            r9 = r0.type;
            r10 = 3;
            if (r9 != r10) goto L_0x02dc;
        L_0x02c6:
            r0 = r20;
            r9 = r0.yRU;
            r9 = r9.getViewTreeObserver();
            r10 = new com.tencent.mm.ui.chatting.viewitems.c$d$1;
            r0 = r25;
            r1 = r20;
            r2 = r28;
            r10.<init>(r1, r2, r8);
            r9.addOnPreDrawListener(r10);
        L_0x02dc:
            r22 = r7;
        L_0x02de:
            r0 = r21;
            r7 = r0.gkB;
            if (r7 == 0) goto L_0x02ee;
        L_0x02e4:
            r0 = r21;
            r7 = r0.gkB;
            r7 = r7.length();
            if (r7 != 0) goto L_0x050e;
        L_0x02ee:
            r0 = r20;
            r7 = r0.yRL;
            r8 = 8;
            r7.setVisibility(r8);
        L_0x02f7:
            r0 = r20;
            r7 = r0.yRK;
            r8 = 0;
            r7.setOnClickListener(r8);
            r0 = r20;
            r7 = r0.yRO;
            r8 = 0;
            r7.setVisibility(r8);
            r0 = r20;
            r7 = r0.yRF;
            r8 = 8;
            r7.setVisibility(r8);
            r0 = r20;
            r7 = r0.yRR;
            r8 = 0;
            r7.setVisibility(r8);
            r0 = r20;
            r7 = r0.yRP;
            r8 = 8;
            r7.setVisibility(r8);
            r23 = 0;
            r0 = r21;
            r7 = r0.type;
            switch(r7) {
                case 0: goto L_0x0cd3;
                case 1: goto L_0x032a;
                case 2: goto L_0x032a;
                case 3: goto L_0x052b;
                case 4: goto L_0x06dc;
                case 5: goto L_0x076a;
                case 6: goto L_0x062b;
                case 7: goto L_0x0a9c;
                case 8: goto L_0x032a;
                case 9: goto L_0x032a;
                case 10: goto L_0x0b24;
                case 11: goto L_0x032a;
                case 12: goto L_0x032a;
                case 13: goto L_0x0bdf;
                case 14: goto L_0x032a;
                case 15: goto L_0x0d54;
                case 16: goto L_0x1039;
                case 17: goto L_0x032a;
                case 18: goto L_0x032a;
                case 19: goto L_0x1179;
                case 20: goto L_0x0c55;
                case 21: goto L_0x032a;
                case 22: goto L_0x032a;
                case 23: goto L_0x032a;
                case 24: goto L_0x10d0;
                case 25: goto L_0x0e1b;
                case 26: goto L_0x0ef1;
                case 27: goto L_0x0ef1;
                case 28: goto L_0x032a;
                case 29: goto L_0x032a;
                case 30: goto L_0x032a;
                case 31: goto L_0x032a;
                case 32: goto L_0x032a;
                case 33: goto L_0x091c;
                case 34: goto L_0x1189;
                case 35: goto L_0x032a;
                case 36: goto L_0x083d;
                case 37: goto L_0x032a;
                case 38: goto L_0x032a;
                case 39: goto L_0x032a;
                case 40: goto L_0x1323;
                default: goto L_0x032a;
            };
        L_0x032a:
            r7 = 1;
            r12 = r6;
            r6 = r7;
        L_0x032d:
            if (r6 == 0) goto L_0x03b7;
        L_0x032f:
            r0 = r21;
            r6 = r0.title;
            if (r6 == 0) goto L_0x1339;
        L_0x0335:
            r0 = r21;
            r6 = r0.title;
            r6 = r6.length();
            if (r6 <= 0) goto L_0x1339;
        L_0x033f:
            r0 = r20;
            r6 = r0.ntj;
            r7 = 0;
            r6.setVisibility(r7);
            r0 = r20;
            r6 = r0.ntj;
            r7 = 2;
            r6.setMaxLines(r7);
            r0 = r20;
            r6 = r0.ntj;
            r0 = r21;
            r7 = r0.title;
            r6.setText(r7);
        L_0x035a:
            r0 = r20;
            r6 = r0.ikL;
            r7 = 8;
            r6.setVisibility(r7);
            if (r22 == 0) goto L_0x03b7;
        L_0x0365:
            r0 = r21;
            r6 = r0.type;
            r7 = 33;
            if (r6 == r7) goto L_0x0375;
        L_0x036d:
            r0 = r21;
            r6 = r0.type;
            r7 = 36;
            if (r6 != r7) goto L_0x1344;
        L_0x0375:
            r6 = com.tencent.mm.ap.o.PC();
            r0 = r29;
            r7 = r0.field_imgPath;
            r8 = r6.lq(r7);
            r0 = r20;
            r6 = r0.yRA;
            r7 = com.tencent.mm.R.k.dvO;
            r6.setImageResource(r7);
            r6 = com.tencent.mm.modelappbrand.a.b.Jp();
            r0 = r20;
            r7 = r0.yRA;
            r9 = new java.lang.StringBuilder;
            r10 = "file://";
            r9.<init>(r10);
            r8 = r9.append(r8);
            r8 = r8.toString();
            r9 = 0;
            r10 = 0;
            r11 = com.tencent.mm.modelappbrand.g.class;
            r11 = com.tencent.mm.kernel.g.h(r11);
            r11 = (com.tencent.mm.modelappbrand.g) r11;
            r13 = 50;
            r14 = 50;
            r11 = r11.aZ(r13, r14);
            r6.a(r7, r8, r9, r10, r11);
        L_0x03b7:
            r0 = r28;
            r6 = r0.yxU;
            if (r6 != 0) goto L_0x139e;
        L_0x03bd:
            r6 = com.tencent.mm.pluginsdk.model.app.g.g(r24);
            if (r6 == 0) goto L_0x1392;
        L_0x03c3:
            r0 = r20;
            r6 = r0.yRN;
            r7 = 0;
            r6.setVisibility(r7);
            r0 = r20;
            r6 = r0.yRN;
            r0 = r21;
            r1 = r29;
            r7 = com.tencent.mm.ui.chatting.viewitems.ar.a(r0, r1);
            r0 = r28;
            com.tencent.mm.ui.chatting.viewitems.b.c(r0, r6, r7);
            r6 = r12;
        L_0x03dd:
            if (r15 != 0) goto L_0x03f5;
        L_0x03df:
            r0 = r20;
            r7 = r0.yRT;
            r7.setTag(r6);
            r0 = r20;
            r6 = r0.yRT;
            r0 = r25;
            r1 = r28;
            r7 = r0.t(r1);
            r6.setOnClickListener(r7);
        L_0x03f5:
            r0 = r25;
            r6 = r0.vGb;
            if (r6 == 0) goto L_0x0417;
        L_0x03fb:
            r0 = r20;
            r6 = r0.yRT;
            r0 = r25;
            r1 = r28;
            r7 = r0.s(r1);
            r6.setOnLongClickListener(r7);
            r0 = r20;
            r6 = r0.yRT;
            r0 = r28;
            r7 = r0.yAM;
            r7 = r7.yBC;
            r6.setOnTouchListener(r7);
        L_0x0417:
            return;
        L_0x0418:
            r8 = "MicroMsg.ChattingItemAppMsgFrom";
            r9 = "amessage, msgid:%s, user:%s";
            r10 = 2;
            r10 = new java.lang.Object[r10];
            r11 = 0;
            r0 = r29;
            r12 = r0.field_msgId;
            r12 = java.lang.Long.valueOf(r12);
            r10[r11] = r12;
            r11 = 1;
            r10[r11] = r30;
            com.tencent.mm.sdk.platformtools.x.e(r8, r9, r10);
            r14 = r6;
            r21 = r7;
            goto L_0x0060;
        L_0x0437:
            r7 = r7.hcI;
            goto L_0x0168;
        L_0x043b:
            r0 = r20;
            r7 = r0.yRT;
            r8 = com.tencent.mm.R.g.bAT;
            r7.setBackgroundResource(r8);
            goto L_0x017b;
        L_0x0446:
            r0 = r24;
            r7 = r0.field_appName;
            goto L_0x01b2;
        L_0x044c:
            r0 = r20;
            r7 = r0.mDG;
            r0 = r21;
            r8 = r0.appId;
            r0 = r28;
            com.tencent.mm.ui.chatting.viewitems.b.a(r0, r7, r8);
            goto L_0x0242;
        L_0x045b:
            r0 = r21;
            r7 = r0.type;
            r8 = 24;
            if (r7 != r8) goto L_0x048f;
        L_0x0463:
            r0 = r20;
            r7 = r0.mDG;
            r8 = com.tencent.mm.sdk.platformtools.ad.getContext();
            r9 = com.tencent.mm.R.l.eeR;
            r8 = r8.getString(r9);
            r7.setText(r8);
            r0 = r20;
            r7 = r0.yRE;
            r8 = 0;
            r7.setVisibility(r8);
            r0 = r20;
            r7 = r0.mDG;
            r8 = 0;
            r7.setVisibility(r8);
            r0 = r20;
            r7 = r0.yRB;
            r8 = 8;
            r7.setVisibility(r8);
            goto L_0x024f;
        L_0x048f:
            r0 = r21;
            r7 = r0.type;
            r8 = 19;
            if (r7 == r8) goto L_0x049d;
        L_0x0497:
            r7 = r14.hfL;
            r8 = 19;
            if (r7 != r8) goto L_0x04c9;
        L_0x049d:
            r0 = r20;
            r7 = r0.mDG;
            r8 = com.tencent.mm.sdk.platformtools.ad.getContext();
            r9 = com.tencent.mm.R.l.dRH;
            r8 = r8.getString(r9);
            r7.setText(r8);
            r0 = r20;
            r7 = r0.yRE;
            r8 = 0;
            r7.setVisibility(r8);
            r0 = r20;
            r7 = r0.mDG;
            r8 = 0;
            r7.setVisibility(r8);
            r0 = r20;
            r7 = r0.yRB;
            r8 = 8;
            r7.setVisibility(r8);
            goto L_0x024f;
        L_0x04c9:
            r0 = r21;
            r1 = r20;
            r7 = com.tencent.mm.ui.chatting.viewitems.c.a(r0, r1);
            if (r7 != 0) goto L_0x024f;
        L_0x04d3:
            r0 = r20;
            r7 = r0.yRE;
            r8 = 8;
            r7.setVisibility(r8);
            r0 = r20;
            r7 = r0.mDG;
            r8 = 8;
            r7.setVisibility(r8);
            r0 = r20;
            r7 = r0.yRB;
            r8 = 8;
            r7.setVisibility(r8);
            goto L_0x024f;
        L_0x04f0:
            r7 = 0;
            goto L_0x025e;
        L_0x04f3:
            r8 = 0;
            goto L_0x0282;
        L_0x04f6:
            r7 = 1;
            goto L_0x02bf;
        L_0x04f9:
            r0 = r20;
            r8 = r0.yRA;
            r9 = r28.getResources();
            r10 = com.tencent.mm.R.g.bEi;
            r9 = android.graphics.BitmapFactory.decodeResource(r9, r10);
            r8.setImageBitmap(r9);
            r22 = r7;
            goto L_0x02de;
        L_0x050e:
            r0 = r20;
            r7 = r0.yRL;
            r8 = 0;
            r7.setVisibility(r8);
            r0 = r20;
            r7 = r0.yRL;
            r0 = r21;
            r8 = r0.gkB;
            r8 = com.tencent.mm.ui.chatting.viewitems.ar.aae(r8);
            r0 = r25;
            r1 = r28;
            r0.b(r1, r7, r8);
            goto L_0x02f7;
        L_0x052b:
            r0 = r21;
            r7 = r0.title;
            if (r7 == 0) goto L_0x060e;
        L_0x0531:
            r0 = r21;
            r7 = r0.title;
            r7 = r7.length();
            if (r7 <= 0) goto L_0x060e;
        L_0x053b:
            r0 = r20;
            r7 = r0.ikL;
            r8 = 0;
            r7.setVisibility(r8);
            r0 = r20;
            r7 = r0.ikL;
            r8 = r28.getContext();
            r8 = r8.getResources();
            r9 = com.tencent.mm.R.e.white;
            r8 = r8.getColor(r9);
            r7.setTextColor(r8);
        L_0x0558:
            r0 = r20;
            r7 = r0.ikM;
            r8 = 0;
            r7.setVisibility(r8);
            r0 = r20;
            r7 = r0.ikM;
            r8 = r28.getContext();
            r8 = r8.getResources();
            r9 = com.tencent.mm.R.e.white;
            r8 = r8.getColor(r9);
            r7.setTextColor(r8);
            r0 = r20;
            r7 = r0.ntj;
            r8 = 8;
            r7.setVisibility(r8);
            r0 = r20;
            r7 = r0.yRF;
            r8 = 4;
            r7.setVisibility(r8);
            r0 = r20;
            r7 = r0.yRK;
            r8 = 0;
            r7.setVisibility(r8);
            r7 = new java.lang.StringBuilder;
            r7.<init>();
            r0 = r29;
            r8 = r0.field_msgId;
            r7 = r7.append(r8);
            r7 = r7.toString();
            r0 = r26;
            r8 = r0.yRp;
            r7 = r7.equals(r8);
            if (r7 == 0) goto L_0x0619;
        L_0x05a9:
            r0 = r20;
            r7 = r0.yRK;
            r8 = com.tencent.mm.R.g.bDS;
            r7.setImageResource(r8);
        L_0x05b2:
            r0 = r20;
            r7 = r0.ikM;
            r8 = 2;
            r7.setMaxLines(r8);
            if (r22 == 0) goto L_0x05de;
        L_0x05bc:
            r0 = r21;
            r7 = r0.appId;
            r8 = 1;
            r9 = r28.getContext();
            r9 = com.tencent.mm.bu.a.getDensity(r9);
            r7 = com.tencent.mm.pluginsdk.model.app.g.b(r7, r8, r9);
            if (r7 == 0) goto L_0x05d5;
        L_0x05cf:
            r8 = r7.isRecycled();
            if (r8 == 0) goto L_0x0623;
        L_0x05d5:
            r0 = r20;
            r7 = r0.yRA;
            r8 = com.tencent.mm.R.k.dvy;
            r7.setImageResource(r8);
        L_0x05de:
            r7 = new com.tencent.mm.ui.chatting.viewitems.c$f;
            r7.<init>();
            r0 = r29;
            r8 = r0.field_msgId;
            r7.frh = r8;
            r0 = r29;
            r8 = r0.field_content;
            r7.fDn = r8;
            r0 = r29;
            r8 = r0.field_imgPath;
            r7.fAn = r8;
            r0 = r20;
            r8 = r0.yRK;
            r8.setTag(r7);
            r0 = r20;
            r7 = r0.yRK;
            r0 = r28;
            r8 = r0.yAM;
            r8 = r8.yBH;
            r7.setOnClickListener(r8);
            r12 = r6;
            r6 = r23;
            goto L_0x032d;
        L_0x060e:
            r0 = r20;
            r7 = r0.ikL;
            r8 = 8;
            r7.setVisibility(r8);
            goto L_0x0558;
        L_0x0619:
            r0 = r20;
            r7 = r0.yRK;
            r8 = com.tencent.mm.R.g.bDT;
            r7.setImageResource(r8);
            goto L_0x05b2;
        L_0x0623:
            r0 = r20;
            r8 = r0.yRA;
            r8.setImageBitmap(r7);
            goto L_0x05de;
        L_0x062b:
            r0 = r21;
            r7 = r0.title;
            if (r7 == 0) goto L_0x06be;
        L_0x0631:
            r0 = r21;
            r7 = r0.title;
            r7 = r7.length();
            if (r7 <= 0) goto L_0x06be;
        L_0x063b:
            r0 = r20;
            r7 = r0.ikL;
            r8 = 0;
            r7.setVisibility(r8);
            r0 = r20;
            r7 = r0.ikL;
            r8 = 2;
            r7.setMaxLines(r8);
        L_0x064b:
            r0 = r20;
            r7 = r0.ikM;
            r8 = 0;
            r7.setVisibility(r8);
            r0 = r20;
            r7 = r0.ntj;
            r8 = 8;
            r7.setVisibility(r8);
            r0 = r20;
            r7 = r0.yRK;
            r8 = 8;
            r7.setVisibility(r8);
            r0 = r20;
            r7 = r0.yRF;
            r8 = 4;
            r7.setVisibility(r8);
            r0 = r20;
            r7 = r0.ikM;
            r8 = 2;
            r7.setMaxLines(r8);
            r0 = r20;
            r7 = r0.ikM;
            r0 = r21;
            r8 = r0.hcM;
            r8 = (long) r8;
            r8 = com.tencent.mm.sdk.platformtools.bi.by(r8);
            r7.setText(r8);
            r0 = r21;
            r7 = r0.hcM;
            r0 = r20;
            r1 = r16;
            com.tencent.mm.ui.chatting.viewitems.c.c.a(r0, r1, r7);
            r7 = 1;
            r7 = java.lang.Boolean.valueOf(r7);
            r0 = r21;
            r8 = r0.for;
            r0 = r21;
            r9 = r0.title;
            r0 = r20;
            r1 = r29;
            com.tencent.mm.ui.chatting.viewitems.c.c.a(r0, r7, r1, r8, r9);
            if (r22 == 0) goto L_0x13aa;
        L_0x06a6:
            r0 = r21;
            r7 = r0.hcN;
            r7 = com.tencent.mm.sdk.platformtools.bi.WC(r7);
            if (r7 == 0) goto L_0x06c8;
        L_0x06b0:
            r0 = r20;
            r7 = r0.yRA;
            r8 = com.tencent.mm.R.g.byZ;
            r7.setImageResource(r8);
            r12 = r6;
            r6 = r23;
            goto L_0x032d;
        L_0x06be:
            r0 = r20;
            r7 = r0.ikL;
            r8 = 8;
            r7.setVisibility(r8);
            goto L_0x064b;
        L_0x06c8:
            r0 = r20;
            r7 = r0.yRA;
            r0 = r21;
            r8 = r0.hcN;
            r8 = com.tencent.mm.pluginsdk.model.r.Sd(r8);
            r7.setImageResource(r8);
            r12 = r6;
            r6 = r23;
            goto L_0x032d;
        L_0x06dc:
            r0 = r21;
            r7 = r0.title;
            if (r7 == 0) goto L_0x0758;
        L_0x06e2:
            r0 = r21;
            r7 = r0.title;
            r7 = r7.length();
            if (r7 <= 0) goto L_0x0758;
        L_0x06ec:
            r0 = r20;
            r7 = r0.ikL;
            r8 = 0;
            r7.setVisibility(r8);
        L_0x06f4:
            r0 = r20;
            r7 = r0.ikM;
            r8 = 0;
            r7.setVisibility(r8);
            r0 = r20;
            r7 = r0.ntj;
            r8 = 8;
            r7.setVisibility(r8);
            r0 = r20;
            r7 = r0.yRK;
            r8 = 0;
            r7.setVisibility(r8);
            r0 = r20;
            r7 = r0.yRK;
            r8 = com.tencent.mm.R.g.bHg;
            r7.setImageResource(r8);
            r0 = r20;
            r7 = r0.yRF;
            r8 = 4;
            r7.setVisibility(r8);
            r0 = r20;
            r7 = r0.ikM;
            r8 = 2;
            r7.setMaxLines(r8);
            if (r22 == 0) goto L_0x13aa;
        L_0x0728:
            r0 = r21;
            r7 = r0.appId;
            r8 = 1;
            r9 = r28.getContext();
            r9 = com.tencent.mm.bu.a.getDensity(r9);
            r7 = com.tencent.mm.pluginsdk.model.app.g.b(r7, r8, r9);
            if (r7 == 0) goto L_0x0741;
        L_0x073b:
            r8 = r7.isRecycled();
            if (r8 == 0) goto L_0x0762;
        L_0x0741:
            r0 = r20;
            r7 = r0.yRA;
            r8 = com.tencent.mm.R.k.dvL;
            r7.setImageResource(r8);
        L_0x074a:
            r0 = r20;
            r7 = r0.yRK;
            r8 = 8;
            r7.setVisibility(r8);
            r12 = r6;
            r6 = r23;
            goto L_0x032d;
        L_0x0758:
            r0 = r20;
            r7 = r0.ikL;
            r8 = 8;
            r7.setVisibility(r8);
            goto L_0x06f4;
        L_0x0762:
            r0 = r20;
            r8 = r0.yRA;
            r8.setImageBitmap(r7);
            goto L_0x074a;
        L_0x076a:
            r0 = r20;
            r7 = r0.ikL;
            r8 = 8;
            r7.setVisibility(r8);
            r0 = r21;
            r7 = r0.title;
            if (r7 == 0) goto L_0x081c;
        L_0x0779:
            r0 = r21;
            r7 = r0.title;
            r7 = r7.length();
            if (r7 <= 0) goto L_0x081c;
        L_0x0783:
            r0 = r20;
            r7 = r0.ntj;
            r8 = 2;
            r7.setMaxLines(r8);
            r0 = r20;
            r7 = r0.ntj;
            r8 = 0;
            r7.setVisibility(r8);
            r0 = r20;
            r7 = r0.ntj;
            r8 = r21.getTitle();
            r7.setText(r8);
        L_0x079e:
            r0 = r20;
            r7 = r0.ikM;
            r8 = 3;
            r7.setMaxLines(r8);
            r7 = com.tencent.mm.ui.chatting.viewitems.c.h(r21);
            if (r7 == 0) goto L_0x0827;
        L_0x07ac:
            r0 = r20;
            r7 = r0.yRK;
            r8 = 0;
            r7.setVisibility(r8);
            r0 = r20;
            r7 = r0.yRK;
            r8 = com.tencent.mm.R.g.bHg;
            r7.setImageResource(r8);
        L_0x07bd:
            r0 = r20;
            r7 = r0.yRF;
            r8 = 4;
            r7.setVisibility(r8);
            if (r22 == 0) goto L_0x13aa;
        L_0x07c7:
            r0 = r21;
            r7 = r0.appId;
            r8 = 1;
            r9 = r28.getContext();
            r9 = com.tencent.mm.bu.a.getDensity(r9);
            r7 = com.tencent.mm.pluginsdk.model.app.g.b(r7, r8, r9);
            if (r7 == 0) goto L_0x07e0;
        L_0x07da:
            r8 = r7.isRecycled();
            if (r8 == 0) goto L_0x0831;
        L_0x07e0:
            r7 = new com.tencent.mm.ap.a.a.c$a;
            r7.<init>();
            r8 = com.tencent.mm.R.k.dvO;
            r7.hFA = r8;
            r8 = com.tencent.mm.sdk.platformtools.ad.getContext();
            r9 = 50;
            r8 = com.tencent.mm.bu.a.fromDPToPix(r8, r9);
            r9 = com.tencent.mm.sdk.platformtools.ad.getContext();
            r10 = 50;
            r9 = com.tencent.mm.bu.a.fromDPToPix(r9, r10);
            r8 = r7.bc(r8, r9);
            r9 = 1;
            r8.hFj = r9;
            r8 = com.tencent.mm.ap.o.PG();
            r0 = r21;
            r9 = r0.thumburl;
            r0 = r20;
            r10 = r0.yRA;
            r7 = r7.PQ();
            r8.a(r9, r10, r7);
            r12 = r6;
            r6 = r23;
            goto L_0x032d;
        L_0x081c:
            r0 = r20;
            r7 = r0.ntj;
            r8 = 8;
            r7.setVisibility(r8);
            goto L_0x079e;
        L_0x0827:
            r0 = r20;
            r7 = r0.yRK;
            r8 = 8;
            r7.setVisibility(r8);
            goto L_0x07bd;
        L_0x0831:
            r0 = r20;
            r8 = r0.yRA;
            r8.setImageBitmap(r7);
            r12 = r6;
            r6 = r23;
            goto L_0x032d;
        L_0x083d:
            r7 = com.tencent.mm.plugin.appbrand.n.c.class;
            r7 = com.tencent.mm.kernel.g.h(r7);
            r7 = (com.tencent.mm.plugin.appbrand.n.c) r7;
            r0 = r21;
            r8 = r0.hfi;
            r9 = r7.rf(r8);
            if (r9 == 0) goto L_0x08fb;
        L_0x084f:
            r7 = r9.field_nickname;
            r8 = r7;
        L_0x0852:
            if (r9 == 0) goto L_0x0902;
        L_0x0854:
            r7 = r9.field_brandIconURL;
        L_0x0856:
            r0 = r20;
            r9 = r0.yRU;
            r10 = 8;
            r9.setVisibility(r10);
            r0 = r20;
            r9 = r0.ySh;
            r10 = 0;
            r9.setVisibility(r10);
            r0 = r20;
            r9 = r0.ySa;
            r10 = 8;
            r9.setVisibility(r10);
            r0 = r20;
            r9 = r0.ySd;
            r10 = 8;
            r9.setVisibility(r10);
            r0 = r20;
            r9 = r0.ySk;
            r0 = r21;
            r10 = r0.title;
            r9.setText(r10);
            r0 = r20;
            r9 = r0.ySd;
            r0 = r21;
            r10 = r0.description;
            r9.setText(r10);
            r0 = r20;
            r9 = r0.ySf;
            r9.setText(r8);
            r0 = r21;
            r8 = r0.hfp;
            switch(r8) {
                case 1: goto L_0x0908;
                case 2: goto L_0x0912;
                default: goto L_0x089d;
            };
        L_0x089d:
            r0 = r20;
            r8 = r0.ySg;
            r9 = com.tencent.mm.R.l.dEe;
            r8.setText(r9);
        L_0x08a6:
            r8 = com.tencent.mm.ap.o.PG();
            r0 = r20;
            r9 = r0.ySe;
            r0 = r25;
            r10 = r0.yPP;
            r8.a(r7, r9, r10);
            r7 = com.tencent.mm.ap.o.PC();
            r0 = r29;
            r8 = r0.field_imgPath;
            r9 = r7.lq(r8);
            r0 = r20;
            r7 = r0.ySi;
            r8 = 0;
            r7.setImageBitmap(r8);
            r7 = com.tencent.mm.modelappbrand.a.b.Jp();
            r0 = r20;
            r8 = r0.ySi;
            r10 = new java.lang.StringBuilder;
            r11 = "file://";
            r10.<init>(r11);
            r9 = r10.append(r9);
            r9 = r9.toString();
            r10 = 0;
            r11 = 0;
            r12 = com.tencent.mm.modelappbrand.g.class;
            r12 = com.tencent.mm.kernel.g.h(r12);
            r12 = (com.tencent.mm.modelappbrand.g) r12;
            r13 = 240; // 0xf0 float:3.36E-43 double:1.186E-321;
            r14 = 192; // 0xc0 float:2.69E-43 double:9.5E-322;
            r12 = r12.aZ(r13, r14);
            r7.a(r8, r9, r10, r11, r12);
            r12 = r6;
            r6 = r23;
            goto L_0x032d;
        L_0x08fb:
            r0 = r21;
            r7 = r0.fHv;
            r8 = r7;
            goto L_0x0852;
        L_0x0902:
            r0 = r21;
            r7 = r0.hfr;
            goto L_0x0856;
        L_0x0908:
            r0 = r20;
            r8 = r0.ySg;
            r9 = com.tencent.mm.R.l.dEw;
            r8.setText(r9);
            goto L_0x08a6;
        L_0x0912:
            r0 = r20;
            r8 = r0.ySg;
            r9 = com.tencent.mm.R.l.dEv;
            r8.setText(r9);
            goto L_0x08a6;
        L_0x091c:
            r7 = com.tencent.mm.plugin.appbrand.n.c.class;
            r7 = com.tencent.mm.kernel.g.h(r7);
            r7 = (com.tencent.mm.plugin.appbrand.n.c) r7;
            r0 = r21;
            r8 = r0.hfi;
            r9 = r7.rf(r8);
            r0 = r21;
            r7 = r0.hfk;
            switch(r7) {
                case 1: goto L_0x0a1c;
                case 2: goto L_0x0938;
                case 3: goto L_0x0938;
                default: goto L_0x0933;
            };
        L_0x0933:
            r7 = 1;
            r12 = r6;
            r6 = r7;
            goto L_0x032d;
        L_0x0938:
            if (r9 == 0) goto L_0x09fa;
        L_0x093a:
            r7 = r9.field_nickname;
            r8 = r7;
        L_0x093d:
            if (r9 == 0) goto L_0x0a01;
        L_0x093f:
            r7 = r9.field_brandIconURL;
        L_0x0941:
            r0 = r20;
            r9 = r0.yRU;
            r10 = 8;
            r9.setVisibility(r10);
            r0 = r20;
            r9 = r0.ySh;
            r10 = 0;
            r9.setVisibility(r10);
            r0 = r20;
            r9 = r0.ySa;
            r10 = 8;
            r9.setVisibility(r10);
            r0 = r20;
            r9 = r0.ySd;
            r10 = 8;
            r9.setVisibility(r10);
            r0 = r20;
            r9 = r0.ySk;
            r0 = r21;
            r10 = r0.title;
            r9.setText(r10);
            r0 = r20;
            r9 = r0.ySd;
            r0 = r21;
            r10 = r0.description;
            r9.setText(r10);
            r0 = r20;
            r9 = r0.ySf;
            r9.setText(r8);
            r0 = r21;
            r8 = r0.hfp;
            switch(r8) {
                case 1: goto L_0x0a07;
                case 2: goto L_0x0a11;
                default: goto L_0x0988;
            };
        L_0x0988:
            r0 = r20;
            r8 = r0.ySg;
            r9 = com.tencent.mm.R.l.dEe;
            r8.setText(r9);
        L_0x0991:
            r8 = com.tencent.mm.ap.o.PG();
            r0 = r20;
            r9 = r0.ySe;
            r0 = r25;
            r10 = r0.yPP;
            r8.a(r7, r9, r10);
            r7 = com.tencent.mm.ap.o.PC();
            r0 = r29;
            r8 = r0.field_imgPath;
            r7 = r7.lq(r8);
            r0 = r20;
            r8 = r0.ySi;
            r9 = 0;
            r8.setImageBitmap(r9);
            r0 = r20;
            r8 = r0.ySi;
            r9 = 4;
            r8.setVisibility(r9);
            r0 = r20;
            r8 = r0.ySj;
            r9 = 0;
            r8.setVisibility(r9);
            r8 = com.tencent.mm.modelappbrand.a.b.Jp();
            r9 = new com.tencent.mm.ui.chatting.viewitems.c$d$2;
            r0 = r25;
            r1 = r20;
            r9.<init>(r1);
            r10 = new java.lang.StringBuilder;
            r11 = "file://";
            r10.<init>(r11);
            r7 = r10.append(r7);
            r10 = r7.toString();
            r11 = 0;
            r7 = com.tencent.mm.modelappbrand.g.class;
            r7 = com.tencent.mm.kernel.g.h(r7);
            r7 = (com.tencent.mm.modelappbrand.g) r7;
            r12 = 240; // 0xf0 float:3.36E-43 double:1.186E-321;
            r13 = 192; // 0xc0 float:2.69E-43 double:9.5E-322;
            r7 = r7.aZ(r12, r13);
            r8.a(r9, r10, r11, r7);
            r12 = r6;
            r6 = r23;
            goto L_0x032d;
        L_0x09fa:
            r0 = r21;
            r7 = r0.fHv;
            r8 = r7;
            goto L_0x093d;
        L_0x0a01:
            r0 = r21;
            r7 = r0.hfr;
            goto L_0x0941;
        L_0x0a07:
            r0 = r20;
            r8 = r0.ySg;
            r9 = com.tencent.mm.R.l.dEw;
            r8.setText(r9);
            goto L_0x0991;
        L_0x0a11:
            r0 = r20;
            r8 = r0.ySg;
            r9 = com.tencent.mm.R.l.dEv;
            r8.setText(r9);
            goto L_0x0991;
        L_0x0a1c:
            if (r9 == 0) goto L_0x0a7e;
        L_0x0a1e:
            r7 = r9.field_nickname;
            r8 = r7;
        L_0x0a21:
            if (r9 == 0) goto L_0x0a84;
        L_0x0a23:
            r7 = r9.field_brandIconURL;
        L_0x0a25:
            r0 = r20;
            r9 = r0.yRU;
            r10 = 8;
            r9.setVisibility(r10);
            r0 = r20;
            r9 = r0.ySh;
            r10 = 8;
            r9.setVisibility(r10);
            r0 = r20;
            r9 = r0.ySa;
            r10 = 0;
            r9.setVisibility(r10);
            r0 = r20;
            r9 = r0.ySc;
            r9.setText(r8);
            r8 = com.tencent.mm.sdk.platformtools.bi.oN(r7);
            if (r8 == 0) goto L_0x0a86;
        L_0x0a4c:
            r7 = com.tencent.mm.ap.o.PC();
            r0 = r29;
            r8 = r0.field_imgPath;
            r7 = r7.lq(r8);
            r8 = com.tencent.mm.modelappbrand.a.b.Jp();
            r0 = r20;
            r9 = r0.ySb;
            r10 = new java.lang.StringBuilder;
            r11 = "file://";
            r10.<init>(r11);
            r7 = r10.append(r7);
            r7 = r7.toString();
            r10 = com.tencent.mm.modelappbrand.a.a.Jo();
            r11 = com.tencent.mm.modelappbrand.a.f.hmb;
            r8.a(r9, r7, r10, r11);
            r12 = r6;
            r6 = r23;
            goto L_0x032d;
        L_0x0a7e:
            r0 = r21;
            r7 = r0.title;
            r8 = r7;
            goto L_0x0a21;
        L_0x0a84:
            r7 = 0;
            goto L_0x0a25;
        L_0x0a86:
            r8 = com.tencent.mm.modelappbrand.a.b.Jp();
            r0 = r20;
            r9 = r0.ySb;
            r10 = com.tencent.mm.modelappbrand.a.a.Jo();
            r11 = com.tencent.mm.modelappbrand.a.f.hmb;
            r8.a(r9, r7, r10, r11);
            r12 = r6;
            r6 = r23;
            goto L_0x032d;
        L_0x0a9c:
            r0 = r20;
            r7 = r0.ikL;
            r8 = 8;
            r7.setVisibility(r8);
            r0 = r21;
            r7 = r0.title;
            if (r7 == 0) goto L_0x0b0e;
        L_0x0aab:
            r0 = r21;
            r7 = r0.title;
            r7 = r7.trim();
            r7 = r7.length();
            if (r7 <= 0) goto L_0x0b0e;
        L_0x0ab9:
            r0 = r20;
            r7 = r0.ntj;
            r8 = 0;
            r7.setVisibility(r8);
            r0 = r20;
            r7 = r0.ntj;
            r8 = r21.getTitle();
            r7.setText(r8);
        L_0x0acc:
            r0 = r20;
            r7 = r0.ikM;
            r8 = 3;
            r7.setMaxLines(r8);
            r0 = r20;
            r7 = r0.yRK;
            r8 = 8;
            r7.setVisibility(r8);
            r0 = r20;
            r7 = r0.yRF;
            r8 = 0;
            r7.setVisibility(r8);
            if (r22 == 0) goto L_0x13aa;
        L_0x0ae7:
            r0 = r21;
            r7 = r0.appId;
            r8 = 1;
            r9 = r28.getContext();
            r9 = com.tencent.mm.bu.a.getDensity(r9);
            r7 = com.tencent.mm.pluginsdk.model.app.g.b(r7, r8, r9);
            if (r7 == 0) goto L_0x0b00;
        L_0x0afa:
            r8 = r7.isRecycled();
            if (r8 == 0) goto L_0x0b18;
        L_0x0b00:
            r0 = r20;
            r7 = r0.yRA;
            r8 = com.tencent.mm.R.k.dvO;
            r7.setImageResource(r8);
            r12 = r6;
            r6 = r23;
            goto L_0x032d;
        L_0x0b0e:
            r0 = r20;
            r7 = r0.ntj;
            r8 = 8;
            r7.setVisibility(r8);
            goto L_0x0acc;
        L_0x0b18:
            r0 = r20;
            r8 = r0.yRA;
            r8.setImageBitmap(r7);
            r12 = r6;
            r6 = r23;
            goto L_0x032d;
        L_0x0b24:
            r0 = r20;
            r7 = r0.ntj;
            r8 = 0;
            r7.setVisibility(r8);
            r0 = r21;
            r7 = r0.hdh;
            r8 = 1;
            if (r7 != r8) goto L_0x0ba3;
        L_0x0b33:
            r0 = r20;
            r7 = r0.ntj;
            r8 = com.tencent.mm.R.l.eIh;
            r7.setText(r8);
        L_0x0b3c:
            r0 = r21;
            r7 = r0.title;
            if (r7 == 0) goto L_0x0b5f;
        L_0x0b42:
            r0 = r21;
            r7 = r0.title;
            r7 = r7.length();
            if (r7 <= 0) goto L_0x0b5f;
        L_0x0b4c:
            r0 = r20;
            r7 = r0.ikL;
            r8 = 0;
            r7.setVisibility(r8);
            r0 = r20;
            r7 = r0.ikL;
            r8 = r21.getTitle();
            r7.setText(r8);
        L_0x0b5f:
            r0 = r20;
            r7 = r0.ikM;
            r8 = 4;
            r7.setMaxLines(r8);
            r0 = r20;
            r7 = r0.yRF;
            r8 = 4;
            r7.setVisibility(r8);
            r0 = r20;
            r7 = r0.yRK;
            r8 = 8;
            r7.setVisibility(r8);
            if (r22 == 0) goto L_0x13aa;
        L_0x0b7a:
            r7 = com.tencent.mm.ap.o.PC();
            r0 = r29;
            r8 = r0.field_imgPath;
            r9 = r28.getContext();
            r9 = com.tencent.mm.bu.a.getDensity(r9);
            r10 = 0;
            r7 = r7.b(r8, r9, r10);
            if (r7 == 0) goto L_0x0bd1;
        L_0x0b91:
            r8 = r7.isRecycled();
            if (r8 != 0) goto L_0x0bd1;
        L_0x0b97:
            r0 = r20;
            r8 = r0.yRA;
            r8.setImageBitmap(r7);
            r12 = r6;
            r6 = r23;
            goto L_0x032d;
        L_0x0ba3:
            r0 = r21;
            r7 = r0.hdh;
            r8 = 2;
            if (r7 != r8) goto L_0x0bb4;
        L_0x0baa:
            r0 = r20;
            r7 = r0.ntj;
            r8 = com.tencent.mm.R.l.eIj;
            r7.setText(r8);
            goto L_0x0b3c;
        L_0x0bb4:
            r0 = r21;
            r7 = r0.hdh;
            r8 = 3;
            if (r7 != r8) goto L_0x0bc6;
        L_0x0bbb:
            r0 = r20;
            r7 = r0.ntj;
            r8 = com.tencent.mm.R.l.eIi;
            r7.setText(r8);
            goto L_0x0b3c;
        L_0x0bc6:
            r0 = r20;
            r7 = r0.ntj;
            r8 = com.tencent.mm.R.l.eIk;
            r7.setText(r8);
            goto L_0x0b3c;
        L_0x0bd1:
            r0 = r20;
            r7 = r0.yRA;
            r8 = com.tencent.mm.R.k.dvO;
            r7.setImageResource(r8);
            r12 = r6;
            r6 = r23;
            goto L_0x032d;
        L_0x0bdf:
            r0 = r20;
            r7 = r0.ikL;
            r8 = 0;
            r7.setVisibility(r8);
            r0 = r20;
            r7 = r0.ikL;
            r8 = r21.getTitle();
            r7.setText(r8);
            r0 = r20;
            r7 = r0.ntj;
            r8 = 0;
            r7.setVisibility(r8);
            r0 = r20;
            r7 = r0.ntj;
            r8 = com.tencent.mm.R.l.dSn;
            r7.setText(r8);
            r0 = r20;
            r7 = r0.ikM;
            r8 = 4;
            r7.setMaxLines(r8);
            r0 = r20;
            r7 = r0.yRF;
            r8 = 4;
            r7.setVisibility(r8);
            r0 = r20;
            r7 = r0.yRK;
            r8 = 8;
            r7.setVisibility(r8);
            if (r22 == 0) goto L_0x13aa;
        L_0x0c1e:
            r7 = com.tencent.mm.ap.o.PC();
            r0 = r29;
            r8 = r0.field_imgPath;
            r9 = r28.getContext();
            r9 = com.tencent.mm.bu.a.getDensity(r9);
            r10 = 0;
            r7 = r7.b(r8, r9, r10);
            if (r7 == 0) goto L_0x0c47;
        L_0x0c35:
            r8 = r7.isRecycled();
            if (r8 != 0) goto L_0x0c47;
        L_0x0c3b:
            r0 = r20;
            r8 = r0.yRA;
            r8.setImageBitmap(r7);
            r12 = r6;
            r6 = r23;
            goto L_0x032d;
        L_0x0c47:
            r0 = r20;
            r7 = r0.yRA;
            r8 = com.tencent.mm.R.k.dvO;
            r7.setImageResource(r8);
            r12 = r6;
            r6 = r23;
            goto L_0x032d;
        L_0x0c55:
            r0 = r21;
            r7 = r0.title;
            if (r7 == 0) goto L_0x0c81;
        L_0x0c5b:
            r0 = r21;
            r7 = r0.title;
            r7 = r7.length();
            if (r7 <= 0) goto L_0x0c81;
        L_0x0c65:
            r0 = r20;
            r7 = r0.ikL;
            r8 = 0;
            r7.setVisibility(r8);
            r0 = r20;
            r7 = r0.ikL;
            r8 = r21.getTitle();
            r7.setText(r8);
            r0 = r20;
            r7 = r0.ntj;
            r8 = 8;
            r7.setVisibility(r8);
        L_0x0c81:
            r0 = r20;
            r7 = r0.ikM;
            r8 = 4;
            r7.setMaxLines(r8);
            r0 = r20;
            r7 = r0.yRF;
            r8 = 4;
            r7.setVisibility(r8);
            r0 = r20;
            r7 = r0.yRK;
            r8 = 8;
            r7.setVisibility(r8);
            if (r22 == 0) goto L_0x13aa;
        L_0x0c9c:
            r7 = com.tencent.mm.ap.o.PC();
            r0 = r29;
            r8 = r0.field_imgPath;
            r9 = r28.getContext();
            r9 = com.tencent.mm.bu.a.getDensity(r9);
            r10 = 0;
            r7 = r7.b(r8, r9, r10);
            if (r7 == 0) goto L_0x0cc5;
        L_0x0cb3:
            r8 = r7.isRecycled();
            if (r8 != 0) goto L_0x0cc5;
        L_0x0cb9:
            r0 = r20;
            r8 = r0.yRA;
            r8.setImageBitmap(r7);
            r12 = r6;
            r6 = r23;
            goto L_0x032d;
        L_0x0cc5:
            r0 = r20;
            r7 = r0.yRA;
            r8 = com.tencent.mm.R.k.dvO;
            r7.setImageResource(r8);
            r12 = r6;
            r6 = r23;
            goto L_0x032d;
        L_0x0cd3:
            r0 = r21;
            r7 = r0.title;
            if (r7 == 0) goto L_0x0d3e;
        L_0x0cd9:
            r0 = r21;
            r7 = r0.title;
            r7 = r7.length();
            if (r7 <= 0) goto L_0x0d3e;
        L_0x0ce3:
            r0 = r20;
            r7 = r0.ikL;
            r8 = 0;
            r7.setVisibility(r8);
        L_0x0ceb:
            r0 = r20;
            r7 = r0.ikM;
            r8 = 0;
            r7.setVisibility(r8);
            r0 = r20;
            r7 = r0.ntj;
            r8 = 8;
            r7.setVisibility(r8);
            r0 = r20;
            r7 = r0.yRK;
            r8 = 8;
            r7.setVisibility(r8);
            r0 = r20;
            r7 = r0.yRF;
            r8 = 4;
            r7.setVisibility(r8);
            r0 = r20;
            r7 = r0.ikM;
            r8 = 2;
            r7.setMaxLines(r8);
            if (r22 == 0) goto L_0x13aa;
        L_0x0d17:
            r0 = r21;
            r7 = r0.appId;
            r8 = 1;
            r9 = r28.getContext();
            r9 = com.tencent.mm.bu.a.getDensity(r9);
            r7 = com.tencent.mm.pluginsdk.model.app.g.b(r7, r8, r9);
            if (r7 == 0) goto L_0x0d30;
        L_0x0d2a:
            r8 = r7.isRecycled();
            if (r8 == 0) goto L_0x0d48;
        L_0x0d30:
            r0 = r20;
            r7 = r0.yRA;
            r8 = com.tencent.mm.R.k.dvO;
            r7.setImageResource(r8);
            r12 = r6;
            r6 = r23;
            goto L_0x032d;
        L_0x0d3e:
            r0 = r20;
            r7 = r0.ikL;
            r8 = 8;
            r7.setVisibility(r8);
            goto L_0x0ceb;
        L_0x0d48:
            r0 = r20;
            r8 = r0.yRA;
            r8.setImageBitmap(r7);
            r12 = r6;
            r6 = r23;
            goto L_0x032d;
        L_0x0d54:
            r0 = r21;
            r6 = r0.title;
            if (r6 == 0) goto L_0x0e08;
        L_0x0d5a:
            r0 = r21;
            r6 = r0.title;
            r6 = r6.length();
            if (r6 <= 0) goto L_0x0e08;
        L_0x0d64:
            r0 = r20;
            r6 = r0.ikL;
            r7 = 0;
            r6.setVisibility(r7);
        L_0x0d6c:
            r0 = r20;
            r6 = r0.ikM;
            r7 = 0;
            r6.setVisibility(r7);
            r0 = r20;
            r6 = r0.ntj;
            r7 = 8;
            r6.setVisibility(r7);
            r0 = r20;
            r6 = r0.yRK;
            r7 = 8;
            r6.setVisibility(r7);
            r0 = r20;
            r6 = r0.yRF;
            r7 = 4;
            r6.setVisibility(r7);
            r0 = r20;
            r6 = r0.ikM;
            r7 = 2;
            r6.setMaxLines(r7);
            if (r22 == 0) goto L_0x0dbe;
        L_0x0d98:
            r6 = com.tencent.mm.ap.o.PC();
            r0 = r29;
            r7 = r0.field_imgPath;
            r8 = r28.getContext();
            r8 = com.tencent.mm.bu.a.getDensity(r8);
            r9 = 0;
            r6 = r6.b(r7, r8, r9);
            if (r6 == 0) goto L_0x0db5;
        L_0x0daf:
            r7 = r6.isRecycled();
            if (r7 == 0) goto L_0x0e13;
        L_0x0db5:
            r0 = r20;
            r6 = r0.yRA;
            r7 = com.tencent.mm.R.k.dvO;
            r6.setImageResource(r7);
        L_0x0dbe:
            r6 = new com.tencent.mm.ui.chatting.viewitems.ar;
            r8 = 0;
            r10 = "";
            r11 = 0;
            r0 = r21;
            r12 = r0.title;
            r0 = r21;
            r13 = r0.fHu;
            r0 = r21;
            r14 = r0.fHv;
            r0 = r21;
            r15 = r0.title;
            r0 = r21;
            r0 = r0.hdp;
            r16 = r0;
            r0 = r21;
            r0 = r0.url;
            r17 = r0;
            r18 = 0;
            r19 = 0;
            r7 = r29;
            r9 = r27;
            r6.<init>(r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19);
            r0 = r20;
            r7 = r0.yRT;
            r7.setTag(r6);
            r0 = r20;
            r7 = r0.yRT;
            r0 = r25;
            r1 = r28;
            r8 = r0.x(r1);
            r7.setOnClickListener(r8);
            r15 = 1;
            r12 = r6;
            r6 = r23;
            goto L_0x032d;
        L_0x0e08:
            r0 = r20;
            r6 = r0.ikL;
            r7 = 8;
            r6.setVisibility(r7);
            goto L_0x0d6c;
        L_0x0e13:
            r0 = r20;
            r7 = r0.yRA;
            r7.setImageBitmap(r6);
            goto L_0x0dbe;
        L_0x0e1b:
            r0 = r21;
            r6 = r0.title;
            if (r6 == 0) goto L_0x0ede;
        L_0x0e21:
            r0 = r21;
            r6 = r0.title;
            r6 = r6.length();
            if (r6 <= 0) goto L_0x0ede;
        L_0x0e2b:
            r0 = r20;
            r6 = r0.ikL;
            r7 = 0;
            r6.setVisibility(r7);
        L_0x0e33:
            r0 = r20;
            r6 = r0.ikM;
            r7 = 0;
            r6.setVisibility(r7);
            r0 = r20;
            r6 = r0.ntj;
            r7 = 8;
            r6.setVisibility(r7);
            r0 = r20;
            r6 = r0.yRK;
            r7 = 8;
            r6.setVisibility(r7);
            r0 = r20;
            r6 = r0.yRF;
            r7 = 4;
            r6.setVisibility(r7);
            r0 = r20;
            r6 = r0.ikM;
            r7 = 2;
            r6.setMaxLines(r7);
            if (r22 == 0) goto L_0x0e85;
        L_0x0e5f:
            r6 = com.tencent.mm.ap.o.PC();
            r0 = r29;
            r7 = r0.field_imgPath;
            r8 = r28.getContext();
            r8 = com.tencent.mm.bu.a.getDensity(r8);
            r9 = 0;
            r6 = r6.b(r7, r8, r9);
            if (r6 == 0) goto L_0x0e7c;
        L_0x0e76:
            r7 = r6.isRecycled();
            if (r7 == 0) goto L_0x0ee9;
        L_0x0e7c:
            r0 = r20;
            r6 = r0.yRA;
            r7 = com.tencent.mm.R.k.dvO;
            r6.setImageResource(r7);
        L_0x0e85:
            r6 = new com.tencent.mm.ui.chatting.viewitems.ar;
            r9 = "";
            r10 = r28.ctL();
            r0 = r21;
            r11 = r0.fHu;
            r0 = r21;
            r12 = r0.fHv;
            r0 = r21;
            r13 = r0.title;
            r0 = r21;
            r14 = r0.heW;
            r0 = r21;
            r15 = r0.designerName;
            r0 = r21;
            r0 = r0.designerRediretctUrl;
            r16 = r0;
            r0 = r21;
            r0 = r0.url;
            r17 = r0;
            r7 = r29;
            r8 = r27;
            r6.<init>(r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17);
            r0 = r20;
            r7 = r0.yRT;
            r7.setTag(r6);
            r0 = r20;
            r7 = r0.yRT;
            r0 = r25;
            r8 = r0.ySp;
            if (r8 != 0) goto L_0x0ed1;
        L_0x0ec6:
            r8 = new com.tencent.mm.ui.chatting.r$h;
            r0 = r28;
            r8.<init>(r0);
            r0 = r25;
            r0.ySp = r8;
        L_0x0ed1:
            r0 = r25;
            r8 = r0.ySp;
            r7.setOnClickListener(r8);
            r15 = 1;
            r12 = r6;
            r6 = r23;
            goto L_0x032d;
        L_0x0ede:
            r0 = r20;
            r6 = r0.ikL;
            r7 = 8;
            r6.setVisibility(r7);
            goto L_0x0e33;
        L_0x0ee9:
            r0 = r20;
            r7 = r0.yRA;
            r7.setImageBitmap(r6);
            goto L_0x0e85;
        L_0x0ef1:
            r0 = r21;
            r6 = r0.title;
            if (r6 == 0) goto L_0x0fdb;
        L_0x0ef7:
            r0 = r21;
            r6 = r0.title;
            r6 = r6.length();
            if (r6 <= 0) goto L_0x0fdb;
        L_0x0f01:
            r0 = r20;
            r6 = r0.ikL;
            r7 = 0;
            r6.setVisibility(r7);
        L_0x0f09:
            r0 = r20;
            r6 = r0.ikM;
            r7 = 0;
            r6.setVisibility(r7);
            r0 = r20;
            r6 = r0.ntj;
            r7 = 8;
            r6.setVisibility(r7);
            r0 = r20;
            r6 = r0.yRK;
            r7 = 8;
            r6.setVisibility(r7);
            r0 = r20;
            r6 = r0.yRF;
            r7 = 4;
            r6.setVisibility(r7);
            r0 = r20;
            r6 = r0.ikM;
            r7 = 2;
            r6.setMaxLines(r7);
            if (r22 == 0) goto L_0x0f5b;
        L_0x0f35:
            r6 = com.tencent.mm.ap.o.PC();
            r0 = r29;
            r7 = r0.field_imgPath;
            r8 = r28.getContext();
            r8 = com.tencent.mm.bu.a.getDensity(r8);
            r9 = 0;
            r6 = r6.b(r7, r8, r9);
            if (r6 == 0) goto L_0x0f52;
        L_0x0f4c:
            r7 = r6.isRecycled();
            if (r7 == 0) goto L_0x0fe6;
        L_0x0f52:
            r0 = r20;
            r6 = r0.yRA;
            r7 = com.tencent.mm.R.k.dvO;
            r6.setImageResource(r7);
        L_0x0f5b:
            r12 = new com.tencent.mm.ui.chatting.viewitems.ar;
            r12.<init>();
            r0 = r29;
            r12.fFE = r0;
            r6 = 0;
            r12.yxU = r6;
            r0 = r27;
            r12.position = r0;
            r6 = 0;
            r12.yXv = r6;
            r6 = r28.ctL();
            r12.title = r6;
            r0 = r21;
            r6 = r0.fHu;
            r12.fHu = r6;
            r0 = r21;
            r6 = r0.fHv;
            r12.fHv = r6;
            r0 = r21;
            r6 = r0.title;
            r12.yXw = r6;
            r0 = r21;
            r6 = r0.type;
            r7 = 26;
            if (r6 != r7) goto L_0x0fef;
        L_0x0f8e:
            r0 = r21;
            r6 = r0.tid;
            r12.tid = r6;
            r0 = r21;
            r6 = r0.heX;
            r12.heX = r6;
            r0 = r21;
            r6 = r0.desc;
            r12.desc = r6;
            r0 = r21;
            r6 = r0.iconUrl;
            r12.iconUrl = r6;
            r0 = r21;
            r6 = r0.secondUrl;
            r12.secondUrl = r6;
            r0 = r21;
            r6 = r0.pageType;
            r12.pageType = r6;
            r0 = r20;
            r6 = r0.yRT;
            r0 = r25;
            r7 = r0.ySq;
            if (r7 != 0) goto L_0x0fc7;
        L_0x0fbc:
            r7 = new com.tencent.mm.ui.chatting.r$k;
            r0 = r28;
            r7.<init>(r0);
            r0 = r25;
            r0.ySq = r7;
        L_0x0fc7:
            r0 = r25;
            r7 = r0.ySq;
            r6.setOnClickListener(r7);
            r6 = 1;
        L_0x0fcf:
            r0 = r20;
            r7 = r0.yRT;
            r7.setTag(r12);
            r15 = r6;
            r6 = r23;
            goto L_0x032d;
        L_0x0fdb:
            r0 = r20;
            r6 = r0.ikL;
            r7 = 8;
            r6.setVisibility(r7);
            goto L_0x0f09;
        L_0x0fe6:
            r0 = r20;
            r7 = r0.yRA;
            r7.setImageBitmap(r6);
            goto L_0x0f5b;
        L_0x0fef:
            r0 = r21;
            r6 = r0.type;
            r7 = 27;
            if (r6 != r7) goto L_0x13af;
        L_0x0ff7:
            r0 = r21;
            r6 = r0.tid;
            r12.tid = r6;
            r0 = r21;
            r6 = r0.heX;
            r12.heX = r6;
            r0 = r21;
            r6 = r0.desc;
            r12.desc = r6;
            r0 = r21;
            r6 = r0.iconUrl;
            r12.iconUrl = r6;
            r0 = r21;
            r6 = r0.secondUrl;
            r12.secondUrl = r6;
            r0 = r21;
            r6 = r0.pageType;
            r12.pageType = r6;
            r0 = r20;
            r6 = r0.yRT;
            r0 = r25;
            r7 = r0.ySr;
            if (r7 != 0) goto L_0x1030;
        L_0x1025:
            r7 = new com.tencent.mm.ui.chatting.r$i;
            r0 = r28;
            r7.<init>(r0);
            r0 = r25;
            r0.ySr = r7;
        L_0x1030:
            r0 = r25;
            r7 = r0.ySr;
            r6.setOnClickListener(r7);
            r6 = 1;
            goto L_0x0fcf;
        L_0x1039:
            r0 = r20;
            r7 = r0.ikL;
            r8 = 0;
            r7.setVisibility(r8);
            r0 = r20;
            r7 = r0.ikL;
            r0 = r21;
            r8 = r0.description;
            r7.setText(r8);
            r0 = r20;
            r7 = r0.ikM;
            r0 = r21;
            r8 = r0.hdV;
            r7.setText(r8);
            r0 = r21;
            r7 = r0.title;
            if (r7 == 0) goto L_0x10b8;
        L_0x105d:
            r0 = r21;
            r7 = r0.title;
            r7 = r7.length();
            if (r7 <= 0) goto L_0x10b8;
        L_0x1067:
            r0 = r20;
            r7 = r0.ntj;
            r8 = 0;
            r7.setVisibility(r8);
            r0 = r20;
            r7 = r0.ntj;
            r0 = r21;
            r8 = r0.title;
            r7.setText(r8);
        L_0x107a:
            r0 = r20;
            r7 = r0.ikM;
            r8 = 4;
            r7.setMaxLines(r8);
            r0 = r20;
            r7 = r0.yRF;
            r8 = 4;
            r7.setVisibility(r8);
            r0 = r20;
            r7 = r0.yRK;
            r8 = 8;
            r7.setVisibility(r8);
            if (r22 == 0) goto L_0x13aa;
        L_0x1095:
            r7 = com.tencent.mm.ap.o.PC();
            r0 = r29;
            r8 = r0.field_imgPath;
            r9 = r28.getContext();
            r9 = com.tencent.mm.bu.a.getDensity(r9);
            r10 = 0;
            r7 = r7.b(r8, r9, r10);
            if (r7 == 0) goto L_0x10c2;
        L_0x10ac:
            r0 = r20;
            r8 = r0.yRA;
            r8.setImageBitmap(r7);
            r12 = r6;
            r6 = r23;
            goto L_0x032d;
        L_0x10b8:
            r0 = r20;
            r7 = r0.ntj;
            r8 = 8;
            r7.setVisibility(r8);
            goto L_0x107a;
        L_0x10c2:
            r0 = r20;
            r7 = r0.yRA;
            r8 = com.tencent.mm.R.k.dvO;
            r7.setImageResource(r8);
            r12 = r6;
            r6 = r23;
            goto L_0x032d;
        L_0x10d0:
            r0 = r20;
            r7 = r0.ikL;
            r8 = 8;
            r7.setVisibility(r8);
            r0 = r20;
            r7 = r0.ntj;
            r8 = 0;
            r7.setVisibility(r8);
            r0 = r21;
            r7 = r0.title;
            if (r7 == 0) goto L_0x1153;
        L_0x10e7:
            r0 = r21;
            r7 = r0.title;
            r7 = r7.trim();
            r7 = r7.length();
            if (r7 <= 0) goto L_0x1153;
        L_0x10f5:
            r0 = r20;
            r7 = r0.ntj;
            r0 = r20;
            r8 = r0.ntj;
            r8 = r8.getContext();
            r0 = r21;
            r9 = r0.title;
            r0 = r20;
            r10 = r0.ntj;
            r10 = r10.getTextSize();
            r8 = com.tencent.mm.pluginsdk.ui.d.i.b(r8, r9, r10);
            r7.setText(r8);
        L_0x1114:
            r0 = r20;
            r7 = r0.ikM;
            r8 = 3;
            r7.setMaxLines(r8);
            r0 = r20;
            r7 = r0.yRK;
            r8 = 8;
            r7.setVisibility(r8);
            r0 = r20;
            r7 = r0.yRF;
            r8 = 4;
            r7.setVisibility(r8);
            if (r22 == 0) goto L_0x1141;
        L_0x112f:
            r0 = r20;
            r7 = r0.yRA;
            r8 = 8;
            r7.setVisibility(r8);
            r0 = r20;
            r7 = r0.yRS;
            r8 = 8;
            r7.setVisibility(r8);
        L_0x1141:
            r0 = r28;
            r1 = r20;
            r2 = r21;
            r3 = r29;
            r4 = r22;
            com.tencent.mm.ui.chatting.viewitems.c.c.a(r0, r1, r2, r3, r4);
            r12 = r6;
            r6 = r23;
            goto L_0x032d;
        L_0x1153:
            r0 = r20;
            r7 = r0.ntj;
            r0 = r20;
            r8 = r0.ntj;
            r8 = r8.getContext();
            r9 = com.tencent.mm.sdk.platformtools.ad.getContext();
            r10 = com.tencent.mm.R.l.ehj;
            r9 = r9.getString(r10);
            r0 = r20;
            r10 = r0.ntj;
            r10 = r10.getTextSize();
            r8 = com.tencent.mm.pluginsdk.ui.d.i.b(r8, r9, r10);
            r7.setText(r8);
            goto L_0x1114;
        L_0x1179:
            r0 = r28;
            r1 = r20;
            r2 = r21;
            r3 = r22;
            com.tencent.mm.ui.chatting.viewitems.c.c.a(r0, r1, r2, r3);
            r12 = r6;
            r6 = r23;
            goto L_0x032d;
        L_0x1189:
            r0 = r21;
            r7 = r0.title;
            if (r7 == 0) goto L_0x12c5;
        L_0x118f:
            r0 = r21;
            r7 = r0.title;
            r7 = r7.length();
            if (r7 <= 0) goto L_0x12c5;
        L_0x1199:
            r0 = r20;
            r7 = r0.ikL;
            r8 = 0;
            r7.setVisibility(r8);
            r0 = r21;
            r7 = r0.hee;
            r7 = com.tencent.mm.sdk.platformtools.bi.oN(r7);
            if (r7 != 0) goto L_0x12ae;
        L_0x11ab:
            r0 = r20;
            r7 = r0.ikL;
            r0 = r21;
            r8 = r0.hee;
            r9 = r28.getContext();
            r9 = r9.getResources();
            r10 = com.tencent.mm.R.e.black;
            r9 = r9.getColor(r10);
            r8 = com.tencent.mm.sdk.platformtools.bi.bc(r8, r9);
            r7.setTextColor(r8);
        L_0x11c8:
            r0 = r20;
            r7 = r0.ikM;
            r8 = 2;
            r7.setMaxLines(r8);
            r0 = r20;
            r7 = r0.ikM;
            r8 = 0;
            r7.setVisibility(r8);
            r0 = r21;
            r7 = r0.hef;
            r7 = com.tencent.mm.sdk.platformtools.bi.oN(r7);
            if (r7 != 0) goto L_0x12d0;
        L_0x11e2:
            r0 = r20;
            r7 = r0.ikM;
            r0 = r21;
            r8 = r0.hef;
            r9 = r28.getContext();
            r9 = r9.getResources();
            r10 = com.tencent.mm.R.e.bsF;
            r9 = r9.getColor(r10);
            r8 = com.tencent.mm.sdk.platformtools.bi.bc(r8, r9);
            r7.setTextColor(r8);
        L_0x11ff:
            r0 = r20;
            r7 = r0.ntj;
            r8 = 8;
            r7.setVisibility(r8);
            r0 = r20;
            r7 = r0.yRF;
            r8 = 4;
            r7.setVisibility(r8);
            r0 = r20;
            r7 = r0.yRK;
            r8 = 8;
            r7.setVisibility(r8);
            r0 = r20;
            r7 = r0.yRE;
            r8 = 0;
            r7.setVisibility(r8);
            r0 = r20;
            r7 = r0.mDG;
            r8 = 0;
            r7.setVisibility(r8);
            r0 = r21;
            r7 = r0.hea;
            r7 = com.tencent.mm.sdk.platformtools.bi.oN(r7);
            if (r7 != 0) goto L_0x12e7;
        L_0x1233:
            r0 = r20;
            r7 = r0.mDG;
            r0 = r21;
            r8 = r0.hea;
            r7.setText(r8);
        L_0x123e:
            r0 = r25;
            r7 = r0.vGb;
            if (r7 == 0) goto L_0x130d;
        L_0x1244:
            r7 = com.tencent.mm.ap.o.PC();
            r0 = r29;
            r8 = r0.field_imgPath;
            r9 = r28.getContext();
            r9 = com.tencent.mm.bu.a.getDensity(r9);
            r10 = 0;
            r7 = r7.a(r8, r9, r10);
            if (r7 == 0) goto L_0x1274;
        L_0x125b:
            r8 = r7.isRecycled();
            if (r8 != 0) goto L_0x1274;
        L_0x1261:
            r8 = 0;
            r9 = r7.getWidth();
            r9 = r9 / 2;
            r9 = (float) r9;
            r8 = com.tencent.mm.sdk.platformtools.d.a(r7, r8, r9);
            r0 = r20;
            r9 = r0.yRA;
            r9.setImageBitmap(r8);
        L_0x1274:
            r0 = r21;
            r8 = r0.hed;
            r8 = com.tencent.mm.sdk.platformtools.bi.oN(r8);
            if (r8 != 0) goto L_0x12f2;
        L_0x127e:
            r7 = com.tencent.mm.ap.o.PG();
            r0 = r21;
            r8 = r0.hed;
            r9 = new android.widget.ImageView;
            r10 = r28.getContext();
            r9.<init>(r10);
            r10 = new com.tencent.mm.ap.a.a.c$a;
            r10.<init>();
            r11 = 1;
            r10.hFl = r11;
            r10 = r10.PQ();
            r11 = new com.tencent.mm.ui.chatting.viewitems.c$d$3;
            r0 = r25;
            r1 = r20;
            r2 = r28;
            r11.<init>(r1, r2);
            r7.a(r8, r9, r10, r11);
            r12 = r6;
            r6 = r23;
            goto L_0x032d;
        L_0x12ae:
            r0 = r20;
            r7 = r0.ikL;
            r8 = r28.getContext();
            r8 = r8.getResources();
            r9 = com.tencent.mm.R.e.black;
            r8 = r8.getColor(r9);
            r7.setTextColor(r8);
            goto L_0x11c8;
        L_0x12c5:
            r0 = r20;
            r7 = r0.ikL;
            r8 = 8;
            r7.setVisibility(r8);
            goto L_0x11c8;
        L_0x12d0:
            r0 = r20;
            r7 = r0.ikM;
            r8 = r28.getContext();
            r8 = r8.getResources();
            r9 = com.tencent.mm.R.e.bsF;
            r8 = r8.getColor(r9);
            r7.setTextColor(r8);
            goto L_0x11ff;
        L_0x12e7:
            r0 = r20;
            r7 = r0.mDG;
            r8 = com.tencent.mm.R.l.dRG;
            r7.setText(r8);
            goto L_0x123e;
        L_0x12f2:
            r0 = r20;
            r8 = r0.yRU;
            r8 = r8.getViewTreeObserver();
            r9 = new com.tencent.mm.ui.chatting.viewitems.c$d$4;
            r0 = r25;
            r1 = r20;
            r2 = r28;
            r9.<init>(r1, r2, r7);
            r8.addOnPreDrawListener(r9);
            r12 = r6;
            r6 = r23;
            goto L_0x032d;
        L_0x130d:
            r0 = r20;
            r7 = r0.yRA;
            r8 = r28.getResources();
            r9 = com.tencent.mm.R.g.bEi;
            r8 = android.graphics.BitmapFactory.decodeResource(r8, r9);
            r7.setImageBitmap(r8);
            r12 = r6;
            r6 = r23;
            goto L_0x032d;
        L_0x1323:
            r7 = r14.hfL;
            r8 = 19;
            if (r7 != r8) goto L_0x13aa;
        L_0x1329:
            r0 = r28;
            r1 = r20;
            r2 = r21;
            r3 = r22;
            com.tencent.mm.ui.chatting.viewitems.c.c.a(r0, r1, r2, r3);
            r12 = r6;
            r6 = r23;
            goto L_0x032d;
        L_0x1339:
            r0 = r20;
            r6 = r0.ntj;
            r7 = 8;
            r6.setVisibility(r7);
            goto L_0x035a;
        L_0x1344:
            r6 = com.tencent.mm.ap.o.PC();
            r0 = r29;
            r7 = r0.field_imgPath;
            r8 = r28.getContext();
            r8 = com.tencent.mm.bu.a.getDensity(r8);
            r9 = 0;
            r6 = r6.b(r7, r8, r9);
            if (r6 == 0) goto L_0x1361;
        L_0x135b:
            r7 = r6.isRecycled();
            if (r7 == 0) goto L_0x1376;
        L_0x1361:
            r6 = com.tencent.mm.ap.o.PC();
            r0 = r29;
            r7 = r0.field_imgPath;
            r8 = r28.getContext();
            r8 = com.tencent.mm.bu.a.getDensity(r8);
            r9 = 0;
            r6 = r6.a(r7, r8, r9);
        L_0x1376:
            if (r6 == 0) goto L_0x1387;
        L_0x1378:
            r7 = r6.isRecycled();
            if (r7 != 0) goto L_0x1387;
        L_0x137e:
            r0 = r20;
            r7 = r0.yRA;
            r7.setImageBitmap(r6);
            goto L_0x03b7;
        L_0x1387:
            r0 = r20;
            r6 = r0.yRA;
            r7 = com.tencent.mm.R.g.byZ;
            r6.setImageResource(r7);
            goto L_0x03b7;
        L_0x1392:
            r0 = r20;
            r6 = r0.yRN;
            r7 = 8;
            r6.setVisibility(r7);
            r6 = r12;
            goto L_0x03dd;
        L_0x139e:
            r0 = r20;
            r6 = r0.yRN;
            r7 = 8;
            r6.setVisibility(r7);
            r6 = r12;
            goto L_0x03dd;
        L_0x13aa:
            r12 = r6;
            r6 = r23;
            goto L_0x032d;
        L_0x13af:
            r6 = r15;
            goto L_0x0fcf;
        L_0x13b2:
            r16 = r6;
            goto L_0x004b;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.chatting.viewitems.c.d.a(com.tencent.mm.ui.chatting.viewitems.b$a, int, com.tencent.mm.ui.chatting.ChattingUI$a, com.tencent.mm.storage.au, java.lang.String):void");
        }

        public final boolean a(ContextMenu contextMenu, View view, au auVar) {
            int i = ((ar) view.getTag()).position;
            int Sm = l.Sm(this.yyH.dn(auVar.field_content, auVar.field_isSend));
            com.tencent.mm.x.g.a fV = com.tencent.mm.x.g.a.fV(this.yyH.dn(auVar.field_content, auVar.field_isSend));
            com.tencent.mm.pluginsdk.model.app.f aZ = g.aZ(fV.appId, false);
            if (g.h(aZ) && !com.tencent.mm.ui.chatting.i.an(auVar)) {
                if (fV.type == 6) {
                    com.tencent.mm.pluginsdk.model.app.b Sn = l.Sn(fV.for);
                    if ((Sn == null || !b.c(auVar, Sn.field_fileFullPath)) && !auVar.ckh()) {
                        contextMenu.add(i, 111, 0, this.yyH.getString(R.l.eEP));
                    }
                } else {
                    contextMenu.add(i, 111, 0, this.yyH.getString(R.l.eEP));
                }
            }
            if (fV.hcM <= 0 || (fV.hcM > 0 && Sm >= 100)) {
                boolean LR;
                switch (fV.type) {
                    case 1:
                        LR = com.tencent.mm.af.f.LR();
                        break;
                    case 2:
                        LR = com.tencent.mm.af.f.LT();
                        break;
                    case 3:
                        LR = com.tencent.mm.af.f.Mc();
                        break;
                    case 4:
                        LR = com.tencent.mm.af.f.LU();
                        break;
                    case 5:
                        LR = com.tencent.mm.af.f.Ma();
                        break;
                    case 6:
                        LR = com.tencent.mm.af.f.Mb();
                        break;
                    case 8:
                        LR = com.tencent.mm.af.f.LY();
                        break;
                    case 16:
                        if (fV.hdW != 5 && fV.hdW != 6 && fV.hdW != 2) {
                            LR = false;
                            break;
                        }
                        if (fV.hdW != 2) {
                            contextMenu.clear();
                        }
                        contextMenu.add(i, 100, 0, this.yyH.getString(R.l.dRS));
                        return false;
                    case 34:
                        contextMenu.clear();
                        contextMenu.add(i, 100, 0, this.yyH.getString(R.l.dRS));
                        return false;
                    default:
                        LR = false;
                        break;
                }
                if (LR && !this.yyH.ctJ()) {
                    contextMenu.add(i, 114, 0, view.getContext().getString(R.l.dRO));
                }
            }
            if (com.tencent.mm.bl.d.Pu("favorite") && (aZ == null || !aZ.YI())) {
                switch (fV.type) {
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                    case 10:
                    case 13:
                    case 19:
                    case 20:
                    case 24:
                        contextMenu.add(i, 116, 0, view.getContext().getString(R.l.eAq));
                        break;
                }
            }
            com.tencent.mm.sdk.b.b diVar = new di();
            diVar.fsL.frh = auVar.field_msgId;
            com.tencent.mm.sdk.b.a.xmy.m(diVar);
            if (diVar.fsM.fsk || b.a(this.yyH.getContext(), fV)) {
                contextMenu.add(i, FileUtils.S_IWUSR, 0, view.getContext().getString(R.l.dRX));
            }
            if (!this.yyH.ctJ()) {
                contextMenu.add(i, 100, 0, this.yyH.getString(R.l.dRS));
            }
            return true;
        }

        public final boolean a(MenuItem menuItem, com.tencent.mm.ui.chatting.ChattingUI.a aVar, au auVar) {
            com.tencent.mm.x.g.a aVar2;
            switch (menuItem.getItemId()) {
                case 100:
                    String str = auVar.field_content;
                    aVar2 = null;
                    if (str != null) {
                        aVar2 = com.tencent.mm.x.g.a.fV(str);
                    }
                    if (aVar2 != null) {
                        l.fr(auVar.field_msgId);
                        if (19 == aVar2.type) {
                            com.tencent.mm.sdk.b.b mvVar = new mv();
                            mvVar.fFz.type = 3;
                            mvVar.fFz.frh = auVar.field_msgId;
                            com.tencent.mm.sdk.b.a.xmy.m(mvVar);
                        }
                    }
                    bb.aL(auVar.field_msgId);
                    com.tencent.mm.pluginsdk.model.app.f aZ = g.aZ(aVar2.appId, false);
                    if (aZ != null && aZ.YI()) {
                        b.a(aVar, aVar2, auVar, aZ);
                        break;
                    }
                case 111:
                    b.a(aVar, auVar, a(aVar, auVar));
                    break;
                case 114:
                    String str2 = auVar.field_content;
                    if (str2 != null) {
                        aVar2 = com.tencent.mm.x.g.a.fV(str2);
                        if (aVar2 != null) {
                            switch (aVar2.type) {
                                case 1:
                                    ah.k(aVar.dn(auVar.field_content, auVar.field_isSend), aVar.getContext());
                                    break;
                                case 2:
                                    ah.a(auVar, aVar.getContext(), a(aVar, auVar), aVar.yAR);
                                    break;
                                case 3:
                                    ah.a(auVar, aVar.dn(auVar.field_content, auVar.field_isSend), aVar.getContext());
                                    break;
                                case 4:
                                    ah.a(auVar, aVar.getContext());
                                    break;
                                case 5:
                                    ah.c(auVar, aVar.dn(auVar.field_content, auVar.field_isSend), aVar.getContext());
                                    break;
                                case 6:
                                    ah.b(auVar, aVar.dn(auVar.field_content, auVar.field_isSend), aVar.getContext());
                                    break;
                                case 8:
                                    ah.b(auVar, aVar.getContext());
                                    break;
                            }
                        }
                    }
                    break;
            }
            return false;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean b(android.view.View r16, com.tencent.mm.ui.chatting.ChattingUI.a r17, com.tencent.mm.storage.au r18) {
            /*
            r15 = this;
            r2 = com.tencent.mm.modelstat.a.a.Click;
            r0 = r18;
            com.tencent.mm.modelstat.a.a(r0, r2);
            r0 = r18;
            r4 = r0.field_content;
            r2 = 0;
            r2 = java.lang.Boolean.valueOf(r2);
            if (r4 != 0) goto L_0x0014;
        L_0x0012:
            r2 = 0;
        L_0x0013:
            return r2;
        L_0x0014:
            r0 = r18;
            r3 = r0.field_isSend;
            r0 = r17;
            r3 = r0.dn(r4, r3);
            r3 = com.tencent.mm.x.g.a.fV(r3);
            r4 = com.tencent.mm.x.k.fZ(r4);
            if (r3 != 0) goto L_0x002a;
        L_0x0028:
            r2 = 0;
            goto L_0x0013;
        L_0x002a:
            r5 = r4.hfL;
            if (r5 == 0) goto L_0x0037;
        L_0x002e:
            r2 = 1;
            r2 = java.lang.Boolean.valueOf(r2);
            r4 = r4.hfL;
            r3.type = r4;
        L_0x0037:
            r8 = r2;
            r2 = r3.appId;
            r4 = 0;
            r5 = com.tencent.mm.pluginsdk.model.app.g.aZ(r2, r4);
            if (r5 == 0) goto L_0x0054;
        L_0x0041:
            r2 = r5.YI();
            if (r2 == 0) goto L_0x0054;
        L_0x0047:
            r4 = com.tencent.mm.ui.chatting.viewitems.b.c(r17, r18);
            r0 = r18;
            r6 = r0.field_msgSvrId;
            r2 = r17;
            com.tencent.mm.ui.chatting.viewitems.b.a(r2, r3, r4, r5, r6);
        L_0x0054:
            r7 = 0;
            r2 = r3.type;
            switch(r2) {
                case 3: goto L_0x00b1;
                case 4: goto L_0x00cd;
                case 6: goto L_0x0138;
                case 7: goto L_0x0167;
                case 10: goto L_0x01c1;
                case 13: goto L_0x0249;
                case 16: goto L_0x02b1;
                case 19: goto L_0x027d;
                case 20: goto L_0x0205;
                case 24: goto L_0x04f7;
                case 33: goto L_0x02e6;
                case 34: goto L_0x0527;
                case 36: goto L_0x042e;
                default: goto L_0x005a;
            };
        L_0x005a:
            r2 = 1;
        L_0x005b:
            if (r2 == 0) goto L_0x07cc;
        L_0x005d:
            r2 = r3.url;
            if (r2 == 0) goto L_0x07cc;
        L_0x0061:
            r2 = r3.url;
            r4 = "";
            r2 = r2.equals(r4);
            if (r2 != 0) goto L_0x07cc;
        L_0x006c:
            r2 = r3.canvasPageXml;
            r2 = com.tencent.mm.sdk.platformtools.bi.oN(r2);
            if (r2 != 0) goto L_0x0584;
        L_0x0074:
            r2 = new android.content.Intent;
            r2.<init>();
            r4 = "sns_landig_pages_from_source";
            r5 = 5;
            r2.putExtra(r4, r5);
            r4 = "msg_id";
            r0 = r18;
            r6 = r0.field_msgId;
            r2.putExtra(r4, r6);
            r4 = "sns_landing_pages_xml";
            r3 = r3.canvasPageXml;
            r2.putExtra(r4, r3);
            r3 = "sns_landing_pages_share_thumb_url";
            r0 = r18;
            r4 = r0.field_imgPath;
            r2.putExtra(r3, r4);
            r3 = 268435456; // 0x10000000 float:2.5243549E-29 double:1.32624737E-315;
            r2.addFlags(r3);
            r3 = r17.getContext();
            r4 = "sns";
            r5 = ".ui.SnsAdNativeLandingPagesPreviewUI";
            com.tencent.mm.bl.d.b(r3, r4, r5, r2);
            r2 = 1;
            goto L_0x0013;
        L_0x00b1:
            r2 = com.tencent.mm.plugin.report.service.g.pWK;
            r4 = 13043; // 0x32f3 float:1.8277E-41 double:6.444E-320;
            r5 = 3;
            r5 = new java.lang.Object[r5];
            r6 = 0;
            r7 = 2;
            r7 = java.lang.Integer.valueOf(r7);
            r5[r6] = r7;
            r6 = 1;
            r7 = r3.description;
            r5[r6] = r7;
            r6 = 2;
            r7 = r3.appId;
            r5[r6] = r7;
            r2.h(r4, r5);
        L_0x00cd:
            r2 = r17.getContext();
            r2 = com.tencent.mm.o.a.aW(r2);
            if (r2 != 0) goto L_0x00e1;
        L_0x00d7:
            r2 = r17.getContext();
            r2 = com.tencent.mm.o.a.aU(r2);
            if (r2 == 0) goto L_0x00ed;
        L_0x00e1:
            r2 = "MicroMsg.ChattingItemAppMsgFrom";
            r3 = "Voip is running, can't do this";
            com.tencent.mm.sdk.platformtools.x.i(r2, r3);
            r2 = 1;
            goto L_0x0013;
        L_0x00ed:
            r0 = r17;
            r1 = r18;
            r2 = r15.a(r0, r3, r1);
            if (r2 == 0) goto L_0x00fa;
        L_0x00f7:
            r2 = 1;
            goto L_0x0013;
        L_0x00fa:
            r2 = r3.url;
            r4 = "message";
            r4 = com.tencent.mm.pluginsdk.model.app.p.A(r2, r4);
            r2 = r3.hcL;
            r5 = "message";
            r5 = com.tencent.mm.pluginsdk.model.app.p.A(r2, r5);
            r2 = r17.getContext();
            r6 = r3.appId;
            r2 = com.tencent.mm.ui.chatting.viewitems.b.getPackageInfo(r2, r6);
            if (r2 != 0) goto L_0x0132;
        L_0x0118:
            r6 = 0;
        L_0x0119:
            if (r2 != 0) goto L_0x0135;
        L_0x011b:
            r7 = 0;
        L_0x011c:
            r8 = r3.appId;
            r9 = 1;
            r0 = r18;
            r10 = r0.field_msgId;
            r0 = r18;
            r12 = r0.field_msgSvrId;
            r2 = r15;
            r3 = r17;
            r14 = r18;
            r2.a(r3, r4, r5, r6, r7, r8, r9, r10, r12, r14);
            r2 = 1;
            goto L_0x0013;
        L_0x0132:
            r6 = r2.versionName;
            goto L_0x0119;
        L_0x0135:
            r7 = r2.versionCode;
            goto L_0x011c;
        L_0x0138:
            r2 = r15.vGb;
            if (r2 != 0) goto L_0x0146;
        L_0x013c:
            r2 = r17.getContext();
            com.tencent.mm.ui.base.u.fJ(r2);
            r2 = 1;
            goto L_0x0013;
        L_0x0146:
            r2 = new android.content.Intent;
            r2.<init>();
            r3 = r17.getContext();
            r4 = "com.tencent.mm.ui.chatting.AppAttachDownloadUI";
            r2.setClassName(r3, r4);
            r3 = "app_msg_id";
            r0 = r18;
            r4 = r0.field_msgId;
            r2.putExtra(r3, r4);
            r0 = r17;
            r0.startActivity(r2);
            r2 = 1;
            goto L_0x0013;
        L_0x0167:
            if (r5 == 0) goto L_0x017a;
        L_0x0169:
            r2 = r5.YI();
            if (r2 == 0) goto L_0x017a;
        L_0x016f:
            r0 = r17;
            r2 = com.tencent.mm.ui.chatting.viewitems.b.a(r0, r5);
            if (r2 == 0) goto L_0x017a;
        L_0x0177:
            r2 = 1;
            goto L_0x0013;
        L_0x017a:
            r2 = r3.for;
            if (r2 == 0) goto L_0x0186;
        L_0x017e:
            r2 = r3.for;
            r2 = r2.length();
            if (r2 != 0) goto L_0x0192;
        L_0x0186:
            r0 = r17;
            r2 = r0.yEI;
            r0 = r18;
            r2.aM(r0);
        L_0x018f:
            r2 = 1;
            goto L_0x0013;
        L_0x0192:
            r2 = r15.vGb;
            if (r2 != 0) goto L_0x01a0;
        L_0x0196:
            r2 = r17.getContext();
            com.tencent.mm.ui.base.u.fJ(r2);
            r2 = 1;
            goto L_0x0013;
        L_0x01a0:
            r2 = new android.content.Intent;
            r2.<init>();
            r3 = r17.getContext();
            r4 = "com.tencent.mm.ui.chatting.AppAttachDownloadUI";
            r2.setClassName(r3, r4);
            r3 = "app_msg_id";
            r0 = r18;
            r4 = r0.field_msgId;
            r2.putExtra(r3, r4);
            r3 = 210; // 0xd2 float:2.94E-43 double:1.04E-321;
            r0 = r17;
            r0.startActivityForResult(r2, r3);
            goto L_0x018f;
        L_0x01c1:
            r2 = r3.hdi;
            r2 = com.tencent.mm.sdk.platformtools.bi.oN(r2);
            if (r2 == 0) goto L_0x01cc;
        L_0x01c9:
            r2 = 0;
            goto L_0x0013;
        L_0x01cc:
            r2 = new android.content.Intent;
            r2.<init>();
            r4 = 65536; // 0x10000 float:9.18355E-41 double:3.2379E-319;
            r2.setFlags(r4);
            r4 = "key_Product_xml";
            r3 = r3.hdi;
            r2.putExtra(r4, r3);
            r3 = "key_ProductUI_getProductInfoScene";
            r4 = 1;
            r2.putExtra(r3, r4);
            r0 = r18;
            r3 = r0.field_imgPath;
            if (r3 != 0) goto L_0x01f5;
        L_0x01eb:
            r3 = "key_ProductUI_chatting_msgId";
            r0 = r18;
            r4 = r0.field_msgId;
            r2.putExtra(r3, r4);
        L_0x01f5:
            r3 = r17.getContext();
            r4 = "scanner";
            r5 = ".ui.ProductUI";
            com.tencent.mm.bl.d.b(r3, r4, r5, r2);
            r2 = 1;
            goto L_0x0013;
        L_0x0205:
            r2 = r3.hdl;
            r2 = com.tencent.mm.sdk.platformtools.bi.oN(r2);
            if (r2 == 0) goto L_0x0210;
        L_0x020d:
            r2 = 0;
            goto L_0x0013;
        L_0x0210:
            r2 = new android.content.Intent;
            r2.<init>();
            r4 = 65536; // 0x10000 float:9.18355E-41 double:3.2379E-319;
            r2.setFlags(r4);
            r4 = "key_TV_xml";
            r3 = r3.hdl;
            r2.putExtra(r4, r3);
            r3 = "key_TV_getProductInfoScene";
            r4 = 1;
            r2.putExtra(r3, r4);
            r0 = r18;
            r3 = r0.field_imgPath;
            if (r3 != 0) goto L_0x0239;
        L_0x022f:
            r3 = "key_TVInfoUI_chatting_msgId";
            r0 = r18;
            r4 = r0.field_msgId;
            r2.putExtra(r3, r4);
        L_0x0239:
            r3 = r17.getContext();
            r4 = "shake";
            r5 = ".ui.TVInfoUI";
            com.tencent.mm.bl.d.b(r3, r4, r5, r2);
            r2 = 1;
            goto L_0x0013;
        L_0x0249:
            r2 = r3.hdo;
            r2 = com.tencent.mm.sdk.platformtools.bi.oN(r2);
            if (r2 == 0) goto L_0x0254;
        L_0x0251:
            r2 = 0;
            goto L_0x0013;
        L_0x0254:
            r2 = new android.content.Intent;
            r2.<init>();
            r4 = 65536; // 0x10000 float:9.18355E-41 double:3.2379E-319;
            r2.setFlags(r4);
            r4 = "key_product_info";
            r3 = r3.hdo;
            r2.putExtra(r4, r3);
            r3 = "key_product_scene";
            r4 = 1;
            r2.putExtra(r3, r4);
            r3 = r17.getContext();
            r4 = "product";
            r5 = ".ui.MallProductUI";
            com.tencent.mm.bl.d.b(r3, r4, r5, r2);
            r2 = 1;
            goto L_0x0013;
        L_0x027d:
            r2 = new android.content.Intent;
            r2.<init>();
            r4 = "message_id";
            r0 = r18;
            r6 = r0.field_msgId;
            r2.putExtra(r4, r6);
            r4 = "record_xml";
            r3 = r3.hdm;
            r2.putExtra(r4, r3);
            r3 = "big_appmsg";
            r2.putExtra(r3, r8);
            r0 = r17;
            r1 = r18;
            com.tencent.mm.ui.chatting.viewitems.c.a.a(r2, r0, r1, r15);
            r3 = r17.getContext();
            r4 = "record";
            r5 = ".ui.RecordMsgDetailUI";
            com.tencent.mm.bl.d.b(r3, r4, r5, r2);
            r2 = 1;
            goto L_0x0013;
        L_0x02b1:
            r2 = r3.fzn;
            r2 = com.tencent.mm.sdk.platformtools.bi.oN(r2);
            if (r2 == 0) goto L_0x02bc;
        L_0x02b9:
            r2 = 0;
            goto L_0x0013;
        L_0x02bc:
            r2 = new android.content.Intent;
            r2.<init>();
            r4 = 65536; // 0x10000 float:9.18355E-41 double:3.2379E-319;
            r2.setFlags(r4);
            r4 = "key_card_app_msg";
            r5 = r3.fzn;
            r2.putExtra(r4, r5);
            r4 = "key_from_scene";
            r3 = r3.hdW;
            r2.putExtra(r4, r3);
            r3 = r17.getContext();
            r4 = "card";
            r5 = ".ui.CardDetailUI";
            com.tencent.mm.bl.d.b(r3, r4, r5, r2);
            r2 = 1;
            goto L_0x0013;
        L_0x02e6:
            r2 = "MicroMsg.ChattingItemAppMsgFrom";
            r4 = "username: %s , path: %s ,appid %s ,url : %s, pkgType : %s, md5 : %s";
            r5 = 6;
            r5 = new java.lang.Object[r5];
            r6 = 0;
            r8 = r3.hfi;
            r5[r6] = r8;
            r6 = 1;
            r8 = r3.hfh;
            r5[r6] = r8;
            r6 = 2;
            r8 = r3.hfj;
            r5[r6] = r8;
            r6 = 3;
            r8 = r3.url;
            r5[r6] = r8;
            r6 = 4;
            r8 = r3.hfp;
            r8 = java.lang.Integer.valueOf(r8);
            r5[r6] = r8;
            r6 = 5;
            r8 = r3.hfl;
            r5[r6] = r8;
            com.tencent.mm.sdk.platformtools.x.i(r2, r4, r5);
            r8 = r17.csn();
            r0 = r17;
            r1 = r18;
            r9 = r15.a(r0, r1);
            r6 = new android.os.Bundle;
            r6.<init>();
            r0 = r17;
            r2 = r0 instanceof com.tencent.mm.ui.chatting.AppBrandServiceChattingUI.a;
            if (r2 == 0) goto L_0x0369;
        L_0x032b:
            r4 = "stat_scene";
            r2 = 10;
            r5 = r6;
        L_0x0331:
            r5.putInt(r4, r2);
            r2 = "stat_msg_id";
            r4 = new java.lang.StringBuilder;
            r5 = "msg_";
            r4.<init>(r5);
            r0 = r18;
            r10 = r0.field_msgSvrId;
            r5 = java.lang.Long.toString(r10);
            r4 = r4.append(r5);
            r4 = r4.toString();
            r6.putString(r2, r4);
            r2 = "stat_chat_talker_username";
            r6.putString(r2, r8);
            r2 = "stat_send_msg_user";
            r6.putString(r2, r9);
            r2 = r3.hfk;
            switch(r2) {
                case 1: goto L_0x0384;
                case 2: goto L_0x03fe;
                case 3: goto L_0x0424;
                default: goto L_0x0363;
            };
        L_0x0363:
            r2 = 1;
        L_0x0364:
            if (r2 != 0) goto L_0x005b;
        L_0x0366:
            r2 = 1;
            goto L_0x0013;
        L_0x0369:
            r0 = r17;
            r2 = r0.yAR;
            if (r2 == 0) goto L_0x0375;
        L_0x036f:
            r4 = "stat_scene";
            r2 = 2;
            r5 = r6;
            goto L_0x0331;
        L_0x0375:
            r4 = "stat_scene";
            r2 = com.tencent.mm.y.s.gI(r8);
            if (r2 == 0) goto L_0x0381;
        L_0x037e:
            r2 = 7;
            r5 = r6;
            goto L_0x0331;
        L_0x0381:
            r2 = 1;
            r5 = r6;
            goto L_0x0331;
        L_0x0384:
            r2 = new android.content.Intent;
            r2.<init>();
            r4 = "key_username";
            r5 = r3.hfi;
            r2.putExtra(r4, r5);
            r0 = r17;
            r4 = r0.yAR;
            if (r4 == 0) goto L_0x03f0;
        L_0x0397:
            r4 = "key_from_scene";
            r5 = 1;
            r2.putExtra(r4, r5);
            r4 = "key_scene_note";
            r5 = new java.lang.StringBuilder;
            r5.<init>();
            r5 = r5.append(r8);
            r8 = ":";
            r5 = r5.append(r8);
            r5 = r5.append(r9);
            r5 = r5.toString();
            r2.putExtra(r4, r5);
        L_0x03bc:
            r4 = new com.tencent.mm.plugin.appbrand.config.WxaExposedParams$a;
            r4.<init>();
            r5 = r3.hfj;
            r4.appId = r5;
            r5 = 6;
            r4.fqZ = r5;
            r5 = r3.hfp;
            r4.iJa = r5;
            r5 = r3.hfm;
            r4.iJb = r5;
            r5 = "key_scene_exposed_params";
            r4 = r4.acv();
            r2.putExtra(r5, r4);
            r4 = "_stat_obj";
            r2.putExtra(r4, r6);
            r4 = r17.getContext();
            r5 = "appbrand";
            r6 = ".ui.AppBrandProfileUI";
            com.tencent.mm.bl.d.b(r4, r5, r6, r2);
            r2 = r7;
            goto L_0x0364;
        L_0x03f0:
            r4 = "key_from_scene";
            r5 = 2;
            r2.putExtra(r4, r5);
            r4 = "key_scene_note";
            r2.putExtra(r4, r8);
            goto L_0x03bc;
        L_0x03fe:
            r0 = r17;
            r2 = r0 instanceof com.tencent.mm.ui.chatting.AppBrandServiceChattingUI.a;
            if (r2 == 0) goto L_0x040c;
        L_0x0404:
            r2 = 1073; // 0x431 float:1.504E-42 double:5.3E-321;
            com.tencent.mm.modelappbrand.a.a(r8, r2, r3, r6);
            r2 = r7;
            goto L_0x0364;
        L_0x040c:
            r2 = com.tencent.mm.y.s.gI(r8);
            if (r2 == 0) goto L_0x041a;
        L_0x0412:
            r2 = 1074; // 0x432 float:1.505E-42 double:5.306E-321;
            com.tencent.mm.modelappbrand.a.a(r8, r2, r3, r6);
            r2 = r7;
            goto L_0x0364;
        L_0x041a:
            r0 = r17;
            r2 = r0.yAR;
            com.tencent.mm.modelappbrand.a.a(r8, r9, r2, r3, r6);
            r2 = r7;
            goto L_0x0364;
        L_0x0424:
            r0 = r17;
            r2 = r0.yAR;
            com.tencent.mm.modelappbrand.a.b(r8, r9, r2, r3, r6);
            r2 = r7;
            goto L_0x0364;
        L_0x042e:
            r2 = r3.hfj;
            r2 = com.tencent.mm.sdk.platformtools.bi.oN(r2);
            if (r2 == 0) goto L_0x047c;
        L_0x0436:
            r2 = r3.hfi;
            r2 = com.tencent.mm.sdk.platformtools.bi.oN(r2);
            if (r2 == 0) goto L_0x047c;
        L_0x043e:
            r4 = r3.url;
            r0 = r17;
            r2 = r0.yAR;
            if (r2 == 0) goto L_0x0478;
        L_0x0446:
            r2 = "groupmessage";
        L_0x0449:
            r2 = com.tencent.mm.pluginsdk.model.app.p.A(r4, r2);
            r4 = new android.content.Intent;
            r4.<init>();
            r5 = "rawUrl";
            r4.putExtra(r5, r2);
            r2 = "webpageTitle";
            r5 = r3.title;
            r4.putExtra(r2, r5);
            r2 = "shortUrl";
            r3 = r3.url;
            r4.putExtra(r2, r3);
            r2 = r17.getContext();
            r3 = "webview";
            r5 = ".ui.tools.WebViewUI";
            com.tencent.mm.bl.d.b(r2, r3, r5, r4);
            r2 = 1;
            goto L_0x0013;
        L_0x0478:
            r2 = "singlemessage";
            goto L_0x0449;
        L_0x047c:
            r7 = r17.csn();
            r0 = r17;
            r1 = r18;
            r8 = r15.a(r0, r1);
            r6 = new android.os.Bundle;
            r6.<init>();
            r0 = r17;
            r2 = r0.yAR;
            if (r2 == 0) goto L_0x04e8;
        L_0x0493:
            r4 = "stat_scene";
            r2 = 2;
            r5 = r6;
        L_0x0498:
            r5.putInt(r4, r2);
            r2 = "stat_msg_id";
            r4 = new java.lang.StringBuilder;
            r5 = "msg_";
            r4.<init>(r5);
            r0 = r18;
            r10 = r0.field_msgSvrId;
            r5 = java.lang.Long.toString(r10);
            r4 = r4.append(r5);
            r4 = r4.toString();
            r6.putString(r2, r4);
            r2 = "stat_chat_talker_username";
            r6.putString(r2, r7);
            r2 = "stat_send_msg_user";
            r6.putString(r2, r8);
            r2 = com.tencent.mm.plugin.appbrand.n.d.class;
            r4 = com.tencent.mm.kernel.g.h(r2);
            r4 = (com.tencent.mm.plugin.appbrand.n.d) r4;
            r5 = r17.getContext();
            r6 = r17.csn();
            r0 = r17;
            r1 = r18;
            r7 = r15.a(r0, r1);
            r0 = r17;
            r8 = r0.yAR;
            r9 = r3;
            r4.a(r5, r6, r7, r8, r9);
            r2 = 1;
            goto L_0x0013;
        L_0x04e8:
            r4 = "stat_scene";
            r2 = com.tencent.mm.y.s.gI(r7);
            if (r2 == 0) goto L_0x04f4;
        L_0x04f1:
            r2 = 7;
            r5 = r6;
            goto L_0x0498;
        L_0x04f4:
            r2 = 1;
            r5 = r6;
            goto L_0x0498;
        L_0x04f7:
            r2 = new com.tencent.mm.f.a.lj;
            r2.<init>();
            r4 = r2.fDA;
            r5 = r17.getContext();
            r4.context = r5;
            r4 = r2.fDA;
            r0 = r18;
            r6 = r0.field_msgId;
            r4.frh = r6;
            r4 = r2.fDA;
            r0 = r17;
            r5 = r0.yAR;
            r4.fCQ = r5;
            r4 = r2.fDA;
            r3 = r3.hdm;
            r4.fDB = r3;
            r3 = r2.fDA;
            r4 = 6;
            r3.scene = r4;
            r3 = com.tencent.mm.sdk.b.a.xmy;
            r3.m(r2);
            r2 = 1;
            goto L_0x0013;
        L_0x0527:
            r2 = new android.content.Intent;
            r2.<init>();
            r4 = "key_from_user_name";
            r0 = r17;
            r1 = r18;
            r5 = r15.a(r0, r1);
            r2.putExtra(r4, r5);
            r4 = "key_biz_uin";
            r5 = r3.hdY;
            r2.putExtra(r4, r5);
            r4 = "key_order_id";
            r3 = r3.hdZ;
            r2.putExtra(r4, r3);
            r0 = r18;
            r3 = r0.field_talker;
            if (r3 == 0) goto L_0x0574;
        L_0x0550:
            r0 = r18;
            r3 = r0.field_talker;
            r4 = "";
            r3 = r3.equals(r4);
            if (r3 != 0) goto L_0x0574;
        L_0x055d:
            r0 = r18;
            r3 = r0.field_talker;
            r4 = "@chatroom";
            r3 = r3.endsWith(r4);
            if (r3 == 0) goto L_0x0574;
        L_0x056a:
            r3 = "key_chatroom_name";
            r0 = r18;
            r4 = r0.field_talker;
            r2.putExtra(r3, r4);
        L_0x0574:
            r3 = r17.getContext();
            r4 = "card";
            r5 = ".ui.CardGiftAcceptUI";
            com.tencent.mm.bl.d.b(r3, r4, r5, r2);
            r2 = 1;
            goto L_0x0013;
        L_0x0584:
            r2 = com.tencent.mm.plugin.webview.fts.topstory.a.a.class;
            r2 = r3.r(r2);
            r2 = (com.tencent.mm.plugin.webview.fts.topstory.a.a) r2;
            if (r2 == 0) goto L_0x0618;
        L_0x058e:
            r4 = r2.ttO;
            r4 = com.tencent.mm.sdk.platformtools.bi.oN(r4);
            if (r4 != 0) goto L_0x0618;
        L_0x0596:
            r4 = new android.content.Intent;
            r4.<init>();
            r5 = "key_scene";
            r6 = 2;
            r4.putExtra(r5, r6);
            r5 = new com.tencent.mm.protocal.c.cbj;
            r5.<init>();
            r6 = r2.ttO;
            r5.ttO = r6;
            r6 = r2.ttP;
            r5.ttP = r6;
            r6 = r2.ttQ;
            r5.ttQ = r6;
            r6 = r2.ttR;
            r5.ttR = r6;
            r6 = r2.ttS;
            r5.ttS = r6;
            r6 = r2.skL;
            r5.skL = r6;
            r6 = r2.lUI;
            r5.lUI = r6;
            r6 = r2.lUJ;
            r5.lUJ = r6;
            r6 = r2.rlx;
            r5.rlx = r6;
            r6 = r2.skF;
            r5.skF = r6;
            r6 = r2.skG;
            r5.skG = r6;
            r6 = r2.skH;
            r5.skH = r6;
            r6 = r2.bhd;
            r5.bhd = r6;
            r6 = r2.pka;
            r5.pka = r6;
            r2 = r2.skM;
            r5.skM = r2;
            r2 = 0;
            r2 = r5.toByteArray();	 Catch:{ IOException -> 0x060a }
        L_0x05e8:
            if (r2 == 0) goto L_0x0618;
        L_0x05ea:
            r3 = 1;
            com.tencent.mm.ui.e.i.xMT = r3;
            r3 = "key_search_web_data";
            r4.putExtra(r3, r2);
            r2 = "key_proxy_fts_rec_ui";
            r3 = 1;
            r4.putExtra(r2, r3);
            r2 = r17.getContext();
            r3 = "webview";
            r5 = ".fts.topstory.ui.TopStoryVideoListUI";
            com.tencent.mm.bl.d.b(r2, r3, r5, r4);
            r2 = 1;
            goto L_0x0013;
        L_0x060a:
            r5 = move-exception;
            r6 = "MicroMsg.ChattingItemAppMsgFrom";
            r7 = "";
            r8 = 0;
            r8 = new java.lang.Object[r8];
            com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r6, r5, r7, r8);
            goto L_0x05e8;
        L_0x0618:
            r4 = r3.url;
            r0 = r17;
            r2 = r0.yAR;
            if (r2 == 0) goto L_0x07af;
        L_0x0620:
            r2 = "groupmessage";
        L_0x0623:
            r2 = com.tencent.mm.pluginsdk.model.app.p.A(r4, r2);
            r4 = r3.url;
            r5 = r17.getContext();
            r6 = r3.appId;
            r5 = com.tencent.mm.ui.chatting.viewitems.b.getPackageInfo(r5, r6);
            r6 = new android.content.Intent;
            r6.<init>();
            r7 = "rawUrl";
            r6.putExtra(r7, r2);
            r2 = "webpageTitle";
            r7 = r3.title;
            r6.putExtra(r2, r7);
            r2 = r3.appId;
            if (r2 == 0) goto L_0x067e;
        L_0x064a:
            r2 = "wx751a1acca5688ba3";
            r7 = r3.appId;
            r2 = r2.equals(r7);
            if (r2 != 0) goto L_0x066b;
        L_0x0655:
            r2 = "wxfbc915ff7c30e335";
            r7 = r3.appId;
            r2 = r2.equals(r7);
            if (r2 != 0) goto L_0x066b;
        L_0x0660:
            r2 = "wx482a4001c37e2b74";
            r7 = r3.appId;
            r2 = r2.equals(r7);
            if (r2 == 0) goto L_0x067e;
        L_0x066b:
            r2 = new android.os.Bundle;
            r2.<init>();
            r7 = "jsapi_args_appid";
            r8 = r3.appId;
            r2.putString(r7, r8);
            r7 = "jsapiargs";
            r6.putExtra(r7, r2);
        L_0x067e:
            r2 = com.tencent.mm.sdk.platformtools.bi.oN(r4);
            if (r2 != 0) goto L_0x07b4;
        L_0x0684:
            r2 = "shortUrl";
            r6.putExtra(r2, r4);
        L_0x068a:
            r4 = "version_name";
            if (r5 != 0) goto L_0x07be;
        L_0x068f:
            r2 = 0;
        L_0x0690:
            r6.putExtra(r4, r2);
            r4 = "version_code";
            if (r5 != 0) goto L_0x07c2;
        L_0x0698:
            r2 = 0;
        L_0x0699:
            r6.putExtra(r4, r2);
            r2 = r3.fHu;
            r2 = com.tencent.mm.sdk.platformtools.bi.oN(r2);
            if (r2 != 0) goto L_0x06b4;
        L_0x06a4:
            r2 = "srcUsername";
            r4 = r3.fHu;
            r6.putExtra(r2, r4);
            r2 = "srcDisplayname";
            r4 = r3.fHv;
            r6.putExtra(r2, r4);
        L_0x06b4:
            r2 = "msg_id";
            r0 = r18;
            r4 = r0.field_msgId;
            r6.putExtra(r2, r4);
            r2 = "KPublisherId";
            r4 = new java.lang.StringBuilder;
            r5 = "msg_";
            r4.<init>(r5);
            r0 = r18;
            r8 = r0.field_msgSvrId;
            r5 = java.lang.Long.toString(r8);
            r4 = r4.append(r5);
            r4 = r4.toString();
            r6.putExtra(r2, r4);
            r2 = "KAppId";
            r4 = r3.appId;
            r6.putExtra(r2, r4);
            r2 = "geta8key_username";
            r4 = r17.csn();
            r6.putExtra(r2, r4);
            r2 = "pre_username";
            r0 = r17;
            r1 = r18;
            r4 = r15.a(r0, r1);
            r6.putExtra(r2, r4);
            r2 = "from_scence";
            r4 = 2;
            r6.putExtra(r2, r4);
            r2 = "expid_str";
            r0 = r18;
            r4 = r0.gkM;
            r6.putExtra(r2, r4);
            r0 = r17;
            r1 = r18;
            r2 = r15.a(r0, r1);
            r4 = r17.csn();
            r2 = com.tencent.mm.y.t.N(r2, r4);
            r4 = "prePublishId";
            r5 = new java.lang.StringBuilder;
            r7 = "msg_";
            r5.<init>(r7);
            r0 = r18;
            r8 = r0.field_msgSvrId;
            r7 = java.lang.Long.toString(r8);
            r5 = r5.append(r7);
            r5 = r5.toString();
            r6.putExtra(r4, r5);
            r4 = "preUsername";
            r0 = r17;
            r1 = r18;
            r5 = r15.a(r0, r1);
            r6.putExtra(r4, r5);
            r4 = "preChatName";
            r5 = r17.csn();
            r6.putExtra(r4, r5);
            r4 = "preChatTYPE";
            r6.putExtra(r4, r2);
            r4 = "preMsgIndex";
            r5 = 0;
            r6.putExtra(r4, r5);
            switch(r2) {
                case 1: goto L_0x07c8;
                case 2: goto L_0x07c6;
                case 3: goto L_0x0763;
                case 4: goto L_0x0763;
                case 5: goto L_0x0763;
                case 6: goto L_0x07ca;
                case 7: goto L_0x07ca;
                default: goto L_0x0763;
            };
        L_0x0763:
            r2 = 0;
        L_0x0764:
            r4 = "share_report_pre_msg_url";
            r5 = r3.url;
            r6.putExtra(r4, r5);
            r4 = "share_report_pre_msg_title";
            r5 = r3.title;
            r6.putExtra(r4, r5);
            r4 = "share_report_pre_msg_desc";
            r5 = r3.description;
            r6.putExtra(r4, r5);
            r4 = "share_report_pre_msg_icon_url";
            r5 = r3.thumburl;
            r6.putExtra(r4, r5);
            r4 = "share_report_pre_msg_appid";
            r3 = r3.appId;
            r6.putExtra(r4, r3);
            r3 = "share_report_from_scene";
            r6.putExtra(r3, r2);
            r3 = 5;
            if (r2 != r3) goto L_0x079f;
        L_0x0795:
            r2 = "share_report_biz_username";
            r3 = r17.csn();
            r6.putExtra(r2, r3);
        L_0x079f:
            r2 = r17.getContext();
            r3 = "webview";
            r4 = ".ui.tools.WebViewUI";
            com.tencent.mm.bl.d.b(r2, r3, r4, r6);
            r2 = 1;
            goto L_0x0013;
        L_0x07af:
            r2 = "singlemessage";
            goto L_0x0623;
        L_0x07b4:
            r2 = "shortUrl";
            r4 = r3.url;
            r6.putExtra(r2, r4);
            goto L_0x068a;
        L_0x07be:
            r2 = r5.versionName;
            goto L_0x0690;
        L_0x07c2:
            r2 = r5.versionCode;
            goto L_0x0699;
        L_0x07c6:
            r2 = 2;
            goto L_0x0764;
        L_0x07c8:
            r2 = 3;
            goto L_0x0764;
        L_0x07ca:
            r2 = 5;
            goto L_0x0764;
        L_0x07cc:
            r2 = 0;
            goto L_0x0013;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.chatting.viewitems.c.d.b(android.view.View, com.tencent.mm.ui.chatting.ChattingUI$a, com.tencent.mm.storage.au):boolean");
        }
    }

    public static class f {
        public String fAn;
        public String fDn;
        public long frh;
        public int ySy = -1;
    }

    static /* synthetic */ boolean a(com.tencent.mm.x.g.a aVar, c cVar) {
        if (!h(aVar)) {
            return false;
        }
        JSONObject Oy = com.tencent.mm.plugin.aj.a.h.Oy("discoverRecommendEntry");
        CharSequence optString = Oy.optString("wording");
        Oy.optString("androidIcon");
        cVar.yRE.setVisibility(0);
        cVar.mDG.setVisibility(0);
        cVar.mDG.setText(optString);
        cVar.yRB.setVisibility(0);
        cVar.yRB.setImageResource(R.g.bGX);
        return true;
    }

    static {
        com.tencent.mm.ap.a.a.c.a aVar = new com.tencent.mm.ap.a.a.c.a();
        aVar.hFj = true;
        aVar.hFl = true;
        liE = aVar.PQ();
    }

    private static boolean h(com.tencent.mm.x.g.a aVar) {
        com.tencent.mm.plugin.webview.fts.topstory.a.a aVar2 = (com.tencent.mm.plugin.webview.fts.topstory.a.a) aVar.r(com.tencent.mm.plugin.webview.fts.topstory.a.a.class);
        if (aVar2 == null || bi.oN(aVar2.ttO)) {
            return false;
        }
        return true;
    }
}
