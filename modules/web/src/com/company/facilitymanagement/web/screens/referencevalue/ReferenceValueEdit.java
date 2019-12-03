package com.company.facilitymanagement.web.screens.referencevalue;

import com.haulmont.cuba.gui.screen.*;
import com.company.facilitymanagement.entity.ReferenceModel.ReferenceValue;

import java.util.Collection;
import java.util.HashSet;
import java.util.Map;

@UiController("facilitymanagement_ReferenceValue.edit")
@UiDescriptor("reference-value-edit.xml")
@EditedEntityContainer("referenceValueDc")
@LoadDataBeforeShow
public class ReferenceValueEdit extends StandardEditor<ReferenceValue> {

}