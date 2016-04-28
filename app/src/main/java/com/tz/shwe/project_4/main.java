package com.tz.shwe.project_4;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.ToggleButton;
import android.view.View;
import android.widget.CompoundButton;

import java.util.Vector;

public class main extends AppCompatActivity {

    Vector sh_lst;
    Button bt_rct, bt_crc, bt_cls;
    ToggleButton tb_mod, tb_grv;

    Shape sh;
    ShapeFactory sh_fact;
    Context cntx;
    TextView txt_vw;
    public static float width, height, div, min;
    RelativeLayout sh_lyt;
    String mode;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sh_lyt = (RelativeLayout) findViewById(R.id.rltv_lyt);
        div = 3;
        min = 100;

        sh_lst = new Vector();
        bt_rct = (Button) findViewById(R.id.btn_rct);
        bt_crc = (Button) findViewById(R.id.btn_crc);
        bt_cls = (Button) findViewById(R.id.btn_cls);

        sh_fact = Factory.get_shape_factory(Color.GREEN, Color.BLUE);
        cntx = this.getApplicationContext();
        txt_vw = (TextView) findViewById(R.id.textView);

        mode = "normal";

        bt_rct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adjustShapeAlpha();
                sh = sh_fact.getShape(cntx, ShapeType.Rectangle);
                sh_lst.add(sh);
                sh_lyt.addView(sh);
                updateShapeCount();
            }
        });

        bt_crc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adjustShapeAlpha();
                sh = sh_fact.getShape(cntx, ShapeType.Circle);
                sh_lst.add(sh);
                sh_lyt.addView(sh);
                updateShapeCount();
            }
        });

        bt_cls.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sh_lst.clear();
                sh_lyt.removeAllViews();
                updateShapeCount();
            }
        });
    }
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        updateSizeInfo();
    }
    private void updateSizeInfo() {
        width = sh_lyt.getWidth();
        height = sh_lyt.getHeight();
    }
    void adjustShapeAlpha() {
        for (int i = 0; i < sh_lst.size(); i++) {
            Shape tmp = (Shape) sh_lst.get(i);
            if (tmp.getShapeAlpha() > 0.1f) {
                tmp.setShapeAlpha(tmp.getShapeAlpha() - 0.1f);
            } else {
                tmp.removeShape();
                sh_lst.remove(i);
            }
        }

    }
    void updateShapeCount() {
        int rct_cnt = 0, crc_cnt = 0;
        for (int i = 0; i < sh_lst.size(); i++) {
            Shape tmp = (Shape) sh_lst.get(i);
            ShapeType sh_t = tmp.getShapeType();
            if (sh_t == ShapeType.Rectangle)
                rct_cnt++;
            else if (sh_t == ShapeType.Circle)
                crc_cnt++;
        }
        txt_vw.setText(rct_cnt + " Rectangles, " + crc_cnt + " Circles.");
    }
}
