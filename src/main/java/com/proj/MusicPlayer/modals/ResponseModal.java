package com.proj.MusicPlayer.modals;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

public class ResponseModal {
    private Boolean status;
    private String message;
    private List<Object> objects;

    public ResponseModal(Boolean status, String message, List<Object> objects) {
        this.status = status;
        this.message = message;
        this.objects = objects;
    }


}
