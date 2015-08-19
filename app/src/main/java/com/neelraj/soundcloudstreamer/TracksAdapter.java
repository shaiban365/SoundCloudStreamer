package com.neelraj.soundcloudstreamer;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import com.neelraj.soundcloudstreamer.soundcloud.Track;
import com.squareup.picasso.Picasso;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by Neel Raj on 18-08-2015.
 */
public class TracksAdapter  extends RecyclerView.Adapter<TracksAdapter.ViewHolder> {

    private List<Track> mTracks;
    private Context mContext;
    private AdapterView.OnItemClickListener mOnItemClickListener;

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.track_row, viewGroup, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        Track track = mTracks.get(i);
        viewHolder.titleTextView.setText(track.getTitle());
        Picasso.with(mContext).load(track.getAvatarURL()).error(R.drawable.art_default).into(viewHolder.thumbImageView);
    }

    @Override
    public int getItemCount() {
        return mTracks.size();
    }

    TracksAdapter(Context context, List<Track> tracks) {
        mContext = context;
        mTracks = tracks;
    }

    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        mOnItemClickListener = onItemClickListener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private final TextView titleTextView;
        private CircleImageView thumbImageView;


        ViewHolder(View v) {
            super(v);
            titleTextView = (TextView) v.findViewById(R.id.track_title);
            thumbImageView = (CircleImageView) v.findViewById(R.id.track_thumbnail);
            v.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if(mOnItemClickListener != null) {
                mOnItemClickListener.onItemClick(null, v, getLayoutPosition(), 0);
            }
        }
    }
}
