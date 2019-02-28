package com.tencent.mm.ui.chatting.b;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.view.animation.ScaleAnimation;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bl.d;
import com.tencent.mm.f.a.eq;
import com.tencent.mm.f.a.rk;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.q.f;
import com.tencent.mm.pluginsdk.q.l;
import com.tencent.mm.pluginsdk.q.q;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MultiTalkRoomPopupNav;
import com.tencent.mm.ui.base.TalkRoomPopupNav;
import com.tencent.mm.ui.base.TalkRoomPopupNav.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.i;
import com.tencent.mm.y.r;
import com.tencent.mm.y.s;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.util.List;

public final class aa implements f, l, q {
    public p fhH;
    public TalkRoomPopupNav yKW;
    public MultiTalkRoomPopupNav yKX;
    private a yKY = new a() {
        public final void cqX() {
            if (com.tencent.mm.o.a.aW(aa.this.fhH.cte().getContext()) || com.tencent.mm.o.a.aU(aa.this.fhH.cte().getContext())) {
                x.d("MicroMsg.ChattingUI.TrackRoomImp", "voip is running");
                return;
            }
            List Eg = com.tencent.mm.pluginsdk.q.a.vje.Eg(aa.this.fhH.csW().field_username);
            x.i("MicroMsg.ChattingUI.TrackRoomImp", "Click banner : %d", Integer.valueOf(Eg.size()));
            if (com.tencent.mm.pluginsdk.q.a.vje.Ei(aa.this.fhH.csW().field_username)) {
                aa aaVar = aa.this;
                if (!aaVar.fhH.csW().field_username.toLowerCase().endsWith("@chatroom") || aaVar.fhH.cti()) {
                    b rkVar = new rk();
                    rkVar.fJX.fJZ = true;
                    com.tencent.mm.sdk.b.a.xmy.m(rkVar);
                    String str;
                    if (bi.oN(rkVar.fJY.fKb) || aaVar.fhH.csW().field_username.equals(rkVar.fJY.fKb)) {
                        str = aaVar.fhH.csW().field_username;
                        aaVar.bn("fromBanner", false);
                        return;
                    }
                    rkVar = new rk();
                    rkVar.fJX.fKa = true;
                    com.tencent.mm.sdk.b.a.xmy.m(rkVar);
                    str = aaVar.fhH.csW().field_username;
                    aaVar.bn("fromBanner", false);
                    return;
                }
                h.b(aaVar.fhH.cte().getContext(), aaVar.fhH.cte().getMMString(R.l.eRC), null, true);
                return;
            }
            aa.this.mW(true);
        }

        public final void cqY() {
            b rkVar = new rk();
            rkVar.fJX.fKa = true;
            com.tencent.mm.sdk.b.a.xmy.m(rkVar);
            aa.this.ZR(aa.this.fhH.csW().field_username);
        }
    };

    /* renamed from: com.tencent.mm.ui.chatting.b.aa$1 */
    class AnonymousClass1 implements OnClickListener {
        final /* synthetic */ Runnable yKZ;

        public AnonymousClass1(Runnable runnable) {
            this.yKZ = runnable;
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            this.yKZ.run();
            b eqVar = new eq();
            eqVar.fub.username = aa.this.fhH.csW().field_username;
            com.tencent.mm.sdk.b.a.xmy.m(eqVar);
        }
    }

    public aa(p pVar) {
        this.fhH = pVar;
    }

    public final void G(String str, String str2, String str3) {
        if (str.equals(this.fhH.csW().field_username)) {
            mV(false);
        }
    }

    public final void RQ(String str) {
        if (str.equals(this.fhH.csW().field_username)) {
            mV(false);
        }
    }

    public final void RP(String str) {
        if (str.equals(this.fhH.csW().field_username)) {
            mV(false);
        }
    }

    private void a(a aVar) {
        if (this.yKW == null) {
            g.a(this.fhH.cte(), R.h.cWe);
            this.yKW = (TalkRoomPopupNav) this.fhH.cte().findViewById(R.h.cQo);
            if (this.yKW == null) {
                return;
            }
        }
        if (this.yKW != null) {
            this.yKW.ypV = aVar;
        }
    }

    public final void mV(boolean z) {
        if (!s.eX(this.fhH.csW().field_username) || this.fhH.cti()) {
            cuM();
            String str;
            if (com.tencent.mm.pluginsdk.q.a.vje != null && com.tencent.mm.pluginsdk.q.a.vje.Ei(this.fhH.csW().field_username)) {
                a(this.yKY);
                if (this.yKW != null) {
                    List Eg = com.tencent.mm.pluginsdk.q.a.vje.Eg(this.fhH.csW().field_username);
                    str = "";
                    if (Eg == null || !Eg.contains(this.fhH.ctj())) {
                        this.yKW.Fp(-1);
                        this.yKW.stop();
                        this.yKW.Fn(R.g.bGW);
                        if (Eg != null && Eg.size() == 1) {
                            str = this.fhH.cte().getMMString(R.l.eRD, r.gw((String) Eg.get(0)));
                        } else if (Eg != null) {
                            str = this.fhH.cte().getMMString(R.l.eRF, Integer.valueOf(Eg.size()));
                        }
                        this.yKW.Fo(R.k.dBq);
                    } else {
                        this.yKW.Fn(R.g.bGV);
                        str = this.fhH.cte().getMMString(R.l.eRE);
                        this.yKW.Fo(R.k.dBr);
                        this.yKW.Fp(R.k.dBs);
                        TalkRoomPopupNav talkRoomPopupNav = this.yKW;
                        if (talkRoomPopupNav.yqg == null || talkRoomPopupNav.yqh == null) {
                            talkRoomPopupNav.yqg = new AlphaAnimation(0.0f, 1.0f);
                            talkRoomPopupNav.yqg.setDuration(1000);
                            talkRoomPopupNav.yqg.setStartOffset(0);
                            talkRoomPopupNav.yqh = new AlphaAnimation(1.0f, 0.0f);
                            talkRoomPopupNav.yqh.setDuration(1000);
                            talkRoomPopupNav.yqh.setStartOffset(0);
                            talkRoomPopupNav.yqg.setAnimationListener(new AnimationListener() {
                                public final void onAnimationStart(Animation animation) {
                                }

                                public final void onAnimationRepeat(Animation animation) {
                                }

                                public final void onAnimationEnd(Animation animation) {
                                    if (TalkRoomPopupNav.this.yqh != null) {
                                        TalkRoomPopupNav.this.ypZ.startAnimation(TalkRoomPopupNav.this.yqh);
                                    }
                                }
                            });
                            talkRoomPopupNav.yqh.setAnimationListener(new AnimationListener() {
                                public final void onAnimationStart(Animation animation) {
                                }

                                public final void onAnimationRepeat(Animation animation) {
                                }

                                public final void onAnimationEnd(Animation animation) {
                                    if (TalkRoomPopupNav.this.yqg != null) {
                                        TalkRoomPopupNav.this.ypZ.startAnimation(TalkRoomPopupNav.this.yqg);
                                    }
                                }
                            });
                            talkRoomPopupNav.ypZ.startAnimation(talkRoomPopupNav.yqg);
                        }
                    }
                    this.yKW.setVisibility(0);
                    this.yKW.Zt(str);
                    this.fhH.FT(1);
                    return;
                }
                return;
            } else if (com.tencent.mm.pluginsdk.q.a.viX != null && com.tencent.mm.pluginsdk.q.a.viX.MW(this.fhH.csW().field_username)) {
                a(this.yKY);
                b rkVar = new rk();
                rkVar.fJX.fJZ = true;
                com.tencent.mm.sdk.b.a.xmy.m(rkVar);
                if (this.fhH.csW().field_username.equals(rkVar.fJY.fKb)) {
                    this.yKW.Fn(R.g.bGV);
                } else {
                    this.yKW.Fn(R.g.bGW);
                }
                str = this.fhH.cte().getMMString(R.l.eRc, Integer.valueOf(com.tencent.mm.pluginsdk.q.a.viX.MX(this.fhH.csW().field_username).size()));
                this.yKW.Fo(R.g.bGM);
                this.yKW.Fp(-1);
                this.yKW.stop();
                this.yKW.setVisibility(0);
                this.yKW.Zt(str);
                this.fhH.FT(1);
                return;
            } else if (!s.eX(this.fhH.csW().field_username) || com.tencent.mm.pluginsdk.q.a.vjf == null) {
                cuM();
                return;
            } else {
                com.tencent.mm.at.b Gk = com.tencent.mm.pluginsdk.q.a.vjf.Gk(this.fhH.csW().field_username);
                if (Gk != null && Gk.field_wxGroupId != null && Gk.field_wxGroupId.equals(this.fhH.csW().field_username)) {
                    if (this.yKX == null) {
                        g.a(this.fhH.cte(), R.h.cWd);
                        this.yKX = (MultiTalkRoomPopupNav) this.fhH.cte().findViewById(R.h.cye);
                    }
                    if (this.yKX != null) {
                        x.i("MicroMsg.ChattingUI.TrackRoomImp", "show multiTalkBanner! ");
                        this.yKX.xTN = this.fhH.csW().field_username;
                        this.yKX.xTO = this.fhH.ctj();
                        this.yKX.xTP = this.fhH.cti();
                        MultiTalkRoomPopupNav multiTalkRoomPopupNav = this.yKX;
                        multiTalkRoomPopupNav.xTU = false;
                        if (multiTalkRoomPopupNav.xTN == null || multiTalkRoomPopupNav.xTO == null) {
                            x.e("MicroMsg.MultiTalkRoomPopupNav", "groupUserName or currentSenderUserName is null! groupUserName:" + multiTalkRoomPopupNav.xTN + ",currentSenderUserName:" + multiTalkRoomPopupNav.xTO);
                        } else {
                            String str2 = multiTalkRoomPopupNav.xTN;
                            if (com.tencent.mm.pluginsdk.q.a.vjf == null || !com.tencent.mm.pluginsdk.q.a.vjf.FY(str2)) {
                                multiTalkRoomPopupNav.coj();
                            } else {
                                List Ga = com.tencent.mm.pluginsdk.q.a.vjf.Ga(str2);
                                if (Ga.size() == 0) {
                                    com.tencent.mm.pluginsdk.q.a.vjf.iI(str2);
                                    multiTalkRoomPopupNav.coj();
                                } else {
                                    int dy = com.tencent.mm.pluginsdk.q.a.vjf.dy(str2, multiTalkRoomPopupNav.xTO);
                                    if (dy == 1) {
                                        multiTalkRoomPopupNav.xTQ = b.xTY;
                                        if (com.tencent.mm.pluginsdk.q.a.vjf.Gb(str2)) {
                                            multiTalkRoomPopupNav.coj();
                                        } else {
                                            CharSequence gw = com.tencent.mm.pluginsdk.q.a.vjf.gw(com.tencent.mm.pluginsdk.q.a.vjf.dx(str2, multiTalkRoomPopupNav.xTO));
                                            multiTalkRoomPopupNav.xTJ.setBackgroundResource(R.g.bDR);
                                            multiTalkRoomPopupNav.xTL.setTextColor(multiTalkRoomPopupNav.getResources().getColor(R.e.btm));
                                            multiTalkRoomPopupNav.xTL.setText(gw);
                                            multiTalkRoomPopupNav.xTK.setVisibility(8);
                                            multiTalkRoomPopupNav.xTM.setVisibility(0);
                                            multiTalkRoomPopupNav.xTL.setVisibility(0);
                                            multiTalkRoomPopupNav.xTT.setVisibility(8);
                                        }
                                    } else if (dy == 10) {
                                        multiTalkRoomPopupNav.xTQ = b.xTZ;
                                        if (com.tencent.mm.pluginsdk.q.a.vjf.Gb(str2)) {
                                            multiTalkRoomPopupNav.coj();
                                        } else if (com.tencent.mm.pluginsdk.q.a.vjf.bcZ()) {
                                            multiTalkRoomPopupNav.coj();
                                        } else {
                                            multiTalkRoomPopupNav.xTQ = b.xUa;
                                            multiTalkRoomPopupNav.YX(ad.getContext().getString(R.l.ewP, new Object[]{Integer.valueOf(Ga.size())}));
                                        }
                                    } else {
                                        multiTalkRoomPopupNav.xTQ = b.xUa;
                                        multiTalkRoomPopupNav.YX(ad.getContext().getString(R.l.ewP, new Object[]{Integer.valueOf(Ga.size())}));
                                    }
                                    multiTalkRoomPopupNav.setVisibility(0);
                                    multiTalkRoomPopupNav.xTI.setVisibility(0);
                                    multiTalkRoomPopupNav.xTJ.setVisibility(0);
                                    if (multiTalkRoomPopupNav.xTR != null && (z || multiTalkRoomPopupNav.xTT == null || multiTalkRoomPopupNav.xTT.getVisibility() != 0)) {
                                        multiTalkRoomPopupNav.xTR.xTX.setVisibility(8);
                                    }
                                    multiTalkRoomPopupNav.db(MultiTalkRoomPopupNav.m(Ga, ""));
                                }
                            }
                        }
                        this.yKX.xTV = Gk;
                        this.fhH.FT(1);
                        return;
                    }
                    return;
                }
                return;
            }
        }
        if (this.yKW != null) {
            this.yKW.setVisibility(8);
            this.fhH.FT(-1);
        }
        if (this.yKX != null) {
            this.yKX.xTP = this.fhH.cti();
            this.yKX.setVisibility(8);
        }
    }

    private void cuM() {
        if (this.yKW != null) {
            this.yKW.setVisibility(8);
            this.yKW.Fp(-1);
            this.yKW.stop();
            this.fhH.FT(-1);
        }
        if (this.yKX != null) {
            if (!com.tencent.mm.pluginsdk.q.a.vjf.FY(this.fhH.csn())) {
                this.yKX.coj();
            }
            this.yKX.setVisibility(8);
            this.fhH.FT(-1);
        }
    }

    public final void mW(final boolean z) {
        if (!this.fhH.csW().field_username.toLowerCase().endsWith("@chatroom") || this.fhH.cti()) {
            b rkVar = new rk();
            rkVar.fJX.fJZ = true;
            com.tencent.mm.sdk.b.a.xmy.m(rkVar);
            if (z) {
                if (bi.oN(rkVar.fJY.fKb) || this.fhH.csW().field_username.equals(rkVar.fJY.fKb)) {
                    ZR(this.fhH.csW().field_username);
                    return;
                } else if (this.yKW == null || this.yKW.getVisibility() != 0) {
                    h.a(this.fhH.cte().getContext(), this.fhH.cte().getMMString(R.l.eQK), null, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            b rkVar = new rk();
                            rkVar.fJX.fKa = true;
                            com.tencent.mm.sdk.b.a.xmy.m(rkVar);
                            aa.this.ZR(aa.this.fhH.csW().field_username);
                        }
                    }, new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    });
                    return;
                } else {
                    TalkRoomPopupNav talkRoomPopupNav = this.yKW;
                    ((TextView) talkRoomPopupNav.findViewById(R.h.cTn)).setText(this.fhH.cte().getMMString(R.l.eQK));
                    talkRoomPopupNav = this.yKW;
                    if (talkRoomPopupNav.yqa == null) {
                        talkRoomPopupNav.yqa = new ScaleAnimation(1.0f, 1.0f, (((float) talkRoomPopupNav.yqc) * 1.0f) / ((float) talkRoomPopupNav.yqd), 1.0f);
                        talkRoomPopupNav.yqa.setDuration(300);
                        talkRoomPopupNav.yqa.setAnimationListener(new AnimationListener() {
                            public final void onAnimationStart(Animation animation) {
                            }

                            public final void onAnimationRepeat(Animation animation) {
                            }

                            public final void onAnimationEnd(Animation animation) {
                                TalkRoomPopupNav.this.ypX.startAnimation(AnimationUtils.loadAnimation(TalkRoomPopupNav.this.getContext(), R.a.bpZ));
                                TalkRoomPopupNav.this.ypX.setVisibility(0);
                            }
                        });
                    }
                    if (talkRoomPopupNav.yqb == null) {
                        talkRoomPopupNav.yqb = AnimationUtils.loadAnimation(talkRoomPopupNav.getContext(), R.a.bqa);
                        talkRoomPopupNav.yqb.setFillAfter(true);
                        talkRoomPopupNav.yqb.setAnimationListener(new AnimationListener() {
                            public final void onAnimationStart(Animation animation) {
                            }

                            public final void onAnimationRepeat(Animation animation) {
                            }

                            public final void onAnimationEnd(Animation animation) {
                                TalkRoomPopupNav.this.xTI.setVisibility(8);
                                TalkRoomPopupNav.this.xTI.setClickable(false);
                            }
                        });
                    }
                    LayoutParams layoutParams = talkRoomPopupNav.mEx.getLayoutParams();
                    layoutParams.height = talkRoomPopupNav.yqd;
                    talkRoomPopupNav.mEx.setLayoutParams(layoutParams);
                    talkRoomPopupNav.mEx.startAnimation(talkRoomPopupNav.yqa);
                    talkRoomPopupNav.xTI.startAnimation(talkRoomPopupNav.yqb);
                    talkRoomPopupNav.ypW.startAnimation(AnimationUtils.loadAnimation(talkRoomPopupNav.getContext(), R.a.bpZ));
                    talkRoomPopupNav.ypW.setVisibility(0);
                    return;
                }
            } else if (com.tencent.mm.pluginsdk.q.a.vje != null && com.tencent.mm.pluginsdk.q.a.vje.Ei(this.fhH.csW().field_username)) {
                String mMString;
                int i;
                List Eg = com.tencent.mm.pluginsdk.q.a.vje.Eg(this.fhH.csW().field_username);
                if (Eg == null || !Eg.contains(this.fhH.ctj())) {
                    mMString = this.fhH.cte().getMMString(R.l.eQP);
                    i = R.l.esC;
                } else {
                    mMString = this.fhH.cte().getMMString(R.l.eQO);
                    i = R.l.ebP;
                }
                g.pWK.h(10997, Integer.valueOf(19), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0));
                i.a aVar = new i.a(this.fhH.cte().getContext());
                aVar.Zn(mMString);
                aVar.EV(R.l.dEy).a(new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                aVar.EW(i).b(new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        aa.this.ZQ(z ? "fromBanner" : "fromPluginTalk");
                    }
                });
                aVar.ale().show();
                return;
            } else if (bi.oN(rkVar.fJY.fKb) || this.fhH.csW().field_username.equals(rkVar.fJY.fKb)) {
                ZR(this.fhH.csW().field_username);
                return;
            } else {
                h.a(this.fhH.cte().getContext(), this.fhH.cte().getMMString(R.l.eQK), null, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        b rkVar = new rk();
                        rkVar.fJX.fKa = true;
                        com.tencent.mm.sdk.b.a.xmy.m(rkVar);
                        aa.this.ZR(aa.this.fhH.csW().field_username);
                    }
                }, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                return;
            }
        }
        h.b(this.fhH.cte().getContext(), this.fhH.cte().getMMString(R.l.eQT), null, true);
    }

    public final void bn(final String str, boolean z) {
        if ((com.tencent.mm.pluginsdk.q.a.vje != null && com.tencent.mm.pluginsdk.q.a.vje.Ei(this.fhH.csW().field_username)) || z) {
            List Eg = com.tencent.mm.pluginsdk.q.a.vje.Eg(this.fhH.csW().field_username);
            if (Eg == null || !Eg.contains(this.fhH.ctj())) {
                g.pWK.h(10997, Integer.valueOf(13), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0));
                h.a(this.fhH.cte().getContext(), this.fhH.cte().getMMString(R.l.ebS), null, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        aa.this.ZQ(str);
                    }
                }, new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        g.pWK.h(10997, Integer.valueOf(14), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0));
                        dialogInterface.dismiss();
                    }
                });
                return;
            }
        }
        ZQ(str);
    }

    public final void ZQ(String str) {
        Intent intent = new Intent();
        intent.putExtra("map_view_type", 6);
        intent.putExtra("map_sender_name", this.fhH.ctj());
        intent.putExtra("map_talker_name", this.fhH.csn());
        intent.putExtra("fromWhereShare", str);
        d.b(this.fhH.cte().getContext(), "location", ".ui.RedirectUI", intent);
    }

    final void ZR(String str) {
        Intent intent = new Intent();
        intent.putExtra("enter_room_username", str);
        intent.setFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        d.b(this.fhH.cte().getContext(), "talkroom", ".ui.TalkRoomUI", intent);
    }
}
