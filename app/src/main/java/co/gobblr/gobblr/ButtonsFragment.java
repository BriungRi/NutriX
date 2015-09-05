package co.gobblr.gobblr;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * Created by Brian on 9/4/2015.
 */
public class ButtonsFragment extends Fragment implements View.OnClickListener {

    Button bHome;
    Button bProfile;
    Button bSettings;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.buttons_fragment, container, false);

        bHome = (Button) view.findViewById(R.id.bHome);
        bProfile = (Button) view.findViewById(R.id.bProfile);
        bSettings = (Button) view.findViewById(R.id.bSettings);

        bHome.setOnClickListener(this);
        bProfile.setOnClickListener(this);
        bSettings.setOnClickListener(this);

        return view;
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case (R.id.bHome):
                break;
            case (R.id.bProfile):
                break;
            case (R.id.bSettings):
                break;
        }
    }
}

