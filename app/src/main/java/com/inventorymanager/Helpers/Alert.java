package com.inventorymanager.Helpers;

import android.support.v4.app.DialogFragment;

public class Alert extends DialogFragment {

    /*public interface AlertListener {
        void onDialogPositiveClick(DialogFragment dialog);
        void onDialogNegativeClick(DialogFragment dialog);
    }

    private AlertListener listener;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            listener = (AlertListener) context;
        } catch (ClassCastException e) {
           *//* // The activity doesn't implement the interface, throw exception
            throw new ClassCastException(activity.toString()
                    + " must implement NoticeDialogListener");*//*
        }
    }


    //https://developer.android.com/guide/topics/ui/dialogs#java
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        final String password = getArguments().getString("password");

        // Use the Builder class for convenient dialog construction
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
       builder.setMessage("Please Confirm Changes !")
                .setIcon(android.R.drawable.star_on)
                .setPositiveButton(R.string.alertYesBtn, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        listener.onDialogPositiveClick(Alert.this);
                        Toast.makeText(getActivity(), " Confirm changing the password : " + password, Toast.LENGTH_LONG).show();
                    }
                })
                .setNegativeButton(R.string.alertNoBtn, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        listener.onDialogNegativeClick(Alert.this);
                        Toast.makeText(getActivity(), " Cancel changing the password : " + password, Toast.LENGTH_LONG).show();

                    }
                });
        // Create the AlertDialog object and return it
        return builder.create();
    }*/
}
