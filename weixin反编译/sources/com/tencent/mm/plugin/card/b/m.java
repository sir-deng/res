package com.tencent.mm.plugin.card.b;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ap.a.a.c.a;
import com.tencent.mm.ap.a.c.g;
import com.tencent.mm.ap.a.d.b;
import com.tencent.mm.ap.o;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;

public final class m {

    /* renamed from: com.tencent.mm.plugin.card.b.m$3 */
    static class AnonymousClass3 implements AnimationListener {
        final /* synthetic */ View ldu;
        final /* synthetic */ ScaleAnimation ldv;

        public AnonymousClass3(View view, ScaleAnimation scaleAnimation) {
            this.ldu = view;
            this.ldv = scaleAnimation;
        }

        public final void onAnimationStart(Animation animation) {
        }

        public final void onAnimationRepeat(Animation animation) {
        }

        public final void onAnimationEnd(Animation animation) {
            this.ldu.startAnimation(this.ldv);
        }
    }

    public static String xC(String str) {
        if (bi.oN(str)) {
            x.e("MicroMsg.CardViewUtil", "toApply is null");
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            stringBuilder.append(str.charAt(i));
            if ((i + 1) % 4 == 0) {
                stringBuilder.append(" ");
            }
        }
        return stringBuilder.toString();
    }

    public static void a(ImageView imageView, String str, int i, int i2, boolean z) {
        if (imageView != null && !TextUtils.isEmpty(str)) {
            if (TextUtils.isEmpty(str)) {
                imageView.setImageResource(i2);
                return;
            }
            a aVar = new a();
            aVar.hFo = e.bnF;
            o.PH();
            aVar.hFH = null;
            aVar.hFn = com.tencent.mm.plugin.card.model.m.wQ(str);
            aVar.hFl = true;
            aVar.hFJ = z;
            aVar.hFj = true;
            aVar.hFs = i;
            aVar.hFr = i;
            aVar.hFA = i2;
            o.PG().a(str, imageView, aVar.PQ());
        }
    }

    public static void a(final Context context, final ImageView imageView, String str, int i, final int i2, final int i3) {
        if (imageView != null && !TextUtils.isEmpty(str)) {
            if (TextUtils.isEmpty(str)) {
                a(imageView, i2, i3);
                return;
            }
            a aVar = new a();
            aVar.hFo = e.bnF;
            o.PH();
            aVar.hFH = null;
            aVar.hFn = com.tencent.mm.plugin.card.model.m.wQ(str);
            aVar.hFl = true;
            aVar.hFJ = false;
            aVar.hFj = true;
            aVar.hFs = i;
            aVar.hFr = i;
            aVar.hFA = i2;
            o.PG().a(str, imageView, aVar.PQ(), new g() {
                public final void lF(String str) {
                }

                public final Bitmap a(String str, b bVar) {
                    return null;
                }

                public final void a(String str, View view, b bVar) {
                    if (bVar.bitmap != null) {
                        final Bitmap bitmap = bVar.bitmap;
                        ah.y(new Runnable() {
                            public final void run() {
                                imageView.setImageBitmap(bitmap);
                                imageView.setColorFilter(i3, Mode.SRC_IN);
                            }
                        });
                        return;
                    }
                    m.a(imageView, i2, i3);
                }
            });
        }
    }

    public static void a(final ImageView imageView, final int i, final int i2) {
        ah.y(new Runnable() {
            public final void run() {
                imageView.setImageResource(i);
                imageView.setColorFilter(i2, Mode.SRC_IN);
            }
        });
    }

    public static void a(MMActivity mMActivity, com.tencent.mm.plugin.card.base.b bVar) {
        a(mMActivity, l.xu(bVar.aui().hdx));
    }

    public static void a(MMActivity mMActivity, int i) {
        mMActivity.getSupportActionBar().setBackgroundDrawable(null);
        Drawable shapeDrawable = new ShapeDrawable();
        shapeDrawable.getPaint().setColor(i);
        mMActivity.getSupportActionBar().setBackgroundDrawable(shapeDrawable);
        View customView = mMActivity.getSupportActionBar().getCustomView();
        if (customView != null) {
            View findViewById = customView.findViewById(R.h.divider);
            if (findViewById != null) {
                findViewById.setBackgroundColor(mMActivity.getResources().getColor(R.e.bsL));
            }
            findViewById = customView.findViewById(R.h.bIX);
            if (findViewById != null) {
                ((ImageView) findViewById).setImageResource(R.g.byz);
            }
            findViewById = customView.findViewById(16908308);
            if (findViewById != null && (findViewById instanceof TextView)) {
                ((TextView) findViewById).setTextColor(mMActivity.getResources().getColor(R.e.white));
            }
            findViewById = customView.findViewById(16908309);
            if (findViewById != null && (findViewById instanceof TextView)) {
                ((TextView) findViewById).setTextColor(mMActivity.getResources().getColor(R.e.white));
            }
            customView.setBackgroundDrawable(shapeDrawable);
        }
    }

    public static void b(MMActivity mMActivity, boolean z) {
        int color = mMActivity.getResources().getColor(R.e.white);
        mMActivity.getSupportActionBar().setBackgroundDrawable(null);
        Drawable shapeDrawable = new ShapeDrawable();
        shapeDrawable.getPaint().setColor(color);
        mMActivity.getSupportActionBar().setBackgroundDrawable(shapeDrawable);
        View customView = mMActivity.getSupportActionBar().getCustomView();
        if (customView != null) {
            View findViewById = customView.findViewById(R.h.divider);
            if (findViewById != null) {
                if (z) {
                    findViewById.setBackgroundColor(mMActivity.getResources().getColor(R.e.bsK));
                } else {
                    findViewById.setVisibility(8);
                }
            }
            findViewById = customView.findViewById(R.h.bIX);
            if (findViewById != null) {
                ((ImageView) findViewById).setImageResource(R.g.bAl);
            }
            findViewById = customView.findViewById(16908308);
            if (findViewById != null && (findViewById instanceof TextView)) {
                ((TextView) findViewById).setTextColor(mMActivity.getResources().getColor(R.e.black));
            }
            findViewById = customView.findViewById(16908309);
            if (findViewById != null && (findViewById instanceof TextView)) {
                ((TextView) findViewById).setTextColor(mMActivity.getResources().getColor(R.e.black));
            }
            customView.setBackgroundDrawable(shapeDrawable);
        }
    }

    public static void b(TextView textView, int i) {
        switch (i) {
            case 0:
                textView.setText(R.l.dPN);
                return;
            case 1:
                textView.setText(R.l.dPI);
                return;
            case 2:
                textView.setText(R.l.dPL);
                return;
            case 3:
                textView.setText(R.l.dPK);
                return;
            case 4:
                textView.setText(R.l.dPO);
                return;
            case 5:
                textView.setText(R.l.dPP);
                return;
            case 6:
                textView.setText(R.l.dPJ);
                return;
            case 7:
                textView.setText(R.l.dPM);
                return;
            default:
                return;
        }
    }
}
