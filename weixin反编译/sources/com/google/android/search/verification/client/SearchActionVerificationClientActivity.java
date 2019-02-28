package com.google.android.search.verification.client;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public abstract class SearchActionVerificationClientActivity extends Activity {
    public abstract Class<? extends SearchActionVerificationClientService> rv();

    protected final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = new Intent(this, rv());
        intent.putExtra("SearchActionVerificationClientExtraIntent", getIntent());
        startService(intent);
        finish();
    }
}
