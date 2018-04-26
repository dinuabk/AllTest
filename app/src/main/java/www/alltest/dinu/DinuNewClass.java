package www.alltest.dinu;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

@SuppressWarnings("All")
public abstract class DinuNewClass extends AppCompatActivity {

    private Toolbar toolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public void setContentView(int layoutId) {

        ViewGroup rootView = (ViewGroup) getLayoutInflater().inflate(R.layout.toolbar, null);
        LayoutInflater.from(this).inflate(layoutId, rootView, true);

        toolbar = (Toolbar) rootView.findViewById(R.id.app_toolbar);
        setSupportActionBar(toolbar);

        super.setContentView(rootView);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                super.onBackPressed();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public Toolbar getToolBar() {
        return this.toolbar;
    }

    public void hideToolBar() {
        this.toolbar.setVisibility(View.GONE);
    }

    public void setLogo(int drawable) {
        ((ImageView) findViewById(R.id.logo)).setImageResource(drawable);
    }

    public void setToolbarTitleName(String title) {
        toolbar.setTitle(title);
    }

    public void setToolbarSubTitle(String subTitle) {
        toolbar.setSubtitle(subTitle);
    }

    public void setToolbarBackArrow(int drawableId) {
        toolbar.setNavigationIcon(drawableId);
    }

}
