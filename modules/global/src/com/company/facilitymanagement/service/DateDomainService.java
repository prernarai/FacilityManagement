package com.company.facilitymanagement.service;

import java.util.Date;

public interface DateDomainService {
    String NAME = "facilitymanagement_DateDomainService";

    Date getDateAfterDays(int days);
}