package com.tencent.mm.plugin.ipcall.ui;

import android.content.Context;
import android.media.AudioManager;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.RelativeLayout;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.mm.R;
import com.tencent.mm.plugin.ipcall.a.i;
import com.tencent.mm.plugin.voip.video.d;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.as;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.util.HashMap;
import java.util.Map;

public class DialPad extends RelativeLayout implements OnClickListener, OnLongClickListener {
    private static final String[] nMD = new String[]{"1", "2", TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL, "4", "5", "6", "7", "8", "9", "*", "0", "#"};
    private static final String[] nME = new String[]{"", "ABC", "DEF", "GHI", "JKL", "MNO", "PQRS", "TUV", "WXYZ", "", "+", ""};
    boolean nMC = false;
    Map<Integer, DialNumberButton> nMF = new HashMap();
    private Map<String, DialNumberButton> nMG = new HashMap();
    Map<Integer, View> nMH = new HashMap();
    a nMI;

    public interface a {
        void Dn(String str);

        void Do(String str);
    }

    public DialPad(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.i.cbV, this);
        float dimensionPixelSize = (float) getContext().getResources().getDimensionPixelSize(R.f.bxE);
        float dimensionPixelSize2 = (float) getContext().getResources().getDimensionPixelSize(R.f.bxG);
        float dimensionPixelSize3 = (float) getContext().getResources().getDimensionPixelSize(R.f.bxF);
        a(R.h.cbN, nMD[0], nME[0], dimensionPixelSize);
        a(R.h.cbT, nMD[1], nME[1], dimensionPixelSize);
        a(R.h.cbS, nMD[2], nME[2], dimensionPixelSize);
        a(R.h.cbL, nMD[3], nME[3], dimensionPixelSize);
        a(R.h.cbK, nMD[4], nME[4], dimensionPixelSize);
        a(R.h.cbQ, nMD[5], nME[5], dimensionPixelSize);
        a(R.h.cbO, nMD[6], nME[6], dimensionPixelSize);
        a(R.h.cbJ, nMD[7], nME[7], dimensionPixelSize);
        a(R.h.cbM, nMD[8], nME[8], dimensionPixelSize);
        a(R.h.cbR, nMD[9], nME[9], dimensionPixelSize3);
        a(R.h.cbU, nMD[10], nME[10], dimensionPixelSize);
        a(R.h.cbP, nMD[11], nME[11], dimensionPixelSize2);
        this.nMH.put(Integer.valueOf(R.h.ccr), findViewById(R.h.ccr));
        this.nMH.put(Integer.valueOf(R.h.cct), findViewById(R.h.cct));
        this.nMH.put(Integer.valueOf(R.h.ccs), findViewById(R.h.ccs));
        this.nMH.put(Integer.valueOf(R.h.ccp), findViewById(R.h.ccp));
        this.nMH.put(Integer.valueOf(R.h.cco), findViewById(R.h.cco));
        for (View view : this.nMH.values()) {
            if (this.nMC) {
                view.setBackgroundDrawable(getResources().getDrawable(R.e.btX));
            } else {
                view.setBackgroundDrawable(getResources().getDrawable(R.e.bsb));
            }
        }
        setClipToPadding(false);
        setClipChildren(false);
    }

    private void a(int i, String str, String str2, float f) {
        DialNumberButton dialNumberButton = (DialNumberButton) findViewById(i);
        if (!bi.oN(str) && str.length() == 1) {
            dialNumberButton.nMA.setText(str);
        }
        if (!bi.oN(str2) || "1".equals(str)) {
            dialNumberButton.nMB.setText(str2);
            dialNumberButton.nMB.setVisibility(0);
        } else {
            dialNumberButton.nMB.setVisibility(8);
        }
        dialNumberButton.nMA.setTextSize(0, f);
        dialNumberButton.setOnClickListener(this);
        dialNumberButton.setOnLongClickListener(this);
        dialNumberButton.gg(this.nMC);
        this.nMF.put(Integer.valueOf(i), dialNumberButton);
        this.nMG.put(str, dialNumberButton);
    }

    public void onClick(View view) {
        if (this.nMF.containsKey(Integer.valueOf(view.getId()))) {
            DialNumberButton dialNumberButton = (DialNumberButton) this.nMF.get(Integer.valueOf(view.getId()));
            String aUQ = dialNumberButton.aUQ();
            String aUR = dialNumberButton.aUR();
            d aUp = i.aUp();
            int Nm = d.Nm(aUQ);
            if (Nm != -1 && d.bJm()) {
                AudioManager audioManager = as.Hn().gDM;
                if (audioManager == null) {
                    audioManager = (AudioManager) d.mContext.getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE);
                }
                int ringerMode = audioManager.getRingerMode();
                if (!(ringerMode == 0 || ringerMode == 1)) {
                    synchronized (aUp.szv) {
                        if (aUp.szw == null) {
                        } else {
                            aUp.szw.startTone(Nm, 250);
                        }
                    }
                }
            }
            if (this.nMI != null) {
                String str;
                a aVar = this.nMI;
                if (bi.oN(aUQ)) {
                    str = aUR;
                } else {
                    str = aUQ;
                }
                aVar.Dn(str);
            }
        }
    }

    public boolean onLongClick(View view) {
        if (!this.nMF.containsKey(Integer.valueOf(view.getId()))) {
            return false;
        }
        DialNumberButton dialNumberButton = (DialNumberButton) this.nMF.get(Integer.valueOf(view.getId()));
        String aUQ = dialNumberButton.aUQ();
        String aUR = dialNumberButton.aUR();
        if (this.nMI != null) {
            a aVar = this.nMI;
            if (!bi.oN(aUQ)) {
                aUR = aUQ;
            }
            aVar.Do(aUR);
        }
        return true;
    }

    public void onViewAdded(View view) {
        x.i("MicroMsg.DialPad", "onViewAdded, class: %s", view.getClass().getSimpleName());
    }

    public void onViewRemoved(View view) {
        x.i("MicroMsg.DialPad", "onViewRemoved, class: %s", view.getClass().getSimpleName());
    }
}
