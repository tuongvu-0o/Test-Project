package com.nguyentuongvu.service;
import java.util.List;

import com.nguyentuongvu.model.Phone;

public interface PhoneService {


public void addPhone(Phone p);

public void updatePhone(Phone p);

public List<Phone> listPhones();

public Phone getPhoneById(int id);

public void removePhone(int id);


}




