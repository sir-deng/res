package com.tencent.mm.plugin.appbrand.wxawidget.console;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView.t;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mm.modelappbrand.LogInfo;
import com.tencent.mm.plugin.appbrand.jsapi.a.d;
import com.tencent.mm.plugin.appbrand.wxawidget.b.b;
import com.tencent.mm.plugin.appbrand.wxawidget.b.c;
import com.tencent.rtmp.sharp.jni.QLog;
import com.tencent.smtt.sdk.WebView;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

final class a extends android.support.v7.widget.RecyclerView.a {
    private static final SimpleDateFormat knb = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
    LayoutInflater DF;
    List<LogInfo> knc = new LinkedList();

    private static class a extends t {
        TextView ipP;
        TextView knd;

        public a(View view, int i) {
            super(view);
            this.knd = (TextView) view.findViewById(b.kmw);
            this.ipP = (TextView) view.findViewById(b.bYU);
            switch (i) {
                case 1:
                    this.knd.setText("L");
                    this.ipP.setTextColor(-7829368);
                    return;
                case 2:
                    this.knd.setText("I");
                    this.ipP.setTextColor(WebView.NIGHT_MODE_COLOR);
                    return;
                case 3:
                    this.knd.setText(QLog.TAG_REPORTLEVEL_COLORUSER);
                    this.ipP.setTextColor(Color.rgb(0, 0, d.CTRL_INDEX));
                    return;
                case 4:
                    this.knd.setText(QLog.TAG_REPORTLEVEL_USER);
                    this.ipP.setTextColor(-65536);
                    return;
                default:
                    this.knd.setText("L");
                    this.ipP.setTextColor(-7829368);
                    return;
            }
        }
    }

    a(Context context) {
        this.DF = LayoutInflater.from(context);
    }

    public final t a(ViewGroup viewGroup, int i) {
        return new a(this.DF.inflate(c.kmP, viewGroup, false), i);
    }

    public final void a(t tVar, int i) {
        LogInfo logInfo = (LogInfo) this.knc.get(i);
        ((a) tVar).ipP.setText(String.format("[%s] %s", new Object[]{knb.format(new Date(logInfo.hlm)), logInfo.message}));
    }

    public final int getItemCount() {
        return this.knc.size();
    }

    public final int getItemViewType(int i) {
        return ((LogInfo) this.knc.get(i)).level;
    }
}
