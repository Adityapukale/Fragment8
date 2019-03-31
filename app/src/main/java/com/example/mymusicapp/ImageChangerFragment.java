package com.example.mymusicapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ViewSwitcher;

public class ImageChangerFragment extends Fragment {

    private ImageSwitcher imageSwitcher;
    private Button btnprev,btnnext;
    private static final int[] IMAGES={R.drawable.ic_launcher_foreground,R.drawable.ic_launcher_background};
    private int mPosition=-1;

    public ImageChangerFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_image_changer, container, false);
        btnprev=(Button)view.findViewById(R.id.idBtnPrevious);
        btnnext=(Button)view.findViewById(R.id.idBtnNext);
        imageSwitcher=(ImageSwitcher)view.findViewById(R.id.idImageSwitcher);
        imageSwitcher.setFactory(new ViewSwitcher.ViewFactory()
        {
            public View makeView()
            {
                ImageView imageView=new ImageView(getActivity().getApplicationContext());
                imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                imageView.setLayoutParams(new ImageSwitcher.LayoutParams(ActionBar.LayoutParams.WRAP_CONTENT,ActionBar.LayoutParams.WRAP_CONTENT));
                return imageView;
            }
        });
        btnnext.setOnClickListener(new View.OnClickListener()
        {
            public void onClick (View view)
            {
                if(mPosition<IMAGES.length-1)
                {
                    mPosition=mPosition+1;
                    imageSwitcher.setBackgroundResource(IMAGES[mPosition]);
                    Toast.makeText(getActivity().getApplicationContext(),"Position: "+ mPosition,Toast.LENGTH_SHORT).show();

                }
            }
        });
        btnprev.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                if(mPosition>0)
                {
                    mPosition=mPosition-1;
                    imageSwitcher.setBackgroundResource(IMAGES[mPosition]);
                    Toast.makeText(getActivity().getApplicationContext(),"Position "+mPosition,Toast.LENGTH_SHORT).show();
                }
            }
        });

        return view;
    }


}
