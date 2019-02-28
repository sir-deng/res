package com.tencent.mm.plugin.exdevice.ui;

import android.content.Context;
import android.content.Intent;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.d.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.r;
import com.tencent.wcdb.FileUtils;

public class ExdeviceRankChampionInfoView extends LinearLayout {
    private int gVQ = 0;
    private TextPaint gu;
    private String jPV;
    private TextView kZb;
    private ImageView lXc;

    public void setAlpha(float f) {
        this.kZb.setAlpha(f);
        this.lXc.setAlpha(f);
    }

    public ExdeviceRankChampionInfoView(final Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        View inflate = LayoutInflater.from(context).inflate(R.i.dhe, this, true);
        this.gu = new TextPaint(1);
        this.kZb = (TextView) inflate.findViewById(R.h.cSn);
        this.lXc = (ImageView) inflate.findViewById(R.h.bLE);
        this.lXc.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                if (bi.oN(ExdeviceRankChampionInfoView.this.jPV)) {
                    x.w("MicroMsg.ExdeviceRankChampionInfoView", "username is null.");
                    return;
                }
                Intent intent = new Intent(context, ExdeviceProfileUI.class);
                intent.putExtra("username", ExdeviceRankChampionInfoView.this.jPV);
                context.startActivity(intent);
            }
        });
        this.kZb.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                if (bi.oN(ExdeviceRankChampionInfoView.this.jPV)) {
                    x.w("MicroMsg.ExdeviceRankChampionInfoView", "username is null.");
                    return;
                }
                Intent intent = new Intent(context, ExdeviceProfileUI.class);
                intent.putExtra("username", ExdeviceRankChampionInfoView.this.jPV);
                context.startActivity(intent);
            }
        });
        try {
            this.gVQ = context.getResources().getDimensionPixelSize(R.f.buV);
            if (this.gVQ <= 0) {
                this.gVQ = FileUtils.S_IWUSR;
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.ExdeviceRankChampionInfoView", e, "", new Object[0]);
            if (this.gVQ <= 0) {
                this.gVQ = FileUtils.S_IWUSR;
            }
        } catch (Throwable th) {
            if (this.gVQ <= 0) {
                this.gVQ = FileUtils.S_IWUSR;
            }
        }
        x.d("MicroMsg.ExdeviceRankChampionInfoView", "ap: ellipsizewidth: %d", Integer.valueOf(this.gVQ));
    }

    public final void zW(String str) {
        this.jPV = str;
        if (this.kZb != null) {
            if (bi.oN(str)) {
                this.kZb.setVisibility(8);
                this.kZb.setText("");
            } else {
                this.kZb.setVisibility(0);
                Context context = getContext();
                int i = R.l.ecT;
                Object[] objArr = new Object[1];
                objArr[0] = TextUtils.ellipsize(i.a(getContext(), r.gw(this.jPV)), this.gu, (float) this.gVQ, TruncateAt.END);
                x.d("MicroMsg.ExdeviceRankChampionInfoView", "title : %s", i.a(getContext(), context.getString(i, objArr)));
                this.kZb.setText(i.b(getContext(), r0, this.kZb.getTextSize()));
            }
        }
        if (this.lXc == null) {
            return;
        }
        if (bi.oN(str)) {
            this.lXc.setVisibility(4);
            return;
        }
        b.o(this.lXc, str);
        this.lXc.setVisibility(0);
    }
}
