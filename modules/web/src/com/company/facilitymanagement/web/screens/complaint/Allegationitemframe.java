package com.company.facilitymanagement.web.screens.complaint;

import com.company.facilitymanagement.entity.ComplaintModel.Allegation;
import com.haulmont.cuba.gui.components.AbstractFrame;
import com.haulmont.cuba.gui.data.Datasource;

import javax.inject.Inject;


public class Allegationitemframe extends AbstractFrame {
    @Inject
    protected Datasource<Allegation> allegationDs;
    public void setAllegationData(Allegation incomingAllegation)
    {
    allegationDs.setItem(incomingAllegation);
    }
}