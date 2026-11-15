package com.carta.vpn;

import android.app.Activity;
import android.app.AlertDialog;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.*;

public class MainActivity extends Activity {
    private final String[] countries = {"🇺🇸  United States", "🇨🇦  Canada", "🇮🇹  Italy",
        "🇫🇷  France", "🇬🇧  United Kingdom", "🇩🇪  Germany", "🇸🇬  Singapore"};
    private int current = 0;
    private final int white = Color.WHITE, muted = Color.rgb(151,170,193), blue = Color.rgb(63,169,245);
    private TextView selected;

    @Override public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setStatusBarColor(Color.rgb(7,17,31));
        getWindow().setNavigationBarColor(Color.rgb(7,17,31));
        LinearLayout page = new LinearLayout(this);
        page.setOrientation(LinearLayout.VERTICAL);
        page.setPadding(dp(24),dp(26),dp(24),dp(20));
        page.setBackgroundColor(Color.rgb(7,17,31));

        TextView brand = text("SARTAJ VPN",24,white,true);
        brand.setLetterSpacing(.14f);
        page.addView(brand);
        TextView by = text("CREATED BY SARTAJ BAJAURI",10,blue,true);
        by.setLetterSpacing(.13f);
        LinearLayout.LayoutParams byp = lp(-2,-2); byp.topMargin=dp(7); page.addView(by,byp);

        TextView globe=text("◉",54,blue,true); globe.setGravity(Gravity.CENTER);
        LinearLayout.LayoutParams gp=lp(-1,dp(118)); gp.topMargin=dp(24); page.addView(globe,gp);
        TextView title=text("Fast. Private. Connected.",24,white,true); title.setGravity(Gravity.CENTER);
        page.addView(title,lp(-1,-2));
        TextView sub=text("A smoother way to stay connected",14,muted,false); sub.setGravity(Gravity.CENTER);
        LinearLayout.LayoutParams sp=lp(-1,-2); sp.topMargin=dp(8); page.addView(sub,sp);

        selected=text(countries[current]+"     ▾",17,white,true);
        selected.setGravity(Gravity.CENTER); selected.setPadding(dp(12),dp(18),dp(12),dp(18));
        selected.setBackground(round(Color.rgb(17,34,55),16,Color.rgb(39,66,96)));
        LinearLayout.LayoutParams cp=lp(-1,-2); cp.topMargin=dp(26); page.addView(selected,cp);
        selected.setOnClickListener(v -> chooseCountry());

        TextView connect=text("CONNECT",17,white,true); connect.setGravity(Gravity.CENTER);
        connect.setLetterSpacing(.15f);
        connect.setBackground(round(Color.rgb(25,119,201),40,Color.rgb(25,119,201)));
        LinearLayout.LayoutParams bp=lp(-1,dp(62)); bp.topMargin=dp(20); page.addView(connect,bp);
        connect.setOnClickListener(v -> new AlertDialog.Builder(this)
            .setTitle("Server setup in progress")
            .setMessage("This preview app does not yet create a VPN tunnel. Real encrypted access requires deployed VPN servers and WireGuard client configuration.")
            .setPositiveButton("OK",null).show());

        TextView statusLabel=text("●  READY TO CONNECT",12,Color.rgb(255,190,90),true);
        statusLabel.setGravity(Gravity.CENTER);
        LinearLayout.LayoutParams st=lp(-1,-2); st.topMargin=dp(18); page.addView(statusLabel,st);

        TextView premium=text("✦  PREMIUM EXPERIENCE",14,blue,true);
        premium.setGravity(Gravity.CENTER); premium.setPadding(dp(12),dp(16),dp(12),dp(16));
        premium.setBackground(round(Color.rgb(13,29,48),14,Color.rgb(37,86,126)));
        LinearLayout.LayoutParams pp=lp(-1,-2); pp.topMargin=dp(24); page.addView(premium,pp);
        TextView list=text("🇺🇸 USA   🇨🇦 Canada   🇮🇹 Italy\n🇫🇷 France   🇬🇧 UK   🇩🇪 Germany   🇸🇬 Singapore",13,white,false);
        list.setGravity(Gravity.CENTER); list.setLineSpacing(dp(8),1f);
        LinearLayout.LayoutParams l=lp(-1,-2); l.topMargin=dp(17); page.addView(list,l);

        TextView note=text("Stable speeds depend on server capacity and your network.",10,muted,false);
        note.setGravity(Gravity.CENTER);
        LinearLayout.LayoutParams np=lp(-1,-2); np.topMargin=dp(20); page.addView(note,np);
        setContentView(page);
    }
    private void chooseCountry() {
        new AlertDialog.Builder(this).setTitle("Choose a location")
            .setSingleChoiceItems(countries,current,(d,w)->{current=w;selected.setText(countries[w]+"     ▾");d.dismiss();})
            .setNegativeButton("CANCEL",null).show();
    }
    private TextView text(String s,int size,int color,boolean bold) {
        TextView t=new TextView(this);t.setText(s);t.setTextSize(size);t.setTextColor(color);
        if(bold)t.setTypeface(Typeface.DEFAULT,Typeface.BOLD);return t;
    }
    private GradientDrawable round(int color,int radius,int stroke) {
        GradientDrawable d=new GradientDrawable();d.setColor(color);d.setCornerRadius(dp(radius));d.setStroke(dp(1),stroke);return d;
    }
    private LinearLayout.LayoutParams lp(int w,int h){return new LinearLayout.LayoutParams(w,h);}
    private int dp(int v){return (int)(v*getResources().getDisplayMetrics().density+.5f);}
}
