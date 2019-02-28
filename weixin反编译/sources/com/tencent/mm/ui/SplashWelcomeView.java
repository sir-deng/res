package com.tencent.mm.ui;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.loader.stub.a;
import com.tencent.mm.loader.stub.b;
import com.tencent.mm.plugin.setting.modelsimple.SwitchAccountModel;
import com.tencent.mm.plugin.setting.ui.widget.SwitchAccountGridView;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.chatting.ak;
import com.tencent.mm.y.ar;
import com.tencent.mm.y.br;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class SplashWelcomeView extends FrameLayout implements ak {
    private Bitmap bitmap;
    private boolean hasDrawed;
    private volatile boolean xVr;
    private volatile boolean xVs;
    private ImageView xVt;
    private int xVu;

    public SplashWelcomeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        fx(context);
    }

    public SplashWelcomeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        fx(context);
    }

    private void fx(Context context) {
        SharedPreferences sharedPreferences;
        String H;
        if (ad.cgj()) {
            sharedPreferences = ad.getContext().getSharedPreferences("switch_account_preferences", 0);
            try {
                x.i("SplashWelcomeView", "transit to switch account %s", Boolean.valueOf(sharedPreferences.getBoolean("transit_to_switch_account", false)));
                if (sharedPreferences.getBoolean("transit_to_switch_account", false)) {
                    sharedPreferences.edit().putBoolean("transit_to_switch_account", false).commit();
                    View inflate = ((Activity) context).getLayoutInflater().inflate(R.i.dst, null);
                    SwitchAccountGridView switchAccountGridView = (SwitchAccountGridView) inflate.findViewById(R.h.cPT);
                    switchAccountGridView.setRowCount(1);
                    switchAccountGridView.setClickable(false);
                    inflate.findViewById(R.h.cPS).setVisibility(8);
                    inflate.findViewById(R.h.cPQ).setVisibility(8);
                    TextView textView = (TextView) inflate.findViewById(R.h.cPV);
                    x.i("SplashWelcomeView", "activity resources %s, application resources %s", context.getResources(), ad.getResources());
                    textView.setText(context.getResources().getString(R.l.eND));
                    Set<String> Ib = br.hju.Ib();
                    H = ar.hhz.H("login_weixin_username", "");
                    Map hashMap = new HashMap();
                    if (bi.oN(H) || Ib.contains(H)) {
                        for (String str : Ib) {
                            hashMap.put(str, new SwitchAccountModel(str, br.hju.getString(str, "login_user_name"), br.hju.getString(str, "last_avatar_path"), br.hju.getString(str, "last_logout_no_pwd_ticket"), bi.Wo(br.hju.getString(str, "last_login_use_voice"))));
                        }
                    } else {
                        hashMap.put(H, new SwitchAccountModel(H, ar.hhz.H("login_user_name", ""), ar.hhz.He(), ar.hhz.H("last_logout_no_pwd_ticket", ""), bi.Wo(ar.hhz.H("last_login_use_voice", ""))));
                    }
                    switchAccountGridView.qtb = true;
                    switchAccountGridView.O(hashMap);
                    switchAccountGridView.qmX = H;
                    switchAccountGridView.qta = true;
                    switchAccountGridView.brW();
                    addView(inflate, new LayoutParams(-1, -1));
                    return;
                }
            } catch (Throwable e) {
                x.printErrStackTrace("SplashWelcomeView", e, "show switch account view with exception!", new Object[0]);
            }
        }
        this.xVt = new SplashImageView(context);
        this.xVt.setScaleType(ScaleType.CENTER_CROP);
        ((SplashImageView) this.xVt).xVq = this;
        addView(this.xVt, new LayoutParams(-1, -1));
        try {
            if (ad.cgj()) {
                sharedPreferences = ad.getContext().getSharedPreferences("system_config_prefs", 0);
                long currentTimeMillis = System.currentTimeMillis() / 1000;
                x.i("SplashWelcomeView", "beginTime:%s,endTime:%s,currentTime:%s", Long.valueOf(sharedPreferences.getLong("new_launch_image_begin_time", 0)), Long.valueOf(sharedPreferences.getLong("new_launch_image_end_time", 0)), Long.valueOf(currentTimeMillis));
                H = a.hbv + "splashWelcomeImg";
                if (currentTimeMillis <= sharedPreferences.getLong("new_launch_image_begin_time", 0) || currentTimeMillis >= r6) {
                    x.i("SplashWelcomeView", "change launch image activity is finished!");
                    b.deleteFile(H);
                    return;
                }
                Object obj;
                this.xVu = sharedPreferences.getInt("launch_fail_times", 0);
                int i = sharedPreferences.getInt("launch_last_status", 0);
                if (i == 1) {
                    x.i("SplashWelcomeView", "last launch status is 'start'.");
                    this.xVu++;
                    sharedPreferences.edit().putInt("launch_fail_times", this.xVu).commit();
                } else if (i == 2) {
                    x.i("SplashWelcomeView", "last launch status is 'end'.");
                }
                sharedPreferences.edit().putInt("launch_last_status", 1).apply();
                if (this.xVu >= 3) {
                    x.i("SplashWelcomeView", "launch exceed max failed times, %d", Integer.valueOf(this.xVu));
                    obj = null;
                } else {
                    obj = 1;
                }
                if (obj != null) {
                    e.post(new Runnable() {
                        /* JADX WARNING: inconsistent code. */
                        /* Code decompiled incorrectly, please refer to instructions dump. */
                        public final void run() {
                            /*
                            r6 = this;
                            r2 = 1;
                            r4 = 0;
                            r0 = r3;
                            r0 = com.tencent.mm.a.e.bO(r0);
                            if (r0 == 0) goto L_0x0084;
                        L_0x000a:
                            r0 = r3;	 Catch:{ Exception -> 0x0053 }
                            r1 = 0;
                            r2 = r3;	 Catch:{ Exception -> 0x0053 }
                            r2 = com.tencent.mm.a.e.bN(r2);	 Catch:{ Exception -> 0x0053 }
                            r0 = com.tencent.mm.a.e.d(r0, r1, r2);	 Catch:{ Exception -> 0x0053 }
                            if (r0 == 0) goto L_0x0045;
                        L_0x0019:
                            r1 = r0.length;	 Catch:{ Exception -> 0x0053 }
                            if (r1 <= 0) goto L_0x0045;
                        L_0x001c:
                            r1 = com.tencent.mm.ui.SplashWelcomeView.this;	 Catch:{ Exception -> 0x0053 }
                            r2 = 0;
                            r3 = r0.length;	 Catch:{ Exception -> 0x0053 }
                            r0 = android.graphics.BitmapFactory.decodeByteArray(r0, r2, r3);	 Catch:{ Exception -> 0x0053 }
                            r1.bitmap = r0;	 Catch:{ Exception -> 0x0053 }
                            r0 = "SplashWelcomeView";
                            r1 = "ready to play animation, hasDrawed %s";
                            r2 = 1;
                            r2 = new java.lang.Object[r2];	 Catch:{ Exception -> 0x0053 }
                            r3 = 0;
                            r4 = com.tencent.mm.ui.SplashWelcomeView.this;	 Catch:{ Exception -> 0x0053 }
                            r4 = r4.hasDrawed;	 Catch:{ Exception -> 0x0053 }
                            r4 = java.lang.Boolean.valueOf(r4);	 Catch:{ Exception -> 0x0053 }
                            r2[r3] = r4;	 Catch:{ Exception -> 0x0053 }
                            com.tencent.mm.sdk.platformtools.x.i(r0, r1, r2);	 Catch:{ Exception -> 0x0053 }
                            r0 = com.tencent.mm.ui.SplashWelcomeView.this;	 Catch:{ Exception -> 0x0053 }
                            r0.xVs = true;	 Catch:{ Exception -> 0x0053 }
                        L_0x0045:
                            r0 = com.tencent.mm.ui.SplashWelcomeView.this;
                            r0 = r0.hasDrawed;
                            if (r0 == 0) goto L_0x0052;
                        L_0x004d:
                            r0 = com.tencent.mm.ui.SplashWelcomeView.this;
                            r0.cos();
                        L_0x0052:
                            return;
                        L_0x0053:
                            r0 = move-exception;
                            r1 = "SplashWelcomeView";
                            r2 = "decode new welcome image error: %s";
                            r3 = 1;
                            r3 = new java.lang.Object[r3];	 Catch:{ all -> 0x0075 }
                            r4 = 0;
                            r5 = r0.getMessage();	 Catch:{ all -> 0x0075 }
                            r3[r4] = r5;	 Catch:{ all -> 0x0075 }
                            com.tencent.mm.sdk.platformtools.x.printErrStackTrace(r1, r0, r2, r3);	 Catch:{ all -> 0x0075 }
                            r0 = com.tencent.mm.ui.SplashWelcomeView.this;
                            r0 = r0.hasDrawed;
                            if (r0 == 0) goto L_0x0052;
                        L_0x006f:
                            r0 = com.tencent.mm.ui.SplashWelcomeView.this;
                            r0.cos();
                            goto L_0x0052;
                        L_0x0075:
                            r0 = move-exception;
                            r1 = com.tencent.mm.ui.SplashWelcomeView.this;
                            r1 = r1.hasDrawed;
                            if (r1 == 0) goto L_0x0083;
                        L_0x007e:
                            r1 = com.tencent.mm.ui.SplashWelcomeView.this;
                            r1.cos();
                        L_0x0083:
                            throw r0;
                        L_0x0084:
                            r0 = "SplashWelcomeView";
                            r1 = "cannot find %s";
                            r2 = new java.lang.Object[r2];
                            r3 = r3;
                            r2[r4] = r3;
                            com.tencent.mm.sdk.platformtools.x.i(r0, r1, r2);
                            goto L_0x0052;
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.SplashWelcomeView.1.run():void");
                        }
                    }, "readWelcomeBg");
                    return;
                }
                return;
            }
            x.i("SplashWelcomeView", "not main process, only load default splash bitmap.");
        } catch (Throwable e2) {
            x.printErrStackTrace("SplashWelcomeView", e2, "%s", e2.getMessage());
        }
    }

    private synchronized void cos() {
        if (!this.xVr) {
            this.xVr = true;
            if (this.bitmap != null) {
                try {
                    ah.y(new Runnable() {
                        public final void run() {
                            x.d("SplashWelcomeView", "set top imageView");
                            final View imageView = new ImageView(SplashWelcomeView.this.getContext());
                            imageView.setScaleType(ScaleType.CENTER_CROP);
                            imageView.setImageBitmap(SplashWelcomeView.this.bitmap);
                            imageView.setAlpha(0.0f);
                            SplashWelcomeView.this.addView(imageView, new LayoutParams(-1, -1));
                            ValueAnimator duration = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f}).setDuration(1000);
                            duration.addUpdateListener(new AnimatorUpdateListener() {
                                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                                    imageView.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                                }
                            });
                            duration.start();
                            x.i("SplashWelcomeView", "start play animation");
                        }
                    });
                } catch (Throwable e) {
                    x.printErrStackTrace("SplashWelcomeView", e, "%s", e.getMessage());
                }
            }
        }
        return;
    }

    public final void aOR() {
        x.i("SplashWelcomeView", "hasDrawed:%s", Boolean.valueOf(this.hasDrawed));
        if (!this.hasDrawed) {
            this.hasDrawed = true;
            if (this.xVs && !this.xVr) {
                cos();
            }
        }
    }
}
