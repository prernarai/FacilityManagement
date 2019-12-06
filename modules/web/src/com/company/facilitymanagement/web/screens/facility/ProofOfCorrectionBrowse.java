package com.company.facilitymanagement.web.screens.facility;

import com.haulmont.cuba.gui.screen.*;
import com.company.facilitymanagement.entity.FacilityManagement.ProofOfCorrection;

@UiController("facilitymanagement_ProofOfCorrection.browse")
@UiDescriptor("proof-of-correction-browse.xml")
@LookupComponent("proofOfCorrectionsTable")
@LoadDataBeforeShow
public class ProofOfCorrectionBrowse extends StandardLookup<ProofOfCorrection> {
}