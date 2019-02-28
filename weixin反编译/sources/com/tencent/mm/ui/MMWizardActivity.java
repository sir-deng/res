package com.tencent.mm.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;
import junit.framework.Assert;

public abstract class MMWizardActivity extends MMActivity {
    public static final Map<String, Intent> xTb = new HashMap();

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        x.i("MicroMsg.MMWizardActivity", "onCreate()");
        Assert.assertFalse("MMWizardActivity Should Start By startWizardActivity or startWizardNextStep", bi.oN(getIntent().getExtras().getString("WizardRootClass")));
        if (getIntent().getExtras().getBoolean("WizardRootKillSelf", false)) {
            super.finish();
            x.i("MicroMsg.MMWizardActivity", "finish wizard, root=" + getComponentName().getClassName());
            exit(getIntent().getExtras().getInt("wizard_activity_result_code"));
        }
    }

    public static void A(Context context, Intent intent) {
        String stringExtra;
        String str = null;
        x.i("MicroMsg.MMWizardActivity", "startWizardActivity()");
        Assert.assertTrue("startWizardActivity: Param context should be a Activity :" + context.toString(), context instanceof Activity);
        Intent intent2 = ((Activity) context).getIntent();
        if (intent2 != null) {
            str = intent2.getStringExtra("WizardRootClass");
            stringExtra = intent2.getStringExtra("WizardTransactionId");
        } else {
            stringExtra = null;
        }
        if (bi.oN(str)) {
            try {
                str = intent.getComponent().getClassName();
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.MMWizardActivity", e, "", new Object[0]);
            }
        }
        Assert.assertFalse("startWizardActivity: ERROR in Get Root Class :[" + intent + "][ " + intent.getComponent() + " ]", bi.oN(str));
        intent.putExtra("WizardRootClass", str);
        if (stringExtra != null) {
            intent.putExtra("WizardTransactionId", stringExtra);
        }
        context.startActivity(intent);
    }

    public static void b(Context context, Intent intent, Intent intent2) {
        try {
            String str = "trans." + bi.Wz() + "." + intent2.hashCode();
            xTb.put(str, intent2);
            intent.putExtra("WizardTransactionId", str);
            Intent intent3 = ((Activity) context).getIntent();
            if (intent3 != null) {
                intent3.putExtra("WizardTransactionId", str);
            }
            A(context, intent);
        } catch (Throwable e) {
            x.e("MicroMsg.MMWizardActivity", "%s", bi.i(e));
        }
    }

    public final void exit(int i) {
        x.i("MicroMsg.MMWizardActivity", "exit()");
        String stringExtra = getIntent().getStringExtra("WizardTransactionId");
        Intent intent = (Intent) xTb.get(stringExtra);
        xTb.remove(stringExtra);
        if (intent != null) {
            x.d("MicroMsg.MMWizardActivity", "doing post exit for transaction=" + stringExtra + ", intent=" + intent);
            intent.putExtra("wizard_activity_result_code", i);
            startActivity(intent);
        }
    }

    public final void cancel() {
        x.i("MicroMsg.MMWizardActivity", "cancel()");
        String stringExtra = getIntent().getStringExtra("WizardTransactionId");
        Intent intent = (Intent) xTb.get(stringExtra);
        xTb.remove(stringExtra);
        if (intent != null) {
            x.d("MicroMsg.MMWizardActivity", "canceled exit for transaction=" + stringExtra + ", intent=" + intent);
        }
    }

    public final void En(int i) {
        x.i("MicroMsg.MMWizardActivity", "finishWizard()");
        String string = getIntent().getExtras().getString("WizardRootClass");
        Assert.assertFalse("finishWizard: ERROR in Get Root Class :[" + string + "]", bi.oN(string));
        Intent className = new Intent().setClassName(this, string);
        className.putExtra("WizardRootClass", getIntent().getStringExtra("WizardRootClass"));
        className.putExtra("WizardTransactionId", getIntent().getStringExtra("WizardTransactionId"));
        className.putExtra("WizardRootKillSelf", true);
        className.putExtra("wizard_activity_result_code", i);
        className.addFlags(67108864);
        startActivity(className);
    }

    public void finish() {
        x.i("MicroMsg.MMWizardActivity", "finish()");
        if (getComponentName().getClassName().equals(getIntent().getStringExtra("WizardRootClass"))) {
            x.d("MicroMsg.MMWizardActivity", "root wizard activity");
            exit(-1);
        }
        super.finish();
    }
}
