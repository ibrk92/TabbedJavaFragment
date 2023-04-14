package com.example.tabbedjavafragment.ui.main;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.example.tabbedjavafragment.R;


public class FirstFragment extends Fragment {
    PageViewModel pageViewModel;

    public static FirstFragment newInstance() {

        return new FirstFragment();

    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //pageViewModel initialize etmemiz gerekiyor,
        // Eger bir fragment icersinde sinifa refarans vermek istediginde this veya getApplicationContext() diyerek yapamiyoruz,
        // Ornegin bunu bir toast mesajinda context istendiginde ne yapmamiz gerektigini gosterelim;

        Toast.makeText(getActivity().getApplicationContext(), "Merhaba", Toast.LENGTH_LONG).show();

        // Bu nedenle fragmentler icinde context'e ihtiyac duyarsan getActivity().getApplicationContext() demen gerekiyor


        pageViewModel = new ViewModelProvider(requireActivity()).get(PageViewModel.class);


    }

    @Nullable
    @Override
    // OnCreateView ile ilk fragmentimizin layoutunu baglayalim.

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_first, container, false);



    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        // Basic Fragment ornegimizde bu sinifin yerine onCreateView icerisinde viewGroup'umuzu olusturmustuk  cunku view'lerimize findviewbyid ile ulasmanin yolu oydu.
        //Ancak bunu yapmak yerine onViewCreated sinifi olusturarak da yapabilirsin !!
        super.onViewCreated(view, savedInstanceState);
        // onViewCreated sinifinin icerisinde gorunumler cagirilabilir !!!
        EditText editText = view.findViewById(R.id.editText);

        //Bu uygulamadaki amac editText'e veriyi girince ikinci fragmentte aninda gostermek
          // Bu nedenle Text Degisince ne olsun diye change listenerimizi yaziyoruz !!


        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                // text degismeden once

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                //text degistigi gibi

                // bu teti viewmodelimiza kayit edecegiz !!

                pageViewModel.setName(charSequence.toString()); // Bu veriyi alacak ve PageViewModel'a kayit edecek!!
            }

            @Override
            public void afterTextChanged(Editable editable) {

                // text degistikten sonra ne olsun

            }
        });


    }
}