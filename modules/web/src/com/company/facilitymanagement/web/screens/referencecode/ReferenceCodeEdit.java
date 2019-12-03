package com.company.facilitymanagement.web.screens.referencecode;

import com.haulmont.cuba.gui.screen.*;
import com.company.facilitymanagement.entity.ReferenceModel.ReferenceCode;

@UiController("facilitymanagement_ReferenceCode.edit")
@UiDescriptor("reference-code-edit.xml")
@EditedEntityContainer("referenceCodeDc")
@LoadDataBeforeShow
public class ReferenceCodeEdit extends StandardEditor<ReferenceCode> {
}