package com.company.facilitymanagement.web.screens.referencecode;

import com.haulmont.cuba.gui.screen.*;
import com.company.facilitymanagement.entity.ReferenceModel.ReferenceCode;

@UiController("facilitymanagement_ReferenceCode.browse")
@UiDescriptor("reference-code-browse.xml")
@LookupComponent("referenceCodesTable")
@LoadDataBeforeShow
public class ReferenceCodeBrowse extends StandardLookup<ReferenceCode> {
}