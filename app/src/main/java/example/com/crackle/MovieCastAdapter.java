package example.com.crackle;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

import static example.com.crackle.Constants.IMAGE_URL_SIZE;
import static example.com.crackle.Constants.LOG_TAG;
import static example.com.crackle.Utils.CAST_IMG;

public class MovieCastAdapter extends RecyclerView.Adapter<MovieCastAdapter.MovieCastViewHolder> {

    private Context context;
    private List<Cast> castList;

    public MovieCastAdapter(Context context, List<Cast> castList) {
        this.context = context;
        this.castList = castList;
    }

    @NonNull
    @Override
    public MovieCastViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MovieCastViewHolder(LayoutInflater.from(context).inflate(R.layout.fragment_cast_list_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull final MovieCastViewHolder holder, int position) {
        Cast cast = castList.get(position);
        Glide.with(context)
                .setDefaultRequestOptions(Utils.setupGlide(CAST_IMG))
                .load(IMAGE_URL_SIZE + cast.getProfileUrl())
                .into(holder.profileImage);
        holder.name.setText(cast.getName());
    }

    @Override
    public int getItemCount() {
        return castList == null ? 0 : castList.size();
    }

    class MovieCastViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.profileImage)
        CircleImageView profileImage;
        @BindView(R.id.name)
        TextView name;

        public MovieCastViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
