// Generated by view binder compiler. Do not edit!
package com.example.ejemplomenu.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.ejemplomenu.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentSodaBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final Button buttonFragmentHome;

  @NonNull
  public final View divider0;

  @NonNull
  public final View divider1;

  @NonNull
  public final ImageView imageSodaBrandA;

  @NonNull
  public final ImageView imageSodaBrandB;

  @NonNull
  public final TextView textSodaBrandA;

  @NonNull
  public final TextView textSodaBrandB;

  private FragmentSodaBinding(@NonNull ConstraintLayout rootView,
      @NonNull Button buttonFragmentHome, @NonNull View divider0, @NonNull View divider1,
      @NonNull ImageView imageSodaBrandA, @NonNull ImageView imageSodaBrandB,
      @NonNull TextView textSodaBrandA, @NonNull TextView textSodaBrandB) {
    this.rootView = rootView;
    this.buttonFragmentHome = buttonFragmentHome;
    this.divider0 = divider0;
    this.divider1 = divider1;
    this.imageSodaBrandA = imageSodaBrandA;
    this.imageSodaBrandB = imageSodaBrandB;
    this.textSodaBrandA = textSodaBrandA;
    this.textSodaBrandB = textSodaBrandB;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentSodaBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentSodaBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_soda, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentSodaBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.button_fragment_home;
      Button buttonFragmentHome = ViewBindings.findChildViewById(rootView, id);
      if (buttonFragmentHome == null) {
        break missingId;
      }

      id = R.id.divider_0;
      View divider0 = ViewBindings.findChildViewById(rootView, id);
      if (divider0 == null) {
        break missingId;
      }

      id = R.id.divider_1;
      View divider1 = ViewBindings.findChildViewById(rootView, id);
      if (divider1 == null) {
        break missingId;
      }

      id = R.id.image_soda_brand_a;
      ImageView imageSodaBrandA = ViewBindings.findChildViewById(rootView, id);
      if (imageSodaBrandA == null) {
        break missingId;
      }

      id = R.id.image_soda_brand_b;
      ImageView imageSodaBrandB = ViewBindings.findChildViewById(rootView, id);
      if (imageSodaBrandB == null) {
        break missingId;
      }

      id = R.id.text_soda_brand_a;
      TextView textSodaBrandA = ViewBindings.findChildViewById(rootView, id);
      if (textSodaBrandA == null) {
        break missingId;
      }

      id = R.id.text_soda_brand_b;
      TextView textSodaBrandB = ViewBindings.findChildViewById(rootView, id);
      if (textSodaBrandB == null) {
        break missingId;
      }

      return new FragmentSodaBinding((ConstraintLayout) rootView, buttonFragmentHome, divider0,
          divider1, imageSodaBrandA, imageSodaBrandB, textSodaBrandA, textSodaBrandB);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}