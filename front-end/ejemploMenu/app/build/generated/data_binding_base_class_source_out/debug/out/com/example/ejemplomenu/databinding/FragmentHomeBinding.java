// Generated by view binder compiler. Do not edit!
package com.example.ejemplomenu.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
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

public final class FragmentHomeBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final ImageButton buttonBeer;

  @NonNull
  public final ImageButton buttonLiqueur;

  @NonNull
  public final ImageButton buttonSoda;

  @NonNull
  public final ImageButton buttonWater;

  @NonNull
  public final TextView textView2;

  @NonNull
  public final TextView textView3;

  @NonNull
  public final TextView textView4;

  @NonNull
  public final TextView textView5;

  private FragmentHomeBinding(@NonNull ConstraintLayout rootView, @NonNull ImageButton buttonBeer,
      @NonNull ImageButton buttonLiqueur, @NonNull ImageButton buttonSoda,
      @NonNull ImageButton buttonWater, @NonNull TextView textView2, @NonNull TextView textView3,
      @NonNull TextView textView4, @NonNull TextView textView5) {
    this.rootView = rootView;
    this.buttonBeer = buttonBeer;
    this.buttonLiqueur = buttonLiqueur;
    this.buttonSoda = buttonSoda;
    this.buttonWater = buttonWater;
    this.textView2 = textView2;
    this.textView3 = textView3;
    this.textView4 = textView4;
    this.textView5 = textView5;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentHomeBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentHomeBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_home, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentHomeBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.button_beer;
      ImageButton buttonBeer = ViewBindings.findChildViewById(rootView, id);
      if (buttonBeer == null) {
        break missingId;
      }

      id = R.id.button_liqueur;
      ImageButton buttonLiqueur = ViewBindings.findChildViewById(rootView, id);
      if (buttonLiqueur == null) {
        break missingId;
      }

      id = R.id.button_soda;
      ImageButton buttonSoda = ViewBindings.findChildViewById(rootView, id);
      if (buttonSoda == null) {
        break missingId;
      }

      id = R.id.button_water;
      ImageButton buttonWater = ViewBindings.findChildViewById(rootView, id);
      if (buttonWater == null) {
        break missingId;
      }

      id = R.id.textView2;
      TextView textView2 = ViewBindings.findChildViewById(rootView, id);
      if (textView2 == null) {
        break missingId;
      }

      id = R.id.textView3;
      TextView textView3 = ViewBindings.findChildViewById(rootView, id);
      if (textView3 == null) {
        break missingId;
      }

      id = R.id.textView4;
      TextView textView4 = ViewBindings.findChildViewById(rootView, id);
      if (textView4 == null) {
        break missingId;
      }

      id = R.id.textView5;
      TextView textView5 = ViewBindings.findChildViewById(rootView, id);
      if (textView5 == null) {
        break missingId;
      }

      return new FragmentHomeBinding((ConstraintLayout) rootView, buttonBeer, buttonLiqueur,
          buttonSoda, buttonWater, textView2, textView3, textView4, textView5);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
