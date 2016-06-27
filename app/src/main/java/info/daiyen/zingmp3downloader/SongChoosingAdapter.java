package info.daiyen.zingmp3downloader;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import info.daiyen.zingmp3downloader.model.ZingMp3Song;

/**
 * Created by corncob on 6/26/16.
 */
public class SongChoosingAdapter extends RecyclerView.Adapter<SongChoosingAdapter.SongViewHolder> {

    public interface OnItemClick {
        void onClick(int position);
    }

    private ArrayList<ZingMp3Song> mDataset;

    OnItemClick onItemClick;

    private Context context;


    public SongChoosingAdapter(ArrayList<ZingMp3Song> mDataset, Context context, OnItemClick onItemClick) {
        this.mDataset = mDataset;
        this.onItemClick = onItemClick;
        this.context = context;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public SongViewHolder onCreateViewHolder(ViewGroup parent,
                                             int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.song_choosing_item, parent, false);
        // set the view's size, margins, paddings and layout parameters

        SongViewHolder vh = new SongViewHolder(v);

        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(SongViewHolder holder, final int position) {

        final ZingMp3Song song = mDataset.get(position);

        holder.txtSongTitle.setText(song.getTitle());
        holder.txtSongArtist.setText(song.getArtist());
        Picasso.with(this.context)
                .load("http://image.mp3.zdn.vn/" + song.getThumbnail())
                .resize(250, 250)
                .centerCrop()
                .placeholder(R.drawable.zingmp3_cover)
                .into(holder.imgSongCover);

        holder.checkBox.setChecked(song.getChosen());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClick.onClick(position);
            }
        });

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        if (mDataset == null) {
            return 0;
        } else {
            return mDataset.size();
        }

    }

    public static class SongViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public CheckBox checkBox;
        public TextView txtSongTitle;
        public TextView txtSongArtist;
        public ImageView imgSongCover;

        public SongViewHolder(View v) {
            super(v);
            checkBox = (CheckBox) v.findViewById(R.id.checkbox);
            txtSongTitle = (TextView) v.findViewById(R.id.txtSongTitle);
            txtSongArtist = (TextView) v.findViewById(R.id.txtSongArtist);
            imgSongCover = (ImageView) v.findViewById(R.id.imgSongCover);
            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
        }
    }
}