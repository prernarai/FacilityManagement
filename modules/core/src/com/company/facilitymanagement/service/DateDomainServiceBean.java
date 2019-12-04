package com.company.facilitymanagement.service;

import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;

@Service(DateDomainService.NAME)
public class DateDomainServiceBean implements DateDomainService {

    @Override
    public Date getDateAfterDays(int days) {
        Date currentDate = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(currentDate);
        c.add(Calendar.DATE, days);
        currentDate = c.getTime();
        return currentDate;
    }

}