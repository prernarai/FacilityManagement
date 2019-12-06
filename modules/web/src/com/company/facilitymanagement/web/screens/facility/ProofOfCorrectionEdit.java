package com.company.facilitymanagement.web.screens.facility;

import com.haulmont.cuba.gui.screen.*;
import com.company.facilitymanagement.entity.FacilityManagement.ProofOfCorrection;

@UiController("facilitymanagement_ProofOfCorrection.edit")
@UiDescriptor("proof-of-correction-edit.xml")
@EditedEntityContainer("proofOfCorrectionDc")
@LoadDataBeforeShow
public class ProofOfCorrectionEdit extends StandardEditor<ProofOfCorrection> {
}