package com.example.tabbedjavafragment.ui.main;

import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

public class PageViewModel extends ViewModel {

    // verileri canli olarak saklamamizi sagliyor
    // LiveData fragmentler ile cok hizli bir sekilde iletisim kurabiliyor demek !, fragmentler arasi veri aktarimi yapmani sagliyor!!
    // private dedik cunku zaten bu sinif icerisinde kullanacagiz!!

    private MutableLiveData<String> nameInput =  new MutableLiveData<>();


    public void setName(String name){

        nameInput.setValue(name);

    }

    public LiveData<String> getName() {
        return nameInput;

    }


}