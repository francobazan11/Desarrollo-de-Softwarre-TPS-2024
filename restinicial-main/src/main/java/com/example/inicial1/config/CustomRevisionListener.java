package com.example.inicial1.config;

import com.example.inicial1.entities.Persona;
import org.hibernate.envers.RevisionListener;
import org.springframework.data.history.Revision;

public class CustomRevisionListener implements RevisionListener {
    public void newRevision(Object revisionEntity) {final Revision revision = (Revision) revisionEntity;
    }
}
