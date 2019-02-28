package com.tencent.mm.ui.applet;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.i;
import com.tencent.mm.v.a.g;
import com.tencent.mm.v.a.h;
import com.tencent.mm.v.a.k;

public class SecurityImage extends LinearLayout {
    private i pDT = null;
    public String xXV = null;
    public String xXW = null;
    public int xXY = 0;
    ProgressBar yeU = null;
    ImageView yeV = null;
    Button yeW = null;
    EditText yeX = null;
    b yeY;

    public static class a {
        public static SecurityImage a(Context context, int i, int i2, byte[] bArr, String str, String str2, final OnClickListener onClickListener, OnCancelListener onCancelListener, OnDismissListener onDismissListener, b bVar) {
            final SecurityImage securityImage = (SecurityImage) View.inflate(context, h.gZN, null);
            if (securityImage.yeY != null) {
                securityImage.yeY.yfb = null;
            }
            securityImage.yeY = bVar;
            securityImage.yeY.yfb = securityImage;
            securityImage.yeU = (ProgressBar) securityImage.findViewById(g.gXP);
            securityImage.yeV = (ImageView) securityImage.findViewById(g.gWZ);
            securityImage.yeW = (Button) securityImage.findViewById(g.gWX);
            securityImage.yeX = (EditText) securityImage.findViewById(g.gWY);
            securityImage.yeW.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    SecurityImage.this.mk(false);
                    if (SecurityImage.this.yeY != null) {
                        SecurityImage.this.yeY.cox();
                    }
                }
            });
            securityImage.a(i2, bArr, str, str2);
            com.tencent.mm.ui.base.i.a aVar = new com.tencent.mm.ui.base.i.a(context);
            aVar.ES(i);
            aVar.EV(k.dEC).a(new OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    onClickListener.onClick(dialogInterface, i);
                }
            });
            aVar.d(onCancelListener);
            aVar.dk(securityImage);
            aVar.mp(true);
            securityImage.pDT = aVar.ale();
            securityImage.pDT.setOnDismissListener(onDismissListener);
            securityImage.pDT.show();
            return securityImage;
        }
    }

    public static abstract class b {
        public SecurityImage yfb;

        public abstract void cox();
    }

    public SecurityImage(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public final void a(int i, byte[] bArr, String str, String str2) {
        mk(true);
        this.xXV = str;
        this.xXW = str2;
        this.xXY = i;
        Bitmap bn = d.bn(bArr);
        if (bn != null) {
            x.i("MicroMsg.SecurityImage", "dkwt setSecImg sid:%s key:%s imgBuf:%d [%d %d]", str, str2, Integer.valueOf(bArr.length), Integer.valueOf(bn.getWidth()), Integer.valueOf(bn.getHeight()));
            this.xXV = str;
            this.xXW = str2;
            this.xXY = i;
            if (bn != null) {
                this.yeV.setImageBitmap(bn);
                return;
            } else {
                x.e("MicroMsg.SecurityImage", "setSecImg failed, decode failed");
                return;
            }
        }
        String str3 = "MicroMsg.SecurityImage";
        String str4 = "dkwt setSecImg ERROR sid:%s key:%s imgBuf:%d";
        Object[] objArr = new Object[3];
        objArr[0] = str;
        objArr[1] = str2;
        objArr[2] = Integer.valueOf(bArr == null ? -1 : bArr.length);
        x.e(str3, str4, objArr);
    }

    public final String cpt() {
        return this.yeX == null ? "" : this.yeX.getText().toString().trim();
    }

    public final void dismiss() {
        if (this.pDT != null) {
            this.pDT.dismiss();
            this.pDT = null;
        }
    }

    private void mk(boolean z) {
        int i = 0;
        this.yeV.setAlpha(z ? 255 : 40);
        this.yeV.setBackgroundColor(z ? 0 : -5592406);
        ProgressBar progressBar = this.yeU;
        if (z) {
            i = 4;
        }
        progressBar.setVisibility(i);
    }
}
