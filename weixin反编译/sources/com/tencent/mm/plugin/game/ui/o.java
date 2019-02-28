package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.mm.R;
import com.tencent.mm.a.f;
import com.tencent.mm.plugin.game.d.b;
import com.tencent.mm.plugin.game.d.c;
import com.tencent.mm.plugin.game.d.e;
import com.tencent.mm.plugin.game.model.SubCoreGameCenter;
import com.tencent.mm.plugin.game.model.t;
import com.tencent.mm.plugin.game.model.t.h;
import com.tencent.mm.plugin.game.model.u;
import com.tencent.mm.plugin.game.model.x;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.y.as;
import java.util.LinkedList;

public final class o extends com.tencent.mm.ui.o<t> {
    private static y nyD;
    private int fof = 0;
    int hLP = 0;
    int las = 15;
    private Context mContext;
    private int niV = 0;
    private OnClickListener nyE;
    private OnClickListener nyF;
    private x nyG;
    private x nyH;
    private long nyI = 0;
    private int nyJ = 0;
    private u nyK;
    private f<String, Bitmap> nyL;

    static class a {
        public TextView jIt;
        public TextView kHt;
        public LinearLayout nyN;
        public ImageView nyO;
        public LinearLayout nyP;
        public ImageView nyQ;
        public TextView nyR;
        public LinearLayout nyS;
        public TextView nyT;
        public ImageView nyU;
        public ImageView nyV;
        public TextView nyW;
        public TextView nyX;
        public LinearLayout nyY;
        public GameMessageListContainerView nyZ;

        a() {
        }
    }

    protected final /* bridge */ /* synthetic */ Object aSn() {
        return (t) this.xQL;
    }

    public final /* synthetic */ Object getItem(int i) {
        return rr(i);
    }

    public o(Context context, t tVar, int i) {
        int i2 = 0;
        super(context, tVar);
        this.mContext = context;
        this.niV = i;
        Cursor rawQuery = SubCoreGameCenter.aRK().rawQuery("select count(*) from GameRawMessage where " + x.j(2, 5, 6, 10, 11, 100) + " and showInMsgList = 1" + " and isHidden = 0", new String[0]);
        if (rawQuery != null) {
            if (rawQuery.moveToFirst()) {
                i2 = rawQuery.getInt(0);
            }
            rawQuery.close();
        }
        this.hLP = i2;
        this.fof = SubCoreGameCenter.aRK().aRe();
        nyD = new y();
        this.nyE = new p(context, i);
        this.nyF = new q(context, i);
        this.nyG = new x(context);
        this.nyG.cK(i, 1);
        this.nyH = new x(context);
        this.nyH.cK(i, 2);
        this.nyK = new u(context, this.niV);
        i2 = c.getScreenWidth(this.mContext);
        this.nyJ = com.tencent.mm.bu.a.ad(this.mContext, ((i2 - (this.mContext.getResources().getDimensionPixelSize(R.f.buw) * 2)) - this.mContext.getResources().getDimensionPixelSize(R.f.bvm)) - this.mContext.getResources().getDimensionPixelSize(R.f.bvC)) / 34;
        this.nyL = new f(30);
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            aVar = new a();
            view = View.inflate(this.context, R.i.dkZ, null);
            aVar.nyO = (ImageView) view.findViewById(R.h.coQ);
            aVar.nyN = (LinearLayout) view.findViewById(R.h.cxA);
            aVar.nyP = (LinearLayout) view.findViewById(R.h.cxD);
            aVar.kHt = (TextView) view.findViewById(R.h.cAs);
            aVar.nyQ = (ImageView) view.findViewById(R.h.bMr);
            aVar.jIt = (TextView) view.findViewById(R.h.cSl);
            aVar.nyR = (TextView) view.findViewById(R.h.cxF);
            aVar.nyS = (LinearLayout) view.findViewById(R.h.cxH);
            aVar.nyT = (TextView) view.findViewById(R.h.cxJ);
            aVar.nyU = (ImageView) view.findViewById(R.h.cxI);
            aVar.nyV = (ImageView) view.findViewById(R.h.cxG);
            aVar.nyW = (TextView) view.findViewById(R.h.cxL);
            aVar.nyX = (TextView) view.findViewById(R.h.cxK);
            aVar.nyZ = (GameMessageListContainerView) view.findViewById(R.h.cxN);
            aVar.nyY = (LinearLayout) view.findViewById(R.h.cxE);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        t rr = rr(i);
        if (rr == null || !rr.niE) {
            if (rr != null) {
                rr.aQT();
                aVar.nyN.setVisibility(0);
                aVar.nyY.setVisibility(8);
                aVar.nyW.setText(b.f(this.context, rr.field_createTime * 1000));
                CharSequence charSequence;
                h hVar;
                if (rr.field_msgType != 100) {
                    Object obj;
                    int size;
                    String str;
                    aVar.jIt.setVisibility(8);
                    aVar.nyR.setVisibility(8);
                    aVar.nyS.setVisibility(8);
                    aVar.nyU.setVisibility(8);
                    aVar.nyV.setVisibility(8);
                    aVar.nyX.setVisibility(8);
                    aVar.nyX.setEnabled(false);
                    aVar.nyV.setEnabled(false);
                    aVar.nyO.setEnabled(false);
                    aVar.kHt.setEnabled(false);
                    aVar.nyZ.setVisibility(8);
                    aVar.nyQ.setVisibility(8);
                    charSequence = null;
                    if (!bi.cC(rr.nhS)) {
                        hVar = (h) rr.nhS.get(0);
                        as.Hm();
                        com.tencent.mm.storage.x Xv = com.tencent.mm.y.c.Ff().Xv(hVar.userName);
                        if (Xv != null) {
                            charSequence = Xv.AX();
                        }
                        if (bi.oN(charSequence)) {
                            charSequence = hVar.bgo;
                        }
                        if (!bi.oN(hVar.niQ)) {
                            obj = 1;
                            size = rr.nhS.size();
                            if (!bi.oN(rr.nhQ) && (rr.nig & 1) == 0) {
                                aVar.nyX.setText(rr.nhQ);
                                aVar.nyX.setVisibility(0);
                                if ((rr.nig & 2) <= 0) {
                                    aVar.nyX.setTextColor(this.context.getResources().getColor(R.e.bsB));
                                    aVar.nyX.setBackgroundResource(R.g.bCB);
                                    aVar.nyX.setOnClickListener(this.nyE);
                                    aVar.nyX.setTag(rr);
                                    aVar.nyX.setEnabled(true);
                                } else {
                                    aVar.nyX.setTextColor(this.context.getResources().getColor(R.e.bst));
                                    aVar.nyX.setBackgroundResource(0);
                                    aVar.nyX.setOnClickListener(null);
                                    aVar.nyX.setEnabled(false);
                                }
                            }
                            if (rr.field_msgType != 10 || rr.field_msgType == 11) {
                                if (!bi.oN(rr.mAppName)) {
                                    aVar.kHt.setText(i.b(this.context, rr.mAppName, aVar.kHt.getTextSize()), BufferType.SPANNABLE);
                                    aVar.kHt.setVisibility(0);
                                } else if (bi.oN(charSequence)) {
                                    aVar.kHt.setText(i.b(this.context, charSequence, aVar.kHt.getTextSize()));
                                    aVar.kHt.setVisibility(0);
                                } else {
                                    aVar.kHt.setVisibility(8);
                                }
                            } else if (bi.oN(charSequence)) {
                                aVar.kHt.setVisibility(8);
                            } else {
                                aVar.kHt.setText(i.b(this.context, charSequence, aVar.kHt.getTextSize()));
                                aVar.kHt.setVisibility(0);
                                if (obj != null) {
                                    aVar.kHt.setOnClickListener(this.nyG);
                                    aVar.kHt.setTag(rr);
                                    aVar.kHt.setEnabled(true);
                                }
                            }
                            switch (rr.field_msgType) {
                                case 2:
                                    e(aVar.nyO, rr.nhM);
                                    str = "礼物";
                                    if (rr.nid.contains("爱心")) {
                                        str = "爱心";
                                    } else if (rr.nid.contains("体力")) {
                                        str = "体力";
                                    }
                                    if (size <= 1) {
                                        aVar.jIt.setText(this.context.getResources().getString(R.l.emZ, new Object[]{String.valueOf(size), str}));
                                    } else {
                                        aVar.jIt.setText(this.context.getResources().getString(R.l.ena, new Object[]{str}));
                                    }
                                    aVar.jIt.setVisibility(0);
                                    a(rr, aVar);
                                    break;
                                case 5:
                                    if (bi.cC(rr.nhS)) {
                                        aVar.nyO.setVisibility(0);
                                        if (bi.oN(((h) rr.nhS.get(0)).niP)) {
                                            e(aVar.nyO, ((h) rr.nhS.get(0)).niP);
                                        } else {
                                            c(aVar.nyO, ((h) rr.nhS.get(0)).userName);
                                        }
                                        if (!bi.oN(((h) rr.nhS.get(0)).niQ)) {
                                            aVar.nyO.setOnClickListener(this.nyH);
                                            aVar.nyO.setTag(rr);
                                            aVar.nyO.setEnabled(true);
                                        }
                                    } else {
                                        aVar.nyO.setVisibility(8);
                                    }
                                    if (size <= 1) {
                                        aVar.jIt.setText(this.context.getResources().getString(R.l.emX, new Object[]{String.valueOf(size)}));
                                        a(rr, aVar);
                                    } else {
                                        aVar.jIt.setText(this.context.getResources().getString(R.l.emY));
                                    }
                                    aVar.nyS.setVisibility(0);
                                    aVar.jIt.setVisibility(0);
                                    aVar.nyT.setText(rr.nio);
                                    aVar.nyS.setOnClickListener(this.nyF);
                                    aVar.nyS.setTag(Long.valueOf(rr.field_msgId));
                                    if (!bi.oN(rr.niq)) {
                                        aVar.nyU.setVisibility(0);
                                        e(aVar.nyU, rr.niq);
                                        break;
                                    }
                                    break;
                                case 6:
                                    if (bi.cC(rr.nhS)) {
                                        aVar.nyO.setVisibility(0);
                                        if (bi.oN(((h) rr.nhS.get(0)).niP)) {
                                            e(aVar.nyO, ((h) rr.nhS.get(0)).niP);
                                        } else {
                                            c(aVar.nyO, ((h) rr.nhS.get(0)).userName);
                                        }
                                        if (!bi.oN(((h) rr.nhS.get(0)).niQ)) {
                                            aVar.nyO.setOnClickListener(this.nyH);
                                            aVar.nyO.setTag(rr);
                                            aVar.nyO.setEnabled(true);
                                        }
                                    } else {
                                        aVar.nyO.setVisibility(8);
                                    }
                                    aVar.nyS.setVisibility(0);
                                    aVar.nyS.setOnClickListener(this.nyF);
                                    aVar.nyS.setTag(Long.valueOf(rr.field_msgId));
                                    if (rr.jxZ == 1) {
                                        if (rr.jxZ == 2) {
                                            if (rr.jxZ == 3) {
                                                aVar.jIt.setVisibility(0);
                                                if (size <= 1) {
                                                    aVar.jIt.setText(this.context.getResources().getString(R.l.emV, new Object[]{String.valueOf(size)}));
                                                    a(rr, aVar);
                                                } else {
                                                    aVar.jIt.setText(this.context.getResources().getString(R.l.emW));
                                                }
                                                aVar.nyT.setText(rr.nin);
                                                break;
                                            }
                                        }
                                        aVar.nyR.setVisibility(0);
                                        aVar.nyR.setText(i.b(this.context, rr.nik, aVar.nyR.getTextSize()));
                                        aVar.nyT.setText(rr.nil);
                                        break;
                                    }
                                    aVar.nyR.setVisibility(0);
                                    aVar.nyR.setText(i.b(this.context, rr.nik, aVar.nyR.getTextSize()));
                                    aVar.nyT.setText(rr.nin);
                                    break;
                                    break;
                                case 10:
                                case 11:
                                    if (bi.oN(rr.nhM)) {
                                        e(aVar.nyO, rr.nhM);
                                        aVar.nyO.setVisibility(0);
                                    } else {
                                        com.tencent.mm.sdk.platformtools.x.e("MicroMsg.GameMessageAdapter", "mAppIcon is null");
                                        aVar.nyO.setVisibility(8);
                                    }
                                    if (!bi.oN(rr.lGV)) {
                                        if (bi.oN(rr.nhY)) {
                                            aVar.nyR.setText(rr.lGV);
                                            aVar.nyR.setVisibility(0);
                                        } else {
                                            aVar.nyS.setVisibility(0);
                                            aVar.nyT.setText(rr.lGV);
                                            aVar.nyS.setOnClickListener(this.nyF);
                                            aVar.nyS.setTag(Long.valueOf(rr.field_msgId));
                                        }
                                    }
                                    if (!bi.oN(rr.nhY)) {
                                        e(aVar.nyV, rr.nhY);
                                        aVar.nyV.setTag(Long.valueOf(rr.field_msgId));
                                        aVar.nyV.setOnTouchListener(nyD);
                                        aVar.nyV.setOnClickListener(this.nyF);
                                        aVar.nyV.setVisibility(0);
                                        aVar.nyV.setEnabled(true);
                                        break;
                                    }
                                    break;
                                default:
                                    com.tencent.mm.sdk.platformtools.x.e("MicroMsg.GameMessageAdapter", "error msgtype: " + rr.field_msgType);
                                    break;
                            }
                        }
                    }
                    obj = null;
                    size = rr.nhS.size();
                    aVar.nyX.setText(rr.nhQ);
                    aVar.nyX.setVisibility(0);
                    if ((rr.nig & 2) <= 0) {
                        aVar.nyX.setTextColor(this.context.getResources().getColor(R.e.bst));
                        aVar.nyX.setBackgroundResource(0);
                        aVar.nyX.setOnClickListener(null);
                        aVar.nyX.setEnabled(false);
                    } else {
                        aVar.nyX.setTextColor(this.context.getResources().getColor(R.e.bsB));
                        aVar.nyX.setBackgroundResource(R.g.bCB);
                        aVar.nyX.setOnClickListener(this.nyE);
                        aVar.nyX.setTag(rr);
                        aVar.nyX.setEnabled(true);
                    }
                    if (rr.field_msgType != 10) {
                    }
                    if (!bi.oN(rr.mAppName)) {
                        aVar.kHt.setText(i.b(this.context, rr.mAppName, aVar.kHt.getTextSize()), BufferType.SPANNABLE);
                        aVar.kHt.setVisibility(0);
                    } else if (bi.oN(charSequence)) {
                        aVar.kHt.setVisibility(8);
                    } else {
                        aVar.kHt.setText(i.b(this.context, charSequence, aVar.kHt.getTextSize()));
                        aVar.kHt.setVisibility(0);
                    }
                    switch (rr.field_msgType) {
                        case 2:
                            e(aVar.nyO, rr.nhM);
                            str = "礼物";
                            if (rr.nid.contains("爱心")) {
                                str = "爱心";
                            } else if (rr.nid.contains("体力")) {
                                str = "体力";
                            }
                            if (size <= 1) {
                                aVar.jIt.setText(this.context.getResources().getString(R.l.ena, new Object[]{str}));
                            } else {
                                aVar.jIt.setText(this.context.getResources().getString(R.l.emZ, new Object[]{String.valueOf(size), str}));
                            }
                            aVar.jIt.setVisibility(0);
                            a(rr, aVar);
                            break;
                        case 5:
                            if (bi.cC(rr.nhS)) {
                                aVar.nyO.setVisibility(8);
                            } else {
                                aVar.nyO.setVisibility(0);
                                if (bi.oN(((h) rr.nhS.get(0)).niP)) {
                                    c(aVar.nyO, ((h) rr.nhS.get(0)).userName);
                                } else {
                                    e(aVar.nyO, ((h) rr.nhS.get(0)).niP);
                                }
                                if (bi.oN(((h) rr.nhS.get(0)).niQ)) {
                                    aVar.nyO.setOnClickListener(this.nyH);
                                    aVar.nyO.setTag(rr);
                                    aVar.nyO.setEnabled(true);
                                }
                            }
                            if (size <= 1) {
                                aVar.jIt.setText(this.context.getResources().getString(R.l.emY));
                            } else {
                                aVar.jIt.setText(this.context.getResources().getString(R.l.emX, new Object[]{String.valueOf(size)}));
                                a(rr, aVar);
                            }
                            aVar.nyS.setVisibility(0);
                            aVar.jIt.setVisibility(0);
                            aVar.nyT.setText(rr.nio);
                            aVar.nyS.setOnClickListener(this.nyF);
                            aVar.nyS.setTag(Long.valueOf(rr.field_msgId));
                            if (bi.oN(rr.niq)) {
                                aVar.nyU.setVisibility(0);
                                e(aVar.nyU, rr.niq);
                                break;
                            }
                            break;
                        case 6:
                            if (bi.cC(rr.nhS)) {
                                aVar.nyO.setVisibility(8);
                            } else {
                                aVar.nyO.setVisibility(0);
                                if (bi.oN(((h) rr.nhS.get(0)).niP)) {
                                    c(aVar.nyO, ((h) rr.nhS.get(0)).userName);
                                } else {
                                    e(aVar.nyO, ((h) rr.nhS.get(0)).niP);
                                }
                                if (bi.oN(((h) rr.nhS.get(0)).niQ)) {
                                    aVar.nyO.setOnClickListener(this.nyH);
                                    aVar.nyO.setTag(rr);
                                    aVar.nyO.setEnabled(true);
                                }
                            }
                            aVar.nyS.setVisibility(0);
                            aVar.nyS.setOnClickListener(this.nyF);
                            aVar.nyS.setTag(Long.valueOf(rr.field_msgId));
                            if (rr.jxZ == 1) {
                                if (rr.jxZ == 2) {
                                    if (rr.jxZ == 3) {
                                        aVar.jIt.setVisibility(0);
                                        if (size <= 1) {
                                            aVar.jIt.setText(this.context.getResources().getString(R.l.emW));
                                        } else {
                                            aVar.jIt.setText(this.context.getResources().getString(R.l.emV, new Object[]{String.valueOf(size)}));
                                            a(rr, aVar);
                                        }
                                        aVar.nyT.setText(rr.nin);
                                        break;
                                    }
                                }
                                aVar.nyR.setVisibility(0);
                                aVar.nyR.setText(i.b(this.context, rr.nik, aVar.nyR.getTextSize()));
                                aVar.nyT.setText(rr.nil);
                                break;
                            }
                            aVar.nyR.setVisibility(0);
                            aVar.nyR.setText(i.b(this.context, rr.nik, aVar.nyR.getTextSize()));
                            aVar.nyT.setText(rr.nin);
                            break;
                            break;
                        case 10:
                        case 11:
                            if (bi.oN(rr.nhM)) {
                                com.tencent.mm.sdk.platformtools.x.e("MicroMsg.GameMessageAdapter", "mAppIcon is null");
                                aVar.nyO.setVisibility(8);
                            } else {
                                e(aVar.nyO, rr.nhM);
                                aVar.nyO.setVisibility(0);
                            }
                            if (bi.oN(rr.lGV)) {
                                if (bi.oN(rr.nhY)) {
                                    aVar.nyS.setVisibility(0);
                                    aVar.nyT.setText(rr.lGV);
                                    aVar.nyS.setOnClickListener(this.nyF);
                                    aVar.nyS.setTag(Long.valueOf(rr.field_msgId));
                                } else {
                                    aVar.nyR.setText(rr.lGV);
                                    aVar.nyR.setVisibility(0);
                                }
                            }
                            if (bi.oN(rr.nhY)) {
                                e(aVar.nyV, rr.nhY);
                                aVar.nyV.setTag(Long.valueOf(rr.field_msgId));
                                aVar.nyV.setOnTouchListener(nyD);
                                aVar.nyV.setOnClickListener(this.nyF);
                                aVar.nyV.setVisibility(0);
                                aVar.nyV.setEnabled(true);
                                break;
                            }
                            break;
                        default:
                            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.GameMessageAdapter", "error msgtype: " + rr.field_msgType);
                            break;
                    }
                }
                if (rr.niw != null) {
                    e(aVar.nyO, rr.niw.niM);
                    aVar.nyO.setVisibility(0);
                    if (bi.oN(rr.niw.niL)) {
                        aVar.kHt.setVisibility(8);
                    } else {
                        aVar.kHt.setText(rr.niw.niL);
                        aVar.kHt.setVisibility(0);
                    }
                    if (bi.oN(rr.niw.niN)) {
                        aVar.nyQ.setVisibility(8);
                    } else {
                        e(aVar.nyQ, rr.niw.niN);
                        aVar.nyQ.setVisibility(0);
                    }
                    if (bi.oN(rr.niw.niH)) {
                        aVar.kHt.setEnabled(false);
                        aVar.nyO.setEnabled(false);
                    } else {
                        aVar.kHt.setEnabled(true);
                        aVar.nyO.setEnabled(true);
                        com.tencent.mm.plugin.game.model.u.a aVar2 = new com.tencent.mm.plugin.game.model.u.a(rr, rr.niw.niH, 1);
                        com.tencent.mm.plugin.game.model.u.a aVar3 = new com.tencent.mm.plugin.game.model.u.a(rr, rr.niw.niH, 2);
                        aVar.kHt.setTag(aVar2);
                        aVar.kHt.setOnClickListener(this.nyK);
                        aVar.nyO.setTag(aVar3);
                        aVar.nyO.setOnClickListener(this.nyK);
                    }
                } else if (bi.cC(rr.nhS)) {
                    aVar.nyO.setVisibility(8);
                    aVar.kHt.setVisibility(8);
                    aVar.nyQ.setVisibility(8);
                } else {
                    hVar = (h) rr.nhS.get(0);
                    if (bi.oN(hVar.bgo)) {
                        as.Hm();
                        com.tencent.mm.storage.x Xv2 = com.tencent.mm.y.c.Ff().Xv(hVar.userName);
                        charSequence = (Xv2 == null || bi.oN(Xv2.AX())) ? hVar.userName : Xv2.AX();
                    } else {
                        charSequence = hVar.bgo;
                    }
                    if (bi.oN(hVar.niS)) {
                        aVar.kHt.setEnabled(false);
                        aVar.nyO.setEnabled(false);
                    } else {
                        aVar.kHt.setEnabled(true);
                        aVar.nyO.setEnabled(true);
                        com.tencent.mm.plugin.game.model.u.a aVar4 = new com.tencent.mm.plugin.game.model.u.a(rr, hVar.niS, 1);
                        com.tencent.mm.plugin.game.model.u.a aVar5 = new com.tencent.mm.plugin.game.model.u.a(rr, hVar.niS, 2);
                        aVar.kHt.setTag(aVar4);
                        aVar.kHt.setOnClickListener(this.nyK);
                        aVar.nyO.setTag(aVar5);
                        aVar.nyO.setOnClickListener(this.nyK);
                    }
                    if (bi.oN(charSequence)) {
                        aVar.kHt.setVisibility(8);
                    } else {
                        aVar.kHt.setText(i.b(this.context, charSequence, aVar.kHt.getTextSize()), BufferType.SPANNABLE);
                        aVar.kHt.setVisibility(0);
                    }
                    aVar.nyO.setVisibility(0);
                    if (bi.oN(hVar.niP)) {
                        c(aVar.nyO, hVar.userName);
                    } else {
                        e(aVar.nyO, hVar.niP);
                    }
                    if (bi.oN(hVar.niR)) {
                        aVar.nyQ.setVisibility(8);
                    } else {
                        e(aVar.nyQ, hVar.niR);
                        aVar.nyQ.setVisibility(0);
                    }
                }
                if (bi.oN(rr.nis)) {
                    aVar.jIt.setVisibility(8);
                } else {
                    if (rr.nhS.size() > 1) {
                        aVar.jIt.setText(this.context.getResources().getString(R.l.enb, new Object[]{Integer.valueOf(rr.nhS.size())}) + rr.nis);
                    } else {
                        aVar.jIt.setText(rr.nis);
                    }
                    aVar.jIt.setVisibility(0);
                }
                if (bi.oN(rr.nit)) {
                    aVar.nyR.setVisibility(8);
                } else {
                    aVar.nyR.setText(i.b(this.context, rr.nit, aVar.nyR.getTextSize()));
                    aVar.nyR.setVisibility(0);
                }
                a(rr, aVar);
                if (bi.oN(rr.nix.niK)) {
                    aVar.nyS.setVisibility(8);
                } else {
                    aVar.nyS.setVisibility(0);
                    if (bi.oN(rr.nix.niH)) {
                        aVar.nyS.setEnabled(false);
                    } else {
                        aVar.nyS.setTag(new com.tencent.mm.plugin.game.model.u.a(rr, rr.nix.niH, 3));
                        aVar.nyS.setOnClickListener(this.nyK);
                        aVar.nyS.setEnabled(true);
                    }
                    aVar.nyT.setText(i.b(this.context, rr.nix.niK, aVar.nyT.getTextSize()));
                    if (bi.oN(rr.nix.niG)) {
                        aVar.nyU.setVisibility(8);
                    } else {
                        e(aVar.nyU, rr.nix.niG);
                        aVar.nyU.setVisibility(0);
                    }
                }
                if (bi.oN(rr.niu)) {
                    aVar.nyV.setVisibility(8);
                } else {
                    e(aVar.nyV, rr.niu);
                    aVar.nyV.setVisibility(0);
                    if (bi.oN(rr.niv)) {
                        aVar.nyV.setEnabled(false);
                    } else {
                        aVar.nyV.setTag(new com.tencent.mm.plugin.game.model.u.a(rr, rr.niv, 3));
                        aVar.nyV.setOnClickListener(this.nyK);
                        aVar.nyV.setEnabled(true);
                    }
                }
                if (bi.oN(rr.niy.mName)) {
                    aVar.nyX.setVisibility(8);
                } else {
                    aVar.nyX.setText(rr.niy.mName);
                    aVar.nyX.setVisibility(0);
                    if (bi.oN(rr.niy.niH)) {
                        aVar.nyX.setEnabled(false);
                    } else {
                        aVar.nyX.setTag(new com.tencent.mm.plugin.game.model.u.a(rr, rr.niy.niH, 5));
                        aVar.nyX.setOnClickListener(this.nyK);
                        aVar.nyX.setEnabled(true);
                    }
                }
            }
        } else {
            aVar.nyN.setVisibility(8);
            aVar.nyY.setVisibility(0);
        }
        return view;
    }

    private void a(t tVar, a aVar) {
        LinkedList linkedList = new LinkedList();
        for (int i = 1; i < tVar.nhS.size(); i++) {
            linkedList.add(tVar.nhS.get(i));
        }
        aVar.nyZ.a(tVar, linkedList, this.nyJ, this.niV, this.nyL);
    }

    private void c(ImageView imageView, String str) {
        if (bi.oN(str)) {
            com.tencent.mm.pluginsdk.ui.a.b.a(imageView, str);
        } else if (this.nyL.bu(str)) {
            Bitmap bitmap = (Bitmap) this.nyL.get(str);
            if (bitmap == null || bitmap.isRecycled()) {
                d(imageView, str);
            } else {
                imageView.setImageBitmap(bitmap);
            }
        } else {
            d(imageView, str);
        }
    }

    private void d(ImageView imageView, String str) {
        Bitmap i = e.aSC().i(imageView, str);
        if (i != null) {
            this.nyL.put(str, i);
        }
    }

    private void e(ImageView imageView, String str) {
        if (this.nyL.bu(str)) {
            Bitmap bitmap = (Bitmap) this.nyL.get(str);
            if (bitmap == null || bitmap.isRecycled()) {
                f(imageView, str);
                return;
            } else {
                imageView.setImageBitmap(bitmap);
                return;
            }
        }
        f(imageView, str);
    }

    private void f(ImageView imageView, final String str) {
        com.tencent.mm.plugin.game.d.e.a.a aVar = new com.tencent.mm.plugin.game.d.e.a.a();
        aVar.hFj = false;
        e.aSC().a(imageView, str, aVar.aSD(), new e.b() {
            public final void a(View view, Bitmap bitmap) {
                if (bitmap != null && !bitmap.isRecycled()) {
                    o.this.nyL.put(str, bitmap);
                }
            }
        });
    }

    public final void XH() {
        setCursor(SubCoreGameCenter.aRK().rawQuery("select * from GameRawMessage where " + x.j(2, 5, 6, 10, 11, 100) + " and showInMsgList = 1" + " and isHidden = 0" + " order by isRead, createTime desc limit " + this.las, new String[0]));
        this.las = getCount();
        if (this.xQN != null) {
            this.xQN.XE();
        }
        super.notifyDataSetChanged();
    }

    protected final void XI() {
        aUU();
        XH();
    }

    private static t a(t tVar, Cursor cursor) {
        if (tVar == null) {
            tVar = new t();
        }
        tVar.b(cursor);
        return tVar;
    }

    public final boolean awL() {
        return this.las >= this.hLP;
    }

    public final int getCount() {
        if (this.count < 0) {
            this.count = getCursor().getCount();
        }
        if (this.count <= 0) {
            return 0;
        }
        return this.count + aSm();
    }

    public final boolean rq(int i) {
        return this.hLP > this.fof && this.fof > 0 && i == this.fof;
    }

    protected final int aSm() {
        return (this.hLP <= this.fof || this.fof <= 0) ? 0 : 1;
    }

    private t rr(int i) {
        if (rq(i)) {
            return (t) this.xQL;
        }
        t tVar;
        if (this.xQM != null) {
            tVar = (t) this.xQM.get(Integer.valueOf(i));
            if (tVar != null) {
                return tVar;
            }
        }
        Object obj = (this.hLP <= this.fof || this.fof <= 0 || i <= this.fof) ? null : 1;
        int i2;
        if (obj != null) {
            i2 = i - 1;
        } else {
            i2 = i;
        }
        if (i < 0 || !getCursor().moveToPosition(i2)) {
            return null;
        }
        if (this.xQM == null) {
            return a((t) this.xQL, getCursor());
        }
        tVar = a(null, getCursor());
        this.xQM.put(Integer.valueOf(i), tVar);
        return tVar;
    }
}
