package com.company.facilitymanagement.web.screens.referencevalue;

import com.haulmont.addon.bproc.web.processform.ProcessForm;
import com.haulmont.cuba.gui.components.SelectAction;
import com.haulmont.cuba.gui.screen.*;
import com.company.facilitymanagement.entity.ReferenceModel.ReferenceValue;

import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@UiController("facilitymanagement_ReferenceValue.browse")
@UiDescriptor("reference-value-browse.xml")
@LookupComponent("referenceValuesTable")
@LoadDataBeforeShow
@ProcessForm
public class ReferenceValueBrowse extends StandardLookup<ReferenceValue> {

}