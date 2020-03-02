package com.olabode.wilson.dagger.ui.main.posts;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.olabode.wilson.dagger.R;
import com.olabode.wilson.dagger.models.Post;
import com.olabode.wilson.dagger.ui.main.Resource;
import com.olabode.wilson.dagger.util.VerticalSpacingItemDecoration;
import com.olabode.wilson.dagger.viewmodels.ViewModelProviderFactory;

import java.util.List;

import javax.inject.Inject;

import dagger.android.support.DaggerFragment;

/**
 * Created by OLABODE WILSON on 2020-02-21.
 */
public class PostsFragment extends DaggerFragment {
    private static final String TAG = "PostsFragment";
    @Inject
    PostsRecyclerAdapter adapter;
    @Inject
    ViewModelProviderFactory providerFactory;
    private PostViewModel postViewModel;
    private RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_posts, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        recyclerView = view.findViewById(R.id.recycler_view);

        postViewModel = ViewModelProviders.of(this, providerFactory)
                .get(PostViewModel.class);

        initRecyclerView();
        subscribeObservers();
    }

    private void subscribeObservers() {
        postViewModel.observePosts().removeObservers(getViewLifecycleOwner());
        postViewModel.observePosts().observe(getViewLifecycleOwner(), new Observer<Resource<List<Post>>>() {
            @Override
            public void onChanged(Resource<List<Post>> listResource) {
                if (listResource != null) {
                    switch (listResource.status) {
                        case LOADING: {
                            break;
                        }
                        case SUCCESS: {
                            adapter.setPosts(listResource.data);
                            break;
                        }

                        case ERROR: {
                            break;
                        }
                    }
                }

            }
        });
    }


    private void initRecyclerView() {
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        VerticalSpacingItemDecoration itemDecoration = new VerticalSpacingItemDecoration(15);
        recyclerView.addItemDecoration(itemDecoration);
        recyclerView.setAdapter(adapter);
    }
}
