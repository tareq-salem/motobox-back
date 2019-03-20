package com.hoc.motobox.listener;

import javax.persistence.PrePersist;

public class UpdateEventListener {
    @PrePersist
    public void preSave()
    {
        System.out.print("Louud && pride");
    }
}
