package com.d.common.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.PopupWindow;

import androidx.annotation.Nullable;

import com.d.lib.common.util.ViewHelper;
import com.d.lib.common.widget.popup.MenuPopup;
import com.d.lib.common.widget.popup.PopupWindowFactory;

import java.util.Arrays;

public class StatusActivity extends Activity implements View.OnClickListener {

    @Override
    public void onClick(View v) {
        int resId = v.getId();
        if (resId == R.id.iv_title_left) {
            finish();
        } else if (resId == R.id.iv_title_right) {
            MenuPopup menuPopup = PopupWindowFactory.createFactory(this)
                    .getMenuPopup(Arrays.asList(new MenuPopup.Bean(getResources().getString(R.string.module_ui_dialog_title) + "1",
                                    R.color.lib_pub_color_white, false),
                            new MenuPopup.Bean(getResources().getString(R.string.module_ui_dialog_title) + "2",
                                    R.color.lib_pub_color_main, false)), new MenuPopup.OnMenuListener() {
                        @Override
                        public void onClick(PopupWindow popup, int position, String item) {

                        }
                    });
            menuPopup.showAsDropDown((View) ViewHelper.findViewById(this, R.id.iv_title_right));
        }
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.module_ui_activity_status);
        initClick();
    }

    private void initClick() {
        ViewHelper.setOnClickListener(this, this, R.id.iv_title_left);
        ViewHelper.setOnClickListener(this, this, R.id.iv_title_right);
    }
}
