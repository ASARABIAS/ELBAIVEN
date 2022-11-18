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

public final class FragmentLiqueurBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final Button buttonFragmentHome;

  @NonNull
  public final View divider0;

  @NonNull
  public final View divider1;

  @NonNull
  public final ImageView imageAguardiente;

  @NonNull
  public final ImageView imageRon;

  @NonNull
  public final TextView textAguardiente;

  @NonNull
  public final TextView textRon;

  private FragmentLiqueurBinding(@NonNull ConstraintLayout rootView,
      @NonNull Button buttonFragmentHome, @NonNull View divider0, @NonNull View divider1,
      @NonNull ImageView imageAguardiente, @NonNull ImageView imageRon,
      @NonNull TextView textAguardiente, @NonNull TextView textRon) {
    this.rootView = rootView;
    this.buttonFragmentHome = buttonFragmentHome;
    this.divider0 = divider0;
    this.divider1 = divider1;
    this.imageAguardiente = imageAguardiente;
    this.imageRon = imageRon;
    this.textAguardiente = textAguardiente;
    this.textRon = textRon;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentLiqueurBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentLiqueurBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_liqueur, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentLiqueurBinding bind(@NonNull View rootView) {
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

      id = R.id.image_aguardiente;
      ImageView imageAguardiente = ViewBindings.findChildViewById(rootView, id);
      if (imageAguardiente == null) {
        break missingId;
      }

      id = R.id.image_ron;
      ImageView imageRon = ViewBindings.findChildViewById(rootView, id);
      if (imageRon == null) {
        break missingId;
      }

      id = R.id.text_aguardiente;
      TextView textAguardiente = ViewBindings.findChildViewById(rootView, id);
      if (textAguardiente == null) {
        break missingId;
      }

      id = R.id.text_ron;
      TextView textRon = ViewBindings.findChildViewById(rootView, id);
      if (textRon == null) {
        break missingId;
      }

      return new FragmentLiqueurBinding((ConstraintLayout) rootView, buttonFragmentHome, divider0,
          divider1, imageAguardiente, imageRon, textAguardiente, textRon);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}