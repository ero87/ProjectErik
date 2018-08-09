package com.example.ero.mytask1;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class UserAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private List<UserModel> userList;

    public UserAdapter(Context context, List<UserModel> userList) {
        this.context = context;
        this.userList = userList;
    }

    @Override
    public int getItemViewType(int position) {
        final UserModel model = userList.get(position);
        if (model.isFemail()) {
            return 0;
        }
        return 1;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view;
        if (0 == viewType) {
            view = inflater.inflate(R.layout.gilr_item, parent, false);
            return new GirlViewHolder(view);
        }
        view = inflater.inflate(R.layout.boy_item, parent, false);
        return new BoyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        final UserModel model = userList.get(position);
        if (model.isFemail()) {
            ((GirlViewHolder) holder).bind(model);
        } else {
            ((BoyViewHolder) holder).bind(model);
        }
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    private void getNewActivity(View itemView) {
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, InfoActivity.class);
                context.startActivity(intent);
            }
        });
    }

    class GirlViewHolder extends RecyclerView.ViewHolder {

        private final ImageButton phone;
        private final CircleImageView imageGirl;
        TextView titlegirl;

        GirlViewHolder(View itemView) {
            super(itemView);
            titlegirl = itemView.findViewById(R.id.name_girl);
            phone = itemView.findViewById(R.id.phone);
            imageGirl = itemView.findViewById(R.id.image_girl);
            getNewActivity(itemView);
        }

        void bind(final UserModel model) {
            titlegirl.setText(model.getTitle());
            Picasso.get().load(model.getImageUrl()).into(imageGirl);
            phone.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Intent.ACTION_DIAL);
                    intent.setData(Uri.parse("tel:" + model.getPhone()));
                    context.startActivity(intent);
                }
            });
        }
    }

    class BoyViewHolder extends RecyclerView.ViewHolder {

        TextView titleboy;
        CircleImageView imageBoy;
        ImageButton email;

        BoyViewHolder(View itemView) {
            super(itemView);
            titleboy = itemView.findViewById(R.id.name_boy);
            imageBoy = itemView.findViewById(R.id.image_boy);
            email = itemView.findViewById(R.id.email);
            getNewActivity(itemView);
        }

        void bind(final UserModel model) {
            titleboy.setText(model.getTitle());
            Picasso.get().load(model.getImageUrl()).into(imageBoy);
            email.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Intent.ACTION_SENDTO);
                    intent.setData(Uri.parse("mailto:" + model.getEmail()));
                    context.startActivity(intent);
                }
            });

        }
    }
}
