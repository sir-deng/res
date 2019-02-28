package com.tencent.mm.ui.conversation.a;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.liteav.network.TXCStreamUploader;
import com.tencent.mm.R;
import com.tencent.mm.bj.a;
import com.tencent.mm.bl.d;
import com.tencent.mm.plugin.sns.b.n;
import com.tencent.mm.pluginsdk.ui.b.b;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.MMImageView;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.bindmobile.BindMContactIntroUI;
import com.tencent.mm.y.a.e;
import com.tencent.mm.y.a.f;
import com.tencent.mm.y.a.g;
import com.tencent.mm.y.as;
import com.tencent.mm.y.az;
import com.tencent.mm.y.ba;
import com.tencent.mm.y.bj;
import com.tencent.mm.y.c;
import com.tencent.mm.y.q;

public final class k extends b {
    protected az zjX = null;

    static /* synthetic */ void o(Context context, boolean z) {
        if (context != null) {
            Intent intent = new Intent();
            intent.setClass(context, BindMContactIntroUI.class);
            intent.putExtra("key_upload_scene", 8);
            intent.putExtra("is_bind_for_contact_sync", z);
            intent.putExtra("KEnterFromBanner", true);
            MMWizardActivity.A(context, intent);
            e ih = g.Ip().ih("4");
            if (ih != null && !bi.oN(ih.value) && (ih.value.equals("1") || ih.value.equals("2"))) {
                g.Ip().ih("4").result = "1";
                f.im("4");
                if (ih.value.equals("1")) {
                    as.Hm();
                    c.Db().set(328195, Boolean.valueOf(true));
                    return;
                }
                as.Hm();
                c.Db().set(328196, Boolean.valueOf(true));
            } else if (z) {
                com.tencent.mm.plugin.report.service.g.pWK.h((int) TXCStreamUploader.TXE_UPLOAD_INFO_PUSH_BEGIN, Integer.valueOf(3), Integer.valueOf(1));
            } else {
                com.tencent.mm.plugin.report.service.g.pWK.h((int) TXCStreamUploader.TXE_UPLOAD_INFO_PUSH_BEGIN, Integer.valueOf(1), Integer.valueOf(1));
            }
        }
    }

    public k(Context context, az azVar) {
        super(context);
        this.zjX = azVar;
        if (this.view != null) {
            OnClickListener anonymousClass3;
            MMImageView mMImageView = (MMImageView) this.view.findViewById(R.h.cuX);
            TextView textView = (TextView) this.view.findViewById(R.h.cuY);
            switch (this.zjX.type) {
                case 1:
                    mMImageView.setImageResource(R.k.dBA);
                    textView.setText(R.l.dKz);
                    break;
                case 2:
                    mMImageView.setImageResource(R.k.dBB);
                    textView.setText(R.l.ehT);
                    break;
                case 3:
                    mMImageView.setImageResource(R.k.dBz);
                    textView.setText(R.l.dKH);
                    break;
                case 4:
                    mMImageView.setImageResource(R.k.dBG);
                    textView.setText(R.l.dKB);
                    break;
                case 6:
                    mMImageView.setImageResource(R.k.dBC);
                    textView.setText(R.l.dKF);
                    break;
                case 7:
                    mMImageView.setImageResource(R.k.dBD);
                    textView.setText(R.l.dKE);
                    break;
                case 8:
                    mMImageView.setImageResource(R.k.dBE);
                    textView.setText(R.l.dKG);
                    break;
                case 9:
                    mMImageView.setImageResource(R.k.dBF);
                    textView.setText(R.l.dKC);
                    break;
                case 10:
                    mMImageView.setImageResource(R.k.dBy);
                    textView.setText(R.l.dKy);
                    break;
            }
            View view = this.view;
            final int i = this.zjX.type;
            final int i2 = this.zjX.showType;
            switch (i) {
                case 1:
                    anonymousClass3 = new OnClickListener() {
                        public final void onClick(View view) {
                            ba.Hy().aX(i, i2);
                            k.o((Context) k.this.vvl.get(), false);
                        }
                    };
                    break;
                case 2:
                    anonymousClass3 = new OnClickListener() {
                        public final void onClick(View view) {
                            ba.Hy().aX(i, i2);
                            k.o((Context) k.this.vvl.get(), true);
                        }
                    };
                    break;
                case 3:
                    anonymousClass3 = new OnClickListener() {
                        public final void onClick(View view) {
                            ba.Hy().aX(i, i2);
                            Context context = (Context) k.this.vvl.get();
                            if (context != null) {
                                as.Hm();
                                if (c.isSDCardAvailable()) {
                                    Intent intent = new Intent();
                                    intent.putExtra("intent_set_avatar", true);
                                    intent.putExtra("KEnterFromBanner", true);
                                    d.b(context, "setting", ".ui.setting.SettingsPersonalInfoUI", intent);
                                    com.tencent.mm.plugin.report.service.g.pWK.h((int) TXCStreamUploader.TXE_UPLOAD_INFO_PUSH_BEGIN, Integer.valueOf(4), Integer.valueOf(1));
                                    return;
                                }
                                u.fJ(context);
                            }
                        }
                    };
                    break;
                case 4:
                    anonymousClass3 = new OnClickListener() {
                        public final void onClick(View view) {
                            ba.Hy().aX(i, i2);
                            Context context = (Context) k.this.vvl.get();
                            if (context != null) {
                                com.tencent.mm.plugin.report.service.g.pWK.h((int) TXCStreamUploader.TXE_UPLOAD_INFO_PUSH_BEGIN, Integer.valueOf(5), Integer.valueOf(1));
                                as.Hm();
                                boolean c = bi.c((Boolean) c.Db().get(4103, null));
                                new Intent().putExtra("KEnterFromBanner", true);
                                if (c) {
                                    bj HX = bj.HX();
                                    if (HX == null) {
                                        d.y(context, "nearby", ".ui.NearbyPersonalInfoUI");
                                        return;
                                    }
                                    String oM = bi.oM(HX.getProvince());
                                    int a = bi.a(Integer.valueOf(HX.fXa), 0);
                                    if (bi.oN(oM) || a == 0) {
                                        d.y(context, "nearby", ".ui.NearbyPersonalInfoUI");
                                        return;
                                    }
                                    LauncherUI cnu = LauncherUI.cnu();
                                    if (cnu != null) {
                                        cnu.xPu.xOK.YW("tab_find_friend");
                                    }
                                    a.dW(context);
                                    return;
                                }
                                d.y(context, "nearby", ".ui.NearbyFriendsIntroUI");
                            }
                        }
                    };
                    break;
                case 6:
                    anonymousClass3 = new OnClickListener() {
                        public final void onClick(View view) {
                            ba.Hy().aX(i, i2);
                            Context context = (Context) k.this.vvl.get();
                            Intent intent = new Intent();
                            intent.putExtra("preceding_scence", 17);
                            d.b(context, "emoji", ".ui.v2.EmojiStoreV2UI", intent);
                            com.tencent.mm.plugin.report.service.g.pWK.h((int) TXCStreamUploader.TXE_UPLOAD_INFO_PUSH_BEGIN, Integer.valueOf(10), Integer.valueOf(1));
                            com.tencent.mm.plugin.report.service.g.pWK.h(12065, Integer.valueOf(2));
                        }
                    };
                    break;
                case 7:
                    anonymousClass3 = new OnClickListener() {
                        public final void onClick(View view) {
                            ba.Hy().aX(i, i2);
                            d.y((Context) k.this.vvl.get(), "game", ".ui.GameCenterUI");
                            com.tencent.mm.plugin.report.service.g.pWK.h((int) TXCStreamUploader.TXE_UPLOAD_INFO_PUSH_BEGIN, Integer.valueOf(9), Integer.valueOf(1));
                        }
                    };
                    break;
                case 8:
                    anonymousClass3 = new OnClickListener() {
                        public final void onClick(View view) {
                            int i;
                            ba.Hy().aX(i, i2);
                            Context context = (Context) k.this.vvl.get();
                            if ((q.Gj() & 65536) == 0) {
                                i = 1;
                            } else {
                                i = 0;
                            }
                            if (i != 0) {
                                d.y(context, "masssend", ".ui.MassSendHistoryUI");
                            } else {
                                d.b(context, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", "masssendapp"));
                            }
                            com.tencent.mm.plugin.report.service.g.pWK.h((int) TXCStreamUploader.TXE_UPLOAD_INFO_PUSH_BEGIN, Integer.valueOf(11), Integer.valueOf(1));
                        }
                    };
                    break;
                case 9:
                    anonymousClass3 = new OnClickListener() {
                        public final void onClick(View view) {
                            boolean z;
                            ba.Hy().aX(i, i2);
                            Context context = (Context) k.this.vvl.get();
                            as.Hm();
                            String str = (String) c.Db().get(68377, null);
                            as.Hm();
                            c.Db().set(68377, "");
                            Intent intent = new Intent();
                            intent.putExtra("sns_timeline_NeedFirstLoadint", true);
                            if (bi.oN(str)) {
                                z = true;
                            } else {
                                z = false;
                            }
                            if (n.qWD != null && n.qWD.Tx() > 0) {
                                z = false;
                            }
                            intent.putExtra("sns_resume_state", z);
                            d.b(context, "sns", ".ui.SnsTimeLineUI", intent);
                            com.tencent.mm.plugin.report.service.g.pWK.h((int) TXCStreamUploader.TXE_UPLOAD_INFO_PUSH_BEGIN, Integer.valueOf(8), Integer.valueOf(1));
                        }
                    };
                    break;
                case 10:
                    anonymousClass3 = new OnClickListener() {
                        public final void onClick(View view) {
                            ba.Hy().aX(i, i2);
                            d.b((Context) k.this.vvl.get(), "subapp", ".ui.autoadd.AutoAddFriendUI", new Intent());
                        }
                    };
                    break;
                default:
                    anonymousClass3 = null;
                    break;
            }
            view.setOnClickListener(anonymousClass3);
        }
    }

    public final int getLayoutId() {
        return R.i.dnd;
    }

    public final void destroy() {
    }
}
