package com.ccb.test.anny.imagetest.fragment;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.bumptech.glide.Glide;
import com.ccb.test.anny.imagetest.R;
import com.ccb.test.anny.imagetest.model.TestData;
import com.ccb.test.anny.imagetest.view.ZoomImageView;


public class FactorInputFragment extends Fragment {

    private ZoomImageView imageView;
    private EditText editText;
    private Button commitButton;

    int factorPosition = 0;

  /*  Uri successImageUri =
            TestData.getImageUriByResourceId(getResources(), R.drawable.success_image);
*/
    int[] buttonTextRId = {R.string.factor_commit_button,
            R.string.factor_request_button};
    int buttonIndex = 0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_factor_input, container, false);
        imageView = (ZoomImageView) view.findViewById(R.id.slieceImageView);
        editText = (EditText) view.findViewById(R.id.slice_value_editText);
        commitButton = (Button) view.findViewById(R.id.slice_commit_button);
        String buttonText = getButtonText(buttonIndex);
        commitButton.setText(buttonText);
        commitButton.setOnClickListener(new CommitButtonOnClickListener());
        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onStart() {
        super.onStart();
        Uri imageUri = TestData.getImageUriByIndex(getResources(), factorPosition);
        showImageByUri(imageUri);
    }

    private void showImageByUri(Uri imageUri) {
        Glide.with(this).load(imageUri).into(imageView);
    }

    private int getButtonRId(int buttonIndex) {
        int index = buttonIndex % buttonTextRId.length;
        return buttonTextRId[index];
    }

    private String getButtonText(int buttonIndex) {
        return getString(getButtonRId(buttonIndex));
    }

    class CommitButtonOnClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            int buttonTextRId = getButtonRId(buttonIndex);
            if(R.string.factor_commit_button == buttonTextRId) {

                //提交
                showImageByUri(TestData.getImageUriByResourceId(getResources(),
                        R.drawable.success_image));
            } else if(R.string.factor_request_button == buttonTextRId) {
                //获取
                factorPosition++;
                showImageByUri(TestData.getImageUriByIndex(getResources(),
                        factorPosition));
            }
            buttonIndex++;
            commitButton.setText(getButtonText(buttonIndex));

        }
    }
}
