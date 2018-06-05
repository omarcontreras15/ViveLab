package co.edu.ufps.vivelab;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import java.util.ArrayList;

public class RecyclerViewAdapterFacebook extends RecyclerView.Adapter<RecyclerViewAdapterFacebook.ViewHolder>{
    private ArrayList<String> publicaciones;

    public RecyclerViewAdapterFacebook() {
        this.publicaciones = new ArrayList<>();
    }

    @Override
    public RecyclerViewAdapterFacebook.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_facebook,parent,false);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerViewAdapterFacebook.ViewHolder holder, int position) {
        WebSettings config= holder.web.getSettings();
        config.setJavaScriptEnabled(true);
        config.setUseWideViewPort(false);
        holder.web.loadUrl(this.publicaciones.get(position));
        holder.web.setWebViewClient(new WebViewClient(){
            //previene que se redireccione a otra pagina al dar click en cualquier link
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                if (url.equals(view.getUrl())) {
                    view.loadUrl(url);
                }
                return true;
            }
        });
    }

    @Override
    public int getItemCount() {
        return this.publicaciones.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private WebView web;
        public ViewHolder(View itemView) {
            super(itemView);
            this.web=(WebView)itemView.findViewById(R.id.web_view_facebook);

        }
    }

    public ArrayList<String> getPublicaciones() {
        return publicaciones;
    }

    public void agregarPublicacion(String id){
        this.publicaciones.add("https://www.facebook.com/plugins/post.php?href=https%3A%2F%2Fwww.facebook.com%2Fpvdlabcucuta%2Fposts%" +
                id+"higth=100%");
    }
}
