package com.inventorymanager.Helpers.Adapters;

import android.support.annotation.NonNull;
import android.support.design.widget.TextInputEditText;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.LinearLayout;

import com.inventorymanager.Models.Entities.User;
import com.inventorymanager.R;

import java.util.ArrayList;
import java.util.List;

public class AccountAdapter extends RecyclerView.Adapter<AccountAdapter.AccountHolder> {
    private List<User> users = new ArrayList<>();
    private OnItemClickListener listener;
    int mRecentlyDeletedItemPosition;
    User mRecentlyDeletedItem;


    @NonNull
    @Override
    public AccountHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.account_card, viewGroup, false);
        return new AccountHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull AccountHolder accountHolder, int i) {
        User currentUser = users.get(i);
        accountHolder.employeeIDAccountTextInputEditText.setText(currentUser.getEmployeeID());
        accountHolder.userNameAccountTextInputEditText.setText(currentUser.getUserName());
        accountHolder.lastNameAccountTextInputEditText.setText(currentUser.getLastName());
        accountHolder.firstNameAccountTextInputEditText.setText(currentUser.getFirstName());
        accountHolder.passwordAccountTextInputEditText.setText(currentUser.getPassword());
        accountHolder.phoneNumberAccountTextInputEditText.setText(currentUser.getPhoneNumber());
        accountHolder.emailAccountTextInputEditText.setText(currentUser.getEmail());
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public void setUsers(List<User> users) {
        this.users = users;
        notifyDataSetChanged();
    }

    public User getUserAt(int position){
        return users.get(position);
    }


    class AccountHolder extends RecyclerView.ViewHolder {
        private TextInputEditText employeeIDAccountTextInputEditText;
        private TextInputEditText userNameAccountTextInputEditText;
        private TextInputEditText lastNameAccountTextInputEditText;
        private TextInputEditText firstNameAccountTextInputEditText;
        private TextInputEditText passwordAccountTextInputEditText;
        private TextInputEditText phoneNumberAccountTextInputEditText;
        private TextInputEditText emailAccountTextInputEditText;


        public int position;

        public AccountHolder(@NonNull View itemView) {
            super(itemView);
            employeeIDAccountTextInputEditText = itemView.findViewById(R.id.employeeIDAccountTextInputEditText);
            userNameAccountTextInputEditText = itemView.findViewById(R.id.userNameAccountTextInputEditText);
            lastNameAccountTextInputEditText = itemView.findViewById(R.id.lastNameAccountTextInputEditText);
            firstNameAccountTextInputEditText = itemView.findViewById(R.id.firstNameAccountTextInputEditText);
            passwordAccountTextInputEditText = itemView.findViewById(R.id.passwordAccountTextInputEditText);
            phoneNumberAccountTextInputEditText = itemView.findViewById(R.id.phoneAccountTextInputEditText);
            emailAccountTextInputEditText = itemView.findViewById(R.id.emailAccountTextInputEditText);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    position = getAdapterPosition();

                    if (listener != null && position != RecyclerView.NO_POSITION) {
                        listener.onItemClick(users.get(position));
                    }
                }
            });
        }
    }

    public interface OnItemClickListener {
        void onItemClick(User user);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    /*
    //https://stackoverflow.com/questions/4946295/android-expand-collapse-animation?page=1&tab=votes#tab-top

    public static void expand(final View v) {
        v.measure(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        final int targetHeight = v.getMeasuredHeight();

        // Older versions of android (pre API 21) cancel animations for views with a height of 0.
        v.getLayoutParams().height = 1;
        v.setVisibility(View.VISIBLE);
        Animation a = new Animation()
        {
            @Override
            protected void applyTransformation(float interpolatedTime, Transformation t) {
                v.getLayoutParams().height = interpolatedTime == 1
                        ? LinearLayout.LayoutParams.WRAP_CONTENT
                        : (int)(targetHeight * interpolatedTime);
                v.requestLayout();
            }

            @Override
            public boolean willChangeBounds() {
                return true;
            }
        };

        // 1dp/ms
        a.setDuration((int)(targetHeight / v.getContext().getResources().getDisplayMetrics().density));
        v.startAnimation(a);
    }

    public static void collapse(final View v) {
        final int initialHeight = v.getMeasuredHeight();

        Animation a = new Animation()
        {
            @Override
            protected void applyTransformation(float interpolatedTime, Transformation t) {
                if(interpolatedTime == 1){
                    v.setVisibility(View.GONE);
                }else{
                    v.getLayoutParams().height = initialHeight - (int)(initialHeight * interpolatedTime);
                    v.requestLayout();
                }
            }

            @Override
            public boolean willChangeBounds() {
                return true;
            }
        };

        // 1dp/ms
        a.setDuration((int)(initialHeight / v.getContext().getResources().getDisplayMetrics().density));
        v.startAnimation(a);
    }*/
}
/*public class AccountAdapter extends RecyclerView.Adapter <AccountAdapter.ViewHolder> {
    private List<User> mUsers;
    private final Context mContext;

    public AccountAdapter(List<User> mUsers, Context mContext) {
        this.mUsers = mUsers;
        this.mContext = mContext;
    }





    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextInputEditText employeeIDTextInputEditText, userNameTextInputEditText, lastNameTextInputEditText;
        public FloatingActionButton editFab;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            editFab = itemView.findViewById(R.id.editFab);
            employeeIDTextInputEditText = itemView.findViewById(R.id.employeeIDEditAccountTextInputEditText);
            userNameTextInputEditText = itemView.findViewById(R.id.userNameEditAccountTextInputEditText);
            lastNameTextInputEditText = itemView.findViewById(R.id.lastNameEditAccountTextInputEditText);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override public void onClick(View v) {
                    int position = getAdapterPosition();
                    Snackbar.make(v, "Click detected on item " + position, Snackbar.LENGTH_LONG).setAction("Action", null).show();
                }
            });
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.account_card, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        final User user = mUsers.get(i);

        viewHolder.employeeIDTextInputEditText.setText(user.getEmployeeID());
        viewHolder.userNameTextInputEditText.setText(user.getUserName());
        viewHolder.lastNameTextInputEditText.setText(user.getLastName());

        viewHolder.editFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, EditAccountActivity.class);
                intent.putExtra("EmployeeID", user.getEmployeeID());
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mUsers.size();
    }


}*/
