package www.alltest.dinu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Test2Activity extends DinuNewClass {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.content_ticket_details);


        setToolbarTitleName("Abstract Class Working");

        setToolbarSubTitle("Second Activity");

        setToolbarBackArrow(R.drawable.ic_arrow_back_white);
    }
}
